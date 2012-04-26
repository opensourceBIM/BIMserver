/**
 * Copyright (C) 2011  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3tc1.impl;

import org.bimserver.models.ifc2x3tc1.IfcRelInteractionRequirements;
import org.bimserver.models.ifc2x3tc1.IfcSpaceProgram;
import org.bimserver.models.ifc2x3tc1.IfcSpatialStructureElement;
import org.bimserver.models.ifc2x3tc1.LogPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Interaction Requirements</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRelInteractionRequirementsImpl#getDailyInteraction <em>Daily Interaction</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRelInteractionRequirementsImpl#getDailyInteractionAsString <em>Daily Interaction As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRelInteractionRequirementsImpl#getImportanceRating <em>Importance Rating</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRelInteractionRequirementsImpl#getImportanceRatingAsString <em>Importance Rating As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRelInteractionRequirementsImpl#getLocationOfInteraction <em>Location Of Interaction</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRelInteractionRequirementsImpl#getRelatedSpaceProgram <em>Related Space Program</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3tc1.impl.IfcRelInteractionRequirementsImpl#getRelatingSpaceProgram <em>Relating Space Program</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelInteractionRequirementsImpl extends IfcRelConnectsImpl implements IfcRelInteractionRequirements {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelInteractionRequirementsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LogPackage.Literals.IFC_REL_INTERACTION_REQUIREMENTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDailyInteraction() {
		return (Double) eGet(LogPackage.Literals.IFC_REL_INTERACTION_REQUIREMENTS__DAILY_INTERACTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDailyInteraction(double newDailyInteraction) {
		eSet(LogPackage.Literals.IFC_REL_INTERACTION_REQUIREMENTS__DAILY_INTERACTION, newDailyInteraction);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDailyInteraction() {
		eUnset(LogPackage.Literals.IFC_REL_INTERACTION_REQUIREMENTS__DAILY_INTERACTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDailyInteraction() {
		return eIsSet(LogPackage.Literals.IFC_REL_INTERACTION_REQUIREMENTS__DAILY_INTERACTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDailyInteractionAsString() {
		return (String) eGet(LogPackage.Literals.IFC_REL_INTERACTION_REQUIREMENTS__DAILY_INTERACTION_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDailyInteractionAsString(String newDailyInteractionAsString) {
		eSet(LogPackage.Literals.IFC_REL_INTERACTION_REQUIREMENTS__DAILY_INTERACTION_AS_STRING, newDailyInteractionAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDailyInteractionAsString() {
		eUnset(LogPackage.Literals.IFC_REL_INTERACTION_REQUIREMENTS__DAILY_INTERACTION_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDailyInteractionAsString() {
		return eIsSet(LogPackage.Literals.IFC_REL_INTERACTION_REQUIREMENTS__DAILY_INTERACTION_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getImportanceRating() {
		return (Double) eGet(LogPackage.Literals.IFC_REL_INTERACTION_REQUIREMENTS__IMPORTANCE_RATING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImportanceRating(double newImportanceRating) {
		eSet(LogPackage.Literals.IFC_REL_INTERACTION_REQUIREMENTS__IMPORTANCE_RATING, newImportanceRating);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetImportanceRating() {
		eUnset(LogPackage.Literals.IFC_REL_INTERACTION_REQUIREMENTS__IMPORTANCE_RATING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetImportanceRating() {
		return eIsSet(LogPackage.Literals.IFC_REL_INTERACTION_REQUIREMENTS__IMPORTANCE_RATING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImportanceRatingAsString() {
		return (String) eGet(LogPackage.Literals.IFC_REL_INTERACTION_REQUIREMENTS__IMPORTANCE_RATING_AS_STRING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImportanceRatingAsString(String newImportanceRatingAsString) {
		eSet(LogPackage.Literals.IFC_REL_INTERACTION_REQUIREMENTS__IMPORTANCE_RATING_AS_STRING, newImportanceRatingAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetImportanceRatingAsString() {
		eUnset(LogPackage.Literals.IFC_REL_INTERACTION_REQUIREMENTS__IMPORTANCE_RATING_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetImportanceRatingAsString() {
		return eIsSet(LogPackage.Literals.IFC_REL_INTERACTION_REQUIREMENTS__IMPORTANCE_RATING_AS_STRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpatialStructureElement getLocationOfInteraction() {
		return (IfcSpatialStructureElement) eGet(LogPackage.Literals.IFC_REL_INTERACTION_REQUIREMENTS__LOCATION_OF_INTERACTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocationOfInteraction(IfcSpatialStructureElement newLocationOfInteraction) {
		eSet(LogPackage.Literals.IFC_REL_INTERACTION_REQUIREMENTS__LOCATION_OF_INTERACTION, newLocationOfInteraction);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLocationOfInteraction() {
		eUnset(LogPackage.Literals.IFC_REL_INTERACTION_REQUIREMENTS__LOCATION_OF_INTERACTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLocationOfInteraction() {
		return eIsSet(LogPackage.Literals.IFC_REL_INTERACTION_REQUIREMENTS__LOCATION_OF_INTERACTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpaceProgram getRelatedSpaceProgram() {
		return (IfcSpaceProgram) eGet(LogPackage.Literals.IFC_REL_INTERACTION_REQUIREMENTS__RELATED_SPACE_PROGRAM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatedSpaceProgram(IfcSpaceProgram newRelatedSpaceProgram) {
		eSet(LogPackage.Literals.IFC_REL_INTERACTION_REQUIREMENTS__RELATED_SPACE_PROGRAM, newRelatedSpaceProgram);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSpaceProgram getRelatingSpaceProgram() {
		return (IfcSpaceProgram) eGet(LogPackage.Literals.IFC_REL_INTERACTION_REQUIREMENTS__RELATING_SPACE_PROGRAM, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingSpaceProgram(IfcSpaceProgram newRelatingSpaceProgram) {
		eSet(LogPackage.Literals.IFC_REL_INTERACTION_REQUIREMENTS__RELATING_SPACE_PROGRAM, newRelatingSpaceProgram);
	}

} //IfcRelInteractionRequirementsImpl
