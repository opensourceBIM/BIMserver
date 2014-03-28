/**
 * Copyright (C) 2009-2013 BIMserver.org
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
package org.bimserver.models.ifc2x3tc1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Ifc Unit Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcUnitEnum()
 * @model
 * @generated
 */
public enum IfcUnitEnum implements Enumerator {
	/**
	 * The '<em><b>NULL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NULL_VALUE
	 * @generated
	 * @ordered
	 */
	NULL(0, "NULL", "NULL"),

	/**
	 * The '<em><b>ELECTRICRESISTANCEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELECTRICRESISTANCEUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	ELECTRICRESISTANCEUNIT(1, "ELECTRICRESISTANCEUNIT", "ELECTRICRESISTANCEUNIT"),

	/**
	 * The '<em><b>ELECTRICCURRENTUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELECTRICCURRENTUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	ELECTRICCURRENTUNIT(2, "ELECTRICCURRENTUNIT", "ELECTRICCURRENTUNIT"),

	/**
	 * The '<em><b>ILLUMINANCEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ILLUMINANCEUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	ILLUMINANCEUNIT(3, "ILLUMINANCEUNIT", "ILLUMINANCEUNIT"),

	/**
	 * The '<em><b>AREAUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AREAUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	AREAUNIT(4, "AREAUNIT", "AREAUNIT"), /**
											 * The '<em><b>FREQUENCYUNIT</b></em>' literal object.
											 * <!-- begin-user-doc -->
											 * <!-- end-user-doc -->
											 * @see #FREQUENCYUNIT_VALUE
											 * @generated
											 * @ordered
											 */
	FREQUENCYUNIT(5, "FREQUENCYUNIT", "FREQUENCYUNIT"),

	/**
	 * The '<em><b>TIMEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TIMEUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	TIMEUNIT(6, "TIMEUNIT", "TIMEUNIT"),

	/**
	 * The '<em><b>ELECTRICCHARGEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELECTRICCHARGEUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	ELECTRICCHARGEUNIT(7, "ELECTRICCHARGEUNIT", "ELECTRICCHARGEUNIT"),

	/**
	 * The '<em><b>FORCEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FORCEUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	FORCEUNIT(8, "FORCEUNIT", "FORCEUNIT"),

	/**
	 * The '<em><b>RADIOACTIVITYUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RADIOACTIVITYUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	RADIOACTIVITYUNIT(9, "RADIOACTIVITYUNIT", "RADIOACTIVITYUNIT"), /**
																	 * The '<em><b>LENGTHUNIT</b></em>' literal object.
																	 * <!-- begin-user-doc -->
																	 * <!-- end-user-doc -->
																	 * @see #LENGTHUNIT_VALUE
																	 * @generated
																	 * @ordered
																	 */
	LENGTHUNIT(10, "LENGTHUNIT", "LENGTHUNIT"),

