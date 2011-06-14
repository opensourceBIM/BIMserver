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
import org.bimserver.models.ifc2x3.IfcGeometricProjectionEnum;
import org.bimserver.models.ifc2x3.IfcGeometricRepresentationContext;
import org.bimserver.models.ifc2x3.IfcGeometricRepresentationSubContext;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Geometric Representation Sub Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGeometricRepresentationSubContextImpl#getParentContext <em>Parent Context</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGeometricRepresentationSubContextImpl#getTargetScale <em>Target Scale</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGeometricRepresentationSubContextImpl#getTargetScaleAsString <em>Target Scale As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGeometricRepresentationSubContextImpl#getTargetView <em>Target View</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcGeometricRepresentationSubContextImpl#getUserDefinedTargetView <em>User Defined Target View</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcGeometricRepresentationSubContextImpl extends IfcGeometricRepresentationContextImpl implements IfcGeometricRepresentationSubContext
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcGeometricRepresentationSubContextImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationSubContext();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGeometricRepresentationContext getParentContext()
	{
		return (IfcGeometricRepresentationContext)eGet(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationSubContext_ParentContext(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentContext(IfcGeometricRepresentationContext newParentContext)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationSubContext_ParentContext(), newParentContext);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTargetScale()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationSubContext_TargetScale(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetScale(float newTargetScale)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationSubContext_TargetScale(), newTargetScale);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTargetScale()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationSubContext_TargetScale());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTargetScale()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationSubContext_TargetScale());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetScaleAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationSubContext_TargetScaleAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetScaleAsString(String newTargetScaleAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationSubContext_TargetScaleAsString(), newTargetScaleAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTargetScaleAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationSubContext_TargetScaleAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTargetScaleAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationSubContext_TargetScaleAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGeometricProjectionEnum getTargetView()
	{
		return (IfcGeometricProjectionEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationSubContext_TargetView(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetView(IfcGeometricProjectionEnum newTargetView)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationSubContext_TargetView(), newTargetView);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserDefinedTargetView()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationSubContext_UserDefinedTargetView(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserDefinedTargetView(String newUserDefinedTargetView)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationSubContext_UserDefinedTargetView(), newUserDefinedTargetView);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserDefinedTargetView()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationSubContext_UserDefinedTargetView());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserDefinedTargetView()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcGeometricRepresentationSubContext_UserDefinedTargetView());
	}

} //IfcGeometricRepresentationSubContextImpl
