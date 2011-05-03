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
import org.bimserver.models.ifc2x3.IfcConnectionSurfaceGeometry;
import org.bimserver.models.ifc2x3.IfcSurfaceOrFaceSurface;

import org.bimserver.models.ifc2x3.impl.IfcConnectionGeometryImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Connection Surface Geometry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConnectionSurfaceGeometryImpl#getSurfaceOnRelatingElement <em>Surface On Relating Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConnectionSurfaceGeometryImpl#getSurfaceOnRelatedElement <em>Surface On Related Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcConnectionSurfaceGeometryImpl extends IfcConnectionGeometryImpl implements IfcConnectionSurfaceGeometry
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
	protected IfcConnectionSurfaceGeometryImpl()
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
		return Ifc2x3Package.Literals.IFC_CONNECTION_SURFACE_GEOMETRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurfaceOrFaceSurface getSurfaceOnRelatingElement()
	{
		return (IfcSurfaceOrFaceSurface)eGet(Ifc2x3Package.Literals.IFC_CONNECTION_SURFACE_GEOMETRY__SURFACE_ON_RELATING_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSurfaceOnRelatingElement(IfcSurfaceOrFaceSurface newSurfaceOnRelatingElement)
	{
		eSet(Ifc2x3Package.Literals.IFC_CONNECTION_SURFACE_GEOMETRY__SURFACE_ON_RELATING_ELEMENT, newSurfaceOnRelatingElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurfaceOrFaceSurface getSurfaceOnRelatedElement()
	{
		return (IfcSurfaceOrFaceSurface)eGet(Ifc2x3Package.Literals.IFC_CONNECTION_SURFACE_GEOMETRY__SURFACE_ON_RELATED_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSurfaceOnRelatedElement(IfcSurfaceOrFaceSurface newSurfaceOnRelatedElement)
	{
		eSet(Ifc2x3Package.Literals.IFC_CONNECTION_SURFACE_GEOMETRY__SURFACE_ON_RELATED_ELEMENT, newSurfaceOnRelatedElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSurfaceOnRelatedElement()
	{
		eUnset(Ifc2x3Package.Literals.IFC_CONNECTION_SURFACE_GEOMETRY__SURFACE_ON_RELATED_ELEMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSurfaceOnRelatedElement()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_CONNECTION_SURFACE_GEOMETRY__SURFACE_ON_RELATED_ELEMENT);
	}

} //IfcConnectionSurfaceGeometryImpl
