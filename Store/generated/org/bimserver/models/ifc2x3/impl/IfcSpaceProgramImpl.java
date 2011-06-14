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
import org.bimserver.models.ifc2x3.IfcRelInteractionRequirements;
import org.bimserver.models.ifc2x3.IfcSpaceProgram;
import org.bimserver.models.ifc2x3.IfcSpatialStructureElement;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Space Program</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpaceProgramImpl#getSpaceProgramIdentifier <em>Space Program Identifier</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpaceProgramImpl#getMaxRequiredArea <em>Max Required Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpaceProgramImpl#getMaxRequiredAreaAsString <em>Max Required Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpaceProgramImpl#getMinRequiredArea <em>Min Required Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpaceProgramImpl#getMinRequiredAreaAsString <em>Min Required Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpaceProgramImpl#getRequestedLocation <em>Requested Location</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpaceProgramImpl#getStandardRequiredArea <em>Standard Required Area</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpaceProgramImpl#getStandardRequiredAreaAsString <em>Standard Required Area As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpaceProgramImpl#getHasInteractionReqsFrom <em>Has Interaction Reqs From</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSpaceProgramImpl#getHasInteractionReqsTo <em>Has Interaction Reqs To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcSpaceProgramImpl extends IfcControlImpl implements IfcSpaceProgram
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSpaceProgramImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcSpaceProgram();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSpaceProgramIdentifier()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_SpaceProgramIdentifier(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpaceProgramIdentifier(String newSpaceProgramIdentifier)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_SpaceProgramIdentifier(), newSpaceProgramIdentifier);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMaxRequiredArea()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_MaxRequiredArea(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxRequiredArea(float newMaxRequiredArea)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_MaxRequiredArea(), newMaxRequiredArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaxRequiredArea()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_MaxRequiredArea());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaxRequiredArea()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_MaxRequiredArea());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaxRequiredAreaAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_MaxRequiredAreaAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxRequiredAreaAsString(String newMaxRequiredAreaAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_MaxRequiredAreaAsString(), newMaxRequiredAreaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaxRequiredAreaAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_MaxRequiredAreaAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaxRequiredAreaAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_MaxRequiredAreaAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getMinRequiredArea()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_MinRequiredArea(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinRequiredArea(float newMinRequiredArea)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_MinRequiredArea(), newMinRequiredArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinRequiredArea()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_MinRequiredArea());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinRequiredArea()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_MinRequiredArea());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinRequiredAreaAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_MinRequiredAreaAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinRequiredAreaAsString(String newMinRequiredAreaAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_MinRequiredAreaAsString(), newMinRequiredAreaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinRequiredAreaAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_MinRequiredAreaAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinRequiredAreaAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_MinRequiredAreaAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpatialStructureElement getRequestedLocation()
	{
		return (IfcSpatialStructureElement)eGet(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_RequestedLocation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequestedLocation(IfcSpatialStructureElement newRequestedLocation)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_RequestedLocation(), newRequestedLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRequestedLocation()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_RequestedLocation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRequestedLocation()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_RequestedLocation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getStandardRequiredArea()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_StandardRequiredArea(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStandardRequiredArea(float newStandardRequiredArea)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_StandardRequiredArea(), newStandardRequiredArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStandardRequiredAreaAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_StandardRequiredAreaAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStandardRequiredAreaAsString(String newStandardRequiredAreaAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_StandardRequiredAreaAsString(), newStandardRequiredAreaAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelInteractionRequirements> getHasInteractionReqsFrom()
	{
		return (EList<IfcRelInteractionRequirements>)eGet(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_HasInteractionReqsFrom(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcRelInteractionRequirements> getHasInteractionReqsTo()
	{
		return (EList<IfcRelInteractionRequirements>)eGet(Ifc2x3Package.eINSTANCE.getIfcSpaceProgram_HasInteractionReqsTo(), true);
	}

} //IfcSpaceProgramImpl
