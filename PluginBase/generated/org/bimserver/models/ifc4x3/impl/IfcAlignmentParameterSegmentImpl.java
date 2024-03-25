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
package org.bimserver.models.ifc4x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc4x3.Ifc4x3Package;
import org.bimserver.models.ifc4x3.IfcAlignmentParameterSegment;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Alignment Parameter Segment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentParameterSegmentImpl#getStartTag <em>Start Tag</em>}</li>
 *   <li>{@link org.bimserver.models.ifc4x3.impl.IfcAlignmentParameterSegmentImpl#getEndTag <em>End Tag</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfcAlignmentParameterSegmentImpl extends IdEObjectImpl implements IfcAlignmentParameterSegment {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcAlignmentParameterSegmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc4x3Package.Literals.IFC_ALIGNMENT_PARAMETER_SEGMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getStartTag() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_PARAMETER_SEGMENT__START_TAG, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartTag(String newStartTag) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_PARAMETER_SEGMENT__START_TAG, newStartTag);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetStartTag() {
		eUnset(Ifc4x3Package.Literals.IFC_ALIGNMENT_PARAMETER_SEGMENT__START_TAG);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetStartTag() {
		return eIsSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_PARAMETER_SEGMENT__START_TAG);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEndTag() {
		return (String) eGet(Ifc4x3Package.Literals.IFC_ALIGNMENT_PARAMETER_SEGMENT__END_TAG, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEndTag(String newEndTag) {
		eSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_PARAMETER_SEGMENT__END_TAG, newEndTag);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEndTag() {
		eUnset(Ifc4x3Package.Literals.IFC_ALIGNMENT_PARAMETER_SEGMENT__END_TAG);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEndTag() {
		return eIsSet(Ifc4x3Package.Literals.IFC_ALIGNMENT_PARAMETER_SEGMENT__END_TAG);
	}

} //IfcAlignmentParameterSegmentImpl
