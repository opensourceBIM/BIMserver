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
import org.bimserver.models.ifc2x3.IfcEnergyProperties;
import org.bimserver.models.ifc2x3.IfcEnergySequenceEnum;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Energy Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEnergyPropertiesImpl#getEnergySequence <em>Energy Sequence</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEnergyPropertiesImpl#getUserDefinedEnergySequence <em>User Defined Energy Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcEnergyPropertiesImpl extends IfcPropertySetDefinitionImpl implements IfcEnergyProperties
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcEnergyPropertiesImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcEnergyProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcEnergySequenceEnum getEnergySequence()
	{
		return (IfcEnergySequenceEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcEnergyProperties_EnergySequence(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnergySequence(IfcEnergySequenceEnum newEnergySequence)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcEnergyProperties_EnergySequence(), newEnergySequence);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserDefinedEnergySequence()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcEnergyProperties_UserDefinedEnergySequence(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserDefinedEnergySequence(String newUserDefinedEnergySequence)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcEnergyProperties_UserDefinedEnergySequence(), newUserDefinedEnergySequence);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserDefinedEnergySequence()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcEnergyProperties_UserDefinedEnergySequence());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserDefinedEnergySequence()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcEnergyProperties_UserDefinedEnergySequence());
	}

} //IfcEnergyPropertiesImpl
