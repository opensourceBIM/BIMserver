/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcInternalOrExternalEnum;
import org.bimserver.models.ifc2x3.IfcRelCoversSpaces;
import org.bimserver.models.ifc2x3.IfcRelSpaceBoundary;
import org.bimserver.models.ifc2x3.IfcSpace;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Space</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpaceImpl#getInteriorOrExteriorSpace <em>Interior Or Exterior Space</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpaceImpl#getElevationWithFlooring <em>Elevation With Flooring</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpaceImpl#getElevationWithFlooringAsString <em>Elevation With Flooring As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpaceImpl#getHasCoverings <em>Has Coverings</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpaceImpl#getBoundedBy <em>Bounded By</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcSpaceImpl extends IfcSpatialStructureElementImpl implements IfcSpace {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSpaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcSpace();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcInternalOrExternalEnum getInteriorOrExteriorSpace() {
		return (IfcInternalOrExternalEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcSpace_InteriorOrExteriorSpace(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInteriorOrExteriorSpace(IfcInternalOrExternalEnum newInteriorOrExteriorSpace) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSpace_InteriorOrExteriorSpace(), newInteriorOrExteriorSpace);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getElevationWithFlooring() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcSpace_ElevationWithFlooring(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElevationWithFlooring(float newElevationWithFlooring) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSpace_ElevationWithFlooring(), newElevationWithFlooring);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetElevationWithFlooring() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSpace_ElevationWithFlooring());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetElevationWithFlooring() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSpace_ElevationWithFlooring());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getElevationWithFlooringAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcSpace_ElevationWithFlooringAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElevationWithFlooringAsString(String newElevationWithFlooringAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSpace_ElevationWithFlooringAsString(), newElevationWithFlooringAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetElevationWithFlooringAsString() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSpace_ElevationWithFlooringAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetElevationWithFlooringAsString() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSpace_ElevationWithFlooringAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelCoversSpaces> getHasCoverings() {
		return (EList<IfcRelCoversSpaces>)eGet(Ifc2x3Package.eINSTANCE.getIfcSpace_HasCoverings(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelSpaceBoundary> getBoundedBy() {
		return (EList<IfcRelSpaceBoundary>)eGet(Ifc2x3Package.eINSTANCE.getIfcSpace_BoundedBy(), true);
	}

} //IfcSpaceImpl
