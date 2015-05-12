package net.sourceforge.osexpress.parser;

/******************************************************************************
 * Copyright (C) 2009-2015  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* Express Scope representation by Stephane Lardet (stephane.lardet@nist.gov
 *
 * Development of this software was funded by the United States Government,
 * and is not subject to copyright.
 *
 * DISCLAIMER: Recipients of this software assume all responsibility
 * associated with its operation, modification, maintenance, and subsequent
 * re-distribution.
 */

/* There are two linking hierarchies here, a tree-like one (using the
 parent atribute) which allows id research into the scopes tree, and a flat
 one (sort of linked list of Scopes, using the next attribute) which reflects
 the order of Scope instances creations during the first pass, thus we can
 retrieve corresponding Scope instances during the second pass
 In addition, information about entities is recorded so as to perform a
 research through the inheritance tree.
 */

@SuppressWarnings("all")
public class Scope implements Cloneable {

	/* scope id */
	public int scopeId; /* for debugging purpose */
	private static int globalId = 1;

	/* id recording */
	private Hashtable<String, ExpressParserTokenTypes> idtable; /* ids */

	/* entities management */
	private boolean entity; /* if we are in a scope defined by an entity */
	private Hashtable entities; /* references to scopes of entities defined here */
	private Vector superentities; /* names of super entities of this */

	/*
	 * schema case: Only if this scope is defined by a schema. External elements
	 * (reference from, use from) are recorded here and then postprocessed
	 */
	private Vector externals; /* external elements referenced or used here */
	private boolean extdone = false; /* processExternals already done */
	private Vector allReferencedSchemas; /*
										 * all elements of these schemas are
										 * referenced
										 */
	private Vector allUsedSchemas; /* all elements of these schemas are used */

	private Vector enumerationTypes; /*
									 * Enumerations linked to their defining
									 * TYPE to manage enumerations reference
									 */

	/* scope linking */
	public Scope parent; /* Scope which this Scope is defined within */
	public Scope next; /* next Scope beeing created during the pass */

	public void addId(String id, ExpressParserTokenTypes type) {
		ExpressParserTokenTypes i;

		/*
		 * records an id with its tokentype drops an error when already defined.
		 * Enumeration ids are recorded in the parent scope for visibility
		 * reasons (it should be visible out of the TYPE in which it is defined
		 */
		i = idtable.get(id.toLowerCase());
		if (i == null)
			idtable.put(id.toLowerCase(), type);
		else
			System.err.println("Warning: id \"" + id + "\" already defined");
	}

	public void addEnumerationType(EnumerationType et) {
		ExpressParserTokenTypes ii;
		int sz, i;
		String id;

		/*
		 * to record enumeration ids out of their original scope (TYPE) Also
		 * records the enumerations with the type where they are defined so they
		 * can be retrieved when processing REFERENCE clauses
		 */
		sz = et.getCount();
		for (i = 0; i < sz; i++) {
			id = et.getEnumerationId(i);
			ii = idtable.get(id.toLowerCase());
			if (ii == null)
				idtable.put(id.toLowerCase(), ExpressParserTokenTypes.ENUMERATION_IDENT);
			else if (ii != ExpressParserTokenTypes.ENUMERATION_IDENT)
				System.err.println("Warning: id \"" + id + "\" already defined");
		}
		if (enumerationTypes == null)
			enumerationTypes = new Vector();
		enumerationTypes.add(et);
	}

	public EnumerationType searchEnumerationType(String name) {
		int sz, i;
		EnumerationType et;

		if (enumerationTypes != null) {
			sz = enumerationTypes.size();
			for (i = 0; i < sz; i++) {
				et = (EnumerationType) enumerationTypes.elementAt(i);
				if (et.typename.equals(name))
					return et;
			}
		}
		return null;
	}

	public void addEntityScope(String name, Scope s) {
		Object o;

		/* records a reference of the scope defined by the entity name */
		o = entities.get(name.toLowerCase());
		if (o == null)
			entities.put(name.toLowerCase(), s);
		else
			System.err.println("Warning: entity \"" + name + "\" already defined in this scope");
	}

	public void addSuperEntity(String name) {
		superentities.add(name);
	}

