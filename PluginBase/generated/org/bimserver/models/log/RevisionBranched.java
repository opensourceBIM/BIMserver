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
package org.bimserver.models.log;

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

import org.bimserver.models.store.Revision;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Revision Branched</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.log.RevisionBranched#getOldrevision <em>Oldrevision</em>}</li>
 *   <li>{@link org.bimserver.models.log.RevisionBranched#getNewrevision <em>Newrevision</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.log.LogPackage#getRevisionBranched()
 * @model
 * @generated
 */
public interface RevisionBranched extends LogAction {
	/**
	 * Returns the value of the '<em><b>Oldrevision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Oldrevision</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Oldrevision</em>' reference.
	 * @see #setOldrevision(Revision)
	 * @see org.bimserver.models.log.LogPackage#getRevisionBranched_Oldrevision()
	 * @model
	 * @generated
	 */
	Revision getOldrevision();

	/**
	 * Sets the value of the '{@link org.bimserver.models.log.RevisionBranched#getOldrevision <em>Oldrevision</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Oldrevision</em>' reference.
	 * @see #getOldrevision()
	 * @generated
	 */
	void setOldrevision(Revision value);

	/**
	 * Returns the value of the '<em><b>Newrevision</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Newrevision</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Newrevision</em>' reference.
	 * @see #setNewrevision(Revision)
	 * @see org.bimserver.models.log.LogPackage#getRevisionBranched_Newrevision()
	 * @model
	 * @generated
	 */
	Revision getNewrevision();

	/**
	 * Sets the value of the '{@link org.bimserver.models.log.RevisionBranched#getNewrevision <em>Newrevision</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Newrevision</em>' reference.
	 * @see #getNewrevision()
	 * @generated
	 */
	void setNewrevision(Revision value);

} // RevisionBranched
