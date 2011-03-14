/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcSimpleValue;
import org.bimserver.models.ifc2x3.IfcTextureCoordinateGenerator;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Texture Coordinate Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextureCoordinateGeneratorImpl#getMode <em>Mode</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextureCoordinateGeneratorImpl#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcTextureCoordinateGeneratorImpl extends IfcTextureCoordinateImpl implements IfcTextureCoordinateGenerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTextureCoordinateGeneratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcTextureCoordinateGenerator();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMode() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTextureCoordinateGenerator_Mode(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMode(String newMode) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextureCoordinateGenerator_Mode(), newMode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcSimpleValue> getParameter() {
		return (EList<IfcSimpleValue>)eGet(Ifc2x3Package.eINSTANCE.getIfcTextureCoordinateGenerator_Parameter(), true);
	}

} //IfcTextureCoordinateGeneratorImpl
