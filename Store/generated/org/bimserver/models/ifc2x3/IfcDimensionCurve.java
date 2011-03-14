/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ifc Dimension Curve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.IfcDimensionCurve#getAnnotatedBySymbols <em>Annotated By Symbols</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDimensionCurve()
 * @model
 * @generated
 */
public interface IfcDimensionCurve extends IfcAnnotationCurveOccurrence {
	/**
	 * Returns the value of the '<em><b>Annotated By Symbols</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.ifc2x3.IfcTerminatorSymbol}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotated By Symbols</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotated By Symbols</em>' reference list.
	 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcDimensionCurve_AnnotatedBySymbols()
	 * @model upper="3"
	 * @generated
	 */
	EList<IfcTerminatorSymbol> getAnnotatedBySymbols();

} // IfcDimensionCurve
