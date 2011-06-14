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
import org.bimserver.models.ifc2x3.IfcMaterial;
import org.bimserver.models.ifc2x3.IfcMaterialClassificationRelationship;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Material Classification Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMaterialClassificationRelationshipImpl#getMaterialClassifications <em>Material Classifications</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcMaterialClassificationRelationshipImpl#getClassifiedMaterial <em>Classified Material</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcMaterialClassificationRelationshipImpl extends IdEObjectImpl implements IfcMaterialClassificationRelationship
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcMaterialClassificationRelationshipImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcMaterialClassificationRelationship();
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
	@SuppressWarnings("unchecked")
	public EList<IfcClassificationNotationSelect> getMaterialClassifications()
	{
		return (EList<IfcClassificationNotationSelect>)eGet(Ifc2x3Package.eINSTANCE.getIfcMaterialClassificationRelationship_MaterialClassifications(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcMaterial getClassifiedMaterial()
	{
		return (IfcMaterial)eGet(Ifc2x3Package.eINSTANCE.getIfcMaterialClassificationRelationship_ClassifiedMaterial(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassifiedMaterial(IfcMaterial newClassifiedMaterial)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcMaterialClassificationRelationship_ClassifiedMaterial(), newClassifiedMaterial);
	}

} //IfcMaterialClassificationRelationshipImpl
