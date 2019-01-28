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

import org.bimserver.models.store.Project;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>New Project Added</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.log.NewProjectAdded#getParentProject <em>Parent Project</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.log.LogPackage#getNewProjectAdded()
 * @model
 * @generated
 */
public interface NewProjectAdded extends ProjectRelated {
	/**
	 * Returns the value of the '<em><b>Parent Project</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Project</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Project</em>' reference.
	 * @see #setParentProject(Project)
	 * @see org.bimserver.models.log.LogPackage#getNewProjectAdded_ParentProject()
	 * @model
	 * @generated
	 */
	Project getParentProject();

	/**
	 * Sets the value of the '{@link org.bimserver.models.log.NewProjectAdded#getParentProject <em>Parent Project</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Project</em>' reference.
	 * @see #getParentProject()
	 * @generated
	 */
	void setParentProject(Project value);

} // NewProjectAdded
