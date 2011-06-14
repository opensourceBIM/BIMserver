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
import org.bimserver.models.ifc2x3.IfcAsymmetricIShapeProfileDef;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Asymmetric IShape Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeWidth <em>Top Flange Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeWidthAsString <em>Top Flange Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeThickness <em>Top Flange Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeThicknessAsString <em>Top Flange Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeFilletRadius <em>Top Flange Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAsymmetricIShapeProfileDefImpl#getTopFlangeFilletRadiusAsString <em>Top Flange Fillet Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAsymmetricIShapeProfileDefImpl#getCentreOfGravityInY <em>Centre Of Gravity In Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAsymmetricIShapeProfileDefImpl#getCentreOfGravityInYAsString <em>Centre Of Gravity In YAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcAsymmetricIShapeProfileDefImpl extends IfcIShapeProfileDefImpl implements IfcAsymmetricIShapeProfileDef
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcAsymmetricIShapeProfileDefImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTopFlangeWidth()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeWidth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopFlangeWidth(float newTopFlangeWidth)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeWidth(), newTopFlangeWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTopFlangeWidthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeWidthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopFlangeWidthAsString(String newTopFlangeWidthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeWidthAsString(), newTopFlangeWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTopFlangeThickness()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopFlangeThickness(float newTopFlangeThickness)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeThickness(), newTopFlangeThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTopFlangeThickness()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTopFlangeThickness()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTopFlangeThicknessAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopFlangeThicknessAsString(String newTopFlangeThicknessAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeThicknessAsString(), newTopFlangeThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTopFlangeThicknessAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTopFlangeThicknessAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTopFlangeFilletRadius()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeFilletRadius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopFlangeFilletRadius(float newTopFlangeFilletRadius)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeFilletRadius(), newTopFlangeFilletRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTopFlangeFilletRadius()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeFilletRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTopFlangeFilletRadius()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeFilletRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTopFlangeFilletRadiusAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeFilletRadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopFlangeFilletRadiusAsString(String newTopFlangeFilletRadiusAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeFilletRadiusAsString(), newTopFlangeFilletRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTopFlangeFilletRadiusAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeFilletRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTopFlangeFilletRadiusAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_TopFlangeFilletRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getCentreOfGravityInY()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_CentreOfGravityInY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCentreOfGravityInY(float newCentreOfGravityInY)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_CentreOfGravityInY(), newCentreOfGravityInY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCentreOfGravityInY()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_CentreOfGravityInY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCentreOfGravityInY()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_CentreOfGravityInY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCentreOfGravityInYAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_CentreOfGravityInYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCentreOfGravityInYAsString(String newCentreOfGravityInYAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_CentreOfGravityInYAsString(), newCentreOfGravityInYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCentreOfGravityInYAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_CentreOfGravityInYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCentreOfGravityInYAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcAsymmetricIShapeProfileDef_CentreOfGravityInYAsString());
	}

} //IfcAsymmetricIShapeProfileDefImpl