	public ExpressParserTokenTypes searchId(String id) {
		ExpressParserTokenTypes i;
		ExpressParserTokenTypes it;

		/*
		 * search the given id in this scope's table, in the entity inheritance
		 * tree and in all the scopes tree if not found. Because of part 10.2.2
		 * of ISO 10303-11:1994, we have to consider the case of redeclaration
		 * of attribute without hiding the entity with the same name in the
		 * outer scope. So if an id is declared as en entity and an attribute,
		 * an ENTITY_ATTR_IDENT token is generated. same for TYPE_ATTR_IDENT,
		 * ENTITY_VAR_IDENT, TYPE_VAR_IDENT ENTITY_PARAM_IDENT and
		 * TYPE_PARAM_IDENT
		 */
		if (id == null) {
			i = null;
		} else {
			i = idtable.get(id.toLowerCase());
		}
		if (i == null) {
			if (entity) {
				i = searchInheritanceTree(id);
				if (i != null) {
					if (i == ExpressParserTokenTypes.ATTRIBUTE_IDENT) {
						if (parent != null) {
							it = parent.searchId(id);
							if (it == ExpressParserTokenTypes.ENTITY_IDENT)
								return ExpressParserTokenTypes.ENTITY_ATTR_IDENT;
							else if (it == ExpressParserTokenTypes.TYPE_IDENT)
								return ExpressParserTokenTypes.TYPE_ATTR_IDENT;
						}
					} else if (i == ExpressParserTokenTypes.VARIABLE_IDENT) {
						if (parent != null) {
							it = parent.searchId(id);
							if (it == ExpressParserTokenTypes.ENTITY_IDENT)
								return ExpressParserTokenTypes.ENTITY_VAR_IDENT;
							else if (it == ExpressParserTokenTypes.TYPE_IDENT)
								return ExpressParserTokenTypes.TYPE_VAR_IDENT;
						}
					} else if (i == ExpressParserTokenTypes.PARAMETER_IDENT) {
						if (parent != null) {
							it = parent.searchId(id);
							if (it == ExpressParserTokenTypes.ENTITY_IDENT)
								return ExpressParserTokenTypes.ENTITY_PARAM_IDENT;
							else if (it == ExpressParserTokenTypes.TYPE_IDENT)
								return ExpressParserTokenTypes.TYPE_PARAM_IDENT;
						}
					}
					return i;
				}
			}
			if (parent != null)
				return parent.searchId(id);
			else
				return ExpressParserTokenTypes.IDENT;
		} else {
			if (i == ExpressParserTokenTypes.ATTRIBUTE_IDENT) {
				if (parent != null) {
					it = parent.searchId(id);
					if (it == ExpressParserTokenTypes.ENTITY_IDENT)
						return ExpressParserTokenTypes.ENTITY_ATTR_IDENT;
					else if (it == ExpressParserTokenTypes.TYPE_IDENT)
						return ExpressParserTokenTypes.TYPE_ATTR_IDENT;
				}
			} else if (i == ExpressParserTokenTypes.VARIABLE_IDENT) {
				if (parent != null) {
					it = parent.searchId(id);
					if (it == ExpressParserTokenTypes.ENTITY_IDENT)
						return ExpressParserTokenTypes.ENTITY_VAR_IDENT;
					else if (it == ExpressParserTokenTypes.TYPE_IDENT)
						return ExpressParserTokenTypes.TYPE_VAR_IDENT;
				}
			} else if (i == ExpressParserTokenTypes.PARAMETER_IDENT) {
				if (parent != null) {
					it = parent.searchId(id);
					if (it == ExpressParserTokenTypes.ENTITY_IDENT)
						return ExpressParserTokenTypes.ENTITY_PARAM_IDENT;
					else if (it == ExpressParserTokenTypes.TYPE_IDENT)
						return ExpressParserTokenTypes.TYPE_PARAM_IDENT;
				}
			}
			return i;
		}
	}

	public ExpressParserTokenTypes searchInheritanceTree(String id) {
		ExpressParserTokenTypes i;
		int sz, j;
		String name;
		Scope ent;

		i = idtable.get(id.toLowerCase());
		if (i != null)
			return i;
		else {
			sz = superentities.size();
			if (sz > 0) {
				for (j = 0; (j < sz) && (i == null); j++) {
					name = (String) superentities.elementAt(j);
					if (parent != null) {
						ent = parent.searchEntity(name);
						if (ent == null)
							System.err.println("Error: unable to resolve entity \"" + name + "\"");
						else
							i = ent.searchInheritanceTree(id);
					}
				}
			}
			return i;
		}
	}

	public Scope searchEntity(String name) {
		Scope ent;

		ent = (Scope) entities.get(name.toLowerCase());
		if ((ent == null) && (parent != null))
			ent = parent.searchEntity(name);
		return ent;
	}

	/* schema case */
	public void addExternal(ExternalId ei) {
		/* an element from another schema (used or referenced) */
		if (externals == null)
			externals = new Vector();

		externals.add(ei);
	}

