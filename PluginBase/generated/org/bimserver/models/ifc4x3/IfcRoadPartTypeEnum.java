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
 * A representation of the literals of the enumeration '<em><b>Ifc Road Part Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcRoadPartTypeEnum()
 * @model
 * @generated
 */
public enum IfcRoadPartTypeEnum implements Enumerator {
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
	 * The '<em><b>BUS STOP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BUS_STOP_VALUE
	 * @generated
	 * @ordered
	 */
	BUS_STOP(1, "BUS_STOP", "BUS_STOP"),

	/**
	 * The '<em><b>SHOULDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHOULDER_VALUE
	 * @generated
	 * @ordered
	 */
	SHOULDER(2, "SHOULDER", "SHOULDER"),

	/**
	 * The '<em><b>CENTRALISLAND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CENTRALISLAND_VALUE
	 * @generated
	 * @ordered
	 */
	CENTRALISLAND(3, "CENTRALISLAND", "CENTRALISLAND"),

	/**
	 * The '<em><b>SIDEWALK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIDEWALK_VALUE
	 * @generated
	 * @ordered
	 */
	SIDEWALK(4, "SIDEWALK", "SIDEWALK"),

	/**
	 * The '<em><b>PARKINGBAY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PARKINGBAY_VALUE
	 * @generated
	 * @ordered
	 */
	PARKINGBAY(5, "PARKINGBAY", "PARKINGBAY"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	USERDEFINED(6, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>ROADSIDE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROADSIDE_VALUE
	 * @generated
	 * @ordered
	 */
	ROADSIDE(7, "ROADSIDE", "ROADSIDE"),

	/**
	 * The '<em><b>ROADWAYPLATEAU</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROADWAYPLATEAU_VALUE
	 * @generated
	 * @ordered
	 */
	ROADWAYPLATEAU(8, "ROADWAYPLATEAU", "ROADWAYPLATEAU"),

	/**
	 * The '<em><b>RAILWAYCROSSING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAILWAYCROSSING_VALUE
	 * @generated
	 * @ordered
	 */
	RAILWAYCROSSING(9, "RAILWAYCROSSING", "RAILWAYCROSSING"),

	/**
	 * The '<em><b>CENTRALRESERVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CENTRALRESERVE_VALUE
	 * @generated
	 * @ordered
	 */
	CENTRALRESERVE(10, "CENTRALRESERVE", "CENTRALRESERVE"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(11, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>REFUGEISLAND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REFUGEISLAND_VALUE
	 * @generated
	 * @ordered
	 */
	REFUGEISLAND(12, "REFUGEISLAND", "REFUGEISLAND"),

	/**
	 * The '<em><b>TRAFFICLANE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRAFFICLANE_VALUE
	 * @generated
	 * @ordered
	 */
	TRAFFICLANE(13, "TRAFFICLANE", "TRAFFICLANE"),

	/**
	 * The '<em><b>HARDSHOULDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HARDSHOULDER_VALUE
	 * @generated
	 * @ordered
	 */
	HARDSHOULDER(14, "HARDSHOULDER", "HARDSHOULDER"),

	/**
	 * The '<em><b>LAYBY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LAYBY_VALUE
	 * @generated
	 * @ordered
	 */
	LAYBY(15, "LAYBY", "LAYBY"),

	/**
	 * The '<em><b>TOLLPLAZA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOLLPLAZA_VALUE
	 * @generated
	 * @ordered
	 */
	TOLLPLAZA(16, "TOLLPLAZA", "TOLLPLAZA"),

	/**
	 * The '<em><b>ROADSIDEPART</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROADSIDEPART_VALUE
	 * @generated
	 * @ordered
	 */
	ROADSIDEPART(17, "ROADSIDEPART", "ROADSIDEPART"),

	/**
	 * The '<em><b>CARRIAGEWAY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CARRIAGEWAY_VALUE
	 * @generated
	 * @ordered
	 */
	CARRIAGEWAY(18, "CARRIAGEWAY", "CARRIAGEWAY"),

	/**
	 * The '<em><b>SOFTSHOULDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOFTSHOULDER_VALUE
	 * @generated
	 * @ordered
	 */
	SOFTSHOULDER(19, "SOFTSHOULDER", "SOFTSHOULDER"),

	/**
	 * The '<em><b>BICYCLECROSSING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BICYCLECROSSING_VALUE
	 * @generated
	 * @ordered
	 */
	BICYCLECROSSING(20, "BICYCLECROSSING", "BICYCLECROSSING"),

	/**
	 * The '<em><b>PEDESTRIAN CROSSING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PEDESTRIAN_CROSSING_VALUE
	 * @generated
	 * @ordered
	 */
	PEDESTRIAN_CROSSING(21, "PEDESTRIAN_CROSSING", "PEDESTRIAN_CROSSING"),

	/**
	 * The '<em><b>PASSINGBAY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PASSINGBAY_VALUE
	 * @generated
	 * @ordered
	 */
	PASSINGBAY(22, "PASSINGBAY", "PASSINGBAY"),

	/**
	 * The '<em><b>TRAFFICISLAND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRAFFICISLAND_VALUE
	 * @generated
	 * @ordered
	 */
	TRAFFICISLAND(23, "TRAFFICISLAND", "TRAFFICISLAND"),

	/**
	 * The '<em><b>INTERSECTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTERSECTION_VALUE
	 * @generated
	 * @ordered
	 */
	INTERSECTION(24, "INTERSECTION", "INTERSECTION"),

	/**
	 * The '<em><b>ROUNDABOUT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROUNDABOUT_VALUE
	 * @generated
	 * @ordered
	 */
	ROUNDABOUT(25, "ROUNDABOUT", "ROUNDABOUT"),

	/**
	 * The '<em><b>ROADSEGMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROADSEGMENT_VALUE
	 * @generated
	 * @ordered
	 */
	ROADSEGMENT(26, "ROADSEGMENT", "ROADSEGMENT");

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
	 * The '<em><b>BUS STOP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BUS_STOP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BUS_STOP_VALUE = 1;

	/**
	 * The '<em><b>SHOULDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHOULDER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SHOULDER_VALUE = 2;

	/**
	 * The '<em><b>CENTRALISLAND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CENTRALISLAND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CENTRALISLAND_VALUE = 3;

	/**
	 * The '<em><b>SIDEWALK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIDEWALK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SIDEWALK_VALUE = 4;

	/**
	 * The '<em><b>PARKINGBAY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PARKINGBAY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PARKINGBAY_VALUE = 5;

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USERDEFINED_VALUE = 6;

	/**
	 * The '<em><b>ROADSIDE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROADSIDE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROADSIDE_VALUE = 7;

	/**
	 * The '<em><b>ROADWAYPLATEAU</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROADWAYPLATEAU
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROADWAYPLATEAU_VALUE = 8;

	/**
	 * The '<em><b>RAILWAYCROSSING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAILWAYCROSSING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RAILWAYCROSSING_VALUE = 9;

	/**
	 * The '<em><b>CENTRALRESERVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CENTRALRESERVE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CENTRALRESERVE_VALUE = 10;

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTDEFINED_VALUE = 11;

	/**
	 * The '<em><b>REFUGEISLAND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REFUGEISLAND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REFUGEISLAND_VALUE = 12;

	/**
	 * The '<em><b>TRAFFICLANE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRAFFICLANE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRAFFICLANE_VALUE = 13;

	/**
	 * The '<em><b>HARDSHOULDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HARDSHOULDER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HARDSHOULDER_VALUE = 14;

	/**
	 * The '<em><b>LAYBY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LAYBY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LAYBY_VALUE = 15;

	/**
	 * The '<em><b>TOLLPLAZA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOLLPLAZA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TOLLPLAZA_VALUE = 16;

	/**
	 * The '<em><b>ROADSIDEPART</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROADSIDEPART
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROADSIDEPART_VALUE = 17;

	/**
	 * The '<em><b>CARRIAGEWAY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CARRIAGEWAY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CARRIAGEWAY_VALUE = 18;

	/**
	 * The '<em><b>SOFTSHOULDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOFTSHOULDER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SOFTSHOULDER_VALUE = 19;

	/**
	 * The '<em><b>BICYCLECROSSING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BICYCLECROSSING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BICYCLECROSSING_VALUE = 20;

	/**
	 * The '<em><b>PEDESTRIAN CROSSING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PEDESTRIAN_CROSSING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PEDESTRIAN_CROSSING_VALUE = 21;

	/**
	 * The '<em><b>PASSINGBAY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PASSINGBAY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PASSINGBAY_VALUE = 22;

	/**
	 * The '<em><b>TRAFFICISLAND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRAFFICISLAND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRAFFICISLAND_VALUE = 23;

	/**
	 * The '<em><b>INTERSECTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INTERSECTION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INTERSECTION_VALUE = 24;

	/**
	 * The '<em><b>ROUNDABOUT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROUNDABOUT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROUNDABOUT_VALUE = 25;

	/**
	 * The '<em><b>ROADSEGMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROADSEGMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ROADSEGMENT_VALUE = 26;

	/**
	 * An array of all the '<em><b>Ifc Road Part Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcRoadPartTypeEnum[] VALUES_ARRAY = new IfcRoadPartTypeEnum[] { NULL, BUS_STOP, SHOULDER,
			CENTRALISLAND, SIDEWALK, PARKINGBAY, USERDEFINED, ROADSIDE, ROADWAYPLATEAU, RAILWAYCROSSING, CENTRALRESERVE,
			NOTDEFINED, REFUGEISLAND, TRAFFICLANE, HARDSHOULDER, LAYBY, TOLLPLAZA, ROADSIDEPART, CARRIAGEWAY,
			SOFTSHOULDER, BICYCLECROSSING, PEDESTRIAN_CROSSING, PASSINGBAY, TRAFFICISLAND, INTERSECTION, ROUNDABOUT,
			ROADSEGMENT, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Road Part Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcRoadPartTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Road Part Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcRoadPartTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcRoadPartTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Road Part Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcRoadPartTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcRoadPartTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Road Part Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcRoadPartTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case BUS_STOP_VALUE:
			return BUS_STOP;
		case SHOULDER_VALUE:
			return SHOULDER;
		case CENTRALISLAND_VALUE:
			return CENTRALISLAND;
		case SIDEWALK_VALUE:
			return SIDEWALK;
		case PARKINGBAY_VALUE:
			return PARKINGBAY;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case ROADSIDE_VALUE:
			return ROADSIDE;
		case ROADWAYPLATEAU_VALUE:
			return ROADWAYPLATEAU;
		case RAILWAYCROSSING_VALUE:
			return RAILWAYCROSSING;
		case CENTRALRESERVE_VALUE:
			return CENTRALRESERVE;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case REFUGEISLAND_VALUE:
			return REFUGEISLAND;
		case TRAFFICLANE_VALUE:
			return TRAFFICLANE;
		case HARDSHOULDER_VALUE:
			return HARDSHOULDER;
		case LAYBY_VALUE:
			return LAYBY;
		case TOLLPLAZA_VALUE:
			return TOLLPLAZA;
		case ROADSIDEPART_VALUE:
			return ROADSIDEPART;
		case CARRIAGEWAY_VALUE:
			return CARRIAGEWAY;
		case SOFTSHOULDER_VALUE:
			return SOFTSHOULDER;
		case BICYCLECROSSING_VALUE:
			return BICYCLECROSSING;
		case PEDESTRIAN_CROSSING_VALUE:
			return PEDESTRIAN_CROSSING;
		case PASSINGBAY_VALUE:
			return PASSINGBAY;
		case TRAFFICISLAND_VALUE:
			return TRAFFICISLAND;
		case INTERSECTION_VALUE:
			return INTERSECTION;
		case ROUNDABOUT_VALUE:
			return ROUNDABOUT;
		case ROADSEGMENT_VALUE:
			return ROADSEGMENT;
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
	private IfcRoadPartTypeEnum(int value, String name, String literal) {
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

} //IfcRoadPartTypeEnum
