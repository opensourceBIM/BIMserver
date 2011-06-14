/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcTendon;
import org.bimserver.models.ifc2x3.IfcTendonTypeEnum;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Tendon</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTendonImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTendonImpl#getNominalDiameter <em>Nominal Diameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTendonImpl#getNominalDiameterAsString <em>Nominal Diameter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTendonImpl#getCrossSectionArea <em>Cross Section Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTendonImpl#getCrossSectionAreaAsString <em>Cross Section Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTendonImpl#getTensionForce <em>Tension Force</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTendonImpl#getTensionForceAsString <em>Tension Force As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTendonImpl#getPreStress <em>Pre Stress</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTendonImpl#getPreStressAsString <em>Pre Stress As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTendonImpl#getFrictionCoefficient <em>Friction Coefficient</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTendonImpl#getFrictionCoefficientAsString <em>Friction Coefficient As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTendonImpl#getAnchorageSlip <em>Anchorage Slip</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTendonImpl#getAnchorageSlipAsString <em>Anchorage Slip As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTendonImpl#getMinCurvatureRadius <em>Min Curvature Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTendonImpl#getMinCurvatureRadiusAsString <em>Min Curvature Radius As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcTendonImpl extends IfcReinforcingElementImpl implements IfcTendon
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTendonImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return Ifc2x3Package.eINSTANCE.getIfcTendon();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTendonTypeEnum getPredefinedType()
	{
		return (IfcTendonTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcTendon_PredefinedType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcTendonTypeEnum newPredefinedType)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTendon_PredefinedType(), newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getNominalDiameter()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcTendon_NominalDiameter(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNominalDiameter(float newNominalDiameter)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTendon_NominalDiameter(), newNominalDiameter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNominalDiameterAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTendon_NominalDiameterAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNominalDiameterAsString(String newNominalDiameterAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTendon_NominalDiameterAsString(), newNominalDiameterAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCrossSectionArea()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcTendon_CrossSectionArea(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCrossSectionArea(float newCrossSectionArea)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTendon_CrossSectionArea(), newCrossSectionArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCrossSectionAreaAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTendon_CrossSectionAreaAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCrossSectionAreaAsString(String newCrossSectionAreaAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTendon_CrossSectionAreaAsString(), newCrossSectionAreaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTensionForce()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcTendon_TensionForce(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTensionForce(float newTensionForce)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTendon_TensionForce(), newTensionForce);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTensionForce()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTendon_TensionForce());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTensionForce()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTendon_TensionForce());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTensionForceAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTendon_TensionForceAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTensionForceAsString(String newTensionForceAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTendon_TensionForceAsString(), newTensionForceAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTensionForceAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTendon_TensionForceAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTensionForceAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTendon_TensionForceAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getPreStress()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcTendon_PreStress(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreStress(float newPreStress)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTendon_PreStress(), newPreStress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPreStress()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTendon_PreStress());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPreStress()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTendon_PreStress());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPreStressAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTendon_PreStressAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreStressAsString(String newPreStressAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTendon_PreStressAsString(), newPreStressAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPreStressAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTendon_PreStressAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPreStressAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTendon_PreStressAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFrictionCoefficient()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcTendon_FrictionCoefficient(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrictionCoefficient(float newFrictionCoefficient)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTendon_FrictionCoefficient(), newFrictionCoefficient);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFrictionCoefficient()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTendon_FrictionCoefficient());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFrictionCoefficient()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTendon_FrictionCoefficient());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFrictionCoefficientAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTendon_FrictionCoefficientAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrictionCoefficientAsString(String newFrictionCoefficientAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTendon_FrictionCoefficientAsString(), newFrictionCoefficientAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFrictionCoefficientAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTendon_FrictionCoefficientAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFrictionCoefficientAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTendon_FrictionCoefficientAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getAnchorageSlip()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcTendon_AnchorageSlip(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnchorageSlip(float newAnchorageSlip)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTendon_AnchorageSlip(), newAnchorageSlip);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAnchorageSlip()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTendon_AnchorageSlip());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAnchorageSlip()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTendon_AnchorageSlip());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAnchorageSlipAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTendon_AnchorageSlipAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnchorageSlipAsString(String newAnchorageSlipAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTendon_AnchorageSlipAsString(), newAnchorageSlipAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAnchorageSlipAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTendon_AnchorageSlipAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAnchorageSlipAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTendon_AnchorageSlipAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMinCurvatureRadius()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcTendon_MinCurvatureRadius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinCurvatureRadius(float newMinCurvatureRadius)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTendon_MinCurvatureRadius(), newMinCurvatureRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinCurvatureRadius()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTendon_MinCurvatureRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinCurvatureRadius()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTendon_MinCurvatureRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinCurvatureRadiusAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTendon_MinCurvatureRadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinCurvatureRadiusAsString(String newMinCurvatureRadiusAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTendon_MinCurvatureRadiusAsString(), newMinCurvatureRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinCurvatureRadiusAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTendon_MinCurvatureRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinCurvatureRadiusAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTendon_MinCurvatureRadiusAsString());
	}

} //IfcTendonImpl
