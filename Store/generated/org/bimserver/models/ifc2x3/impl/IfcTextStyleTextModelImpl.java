/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.emf.IdEObjectImpl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcSizeSelect;
import org.bimserver.models.ifc2x3.IfcTextStyleTextModel;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Text Style Text Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextStyleTextModelImpl#getTextIndent <em>Text Indent</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextStyleTextModelImpl#getTextAlign <em>Text Align</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextStyleTextModelImpl#getTextDecoration <em>Text Decoration</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextStyleTextModelImpl#getLetterSpacing <em>Letter Spacing</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextStyleTextModelImpl#getWordSpacing <em>Word Spacing</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextStyleTextModelImpl#getTextTransform <em>Text Transform</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextStyleTextModelImpl#getLineHeight <em>Line Height</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcTextStyleTextModelImpl extends IdEObjectImpl implements IfcTextStyleTextModel {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTextStyleTextModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel();
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
	public IfcSizeSelect getTextIndent() {
		return (IfcSizeSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_TextIndent(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextIndent(IfcSizeSelect newTextIndent) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_TextIndent(), newTextIndent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTextIndent() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_TextIndent());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTextIndent() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_TextIndent());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTextAlign() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_TextAlign(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextAlign(String newTextAlign) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_TextAlign(), newTextAlign);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTextAlign() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_TextAlign());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTextAlign() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_TextAlign());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTextDecoration() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_TextDecoration(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextDecoration(String newTextDecoration) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_TextDecoration(), newTextDecoration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTextDecoration() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_TextDecoration());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTextDecoration() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_TextDecoration());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSizeSelect getLetterSpacing() {
		return (IfcSizeSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_LetterSpacing(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLetterSpacing(IfcSizeSelect newLetterSpacing) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_LetterSpacing(), newLetterSpacing);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLetterSpacing() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_LetterSpacing());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLetterSpacing() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_LetterSpacing());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSizeSelect getWordSpacing() {
		return (IfcSizeSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_WordSpacing(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWordSpacing(IfcSizeSelect newWordSpacing) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_WordSpacing(), newWordSpacing);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetWordSpacing() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_WordSpacing());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetWordSpacing() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_WordSpacing());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTextTransform() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_TextTransform(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextTransform(String newTextTransform) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_TextTransform(), newTextTransform);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTextTransform() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_TextTransform());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTextTransform() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_TextTransform());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfcSizeSelect getLineHeight() {
		return (IfcSizeSelect)eGet(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_LineHeight(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLineHeight(IfcSizeSelect newLineHeight) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_LineHeight(), newLineHeight);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLineHeight() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_LineHeight());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLineHeight() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcTextStyleTextModel_LineHeight());
	}

} //IfcTextStyleTextModelImpl
