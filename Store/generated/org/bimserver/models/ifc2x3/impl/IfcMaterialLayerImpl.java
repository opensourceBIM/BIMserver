/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcMaterial;
import org.bimserver.models.ifc2x3.IfcMaterialLayer;
import org.bimserver.models.ifc2x3.IfcMaterialLayerSet;
import org.bimserver.models.ifc2x3.Tristate;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Material Layer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMaterialLayerImpl#getMaterial <em>Material</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMaterialLayerImpl#getLayerThickness <em>Layer Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMaterialLayerImpl#getLayerThicknessAsString <em>Layer Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMaterialLayerImpl#getIsVentilated <em>Is Ventilated</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMaterialLayerImpl#getToMaterialLayerSet <em>To Material Layer Set</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcMaterialLayerImpl extends IdEObjectImpl implements IfcMaterialLayer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMaterialLayerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcMaterialLayer();
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
	public IfcMaterial getMaterial() {
		return (IfcMaterial)eGet(Ifc2x3Package.eINSTANCE.getIfcMaterialLayer_Material(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaterial(IfcMaterial newMaterial) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcMaterialLayer_Material(), newMaterial);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaterial() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMaterialLayer_Material());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaterial() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMaterialLayer_Material());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLayerThickness() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcMaterialLayer_LayerThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayerThickness(float newLayerThickness) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcMaterialLayer_LayerThickness(), newLayerThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLayerThicknessAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcMaterialLayer_LayerThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLayerThicknessAsString(String newLayerThicknessAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcMaterialLayer_LayerThicknessAsString(), newLayerThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getIsVentilated() {
		return (Tristate)eGet(Ifc2x3Package.eINSTANCE.getIfcMaterialLayer_IsVentilated(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsVentilated(Tristate newIsVentilated) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcMaterialLayer_IsVentilated(), newIsVentilated);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsVentilated() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMaterialLayer_IsVentilated());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsVentilated() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMaterialLayer_IsVentilated());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMaterialLayerSet getToMaterialLayerSet() {
		return (IfcMaterialLayerSet)eGet(Ifc2x3Package.eINSTANCE.getIfcMaterialLayer_ToMaterialLayerSet(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToMaterialLayerSet(IfcMaterialLayerSet newToMaterialLayerSet) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcMaterialLayer_ToMaterialLayerSet(), newToMaterialLayerSet);
	}

} //IfcMaterialLayerImpl
