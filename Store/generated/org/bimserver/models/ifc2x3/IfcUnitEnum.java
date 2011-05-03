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
 * A representation of the literals of the enumeration '<em><b>Ifc Unit Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcUnitEnum()
 * @model
 * @generated
 */
public enum IfcUnitEnum implements Enumerator
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
	 * The '<em><b>ELECTRICRESISTANCEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELECTRICRESISTANCEUNIT
	 * @generated
	 * @ordered
	 */
	ELECTRICRESISTANCEUNIT_LITERAL(1, "ELECTRICRESISTANCEUNIT", "ELECTRICRESISTANCEUNIT"),

	/**
	 * The '<em><b>ELECTRICCURRENTUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELECTRICCURRENTUNIT
	 * @generated
	 * @ordered
	 */
	ELECTRICCURRENTUNIT_LITERAL(2, "ELECTRICCURRENTUNIT", "ELECTRICCURRENTUNIT"),

	/**
	 * The '<em><b>ILLUMINANCEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ILLUMINANCEUNIT
	 * @generated
	 * @ordered
	 */
	ILLUMINANCEUNIT_LITERAL(3, "ILLUMINANCEUNIT", "ILLUMINANCEUNIT"),

	/**
	 * The '<em><b>FREQUENCYUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FREQUENCYUNIT
	 * @generated
	 * @ordered
	 */
	FREQUENCYUNIT_LITERAL(4, "FREQUENCYUNIT", "FREQUENCYUNIT"),

	/**
	 * The '<em><b>AREAUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AREAUNIT
	 * @generated
	 * @ordered
	 */
	AREAUNIT_LITERAL(5, "AREAUNIT", "AREAUNIT"),

	/**
	 * The '<em><b>TIMEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TIMEUNIT
	 * @generated
	 * @ordered
	 */
	TIMEUNIT_LITERAL(6, "TIMEUNIT", "TIMEUNIT"),

	/**
	 * The '<em><b>ELECTRICCHARGEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELECTRICCHARGEUNIT
	 * @generated
	 * @ordered
	 */
	ELECTRICCHARGEUNIT_LITERAL(7, "ELECTRICCHARGEUNIT", "ELECTRICCHARGEUNIT"),

	/**
	 * The '<em><b>FORCEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FORCEUNIT
	 * @generated
	 * @ordered
	 */
	FORCEUNIT_LITERAL(8, "FORCEUNIT", "FORCEUNIT"),

	/**
	 * The '<em><b>LENGTHUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LENGTHUNIT
	 * @generated
	 * @ordered
	 */
	LENGTHUNIT_LITERAL(9, "LENGTHUNIT", "LENGTHUNIT"),

	/**
	 * The '<em><b>RADIOACTIVITYUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RADIOACTIVITYUNIT
	 * @generated
	 * @ordered
	 */
	RADIOACTIVITYUNIT_LITERAL(10, "RADIOACTIVITYUNIT", "RADIOACTIVITYUNIT"),

	/**
	 * The '<em><b>DOSEEQUIVALENTUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOSEEQUIVALENTUNIT
	 * @generated
	 * @ordered
	 */
	DOSEEQUIVALENTUNIT_LITERAL(11, "DOSEEQUIVALENTUNIT", "DOSEEQUIVALENTUNIT"),

	/**
	 * The '<em><b>INDUCTANCEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INDUCTANCEUNIT
	 * @generated
	 * @ordered
	 */
	INDUCTANCEUNIT_LITERAL(12, "INDUCTANCEUNIT", "INDUCTANCEUNIT"),

	/**
	 * The '<em><b>MAGNETICFLUXDENSITYUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAGNETICFLUXDENSITYUNIT
	 * @generated
	 * @ordered
	 */
	MAGNETICFLUXDENSITYUNIT_LITERAL(13, "MAGNETICFLUXDENSITYUNIT", "MAGNETICFLUXDENSITYUNIT"),

	/**
	 * The '<em><b>LUMINOUSINTENSITYUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LUMINOUSINTENSITYUNIT
	 * @generated
	 * @ordered
	 */
	LUMINOUSINTENSITYUNIT_LITERAL(14, "LUMINOUSINTENSITYUNIT", "LUMINOUSINTENSITYUNIT"),

	/**
	 * The '<em><b>LUMINOUSFLUXUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LUMINOUSFLUXUNIT
	 * @generated
	 * @ordered
	 */
	LUMINOUSFLUXUNIT_LITERAL(15, "LUMINOUSFLUXUNIT", "LUMINOUSFLUXUNIT"),

	/**
	 * The '<em><b>VOLUMEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VOLUMEUNIT
	 * @generated
	 * @ordered
	 */
	VOLUMEUNIT_LITERAL(16, "VOLUMEUNIT", "VOLUMEUNIT"),

	/**
	 * The '<em><b>ELECTRICCONDUCTANCEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELECTRICCONDUCTANCEUNIT
	 * @generated
	 * @ordered
	 */
	ELECTRICCONDUCTANCEUNIT_LITERAL(17, "ELECTRICCONDUCTANCEUNIT", "ELECTRICCONDUCTANCEUNIT"),

	/**
	 * The '<em><b>AMOUNTOFSUBSTANCEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AMOUNTOFSUBSTANCEUNIT
	 * @generated
	 * @ordered
	 */
	AMOUNTOFSUBSTANCEUNIT_LITERAL(18, "AMOUNTOFSUBSTANCEUNIT", "AMOUNTOFSUBSTANCEUNIT"),

	/**
	 * The '<em><b>ENERGYUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENERGYUNIT
	 * @generated
	 * @ordered
	 */
	ENERGYUNIT_LITERAL(19, "ENERGYUNIT", "ENERGYUNIT"),

	/**
	 * The '<em><b>POWERUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POWERUNIT
	 * @generated
	 * @ordered
	 */
	POWERUNIT_LITERAL(20, "POWERUNIT", "POWERUNIT"),

	/**
	 * The '<em><b>SOLIDANGLEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOLIDANGLEUNIT
	 * @generated
	 * @ordered
	 */
	SOLIDANGLEUNIT_LITERAL(21, "SOLIDANGLEUNIT", "SOLIDANGLEUNIT"),

	/**
	 * The '<em><b>ELECTRICVOLTAGEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELECTRICVOLTAGEUNIT
	 * @generated
	 * @ordered
	 */
	ELECTRICVOLTAGEUNIT_LITERAL(22, "ELECTRICVOLTAGEUNIT", "ELECTRICVOLTAGEUNIT"),

	/**
	 * The '<em><b>ELECTRICCAPACITANCEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELECTRICCAPACITANCEUNIT
	 * @generated
	 * @ordered
	 */
	ELECTRICCAPACITANCEUNIT_LITERAL(23, "ELECTRICCAPACITANCEUNIT", "ELECTRICCAPACITANCEUNIT"),

	/**
	 * The '<em><b>PRESSUREUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRESSUREUNIT
	 * @generated
	 * @ordered
	 */
	PRESSUREUNIT_LITERAL(24, "PRESSUREUNIT", "PRESSUREUNIT"),

	/**
	 * The '<em><b>THERMODYNAMICTEMPERATUREUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #THERMODYNAMICTEMPERATUREUNIT
	 * @generated
	 * @ordered
	 */
	THERMODYNAMICTEMPERATUREUNIT_LITERAL(25, "THERMODYNAMICTEMPERATUREUNIT", "THERMODYNAMICTEMPERATUREUNIT"),

	/**
	 * The '<em><b>MASSUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MASSUNIT
	 * @generated
	 * @ordered
	 */
	MASSUNIT_LITERAL(26, "MASSUNIT", "MASSUNIT"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @generated
	 * @ordered
	 */
	USERDEFINED_LITERAL(27, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>ABSORBEDDOSEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ABSORBEDDOSEUNIT
	 * @generated
	 * @ordered
	 */
	ABSORBEDDOSEUNIT_LITERAL(28, "ABSORBEDDOSEUNIT", "ABSORBEDDOSEUNIT"),

	/**
	 * The '<em><b>MAGNETICFLUXUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAGNETICFLUXUNIT
	 * @generated
	 * @ordered
	 */
	MAGNETICFLUXUNIT_LITERAL(29, "MAGNETICFLUXUNIT", "MAGNETICFLUXUNIT"),

	/**
	 * The '<em><b>PLANEANGLEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLANEANGLEUNIT
	 * @generated
	 * @ordered
	 */
	PLANEANGLEUNIT_LITERAL(30, "PLANEANGLEUNIT", "PLANEANGLEUNIT");

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
	 * The '<em><b>ELECTRICRESISTANCEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ELECTRICRESISTANCEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ELECTRICRESISTANCEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ELECTRICRESISTANCEUNIT = 1;

	/**
	 * The '<em><b>ELECTRICCURRENTUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ELECTRICCURRENTUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ELECTRICCURRENTUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ELECTRICCURRENTUNIT = 2;

	/**
	 * The '<em><b>ILLUMINANCEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ILLUMINANCEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ILLUMINANCEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ILLUMINANCEUNIT = 3;

	/**
	 * The '<em><b>FREQUENCYUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FREQUENCYUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FREQUENCYUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FREQUENCYUNIT = 4;

	/**
	 * The '<em><b>AREAUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AREAUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AREAUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AREAUNIT = 5;

	/**
	 * The '<em><b>TIMEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TIMEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TIMEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TIMEUNIT = 6;

	/**
	 * The '<em><b>ELECTRICCHARGEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ELECTRICCHARGEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ELECTRICCHARGEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ELECTRICCHARGEUNIT = 7;

	/**
	 * The '<em><b>FORCEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FORCEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FORCEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FORCEUNIT = 8;

	/**
	 * The '<em><b>LENGTHUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LENGTHUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LENGTHUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LENGTHUNIT = 9;

	/**
	 * The '<em><b>RADIOACTIVITYUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RADIOACTIVITYUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RADIOACTIVITYUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RADIOACTIVITYUNIT = 10;

	/**
	 * The '<em><b>DOSEEQUIVALENTUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOSEEQUIVALENTUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOSEEQUIVALENTUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOSEEQUIVALENTUNIT = 11;

	/**
	 * The '<em><b>INDUCTANCEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INDUCTANCEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INDUCTANCEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INDUCTANCEUNIT = 12;

	/**
	 * The '<em><b>MAGNETICFLUXDENSITYUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MAGNETICFLUXDENSITYUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAGNETICFLUXDENSITYUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MAGNETICFLUXDENSITYUNIT = 13;

	/**
	 * The '<em><b>LUMINOUSINTENSITYUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LUMINOUSINTENSITYUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LUMINOUSINTENSITYUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LUMINOUSINTENSITYUNIT = 14;

	/**
	 * The '<em><b>LUMINOUSFLUXUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LUMINOUSFLUXUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LUMINOUSFLUXUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LUMINOUSFLUXUNIT = 15;

	/**
	 * The '<em><b>VOLUMEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VOLUMEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VOLUMEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VOLUMEUNIT = 16;

	/**
	 * The '<em><b>ELECTRICCONDUCTANCEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ELECTRICCONDUCTANCEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ELECTRICCONDUCTANCEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ELECTRICCONDUCTANCEUNIT = 17;

	/**
	 * The '<em><b>AMOUNTOFSUBSTANCEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AMOUNTOFSUBSTANCEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AMOUNTOFSUBSTANCEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AMOUNTOFSUBSTANCEUNIT = 18;

	/**
	 * The '<em><b>ENERGYUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ENERGYUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENERGYUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ENERGYUNIT = 19;

	/**
	 * The '<em><b>POWERUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>POWERUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #POWERUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int POWERUNIT = 20;

	/**
	 * The '<em><b>SOLIDANGLEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOLIDANGLEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOLIDANGLEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SOLIDANGLEUNIT = 21;

	/**
	 * The '<em><b>ELECTRICVOLTAGEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ELECTRICVOLTAGEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ELECTRICVOLTAGEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ELECTRICVOLTAGEUNIT = 22;

	/**
	 * The '<em><b>ELECTRICCAPACITANCEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ELECTRICCAPACITANCEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ELECTRICCAPACITANCEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ELECTRICCAPACITANCEUNIT = 23;

	/**
	 * The '<em><b>PRESSUREUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRESSUREUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRESSUREUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PRESSUREUNIT = 24;

	/**
	 * The '<em><b>THERMODYNAMICTEMPERATUREUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>THERMODYNAMICTEMPERATUREUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #THERMODYNAMICTEMPERATUREUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int THERMODYNAMICTEMPERATUREUNIT = 25;

	/**
	 * The '<em><b>MASSUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MASSUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MASSUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MASSUNIT = 26;

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
	public static final int USERDEFINED = 27;

	/**
	 * The '<em><b>ABSORBEDDOSEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ABSORBEDDOSEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ABSORBEDDOSEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ABSORBEDDOSEUNIT = 28;

	/**
	 * The '<em><b>MAGNETICFLUXUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MAGNETICFLUXUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAGNETICFLUXUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MAGNETICFLUXUNIT = 29;

	/**
	 * The '<em><b>PLANEANGLEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PLANEANGLEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLANEANGLEUNIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PLANEANGLEUNIT = 30;

	/**
	 * An array of all the '<em><b>Ifc Unit Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcUnitEnum[] VALUES_ARRAY =
		new IfcUnitEnum[]
		{
			NULL_LITERAL,
			ELECTRICRESISTANCEUNIT_LITERAL,
			ELECTRICCURRENTUNIT_LITERAL,
			ILLUMINANCEUNIT_LITERAL,
			FREQUENCYUNIT_LITERAL,
			AREAUNIT_LITERAL,
			TIMEUNIT_LITERAL,
			ELECTRICCHARGEUNIT_LITERAL,
			FORCEUNIT_LITERAL,
			LENGTHUNIT_LITERAL,
			RADIOACTIVITYUNIT_LITERAL,
			DOSEEQUIVALENTUNIT_LITERAL,
			INDUCTANCEUNIT_LITERAL,
			MAGNETICFLUXDENSITYUNIT_LITERAL,
			LUMINOUSINTENSITYUNIT_LITERAL,
			LUMINOUSFLUXUNIT_LITERAL,
			VOLUMEUNIT_LITERAL,
			ELECTRICCONDUCTANCEUNIT_LITERAL,
			AMOUNTOFSUBSTANCEUNIT_LITERAL,
			ENERGYUNIT_LITERAL,
			POWERUNIT_LITERAL,
			SOLIDANGLEUNIT_LITERAL,
			ELECTRICVOLTAGEUNIT_LITERAL,
			ELECTRICCAPACITANCEUNIT_LITERAL,
			PRESSUREUNIT_LITERAL,
			THERMODYNAMICTEMPERATUREUNIT_LITERAL,
			MASSUNIT_LITERAL,
			USERDEFINED_LITERAL,
			ABSORBEDDOSEUNIT_LITERAL,
			MAGNETICFLUXUNIT_LITERAL,
			PLANEANGLEUNIT_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Unit Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcUnitEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Unit Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcUnitEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcUnitEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Unit Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcUnitEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcUnitEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Unit Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcUnitEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case ELECTRICRESISTANCEUNIT: return ELECTRICRESISTANCEUNIT_LITERAL;
			case ELECTRICCURRENTUNIT: return ELECTRICCURRENTUNIT_LITERAL;
			case ILLUMINANCEUNIT: return ILLUMINANCEUNIT_LITERAL;
			case FREQUENCYUNIT: return FREQUENCYUNIT_LITERAL;
			case AREAUNIT: return AREAUNIT_LITERAL;
			case TIMEUNIT: return TIMEUNIT_LITERAL;
			case ELECTRICCHARGEUNIT: return ELECTRICCHARGEUNIT_LITERAL;
			case FORCEUNIT: return FORCEUNIT_LITERAL;
			case LENGTHUNIT: return LENGTHUNIT_LITERAL;
			case RADIOACTIVITYUNIT: return RADIOACTIVITYUNIT_LITERAL;
			case DOSEEQUIVALENTUNIT: return DOSEEQUIVALENTUNIT_LITERAL;
			case INDUCTANCEUNIT: return INDUCTANCEUNIT_LITERAL;
			case MAGNETICFLUXDENSITYUNIT: return MAGNETICFLUXDENSITYUNIT_LITERAL;
			case LUMINOUSINTENSITYUNIT: return LUMINOUSINTENSITYUNIT_LITERAL;
			case LUMINOUSFLUXUNIT: return LUMINOUSFLUXUNIT_LITERAL;
			case VOLUMEUNIT: return VOLUMEUNIT_LITERAL;
			case ELECTRICCONDUCTANCEUNIT: return ELECTRICCONDUCTANCEUNIT_LITERAL;
			case AMOUNTOFSUBSTANCEUNIT: return AMOUNTOFSUBSTANCEUNIT_LITERAL;
			case ENERGYUNIT: return ENERGYUNIT_LITERAL;
			case POWERUNIT: return POWERUNIT_LITERAL;
			case SOLIDANGLEUNIT: return SOLIDANGLEUNIT_LITERAL;
			case ELECTRICVOLTAGEUNIT: return ELECTRICVOLTAGEUNIT_LITERAL;
			case ELECTRICCAPACITANCEUNIT: return ELECTRICCAPACITANCEUNIT_LITERAL;
			case PRESSUREUNIT: return PRESSUREUNIT_LITERAL;
			case THERMODYNAMICTEMPERATUREUNIT: return THERMODYNAMICTEMPERATUREUNIT_LITERAL;
			case MASSUNIT: return MASSUNIT_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case ABSORBEDDOSEUNIT: return ABSORBEDDOSEUNIT_LITERAL;
			case MAGNETICFLUXUNIT: return MAGNETICFLUXUNIT_LITERAL;
			case PLANEANGLEUNIT: return PLANEANGLEUNIT_LITERAL;
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
	private IfcUnitEnum(int value, String name, String literal)
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
	
} //IfcUnitEnum
