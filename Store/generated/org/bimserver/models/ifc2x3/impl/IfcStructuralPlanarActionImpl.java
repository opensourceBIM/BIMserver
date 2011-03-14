/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcProjectedOrTrueLengthEnum;
import org.bimserver.models.ifc2x3.IfcStructuralPlanarAction;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Planar Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralPlanarActionImpl#getProjectedOrTrue <em>Projected Or True</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcStructuralPlanarActionImpl extends IfcStructuralActionImpl implements IfcStructuralPlanarAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralPlanarActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcStructuralPlanarAction();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProjectedOrTrueLengthEnum getProjectedOrTrue() {
		return (IfcProjectedOrTrueLengthEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralPlanarAction_ProjectedOrTrue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectedOrTrue(IfcProjectedOrTrueLengthEnum newProjectedOrTrue) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralPlanarAction_ProjectedOrTrue(), newProjectedOrTrue);
	}

} //IfcStructuralPlanarActionImpl
