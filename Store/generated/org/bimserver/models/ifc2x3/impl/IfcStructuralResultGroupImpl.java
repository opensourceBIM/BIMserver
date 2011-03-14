/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcAnalysisTheoryTypeEnum;
import org.bimserver.models.ifc2x3.IfcStructuralAnalysisModel;
import org.bimserver.models.ifc2x3.IfcStructuralLoadGroup;
import org.bimserver.models.ifc2x3.IfcStructuralResultGroup;
import org.bimserver.models.ifc2x3.Tristate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Result Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralResultGroupImpl#getTheoryType <em>Theory Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralResultGroupImpl#getResultForLoadGroup <em>Result For Load Group</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralResultGroupImpl#getIsLinear <em>Is Linear</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralResultGroupImpl#getResultGroupFor <em>Result Group For</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcStructuralResultGroupImpl extends IfcGroupImpl implements IfcStructuralResultGroup {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralResultGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcStructuralResultGroup();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAnalysisTheoryTypeEnum getTheoryType() {
		return (IfcAnalysisTheoryTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralResultGroup_TheoryType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTheoryType(IfcAnalysisTheoryTypeEnum newTheoryType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralResultGroup_TheoryType(), newTheoryType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralLoadGroup getResultForLoadGroup() {
		return (IfcStructuralLoadGroup)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralResultGroup_ResultForLoadGroup(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultForLoadGroup(IfcStructuralLoadGroup newResultForLoadGroup) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralResultGroup_ResultForLoadGroup(), newResultForLoadGroup);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetResultForLoadGroup() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralResultGroup_ResultForLoadGroup());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetResultForLoadGroup() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralResultGroup_ResultForLoadGroup());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getIsLinear() {
		return (Tristate)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralResultGroup_IsLinear(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsLinear(Tristate newIsLinear) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralResultGroup_IsLinear(), newIsLinear);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcStructuralAnalysisModel> getResultGroupFor() {
		return (EList<IfcStructuralAnalysisModel>)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralResultGroup_ResultGroupFor(), true);
	}

} //IfcStructuralResultGroupImpl
