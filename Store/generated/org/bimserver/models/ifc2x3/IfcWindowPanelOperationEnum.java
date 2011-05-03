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
 * A representation of the literals of the enumeration '<em><b>Ifc Window Panel Operation Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcWindowPanelOperationEnum()
 * @model
 * @generated
 */
public enum IfcWindowPanelOperationEnum implements Enumerator
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
	 * The '<em><b>SIDEHUNGLEFTHAND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIDEHUNGLEFTHAND
	 * @generated
	 * @ordered
	 */
	SIDEHUNGLEFTHAND_LITERAL(1, "SIDEHUNGLEFTHAND", "SIDEHUNGLEFTHAND"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @generated
	 * @ordered
	 */
	NOTDEFINED_LITERAL(2, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>TOPHUNG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOPHUNG
	 * @generated
	 * @ordered
	 */
	TOPHUNG_LITERAL(3, "TOPHUNG", "TOPHUNG"),

	/**
	 * The '<em><b>TILTANDTURNRIGHTHAND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TILTANDTURNRIGHTHAND
	 * @generated
	 * @ordered
	 */
	TILTANDTURNRIGHTHAND_LITERAL(4, "TILTANDTURNRIGHTHAND", "TILTANDTURNRIGHTHAND"),

	/**
	 * The '<em><b>PIVOTHORIZONTAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PIVOTHORIZONTAL
	 * @generated
	 * @ordered
	 */
	PIVOTHORIZONTAL_LITERAL(5, "PIVOTHORIZONTAL", "PIVOTHORIZONTAL"),

	/**
	 * The '<em><b>SLIDINGHORIZONTAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SLIDINGHORIZONTAL
	 * @generated
	 * @ordered
	 */
	SLIDINGHORIZONTAL_LITERAL(6, "SLIDINGHORIZONTAL", "SLIDINGHORIZONTAL"),

	/**
	 * The '<em><b>PIVOTVERTICAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PIVOTVERTICAL
	 * @generated
	 * @ordered
	 */
	PIVOTVERTICAL_LITERAL(7, "PIVOTVERTICAL", "PIVOTVERTICAL"),

	/**
	 * The '<em><b>REMOVABLECASEMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REMOVABLECASEMENT
	 * @generated
	 * @ordered
	 */
	REMOVABLECASEMENT_LITERAL(8, "REMOVABLECASEMENT", "REMOVABLECASEMENT"),

	/**
	 * The '<em><b>OTHEROPERATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OTHEROPERATION
	 * @generated
	 * @ordered
	 */
	OTHEROPERATION_LITERAL(9, "OTHEROPERATION", "OTHEROPERATION"),

	/**
	 * The '<em><b>SIDEHUNGRIGHTHAND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIDEHUNGRIGHTHAND
	 * @generated
	 * @ordered
	 */
	SIDEHUNGRIGHTHAND_LITERAL(10, "SIDEHUNGRIGHTHAND", "SIDEHUNGRIGHTHAND"),

	/**
	 * The '<em><b>BOTTOMHUNG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOTTOMHUNG
	 * @generated
	 * @ordered
	 */
	BOTTOMHUNG_LITERAL(11, "BOTTOMHUNG", "BOTTOMHUNG"),

	/**
	 * The '<em><b>SLIDINGVERTICAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SLIDINGVERTICAL
	 * @generated
	 * @ordered
	 */
	SLIDINGVERTICAL_LITERAL(12, "SLIDINGVERTICAL", "SLIDINGVERTICAL"),

	/**
	 * The '<em><b>FIXEDCASEMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIXEDCASEMENT
	 * @generated
	 * @ordered
	 */
	FIXEDCASEMENT_LITERAL(13, "FIXEDCASEMENT", "FIXEDCASEMENT"),

	/**
	 * The '<em><b>TILTANDTURNLEFTHAND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TILTANDTURNLEFTHAND
	 * @generated
	 * @ordered
	 */
	TILTANDTURNLEFTHAND_LITERAL(14, "TILTANDTURNLEFTHAND", "TILTANDTURNLEFTHAND");

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
	 * The '<em><b>SIDEHUNGLEFTHAND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SIDEHUNGLEFTHAND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SIDEHUNGLEFTHAND_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SIDEHUNGLEFTHAND = 1;

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
	public static final int NOTDEFINED = 2;

	/**
	 * The '<em><b>TOPHUNG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TOPHUNG</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TOPHUNG_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TOPHUNG = 3;

	/**
	 * The '<em><b>TILTANDTURNRIGHTHAND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TILTANDTURNRIGHTHAND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TILTANDTURNRIGHTHAND_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TILTANDTURNRIGHTHAND = 4;

	/**
	 * The '<em><b>PIVOTHORIZONTAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PIVOTHORIZONTAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PIVOTHORIZONTAL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PIVOTHORIZONTAL = 5;

	/**
	 * The '<em><b>SLIDINGHORIZONTAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SLIDINGHORIZONTAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SLIDINGHORIZONTAL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SLIDINGHORIZONTAL = 6;

	/**
	 * The '<em><b>PIVOTVERTICAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PIVOTVERTICAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PIVOTVERTICAL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PIVOTVERTICAL = 7;

	/**
	 * The '<em><b>REMOVABLECASEMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REMOVABLECASEMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REMOVABLECASEMENT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REMOVABLECASEMENT = 8;

	/**
	 * The '<em><b>OTHEROPERATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OTHEROPERATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OTHEROPERATION_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OTHEROPERATION = 9;

	/**
	 * The '<em><b>SIDEHUNGRIGHTHAND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SIDEHUNGRIGHTHAND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SIDEHUNGRIGHTHAND_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SIDEHUNGRIGHTHAND = 10;

	/**
	 * The '<em><b>BOTTOMHUNG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BOTTOMHUNG</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOTTOMHUNG_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BOTTOMHUNG = 11;

	/**
	 * The '<em><b>SLIDINGVERTICAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SLIDINGVERTICAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SLIDINGVERTICAL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SLIDINGVERTICAL = 12;

	/**
	 * The '<em><b>FIXEDCASEMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FIXEDCASEMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIXEDCASEMENT_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FIXEDCASEMENT = 13;

	/**
	 * The '<em><b>TILTANDTURNLEFTHAND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TILTANDTURNLEFTHAND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TILTANDTURNLEFTHAND_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TILTANDTURNLEFTHAND = 14;

	/**
	 * An array of all the '<em><b>Ifc Window Panel Operation Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcWindowPanelOperationEnum[] VALUES_ARRAY =
		new IfcWindowPanelOperationEnum[]
		{
			NULL_LITERAL,
			SIDEHUNGLEFTHAND_LITERAL,
			NOTDEFINED_LITERAL,
			TOPHUNG_LITERAL,
			TILTANDTURNRIGHTHAND_LITERAL,
			PIVOTHORIZONTAL_LITERAL,
			SLIDINGHORIZONTAL_LITERAL,
			PIVOTVERTICAL_LITERAL,
			REMOVABLECASEMENT_LITERAL,
			OTHEROPERATION_LITERAL,
			SIDEHUNGRIGHTHAND_LITERAL,
			BOTTOMHUNG_LITERAL,
			SLIDINGVERTICAL_LITERAL,
			FIXEDCASEMENT_LITERAL,
			TILTANDTURNLEFTHAND_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Window Panel Operation Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcWindowPanelOperationEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Window Panel Operation Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcWindowPanelOperationEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcWindowPanelOperationEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Window Panel Operation Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcWindowPanelOperationEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcWindowPanelOperationEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Window Panel Operation Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcWindowPanelOperationEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case SIDEHUNGLEFTHAND: return SIDEHUNGLEFTHAND_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case TOPHUNG: return TOPHUNG_LITERAL;
			case TILTANDTURNRIGHTHAND: return TILTANDTURNRIGHTHAND_LITERAL;
			case PIVOTHORIZONTAL: return PIVOTHORIZONTAL_LITERAL;
			case SLIDINGHORIZONTAL: return SLIDINGHORIZONTAL_LITERAL;
			case PIVOTVERTICAL: return PIVOTVERTICAL_LITERAL;
			case REMOVABLECASEMENT: return REMOVABLECASEMENT_LITERAL;
			case OTHEROPERATION: return OTHEROPERATION_LITERAL;
			case SIDEHUNGRIGHTHAND: return SIDEHUNGRIGHTHAND_LITERAL;
			case BOTTOMHUNG: return BOTTOMHUNG_LITERAL;
			case SLIDINGVERTICAL: return SLIDINGVERTICAL_LITERAL;
			case FIXEDCASEMENT: return FIXEDCASEMENT_LITERAL;
			case TILTANDTURNLEFTHAND: return TILTANDTURNLEFTHAND_LITERAL;
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
	private IfcWindowPanelOperationEnum(int value, String name, String literal)
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
	
} //IfcWindowPanelOperationEnum
