/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcBuildingStorey;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Building Storey</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBuildingStoreyImpl#getElevation <em>Elevation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcBuildingStoreyImpl#getElevationAsString <em>Elevation As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcBuildingStoreyImpl extends IfcSpatialStructureElementImpl implements IfcBuildingStorey {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcBuildingStoreyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcBuildingStorey();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getElevation() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcBuildingStorey_Elevation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElevation(float newElevation) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcBuildingStorey_Elevation(), newElevation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetElevation() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBuildingStorey_Elevation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetElevation() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBuildingStorey_Elevation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getElevationAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcBuildingStorey_ElevationAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElevationAsString(String newElevationAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcBuildingStorey_ElevationAsString(), newElevationAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetElevationAsString() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcBuildingStorey_ElevationAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetElevationAsString() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcBuildingStorey_ElevationAsString());
	}

} //IfcBuildingStoreyImpl
