/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.store.impl;

import java.io.IOException;

import java.net.URL;

import org.bimserver.models.ifc2x3.Ifc2x3Package;

import org.bimserver.models.ifc2x3.impl.Ifc2x3PackageImpl;

import org.bimserver.models.log.LogPackage;

import org.bimserver.models.log.impl.LogPackageImpl;

import org.bimserver.models.store.StoreFactory;
import org.bimserver.models.store.StorePackage;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
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
public class StorePackageImpl extends EPackageImpl implements StorePackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected String packageFilename = "store.ecore";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clashEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eidClashEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass guidClashEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass clashDetectionSettingsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass revisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass concreteRevisionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass geoTagEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass checkoutEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass settingsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serializerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ignoreFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum userTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum checkinStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum siPrefixEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum objectStateEEnum = null;

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
	 * @see org.bimserver.models.store.StorePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StorePackageImpl()
	{
		super(eNS_URI, StoreFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link StorePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @generated
	 */
	public static StorePackage init()
	{
		if (isInited) return (StorePackage)EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI);

		// Obtain or create and register package
		StorePackageImpl theStorePackage = (StorePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof StorePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new StorePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		LogPackageImpl theLogPackage = (LogPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LogPackage.eNS_URI) instanceof LogPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LogPackage.eNS_URI) : LogPackage.eINSTANCE);
		Ifc2x3PackageImpl theIfc2x3Package = (Ifc2x3PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Ifc2x3Package.eNS_URI) instanceof Ifc2x3PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Ifc2x3Package.eNS_URI) : Ifc2x3Package.eINSTANCE);

		// Load packages
		theStorePackage.loadPackage();
		theLogPackage.loadPackage();
		theIfc2x3Package.loadPackage();

		// Fix loaded packages
		theStorePackage.fixPackageContents();
		theLogPackage.fixPackageContents();
		theIfc2x3Package.fixPackageContents();

		// Mark meta-data to indicate it can't be changed
		theStorePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(StorePackage.eNS_URI, theStorePackage);
		return theStorePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProject()
	{
		if (projectEClass == null)
		{
			projectEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(4);
		}
		return projectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_Id()
	{
        return (EAttribute)getProject().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_Name()
	{
        return (EAttribute)getProject().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_HasAuthorizedUsers()
	{
        return (EReference)getProject().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_ConcreteRevisions()
	{
        return (EReference)getProject().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_Revisions()
	{
        return (EReference)getProject().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_LastConcreteRevision()
	{
        return (EReference)getProject().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_LastRevision()
	{
        return (EReference)getProject().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_Checkouts()
	{
        return (EReference)getProject().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_State()
	{
        return (EAttribute)getProject().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_CreatedDate()
	{
        return (EAttribute)getProject().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_CreatedBy()
	{
        return (EReference)getProject().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_GeoTag()
	{
        return (EReference)getProject().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_SubProjects()
	{
        return (EReference)getProject().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_Parent()
	{
        return (EReference)getProject().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_Description()
	{
        return (EAttribute)getProject().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_ClashDetectionSettings()
	{
        return (EReference)getProject().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_ExportLengthMeasurePrefix()
	{
        return (EAttribute)getProject().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUser()
	{
		if (userEClass == null)
		{
			userEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(5);
		}
		return userEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_Name()
	{
        return (EAttribute)getUser().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_Password()
	{
        return (EAttribute)getUser().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUser_HasRightsOn()
	{
        return (EReference)getUser().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUser_Revisions()
	{
        return (EReference)getUser().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_State()
	{
        return (EAttribute)getUser().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_CreatedOn()
	{
        return (EAttribute)getUser().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUser_CreatedBy()
	{
        return (EReference)getUser().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_UserType()
	{
        return (EAttribute)getUser().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_Username()
	{
        return (EAttribute)getUser().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_LastSeen()
	{
        return (EAttribute)getUser().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_ValidationToken()
	{
        return (EAttribute)getUser().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUser_ValidationTokenCreated()
	{
        return (EAttribute)getUser().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClash()
	{
		if (clashEClass == null)
		{
			clashEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(6);
		}
		return clashEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClash_Name1()
	{
        return (EAttribute)getClash().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClash_Name2()
	{
        return (EAttribute)getClash().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClash_Type1()
	{
        return (EAttribute)getClash().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClash_Type2()
	{
        return (EAttribute)getClash().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClash_Revision1()
	{
        return (EReference)getClash().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClash_Revision2()
	{
        return (EReference)getClash().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEidClash()
	{
		if (eidClashEClass == null)
		{
			eidClashEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(7);
		}
		return eidClashEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEidClash_Eid1()
	{
        return (EAttribute)getEidClash().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEidClash_Eid2()
	{
        return (EAttribute)getEidClash().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGuidClash()
	{
		if (guidClashEClass == null)
		{
			guidClashEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(8);
		}
		return guidClashEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGuidClash_Guid1()
	{
        return (EAttribute)getGuidClash().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGuidClash_Guid2()
	{
        return (EAttribute)getGuidClash().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClashDetectionSettings()
	{
		if (clashDetectionSettingsEClass == null)
		{
			clashDetectionSettingsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(9);
		}
		return clashDetectionSettingsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClashDetectionSettings_Enabled()
	{
        return (EAttribute)getClashDetectionSettings().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClashDetectionSettings_Projects()
	{
        return (EReference)getClashDetectionSettings().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClashDetectionSettings_Margin()
	{
        return (EAttribute)getClashDetectionSettings().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClashDetectionSettings_Revisions()
	{
        return (EReference)getClashDetectionSettings().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClashDetectionSettings_IgnoredClasses()
	{
        return (EAttribute)getClashDetectionSettings().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRevision()
	{
		if (revisionEClass == null)
		{
			revisionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(10);
		}
		return revisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_Id()
	{
        return (EAttribute)getRevision().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRevision_User()
	{
        return (EReference)getRevision().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_Date()
	{
        return (EAttribute)getRevision().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_Comment()
	{
        return (EAttribute)getRevision().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_Size()
	{
        return (EAttribute)getRevision().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRevision_ConcreteRevisions()
	{
        return (EReference)getRevision().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRevision_LastConcreteRevision()
	{
        return (EReference)getRevision().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRevision_Checkouts()
	{
        return (EReference)getRevision().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRevision_Project()
	{
        return (EReference)getRevision().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_State()
	{
        return (EAttribute)getRevision().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRevision_LastClashes()
	{
        return (EReference)getRevision().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_Tag()
	{
        return (EAttribute)getRevision().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_LastError()
	{
        return (EAttribute)getRevision().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_Bmi()
	{
        return (EAttribute)getRevision().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_NrClashes()
	{
        return (EAttribute)getRevision().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRevision_Laid()
	{
        return (EAttribute)getRevision().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConcreteRevision()
	{
		if (concreteRevisionEClass == null)
		{
			concreteRevisionEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(11);
		}
		return concreteRevisionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteRevision_Id()
	{
        return (EAttribute)getConcreteRevision().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteRevision_Project()
	{
        return (EReference)getConcreteRevision().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteRevision_State()
	{
        return (EAttribute)getConcreteRevision().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteRevision_Checksum()
	{
        return (EAttribute)getConcreteRevision().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteRevision_Revisions()
	{
        return (EReference)getConcreteRevision().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteRevision_Size()
	{
        return (EAttribute)getConcreteRevision().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteRevision_Date()
	{
        return (EAttribute)getConcreteRevision().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteRevision_LastError()
	{
        return (EAttribute)getConcreteRevision().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeoTag()
	{
		if (geoTagEClass == null)
		{
			geoTagEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(12);
		}
		return geoTagEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeoTag_Enabled()
	{
        return (EAttribute)getGeoTag().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeoTag_Projects()
	{
        return (EReference)getGeoTag().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeoTag_X()
	{
        return (EAttribute)getGeoTag().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeoTag_Y()
	{
        return (EAttribute)getGeoTag().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeoTag_Z()
	{
        return (EAttribute)getGeoTag().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeoTag_Epsg()
	{
        return (EAttribute)getGeoTag().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeoTag_DirectionAngle()
	{
        return (EAttribute)getGeoTag().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCheckout()
	{
		if (checkoutEClass == null)
		{
			checkoutEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(13);
		}
		return checkoutEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCheckout_User()
	{
        return (EReference)getCheckout().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCheckout_Revision()
	{
        return (EReference)getCheckout().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCheckout_Project()
	{
        return (EReference)getCheckout().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCheckout_Date()
	{
        return (EAttribute)getCheckout().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCheckout_Checkin()
	{
        return (EReference)getCheckout().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCheckout_Active()
	{
        return (EAttribute)getCheckout().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSettings()
	{
		if (settingsEClass == null)
		{
			settingsEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(14);
		}
		return settingsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_ShowVersionUpgradeAvailable()
	{
        return (EAttribute)getSettings().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_SendConfirmationEmailAfterRegistration()
	{
        return (EAttribute)getSettings().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_UseCaching()
	{
        return (EAttribute)getSettings().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_AllowSelfRegistration()
	{
        return (EAttribute)getSettings().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_AutoTestClashes()
	{
        return (EAttribute)getSettings().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_IntelligentMerging()
	{
        return (EAttribute)getSettings().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_AllowUsersToCreateTopLevelProjects()
	{
        return (EAttribute)getSettings().getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_CheckinMergingEnabled()
	{
        return (EAttribute)getSettings().getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_RegistrationAddition()
	{
        return (EAttribute)getSettings().getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_SmtpServer()
	{
        return (EAttribute)getSettings().getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_EmailSenderAddress()
	{
        return (EAttribute)getSettings().getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_EnabledExportTypes()
	{
        return (EAttribute)getSettings().getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_CustomLogoAddress()
	{
        return (EAttribute)getSettings().getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_SiteAddress()
	{
        return (EAttribute)getSettings().getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSettings_Serializers()
	{
        return (EReference)getSettings().getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSettings_IgnoreFiles()
	{
        return (EReference)getSettings().getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_HeaderAddition()
	{
        return (EAttribute)getSettings().getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSettings_FooterAddition()
	{
        return (EAttribute)getSettings().getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSerializer()
	{
		if (serializerEClass == null)
		{
			serializerEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(15);
		}
		return serializerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSerializer_Name()
	{
        return (EAttribute)getSerializer().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSerializer_Description()
	{
        return (EAttribute)getSerializer().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSerializer_ClassName()
	{
        return (EAttribute)getSerializer().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSerializer_Enabled()
	{
        return (EAttribute)getSerializer().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSerializer_IgnoreFile()
	{
        return (EReference)getSerializer().getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSerializer_Settings()
	{
        return (EReference)getSerializer().getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIgnoreFile()
	{
		if (ignoreFileEClass == null)
		{
			ignoreFileEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(16);
		}
		return ignoreFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIgnoreFile_Name()
	{
        return (EAttribute)getIgnoreFile().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIgnoreFile_Data()
	{
        return (EAttribute)getIgnoreFile().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIgnoreFile_Serializers()
	{
        return (EReference)getIgnoreFile().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIgnoreFile_Settings()
	{
        return (EReference)getIgnoreFile().getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUserType()
	{
		if (userTypeEEnum == null)
		{
			userTypeEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(0);
		}
		return userTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCheckinState()
	{
		if (checkinStateEEnum == null)
		{
			checkinStateEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(1);
		}
		return checkinStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSIPrefix()
	{
		if (siPrefixEEnum == null)
		{
			siPrefixEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(2);
		}
		return siPrefixEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getObjectState()
	{
		if (objectStateEEnum == null)
		{
			objectStateEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(StorePackage.eNS_URI).getEClassifiers().get(3);
		}
		return objectStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoreFactory getStoreFactory()
	{
		return (StoreFactory)getEFactoryInstance();
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
	public void loadPackage()
	{
		if (isLoaded) return;
		isLoaded = true;

		URL url = getClass().getResource(packageFilename);
		if (url == null)
		{
			throw new RuntimeException("Missing serialized package: " + packageFilename);
		}
		URI uri = URI.createURI(url.toString());
		Resource resource = new EcoreResourceFactoryImpl().createResource(uri);
		try
		{
			resource.load(null);
		}
		catch (IOException exception)
		{
			throw new WrappedException(exception);
		}
		initializeFromLoadedEPackage(this, (EPackage)resource.getContents().get(0));
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
	public void fixPackageContents()
	{
		if (isFixed) return;
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
	protected void fixInstanceClass(EClassifier eClassifier)
	{
		if (eClassifier.getInstanceClassName() == null)
		{
			eClassifier.setInstanceClassName("org.bimserver.models.store." + eClassifier.getName());
			setGeneratedClassName(eClassifier);
		}
	}

} //StorePackageImpl
