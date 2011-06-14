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
import org.bimserver.models.ifc2x3.IfcInternalOrExternalEnum;
import org.bimserver.models.ifc2x3.IfcRelCoversSpaces;
import org.bimserver.models.ifc2x3.IfcRelSpaceBoundary;
import org.bimserver.models.ifc2x3.IfcSpace;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Space</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpaceImpl#getInteriorOrExteriorSpace <em>Interior Or Exterior Space</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpaceImpl#getElevationWithFlooring <em>Elevation With Flooring</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpaceImpl#getElevationWithFlooringAsString <em>Elevation With Flooring As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpaceImpl#getHasCoverings <em>Has Coverings</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpaceImpl#getBoundedBy <em>Bounded By</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcSpaceImpl extends IfcSpatialStructureElementImpl implements IfcSpace
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSpaceImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcSpace();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcInternalOrExternalEnum getInteriorOrExteriorSpace()
	{
		return (IfcInternalOrExternalEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcSpace_InteriorOrExteriorSpace(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInteriorOrExteriorSpace(IfcInternalOrExternalEnum newInteriorOrExteriorSpace)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcSpace_InteriorOrExteriorSpace(), newInteriorOrExteriorSpace);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getElevationWithFlooring()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcSpace_ElevationWithFlooring(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElevationWithFlooring(float newElevationWithFlooring)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcSpace_ElevationWithFlooring(), newElevationWithFlooring);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetElevationWithFlooring()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSpace_ElevationWithFlooring());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetElevationWithFlooring()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSpace_ElevationWithFlooring());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getElevationWithFlooringAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcSpace_ElevationWithFlooringAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElevationWithFlooringAsString(String newElevationWithFlooringAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcSpace_ElevationWithFlooringAsString(), newElevationWithFlooringAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetElevationWithFlooringAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSpace_ElevationWithFlooringAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetElevationWithFlooringAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSpace_ElevationWithFlooringAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelCoversSpaces> getHasCoverings()
	{
		return (EList<IfcRelCoversSpaces>)eGet(Ifc2x3Package.eINSTANCE.getIfcSpace_HasCoverings(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelSpaceBoundary> getBoundedBy()
	{
		return (EList<IfcRelSpaceBoundary>)eGet(Ifc2x3Package.eINSTANCE.getIfcSpace_BoundedBy(), true);
	}

} //IfcSpaceImpl
