/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcCartesianPoint;
import org.bimserver.models.ifc2x3.IfcLine;
import org.bimserver.models.ifc2x3.IfcVector;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Line</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLineImpl#getPnt <em>Pnt</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLineImpl#getDir <em>Dir</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcLineImpl extends IfcCurveImpl implements IfcLine {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcLineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcLine();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCartesianPoint getPnt() {
		return (IfcCartesianPoint)eGet(Ifc2x3Package.eINSTANCE.getIfcLine_Pnt(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPnt(IfcCartesianPoint newPnt) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcLine_Pnt(), newPnt);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcVector getDir() {
		return (IfcVector)eGet(Ifc2x3Package.eINSTANCE.getIfcLine_Dir(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDir(IfcVector newDir) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcLine_Dir(), newDir);
	}

} //IfcLineImpl
