/*-
 * See the file LICENSE for redistribution information.
 *
 * Copyright (c) 2002-2010 Oracle.  All rights reserved.
 *
 */

package com.sleepycat.persist.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sleepycat.bind.tuple.IntegerBinding;
import com.sleepycat.compat.DbCompat;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.OperationStatus;
import com.sleepycat.je.Transaction;
import com.sleepycat.je.utilint.IdentityHashMap;
/* <!-- begin JE only --> */
import com.sleepycat.je.rep.ReplicaWriteException;
/* <!-- end JE only --> */
import com.sleepycat.persist.DatabaseNamer;
import com.sleepycat.persist.StoreExistsException;
import com.sleepycat.persist.StoreNotFoundException;
import com.sleepycat.persist.evolve.Converter;
import com.sleepycat.persist.evolve.IncompatibleClassException;
import com.sleepycat.persist.evolve.Mutations;
import com.sleepycat.persist.evolve.Renamer;
import com.sleepycat.persist.model.AnnotationModel;
import com.sleepycat.persist.model.ClassMetadata;
import com.sleepycat.persist.model.EntityMetadata;
import com.sleepycat.persist.model.EntityModel;
import com.sleepycat.persist.model.ModelInternal;
import com.sleepycat.persist.raw.RawObject;
import com.sleepycat.persist.raw.RawType;
import com.sleepycat.util.RuntimeExceptionWrapper;

/**
 * The catalog of class formats for a store, along with its associated model
 * and mutations.
 *
 * @author Mark Hayes
 */
public class PersistCatalog implements Catalog {

    /**
     * Key to Data record in the catalog database.  In the JE 3.0.12 beta
     * version the formatList record is stored under this key and is converted
     * to a Data object when it is read.
     */
    private static final byte[] DATA_KEY = getIntBytes(-1);

    /**
     * Key to a JE 3.0.12 beta version mutations record in the catalog
     * database.  This record is no longer used because mutations are stored in
     * the Data record and is deleted when the beta version is detected.
     */
    private static final byte[] BETA_MUTATIONS_KEY = getIntBytes(-2);

    private static byte[] getIntBytes(int val) {
        DatabaseEntry entry = new DatabaseEntry();
        IntegerBinding.intToEntry(val, entry);
        assert entry.getSize() == 4 && entry.getData().length == 4;
        return entry.getData();
    }

    /**
     * Used by unit tests.
     */
    public static boolean expectNoClassChanges;
    public static boolean unevolvedFormatsEncountered;

    /**
     * The object stored under DATA_KEY in the catalog database.
     */
    private static class Data implements Serializable {

        static final long serialVersionUID = 7515058069137413261L;

        List<Format> formatList;
        Mutations mutations;
        int version;
    }

    /**
     * A list of all formats indexed by formatId.  Element zero is unused and
     * null, since IDs start at one; this avoids adjusting the ID to index the
     * list.  Some elements are null to account for predefined IDs that are not
     * used.
     *
     * <p>This field, like formatMap, is volatile because it is reassigned
     * when dynamically adding new formats.  See {@link addNewFormat}.</p>
     */
    private volatile List<Format> formatList;

    /**
     * A map of the current/live formats in formatList, indexed by class name.
     *
     * <p>This field, like formatList, is volatile because it is reassigned
     * when dynamically adding new formats.  See {@link addNewFormat}.</p>
     */
    private volatile Map<String, Format> formatMap;

    /**
     * A map of the latest formats (includes deleted formats) in formatList,
     * indexed by class name.
     *
     * <p>This field, like formatMap, is volatile because it is reassigned
     * when dynamically adding new formats.  See {@link addNewFormat}.</p>
     */
    private volatile Map<String, Format> latestFormatMap;

    /**
     * A temporary map of proxied class name to proxy class name.  Used during
     * catalog creation, and then set to null.  This map is used to force proxy
     * formats to be created prior to proxied formats. [#14665]
     */
    private Map<String, String> proxyClassMap;

    private final boolean rawAccess;
    private EntityModel model;
    private StoredModel storedModel;
    private Mutations mutations;
    private final Database db;
    private int openCount;
    private boolean readOnly;

    /**
     * If a Replica is upgraded, local in-memory evolution may take place prior
     * to the Master being upgraded.  In that case, the size of the formatList
     * will be greater than nStoredFormats.  In this case, the readOnly
     * state field will be set to true.  We must be sure not to write the
     * metadata in this state.  [#16655]
     */
    private volatile int nStoredFormats;

