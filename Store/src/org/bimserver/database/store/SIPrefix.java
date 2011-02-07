/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.database.store;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>SI Prefix</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.database.store.StorePackage#getSIPrefix()
 * @model
 * @generated
 */
public enum SIPrefix implements Enumerator {
	/**
	 * The '<em><b>Meter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #METER_VALUE
	 * @generated
	 * @ordered
	 */
	METER(0, "meter", "NULL"), /**
	 * The '<em><b>Attometer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ATTOMETER_VALUE
	 * @generated
	 * @ordered
	 */
	ATTOMETER(-18, "attometer", "ATTO"), /**
	 * The '<em><b>Femtometer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FEMTOMETER_VALUE
	 * @generated
	 * @ordered
	 */
	FEMTOMETER(-15, "femtometer", "FEMTO"), /**
	 * The '<em><b>Picometer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PICOMETER_VALUE
	 * @generated
	 * @ordered
	 */
	PICOMETER(-12, "picometer", "PICO"), /**
	 * The '<em><b>Nanometer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NANOMETER_VALUE
	 * @generated
	 * @ordered
	 */
	NANOMETER(-9, "nanometer", "NANO"), /**
	 * The '<em><b>Micrometer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MICROMETER_VALUE
	 * @generated
	 * @ordered
	 */
	MICROMETER(-6, "micrometer", "MICRO"), /**
	 * The '<em><b>Millimeter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MILLIMETER_VALUE
	 * @generated
	 * @ordered
	 */
	MILLIMETER(-3, "millimeter", "MILLI"), /**
	 * The '<em><b>Centimeter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CENTIMETER_VALUE
	 * @generated
	 * @ordered
	 */
	CENTIMETER(-2, "centimeter", "CENTI"), /**
	 * The '<em><b>Decimeter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECIMETER_VALUE
	 * @generated
	 * @ordered
	 */
	DECIMETER(-1, "decimeter", "DECI"), /**
	 * The '<em><b>Decameter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECAMETER_VALUE
	 * @generated
	 * @ordered
	 */
	DECAMETER(1, "decameter", "DECA"), /**
	 * The '<em><b>Hectometer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HECTOMETER_VALUE
	 * @generated
	 * @ordered
	 */
	HECTOMETER(2, "hectometer", "HECTO"), /**
	 * The '<em><b>Kilometer</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KILOMETER_VALUE
	 * @generated
	 * @ordered
	 */
	KILOMETER(3, "kilometer", "KILO"), /**
	 * The '<em><b>Megameter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEGAMETER_VALUE
	 * @generated
	 * @ordered
	 */
	MEGAMETER(6, "megameter", "MEGA"), /**
	 * The '<em><b>Gigameter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GIGAMETER_VALUE
	 * @generated
	 * @ordered
	 */
	GIGAMETER(9, "gigameter", "GIGA"), /**
	 * The '<em><b>Terameter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TERAMETER_VALUE
	 * @generated
	 * @ordered
	 */
	TERAMETER(12, "terameter", "TERA"), /**
	 * The '<em><b>Petameter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PETAMETER_VALUE
	 * @generated
	 * @ordered
	 */
	PETAMETER(15, "petameter", "PETA"), /**
	 * The '<em><b>Exameter</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXAMETER_VALUE
	 * @generated
	 * @ordered
	 */
	EXAMETER(18, "exameter", "EXA");

	/**
	 * The '<em><b>Meter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Meter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #METER
	 * @model name="meter" literal="NULL"
	 * @generated
	 * @ordered
	 */
	public static final int METER_VALUE = 0;

	/**
	 * The '<em><b>Attometer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Attometer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ATTOMETER
	 * @model name="attometer" literal="ATTO"
	 * @generated
	 * @ordered
	 */
	public static final int ATTOMETER_VALUE = -18;

	/**
	 * The '<em><b>Femtometer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Femtometer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FEMTOMETER
	 * @model name="femtometer" literal="FEMTO"
	 * @generated
	 * @ordered
	 */
	public static final int FEMTOMETER_VALUE = -15;

	/**
	 * The '<em><b>Picometer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Picometer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PICOMETER
	 * @model name="picometer" literal="PICO"
	 * @generated
	 * @ordered
	 */
	public static final int PICOMETER_VALUE = -12;

	/**
	 * The '<em><b>Nanometer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Nanometer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NANOMETER
	 * @model name="nanometer" literal="NANO"
	 * @generated
	 * @ordered
	 */
	public static final int NANOMETER_VALUE = -9;

