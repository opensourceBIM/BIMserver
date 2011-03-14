/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcDimensionCurve;
import org.bimserver.models.ifc2x3.IfcTerminatorSymbol;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Dimension Curve</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcDimensionCurveImpl#getAnnotatedBySymbols <em>Annotated By Symbols</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcDimensionCurveImpl extends IfcAnnotationCurveOccurrenceImpl implements IfcDimensionCurve {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcDimensionCurveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcDimensionCurve();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcTerminatorSymbol> getAnnotatedBySymbols() {
		return (EList<IfcTerminatorSymbol>)eGet(Ifc2x3Package.eINSTANCE.getIfcDimensionCurve_AnnotatedBySymbols(), true);
	}

} //IfcDimensionCurveImpl
