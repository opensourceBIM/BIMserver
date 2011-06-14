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
		return Ifc2x3Package.eINSTANCE.getIfcRelFlowControlElements();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDistributionControlElement> getRelatedControlElements()
	{
		return (EList<IfcDistributionControlElement>)eGet(Ifc2x3Package.eINSTANCE.getIfcRelFlowControlElements_RelatedControlElements(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDistributionFlowElement getRelatingFlowElement()
	{
		return (IfcDistributionFlowElement)eGet(Ifc2x3Package.eINSTANCE.getIfcRelFlowControlElements_RelatingFlowElement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingFlowElement(IfcDistributionFlowElement newRelatingFlowElement)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelFlowControlElements_RelatingFlowElement(), newRelatingFlowElement);
	}

} //IfcRelFlowControlElementsImpl
