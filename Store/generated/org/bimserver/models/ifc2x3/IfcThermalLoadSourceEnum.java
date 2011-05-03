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
 * A representation of the literals of the enumeration '<em><b>Ifc Thermal Load Source Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcThermalLoadSourceEnum()
 * @model
 * @generated
 */
public enum IfcThermalLoadSourceEnum implements Enumerator
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
	 * The '<em><b>VENTILATIONINDOORAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VENTILATIONINDOORAIR
	 * @generated
	 * @ordered
	 */
	VENTILATIONINDOORAIR_LITERAL(1, "VENTILATIONINDOORAIR", "VENTILATIONINDOORAIR"),

	/**
	 * The '<em><b>RECIRCULATEDAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RECIRCULATEDAIR
	 * @generated
	 * @ordered
	 */
	RECIRCULATEDAIR_LITERAL(2, "RECIRCULATEDAIR", "RECIRCULATEDAIR"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @generated
	 * @ordered
	 */
	NOTDEFINED_LITERAL(3, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>EXHAUSTAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXHAUSTAIR
	 * @generated
	 * @ordered
	 */
	EXHAUSTAIR_LITERAL(4, "EXHAUSTAIR", "EXHAUSTAIR"),

	/**
	 * The '<em><b>VENTILATIONOUTSIDEAIR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VENTILATIONOUTSIDEAIR
	 * @generated
	 * @ordered
	 */
	VENTILATIONOUTSIDEAIR_LITERAL(5, "VENTILATIONOUTSIDEAIR", "VENTILATIONOUTSIDEAIR"),

	/**
	 * The '<em><b>EQUIPMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EQUIPMENT
	 * @generated
	 * @ordered
	 */
	EQUIPMENT_LITERAL(6, "EQUIPMENT", "EQUIPMENT"),

	/**
	 * The '<em><b>DRYBULBTEMPERATURE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DRYBULBTEMPERATURE
	 * @generated
	 * @ordered
	 */
	DRYBULBTEMPERATURE_LITERAL(7, "DRYBULBTEMPERATURE", "DRYBULBTEMPERATURE"),

	/**
	 * The '<em><b>RELATIVEHUMIDITY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RELATIVEHUMIDITY
	 * @generated
	 * @ordered
	 */
	RELATIVEHUMIDITY_LITERAL(8, "RELATIVEHUMIDITY", "RELATIVEHUMIDITY"),

	/**
	 * The '<em><b>PEOPLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PEOPLE
	 * @generated
	 * @ordered
	 */
	PEOPLE_LITERAL(9, "PEOPLE", "PEOPLE"),

	/**
	 * The '<em><b>INFILTRATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INFILTRATION
	 * @generated
	 * @ordered
	 */
	INFILTRATION_LITERAL(10, "INFILTRATION", "INFILTRATION"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @generated
	 * @ordered
	 */
	USERDEFINED_LITERAL(11, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>AIREXCHANGERATE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AIREXCHANGERATE
	 * @generated
	 * @ordered
	 */
	AIREXCHANGERATE_LITERAL(12, "AIREXCHANGERATE", "AIREXCHANGERATE"),

	/**
	 * The '<em><b>LIGHTING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIGHTING
	 * @generated
	 * @ordered
	 */
	LIGHTING_LITERAL(13, "LIGHTING", "LIGHTING");

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
	 * The '<em><b>VENTILATIONINDOORAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VENTILATIONINDOORAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VENTILATIONINDOORAIR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VENTILATIONINDOORAIR = 1;

	/**
	 * The '<em><b>RECIRCULATEDAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RECIRCULATEDAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RECIRCULATEDAIR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RECIRCULATEDAIR = 2;

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
	public static final int NOTDEFINED = 3;

	/**
	 * The '<em><b>EXHAUSTAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EXHAUSTAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXHAUSTAIR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EXHAUSTAIR = 4;

	/**
	 * The '<em><b>VENTILATIONOUTSIDEAIR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VENTILATIONOUTSIDEAIR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VENTILATIONOUTSIDEAIR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VENTILATIONOUTSIDEAIR = 5;

	/**
	 * The '<em><b>EQUIPMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EQUIPMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EQUIPMENT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EQUIPMENT = 6;

	/**
	 * The '<em><b>DRYBULBTEMPERATURE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DRYBULBTEMPERATURE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DRYBULBTEMPERATURE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DRYBULBTEMPERATURE = 7;

	/**
	 * The '<em><b>RELATIVEHUMIDITY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RELATIVEHUMIDITY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RELATIVEHUMIDITY_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RELATIVEHUMIDITY = 8;

	/**
	 * The '<em><b>PEOPLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PEOPLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PEOPLE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PEOPLE = 9;

	/**
	 * The '<em><b>INFILTRATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INFILTRATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INFILTRATION_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INFILTRATION = 10;

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
	public static final int USERDEFINED = 11;

	/**
	 * The '<em><b>AIREXCHANGERATE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AIREXCHANGERATE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AIREXCHANGERATE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AIREXCHANGERATE = 12;

	/**
	 * The '<em><b>LIGHTING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LIGHTING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LIGHTING_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LIGHTING = 13;

	/**
	 * An array of all the '<em><b>Ifc Thermal Load Source Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcThermalLoadSourceEnum[] VALUES_ARRAY =
		new IfcThermalLoadSourceEnum[]
		{
			NULL_LITERAL,
			VENTILATIONINDOORAIR_LITERAL,
			RECIRCULATEDAIR_LITERAL,
			NOTDEFINED_LITERAL,
			EXHAUSTAIR_LITERAL,
			VENTILATIONOUTSIDEAIR_LITERAL,
			EQUIPMENT_LITERAL,
			DRYBULBTEMPERATURE_LITERAL,
			RELATIVEHUMIDITY_LITERAL,
			PEOPLE_LITERAL,
			INFILTRATION_LITERAL,
			USERDEFINED_LITERAL,
			AIREXCHANGERATE_LITERAL,
			LIGHTING_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Thermal Load Source Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcThermalLoadSourceEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Thermal Load Source Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcThermalLoadSourceEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcThermalLoadSourceEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Thermal Load Source Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcThermalLoadSourceEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcThermalLoadSourceEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Thermal Load Source Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcThermalLoadSourceEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case VENTILATIONINDOORAIR: return VENTILATIONINDOORAIR_LITERAL;
			case RECIRCULATEDAIR: return RECIRCULATEDAIR_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case EXHAUSTAIR: return EXHAUSTAIR_LITERAL;
			case VENTILATIONOUTSIDEAIR: return VENTILATIONOUTSIDEAIR_LITERAL;
			case EQUIPMENT: return EQUIPMENT_LITERAL;
			case DRYBULBTEMPERATURE: return DRYBULBTEMPERATURE_LITERAL;
			case RELATIVEHUMIDITY: return RELATIVEHUMIDITY_LITERAL;
			case PEOPLE: return PEOPLE_LITERAL;
			case INFILTRATION: return INFILTRATION_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case AIREXCHANGERATE: return AIREXCHANGERATE_LITERAL;
			case LIGHTING: return LIGHTING_LITERAL;
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
	private IfcThermalLoadSourceEnum(int value, String name, String literal)
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
	
} //IfcThermalLoadSourceEnum
