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
package org.bimserver.models.ifc2x3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Ifc Electric Appliance Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcElectricApplianceTypeEnum()
 * @model
 * @generated
 */
public enum IfcElectricApplianceTypeEnum implements Enumerator
{
	/**
	 * The '<em><b>NULL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NULL
	 * @generated
	 * @ordered
	 */
	NULL_LITERAL(0, "NULL", "NULL"),

	/**
	 * The '<em><b>FRIDGE FREEZER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRIDGE_FREEZER
	 * @generated
	 * @ordered
	 */
	FRIDGE_FREEZER_LITERAL(1, "FRIDGE_FREEZER", "FRIDGE_FREEZER"),

	/**
	 * The '<em><b>REFRIGERATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REFRIGERATOR
	 * @generated
	 * @ordered
	 */
	REFRIGERATOR_LITERAL(2, "REFRIGERATOR", "REFRIGERATOR"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @generated
	 * @ordered
	 */
	NOTDEFINED_LITERAL(3, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>WASHINGMACHINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WASHINGMACHINE
	 * @generated
	 * @ordered
	 */
	WASHINGMACHINE_LITERAL(4, "WASHINGMACHINE", "WASHINGMACHINE"),

	/**
	 * The '<em><b>SCANNER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCANNER
	 * @generated
	 * @ordered
	 */
	SCANNER_LITERAL(5, "SCANNER", "SCANNER"),

	/**
	 * The '<em><b>FREEZER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FREEZER
	 * @generated
	 * @ordered
	 */
	FREEZER_LITERAL(6, "FREEZER", "FREEZER"),

	/**
	 * The '<em><b>COMPUTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPUTER
	 * @generated
	 * @ordered
	 */
	COMPUTER_LITERAL(7, "COMPUTER", "COMPUTER"),

	/**
	 * The '<em><b>PHOTOCOPIER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PHOTOCOPIER
	 * @generated
	 * @ordered
	 */
	PHOTOCOPIER_LITERAL(8, "PHOTOCOPIER", "PHOTOCOPIER"),

	/**
	 * The '<em><b>INDIRECTWATERHEATER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INDIRECTWATERHEATER
	 * @generated
	 * @ordered
	 */
	INDIRECTWATERHEATER_LITERAL(9, "INDIRECTWATERHEATER", "INDIRECTWATERHEATER"),

	/**
	 * The '<em><b>FACSIMILE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FACSIMILE
	 * @generated
	 * @ordered
	 */
	FACSIMILE_LITERAL(10, "FACSIMILE", "FACSIMILE"),

	/**
	 * The '<em><b>VENDINGMACHINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VENDINGMACHINE
	 * @generated
	 * @ordered
	 */
	VENDINGMACHINE_LITERAL(11, "VENDINGMACHINE", "VENDINGMACHINE"),

	/**
	 * The '<em><b>DISHWASHER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISHWASHER
	 * @generated
	 * @ordered
	 */
	DISHWASHER_LITERAL(12, "DISHWASHER", "DISHWASHER"),

	/**
	 * The '<em><b>HANDDRYER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HANDDRYER
	 * @generated
	 * @ordered
	 */
	HANDDRYER_LITERAL(13, "HANDDRYER", "HANDDRYER"),

	/**
	 * The '<em><b>MICROWAVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MICROWAVE
	 * @generated
	 * @ordered
	 */
	MICROWAVE_LITERAL(14, "MICROWAVE", "MICROWAVE"),

	/**
	 * The '<em><b>FREESTANDINGFAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FREESTANDINGFAN
	 * @generated
	 * @ordered
	 */
	FREESTANDINGFAN_LITERAL(15, "FREESTANDINGFAN", "FREESTANDINGFAN"),

	/**
	 * The '<em><b>PRINTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRINTER
	 * @generated
	 * @ordered
	 */
	PRINTER_LITERAL(16, "PRINTER", "PRINTER"),

	/**
	 * The '<em><b>RADIANTHEATER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RADIANTHEATER
	 * @generated
	 * @ordered
	 */
	RADIANTHEATER_LITERAL(17, "RADIANTHEATER", "RADIANTHEATER"),

	/**
	 * The '<em><b>ELECTRICHEATER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELECTRICHEATER
	 * @generated
	 * @ordered
	 */
	ELECTRICHEATER_LITERAL(18, "ELECTRICHEATER", "ELECTRICHEATER"),

	/**
	 * The '<em><b>WATERCOOLER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WATERCOOLER
	 * @generated
	 * @ordered
	 */
	WATERCOOLER_LITERAL(19, "WATERCOOLER", "WATERCOOLER"),

	/**
	 * The '<em><b>TELEPHONE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TELEPHONE
	 * @generated
	 * @ordered
	 */
	TELEPHONE_LITERAL(20, "TELEPHONE", "TELEPHONE"),

	/**
	 * The '<em><b>WATERHEATER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WATERHEATER
	 * @generated
	 * @ordered
	 */
	WATERHEATER_LITERAL(21, "WATERHEATER", "WATERHEATER"),

	/**
	 * The '<em><b>DIRECTWATERHEATER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DIRECTWATERHEATER
	 * @generated
	 * @ordered
	 */
	DIRECTWATERHEATER_LITERAL(22, "DIRECTWATERHEATER", "DIRECTWATERHEATER"),

	/**
	 * The '<em><b>TUMBLEDRYER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TUMBLEDRYER
	 * @generated
	 * @ordered
	 */
	TUMBLEDRYER_LITERAL(23, "TUMBLEDRYER", "TUMBLEDRYER"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @generated
	 * @ordered
	 */
	USERDEFINED_LITERAL(24, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>ELECTRICCOOKER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ELECTRICCOOKER
	 * @generated
	 * @ordered
	 */
	ELECTRICCOOKER_LITERAL(25, "ELECTRICCOOKER", "ELECTRICCOOKER"),

	/**
	 * The '<em><b>TV</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TV
	 * @generated
	 * @ordered
	 */
	TV_LITERAL(26, "TV", "TV");

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * The '<em><b>NULL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NULL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NULL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NULL = 0;

	/**
	 * The '<em><b>FRIDGE FREEZER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FRIDGE FREEZER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FRIDGE_FREEZER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FRIDGE_FREEZER = 1;

	/**
	 * The '<em><b>REFRIGERATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REFRIGERATOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REFRIGERATOR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REFRIGERATOR = 2;

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOTDEFINED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOTDEFINED = 3;

	/**
	 * The '<em><b>WASHINGMACHINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WASHINGMACHINE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WASHINGMACHINE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WASHINGMACHINE = 4;

	/**
	 * The '<em><b>SCANNER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SCANNER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SCANNER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SCANNER = 5;

	/**
	 * The '<em><b>FREEZER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FREEZER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FREEZER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FREEZER = 6;

	/**
	 * The '<em><b>COMPUTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMPUTER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMPUTER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COMPUTER = 7;

	/**
	 * The '<em><b>PHOTOCOPIER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PHOTOCOPIER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PHOTOCOPIER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PHOTOCOPIER = 8;

	/**
	 * The '<em><b>INDIRECTWATERHEATER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INDIRECTWATERHEATER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INDIRECTWATERHEATER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INDIRECTWATERHEATER = 9;

	/**
	 * The '<em><b>FACSIMILE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FACSIMILE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FACSIMILE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FACSIMILE = 10;

	/**
	 * The '<em><b>VENDINGMACHINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VENDINGMACHINE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VENDINGMACHINE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VENDINGMACHINE = 11;

	/**
	 * The '<em><b>DISHWASHER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DISHWASHER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DISHWASHER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DISHWASHER = 12;

	/**
	 * The '<em><b>HANDDRYER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HANDDRYER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HANDDRYER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HANDDRYER = 13;

	/**
	 * The '<em><b>MICROWAVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MICROWAVE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MICROWAVE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MICROWAVE = 14;

	/**
	 * The '<em><b>FREESTANDINGFAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FREESTANDINGFAN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FREESTANDINGFAN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FREESTANDINGFAN = 15;

	/**
	 * The '<em><b>PRINTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PRINTER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRINTER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PRINTER = 16;

	/**
	 * The '<em><b>RADIANTHEATER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RADIANTHEATER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RADIANTHEATER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RADIANTHEATER = 17;

	/**
	 * The '<em><b>ELECTRICHEATER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ELECTRICHEATER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ELECTRICHEATER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ELECTRICHEATER = 18;

	/**
	 * The '<em><b>WATERCOOLER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WATERCOOLER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WATERCOOLER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WATERCOOLER = 19;

	/**
	 * The '<em><b>TELEPHONE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TELEPHONE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TELEPHONE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TELEPHONE = 20;

	/**
	 * The '<em><b>WATERHEATER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WATERHEATER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WATERHEATER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WATERHEATER = 21;

	/**
	 * The '<em><b>DIRECTWATERHEATER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DIRECTWATERHEATER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DIRECTWATERHEATER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DIRECTWATERHEATER = 22;

	/**
	 * The '<em><b>TUMBLEDRYER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TUMBLEDRYER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TUMBLEDRYER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TUMBLEDRYER = 23;

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>USERDEFINED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USERDEFINED = 24;

	/**
	 * The '<em><b>ELECTRICCOOKER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ELECTRICCOOKER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ELECTRICCOOKER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ELECTRICCOOKER = 25;

	/**
	 * The '<em><b>TV</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TV</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TV_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TV = 26;

	/**
	 * An array of all the '<em><b>Ifc Electric Appliance Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcElectricApplianceTypeEnum[] VALUES_ARRAY =
		new IfcElectricApplianceTypeEnum[]
		{
			NULL_LITERAL,
			FRIDGE_FREEZER_LITERAL,
			REFRIGERATOR_LITERAL,
			NOTDEFINED_LITERAL,
			WASHINGMACHINE_LITERAL,
			SCANNER_LITERAL,
			FREEZER_LITERAL,
			COMPUTER_LITERAL,
			PHOTOCOPIER_LITERAL,
			INDIRECTWATERHEATER_LITERAL,
			FACSIMILE_LITERAL,
			VENDINGMACHINE_LITERAL,
			DISHWASHER_LITERAL,
			HANDDRYER_LITERAL,
			MICROWAVE_LITERAL,
			FREESTANDINGFAN_LITERAL,
			PRINTER_LITERAL,
			RADIANTHEATER_LITERAL,
			ELECTRICHEATER_LITERAL,
			WATERCOOLER_LITERAL,
			TELEPHONE_LITERAL,
			WATERHEATER_LITERAL,
			DIRECTWATERHEATER_LITERAL,
			TUMBLEDRYER_LITERAL,
			USERDEFINED_LITERAL,
			ELECTRICCOOKER_LITERAL,
			TV_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Electric Appliance Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcElectricApplianceTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Electric Appliance Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcElectricApplianceTypeEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcElectricApplianceTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Electric Appliance Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcElectricApplianceTypeEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcElectricApplianceTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Electric Appliance Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcElectricApplianceTypeEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case FRIDGE_FREEZER: return FRIDGE_FREEZER_LITERAL;
			case REFRIGERATOR: return REFRIGERATOR_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case WASHINGMACHINE: return WASHINGMACHINE_LITERAL;
			case SCANNER: return SCANNER_LITERAL;
			case FREEZER: return FREEZER_LITERAL;
			case COMPUTER: return COMPUTER_LITERAL;
			case PHOTOCOPIER: return PHOTOCOPIER_LITERAL;
			case INDIRECTWATERHEATER: return INDIRECTWATERHEATER_LITERAL;
			case FACSIMILE: return FACSIMILE_LITERAL;
			case VENDINGMACHINE: return VENDINGMACHINE_LITERAL;
			case DISHWASHER: return DISHWASHER_LITERAL;
			case HANDDRYER: return HANDDRYER_LITERAL;
			case MICROWAVE: return MICROWAVE_LITERAL;
			case FREESTANDINGFAN: return FREESTANDINGFAN_LITERAL;
			case PRINTER: return PRINTER_LITERAL;
			case RADIANTHEATER: return RADIANTHEATER_LITERAL;
			case ELECTRICHEATER: return ELECTRICHEATER_LITERAL;
			case WATERCOOLER: return WATERCOOLER_LITERAL;
			case TELEPHONE: return TELEPHONE_LITERAL;
			case WATERHEATER: return WATERHEATER_LITERAL;
			case DIRECTWATERHEATER: return DIRECTWATERHEATER_LITERAL;
			case TUMBLEDRYER: return TUMBLEDRYER_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case ELECTRICCOOKER: return ELECTRICCOOKER_LITERAL;
			case TV: return TV_LITERAL;
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
	private IfcElectricApplianceTypeEnum(int value, String name, String literal)
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
	
} //IfcElectricApplianceTypeEnum
