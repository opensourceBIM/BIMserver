/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcEllipse;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Ellipse</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEllipseImpl#getSemiAxis1 <em>Semi Axis1</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEllipseImpl#getSemiAxis1AsString <em>Semi Axis1 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEllipseImpl#getSemiAxis2 <em>Semi Axis2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEllipseImpl#getSemiAxis2AsString <em>Semi Axis2 As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcEllipseImpl extends IfcConicImpl implements IfcEllipse {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcEllipseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcEllipse();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSemiAxis1() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcEllipse_SemiAxis1(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemiAxis1(float newSemiAxis1) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcEllipse_SemiAxis1(), newSemiAxis1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSemiAxis1AsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcEllipse_SemiAxis1AsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemiAxis1AsString(String newSemiAxis1AsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcEllipse_SemiAxis1AsString(), newSemiAxis1AsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSemiAxis2() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcEllipse_SemiAxis2(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemiAxis2(float newSemiAxis2) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcEllipse_SemiAxis2(), newSemiAxis2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSemiAxis2AsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcEllipse_SemiAxis2AsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemiAxis2AsString(String newSemiAxis2AsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcEllipse_SemiAxis2AsString(), newSemiAxis2AsString);
	}

} //IfcEllipseImpl
