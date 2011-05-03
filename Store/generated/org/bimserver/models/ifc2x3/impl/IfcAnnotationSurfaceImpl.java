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
import org.bimserver.models.ifc2x3.IfcAnnotationSurface;
import org.bimserver.models.ifc2x3.IfcGeometricRepresentationItem;
import org.bimserver.models.ifc2x3.IfcTextureCoordinate;

import org.bimserver.models.ifc2x3.impl.IfcGeometricRepresentationItemImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Annotation Surface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAnnotationSurfaceImpl#getItem <em>Item</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAnnotationSurfaceImpl#getTextureCoordinates <em>Texture Coordinates</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcAnnotationSurfaceImpl extends IfcGeometricRepresentationItemImpl implements IfcAnnotationSurface
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
	protected IfcAnnotationSurfaceImpl()
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
		return Ifc2x3Package.Literals.IFC_ANNOTATION_SURFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGeometricRepresentationItem getItem()
	{
		return (IfcGeometricRepresentationItem)eGet(Ifc2x3Package.Literals.IFC_ANNOTATION_SURFACE__ITEM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setItem(IfcGeometricRepresentationItem newItem)
	{
		eSet(Ifc2x3Package.Literals.IFC_ANNOTATION_SURFACE__ITEM, newItem);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTextureCoordinate getTextureCoordinates()
	{
		return (IfcTextureCoordinate)eGet(Ifc2x3Package.Literals.IFC_ANNOTATION_SURFACE__TEXTURE_COORDINATES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextureCoordinates(IfcTextureCoordinate newTextureCoordinates)
	{
		eSet(Ifc2x3Package.Literals.IFC_ANNOTATION_SURFACE__TEXTURE_COORDINATES, newTextureCoordinates);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTextureCoordinates()
	{
		eUnset(Ifc2x3Package.Literals.IFC_ANNOTATION_SURFACE__TEXTURE_COORDINATES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTextureCoordinates()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_ANNOTATION_SURFACE__TEXTURE_COORDINATES);
	}

} //IfcAnnotationSurfaceImpl
