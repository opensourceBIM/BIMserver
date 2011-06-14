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
import org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacementDistortion;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Load Single Displacement Distortion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadSingleDisplacementDistortionImpl#getDistortion <em>Distortion</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadSingleDisplacementDistortionImpl#getDistortionAsString <em>Distortion As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcStructuralLoadSingleDisplacementDistortionImpl extends IfcStructuralLoadSingleDisplacementImpl implements IfcStructuralLoadSingleDisplacementDistortion
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralLoadSingleDisplacementDistortionImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacementDistortion();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDistortion()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacementDistortion_Distortion(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistortion(float newDistortion)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacementDistortion_Distortion(), newDistortion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDistortion()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacementDistortion_Distortion());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDistortion()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacementDistortion_Distortion());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDistortionAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacementDistortion_DistortionAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistortionAsString(String newDistortionAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacementDistortion_DistortionAsString(), newDistortionAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDistortionAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacementDistortion_DistortionAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDistortionAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacementDistortion_DistortionAsString());
	}

} //IfcStructuralLoadSingleDisplacementDistortionImpl
