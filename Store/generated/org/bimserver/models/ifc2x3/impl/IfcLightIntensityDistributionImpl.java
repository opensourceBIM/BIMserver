/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcLightDistributionCurveEnum;
import org.bimserver.models.ifc2x3.IfcLightDistributionData;
import org.bimserver.models.ifc2x3.IfcLightIntensityDistribution;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Light Intensity Distribution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightIntensityDistributionImpl#getLightDistributionCurve <em>Light Distribution Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightIntensityDistributionImpl#getDistributionData <em>Distribution Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcLightIntensityDistributionImpl extends IdEObjectImpl implements IfcLightIntensityDistribution {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcLightIntensityDistributionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcLightIntensityDistribution();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLightDistributionCurveEnum getLightDistributionCurve() {
		return (IfcLightDistributionCurveEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcLightIntensityDistribution_LightDistributionCurve(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLightDistributionCurve(IfcLightDistributionCurveEnum newLightDistributionCurve) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcLightIntensityDistribution_LightDistributionCurve(), newLightDistributionCurve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcLightDistributionData> getDistributionData() {
		return (EList<IfcLightDistributionData>)eGet(Ifc2x3Package.eINSTANCE.getIfcLightIntensityDistribution_DistributionData(), true);
	}

} //IfcLightIntensityDistributionImpl
