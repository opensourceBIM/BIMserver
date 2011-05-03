/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Ifc Derived Unit Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDerivedUnitEnum()
 * @model
 * @generated
 */
public enum IfcDerivedUnitEnum implements Enumerator
{
	/**
	 * The '<em><b>NULL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NULL
	 * @generated
	 * @ordered
	 */
	NULL_LITERAL(0, "NULL", "NULL"),

	/**
	 * The '<em><b>MOMENTOFINERTIAUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOMENTOFINERTIAUNIT
	 * @generated
	 * @ordered
	 */
	MOMENTOFINERTIAUNIT_LITERAL(1, "MOMENTOFINERTIAUNIT", "MOMENTOFINERTIAUNIT"),

	/**
	 * The '<em><b>MOLECULARWEIGHTUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOLECULARWEIGHTUNIT
	 * @generated
	 * @ordered
	 */
	MOLECULARWEIGHTUNIT_LITERAL(2, "MOLECULARWEIGHTUNIT", "MOLECULARWEIGHTUNIT"),

	/**
	 * The '<em><b>SECTIONMODULUSUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SECTIONMODULUSUNIT
	 * @generated
	 * @ordered
	 */
	SECTIONMODULUSUNIT_LITERAL(3, "SECTIONMODULUSUNIT", "SECTIONMODULUSUNIT"),

	/**
	 * The '<em><b>HEATFLUXDENSITYUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HEATFLUXDENSITYUNIT
	 * @generated
	 * @ordered
	 */
	HEATFLUXDENSITYUNIT_LITERAL(4, "HEATFLUXDENSITYUNIT", "HEATFLUXDENSITYUNIT"),

	/**
	 * The '<em><b>ROTATIONALFREQUENCYUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROTATIONALFREQUENCYUNIT
	 * @generated
	 * @ordered
	 */
	ROTATIONALFREQUENCYUNIT_LITERAL(5, "ROTATIONALFREQUENCYUNIT", "ROTATIONALFREQUENCYUNIT"),

	/**
	 * The '<em><b>THERMALTRANSMITTANCEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #THERMALTRANSMITTANCEUNIT
	 * @generated
	 * @ordered
	 */
	THERMALTRANSMITTANCEUNIT_LITERAL(6, "THERMALTRANSMITTANCEUNIT", "THERMALTRANSMITTANCEUNIT"),

	/**
	 * The '<em><b>KINEMATICVISCOSITYUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KINEMATICVISCOSITYUNIT
	 * @generated
	 * @ordered
	 */
	KINEMATICVISCOSITYUNIT_LITERAL(7, "KINEMATICVISCOSITYUNIT", "KINEMATICVISCOSITYUNIT"),

	/**
	 * The '<em><b>VOLUMETRICFLOWRATEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VOLUMETRICFLOWRATEUNIT
	 * @generated
	 * @ordered
	 */
	VOLUMETRICFLOWRATEUNIT_LITERAL(8, "VOLUMETRICFLOWRATEUNIT", "VOLUMETRICFLOWRATEUNIT"),

	/**
	 * The '<em><b>SPECIFICHEATCAPACITYUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPECIFICHEATCAPACITYUNIT
	 * @generated
	 * @ordered
	 */
	SPECIFICHEATCAPACITYUNIT_LITERAL(9, "SPECIFICHEATCAPACITYUNIT", "SPECIFICHEATCAPACITYUNIT"),

	/**
	 * The '<em><b>HEATINGVALUEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HEATINGVALUEUNIT
	 * @generated
	 * @ordered
	 */
	HEATINGVALUEUNIT_LITERAL(10, "HEATINGVALUEUNIT", "HEATINGVALUEUNIT"),

	/**
	 * The '<em><b>TORQUEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TORQUEUNIT
	 * @generated
	 * @ordered
	 */
	TORQUEUNIT_LITERAL(11, "TORQUEUNIT", "TORQUEUNIT"),

	/**
	 * The '<em><b>THERMALRESISTANCEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #THERMALRESISTANCEUNIT
	 * @generated
	 * @ordered
	 */
	THERMALRESISTANCEUNIT_LITERAL(12, "THERMALRESISTANCEUNIT", "THERMALRESISTANCEUNIT"),

