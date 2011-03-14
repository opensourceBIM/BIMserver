/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcReinforcingBar;
import org.bimserver.models.ifc2x3.IfcReinforcingBarRoleEnum;
import org.bimserver.models.ifc2x3.IfcReinforcingBarSurfaceEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Reinforcing Bar</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcingBarImpl#getNominalDiameter <em>Nominal Diameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcingBarImpl#getNominalDiameterAsString <em>Nominal Diameter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcingBarImpl#getCrossSectionArea <em>Cross Section Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcingBarImpl#getCrossSectionAreaAsString <em>Cross Section Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcingBarImpl#getBarLength <em>Bar Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcingBarImpl#getBarLengthAsString <em>Bar Length As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcingBarImpl#getBarRole <em>Bar Role</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcingBarImpl#getBarSurface <em>Bar Surface</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcReinforcingBarImpl extends IfcReinforcingElementImpl implements IfcReinforcingBar {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcReinforcingBarImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcReinforcingBar();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getNominalDiameter() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcingBar_NominalDiameter(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNominalDiameter(float newNominalDiameter) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingBar_NominalDiameter(), newNominalDiameter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNominalDiameterAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcingBar_NominalDiameterAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNominalDiameterAsString(String newNominalDiameterAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingBar_NominalDiameterAsString(), newNominalDiameterAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCrossSectionArea() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcingBar_CrossSectionArea(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCrossSectionArea(float newCrossSectionArea) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingBar_CrossSectionArea(), newCrossSectionArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCrossSectionAreaAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcingBar_CrossSectionAreaAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCrossSectionAreaAsString(String newCrossSectionAreaAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingBar_CrossSectionAreaAsString(), newCrossSectionAreaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getBarLength() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcingBar_BarLength(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBarLength(float newBarLength) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingBar_BarLength(), newBarLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBarLength() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcReinforcingBar_BarLength());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBarLength() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingBar_BarLength());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBarLengthAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcingBar_BarLengthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBarLengthAsString(String newBarLengthAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingBar_BarLengthAsString(), newBarLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBarLengthAsString() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcReinforcingBar_BarLengthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBarLengthAsString() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingBar_BarLengthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcReinforcingBarRoleEnum getBarRole() {
		return (IfcReinforcingBarRoleEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcingBar_BarRole(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBarRole(IfcReinforcingBarRoleEnum newBarRole) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingBar_BarRole(), newBarRole);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcReinforcingBarSurfaceEnum getBarSurface() {
		return (IfcReinforcingBarSurfaceEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcingBar_BarSurface(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBarSurface(IfcReinforcingBarSurfaceEnum newBarSurface) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingBar_BarSurface(), newBarSurface);
	}

} //IfcReinforcingBarImpl
