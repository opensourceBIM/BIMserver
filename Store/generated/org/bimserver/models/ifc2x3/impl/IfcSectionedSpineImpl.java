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
import org.bimserver.models.ifc2x3.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3.IfcCompositeCurve;
import org.bimserver.models.ifc2x3.IfcProfileDef;
import org.bimserver.models.ifc2x3.IfcSectionedSpine;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Sectioned Spine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSectionedSpineImpl#getSpineCurve <em>Spine Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSectionedSpineImpl#getCrossSections <em>Cross Sections</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSectionedSpineImpl#getCrossSectionPositions <em>Cross Section Positions</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSectionedSpineImpl#getDim <em>Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcSectionedSpineImpl extends IfcGeometricRepresentationItemImpl implements IfcSectionedSpine
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSectionedSpineImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcSectionedSpine();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCompositeCurve getSpineCurve()
	{
		return (IfcCompositeCurve)eGet(Ifc2x3Package.eINSTANCE.getIfcSectionedSpine_SpineCurve(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpineCurve(IfcCompositeCurve newSpineCurve)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcSectionedSpine_SpineCurve(), newSpineCurve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcProfileDef> getCrossSections()
	{
		return (EList<IfcProfileDef>)eGet(Ifc2x3Package.eINSTANCE.getIfcSectionedSpine_CrossSections(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcAxis2Placement3D> getCrossSectionPositions()
	{
		return (EList<IfcAxis2Placement3D>)eGet(Ifc2x3Package.eINSTANCE.getIfcSectionedSpine_CrossSectionPositions(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDim()
	{
		return (Integer)eGet(Ifc2x3Package.eINSTANCE.getIfcSectionedSpine_Dim(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDim(int newDim)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcSectionedSpine_Dim(), newDim);
	}

} //IfcSectionedSpineImpl
