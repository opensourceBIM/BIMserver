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
import org.bimserver.models.ifc2x3.IfcAnnotationFillAreaOccurrence;
import org.bimserver.models.ifc2x3.IfcGlobalOrLocalEnum;
import org.bimserver.models.ifc2x3.IfcPoint;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Annotation Fill Area Occurrence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAnnotationFillAreaOccurrenceImpl#getFillStyleTarget <em>Fill Style Target</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcAnnotationFillAreaOccurrenceImpl#getGlobalOrLocal <em>Global Or Local</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcAnnotationFillAreaOccurrenceImpl extends IfcAnnotationOccurrenceImpl implements IfcAnnotationFillAreaOccurrence
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcAnnotationFillAreaOccurrenceImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcAnnotationFillAreaOccurrence();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcPoint getFillStyleTarget()
	{
		return (IfcPoint)eGet(Ifc2x3Package.eINSTANCE.getIfcAnnotationFillAreaOccurrence_FillStyleTarget(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFillStyleTarget(IfcPoint newFillStyleTarget)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcAnnotationFillAreaOccurrence_FillStyleTarget(), newFillStyleTarget);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFillStyleTarget()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcAnnotationFillAreaOccurrence_FillStyleTarget());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFillStyleTarget()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcAnnotationFillAreaOccurrence_FillStyleTarget());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcGlobalOrLocalEnum getGlobalOrLocal()
	{
		return (IfcGlobalOrLocalEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcAnnotationFillAreaOccurrence_GlobalOrLocal(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGlobalOrLocal(IfcGlobalOrLocalEnum newGlobalOrLocal)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcAnnotationFillAreaOccurrence_GlobalOrLocal(), newGlobalOrLocal);
	}

} //IfcAnnotationFillAreaOccurrenceImpl
