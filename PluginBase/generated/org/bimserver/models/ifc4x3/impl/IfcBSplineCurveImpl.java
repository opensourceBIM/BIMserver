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
import org.bimserver.models.ifc4x3.IfcBSplineCurve;
import org.bimserver.models.ifc4x3.IfcBSplineCurveForm;
import org.bimserver.models.ifc4x3.IfcCartesianPoint;
import org.bimserver.models.ifc4x3.Tristate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc BSpline Curve</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBSplineCurveImpl#getDegree <em>Degree</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBSplineCurveImpl#getControlPointsList <em>Control Points List</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBSplineCurveImpl#getCurveForm <em>Curve Form</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBSplineCurveImpl#getClosedCurve <em>Closed Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBSplineCurveImpl#getSelfIntersect <em>Self Intersect</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcBSplineCurveImpl#getUpperIndexOnControlPoints <em>Upper Index On Control Points</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcBSplineCurveImpl extends IfcBoundedCurveImpl implements IfcBSplineCurve {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcBSplineCurveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.eINSTANCE.getIfcBSplineCurve();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getDegree() {
		return (Long) eGet(Ifc4x3Package.eINSTANCE.getIfcBSplineCurve_Degree(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDegree(long newDegree) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBSplineCurve_Degree(), newDegree);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<IfcCartesianPoint> getControlPointsList() {
		return (EList<IfcCartesianPoint>) eGet(Ifc4x3Package.eINSTANCE.getIfcBSplineCurve_ControlPointsList(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcBSplineCurveForm getCurveForm() {
		return (IfcBSplineCurveForm) eGet(Ifc4x3Package.eINSTANCE.getIfcBSplineCurve_CurveForm(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurveForm(IfcBSplineCurveForm newCurveForm) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBSplineCurve_CurveForm(), newCurveForm);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getClosedCurve() {
		return (Tristate) eGet(Ifc4x3Package.eINSTANCE.getIfcBSplineCurve_ClosedCurve(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClosedCurve(Tristate newClosedCurve) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBSplineCurve_ClosedCurve(), newClosedCurve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Tristate getSelfIntersect() {
		return (Tristate) eGet(Ifc4x3Package.eINSTANCE.getIfcBSplineCurve_SelfIntersect(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSelfIntersect(Tristate newSelfIntersect) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBSplineCurve_SelfIntersect(), newSelfIntersect);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getUpperIndexOnControlPoints() {
		return (Long) eGet(Ifc4x3Package.eINSTANCE.getIfcBSplineCurve_UpperIndexOnControlPoints(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUpperIndexOnControlPoints(long newUpperIndexOnControlPoints) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcBSplineCurve_UpperIndexOnControlPoints(), newUpperIndexOnControlPoints);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetUpperIndexOnControlPoints() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcBSplineCurve_UpperIndexOnControlPoints());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetUpperIndexOnControlPoints() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcBSplineCurve_UpperIndexOnControlPoints());
	}

} //IfcBSplineCurveImpl
