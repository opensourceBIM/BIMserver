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
import org.bimserver.models.ifc2x3.IfcTrapeziumProfileDef;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Trapezium Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTrapeziumProfileDefImpl#getBottomXDim <em>Bottom XDim</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTrapeziumProfileDefImpl#getBottomXDimAsString <em>Bottom XDim As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTrapeziumProfileDefImpl#getTopXDim <em>Top XDim</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTrapeziumProfileDefImpl#getTopXDimAsString <em>Top XDim As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTrapeziumProfileDefImpl#getYDim <em>YDim</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTrapeziumProfileDefImpl#getYDimAsString <em>YDim As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTrapeziumProfileDefImpl#getTopXOffset <em>Top XOffset</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTrapeziumProfileDefImpl#getTopXOffsetAsString <em>Top XOffset As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcTrapeziumProfileDefImpl extends IfcParameterizedProfileDefImpl implements IfcTrapeziumProfileDef
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTrapeziumProfileDefImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcTrapeziumProfileDef();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getBottomXDim()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcTrapeziumProfileDef_BottomXDim(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBottomXDim(float newBottomXDim)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTrapeziumProfileDef_BottomXDim(), newBottomXDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBottomXDimAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTrapeziumProfileDef_BottomXDimAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBottomXDimAsString(String newBottomXDimAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTrapeziumProfileDef_BottomXDimAsString(), newBottomXDimAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTopXDim()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcTrapeziumProfileDef_TopXDim(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopXDim(float newTopXDim)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTrapeziumProfileDef_TopXDim(), newTopXDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTopXDimAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTrapeziumProfileDef_TopXDimAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopXDimAsString(String newTopXDimAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTrapeziumProfileDef_TopXDimAsString(), newTopXDimAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getYDim()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcTrapeziumProfileDef_YDim(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYDim(float newYDim)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTrapeziumProfileDef_YDim(), newYDim);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getYDimAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTrapeziumProfileDef_YDimAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYDimAsString(String newYDimAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTrapeziumProfileDef_YDimAsString(), newYDimAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTopXOffset()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcTrapeziumProfileDef_TopXOffset(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopXOffset(float newTopXOffset)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTrapeziumProfileDef_TopXOffset(), newTopXOffset);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTopXOffsetAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTrapeziumProfileDef_TopXOffsetAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopXOffsetAsString(String newTopXOffsetAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTrapeziumProfileDef_TopXOffsetAsString(), newTopXOffsetAsString);
	}

} //IfcTrapeziumProfileDefImpl
