/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcFeatureElementAddition;
import org.bimserver.models.ifc2x3.IfcRelProjectsElement;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Feature Element Addition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcFeatureElementAdditionImpl#getProjectsElements <em>Projects Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcFeatureElementAdditionImpl extends IfcFeatureElementImpl implements IfcFeatureElementAddition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcFeatureElementAdditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcFeatureElementAddition();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcRelProjectsElement getProjectsElements() {
		return (IfcRelProjectsElement)eGet(Ifc2x3Package.eINSTANCE.getIfcFeatureElementAddition_ProjectsElements(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectsElements(IfcRelProjectsElement newProjectsElements) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcFeatureElementAddition_ProjectsElements(), newProjectsElements);
	}

} //IfcFeatureElementAdditionImpl
