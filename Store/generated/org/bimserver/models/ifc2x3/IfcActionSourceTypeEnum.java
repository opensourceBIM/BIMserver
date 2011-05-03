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
 * A representation of the literals of the enumeration '<em><b>Ifc Action Source Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcActionSourceTypeEnum()
 * @model
 * @generated
 */
public enum IfcActionSourceTypeEnum implements Enumerator
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
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @generated
	 * @ordered
	 */
	NOTDEFINED_LITERAL(1, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>PRESTRESSING P</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRESTRESSING_P
	 * @generated
	 * @ordered
	 */
	PRESTRESSING_P_LITERAL(2, "PRESTRESSING_P", "PRESTRESSING_P"),

	/**
	 * The '<em><b>SNOW S</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SNOW_S
	 * @generated
	 * @ordered
	 */
	SNOW_S_LITERAL(3, "SNOW_S", "SNOW_S"),

	/**
	 * The '<em><b>ERECTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ERECTION
	 * @generated
	 * @ordered
	 */
	ERECTION_LITERAL(4, "ERECTION", "ERECTION"),

	/**
	 * The '<em><b>SETTLEMENT U</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SETTLEMENT_U
	 * @generated
	 * @ordered
	 */
	SETTLEMENT_U_LITERAL(5, "SETTLEMENT_U", "SETTLEMENT_U"),

	/**
	 * The '<em><b>IMPACT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IMPACT
	 * @generated
	 * @ordered
	 */
	IMPACT_LITERAL(6, "IMPACT", "IMPACT"),

	/**
	 * The '<em><b>LIVE LOAD Q</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIVE_LOAD_Q
	 * @generated
	 * @ordered
	 */
	LIVE_LOAD_Q_LITERAL(7, "LIVE_LOAD_Q", "LIVE_LOAD_Q"),

	/**
	 * The '<em><b>COMPLETION G1</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPLETION_G1
	 * @generated
	 * @ordered
	 */
	COMPLETION_G1_LITERAL(8, "COMPLETION_G1", "COMPLETION_G1"),

	/**
	 * The '<em><b>BUOYANCY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BUOYANCY
	 * @generated
	 * @ordered
	 */
	BUOYANCY_LITERAL(9, "BUOYANCY", "BUOYANCY"),

	/**
	 * The '<em><b>EARTHQUAKE E</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EARTHQUAKE_E
	 * @generated
	 * @ordered
	 */
	EARTHQUAKE_E_LITERAL(10, "EARTHQUAKE_E", "EARTHQUAKE_E"),

	/**
	 * The '<em><b>CURRENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CURRENT
	 * @generated
	 * @ordered
	 */
	CURRENT_LITERAL(11, "CURRENT", "CURRENT"),

	/**
	 * The '<em><b>FIRE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIRE
	 * @generated
	 * @ordered
	 */
	FIRE_LITERAL(12, "FIRE", "FIRE"),

	/**
	 * The '<em><b>WAVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WAVE
	 * @generated
	 * @ordered
	 */
	WAVE_LITERAL(13, "WAVE", "WAVE"),

	/**
	 * The '<em><b>TEMPERATURE T</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEMPERATURE_T
	 * @generated
	 * @ordered
	 */
	TEMPERATURE_T_LITERAL(14, "TEMPERATURE_T", "TEMPERATURE_T"),

	/**
	 * The '<em><b>ICE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ICE
	 * @generated
	 * @ordered
	 */
	ICE_LITERAL(15, "ICE", "ICE"),

	/**
	 * The '<em><b>CREEP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREEP
	 * @generated
	 * @ordered
	 */
	CREEP_LITERAL(16, "CREEP", "CREEP"),

	/**
	 * The '<em><b>RAIN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAIN
	 * @generated
	 * @ordered
	 */
	RAIN_LITERAL(17, "RAIN", "RAIN"),

	/**
	 * The '<em><b>PROPPING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROPPING
	 * @generated
	 * @ordered
	 */
	PROPPING_LITERAL(18, "PROPPING", "PROPPING"),

	/**
	 * The '<em><b>SYSTEM IMPERFECTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYSTEM_IMPERFECTION
	 * @generated
	 * @ordered
	 */
	SYSTEM_IMPERFECTION_LITERAL(19, "SYSTEM_IMPERFECTION", "SYSTEM_IMPERFECTION"),

	/**
	 * The '<em><b>TRANSPORT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSPORT
	 * @generated
	 * @ordered
	 */
	TRANSPORT_LITERAL(20, "TRANSPORT", "TRANSPORT"),

	/**
	 * The '<em><b>IMPULSE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IMPULSE
	 * @generated
	 * @ordered
	 */
	IMPULSE_LITERAL(21, "IMPULSE", "IMPULSE"),

	/**
	 * The '<em><b>BRAKES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BRAKES
	 * @generated
	 * @ordered
	 */
	BRAKES_LITERAL(22, "BRAKES", "BRAKES"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @generated
	 * @ordered
	 */
	USERDEFINED_LITERAL(23, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>SHRINKAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHRINKAGE
	 * @generated
	 * @ordered
	 */
	SHRINKAGE_LITERAL(24, "SHRINKAGE", "SHRINKAGE"),

	/**
	 * The '<em><b>DEAD LOAD G</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEAD_LOAD_G
	 * @generated
	 * @ordered
	 */
	DEAD_LOAD_G_LITERAL(25, "DEAD_LOAD_G", "DEAD_LOAD_G"),

	/**
	 * The '<em><b>WIND W</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WIND_W
	 * @generated
	 * @ordered
	 */
	WIND_W_LITERAL(26, "WIND_W", "WIND_W"),

	/**
	 * The '<em><b>LACK OF FIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LACK_OF_FIT
	 * @generated
	 * @ordered
	 */
	LACK_OF_FIT_LITERAL(27, "LACK_OF_FIT", "LACK_OF_FIT");

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
	 * The '<em><b>NOTDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOTDEFINED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTDEFINED = 1;

	/**
	 * The '<em><b>PRESTRESSING P</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRESTRESSING P</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRESTRESSING_P_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PRESTRESSING_P = 2;

	/**
	 * The '<em><b>SNOW S</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SNOW S</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SNOW_S_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SNOW_S = 3;

	/**
	 * The '<em><b>ERECTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ERECTION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ERECTION_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ERECTION = 4;

	/**
	 * The '<em><b>SETTLEMENT U</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SETTLEMENT U</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SETTLEMENT_U_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SETTLEMENT_U = 5;

	/**
	 * The '<em><b>IMPACT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IMPACT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IMPACT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IMPACT = 6;

	/**
	 * The '<em><b>LIVE LOAD Q</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LIVE LOAD Q</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LIVE_LOAD_Q_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LIVE_LOAD_Q = 7;

	/**
	 * The '<em><b>COMPLETION G1</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMPLETION G1</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMPLETION_G1_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMPLETION_G1 = 8;

	/**
	 * The '<em><b>BUOYANCY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BUOYANCY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BUOYANCY_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BUOYANCY = 9;

	/**
	 * The '<em><b>EARTHQUAKE E</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EARTHQUAKE E</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EARTHQUAKE_E_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EARTHQUAKE_E = 10;

	/**
	 * The '<em><b>CURRENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CURRENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CURRENT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CURRENT = 11;

	/**
	 * The '<em><b>FIRE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FIRE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIRE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FIRE = 12;

	/**
	 * The '<em><b>WAVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WAVE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WAVE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WAVE = 13;

	/**
	 * The '<em><b>TEMPERATURE T</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TEMPERATURE T</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TEMPERATURE_T_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TEMPERATURE_T = 14;

	/**
	 * The '<em><b>ICE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ICE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ICE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ICE = 15;

	/**
	 * The '<em><b>CREEP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CREEP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CREEP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CREEP = 16;

	/**
	 * The '<em><b>RAIN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RAIN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RAIN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RAIN = 17;

	/**
	 * The '<em><b>PROPPING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PROPPING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PROPPING_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PROPPING = 18;

	/**
	 * The '<em><b>SYSTEM IMPERFECTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SYSTEM IMPERFECTION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SYSTEM_IMPERFECTION_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SYSTEM_IMPERFECTION = 19;

	/**
	 * The '<em><b>TRANSPORT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRANSPORT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRANSPORT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRANSPORT = 20;

	/**
	 * The '<em><b>IMPULSE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IMPULSE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IMPULSE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IMPULSE = 21;

	/**
	 * The '<em><b>BRAKES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BRAKES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BRAKES_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BRAKES = 22;

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
	public static final int USERDEFINED = 23;

	/**
	 * The '<em><b>SHRINKAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SHRINKAGE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SHRINKAGE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SHRINKAGE = 24;

	/**
	 * The '<em><b>DEAD LOAD G</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DEAD LOAD G</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DEAD_LOAD_G_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DEAD_LOAD_G = 25;

	/**
	 * The '<em><b>WIND W</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WIND W</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WIND_W_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WIND_W = 26;

	/**
	 * The '<em><b>LACK OF FIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LACK OF FIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LACK_OF_FIT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LACK_OF_FIT = 27;

	/**
	 * An array of all the '<em><b>Ifc Action Source Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcActionSourceTypeEnum[] VALUES_ARRAY =
		new IfcActionSourceTypeEnum[]
		{
			NULL_LITERAL,
			NOTDEFINED_LITERAL,
			PRESTRESSING_P_LITERAL,
			SNOW_S_LITERAL,
			ERECTION_LITERAL,
			SETTLEMENT_U_LITERAL,
			IMPACT_LITERAL,
			LIVE_LOAD_Q_LITERAL,
			COMPLETION_G1_LITERAL,
			BUOYANCY_LITERAL,
			EARTHQUAKE_E_LITERAL,
			CURRENT_LITERAL,
			FIRE_LITERAL,
			WAVE_LITERAL,
			TEMPERATURE_T_LITERAL,
			ICE_LITERAL,
			CREEP_LITERAL,
			RAIN_LITERAL,
			PROPPING_LITERAL,
			SYSTEM_IMPERFECTION_LITERAL,
			TRANSPORT_LITERAL,
			IMPULSE_LITERAL,
			BRAKES_LITERAL,
			USERDEFINED_LITERAL,
			SHRINKAGE_LITERAL,
			DEAD_LOAD_G_LITERAL,
			WIND_W_LITERAL,
			LACK_OF_FIT_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Action Source Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcActionSourceTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Action Source Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcActionSourceTypeEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcActionSourceTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Action Source Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcActionSourceTypeEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcActionSourceTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Action Source Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcActionSourceTypeEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case PRESTRESSING_P: return PRESTRESSING_P_LITERAL;
			case SNOW_S: return SNOW_S_LITERAL;
			case ERECTION: return ERECTION_LITERAL;
			case SETTLEMENT_U: return SETTLEMENT_U_LITERAL;
			case IMPACT: return IMPACT_LITERAL;
			case LIVE_LOAD_Q: return LIVE_LOAD_Q_LITERAL;
			case COMPLETION_G1: return COMPLETION_G1_LITERAL;
			case BUOYANCY: return BUOYANCY_LITERAL;
			case EARTHQUAKE_E: return EARTHQUAKE_E_LITERAL;
			case CURRENT: return CURRENT_LITERAL;
			case FIRE: return FIRE_LITERAL;
			case WAVE: return WAVE_LITERAL;
			case TEMPERATURE_T: return TEMPERATURE_T_LITERAL;
			case ICE: return ICE_LITERAL;
			case CREEP: return CREEP_LITERAL;
			case RAIN: return RAIN_LITERAL;
			case PROPPING: return PROPPING_LITERAL;
			case SYSTEM_IMPERFECTION: return SYSTEM_IMPERFECTION_LITERAL;
			case TRANSPORT: return TRANSPORT_LITERAL;
			case IMPULSE: return IMPULSE_LITERAL;
			case BRAKES: return BRAKES_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case SHRINKAGE: return SHRINKAGE_LITERAL;
			case DEAD_LOAD_G: return DEAD_LOAD_G_LITERAL;
			case WIND_W: return WIND_W_LITERAL;
			case LACK_OF_FIT: return LACK_OF_FIT_LITERAL;
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
	private IfcActionSourceTypeEnum(int value, String name, String literal)
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
	
} //IfcActionSourceTypeEnum
