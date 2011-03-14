/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcConnectionGeometry;
import org.bimserver.models.ifc2x3.IfcRelConnectsWithEccentricity;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Connects With Eccentricity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelConnectsWithEccentricityImpl#getConnectionConstraint <em>Connection Constraint</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelConnectsWithEccentricityImpl extends IfcRelConnectsStructuralMemberImpl implements IfcRelConnectsWithEccentricity {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelConnectsWithEccentricityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRelConnectsWithEccentricity();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConnectionGeometry getConnectionConstraint() {
		return (IfcConnectionGeometry)eGet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsWithEccentricity_ConnectionConstraint(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionConstraint(IfcConnectionGeometry newConnectionConstraint) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelConnectsWithEccentricity_ConnectionConstraint(), newConnectionConstraint);
	}

} //IfcRelConnectsWithEccentricityImpl
