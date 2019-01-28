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
import org.bimserver.models.ifc2x3tc1.IfcAnnotationFillAreaOccurrence;
import org.bimserver.models.ifc2x3tc1.IfcGlobalOrLocalEnum;
import org.bimserver.models.ifc2x3tc1.IfcPoint;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Annotation Fill Area Occurrence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAnnotationFillAreaOccurrenceImpl#getFillStyleTarget <em>Fill Style Target</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcAnnotationFillAreaOccurrenceImpl#getGlobalOrLocal <em>Global Or Local</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcAnnotationFillAreaOccurrenceImpl extends IfcAnnotationOccurrenceImpl
		implements IfcAnnotationFillAreaOccurrence {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcAnnotationFillAreaOccurrenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_ANNOTATION_FILL_AREA_OCCURRENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPoint getFillStyleTarget() {
		return (IfcPoint) eGet(Ifc2x3tc1Package.Literals.IFC_ANNOTATION_FILL_AREA_OCCURRENCE__FILL_STYLE_TARGET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFillStyleTarget(IfcPoint newFillStyleTarget) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ANNOTATION_FILL_AREA_OCCURRENCE__FILL_STYLE_TARGET, newFillStyleTarget);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFillStyleTarget() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ANNOTATION_FILL_AREA_OCCURRENCE__FILL_STYLE_TARGET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFillStyleTarget() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ANNOTATION_FILL_AREA_OCCURRENCE__FILL_STYLE_TARGET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGlobalOrLocalEnum getGlobalOrLocal() {
		return (IfcGlobalOrLocalEnum) eGet(
				Ifc2x3tc1Package.Literals.IFC_ANNOTATION_FILL_AREA_OCCURRENCE__GLOBAL_OR_LOCAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGlobalOrLocal(IfcGlobalOrLocalEnum newGlobalOrLocal) {
		eSet(Ifc2x3tc1Package.Literals.IFC_ANNOTATION_FILL_AREA_OCCURRENCE__GLOBAL_OR_LOCAL, newGlobalOrLocal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetGlobalOrLocal() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_ANNOTATION_FILL_AREA_OCCURRENCE__GLOBAL_OR_LOCAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetGlobalOrLocal() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_ANNOTATION_FILL_AREA_OCCURRENCE__GLOBAL_OR_LOCAL);
	}

} //IfcAnnotationFillAreaOccurrenceImpl
