/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcDateTimeSelect;
import org.bimserver.models.ifc2x3.IfcIrregularTimeSeriesValue;
import org.bimserver.models.ifc2x3.IfcValue;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Irregular Time Series Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcIrregularTimeSeriesValueImpl#getTimeStamp <em>Time Stamp</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcIrregularTimeSeriesValueImpl#getListValues <em>List Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcIrregularTimeSeriesValueImpl extends IdEObjectImpl implements IfcIrregularTimeSeriesValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcIrregularTimeSeriesValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcIrregularTimeSeriesValue();
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
	public IfcDateTimeSelect getTimeStamp() {
		return (IfcDateTimeSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcIrregularTimeSeriesValue_TimeStamp(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeStamp(IfcDateTimeSelect newTimeStamp) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcIrregularTimeSeriesValue_TimeStamp(), newTimeStamp);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcValue> getListValues() {
		return (EList<IfcValue>)eGet(Ifc2x3Package.eINSTANCE.getIfcIrregularTimeSeriesValue_ListValues(), true);
	}

} //IfcIrregularTimeSeriesValueImpl
