/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcQuantityVolume;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Quantity Volume</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcQuantityVolumeImpl#getVolumeValue <em>Volume Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcQuantityVolumeImpl#getVolumeValueAsString <em>Volume Value As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcQuantityVolumeImpl extends IfcPhysicalSimpleQuantityImpl implements IfcQuantityVolume {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcQuantityVolumeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcQuantityVolume();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getVolumeValue() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcQuantityVolume_VolumeValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVolumeValue(float newVolumeValue) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcQuantityVolume_VolumeValue(), newVolumeValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVolumeValueAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcQuantityVolume_VolumeValueAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVolumeValueAsString(String newVolumeValueAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcQuantityVolume_VolumeValueAsString(), newVolumeValueAsString);
	}

} //IfcQuantityVolumeImpl
