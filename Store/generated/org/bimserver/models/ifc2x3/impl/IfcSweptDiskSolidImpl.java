/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcCurve;
import org.bimserver.models.ifc2x3.IfcSweptDiskSolid;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Swept Disk Solid</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSweptDiskSolidImpl#getDirectrix <em>Directrix</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSweptDiskSolidImpl#getRadius <em>Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSweptDiskSolidImpl#getRadiusAsString <em>Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSweptDiskSolidImpl#getInnerRadius <em>Inner Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSweptDiskSolidImpl#getInnerRadiusAsString <em>Inner Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSweptDiskSolidImpl#getStartParam <em>Start Param</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSweptDiskSolidImpl#getStartParamAsString <em>Start Param As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSweptDiskSolidImpl#getEndParam <em>End Param</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSweptDiskSolidImpl#getEndParamAsString <em>End Param As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcSweptDiskSolidImpl extends IfcSolidModelImpl implements IfcSweptDiskSolid {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSweptDiskSolidImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcSweptDiskSolid();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurve getDirectrix() {
		return (IfcCurve)eGet(Ifc2x3Package.eINSTANCE.getIfcSweptDiskSolid_Directrix(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirectrix(IfcCurve newDirectrix) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSweptDiskSolid_Directrix(), newDirectrix);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRadius() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcSweptDiskSolid_Radius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRadius(float newRadius) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSweptDiskSolid_Radius(), newRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRadiusAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcSweptDiskSolid_RadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRadiusAsString(String newRadiusAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSweptDiskSolid_RadiusAsString(), newRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getInnerRadius() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcSweptDiskSolid_InnerRadius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInnerRadius(float newInnerRadius) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSweptDiskSolid_InnerRadius(), newInnerRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInnerRadius() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSweptDiskSolid_InnerRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInnerRadius() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSweptDiskSolid_InnerRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInnerRadiusAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcSweptDiskSolid_InnerRadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInnerRadiusAsString(String newInnerRadiusAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSweptDiskSolid_InnerRadiusAsString(), newInnerRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInnerRadiusAsString() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSweptDiskSolid_InnerRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInnerRadiusAsString() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSweptDiskSolid_InnerRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getStartParam() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcSweptDiskSolid_StartParam(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartParam(float newStartParam) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSweptDiskSolid_StartParam(), newStartParam);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStartParamAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcSweptDiskSolid_StartParamAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartParamAsString(String newStartParamAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSweptDiskSolid_StartParamAsString(), newStartParamAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getEndParam() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcSweptDiskSolid_EndParam(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndParam(float newEndParam) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSweptDiskSolid_EndParam(), newEndParam);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEndParamAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcSweptDiskSolid_EndParamAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndParamAsString(String newEndParamAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSweptDiskSolid_EndParamAsString(), newEndParamAsString);
	}

} //IfcSweptDiskSolidImpl
