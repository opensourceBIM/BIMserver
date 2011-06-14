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
import org.bimserver.models.ifc2x3.IfcCartesianPoint;
import org.bimserver.models.ifc2x3.IfcLightSourcePositional;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Light Source Positional</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourcePositionalImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourcePositionalImpl#getRadius <em>Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourcePositionalImpl#getRadiusAsString <em>Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourcePositionalImpl#getConstantAttenuation <em>Constant Attenuation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourcePositionalImpl#getConstantAttenuationAsString <em>Constant Attenuation As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourcePositionalImpl#getDistanceAttenuation <em>Distance Attenuation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourcePositionalImpl#getDistanceAttenuationAsString <em>Distance Attenuation As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourcePositionalImpl#getQuadricAttenuation <em>Quadric Attenuation</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcLightSourcePositionalImpl#getQuadricAttenuationAsString <em>Quadric Attenuation As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcLightSourcePositionalImpl extends IfcLightSourceImpl implements IfcLightSourcePositional
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcLightSourcePositionalImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcLightSourcePositional();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCartesianPoint getPosition()
	{
		return (IfcCartesianPoint)eGet(Ifc2x3Package.eINSTANCE.getIfcLightSourcePositional_Position(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosition(IfcCartesianPoint newPosition)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLightSourcePositional_Position(), newPosition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRadius()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcLightSourcePositional_Radius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRadius(float newRadius)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLightSourcePositional_Radius(), newRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRadiusAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcLightSourcePositional_RadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRadiusAsString(String newRadiusAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLightSourcePositional_RadiusAsString(), newRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getConstantAttenuation()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcLightSourcePositional_ConstantAttenuation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstantAttenuation(float newConstantAttenuation)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLightSourcePositional_ConstantAttenuation(), newConstantAttenuation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConstantAttenuationAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcLightSourcePositional_ConstantAttenuationAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstantAttenuationAsString(String newConstantAttenuationAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLightSourcePositional_ConstantAttenuationAsString(), newConstantAttenuationAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDistanceAttenuation()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcLightSourcePositional_DistanceAttenuation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistanceAttenuation(float newDistanceAttenuation)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLightSourcePositional_DistanceAttenuation(), newDistanceAttenuation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDistanceAttenuationAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcLightSourcePositional_DistanceAttenuationAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistanceAttenuationAsString(String newDistanceAttenuationAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLightSourcePositional_DistanceAttenuationAsString(), newDistanceAttenuationAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getQuadricAttenuation()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcLightSourcePositional_QuadricAttenuation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuadricAttenuation(float newQuadricAttenuation)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLightSourcePositional_QuadricAttenuation(), newQuadricAttenuation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQuadricAttenuationAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcLightSourcePositional_QuadricAttenuationAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuadricAttenuationAsString(String newQuadricAttenuationAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcLightSourcePositional_QuadricAttenuationAsString(), newQuadricAttenuationAsString);
	}

} //IfcLightSourcePositionalImpl
