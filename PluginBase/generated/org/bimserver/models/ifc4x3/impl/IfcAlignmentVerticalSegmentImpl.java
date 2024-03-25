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
import org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegment;
import org.bimserver.models.ifc4x3.IfcAlignmentVerticalSegmentTypeEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Alignment Vertical Segment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentVerticalSegmentImpl#getStartDistAlong <em>Start Dist Along</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentVerticalSegmentImpl#getStartDistAlongAsString <em>Start Dist Along As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentVerticalSegmentImpl#getHorizontalLength <em>Horizontal Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentVerticalSegmentImpl#getHorizontalLengthAsString <em>Horizontal Length As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentVerticalSegmentImpl#getStartHeight <em>Start Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentVerticalSegmentImpl#getStartHeightAsString <em>Start Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentVerticalSegmentImpl#getStartGradient <em>Start Gradient</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentVerticalSegmentImpl#getStartGradientAsString <em>Start Gradient As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentVerticalSegmentImpl#getEndGradient <em>End Gradient</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentVerticalSegmentImpl#getEndGradientAsString <em>End Gradient As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentVerticalSegmentImpl#getRadiusOfCurvature <em>Radius Of Curvature</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentVerticalSegmentImpl#getRadiusOfCurvatureAsString <em>Radius Of Curvature As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentVerticalSegmentImpl#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcAlignmentVerticalSegmentImpl extends IfcAlignmentParameterSegmentImpl
		implements IfcAlignmentVerticalSegment {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcAlignmentVerticalSegmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getStartDistAlong() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__START_DIST_ALONG, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartDistAlong(double newStartDistAlong) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__START_DIST_ALONG, newStartDistAlong);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStartDistAlongAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__START_DIST_ALONG_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartDistAlongAsString(String newStartDistAlongAsString) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__START_DIST_ALONG_AS_STRING,
				newStartDistAlongAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getHorizontalLength() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__HORIZONTAL_LENGTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHorizontalLength(double newHorizontalLength) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__HORIZONTAL_LENGTH, newHorizontalLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getHorizontalLengthAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__HORIZONTAL_LENGTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHorizontalLengthAsString(String newHorizontalLengthAsString) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__HORIZONTAL_LENGTH_AS_STRING,
				newHorizontalLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getStartHeight() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__START_HEIGHT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartHeight(double newStartHeight) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__START_HEIGHT, newStartHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStartHeightAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__START_HEIGHT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartHeightAsString(String newStartHeightAsString) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__START_HEIGHT_AS_STRING, newStartHeightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getStartGradient() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__START_GRADIENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartGradient(double newStartGradient) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__START_GRADIENT, newStartGradient);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStartGradientAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__START_GRADIENT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartGradientAsString(String newStartGradientAsString) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__START_GRADIENT_AS_STRING, newStartGradientAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getEndGradient() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__END_GRADIENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEndGradient(double newEndGradient) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__END_GRADIENT, newEndGradient);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEndGradientAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__END_GRADIENT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEndGradientAsString(String newEndGradientAsString) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__END_GRADIENT_AS_STRING, newEndGradientAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getRadiusOfCurvature() {
		return (Double) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__RADIUS_OF_CURVATURE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRadiusOfCurvature(double newRadiusOfCurvature) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__RADIUS_OF_CURVATURE, newRadiusOfCurvature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRadiusOfCurvature() {
		eUnset(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__RADIUS_OF_CURVATURE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRadiusOfCurvature() {
		return eIsSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__RADIUS_OF_CURVATURE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRadiusOfCurvatureAsString() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__RADIUS_OF_CURVATURE_AS_STRING,
				true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRadiusOfCurvatureAsString(String newRadiusOfCurvatureAsString) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__RADIUS_OF_CURVATURE_AS_STRING,
				newRadiusOfCurvatureAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetRadiusOfCurvatureAsString() {
		eUnset(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__RADIUS_OF_CURVATURE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetRadiusOfCurvatureAsString() {
		return eIsSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__RADIUS_OF_CURVATURE_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcAlignmentVerticalSegmentTypeEnum getPredefinedType() {
		return (IfcAlignmentVerticalSegmentTypeEnum) eGet(
				Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__PREDEFINED_TYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredefinedType(IfcAlignmentVerticalSegmentTypeEnum newPredefinedType) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_VERTICAL_SEGMENT__PREDEFINED_TYPE, newPredefinedType);
	}

} //IfcAlignmentVerticalSegmentImpl
