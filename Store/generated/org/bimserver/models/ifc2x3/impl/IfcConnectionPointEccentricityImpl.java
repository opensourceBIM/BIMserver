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
import org.bimserver.models.ifc2x3.IfcConnectionPointEccentricity;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Connection Point Eccentricity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConnectionPointEccentricityImpl#getEccentricityInX <em>Eccentricity In X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConnectionPointEccentricityImpl#getEccentricityInXAsString <em>Eccentricity In XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConnectionPointEccentricityImpl#getEccentricityInY <em>Eccentricity In Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConnectionPointEccentricityImpl#getEccentricityInYAsString <em>Eccentricity In YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConnectionPointEccentricityImpl#getEccentricityInZ <em>Eccentricity In Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConnectionPointEccentricityImpl#getEccentricityInZAsString <em>Eccentricity In ZAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcConnectionPointEccentricityImpl extends IfcConnectionPointGeometryImpl implements IfcConnectionPointEccentricity
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcConnectionPointEccentricityImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcConnectionPointEccentricity();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getEccentricityInX()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcConnectionPointEccentricity_EccentricityInX(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEccentricityInX(float newEccentricityInX)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcConnectionPointEccentricity_EccentricityInX(), newEccentricityInX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEccentricityInX()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConnectionPointEccentricity_EccentricityInX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEccentricityInX()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConnectionPointEccentricity_EccentricityInX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEccentricityInXAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcConnectionPointEccentricity_EccentricityInXAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEccentricityInXAsString(String newEccentricityInXAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcConnectionPointEccentricity_EccentricityInXAsString(), newEccentricityInXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEccentricityInXAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConnectionPointEccentricity_EccentricityInXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEccentricityInXAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConnectionPointEccentricity_EccentricityInXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getEccentricityInY()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcConnectionPointEccentricity_EccentricityInY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEccentricityInY(float newEccentricityInY)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcConnectionPointEccentricity_EccentricityInY(), newEccentricityInY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEccentricityInY()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConnectionPointEccentricity_EccentricityInY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEccentricityInY()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConnectionPointEccentricity_EccentricityInY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEccentricityInYAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcConnectionPointEccentricity_EccentricityInYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEccentricityInYAsString(String newEccentricityInYAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcConnectionPointEccentricity_EccentricityInYAsString(), newEccentricityInYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEccentricityInYAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConnectionPointEccentricity_EccentricityInYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEccentricityInYAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConnectionPointEccentricity_EccentricityInYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getEccentricityInZ()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcConnectionPointEccentricity_EccentricityInZ(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEccentricityInZ(float newEccentricityInZ)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcConnectionPointEccentricity_EccentricityInZ(), newEccentricityInZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEccentricityInZ()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConnectionPointEccentricity_EccentricityInZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEccentricityInZ()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConnectionPointEccentricity_EccentricityInZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEccentricityInZAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcConnectionPointEccentricity_EccentricityInZAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEccentricityInZAsString(String newEccentricityInZAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcConnectionPointEccentricity_EccentricityInZAsString(), newEccentricityInZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEccentricityInZAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConnectionPointEccentricity_EccentricityInZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEccentricityInZAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConnectionPointEccentricity_EccentricityInZAsString());
	}

} //IfcConnectionPointEccentricityImpl