	public Vector getReferencedExternals() {
		/*
		 * get all elements of this schema that can be referenced i.e. constant,
		 * entity, function, procedure, type
		 */
		Enumeration e;
		String id;
		ExpressParserTokenTypes type;
		Vector res = null;
		ExternalId ei;

		e = idtable.keys();
		while (e.hasMoreElements()) {
			id = (String) e.nextElement();
			type = idtable.get(id.toLowerCase());
			if (type == ExpressParserTokenTypes.CONSTANT_IDENT || type == ExpressParserTokenTypes.ENTITY_IDENT || type == ExpressParserTokenTypes.FUNCTION_IDENT
					|| type == ExpressParserTokenTypes.PROCEDURE_IDENT || type == ExpressParserTokenTypes.TYPE_IDENT) {
				if (res == null)
					res = new Vector();
				ei = new ExternalId(id, type);
				res.add(ei);
			}
		}
		return res;
	}

	public Vector getUsedExternals() {
		/*
		 * get all elements of this schema that can be used i.e. entity, type
		 */
		Enumeration e;
		String id;
		ExpressParserTokenTypes type;
		Vector res = null;
		ExternalId ei;

		e = idtable.keys();
		while (e.hasMoreElements()) {
			id = (String) e.nextElement();
			type = idtable.get(id.toLowerCase());
			if (type == ExpressParserTokenTypes.ENTITY_IDENT || type == ExpressParserTokenTypes.TYPE_IDENT) {
				if (res == null)
					res = new Vector();
				ei = new ExternalId(id, type);
				res.add(ei);
			}
		}
		return res;
	}

	public void addAllReferenceExternals(String schema) {
		/* schema referenced here (all elements) */
		if (allReferencedSchemas == null)
			allReferencedSchemas = new Vector();
		allReferencedSchemas.add(schema);
	}

	public void addAllUseExternals(String schema) {
		/* schema used here (all elements) */
		if (allUsedSchemas == null)
			allUsedSchemas = new Vector();
		allUsedSchemas.add(schema);
	}

