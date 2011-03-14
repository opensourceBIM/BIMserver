/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Material Definition Representation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcMaterialDefinitionRepresentation#getRepresentedMaterial <em>Represented Material</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterialDefinitionRepresentation()
 * @model
 * @generated
 */
public interface IfcMaterialDefinitionRepresentation extends IfcProductRepresentation {
	/**
	 * Returns the value of the '<em><b>Represented Material</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcMaterial#getHasRepresentation <em>Has Representation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Represented Material</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Represented Material</em>' reference.
	 * @see #setRepresentedMaterial(IfcMaterial)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcMaterialDefinitionRepresentation_RepresentedMaterial()
	 * @see org.bimserver.models.ifc2x3.IfcMaterial#getHasRepresentation
	 * @model opposite="HasRepresentation"
	 * @generated
	 */
	IfcMaterial getRepresentedMaterial();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcMaterialDefinitionRepresentation#getRepresentedMaterial <em>Represented Material</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Represented Material</em>' reference.
	 * @see #getRepresentedMaterial()
	 * @generated
	 */
	void setRepresentedMaterial(IfcMaterial value);

} // IfcMaterialDefinitionRepresentation
