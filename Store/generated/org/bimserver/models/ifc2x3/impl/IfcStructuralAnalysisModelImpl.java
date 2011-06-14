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
import org.bimserver.models.ifc2x3.IfcAnalysisModelTypeEnum;
import org.bimserver.models.ifc2x3.IfcAxis2Placement3D;
import org.bimserver.models.ifc2x3.IfcStructuralAnalysisModel;
import org.bimserver.models.ifc2x3.IfcStructuralLoadGroup;
import org.bimserver.models.ifc2x3.IfcStructuralResultGroup;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Analysis Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralAnalysisModelImpl#getPredefinedType <em>Predefined Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralAnalysisModelImpl#getOrientationOf2DPlane <em>Orientation Of2 DPlane</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralAnalysisModelImpl#getLoadedBy <em>Loaded By</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralAnalysisModelImpl#getHasResults <em>Has Results</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcStructuralAnalysisModelImpl extends IfcSystemImpl implements IfcStructuralAnalysisModel
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralAnalysisModelImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcStructuralAnalysisModel();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAnalysisModelTypeEnum getPredefinedType()
	{
		return (IfcAnalysisModelTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralAnalysisModel_PredefinedType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPredefinedType(IfcAnalysisModelTypeEnum newPredefinedType)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralAnalysisModel_PredefinedType(), newPredefinedType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcAxis2Placement3D getOrientationOf2DPlane()
	{
		return (IfcAxis2Placement3D)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralAnalysisModel_OrientationOf2DPlane(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrientationOf2DPlane(IfcAxis2Placement3D newOrientationOf2DPlane)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralAnalysisModel_OrientationOf2DPlane(), newOrientationOf2DPlane);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOrientationOf2DPlane()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralAnalysisModel_OrientationOf2DPlane());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOrientationOf2DPlane()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralAnalysisModel_OrientationOf2DPlane());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcStructuralLoadGroup> getLoadedBy()
	{
		return (EList<IfcStructuralLoadGroup>)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralAnalysisModel_LoadedBy(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLoadedBy()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralAnalysisModel_LoadedBy());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLoadedBy()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralAnalysisModel_LoadedBy());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcStructuralResultGroup> getHasResults()
	{
		return (EList<IfcStructuralResultGroup>)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralAnalysisModel_HasResults(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetHasResults()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralAnalysisModel_HasResults());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetHasResults()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralAnalysisModel_HasResults());
	}

} //IfcStructuralAnalysisModelImpl
