/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;

import org.bimserver.emf.IdEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Shape Aspect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcShapeAspect#getShapeRepresentations <em>Shape Representations</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcShapeAspect#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcShapeAspect#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcShapeAspect#isProductDefinitional <em>Product Definitional</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcShapeAspect#getPartOfProductDefinitionShape <em>Part Of Product Definition Shape</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcShapeAspect()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcShapeAspect extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Shape Representations</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcShapeModel}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcShapeModel#getOfShapeAspect <em>Of Shape Aspect</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shape Representations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shape Representations</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcShapeAspect_ShapeRepresentations()
	 * @see org.bimserver.models.ifc2x3.IfcShapeModel#getOfShapeAspect
	 * @model opposite="OfShapeAspect"
	 * @generated
	 */
	EList<IfcShapeModel> getShapeRepresentations();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #setName(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcShapeAspect_Name()
	 * @model unsettable="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcShapeAspect#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see #unsetName()
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcShapeAspect#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	void unsetName();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcShapeAspect#getName <em>Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Name</em>' attribute is set.
	 * @see #unsetName()
	 * @see #getName()
	 * @see #setName(String)
	 * @generated
	 */
	boolean isSetName();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #isSetDescription()
	 * @see #unsetDescription()
	 * @see #setDescription(String)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcShapeAspect_Description()
	 * @model unsettable="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcShapeAspect#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #isSetDescription()
	 * @see #unsetDescription()
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcShapeAspect#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	void unsetDescription();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcShapeAspect#getDescription <em>Description</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Description</em>' attribute is set.
	 * @see #unsetDescription()
	 * @see #getDescription()
	 * @see #setDescription(String)
	 * @generated
	 */
	boolean isSetDescription();

	/**
	 * Returns the value of the '<em><b>Product Definitional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Product Definitional</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product Definitional</em>' attribute.
	 * @see #setProductDefinitional(boolean)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcShapeAspect_ProductDefinitional()
	 * @model
	 * @generated
	 */
	boolean isProductDefinitional();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcShapeAspect#isProductDefinitional <em>Product Definitional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Product Definitional</em>' attribute.
	 * @see #isProductDefinitional()
	 * @generated
	 */
	void setProductDefinitional(boolean value);

	/**
	 * Returns the value of the '<em><b>Part Of Product Definition Shape</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcProductDefinitionShape#getHasShapeAspects <em>Has Shape Aspects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Of Product Definition Shape</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Of Product Definition Shape</em>' reference.
	 * @see #setPartOfProductDefinitionShape(IfcProductDefinitionShape)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcShapeAspect_PartOfProductDefinitionShape()
	 * @see org.bimserver.models.ifc2x3.IfcProductDefinitionShape#getHasShapeAspects
	 * @model opposite="HasShapeAspects"
	 * @generated
	 */
	IfcProductDefinitionShape getPartOfProductDefinitionShape();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcShapeAspect#getPartOfProductDefinitionShape <em>Part Of Product Definition Shape</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part Of Product Definition Shape</em>' reference.
	 * @see #getPartOfProductDefinitionShape()
	 * @generated
	 */
	void setPartOfProductDefinitionShape(IfcProductDefinitionShape value);

} // IfcShapeAspect
