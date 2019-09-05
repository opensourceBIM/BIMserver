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
import org.bimserver.models.ifc4.IfcAnnotationFillArea;
import org.bimserver.models.ifc4.IfcCurve;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Annotation Fill Area</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAnnotationFillAreaImpl#getOuterBoundary <em>Outer Boundary</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcAnnotationFillAreaImpl#getInnerBoundaries <em>Inner Boundaries</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcAnnotationFillAreaImpl extends IfcGeometricRepresentationItemImpl implements IfcAnnotationFillArea {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcAnnotationFillAreaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_ANNOTATION_FILL_AREA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCurve getOuterBoundary() {
		return (IfcCurve) eGet(Ifc4Package.Literals.IFC_ANNOTATION_FILL_AREA__OUTER_BOUNDARY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOuterBoundary(IfcCurve newOuterBoundary) {
		eSet(Ifc4Package.Literals.IFC_ANNOTATION_FILL_AREA__OUTER_BOUNDARY, newOuterBoundary);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcCurve> getInnerBoundaries() {
		return (EList<IfcCurve>) eGet(Ifc4Package.Literals.IFC_ANNOTATION_FILL_AREA__INNER_BOUNDARIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetInnerBoundaries() {
		eUnset(Ifc4Package.Literals.IFC_ANNOTATION_FILL_AREA__INNER_BOUNDARIES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetInnerBoundaries() {
		return eIsSet(Ifc4Package.Literals.IFC_ANNOTATION_FILL_AREA__INNER_BOUNDARIES);
	}

} //IfcAnnotationFillAreaImpl
