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
import org.bimserver.models.ifc2x3.IfcBoundaryEdgeCondition;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Boundary Edge Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundaryEdgeConditionImpl#getLinearStiffnessByLengthX <em>Linear Stiffness By Length X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundaryEdgeConditionImpl#getLinearStiffnessByLengthXAsString <em>Linear Stiffness By Length XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundaryEdgeConditionImpl#getLinearStiffnessByLengthY <em>Linear Stiffness By Length Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundaryEdgeConditionImpl#getLinearStiffnessByLengthYAsString <em>Linear Stiffness By Length YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundaryEdgeConditionImpl#getLinearStiffnessByLengthZ <em>Linear Stiffness By Length Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundaryEdgeConditionImpl#getLinearStiffnessByLengthZAsString <em>Linear Stiffness By Length ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundaryEdgeConditionImpl#getRotationalStiffnessByLengthX <em>Rotational Stiffness By Length X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundaryEdgeConditionImpl#getRotationalStiffnessByLengthXAsString <em>Rotational Stiffness By Length XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundaryEdgeConditionImpl#getRotationalStiffnessByLengthY <em>Rotational Stiffness By Length Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundaryEdgeConditionImpl#getRotationalStiffnessByLengthYAsString <em>Rotational Stiffness By Length YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundaryEdgeConditionImpl#getRotationalStiffnessByLengthZ <em>Rotational Stiffness By Length Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBoundaryEdgeConditionImpl#getRotationalStiffnessByLengthZAsString <em>Rotational Stiffness By Length ZAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcBoundaryEdgeConditionImpl extends IfcBoundaryConditionImpl implements IfcBoundaryEdgeCondition
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcBoundaryEdgeConditionImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLinearStiffnessByLengthX()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_LinearStiffnessByLengthX(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessByLengthX(float newLinearStiffnessByLengthX)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_LinearStiffnessByLengthX(), newLinearStiffnessByLengthX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessByLengthX()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_LinearStiffnessByLengthX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessByLengthX()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_LinearStiffnessByLengthX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinearStiffnessByLengthXAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_LinearStiffnessByLengthXAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessByLengthXAsString(String newLinearStiffnessByLengthXAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_LinearStiffnessByLengthXAsString(), newLinearStiffnessByLengthXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessByLengthXAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_LinearStiffnessByLengthXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessByLengthXAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_LinearStiffnessByLengthXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLinearStiffnessByLengthY()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_LinearStiffnessByLengthY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessByLengthY(float newLinearStiffnessByLengthY)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_LinearStiffnessByLengthY(), newLinearStiffnessByLengthY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessByLengthY()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_LinearStiffnessByLengthY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessByLengthY()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_LinearStiffnessByLengthY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinearStiffnessByLengthYAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_LinearStiffnessByLengthYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessByLengthYAsString(String newLinearStiffnessByLengthYAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_LinearStiffnessByLengthYAsString(), newLinearStiffnessByLengthYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessByLengthYAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_LinearStiffnessByLengthYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessByLengthYAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_LinearStiffnessByLengthYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLinearStiffnessByLengthZ()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_LinearStiffnessByLengthZ(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessByLengthZ(float newLinearStiffnessByLengthZ)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_LinearStiffnessByLengthZ(), newLinearStiffnessByLengthZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessByLengthZ()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_LinearStiffnessByLengthZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessByLengthZ()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_LinearStiffnessByLengthZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinearStiffnessByLengthZAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_LinearStiffnessByLengthZAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearStiffnessByLengthZAsString(String newLinearStiffnessByLengthZAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_LinearStiffnessByLengthZAsString(), newLinearStiffnessByLengthZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearStiffnessByLengthZAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_LinearStiffnessByLengthZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearStiffnessByLengthZAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_LinearStiffnessByLengthZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRotationalStiffnessByLengthX()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthX(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalStiffnessByLengthX(float newRotationalStiffnessByLengthX)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthX(), newRotationalStiffnessByLengthX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalStiffnessByLengthX()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalStiffnessByLengthX()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRotationalStiffnessByLengthXAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthXAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalStiffnessByLengthXAsString(String newRotationalStiffnessByLengthXAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthXAsString(), newRotationalStiffnessByLengthXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalStiffnessByLengthXAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalStiffnessByLengthXAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRotationalStiffnessByLengthY()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalStiffnessByLengthY(float newRotationalStiffnessByLengthY)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthY(), newRotationalStiffnessByLengthY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalStiffnessByLengthY()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalStiffnessByLengthY()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRotationalStiffnessByLengthYAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalStiffnessByLengthYAsString(String newRotationalStiffnessByLengthYAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthYAsString(), newRotationalStiffnessByLengthYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalStiffnessByLengthYAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalStiffnessByLengthYAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRotationalStiffnessByLengthZ()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthZ(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalStiffnessByLengthZ(float newRotationalStiffnessByLengthZ)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthZ(), newRotationalStiffnessByLengthZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalStiffnessByLengthZ()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalStiffnessByLengthZ()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRotationalStiffnessByLengthZAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthZAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalStiffnessByLengthZAsString(String newRotationalStiffnessByLengthZAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthZAsString(), newRotationalStiffnessByLengthZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalStiffnessByLengthZAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalStiffnessByLengthZAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBoundaryEdgeCondition_RotationalStiffnessByLengthZAsString());
	}

} //IfcBoundaryEdgeConditionImpl