	/**
	 * The '<em><b>Micrometer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Micrometer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MICROMETER
	 * @model name="micrometer" literal="MICRO"
	 * @generated
	 * @ordered
	 */
	public static final int MICROMETER_VALUE = -6;

	/**
	 * The '<em><b>Millimeter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Millimeter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MILLIMETER
	 * @model name="millimeter" literal="MILLI"
	 * @generated
	 * @ordered
	 */
	public static final int MILLIMETER_VALUE = -3;

	/**
	 * The '<em><b>Centimeter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Centimeter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CENTIMETER
	 * @model name="centimeter" literal="CENTI"
	 * @generated
	 * @ordered
	 */
	public static final int CENTIMETER_VALUE = -2;

	/**
	 * The '<em><b>Decimeter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Decimeter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DECIMETER
	 * @model name="decimeter" literal="DECI"
	 * @generated
	 * @ordered
	 */
	public static final int DECIMETER_VALUE = -1;

	/**
	 * The '<em><b>Decameter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Decameter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DECAMETER
	 * @model name="decameter" literal="DECA"
	 * @generated
	 * @ordered
	 */
	public static final int DECAMETER_VALUE = 1;

	/**
	 * The '<em><b>Hectometer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Hectometer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HECTOMETER
	 * @model name="hectometer" literal="HECTO"
	 * @generated
	 * @ordered
	 */
	public static final int HECTOMETER_VALUE = 2;

	/**
	 * The '<em><b>Kilometer</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Kilometer</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KILOMETER
	 * @model name="kilometer" literal="KILO"
	 * @generated
	 * @ordered
	 */
	public static final int KILOMETER_VALUE = 3;

	/**
	 * The '<em><b>Megameter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Megameter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEGAMETER
	 * @model name="megameter" literal="MEGA"
	 * @generated
	 * @ordered
	 */
	public static final int MEGAMETER_VALUE = 6;

	/**
	 * The '<em><b>Gigameter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Gigameter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GIGAMETER
	 * @model name="gigameter" literal="GIGA"
	 * @generated
	 * @ordered
	 */
	public static final int GIGAMETER_VALUE = 9;

	/**
	 * The '<em><b>Terameter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Terameter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TERAMETER
	 * @model name="terameter" literal="TERA"
	 * @generated
	 * @ordered
	 */
	public static final int TERAMETER_VALUE = 12;

	/**
	 * The '<em><b>Petameter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Petameter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PETAMETER
	 * @model name="petameter" literal="PETA"
	 * @generated
	 * @ordered
	 */
	public static final int PETAMETER_VALUE = 15;

	/**
	 * The '<em><b>Exameter</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Exameter</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXAMETER
	 * @model name="exameter" literal="EXA"
	 * @generated
	 * @ordered
	 */
	public static final int EXAMETER_VALUE = 18;

	/**
	 * An array of all the '<em><b>SI Prefix</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SIPrefix[] VALUES_ARRAY =
		new SIPrefix[] {
			METER,
			ATTOMETER,
			FEMTOMETER,
			PICOMETER,
			NANOMETER,
			MICROMETER,
			MILLIMETER,
			CENTIMETER,
			DECIMETER,
			DECAMETER,
			HECTOMETER,
			KILOMETER,
			MEGAMETER,
			GIGAMETER,
			TERAMETER,
			PETAMETER,
			EXAMETER,
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
	public static SIPrefix get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SIPrefix result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
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
	public static SIPrefix getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SIPrefix result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
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
	public static SIPrefix get(int value) {
		switch (value) {
			case METER_VALUE: return METER;
			case ATTOMETER_VALUE: return ATTOMETER;
			case FEMTOMETER_VALUE: return FEMTOMETER;
			case PICOMETER_VALUE: return PICOMETER;
			case NANOMETER_VALUE: return NANOMETER;
			case MICROMETER_VALUE: return MICROMETER;
			case MILLIMETER_VALUE: return MILLIMETER;
			case CENTIMETER_VALUE: return CENTIMETER;
			case DECIMETER_VALUE: return DECIMETER;
			case DECAMETER_VALUE: return DECAMETER;
			case HECTOMETER_VALUE: return HECTOMETER;
			case KILOMETER_VALUE: return KILOMETER;
			case MEGAMETER_VALUE: return MEGAMETER;
			case GIGAMETER_VALUE: return GIGAMETER;
			case TERAMETER_VALUE: return TERAMETER;
			case PETAMETER_VALUE: return PETAMETER;
			case EXAMETER_VALUE: return EXAMETER;
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
	private SIPrefix(int value, String name, String literal) {
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
	
} //SIPrefix
