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
package org.bimserver.models.ifc2x3tc1;

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

public interface IfcStructuralLoadLinearForce extends IfcStructuralLoadStatic {
	/**
	 * Returns the value of the '<em><b>Linear Force X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Force X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Force X</em>' attribute.
	 * @see #isSetLinearForceX()
	 * @see #unsetLinearForceX()
	 * @see #setLinearForceX(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralLoadLinearForce_LinearForceX()
	 * @model unsettable="true"
	 * @generated
	 */
	double getLinearForceX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearForceX <em>Linear Force X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Force X</em>' attribute.
	 * @see #isSetLinearForceX()
	 * @see #unsetLinearForceX()
	 * @see #getLinearForceX()
	 * @generated
	 */
	void setLinearForceX(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearForceX <em>Linear Force X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearForceX()
	 * @see #getLinearForceX()
	 * @see #setLinearForceX(double)
	 * @generated
	 */
	void unsetLinearForceX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearForceX <em>Linear Force X</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Force X</em>' attribute is set.
	 * @see #unsetLinearForceX()
	 * @see #getLinearForceX()
	 * @see #setLinearForceX(double)
	 * @generated
	 */
	boolean isSetLinearForceX();

	/**
	 * Returns the value of the '<em><b>Linear Force XAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Force XAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Force XAs String</em>' attribute.
	 * @see #isSetLinearForceXAsString()
	 * @see #unsetLinearForceXAsString()
	 * @see #setLinearForceXAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralLoadLinearForce_LinearForceXAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLinearForceXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearForceXAsString <em>Linear Force XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Force XAs String</em>' attribute.
	 * @see #isSetLinearForceXAsString()
	 * @see #unsetLinearForceXAsString()
	 * @see #getLinearForceXAsString()
	 * @generated
	 */
	void setLinearForceXAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearForceXAsString <em>Linear Force XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearForceXAsString()
	 * @see #getLinearForceXAsString()
	 * @see #setLinearForceXAsString(String)
	 * @generated
	 */
	void unsetLinearForceXAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearForceXAsString <em>Linear Force XAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Force XAs String</em>' attribute is set.
	 * @see #unsetLinearForceXAsString()
	 * @see #getLinearForceXAsString()
	 * @see #setLinearForceXAsString(String)
	 * @generated
	 */
	boolean isSetLinearForceXAsString();

	/**
	 * Returns the value of the '<em><b>Linear Force Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Force Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Force Y</em>' attribute.
	 * @see #isSetLinearForceY()
	 * @see #unsetLinearForceY()
	 * @see #setLinearForceY(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralLoadLinearForce_LinearForceY()
	 * @model unsettable="true"
	 * @generated
	 */
	double getLinearForceY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearForceY <em>Linear Force Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Force Y</em>' attribute.
	 * @see #isSetLinearForceY()
	 * @see #unsetLinearForceY()
	 * @see #getLinearForceY()
	 * @generated
	 */
	void setLinearForceY(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearForceY <em>Linear Force Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearForceY()
	 * @see #getLinearForceY()
	 * @see #setLinearForceY(double)
	 * @generated
	 */
	void unsetLinearForceY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearForceY <em>Linear Force Y</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Force Y</em>' attribute is set.
	 * @see #unsetLinearForceY()
	 * @see #getLinearForceY()
	 * @see #setLinearForceY(double)
	 * @generated
	 */
	boolean isSetLinearForceY();

	/**
	 * Returns the value of the '<em><b>Linear Force YAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Force YAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Force YAs String</em>' attribute.
	 * @see #isSetLinearForceYAsString()
	 * @see #unsetLinearForceYAsString()
	 * @see #setLinearForceYAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralLoadLinearForce_LinearForceYAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLinearForceYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearForceYAsString <em>Linear Force YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Force YAs String</em>' attribute.
	 * @see #isSetLinearForceYAsString()
	 * @see #unsetLinearForceYAsString()
	 * @see #getLinearForceYAsString()
	 * @generated
	 */
	void setLinearForceYAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearForceYAsString <em>Linear Force YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearForceYAsString()
	 * @see #getLinearForceYAsString()
	 * @see #setLinearForceYAsString(String)
	 * @generated
	 */
	void unsetLinearForceYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearForceYAsString <em>Linear Force YAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Force YAs String</em>' attribute is set.
	 * @see #unsetLinearForceYAsString()
	 * @see #getLinearForceYAsString()
	 * @see #setLinearForceYAsString(String)
	 * @generated
	 */
	boolean isSetLinearForceYAsString();

	/**
	 * Returns the value of the '<em><b>Linear Force Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Force Z</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Force Z</em>' attribute.
	 * @see #isSetLinearForceZ()
	 * @see #unsetLinearForceZ()
	 * @see #setLinearForceZ(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralLoadLinearForce_LinearForceZ()
	 * @model unsettable="true"
	 * @generated
	 */
	double getLinearForceZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearForceZ <em>Linear Force Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Force Z</em>' attribute.
	 * @see #isSetLinearForceZ()
	 * @see #unsetLinearForceZ()
	 * @see #getLinearForceZ()
	 * @generated
	 */
	void setLinearForceZ(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearForceZ <em>Linear Force Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearForceZ()
	 * @see #getLinearForceZ()
	 * @see #setLinearForceZ(double)
	 * @generated
	 */
	void unsetLinearForceZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearForceZ <em>Linear Force Z</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Force Z</em>' attribute is set.
	 * @see #unsetLinearForceZ()
	 * @see #getLinearForceZ()
	 * @see #setLinearForceZ(double)
	 * @generated
	 */
	boolean isSetLinearForceZ();

	/**
	 * Returns the value of the '<em><b>Linear Force ZAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Force ZAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Force ZAs String</em>' attribute.
	 * @see #isSetLinearForceZAsString()
	 * @see #unsetLinearForceZAsString()
	 * @see #setLinearForceZAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralLoadLinearForce_LinearForceZAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLinearForceZAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearForceZAsString <em>Linear Force ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Force ZAs String</em>' attribute.
	 * @see #isSetLinearForceZAsString()
	 * @see #unsetLinearForceZAsString()
	 * @see #getLinearForceZAsString()
	 * @generated
	 */
	void setLinearForceZAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearForceZAsString <em>Linear Force ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearForceZAsString()
	 * @see #getLinearForceZAsString()
	 * @see #setLinearForceZAsString(String)
	 * @generated
	 */
	void unsetLinearForceZAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearForceZAsString <em>Linear Force ZAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Force ZAs String</em>' attribute is set.
	 * @see #unsetLinearForceZAsString()
	 * @see #getLinearForceZAsString()
	 * @see #setLinearForceZAsString(String)
	 * @generated
	 */
	boolean isSetLinearForceZAsString();

	/**
	 * Returns the value of the '<em><b>Linear Moment X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Moment X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Moment X</em>' attribute.
	 * @see #isSetLinearMomentX()
	 * @see #unsetLinearMomentX()
	 * @see #setLinearMomentX(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralLoadLinearForce_LinearMomentX()
	 * @model unsettable="true"
	 * @generated
	 */
	double getLinearMomentX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearMomentX <em>Linear Moment X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Moment X</em>' attribute.
	 * @see #isSetLinearMomentX()
	 * @see #unsetLinearMomentX()
	 * @see #getLinearMomentX()
	 * @generated
	 */
	void setLinearMomentX(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearMomentX <em>Linear Moment X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearMomentX()
	 * @see #getLinearMomentX()
	 * @see #setLinearMomentX(double)
	 * @generated
	 */
	void unsetLinearMomentX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearMomentX <em>Linear Moment X</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Moment X</em>' attribute is set.
	 * @see #unsetLinearMomentX()
	 * @see #getLinearMomentX()
	 * @see #setLinearMomentX(double)
	 * @generated
	 */
	boolean isSetLinearMomentX();

	/**
	 * Returns the value of the '<em><b>Linear Moment XAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Moment XAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Moment XAs String</em>' attribute.
	 * @see #isSetLinearMomentXAsString()
	 * @see #unsetLinearMomentXAsString()
	 * @see #setLinearMomentXAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralLoadLinearForce_LinearMomentXAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLinearMomentXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearMomentXAsString <em>Linear Moment XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Moment XAs String</em>' attribute.
	 * @see #isSetLinearMomentXAsString()
	 * @see #unsetLinearMomentXAsString()
	 * @see #getLinearMomentXAsString()
	 * @generated
	 */
	void setLinearMomentXAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearMomentXAsString <em>Linear Moment XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearMomentXAsString()
	 * @see #getLinearMomentXAsString()
	 * @see #setLinearMomentXAsString(String)
	 * @generated
	 */
	void unsetLinearMomentXAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearMomentXAsString <em>Linear Moment XAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Moment XAs String</em>' attribute is set.
	 * @see #unsetLinearMomentXAsString()
	 * @see #getLinearMomentXAsString()
	 * @see #setLinearMomentXAsString(String)
	 * @generated
	 */
	boolean isSetLinearMomentXAsString();

	/**
	 * Returns the value of the '<em><b>Linear Moment Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Moment Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Moment Y</em>' attribute.
	 * @see #isSetLinearMomentY()
	 * @see #unsetLinearMomentY()
	 * @see #setLinearMomentY(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralLoadLinearForce_LinearMomentY()
	 * @model unsettable="true"
	 * @generated
	 */
	double getLinearMomentY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearMomentY <em>Linear Moment Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Moment Y</em>' attribute.
	 * @see #isSetLinearMomentY()
	 * @see #unsetLinearMomentY()
	 * @see #getLinearMomentY()
	 * @generated
	 */
	void setLinearMomentY(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearMomentY <em>Linear Moment Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearMomentY()
	 * @see #getLinearMomentY()
	 * @see #setLinearMomentY(double)
	 * @generated
	 */
	void unsetLinearMomentY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearMomentY <em>Linear Moment Y</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Moment Y</em>' attribute is set.
	 * @see #unsetLinearMomentY()
	 * @see #getLinearMomentY()
	 * @see #setLinearMomentY(double)
	 * @generated
	 */
	boolean isSetLinearMomentY();

	/**
	 * Returns the value of the '<em><b>Linear Moment YAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Moment YAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Moment YAs String</em>' attribute.
	 * @see #isSetLinearMomentYAsString()
	 * @see #unsetLinearMomentYAsString()
	 * @see #setLinearMomentYAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralLoadLinearForce_LinearMomentYAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLinearMomentYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearMomentYAsString <em>Linear Moment YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Moment YAs String</em>' attribute.
	 * @see #isSetLinearMomentYAsString()
	 * @see #unsetLinearMomentYAsString()
	 * @see #getLinearMomentYAsString()
	 * @generated
	 */
	void setLinearMomentYAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearMomentYAsString <em>Linear Moment YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearMomentYAsString()
	 * @see #getLinearMomentYAsString()
	 * @see #setLinearMomentYAsString(String)
	 * @generated
	 */
	void unsetLinearMomentYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearMomentYAsString <em>Linear Moment YAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Moment YAs String</em>' attribute is set.
	 * @see #unsetLinearMomentYAsString()
	 * @see #getLinearMomentYAsString()
	 * @see #setLinearMomentYAsString(String)
	 * @generated
	 */
	boolean isSetLinearMomentYAsString();

	/**
	 * Returns the value of the '<em><b>Linear Moment Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Moment Z</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Moment Z</em>' attribute.
	 * @see #isSetLinearMomentZ()
	 * @see #unsetLinearMomentZ()
	 * @see #setLinearMomentZ(double)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralLoadLinearForce_LinearMomentZ()
	 * @model unsettable="true"
	 * @generated
	 */
	double getLinearMomentZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearMomentZ <em>Linear Moment Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Moment Z</em>' attribute.
	 * @see #isSetLinearMomentZ()
	 * @see #unsetLinearMomentZ()
	 * @see #getLinearMomentZ()
	 * @generated
	 */
	void setLinearMomentZ(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearMomentZ <em>Linear Moment Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearMomentZ()
	 * @see #getLinearMomentZ()
	 * @see #setLinearMomentZ(double)
	 * @generated
	 */
	void unsetLinearMomentZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearMomentZ <em>Linear Moment Z</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Moment Z</em>' attribute is set.
	 * @see #unsetLinearMomentZ()
	 * @see #getLinearMomentZ()
	 * @see #setLinearMomentZ(double)
	 * @generated
	 */
	boolean isSetLinearMomentZ();

	/**
	 * Returns the value of the '<em><b>Linear Moment ZAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linear Moment ZAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linear Moment ZAs String</em>' attribute.
	 * @see #isSetLinearMomentZAsString()
	 * @see #unsetLinearMomentZAsString()
	 * @see #setLinearMomentZAsString(String)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralLoadLinearForce_LinearMomentZAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLinearMomentZAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearMomentZAsString <em>Linear Moment ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linear Moment ZAs String</em>' attribute.
	 * @see #isSetLinearMomentZAsString()
	 * @see #unsetLinearMomentZAsString()
	 * @see #getLinearMomentZAsString()
	 * @generated
	 */
	void setLinearMomentZAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearMomentZAsString <em>Linear Moment ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLinearMomentZAsString()
	 * @see #getLinearMomentZAsString()
	 * @see #setLinearMomentZAsString(String)
	 * @generated
	 */
	void unsetLinearMomentZAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralLoadLinearForce#getLinearMomentZAsString <em>Linear Moment ZAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Linear Moment ZAs String</em>' attribute is set.
	 * @see #unsetLinearMomentZAsString()
	 * @see #getLinearMomentZAsString()
	 * @see #setLinearMomentZAsString(String)
	 * @generated
	 */
	boolean isSetLinearMomentZAsString();

} // IfcStructuralLoadLinearForce
