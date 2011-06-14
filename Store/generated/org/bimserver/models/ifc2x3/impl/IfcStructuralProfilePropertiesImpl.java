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
import org.bimserver.models.ifc2x3.IfcStructuralProfileProperties;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Profile Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getTorsionalConstantX <em>Torsional Constant X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getTorsionalConstantXAsString <em>Torsional Constant XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getMomentOfInertiaYZ <em>Moment Of Inertia YZ</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getMomentOfInertiaYZAsString <em>Moment Of Inertia YZ As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getMomentOfInertiaY <em>Moment Of Inertia Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getMomentOfInertiaYAsString <em>Moment Of Inertia YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getMomentOfInertiaZ <em>Moment Of Inertia Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getMomentOfInertiaZAsString <em>Moment Of Inertia ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getWarpingConstant <em>Warping Constant</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getWarpingConstantAsString <em>Warping Constant As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getShearCentreZ <em>Shear Centre Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getShearCentreZAsString <em>Shear Centre ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getShearCentreY <em>Shear Centre Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getShearCentreYAsString <em>Shear Centre YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getShearDeformationAreaZ <em>Shear Deformation Area Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getShearDeformationAreaZAsString <em>Shear Deformation Area ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getShearDeformationAreaY <em>Shear Deformation Area Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getShearDeformationAreaYAsString <em>Shear Deformation Area YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getMaximumSectionModulusY <em>Maximum Section Modulus Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getMaximumSectionModulusYAsString <em>Maximum Section Modulus YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getMinimumSectionModulusY <em>Minimum Section Modulus Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getMinimumSectionModulusYAsString <em>Minimum Section Modulus YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getMaximumSectionModulusZ <em>Maximum Section Modulus Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getMaximumSectionModulusZAsString <em>Maximum Section Modulus ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getMinimumSectionModulusZ <em>Minimum Section Modulus Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getMinimumSectionModulusZAsString <em>Minimum Section Modulus ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getTorsionalSectionModulus <em>Torsional Section Modulus</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getTorsionalSectionModulusAsString <em>Torsional Section Modulus As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getCentreOfGravityInX <em>Centre Of Gravity In X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getCentreOfGravityInXAsString <em>Centre Of Gravity In XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getCentreOfGravityInY <em>Centre Of Gravity In Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralProfilePropertiesImpl#getCentreOfGravityInYAsString <em>Centre Of Gravity In YAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcStructuralProfilePropertiesImpl extends IfcGeneralProfilePropertiesImpl implements IfcStructuralProfileProperties
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralProfilePropertiesImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTorsionalConstantX()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_TorsionalConstantX(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTorsionalConstantX(float newTorsionalConstantX)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_TorsionalConstantX(), newTorsionalConstantX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTorsionalConstantX()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_TorsionalConstantX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTorsionalConstantX()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_TorsionalConstantX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTorsionalConstantXAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_TorsionalConstantXAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTorsionalConstantXAsString(String newTorsionalConstantXAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_TorsionalConstantXAsString(), newTorsionalConstantXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTorsionalConstantXAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_TorsionalConstantXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTorsionalConstantXAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_TorsionalConstantXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMomentOfInertiaYZ()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MomentOfInertiaYZ(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMomentOfInertiaYZ(float newMomentOfInertiaYZ)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MomentOfInertiaYZ(), newMomentOfInertiaYZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMomentOfInertiaYZ()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MomentOfInertiaYZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMomentOfInertiaYZ()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MomentOfInertiaYZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMomentOfInertiaYZAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MomentOfInertiaYZAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMomentOfInertiaYZAsString(String newMomentOfInertiaYZAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MomentOfInertiaYZAsString(), newMomentOfInertiaYZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMomentOfInertiaYZAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MomentOfInertiaYZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMomentOfInertiaYZAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MomentOfInertiaYZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMomentOfInertiaY()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MomentOfInertiaY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMomentOfInertiaY(float newMomentOfInertiaY)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MomentOfInertiaY(), newMomentOfInertiaY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMomentOfInertiaY()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MomentOfInertiaY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMomentOfInertiaY()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MomentOfInertiaY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMomentOfInertiaYAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MomentOfInertiaYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMomentOfInertiaYAsString(String newMomentOfInertiaYAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MomentOfInertiaYAsString(), newMomentOfInertiaYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMomentOfInertiaYAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MomentOfInertiaYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMomentOfInertiaYAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MomentOfInertiaYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMomentOfInertiaZ()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MomentOfInertiaZ(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMomentOfInertiaZ(float newMomentOfInertiaZ)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MomentOfInertiaZ(), newMomentOfInertiaZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMomentOfInertiaZ()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MomentOfInertiaZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMomentOfInertiaZ()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MomentOfInertiaZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMomentOfInertiaZAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MomentOfInertiaZAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMomentOfInertiaZAsString(String newMomentOfInertiaZAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MomentOfInertiaZAsString(), newMomentOfInertiaZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMomentOfInertiaZAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MomentOfInertiaZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMomentOfInertiaZAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MomentOfInertiaZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWarpingConstant()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_WarpingConstant(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWarpingConstant(float newWarpingConstant)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_WarpingConstant(), newWarpingConstant);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWarpingConstant()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_WarpingConstant());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWarpingConstant()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_WarpingConstant());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWarpingConstantAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_WarpingConstantAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWarpingConstantAsString(String newWarpingConstantAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_WarpingConstantAsString(), newWarpingConstantAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWarpingConstantAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_WarpingConstantAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWarpingConstantAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_WarpingConstantAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getShearCentreZ()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearCentreZ(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearCentreZ(float newShearCentreZ)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearCentreZ(), newShearCentreZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearCentreZ()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearCentreZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearCentreZ()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearCentreZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShearCentreZAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearCentreZAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearCentreZAsString(String newShearCentreZAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearCentreZAsString(), newShearCentreZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearCentreZAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearCentreZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearCentreZAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearCentreZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getShearCentreY()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearCentreY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearCentreY(float newShearCentreY)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearCentreY(), newShearCentreY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearCentreY()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearCentreY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearCentreY()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearCentreY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShearCentreYAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearCentreYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearCentreYAsString(String newShearCentreYAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearCentreYAsString(), newShearCentreYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearCentreYAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearCentreYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearCentreYAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearCentreYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getShearDeformationAreaZ()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearDeformationAreaZ(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearDeformationAreaZ(float newShearDeformationAreaZ)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearDeformationAreaZ(), newShearDeformationAreaZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearDeformationAreaZ()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearDeformationAreaZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearDeformationAreaZ()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearDeformationAreaZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShearDeformationAreaZAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearDeformationAreaZAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearDeformationAreaZAsString(String newShearDeformationAreaZAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearDeformationAreaZAsString(), newShearDeformationAreaZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearDeformationAreaZAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearDeformationAreaZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearDeformationAreaZAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearDeformationAreaZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getShearDeformationAreaY()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearDeformationAreaY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearDeformationAreaY(float newShearDeformationAreaY)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearDeformationAreaY(), newShearDeformationAreaY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearDeformationAreaY()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearDeformationAreaY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearDeformationAreaY()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearDeformationAreaY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShearDeformationAreaYAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearDeformationAreaYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShearDeformationAreaYAsString(String newShearDeformationAreaYAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearDeformationAreaYAsString(), newShearDeformationAreaYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShearDeformationAreaYAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearDeformationAreaYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShearDeformationAreaYAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_ShearDeformationAreaYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMaximumSectionModulusY()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MaximumSectionModulusY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumSectionModulusY(float newMaximumSectionModulusY)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MaximumSectionModulusY(), newMaximumSectionModulusY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaximumSectionModulusY()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MaximumSectionModulusY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaximumSectionModulusY()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MaximumSectionModulusY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaximumSectionModulusYAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MaximumSectionModulusYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumSectionModulusYAsString(String newMaximumSectionModulusYAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MaximumSectionModulusYAsString(), newMaximumSectionModulusYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaximumSectionModulusYAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MaximumSectionModulusYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaximumSectionModulusYAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MaximumSectionModulusYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMinimumSectionModulusY()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MinimumSectionModulusY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumSectionModulusY(float newMinimumSectionModulusY)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MinimumSectionModulusY(), newMinimumSectionModulusY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinimumSectionModulusY()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MinimumSectionModulusY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinimumSectionModulusY()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MinimumSectionModulusY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinimumSectionModulusYAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MinimumSectionModulusYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumSectionModulusYAsString(String newMinimumSectionModulusYAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MinimumSectionModulusYAsString(), newMinimumSectionModulusYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinimumSectionModulusYAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MinimumSectionModulusYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinimumSectionModulusYAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MinimumSectionModulusYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMaximumSectionModulusZ()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MaximumSectionModulusZ(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumSectionModulusZ(float newMaximumSectionModulusZ)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MaximumSectionModulusZ(), newMaximumSectionModulusZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaximumSectionModulusZ()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MaximumSectionModulusZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaximumSectionModulusZ()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MaximumSectionModulusZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaximumSectionModulusZAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MaximumSectionModulusZAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumSectionModulusZAsString(String newMaximumSectionModulusZAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MaximumSectionModulusZAsString(), newMaximumSectionModulusZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaximumSectionModulusZAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MaximumSectionModulusZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaximumSectionModulusZAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MaximumSectionModulusZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMinimumSectionModulusZ()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MinimumSectionModulusZ(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumSectionModulusZ(float newMinimumSectionModulusZ)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MinimumSectionModulusZ(), newMinimumSectionModulusZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinimumSectionModulusZ()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MinimumSectionModulusZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinimumSectionModulusZ()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MinimumSectionModulusZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinimumSectionModulusZAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MinimumSectionModulusZAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumSectionModulusZAsString(String newMinimumSectionModulusZAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MinimumSectionModulusZAsString(), newMinimumSectionModulusZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinimumSectionModulusZAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MinimumSectionModulusZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinimumSectionModulusZAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_MinimumSectionModulusZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTorsionalSectionModulus()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_TorsionalSectionModulus(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTorsionalSectionModulus(float newTorsionalSectionModulus)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_TorsionalSectionModulus(), newTorsionalSectionModulus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTorsionalSectionModulus()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_TorsionalSectionModulus());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTorsionalSectionModulus()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_TorsionalSectionModulus());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTorsionalSectionModulusAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_TorsionalSectionModulusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTorsionalSectionModulusAsString(String newTorsionalSectionModulusAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_TorsionalSectionModulusAsString(), newTorsionalSectionModulusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTorsionalSectionModulusAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_TorsionalSectionModulusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTorsionalSectionModulusAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_TorsionalSectionModulusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCentreOfGravityInX()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_CentreOfGravityInX(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCentreOfGravityInX(float newCentreOfGravityInX)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_CentreOfGravityInX(), newCentreOfGravityInX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCentreOfGravityInX()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_CentreOfGravityInX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCentreOfGravityInX()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_CentreOfGravityInX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCentreOfGravityInXAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_CentreOfGravityInXAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCentreOfGravityInXAsString(String newCentreOfGravityInXAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_CentreOfGravityInXAsString(), newCentreOfGravityInXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCentreOfGravityInXAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_CentreOfGravityInXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCentreOfGravityInXAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_CentreOfGravityInXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCentreOfGravityInY()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_CentreOfGravityInY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCentreOfGravityInY(float newCentreOfGravityInY)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_CentreOfGravityInY(), newCentreOfGravityInY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCentreOfGravityInY()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_CentreOfGravityInY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCentreOfGravityInY()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_CentreOfGravityInY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCentreOfGravityInYAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_CentreOfGravityInYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCentreOfGravityInYAsString(String newCentreOfGravityInYAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_CentreOfGravityInYAsString(), newCentreOfGravityInYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCentreOfGravityInYAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_CentreOfGravityInYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCentreOfGravityInYAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralProfileProperties_CentreOfGravityInYAsString());
	}

} //IfcStructuralProfilePropertiesImpl
