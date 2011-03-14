/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcConditionCriterion;
import org.bimserver.models.ifc2x3.IfcConditionCriterionSelect;
import org.bimserver.models.ifc2x3.IfcDateTimeSelect;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Condition Criterion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConditionCriterionImpl#getCriterion <em>Criterion</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConditionCriterionImpl#getCriterionDateTime <em>Criterion Date Time</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcConditionCriterionImpl extends IfcControlImpl implements IfcConditionCriterion {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcConditionCriterionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcConditionCriterion();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConditionCriterionSelect getCriterion() {
		return (IfcConditionCriterionSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcConditionCriterion_Criterion(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCriterion(IfcConditionCriterionSelect newCriterion) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcConditionCriterion_Criterion(), newCriterion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getCriterionDateTime() {
		return (IfcDateTimeSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcConditionCriterion_CriterionDateTime(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCriterionDateTime(IfcDateTimeSelect newCriterionDateTime) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcConditionCriterion_CriterionDateTime(), newCriterionDateTime);
	}

} //IfcConditionCriterionImpl
