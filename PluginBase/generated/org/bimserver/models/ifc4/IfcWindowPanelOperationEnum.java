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
 * A representation of the literals of the enumeration '<em><b>Ifc Window Panel Operation Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcWindowPanelOperationEnum()
 * @model
 * @generated
 */
public enum IfcWindowPanelOperationEnum implements Enumerator {
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
	 * The '<em><b>SIDEHUNGLEFTHAND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIDEHUNGLEFTHAND_VALUE
	 * @generated
	 * @ordered
	 */
	SIDEHUNGLEFTHAND(1, "SIDEHUNGLEFTHAND", "SIDEHUNGLEFTHAND"),

	/**
	 * The '<em><b>FIXEDCASEMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIXEDCASEMENT_VALUE
	 * @generated
	 * @ordered
	 */
	FIXEDCASEMENT(2, "FIXEDCASEMENT", "FIXEDCASEMENT"),

	/**
	 * The '<em><b>TILTANDTURNRIGHTHAND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TILTANDTURNRIGHTHAND_VALUE
	 * @generated
	 * @ordered
	 */
	TILTANDTURNRIGHTHAND(3, "TILTANDTURNRIGHTHAND", "TILTANDTURNRIGHTHAND"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(4, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>TILTANDTURNLEFTHAND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TILTANDTURNLEFTHAND_VALUE
	 * @generated
	 * @ordered
	 */
	TILTANDTURNLEFTHAND(5, "TILTANDTURNLEFTHAND", "TILTANDTURNLEFTHAND"),

	/**
	 * The '<em><b>OTHEROPERATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OTHEROPERATION_VALUE
	 * @generated
	 * @ordered
	 */
	OTHEROPERATION(6, "OTHEROPERATION", "OTHEROPERATION"),

	/**
	 * The '<em><b>PIVOTHORIZONTAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PIVOTHORIZONTAL_VALUE
	 * @generated
	 * @ordered
	 */
	PIVOTHORIZONTAL(7, "PIVOTHORIZONTAL", "PIVOTHORIZONTAL"),

	/**
	 * The '<em><b>PIVOTVERTICAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PIVOTVERTICAL_VALUE
	 * @generated
	 * @ordered
	 */
	PIVOTVERTICAL(8, "PIVOTVERTICAL", "PIVOTVERTICAL"),

	/**
	 * The '<em><b>SLIDINGHORIZONTAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SLIDINGHORIZONTAL_VALUE
	 * @generated
	 * @ordered
	 */
	SLIDINGHORIZONTAL(9, "SLIDINGHORIZONTAL", "SLIDINGHORIZONTAL"),

	/**
	 * The '<em><b>TOPHUNG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOPHUNG_VALUE
	 * @generated
	 * @ordered
	 */
	TOPHUNG(10, "TOPHUNG", "TOPHUNG"),

	/**
	 * The '<em><b>BOTTOMHUNG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOTTOMHUNG_VALUE
	 * @generated
	 * @ordered
	 */
	BOTTOMHUNG(11, "BOTTOMHUNG", "BOTTOMHUNG"),

	/**
	 * The '<em><b>SLIDINGVERTICAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SLIDINGVERTICAL_VALUE
	 * @generated
	 * @ordered
	 */
	SLIDINGVERTICAL(12, "SLIDINGVERTICAL", "SLIDINGVERTICAL"),

	/**
	 * The '<em><b>SIDEHUNGRIGHTHAND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIDEHUNGRIGHTHAND_VALUE
	 * @generated
	 * @ordered
	 */
	SIDEHUNGRIGHTHAND(13, "SIDEHUNGRIGHTHAND", "SIDEHUNGRIGHTHAND"),

	/**
	 * The '<em><b>REMOVABLECASEMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REMOVABLECASEMENT_VALUE
	 * @generated
	 * @ordered
	 */
	REMOVABLECASEMENT(14, "REMOVABLECASEMENT", "REMOVABLECASEMENT");

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
	 * The '<em><b>SIDEHUNGLEFTHAND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SIDEHUNGLEFTHAND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SIDEHUNGLEFTHAND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SIDEHUNGLEFTHAND_VALUE = 1;

	/**
	 * The '<em><b>FIXEDCASEMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FIXEDCASEMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIXEDCASEMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FIXEDCASEMENT_VALUE = 2;

	/**
	 * The '<em><b>TILTANDTURNRIGHTHAND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TILTANDTURNRIGHTHAND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TILTANDTURNRIGHTHAND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TILTANDTURNRIGHTHAND_VALUE = 3;

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
	public static final int NOTDEFINED_VALUE = 4;

	/**
	 * The '<em><b>TILTANDTURNLEFTHAND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TILTANDTURNLEFTHAND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TILTANDTURNLEFTHAND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TILTANDTURNLEFTHAND_VALUE = 5;

	/**
	 * The '<em><b>OTHEROPERATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OTHEROPERATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OTHEROPERATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OTHEROPERATION_VALUE = 6;

	/**
	 * The '<em><b>PIVOTHORIZONTAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PIVOTHORIZONTAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PIVOTHORIZONTAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PIVOTHORIZONTAL_VALUE = 7;

	/**
	 * The '<em><b>PIVOTVERTICAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PIVOTVERTICAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PIVOTVERTICAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PIVOTVERTICAL_VALUE = 8;

	/**
	 * The '<em><b>SLIDINGHORIZONTAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SLIDINGHORIZONTAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SLIDINGHORIZONTAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SLIDINGHORIZONTAL_VALUE = 9;

	/**
	 * The '<em><b>TOPHUNG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TOPHUNG</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TOPHUNG
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TOPHUNG_VALUE = 10;

	/**
	 * The '<em><b>BOTTOMHUNG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BOTTOMHUNG</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOTTOMHUNG
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BOTTOMHUNG_VALUE = 11;

	/**
	 * The '<em><b>SLIDINGVERTICAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SLIDINGVERTICAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SLIDINGVERTICAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SLIDINGVERTICAL_VALUE = 12;

	/**
	 * The '<em><b>SIDEHUNGRIGHTHAND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SIDEHUNGRIGHTHAND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SIDEHUNGRIGHTHAND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SIDEHUNGRIGHTHAND_VALUE = 13;

	/**
	 * The '<em><b>REMOVABLECASEMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REMOVABLECASEMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REMOVABLECASEMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REMOVABLECASEMENT_VALUE = 14;

	/**
	 * An array of all the '<em><b>Ifc Window Panel Operation Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcWindowPanelOperationEnum[] VALUES_ARRAY = new IfcWindowPanelOperationEnum[] { NULL, SIDEHUNGLEFTHAND, FIXEDCASEMENT, TILTANDTURNRIGHTHAND, NOTDEFINED, TILTANDTURNLEFTHAND, OTHEROPERATION, PIVOTHORIZONTAL,
			PIVOTVERTICAL, SLIDINGHORIZONTAL, TOPHUNG, BOTTOMHUNG, SLIDINGVERTICAL, SIDEHUNGRIGHTHAND, REMOVABLECASEMENT, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Window Panel Operation Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcWindowPanelOperationEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Window Panel Operation Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcWindowPanelOperationEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcWindowPanelOperationEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Window Panel Operation Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcWindowPanelOperationEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcWindowPanelOperationEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Window Panel Operation Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcWindowPanelOperationEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case SIDEHUNGLEFTHAND_VALUE:
			return SIDEHUNGLEFTHAND;
		case FIXEDCASEMENT_VALUE:
			return FIXEDCASEMENT;
		case TILTANDTURNRIGHTHAND_VALUE:
			return TILTANDTURNRIGHTHAND;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case TILTANDTURNLEFTHAND_VALUE:
			return TILTANDTURNLEFTHAND;
		case OTHEROPERATION_VALUE:
			return OTHEROPERATION;
		case PIVOTHORIZONTAL_VALUE:
			return PIVOTHORIZONTAL;
		case PIVOTVERTICAL_VALUE:
			return PIVOTVERTICAL;
		case SLIDINGHORIZONTAL_VALUE:
			return SLIDINGHORIZONTAL;
		case TOPHUNG_VALUE:
			return TOPHUNG;
		case BOTTOMHUNG_VALUE:
			return BOTTOMHUNG;
		case SLIDINGVERTICAL_VALUE:
			return SLIDINGVERTICAL;
		case SIDEHUNGRIGHTHAND_VALUE:
			return SIDEHUNGRIGHTHAND;
		case REMOVABLECASEMENT_VALUE:
			return REMOVABLECASEMENT;
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
	private IfcWindowPanelOperationEnum(int value, String name, String literal) {
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

} //IfcWindowPanelOperationEnum
