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
 * A representation of the literals of the enumeration '<em><b>Ifc SI Prefix</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcSIPrefix()
 * @model
 * @generated
 */
public enum IfcSIPrefix implements Enumerator
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
	 * The '<em><b>ATTO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ATTO
	 * @generated
	 * @ordered
	 */
	ATTO_LITERAL(1, "ATTO", "ATTO"),

	/**
	 * The '<em><b>MICRO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MICRO
	 * @generated
	 * @ordered
	 */
	MICRO_LITERAL(2, "MICRO", "MICRO"),

	/**
	 * The '<em><b>PICO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PICO
	 * @generated
	 * @ordered
	 */
	PICO_LITERAL(3, "PICO", "PICO"),

	/**
	 * The '<em><b>CENTI</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CENTI
	 * @generated
	 * @ordered
	 */
	CENTI_LITERAL(4, "CENTI", "CENTI"),

	/**
	 * The '<em><b>DECI</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECI
	 * @generated
	 * @ordered
	 */
	DECI_LITERAL(5, "DECI", "DECI"),

	/**
	 * The '<em><b>KILO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KILO
	 * @generated
	 * @ordered
	 */
	KILO_LITERAL(6, "KILO", "KILO"),

	/**
	 * The '<em><b>TERA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TERA
	 * @generated
	 * @ordered
	 */
	TERA_LITERAL(7, "TERA", "TERA"),

	/**
	 * The '<em><b>MEGA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEGA
	 * @generated
	 * @ordered
	 */
	MEGA_LITERAL(8, "MEGA", "MEGA"),

	/**
	 * The '<em><b>PETA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PETA
	 * @generated
	 * @ordered
	 */
	PETA_LITERAL(9, "PETA", "PETA"),

	/**
	 * The '<em><b>FEMTO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FEMTO
	 * @generated
	 * @ordered
	 */
	FEMTO_LITERAL(10, "FEMTO", "FEMTO"),

	/**
	 * The '<em><b>EXA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXA
	 * @generated
	 * @ordered
	 */
	EXA_LITERAL(11, "EXA", "EXA"),

	/**
	 * The '<em><b>MILLI</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MILLI
	 * @generated
	 * @ordered
	 */
	MILLI_LITERAL(12, "MILLI", "MILLI"),

	/**
	 * The '<em><b>GIGA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GIGA
	 * @generated
	 * @ordered
	 */
	GIGA_LITERAL(13, "GIGA", "GIGA"),

	/**
	 * The '<em><b>DECA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECA
	 * @generated
	 * @ordered
	 */
	DECA_LITERAL(14, "DECA", "DECA"),

	/**
	 * The '<em><b>HECTO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HECTO
	 * @generated
	 * @ordered
	 */
	HECTO_LITERAL(15, "HECTO", "HECTO"),

	/**
	 * The '<em><b>NANO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NANO
	 * @generated
	 * @ordered
	 */
	NANO_LITERAL(16, "NANO", "NANO");

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
	 * The '<em><b>ATTO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ATTO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ATTO_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ATTO = 1;

	/**
	 * The '<em><b>MICRO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MICRO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MICRO_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MICRO = 2;

	/**
	 * The '<em><b>PICO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PICO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PICO_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PICO = 3;

	/**
	 * The '<em><b>CENTI</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CENTI</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CENTI_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CENTI = 4;

	/**
	 * The '<em><b>DECI</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DECI</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DECI_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DECI = 5;

	/**
	 * The '<em><b>KILO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KILO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KILO_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KILO = 6;

	/**
	 * The '<em><b>TERA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TERA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TERA_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TERA = 7;

	/**
	 * The '<em><b>MEGA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MEGA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEGA_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MEGA = 8;

	/**
	 * The '<em><b>PETA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PETA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PETA_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PETA = 9;

	/**
	 * The '<em><b>FEMTO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FEMTO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FEMTO_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FEMTO = 10;

	/**
	 * The '<em><b>EXA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EXA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXA_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EXA = 11;

	/**
	 * The '<em><b>MILLI</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MILLI</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MILLI_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MILLI = 12;

	/**
	 * The '<em><b>GIGA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GIGA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GIGA_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GIGA = 13;

	/**
	 * The '<em><b>DECA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DECA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DECA_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DECA = 14;

	/**
	 * The '<em><b>HECTO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HECTO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HECTO_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HECTO = 15;

	/**
	 * The '<em><b>NANO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NANO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NANO_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NANO = 16;

	/**
	 * An array of all the '<em><b>Ifc SI Prefix</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcSIPrefix[] VALUES_ARRAY =
		new IfcSIPrefix[]
		{
			NULL_LITERAL,
			ATTO_LITERAL,
			MICRO_LITERAL,
			PICO_LITERAL,
			CENTI_LITERAL,
			DECI_LITERAL,
			KILO_LITERAL,
			TERA_LITERAL,
			MEGA_LITERAL,
			PETA_LITERAL,
			FEMTO_LITERAL,
			EXA_LITERAL,
			MILLI_LITERAL,
			GIGA_LITERAL,
			DECA_LITERAL,
			HECTO_LITERAL,
			NANO_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc SI Prefix</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcSIPrefix> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc SI Prefix</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcSIPrefix get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcSIPrefix result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc SI Prefix</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcSIPrefix getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcSIPrefix result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc SI Prefix</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcSIPrefix get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case ATTO: return ATTO_LITERAL;
			case MICRO: return MICRO_LITERAL;
			case PICO: return PICO_LITERAL;
			case CENTI: return CENTI_LITERAL;
			case DECI: return DECI_LITERAL;
			case KILO: return KILO_LITERAL;
			case TERA: return TERA_LITERAL;
			case MEGA: return MEGA_LITERAL;
			case PETA: return PETA_LITERAL;
			case FEMTO: return FEMTO_LITERAL;
			case EXA: return EXA_LITERAL;
			case MILLI: return MILLI_LITERAL;
			case GIGA: return GIGA_LITERAL;
			case DECA: return DECA_LITERAL;
			case HECTO: return HECTO_LITERAL;
			case NANO: return NANO_LITERAL;
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
	private IfcSIPrefix(int value, String name, String literal)
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
	
} //IfcSIPrefix
