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
	 * @see #setReferencedTimeSeries(IfcTimeSeries)
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTimeSeriesReferenceRelationship_ReferencedTimeSeries()
	 * @see org.bimserver.models.ifc2x3.IfcTimeSeries#getDocumentedBy
	 * @model opposite="DocumentedBy"
	 * @generated
	 */
	IfcTimeSeries getReferencedTimeSeries();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3.IfcTimeSeriesReferenceRelationship#getReferencedTimeSeries <em>Referenced Time Series</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Time Series</em>' reference.
	 * @see #getReferencedTimeSeries()
	 * @generated
	 */
	void setReferencedTimeSeries(IfcTimeSeries value);

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
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcTimeSeriesReferenceRelationship_TimeSeriesReferences()
	 * @model
	 * @generated
	 */
	EList<IfcDocumentSelect> getTimeSeriesReferences();

} // IfcTimeSeriesReferenceRelationship
