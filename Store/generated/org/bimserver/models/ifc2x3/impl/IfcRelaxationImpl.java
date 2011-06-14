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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcRelaxation;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Relaxation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelaxationImpl#getRelaxationValue <em>Relaxation Value</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelaxationImpl#getRelaxationValueAsString <em>Relaxation Value As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelaxationImpl#getInitialStress <em>Initial Stress</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelaxationImpl#getInitialStressAsString <em>Initial Stress As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelaxationImpl extends IdEObjectImpl implements IfcRelaxation
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelaxationImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcRelaxation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount()
	{
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRelaxationValue()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRelaxation_RelaxationValue(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelaxationValue(float newRelaxationValue)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelaxation_RelaxationValue(), newRelaxationValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRelaxationValueAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRelaxation_RelaxationValueAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelaxationValueAsString(String newRelaxationValueAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelaxation_RelaxationValueAsString(), newRelaxationValueAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getInitialStress()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRelaxation_InitialStress(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialStress(float newInitialStress)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelaxation_InitialStress(), newInitialStress);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInitialStressAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRelaxation_InitialStressAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialStressAsString(String newInitialStressAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelaxation_InitialStressAsString(), newInitialStressAsString);
	}

} //IfcRelaxationImpl
