/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcPile;
import org.bimserver.models.ifc2x3.IfcPileConstructionEnum;
import org.bimserver.models.ifc2x3.IfcPileTypeEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Pile</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPileImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPileImpl#getConstructionType <em>Construction Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcPileImpl extends IfcBuildingElementImpl implements IfcPile {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcPile();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPileTypeEnum getPredefinedType() {
		return (IfcPileTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcPile_PredefinedType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcPileTypeEnum newPredefinedType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcPile_PredefinedType(), newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPileConstructionEnum getConstructionType() {
		return (IfcPileConstructionEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcPile_ConstructionType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstructionType(IfcPileConstructionEnum newConstructionType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcPile_ConstructionType(), newConstructionType);
	}

} //IfcPileImpl
