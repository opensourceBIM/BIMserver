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
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcDraughtingCallout;
import org.bimserver.models.ifc2x3.IfcDraughtingCalloutElement;
import org.bimserver.models.ifc2x3.IfcDraughtingCalloutRelationship;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Draughting Callout</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDraughtingCalloutImpl#getContents <em>Contents</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDraughtingCalloutImpl#getIsRelatedFromCallout <em>Is Related From Callout</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDraughtingCalloutImpl#getIsRelatedToCallout <em>Is Related To Callout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcDraughtingCalloutImpl extends IfcGeometricRepresentationItemImpl implements IfcDraughtingCallout
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDraughtingCalloutImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return Ifc2x3Package.eINSTANCE.getIfcDraughtingCallout();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDraughtingCalloutElement> getContents()
	{
		return (EList<IfcDraughtingCalloutElement>)eGet(Ifc2x3Package.eINSTANCE.getIfcDraughtingCallout_Contents(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDraughtingCalloutRelationship> getIsRelatedFromCallout()
	{
		return (EList<IfcDraughtingCalloutRelationship>)eGet(Ifc2x3Package.eINSTANCE.getIfcDraughtingCallout_IsRelatedFromCallout(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDraughtingCalloutRelationship> getIsRelatedToCallout()
	{
		return (EList<IfcDraughtingCalloutRelationship>)eGet(Ifc2x3Package.eINSTANCE.getIfcDraughtingCallout_IsRelatedToCallout(), true);
	}

} //IfcDraughtingCalloutImpl
