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
package org.bimserver.models.ifc4x3.impl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcAlignmentCantSegment;
import org.bimserver.models.ifc4x3.IfcAlignmentCantSegmentTypeEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Alignment Cant Segment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentCantSegmentImpl#getStartDistAlong <em>Start Dist Along</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentCantSegmentImpl#getStartDistAlongAsString <em>Start Dist Along As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentCantSegmentImpl#getHorizontalLength <em>Horizontal Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentCantSegmentImpl#getHorizontalLengthAsString <em>Horizontal Length As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentCantSegmentImpl#getStartCantLeft <em>Start Cant Left</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentCantSegmentImpl#getStartCantLeftAsString <em>Start Cant Left As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentCantSegmentImpl#getEndCantLeft <em>End Cant Left</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentCantSegmentImpl#getEndCantLeftAsString <em>End Cant Left As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentCantSegmentImpl#getStartCantRight <em>Start Cant Right</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentCantSegmentImpl#getStartCantRightAsString <em>Start Cant Right As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentCantSegmentImpl#getEndCantRight <em>End Cant Right</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentCantSegmentImpl#getEndCantRightAsString <em>End Cant Right As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentCantSegmentImpl#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcAlignmentCantSegmentImpl extends IfcAlignmentParameterSegmentImpl implements IfcAlignmentCantSegment {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcAlignmentCantSegmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getStartDistAlong() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__START_DIST_ALONG, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartDistAlong(double newStartDistAlong) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__START_DIST_ALONG, newStartDistAlong);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStartDistAlongAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__START_DIST_ALONG_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartDistAlongAsString(String newStartDistAlongAsString) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__START_DIST_ALONG_AS_STRING, newStartDistAlongAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getHorizontalLength() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__HORIZONTAL_LENGTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHorizontalLength(double newHorizontalLength) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__HORIZONTAL_LENGTH, newHorizontalLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getHorizontalLengthAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__HORIZONTAL_LENGTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHorizontalLengthAsString(String newHorizontalLengthAsString) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__HORIZONTAL_LENGTH_AS_STRING,
				newHorizontalLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getStartCantLeft() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__START_CANT_LEFT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartCantLeft(double newStartCantLeft) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__START_CANT_LEFT, newStartCantLeft);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStartCantLeftAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__START_CANT_LEFT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartCantLeftAsString(String newStartCantLeftAsString) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__START_CANT_LEFT_AS_STRING, newStartCantLeftAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getEndCantLeft() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__END_CANT_LEFT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEndCantLeft(double newEndCantLeft) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__END_CANT_LEFT, newEndCantLeft);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEndCantLeft() {
		eUnset(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__END_CANT_LEFT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEndCantLeft() {
		return eIsSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__END_CANT_LEFT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEndCantLeftAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__END_CANT_LEFT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEndCantLeftAsString(String newEndCantLeftAsString) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__END_CANT_LEFT_AS_STRING, newEndCantLeftAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEndCantLeftAsString() {
		eUnset(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__END_CANT_LEFT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEndCantLeftAsString() {
		return eIsSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__END_CANT_LEFT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getStartCantRight() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__START_CANT_RIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartCantRight(double newStartCantRight) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__START_CANT_RIGHT, newStartCantRight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStartCantRightAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__START_CANT_RIGHT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartCantRightAsString(String newStartCantRightAsString) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__START_CANT_RIGHT_AS_STRING, newStartCantRightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getEndCantRight() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__END_CANT_RIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEndCantRight(double newEndCantRight) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__END_CANT_RIGHT, newEndCantRight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEndCantRight() {
		eUnset(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__END_CANT_RIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEndCantRight() {
		return eIsSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__END_CANT_RIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEndCantRightAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__END_CANT_RIGHT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEndCantRightAsString(String newEndCantRightAsString) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__END_CANT_RIGHT_AS_STRING, newEndCantRightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEndCantRightAsString() {
		eUnset(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__END_CANT_RIGHT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEndCantRightAsString() {
		return eIsSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__END_CANT_RIGHT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAlignmentCantSegmentTypeEnum getPredefinedType() {
		return (IfcAlignmentCantSegmentTypeEnum) eGet(
				Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredefinedType(IfcAlignmentCantSegmentTypeEnum newPredefinedType) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_CANT_SEGMENT__PREDEFINED_TYPE, newPredefinedType);
	}

} //IfcAlignmentCantSegmentImpl
