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
package org.bimserver.models.ifc4.impl;

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

import org.bimserver.models.ifc4.Ifc4Package;
import org.bimserver.models.ifc4.IfcFillAreaStyle;
import org.bimserver.models.ifc4.IfcFillStyleSelect;
import org.bimserver.models.ifc4.Tristate;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Fill Area Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcFillAreaStyleImpl#getFillStyles <em>Fill Styles</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcFillAreaStyleImpl#getModelorDraughting <em>Modelor Draughting</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcFillAreaStyleImpl extends IfcPresentationStyleImpl implements IfcFillAreaStyle {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcFillAreaStyleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_FILL_AREA_STYLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcFillStyleSelect> getFillStyles() {
		return (EList<IfcFillStyleSelect>) eGet(Ifc4Package.Literals.IFC_FILL_AREA_STYLE__FILL_STYLES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getModelorDraughting() {
		return (Tristate) eGet(Ifc4Package.Literals.IFC_FILL_AREA_STYLE__MODELOR_DRAUGHTING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModelorDraughting(Tristate newModelorDraughting) {
		eSet(Ifc4Package.Literals.IFC_FILL_AREA_STYLE__MODELOR_DRAUGHTING, newModelorDraughting);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetModelorDraughting() {
		eUnset(Ifc4Package.Literals.IFC_FILL_AREA_STYLE__MODELOR_DRAUGHTING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetModelorDraughting() {
		return eIsSet(Ifc4Package.Literals.IFC_FILL_AREA_STYLE__MODELOR_DRAUGHTING);
	}

} //IfcFillAreaStyleImpl
