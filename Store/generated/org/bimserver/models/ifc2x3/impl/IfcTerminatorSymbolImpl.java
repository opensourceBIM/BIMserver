/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcAnnotationCurveOccurrence;
import org.bimserver.models.ifc2x3.IfcTerminatorSymbol;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Terminator Symbol</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTerminatorSymbolImpl#getAnnotatedCurve <em>Annotated Curve</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcTerminatorSymbolImpl extends IfcAnnotationSymbolOccurrenceImpl implements IfcTerminatorSymbol {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTerminatorSymbolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcTerminatorSymbol();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAnnotationCurveOccurrence getAnnotatedCurve() {
		return (IfcAnnotationCurveOccurrence)eGet(Ifc2x3Package.eINSTANCE.getIfcTerminatorSymbol_AnnotatedCurve(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnnotatedCurve(IfcAnnotationCurveOccurrence newAnnotatedCurve) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcTerminatorSymbol_AnnotatedCurve(), newAnnotatedCurve);
	}

} //IfcTerminatorSymbolImpl
