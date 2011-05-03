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
public enum CheckinState implements Enumerator
{
	/**
	 * The '<em><b>UPLOADING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UPLOADING
	 * @generated
	 * @ordered
	 */
	UPLOADING_LITERAL(0, "UPLOADING", "UPLOADING"),

	/**
	 * The '<em><b>PARSING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PARSING
	 * @generated
	 * @ordered
	 */
	PARSING_LITERAL(1, "PARSING", "PARSING"),

	/**
	 * The '<em><b>STORING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STORING
	 * @generated
	 * @ordered
	 */
	STORING_LITERAL(2, "STORING", "STORING"),

	/**
	 * The '<em><b>SEARCHING CLASHES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEARCHING_CLASHES
	 * @generated
	 * @ordered
	 */
	SEARCHING_CLASHES_LITERAL(3, "SEARCHING_CLASHES", "SEARCHING_CLASHES"),

	/**
	 * The '<em><b>DONE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DONE
	 * @generated
	 * @ordered
	 */
	DONE_LITERAL(4, "DONE", "DONE"),

	/**
	 * The '<em><b>ERROR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ERROR
	 * @generated
	 * @ordered
	 */
	ERROR_LITERAL(5, "ERROR", "ERROR"),

	/**
	 * The '<em><b>CLASHES ERROR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLASHES_ERROR
	 * @generated
	 * @ordered
	 */
	CLASHES_ERROR_LITERAL(6, "CLASHES_ERROR", "CLASHES_ERROR");

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * The '<em><b>UPLOADING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UPLOADING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UPLOADING_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UPLOADING = 0;

	/**
	 * The '<em><b>PARSING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PARSING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PARSING_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PARSING = 1;

	/**
	 * The '<em><b>STORING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STORING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STORING_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STORING = 2;

	/**
	 * The '<em><b>SEARCHING CLASHES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SEARCHING CLASHES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SEARCHING_CLASHES_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SEARCHING_CLASHES = 3;

	/**
	 * The '<em><b>DONE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DONE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DONE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DONE = 4;

	/**
	 * The '<em><b>ERROR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ERROR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ERROR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ERROR = 5;

	/**
	 * The '<em><b>CLASHES ERROR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CLASHES ERROR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLASHES_ERROR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CLASHES_ERROR = 6;

	/**
	 * An array of all the '<em><b>Checkin State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CheckinState[] VALUES_ARRAY =
		new CheckinState[]
		{
			UPLOADING_LITERAL,
			PARSING_LITERAL,
			STORING_LITERAL,
			SEARCHING_CLASHES_LITERAL,
			DONE_LITERAL,
			ERROR_LITERAL,
			CLASHES_ERROR_LITERAL,
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
	public static CheckinState get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			CheckinState result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
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
	public static CheckinState getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			CheckinState result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
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
	public static CheckinState get(int value)
	{
		switch (value)
		{
			case UPLOADING: return UPLOADING_LITERAL;
			case PARSING: return PARSING_LITERAL;
			case STORING: return STORING_LITERAL;
			case SEARCHING_CLASHES: return SEARCHING_CLASHES_LITERAL;
			case DONE: return DONE_LITERAL;
			case ERROR: return ERROR_LITERAL;
			case CLASHES_ERROR: return CLASHES_ERROR_LITERAL;
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
	private CheckinState(int value, String name, String literal)
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
	
} //CheckinState
