/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcElementCompositionEnum;
import org.bimserver.models.ifc2x3.IfcRelContainedInSpatialStructure;
import org.bimserver.models.ifc2x3.IfcRelReferencedInSpatialStructure;
import org.bimserver.models.ifc2x3.IfcRelServicesBuildings;
import org.bimserver.models.ifc2x3.IfcSpatialStructureElement;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Spatial Structure Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpatialStructureElementImpl#getLongName <em>Long Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpatialStructureElementImpl#getCompositionType <em>Composition Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpatialStructureElementImpl#getReferencesElements <em>References Elements</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpatialStructureElementImpl#getServicedBySystems <em>Serviced By Systems</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpatialStructureElementImpl#getContainsElements <em>Contains Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcSpatialStructureElementImpl extends IfcProductImpl implements IfcSpatialStructureElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSpatialStructureElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcSpatialStructureElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLongName() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcSpatialStructureElement_LongName(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongName(String newLongName) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSpatialStructureElement_LongName(), newLongName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLongName() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSpatialStructureElement_LongName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLongName() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSpatialStructureElement_LongName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElementCompositionEnum getCompositionType() {
		return (IfcElementCompositionEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcSpatialStructureElement_CompositionType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompositionType(IfcElementCompositionEnum newCompositionType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSpatialStructureElement_CompositionType(), newCompositionType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelReferencedInSpatialStructure> getReferencesElements() {
		return (EList<IfcRelReferencedInSpatialStructure>)eGet(Ifc2x3Package.eINSTANCE.getIfcSpatialStructureElement_ReferencesElements(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelServicesBuildings> getServicedBySystems() {
		return (EList<IfcRelServicesBuildings>)eGet(Ifc2x3Package.eINSTANCE.getIfcSpatialStructureElement_ServicedBySystems(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelContainedInSpatialStructure> getContainsElements() {
		return (EList<IfcRelContainedInSpatialStructure>)eGet(Ifc2x3Package.eINSTANCE.getIfcSpatialStructureElement_ContainsElements(), true);
	}

} //IfcSpatialStructureElementImpl
