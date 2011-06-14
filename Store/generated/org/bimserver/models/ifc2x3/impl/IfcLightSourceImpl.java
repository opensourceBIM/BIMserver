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
import org.bimserver.models.ifc2x3.IfcColourRgb;
import org.bimserver.models.ifc2x3.IfcLightSource;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Light Source</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourceImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourceImpl#getLightColour <em>Light Colour</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourceImpl#getAmbientIntensity <em>Ambient Intensity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourceImpl#getAmbientIntensityAsString <em>Ambient Intensity As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourceImpl#getIntensity <em>Intensity</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourceImpl#getIntensityAsString <em>Intensity As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcLightSourceImpl extends IfcGeometricRepresentationItemImpl implements IfcLightSource
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcLightSourceImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcLightSource();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcLightSource_Name(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLightSource_Name(), newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetName()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLightSource_Name());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetName()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLightSource_Name());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcColourRgb getLightColour()
	{
		return (IfcColourRgb)eGet(Ifc2x3Package.eINSTANCE.getIfcLightSource_LightColour(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLightColour(IfcColourRgb newLightColour)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLightSource_LightColour(), newLightColour);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getAmbientIntensity()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcLightSource_AmbientIntensity(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAmbientIntensity(float newAmbientIntensity)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLightSource_AmbientIntensity(), newAmbientIntensity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAmbientIntensity()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLightSource_AmbientIntensity());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAmbientIntensity()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLightSource_AmbientIntensity());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAmbientIntensityAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcLightSource_AmbientIntensityAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAmbientIntensityAsString(String newAmbientIntensityAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLightSource_AmbientIntensityAsString(), newAmbientIntensityAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAmbientIntensityAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLightSource_AmbientIntensityAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAmbientIntensityAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLightSource_AmbientIntensityAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getIntensity()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcLightSource_Intensity(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntensity(float newIntensity)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLightSource_Intensity(), newIntensity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIntensity()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLightSource_Intensity());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIntensity()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLightSource_Intensity());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIntensityAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcLightSource_IntensityAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntensityAsString(String newIntensityAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLightSource_IntensityAsString(), newIntensityAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIntensityAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcLightSource_IntensityAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIntensityAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcLightSource_IntensityAsString());
	}

} //IfcLightSourceImpl
