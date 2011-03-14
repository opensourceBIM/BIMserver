/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcAnnotationFillAreaOccurrence;
import org.bimserver.models.ifc2x3.IfcGlobalOrLocalEnum;
import org.bimserver.models.ifc2x3.IfcPoint;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Annotation Fill Area Occurrence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAnnotationFillAreaOccurrenceImpl#getFillStyleTarget <em>Fill Style Target</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAnnotationFillAreaOccurrenceImpl#getGlobalOrLocal <em>Global Or Local</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcAnnotationFillAreaOccurrenceImpl extends IfcAnnotationOccurrenceImpl implements IfcAnnotationFillAreaOccurrence {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcAnnotationFillAreaOccurrenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcAnnotationFillAreaOccurrence();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPoint getFillStyleTarget() {
		return (IfcPoint)eGet(Ifc2x3Package.eINSTANCE.getIfcAnnotationFillAreaOccurrence_FillStyleTarget(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFillStyleTarget(IfcPoint newFillStyleTarget) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcAnnotationFillAreaOccurrence_FillStyleTarget(), newFillStyleTarget);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFillStyleTarget() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcAnnotationFillAreaOccurrence_FillStyleTarget());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFillStyleTarget() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcAnnotationFillAreaOccurrence_FillStyleTarget());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGlobalOrLocalEnum getGlobalOrLocal() {
		return (IfcGlobalOrLocalEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcAnnotationFillAreaOccurrence_GlobalOrLocal(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGlobalOrLocal(IfcGlobalOrLocalEnum newGlobalOrLocal) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcAnnotationFillAreaOccurrence_GlobalOrLocal(), newGlobalOrLocal);
	}

} //IfcAnnotationFillAreaOccurrenceImpl
