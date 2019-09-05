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

public interface IfcSweptDiskSolid extends IfcSolidModel {
	/**
	 * Returns the value of the '<em><b>Directrix</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Directrix</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Directrix</em>' reference.
	 * @see #setDirectrix(IfcCurve)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSweptDiskSolid_Directrix()
	 * @model
	 * @generated
	 */
	IfcCurve getDirectrix();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolid#getDirectrix <em>Directrix</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Directrix</em>' reference.
	 * @see #getDirectrix()
	 * @generated
	 */
	void setDirectrix(IfcCurve value);

	/**
	 * Returns the value of the '<em><b>Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Radius</em>' attribute.
	 * @see #setRadius(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSweptDiskSolid_Radius()
	 * @model
	 * @generated
	 */
	double getRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolid#getRadius <em>Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Radius</em>' attribute.
	 * @see #getRadius()
	 * @generated
	 */
	void setRadius(double value);

	/**
	 * Returns the value of the '<em><b>Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Radius As String</em>' attribute.
	 * @see #setRadiusAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSweptDiskSolid_RadiusAsString()
	 * @model annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolid#getRadiusAsString <em>Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Radius As String</em>' attribute.
	 * @see #getRadiusAsString()
	 * @generated
	 */
	void setRadiusAsString(String value);

	/**
	 * Returns the value of the '<em><b>Inner Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Radius</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Radius</em>' attribute.
	 * @see #isSetInnerRadius()
	 * @see #unsetInnerRadius()
	 * @see #setInnerRadius(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSweptDiskSolid_InnerRadius()
	 * @model unsettable="true"
	 * @generated
	 */
	double getInnerRadius();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolid#getInnerRadius <em>Inner Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inner Radius</em>' attribute.
	 * @see #isSetInnerRadius()
	 * @see #unsetInnerRadius()
	 * @see #getInnerRadius()
	 * @generated
	 */
	void setInnerRadius(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolid#getInnerRadius <em>Inner Radius</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInnerRadius()
	 * @see #getInnerRadius()
	 * @see #setInnerRadius(double)
	 * @generated
	 */
	void unsetInnerRadius();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolid#getInnerRadius <em>Inner Radius</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Inner Radius</em>' attribute is set.
	 * @see #unsetInnerRadius()
	 * @see #getInnerRadius()
	 * @see #setInnerRadius(double)
	 * @generated
	 */
	boolean isSetInnerRadius();

	/**
	 * Returns the value of the '<em><b>Inner Radius As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inner Radius As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inner Radius As String</em>' attribute.
	 * @see #isSetInnerRadiusAsString()
	 * @see #unsetInnerRadiusAsString()
	 * @see #setInnerRadiusAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSweptDiskSolid_InnerRadiusAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getInnerRadiusAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolid#getInnerRadiusAsString <em>Inner Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inner Radius As String</em>' attribute.
	 * @see #isSetInnerRadiusAsString()
	 * @see #unsetInnerRadiusAsString()
	 * @see #getInnerRadiusAsString()
	 * @generated
	 */
	void setInnerRadiusAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolid#getInnerRadiusAsString <em>Inner Radius As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInnerRadiusAsString()
	 * @see #getInnerRadiusAsString()
	 * @see #setInnerRadiusAsString(String)
	 * @generated
	 */
	void unsetInnerRadiusAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolid#getInnerRadiusAsString <em>Inner Radius As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Inner Radius As String</em>' attribute is set.
	 * @see #unsetInnerRadiusAsString()
	 * @see #getInnerRadiusAsString()
	 * @see #setInnerRadiusAsString(String)
	 * @generated
	 */
	boolean isSetInnerRadiusAsString();

	/**
	 * Returns the value of the '<em><b>Start Param</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Param</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Param</em>' attribute.
	 * @see #isSetStartParam()
	 * @see #unsetStartParam()
	 * @see #setStartParam(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSweptDiskSolid_StartParam()
	 * @model unsettable="true"
	 * @generated
	 */
	double getStartParam();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolid#getStartParam <em>Start Param</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Param</em>' attribute.
	 * @see #isSetStartParam()
	 * @see #unsetStartParam()
	 * @see #getStartParam()
	 * @generated
	 */
	void setStartParam(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolid#getStartParam <em>Start Param</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStartParam()
	 * @see #getStartParam()
	 * @see #setStartParam(double)
	 * @generated
	 */
	void unsetStartParam();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolid#getStartParam <em>Start Param</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Start Param</em>' attribute is set.
	 * @see #unsetStartParam()
	 * @see #getStartParam()
	 * @see #setStartParam(double)
	 * @generated
	 */
	boolean isSetStartParam();

	/**
	 * Returns the value of the '<em><b>Start Param As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Param As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Param As String</em>' attribute.
	 * @see #isSetStartParamAsString()
	 * @see #unsetStartParamAsString()
	 * @see #setStartParamAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSweptDiskSolid_StartParamAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getStartParamAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolid#getStartParamAsString <em>Start Param As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Param As String</em>' attribute.
	 * @see #isSetStartParamAsString()
	 * @see #unsetStartParamAsString()
	 * @see #getStartParamAsString()
	 * @generated
	 */
	void setStartParamAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolid#getStartParamAsString <em>Start Param As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetStartParamAsString()
	 * @see #getStartParamAsString()
	 * @see #setStartParamAsString(String)
	 * @generated
	 */
	void unsetStartParamAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolid#getStartParamAsString <em>Start Param As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Start Param As String</em>' attribute is set.
	 * @see #unsetStartParamAsString()
	 * @see #getStartParamAsString()
	 * @see #setStartParamAsString(String)
	 * @generated
	 */
	boolean isSetStartParamAsString();

	/**
	 * Returns the value of the '<em><b>End Param</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Param</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Param</em>' attribute.
	 * @see #isSetEndParam()
	 * @see #unsetEndParam()
	 * @see #setEndParam(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSweptDiskSolid_EndParam()
	 * @model unsettable="true"
	 * @generated
	 */
	double getEndParam();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolid#getEndParam <em>End Param</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Param</em>' attribute.
	 * @see #isSetEndParam()
	 * @see #unsetEndParam()
	 * @see #getEndParam()
	 * @generated
	 */
	void setEndParam(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolid#getEndParam <em>End Param</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEndParam()
	 * @see #getEndParam()
	 * @see #setEndParam(double)
	 * @generated
	 */
	void unsetEndParam();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolid#getEndParam <em>End Param</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>End Param</em>' attribute is set.
	 * @see #unsetEndParam()
	 * @see #getEndParam()
	 * @see #setEndParam(double)
	 * @generated
	 */
	boolean isSetEndParam();

	/**
	 * Returns the value of the '<em><b>End Param As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Param As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Param As String</em>' attribute.
	 * @see #isSetEndParamAsString()
	 * @see #unsetEndParamAsString()
	 * @see #setEndParamAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSweptDiskSolid_EndParamAsString()
	 * @model unsettable="true"
	 *        annotation="asstring"
	 *        annotation="hidden"
	 * @generated
	 */
	String getEndParamAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolid#getEndParamAsString <em>End Param As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Param As String</em>' attribute.
	 * @see #isSetEndParamAsString()
	 * @see #unsetEndParamAsString()
	 * @see #getEndParamAsString()
	 * @generated
	 */
	void setEndParamAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolid#getEndParamAsString <em>End Param As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEndParamAsString()
	 * @see #getEndParamAsString()
	 * @see #setEndParamAsString(String)
	 * @generated
	 */
	void unsetEndParamAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSweptDiskSolid#getEndParamAsString <em>End Param As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>End Param As String</em>' attribute is set.
	 * @see #unsetEndParamAsString()
	 * @see #getEndParamAsString()
	 * @see #setEndParamAsString(String)
	 * @generated
	 */
	boolean isSetEndParamAsString();

} // IfcSweptDiskSolid
