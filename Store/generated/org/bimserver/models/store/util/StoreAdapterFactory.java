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
package org.bimserver.models.store.util;

import org.bimserver.models.store.Checkout;
import org.bimserver.models.store.Clash;
import org.bimserver.models.store.ClashDetectionSettings;
import org.bimserver.models.store.ConcreteRevision;
import org.bimserver.models.store.EidClash;
import org.bimserver.models.store.GeoTag;
import org.bimserver.models.store.GuidClash;
import org.bimserver.models.store.IfcEngine;
import org.bimserver.models.store.IgnoreFile;
import org.bimserver.models.store.Project;
import org.bimserver.models.store.Revision;
import org.bimserver.models.store.Serializer;
import org.bimserver.models.store.Settings;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.store.StorePackage
 * @generated
 */
public class StoreAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StorePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StoreAdapterFactory()
	{
		if (modelPackage == null) {
			modelPackage = StorePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object)
	{
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StoreSwitch<Adapter> modelSwitch =
		new StoreSwitch<Adapter>() {
			@Override
			public Adapter caseProject(Project object) {
				return createProjectAdapter();
			}
			@Override
			public Adapter caseUser(User object) {
				return createUserAdapter();
			}
			@Override
			public Adapter caseClash(Clash object) {
				return createClashAdapter();
			}
			@Override
			public Adapter caseEidClash(EidClash object) {
				return createEidClashAdapter();
			}
			@Override
			public Adapter caseGuidClash(GuidClash object) {
				return createGuidClashAdapter();
			}
			@Override
			public Adapter caseClashDetectionSettings(ClashDetectionSettings object) {
				return createClashDetectionSettingsAdapter();
			}
			@Override
			public Adapter caseRevision(Revision object) {
				return createRevisionAdapter();
			}
			@Override
			public Adapter caseConcreteRevision(ConcreteRevision object) {
				return createConcreteRevisionAdapter();
			}
			@Override
			public Adapter caseGeoTag(GeoTag object) {
				return createGeoTagAdapter();
			}
			@Override
			public Adapter caseCheckout(Checkout object) {
				return createCheckoutAdapter();
			}
			@Override
			public Adapter caseSettings(Settings object) {
				return createSettingsAdapter();
			}
			@Override
			public Adapter caseSerializer(Serializer object) {
				return createSerializerAdapter();
			}
			@Override
			public Adapter caseIgnoreFile(IgnoreFile object) {
				return createIgnoreFileAdapter();
			}
			@Override
			public Adapter caseIfcEngine(IfcEngine object) {
				return createIfcEngineAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target)
	{
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.Project
	 * @generated
	 */
	public Adapter createProjectAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.User
	 * @generated
	 */
	public Adapter createUserAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.Clash <em>Clash</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.Clash
	 * @generated
	 */
	public Adapter createClashAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.EidClash <em>Eid Clash</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.EidClash
	 * @generated
	 */
	public Adapter createEidClashAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.GuidClash <em>Guid Clash</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.GuidClash
	 * @generated
	 */
	public Adapter createGuidClashAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ClashDetectionSettings <em>Clash Detection Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ClashDetectionSettings
	 * @generated
	 */
	public Adapter createClashDetectionSettingsAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.Revision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.Revision
	 * @generated
	 */
	public Adapter createRevisionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.ConcreteRevision <em>Concrete Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.ConcreteRevision
	 * @generated
	 */
	public Adapter createConcreteRevisionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.GeoTag <em>Geo Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.GeoTag
	 * @generated
	 */
	public Adapter createGeoTagAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.Checkout <em>Checkout</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.Checkout
	 * @generated
	 */
	public Adapter createCheckoutAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.Settings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.Settings
	 * @generated
	 */
	public Adapter createSettingsAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.Serializer <em>Serializer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.Serializer
	 * @generated
	 */
	public Adapter createSerializerAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.IgnoreFile <em>Ignore File</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.IgnoreFile
	 * @generated
	 */
	public Adapter createIgnoreFileAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.bimserver.models.store.IfcEngine <em>Ifc Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.bimserver.models.store.IfcEngine
	 * @generated
	 */
	public Adapter createIfcEngineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter()
	{
		return null;
	}

} //StoreAdapterFactory
