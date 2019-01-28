/**
 * Copyright (C) 2009-2014 BIMserver.org
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
package org.bimserver.models.ifc2x3tc1;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

public interface IfcStructuralAction extends IfcStructuralActivity {
	/**
	 * Returns the value of the '<em><b>Destabilizing Load</b></em>' attribute.
	 * The literals are from the enumeration {@link org.bimserver.models.ifc2x3tc1.Tristate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Destabilizing Load</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Destabilizing Load</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.Tristate
	 * @see #setDestabilizingLoad(Tristate)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralAction_DestabilizingLoad()
	 * @model
	 * @generated
	 */
	Tristate getDestabilizingLoad();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralAction#getDestabilizingLoad <em>Destabilizing Load</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Destabilizing Load</em>' attribute.
	 * @see org.bimserver.models.ifc2x3tc1.Tristate
	 * @see #getDestabilizingLoad()
	 * @generated
	 */
	void setDestabilizingLoad(Tristate value);

	/**
	 * Returns the value of the '<em><b>Caused By</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralReaction#getCauses <em>Causes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Caused By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Caused By</em>' reference.
	 * @see #isSetCausedBy()
	 * @see #unsetCausedBy()
	 * @see #setCausedBy(IfcStructuralReaction)
	 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcStructuralAction_CausedBy()
	 * @see org.bimserver.models.ifc2x3tc1.IfcStructuralReaction#getCauses
	 * @model opposite="Causes" unsettable="true"
	 * @generated
	 */
	IfcStructuralReaction getCausedBy();

	/**
	 * Sets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralAction#getCausedBy <em>Caused By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Caused By</em>' reference.
	 * @see #isSetCausedBy()
	 * @see #unsetCausedBy()
	 * @see #getCausedBy()
	 * @generated
	 */
	void setCausedBy(IfcStructuralReaction value);

	/**
	 * Unsets the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralAction#getCausedBy <em>Caused By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCausedBy()
	 * @see #getCausedBy()
	 * @see #setCausedBy(IfcStructuralReaction)
	 * @generated
	 */
	void unsetCausedBy();

	/**
	 * Returns whether the value of the '{@link org.bimserver.models.ifc2x3tc1.IfcStructuralAction#getCausedBy <em>Caused By</em>}' reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Caused By</em>' reference is set.
	 * @see #unsetCausedBy()
	 * @see #getCausedBy()
	 * @see #setCausedBy(IfcStructuralReaction)
	 * @generated
	 */
	boolean isSetCausedBy();

} // IfcStructuralAction
