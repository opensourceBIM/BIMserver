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
import org.bimserver.models.ifc2x3.IfcFailureConnectionCondition;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Failure Connection Condition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFailureConnectionConditionImpl#getTensionFailureX <em>Tension Failure X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFailureConnectionConditionImpl#getTensionFailureXAsString <em>Tension Failure XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFailureConnectionConditionImpl#getTensionFailureY <em>Tension Failure Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFailureConnectionConditionImpl#getTensionFailureYAsString <em>Tension Failure YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFailureConnectionConditionImpl#getTensionFailureZ <em>Tension Failure Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFailureConnectionConditionImpl#getTensionFailureZAsString <em>Tension Failure ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFailureConnectionConditionImpl#getCompressionFailureX <em>Compression Failure X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFailureConnectionConditionImpl#getCompressionFailureXAsString <em>Compression Failure XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFailureConnectionConditionImpl#getCompressionFailureY <em>Compression Failure Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFailureConnectionConditionImpl#getCompressionFailureYAsString <em>Compression Failure YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFailureConnectionConditionImpl#getCompressionFailureZ <em>Compression Failure Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFailureConnectionConditionImpl#getCompressionFailureZAsString <em>Compression Failure ZAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcFailureConnectionConditionImpl extends IfcStructuralConnectionConditionImpl implements IfcFailureConnectionCondition
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcFailureConnectionConditionImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTensionFailureX()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_TensionFailureX(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTensionFailureX(float newTensionFailureX)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_TensionFailureX(), newTensionFailureX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTensionFailureX()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_TensionFailureX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTensionFailureX()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_TensionFailureX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTensionFailureXAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_TensionFailureXAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTensionFailureXAsString(String newTensionFailureXAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_TensionFailureXAsString(), newTensionFailureXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTensionFailureXAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_TensionFailureXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTensionFailureXAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_TensionFailureXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTensionFailureY()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_TensionFailureY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTensionFailureY(float newTensionFailureY)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_TensionFailureY(), newTensionFailureY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTensionFailureY()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_TensionFailureY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTensionFailureY()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_TensionFailureY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTensionFailureYAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_TensionFailureYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTensionFailureYAsString(String newTensionFailureYAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_TensionFailureYAsString(), newTensionFailureYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTensionFailureYAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_TensionFailureYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTensionFailureYAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_TensionFailureYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTensionFailureZ()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_TensionFailureZ(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTensionFailureZ(float newTensionFailureZ)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_TensionFailureZ(), newTensionFailureZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTensionFailureZ()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_TensionFailureZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTensionFailureZ()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_TensionFailureZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTensionFailureZAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_TensionFailureZAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTensionFailureZAsString(String newTensionFailureZAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_TensionFailureZAsString(), newTensionFailureZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTensionFailureZAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_TensionFailureZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTensionFailureZAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_TensionFailureZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCompressionFailureX()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_CompressionFailureX(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompressionFailureX(float newCompressionFailureX)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_CompressionFailureX(), newCompressionFailureX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCompressionFailureX()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_CompressionFailureX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCompressionFailureX()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_CompressionFailureX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCompressionFailureXAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_CompressionFailureXAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompressionFailureXAsString(String newCompressionFailureXAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_CompressionFailureXAsString(), newCompressionFailureXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCompressionFailureXAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_CompressionFailureXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCompressionFailureXAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_CompressionFailureXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCompressionFailureY()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_CompressionFailureY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompressionFailureY(float newCompressionFailureY)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_CompressionFailureY(), newCompressionFailureY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCompressionFailureY()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_CompressionFailureY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCompressionFailureY()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_CompressionFailureY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCompressionFailureYAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_CompressionFailureYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompressionFailureYAsString(String newCompressionFailureYAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_CompressionFailureYAsString(), newCompressionFailureYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCompressionFailureYAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_CompressionFailureYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCompressionFailureYAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_CompressionFailureYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCompressionFailureZ()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_CompressionFailureZ(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompressionFailureZ(float newCompressionFailureZ)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_CompressionFailureZ(), newCompressionFailureZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCompressionFailureZ()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_CompressionFailureZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCompressionFailureZ()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_CompressionFailureZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCompressionFailureZAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_CompressionFailureZAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompressionFailureZAsString(String newCompressionFailureZAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_CompressionFailureZAsString(), newCompressionFailureZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCompressionFailureZAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_CompressionFailureZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCompressionFailureZAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcFailureConnectionCondition_CompressionFailureZAsString());
	}

} //IfcFailureConnectionConditionImpl
