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
		return Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMeshLength()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_MeshLength(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeshLength(float newMeshLength)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_MeshLength(), newMeshLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMeshLength()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_MeshLength());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMeshLength()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_MeshLength());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMeshLengthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_MeshLengthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeshLengthAsString(String newMeshLengthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_MeshLengthAsString(), newMeshLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMeshLengthAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_MeshLengthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMeshLengthAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_MeshLengthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMeshWidth()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_MeshWidth(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeshWidth(float newMeshWidth)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_MeshWidth(), newMeshWidth);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMeshWidth()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_MeshWidth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMeshWidth()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_MeshWidth());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMeshWidthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_MeshWidthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeshWidthAsString(String newMeshWidthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_MeshWidthAsString(), newMeshWidthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMeshWidthAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_MeshWidthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMeshWidthAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_MeshWidthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLongitudinalBarNominalDiameter()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarNominalDiameter(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitudinalBarNominalDiameter(float newLongitudinalBarNominalDiameter)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarNominalDiameter(), newLongitudinalBarNominalDiameter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLongitudinalBarNominalDiameterAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarNominalDiameterAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitudinalBarNominalDiameterAsString(String newLongitudinalBarNominalDiameterAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarNominalDiameterAsString(), newLongitudinalBarNominalDiameterAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTransverseBarNominalDiameter()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarNominalDiameter(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransverseBarNominalDiameter(float newTransverseBarNominalDiameter)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarNominalDiameter(), newTransverseBarNominalDiameter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransverseBarNominalDiameterAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarNominalDiameterAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransverseBarNominalDiameterAsString(String newTransverseBarNominalDiameterAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarNominalDiameterAsString(), newTransverseBarNominalDiameterAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLongitudinalBarCrossSectionArea()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarCrossSectionArea(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitudinalBarCrossSectionArea(float newLongitudinalBarCrossSectionArea)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarCrossSectionArea(), newLongitudinalBarCrossSectionArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLongitudinalBarCrossSectionAreaAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarCrossSectionAreaAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitudinalBarCrossSectionAreaAsString(String newLongitudinalBarCrossSectionAreaAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarCrossSectionAreaAsString(), newLongitudinalBarCrossSectionAreaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTransverseBarCrossSectionArea()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarCrossSectionArea(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransverseBarCrossSectionArea(float newTransverseBarCrossSectionArea)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarCrossSectionArea(), newTransverseBarCrossSectionArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransverseBarCrossSectionAreaAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarCrossSectionAreaAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransverseBarCrossSectionAreaAsString(String newTransverseBarCrossSectionAreaAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarCrossSectionAreaAsString(), newTransverseBarCrossSectionAreaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLongitudinalBarSpacing()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarSpacing(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitudinalBarSpacing(float newLongitudinalBarSpacing)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarSpacing(), newLongitudinalBarSpacing);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLongitudinalBarSpacingAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarSpacingAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitudinalBarSpacingAsString(String newLongitudinalBarSpacingAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_LongitudinalBarSpacingAsString(), newLongitudinalBarSpacingAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTransverseBarSpacing()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarSpacing(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransverseBarSpacing(float newTransverseBarSpacing)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarSpacing(), newTransverseBarSpacing);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransverseBarSpacingAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarSpacingAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransverseBarSpacingAsString(String newTransverseBarSpacingAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcReinforcingMesh_TransverseBarSpacingAsString(), newTransverseBarSpacingAsString);
	}

} //IfcReinforcingMeshImpl
