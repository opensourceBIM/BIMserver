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
import org.bimserver.models.ifc2x3.IfcPresentationLayerWithStyle;
import org.bimserver.models.ifc2x3.IfcPresentationStyleSelect;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Presentation Layer With Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPresentationLayerWithStyleImpl#isLayerOn <em>Layer On</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPresentationLayerWithStyleImpl#isLayerFrozen <em>Layer Frozen</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPresentationLayerWithStyleImpl#isLayerBlocked <em>Layer Blocked</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPresentationLayerWithStyleImpl#getLayerStyles <em>Layer Styles</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcPresentationLayerWithStyleImpl extends IfcPresentationLayerAssignmentImpl implements IfcPresentationLayerWithStyle
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPresentationLayerWithStyleImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcPresentationLayerWithStyle();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLayerOn()
	{
		return (Boolean)eGet(Ifc2x3Package.eINSTANCE.getIfcPresentationLayerWithStyle_LayerOn(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayerOn(boolean newLayerOn)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPresentationLayerWithStyle_LayerOn(), newLayerOn);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLayerFrozen()
	{
		return (Boolean)eGet(Ifc2x3Package.eINSTANCE.getIfcPresentationLayerWithStyle_LayerFrozen(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayerFrozen(boolean newLayerFrozen)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPresentationLayerWithStyle_LayerFrozen(), newLayerFrozen);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLayerBlocked()
	{
		return (Boolean)eGet(Ifc2x3Package.eINSTANCE.getIfcPresentationLayerWithStyle_LayerBlocked(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayerBlocked(boolean newLayerBlocked)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPresentationLayerWithStyle_LayerBlocked(), newLayerBlocked);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcPresentationStyleSelect> getLayerStyles()
	{
		return (EList<IfcPresentationStyleSelect>)eGet(Ifc2x3Package.eINSTANCE.getIfcPresentationLayerWithStyle_LayerStyles(), true);
	}

} //IfcPresentationLayerWithStyleImpl
