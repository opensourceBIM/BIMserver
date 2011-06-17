/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Checkin State</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.store.StorePackage#getCheckinState()
 * @model
 * @generated
 */
public enum CheckinState implements Enumerator {
	/**
	 * The '<em><b>UPLOADING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UPLOADING_VALUE
	 * @generated
	 * @ordered
	 */
	UPLOADING(0, "UPLOADING", "UPLOADING"),

	/**
	 * The '<em><b>PARSING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PARSING_VALUE
	 * @generated
	 * @ordered
	 */
	PARSING(1, "PARSING", "PARSING"),

	/**
	 * The '<em><b>STORING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STORING_VALUE
	 * @generated
	 * @ordered
	 */
	STORING(2, "STORING", "STORING"),

	/**
	 * The '<em><b>SEARCHING CLASHES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEARCHING_CLASHES_VALUE
	 * @generated
	 * @ordered
	 */
	SEARCHING_CLASHES(3, "SEARCHING_CLASHES", "SEARCHING_CLASHES"),

	/**
	 * The '<em><b>DONE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DONE_VALUE
	 * @generated
	 * @ordered
	 */
	DONE(4, "DONE", "DONE"),

	/**
	 * The '<em><b>ERROR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ERROR_VALUE
	 * @generated
	 * @ordered
	 */
	ERROR(5, "ERROR", "ERROR"),

	/**
	 * The '<em><b>CLASHES ERROR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLASHES_ERROR_VALUE
	 * @generated
	 * @ordered
	 */
	CLASHES_ERROR(6, "CLASHES_ERROR", "CLASHES_ERROR");

	/**
	 * The '<em><b>UPLOADING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UPLOADING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UPLOADING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UPLOADING_VALUE = 0;

	/**
	 * The '<em><b>PARSING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PARSING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PARSING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PARSING_VALUE = 1;

	/**
	 * The '<em><b>STORING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STORING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STORING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STORING_VALUE = 2;

	/**
	 * The '<em><b>SEARCHING CLASHES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SEARCHING CLASHES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SEARCHING_CLASHES
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SEARCHING_CLASHES_VALUE = 3;

	/**
	 * The '<em><b>DONE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DONE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DONE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DONE_VALUE = 4;

	/**
	 * The '<em><b>ERROR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ERROR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ERROR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ERROR_VALUE = 5;

	/**
	 * The '<em><b>CLASHES ERROR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CLASHES ERROR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLASHES_ERROR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CLASHES_ERROR_VALUE = 6;

	/**
	 * An array of all the '<em><b>Checkin State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CheckinState[] VALUES_ARRAY =
		new CheckinState[] {
			UPLOADING,
			PARSING,
			STORING,
			SEARCHING_CLASHES,
			DONE,
			ERROR,
			CLASHES_ERROR,
		};

	/**
	 * A public read-only list of all the '<em><b>Checkin State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<CheckinState> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Checkin State</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CheckinState get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CheckinState result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Checkin State</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CheckinState getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CheckinState result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Checkin State</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CheckinState get(int value) {
		switch (value) {
			case UPLOADING_VALUE: return UPLOADING;
			case PARSING_VALUE: return PARSING;
			case STORING_VALUE: return STORING;
			case SEARCHING_CLASHES_VALUE: return SEARCHING_CLASHES;
			case DONE_VALUE: return DONE;
			case ERROR_VALUE: return ERROR;
			case CLASHES_ERROR_VALUE: return CLASHES_ERROR;
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
	private CheckinState(int value, String name, String literal) {
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
	
} //CheckinState
