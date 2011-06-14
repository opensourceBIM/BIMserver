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
import org.bimserver.models.ifc2x3.IfcCurve;
import org.bimserver.models.ifc2x3.IfcGrid;
import org.bimserver.models.ifc2x3.IfcGridAxis;
import org.bimserver.models.ifc2x3.IfcVirtualGridIntersection;
import org.bimserver.models.ifc2x3.Tristate;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Grid Axis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGridAxisImpl#getAxisTag <em>Axis Tag</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGridAxisImpl#getAxisCurve <em>Axis Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGridAxisImpl#getSameSense <em>Same Sense</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGridAxisImpl#getPartOfW <em>Part Of W</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGridAxisImpl#getPartOfV <em>Part Of V</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGridAxisImpl#getPartOfU <em>Part Of U</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGridAxisImpl#getHasIntersections <em>Has Intersections</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcGridAxisImpl extends IdEObjectImpl implements IfcGridAxis
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcGridAxisImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcGridAxis();
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
	public String getAxisTag()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcGridAxis_AxisTag(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAxisTag(String newAxisTag)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcGridAxis_AxisTag(), newAxisTag);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAxisTag()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcGridAxis_AxisTag());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAxisTag()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcGridAxis_AxisTag());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurve getAxisCurve()
	{
		return (IfcCurve)eGet(Ifc2x3Package.eINSTANCE.getIfcGridAxis_AxisCurve(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAxisCurve(IfcCurve newAxisCurve)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcGridAxis_AxisCurve(), newAxisCurve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getSameSense()
	{
		return (Tristate)eGet(Ifc2x3Package.eINSTANCE.getIfcGridAxis_SameSense(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSameSense(Tristate newSameSense)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcGridAxis_SameSense(), newSameSense);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcGrid> getPartOfW()
	{
		return (EList<IfcGrid>)eGet(Ifc2x3Package.eINSTANCE.getIfcGridAxis_PartOfW(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcGrid> getPartOfV()
	{
		return (EList<IfcGrid>)eGet(Ifc2x3Package.eINSTANCE.getIfcGridAxis_PartOfV(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcGrid> getPartOfU()
	{
		return (EList<IfcGrid>)eGet(Ifc2x3Package.eINSTANCE.getIfcGridAxis_PartOfU(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcVirtualGridIntersection> getHasIntersections()
	{
		return (EList<IfcVirtualGridIntersection>)eGet(Ifc2x3Package.eINSTANCE.getIfcGridAxis_HasIntersections(), true);
	}

} //IfcGridAxisImpl
