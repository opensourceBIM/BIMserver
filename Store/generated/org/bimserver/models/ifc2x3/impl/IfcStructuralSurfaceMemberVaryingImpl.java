/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcShapeAspect;
import org.bimserver.models.ifc2x3.IfcStructuralSurfaceMemberVarying;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Surface Member Varying</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralSurfaceMemberVaryingImpl#getSubsequentThickness <em>Subsequent Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralSurfaceMemberVaryingImpl#getSubsequentThicknessAsString <em>Subsequent Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralSurfaceMemberVaryingImpl#getVaryingThicknessLocation <em>Varying Thickness Location</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralSurfaceMemberVaryingImpl#getVaryingThickness <em>Varying Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralSurfaceMemberVaryingImpl#getVaryingThicknessAsString <em>Varying Thickness As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcStructuralSurfaceMemberVaryingImpl extends IfcStructuralSurfaceMemberImpl implements IfcStructuralSurfaceMemberVarying {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralSurfaceMemberVaryingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcStructuralSurfaceMemberVarying();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Float> getSubsequentThickness() {
		return (EList<Float>)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralSurfaceMemberVarying_SubsequentThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getSubsequentThicknessAsString() {
		return (EList<String>)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralSurfaceMemberVarying_SubsequentThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcShapeAspect getVaryingThicknessLocation() {
		return (IfcShapeAspect)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralSurfaceMemberVarying_VaryingThicknessLocation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVaryingThicknessLocation(IfcShapeAspect newVaryingThicknessLocation) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralSurfaceMemberVarying_VaryingThicknessLocation(), newVaryingThicknessLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getVaryingThickness() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralSurfaceMemberVarying_VaryingThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVaryingThickness(float newVaryingThickness) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralSurfaceMemberVarying_VaryingThickness(), newVaryingThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVaryingThicknessAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralSurfaceMemberVarying_VaryingThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVaryingThicknessAsString(String newVaryingThicknessAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralSurfaceMemberVarying_VaryingThicknessAsString(), newVaryingThicknessAsString);
	}

} //IfcStructuralSurfaceMemberVaryingImpl
