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
import org.bimserver.models.ifc2x3.IfcPropertyTableValue;
import org.bimserver.models.ifc2x3.IfcUnit;
import org.bimserver.models.ifc2x3.IfcValue;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Property Table Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPropertyTableValueImpl#getDefiningValues <em>Defining Values</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPropertyTableValueImpl#getDefinedValues <em>Defined Values</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPropertyTableValueImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPropertyTableValueImpl#getDefiningUnit <em>Defining Unit</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPropertyTableValueImpl#getDefinedUnit <em>Defined Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcPropertyTableValueImpl extends IfcSimplePropertyImpl implements IfcPropertyTableValue
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPropertyTableValueImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcPropertyTableValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcValue> getDefiningValues()
	{
		return (EList<IfcValue>)eGet(Ifc2x3Package.eINSTANCE.getIfcPropertyTableValue_DefiningValues(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcValue> getDefinedValues()
	{
		return (EList<IfcValue>)eGet(Ifc2x3Package.eINSTANCE.getIfcPropertyTableValue_DefinedValues(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpression()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcPropertyTableValue_Expression(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpression(String newExpression)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPropertyTableValue_Expression(), newExpression);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetExpression()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPropertyTableValue_Expression());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetExpression()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPropertyTableValue_Expression());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcUnit getDefiningUnit()
	{
		return (IfcUnit)eGet(Ifc2x3Package.eINSTANCE.getIfcPropertyTableValue_DefiningUnit(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefiningUnit(IfcUnit newDefiningUnit)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPropertyTableValue_DefiningUnit(), newDefiningUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDefiningUnit()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPropertyTableValue_DefiningUnit());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDefiningUnit()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPropertyTableValue_DefiningUnit());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcUnit getDefinedUnit()
	{
		return (IfcUnit)eGet(Ifc2x3Package.eINSTANCE.getIfcPropertyTableValue_DefinedUnit(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinedUnit(IfcUnit newDefinedUnit)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPropertyTableValue_DefinedUnit(), newDefinedUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDefinedUnit()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPropertyTableValue_DefinedUnit());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDefinedUnit()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPropertyTableValue_DefinedUnit());
	}

} //IfcPropertyTableValueImpl
