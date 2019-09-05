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
import org.bimserver.models.ifc4.IfcTriangulatedFaceSet;
import org.bimserver.models.ifc4.ListOfELong;
import org.bimserver.models.ifc4.ListOfIfcParameterValue;
import org.bimserver.models.ifc4.Tristate;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Triangulated Face Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTriangulatedFaceSetImpl#getNormals <em>Normals</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTriangulatedFaceSetImpl#getClosed <em>Closed</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTriangulatedFaceSetImpl#getCoordIndex <em>Coord Index</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTriangulatedFaceSetImpl#getPnIndex <em>Pn Index</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.impl.IfcTriangulatedFaceSetImpl#getNumberOfTriangles <em>Number Of Triangles</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcTriangulatedFaceSetImpl extends IfcTessellatedFaceSetImpl implements IfcTriangulatedFaceSet {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTriangulatedFaceSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4Package.Literals.IFC_TRIANGULATED_FACE_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<ListOfIfcParameterValue> getNormals() {
		return (EList<ListOfIfcParameterValue>) eGet(Ifc4Package.Literals.IFC_TRIANGULATED_FACE_SET__NORMALS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getClosed() {
		return (Tristate) eGet(Ifc4Package.Literals.IFC_TRIANGULATED_FACE_SET__CLOSED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClosed(Tristate newClosed) {
		eSet(Ifc4Package.Literals.IFC_TRIANGULATED_FACE_SET__CLOSED, newClosed);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetClosed() {
		eUnset(Ifc4Package.Literals.IFC_TRIANGULATED_FACE_SET__CLOSED);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetClosed() {
		return eIsSet(Ifc4Package.Literals.IFC_TRIANGULATED_FACE_SET__CLOSED);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<ListOfELong> getCoordIndex() {
		return (EList<ListOfELong>) eGet(Ifc4Package.Literals.IFC_TRIANGULATED_FACE_SET__COORD_INDEX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Long> getPnIndex() {
		return (EList<Long>) eGet(Ifc4Package.Literals.IFC_TRIANGULATED_FACE_SET__PN_INDEX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPnIndex() {
		eUnset(Ifc4Package.Literals.IFC_TRIANGULATED_FACE_SET__PN_INDEX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPnIndex() {
		return eIsSet(Ifc4Package.Literals.IFC_TRIANGULATED_FACE_SET__PN_INDEX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getNumberOfTriangles() {
		return (Long) eGet(Ifc4Package.Literals.IFC_TRIANGULATED_FACE_SET__NUMBER_OF_TRIANGLES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNumberOfTriangles(long newNumberOfTriangles) {
		eSet(Ifc4Package.Literals.IFC_TRIANGULATED_FACE_SET__NUMBER_OF_TRIANGLES, newNumberOfTriangles);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetNumberOfTriangles() {
		eUnset(Ifc4Package.Literals.IFC_TRIANGULATED_FACE_SET__NUMBER_OF_TRIANGLES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetNumberOfTriangles() {
		return eIsSet(Ifc4Package.Literals.IFC_TRIANGULATED_FACE_SET__NUMBER_OF_TRIANGLES);
	}

} //IfcTriangulatedFaceSetImpl