    /**
     * The Store is normally present but may be null in unit tests (for
     * example, BindingTest).
     */
    private final Store store;

    /**
     * The Evolver and catalog Data are non-null during catalog initialization,
     * and null otherwise.
     */
    private Evolver evolver;
    private Data catalogData;

    /**
     * Creates a new catalog, opening the database and reading it from a given
     * catalog database if it already exists.  All predefined formats and
     * formats for the given model are added.  For modified classes, old
     * formats are defined based on the rules for compatible class changes and
     * the given mutations.  If any format is changed or added, and the
     * database is not read-only, write the initialized catalog to the
     * database.
     */
    public PersistCatalog(final Transaction txn,
                          final Environment env,
                          final String storePrefix,
                          final String dbName,
                          final DatabaseConfig dbConfig,
                          final EntityModel modelParam,
                          final Mutations mutationsParam,
                          final boolean rawAccess,
                          final Store store)
        throws StoreExistsException,
               StoreNotFoundException,
               IncompatibleClassException,
               DatabaseException {

        this.rawAccess = rawAccess;
        this.store = store;
        /* store may be null for testing. */
        String[] fileAndDbNames = (store != null) ?
            store.parseDbName(dbName) :
            Store.parseDbName(dbName, DatabaseNamer.DEFAULT);

        /*
         * Use a null (auto-commit) transaction for opening the database, so
         * that the database is opened even if a ReplicaWriteException occurs
         * when attempting to evolve the metadata.  We will close the database
         * if another exception occurs in the finally statement below.
         */
        db = DbCompat.openDatabase(env, null /*txn*/, fileAndDbNames[0],
                                   fileAndDbNames[1], dbConfig);
        if (db == null) {
            String dbNameMsg = store.getDbNameMessage(fileAndDbNames);
            if (dbConfig.getExclusiveCreate()) {
                throw new StoreExistsException
                    ("Catalog DB already exists and ExclusiveCreate=true, " +
                     dbNameMsg);
            } else {
                assert !dbConfig.getAllowCreate();
                throw new StoreNotFoundException
                    ("Catalog DB does not exist and AllowCreate=false, " +
                     dbNameMsg);
            }
        }
        openCount = 1;
        boolean success = false;
        try {
            init(txn, storePrefix, modelParam, mutationsParam);
            success = true;
        } finally {
            if (!success) {
                close();
            }
        }
    }

    /**
     * Creates a new catalog when a Replica refresh occurs.  Uses some
     * information from the old catalog directly in the new catalog, but all
     * formats are created from scratch and class evolution is attempted.
     */
    PersistCatalog(final Transaction txn,
                   final PersistCatalog oldCatalog,
                   final String storePrefix)
        throws DatabaseException {

        db = oldCatalog.db;
        store = oldCatalog.store;
        rawAccess = oldCatalog.rawAccess;
        openCount = oldCatalog.openCount;

        init(txn, storePrefix, oldCatalog.model, oldCatalog.mutations);
    }

