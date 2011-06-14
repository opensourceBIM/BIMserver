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
import org.bimserver.models.ifc2x3.IfcRectangularTrimmedSurface;
import org.bimserver.models.ifc2x3.IfcSurface;
import org.bimserver.models.ifc2x3.Tristate;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rectangular Trimmed Surface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangularTrimmedSurfaceImpl#getBasisSurface <em>Basis Surface</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangularTrimmedSurfaceImpl#getU1 <em>U1</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangularTrimmedSurfaceImpl#getU1AsString <em>U1 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangularTrimmedSurfaceImpl#getV1 <em>V1</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangularTrimmedSurfaceImpl#getV1AsString <em>V1 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangularTrimmedSurfaceImpl#getU2 <em>U2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangularTrimmedSurfaceImpl#getU2AsString <em>U2 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangularTrimmedSurfaceImpl#getV2 <em>V2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangularTrimmedSurfaceImpl#getV2AsString <em>V2 As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangularTrimmedSurfaceImpl#getUsense <em>Usense</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangularTrimmedSurfaceImpl#getVsense <em>Vsense</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangularTrimmedSurfaceImpl#getDim <em>Dim</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRectangularTrimmedSurfaceImpl extends IfcBoundedSurfaceImpl implements IfcRectangularTrimmedSurface
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRectangularTrimmedSurfaceImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcRectangularTrimmedSurface();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurface getBasisSurface()
	{
		return (IfcSurface)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangularTrimmedSurface_BasisSurface(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasisSurface(IfcSurface newBasisSurface)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangularTrimmedSurface_BasisSurface(), newBasisSurface);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getU1()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangularTrimmedSurface_U1(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setU1(float newU1)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangularTrimmedSurface_U1(), newU1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getU1AsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangularTrimmedSurface_U1AsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setU1AsString(String newU1AsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangularTrimmedSurface_U1AsString(), newU1AsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getV1()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangularTrimmedSurface_V1(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setV1(float newV1)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangularTrimmedSurface_V1(), newV1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getV1AsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangularTrimmedSurface_V1AsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setV1AsString(String newV1AsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangularTrimmedSurface_V1AsString(), newV1AsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getU2()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangularTrimmedSurface_U2(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setU2(float newU2)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangularTrimmedSurface_U2(), newU2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getU2AsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangularTrimmedSurface_U2AsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setU2AsString(String newU2AsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangularTrimmedSurface_U2AsString(), newU2AsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getV2()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangularTrimmedSurface_V2(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setV2(float newV2)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangularTrimmedSurface_V2(), newV2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getV2AsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangularTrimmedSurface_V2AsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setV2AsString(String newV2AsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangularTrimmedSurface_V2AsString(), newV2AsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getUsense()
	{
		return (Tristate)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangularTrimmedSurface_Usense(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsense(Tristate newUsense)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangularTrimmedSurface_Usense(), newUsense);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getVsense()
	{
		return (Tristate)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangularTrimmedSurface_Vsense(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVsense(Tristate newVsense)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangularTrimmedSurface_Vsense(), newVsense);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDim()
	{
		return (Integer)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangularTrimmedSurface_Dim(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDim(int newDim)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangularTrimmedSurface_Dim(), newDim);
	}

} //IfcRectangularTrimmedSurfaceImpl
