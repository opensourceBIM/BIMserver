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
import org.bimserver.models.ifc2x3.IfcCurve;
import org.bimserver.models.ifc2x3.IfcEdgeCurve;
import org.bimserver.models.ifc2x3.Tristate;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Edge Curve</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEdgeCurveImpl#getEdgeGeometry <em>Edge Geometry</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcEdgeCurveImpl#getSameSense <em>Same Sense</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcEdgeCurveImpl extends IfcEdgeImpl implements IfcEdgeCurve
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcEdgeCurveImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcEdgeCurve();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurve getEdgeGeometry()
	{
		return (IfcCurve)eGet(Ifc2x3Package.eINSTANCE.getIfcEdgeCurve_EdgeGeometry(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdgeGeometry(IfcCurve newEdgeGeometry)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcEdgeCurve_EdgeGeometry(), newEdgeGeometry);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getSameSense()
	{
		return (Tristate)eGet(Ifc2x3Package.eINSTANCE.getIfcEdgeCurve_SameSense(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSameSense(Tristate newSameSense)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcEdgeCurve_SameSense(), newSameSense);
	}

} //IfcEdgeCurveImpl
