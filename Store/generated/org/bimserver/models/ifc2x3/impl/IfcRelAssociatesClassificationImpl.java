/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcClassificationNotationSelect;
import org.bimserver.models.ifc2x3.IfcRelAssociatesClassification;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Associates Classification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelAssociatesClassificationImpl#getRelatingClassification <em>Relating Classification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelAssociatesClassificationImpl extends IfcRelAssociatesImpl implements IfcRelAssociatesClassification {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelAssociatesClassificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRelAssociatesClassification();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcClassificationNotationSelect getRelatingClassification() {
		return (IfcClassificationNotationSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcRelAssociatesClassification_RelatingClassification(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingClassification(IfcClassificationNotationSelect newRelatingClassification) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelAssociatesClassification_RelatingClassification(), newRelatingClassification);
	}

} //IfcRelAssociatesClassificationImpl
