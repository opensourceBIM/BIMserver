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
 * A representation of the literals of the enumeration '<em><b>SI Prefix</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.store.StorePackage#getSIPrefix()
 * @model
 * @generated
 */
public enum SIPrefix implements Enumerator
{
	/**
	 * The '<em><b>Meter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #METER
	 * @generated
	 * @ordered
	 */
	METER_LITERAL(0, "meter", "meter"),

	/**
	 * The '<em><b>Attometer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ATTOMETER
	 * @generated
	 * @ordered
	 */
	ATTOMETER_LITERAL(-18, "attometer", "attometer"),

	/**
	 * The '<em><b>Femtometer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FEMTOMETER
	 * @generated
	 * @ordered
	 */
	FEMTOMETER_LITERAL(-15, "femtometer", "femtometer"),

	/**
	 * The '<em><b>Picometer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PICOMETER
	 * @generated
	 * @ordered
	 */
	PICOMETER_LITERAL(-12, "picometer", "picometer"),

	/**
	 * The '<em><b>Nanometer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NANOMETER
	 * @generated
	 * @ordered
	 */
	NANOMETER_LITERAL(-9, "nanometer", "nanometer"),

	/**
	 * The '<em><b>Micrometer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MICROMETER
	 * @generated
	 * @ordered
	 */
	MICROMETER_LITERAL(-6, "micrometer", "micrometer"),

	/**
	 * The '<em><b>Millimeter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MILLIMETER
	 * @generated
	 * @ordered
	 */
	MILLIMETER_LITERAL(-3, "millimeter", "millimeter"),

	/**
	 * The '<em><b>Centimeter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CENTIMETER
	 * @generated
	 * @ordered
	 */
	CENTIMETER_LITERAL(-2, "centimeter", "centimeter"),

	/**
	 * The '<em><b>Decimeter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECIMETER
	 * @generated
	 * @ordered
	 */
	DECIMETER_LITERAL(-1, "decimeter", "decimeter"),

	/**
	 * The '<em><b>Decameter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECAMETER
	 * @generated
	 * @ordered
	 */
	DECAMETER_LITERAL(1, "decameter", "decameter"),

	/**
	 * The '<em><b>Hectometer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HECTOMETER
	 * @generated
	 * @ordered
	 */
	HECTOMETER_LITERAL(2, "hectometer", "hectometer"),

	/**
	 * The '<em><b>Kilometer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KILOMETER
	 * @generated
	 * @ordered
	 */
	KILOMETER_LITERAL(3, "kilometer", "kilometer"),

	/**
	 * The '<em><b>Megameter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEGAMETER
	 * @generated
	 * @ordered
	 */
	MEGAMETER_LITERAL(6, "megameter", "megameter"),

	/**
	 * The '<em><b>Gigameter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GIGAMETER
	 * @generated
	 * @ordered
	 */
	GIGAMETER_LITERAL(9, "gigameter", "gigameter"),

	/**
	 * The '<em><b>Terameter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TERAMETER
	 * @generated
	 * @ordered
	 */
	TERAMETER_LITERAL(12, "terameter", "terameter"),

	/**
	 * The '<em><b>Petameter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PETAMETER
	 * @generated
	 * @ordered
	 */
	PETAMETER_LITERAL(15, "petameter", "petameter"),

	/**
	 * The '<em><b>Exameter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXAMETER
	 * @generated
	 * @ordered
	 */
	EXAMETER_LITERAL(18, "exameter", "exameter");

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * The '<em><b>Meter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Meter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #METER_LITERAL
	 * @model name="meter"
	 * @generated
	 * @ordered
	 */
	public static final int METER = 0;

	/**
	 * The '<em><b>Attometer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Attometer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ATTOMETER_LITERAL
	 * @model name="attometer"
	 * @generated
	 * @ordered
	 */
	public static final int ATTOMETER = -18;

	/**
	 * The '<em><b>Femtometer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Femtometer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FEMTOMETER_LITERAL
	 * @model name="femtometer"
	 * @generated
	 * @ordered
	 */
	public static final int FEMTOMETER = -15;

	/**
	 * The '<em><b>Picometer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Picometer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PICOMETER_LITERAL
	 * @model name="picometer"
	 * @generated
	 * @ordered
	 */
	public static final int PICOMETER = -12;

	/**
	 * The '<em><b>Nanometer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Nanometer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NANOMETER_LITERAL
	 * @model name="nanometer"
	 * @generated
	 * @ordered
	 */
	public static final int NANOMETER = -9;

	/**
	 * The '<em><b>Micrometer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Micrometer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MICROMETER_LITERAL
	 * @model name="micrometer"
	 * @generated
	 * @ordered
	 */
	public static final int MICROMETER = -6;

