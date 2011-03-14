/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcRelConnectsStructuralActivity;
import org.bimserver.models.ifc2x3.IfcStructuralActivity;
import org.bimserver.models.ifc2x3.IfcStructuralActivityAssignmentSelect;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Connects Structural Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsStructuralActivityImpl#getRelatingElement <em>Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsStructuralActivityImpl#getRelatedStructuralActivity <em>Related Structural Activity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelConnectsStructuralActivityImpl extends IfcRelConnectsImpl implements IfcRelConnectsStructuralActivity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelConnectsStructuralActivityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralActivity();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralActivityAssignmentSelect getRelatingElement() {
		return (IfcStructuralActivityAssignmentSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralActivity_RelatingElement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingElement(IfcStructuralActivityAssignmentSelect newRelatingElement) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralActivity_RelatingElement(), newRelatingElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcStructuralActivity getRelatedStructuralActivity() {
		return (IfcStructuralActivity)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralActivity_RelatedStructuralActivity(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatedStructuralActivity(IfcStructuralActivity newRelatedStructuralActivity) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsStructuralActivity_RelatedStructuralActivity(), newRelatedStructuralActivity);
	}

} //IfcRelConnectsStructuralActivityImpl
