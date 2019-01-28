/**
 * Copyright (C) 2009-2014 BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3tc1.impl;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcPresentationLayerWithStyle;
import org.bimserver.models.ifc2x3tc1.IfcPresentationStyleSelect;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Presentation Layer With Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcPresentationLayerWithStyleImpl#isLayerOn <em>Layer On</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcPresentationLayerWithStyleImpl#isLayerFrozen <em>Layer Frozen</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcPresentationLayerWithStyleImpl#isLayerBlocked <em>Layer Blocked</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcPresentationLayerWithStyleImpl#getLayerStyles <em>Layer Styles</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcPresentationLayerWithStyleImpl extends IfcPresentationLayerAssignmentImpl
		implements IfcPresentationLayerWithStyle {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPresentationLayerWithStyleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_PRESENTATION_LAYER_WITH_STYLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLayerOn() {
		return (Boolean) eGet(Ifc2x3tc1Package.Literals.IFC_PRESENTATION_LAYER_WITH_STYLE__LAYER_ON, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayerOn(boolean newLayerOn) {
		eSet(Ifc2x3tc1Package.Literals.IFC_PRESENTATION_LAYER_WITH_STYLE__LAYER_ON, newLayerOn);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLayerFrozen() {
		return (Boolean) eGet(Ifc2x3tc1Package.Literals.IFC_PRESENTATION_LAYER_WITH_STYLE__LAYER_FROZEN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayerFrozen(boolean newLayerFrozen) {
		eSet(Ifc2x3tc1Package.Literals.IFC_PRESENTATION_LAYER_WITH_STYLE__LAYER_FROZEN, newLayerFrozen);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLayerBlocked() {
		return (Boolean) eGet(Ifc2x3tc1Package.Literals.IFC_PRESENTATION_LAYER_WITH_STYLE__LAYER_BLOCKED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayerBlocked(boolean newLayerBlocked) {
		eSet(Ifc2x3tc1Package.Literals.IFC_PRESENTATION_LAYER_WITH_STYLE__LAYER_BLOCKED, newLayerBlocked);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcPresentationStyleSelect> getLayerStyles() {
		return (EList<IfcPresentationStyleSelect>) eGet(
				Ifc2x3tc1Package.Literals.IFC_PRESENTATION_LAYER_WITH_STYLE__LAYER_STYLES, true);
	}

} //IfcPresentationLayerWithStyleImpl
