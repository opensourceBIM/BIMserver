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
 * A representation of the literals of the enumeration '<em><b>Ifc BSpline Surface Form</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcBSplineSurfaceForm()
 * @model
 * @generated
 */
public enum IfcBSplineSurfaceForm implements Enumerator {
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
	 * The '<em><b>SURF OF REVOLUTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SURF_OF_REVOLUTION_VALUE
	 * @generated
	 * @ordered
	 */
	SURF_OF_REVOLUTION(1, "SURF_OF_REVOLUTION", "SURF_OF_REVOLUTION"),

	/**
	 * The '<em><b>UNSPECIFIED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNSPECIFIED_VALUE
	 * @generated
	 * @ordered
	 */
	UNSPECIFIED(2, "UNSPECIFIED", "UNSPECIFIED"),

	/**
	 * The '<em><b>TOROIDAL SURF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOROIDAL_SURF_VALUE
	 * @generated
	 * @ordered
	 */
	TOROIDAL_SURF(3, "TOROIDAL_SURF", "TOROIDAL_SURF"),

	/**
	 * The '<em><b>CONICAL SURF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONICAL_SURF_VALUE
	 * @generated
	 * @ordered
	 */
	CONICAL_SURF(4, "CONICAL_SURF", "CONICAL_SURF"),

	/**
	 * The '<em><b>QUADRIC SURF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QUADRIC_SURF_VALUE
	 * @generated
	 * @ordered
	 */
	QUADRIC_SURF(5, "QUADRIC_SURF", "QUADRIC_SURF"),

	/**
	 * The '<em><b>SURF OF LINEAR EXTRUSION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SURF_OF_LINEAR_EXTRUSION_VALUE
	 * @generated
	 * @ordered
	 */
	SURF_OF_LINEAR_EXTRUSION(6, "SURF_OF_LINEAR_EXTRUSION", "SURF_OF_LINEAR_EXTRUSION"),

	/**
	 * The '<em><b>GENERALISED CONE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GENERALISED_CONE_VALUE
	 * @generated
	 * @ordered
	 */
	GENERALISED_CONE(7, "GENERALISED_CONE", "GENERALISED_CONE"),

	/**
	 * The '<em><b>SPHERICAL SURF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPHERICAL_SURF_VALUE
	 * @generated
	 * @ordered
	 */
	SPHERICAL_SURF(8, "SPHERICAL_SURF", "SPHERICAL_SURF"),

	/**
	 * The '<em><b>RULED SURF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RULED_SURF_VALUE
	 * @generated
	 * @ordered
	 */
	RULED_SURF(9, "RULED_SURF", "RULED_SURF"),

	/**
	 * The '<em><b>CYLINDRICAL SURF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CYLINDRICAL_SURF_VALUE
	 * @generated
	 * @ordered
	 */
	CYLINDRICAL_SURF(10, "CYLINDRICAL_SURF", "CYLINDRICAL_SURF"),

	/**
	 * The '<em><b>PLANE SURF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLANE_SURF_VALUE
	 * @generated
	 * @ordered
	 */
	PLANE_SURF(11, "PLANE_SURF", "PLANE_SURF");

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
	 * The '<em><b>SURF OF REVOLUTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SURF OF REVOLUTION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SURF_OF_REVOLUTION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SURF_OF_REVOLUTION_VALUE = 1;

	/**
	 * The '<em><b>UNSPECIFIED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNSPECIFIED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNSPECIFIED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNSPECIFIED_VALUE = 2;

	/**
	 * The '<em><b>TOROIDAL SURF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TOROIDAL SURF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TOROIDAL_SURF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TOROIDAL_SURF_VALUE = 3;

	/**
	 * The '<em><b>CONICAL SURF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONICAL SURF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONICAL_SURF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONICAL_SURF_VALUE = 4;

	/**
	 * The '<em><b>QUADRIC SURF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>QUADRIC SURF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QUADRIC_SURF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int QUADRIC_SURF_VALUE = 5;

	/**
	 * The '<em><b>SURF OF LINEAR EXTRUSION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SURF OF LINEAR EXTRUSION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SURF_OF_LINEAR_EXTRUSION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SURF_OF_LINEAR_EXTRUSION_VALUE = 6;

	/**
	 * The '<em><b>GENERALISED CONE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GENERALISED CONE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GENERALISED_CONE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GENERALISED_CONE_VALUE = 7;

	/**
	 * The '<em><b>SPHERICAL SURF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SPHERICAL SURF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SPHERICAL_SURF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SPHERICAL_SURF_VALUE = 8;

	/**
	 * The '<em><b>RULED SURF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RULED SURF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RULED_SURF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RULED_SURF_VALUE = 9;

	/**
	 * The '<em><b>CYLINDRICAL SURF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CYLINDRICAL SURF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CYLINDRICAL_SURF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CYLINDRICAL_SURF_VALUE = 10;

	/**
	 * The '<em><b>PLANE SURF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PLANE SURF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLANE_SURF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PLANE_SURF_VALUE = 11;

	/**
	 * An array of all the '<em><b>Ifc BSpline Surface Form</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcBSplineSurfaceForm[] VALUES_ARRAY = new IfcBSplineSurfaceForm[] { NULL, SURF_OF_REVOLUTION, UNSPECIFIED, TOROIDAL_SURF, CONICAL_SURF, QUADRIC_SURF, SURF_OF_LINEAR_EXTRUSION, GENERALISED_CONE, SPHERICAL_SURF,
			RULED_SURF, CYLINDRICAL_SURF, PLANE_SURF, };

	/**
	 * A public read-only list of all the '<em><b>Ifc BSpline Surface Form</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcBSplineSurfaceForm> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc BSpline Surface Form</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcBSplineSurfaceForm get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcBSplineSurfaceForm result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc BSpline Surface Form</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcBSplineSurfaceForm getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcBSplineSurfaceForm result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc BSpline Surface Form</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcBSplineSurfaceForm get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case SURF_OF_REVOLUTION_VALUE:
			return SURF_OF_REVOLUTION;
		case UNSPECIFIED_VALUE:
			return UNSPECIFIED;
		case TOROIDAL_SURF_VALUE:
			return TOROIDAL_SURF;
		case CONICAL_SURF_VALUE:
			return CONICAL_SURF;
		case QUADRIC_SURF_VALUE:
			return QUADRIC_SURF;
		case SURF_OF_LINEAR_EXTRUSION_VALUE:
			return SURF_OF_LINEAR_EXTRUSION;
		case GENERALISED_CONE_VALUE:
			return GENERALISED_CONE;
		case SPHERICAL_SURF_VALUE:
			return SPHERICAL_SURF;
		case RULED_SURF_VALUE:
			return RULED_SURF;
		case CYLINDRICAL_SURF_VALUE:
			return CYLINDRICAL_SURF;
		case PLANE_SURF_VALUE:
			return PLANE_SURF;
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
	private IfcBSplineSurfaceForm(int value, String name, String literal) {
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

} //IfcBSplineSurfaceForm
