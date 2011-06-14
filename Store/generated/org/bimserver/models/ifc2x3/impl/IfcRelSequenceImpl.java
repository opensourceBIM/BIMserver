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
import org.bimserver.models.ifc2x3.IfcProcess;
import org.bimserver.models.ifc2x3.IfcRelSequence;
import org.bimserver.models.ifc2x3.IfcSequenceEnum;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelSequenceImpl#getRelatingProcess <em>Relating Process</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelSequenceImpl#getRelatedProcess <em>Related Process</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelSequenceImpl#getTimeLag <em>Time Lag</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelSequenceImpl#getTimeLagAsString <em>Time Lag As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelSequenceImpl#getSequenceType <em>Sequence Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelSequenceImpl extends IfcRelConnectsImpl implements IfcRelSequence
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelSequenceImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcRelSequence();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProcess getRelatingProcess()
	{
		return (IfcProcess)eGet(Ifc2x3Package.eINSTANCE.getIfcRelSequence_RelatingProcess(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingProcess(IfcProcess newRelatingProcess)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelSequence_RelatingProcess(), newRelatingProcess);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProcess getRelatedProcess()
	{
		return (IfcProcess)eGet(Ifc2x3Package.eINSTANCE.getIfcRelSequence_RelatedProcess(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatedProcess(IfcProcess newRelatedProcess)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelSequence_RelatedProcess(), newRelatedProcess);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getTimeLag()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRelSequence_TimeLag(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeLag(float newTimeLag)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelSequence_TimeLag(), newTimeLag);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTimeLagAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRelSequence_TimeLagAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeLagAsString(String newTimeLagAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelSequence_TimeLagAsString(), newTimeLagAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSequenceEnum getSequenceType()
	{
		return (IfcSequenceEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcRelSequence_SequenceType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequenceType(IfcSequenceEnum newSequenceType)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelSequence_SequenceType(), newSequenceType);
	}

} //IfcRelSequenceImpl
