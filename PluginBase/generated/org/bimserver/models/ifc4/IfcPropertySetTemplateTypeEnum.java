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
package org.bimserver.models.ifc4;

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
 * A representation of the literals of the enumeration '<em><b>Ifc Property Set Template Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcPropertySetTemplateTypeEnum()
 * @model
 * @generated
 */
public enum IfcPropertySetTemplateTypeEnum implements Enumerator {
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
	 * The '<em><b>PSET OCCURRENCEDRIVEN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PSET_OCCURRENCEDRIVEN_VALUE
	 * @generated
	 * @ordered
	 */
	PSET_OCCURRENCEDRIVEN(1, "PSET_OCCURRENCEDRIVEN", "PSET_OCCURRENCEDRIVEN"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(2, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>PSET TYPEDRIVENONLY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PSET_TYPEDRIVENONLY_VALUE
	 * @generated
	 * @ordered
	 */
	PSET_TYPEDRIVENONLY(3, "PSET_TYPEDRIVENONLY", "PSET_TYPEDRIVENONLY"),

	/**
	 * The '<em><b>QTO TYPEDRIVENONLY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QTO_TYPEDRIVENONLY_VALUE
	 * @generated
	 * @ordered
	 */
	QTO_TYPEDRIVENONLY(4, "QTO_TYPEDRIVENONLY", "QTO_TYPEDRIVENONLY"),

	/**
	 * The '<em><b>PSET TYPEDRIVENOVERRIDE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PSET_TYPEDRIVENOVERRIDE_VALUE
	 * @generated
	 * @ordered
	 */
	PSET_TYPEDRIVENOVERRIDE(5, "PSET_TYPEDRIVENOVERRIDE", "PSET_TYPEDRIVENOVERRIDE"),

	/**
	 * The '<em><b>QTO OCCURRENCEDRIVEN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QTO_OCCURRENCEDRIVEN_VALUE
	 * @generated
	 * @ordered
	 */
	QTO_OCCURRENCEDRIVEN(6, "QTO_OCCURRENCEDRIVEN", "QTO_OCCURRENCEDRIVEN"),

	/**
	 * The '<em><b>QTO TYPEDRIVENOVERRIDE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QTO_TYPEDRIVENOVERRIDE_VALUE
	 * @generated
	 * @ordered
	 */
	QTO_TYPEDRIVENOVERRIDE(7, "QTO_TYPEDRIVENOVERRIDE", "QTO_TYPEDRIVENOVERRIDE"),

	/**
	 * The '<em><b>PSET PERFORMANCEDRIVEN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PSET_PERFORMANCEDRIVEN_VALUE
	 * @generated
	 * @ordered
	 */
	PSET_PERFORMANCEDRIVEN(8, "PSET_PERFORMANCEDRIVEN", "PSET_PERFORMANCEDRIVEN");

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
	 * The '<em><b>PSET OCCURRENCEDRIVEN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PSET OCCURRENCEDRIVEN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PSET_OCCURRENCEDRIVEN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PSET_OCCURRENCEDRIVEN_VALUE = 1;

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOTDEFINED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTDEFINED_VALUE = 2;

	/**
	 * The '<em><b>PSET TYPEDRIVENONLY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PSET TYPEDRIVENONLY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PSET_TYPEDRIVENONLY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PSET_TYPEDRIVENONLY_VALUE = 3;

	/**
	 * The '<em><b>QTO TYPEDRIVENONLY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>QTO TYPEDRIVENONLY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QTO_TYPEDRIVENONLY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int QTO_TYPEDRIVENONLY_VALUE = 4;

	/**
	 * The '<em><b>PSET TYPEDRIVENOVERRIDE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PSET TYPEDRIVENOVERRIDE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PSET_TYPEDRIVENOVERRIDE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PSET_TYPEDRIVENOVERRIDE_VALUE = 5;

	/**
	 * The '<em><b>QTO OCCURRENCEDRIVEN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>QTO OCCURRENCEDRIVEN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QTO_OCCURRENCEDRIVEN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int QTO_OCCURRENCEDRIVEN_VALUE = 6;

	/**
	 * The '<em><b>QTO TYPEDRIVENOVERRIDE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>QTO TYPEDRIVENOVERRIDE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QTO_TYPEDRIVENOVERRIDE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int QTO_TYPEDRIVENOVERRIDE_VALUE = 7;

	/**
	 * The '<em><b>PSET PERFORMANCEDRIVEN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PSET PERFORMANCEDRIVEN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PSET_PERFORMANCEDRIVEN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PSET_PERFORMANCEDRIVEN_VALUE = 8;

	/**
	 * An array of all the '<em><b>Ifc Property Set Template Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcPropertySetTemplateTypeEnum[] VALUES_ARRAY = new IfcPropertySetTemplateTypeEnum[] { NULL, PSET_OCCURRENCEDRIVEN, NOTDEFINED, PSET_TYPEDRIVENONLY, QTO_TYPEDRIVENONLY, PSET_TYPEDRIVENOVERRIDE, QTO_OCCURRENCEDRIVEN,
			QTO_TYPEDRIVENOVERRIDE, PSET_PERFORMANCEDRIVEN, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Property Set Template Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcPropertySetTemplateTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Property Set Template Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcPropertySetTemplateTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcPropertySetTemplateTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Property Set Template Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcPropertySetTemplateTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcPropertySetTemplateTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Property Set Template Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcPropertySetTemplateTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case PSET_OCCURRENCEDRIVEN_VALUE:
			return PSET_OCCURRENCEDRIVEN;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case PSET_TYPEDRIVENONLY_VALUE:
			return PSET_TYPEDRIVENONLY;
		case QTO_TYPEDRIVENONLY_VALUE:
			return QTO_TYPEDRIVENONLY;
		case PSET_TYPEDRIVENOVERRIDE_VALUE:
			return PSET_TYPEDRIVENOVERRIDE;
		case QTO_OCCURRENCEDRIVEN_VALUE:
			return QTO_OCCURRENCEDRIVEN;
		case QTO_TYPEDRIVENOVERRIDE_VALUE:
			return QTO_TYPEDRIVENOVERRIDE;
		case PSET_PERFORMANCEDRIVEN_VALUE:
			return PSET_PERFORMANCEDRIVEN;
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
	private IfcPropertySetTemplateTypeEnum(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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

} //IfcPropertySetTemplateTypeEnum
