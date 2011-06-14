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
import org.bimserver.models.ifc2x3.IfcCurve;
import org.bimserver.models.ifc2x3.IfcTrimmedCurve;
import org.bimserver.models.ifc2x3.IfcTrimmingPreference;
import org.bimserver.models.ifc2x3.IfcTrimmingSelect;
import org.bimserver.models.ifc2x3.Tristate;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Trimmed Curve</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTrimmedCurveImpl#getBasisCurve <em>Basis Curve</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTrimmedCurveImpl#getTrim1 <em>Trim1</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTrimmedCurveImpl#getTrim2 <em>Trim2</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTrimmedCurveImpl#getSenseAgreement <em>Sense Agreement</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTrimmedCurveImpl#getMasterRepresentation <em>Master Representation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcTrimmedCurveImpl extends IfcBoundedCurveImpl implements IfcTrimmedCurve
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTrimmedCurveImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcTrimmedCurve();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcCurve getBasisCurve()
	{
		return (IfcCurve)eGet(Ifc2x3Package.eINSTANCE.getIfcTrimmedCurve_BasisCurve(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasisCurve(IfcCurve newBasisCurve)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTrimmedCurve_BasisCurve(), newBasisCurve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcTrimmingSelect> getTrim1()
	{
		return (EList<IfcTrimmingSelect>)eGet(Ifc2x3Package.eINSTANCE.getIfcTrimmedCurve_Trim1(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcTrimmingSelect> getTrim2()
	{
		return (EList<IfcTrimmingSelect>)eGet(Ifc2x3Package.eINSTANCE.getIfcTrimmedCurve_Trim2(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getSenseAgreement()
	{
		return (Tristate)eGet(Ifc2x3Package.eINSTANCE.getIfcTrimmedCurve_SenseAgreement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSenseAgreement(Tristate newSenseAgreement)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTrimmedCurve_SenseAgreement(), newSenseAgreement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcTrimmingPreference getMasterRepresentation()
	{
		return (IfcTrimmingPreference)eGet(Ifc2x3Package.eINSTANCE.getIfcTrimmedCurve_MasterRepresentation(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMasterRepresentation(IfcTrimmingPreference newMasterRepresentation)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcTrimmedCurve_MasterRepresentation(), newMasterRepresentation);
	}

} //IfcTrimmedCurveImpl
