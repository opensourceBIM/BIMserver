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
import org.bimserver.models.ifc2x3.IfcCompositeCurve;
import org.bimserver.models.ifc2x3.IfcCompositeCurveSegment;
import org.bimserver.models.ifc2x3.IfcCurve;
import org.bimserver.models.ifc2x3.IfcTransitionCode;
import org.bimserver.models.ifc2x3.Tristate;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Composite Curve Segment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCompositeCurveSegmentImpl#getTransition <em>Transition</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCompositeCurveSegmentImpl#getSameSense <em>Same Sense</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCompositeCurveSegmentImpl#getParentCurve <em>Parent Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCompositeCurveSegmentImpl#getUsingCurves <em>Using Curves</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcCompositeCurveSegmentImpl#getDim <em>Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcCompositeCurveSegmentImpl extends IfcGeometricRepresentationItemImpl implements IfcCompositeCurveSegment
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcCompositeCurveSegmentImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcCompositeCurveSegment();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTransitionCode getTransition()
	{
		return (IfcTransitionCode)eGet(Ifc2x3Package.eINSTANCE.getIfcCompositeCurveSegment_Transition(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransition(IfcTransitionCode newTransition)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCompositeCurveSegment_Transition(), newTransition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getSameSense()
	{
		return (Tristate)eGet(Ifc2x3Package.eINSTANCE.getIfcCompositeCurveSegment_SameSense(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSameSense(Tristate newSameSense)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCompositeCurveSegment_SameSense(), newSameSense);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurve getParentCurve()
	{
		return (IfcCurve)eGet(Ifc2x3Package.eINSTANCE.getIfcCompositeCurveSegment_ParentCurve(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentCurve(IfcCurve newParentCurve)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCompositeCurveSegment_ParentCurve(), newParentCurve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcCompositeCurve> getUsingCurves()
	{
		return (EList<IfcCompositeCurve>)eGet(Ifc2x3Package.eINSTANCE.getIfcCompositeCurveSegment_UsingCurves(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDim()
	{
		return (Integer)eGet(Ifc2x3Package.eINSTANCE.getIfcCompositeCurveSegment_Dim(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDim(int newDim)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcCompositeCurveSegment_Dim(), newDim);
	}

} //IfcCompositeCurveSegmentImpl
