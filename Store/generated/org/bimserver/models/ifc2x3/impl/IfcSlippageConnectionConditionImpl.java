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
import org.bimserver.models.ifc2x3.IfcSlippageConnectionCondition;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Slippage Connection Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSlippageConnectionConditionImpl#getSlippageX <em>Slippage X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSlippageConnectionConditionImpl#getSlippageXAsString <em>Slippage XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSlippageConnectionConditionImpl#getSlippageY <em>Slippage Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSlippageConnectionConditionImpl#getSlippageYAsString <em>Slippage YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSlippageConnectionConditionImpl#getSlippageZ <em>Slippage Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSlippageConnectionConditionImpl#getSlippageZAsString <em>Slippage ZAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcSlippageConnectionConditionImpl extends IfcStructuralConnectionConditionImpl implements IfcSlippageConnectionCondition
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSlippageConnectionConditionImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcSlippageConnectionCondition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSlippageX()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcSlippageConnectionCondition_SlippageX(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSlippageX(float newSlippageX)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcSlippageConnectionCondition_SlippageX(), newSlippageX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSlippageX()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSlippageConnectionCondition_SlippageX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSlippageX()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSlippageConnectionCondition_SlippageX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSlippageXAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcSlippageConnectionCondition_SlippageXAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSlippageXAsString(String newSlippageXAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcSlippageConnectionCondition_SlippageXAsString(), newSlippageXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSlippageXAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSlippageConnectionCondition_SlippageXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSlippageXAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSlippageConnectionCondition_SlippageXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSlippageY()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcSlippageConnectionCondition_SlippageY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSlippageY(float newSlippageY)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcSlippageConnectionCondition_SlippageY(), newSlippageY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSlippageY()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSlippageConnectionCondition_SlippageY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSlippageY()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSlippageConnectionCondition_SlippageY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSlippageYAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcSlippageConnectionCondition_SlippageYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSlippageYAsString(String newSlippageYAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcSlippageConnectionCondition_SlippageYAsString(), newSlippageYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSlippageYAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSlippageConnectionCondition_SlippageYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSlippageYAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSlippageConnectionCondition_SlippageYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSlippageZ()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcSlippageConnectionCondition_SlippageZ(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSlippageZ(float newSlippageZ)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcSlippageConnectionCondition_SlippageZ(), newSlippageZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSlippageZ()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSlippageConnectionCondition_SlippageZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSlippageZ()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSlippageConnectionCondition_SlippageZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSlippageZAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcSlippageConnectionCondition_SlippageZAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSlippageZAsString(String newSlippageZAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcSlippageConnectionCondition_SlippageZAsString(), newSlippageZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSlippageZAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSlippageConnectionCondition_SlippageZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSlippageZAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSlippageConnectionCondition_SlippageZAsString());
	}

} //IfcSlippageConnectionConditionImpl
