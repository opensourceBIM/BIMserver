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
import org.bimserver.models.ifc2x3.IfcConstraint;
import org.bimserver.models.ifc2x3.IfcConstraintAggregationRelationship;
import org.bimserver.models.ifc2x3.IfcLogicalOperatorEnum;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Constraint Aggregation Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstraintAggregationRelationshipImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstraintAggregationRelationshipImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstraintAggregationRelationshipImpl#getRelatingConstraint <em>Relating Constraint</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstraintAggregationRelationshipImpl#getRelatedConstraints <em>Related Constraints</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstraintAggregationRelationshipImpl#getLogicalAggregator <em>Logical Aggregator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcConstraintAggregationRelationshipImpl extends IdEObjectImpl implements IfcConstraintAggregationRelationship
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcConstraintAggregationRelationshipImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcConstraintAggregationRelationship();
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
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcConstraintAggregationRelationship_Name(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcConstraintAggregationRelationship_Name(), newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetName()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConstraintAggregationRelationship_Name());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetName()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConstraintAggregationRelationship_Name());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcConstraintAggregationRelationship_Description(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcConstraintAggregationRelationship_Description(), newDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDescription()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcConstraintAggregationRelationship_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDescription()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcConstraintAggregationRelationship_Description());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcConstraint getRelatingConstraint()
	{
		return (IfcConstraint)eGet(Ifc2x3Package.eINSTANCE.getIfcConstraintAggregationRelationship_RelatingConstraint(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingConstraint(IfcConstraint newRelatingConstraint)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcConstraintAggregationRelationship_RelatingConstraint(), newRelatingConstraint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcConstraint> getRelatedConstraints()
	{
		return (EList<IfcConstraint>)eGet(Ifc2x3Package.eINSTANCE.getIfcConstraintAggregationRelationship_RelatedConstraints(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcLogicalOperatorEnum getLogicalAggregator()
	{
		return (IfcLogicalOperatorEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcConstraintAggregationRelationship_LogicalAggregator(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLogicalAggregator(IfcLogicalOperatorEnum newLogicalAggregator)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcConstraintAggregationRelationship_LogicalAggregator(), newLogicalAggregator);
	}

} //IfcConstraintAggregationRelationshipImpl
