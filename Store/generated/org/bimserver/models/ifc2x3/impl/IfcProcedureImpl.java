/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcProcedure;
import org.bimserver.models.ifc2x3.IfcProcedureTypeEnum;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Procedure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProcedureImpl#getProcedureID <em>Procedure ID</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProcedureImpl#getProcedureType <em>Procedure Type</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcProcedureImpl#getUserDefinedProcedureType <em>User Defined Procedure Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcProcedureImpl extends IfcProcessImpl implements IfcProcedure {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcProcedureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcProcedure();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProcedureID() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcProcedure_ProcedureID(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcedureID(String newProcedureID) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcProcedure_ProcedureID(), newProcedureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcProcedureTypeEnum getProcedureType() {
		return (IfcProcedureTypeEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcProcedure_ProcedureType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcedureType(IfcProcedureTypeEnum newProcedureType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcProcedure_ProcedureType(), newProcedureType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserDefinedProcedureType() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcProcedure_UserDefinedProcedureType(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserDefinedProcedureType(String newUserDefinedProcedureType) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcProcedure_UserDefinedProcedureType(), newUserDefinedProcedureType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetUserDefinedProcedureType() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcProcedure_UserDefinedProcedureType());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetUserDefinedProcedureType() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcProcedure_UserDefinedProcedureType());
	}

} //IfcProcedureImpl
