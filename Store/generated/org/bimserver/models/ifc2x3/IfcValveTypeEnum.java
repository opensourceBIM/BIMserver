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
 * A representation of the literals of the enumeration '<em><b>Ifc Valve Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcValveTypeEnum()
 * @model
 * @generated
 */
public enum IfcValveTypeEnum implements Enumerator
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
	 * The '<em><b>FAUCET</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAUCET
	 * @generated
	 * @ordered
	 */
	FAUCET_LITERAL(1, "FAUCET", "FAUCET"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @generated
	 * @ordered
	 */
	NOTDEFINED_LITERAL(2, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>ISOLATING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ISOLATING
	 * @generated
	 * @ordered
	 */
	ISOLATING_LITERAL(3, "ISOLATING", "ISOLATING"),

	/**
	 * The '<em><b>COMMISSIONING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMMISSIONING
	 * @generated
	 * @ordered
	 */
	COMMISSIONING_LITERAL(4, "COMMISSIONING", "COMMISSIONING"),

	/**
	 * The '<em><b>DOUBLECHECK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLECHECK
	 * @generated
	 * @ordered
	 */
	DOUBLECHECK_LITERAL(5, "DOUBLECHECK", "DOUBLECHECK"),

	/**
	 * The '<em><b>STOPCOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STOPCOCK
	 * @generated
	 * @ordered
	 */
	STOPCOCK_LITERAL(6, "STOPCOCK", "STOPCOCK"),

	/**
	 * The '<em><b>PRESSUREREDUCING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRESSUREREDUCING
	 * @generated
	 * @ordered
	 */
	PRESSUREREDUCING_LITERAL(7, "PRESSUREREDUCING", "PRESSUREREDUCING"),

	/**
	 * The '<em><b>STEAMTRAP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STEAMTRAP
	 * @generated
	 * @ordered
	 */
	STEAMTRAP_LITERAL(8, "STEAMTRAP", "STEAMTRAP"),

	/**
	 * The '<em><b>GASTAP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GASTAP
	 * @generated
	 * @ordered
	 */
	GASTAP_LITERAL(9, "GASTAP", "GASTAP"),

	/**
	 * The '<em><b>DOUBLEREGULATING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOUBLEREGULATING
	 * @generated
	 * @ordered
	 */
	DOUBLEREGULATING_LITERAL(10, "DOUBLEREGULATING", "DOUBLEREGULATING"),

	/**
	 * The '<em><b>ANTIVACUUM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANTIVACUUM
	 * @generated
	 * @ordered
	 */
	ANTIVACUUM_LITERAL(11, "ANTIVACUUM", "ANTIVACUUM"),

	/**
	 * The '<em><b>SAFETYCUTOFF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SAFETYCUTOFF
	 * @generated
	 * @ordered
	 */
	SAFETYCUTOFF_LITERAL(12, "SAFETYCUTOFF", "SAFETYCUTOFF"),

	/**
	 * The '<em><b>REGULATING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REGULATING
	 * @generated
	 * @ordered
	 */
	REGULATING_LITERAL(13, "REGULATING", "REGULATING"),

	/**
	 * The '<em><b>CHANGEOVER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGEOVER
	 * @generated
	 * @ordered
	 */
	CHANGEOVER_LITERAL(14, "CHANGEOVER", "CHANGEOVER"),

	/**
	 * The '<em><b>CHECK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHECK
	 * @generated
	 * @ordered
	 */
	CHECK_LITERAL(15, "CHECK", "CHECK"),

	/**
	 * The '<em><b>DIVERTING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIVERTING
	 * @generated
	 * @ordered
	 */
	DIVERTING_LITERAL(16, "DIVERTING", "DIVERTING"),

	/**
	 * The '<em><b>DRAWOFFCOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DRAWOFFCOCK
	 * @generated
	 * @ordered
	 */
	DRAWOFFCOCK_LITERAL(17, "DRAWOFFCOCK", "DRAWOFFCOCK"),

	/**
	 * The '<em><b>PRESSURERELIEF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRESSURERELIEF
	 * @generated
	 * @ordered
	 */
	PRESSURERELIEF_LITERAL(18, "PRESSURERELIEF", "PRESSURERELIEF"),

	/**
	 * The '<em><b>MIXING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MIXING
	 * @generated
	 * @ordered
	 */
	MIXING_LITERAL(19, "MIXING", "MIXING"),

	/**
	 * The '<em><b>FLUSHING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FLUSHING
	 * @generated
	 * @ordered
	 */
	FLUSHING_LITERAL(20, "FLUSHING", "FLUSHING"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @generated
	 * @ordered
	 */
	USERDEFINED_LITERAL(21, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>GASCOCK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GASCOCK
	 * @generated
	 * @ordered
	 */
	GASCOCK_LITERAL(22, "GASCOCK", "GASCOCK"),

	/**
	 * The '<em><b>AIRRELEASE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AIRRELEASE
	 * @generated
	 * @ordered
	 */
	AIRRELEASE_LITERAL(23, "AIRRELEASE", "AIRRELEASE");

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
	 * The '<em><b>FAUCET</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FAUCET</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FAUCET_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FAUCET = 1;

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
	public static final int NOTDEFINED = 2;

	/**
	 * The '<em><b>ISOLATING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ISOLATING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ISOLATING_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ISOLATING = 3;

	/**
	 * The '<em><b>COMMISSIONING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMMISSIONING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMMISSIONING_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMMISSIONING = 4;

	/**
	 * The '<em><b>DOUBLECHECK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLECHECK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLECHECK_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLECHECK = 5;

	/**
	 * The '<em><b>STOPCOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STOPCOCK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STOPCOCK_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STOPCOCK = 6;

	/**
	 * The '<em><b>PRESSUREREDUCING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRESSUREREDUCING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRESSUREREDUCING_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PRESSUREREDUCING = 7;

	/**
	 * The '<em><b>STEAMTRAP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STEAMTRAP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STEAMTRAP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STEAMTRAP = 8;

	/**
	 * The '<em><b>GASTAP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GASTAP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GASTAP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GASTAP = 9;

	/**
	 * The '<em><b>DOUBLEREGULATING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOUBLEREGULATING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOUBLEREGULATING_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOUBLEREGULATING = 10;

	/**
	 * The '<em><b>ANTIVACUUM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ANTIVACUUM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANTIVACUUM_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ANTIVACUUM = 11;

	/**
	 * The '<em><b>SAFETYCUTOFF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SAFETYCUTOFF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SAFETYCUTOFF_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SAFETYCUTOFF = 12;

	/**
	 * The '<em><b>REGULATING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REGULATING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REGULATING_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REGULATING = 13;

	/**
	 * The '<em><b>CHANGEOVER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CHANGEOVER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHANGEOVER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHANGEOVER = 14;

	/**
	 * The '<em><b>CHECK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CHECK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHECK_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHECK = 15;

	/**
	 * The '<em><b>DIVERTING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIVERTING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIVERTING_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIVERTING = 16;

	/**
	 * The '<em><b>DRAWOFFCOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DRAWOFFCOCK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DRAWOFFCOCK_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DRAWOFFCOCK = 17;

	/**
	 * The '<em><b>PRESSURERELIEF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRESSURERELIEF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRESSURERELIEF_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PRESSURERELIEF = 18;

	/**
	 * The '<em><b>MIXING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MIXING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MIXING_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MIXING = 19;

	/**
	 * The '<em><b>FLUSHING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FLUSHING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FLUSHING_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FLUSHING = 20;

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
	public static final int USERDEFINED = 21;

	/**
	 * The '<em><b>GASCOCK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GASCOCK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GASCOCK_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GASCOCK = 22;

	/**
	 * The '<em><b>AIRRELEASE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AIRRELEASE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AIRRELEASE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AIRRELEASE = 23;

	/**
	 * An array of all the '<em><b>Ifc Valve Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcValveTypeEnum[] VALUES_ARRAY =
		new IfcValveTypeEnum[]
		{
			NULL_LITERAL,
			FAUCET_LITERAL,
			NOTDEFINED_LITERAL,
			ISOLATING_LITERAL,
			COMMISSIONING_LITERAL,
			DOUBLECHECK_LITERAL,
			STOPCOCK_LITERAL,
			PRESSUREREDUCING_LITERAL,
			STEAMTRAP_LITERAL,
			GASTAP_LITERAL,
			DOUBLEREGULATING_LITERAL,
			ANTIVACUUM_LITERAL,
			SAFETYCUTOFF_LITERAL,
			REGULATING_LITERAL,
			CHANGEOVER_LITERAL,
			CHECK_LITERAL,
			DIVERTING_LITERAL,
			DRAWOFFCOCK_LITERAL,
			PRESSURERELIEF_LITERAL,
			MIXING_LITERAL,
			FLUSHING_LITERAL,
			USERDEFINED_LITERAL,
			GASCOCK_LITERAL,
			AIRRELEASE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Valve Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcValveTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Valve Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcValveTypeEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcValveTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Valve Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcValveTypeEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcValveTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Valve Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcValveTypeEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case FAUCET: return FAUCET_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case ISOLATING: return ISOLATING_LITERAL;
			case COMMISSIONING: return COMMISSIONING_LITERAL;
			case DOUBLECHECK: return DOUBLECHECK_LITERAL;
			case STOPCOCK: return STOPCOCK_LITERAL;
			case PRESSUREREDUCING: return PRESSUREREDUCING_LITERAL;
			case STEAMTRAP: return STEAMTRAP_LITERAL;
			case GASTAP: return GASTAP_LITERAL;
			case DOUBLEREGULATING: return DOUBLEREGULATING_LITERAL;
			case ANTIVACUUM: return ANTIVACUUM_LITERAL;
			case SAFETYCUTOFF: return SAFETYCUTOFF_LITERAL;
			case REGULATING: return REGULATING_LITERAL;
			case CHANGEOVER: return CHANGEOVER_LITERAL;
			case CHECK: return CHECK_LITERAL;
			case DIVERTING: return DIVERTING_LITERAL;
			case DRAWOFFCOCK: return DRAWOFFCOCK_LITERAL;
			case PRESSURERELIEF: return PRESSURERELIEF_LITERAL;
			case MIXING: return MIXING_LITERAL;
			case FLUSHING: return FLUSHING_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case GASCOCK: return GASCOCK_LITERAL;
			case AIRRELEASE: return AIRRELEASE_LITERAL;
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
	private IfcValveTypeEnum(int value, String name, String literal)
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
	
} //IfcValveTypeEnum
