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
import org.bimserver.models.ifc2x3.IfcMechanicalFastener;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Mechanical Fastener</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalFastenerImpl#getNominalDiameter <em>Nominal Diameter</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalFastenerImpl#getNominalDiameterAsString <em>Nominal Diameter As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalFastenerImpl#getNominalLength <em>Nominal Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMechanicalFastenerImpl#getNominalLengthAsString <em>Nominal Length As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcMechanicalFastenerImpl extends IfcFastenerImpl implements IfcMechanicalFastener
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMechanicalFastenerImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcMechanicalFastener();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getNominalDiameter()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalFastener_NominalDiameter(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNominalDiameter(float newNominalDiameter)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalFastener_NominalDiameter(), newNominalDiameter);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetNominalDiameter()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalFastener_NominalDiameter());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetNominalDiameter()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalFastener_NominalDiameter());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNominalDiameterAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalFastener_NominalDiameterAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNominalDiameterAsString(String newNominalDiameterAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalFastener_NominalDiameterAsString(), newNominalDiameterAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetNominalDiameterAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalFastener_NominalDiameterAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetNominalDiameterAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalFastener_NominalDiameterAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getNominalLength()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalFastener_NominalLength(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNominalLength(float newNominalLength)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalFastener_NominalLength(), newNominalLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetNominalLength()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalFastener_NominalLength());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetNominalLength()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalFastener_NominalLength());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNominalLengthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcMechanicalFastener_NominalLengthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNominalLengthAsString(String newNominalLengthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalFastener_NominalLengthAsString(), newNominalLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetNominalLengthAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcMechanicalFastener_NominalLengthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetNominalLengthAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcMechanicalFastener_NominalLengthAsString());
	}

} //IfcMechanicalFastenerImpl
