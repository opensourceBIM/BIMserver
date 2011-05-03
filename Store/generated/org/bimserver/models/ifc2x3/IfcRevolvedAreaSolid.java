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

import org.bimserver.models.ifc2x3.IfcAxis1Placement;
import org.bimserver.models.ifc2x3.IfcSweptAreaSolid;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Revolved Area Solid</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRevolvedAreaSolid#getAxis <em>Axis</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRevolvedAreaSolid#getAngle <em>Angle</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcRevolvedAreaSolid#getAngleAsString <em>Angle As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRevolvedAreaSolid()
 * @model
 * @generated
 */
public interface IfcRevolvedAreaSolid extends IfcSweptAreaSolid
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * Returns the value of the '<em><b>Axis</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Axis</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Axis</em>' reference.
	 * @see #setAxis(IfcAxis1Placement)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRevolvedAreaSolid_Axis()
	 * @model
	 * @generated
	 */
	IfcAxis1Placement getAxis();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRevolvedAreaSolid#getAxis <em>Axis</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Axis</em>' reference.
	 * @see #getAxis()
	 * @generated
	 */
	void setAxis(IfcAxis1Placement value);

	/**
	 * Returns the value of the '<em><b>Angle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Angle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Angle</em>' attribute.
	 * @see #setAngle(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRevolvedAreaSolid_Angle()
	 * @model
	 * @generated
	 */
	float getAngle();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRevolvedAreaSolid#getAngle <em>Angle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Angle</em>' attribute.
	 * @see #getAngle()
	 * @generated
	 */
	void setAngle(float value);

	/**
	 * Returns the value of the '<em><b>Angle As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Angle As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Angle As String</em>' attribute.
	 * @see #setAngleAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcRevolvedAreaSolid_AngleAsString()
	 * @model
	 * @generated
	 */
	String getAngleAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcRevolvedAreaSolid#getAngleAsString <em>Angle As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Angle As String</em>' attribute.
	 * @see #getAngleAsString()
	 * @generated
	 */
	void setAngleAsString(String value);

} // IfcRevolvedAreaSolid
