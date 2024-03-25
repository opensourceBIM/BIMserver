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
import org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegment;
import org.bimserver.models.ifc4x3.IfcAlignmentHorizontalSegmentTypeEnum;
import org.bimserver.models.ifc4x3.IfcCartesianPoint;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Alignment Horizontal Segment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentHorizontalSegmentImpl#getStartPoint <em>Start Point</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentHorizontalSegmentImpl#getStartDirection <em>Start Direction</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentHorizontalSegmentImpl#getStartDirectionAsString <em>Start Direction As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentHorizontalSegmentImpl#getStartRadiusOfCurvature <em>Start Radius Of Curvature</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentHorizontalSegmentImpl#getStartRadiusOfCurvatureAsString <em>Start Radius Of Curvature As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentHorizontalSegmentImpl#getEndRadiusOfCurvature <em>End Radius Of Curvature</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentHorizontalSegmentImpl#getEndRadiusOfCurvatureAsString <em>End Radius Of Curvature As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentHorizontalSegmentImpl#getSegmentLength <em>Segment Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentHorizontalSegmentImpl#getSegmentLengthAsString <em>Segment Length As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentHorizontalSegmentImpl#getGravityCenterLineHeight <em>Gravity Center Line Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentHorizontalSegmentImpl#getGravityCenterLineHeightAsString <em>Gravity Center Line Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentHorizontalSegmentImpl#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcAlignmentHorizontalSegmentImpl extends IfcAlignmentParameterSegmentImpl
		implements IfcAlignmentHorizontalSegment {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcAlignmentHorizontalSegmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcCartesianPoint getStartPoint() {
		return (IfcCartesianPoint) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__START_POINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartPoint(IfcCartesianPoint newStartPoint) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__START_POINT, newStartPoint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getStartDirection() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__START_DIRECTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartDirection(double newStartDirection) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__START_DIRECTION, newStartDirection);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStartDirectionAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__START_DIRECTION_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartDirectionAsString(String newStartDirectionAsString) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__START_DIRECTION_AS_STRING,
				newStartDirectionAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getStartRadiusOfCurvature() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__START_RADIUS_OF_CURVATURE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartRadiusOfCurvature(double newStartRadiusOfCurvature) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__START_RADIUS_OF_CURVATURE,
				newStartRadiusOfCurvature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStartRadiusOfCurvatureAsString() {
		return (String) eGet(
				Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__START_RADIUS_OF_CURVATURE_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartRadiusOfCurvatureAsString(String newStartRadiusOfCurvatureAsString) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__START_RADIUS_OF_CURVATURE_AS_STRING,
				newStartRadiusOfCurvatureAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getEndRadiusOfCurvature() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__END_RADIUS_OF_CURVATURE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEndRadiusOfCurvature(double newEndRadiusOfCurvature) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__END_RADIUS_OF_CURVATURE, newEndRadiusOfCurvature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEndRadiusOfCurvatureAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__END_RADIUS_OF_CURVATURE_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEndRadiusOfCurvatureAsString(String newEndRadiusOfCurvatureAsString) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__END_RADIUS_OF_CURVATURE_AS_STRING,
				newEndRadiusOfCurvatureAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getSegmentLength() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__SEGMENT_LENGTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSegmentLength(double newSegmentLength) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__SEGMENT_LENGTH, newSegmentLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSegmentLengthAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__SEGMENT_LENGTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSegmentLengthAsString(String newSegmentLengthAsString) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__SEGMENT_LENGTH_AS_STRING,
				newSegmentLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getGravityCenterLineHeight() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__GRAVITY_CENTER_LINE_HEIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGravityCenterLineHeight(double newGravityCenterLineHeight) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__GRAVITY_CENTER_LINE_HEIGHT,
				newGravityCenterLineHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetGravityCenterLineHeight() {
		eUnset(Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__GRAVITY_CENTER_LINE_HEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetGravityCenterLineHeight() {
		return eIsSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__GRAVITY_CENTER_LINE_HEIGHT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGravityCenterLineHeightAsString() {
		return (String) eGet(
				Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__GRAVITY_CENTER_LINE_HEIGHT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGravityCenterLineHeightAsString(String newGravityCenterLineHeightAsString) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__GRAVITY_CENTER_LINE_HEIGHT_AS_STRING,
				newGravityCenterLineHeightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetGravityCenterLineHeightAsString() {
		eUnset(Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__GRAVITY_CENTER_LINE_HEIGHT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetGravityCenterLineHeightAsString() {
		return eIsSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__GRAVITY_CENTER_LINE_HEIGHT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAlignmentHorizontalSegmentTypeEnum getPredefinedType() {
		return (IfcAlignmentHorizontalSegmentTypeEnum) eGet(
				Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredefinedType(IfcAlignmentHorizontalSegmentTypeEnum newPredefinedType) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_HORIZONTAL_SEGMENT__PREDEFINED_TYPE, newPredefinedType);
	}

} //IfcAlignmentHorizontalSegmentImpl
