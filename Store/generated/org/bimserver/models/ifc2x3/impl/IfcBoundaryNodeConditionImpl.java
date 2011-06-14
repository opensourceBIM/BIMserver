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
import org.bimserver.models.ifc2x3.IfcBoundaryNodeCondition;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Boundary Node Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundaryNodeConditionImpl#getLinearStiffnessX <em>Linear Stiffness X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundaryNodeConditionImpl#getLinearStiffnessXAsString <em>Linear Stiffness XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundaryNodeConditionImpl#getLinearStiffnessY <em>Linear Stiffness Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundaryNodeConditionImpl#getLinearStiffnessYAsString <em>Linear Stiffness YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundaryNodeConditionImpl#getLinearStiffnessZ <em>Linear Stiffness Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundaryNodeConditionImpl#getLinearStiffnessZAsString <em>Linear Stiffness ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundaryNodeConditionImpl#getRotationalStiffnessX <em>Rotational Stiffness X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundaryNodeConditionImpl#getRotationalStiffnessXAsString <em>Rotational Stiffness XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundaryNodeConditionImpl#getRotationalStiffnessY <em>Rotational Stiffness Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundaryNodeConditionImpl#getRotationalStiffnessYAsString <em>Rotational Stiffness YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundaryNodeConditionImpl#getRotationalStiffnessZ <em>Rotational Stiffness Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundaryNodeConditionImpl#getRotationalStiffnessZAsString <em>Rotational Stiffness ZAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcBoundaryNodeConditionImpl extends IfcBoundaryConditionImpl implements IfcBoundaryNodeCondition
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcBoundaryNodeConditionImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLinearStiffnessX()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_LinearStiffnessX(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessX(float newLinearStiffnessX)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_LinearStiffnessX(), newLinearStiffnessX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessX()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_LinearStiffnessX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessX()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_LinearStiffnessX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinearStiffnessXAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_LinearStiffnessXAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessXAsString(String newLinearStiffnessXAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_LinearStiffnessXAsString(), newLinearStiffnessXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessXAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_LinearStiffnessXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessXAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_LinearStiffnessXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLinearStiffnessY()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_LinearStiffnessY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessY(float newLinearStiffnessY)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_LinearStiffnessY(), newLinearStiffnessY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessY()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_LinearStiffnessY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessY()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_LinearStiffnessY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinearStiffnessYAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_LinearStiffnessYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessYAsString(String newLinearStiffnessYAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_LinearStiffnessYAsString(), newLinearStiffnessYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessYAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_LinearStiffnessYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessYAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_LinearStiffnessYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLinearStiffnessZ()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_LinearStiffnessZ(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessZ(float newLinearStiffnessZ)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_LinearStiffnessZ(), newLinearStiffnessZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessZ()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_LinearStiffnessZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessZ()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_LinearStiffnessZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinearStiffnessZAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_LinearStiffnessZAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessZAsString(String newLinearStiffnessZAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_LinearStiffnessZAsString(), newLinearStiffnessZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessZAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_LinearStiffnessZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessZAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_LinearStiffnessZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRotationalStiffnessX()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessX(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalStiffnessX(float newRotationalStiffnessX)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessX(), newRotationalStiffnessX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalStiffnessX()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalStiffnessX()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRotationalStiffnessXAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessXAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalStiffnessXAsString(String newRotationalStiffnessXAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessXAsString(), newRotationalStiffnessXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalStiffnessXAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalStiffnessXAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRotationalStiffnessY()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalStiffnessY(float newRotationalStiffnessY)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessY(), newRotationalStiffnessY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalStiffnessY()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalStiffnessY()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRotationalStiffnessYAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalStiffnessYAsString(String newRotationalStiffnessYAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessYAsString(), newRotationalStiffnessYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalStiffnessYAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalStiffnessYAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRotationalStiffnessZ()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessZ(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalStiffnessZ(float newRotationalStiffnessZ)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessZ(), newRotationalStiffnessZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalStiffnessZ()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalStiffnessZ()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRotationalStiffnessZAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessZAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalStiffnessZAsString(String newRotationalStiffnessZAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessZAsString(), newRotationalStiffnessZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalStiffnessZAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalStiffnessZAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryNodeCondition_RotationalStiffnessZAsString());
	}

} //IfcBoundaryNodeConditionImpl