	/**
	 * The '<em><b>SHEARMODULUSUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHEARMODULUSUNIT
	 * @generated
	 * @ordered
	 */
	SHEARMODULUSUNIT_LITERAL(13, "SHEARMODULUSUNIT", "SHEARMODULUSUNIT"),

	/**
	 * The '<em><b>MODULUSOFSUBGRADEREACTIONUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODULUSOFSUBGRADEREACTIONUNIT
	 * @generated
	 * @ordered
	 */
	MODULUSOFSUBGRADEREACTIONUNIT_LITERAL(14, "MODULUSOFSUBGRADEREACTIONUNIT", "MODULUSOFSUBGRADEREACTIONUNIT"),

	/**
	 * The '<em><b>DYNAMICVISCOSITYUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DYNAMICVISCOSITYUNIT
	 * @generated
	 * @ordered
	 */
	DYNAMICVISCOSITYUNIT_LITERAL(15, "DYNAMICVISCOSITYUNIT", "DYNAMICVISCOSITYUNIT"),

	/**
	 * The '<em><b>ROTATIONALSTIFFNESSUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROTATIONALSTIFFNESSUNIT
	 * @generated
	 * @ordered
	 */
	ROTATIONALSTIFFNESSUNIT_LITERAL(16, "ROTATIONALSTIFFNESSUNIT", "ROTATIONALSTIFFNESSUNIT"),

	/**
	 * The '<em><b>MASSDENSITYUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MASSDENSITYUNIT
	 * @generated
	 * @ordered
	 */
	MASSDENSITYUNIT_LITERAL(17, "MASSDENSITYUNIT", "MASSDENSITYUNIT"),

	/**
	 * The '<em><b>LINEARSTIFFNESSUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINEARSTIFFNESSUNIT
	 * @generated
	 * @ordered
	 */
	LINEARSTIFFNESSUNIT_LITERAL(18, "LINEARSTIFFNESSUNIT", "LINEARSTIFFNESSUNIT"),

	/**
	 * The '<em><b>VAPORPERMEABILITYUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VAPORPERMEABILITYUNIT
	 * @generated
	 * @ordered
	 */
	VAPORPERMEABILITYUNIT_LITERAL(19, "VAPORPERMEABILITYUNIT", "VAPORPERMEABILITYUNIT"),

	/**
	 * The '<em><b>TEMPERATUREGRADIENTUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEMPERATUREGRADIENTUNIT
	 * @generated
	 * @ordered
	 */
	TEMPERATUREGRADIENTUNIT_LITERAL(20, "TEMPERATUREGRADIENTUNIT", "TEMPERATUREGRADIENTUNIT"),

	/**
	 * The '<em><b>ANGULARVELOCITYUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANGULARVELOCITYUNIT
	 * @generated
	 * @ordered
	 */
	ANGULARVELOCITYUNIT_LITERAL(21, "ANGULARVELOCITYUNIT", "ANGULARVELOCITYUNIT"),

	/**
	 * The '<em><b>CURVATUREUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CURVATUREUNIT
	 * @generated
	 * @ordered
	 */
	CURVATUREUNIT_LITERAL(22, "CURVATUREUNIT", "CURVATUREUNIT"),

	/**
	 * The '<em><b>WARPINGMOMENTUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WARPINGMOMENTUNIT
	 * @generated
	 * @ordered
	 */
	WARPINGMOMENTUNIT_LITERAL(23, "WARPINGMOMENTUNIT", "WARPINGMOMENTUNIT"),

	/**
	 * The '<em><b>ROTATIONALMASSUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROTATIONALMASSUNIT
	 * @generated
	 * @ordered
	 */
	ROTATIONALMASSUNIT_LITERAL(24, "ROTATIONALMASSUNIT", "ROTATIONALMASSUNIT"),

	/**
	 * The '<em><b>THERMALADMITTANCEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #THERMALADMITTANCEUNIT
	 * @generated
	 * @ordered
	 */
	THERMALADMITTANCEUNIT_LITERAL(25, "THERMALADMITTANCEUNIT", "THERMALADMITTANCEUNIT"),

	/**
	 * The '<em><b>MASSFLOWRATEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MASSFLOWRATEUNIT
	 * @generated
	 * @ordered
	 */
	MASSFLOWRATEUNIT_LITERAL(26, "MASSFLOWRATEUNIT", "MASSFLOWRATEUNIT"),

