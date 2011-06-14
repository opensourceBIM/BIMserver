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
import org.bimserver.models.ifc2x3.IfcMeasureValue;
import org.bimserver.models.ifc2x3.IfcServiceLifeFactor;
import org.bimserver.models.ifc2x3.IfcServiceLifeFactorTypeEnum;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Service Life Factor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcServiceLifeFactorImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcServiceLifeFactorImpl#getUpperValue <em>Upper Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcServiceLifeFactorImpl#getMostUsedValue <em>Most Used Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcServiceLifeFactorImpl#getLowerValue <em>Lower Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcServiceLifeFactorImpl extends IfcPropertySetDefinitionImpl implements IfcServiceLifeFactor
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcServiceLifeFactorImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcServiceLifeFactor();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcServiceLifeFactorTypeEnum getPredefinedType()
	{
		return (IfcServiceLifeFactorTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcServiceLifeFactor_PredefinedType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcServiceLifeFactorTypeEnum newPredefinedType)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcServiceLifeFactor_PredefinedType(), newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMeasureValue getUpperValue()
	{
		return (IfcMeasureValue)eGet(Ifc2x3Package.eINSTANCE.getIfcServiceLifeFactor_UpperValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperValue(IfcMeasureValue newUpperValue)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcServiceLifeFactor_UpperValue(), newUpperValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUpperValue()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcServiceLifeFactor_UpperValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUpperValue()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcServiceLifeFactor_UpperValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMeasureValue getMostUsedValue()
	{
		return (IfcMeasureValue)eGet(Ifc2x3Package.eINSTANCE.getIfcServiceLifeFactor_MostUsedValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMostUsedValue(IfcMeasureValue newMostUsedValue)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcServiceLifeFactor_MostUsedValue(), newMostUsedValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMeasureValue getLowerValue()
	{
		return (IfcMeasureValue)eGet(Ifc2x3Package.eINSTANCE.getIfcServiceLifeFactor_LowerValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerValue(IfcMeasureValue newLowerValue)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcServiceLifeFactor_LowerValue(), newLowerValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLowerValue()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcServiceLifeFactor_LowerValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLowerValue()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcServiceLifeFactor_LowerValue());
	}

} //IfcServiceLifeFactorImpl
