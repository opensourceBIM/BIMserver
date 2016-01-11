/**
 * Copyright (C) 2009-2014 BIMserver.org
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
 */
package org.bimserver.models.geometry.impl;

import java.io.IOException;
import java.net.URL;

import org.bimserver.models.geometry.GeometryFactory;
import org.bimserver.models.geometry.GeometryPackage;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.impl.Ifc2x3tc1PackageImpl;
import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.impl.Ifc4PackageImpl;
import org.bimserver.models.log.LogPackage;
import org.bimserver.models.log.impl.LogPackageImpl;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.impl.StorePackageImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GeometryPackageImpl extends EPackageImpl implements GeometryPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected String packageFilename = "geometry.ecore";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass geometryInfoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vector3fEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass geometryDataEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.bimserver.models.geometry.GeometryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GeometryPackageImpl() {
		super(eNS_URI, GeometryFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link GeometryPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @generated
	 */
	public static GeometryPackage init() {
		if (isInited)
			return (GeometryPackage) EPackage.Registry.INSTANCE.getEPackage(GeometryPackage.eNS_URI);

		// Obtain or create and register package
		GeometryPackageImpl theGeometryPackage = (GeometryPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof GeometryPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
						: new GeometryPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		Ifc2x3tc1PackageImpl theIfc2x3tc1Package = (Ifc2x3tc1PackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(Ifc2x3tc1Package.eNS_URI) instanceof Ifc2x3tc1PackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(Ifc2x3tc1Package.eNS_URI)
						: Ifc2x3tc1Package.eINSTANCE);
		Ifc4PackageImpl theIfc4Package = (Ifc4PackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(Ifc4Package.eNS_URI) instanceof Ifc4PackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(Ifc4Package.eNS_URI) : Ifc4Package.eINSTANCE);
		LogPackageImpl theLogPackage = (LogPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(LogPackage.eNS_URI) instanceof LogPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(LogPackage.eNS_URI) : LogPackage.eINSTANCE);
		StorePackageImpl theStorePackage = (StorePackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(StorePackage.eNS_URI) instanceof StorePackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI) : StorePackage.eINSTANCE);

		// Load packages
		theGeometryPackage.loadPackage();
		theIfc2x3tc1Package.loadPackage();
		theIfc4Package.loadPackage();
		theLogPackage.loadPackage();
		theStorePackage.loadPackage();

		// Fix loaded packages
		theGeometryPackage.fixPackageContents();
		theIfc2x3tc1Package.fixPackageContents();
		theIfc4Package.fixPackageContents();
		theLogPackage.fixPackageContents();
		theStorePackage.fixPackageContents();

		// Mark meta-data to indicate it can't be changed
		theGeometryPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GeometryPackage.eNS_URI, theGeometryPackage);
		return theGeometryPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeometryInfo() {
		if (geometryInfoEClass == null) {
			geometryInfoEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(GeometryPackage.eNS_URI)
					.getEClassifiers().get(0);
		}
		return geometryInfoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeometryInfo_MinBounds() {
		return (EReference) getGeometryInfo().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeometryInfo_MaxBounds() {
		return (EReference) getGeometryInfo().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeometryInfo_StartVertex() {
		return (EAttribute) getGeometryInfo().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeometryInfo_StartIndex() {
		return (EAttribute) getGeometryInfo().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeometryInfo_PrimitiveCount() {
		return (EAttribute) getGeometryInfo().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeometryInfo_Data() {
		return (EReference) getGeometryInfo().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeometryInfo_Transformation() {
		return (EAttribute) getGeometryInfo().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeometryInfo_Area() {
		return (EAttribute) getGeometryInfo().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeometryInfo_Volume() {
		return (EAttribute) getGeometryInfo().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVector3f() {
		if (vector3fEClass == null) {
			vector3fEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(GeometryPackage.eNS_URI).getEClassifiers()
					.get(1);
		}
		return vector3fEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVector3f_X() {
		return (EAttribute) getVector3f().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVector3f_Y() {
		return (EAttribute) getVector3f().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVector3f_Z() {
		return (EAttribute) getVector3f().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeometryData() {
		if (geometryDataEClass == null) {
			geometryDataEClass = (EClass) EPackage.Registry.INSTANCE.getEPackage(GeometryPackage.eNS_URI)
					.getEClassifiers().get(2);
		}
		return geometryDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeometryData_Indices() {
		return (EAttribute) getGeometryData().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeometryData_Vertices() {
		return (EAttribute) getGeometryData().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeometryData_Normals() {
		return (EAttribute) getGeometryData().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeometryData_Materials() {
		return (EAttribute) getGeometryData().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeometryData_MaterialIndices() {
		return (EAttribute) getGeometryData().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeometryFactory getGeometryFactory() {
		return (GeometryFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isLoaded = false;

	/**
	 * Laods the package and any sub-packages from their serialized form.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void loadPackage() {
		if (isLoaded)
			return;
		isLoaded = true;

		URL url = getClass().getResource(packageFilename);
		if (url == null) {
			throw new RuntimeException("Missing serialized package: " + packageFilename);
		}
		URI uri = URI.createURI(url.toString());
		Resource resource = new EcoreResourceFactoryImpl().createResource(uri);
		try {
			resource.load(null);
		} catch (IOException exception) {
			throw new WrappedException(exception);
		}
		initializeFromLoadedEPackage(this, (EPackage) resource.getContents().get(0));
		createResource(eNS_URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isFixed = false;

	/**
	 * Fixes up the loaded package, to make it appear as if it had been programmatically built.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fixPackageContents() {
		if (isFixed)
			return;
		isFixed = true;
		fixEClassifiers();
	}

	/**
	 * Sets the instance class on the given classifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void fixInstanceClass(EClassifier eClassifier) {
		if (eClassifier.getInstanceClassName() == null) {
			eClassifier.setInstanceClassName("org.bimserver.models.geometry." + eClassifier.getName());
			setGeneratedClassName(eClassifier);
		}
	}

} //GeometryPackageImpl