	/**
	 * The '<em><b>SOUNDPOWERUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOUNDPOWERUNIT
	 * @generated
	 * @ordered
	 */
	SOUNDPOWERUNIT_LITERAL(27, "SOUNDPOWERUNIT", "SOUNDPOWERUNIT"),

	/**
	 * The '<em><b>COMPOUNDPLANEANGLEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPOUNDPLANEANGLEUNIT
	 * @generated
	 * @ordered
	 */
	COMPOUNDPLANEANGLEUNIT_LITERAL(28, "COMPOUNDPLANEANGLEUNIT", "COMPOUNDPLANEANGLEUNIT"),

	/**
	 * The '<em><b>ISOTHERMALMOISTURECAPACITYUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ISOTHERMALMOISTURECAPACITYUNIT
	 * @generated
	 * @ordered
	 */
	ISOTHERMALMOISTURECAPACITYUNIT_LITERAL(29, "ISOTHERMALMOISTURECAPACITYUNIT", "ISOTHERMALMOISTURECAPACITYUNIT"),

	/**
	 * The '<em><b>IONCONCENTRATIONUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IONCONCENTRATIONUNIT
	 * @generated
	 * @ordered
	 */
	IONCONCENTRATIONUNIT_LITERAL(30, "IONCONCENTRATIONUNIT", "IONCONCENTRATIONUNIT"),

	/**
	 * The '<em><b>ACCELERATIONUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACCELERATIONUNIT
	 * @generated
	 * @ordered
	 */
	ACCELERATIONUNIT_LITERAL(31, "ACCELERATIONUNIT", "ACCELERATIONUNIT"),

	/**
	 * The '<em><b>MODULUSOFROTATIONALSUBGRADEREACTIONUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODULUSOFROTATIONALSUBGRADEREACTIONUNIT
	 * @generated
	 * @ordered
	 */
	MODULUSOFROTATIONALSUBGRADEREACTIONUNIT_LITERAL(32, "MODULUSOFROTATIONALSUBGRADEREACTIONUNIT", "MODULUSOFROTATIONALSUBGRADEREACTIONUNIT"),

	/**
	 * The '<em><b>PLANARFORCEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLANARFORCEUNIT
	 * @generated
	 * @ordered
	 */
	PLANARFORCEUNIT_LITERAL(33, "PLANARFORCEUNIT", "PLANARFORCEUNIT"),

	/**
	 * The '<em><b>MOISTUREDIFFUSIVITYUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MOISTUREDIFFUSIVITYUNIT
	 * @generated
	 * @ordered
	 */
	MOISTUREDIFFUSIVITYUNIT_LITERAL(34, "MOISTUREDIFFUSIVITYUNIT", "MOISTUREDIFFUSIVITYUNIT"),

	/**
	 * The '<em><b>SECTIONAREAINTEGRALUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SECTIONAREAINTEGRALUNIT
	 * @generated
	 * @ordered
	 */
	SECTIONAREAINTEGRALUNIT_LITERAL(35, "SECTIONAREAINTEGRALUNIT", "SECTIONAREAINTEGRALUNIT"),

	/**
	 * The '<em><b>MODULUSOFELASTICITYUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODULUSOFELASTICITYUNIT
	 * @generated
	 * @ordered
	 */
	MODULUSOFELASTICITYUNIT_LITERAL(36, "MODULUSOFELASTICITYUNIT", "MODULUSOFELASTICITYUNIT"),

	/**
	 * The '<em><b>LINEARVELOCITYUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINEARVELOCITYUNIT
	 * @generated
	 * @ordered
	 */
	LINEARVELOCITYUNIT_LITERAL(37, "LINEARVELOCITYUNIT", "LINEARVELOCITYUNIT"),

	/**
	 * The '<em><b>MASSPERLENGTHUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MASSPERLENGTHUNIT
	 * @generated
	 * @ordered
	 */
	MASSPERLENGTHUNIT_LITERAL(38, "MASSPERLENGTHUNIT", "MASSPERLENGTHUNIT"),

	/**
	 * The '<em><b>INTEGERCOUNTRATEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTEGERCOUNTRATEUNIT
	 * @generated
	 * @ordered
	 */
	INTEGERCOUNTRATEUNIT_LITERAL(39, "INTEGERCOUNTRATEUNIT", "INTEGERCOUNTRATEUNIT"),

