/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcAppliedValue;
import org.bimserver.models.ifc2x3.IfcAppliedValueRelationship;
import org.bimserver.models.ifc2x3.IfcArithmeticOperatorEnum;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Applied Value Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAppliedValueRelationshipImpl#getComponentOfTotal <em>Component Of Total</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAppliedValueRelationshipImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAppliedValueRelationshipImpl#getArithmeticOperator <em>Arithmetic Operator</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAppliedValueRelationshipImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAppliedValueRelationshipImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcAppliedValueRelationshipImpl extends IdEObjectImpl implements IfcAppliedValueRelationship {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcAppliedValueRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcAppliedValueRelationship();
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
	public IfcAppliedValue getComponentOfTotal() {
		return (IfcAppliedValue)eGet(Ifc2x3Package.eINSTANCE.getIfcAppliedValueRelationship_ComponentOfTotal(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentOfTotal(IfcAppliedValue newComponentOfTotal) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcAppliedValueRelationship_ComponentOfTotal(), newComponentOfTotal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcAppliedValue> getComponents() {
		return (EList<IfcAppliedValue>)eGet(Ifc2x3Package.eINSTANCE.getIfcAppliedValueRelationship_Components(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcArithmeticOperatorEnum getArithmeticOperator() {
		return (IfcArithmeticOperatorEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcAppliedValueRelationship_ArithmeticOperator(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArithmeticOperator(IfcArithmeticOperatorEnum newArithmeticOperator) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcAppliedValueRelationship_ArithmeticOperator(), newArithmeticOperator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcAppliedValueRelationship_Name(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcAppliedValueRelationship_Name(), newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetName() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcAppliedValueRelationship_Name());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetName() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcAppliedValueRelationship_Name());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcAppliedValueRelationship_Description(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcAppliedValueRelationship_Description(), newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDescription() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcAppliedValueRelationship_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDescription() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcAppliedValueRelationship_Description());
	}

} //IfcAppliedValueRelationshipImpl
