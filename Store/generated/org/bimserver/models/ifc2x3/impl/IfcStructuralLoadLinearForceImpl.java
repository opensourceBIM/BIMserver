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
import org.bimserver.models.ifc2x3.IfcStructuralLoadLinearForce;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ifc Structural Load Linear Force</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadLinearForceImpl#getLinearForceX <em>Linear Force X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadLinearForceImpl#getLinearForceXAsString <em>Linear Force XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadLinearForceImpl#getLinearForceY <em>Linear Force Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadLinearForceImpl#getLinearForceYAsString <em>Linear Force YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadLinearForceImpl#getLinearForceZ <em>Linear Force Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadLinearForceImpl#getLinearForceZAsString <em>Linear Force ZAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadLinearForceImpl#getLinearMomentX <em>Linear Moment X</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadLinearForceImpl#getLinearMomentXAsString <em>Linear Moment XAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadLinearForceImpl#getLinearMomentY <em>Linear Moment Y</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadLinearForceImpl#getLinearMomentYAsString <em>Linear Moment YAs String</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadLinearForceImpl#getLinearMomentZ <em>Linear Moment Z</em>}</li>
 *   <li>{@link org.bimserver.models.ifc2x3.impl.IfcStructuralLoadLinearForceImpl#getLinearMomentZAsString <em>Linear Moment ZAs String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfcStructuralLoadLinearForceImpl extends IfcStructuralLoadStaticImpl implements IfcStructuralLoadLinearForce
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfcStructuralLoadLinearForceImpl()
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
		return Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLinearForceX()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearForceX(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearForceX(float newLinearForceX)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearForceX(), newLinearForceX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearForceX()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearForceX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearForceX()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearForceX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinearForceXAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearForceXAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearForceXAsString(String newLinearForceXAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearForceXAsString(), newLinearForceXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearForceXAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearForceXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearForceXAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearForceXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLinearForceY()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearForceY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearForceY(float newLinearForceY)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearForceY(), newLinearForceY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearForceY()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearForceY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearForceY()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearForceY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinearForceYAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearForceYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearForceYAsString(String newLinearForceYAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearForceYAsString(), newLinearForceYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearForceYAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearForceYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearForceYAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearForceYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLinearForceZ()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearForceZ(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearForceZ(float newLinearForceZ)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearForceZ(), newLinearForceZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearForceZ()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearForceZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearForceZ()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearForceZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinearForceZAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearForceZAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearForceZAsString(String newLinearForceZAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearForceZAsString(), newLinearForceZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearForceZAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearForceZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearForceZAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearForceZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLinearMomentX()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearMomentX(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearMomentX(float newLinearMomentX)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearMomentX(), newLinearMomentX);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearMomentX()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearMomentX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearMomentX()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearMomentX());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinearMomentXAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearMomentXAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearMomentXAsString(String newLinearMomentXAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearMomentXAsString(), newLinearMomentXAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearMomentXAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearMomentXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearMomentXAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearMomentXAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLinearMomentY()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearMomentY(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearMomentY(float newLinearMomentY)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearMomentY(), newLinearMomentY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearMomentY()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearMomentY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearMomentY()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearMomentY());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinearMomentYAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearMomentYAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearMomentYAsString(String newLinearMomentYAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearMomentYAsString(), newLinearMomentYAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearMomentYAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearMomentYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearMomentYAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearMomentYAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLinearMomentZ()
	{
		return (Float)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearMomentZ(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearMomentZ(float newLinearMomentZ)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearMomentZ(), newLinearMomentZ);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearMomentZ()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearMomentZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearMomentZ()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearMomentZ());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinearMomentZAsString()
	{
		return (String)eGet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearMomentZAsString(), true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinearMomentZAsString(String newLinearMomentZAsString)
	{
		eSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearMomentZAsString(), newLinearMomentZAsString);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinearMomentZAsString()
	{
		eUnset(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearMomentZAsString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinearMomentZAsString()
	{
		return eIsSet(Ifc2x3Package.eINSTANCE.getIfcStructuralLoadLinearForce_LinearMomentZAsString());
	}

} //IfcStructuralLoadLinearForceImpl
