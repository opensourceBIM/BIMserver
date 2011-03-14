/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcShapeAspect;
import org.bimserver.models.ifc2x3.IfcStructuralLoad;
import org.bimserver.models.ifc2x3.IfcStructuralPlanarActionVarying;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Planar Action Varying</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralPlanarActionVaryingImpl#getVaryingAppliedLoadLocation <em>Varying Applied Load Location</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralPlanarActionVaryingImpl#getSubsequentAppliedLoads <em>Subsequent Applied Loads</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcStructuralPlanarActionVaryingImpl extends IfcStructuralPlanarActionImpl implements IfcStructuralPlanarActionVarying {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralPlanarActionVaryingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcStructuralPlanarActionVarying();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcShapeAspect getVaryingAppliedLoadLocation() {
		return (IfcShapeAspect)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralPlanarActionVarying_VaryingAppliedLoadLocation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVaryingAppliedLoadLocation(IfcShapeAspect newVaryingAppliedLoadLocation) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralPlanarActionVarying_VaryingAppliedLoadLocation(), newVaryingAppliedLoadLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcStructuralLoad> getSubsequentAppliedLoads() {
		return (EList<IfcStructuralLoad>)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralPlanarActionVarying_SubsequentAppliedLoads(), true);
	}

} //IfcStructuralPlanarActionVaryingImpl
