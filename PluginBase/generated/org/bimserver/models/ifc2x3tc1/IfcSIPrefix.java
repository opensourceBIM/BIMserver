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
package org.bimserver.models.ifc2x3tc1;

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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Ifc SI Prefix</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcSIPrefix()
 * @model
 * @generated
 */
public enum IfcSIPrefix implements Enumerator {
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
	 * The '<em><b>DECA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECA_VALUE
	 * @generated
	 * @ordered
	 */
	DECA(1, "DECA", "DECA"),

	/**
	 * The '<em><b>PICO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PICO_VALUE
	 * @generated
	 * @ordered
	 */
	PICO(2, "PICO", "PICO"),

	/**
	 * The '<em><b>KILO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KILO_VALUE
	 * @generated
	 * @ordered
	 */
	KILO(3, "KILO", "KILO"),

	/**
	 * The '<em><b>PETA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PETA_VALUE
	 * @generated
	 * @ordered
	 */
	PETA(4, "PETA", "PETA"),

	/**
	 * The '<em><b>TERA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TERA_VALUE
	 * @generated
	 * @ordered
	 */
	TERA(5, "TERA", "TERA"),

	/**
	 * The '<em><b>EXA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXA_VALUE
	 * @generated
	 * @ordered
	 */
	EXA(6, "EXA", "EXA"),

	/**
	 * The '<em><b>NANO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NANO_VALUE
	 * @generated
	 * @ordered
	 */
	NANO(7, "NANO", "NANO"),

	/**
	 * The '<em><b>ATTO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ATTO_VALUE
	 * @generated
	 * @ordered
	 */
	ATTO(8, "ATTO", "ATTO"),

	/**
	 * The '<em><b>CENTI</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CENTI_VALUE
	 * @generated
	 * @ordered
	 */
	CENTI(9, "CENTI", "CENTI"),

	/**
	 * The '<em><b>MILLI</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MILLI_VALUE
	 * @generated
	 * @ordered
	 */
	MILLI(10, "MILLI", "MILLI"),

	/**
	 * The '<em><b>FEMTO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FEMTO_VALUE
	 * @generated
	 * @ordered
	 */
	FEMTO(11, "FEMTO", "FEMTO"),

	/**
	 * The '<em><b>MEGA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEGA_VALUE
	 * @generated
	 * @ordered
	 */
	MEGA(12, "MEGA", "MEGA"),

	/**
	 * The '<em><b>HECTO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HECTO_VALUE
	 * @generated
	 * @ordered
	 */
	HECTO(13, "HECTO", "HECTO"),

	/**
	 * The '<em><b>DECI</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECI_VALUE
	 * @generated
	 * @ordered
	 */
	DECI(14, "DECI", "DECI"),

	/**
	 * The '<em><b>MICRO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MICRO_VALUE
	 * @generated
	 * @ordered
	 */
	MICRO(15, "MICRO", "MICRO"),

	/**
	 * The '<em><b>GIGA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GIGA_VALUE
	 * @generated
	 * @ordered
	 */
	GIGA(16, "GIGA", "GIGA");

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
	 * The '<em><b>DECA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DECA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DECA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DECA_VALUE = 1;

	/**
	 * The '<em><b>PICO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PICO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PICO
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PICO_VALUE = 2;

	/**
	 * The '<em><b>KILO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KILO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KILO
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KILO_VALUE = 3;

	/**
	 * The '<em><b>PETA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PETA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PETA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PETA_VALUE = 4;

	/**
	 * The '<em><b>TERA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TERA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TERA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TERA_VALUE = 5;

	/**
	 * The '<em><b>EXA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EXA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EXA_VALUE = 6;

	/**
	 * The '<em><b>NANO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NANO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NANO
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NANO_VALUE = 7;

	/**
	 * The '<em><b>ATTO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ATTO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ATTO
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ATTO_VALUE = 8;

	/**
	 * The '<em><b>CENTI</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CENTI</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CENTI
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CENTI_VALUE = 9;

	/**
	 * The '<em><b>MILLI</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MILLI</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MILLI
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MILLI_VALUE = 10;

	/**
	 * The '<em><b>FEMTO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FEMTO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FEMTO
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FEMTO_VALUE = 11;

	/**
	 * The '<em><b>MEGA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MEGA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEGA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MEGA_VALUE = 12;

	/**
	 * The '<em><b>HECTO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HECTO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HECTO
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HECTO_VALUE = 13;

	/**
	 * The '<em><b>DECI</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DECI</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DECI
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DECI_VALUE = 14;

	/**
	 * The '<em><b>MICRO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MICRO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MICRO
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MICRO_VALUE = 15;

	/**
	 * The '<em><b>GIGA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GIGA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GIGA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GIGA_VALUE = 16;

	/**
	 * An array of all the '<em><b>Ifc SI Prefix</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcSIPrefix[] VALUES_ARRAY = new IfcSIPrefix[] { NULL, DECA, PICO, KILO, PETA, TERA, EXA, NANO,
			ATTO, CENTI, MILLI, FEMTO, MEGA, HECTO, DECI, MICRO, GIGA, };

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
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcSIPrefix get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcSIPrefix result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc SI Prefix</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcSIPrefix getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcSIPrefix result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc SI Prefix</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcSIPrefix get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case DECA_VALUE:
			return DECA;
		case PICO_VALUE:
			return PICO;
		case KILO_VALUE:
			return KILO;
		case PETA_VALUE:
			return PETA;
		case TERA_VALUE:
			return TERA;
		case EXA_VALUE:
			return EXA;
		case NANO_VALUE:
			return NANO;
		case ATTO_VALUE:
			return ATTO;
		case CENTI_VALUE:
			return CENTI;
		case MILLI_VALUE:
			return MILLI;
		case FEMTO_VALUE:
			return FEMTO;
		case MEGA_VALUE:
			return MEGA;
		case HECTO_VALUE:
			return HECTO;
		case DECI_VALUE:
			return DECI;
		case MICRO_VALUE:
			return MICRO;
		case GIGA_VALUE:
			return GIGA;
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
	private IfcSIPrefix(int value, String name, String literal) {
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

} //IfcSIPrefix
