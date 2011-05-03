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
 * A representation of the literals of the enumeration '<em><b>Ifc Damper Type Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDamperTypeEnum()
 * @model
 * @generated
 */
public enum IfcDamperTypeEnum implements Enumerator
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
	 * The '<em><b>BLASTDAMPER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BLASTDAMPER
	 * @generated
	 * @ordered
	 */
	BLASTDAMPER_LITERAL(1, "BLASTDAMPER", "BLASTDAMPER"),

	/**
	 * The '<em><b>FIRESMOKEDAMPER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIRESMOKEDAMPER
	 * @generated
	 * @ordered
	 */
	FIRESMOKEDAMPER_LITERAL(2, "FIRESMOKEDAMPER", "FIRESMOKEDAMPER"),

	/**
	 * The '<em><b>BALANCINGDAMPER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BALANCINGDAMPER
	 * @generated
	 * @ordered
	 */
	BALANCINGDAMPER_LITERAL(3, "BALANCINGDAMPER", "BALANCINGDAMPER"),

	/**
	 * The '<em><b>NOTDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOTDEFINED
	 * @generated
	 * @ordered
	 */
	NOTDEFINED_LITERAL(4, "NOTDEFINED", "NOTDEFINED"),

	/**
	 * The '<em><b>FIREDAMPER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIREDAMPER
	 * @generated
	 * @ordered
	 */
	FIREDAMPER_LITERAL(5, "FIREDAMPER", "FIREDAMPER"),

	/**
	 * The '<em><b>SMOKEDAMPER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SMOKEDAMPER
	 * @generated
	 * @ordered
	 */
	SMOKEDAMPER_LITERAL(6, "SMOKEDAMPER", "SMOKEDAMPER"),

	/**
	 * The '<em><b>RELIEFDAMPER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RELIEFDAMPER
	 * @generated
	 * @ordered
	 */
	RELIEFDAMPER_LITERAL(7, "RELIEFDAMPER", "RELIEFDAMPER"),

	/**
	 * The '<em><b>GRAVITYRELIEFDAMPER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GRAVITYRELIEFDAMPER
	 * @generated
	 * @ordered
	 */
	GRAVITYRELIEFDAMPER_LITERAL(8, "GRAVITYRELIEFDAMPER", "GRAVITYRELIEFDAMPER"),

	/**
	 * The '<em><b>BACKDRAFTDAMPER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BACKDRAFTDAMPER
	 * @generated
	 * @ordered
	 */
	BACKDRAFTDAMPER_LITERAL(9, "BACKDRAFTDAMPER", "BACKDRAFTDAMPER"),

	/**
	 * The '<em><b>GRAVITYDAMPER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GRAVITYDAMPER
	 * @generated
	 * @ordered
	 */
	GRAVITYDAMPER_LITERAL(10, "GRAVITYDAMPER", "GRAVITYDAMPER"),

	/**
	 * The '<em><b>FUMEHOODEXHAUST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FUMEHOODEXHAUST
	 * @generated
	 * @ordered
	 */
	FUMEHOODEXHAUST_LITERAL(11, "FUMEHOODEXHAUST", "FUMEHOODEXHAUST"),

	/**
	 * The '<em><b>USERDEFINED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USERDEFINED
	 * @generated
	 * @ordered
	 */
	USERDEFINED_LITERAL(12, "USERDEFINED", "USERDEFINED"),

	/**
	 * The '<em><b>CONTROLDAMPER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTROLDAMPER
	 * @generated
	 * @ordered
	 */
	CONTROLDAMPER_LITERAL(13, "CONTROLDAMPER", "CONTROLDAMPER");

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
	 * The '<em><b>BLASTDAMPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BLASTDAMPER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BLASTDAMPER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BLASTDAMPER = 1;

	/**
	 * The '<em><b>FIRESMOKEDAMPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FIRESMOKEDAMPER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIRESMOKEDAMPER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FIRESMOKEDAMPER = 2;

	/**
	 * The '<em><b>BALANCINGDAMPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BALANCINGDAMPER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BALANCINGDAMPER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BALANCINGDAMPER = 3;

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
	public static final int NOTDEFINED = 4;

	/**
	 * The '<em><b>FIREDAMPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FIREDAMPER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIREDAMPER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FIREDAMPER = 5;

	/**
	 * The '<em><b>SMOKEDAMPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SMOKEDAMPER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SMOKEDAMPER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SMOKEDAMPER = 6;

	/**
	 * The '<em><b>RELIEFDAMPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RELIEFDAMPER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RELIEFDAMPER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RELIEFDAMPER = 7;

	/**
	 * The '<em><b>GRAVITYRELIEFDAMPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GRAVITYRELIEFDAMPER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GRAVITYRELIEFDAMPER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GRAVITYRELIEFDAMPER = 8;

	/**
	 * The '<em><b>BACKDRAFTDAMPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BACKDRAFTDAMPER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BACKDRAFTDAMPER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BACKDRAFTDAMPER = 9;

	/**
	 * The '<em><b>GRAVITYDAMPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GRAVITYDAMPER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GRAVITYDAMPER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GRAVITYDAMPER = 10;

	/**
	 * The '<em><b>FUMEHOODEXHAUST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FUMEHOODEXHAUST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FUMEHOODEXHAUST_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FUMEHOODEXHAUST = 11;

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
	public static final int USERDEFINED = 12;

	/**
	 * The '<em><b>CONTROLDAMPER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CONTROLDAMPER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTROLDAMPER_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CONTROLDAMPER = 13;

	/**
	 * An array of all the '<em><b>Ifc Damper Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcDamperTypeEnum[] VALUES_ARRAY =
		new IfcDamperTypeEnum[]
		{
			NULL_LITERAL,
			BLASTDAMPER_LITERAL,
			FIRESMOKEDAMPER_LITERAL,
			BALANCINGDAMPER_LITERAL,
			NOTDEFINED_LITERAL,
			FIREDAMPER_LITERAL,
			SMOKEDAMPER_LITERAL,
			RELIEFDAMPER_LITERAL,
			GRAVITYRELIEFDAMPER_LITERAL,
			BACKDRAFTDAMPER_LITERAL,
			GRAVITYDAMPER_LITERAL,
			FUMEHOODEXHAUST_LITERAL,
			USERDEFINED_LITERAL,
			CONTROLDAMPER_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Damper Type Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcDamperTypeEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Damper Type Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcDamperTypeEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcDamperTypeEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Damper Type Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcDamperTypeEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcDamperTypeEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Damper Type Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcDamperTypeEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case BLASTDAMPER: return BLASTDAMPER_LITERAL;
			case FIRESMOKEDAMPER: return FIRESMOKEDAMPER_LITERAL;
			case BALANCINGDAMPER: return BALANCINGDAMPER_LITERAL;
			case NOTDEFINED: return NOTDEFINED_LITERAL;
			case FIREDAMPER: return FIREDAMPER_LITERAL;
			case SMOKEDAMPER: return SMOKEDAMPER_LITERAL;
			case RELIEFDAMPER: return RELIEFDAMPER_LITERAL;
			case GRAVITYRELIEFDAMPER: return GRAVITYRELIEFDAMPER_LITERAL;
			case BACKDRAFTDAMPER: return BACKDRAFTDAMPER_LITERAL;
			case GRAVITYDAMPER: return GRAVITYDAMPER_LITERAL;
			case FUMEHOODEXHAUST: return FUMEHOODEXHAUST_LITERAL;
			case USERDEFINED: return USERDEFINED_LITERAL;
			case CONTROLDAMPER: return CONTROLDAMPER_LITERAL;
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
	private IfcDamperTypeEnum(int value, String name, String literal)
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
	
} //IfcDamperTypeEnum
