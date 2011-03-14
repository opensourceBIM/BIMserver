/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcBuildingElementProxyType;
import org.bimserver.models.ifc2x3.IfcBuildingElementProxyTypeEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Building Element Proxy Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBuildingElementProxyTypeImpl#getPredefinedType <em>Predefined Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcBuildingElementProxyTypeImpl extends IfcBuildingElementTypeImpl implements IfcBuildingElementProxyType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcBuildingElementProxyTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcBuildingElementProxyType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcBuildingElementProxyTypeEnum getPredefinedType() {
		return (IfcBuildingElementProxyTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcBuildingElementProxyType_PredefinedType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcBuildingElementProxyTypeEnum newPredefinedType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcBuildingElementProxyType_PredefinedType(), newPredefinedType);
	}

} //IfcBuildingElementProxyTypeImpl
