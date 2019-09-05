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
 * A representation of the model object '<em><b>Ifc Surface Texture</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcSurfaceTexture#getRepeatS <em>Repeat S</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSurfaceTexture#getRepeatT <em>Repeat T</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSurfaceTexture#getMode <em>Mode</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSurfaceTexture#getTextureTransform <em>Texture Transform</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSurfaceTexture#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSurfaceTexture#getIsMappedBy <em>Is Mapped By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcSurfaceTexture#getUsedInStyles <em>Used In Styles</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSurfaceTexture()
 * @model
 * @generated
 */
public interface IfcSurfaceTexture extends IfcPresentationItem {
	/**
	 * Returns the value of the '<em><b>Repeat S</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repeat S</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repeat S</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #setRepeatS(Tristate)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSurfaceTexture_RepeatS()
	 * @model
	 * @generated
	 */
	Tristate getRepeatS();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceTexture#getRepeatS <em>Repeat S</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repeat S</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #getRepeatS()
	 * @generated
	 */
	void setRepeatS(Tristate value);

	/**
	 * Returns the value of the '<em><b>Repeat T</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Repeat T</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repeat T</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #setRepeatT(Tristate)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSurfaceTexture_RepeatT()
	 * @model
	 * @generated
	 */
	Tristate getRepeatT();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceTexture#getRepeatT <em>Repeat T</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repeat T</em>' attribute.
	 * @see org.bimserver.models.ifc4.Tristate
	 * @see #getRepeatT()
	 * @generated
	 */
	void setRepeatT(Tristate value);

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see #isSetMode()
	 * @see #unsetMode()
	 * @see #setMode(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSurfaceTexture_Mode()
	 * @model unsettable="true"
	 * @generated
	 */
	String getMode();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceTexture#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see #isSetMode()
	 * @see #unsetMode()
	 * @see #getMode()
	 * @generated
	 */
	void setMode(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceTexture#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMode()
	 * @see #getMode()
	 * @see #setMode(String)
	 * @generated
	 */
	void unsetMode();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceTexture#getMode <em>Mode</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Mode</em>' attribute is set.
	 * @see #unsetMode()
	 * @see #getMode()
	 * @see #setMode(String)
	 * @generated
	 */
	boolean isSetMode();

	/**
	 * Returns the value of the '<em><b>Texture Transform</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Texture Transform</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Texture Transform</em>' reference.
	 * @see #isSetTextureTransform()
	 * @see #unsetTextureTransform()
	 * @see #setTextureTransform(IfcCartesianTransformationOperator2D)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSurfaceTexture_TextureTransform()
	 * @model unsettable="true"
	 * @generated
	 */
	IfcCartesianTransformationOperator2D getTextureTransform();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceTexture#getTextureTransform <em>Texture Transform</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Texture Transform</em>' reference.
	 * @see #isSetTextureTransform()
	 * @see #unsetTextureTransform()
	 * @see #getTextureTransform()
	 * @generated
	 */
	void setTextureTransform(IfcCartesianTransformationOperator2D value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceTexture#getTextureTransform <em>Texture Transform</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTextureTransform()
	 * @see #getTextureTransform()
	 * @see #setTextureTransform(IfcCartesianTransformationOperator2D)
	 * @generated
	 */
	void unsetTextureTransform();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceTexture#getTextureTransform <em>Texture Transform</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Texture Transform</em>' reference is set.
	 * @see #unsetTextureTransform()
	 * @see #getTextureTransform()
	 * @see #setTextureTransform(IfcCartesianTransformationOperator2D)
	 * @generated
	 */
	boolean isSetTextureTransform();

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' attribute list.
	 * @see #isSetParameter()
	 * @see #unsetParameter()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSurfaceTexture_Parameter()
	 * @model unique="false" unsettable="true"
	 * @generated
	 */
	EList<String> getParameter();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceTexture#getParameter <em>Parameter</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetParameter()
	 * @see #getParameter()
	 * @generated
	 */
	void unsetParameter();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceTexture#getParameter <em>Parameter</em>}' attribute list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Parameter</em>' attribute list is set.
	 * @see #unsetParameter()
	 * @see #getParameter()
	 * @generated
	 */
	boolean isSetParameter();

	/**
	 * Returns the value of the '<em><b>Is Mapped By</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcTextureCoordinate}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcTextureCoordinate#getMaps <em>Maps</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Mapped By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Mapped By</em>' reference list.
	 * @see #isSetIsMappedBy()
	 * @see #unsetIsMappedBy()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSurfaceTexture_IsMappedBy()
	 * @see org.bimserver.models.ifc4.IfcTextureCoordinate#getMaps
	 * @model opposite="Maps" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcTextureCoordinate> getIsMappedBy();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceTexture#getIsMappedBy <em>Is Mapped By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsMappedBy()
	 * @see #getIsMappedBy()
	 * @generated
	 */
	void unsetIsMappedBy();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceTexture#getIsMappedBy <em>Is Mapped By</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is Mapped By</em>' reference list is set.
	 * @see #unsetIsMappedBy()
	 * @see #getIsMappedBy()
	 * @generated
	 */
	boolean isSetIsMappedBy();

	/**
	 * Returns the value of the '<em><b>Used In Styles</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc4.IfcSurfaceStyleWithTextures}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc4.IfcSurfaceStyleWithTextures#getTextures <em>Textures</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used In Styles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used In Styles</em>' reference list.
	 * @see #isSetUsedInStyles()
	 * @see #unsetUsedInStyles()
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcSurfaceTexture_UsedInStyles()
	 * @see org.bimserver.models.ifc4.IfcSurfaceStyleWithTextures#getTextures
	 * @model opposite="Textures" unsettable="true"
	 *        annotation="inverse"
	 * @generated
	 */
	EList<IfcSurfaceStyleWithTextures> getUsedInStyles();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceTexture#getUsedInStyles <em>Used In Styles</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUsedInStyles()
	 * @see #getUsedInStyles()
	 * @generated
	 */
	void unsetUsedInStyles();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcSurfaceTexture#getUsedInStyles <em>Used In Styles</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Used In Styles</em>' reference list is set.
	 * @see #unsetUsedInStyles()
	 * @see #getUsedInStyles()
	 * @generated
	 */
	boolean isSetUsedInStyles();

} // IfcSurfaceTexture
