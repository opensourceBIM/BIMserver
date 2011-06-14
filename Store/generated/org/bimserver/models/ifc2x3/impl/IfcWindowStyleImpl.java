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
import org.bimserver.models.ifc2x3.IfcWindowStyle;
import org.bimserver.models.ifc2x3.IfcWindowStyleConstructionEnum;
import org.bimserver.models.ifc2x3.IfcWindowStyleOperationEnum;
import org.bimserver.models.ifc2x3.Tristate;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Window Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowStyleImpl#getConstructionType <em>Construction Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowStyleImpl#getOperationType <em>Operation Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowStyleImpl#getParameterTakesPrecedence <em>Parameter Takes Precedence</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcWindowStyleImpl#getSizeable <em>Sizeable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcWindowStyleImpl extends IfcTypeProductImpl implements IfcWindowStyle
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcWindowStyleImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcWindowStyle();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWindowStyleConstructionEnum getConstructionType()
	{
		return (IfcWindowStyleConstructionEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcWindowStyle_ConstructionType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstructionType(IfcWindowStyleConstructionEnum newConstructionType)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWindowStyle_ConstructionType(), newConstructionType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWindowStyleOperationEnum getOperationType()
	{
		return (IfcWindowStyleOperationEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcWindowStyle_OperationType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationType(IfcWindowStyleOperationEnum newOperationType)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWindowStyle_OperationType(), newOperationType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getParameterTakesPrecedence()
	{
		return (Tristate)eGet(Ifc2x3Package.eINSTANCE.getIfcWindowStyle_ParameterTakesPrecedence(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterTakesPrecedence(Tristate newParameterTakesPrecedence)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWindowStyle_ParameterTakesPrecedence(), newParameterTakesPrecedence);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getSizeable()
	{
		return (Tristate)eGet(Ifc2x3Package.eINSTANCE.getIfcWindowStyle_Sizeable(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSizeable(Tristate newSizeable)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcWindowStyle_Sizeable(), newSizeable);
	}

} //IfcWindowStyleImpl