	/**
	 * The '<em><b>LINEARMOMENTUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINEARMOMENTUNIT
	 * @generated
	 * @ordered
	 */
	LINEARMOMENTUNIT_LITERAL(40, "LINEARMOMENTUNIT", "LINEARMOMENTUNIT"),

	/**
	 * The '<em><b>SOUNDPRESSUREUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOUNDPRESSUREUNIT
	 * @generated
	 * @ordered
	 */
	SOUNDPRESSUREUNIT_LITERAL(41, "SOUNDPRESSUREUNIT", "SOUNDPRESSUREUNIT"),

	/**
	 * The '<em><b>LINEARFORCEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LINEARFORCEUNIT
	 * @generated
	 * @ordered
	 */
	LINEARFORCEUNIT_LITERAL(42, "LINEARFORCEUNIT", "LINEARFORCEUNIT"),

	/**
	 * The '<em><b>LUMINOUSINTENSITYDISTRIBUTIONUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LUMINOUSINTENSITYDISTRIBUTIONUNIT
	 * @generated
	 * @ordered
	 */
	LUMINOUSINTENSITYDISTRIBUTIONUNIT_LITERAL(43, "LUMINOUSINTENSITYDISTRIBUTIONUNIT", "LUMINOUSINTENSITYDISTRIBUTIONUNIT"),

	/**
	 * The '<em><b>PHUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PHUNIT
	 * @generated
	 * @ordered
	 */
	PHUNIT_LITERAL(44, "PHUNIT", "PHUNIT"),

	/**
	 * The '<em><b>THERMALEXPANSIONCOEFFICIENTUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #THERMALEXPANSIONCOEFFICIENTUNIT
	 * @generated
	 * @ordered
	 */
	THERMALEXPANSIONCOEFFICIENTUNIT_LITERAL(45, "THERMALEXPANSIONCOEFFICIENTUNIT", "THERMALEXPANSIONCOEFFICIENTUNIT"),

	/**
	 * The '<em><b>MODULUSOFLINEARSUBGRADEREACTIONUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODULUSOFLINEARSUBGRADEREACTIONUNIT
	 * @generated
	 * @ordered
	 */
	MODULUSOFLINEARSUBGRADEREACTIONUNIT_LITERAL(46, "MODULUSOFLINEARSUBGRADEREACTIONUNIT", "MODULUSOFLINEARSUBGRADEREACTIONUNIT"),

