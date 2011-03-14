/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcAxis2Placement;
import org.bimserver.models.ifc2x3.IfcTextLiteral;
import org.bimserver.models.ifc2x3.IfcTextPath;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Text Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextLiteralImpl#getLiteral <em>Literal</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextLiteralImpl#getPlacement <em>Placement</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextLiteralImpl#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcTextLiteralImpl extends IfcGeometricRepresentationItemImpl implements IfcTextLiteral {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTextLiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcTextLiteral();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTextLiteral_Literal(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiteral(String newLiteral) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextLiteral_Literal(), newLiteral);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAxis2Placement getPlacement() {
		return (IfcAxis2Placement)eGet(Ifc2x3Package.eINSTANCE.getIfcTextLiteral_Placement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlacement(IfcAxis2Placement newPlacement) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextLiteral_Placement(), newPlacement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTextPath getPath() {
		return (IfcTextPath)eGet(Ifc2x3Package.eINSTANCE.getIfcTextLiteral_Path(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(IfcTextPath newPath) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextLiteral_Path(), newPath);
	}

} //IfcTextLiteralImpl
