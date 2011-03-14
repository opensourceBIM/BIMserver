/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcElement;
import org.bimserver.models.ifc2x3.IfcFeatureElementSubtraction;
import org.bimserver.models.ifc2x3.IfcRelVoidsElement;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rel Voids Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelVoidsElementImpl#getRelatingBuildingElement <em>Relating Building Element</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRelVoidsElementImpl#getRelatedOpeningElement <em>Related Opening Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRelVoidsElementImpl extends IfcRelConnectsImpl implements IfcRelVoidsElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRelVoidsElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRelVoidsElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcElement getRelatingBuildingElement() {
		return (IfcElement)eGet(Ifc2x3Package.eINSTANCE.getIfcRelVoidsElement_RelatingBuildingElement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatingBuildingElement(IfcElement newRelatingBuildingElement) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelVoidsElement_RelatingBuildingElement(), newRelatingBuildingElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcFeatureElementSubtraction getRelatedOpeningElement() {
		return (IfcFeatureElementSubtraction)eGet(Ifc2x3Package.eINSTANCE.getIfcRelVoidsElement_RelatedOpeningElement(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatedOpeningElement(IfcFeatureElementSubtraction newRelatedOpeningElement) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRelVoidsElement_RelatedOpeningElement(), newRelatedOpeningElement);
	}

} //IfcRelVoidsElementImpl
