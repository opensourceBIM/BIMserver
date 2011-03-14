/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.ifc2x3.impl;

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.models.ifc2x3.IfcTextureMap;
import org.bimserver.models.ifc2x3.IfcVertexBasedTextureMap;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Texture Map</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcTextureMapImpl#getTextureMaps <em>Texture Maps</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcTextureMapImpl extends IfcTextureCoordinateImpl implements IfcTextureMap {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcTextureMapImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ifc2x3Package.eINSTANCE.getIfcTextureMap();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<IfcVertexBasedTextureMap> getTextureMaps() {
		return (EList<IfcVertexBasedTextureMap>)eGet(Ifc2x3Package.eINSTANCE.getIfcTextureMap_TextureMaps(), true);
	}

} //IfcTextureMapImpl
