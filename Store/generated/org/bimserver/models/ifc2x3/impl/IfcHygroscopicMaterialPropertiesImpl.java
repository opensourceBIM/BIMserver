/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcHygroscopicMaterialProperties;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Hygroscopic Material Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcHygroscopicMaterialPropertiesImpl#getUpperVaporResistanceFactor <em>Upper Vapor Resistance Factor</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcHygroscopicMaterialPropertiesImpl#getUpperVaporResistanceFactorAsString <em>Upper Vapor Resistance Factor As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcHygroscopicMaterialPropertiesImpl#getLowerVaporResistanceFactor <em>Lower Vapor Resistance Factor</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcHygroscopicMaterialPropertiesImpl#getLowerVaporResistanceFactorAsString <em>Lower Vapor Resistance Factor As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcHygroscopicMaterialPropertiesImpl#getIsothermalMoistureCapacity <em>Isothermal Moisture Capacity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcHygroscopicMaterialPropertiesImpl#getIsothermalMoistureCapacityAsString <em>Isothermal Moisture Capacity As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcHygroscopicMaterialPropertiesImpl#getVaporPermeability <em>Vapor Permeability</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcHygroscopicMaterialPropertiesImpl#getVaporPermeabilityAsString <em>Vapor Permeability As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcHygroscopicMaterialPropertiesImpl#getMoistureDiffusivity <em>Moisture Diffusivity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcHygroscopicMaterialPropertiesImpl#getMoistureDiffusivityAsString <em>Moisture Diffusivity As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcHygroscopicMaterialPropertiesImpl extends IfcMaterialPropertiesImpl implements IfcHygroscopicMaterialProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcHygroscopicMaterialPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getUpperVaporResistanceFactor() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_UpperVaporResistanceFactor(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperVaporResistanceFactor(float newUpperVaporResistanceFactor) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_UpperVaporResistanceFactor(), newUpperVaporResistanceFactor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUpperVaporResistanceFactor() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_UpperVaporResistanceFactor());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUpperVaporResistanceFactor() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_UpperVaporResistanceFactor());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUpperVaporResistanceFactorAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_UpperVaporResistanceFactorAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperVaporResistanceFactorAsString(String newUpperVaporResistanceFactorAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_UpperVaporResistanceFactorAsString(), newUpperVaporResistanceFactorAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUpperVaporResistanceFactorAsString() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_UpperVaporResistanceFactorAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUpperVaporResistanceFactorAsString() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_UpperVaporResistanceFactorAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLowerVaporResistanceFactor() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_LowerVaporResistanceFactor(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerVaporResistanceFactor(float newLowerVaporResistanceFactor) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_LowerVaporResistanceFactor(), newLowerVaporResistanceFactor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLowerVaporResistanceFactor() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_LowerVaporResistanceFactor());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLowerVaporResistanceFactor() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_LowerVaporResistanceFactor());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLowerVaporResistanceFactorAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_LowerVaporResistanceFactorAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerVaporResistanceFactorAsString(String newLowerVaporResistanceFactorAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_LowerVaporResistanceFactorAsString(), newLowerVaporResistanceFactorAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLowerVaporResistanceFactorAsString() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_LowerVaporResistanceFactorAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLowerVaporResistanceFactorAsString() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_LowerVaporResistanceFactorAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getIsothermalMoistureCapacity() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_IsothermalMoistureCapacity(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsothermalMoistureCapacity(float newIsothermalMoistureCapacity) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_IsothermalMoistureCapacity(), newIsothermalMoistureCapacity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsothermalMoistureCapacity() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_IsothermalMoistureCapacity());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsothermalMoistureCapacity() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_IsothermalMoistureCapacity());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsothermalMoistureCapacityAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_IsothermalMoistureCapacityAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsothermalMoistureCapacityAsString(String newIsothermalMoistureCapacityAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_IsothermalMoistureCapacityAsString(), newIsothermalMoistureCapacityAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsothermalMoistureCapacityAsString() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_IsothermalMoistureCapacityAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsothermalMoistureCapacityAsString() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_IsothermalMoistureCapacityAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getVaporPermeability() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_VaporPermeability(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVaporPermeability(float newVaporPermeability) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_VaporPermeability(), newVaporPermeability);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVaporPermeability() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_VaporPermeability());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVaporPermeability() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_VaporPermeability());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVaporPermeabilityAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_VaporPermeabilityAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVaporPermeabilityAsString(String newVaporPermeabilityAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_VaporPermeabilityAsString(), newVaporPermeabilityAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVaporPermeabilityAsString() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_VaporPermeabilityAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVaporPermeabilityAsString() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_VaporPermeabilityAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMoistureDiffusivity() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_MoistureDiffusivity(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMoistureDiffusivity(float newMoistureDiffusivity) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_MoistureDiffusivity(), newMoistureDiffusivity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMoistureDiffusivity() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_MoistureDiffusivity());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMoistureDiffusivity() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_MoistureDiffusivity());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMoistureDiffusivityAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_MoistureDiffusivityAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMoistureDiffusivityAsString(String newMoistureDiffusivityAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_MoistureDiffusivityAsString(), newMoistureDiffusivityAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMoistureDiffusivityAsString() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_MoistureDiffusivityAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMoistureDiffusivityAsString() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcHygroscopicMaterialProperties_MoistureDiffusivityAsString());
	}

} //IfcHygroscopicMaterialPropertiesImpl