    private void init(final Transaction txn,
                      final String storePrefix,
                      final EntityModel modelParam,
                      final Mutations mutationsParam)
        throws DatabaseException {

        try {
            catalogData = readData(txn);
            mutations = catalogData.mutations;
            if (mutations == null) {
                mutations = new Mutations();
            }

            /*
             * When the beta version is detected, force a re-write of the
             * catalog and disallow class changes.  This brings the catalog up
             * to date so that evolution can proceed correctly from then on.
             */
            boolean betaVersion = (catalogData.version == BETA_VERSION);
            boolean needWrite = betaVersion;
            boolean disallowClassChanges = betaVersion;

            /*
             * Store the given mutations if they are different from the stored
             * mutations, and force evolution to apply the new mutations.
             */
            boolean forceEvolution = false;
            if (mutationsParam != null &&
                !mutations.equals(mutationsParam)) {
                mutations = mutationsParam;
                needWrite = true;
                forceEvolution = true;
            }

            /* Get the existing format list, or copy it from SimpleCatalog. */
            formatList = catalogData.formatList;
            if (formatList == null) {
                formatList = SimpleCatalog.copyFormatList();

                /*
                 * Special cases: Object and Number are predefined but are not
                 * simple types.
                 */
                Format format = new NonPersistentFormat(Object.class);
                format.setId(Format.ID_OBJECT);
                formatList.set(Format.ID_OBJECT, format);
                format = new NonPersistentFormat(Number.class);
                format.setId(Format.ID_NUMBER);
                formatList.set(Format.ID_NUMBER, format);
            } else {
                if (SimpleCatalog.copyMissingFormats(formatList)) {
                    needWrite = true;
                }
                nStoredFormats = formatList.size();
            }

            /* Special handling for JE 3.0.12 beta formats. */
            if (betaVersion) {
                Map<String, Format> formatMap = new HashMap<String, Format>();
                for (Format format : formatList) {
                    if (format != null) {
                        formatMap.put(format.getClassName(), format);
                    }
                }
                for (Format format : formatList) {
                    if (format != null) {
                        format.migrateFromBeta(formatMap);
                    }
                }
            }

            /*
             * If we should not use the current model, initialize the stored
             * model and return.
             */
            formatMap = new HashMap<String, Format>(formatList.size());
            latestFormatMap = new HashMap<String, Format>(formatList.size());
            if (rawAccess) {
                for (Format format : formatList) {
                    if (format != null) {
                        String name = format.getClassName();
                        if (format.isCurrentVersion()) {
                            formatMap.put(name, format);
                        }
                        if (format == format.getLatestVersion()) {
                            latestFormatMap.put(name, format);
                        }
                    }
                }
                if (modelParam != null) {
                    model = modelParam;
                    storedModel = (StoredModel) modelParam;
                } else {
                    storedModel = new StoredModel(this);
                    model = storedModel;
                }
                for (Format format : formatList) {
                    if (format != null) {
                        format.initializeIfNeeded(this, model);
                    }
                }
                initModelAndMutations();
                return;
            }

            /*
             * We are opening a store that uses the current model. Default to
             * the AnnotationModel if no model is specified.
             */
            if (modelParam != null) {
                model = modelParam;
            } else {
                model = new AnnotationModel();
            }
            storedModel = null;

            /*
             * Add all predefined (simple) formats to the format map.  The
             * current version of other formats will be added below.
             */
            for (int i = 0; i <= Format.ID_PREDEFINED; i += 1) {
                Format simpleFormat = formatList.get(i);
                if (simpleFormat != null) {
                    formatMap.put(simpleFormat.getClassName(), simpleFormat);
                }
            }

            /*
             * Known classes are those explicitly registered by the user via
             * the model, plus the predefined proxy classes.
             */
            List<String> knownClasses =
                new ArrayList<String>(model.getKnownClasses());
            addPredefinedProxies(knownClasses);

            /*
             * Create a temporary map of proxied class name to proxy class
             * name, using all known formats and classes.  This map is used to
             * force proxy formats to be created prior to proxied formats.
             * [#14665]
             */
            proxyClassMap = new HashMap<String, String>();
            for (Format oldFormat : formatList) {
                if (oldFormat == null || Format.isPredefined(oldFormat)) {
                    continue;
                }
                String oldName = oldFormat.getClassName();
                Renamer renamer = mutations.getRenamer
                    (oldName, oldFormat.getVersion(), null);
                String newName =
                    (renamer != null) ? renamer.getNewName() : oldName;
                addProxiedClass(newName);
            }
            for (String className : knownClasses) {
                addProxiedClass(className);
            }

            /*
             * Add known formats from the model and the predefined proxies.
             * In general, classes will not be present in an AnnotationModel
             * until an instance is stored, in which case an old format exists.
             * However, registered proxy classes are an exception and must be
             * added in advance.  And the user may choose to register new
             * classes in advance.  The more formats we define in advance, the
             * less times we have to write to the catalog database.
             */
            Map<String, Format> newFormats = new HashMap<String, Format>();
            for (String className : knownClasses) {
                createFormat(className, newFormats);
            }

            /*
             * Perform class evolution for all old formats, and throw an
             * exception that contains the messages for all of the errors in
             * mutations or in the definition of new classes.
             */
            evolver = new Evolver
                (this, storePrefix, mutations, newFormats, forceEvolution,
                 disallowClassChanges);
            for (Format oldFormat : formatList) {
                if (oldFormat == null || Format.isPredefined(oldFormat)) {
                    continue;
                }
                if (oldFormat.isEntity()) {
                    evolver.evolveFormat(oldFormat);
                } else {
                    evolver.addNonEntityFormat(oldFormat);
                }
            }
            evolver.finishEvolution();
            String errors = evolver.getErrors();
            if (errors != null) {
                throw new IncompatibleClassException(errors);
            }

            /*
             * Add the new formats remaining.  New formats that are equal to
             * old formats were removed from the newFormats map above.
             */
            for (Format newFormat : newFormats.values()) {
                addFormat(newFormat);
            }

            /* Initialize all formats. */
            for (Format format : formatList) {
                if (format != null) {
                    format.initializeIfNeeded(this, model);
                    if (format == format.getLatestVersion()) {
                        latestFormatMap.put(format.getClassName(), format);
                    }
                }
            }

            final boolean formatsChanged =
                 newFormats.size() > 0 ||
                 evolver.areFormatsChanged();
            needWrite |= formatsChanged;

            /* For unit testing. */
            if (expectNoClassChanges && formatsChanged) {
                throw new IllegalStateException
                    ("Unexpected changes " +
                     " newFormats.size=" + newFormats.size() +
                     " areFormatsChanged=" + evolver.areFormatsChanged());
            }

            readOnly = db.getConfig().getReadOnly();

            /* Write the catalog if anything changed. */
            if (needWrite && !readOnly) {

                /* <!-- begin JE only --> */
                try {
                /* <!-- end JE only --> */

                    /*
                     * Only rename/remove databases if we are going to update
                     * the catalog to reflect those class changes.
                     */
                    evolver.renameAndRemoveDatabases(store, txn);

                    /*
                     * Note that we use the Data object that was read above, and
                     * the beta version determines whether to delete the old
                     * mutations record.
                     */
                    catalogData.formatList = formatList;
                    catalogData.mutations = mutations;
                    writeData(txn, catalogData);
                /* <!-- begin JE only --> */
                } catch (ReplicaWriteException e) {
                    readOnly = true;
                }
                /* <!-- end JE only --> */
            }
            initModelAndMutations();
        } finally {

            /*
             * Fields needed only for the duration of this ctor and which
             * should be null afterwards.
             */
            proxyClassMap = null;
            catalogData = null;
            evolver = null;
        }
    }

