/**
 * Copyright (C) 2009-2014 BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc4x3.impl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcReinforcingBar;
import org.bimserver.models.ifc4x3.IfcReinforcingBarSurfaceEnum;
import org.bimserver.models.ifc4x3.IfcReinforcingBarTypeEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Reinforcing Bar</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingBarImpl#getNominalDiameter <em>Nominal Diameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingBarImpl#getNominalDiameterAsString <em>Nominal Diameter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingBarImpl#getCrossSectionArea <em>Cross Section Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingBarImpl#getCrossSectionAreaAsString <em>Cross Section Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingBarImpl#getBarLength <em>Bar Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingBarImpl#getBarLengthAsString <em>Bar Length As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingBarImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcReinforcingBarImpl#getBarSurface <em>Bar Surface</em>}</li>
 * </ul>
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
		return Ifc4x3Package.eINSTANCE.getIfcReinforcingBar();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getNominalDiameter() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_NominalDiameter(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNominalDiameter(double newNominalDiameter) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_NominalDiameter(), newNominalDiameter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetNominalDiameter() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_NominalDiameter());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetNominalDiameter() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_NominalDiameter());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNominalDiameterAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_NominalDiameterAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNominalDiameterAsString(String newNominalDiameterAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_NominalDiameterAsString(), newNominalDiameterAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetNominalDiameterAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_NominalDiameterAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetNominalDiameterAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_NominalDiameterAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getCrossSectionArea() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_CrossSectionArea(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCrossSectionArea(double newCrossSectionArea) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_CrossSectionArea(), newCrossSectionArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCrossSectionArea() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_CrossSectionArea());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCrossSectionArea() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_CrossSectionArea());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCrossSectionAreaAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_CrossSectionAreaAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCrossSectionAreaAsString(String newCrossSectionAreaAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_CrossSectionAreaAsString(), newCrossSectionAreaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetCrossSectionAreaAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_CrossSectionAreaAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetCrossSectionAreaAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_CrossSectionAreaAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getBarLength() {
		return (Double) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_BarLength(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBarLength(double newBarLength) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_BarLength(), newBarLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBarLength() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_BarLength());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBarLength() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_BarLength());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBarLengthAsString() {
		return (String) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_BarLengthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBarLengthAsString(String newBarLengthAsString) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_BarLengthAsString(), newBarLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBarLengthAsString() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_BarLengthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBarLengthAsString() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_BarLengthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcReinforcingBarTypeEnum getPredefinedType() {
		return (IfcReinforcingBarTypeEnum) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_PredefinedType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPredefinedType(IfcReinforcingBarTypeEnum newPredefinedType) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_PredefinedType(), newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetPredefinedType() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_PredefinedType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetPredefinedType() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_PredefinedType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfcReinforcingBarSurfaceEnum getBarSurface() {
		return (IfcReinforcingBarSurfaceEnum) eGet(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_BarSurface(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBarSurface(IfcReinforcingBarSurfaceEnum newBarSurface) {
		eSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_BarSurface(), newBarSurface);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBarSurface() {
		eUnset(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_BarSurface());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBarSurface() {
		return eIsSet(Ifc4x3Package.eINSTANCE.getIfcReinforcingBar_BarSurface());
	}

} //IfcReinforcingBarImpl
