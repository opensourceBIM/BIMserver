/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcRamp;
import org.bimserver.models.ifc2x3.IfcRampTypeEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Ramp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRampImpl#getShapeType <em>Shape Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRampImpl extends IfcBuildingElementImpl implements IfcRamp {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRampImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRamp();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRampTypeEnum getShapeType() {
		return (IfcRampTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcRamp_ShapeType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShapeType(IfcRampTypeEnum newShapeType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRamp_ShapeType(), newShapeType);
	}

} //IfcRampImpl