	/**
	 * The '<em><b>DOSEEQUIVALENTUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOSEEQUIVALENTUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	DOSEEQUIVALENTUNIT(11, "DOSEEQUIVALENTUNIT", "DOSEEQUIVALENTUNIT"),

	/**
	 * The '<em><b>INDUCTANCEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INDUCTANCEUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	INDUCTANCEUNIT(12, "INDUCTANCEUNIT", "INDUCTANCEUNIT"),

	/**
	 * The '<em><b>MAGNETICFLUXDENSITYUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAGNETICFLUXDENSITYUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	MAGNETICFLUXDENSITYUNIT(13, "MAGNETICFLUXDENSITYUNIT", "MAGNETICFLUXDENSITYUNIT"),

	/**
	 * The '<em><b>LUMINOUSINTENSITYUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LUMINOUSINTENSITYUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	LUMINOUSINTENSITYUNIT(14, "LUMINOUSINTENSITYUNIT", "LUMINOUSINTENSITYUNIT"),

	/**
	 * The '<em><b>LUMINOUSFLUXUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LUMINOUSFLUXUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	LUMINOUSFLUXUNIT(15, "LUMINOUSFLUXUNIT", "LUMINOUSFLUXUNIT"),

	/**
	 * The '<em><b>VOLUMEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VOLUMEUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	VOLUMEUNIT(16, "VOLUMEUNIT", "VOLUMEUNIT"),

	/**
	 * The '<em><b>ELECTRICCONDUCTANCEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELECTRICCONDUCTANCEUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	ELECTRICCONDUCTANCEUNIT(17, "ELECTRICCONDUCTANCEUNIT", "ELECTRICCONDUCTANCEUNIT"),

	/**
	 * The '<em><b>AMOUNTOFSUBSTANCEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AMOUNTOFSUBSTANCEUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	AMOUNTOFSUBSTANCEUNIT(18, "AMOUNTOFSUBSTANCEUNIT", "AMOUNTOFSUBSTANCEUNIT"),

	/**
	 * The '<em><b>ENERGYUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENERGYUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	ENERGYUNIT(19, "ENERGYUNIT", "ENERGYUNIT"),

	/**
	 * The '<em><b>POWERUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POWERUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	POWERUNIT(20, "POWERUNIT", "POWERUNIT"),

	/**
	 * The '<em><b>SOLIDANGLEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOLIDANGLEUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	SOLIDANGLEUNIT(21, "SOLIDANGLEUNIT", "SOLIDANGLEUNIT"),

	/**
	 * The '<em><b>ELECTRICVOLTAGEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELECTRICVOLTAGEUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	ELECTRICVOLTAGEUNIT(22, "ELECTRICVOLTAGEUNIT", "ELECTRICVOLTAGEUNIT"),

	/**
	 * The '<em><b>ELECTRICCAPACITANCEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELECTRICCAPACITANCEUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	ELECTRICCAPACITANCEUNIT(23, "ELECTRICCAPACITANCEUNIT", "ELECTRICCAPACITANCEUNIT"),

	/**
	 * The '<em><b>PRESSUREUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRESSUREUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	PRESSUREUNIT(24, "PRESSUREUNIT", "PRESSUREUNIT"),

	/**
	 * The '<em><b>THERMODYNAMICTEMPERATUREUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #THERMODYNAMICTEMPERATUREUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	THERMODYNAMICTEMPERATUREUNIT(25, "THERMODYNAMICTEMPERATUREUNIT", "THERMODYNAMICTEMPERATUREUNIT"),

	/**
	 * The '<em><b>MASSUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MASSUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	MASSUNIT(26, "MASSUNIT", "MASSUNIT"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USERDEFINED(27, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>ABSORBEDDOSEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ABSORBEDDOSEUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	ABSORBEDDOSEUNIT(28, "ABSORBEDDOSEUNIT", "ABSORBEDDOSEUNIT"),

	/**
	 * The '<em><b>MAGNETICFLUXUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAGNETICFLUXUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	MAGNETICFLUXUNIT(29, "MAGNETICFLUXUNIT", "MAGNETICFLUXUNIT"),

	/**
	 * The '<em><b>PLANEANGLEUNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLANEANGLEUNIT_VALUE
	 * @generated
	 * @ordered
	 */
	PLANEANGLEUNIT(30, "PLANEANGLEUNIT", "PLANEANGLEUNIT");

