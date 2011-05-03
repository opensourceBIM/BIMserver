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

import org.bimserver.models.ifc2x3.impl.IfcBoundedSurfaceImpl;

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
	public static final String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

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
		return Ifc2x3Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSurface getBasisSurface()
	{
		return (IfcSurface)eGet(Ifc2x3Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__BASIS_SURFACE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasisSurface(IfcSurface newBasisSurface)
	{
		eSet(Ifc2x3Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__BASIS_SURFACE, newBasisSurface);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getU1()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__U1, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setU1(float newU1)
	{
		eSet(Ifc2x3Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__U1, newU1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getU1AsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__U1_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setU1AsString(String newU1AsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__U1_AS_STRING, newU1AsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getV1()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__V1, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setV1(float newV1)
	{
		eSet(Ifc2x3Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__V1, newV1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getV1AsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__V1_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setV1AsString(String newV1AsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__V1_AS_STRING, newV1AsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getU2()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__U2, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setU2(float newU2)
	{
		eSet(Ifc2x3Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__U2, newU2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getU2AsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__U2_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setU2AsString(String newU2AsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__U2_AS_STRING, newU2AsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getV2()
	{
		return (Float)eGet(Ifc2x3Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__V2, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setV2(float newV2)
	{
		eSet(Ifc2x3Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__V2, newV2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getV2AsString()
	{
		return (String)eGet(Ifc2x3Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__V2_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setV2AsString(String newV2AsString)
	{
		eSet(Ifc2x3Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__V2_AS_STRING, newV2AsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getUsense()
	{
		return (Tristate)eGet(Ifc2x3Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__USENSE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsense(Tristate newUsense)
	{
		eSet(Ifc2x3Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__USENSE, newUsense);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getVsense()
	{
		return (Tristate)eGet(Ifc2x3Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__VSENSE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVsense(Tristate newVsense)
	{
		eSet(Ifc2x3Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__VSENSE, newVsense);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDim()
	{
		return (Integer)eGet(Ifc2x3Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__DIM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDim(int newDim)
	{
		eSet(Ifc2x3Package.Literals.IFC_RECTANGULAR_TRIMMED_SURFACE__DIM, newDim);
	}

} //IfcRectangularTrimmedSurfaceImpl
