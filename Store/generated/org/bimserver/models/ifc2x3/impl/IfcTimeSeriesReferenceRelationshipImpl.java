/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcDocumentSelect;
import org.bimserver.models.ifc2x3.IfcTimeSeries;
import org.bimserver.models.ifc2x3.IfcTimeSeriesReferenceRelationship;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Time Series Reference Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTimeSeriesReferenceRelationshipImpl#getReferencedTimeSeries <em>Referenced Time Series</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTimeSeriesReferenceRelationshipImpl#getTimeSeriesReferences <em>Time Series References</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcTimeSeriesReferenceRelationshipImpl extends IdEObjectImpl implements IfcTimeSeriesReferenceRelationship {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTimeSeriesReferenceRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcTimeSeriesReferenceRelationship();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTimeSeries getReferencedTimeSeries() {
		return (IfcTimeSeries)eGet(Ifc2x3Package.eINSTANCE.getIfcTimeSeriesReferenceRelationship_ReferencedTimeSeries(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedTimeSeries(IfcTimeSeries newReferencedTimeSeries) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcTimeSeriesReferenceRelationship_ReferencedTimeSeries(), newReferencedTimeSeries);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcDocumentSelect> getTimeSeriesReferences() {
		return (EList<IfcDocumentSelect>)eGet(Ifc2x3Package.eINSTANCE.getIfcTimeSeriesReferenceRelationship_TimeSeriesReferences(), true);
	}

} //IfcTimeSeriesReferenceRelationshipImpl
