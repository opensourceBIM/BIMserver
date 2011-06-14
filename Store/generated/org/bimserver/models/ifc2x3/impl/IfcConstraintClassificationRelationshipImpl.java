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
import org.bimserver.models.ifc2x3.IfcClassificationNotationSelect;
import org.bimserver.models.ifc2x3.IfcConstraint;
import org.bimserver.models.ifc2x3.IfcConstraintClassificationRelationship;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Constraint Classification Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstraintClassificationRelationshipImpl#getClassifiedConstraint <em>Classified Constraint</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcConstraintClassificationRelationshipImpl#getRelatedClassifications <em>Related Classifications</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcConstraintClassificationRelationshipImpl extends IdEObjectImpl implements IfcConstraintClassificationRelationship
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcConstraintClassificationRelationshipImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcConstraintClassificationRelationship();
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
	public IfcConstraint getClassifiedConstraint()
	{
		return (IfcConstraint)eGet(Ifc2x3Package.eINSTANCE.getIfcConstraintClassificationRelationship_ClassifiedConstraint(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassifiedConstraint(IfcConstraint newClassifiedConstraint)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcConstraintClassificationRelationship_ClassifiedConstraint(), newClassifiedConstraint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcClassificationNotationSelect> getRelatedClassifications()
	{
		return (EList<IfcClassificationNotationSelect>)eGet(Ifc2x3Package.eINSTANCE.getIfcConstraintClassificationRelationship_RelatedClassifications(), true);
	}

} //IfcConstraintClassificationRelationshipImpl