	/**
	 * The '<em><b>WARPINGCONSTANTUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WARPINGCONSTANTUNIT
	 * @generated
	 * @ordered
	 */
	WARPINGCONSTANTUNIT_LITERAL(47, "WARPINGCONSTANTUNIT", "WARPINGCONSTANTUNIT"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @generated
	 * @ordered
	 */
	USERDEFINED_LITERAL(48, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>THERMALCONDUCTANCEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #THERMALCONDUCTANCEUNIT
	 * @generated
	 * @ordered
	 */
	THERMALCONDUCTANCEUNIT_LITERAL(49, "THERMALCONDUCTANCEUNIT", "THERMALCONDUCTANCEUNIT");

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * The '<em><b>NULL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NULL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NULL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NULL = 0;

	/**
	 * The '<em><b>MOMENTOFINERTIAUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MOMENTOFINERTIAUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MOMENTOFINERTIAUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MOMENTOFINERTIAUNIT = 1;

	/**
	 * The '<em><b>MOLECULARWEIGHTUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MOLECULARWEIGHTUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MOLECULARWEIGHTUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MOLECULARWEIGHTUNIT = 2;

	/**
	 * The '<em><b>SECTIONMODULUSUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SECTIONMODULUSUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SECTIONMODULUSUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SECTIONMODULUSUNIT = 3;

	/**
	 * The '<em><b>HEATFLUXDENSITYUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HEATFLUXDENSITYUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HEATFLUXDENSITYUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HEATFLUXDENSITYUNIT = 4;

	/**
	 * The '<em><b>ROTATIONALFREQUENCYUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROTATIONALFREQUENCYUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ROTATIONALFREQUENCYUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROTATIONALFREQUENCYUNIT = 5;

	/**
	 * The '<em><b>THERMALTRANSMITTANCEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>THERMALTRANSMITTANCEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #THERMALTRANSMITTANCEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int THERMALTRANSMITTANCEUNIT = 6;

	/**
	 * The '<em><b>KINEMATICVISCOSITYUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KINEMATICVISCOSITYUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KINEMATICVISCOSITYUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KINEMATICVISCOSITYUNIT = 7;

	/**
	 * The '<em><b>VOLUMETRICFLOWRATEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VOLUMETRICFLOWRATEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VOLUMETRICFLOWRATEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VOLUMETRICFLOWRATEUNIT = 8;

	/**
	 * The '<em><b>SPECIFICHEATCAPACITYUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SPECIFICHEATCAPACITYUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SPECIFICHEATCAPACITYUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SPECIFICHEATCAPACITYUNIT = 9;

	/**
	 * The '<em><b>HEATINGVALUEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HEATINGVALUEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HEATINGVALUEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HEATINGVALUEUNIT = 10;

	/**
	 * The '<em><b>TORQUEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TORQUEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TORQUEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TORQUEUNIT = 11;

	/**
	 * The '<em><b>THERMALRESISTANCEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>THERMALRESISTANCEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #THERMALRESISTANCEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int THERMALRESISTANCEUNIT = 12;

	/**
	 * The '<em><b>SHEARMODULUSUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SHEARMODULUSUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SHEARMODULUSUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SHEARMODULUSUNIT = 13;

	/**
	 * The '<em><b>MODULUSOFSUBGRADEREACTIONUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MODULUSOFSUBGRADEREACTIONUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MODULUSOFSUBGRADEREACTIONUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MODULUSOFSUBGRADEREACTIONUNIT = 14;

	/**
	 * The '<em><b>DYNAMICVISCOSITYUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DYNAMICVISCOSITYUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DYNAMICVISCOSITYUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DYNAMICVISCOSITYUNIT = 15;

	/**
	 * The '<em><b>ROTATIONALSTIFFNESSUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROTATIONALSTIFFNESSUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ROTATIONALSTIFFNESSUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROTATIONALSTIFFNESSUNIT = 16;

	/**
	 * The '<em><b>MASSDENSITYUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MASSDENSITYUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MASSDENSITYUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MASSDENSITYUNIT = 17;

	/**
	 * The '<em><b>LINEARSTIFFNESSUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LINEARSTIFFNESSUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LINEARSTIFFNESSUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LINEARSTIFFNESSUNIT = 18;

	/**
	 * The '<em><b>VAPORPERMEABILITYUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VAPORPERMEABILITYUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VAPORPERMEABILITYUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VAPORPERMEABILITYUNIT = 19;

	/**
	 * The '<em><b>TEMPERATUREGRADIENTUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TEMPERATUREGRADIENTUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TEMPERATUREGRADIENTUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TEMPERATUREGRADIENTUNIT = 20;

	/**
	 * The '<em><b>ANGULARVELOCITYUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ANGULARVELOCITYUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANGULARVELOCITYUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ANGULARVELOCITYUNIT = 21;

	/**
	 * The '<em><b>CURVATUREUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CURVATUREUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CURVATUREUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CURVATUREUNIT = 22;

	/**
	 * The '<em><b>WARPINGMOMENTUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WARPINGMOMENTUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WARPINGMOMENTUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WARPINGMOMENTUNIT = 23;

	/**
	 * The '<em><b>ROTATIONALMASSUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROTATIONALMASSUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ROTATIONALMASSUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROTATIONALMASSUNIT = 24;

	/**
	 * The '<em><b>THERMALADMITTANCEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>THERMALADMITTANCEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #THERMALADMITTANCEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int THERMALADMITTANCEUNIT = 25;

	/**
	 * The '<em><b>MASSFLOWRATEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MASSFLOWRATEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MASSFLOWRATEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MASSFLOWRATEUNIT = 26;

	/**
	 * The '<em><b>SOUNDPOWERUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOUNDPOWERUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOUNDPOWERUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SOUNDPOWERUNIT = 27;

	/**
	 * The '<em><b>COMPOUNDPLANEANGLEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMPOUNDPLANEANGLEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMPOUNDPLANEANGLEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMPOUNDPLANEANGLEUNIT = 28;

	/**
	 * The '<em><b>ISOTHERMALMOISTURECAPACITYUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ISOTHERMALMOISTURECAPACITYUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ISOTHERMALMOISTURECAPACITYUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ISOTHERMALMOISTURECAPACITYUNIT = 29;

	/**
	 * The '<em><b>IONCONCENTRATIONUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IONCONCENTRATIONUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IONCONCENTRATIONUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IONCONCENTRATIONUNIT = 30;

	/**
	 * The '<em><b>ACCELERATIONUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ACCELERATIONUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACCELERATIONUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ACCELERATIONUNIT = 31;

	/**
	 * The '<em><b>MODULUSOFROTATIONALSUBGRADEREACTIONUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MODULUSOFROTATIONALSUBGRADEREACTIONUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MODULUSOFROTATIONALSUBGRADEREACTIONUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MODULUSOFROTATIONALSUBGRADEREACTIONUNIT = 32;

	/**
	 * The '<em><b>PLANARFORCEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PLANARFORCEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLANARFORCEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PLANARFORCEUNIT = 33;

	/**
	 * The '<em><b>MOISTUREDIFFUSIVITYUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MOISTUREDIFFUSIVITYUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MOISTUREDIFFUSIVITYUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MOISTUREDIFFUSIVITYUNIT = 34;

	/**
	 * The '<em><b>SECTIONAREAINTEGRALUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SECTIONAREAINTEGRALUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SECTIONAREAINTEGRALUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SECTIONAREAINTEGRALUNIT = 35;

	/**
	 * The '<em><b>MODULUSOFELASTICITYUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MODULUSOFELASTICITYUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MODULUSOFELASTICITYUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MODULUSOFELASTICITYUNIT = 36;

	/**
	 * The '<em><b>LINEARVELOCITYUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LINEARVELOCITYUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LINEARVELOCITYUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LINEARVELOCITYUNIT = 37;

	/**
	 * The '<em><b>MASSPERLENGTHUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MASSPERLENGTHUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MASSPERLENGTHUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MASSPERLENGTHUNIT = 38;

	/**
	 * The '<em><b>INTEGERCOUNTRATEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INTEGERCOUNTRATEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INTEGERCOUNTRATEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INTEGERCOUNTRATEUNIT = 39;

	/**
	 * The '<em><b>LINEARMOMENTUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LINEARMOMENTUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LINEARMOMENTUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LINEARMOMENTUNIT = 40;

	/**
	 * The '<em><b>SOUNDPRESSUREUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOUNDPRESSUREUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOUNDPRESSUREUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SOUNDPRESSUREUNIT = 41;

	/**
	 * The '<em><b>LINEARFORCEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LINEARFORCEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LINEARFORCEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LINEARFORCEUNIT = 42;

	/**
	 * The '<em><b>LUMINOUSINTENSITYDISTRIBUTIONUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LUMINOUSINTENSITYDISTRIBUTIONUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LUMINOUSINTENSITYDISTRIBUTIONUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LUMINOUSINTENSITYDISTRIBUTIONUNIT = 43;

	/**
	 * The '<em><b>PHUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PHUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PHUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PHUNIT = 44;

	/**
	 * The '<em><b>THERMALEXPANSIONCOEFFICIENTUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>THERMALEXPANSIONCOEFFICIENTUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #THERMALEXPANSIONCOEFFICIENTUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int THERMALEXPANSIONCOEFFICIENTUNIT = 45;

	/**
	 * The '<em><b>MODULUSOFLINEARSUBGRADEREACTIONUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MODULUSOFLINEARSUBGRADEREACTIONUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MODULUSOFLINEARSUBGRADEREACTIONUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MODULUSOFLINEARSUBGRADEREACTIONUNIT = 46;

	/**
	 * The '<em><b>WARPINGCONSTANTUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WARPINGCONSTANTUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WARPINGCONSTANTUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WARPINGCONSTANTUNIT = 47;

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>USERDEFINED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USERDEFINED = 48;

	/**
	 * The '<em><b>THERMALCONDUCTANCEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>THERMALCONDUCTANCEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #THERMALCONDUCTANCEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int THERMALCONDUCTANCEUNIT = 49;

	/**
	 * An array of all the '<em><b>Ifc Derived Unit Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcDerivedUnitEnum[] VALUES_ARRAY =
		new IfcDerivedUnitEnum[]
		{
			NULL_LITERAL,
			MOMENTOFINERTIAUNIT_LITERAL,
			MOLECULARWEIGHTUNIT_LITERAL,
			SECTIONMODULUSUNIT_LITERAL,
			HEATFLUXDENSITYUNIT_LITERAL,
			ROTATIONALFREQUENCYUNIT_LITERAL,
			THERMALTRANSMITTANCEUNIT_LITERAL,
			KINEMATICVISCOSITYUNIT_LITERAL,
			VOLUMETRICFLOWRATEUNIT_LITERAL,
			SPECIFICHEATCAPACITYUNIT_LITERAL,
			HEATINGVALUEUNIT_LITERAL,
			TORQUEUNIT_LITERAL,
			THERMALRESISTANCEUNIT_LITERAL,
			SHEARMODULUSUNIT_LITERAL,
			MODULUSOFSUBGRADEREACTIONUNIT_LITERAL,
			DYNAMICVISCOSITYUNIT_LITERAL,
			ROTATIONALSTIFFNESSUNIT_LITERAL,
			MASSDENSITYUNIT_LITERAL,
			LINEARSTIFFNESSUNIT_LITERAL,
			VAPORPERMEABILITYUNIT_LITERAL,
			TEMPERATUREGRADIENTUNIT_LITERAL,
			ANGULARVELOCITYUNIT_LITERAL,
			CURVATUREUNIT_LITERAL,
			WARPINGMOMENTUNIT_LITERAL,
			ROTATIONALMASSUNIT_LITERAL,
			THERMALADMITTANCEUNIT_LITERAL,
			MASSFLOWRATEUNIT_LITERAL,
			SOUNDPOWERUNIT_LITERAL,
			COMPOUNDPLANEANGLEUNIT_LITERAL,
			ISOTHERMALMOISTURECAPACITYUNIT_LITERAL,
			IONCONCENTRATIONUNIT_LITERAL,
			ACCELERATIONUNIT_LITERAL,
			MODULUSOFROTATIONALSUBGRADEREACTIONUNIT_LITERAL,
			PLANARFORCEUNIT_LITERAL,
			MOISTUREDIFFUSIVITYUNIT_LITERAL,
			SECTIONAREAINTEGRALUNIT_LITERAL,
			MODULUSOFELASTICITYUNIT_LITERAL,
			LINEARVELOCITYUNIT_LITERAL,
			MASSPERLENGTHUNIT_LITERAL,
			INTEGERCOUNTRATEUNIT_LITERAL,
			LINEARMOMENTUNIT_LITERAL,
			SOUNDPRESSUREUNIT_LITERAL,
			LINEARFORCEUNIT_LITERAL,
			LUMINOUSINTENSITYDISTRIBUTIONUNIT_LITERAL,
			PHUNIT_LITERAL,
			THERMALEXPANSIONCOEFFICIENTUNIT_LITERAL,
			MODULUSOFLINEARSUBGRADEREACTIONUNIT_LITERAL,
			WARPINGCONSTANTUNIT_LITERAL,
			USERDEFINED_LITERAL,
			THERMALCONDUCTANCEUNIT_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Derived Unit Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcDerivedUnitEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Derived Unit Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcDerivedUnitEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcDerivedUnitEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Derived Unit Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcDerivedUnitEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcDerivedUnitEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Derived Unit Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcDerivedUnitEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case MOMENTOFINERTIAUNIT: return MOMENTOFINERTIAUNIT_LITERAL;
			case MOLECULARWEIGHTUNIT: return MOLECULARWEIGHTUNIT_LITERAL;
			case SECTIONMODULUSUNIT: return SECTIONMODULUSUNIT_LITERAL;
			case HEATFLUXDENSITYUNIT: return HEATFLUXDENSITYUNIT_LITERAL;
			case ROTATIONALFREQUENCYUNIT: return ROTATIONALFREQUENCYUNIT_LITERAL;
			case THERMALTRANSMITTANCEUNIT: return THERMALTRANSMITTANCEUNIT_LITERAL;
			case KINEMATICVISCOSITYUNIT: return KINEMATICVISCOSITYUNIT_LITERAL;
			case VOLUMETRICFLOWRATEUNIT: return VOLUMETRICFLOWRATEUNIT_LITERAL;
			case SPECIFICHEATCAPACITYUNIT: return SPECIFICHEATCAPACITYUNIT_LITERAL;
			case HEATINGVALUEUNIT: return HEATINGVALUEUNIT_LITERAL;
			case TORQUEUNIT: return TORQUEUNIT_LITERAL;
			case THERMALRESISTANCEUNIT: return THERMALRESISTANCEUNIT_LITERAL;
			case SHEARMODULUSUNIT: return SHEARMODULUSUNIT_LITERAL;
			case MODULUSOFSUBGRADEREACTIONUNIT: return MODULUSOFSUBGRADEREACTIONUNIT_LITERAL;
			case DYNAMICVISCOSITYUNIT: return DYNAMICVISCOSITYUNIT_LITERAL;
			case ROTATIONALSTIFFNESSUNIT: return ROTATIONALSTIFFNESSUNIT_LITERAL;
			case MASSDENSITYUNIT: return MASSDENSITYUNIT_LITERAL;
			case LINEARSTIFFNESSUNIT: return LINEARSTIFFNESSUNIT_LITERAL;
			case VAPORPERMEABILITYUNIT: return VAPORPERMEABILITYUNIT_LITERAL;
			case TEMPERATUREGRADIENTUNIT: return TEMPERATUREGRADIENTUNIT_LITERAL;
			case ANGULARVELOCITYUNIT: return ANGULARVELOCITYUNIT_LITERAL;
			case CURVATUREUNIT: return CURVATUREUNIT_LITERAL;
			case WARPINGMOMENTUNIT: return WARPINGMOMENTUNIT_LITERAL;
			case ROTATIONALMASSUNIT: return ROTATIONALMASSUNIT_LITERAL;
			case THERMALADMITTANCEUNIT: return THERMALADMITTANCEUNIT_LITERAL;
			case MASSFLOWRATEUNIT: return MASSFLOWRATEUNIT_LITERAL;
			case SOUNDPOWERUNIT: return SOUNDPOWERUNIT_LITERAL;
			case COMPOUNDPLANEANGLEUNIT: return COMPOUNDPLANEANGLEUNIT_LITERAL;
			case ISOTHERMALMOISTURECAPACITYUNIT: return ISOTHERMALMOISTURECAPACITYUNIT_LITERAL;
			case IONCONCENTRATIONUNIT: return IONCONCENTRATIONUNIT_LITERAL;
			case ACCELERATIONUNIT: return ACCELERATIONUNIT_LITERAL;
			case MODULUSOFROTATIONALSUBGRADEREACTIONUNIT: return MODULUSOFROTATIONALSUBGRADEREACTIONUNIT_LITERAL;
			case PLANARFORCEUNIT: return PLANARFORCEUNIT_LITERAL;
			case MOISTUREDIFFUSIVITYUNIT: return MOISTUREDIFFUSIVITYUNIT_LITERAL;
			case SECTIONAREAINTEGRALUNIT: return SECTIONAREAINTEGRALUNIT_LITERAL;
			case MODULUSOFELASTICITYUNIT: return MODULUSOFELASTICITYUNIT_LITERAL;
			case LINEARVELOCITYUNIT: return LINEARVELOCITYUNIT_LITERAL;
			case MASSPERLENGTHUNIT: return MASSPERLENGTHUNIT_LITERAL;
			case INTEGERCOUNTRATEUNIT: return INTEGERCOUNTRATEUNIT_LITERAL;
			case LINEARMOMENTUNIT: return LINEARMOMENTUNIT_LITERAL;
			case SOUNDPRESSUREUNIT: return SOUNDPRESSUREUNIT_LITERAL;
			case LINEARFORCEUNIT: return LINEARFORCEUNIT_LITERAL;
			case LUMINOUSINTENSITYDISTRIBUTIONUNIT: return LUMINOUSINTENSITYDISTRIBUTIONUNIT_LITERAL;
			case PHUNIT: return PHUNIT_LITERAL;
			case THERMALEXPANSIONCOEFFICIENTUNIT: return THERMALEXPANSIONCOEFFICIENTUNIT_LITERAL;
			case MODULUSOFLINEARSUBGRADEREACTIONUNIT: return MODULUSOFLINEARSUBGRADEREACTIONUNIT_LITERAL;
			case WARPINGCONSTANTUNIT: return WARPINGCONSTANTUNIT_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case THERMALCONDUCTANCEUNIT: return THERMALCONDUCTANCEUNIT_LITERAL;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private IfcDerivedUnitEnum(int value, String name, String literal)
	{
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue()
	{
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral()
	{
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		return literal;
	}
	
} //IfcDerivedUnitEnum
