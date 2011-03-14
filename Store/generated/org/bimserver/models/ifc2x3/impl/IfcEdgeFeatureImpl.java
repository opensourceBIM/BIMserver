/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcEdgeFeature;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Edge Feature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEdgeFeatureImpl#getFeatureLength <em>Feature Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEdgeFeatureImpl#getFeatureLengthAsString <em>Feature Length As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcEdgeFeatureImpl extends IfcFeatureElementSubtractionImpl implements IfcEdgeFeature {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcEdgeFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcEdgeFeature();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFeatureLength() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcEdgeFeature_FeatureLength(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureLength(float newFeatureLength) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcEdgeFeature_FeatureLength(), newFeatureLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFeatureLength() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcEdgeFeature_FeatureLength());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFeatureLength() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcEdgeFeature_FeatureLength());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFeatureLengthAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcEdgeFeature_FeatureLengthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureLengthAsString(String newFeatureLengthAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcEdgeFeature_FeatureLengthAsString(), newFeatureLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFeatureLengthAsString() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcEdgeFeature_FeatureLengthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFeatureLengthAsString() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcEdgeFeature_FeatureLengthAsString());
	}

} //IfcEdgeFeatureImpl
