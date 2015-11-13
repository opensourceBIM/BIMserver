/**
 * Copyright (C) 2009-2013 BIMserver.org
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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Tendon Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4.IfcTendonType#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTendonType#getNominalDiameter <em>Nominal Diameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTendonType#getNominalDiameterAsString <em>Nominal Diameter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTendonType#getCrossSectionArea <em>Cross Section Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTendonType#getCrossSectionAreaAsString <em>Cross Section Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTendonType#getSheethDiameter <em>Sheeth Diameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4.IfcTendonType#getSheethDiameterAsString <em>Sheeth Diameter As String</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTendonType()
 * @model
 * @generated
 */
public interface IfcTendonType extends IfcReinforcingElementType {
	/**
	 * Returns the value of the '<em><b>Predefined Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc4.IfcTendonTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcTendonTypeEnum
	 * @see #setPredefinedType(IfcTendonTypeEnum)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTendonType_PredefinedType()
	 * @model
	 * @generated
	 */
	IfcTendonTypeEnum getPredefinedType();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTendonType#getPredefinedType <em>Predefined Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predefined Type</em>' attribute.
	 * @see org.bimserver.models.ifc4.IfcTendonTypeEnum
	 * @see #getPredefinedType()
	 * @generated
	 */
	void setPredefinedType(IfcTendonTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Nominal Diameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nominal Diameter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nominal Diameter</em>' attribute.
	 * @see #isSetNominalDiameter()
	 * @see #unsetNominalDiameter()
	 * @see #setNominalDiameter(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTendonType_NominalDiameter()
	 * @model unsettable="true"
	 * @generated
	 */
	double getNominalDiameter();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTendonType#getNominalDiameter <em>Nominal Diameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nominal Diameter</em>' attribute.
	 * @see #isSetNominalDiameter()
	 * @see #unsetNominalDiameter()
	 * @see #getNominalDiameter()
	 * @generated
	 */
	void setNominalDiameter(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTendonType#getNominalDiameter <em>Nominal Diameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNominalDiameter()
	 * @see #getNominalDiameter()
	 * @see #setNominalDiameter(double)
	 * @generated
	 */
	void unsetNominalDiameter();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTendonType#getNominalDiameter <em>Nominal Diameter</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Nominal Diameter</em>' attribute is set.
	 * @see #unsetNominalDiameter()
	 * @see #getNominalDiameter()
	 * @see #setNominalDiameter(double)
	 * @generated
	 */
	boolean isSetNominalDiameter();

	/**
	 * Returns the value of the '<em><b>Nominal Diameter As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nominal Diameter As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nominal Diameter As String</em>' attribute.
	 * @see #isSetNominalDiameterAsString()
	 * @see #unsetNominalDiameterAsString()
	 * @see #setNominalDiameterAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTendonType_NominalDiameterAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getNominalDiameterAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTendonType#getNominalDiameterAsString <em>Nominal Diameter As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nominal Diameter As String</em>' attribute.
	 * @see #isSetNominalDiameterAsString()
	 * @see #unsetNominalDiameterAsString()
	 * @see #getNominalDiameterAsString()
	 * @generated
	 */
	void setNominalDiameterAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTendonType#getNominalDiameterAsString <em>Nominal Diameter As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNominalDiameterAsString()
	 * @see #getNominalDiameterAsString()
	 * @see #setNominalDiameterAsString(String)
	 * @generated
	 */
	void unsetNominalDiameterAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTendonType#getNominalDiameterAsString <em>Nominal Diameter As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Nominal Diameter As String</em>' attribute is set.
	 * @see #unsetNominalDiameterAsString()
	 * @see #getNominalDiameterAsString()
	 * @see #setNominalDiameterAsString(String)
	 * @generated
	 */
	boolean isSetNominalDiameterAsString();

	/**
	 * Returns the value of the '<em><b>Cross Section Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cross Section Area</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cross Section Area</em>' attribute.
	 * @see #isSetCrossSectionArea()
	 * @see #unsetCrossSectionArea()
	 * @see #setCrossSectionArea(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTendonType_CrossSectionArea()
	 * @model unsettable="true"
	 * @generated
	 */
	double getCrossSectionArea();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTendonType#getCrossSectionArea <em>Cross Section Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cross Section Area</em>' attribute.
	 * @see #isSetCrossSectionArea()
	 * @see #unsetCrossSectionArea()
	 * @see #getCrossSectionArea()
	 * @generated
	 */
	void setCrossSectionArea(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTendonType#getCrossSectionArea <em>Cross Section Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCrossSectionArea()
	 * @see #getCrossSectionArea()
	 * @see #setCrossSectionArea(double)
	 * @generated
	 */
	void unsetCrossSectionArea();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTendonType#getCrossSectionArea <em>Cross Section Area</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Cross Section Area</em>' attribute is set.
	 * @see #unsetCrossSectionArea()
	 * @see #getCrossSectionArea()
	 * @see #setCrossSectionArea(double)
	 * @generated
	 */
	boolean isSetCrossSectionArea();

	/**
	 * Returns the value of the '<em><b>Cross Section Area As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cross Section Area As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cross Section Area As String</em>' attribute.
	 * @see #isSetCrossSectionAreaAsString()
	 * @see #unsetCrossSectionAreaAsString()
	 * @see #setCrossSectionAreaAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTendonType_CrossSectionAreaAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getCrossSectionAreaAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTendonType#getCrossSectionAreaAsString <em>Cross Section Area As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cross Section Area As String</em>' attribute.
	 * @see #isSetCrossSectionAreaAsString()
	 * @see #unsetCrossSectionAreaAsString()
	 * @see #getCrossSectionAreaAsString()
	 * @generated
	 */
	void setCrossSectionAreaAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTendonType#getCrossSectionAreaAsString <em>Cross Section Area As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCrossSectionAreaAsString()
	 * @see #getCrossSectionAreaAsString()
	 * @see #setCrossSectionAreaAsString(String)
	 * @generated
	 */
	void unsetCrossSectionAreaAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTendonType#getCrossSectionAreaAsString <em>Cross Section Area As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Cross Section Area As String</em>' attribute is set.
	 * @see #unsetCrossSectionAreaAsString()
	 * @see #getCrossSectionAreaAsString()
	 * @see #setCrossSectionAreaAsString(String)
	 * @generated
	 */
	boolean isSetCrossSectionAreaAsString();

	/**
	 * Returns the value of the '<em><b>Sheeth Diameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sheeth Diameter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sheeth Diameter</em>' attribute.
	 * @see #isSetSheethDiameter()
	 * @see #unsetSheethDiameter()
	 * @see #setSheethDiameter(double)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTendonType_SheethDiameter()
	 * @model unsettable="true"
	 * @generated
	 */
	double getSheethDiameter();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTendonType#getSheethDiameter <em>Sheeth Diameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sheeth Diameter</em>' attribute.
	 * @see #isSetSheethDiameter()
	 * @see #unsetSheethDiameter()
	 * @see #getSheethDiameter()
	 * @generated
	 */
	void setSheethDiameter(double value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTendonType#getSheethDiameter <em>Sheeth Diameter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSheethDiameter()
	 * @see #getSheethDiameter()
	 * @see #setSheethDiameter(double)
	 * @generated
	 */
	void unsetSheethDiameter();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTendonType#getSheethDiameter <em>Sheeth Diameter</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Sheeth Diameter</em>' attribute is set.
	 * @see #unsetSheethDiameter()
	 * @see #getSheethDiameter()
	 * @see #setSheethDiameter(double)
	 * @generated
	 */
	boolean isSetSheethDiameter();

	/**
	 * Returns the value of the '<em><b>Sheeth Diameter As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sheeth Diameter As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sheeth Diameter As String</em>' attribute.
	 * @see #isSetSheethDiameterAsString()
	 * @see #unsetSheethDiameterAsString()
	 * @see #setSheethDiameterAsString(String)
	 * @see org.bimserver.models.ifc4.Ifc4Package#getIfcTendonType_SheethDiameterAsString()
	 * @model unsettable="true"
	 * @generated
	 */
	String getSheethDiameterAsString();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc4.IfcTendonType#getSheethDiameterAsString <em>Sheeth Diameter As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sheeth Diameter As String</em>' attribute.
	 * @see #isSetSheethDiameterAsString()
	 * @see #unsetSheethDiameterAsString()
	 * @see #getSheethDiameterAsString()
	 * @generated
	 */
	void setSheethDiameterAsString(String value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc4.IfcTendonType#getSheethDiameterAsString <em>Sheeth Diameter As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSheethDiameterAsString()
	 * @see #getSheethDiameterAsString()
	 * @see #setSheethDiameterAsString(String)
	 * @generated
	 */
	void unsetSheethDiameterAsString();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc4.IfcTendonType#getSheethDiameterAsString <em>Sheeth Diameter As String</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Sheeth Diameter As String</em>' attribute is set.
	 * @see #unsetSheethDiameterAsString()
	 * @see #getSheethDiameterAsString()
	 * @see #setSheethDiameterAsString(String)
	 * @generated
	 */
	boolean isSetSheethDiameterAsString();

} // IfcTendonType
