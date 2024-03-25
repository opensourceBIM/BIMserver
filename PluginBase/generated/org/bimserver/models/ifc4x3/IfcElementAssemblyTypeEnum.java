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
 * A representation of the literals of the enumeration '<em><b>Ifc Element Assembly Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc4x3.Ifc4x3Package#getIfcElementAssemblyTypeEnum()
 * @model
 * @generated
 */
public enum IfcElementAssemblyTypeEnum implements Enumerator {
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
	 * The '<em><b>ENTRANCEWORKS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENTRANCEWORKS_VALUE
	 * @generated
	 * @ordered
	 */
	ENTRANCEWORKS(1, "ENTRANCEWORKS", "ENTRANCEWORKS"),

	/**
	 * The '<em><b>PIER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PIER_VALUE
	 * @generated
	 * @ordered
	 */
	PIER(2, "PIER", "PIER"),

	/**
	 * The '<em><b>DILATATIONPANEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DILATATIONPANEL_VALUE
	 * @generated
	 * @ordered
	 */
	DILATATIONPANEL(3, "DILATATIONPANEL", "DILATATIONPANEL"),

	/**
	 * The '<em><b>ARCH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARCH_VALUE
	 * @generated
	 * @ordered
	 */
	ARCH(4, "ARCH", "ARCH"),

	/**
	 * The '<em><b>ABUTMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ABUTMENT_VALUE
	 * @generated
	 * @ordered
	 */
	ABUTMENT(5, "ABUTMENT", "ABUTMENT"),

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
	 * The '<em><b>ACCESSORY ASSEMBLY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACCESSORY_ASSEMBLY_VALUE
	 * @generated
	 * @ordered
	 */
	ACCESSORY_ASSEMBLY(7, "ACCESSORY_ASSEMBLY", "ACCESSORY_ASSEMBLY"),

	/**
	 * The '<em><b>TRAFFIC CALMING DEVICE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRAFFIC_CALMING_DEVICE_VALUE
	 * @generated
	 * @ordered
	 */
	TRAFFIC_CALMING_DEVICE(8, "TRAFFIC_CALMING_DEVICE", "TRAFFIC_CALMING_DEVICE"),

	/**
	 * The '<em><b>SUMPBUSTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUMPBUSTER_VALUE
	 * @generated
	 * @ordered
	 */
	SUMPBUSTER(9, "SUMPBUSTER", "SUMPBUSTER"),

	/**
	 * The '<em><b>BRACED FRAME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BRACED_FRAME_VALUE
	 * @generated
	 * @ordered
	 */
	BRACED_FRAME(10, "BRACED_FRAME", "BRACED_FRAME"),

	/**
	 * The '<em><b>REINFORCEMENT UNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REINFORCEMENT_UNIT_VALUE
	 * @generated
	 * @ordered
	 */
	REINFORCEMENT_UNIT(11, "REINFORCEMENT_UNIT", "REINFORCEMENT_UNIT"),

	/**
	 * The '<em><b>GIRDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GIRDER_VALUE
	 * @generated
	 * @ordered
	 */
	GIRDER(12, "GIRDER", "GIRDER"),

