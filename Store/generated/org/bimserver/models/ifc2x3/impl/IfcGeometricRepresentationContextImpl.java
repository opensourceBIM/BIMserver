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
import org.bimserver.models.ifc2x3.IfcAxis2Placement;
import org.bimserver.models.ifc2x3.IfcDirection;
import org.bimserver.models.ifc2x3.IfcGeometricRepresentationContext;
import org.bimserver.models.ifc2x3.IfcGeometricRepresentationSubContext;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Geometric Representation Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGeometricRepresentationContextImpl#getCoordinateSpaceDimension <em>Coordinate Space Dimension</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGeometricRepresentationContextImpl#getPrecision <em>Precision</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGeometricRepresentationContextImpl#getPrecisionAsString <em>Precision As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGeometricRepresentationContextImpl#getWorldCoordinateSystem <em>World Coordinate System</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGeometricRepresentationContextImpl#getTrueNorth <em>True North</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGeometricRepresentationContextImpl#getHasSubContexts <em>Has Sub Contexts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcGeometricRepresentationContextImpl extends IfcRepresentationContextImpl implements IfcGeometricRepresentationContext
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcGeometricRepresentationContextImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationContext();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCoordinateSpaceDimension()
	{
		return (Integer)eGet(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationContext_CoordinateSpaceDimension(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoordinateSpaceDimension(int newCoordinateSpaceDimension)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationContext_CoordinateSpaceDimension(), newCoordinateSpaceDimension);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getPrecision()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationContext_Precision(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrecision(float newPrecision)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationContext_Precision(), newPrecision);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrecisionAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationContext_PrecisionAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrecisionAsString(String newPrecisionAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationContext_PrecisionAsString(), newPrecisionAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAxis2Placement getWorldCoordinateSystem()
	{
		return (IfcAxis2Placement)eGet(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationContext_WorldCoordinateSystem(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWorldCoordinateSystem(IfcAxis2Placement newWorldCoordinateSystem)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationContext_WorldCoordinateSystem(), newWorldCoordinateSystem);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDirection getTrueNorth()
	{
		return (IfcDirection)eGet(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationContext_TrueNorth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrueNorth(IfcDirection newTrueNorth)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationContext_TrueNorth(), newTrueNorth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTrueNorth()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationContext_TrueNorth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTrueNorth()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationContext_TrueNorth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcGeometricRepresentationSubContext> getHasSubContexts()
	{
		return (EList<IfcGeometricRepresentationSubContext>)eGet(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationContext_HasSubContexts(), true);
	}

} //IfcGeometricRepresentationContextImpl
