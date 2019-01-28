/**
 * Copyright (C) 2009-2014 BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3tc1.impl;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package;
import org.bimserver.models.ifc2x3tc1.IfcWaterProperties;
import org.bimserver.models.ifc2x3tc1.Tristate;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Water Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcWaterPropertiesImpl#getIsPotable <em>Is Potable</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcWaterPropertiesImpl#getHardness <em>Hardness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcWaterPropertiesImpl#getHardnessAsString <em>Hardness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcWaterPropertiesImpl#getAlkalinityConcentration <em>Alkalinity Concentration</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcWaterPropertiesImpl#getAlkalinityConcentrationAsString <em>Alkalinity Concentration As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcWaterPropertiesImpl#getAcidityConcentration <em>Acidity Concentration</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcWaterPropertiesImpl#getAcidityConcentrationAsString <em>Acidity Concentration As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcWaterPropertiesImpl#getImpuritiesContent <em>Impurities Content</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcWaterPropertiesImpl#getImpuritiesContentAsString <em>Impurities Content As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcWaterPropertiesImpl#getPHLevel <em>PH Level</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcWaterPropertiesImpl#getPHLevelAsString <em>PH Level As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcWaterPropertiesImpl#getDissolvedSolidsContent <em>Dissolved Solids Content</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcWaterPropertiesImpl#getDissolvedSolidsContentAsString <em>Dissolved Solids Content As String</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcWaterPropertiesImpl extends IfcMaterialPropertiesImpl implements IfcWaterProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcWaterPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getIsPotable() {
		return (Tristate) eGet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__IS_POTABLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsPotable(Tristate newIsPotable) {
		eSet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__IS_POTABLE, newIsPotable);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsPotable() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__IS_POTABLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsPotable() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__IS_POTABLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getHardness() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__HARDNESS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHardness(double newHardness) {
		eSet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__HARDNESS, newHardness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHardness() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__HARDNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHardness() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__HARDNESS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHardnessAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__HARDNESS_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHardnessAsString(String newHardnessAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__HARDNESS_AS_STRING, newHardnessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHardnessAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__HARDNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHardnessAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__HARDNESS_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAlkalinityConcentration() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__ALKALINITY_CONCENTRATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlkalinityConcentration(double newAlkalinityConcentration) {
		eSet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__ALKALINITY_CONCENTRATION, newAlkalinityConcentration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAlkalinityConcentration() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__ALKALINITY_CONCENTRATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAlkalinityConcentration() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__ALKALINITY_CONCENTRATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAlkalinityConcentrationAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__ALKALINITY_CONCENTRATION_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlkalinityConcentrationAsString(String newAlkalinityConcentrationAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__ALKALINITY_CONCENTRATION_AS_STRING,
				newAlkalinityConcentrationAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAlkalinityConcentrationAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__ALKALINITY_CONCENTRATION_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAlkalinityConcentrationAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__ALKALINITY_CONCENTRATION_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getAcidityConcentration() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__ACIDITY_CONCENTRATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAcidityConcentration(double newAcidityConcentration) {
		eSet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__ACIDITY_CONCENTRATION, newAcidityConcentration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAcidityConcentration() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__ACIDITY_CONCENTRATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAcidityConcentration() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__ACIDITY_CONCENTRATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAcidityConcentrationAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__ACIDITY_CONCENTRATION_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAcidityConcentrationAsString(String newAcidityConcentrationAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__ACIDITY_CONCENTRATION_AS_STRING,
				newAcidityConcentrationAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAcidityConcentrationAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__ACIDITY_CONCENTRATION_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAcidityConcentrationAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__ACIDITY_CONCENTRATION_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getImpuritiesContent() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__IMPURITIES_CONTENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImpuritiesContent(double newImpuritiesContent) {
		eSet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__IMPURITIES_CONTENT, newImpuritiesContent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetImpuritiesContent() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__IMPURITIES_CONTENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetImpuritiesContent() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__IMPURITIES_CONTENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImpuritiesContentAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__IMPURITIES_CONTENT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImpuritiesContentAsString(String newImpuritiesContentAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__IMPURITIES_CONTENT_AS_STRING,
				newImpuritiesContentAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetImpuritiesContentAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__IMPURITIES_CONTENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetImpuritiesContentAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__IMPURITIES_CONTENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPHLevel() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__PH_LEVEL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPHLevel(double newPHLevel) {
		eSet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__PH_LEVEL, newPHLevel);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPHLevel() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__PH_LEVEL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPHLevel() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__PH_LEVEL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPHLevelAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__PH_LEVEL_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPHLevelAsString(String newPHLevelAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__PH_LEVEL_AS_STRING, newPHLevelAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPHLevelAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__PH_LEVEL_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPHLevelAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__PH_LEVEL_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDissolvedSolidsContent() {
		return (Double) eGet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__DISSOLVED_SOLIDS_CONTENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDissolvedSolidsContent(double newDissolvedSolidsContent) {
		eSet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__DISSOLVED_SOLIDS_CONTENT, newDissolvedSolidsContent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDissolvedSolidsContent() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__DISSOLVED_SOLIDS_CONTENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDissolvedSolidsContent() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__DISSOLVED_SOLIDS_CONTENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDissolvedSolidsContentAsString() {
		return (String) eGet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__DISSOLVED_SOLIDS_CONTENT_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDissolvedSolidsContentAsString(String newDissolvedSolidsContentAsString) {
		eSet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__DISSOLVED_SOLIDS_CONTENT_AS_STRING,
				newDissolvedSolidsContentAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDissolvedSolidsContentAsString() {
		eUnset(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__DISSOLVED_SOLIDS_CONTENT_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDissolvedSolidsContentAsString() {
		return eIsSet(Ifc2x3tc1Package.Literals.IFC_WATER_PROPERTIES__DISSOLVED_SOLIDS_CONTENT_AS_STRING);
	}

} //IfcWaterPropertiesImpl