	/**
	 * The '<em><b>PYLON</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PYLON_VALUE
	 * @generated
	 * @ordered
	 */
	PYLON(13, "PYLON", "PYLON"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOTDEFINED(14, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>SLAB FIELD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SLAB_FIELD_VALUE
	 * @generated
	 * @ordered
	 */
	SLAB_FIELD(15, "SLAB_FIELD", "SLAB_FIELD"),

	/**
	 * The '<em><b>MAST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAST_VALUE
	 * @generated
	 * @ordered
	 */
	MAST(16, "MAST", "MAST"),

	/**
	 * The '<em><b>TURNOUTPANEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TURNOUTPANEL_VALUE
	 * @generated
	 * @ordered
	 */
	TURNOUTPANEL(17, "TURNOUTPANEL", "TURNOUTPANEL"),

	/**
	 * The '<em><b>BEAM GRID</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BEAM_GRID_VALUE
	 * @generated
	 * @ordered
	 */
	BEAM_GRID(18, "BEAM_GRID", "BEAM_GRID"),

	/**
	 * The '<em><b>SUPPORTINGASSEMBLY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUPPORTINGASSEMBLY_VALUE
	 * @generated
	 * @ordered
	 */
	SUPPORTINGASSEMBLY(19, "SUPPORTINGASSEMBLY", "SUPPORTINGASSEMBLY"),

	/**
	 * The '<em><b>SIGNALASSEMBLY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIGNALASSEMBLY_VALUE
	 * @generated
	 * @ordered
	 */
	SIGNALASSEMBLY(20, "SIGNALASSEMBLY", "SIGNALASSEMBLY"),

	/**
	 * The '<em><b>CROSS BRACING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CROSS_BRACING_VALUE
	 * @generated
	 * @ordered
	 */
	CROSS_BRACING(21, "CROSS_BRACING", "CROSS_BRACING"),

	/**
	 * The '<em><b>GRID</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GRID_VALUE
	 * @generated
	 * @ordered
	 */
	GRID(22, "GRID", "GRID"),

	/**
	 * The '<em><b>RAIL MECHANICAL EQUIPMENT ASSEMBLY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAIL_MECHANICAL_EQUIPMENT_ASSEMBLY_VALUE
	 * @generated
	 * @ordered
	 */
	RAIL_MECHANICAL_EQUIPMENT_ASSEMBLY(23, "RAIL_MECHANICAL_EQUIPMENT_ASSEMBLY", "RAIL_MECHANICAL_EQUIPMENT_ASSEMBLY"),

	/**
	 * The '<em><b>TRACTION SWITCHING ASSEMBLY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRACTION_SWITCHING_ASSEMBLY_VALUE
	 * @generated
	 * @ordered
	 */
	TRACTION_SWITCHING_ASSEMBLY(24, "TRACTION_SWITCHING_ASSEMBLY", "TRACTION_SWITCHING_ASSEMBLY"),

	/**
	 * The '<em><b>TRACKPANEL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRACKPANEL_VALUE
	 * @generated
	 * @ordered
	 */
	TRACKPANEL(25, "TRACKPANEL", "TRACKPANEL"),

	/**
	 * The '<em><b>TRUSS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRUSS_VALUE
	 * @generated
	 * @ordered
	 */
	TRUSS(26, "TRUSS", "TRUSS"),

	/**
	 * The '<em><b>DECK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECK_VALUE
	 * @generated
	 * @ordered
	 */
	DECK(27, "DECK", "DECK"),

	/**
	 * The '<em><b>SHELTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHELTER_VALUE
	 * @generated
	 * @ordered
	 */
	SHELTER(28, "SHELTER", "SHELTER"),

	/**
	 * The '<em><b>SUSPENSIONASSEMBLY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUSPENSIONASSEMBLY_VALUE
	 * @generated
	 * @ordered
	 */
	SUSPENSIONASSEMBLY(29, "SUSPENSIONASSEMBLY", "SUSPENSIONASSEMBLY"),

	/**
	 * The '<em><b>RIGID FRAME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RIGID_FRAME_VALUE
	 * @generated
	 * @ordered
	 */
	RIGID_FRAME(30, "RIGID_FRAME", "RIGID_FRAME");

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
	 * The '<em><b>ENTRANCEWORKS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENTRANCEWORKS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ENTRANCEWORKS_VALUE = 1;

	/**
	 * The '<em><b>PIER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PIER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PIER_VALUE = 2;

	/**
	 * The '<em><b>DILATATIONPANEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DILATATIONPANEL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DILATATIONPANEL_VALUE = 3;

	/**
	 * The '<em><b>ARCH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARCH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ARCH_VALUE = 4;

	/**
	 * The '<em><b>ABUTMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ABUTMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ABUTMENT_VALUE = 5;

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
	 * The '<em><b>ACCESSORY ASSEMBLY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACCESSORY_ASSEMBLY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ACCESSORY_ASSEMBLY_VALUE = 7;

	/**
	 * The '<em><b>TRAFFIC CALMING DEVICE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRAFFIC_CALMING_DEVICE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRAFFIC_CALMING_DEVICE_VALUE = 8;

	/**
	 * The '<em><b>SUMPBUSTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUMPBUSTER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUMPBUSTER_VALUE = 9;

	/**
	 * The '<em><b>BRACED FRAME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BRACED_FRAME
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BRACED_FRAME_VALUE = 10;

	/**
	 * The '<em><b>REINFORCEMENT UNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REINFORCEMENT_UNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REINFORCEMENT_UNIT_VALUE = 11;

	/**
	 * The '<em><b>GIRDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GIRDER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GIRDER_VALUE = 12;

	/**
	 * The '<em><b>PYLON</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PYLON
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PYLON_VALUE = 13;

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTDEFINED_VALUE = 14;

	/**
	 * The '<em><b>SLAB FIELD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SLAB_FIELD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SLAB_FIELD_VALUE = 15;

	/**
	 * The '<em><b>MAST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MAST_VALUE = 16;

	/**
	 * The '<em><b>TURNOUTPANEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TURNOUTPANEL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TURNOUTPANEL_VALUE = 17;

	/**
	 * The '<em><b>BEAM GRID</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BEAM_GRID
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BEAM_GRID_VALUE = 18;

	/**
	 * The '<em><b>SUPPORTINGASSEMBLY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUPPORTINGASSEMBLY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUPPORTINGASSEMBLY_VALUE = 19;

	/**
	 * The '<em><b>SIGNALASSEMBLY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIGNALASSEMBLY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SIGNALASSEMBLY_VALUE = 20;

	/**
	 * The '<em><b>CROSS BRACING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CROSS_BRACING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CROSS_BRACING_VALUE = 21;

	/**
	 * The '<em><b>GRID</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GRID
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GRID_VALUE = 22;

	/**
	 * The '<em><b>RAIL MECHANICAL EQUIPMENT ASSEMBLY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAIL_MECHANICAL_EQUIPMENT_ASSEMBLY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RAIL_MECHANICAL_EQUIPMENT_ASSEMBLY_VALUE = 23;

	/**
	 * The '<em><b>TRACTION SWITCHING ASSEMBLY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRACTION_SWITCHING_ASSEMBLY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRACTION_SWITCHING_ASSEMBLY_VALUE = 24;

	/**
	 * The '<em><b>TRACKPANEL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRACKPANEL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRACKPANEL_VALUE = 25;

	/**
	 * The '<em><b>TRUSS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRUSS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRUSS_VALUE = 26;

	/**
	 * The '<em><b>DECK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DECK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DECK_VALUE = 27;

	/**
	 * The '<em><b>SHELTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHELTER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SHELTER_VALUE = 28;

	/**
	 * The '<em><b>SUSPENSIONASSEMBLY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUSPENSIONASSEMBLY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SUSPENSIONASSEMBLY_VALUE = 29;

	/**
	 * The '<em><b>RIGID FRAME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RIGID_FRAME
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RIGID_FRAME_VALUE = 30;

	/**
	 * An array of all the '<em><b>Ifc Element Assembly Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcElementAssemblyTypeEnum[] VALUES_ARRAY = new IfcElementAssemblyTypeEnum[] { NULL,
			ENTRANCEWORKS, PIER, DILATATIONPANEL, ARCH, ABUTMENT, USERDEFINED, ACCESSORY_ASSEMBLY,
			TRAFFIC_CALMING_DEVICE, SUMPBUSTER, BRACED_FRAME, REINFORCEMENT_UNIT, GIRDER, PYLON, NOTDEFINED, SLAB_FIELD,
			MAST, TURNOUTPANEL, BEAM_GRID, SUPPORTINGASSEMBLY, SIGNALASSEMBLY, CROSS_BRACING, GRID,
			RAIL_MECHANICAL_EQUIPMENT_ASSEMBLY, TRACTION_SWITCHING_ASSEMBLY, TRACKPANEL, TRUSS, DECK, SHELTER,
			SUSPENSIONASSEMBLY, RIGID_FRAME, };

	/**
	 * A public read-only list of all the '<em><b>Ifc Element Assembly Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcElementAssemblyTypeEnum> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Element Assembly Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcElementAssemblyTypeEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcElementAssemblyTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Element Assembly Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcElementAssemblyTypeEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcElementAssemblyTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Element Assembly Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcElementAssemblyTypeEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case ENTRANCEWORKS_VALUE:
			return ENTRANCEWORKS;
		case PIER_VALUE:
			return PIER;
		case DILATATIONPANEL_VALUE:
			return DILATATIONPANEL;
		case ARCH_VALUE:
			return ARCH;
		case ABUTMENT_VALUE:
			return ABUTMENT;
		case USERDEFINED_VALUE:
			return USERDEFINED;
		case ACCESSORY_ASSEMBLY_VALUE:
			return ACCESSORY_ASSEMBLY;
		case TRAFFIC_CALMING_DEVICE_VALUE:
			return TRAFFIC_CALMING_DEVICE;
		case SUMPBUSTER_VALUE:
			return SUMPBUSTER;
		case BRACED_FRAME_VALUE:
			return BRACED_FRAME;
		case REINFORCEMENT_UNIT_VALUE:
			return REINFORCEMENT_UNIT;
		case GIRDER_VALUE:
			return GIRDER;
		case PYLON_VALUE:
			return PYLON;
		case NOTDEFINED_VALUE:
			return NOTDEFINED;
		case SLAB_FIELD_VALUE:
			return SLAB_FIELD;
		case MAST_VALUE:
			return MAST;
		case TURNOUTPANEL_VALUE:
			return TURNOUTPANEL;
		case BEAM_GRID_VALUE:
			return BEAM_GRID;
		case SUPPORTINGASSEMBLY_VALUE:
			return SUPPORTINGASSEMBLY;
		case SIGNALASSEMBLY_VALUE:
			return SIGNALASSEMBLY;
		case CROSS_BRACING_VALUE:
			return CROSS_BRACING;
		case GRID_VALUE:
			return GRID;
		case RAIL_MECHANICAL_EQUIPMENT_ASSEMBLY_VALUE:
			return RAIL_MECHANICAL_EQUIPMENT_ASSEMBLY;
		case TRACTION_SWITCHING_ASSEMBLY_VALUE:
			return TRACTION_SWITCHING_ASSEMBLY;
		case TRACKPANEL_VALUE:
			return TRACKPANEL;
		case TRUSS_VALUE:
			return TRUSS;
		case DECK_VALUE:
			return DECK;
		case SHELTER_VALUE:
			return SHELTER;
		case SUSPENSIONASSEMBLY_VALUE:
			return SUSPENSIONASSEMBLY;
		case RIGID_FRAME_VALUE:
			return RIGID_FRAME;
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
	private IfcElementAssemblyTypeEnum(int value, String name, String literal) {
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

} //IfcElementAssemblyTypeEnum
