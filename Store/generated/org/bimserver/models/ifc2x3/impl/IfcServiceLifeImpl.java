/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcServiceLife;
import org.bimserver.models.ifc2x3.IfcServiceLifeTypeEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Service Life</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcServiceLifeImpl#getServiceLifeType <em>Service Life Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcServiceLifeImpl#getServiceLifeDuration <em>Service Life Duration</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcServiceLifeImpl#getServiceLifeDurationAsString <em>Service Life Duration As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcServiceLifeImpl extends IfcControlImpl implements IfcServiceLife {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcServiceLifeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcServiceLife();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcServiceLifeTypeEnum getServiceLifeType() {
		return (IfcServiceLifeTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcServiceLife_ServiceLifeType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceLifeType(IfcServiceLifeTypeEnum newServiceLifeType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcServiceLife_ServiceLifeType(), newServiceLifeType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getServiceLifeDuration() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcServiceLife_ServiceLifeDuration(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceLifeDuration(float newServiceLifeDuration) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcServiceLife_ServiceLifeDuration(), newServiceLifeDuration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceLifeDurationAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcServiceLife_ServiceLifeDurationAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceLifeDurationAsString(String newServiceLifeDurationAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcServiceLife_ServiceLifeDurationAsString(), newServiceLifeDurationAsString);
	}

} //IfcServiceLifeImpl
