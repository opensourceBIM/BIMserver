/**
 * Copyright (C) 2011  BIMserver.org
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
package org.bimserver.models.ifc2x3;

import org.bimserver.emf.IdEObject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Time Series Reference Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTimeSeriesReferenceRelationship#getReferencedTimeSeries <em>Referenced Time Series</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcTimeSeriesReferenceRelationship#getTimeSeriesReferences <em>Time Series References</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTimeSeriesReferenceRelationship()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface IfcTimeSeriesReferenceRelationship extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Referenced Time Series</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3.IfcTimeSeries#getDocumentedBy <em>Documented By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referenced Time Series</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referenced Time Series</em>' reference.
	 * @see #isSetReferencedTimeSeries()
	 * @see #unsetReferencedTimeSeries()
	 * @see #setReferencedTimeSeries(IfcTimeSeries)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTimeSeriesReferenceRelationship_ReferencedTimeSeries()
	 * @see org.bimserver.models.ifc2x3.IfcTimeSeries#getDocumentedBy
	 * @model opposite="DocumentedBy" unsettable="true"
	 * @generated
	 */
	IfcTimeSeries getReferencedTimeSeries();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeriesReferenceRelationship#getReferencedTimeSeries <em>Referenced Time Series</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Time Series</em>' reference.
	 * @see #isSetReferencedTimeSeries()
	 * @see #unsetReferencedTimeSeries()
	 * @see #getReferencedTimeSeries()
	 * @generated
	 */
	void setReferencedTimeSeries(IfcTimeSeries value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeriesReferenceRelationship#getReferencedTimeSeries <em>Referenced Time Series</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetReferencedTimeSeries()
	 * @see #getReferencedTimeSeries()
	 * @see #setReferencedTimeSeries(IfcTimeSeries)
	 * @generated
	 */
	void unsetReferencedTimeSeries();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeriesReferenceRelationship#getReferencedTimeSeries <em>Referenced Time Series</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Referenced Time Series</em>' reference is set.
	 * @see #unsetReferencedTimeSeries()
	 * @see #getReferencedTimeSeries()
	 * @see #setReferencedTimeSeries(IfcTimeSeries)
	 * @generated
	 */
	boolean isSetReferencedTimeSeries();

	/**
	 * Returns the value of the '<em><b>Time Series References</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcDocumentSelect}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Series References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Series References</em>' reference list.
	 * @see #isSetTimeSeriesReferences()
	 * @see #unsetTimeSeriesReferences()
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTimeSeriesReferenceRelationship_TimeSeriesReferences()
	 * @model unsettable="true"
	 * @generated
	 */
	EList<IfcDocumentSelect> getTimeSeriesReferences();

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeriesReferenceRelationship#getTimeSeriesReferences <em>Time Series References</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTimeSeriesReferences()
	 * @see #getTimeSeriesReferences()
	 * @generated
	 */
	void unsetTimeSeriesReferences();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeriesReferenceRelationship#getTimeSeriesReferences <em>Time Series References</em>}' reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Time Series References</em>' reference list is set.
	 * @see #unsetTimeSeriesReferences()
	 * @see #getTimeSeriesReferences()
	 * @generated
	 */
	boolean isSetTimeSeriesReferences();

} // IfcTimeSeriesReferenceRelationship