    private void initModelAndMutations() {

        /*
         * Give the model a reference to the catalog to fully initialize
         * the model.  Only then may we initialize the Converter mutations,
         * which themselves may call model methods and expect the model to
         * be fully initialized.
         */
        ModelInternal.setCatalog(model, this);
        for (Converter converter : mutations.getConverters()) {
            converter.getConversion().initialize(model);
        }
    }

    public void getEntityFormats(Collection<Format> entityFormats) {
        for (Format format : formatMap.values()) {
            if (format.isEntity()) {
                entityFormats.add(format);
            }
        }
    }

    private void addProxiedClass(String className) {
        ClassMetadata metadata = model.getClassMetadata(className);
        if (metadata != null) {
            String proxiedClassName = metadata.getProxiedClassName();
            if (proxiedClassName != null) {
                proxyClassMap.put(proxiedClassName, className);
            }
        }
    }

    private void addPredefinedProxies(List<String> knownClasses) {
        knownClasses.add(CollectionProxy.ArrayListProxy.class.getName());
        knownClasses.add(CollectionProxy.LinkedListProxy.class.getName());
        knownClasses.add(CollectionProxy.HashSetProxy.class.getName());
        knownClasses.add(CollectionProxy.TreeSetProxy.class.getName());
        knownClasses.add(MapProxy.HashMapProxy.class.getName());
        knownClasses.add(MapProxy.TreeMapProxy.class.getName());
    }

    /**
     * Returns a map from format to a set of its superclass formats.  The
     * format for simple types, enums and class Object are not included.  Only
     * complex types have superclass formats as defined by
     * Format.getSuperFormat.
     */
    Map<Format, Set<Format>> getSubclassMap() {
        Map<Format, Set<Format>> subclassMap =
            new HashMap<Format, Set<Format>>();
        for (Format format : formatList) {
            if (format == null || Format.isPredefined(format)) {
                continue;
            }
            Format superFormat = format.getSuperFormat();
            if (superFormat != null) {
                Set<Format> subclass = subclassMap.get(superFormat);
                if (subclass == null) {
                    subclass = new HashSet<Format>();
                    subclassMap.put(superFormat, subclass);
                }
                subclass.add(format);
            }
        }
        return subclassMap;
    }

    /**
     * Returns the model parameter, default model or stored model.
     */
    public EntityModel getResolvedModel() {
        return model;
    }

    /**
     * Increments the reference count for a catalog that is already open.
     */
    public void openExisting() {
        openCount += 1;
    }

    /**
     * Returns true if the user opened the store read-only, or we're running in
     * Replica upgrade mode.
     */
    public boolean isReadOnly() {
        return readOnly;
    }