	/**
	 * The '<em><b>Millimeter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Millimeter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MILLIMETER_LITERAL
	 * @model name="millimeter"
	 * @generated
	 * @ordered
	 */
	public static final int MILLIMETER = -3;

	/**
	 * The '<em><b>Centimeter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Centimeter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CENTIMETER_LITERAL
	 * @model name="centimeter"
	 * @generated
	 * @ordered
	 */
	public static final int CENTIMETER = -2;

	/**
	 * The '<em><b>Decimeter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Decimeter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DECIMETER_LITERAL
	 * @model name="decimeter"
	 * @generated
	 * @ordered
	 */
	public static final int DECIMETER = -1;

	/**
	 * The '<em><b>Decameter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Decameter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DECAMETER_LITERAL
	 * @model name="decameter"
	 * @generated
	 * @ordered
	 */
	public static final int DECAMETER = 1;

	/**
	 * The '<em><b>Hectometer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Hectometer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HECTOMETER_LITERAL
	 * @model name="hectometer"
	 * @generated
	 * @ordered
	 */
	public static final int HECTOMETER = 2;

	/**
	 * The '<em><b>Kilometer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Kilometer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KILOMETER_LITERAL
	 * @model name="kilometer"
	 * @generated
	 * @ordered
	 */
	public static final int KILOMETER = 3;

	/**
	 * The '<em><b>Megameter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Megameter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEGAMETER_LITERAL
	 * @model name="megameter"
	 * @generated
	 * @ordered
	 */
	public static final int MEGAMETER = 6;

	/**
	 * The '<em><b>Gigameter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Gigameter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GIGAMETER_LITERAL
	 * @model name="gigameter"
	 * @generated
	 * @ordered
	 */
	public static final int GIGAMETER = 9;

	/**
	 * The '<em><b>Terameter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Terameter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TERAMETER_LITERAL
	 * @model name="terameter"
	 * @generated
	 * @ordered
	 */
	public static final int TERAMETER = 12;

	/**
	 * The '<em><b>Petameter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Petameter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PETAMETER_LITERAL
	 * @model name="petameter"
	 * @generated
	 * @ordered
	 */
	public static final int PETAMETER = 15;

	/**
	 * The '<em><b>Exameter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Exameter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXAMETER_LITERAL
	 * @model name="exameter"
	 * @generated
	 * @ordered
	 */
	public static final int EXAMETER = 18;

	/**
	 * An array of all the '<em><b>SI Prefix</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SIPrefix[] VALUES_ARRAY =
		new SIPrefix[]
		{
			METER_LITERAL,
			ATTOMETER_LITERAL,
			FEMTOMETER_LITERAL,
			PICOMETER_LITERAL,
			NANOMETER_LITERAL,
			MICROMETER_LITERAL,
			MILLIMETER_LITERAL,
			CENTIMETER_LITERAL,
			DECIMETER_LITERAL,
			DECAMETER_LITERAL,
			HECTOMETER_LITERAL,
			KILOMETER_LITERAL,
			MEGAMETER_LITERAL,
			GIGAMETER_LITERAL,
			TERAMETER_LITERAL,
			PETAMETER_LITERAL,
			EXAMETER_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>SI Prefix</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SIPrefix> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>SI Prefix</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SIPrefix get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			SIPrefix result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>SI Prefix</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SIPrefix getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			SIPrefix result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>SI Prefix</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SIPrefix get(int value)
	{
		switch (value)
		{
			case METER: return METER_LITERAL;
			case ATTOMETER: return ATTOMETER_LITERAL;
			case FEMTOMETER: return FEMTOMETER_LITERAL;
			case PICOMETER: return PICOMETER_LITERAL;
			case NANOMETER: return NANOMETER_LITERAL;
			case MICROMETER: return MICROMETER_LITERAL;
			case MILLIMETER: return MILLIMETER_LITERAL;
			case CENTIMETER: return CENTIMETER_LITERAL;
			case DECIMETER: return DECIMETER_LITERAL;
			case DECAMETER: return DECAMETER_LITERAL;
			case HECTOMETER: return HECTOMETER_LITERAL;
			case KILOMETER: return KILOMETER_LITERAL;
			case MEGAMETER: return MEGAMETER_LITERAL;
			case GIGAMETER: return GIGAMETER_LITERAL;
			case TERAMETER: return TERAMETER_LITERAL;
			case PETAMETER: return PETAMETER_LITERAL;
			case EXAMETER: return EXAMETER_LITERAL;
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
	private SIPrefix(int value, String name, String literal)
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
	
} //SIPrefix
