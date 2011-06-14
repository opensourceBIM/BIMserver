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
import org.bimserver.models.ifc2x3.IfcStairFlight;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Stair Flight</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStairFlightImpl#getNumberOfRiser <em>Number Of Riser</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStairFlightImpl#getNumberOfTreads <em>Number Of Treads</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStairFlightImpl#getRiserHeight <em>Riser Height</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStairFlightImpl#getRiserHeightAsString <em>Riser Height As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStairFlightImpl#getTreadLength <em>Tread Length</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStairFlightImpl#getTreadLengthAsString <em>Tread Length As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcStairFlightImpl extends IfcBuildingElementImpl implements IfcStairFlight
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStairFlightImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcStairFlight();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberOfRiser()
	{
		return (Integer)eGet(Ifc2x3Package.eINSTANCE.getIfcStairFlight_NumberOfRiser(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfRiser(int newNumberOfRiser)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStairFlight_NumberOfRiser(), newNumberOfRiser);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumberOfTreads()
	{
		return (Integer)eGet(Ifc2x3Package.eINSTANCE.getIfcStairFlight_NumberOfTreads(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberOfTreads(int newNumberOfTreads)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStairFlight_NumberOfTreads(), newNumberOfTreads);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getRiserHeight()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStairFlight_RiserHeight(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRiserHeight(float newRiserHeight)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStairFlight_RiserHeight(), newRiserHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRiserHeight()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStairFlight_RiserHeight());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRiserHeight()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStairFlight_RiserHeight());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRiserHeightAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStairFlight_RiserHeightAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRiserHeightAsString(String newRiserHeightAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStairFlight_RiserHeightAsString(), newRiserHeightAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRiserHeightAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStairFlight_RiserHeightAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRiserHeightAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStairFlight_RiserHeightAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTreadLength()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStairFlight_TreadLength(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTreadLength(float newTreadLength)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStairFlight_TreadLength(), newTreadLength);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTreadLength()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStairFlight_TreadLength());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTreadLength()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStairFlight_TreadLength());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTreadLengthAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStairFlight_TreadLengthAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTreadLengthAsString(String newTreadLengthAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStairFlight_TreadLengthAsString(), newTreadLengthAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTreadLengthAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStairFlight_TreadLengthAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTreadLengthAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStairFlight_TreadLengthAsString());
	}

} //IfcStairFlightImpl
