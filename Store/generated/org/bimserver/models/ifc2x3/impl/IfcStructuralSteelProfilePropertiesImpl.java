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
import org.bimserver.models.ifc2x3.IfcStructuralSteelProfileProperties;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Steel Profile Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralSteelProfilePropertiesImpl#getShearAreaZ <em>Shear Area Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralSteelProfilePropertiesImpl#getShearAreaZAsString <em>Shear Area ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralSteelProfilePropertiesImpl#getShearAreaY <em>Shear Area Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralSteelProfilePropertiesImpl#getShearAreaYAsString <em>Shear Area YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralSteelProfilePropertiesImpl#getPlasticShapeFactorY <em>Plastic Shape Factor Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralSteelProfilePropertiesImpl#getPlasticShapeFactorYAsString <em>Plastic Shape Factor YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralSteelProfilePropertiesImpl#getPlasticShapeFactorZ <em>Plastic Shape Factor Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralSteelProfilePropertiesImpl#getPlasticShapeFactorZAsString <em>Plastic Shape Factor ZAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcStructuralSteelProfilePropertiesImpl extends IfcStructuralProfilePropertiesImpl implements IfcStructuralSteelProfileProperties
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralSteelProfilePropertiesImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getShearAreaZ()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_ShearAreaZ(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearAreaZ(float newShearAreaZ)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_ShearAreaZ(), newShearAreaZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearAreaZ()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_ShearAreaZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearAreaZ()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_ShearAreaZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShearAreaZAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_ShearAreaZAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearAreaZAsString(String newShearAreaZAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_ShearAreaZAsString(), newShearAreaZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearAreaZAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_ShearAreaZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearAreaZAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_ShearAreaZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getShearAreaY()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_ShearAreaY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearAreaY(float newShearAreaY)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_ShearAreaY(), newShearAreaY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearAreaY()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_ShearAreaY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearAreaY()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_ShearAreaY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShearAreaYAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_ShearAreaYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearAreaYAsString(String newShearAreaYAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_ShearAreaYAsString(), newShearAreaYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearAreaYAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_ShearAreaYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearAreaYAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_ShearAreaYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getPlasticShapeFactorY()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_PlasticShapeFactorY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlasticShapeFactorY(float newPlasticShapeFactorY)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_PlasticShapeFactorY(), newPlasticShapeFactorY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPlasticShapeFactorY()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_PlasticShapeFactorY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlasticShapeFactorY()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_PlasticShapeFactorY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPlasticShapeFactorYAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_PlasticShapeFactorYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlasticShapeFactorYAsString(String newPlasticShapeFactorYAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_PlasticShapeFactorYAsString(), newPlasticShapeFactorYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPlasticShapeFactorYAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_PlasticShapeFactorYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlasticShapeFactorYAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_PlasticShapeFactorYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getPlasticShapeFactorZ()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_PlasticShapeFactorZ(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlasticShapeFactorZ(float newPlasticShapeFactorZ)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_PlasticShapeFactorZ(), newPlasticShapeFactorZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPlasticShapeFactorZ()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_PlasticShapeFactorZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlasticShapeFactorZ()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_PlasticShapeFactorZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPlasticShapeFactorZAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_PlasticShapeFactorZAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlasticShapeFactorZAsString(String newPlasticShapeFactorZAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_PlasticShapeFactorZAsString(), newPlasticShapeFactorZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPlasticShapeFactorZAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_PlasticShapeFactorZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlasticShapeFactorZAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralSteelProfileProperties_PlasticShapeFactorZAsString());
	}

} //IfcStructuralSteelProfilePropertiesImpl
