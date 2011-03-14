/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Image Texture</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcImageTexture#getUrlReference <em>Url Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcImageTexture()
 * @model
 * @generated
 */
public interface IfcImageTexture extends IfcSurfaceTexture {
	/**
	 * Returns the value of the '<em><b>Url Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url Reference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url Reference</em>' attribute.
	 * @see #setUrlReference(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcImageTexture_UrlReference()
	 * @model
	 * @generated
	 */
	String getUrlReference();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcImageTexture#getUrlReference <em>Url Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url Reference</em>' attribute.
	 * @see #getUrlReference()
	 * @generated
	 */
	void setUrlReference(String value);

} // IfcImageTexture
