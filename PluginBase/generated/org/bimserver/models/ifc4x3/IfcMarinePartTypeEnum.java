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
package org.bimserver.models.ifc4x3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Ifc Marine Part Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcMarinePartTypeEnum()
 * @model
 * @generated
 */
public enum IfcMarinePartTypeEnum implements Enumerator {
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
	 * The '<em><b>CORE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CORE_VALUE
	 * @generated
	 * @ordered
	 */
	CORE(1, "CORE", "CORE"),

	/**
	 * The '<em><b>CREST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREST_VALUE
	 * @generated
	 * @ordered
	 */
	CREST(2, "CREST", "CREST"),

	/**
	 * The '<em><b>COPELEVEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COPELEVEL_VALUE
	 * @generated
	 * @ordered
	 */
	COPELEVEL(3, "COPELEVEL", "COPELEVEL"),

	/**
	 * The '<em><b>GATEHEAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GATEHEAD_VALUE
	 * @generated
	 * @ordered
	 */
	GATEHEAD(4, "GATEHEAD", "GATEHEAD"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USERDEFINED(5, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>LEEWARDSIDE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LEEWARDSIDE_VALUE
	 * @generated
	 * @ordered
	 */
	LEEWARDSIDE(6, "LEEWARDSIDE", "LEEWARDSIDE"),

	/**
	 * The '<em><b>APPROACHCHANNEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #APPROACHCHANNEL_VALUE
	 * @generated
	 * @ordered
	 */
	APPROACHCHANNEL(7, "APPROACHCHANNEL", "APPROACHCHANNEL"),

	/**
	 * The '<em><b>CILL LEVEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CILL_LEVEL_VALUE
	 * @generated
	 * @ordered
	 */
	CILL_LEVEL(8, "CILL_LEVEL", "CILL_LEVEL"),

	/**
	 * The '<em><b>GUDINGSTRUCTURE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GUDINGSTRUCTURE_VALUE
	 * @generated
	 * @ordered
	 */
	GUDINGSTRUCTURE(9, "GUDINGSTRUCTURE", "GUDINGSTRUCTURE"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(10, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>ANCHORAGE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANCHORAGE_VALUE
	 * @generated
	 * @ordered
	 */
	ANCHORAGE(11, "ANCHORAGE", "ANCHORAGE"),

	/**
	 * The '<em><b>LOWWATERLINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOWWATERLINE_VALUE
	 * @generated
	 * @ordered
	 */
	LOWWATERLINE(12, "LOWWATERLINE", "LOWWATERLINE"),

	/**
	 * The '<em><b>VEHICLESERVICING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VEHICLESERVICING_VALUE
	 * @generated
	 * @ordered
	 */
	VEHICLESERVICING(13, "VEHICLESERVICING", "VEHICLESERVICING"),

	/**
	 * The '<em><b>NAVIGATIONALAREA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NAVIGATIONALAREA_VALUE
	 * @generated
	 * @ordered
	 */
	NAVIGATIONALAREA(14, "NAVIGATIONALAREA", "NAVIGATIONALAREA"),

	/**
	 * The '<em><b>BELOWWATERLINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BELOWWATERLINE_VALUE
	 * @generated
	 * @ordered
	 */
	BELOWWATERLINE(15, "BELOWWATERLINE", "BELOWWATERLINE"),

	/**
	 * The '<em><b>BERTHINGSTRUCTURE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BERTHINGSTRUCTURE_VALUE
	 * @generated
	 * @ordered
	 */
	BERTHINGSTRUCTURE(16, "BERTHINGSTRUCTURE", "BERTHINGSTRUCTURE"),

	/**
	 * The '<em><b>SHIPTRANSFER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHIPTRANSFER_VALUE
	 * @generated
	 * @ordered
	 */
	SHIPTRANSFER(17, "SHIPTRANSFER", "SHIPTRANSFER"),

	/**
	 * The '<em><b>WEATHERSIDE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WEATHERSIDE_VALUE
	 * @generated
	 * @ordered
	 */
	WEATHERSIDE(18, "WEATHERSIDE", "WEATHERSIDE"),

	/**
	 * The '<em><b>PROTECTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROTECTION_VALUE
	 * @generated
	 * @ordered
	 */
	PROTECTION(19, "PROTECTION", "PROTECTION"),

	/**
	 * The '<em><b>ABOVEWATERLINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ABOVEWATERLINE_VALUE
	 * @generated
	 * @ordered
	 */
	ABOVEWATERLINE(20, "ABOVEWATERLINE", "ABOVEWATERLINE"),

	/**
	 * The '<em><b>LANDFIELD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LANDFIELD_VALUE
	 * @generated
	 * @ordered
	 */
	LANDFIELD(21, "LANDFIELD", "LANDFIELD"),

	/**
	 * The '<em><b>CHAMBER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHAMBER_VALUE
	 * @generated
	 * @ordered
	 */
	CHAMBER(22, "CHAMBER", "CHAMBER"),

	/**
	 * The '<em><b>STORAGEAREA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STORAGEAREA_VALUE
	 * @generated
	 * @ordered
	 */
	STORAGEAREA(23, "STORAGEAREA", "STORAGEAREA"),

	/**
	 * The '<em><b>WATERFIELD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WATERFIELD_VALUE
	 * @generated
	 * @ordered
	 */
	WATERFIELD(24, "WATERFIELD", "WATERFIELD"),

	/**
	 * The '<em><b>MANUFACTURING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MANUFACTURING_VALUE
	 * @generated
	 * @ordered
	 */
	MANUFACTURING(25, "MANUFACTURING", "MANUFACTURING"),

	/**
	 * The '<em><b>HIGHWATERLINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HIGHWATERLINE_VALUE
	 * @generated
	 * @ordered
	 */
	HIGHWATERLINE(26, "HIGHWATERLINE", "HIGHWATERLINE");

	/**
	 * The '<em><b>NULL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NULL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NULL_VALUE = 0;

	/**
	 * The '<em><b>CORE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CORE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CORE_VALUE = 1;

	/**
	 * The '<em><b>CREST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CREST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CREST_VALUE = 2;

	/**
	 * The '<em><b>COPELEVEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COPELEVEL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COPELEVEL_VALUE = 3;

	/**
	 * The '<em><b>GATEHEAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GATEHEAD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GATEHEAD_VALUE = 4;

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USERDEFINED_VALUE = 5;

	/**
	 * The '<em><b>LEEWARDSIDE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LEEWARDSIDE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LEEWARDSIDE_VALUE = 6;

	/**
	 * The '<em><b>APPROACHCHANNEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #APPROACHCHANNEL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int APPROACHCHANNEL_VALUE = 7;

	/**
	 * The '<em><b>CILL LEVEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CILL_LEVEL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CILL_LEVEL_VALUE = 8;

	/**
	 * The '<em><b>GUDINGSTRUCTURE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GUDINGSTRUCTURE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GUDINGSTRUCTURE_VALUE = 9;

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTDEFINED_VALUE = 10;

	/**
	 * The '<em><b>ANCHORAGE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANCHORAGE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ANCHORAGE_VALUE = 11;

	/**
	 * The '<em><b>LOWWATERLINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOWWATERLINE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LOWWATERLINE_VALUE = 12;

	/**
	 * The '<em><b>VEHICLESERVICING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VEHICLESERVICING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VEHICLESERVICING_VALUE = 13;

	/**
	 * The '<em><b>NAVIGATIONALAREA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NAVIGATIONALAREA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NAVIGATIONALAREA_VALUE = 14;

	/**
	 * The '<em><b>BELOWWATERLINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BELOWWATERLINE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BELOWWATERLINE_VALUE = 15;

	/**
	 * The '<em><b>BERTHINGSTRUCTURE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BERTHINGSTRUCTURE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BERTHINGSTRUCTURE_VALUE = 16;

	/**
	 * The '<em><b>SHIPTRANSFER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHIPTRANSFER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SHIPTRANSFER_VALUE = 17;

	/**
	 * The '<em><b>WEATHERSIDE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WEATHERSIDE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WEATHERSIDE_VALUE = 18;

	/**
	 * The '<em><b>PROTECTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PROTECTION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PROTECTION_VALUE = 19;

	/**
	 * The '<em><b>ABOVEWATERLINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ABOVEWATERLINE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ABOVEWATERLINE_VALUE = 20;

	/**
	 * The '<em><b>LANDFIELD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LANDFIELD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LANDFIELD_VALUE = 21;

	/**
	 * The '<em><b>CHAMBER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHAMBER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHAMBER_VALUE = 22;

	/**
	 * The '<em><b>STORAGEAREA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STORAGEAREA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STORAGEAREA_VALUE = 23;

	/**
	 * The '<em><b>WATERFIELD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WATERFIELD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WATERFIELD_VALUE = 24;

	/**
	 * The '<em><b>MANUFACTURING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MANUFACTURING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MANUFACTURING_VALUE = 25;

	/**
	 * The '<em><b>HIGHWATERLINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HIGHWATERLINE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HIGHWATERLINE_VALUE = 26;

	/**
	 * An array of all the '<em><b>Ifc Marine Part Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcMarinePartTypeEnum[] VALUES_ARRAY = new IfcMarinePartTypeEnum[] { NULL, CORE, CREST,
			COPELEVEL, GATEHEAD, USERDEFINED, LEEWARDSIDE, APPROACHCHANNEL, CILL_LEVEL, GUDINGSTRUCTURE, NOTDEFINED,
			ANCHORAGE, LOWWATERLINE, VEHICLESERVICING, NAVIGATIONALAREA, BELOWWATERLINE, BERTHINGSTRUCTURE,
			SHIPTRANSFER, WEATHERSIDE, PROTECTION, ABOVEWATERLINE, LANDFIELD, CHAMBER, STORAGEAREA, WATERFIELD,
			MANUFACTURING, HIGHWATERLINE, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Marine Part Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcMarinePartTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Marine Part Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcMarinePartTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcMarinePartTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Marine Part Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcMarinePartTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcMarinePartTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Marine Part Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcMarinePartTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case CORE_VALUE:
			return CORE;
		case CREST_VALUE:
			return CREST;
		case COPELEVEL_VALUE:
			return COPELEVEL;
		case GATEHEAD_VALUE:
			return GATEHEAD;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case LEEWARDSIDE_VALUE:
			return LEEWARDSIDE;
		case APPROACHCHANNEL_VALUE:
			return APPROACHCHANNEL;
		case CILL_LEVEL_VALUE:
			return CILL_LEVEL;
		case GUDINGSTRUCTURE_VALUE:
			return GUDINGSTRUCTURE;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case ANCHORAGE_VALUE:
			return ANCHORAGE;
		case LOWWATERLINE_VALUE:
			return LOWWATERLINE;
		case VEHICLESERVICING_VALUE:
			return VEHICLESERVICING;
		case NAVIGATIONALAREA_VALUE:
			return NAVIGATIONALAREA;
		case BELOWWATERLINE_VALUE:
			return BELOWWATERLINE;
		case BERTHINGSTRUCTURE_VALUE:
			return BERTHINGSTRUCTURE;
		case SHIPTRANSFER_VALUE:
			return SHIPTRANSFER;
		case WEATHERSIDE_VALUE:
			return WEATHERSIDE;
		case PROTECTION_VALUE:
			return PROTECTION;
		case ABOVEWATERLINE_VALUE:
			return ABOVEWATERLINE;
		case LANDFIELD_VALUE:
			return LANDFIELD;
		case CHAMBER_VALUE:
			return CHAMBER;
		case STORAGEAREA_VALUE:
			return STORAGEAREA;
		case WATERFIELD_VALUE:
			return WATERFIELD;
		case MANUFACTURING_VALUE:
			return MANUFACTURING;
		case HIGHWATERLINE_VALUE:
			return HIGHWATERLINE;
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
	private IfcMarinePartTypeEnum(int value, String name, String literal) {
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

} //IfcMarinePartTypeEnum
