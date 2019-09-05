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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcContext#getObjectType <em>Object Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcContext#getLongName <em>Long Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcContext#getPhase <em>Phase</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcContext#getRepresentationContexts <em>Representation Contexts</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcContext#getUnitsInContext <em>Units In Context</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcContext#getIsDefinedBy <em>Is Defined By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcContext#getDeclares <em>Declares</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcContext()
 * @model
 * @generated
 */
public interface IfcContext extends IfcObjectDefinition {
	/**
	 * Returns the value of the '<em><b>Object Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object Type</em>' attribute.
	 * @see #isSetObjectType()
	 * @see #unsetObjectType()
	 * @see #setObjectType(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcContext_ObjectType()
	 * @model unsettable="true"
	 * @generated
	 */
	String getObjectType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcContext#getObjectType <em>Object Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object Type</em>' attribute.
	 * @see #isSetObjectType()
	 * @see #unsetObjectType()
	 * @see #getObjectType()
	 * @generated
	 */
	void setObjectType(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcContext#getObjectType <em>Object Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetObjectType()
	 * @see #getObjectType()
	 * @see #setObjectType(String)
	 * @generated
	 */
	void unsetObjectType();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcContext#getObjectType <em>Object Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Object Type</em>' attribute is set.
	 * @see #unsetObjectType()
	 * @see #getObjectType()
	 * @see #setObjectType(String)
	 * @generated
	 */
	boolean isSetObjectType();

	/**
	 * Returns the value of the '<em><b>Long Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Long Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Long Name</em>' attribute.
	 * @see #isSetLongName()
	 * @see #unsetLongName()
	 * @see #setLongName(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcContext_LongName()
	 * @model unsettable="true"
	 * @generated
	 */
	String getLongName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcContext#getLongName <em>Long Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Long Name</em>' attribute.
	 * @see #isSetLongName()
	 * @see #unsetLongName()
	 * @see #getLongName()
	 * @generated
	 */
	void setLongName(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcContext#getLongName <em>Long Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLongName()
	 * @see #getLongName()
	 * @see #setLongName(String)
	 * @generated
	 */
	void unsetLongName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcContext#getLongName <em>Long Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Long Name</em>' attribute is set.
	 * @see #unsetLongName()
	 * @see #getLongName()
	 * @see #setLongName(String)
	 * @generated
	 */
	boolean isSetLongName();

	/**
	 * Returns the value of the '<em><b>Phase</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Phase</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Phase</em>' attribute.
	 * @see #isSetPhase()
	 * @see #unsetPhase()
	 * @see #setPhase(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcContext_Phase()
	 * @model unsettable="true"
	 * @generated
	 */
	String getPhase();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcContext#getPhase <em>Phase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Phase</em>' attribute.
	 * @see #isSetPhase()
	 * @see #unsetPhase()
	 * @see #getPhase()
	 * @generated
	 */
	void setPhase(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcContext#getPhase <em>Phase</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPhase()
	 * @see #getPhase()
	 * @see #setPhase(String)
	 * @generated
	 */
	void unsetPhase();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcContext#getPhase <em>Phase</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Phase</em>' attribute is set.
	 * @see #unsetPhase()
	 * @see #getPhase()
	 * @see #setPhase(String)
	 * @generated
	 */
	boolean isSetPhase();

	/**
	 * Returns the value of the '<em><b>Representation Contexts</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRepresentationContext}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Representation Contexts</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Representation Contexts</em>' reference list.
	 * @see #isSetRepresentationContexts()
	 * @see #unsetRepresentationContexts()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcContext_RepresentationContexts()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcRepresentationContext> getRepresentationContexts();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcContext#getRepresentationContexts <em>Representation Contexts</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRepresentationContexts()
	 * @see #getRepresentationContexts()
	 * @generated
	 */
	void unsetRepresentationContexts();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcContext#getRepresentationContexts <em>Representation Contexts</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Representation Contexts</em>' reference list is set.
	 * @see #unsetRepresentationContexts()
	 * @see #getRepresentationContexts()
	 * @generated
	 */
	boolean isSetRepresentationContexts();

	/**
	 * Returns the value of the '<em><b>Units In Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Units In Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Units In Context</em>' reference.
	 * @see #isSetUnitsInContext()
	 * @see #unsetUnitsInContext()
	 * @see #setUnitsInContext(IfcUnitAssignment)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcContext_UnitsInContext()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcUnitAssignment getUnitsInContext();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcContext#getUnitsInContext <em>Units In Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Units In Context</em>' reference.
	 * @see #isSetUnitsInContext()
	 * @see #unsetUnitsInContext()
	 * @see #getUnitsInContext()
	 * @generated
	 */
	void setUnitsInContext(IfcUnitAssignment value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcContext#getUnitsInContext <em>Units In Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUnitsInContext()
	 * @see #getUnitsInContext()
	 * @see #setUnitsInContext(IfcUnitAssignment)
	 * @generated
	 */
	void unsetUnitsInContext();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcContext#getUnitsInContext <em>Units In Context</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Units In Context</em>' reference is set.
	 * @see #unsetUnitsInContext()
	 * @see #getUnitsInContext()
	 * @see #setUnitsInContext(IfcUnitAssignment)
	 * @generated
	 */
	boolean isSetUnitsInContext();

	/**
	 * Returns the value of the '<em><b>Is Defined By</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelDefinesByProperties}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Defined By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Defined By</em>' reference list.
	 * @see #isSetIsDefinedBy()
	 * @see #unsetIsDefinedBy()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcContext_IsDefinedBy()
	 * @model unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelDefinesByProperties> getIsDefinedBy();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcContext#getIsDefinedBy <em>Is Defined By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsDefinedBy()
	 * @see #getIsDefinedBy()
	 * @generated
	 */
	void unsetIsDefinedBy();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcContext#getIsDefinedBy <em>Is Defined By</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Defined By</em>' reference list is set.
	 * @see #unsetIsDefinedBy()
	 * @see #getIsDefinedBy()
	 * @generated
	 */
	boolean isSetIsDefinedBy();

	/**
	 * Returns the value of the '<em><b>Declares</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcRelDeclares}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcRelDeclares#getRelatingContext <em>Relating Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declares</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declares</em>' reference list.
	 * @see #isSetDeclares()
	 * @see #unsetDeclares()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcContext_Declares()
	 * @see org.bimserver.models.ifc4.IfcRelDeclares#getRelatingContext
	 * @model opposite="RelatingContext" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcRelDeclares> getDeclares();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcContext#getDeclares <em>Declares</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDeclares()
	 * @see #getDeclares()
	 * @generated
	 */
	void unsetDeclares();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcContext#getDeclares <em>Declares</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Declares</em>' reference list is set.
	 * @see #unsetDeclares()
	 * @see #getDeclares()
	 * @generated
	 */
	boolean isSetDeclares();

} // IfcContext
