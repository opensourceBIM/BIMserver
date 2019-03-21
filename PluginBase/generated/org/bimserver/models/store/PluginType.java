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
package org.bimserver.models.store;

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
 * A representation of the literals of the enumeration '<em><b>Plugin Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.store.StorePackage#getPluginType()
 * @model
 * @generated
 */
public enum PluginType implements Enumerator {
	/**
	 * The '<em><b>SERIALIZER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SERIALIZER_VALUE
	 * @generated
	 * @ordered
	 */
	SERIALIZER(0, "SERIALIZER", "SERIALIZER"),
	/**
	 * The '<em><b>DESERIALIZER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	* <!-- end-user-doc -->
	 * @see #DESERIALIZER_VALUE
	 * @generated
	 * @ordered
	 */
	DESERIALIZER(1, "DESERIALIZER", "DESERIALIZER"),
	/**
	 * The '<em><b>RENDER ENGINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	* <!-- end-user-doc -->
	 * @see #RENDER_ENGINE_VALUE
	 * @generated
	 * @ordered
	 */
	RENDER_ENGINE(2, "RENDER_ENGINE", "RENDER_ENGINE"),
	/**
	 * The '<em><b>QUERY ENGINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	* <!-- end-user-doc -->
	 * @see #QUERY_ENGINE_VALUE
	 * @generated
	 * @ordered
	 */
	QUERY_ENGINE(3, "QUERY_ENGINE", "QUERY_ENGINE"),
	/**
	 * The '<em><b>OBJECT IDM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	* <!-- end-user-doc -->
	 * @see #OBJECT_IDM_VALUE
	 * @generated
	 * @ordered
	 */
	OBJECT_IDM(4, "OBJECT_IDM", "OBJECT_IDM"),
	/**
	 * The '<em><b>WEB MODULE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	* <!-- end-user-doc -->
	 * @see #WEB_MODULE_VALUE
	 * @generated
	 * @ordered
	 */
	WEB_MODULE(5, "WEB_MODULE", "WEB_MODULE"),
	/**
	 * The '<em><b>MODEL MERGER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	* <!-- end-user-doc -->
	 * @see #MODEL_MERGER_VALUE
	 * @generated
	 * @ordered
	 */
	MODEL_MERGER(6, "MODEL_MERGER", "MODEL_MERGER"),
	/**
	 * The '<em><b>MODEL COMPARE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	* <!-- end-user-doc -->
	 * @see #MODEL_COMPARE_VALUE
	 * @generated
	 * @ordered
	 */
	MODEL_COMPARE(7, "MODEL_COMPARE", "MODEL_COMPARE"),
	/**
	 * The '<em><b>MODEL CHECKER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	* <!-- end-user-doc -->
	 * @see #MODEL_CHECKER_VALUE
	 * @generated
	 * @ordered
	 */
	MODEL_CHECKER(8, "MODEL_CHECKER", "MODEL_CHECKER"),
	/**
	 * The '<em><b>STILL IMAGE RENDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	* <!-- end-user-doc -->
	 * @see #STILL_IMAGE_RENDER_VALUE
	 * @generated
	 * @ordered
	 */
	STILL_IMAGE_RENDER(9, "STILL_IMAGE_RENDER", "STILL_IMAGE_RENDER"),
	/**
	 * The '<em><b>SERVICE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	* <!-- end-user-doc -->
	 * @see #SERVICE_VALUE
	 * @generated
	 * @ordered
	 */
	SERVICE(10, "SERVICE", "SERVICE");

	/**
	 * The '<em><b>SERIALIZER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SERIALIZER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SERIALIZER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SERIALIZER_VALUE = 0;

	/**
	 * The '<em><b>DESERIALIZER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DESERIALIZER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DESERIALIZER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DESERIALIZER_VALUE = 1;

	/**
	 * The '<em><b>RENDER ENGINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RENDER ENGINE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RENDER_ENGINE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RENDER_ENGINE_VALUE = 2;

	/**
	 * The '<em><b>QUERY ENGINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>QUERY ENGINE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QUERY_ENGINE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int QUERY_ENGINE_VALUE = 3;

	/**
	 * The '<em><b>OBJECT IDM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OBJECT IDM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OBJECT_IDM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OBJECT_IDM_VALUE = 4;

	/**
	 * The '<em><b>WEB MODULE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WEB MODULE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WEB_MODULE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WEB_MODULE_VALUE = 5;

	/**
	 * The '<em><b>MODEL MERGER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MODEL MERGER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MODEL_MERGER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MODEL_MERGER_VALUE = 6;

	/**
	 * The '<em><b>MODEL COMPARE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MODEL COMPARE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MODEL_COMPARE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MODEL_COMPARE_VALUE = 7;

	/**
	 * The '<em><b>MODEL CHECKER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MODEL CHECKER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MODEL_CHECKER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MODEL_CHECKER_VALUE = 8;

	/**
	 * The '<em><b>STILL IMAGE RENDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STILL IMAGE RENDER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STILL_IMAGE_RENDER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STILL_IMAGE_RENDER_VALUE = 9;

	/**
	 * The '<em><b>SERVICE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SERVICE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SERVICE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SERVICE_VALUE = 10;

	/**
	 * An array of all the '<em><b>Plugin Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final PluginType[] VALUES_ARRAY = new PluginType[] { SERIALIZER, DESERIALIZER, RENDER_ENGINE, QUERY_ENGINE, OBJECT_IDM, WEB_MODULE, MODEL_MERGER, MODEL_COMPARE, MODEL_CHECKER, STILL_IMAGE_RENDER, SERVICE, };

	/**
	 * A public read-only list of all the '<em><b>Plugin Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<PluginType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Plugin Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static PluginType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PluginType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Plugin Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static PluginType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			PluginType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Plugin Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static PluginType get(int value) {
		switch (value) {
		case SERIALIZER_VALUE:
			return SERIALIZER;
		case DESERIALIZER_VALUE:
			return DESERIALIZER;
		case RENDER_ENGINE_VALUE:
			return RENDER_ENGINE;
		case QUERY_ENGINE_VALUE:
			return QUERY_ENGINE;
		case OBJECT_IDM_VALUE:
			return OBJECT_IDM;
		case WEB_MODULE_VALUE:
			return WEB_MODULE;
		case MODEL_MERGER_VALUE:
			return MODEL_MERGER;
		case MODEL_COMPARE_VALUE:
			return MODEL_COMPARE;
		case MODEL_CHECKER_VALUE:
			return MODEL_CHECKER;
		case STILL_IMAGE_RENDER_VALUE:
			return STILL_IMAGE_RENDER;
		case SERVICE_VALUE:
			return SERVICE;
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
	private PluginType(int value, String name, String literal) {
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

} //PluginType
