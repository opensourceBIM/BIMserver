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
 * A representation of the literals of the enumeration '<em><b>Compare Identifier</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.store.StorePackage#getCompareIdentifier()
 * @model
 * @generated
 */
public enum CompareIdentifier implements Enumerator {
	/**
	 * The '<em><b>NAME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NAME_VALUE
	 * @generated
	 * @ordered
	 */
	NAME(0, "NAME", "NAME"),

	/**
	 * The '<em><b>GUID</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GUID_VALUE
	 * @generated
	 * @ordered
	 */
	GUID(1, "GUID", "GUID");

	/**
	 * The '<em><b>NAME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NAME</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NAME
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NAME_VALUE = 0;

	/**
	 * The '<em><b>GUID</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GUID</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GUID
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GUID_VALUE = 1;

	/**
	 * An array of all the '<em><b>Compare Identifier</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CompareIdentifier[] VALUES_ARRAY =
		new CompareIdentifier[] {
			NAME,
			GUID,
		};

	/**
	 * A public read-only list of all the '<em><b>Compare Identifier</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<CompareIdentifier> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Compare Identifier</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompareIdentifier get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CompareIdentifier result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Compare Identifier</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompareIdentifier getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CompareIdentifier result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Compare Identifier</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CompareIdentifier get(int value) {
		switch (value) {
			case NAME_VALUE: return NAME;
			case GUID_VALUE: return GUID;
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
	private CompareIdentifier(int value, String name, String literal) {
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
	
} //CompareIdentifier
