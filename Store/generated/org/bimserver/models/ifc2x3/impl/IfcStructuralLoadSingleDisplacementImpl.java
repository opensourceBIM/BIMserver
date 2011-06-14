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
import org.bimserver.models.ifc2x3.IfcStructuralLoadSingleDisplacement;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Load Single Displacement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadSingleDisplacementImpl#getDisplacementX <em>Displacement X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadSingleDisplacementImpl#getDisplacementXAsString <em>Displacement XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadSingleDisplacementImpl#getDisplacementY <em>Displacement Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadSingleDisplacementImpl#getDisplacementYAsString <em>Displacement YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadSingleDisplacementImpl#getDisplacementZ <em>Displacement Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadSingleDisplacementImpl#getDisplacementZAsString <em>Displacement ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadSingleDisplacementImpl#getRotationalDisplacementRX <em>Rotational Displacement RX</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadSingleDisplacementImpl#getRotationalDisplacementRXAsString <em>Rotational Displacement RX As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadSingleDisplacementImpl#getRotationalDisplacementRY <em>Rotational Displacement RY</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadSingleDisplacementImpl#getRotationalDisplacementRYAsString <em>Rotational Displacement RY As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadSingleDisplacementImpl#getRotationalDisplacementRZ <em>Rotational Displacement RZ</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadSingleDisplacementImpl#getRotationalDisplacementRZAsString <em>Rotational Displacement RZ As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcStructuralLoadSingleDisplacementImpl extends IfcStructuralLoadStaticImpl implements IfcStructuralLoadSingleDisplacement
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralLoadSingleDisplacementImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDisplacementX()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementX(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplacementX(float newDisplacementX)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementX(), newDisplacementX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDisplacementX()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDisplacementX()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDisplacementXAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementXAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplacementXAsString(String newDisplacementXAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementXAsString(), newDisplacementXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDisplacementXAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDisplacementXAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDisplacementY()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplacementY(float newDisplacementY)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementY(), newDisplacementY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDisplacementY()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDisplacementY()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDisplacementYAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplacementYAsString(String newDisplacementYAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementYAsString(), newDisplacementYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDisplacementYAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDisplacementYAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDisplacementZ()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementZ(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplacementZ(float newDisplacementZ)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementZ(), newDisplacementZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDisplacementZ()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDisplacementZ()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDisplacementZAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementZAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisplacementZAsString(String newDisplacementZAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementZAsString(), newDisplacementZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDisplacementZAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDisplacementZAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_DisplacementZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRotationalDisplacementRX()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRX(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalDisplacementRX(float newRotationalDisplacementRX)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRX(), newRotationalDisplacementRX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalDisplacementRX()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalDisplacementRX()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRotationalDisplacementRXAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRXAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalDisplacementRXAsString(String newRotationalDisplacementRXAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRXAsString(), newRotationalDisplacementRXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalDisplacementRXAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalDisplacementRXAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRotationalDisplacementRY()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalDisplacementRY(float newRotationalDisplacementRY)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRY(), newRotationalDisplacementRY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalDisplacementRY()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalDisplacementRY()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRotationalDisplacementRYAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalDisplacementRYAsString(String newRotationalDisplacementRYAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRYAsString(), newRotationalDisplacementRYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalDisplacementRYAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalDisplacementRYAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRotationalDisplacementRZ()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRZ(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalDisplacementRZ(float newRotationalDisplacementRZ)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRZ(), newRotationalDisplacementRZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalDisplacementRZ()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalDisplacementRZ()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRotationalDisplacementRZAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRZAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRotationalDisplacementRZAsString(String newRotationalDisplacementRZAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRZAsString(), newRotationalDisplacementRZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRotationalDisplacementRZAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRotationalDisplacementRZAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadSingleDisplacement_RotationalDisplacementRZAsString());
	}

} //IfcStructuralLoadSingleDisplacementImpl