	public void processExternals(Hashtable schemas) {
		/*
		 * add ids of used and referenced elements of other schemas to this
		 * schema's scope
		 */
		int sz, i, sz2, j;
		ExpressParserTokenTypes eid;
		ExternalId ei;
		Scope s, es = null;
		String rn = null;
		Vector eids;
		EnumerationType et, ext;

		if (!extdone) {
			if (externals != null) {
				/*
				 * Here we manage REFERENCES to (or USE of) single elements,
				 * when specified in the REFERENCE or USE clause
				 */
				sz = externals.size();
				for (i = 0; i < sz; i++) {
					ei = (ExternalId) externals.elementAt(i);
					s = (Scope) schemas.get(ei.schema);
					if (s == null)
						System.err.println("Warning: REFERENCED or USED schema \"" + ei.schema + "\" does not exist in the parsed file");
					else {
						/*
						 * schema has to be processed before since you can USE
						 * or REFERENCE elements that the schema USEs itself
						 */
						s.processExternals(schemas);
						eid = s.searchId(ei.id);
						if (eid == ExpressParserTokenTypes.IDENT)
							System.err.println("Warning: external id \"" + ei.id + "\" not found in schema \"" + ei.schema + "\"");
						else {
							rn = ei.rename;
							/*
							 * idtable.put is used instead of addId because some
							 * externals ids may be imported twice or more, so
							 * it would throw double definition errors
							 */
							if (rn != null)
								idtable.put(rn.toLowerCase(), eid);
							else
								idtable.put(ei.id.toLowerCase(), eid);

							/* Entity information (Scope) management */
							if (eid == ExpressParserTokenTypes.ENTITY_IDENT) {
								try {
									es = (Scope) s.searchEntity(ei.id).clone();
									/*
									 * we clone the Scope because we have to
									 * assign a new parent to it (this), but the
									 * original Scope should keep its parent
									 * attribute safe
									 */
								} catch (CloneNotSupportedException cnse) {
								}
								es.setParent(this);
								entities.put(ei.id.toLowerCase(), es);
							}
							/* Extensible enumerations management */
							else if (eid == ExpressParserTokenTypes.TYPE_IDENT) {
								et = s.searchEnumerationType(ei.id);
								if (et != null) {
									if (rn != null)
										et.setTypeName(rn);
									if (et.basedOnName != null) {
										ext = s.searchEnumerationType(et.basedOnName);
										if (ext != null) {
											if (!ext.extensible)
												System.err.println("Warning: enumeration type \"" + et.typename + "\" based on non extensible enumeration \"" + et.basedOnName
														+ "\"");
											et.extendWith(ext);
										} else
											System.err.println("Warning: extensible enumeration \"" + et.basedOnName + "\" not found");
									}
									addEnumerationType(et);
								}
							}
						}
					}
				}
			}
			if (allReferencedSchemas != null) {
				/*
				 * Here we manage REFERENCES to all referencable elements of a
				 * schema (when no element is specified in the REFERENCE clause)
				 */
				sz = allReferencedSchemas.size();
				for (i = 0; i < sz; i++) {
					s = (Scope) schemas.get(allReferencedSchemas.elementAt(i));
					if (s == null)
						System.err.println("Warning: REFERENCED schema \"" + (String) allReferencedSchemas.elementAt(i) + "\" does not exist in the parsed file");
					else {
						eids = s.getReferencedExternals();
						if (eids != null) {
							sz2 = eids.size();
							for (j = 0; j < sz2; j++) {
								ei = (ExternalId) eids.elementAt(j);
								idtable.put(ei.id.toLowerCase(), ei.type);

								/* Entity information (Scope) management */
								if (ei.type == ExpressParserTokenTypes.ENTITY_IDENT) {
									try {
										es = (Scope) s.searchEntity(ei.id).clone();
									} catch (CloneNotSupportedException cnse) {
									}
									es.setParent(this);
									entities.put(ei.id.toLowerCase(), es);
								}
								/* extensible enumerations management */
								else if (ei.type == ExpressParserTokenTypes.TYPE_IDENT) {
									et = s.searchEnumerationType(ei.id);
									if (et != null) {
										if (rn != null)
											et.setTypeName(rn);
										if (et.basedOnName != null) {
											ext = searchEnumerationType(et.basedOnName);
											if (ext != null) {
												if (!ext.extensible)
													System.err.println("Warning: enumeration type \"" + et.typename + "\" based on non extensible enumeration \"" + et.basedOnName
															+ "\"");
												et.extendWith(ext);
											} else
												System.err.println("Warning: extensible enumeration \"" + et.basedOnName + "\" not found");
										}
										addEnumerationType(et);
									}
								}
							}
						}
					}
				}
			}
			if (allUsedSchemas != null) {
				/*
				 * Here we manage USEs of all useable elements of a schema (when
				 * no element is specified in the USE clause)
				 */
				sz = allUsedSchemas.size();
				for (i = 0; i < sz; i++) {
					s = (Scope) schemas.get(allUsedSchemas.elementAt(i));
					if (s == null)
						System.err.println("Warning: USED schema \"" + (String) allUsedSchemas.elementAt(i) + "\" does not exist in the parsed file");
					else {
						eids = s.getUsedExternals();
						if (eids != null) {
							sz2 = eids.size();
							for (j = 0; j < sz2; j++) {
								ei = (ExternalId) eids.elementAt(j);
								idtable.put(ei.id.toLowerCase(), ei.type);

								/* Entity information (Scope) management */
								if (ei.type == ExpressParserTokenTypes.ENTITY_IDENT) {
									try {
										es = (Scope) s.searchEntity(ei.id).clone();
									} catch (CloneNotSupportedException cnse) {
									}
									es.setParent(this);
									entities.put(ei.id.toLowerCase(), es);
								}
								/* extensible enumerations management */
								else if (ei.type == ExpressParserTokenTypes.TYPE_IDENT) {
									et = s.searchEnumerationType(ei.id);
									if (et != null) {
										if (rn != null)
											et.setTypeName(rn);
										if (et.basedOnName != null) {
											ext = searchEnumerationType(et.basedOnName);
											if (ext != null) {
												if (!ext.extensible)
													System.err.println("Warning: enumeration type \"" + et.typename + "\" based on non extensible enumeration \"" + et.basedOnName
															+ "\"");
												et.extendWith(ext);
											} else
												System.err.println("Warning: extensible enumeration \"" + et.basedOnName + "\" not found");
										}
										addEnumerationType(et);
									}
								}
							}
						}
					}
				}
			}
		}
		extdone = true;
	}

	/* linking */

	public void setParent(Scope p) {
		parent = p;
	}

	public void setNext(Scope next) {
		/* next accessor */
		this.next = next;
	}

	public void setEntity() {
		entity = true;
		superentities = new Vector();
	}

	public Scope(Scope parent) {
		/* creation */
		scopeId = globalId;
		globalId++;
		this.parent = parent;
		idtable = new Hashtable();
		entities = new Hashtable();
		entity = false;
	}
}
