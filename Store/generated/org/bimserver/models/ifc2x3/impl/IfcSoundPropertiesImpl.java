/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcSoundProperties;
import org.bimserver.models.ifc2x3.IfcSoundScaleEnum;
import org.bimserver.models.ifc2x3.IfcSoundValue;
import org.bimserver.models.ifc2x3.Tristate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Sound Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSoundPropertiesImpl#getIsAttenuating <em>Is Attenuating</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSoundPropertiesImpl#getSoundScale <em>Sound Scale</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcSoundPropertiesImpl#getSoundValues <em>Sound Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcSoundPropertiesImpl extends IfcPropertySetDefinitionImpl implements IfcSoundProperties {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcSoundPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcSoundProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tristate getIsAttenuating() {
		return (Tristate)eGet(Ifc2x3Package.eINSTANCE.getIfcSoundProperties_IsAttenuating(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAttenuating(Tristate newIsAttenuating) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSoundProperties_IsAttenuating(), newIsAttenuating);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSoundScaleEnum getSoundScale() {
		return (IfcSoundScaleEnum)eGet(Ifc2x3Package.eINSTANCE.getIfcSoundProperties_SoundScale(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSoundScale(IfcSoundScaleEnum newSoundScale) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcSoundProperties_SoundScale(), newSoundScale);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcSoundValue> getSoundValues() {
		return (EList<IfcSoundValue>)eGet(Ifc2x3Package.eINSTANCE.getIfcSoundProperties_SoundValues(), true);
	}

} //IfcSoundPropertiesImpl
