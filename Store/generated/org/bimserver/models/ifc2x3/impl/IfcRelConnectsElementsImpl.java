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
import org.bimserver.models.ifc2x3.IfcConnectionGeometry;
import org.bimserver.models.ifc2x3.IfcElement;
import org.bimserver.models.ifc2x3.IfcRelConnectsElements;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Connects Elements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsElementsImpl#getConnectionGeometry <em>Connection Geometry</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsElementsImpl#getRelatingElement <em>Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsElementsImpl#getRelatedElement <em>Related Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelConnectsElementsImpl extends IfcRelConnectsImpl implements IfcRelConnectsElements
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelConnectsElementsImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcRelConnectsElements();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConnectionGeometry getConnectionGeometry()
	{
		return (IfcConnectionGeometry)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsElements_ConnectionGeometry(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionGeometry(IfcConnectionGeometry newConnectionGeometry)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsElements_ConnectionGeometry(), newConnectionGeometry);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetConnectionGeometry()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRelConnectsElements_ConnectionGeometry());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetConnectionGeometry()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsElements_ConnectionGeometry());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElement getRelatingElement()
	{
		return (IfcElement)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsElements_RelatingElement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingElement(IfcElement newRelatingElement)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsElements_RelatingElement(), newRelatingElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElement getRelatedElement()
	{
		return (IfcElement)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsElements_RelatedElement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatedElement(IfcElement newRelatedElement)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsElements_RelatedElement(), newRelatedElement);
	}

} //IfcRelConnectsElementsImpl
