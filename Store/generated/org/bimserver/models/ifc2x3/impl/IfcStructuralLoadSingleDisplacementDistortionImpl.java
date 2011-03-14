/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacementDistortion;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Load Single Displacement Distortion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadSingleDisplacementDistortionImpl#getDistortion <em>Distortion</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadSingleDisplacementDistortionImpl#getDistortionAsString <em>Distortion As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcStructuralLoadSingleDisplacementDistortionImpl extends IfcStructuralLoadSingleDisplacementImpl implements IfcStructuralLoadSingleDisplacementDistortion {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralLoadSingleDisplacementDistortionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacementDistortion();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDistortion() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacementDistortion_Distortion(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistortion(float newDistortion) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacementDistortion_Distortion(), newDistortion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDistortion() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacementDistortion_Distortion());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDistortion() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacementDistortion_Distortion());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDistortionAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacementDistortion_DistortionAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistortionAsString(String newDistortionAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacementDistortion_DistortionAsString(), newDistortionAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDistortionAsString() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacementDistortion_DistortionAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDistortionAsString() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacementDistortion_DistortionAsString());
	}

} //IfcStructuralLoadSingleDisplacementDistortionImpl
