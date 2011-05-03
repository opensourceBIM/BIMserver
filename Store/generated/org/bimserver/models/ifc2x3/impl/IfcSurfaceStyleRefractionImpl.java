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

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcSurfaceStyleRefraction;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Surface Style Refraction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceStyleRefractionImpl#getRefractionIndex <em>Refraction Index</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceStyleRefractionImpl#getRefractionIndexAsString <em>Refraction Index As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceStyleRefractionImpl#getDispersionFactor <em>Dispersion Factor</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSurfaceStyleRefractionImpl#getDispersionFactorAsString <em>Dispersion Factor As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcSurfaceStyleRefractionImpl extends IdEObjectImpl implements IfcSurfaceStyleRefraction
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSurfaceStyleRefractionImpl()
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
		return Ifc2x3Package.Literals.IFC_SURFACE_STYLE_REFRACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount()
	{
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRefractionIndex()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_REFRACTION__REFRACTION_INDEX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefractionIndex(float newRefractionIndex)
	{
		eSet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_REFRACTION__REFRACTION_INDEX, newRefractionIndex);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRefractionIndex()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_REFRACTION__REFRACTION_INDEX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRefractionIndex()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_REFRACTION__REFRACTION_INDEX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRefractionIndexAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_REFRACTION__REFRACTION_INDEX_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefractionIndexAsString(String newRefractionIndexAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_REFRACTION__REFRACTION_INDEX_AS_STRING, newRefractionIndexAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRefractionIndexAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_REFRACTION__REFRACTION_INDEX_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRefractionIndexAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_REFRACTION__REFRACTION_INDEX_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getDispersionFactor()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_REFRACTION__DISPERSION_FACTOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDispersionFactor(float newDispersionFactor)
	{
		eSet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_REFRACTION__DISPERSION_FACTOR, newDispersionFactor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDispersionFactor()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_REFRACTION__DISPERSION_FACTOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDispersionFactor()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_REFRACTION__DISPERSION_FACTOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDispersionFactorAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_REFRACTION__DISPERSION_FACTOR_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDispersionFactorAsString(String newDispersionFactorAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_REFRACTION__DISPERSION_FACTOR_AS_STRING, newDispersionFactorAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDispersionFactorAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_REFRACTION__DISPERSION_FACTOR_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDispersionFactorAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_SURFACE_STYLE_REFRACTION__DISPERSION_FACTOR_AS_STRING);
	}

} //IfcSurfaceStyleRefractionImpl
