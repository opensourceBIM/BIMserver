/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.store;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Checkin Status</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.store.StorePackage#getCheckinStatus()
 * @model
 * @generated
 */
public enum CheckinStatus implements Enumerator {
	/**
	 * The '<em><b>CH NONE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CH_NONE_VALUE
	 * @generated
	 * @ordered
	 */
	CH_NONE(0, "CH_NONE", "CH_NONE"),

	/**
	 * The '<em><b>CH STARTED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CH_STARTED_VALUE
	 * @generated
	 * @ordered
	 */
	CH_STARTED(1, "CH_STARTED", "CH_STARTED"),

	/**
	 * The '<em><b>CH FINISHED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CH_FINISHED_VALUE
	 * @generated
	 * @ordered
	 */
	CH_FINISHED(2, "CH_FINISHED", "CH_FINISHED"),

	/**
	 * The '<em><b>CH ERROR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CH_ERROR_VALUE
	 * @generated
	 * @ordered
	 */
	CH_ERROR(3, "CH_ERROR", "CH_ERROR");

	/**
	 * The '<em><b>CH NONE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CH NONE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CH_NONE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CH_NONE_VALUE = 0;

	/**
	 * The '<em><b>CH STARTED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CH STARTED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CH_STARTED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CH_STARTED_VALUE = 1;

	/**
	 * The '<em><b>CH FINISHED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CH FINISHED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CH_FINISHED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CH_FINISHED_VALUE = 2;

	/**
	 * The '<em><b>CH ERROR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CH ERROR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CH_ERROR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CH_ERROR_VALUE = 3;

	/**
	 * An array of all the '<em><b>Checkin Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CheckinStatus[] VALUES_ARRAY = new CheckinStatus[] { CH_NONE, CH_STARTED, CH_FINISHED, CH_ERROR, };

	/**
	 * A public read-only list of all the '<em><b>Checkin Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<CheckinStatus> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Checkin Status</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CheckinStatus get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CheckinStatus result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Checkin Status</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CheckinStatus getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CheckinStatus result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Checkin Status</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CheckinStatus get(int value) {
		switch (value) {
		case CH_NONE_VALUE:
			return CH_NONE;
		case CH_STARTED_VALUE:
			return CH_STARTED;
		case CH_FINISHED_VALUE:
			return CH_FINISHED;
		case CH_ERROR_VALUE:
			return CH_ERROR;
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
	private CheckinStatus(int value, String name, String literal) {
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

} //CheckinStatus
