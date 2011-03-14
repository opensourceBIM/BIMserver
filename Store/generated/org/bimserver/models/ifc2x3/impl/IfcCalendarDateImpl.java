/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcCalendarDate;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Calendar Date</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCalendarDateImpl#getDayComponent <em>Day Component</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCalendarDateImpl#getMonthComponent <em>Month Component</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCalendarDateImpl#getYearComponent <em>Year Component</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcCalendarDateImpl extends IdEObjectImpl implements IfcCalendarDate {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCalendarDateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcCalendarDate();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDayComponent() {
		return (Integer)eGet(Ifc2x3Package.eINSTANCE.getIfcCalendarDate_DayComponent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDayComponent(int newDayComponent) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCalendarDate_DayComponent(), newDayComponent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMonthComponent() {
		return (Integer)eGet(Ifc2x3Package.eINSTANCE.getIfcCalendarDate_MonthComponent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMonthComponent(int newMonthComponent) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCalendarDate_MonthComponent(), newMonthComponent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getYearComponent() {
		return (Integer)eGet(Ifc2x3Package.eINSTANCE.getIfcCalendarDate_YearComponent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYearComponent(int newYearComponent) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcCalendarDate_YearComponent(), newYearComponent);
	}

} //IfcCalendarDateImpl
