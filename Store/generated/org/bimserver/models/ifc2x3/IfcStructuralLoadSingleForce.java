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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Structural Load Single Force</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getForceX <em>Force X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getForceXAsString <em>Force XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getForceY <em>Force Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getForceYAsString <em>Force YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getForceZ <em>Force Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getForceZAsString <em>Force ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getMomentX <em>Moment X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getMomentXAsString <em>Moment XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getMomentY <em>Moment Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getMomentYAsString <em>Moment YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getMomentZ <em>Moment Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getMomentZAsString <em>Moment ZAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleForce()
 * @model
 * @generated
 */
public interface IfcStructuralLoadSingleForce extends IfcStructuralLoadStatic
{
	/**
	 * Returns the value of the '<em><b>Force X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Force X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Force X</em>' attribute.
	 * @see #isSetForceX()
	 * @see #unsetForceX()
	 * @see #setForceX(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleForce_ForceX()
	 * @model unsettable="true"
	 * @generated
	 */
	float getForceX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getForceX <em>Force X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Force X</em>' attribute.
	 * @see #isSetForceX()
	 * @see #unsetForceX()
	 * @see #getForceX()
	 * @generated
	 */
	void setForceX(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getForceX <em>Force X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetForceX()
	 * @see #getForceX()
	 * @see #setForceX(float)
	 * @generated
	 */
	void unsetForceX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getForceX <em>Force X</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Force X</em>' attribute is set.
	 * @see #unsetForceX()
	 * @see #getForceX()
	 * @see #setForceX(float)
	 * @generated
	 */
	boolean isSetForceX();

	/**
	 * Returns the value of the '<em><b>Force XAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Force XAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Force XAs String</em>' attribute.
	 * @see #isSetForceXAsString()
	 * @see #unsetForceXAsString()
	 * @see #setForceXAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleForce_ForceXAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getForceXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getForceXAsString <em>Force XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Force XAs String</em>' attribute.
	 * @see #isSetForceXAsString()
	 * @see #unsetForceXAsString()
	 * @see #getForceXAsString()
	 * @generated
	 */
	void setForceXAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getForceXAsString <em>Force XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetForceXAsString()
	 * @see #getForceXAsString()
	 * @see #setForceXAsString(String)
	 * @generated
	 */
	void unsetForceXAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getForceXAsString <em>Force XAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Force XAs String</em>' attribute is set.
	 * @see #unsetForceXAsString()
	 * @see #getForceXAsString()
	 * @see #setForceXAsString(String)
	 * @generated
	 */
	boolean isSetForceXAsString();

	/**
	 * Returns the value of the '<em><b>Force Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Force Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Force Y</em>' attribute.
	 * @see #isSetForceY()
	 * @see #unsetForceY()
	 * @see #setForceY(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleForce_ForceY()
	 * @model unsettable="true"
	 * @generated
	 */
	float getForceY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getForceY <em>Force Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Force Y</em>' attribute.
	 * @see #isSetForceY()
	 * @see #unsetForceY()
	 * @see #getForceY()
	 * @generated
	 */
	void setForceY(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getForceY <em>Force Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetForceY()
	 * @see #getForceY()
	 * @see #setForceY(float)
	 * @generated
	 */
	void unsetForceY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getForceY <em>Force Y</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Force Y</em>' attribute is set.
	 * @see #unsetForceY()
	 * @see #getForceY()
	 * @see #setForceY(float)
	 * @generated
	 */
	boolean isSetForceY();

	/**
	 * Returns the value of the '<em><b>Force YAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Force YAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Force YAs String</em>' attribute.
	 * @see #isSetForceYAsString()
	 * @see #unsetForceYAsString()
	 * @see #setForceYAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleForce_ForceYAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getForceYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getForceYAsString <em>Force YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Force YAs String</em>' attribute.
	 * @see #isSetForceYAsString()
	 * @see #unsetForceYAsString()
	 * @see #getForceYAsString()
	 * @generated
	 */
	void setForceYAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getForceYAsString <em>Force YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetForceYAsString()
	 * @see #getForceYAsString()
	 * @see #setForceYAsString(String)
	 * @generated
	 */
	void unsetForceYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getForceYAsString <em>Force YAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Force YAs String</em>' attribute is set.
	 * @see #unsetForceYAsString()
	 * @see #getForceYAsString()
	 * @see #setForceYAsString(String)
	 * @generated
	 */
	boolean isSetForceYAsString();

	/**
	 * Returns the value of the '<em><b>Force Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Force Z</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Force Z</em>' attribute.
	 * @see #isSetForceZ()
	 * @see #unsetForceZ()
	 * @see #setForceZ(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleForce_ForceZ()
	 * @model unsettable="true"
	 * @generated
	 */
	float getForceZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getForceZ <em>Force Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Force Z</em>' attribute.
	 * @see #isSetForceZ()
	 * @see #unsetForceZ()
	 * @see #getForceZ()
	 * @generated
	 */
	void setForceZ(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getForceZ <em>Force Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetForceZ()
	 * @see #getForceZ()
	 * @see #setForceZ(float)
	 * @generated
	 */
	void unsetForceZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getForceZ <em>Force Z</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Force Z</em>' attribute is set.
	 * @see #unsetForceZ()
	 * @see #getForceZ()
	 * @see #setForceZ(float)
	 * @generated
	 */
	boolean isSetForceZ();

	/**
	 * Returns the value of the '<em><b>Force ZAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Force ZAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Force ZAs String</em>' attribute.
	 * @see #isSetForceZAsString()
	 * @see #unsetForceZAsString()
	 * @see #setForceZAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleForce_ForceZAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getForceZAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getForceZAsString <em>Force ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Force ZAs String</em>' attribute.
	 * @see #isSetForceZAsString()
	 * @see #unsetForceZAsString()
	 * @see #getForceZAsString()
	 * @generated
	 */
	void setForceZAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getForceZAsString <em>Force ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetForceZAsString()
	 * @see #getForceZAsString()
	 * @see #setForceZAsString(String)
	 * @generated
	 */
	void unsetForceZAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getForceZAsString <em>Force ZAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Force ZAs String</em>' attribute is set.
	 * @see #unsetForceZAsString()
	 * @see #getForceZAsString()
	 * @see #setForceZAsString(String)
	 * @generated
	 */
	boolean isSetForceZAsString();

	/**
	 * Returns the value of the '<em><b>Moment X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Moment X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moment X</em>' attribute.
	 * @see #isSetMomentX()
	 * @see #unsetMomentX()
	 * @see #setMomentX(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleForce_MomentX()
	 * @model unsettable="true"
	 * @generated
	 */
	float getMomentX();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getMomentX <em>Moment X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Moment X</em>' attribute.
	 * @see #isSetMomentX()
	 * @see #unsetMomentX()
	 * @see #getMomentX()
	 * @generated
	 */
	void setMomentX(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getMomentX <em>Moment X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMomentX()
	 * @see #getMomentX()
	 * @see #setMomentX(float)
	 * @generated
	 */
	void unsetMomentX();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getMomentX <em>Moment X</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Moment X</em>' attribute is set.
	 * @see #unsetMomentX()
	 * @see #getMomentX()
	 * @see #setMomentX(float)
	 * @generated
	 */
	boolean isSetMomentX();

	/**
	 * Returns the value of the '<em><b>Moment XAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Moment XAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moment XAs String</em>' attribute.
	 * @see #isSetMomentXAsString()
	 * @see #unsetMomentXAsString()
	 * @see #setMomentXAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleForce_MomentXAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getMomentXAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getMomentXAsString <em>Moment XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Moment XAs String</em>' attribute.
	 * @see #isSetMomentXAsString()
	 * @see #unsetMomentXAsString()
	 * @see #getMomentXAsString()
	 * @generated
	 */
	void setMomentXAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getMomentXAsString <em>Moment XAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMomentXAsString()
	 * @see #getMomentXAsString()
	 * @see #setMomentXAsString(String)
	 * @generated
	 */
	void unsetMomentXAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getMomentXAsString <em>Moment XAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Moment XAs String</em>' attribute is set.
	 * @see #unsetMomentXAsString()
	 * @see #getMomentXAsString()
	 * @see #setMomentXAsString(String)
	 * @generated
	 */
	boolean isSetMomentXAsString();

	/**
	 * Returns the value of the '<em><b>Moment Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Moment Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moment Y</em>' attribute.
	 * @see #isSetMomentY()
	 * @see #unsetMomentY()
	 * @see #setMomentY(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleForce_MomentY()
	 * @model unsettable="true"
	 * @generated
	 */
	float getMomentY();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getMomentY <em>Moment Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Moment Y</em>' attribute.
	 * @see #isSetMomentY()
	 * @see #unsetMomentY()
	 * @see #getMomentY()
	 * @generated
	 */
	void setMomentY(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getMomentY <em>Moment Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMomentY()
	 * @see #getMomentY()
	 * @see #setMomentY(float)
	 * @generated
	 */
	void unsetMomentY();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getMomentY <em>Moment Y</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Moment Y</em>' attribute is set.
	 * @see #unsetMomentY()
	 * @see #getMomentY()
	 * @see #setMomentY(float)
	 * @generated
	 */
	boolean isSetMomentY();

	/**
	 * Returns the value of the '<em><b>Moment YAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Moment YAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moment YAs String</em>' attribute.
	 * @see #isSetMomentYAsString()
	 * @see #unsetMomentYAsString()
	 * @see #setMomentYAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleForce_MomentYAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getMomentYAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getMomentYAsString <em>Moment YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Moment YAs String</em>' attribute.
	 * @see #isSetMomentYAsString()
	 * @see #unsetMomentYAsString()
	 * @see #getMomentYAsString()
	 * @generated
	 */
	void setMomentYAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getMomentYAsString <em>Moment YAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMomentYAsString()
	 * @see #getMomentYAsString()
	 * @see #setMomentYAsString(String)
	 * @generated
	 */
	void unsetMomentYAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getMomentYAsString <em>Moment YAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Moment YAs String</em>' attribute is set.
	 * @see #unsetMomentYAsString()
	 * @see #getMomentYAsString()
	 * @see #setMomentYAsString(String)
	 * @generated
	 */
	boolean isSetMomentYAsString();

	/**
	 * Returns the value of the '<em><b>Moment Z</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Moment Z</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moment Z</em>' attribute.
	 * @see #isSetMomentZ()
	 * @see #unsetMomentZ()
	 * @see #setMomentZ(float)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleForce_MomentZ()
	 * @model unsettable="true"
	 * @generated
	 */
	float getMomentZ();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getMomentZ <em>Moment Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Moment Z</em>' attribute.
	 * @see #isSetMomentZ()
	 * @see #unsetMomentZ()
	 * @see #getMomentZ()
	 * @generated
	 */
	void setMomentZ(float value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getMomentZ <em>Moment Z</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMomentZ()
	 * @see #getMomentZ()
	 * @see #setMomentZ(float)
	 * @generated
	 */
	void unsetMomentZ();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getMomentZ <em>Moment Z</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Moment Z</em>' attribute is set.
	 * @see #unsetMomentZ()
	 * @see #getMomentZ()
	 * @see #setMomentZ(float)
	 * @generated
	 */
	boolean isSetMomentZ();

	/**
	 * Returns the value of the '<em><b>Moment ZAs String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Moment ZAs String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Moment ZAs String</em>' attribute.
	 * @see #isSetMomentZAsString()
	 * @see #unsetMomentZAsString()
	 * @see #setMomentZAsString(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcStructuralLoadSingleForce_MomentZAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getMomentZAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getMomentZAsString <em>Moment ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Moment ZAs String</em>' attribute.
	 * @see #isSetMomentZAsString()
	 * @see #unsetMomentZAsString()
	 * @see #getMomentZAsString()
	 * @generated
	 */
	void setMomentZAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getMomentZAsString <em>Moment ZAs String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMomentZAsString()
	 * @see #getMomentZAsString()
	 * @see #setMomentZAsString(String)
	 * @generated
	 */
	void unsetMomentZAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcStructuralLoadSingleForce#getMomentZAsString <em>Moment ZAs String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Moment ZAs String</em>' attribute is set.
	 * @see #unsetMomentZAsString()
	 * @see #getMomentZAsString()
	 * @see #setMomentZAsString(String)
	 * @generated
	 */
	boolean isSetMomentZAsString();

} // IfcStructuralLoadSingleForce
