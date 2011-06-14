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
import org.bimserver.models.ifc2x3.IfcPermeableCoveringOperationEnum;
import org.bimserver.models.ifc2x3.IfcPermeableCoveringProperties;
import org.bimserver.models.ifc2x3.IfcShapeAspect;
import org.bimserver.models.ifc2x3.IfcWindowPanelPositionEnum;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Permeable Covering Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPermeableCoveringPropertiesImpl#getOperationType <em>Operation Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPermeableCoveringPropertiesImpl#getPanelPosition <em>Panel Position</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPermeableCoveringPropertiesImpl#getFrameDepth <em>Frame Depth</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPermeableCoveringPropertiesImpl#getFrameDepthAsString <em>Frame Depth As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPermeableCoveringPropertiesImpl#getFrameThickness <em>Frame Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPermeableCoveringPropertiesImpl#getFrameThicknessAsString <em>Frame Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcPermeableCoveringPropertiesImpl#getShapeAspectStyle <em>Shape Aspect Style</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcPermeableCoveringPropertiesImpl extends IfcPropertySetDefinitionImpl implements IfcPermeableCoveringProperties
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcPermeableCoveringPropertiesImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcPermeableCoveringProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPermeableCoveringOperationEnum getOperationType()
	{
		return (IfcPermeableCoveringOperationEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcPermeableCoveringProperties_OperationType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationType(IfcPermeableCoveringOperationEnum newOperationType)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPermeableCoveringProperties_OperationType(), newOperationType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcWindowPanelPositionEnum getPanelPosition()
	{
		return (IfcWindowPanelPositionEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcPermeableCoveringProperties_PanelPosition(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPanelPosition(IfcWindowPanelPositionEnum newPanelPosition)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPermeableCoveringProperties_PanelPosition(), newPanelPosition);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFrameDepth()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcPermeableCoveringProperties_FrameDepth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrameDepth(float newFrameDepth)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPermeableCoveringProperties_FrameDepth(), newFrameDepth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFrameDepth()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPermeableCoveringProperties_FrameDepth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFrameDepth()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPermeableCoveringProperties_FrameDepth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFrameDepthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcPermeableCoveringProperties_FrameDepthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrameDepthAsString(String newFrameDepthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPermeableCoveringProperties_FrameDepthAsString(), newFrameDepthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFrameDepthAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPermeableCoveringProperties_FrameDepthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFrameDepthAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPermeableCoveringProperties_FrameDepthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFrameThickness()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcPermeableCoveringProperties_FrameThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrameThickness(float newFrameThickness)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPermeableCoveringProperties_FrameThickness(), newFrameThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFrameThickness()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPermeableCoveringProperties_FrameThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFrameThickness()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPermeableCoveringProperties_FrameThickness());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFrameThicknessAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcPermeableCoveringProperties_FrameThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrameThicknessAsString(String newFrameThicknessAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPermeableCoveringProperties_FrameThicknessAsString(), newFrameThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFrameThicknessAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPermeableCoveringProperties_FrameThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFrameThicknessAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPermeableCoveringProperties_FrameThicknessAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcShapeAspect getShapeAspectStyle()
	{
		return (IfcShapeAspect)eGet(Ifc2x3Package.eINSTANCE.getIfcPermeableCoveringProperties_ShapeAspectStyle(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShapeAspectStyle(IfcShapeAspect newShapeAspectStyle)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcPermeableCoveringProperties_ShapeAspectStyle(), newShapeAspectStyle);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetShapeAspectStyle()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcPermeableCoveringProperties_ShapeAspectStyle());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetShapeAspectStyle()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcPermeableCoveringProperties_ShapeAspectStyle());
	}

} //IfcPermeableCoveringPropertiesImpl
