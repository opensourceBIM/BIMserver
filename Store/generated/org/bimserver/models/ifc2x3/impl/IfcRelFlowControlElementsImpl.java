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
import org.bimserver.models.ifc2x3.IfcDistributionControlElement;
import org.bimserver.models.ifc2x3.IfcDistributionFlowElement;
import org.bimserver.models.ifc2x3.IfcRelFlowControlElements;

import org.bimserver.models.ifc2x3.impl.IfcRelConnectsImpl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Flow Control Elements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelFlowControlElementsImpl#getRelatedControlElements <em>Related Control Elements</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelFlowControlElementsImpl#getRelatingFlowElement <em>Relating Flow Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelFlowControlElementsImpl extends IfcRelConnectsImpl implements IfcRelFlowControlElements
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
	protected IfcRelFlowControlElementsImpl()
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
		return Ifc2x3Package.Literals.IFC_REL_FLOW_CONTROL_ELEMENTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDistributionControlElement> getRelatedControlElements()
	{
		return (EList<IfcDistributionControlElement>)eGet(Ifc2x3Package.Literals.IFC_REL_FLOW_CONTROL_ELEMENTS__RELATED_CONTROL_ELEMENTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDistributionFlowElement getRelatingFlowElement()
	{
		return (IfcDistributionFlowElement)eGet(Ifc2x3Package.Literals.IFC_REL_FLOW_CONTROL_ELEMENTS__RELATING_FLOW_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingFlowElement(IfcDistributionFlowElement newRelatingFlowElement)
	{
		eSet(Ifc2x3Package.Literals.IFC_REL_FLOW_CONTROL_ELEMENTS__RELATING_FLOW_ELEMENT, newRelatingFlowElement);
	}

} //IfcRelFlowControlElementsImpl
