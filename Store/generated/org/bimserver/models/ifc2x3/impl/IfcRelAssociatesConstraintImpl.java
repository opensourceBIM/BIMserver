/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcConstraint;
import org.bimserver.models.ifc2x3.IfcRelAssociatesConstraint;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Associates Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelAssociatesConstraintImpl#getIntent <em>Intent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelAssociatesConstraintImpl#getRelatingConstraint <em>Relating Constraint</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelAssociatesConstraintImpl extends IfcRelAssociatesImpl implements IfcRelAssociatesConstraint {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelAssociatesConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRelAssociatesConstraint();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIntent() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRelAssociatesConstraint_Intent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntent(String newIntent) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelAssociatesConstraint_Intent(), newIntent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConstraint getRelatingConstraint() {
		return (IfcConstraint)eGet(Ifc2x3Package.eINSTANCE.getIfcRelAssociatesConstraint_RelatingConstraint(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingConstraint(IfcConstraint newRelatingConstraint) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelAssociatesConstraint_RelatingConstraint(), newRelatingConstraint);
	}

} //IfcRelAssociatesConstraintImpl
