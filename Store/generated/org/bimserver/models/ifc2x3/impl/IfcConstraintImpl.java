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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcActorSelect;
import org.bimserver.models.ifc2x3.IfcConstraint;
import org.bimserver.models.ifc2x3.IfcConstraintAggregationRelationship;
import org.bimserver.models.ifc2x3.IfcConstraintClassificationRelationship;
import org.bimserver.models.ifc2x3.IfcConstraintEnum;
import org.bimserver.models.ifc2x3.IfcConstraintRelationship;
import org.bimserver.models.ifc2x3.IfcDateTimeSelect;
import org.bimserver.models.ifc2x3.IfcPropertyConstraintRelationship;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstraintImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstraintImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstraintImpl#getConstraintGrade <em>Constraint Grade</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstraintImpl#getConstraintSource <em>Constraint Source</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstraintImpl#getCreatingActor <em>Creating Actor</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstraintImpl#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstraintImpl#getUserDefinedGrade <em>User Defined Grade</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstraintImpl#getClassifiedAs <em>Classified As</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstraintImpl#getRelatesConstraints <em>Relates Constraints</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstraintImpl#getIsRelatedWith <em>Is Related With</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstraintImpl#getPropertiesForConstraint <em>Properties For Constraint</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstraintImpl#getAggregates <em>Aggregates</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstraintImpl#getIsAggregatedIn <em>Is Aggregated In</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcConstraintImpl extends IdEObjectImpl implements IfcConstraint
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcConstraintImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcConstraint();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount()
	{
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcConstraint_Name(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcConstraint_Name(), newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcConstraint_Description(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcConstraint_Description(), newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDescription()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConstraint_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDescription()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConstraint_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConstraintEnum getConstraintGrade()
	{
		return (IfcConstraintEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcConstraint_ConstraintGrade(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraintGrade(IfcConstraintEnum newConstraintGrade)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcConstraint_ConstraintGrade(), newConstraintGrade);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConstraintSource()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcConstraint_ConstraintSource(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraintSource(String newConstraintSource)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcConstraint_ConstraintSource(), newConstraintSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetConstraintSource()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConstraint_ConstraintSource());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetConstraintSource()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConstraint_ConstraintSource());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcActorSelect getCreatingActor()
	{
		return (IfcActorSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcConstraint_CreatingActor(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreatingActor(IfcActorSelect newCreatingActor)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcConstraint_CreatingActor(), newCreatingActor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCreatingActor()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConstraint_CreatingActor());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCreatingActor()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConstraint_CreatingActor());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcDateTimeSelect getCreationTime()
	{
		return (IfcDateTimeSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcConstraint_CreationTime(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationTime(IfcDateTimeSelect newCreationTime)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcConstraint_CreationTime(), newCreationTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCreationTime()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConstraint_CreationTime());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCreationTime()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConstraint_CreationTime());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserDefinedGrade()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcConstraint_UserDefinedGrade(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserDefinedGrade(String newUserDefinedGrade)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcConstraint_UserDefinedGrade(), newUserDefinedGrade);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserDefinedGrade()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConstraint_UserDefinedGrade());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserDefinedGrade()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConstraint_UserDefinedGrade());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcConstraintClassificationRelationship> getClassifiedAs()
	{
		return (EList<IfcConstraintClassificationRelationship>)eGet(Ifc2x3Package.eINSTANCE.getIfcConstraint_ClassifiedAs(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcConstraintRelationship> getRelatesConstraints()
	{
		return (EList<IfcConstraintRelationship>)eGet(Ifc2x3Package.eINSTANCE.getIfcConstraint_RelatesConstraints(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcConstraintRelationship> getIsRelatedWith()
	{
		return (EList<IfcConstraintRelationship>)eGet(Ifc2x3Package.eINSTANCE.getIfcConstraint_IsRelatedWith(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcPropertyConstraintRelationship> getPropertiesForConstraint()
	{
		return (EList<IfcPropertyConstraintRelationship>)eGet(Ifc2x3Package.eINSTANCE.getIfcConstraint_PropertiesForConstraint(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcConstraintAggregationRelationship> getAggregates()
	{
		return (EList<IfcConstraintAggregationRelationship>)eGet(Ifc2x3Package.eINSTANCE.getIfcConstraint_Aggregates(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcConstraintAggregationRelationship> getIsAggregatedIn()
	{
		return (EList<IfcConstraintAggregationRelationship>)eGet(Ifc2x3Package.eINSTANCE.getIfcConstraint_IsAggregatedIn(), true);
	}

} //IfcConstraintImpl
