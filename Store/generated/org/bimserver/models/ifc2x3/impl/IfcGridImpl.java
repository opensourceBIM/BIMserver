/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcGrid;
import org.bimserver.models.ifc2x3.IfcGridAxis;
import org.bimserver.models.ifc2x3.IfcRelContainedInSpatialStructure;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Grid</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGridImpl#getUAxes <em>UAxes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGridImpl#getVAxes <em>VAxes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGridImpl#getWAxes <em>WAxes</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGridImpl#getContainedInStructure <em>Contained In Structure</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcGridImpl extends IfcProductImpl implements IfcGrid {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcGridImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcGrid();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcGridAxis> getUAxes() {
		return (EList<IfcGridAxis>)eGet(Ifc2x3Package.eINSTANCE.getIfcGrid_UAxes(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcGridAxis> getVAxes() {
		return (EList<IfcGridAxis>)eGet(Ifc2x3Package.eINSTANCE.getIfcGrid_VAxes(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcGridAxis> getWAxes() {
		return (EList<IfcGridAxis>)eGet(Ifc2x3Package.eINSTANCE.getIfcGrid_WAxes(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWAxes() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcGrid_WAxes());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWAxes() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcGrid_WAxes());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelContainedInSpatialStructure> getContainedInStructure() {
		return (EList<IfcRelContainedInSpatialStructure>)eGet(Ifc2x3Package.eINSTANCE.getIfcGrid_ContainedInStructure(), true);
	}

} //IfcGridImpl
