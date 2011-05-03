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
import org.bimserver.models.ifc2x3.IfcReinforcingMesh;

import org.bimserver.models.ifc2x3.impl.IfcReinforcingElementImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Reinforcing Mesh</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcingMeshImpl#getMeshLength <em>Mesh Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcingMeshImpl#getMeshLengthAsString <em>Mesh Length As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcingMeshImpl#getMeshWidth <em>Mesh Width</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcingMeshImpl#getMeshWidthAsString <em>Mesh Width As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcingMeshImpl#getLongitudinalBarNominalDiameter <em>Longitudinal Bar Nominal Diameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcingMeshImpl#getLongitudinalBarNominalDiameterAsString <em>Longitudinal Bar Nominal Diameter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcingMeshImpl#getTransverseBarNominalDiameter <em>Transverse Bar Nominal Diameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcingMeshImpl#getTransverseBarNominalDiameterAsString <em>Transverse Bar Nominal Diameter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcingMeshImpl#getLongitudinalBarCrossSectionArea <em>Longitudinal Bar Cross Section Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcingMeshImpl#getLongitudinalBarCrossSectionAreaAsString <em>Longitudinal Bar Cross Section Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcingMeshImpl#getTransverseBarCrossSectionArea <em>Transverse Bar Cross Section Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcingMeshImpl#getTransverseBarCrossSectionAreaAsString <em>Transverse Bar Cross Section Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcingMeshImpl#getLongitudinalBarSpacing <em>Longitudinal Bar Spacing</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcingMeshImpl#getLongitudinalBarSpacingAsString <em>Longitudinal Bar Spacing As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcingMeshImpl#getTransverseBarSpacing <em>Transverse Bar Spacing</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcReinforcingMeshImpl#getTransverseBarSpacingAsString <em>Transverse Bar Spacing As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcReinforcingMeshImpl extends IfcReinforcingElementImpl implements IfcReinforcingMesh
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
	protected IfcReinforcingMeshImpl()
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
		return Ifc2x3Package.Literals.IFC_REINFORCING_MESH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMeshLength()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__MESH_LENGTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeshLength(float newMeshLength)
	{
		eSet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__MESH_LENGTH, newMeshLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMeshLength()
	{
		eUnset(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__MESH_LENGTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMeshLength()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__MESH_LENGTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMeshLengthAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__MESH_LENGTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeshLengthAsString(String newMeshLengthAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__MESH_LENGTH_AS_STRING, newMeshLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMeshLengthAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__MESH_LENGTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMeshLengthAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__MESH_LENGTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMeshWidth()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__MESH_WIDTH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeshWidth(float newMeshWidth)
	{
		eSet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__MESH_WIDTH, newMeshWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMeshWidth()
	{
		eUnset(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__MESH_WIDTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMeshWidth()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__MESH_WIDTH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMeshWidthAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__MESH_WIDTH_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeshWidthAsString(String newMeshWidthAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__MESH_WIDTH_AS_STRING, newMeshWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMeshWidthAsString()
	{
		eUnset(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__MESH_WIDTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMeshWidthAsString()
	{
		return eIsSet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__MESH_WIDTH_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLongitudinalBarNominalDiameter()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__LONGITUDINAL_BAR_NOMINAL_DIAMETER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitudinalBarNominalDiameter(float newLongitudinalBarNominalDiameter)
	{
		eSet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__LONGITUDINAL_BAR_NOMINAL_DIAMETER, newLongitudinalBarNominalDiameter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLongitudinalBarNominalDiameterAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__LONGITUDINAL_BAR_NOMINAL_DIAMETER_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitudinalBarNominalDiameterAsString(String newLongitudinalBarNominalDiameterAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__LONGITUDINAL_BAR_NOMINAL_DIAMETER_AS_STRING, newLongitudinalBarNominalDiameterAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTransverseBarNominalDiameter()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__TRANSVERSE_BAR_NOMINAL_DIAMETER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransverseBarNominalDiameter(float newTransverseBarNominalDiameter)
	{
		eSet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__TRANSVERSE_BAR_NOMINAL_DIAMETER, newTransverseBarNominalDiameter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransverseBarNominalDiameterAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__TRANSVERSE_BAR_NOMINAL_DIAMETER_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransverseBarNominalDiameterAsString(String newTransverseBarNominalDiameterAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__TRANSVERSE_BAR_NOMINAL_DIAMETER_AS_STRING, newTransverseBarNominalDiameterAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLongitudinalBarCrossSectionArea()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__LONGITUDINAL_BAR_CROSS_SECTION_AREA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitudinalBarCrossSectionArea(float newLongitudinalBarCrossSectionArea)
	{
		eSet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__LONGITUDINAL_BAR_CROSS_SECTION_AREA, newLongitudinalBarCrossSectionArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLongitudinalBarCrossSectionAreaAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__LONGITUDINAL_BAR_CROSS_SECTION_AREA_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitudinalBarCrossSectionAreaAsString(String newLongitudinalBarCrossSectionAreaAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__LONGITUDINAL_BAR_CROSS_SECTION_AREA_AS_STRING, newLongitudinalBarCrossSectionAreaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTransverseBarCrossSectionArea()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__TRANSVERSE_BAR_CROSS_SECTION_AREA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransverseBarCrossSectionArea(float newTransverseBarCrossSectionArea)
	{
		eSet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__TRANSVERSE_BAR_CROSS_SECTION_AREA, newTransverseBarCrossSectionArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransverseBarCrossSectionAreaAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__TRANSVERSE_BAR_CROSS_SECTION_AREA_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransverseBarCrossSectionAreaAsString(String newTransverseBarCrossSectionAreaAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__TRANSVERSE_BAR_CROSS_SECTION_AREA_AS_STRING, newTransverseBarCrossSectionAreaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLongitudinalBarSpacing()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__LONGITUDINAL_BAR_SPACING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitudinalBarSpacing(float newLongitudinalBarSpacing)
	{
		eSet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__LONGITUDINAL_BAR_SPACING, newLongitudinalBarSpacing);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLongitudinalBarSpacingAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__LONGITUDINAL_BAR_SPACING_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitudinalBarSpacingAsString(String newLongitudinalBarSpacingAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__LONGITUDINAL_BAR_SPACING_AS_STRING, newLongitudinalBarSpacingAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTransverseBarSpacing()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__TRANSVERSE_BAR_SPACING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransverseBarSpacing(float newTransverseBarSpacing)
	{
		eSet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__TRANSVERSE_BAR_SPACING, newTransverseBarSpacing);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransverseBarSpacingAsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__TRANSVERSE_BAR_SPACING_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransverseBarSpacingAsString(String newTransverseBarSpacingAsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_REINFORCING_MESH__TRANSVERSE_BAR_SPACING_AS_STRING, newTransverseBarSpacingAsString);
	}

} //IfcReinforcingMeshImpl
