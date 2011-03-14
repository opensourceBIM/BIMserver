/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcClassification;
import org.bimserver.models.ifc2x3.IfcClassificationReference;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Classification Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcClassificationReferenceImpl#getReferencedSource <em>Referenced Source</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcClassificationReferenceImpl extends IfcExternalReferenceImpl implements IfcClassificationReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcClassificationReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcClassificationReference();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcClassification getReferencedSource() {
		return (IfcClassification)eGet(Ifc2x3Package.eINSTANCE.getIfcClassificationReference_ReferencedSource(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferencedSource(IfcClassification newReferencedSource) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcClassificationReference_ReferencedSource(), newReferencedSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetReferencedSource() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcClassificationReference_ReferencedSource());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetReferencedSource() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcClassificationReference_ReferencedSource());
	}

} //IfcClassificationReferenceImpl