	/**
	 * The '<em><b>NULL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NULL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NULL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NULL_VALUE = 0;

	/**
	 * The '<em><b>ELECTRICRESISTANCEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ELECTRICRESISTANCEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ELECTRICRESISTANCEUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ELECTRICRESISTANCEUNIT_VALUE = 1;

	/**
	 * The '<em><b>ELECTRICCURRENTUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ELECTRICCURRENTUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ELECTRICCURRENTUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ELECTRICCURRENTUNIT_VALUE = 2;

	/**
	 * The '<em><b>ILLUMINANCEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ILLUMINANCEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ILLUMINANCEUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ILLUMINANCEUNIT_VALUE = 3;

	/**
	 * The '<em><b>AREAUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AREAUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AREAUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AREAUNIT_VALUE = 4;

	/**
	 * The '<em><b>FREQUENCYUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FREQUENCYUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FREQUENCYUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FREQUENCYUNIT_VALUE = 5;

	/**
	 * The '<em><b>TIMEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TIMEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TIMEUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TIMEUNIT_VALUE = 6;

	/**
	 * The '<em><b>ELECTRICCHARGEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ELECTRICCHARGEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ELECTRICCHARGEUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ELECTRICCHARGEUNIT_VALUE = 7;

	/**
	 * The '<em><b>FORCEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FORCEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FORCEUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FORCEUNIT_VALUE = 8;

	/**
	 * The '<em><b>RADIOACTIVITYUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RADIOACTIVITYUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RADIOACTIVITYUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RADIOACTIVITYUNIT_VALUE = 9;

	/**
	 * The '<em><b>LENGTHUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LENGTHUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LENGTHUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LENGTHUNIT_VALUE = 10;

	/**
	 * The '<em><b>DOSEEQUIVALENTUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOSEEQUIVALENTUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOSEEQUIVALENTUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOSEEQUIVALENTUNIT_VALUE = 11;

	/**
	 * The '<em><b>INDUCTANCEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INDUCTANCEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INDUCTANCEUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INDUCTANCEUNIT_VALUE = 12;

	/**
	 * The '<em><b>MAGNETICFLUXDENSITYUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MAGNETICFLUXDENSITYUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAGNETICFLUXDENSITYUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MAGNETICFLUXDENSITYUNIT_VALUE = 13;

	/**
	 * The '<em><b>LUMINOUSINTENSITYUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LUMINOUSINTENSITYUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LUMINOUSINTENSITYUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LUMINOUSINTENSITYUNIT_VALUE = 14;

	/**
	 * The '<em><b>LUMINOUSFLUXUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LUMINOUSFLUXUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LUMINOUSFLUXUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LUMINOUSFLUXUNIT_VALUE = 15;

	/**
	 * The '<em><b>VOLUMEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VOLUMEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VOLUMEUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VOLUMEUNIT_VALUE = 16;

	/**
	 * The '<em><b>ELECTRICCONDUCTANCEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ELECTRICCONDUCTANCEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ELECTRICCONDUCTANCEUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ELECTRICCONDUCTANCEUNIT_VALUE = 17;

	/**
	 * The '<em><b>AMOUNTOFSUBSTANCEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AMOUNTOFSUBSTANCEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AMOUNTOFSUBSTANCEUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AMOUNTOFSUBSTANCEUNIT_VALUE = 18;

	/**
	 * The '<em><b>ENERGYUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ENERGYUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENERGYUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ENERGYUNIT_VALUE = 19;

	/**
	 * The '<em><b>POWERUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>POWERUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #POWERUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int POWERUNIT_VALUE = 20;

	/**
	 * The '<em><b>SOLIDANGLEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOLIDANGLEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOLIDANGLEUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SOLIDANGLEUNIT_VALUE = 21;

	/**
	 * The '<em><b>ELECTRICVOLTAGEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ELECTRICVOLTAGEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ELECTRICVOLTAGEUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ELECTRICVOLTAGEUNIT_VALUE = 22;

	/**
	 * The '<em><b>ELECTRICCAPACITANCEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ELECTRICCAPACITANCEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ELECTRICCAPACITANCEUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ELECTRICCAPACITANCEUNIT_VALUE = 23;

	/**
	 * The '<em><b>PRESSUREUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRESSUREUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRESSUREUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PRESSUREUNIT_VALUE = 24;

	/**
	 * The '<em><b>THERMODYNAMICTEMPERATUREUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>THERMODYNAMICTEMPERATUREUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #THERMODYNAMICTEMPERATUREUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int THERMODYNAMICTEMPERATUREUNIT_VALUE = 25;

	/**
	 * The '<em><b>MASSUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MASSUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MASSUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MASSUNIT_VALUE = 26;

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>USERDEFINED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USERDEFINED_VALUE = 27;

	/**
	 * The '<em><b>ABSORBEDDOSEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ABSORBEDDOSEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ABSORBEDDOSEUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ABSORBEDDOSEUNIT_VALUE = 28;

	/**
	 * The '<em><b>MAGNETICFLUXUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MAGNETICFLUXUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAGNETICFLUXUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MAGNETICFLUXUNIT_VALUE = 29;

	/**
	 * The '<em><b>PLANEANGLEUNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PLANEANGLEUNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLANEANGLEUNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PLANEANGLEUNIT_VALUE = 30;

	/**
	 * An array of all the '<em><b>Ifc Unit Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcUnitEnum[] VALUES_ARRAY = new IfcUnitEnum[] { NULL, ELECTRICRESISTANCEUNIT, ELECTRICCURRENTUNIT, ILLUMINANCEUNIT, AREAUNIT, FREQUENCYUNIT, TIMEUNIT,
			ELECTRICCHARGEUNIT, FORCEUNIT, RADIOACTIVITYUNIT, LENGTHUNIT, DOSEEQUIVALENTUNIT, INDUCTANCEUNIT, MAGNETICFLUXDENSITYUNIT, LUMINOUSINTENSITYUNIT, LUMINOUSFLUXUNIT,
			VOLUMEUNIT, ELECTRICCONDUCTANCEUNIT, AMOUNTOFSUBSTANCEUNIT, ENERGYUNIT, POWERUNIT, SOLIDANGLEUNIT, ELECTRICVOLTAGEUNIT, ELECTRICCAPACITANCEUNIT, PRESSUREUNIT,
			THERMODYNAMICTEMPERATUREUNIT, MASSUNIT, USERDEFINED, ABSORBEDDOSEUNIT, MAGNETICFLUXUNIT, PLANEANGLEUNIT, };

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
	public static IfcUnitEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcUnitEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
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
	public static IfcUnitEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcUnitEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
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
	public static IfcUnitEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case ELECTRICRESISTANCEUNIT_VALUE:
			return ELECTRICRESISTANCEUNIT;
		case ELECTRICCURRENTUNIT_VALUE:
			return ELECTRICCURRENTUNIT;
		case ILLUMINANCEUNIT_VALUE:
			return ILLUMINANCEUNIT;
		case AREAUNIT_VALUE:
			return AREAUNIT;
		case FREQUENCYUNIT_VALUE:
			return FREQUENCYUNIT;
		case TIMEUNIT_VALUE:
			return TIMEUNIT;
		case ELECTRICCHARGEUNIT_VALUE:
			return ELECTRICCHARGEUNIT;
		case FORCEUNIT_VALUE:
			return FORCEUNIT;
		case RADIOACTIVITYUNIT_VALUE:
			return RADIOACTIVITYUNIT;
		case LENGTHUNIT_VALUE:
			return LENGTHUNIT;
		case DOSEEQUIVALENTUNIT_VALUE:
			return DOSEEQUIVALENTUNIT;
		case INDUCTANCEUNIT_VALUE:
			return INDUCTANCEUNIT;
		case MAGNETICFLUXDENSITYUNIT_VALUE:
			return MAGNETICFLUXDENSITYUNIT;
		case LUMINOUSINTENSITYUNIT_VALUE:
			return LUMINOUSINTENSITYUNIT;
		case LUMINOUSFLUXUNIT_VALUE:
			return LUMINOUSFLUXUNIT;
		case VOLUMEUNIT_VALUE:
			return VOLUMEUNIT;
		case ELECTRICCONDUCTANCEUNIT_VALUE:
			return ELECTRICCONDUCTANCEUNIT;
		case AMOUNTOFSUBSTANCEUNIT_VALUE:
			return AMOUNTOFSUBSTANCEUNIT;
		case ENERGYUNIT_VALUE:
			return ENERGYUNIT;
		case POWERUNIT_VALUE:
			return POWERUNIT;
		case SOLIDANGLEUNIT_VALUE:
			return SOLIDANGLEUNIT;
		case ELECTRICVOLTAGEUNIT_VALUE:
			return ELECTRICVOLTAGEUNIT;
		case ELECTRICCAPACITANCEUNIT_VALUE:
			return ELECTRICCAPACITANCEUNIT;
		case PRESSUREUNIT_VALUE:
			return PRESSUREUNIT;
		case THERMODYNAMICTEMPERATUREUNIT_VALUE:
			return THERMODYNAMICTEMPERATUREUNIT;
		case MASSUNIT_VALUE:
			return MASSUNIT;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case ABSORBEDDOSEUNIT_VALUE:
			return ABSORBEDDOSEUNIT;
		case MAGNETICFLUXUNIT_VALUE:
			return MAGNETICFLUXUNIT;
		case PLANEANGLEUNIT_VALUE:
			return PLANEANGLEUNIT;
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
	private IfcUnitEnum(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} //IfcUnitEnum
