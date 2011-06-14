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
import org.bimserver.models.ifc2x3.IfcTextLiteral;
import org.bimserver.models.ifc2x3.IfcTextPath;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Text Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextLiteralImpl#getLiteral <em>Literal</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextLiteralImpl#getPlacement <em>Placement</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextLiteralImpl#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcTextLiteralImpl extends IfcGeometricRepresentationItemImpl implements IfcTextLiteral
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTextLiteralImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcTextLiteral();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTextLiteral_Literal(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiteral(String newLiteral)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextLiteral_Literal(), newLiteral);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAxis2Placement getPlacement()
	{
		return (IfcAxis2Placement)eGet(Ifc2x3Package.eINSTANCE.getIfcTextLiteral_Placement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlacement(IfcAxis2Placement newPlacement)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextLiteral_Placement(), newPlacement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTextPath getPath()
	{
		return (IfcTextPath)eGet(Ifc2x3Package.eINSTANCE.getIfcTextLiteral_Path(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(IfcTextPath newPath)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextLiteral_Path(), newPath);
	}

} //IfcTextLiteralImpl