    /**
     * Decrements the reference count and closes the catalog DB when it reaches
     * zero.  Returns true if the database was closed or false if the reference
     * count is still non-zero and the database was left open.
     */
    public boolean close()
        throws DatabaseException {

        if (openCount == 0) {
            throw DbCompat.unexpectedState("Catalog is not open");
        } else {
            openCount -= 1;
            if (openCount == 0) {
                db.close();
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Returns the current merged mutations.
     */
    public Mutations getMutations() {
        return mutations;
    }

    /**
     * Convenience method that gets the class for the given class name and
     * calls createFormat with the class object.
     */
    public Format createFormat(String clsName,
                               Map<String, Format> newFormats) {
        Class type;
        try {
            type = SimpleCatalog.classForName(clsName);
        } catch (ClassNotFoundException e) {
            throw DbCompat.unexpectedState
                ("Class does not exist: " + clsName);
        }
        return createFormat(type, newFormats);
    }

    /**
     * If the given class format is not already present in the given map and
     * a format for this class name does not already exist, creates an
     * uninitialized format, adds it to the map, and also collects related
     * formats in the map.
     */
    public Format createFormat(Class type, Map<String, Format> newFormats) {
        /* Return a new or existing format for this class. */
        String className = type.getName();
        Format format = newFormats.get(className);
        if (format != null) {
            return format;
        }
        format = formatMap.get(className);
        if (format != null) {
            return format;
        }
        /* Simple types are predefined. */
        assert !SimpleCatalog.isSimpleType(type) : className;

        /*
         * Although metadata is only needed for a complex type, call
         * getClassMetadata for all types to support checks for illegal
         * metadata on other types.
         */
        ClassMetadata metadata = model.getClassMetadata(className);
        /* Create format of the appropriate type. */
        String proxyClassName = null;
        if (proxyClassMap != null) {
            proxyClassName = proxyClassMap.get(className);
        }
        if (proxyClassName != null) {
            format = new ProxiedFormat(type, proxyClassName);
        } else if (type.isArray()) {
            format = type.getComponentType().isPrimitive() ?
                (new PrimitiveArrayFormat(type)) :
                (new ObjectArrayFormat(type));
        } else if (type.isEnum()) {
            format = new EnumFormat(type);
        } else if (type == Object.class || type.isInterface()) {
            format = new NonPersistentFormat(type);
        } else {
            if (metadata == null) {
                throw new IllegalArgumentException
                    ("Class could not be loaded or is not persistent: " +
                     className);
            }
            if (metadata.getCompositeKeyFields() != null &&
                (metadata.getPrimaryKey() != null ||
                 metadata.getSecondaryKeys() != null)) {
                throw new IllegalArgumentException
                    ("A composite key class may not have primary or" +
                     " secondary key fields: " + type.getName());
            }

            /*
             * Check for inner class before default constructor, to give a
             * specific error message for each.
             */
            if (type.getEnclosingClass() != null &&
                !Modifier.isStatic(type.getModifiers())) {
                throw new IllegalArgumentException
                    ("Inner classes not allowed: " + type.getName());
            }
            try {
                type.getDeclaredConstructor();
            } catch (NoSuchMethodException e) {
                throw new IllegalArgumentException
                    ("No default constructor: " + type.getName(), e);
            }
            if (metadata.getCompositeKeyFields() != null) {
                format = new CompositeKeyFormat
                    (type, metadata, metadata.getCompositeKeyFields());
            } else {
                EntityMetadata entityMetadata =
                    model.getEntityMetadata(className);
                format = new ComplexFormat(type, metadata, entityMetadata);
            }
        }
        /* Collect new format along with any related new formats. */
        newFormats.put(className, format);
        format.collectRelatedFormats(this, newFormats);

        return format;
    }

    /**
     * Adds a format and makes it the current format for the class.
     */
    private void addFormat(Format format) {
        addFormat(format, formatList, formatMap);
    }

    /**
     * Adds a format to the given the format collections, for use when
     * dynamically adding formats.
     */
    private void addFormat(Format format,
                           List<Format> list,
                           Map<String, Format> map) {
        format.setId(list.size());
        list.add(format);
        map.put(format.getClassName(), format);
    }

    /**
     * Installs an existing format when no evolution is needed, i.e, when the
     * new and old formats are identical.
     */
    void useExistingFormat(Format oldFormat) {
        assert oldFormat.isCurrentVersion();
        formatMap.put(oldFormat.getClassName(), oldFormat);
    }

    /**
     * Returns a set of all persistent (non-simple type) class names.
     */
    Set<String> getModelClasses() {
        Set<String> classes = new HashSet<String>();
        for (Format format : formatMap.values()) {
            if (format.isModelClass()) {
                classes.add(format.getClassName());
            }
        }
        return Collections.unmodifiableSet(classes);
    }

    /**
     * Returns all formats as RawTypes.
     */
    public List<RawType> getAllRawTypes() {
        List<RawType> list = new ArrayList<RawType>();
        for (RawType type : formatList) {
            if (type != null) {
                list.add(type);
            }
        }
        return Collections.unmodifiableList(list);
    }

    /**
     * When a format is intialized, this method is called to get the version
     * of the serialized object to be initialized.  See Catalog.
     */
    public int getInitVersion(Format format, boolean forReader) {

        if (catalogData == null || catalogData.formatList == null ||
            format.getId() >= catalogData.formatList.size()) {

            /*
             * For new formats, use the current version.  If catalogData is
             * null, the Catalog ctor is finished and the format must be new.
             * If the ctor is in progress, the format is new if its ID is
             * greater than the ID of all pre-existing formats.
             */
            return Catalog.CURRENT_VERSION;
        } else {

            /*
             * Get the version of a pre-existing format during execution of the
             * Catalog ctor.  The catalogData field is non-null, but evolver
             * may be null if the catalog is opened in raw mode.
             */
            assert catalogData != null;

            if (forReader) {

                /*
                 * Get the version of the evolution reader for a pre-existing
                 * format.  Use the current version if the format changed
                 * during class evolution, otherwise use the stored version.
                 */
                return (evolver != null && evolver.isFormatChanged(format)) ?
                       Catalog.CURRENT_VERSION : catalogData.version;
            } else {
                /* Always used the stored version for a pre-existing format. */
                return catalogData.version;
            }
        }
    }

    public Format getFormat(final int formatId, final boolean expectStored) {
        if (formatId < 0) {
            throw DbCompat.unexpectedState
                ("Format ID " + formatId + " is negative," +
                 " may indicate data corruption.");
        }

        /**
         * If we're attempting to read a record containing a format ID that is
         * greater than the maximum known stored format, then we refresh the
         * formats from disk, expecting that the stored formats have been
         * updated by the Master node.  Note that format IDs greater than
         * nStoredFormats may exist in the formatList, if evolution took place
         * on this Replica in a read-only mode.  Such formats are never written
         * (Replicas do not write) and cannot be used for reading an existing
         * record.  [#16655]
         *
         * Do not perform this check if we did not get the format ID from a
         * stored record (expectStored is false). For example, this would cause
         * an erroneous RefreshException when this method is called during a
         * convertRawObject operation, which calls this method to get a fresh
         * copy of a format that may not be stored.  [#18690]
         */
        if (expectStored && formatId >= nStoredFormats) {
            assert store != null;
            throw new RefreshException(store, this, formatId);
        }

        Format format = formatList.get(formatId);
        if (format == null) {
            throw DbCompat.unexpectedState
                ("Format ID " + formatId + " has null format," +
                 " may indicate data corruption.");
        }

        /*
         * Currently we can't throw DeletedClassException because we should not
         * do this if we're being called during a Conversion, and we don't have
         * that state information available.
         */
        /*
        if (format.isDeleted()) {
            throw new DeletedClassException
                ("Class " + format.getClassName() +
                 " was deleted with a Deleter muation, format ID " +
                 formatId + '.');
        }
        */

        return format;
    }

    /**
     * Get a format for a given class, creating it if it does not exist.
     *
     * <p>This method is called for top level entity instances by
     * PersistEntityBinding.  When a new entity subclass format is added we
     * call Store.checkEntitySubclassSecondaries to ensure that all secondary
     * databases have been opened, before storing the entity.  We do this here
     * while not holding a synchronization mutex, not in addNewFormat, to avoid
     * deadlocks. checkEntitySubclassSecondaries synchronizes on the Store.
     * [#16399]</p>
     *
     * <p>Historical note:  At one time we opened / created the secondary
     * databases rather than requiring the user to open them, see [#15247].
     * Later we found this to be problematic since a user txn may have locked
     * primary records, see [#16399].</p>
     */
    public Format getFormat(Class cls, boolean checkEntitySubclassIndexes) {
        Format format = formatMap.get(cls.getName());
        if (format == null) {
            if (model != null) {
                format = addNewFormat(cls);
                /* Detect and handle new entity subclass. [#15247] */
                if (checkEntitySubclassIndexes && store != null) {
                    Format entityFormat = format.getEntityFormat();
                    if (entityFormat != null && entityFormat != format) {
                        try {
                            store.checkEntitySubclassSecondaries
                                (entityFormat.getEntityMetadata(),
                                 cls.getName());
                        } catch (DatabaseException e) {
                            throw RuntimeExceptionWrapper.wrapIfNeeded(e);
                        }
                    }
                }
            }
            if (format == null) {
                throw new IllegalArgumentException
                    ("Class is not persistent: " + cls.getName());
            }
        }

        return format;
    }

    public Format getFormat(String className) {
        return formatMap.get(className);
    }

    public Format getLatestVersion(String className) {
        return latestFormatMap.get(className);
    }

    /**
     * Returns the name of an entity class to be used to form the database
     * name.  Normally this is the same as the class name, but in replica
     * upgrade mode it may be an earlier version of a renamed class.  Returns
     * null if there is no stored version of the class. [#16655]
     */
    public String getDatabaseClassName(final String className) {
        final Format format = getStoredFormat(className);
        if (format == null) {
            return null;
        }
        return format.getClassName();
    }

    /**
     * Similar to getDatabaseClassName but instead handles an earlier version
     * of a renamed key.  [#16655]
     */
    public String getDatabaseKeyName(final String className,
                                     final String keyName) {
        final Format format = getStoredFormat(className);
        if (format == null) {
            return null;
        }
        return format.getOldKeyName(keyName);
    }

    private Format getStoredFormat(final String className) {
        Format format = getFormat(className);
        while (format != null && format.getId() >= nStoredFormats) {
            format = format.getPreviousVersion();
        }
        return format;
    }

    /**
     * Metadata needs refreshing when a Replica with stale metadata is elected
     * master, and then a user write operation is attempted.  [#16655]
     */
    void checkWriteInReplicaUpgradeMode() {
        if (nStoredFormats < formatList.size()) {
            throw new RefreshException(store, this, -1 /*formatId*/);
        }
    }

    /**
     * Adds a format for a new class.  Returns the format added for the given
     * class, or throws an exception if the given class is not persistent.
     *
     * <p>This method uses a copy-on-write technique to add new formats without
     * impacting other threads.</p>
     */
    private synchronized Format addNewFormat(Class cls) {

        /*
         * After synchronizing, check whether another thread has added the
         * format needed.  Note that this is not the double-check technique
         * because the formatMap field is volatile and is not itself checked
         * for null.  (The double-check technique is known to be flawed in
         * Java.)
         */
        Format format = formatMap.get(cls.getName());
        if (format != null) {
            return format;
        }

        /* Copy the read-only format collections. */
        List<Format> newFormatList = new ArrayList<Format>(formatList);
        Map<String, Format> newFormatMap =
            new HashMap<String, Format>(formatMap);
        Map<String, Format> newLatestFormatMap =
            new HashMap<String, Format>(latestFormatMap);

        /* Add the new format and all related new formats. */
        Map<String, Format> newFormats = new HashMap<String, Format>();
        format = createFormat(cls, newFormats);
        for (Format newFormat : newFormats.values()) {
            addFormat(newFormat, newFormatList, newFormatMap);
        }

        /*
         * Initialize new formats using a read-only catalog because we can't
         * update this catalog until after we store it (below).
         */
        Catalog newFormatCatalog =
            new ReadOnlyCatalog(newFormatList, newFormatMap);
        for (Format newFormat : newFormats.values()) {
            newFormat.initializeIfNeeded(newFormatCatalog, model);
            newLatestFormatMap.put(newFormat.getClassName(), newFormat);
        }

        /*
         * Write the updated catalog using auto-commit, then assign the new
         * collections.  The database write must occur before the collections
         * are used, since a format must be persistent before it can be
         * referenced by a data record.
         *
         * In readOnly mode, which includes Replica upgrade mode, we should not
         * attempt to write since we could be elected Master and write stale
         * metadata.  If ReplicaWriteException occurs then we transition to
         * Replica upgrade mode in the same manner as in the init() method.
         * This can happen when no schema change is made except for one or more
         * new entity classes.  The new entity class will not be detected by
         * evolution (during init()) but will be detected here if the user
         * calls getPrimaryIndex.  [#16655]
         */
        if (!readOnly) {
            try {
                Data catalogData = new Data();
                catalogData.formatList = newFormatList;
                catalogData.mutations = mutations;
                writeData(null, catalogData);
            /* <!-- begin JE only --> */
            } catch (ReplicaWriteException e) {
                readOnly = true;
            /* <!-- end JE only --> */
            } catch (DatabaseException e) {
                throw RuntimeExceptionWrapper.wrapIfNeeded(e);
            }
        }
        formatList = newFormatList;
        formatMap = newFormatMap;
        latestFormatMap = newLatestFormatMap;

        return format;
    }

    /**
     * Used to write the catalog when a format has been changed, for example,
     * when Store.evolve has updated a Format's EvolveNeeded property.  Uses
     * auto-commit.
     */
    public synchronized void flush()
        throws DatabaseException {

        Data catalogData = new Data();
        catalogData.formatList = formatList;
        catalogData.mutations = mutations;
        writeData(null, catalogData);
    }

    /**
     * Returns the number of stored formats.
     */
    int getNFormats() {
        return nStoredFormats;
    }

    /**
     * Reads catalog Data, converting old versions as necessary.  An empty
     * Data object is returned if no catalog data currently exists.  Null is
     * never returned.
     */
    private Data readData(Transaction txn)
        throws DatabaseException {

        Data catalogData;
        DatabaseEntry key = new DatabaseEntry(DATA_KEY);
        DatabaseEntry data = new DatabaseEntry();
        OperationStatus status = db.get(txn, key, data, null);
        if (status == OperationStatus.SUCCESS) {
            ByteArrayInputStream bais = new ByteArrayInputStream
                (data.getData(), data.getOffset(), data.getSize());
            try {
                ObjectInputStream ois = new ObjectInputStream(bais);
                Object object = ois.readObject();
                assert ois.available() == 0;
                if (object instanceof Data) {
                    catalogData = (Data) object;
                } else {
                    if (!(object instanceof List)) {
                        throw DbCompat.unexpectedState
                            (object.getClass().getName());
                    }
                    catalogData = new Data();
                    catalogData.formatList = (List) object;
                    catalogData.version = BETA_VERSION;
                }
                return catalogData;
            } catch (ClassNotFoundException e) {
                throw DbCompat.unexpectedException(e);
            } catch (IOException e) {
                throw DbCompat.unexpectedException(e);
            }
        } else {
            catalogData = new Data();
            catalogData.version = Catalog.CURRENT_VERSION;
        }
        return catalogData;
    }

    /**
     * Writes catalog Data.  If txn is null, auto-commit is used.
     */
    private void writeData(Transaction txn, Data catalogData)
        throws DatabaseException {

        Data oldData = readData(txn);

        /*
         * Metadata needs refreshing when a Replica with stale metadata is
         * elected master, and then a user write operation is attempted that
         * also requires a metadata update.  [#16655]
         */
        final int nOldFormats = formatList.size();
        if (oldData.formatList != null &&
            oldData.formatList.size() > nOldFormats) {
            throw new RefreshException(store, this,  /*formatId*/-1);
        }

        /* Catalog data is written in the current version. */
        boolean wasBetaVersion = (catalogData.version == BETA_VERSION);
        catalogData.version = CURRENT_VERSION;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(catalogData);
        } catch (IOException e) {
            throw DbCompat.unexpectedException(e);
        }
        DatabaseEntry key = new DatabaseEntry(DATA_KEY);
        DatabaseEntry data = new DatabaseEntry(baos.toByteArray());
        db.put(txn, key, data);

        /*
         * Delete the unused beta mutations record if we read the beta version
         * record earlier.
         */
        if (wasBetaVersion) {
            key.setData(BETA_MUTATIONS_KEY);
            db.delete(txn, key);
        }

        nStoredFormats = catalogData.formatList.size();
    }

    public boolean isRawAccess() {
        return rawAccess;
    }

    public Object convertRawObject(RawObject o, IdentityHashMap converted) {
        Format format = (Format) o.getType();
        if (this == format.getCatalog()) {
            /* Ensure a fresh format is used, in case of Replica refresh. */
            format = getFormat(format.getId(), false /*expectStored*/);
        } else {

            /*
             * Use the corresponding format in this catalog when the external
             * raw object was created using a different catalog.  Create the
             * format if it does not already exist, for example, when this
             * store is empty. [#16253].
             */
            String clsName = format.getClassName();
            Class cls;
            try {
                cls = SimpleCatalog.classForName(clsName);
                format = getFormat(cls, true /*checkEntitySubclassIndexes*/);
            } catch (ClassNotFoundException e) {
                format = null;
            }
            if (format == null) {
                throw new IllegalArgumentException
                    ("External raw type not found: " + clsName);
            }
        }
        Format proxiedFormat = format.getProxiedFormat();
        if (proxiedFormat != null) {
            format = proxiedFormat;
        }
        if (converted == null) {
            converted = new IdentityHashMap();
        }
        return format.convertRawObject(this, false, o, converted);
    }
}
