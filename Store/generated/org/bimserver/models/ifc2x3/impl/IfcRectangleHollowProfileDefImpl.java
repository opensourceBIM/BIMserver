/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcRectangleHollowProfileDef;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Rectangle Hollow Profile Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangleHollowProfileDefImpl#getWallThickness <em>Wall Thickness</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangleHollowProfileDefImpl#getWallThicknessAsString <em>Wall Thickness As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangleHollowProfileDefImpl#getInnerFilletRadius <em>Inner Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangleHollowProfileDefImpl#getInnerFilletRadiusAsString <em>Inner Fillet Radius As String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangleHollowProfileDefImpl#getOuterFilletRadius <em>Outer Fillet Radius</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcRectangleHollowProfileDefImpl#getOuterFilletRadiusAsString <em>Outer Fillet Radius As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcRectangleHollowProfileDefImpl extends IfcRectangleProfileDefImpl implements IfcRectangleHollowProfileDef {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcRectangleHollowProfileDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcRectangleHollowProfileDef();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWallThickness() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangleHollowProfileDef_WallThickness(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWallThickness(float newWallThickness) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangleHollowProfileDef_WallThickness(), newWallThickness);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWallThicknessAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangleHollowProfileDef_WallThicknessAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWallThicknessAsString(String newWallThicknessAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangleHollowProfileDef_WallThicknessAsString(), newWallThicknessAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getInnerFilletRadius() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangleHollowProfileDef_InnerFilletRadius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInnerFilletRadius(float newInnerFilletRadius) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangleHollowProfileDef_InnerFilletRadius(), newInnerFilletRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInnerFilletRadius() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRectangleHollowProfileDef_InnerFilletRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInnerFilletRadius() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRectangleHollowProfileDef_InnerFilletRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInnerFilletRadiusAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangleHollowProfileDef_InnerFilletRadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInnerFilletRadiusAsString(String newInnerFilletRadiusAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangleHollowProfileDef_InnerFilletRadiusAsString(), newInnerFilletRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInnerFilletRadiusAsString() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRectangleHollowProfileDef_InnerFilletRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInnerFilletRadiusAsString() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRectangleHollowProfileDef_InnerFilletRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getOuterFilletRadius() {
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangleHollowProfileDef_OuterFilletRadius(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOuterFilletRadius(float newOuterFilletRadius) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangleHollowProfileDef_OuterFilletRadius(), newOuterFilletRadius);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOuterFilletRadius() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRectangleHollowProfileDef_OuterFilletRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOuterFilletRadius() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRectangleHollowProfileDef_OuterFilletRadius());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOuterFilletRadiusAsString() {
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcRectangleHollowProfileDef_OuterFilletRadiusAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOuterFilletRadiusAsString(String newOuterFilletRadiusAsString) {
		eSet(Ifc2x3Package.eINSTANCE.getIfcRectangleHollowProfileDef_OuterFilletRadiusAsString(), newOuterFilletRadiusAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOuterFilletRadiusAsString() {
		eUnset(Ifc2x3Package.eINSTANCE.getIfcRectangleHollowProfileDef_OuterFilletRadiusAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOuterFilletRadiusAsString() {
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcRectangleHollowProfileDef_OuterFilletRadiusAsString());
	}

} //IfcRectangleHollowProfileDefImpl
