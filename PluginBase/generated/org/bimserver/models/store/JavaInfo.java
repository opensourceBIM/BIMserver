/**
 * Copyright (C) 2009-2014 BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.store;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.JavaInfo#getHeapTotal <em>Heap Total</em>}</li>
 *   <li>{@link org.bimserver.models.store.JavaInfo#getHeapUsed <em>Heap Used</em>}</li>
 *   <li>{@link org.bimserver.models.store.JavaInfo#getHeapFree <em>Heap Free</em>}</li>
 *   <li>{@link org.bimserver.models.store.JavaInfo#getHeapMax <em>Heap Max</em>}</li>
 *   <li>{@link org.bimserver.models.store.JavaInfo#getThreads <em>Threads</em>}</li>
 *   <li>{@link org.bimserver.models.store.JavaInfo#getJavaHome <em>Java Home</em>}</li>
 *   <li>{@link org.bimserver.models.store.JavaInfo#getJavaVersion <em>Java Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.JavaInfo#getJavaVendor <em>Java Vendor</em>}</li>
 *   <li>{@link org.bimserver.models.store.JavaInfo#getJavaVendorurl <em>Java Vendorurl</em>}</li>
 *   <li>{@link org.bimserver.models.store.JavaInfo#getJavavmVersion <em>Javavm Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.JavaInfo#getJavavmVendor <em>Javavm Vendor</em>}</li>
 *   <li>{@link org.bimserver.models.store.JavaInfo#getJavavmName <em>Javavm Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.JavaInfo#getJavaspecVersion <em>Javaspec Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.JavaInfo#getJavaspecVendor <em>Javaspec Vendor</em>}</li>
 *   <li>{@link org.bimserver.models.store.JavaInfo#getJavaspecName <em>Javaspec Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.JavaInfo#getJavaClassVersion <em>Java Class Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.JavaInfo#getJavaClasspath <em>Java Classpath</em>}</li>
 *   <li>{@link org.bimserver.models.store.JavaInfo#getJavaLibrarypath <em>Java Librarypath</em>}</li>
 *   <li>{@link org.bimserver.models.store.JavaInfo#getJavaIoTmp <em>Java Io Tmp</em>}</li>
 *   <li>{@link org.bimserver.models.store.JavaInfo#getJavaExtdir <em>Java Extdir</em>}</li>
 *   <li>{@link org.bimserver.models.store.JavaInfo#getJavaFileSeparator <em>Java File Separator</em>}</li>
 *   <li>{@link org.bimserver.models.store.JavaInfo#getJavaPathSeparator <em>Java Path Separator</em>}</li>
 *   <li>{@link org.bimserver.models.store.JavaInfo#getJavaLineSeparator <em>Java Line Separator</em>}</li>
 * </ul>
 *
 * @see org.bimserver.models.store.StorePackage#getJavaInfo()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface JavaInfo extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Heap Total</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Heap Total</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Heap Total</em>' attribute.
	 * @see #setHeapTotal(long)
	 * @see org.bimserver.models.store.StorePackage#getJavaInfo_HeapTotal()
	 * @model
	 * @generated
	 */
	long getHeapTotal();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.JavaInfo#getHeapTotal <em>Heap Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heap Total</em>' attribute.
	 * @see #getHeapTotal()
	 * @generated
	 */
	void setHeapTotal(long value);

	/**
	 * Returns the value of the '<em><b>Heap Used</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Heap Used</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Heap Used</em>' attribute.
	 * @see #setHeapUsed(long)
	 * @see org.bimserver.models.store.StorePackage#getJavaInfo_HeapUsed()
	 * @model
	 * @generated
	 */
	long getHeapUsed();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.JavaInfo#getHeapUsed <em>Heap Used</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heap Used</em>' attribute.
	 * @see #getHeapUsed()
	 * @generated
	 */
	void setHeapUsed(long value);

	/**
	 * Returns the value of the '<em><b>Heap Free</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Heap Free</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Heap Free</em>' attribute.
	 * @see #setHeapFree(long)
	 * @see org.bimserver.models.store.StorePackage#getJavaInfo_HeapFree()
	 * @model
	 * @generated
	 */
	long getHeapFree();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.JavaInfo#getHeapFree <em>Heap Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heap Free</em>' attribute.
	 * @see #getHeapFree()
	 * @generated
	 */
	void setHeapFree(long value);

	/**
	 * Returns the value of the '<em><b>Heap Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Heap Max</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Heap Max</em>' attribute.
	 * @see #setHeapMax(long)
	 * @see org.bimserver.models.store.StorePackage#getJavaInfo_HeapMax()
	 * @model
	 * @generated
	 */
	long getHeapMax();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.JavaInfo#getHeapMax <em>Heap Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heap Max</em>' attribute.
	 * @see #getHeapMax()
	 * @generated
	 */
	void setHeapMax(long value);

	/**
	 * Returns the value of the '<em><b>Threads</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Threads</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threads</em>' attribute.
	 * @see #setThreads(int)
	 * @see org.bimserver.models.store.StorePackage#getJavaInfo_Threads()
	 * @model
	 * @generated
	 */
	int getThreads();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.JavaInfo#getThreads <em>Threads</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Threads</em>' attribute.
	 * @see #getThreads()
	 * @generated
	 */
	void setThreads(int value);

	/**
	 * Returns the value of the '<em><b>Java Home</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Home</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Home</em>' attribute.
	 * @see #setJavaHome(String)
	 * @see org.bimserver.models.store.StorePackage#getJavaInfo_JavaHome()
	 * @model
	 * @generated
	 */
	String getJavaHome();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.JavaInfo#getJavaHome <em>Java Home</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Java Home</em>' attribute.
	 * @see #getJavaHome()
	 * @generated
	 */
	void setJavaHome(String value);

	/**
	 * Returns the value of the '<em><b>Java Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Version</em>' attribute.
	 * @see #setJavaVersion(String)
	 * @see org.bimserver.models.store.StorePackage#getJavaInfo_JavaVersion()
	 * @model
	 * @generated
	 */
	String getJavaVersion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.JavaInfo#getJavaVersion <em>Java Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Java Version</em>' attribute.
	 * @see #getJavaVersion()
	 * @generated
	 */
	void setJavaVersion(String value);

	/**
	 * Returns the value of the '<em><b>Java Vendor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Vendor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Vendor</em>' attribute.
	 * @see #setJavaVendor(String)
	 * @see org.bimserver.models.store.StorePackage#getJavaInfo_JavaVendor()
	 * @model
	 * @generated
	 */
	String getJavaVendor();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.JavaInfo#getJavaVendor <em>Java Vendor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Java Vendor</em>' attribute.
	 * @see #getJavaVendor()
	 * @generated
	 */
	void setJavaVendor(String value);

	/**
	 * Returns the value of the '<em><b>Java Vendorurl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Vendorurl</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Vendorurl</em>' attribute.
	 * @see #setJavaVendorurl(String)
	 * @see org.bimserver.models.store.StorePackage#getJavaInfo_JavaVendorurl()
	 * @model
	 * @generated
	 */
	String getJavaVendorurl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.JavaInfo#getJavaVendorurl <em>Java Vendorurl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Java Vendorurl</em>' attribute.
	 * @see #getJavaVendorurl()
	 * @generated
	 */
	void setJavaVendorurl(String value);

	/**
	 * Returns the value of the '<em><b>Javavm Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Javavm Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Javavm Version</em>' attribute.
	 * @see #setJavavmVersion(String)
	 * @see org.bimserver.models.store.StorePackage#getJavaInfo_JavavmVersion()
	 * @model
	 * @generated
	 */
	String getJavavmVersion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.JavaInfo#getJavavmVersion <em>Javavm Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Javavm Version</em>' attribute.
	 * @see #getJavavmVersion()
	 * @generated
	 */
	void setJavavmVersion(String value);

	/**
	 * Returns the value of the '<em><b>Javavm Vendor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Javavm Vendor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Javavm Vendor</em>' attribute.
	 * @see #setJavavmVendor(String)
	 * @see org.bimserver.models.store.StorePackage#getJavaInfo_JavavmVendor()
	 * @model
	 * @generated
	 */
	String getJavavmVendor();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.JavaInfo#getJavavmVendor <em>Javavm Vendor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Javavm Vendor</em>' attribute.
	 * @see #getJavavmVendor()
	 * @generated
	 */
	void setJavavmVendor(String value);

	/**
	 * Returns the value of the '<em><b>Javavm Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Javavm Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Javavm Name</em>' attribute.
	 * @see #setJavavmName(String)
	 * @see org.bimserver.models.store.StorePackage#getJavaInfo_JavavmName()
	 * @model
	 * @generated
	 */
	String getJavavmName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.JavaInfo#getJavavmName <em>Javavm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Javavm Name</em>' attribute.
	 * @see #getJavavmName()
	 * @generated
	 */
	void setJavavmName(String value);

	/**
	 * Returns the value of the '<em><b>Javaspec Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Javaspec Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Javaspec Version</em>' attribute.
	 * @see #setJavaspecVersion(String)
	 * @see org.bimserver.models.store.StorePackage#getJavaInfo_JavaspecVersion()
	 * @model
	 * @generated
	 */
	String getJavaspecVersion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.JavaInfo#getJavaspecVersion <em>Javaspec Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Javaspec Version</em>' attribute.
	 * @see #getJavaspecVersion()
	 * @generated
	 */
	void setJavaspecVersion(String value);

	/**
	 * Returns the value of the '<em><b>Javaspec Vendor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Javaspec Vendor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Javaspec Vendor</em>' attribute.
	 * @see #setJavaspecVendor(String)
	 * @see org.bimserver.models.store.StorePackage#getJavaInfo_JavaspecVendor()
	 * @model
	 * @generated
	 */
	String getJavaspecVendor();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.JavaInfo#getJavaspecVendor <em>Javaspec Vendor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Javaspec Vendor</em>' attribute.
	 * @see #getJavaspecVendor()
	 * @generated
	 */
	void setJavaspecVendor(String value);

	/**
	 * Returns the value of the '<em><b>Javaspec Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Javaspec Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Javaspec Name</em>' attribute.
	 * @see #setJavaspecName(String)
	 * @see org.bimserver.models.store.StorePackage#getJavaInfo_JavaspecName()
	 * @model
	 * @generated
	 */
	String getJavaspecName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.JavaInfo#getJavaspecName <em>Javaspec Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Javaspec Name</em>' attribute.
	 * @see #getJavaspecName()
	 * @generated
	 */
	void setJavaspecName(String value);

	/**
	 * Returns the value of the '<em><b>Java Class Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Class Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Class Version</em>' attribute.
	 * @see #setJavaClassVersion(String)
	 * @see org.bimserver.models.store.StorePackage#getJavaInfo_JavaClassVersion()
	 * @model
	 * @generated
	 */
	String getJavaClassVersion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.JavaInfo#getJavaClassVersion <em>Java Class Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Java Class Version</em>' attribute.
	 * @see #getJavaClassVersion()
	 * @generated
	 */
	void setJavaClassVersion(String value);

	/**
	 * Returns the value of the '<em><b>Java Classpath</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Classpath</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Classpath</em>' attribute list.
	 * @see org.bimserver.models.store.StorePackage#getJavaInfo_JavaClasspath()
	 * @model
	 * @generated
	 */
	EList<String> getJavaClasspath();

	/**
	 * Returns the value of the '<em><b>Java Librarypath</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Librarypath</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Librarypath</em>' attribute list.
	 * @see org.bimserver.models.store.StorePackage#getJavaInfo_JavaLibrarypath()
	 * @model
	 * @generated
	 */
	EList<String> getJavaLibrarypath();

	/**
	 * Returns the value of the '<em><b>Java Io Tmp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Io Tmp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Io Tmp</em>' attribute.
	 * @see #setJavaIoTmp(String)
	 * @see org.bimserver.models.store.StorePackage#getJavaInfo_JavaIoTmp()
	 * @model
	 * @generated
	 */
	String getJavaIoTmp();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.JavaInfo#getJavaIoTmp <em>Java Io Tmp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Java Io Tmp</em>' attribute.
	 * @see #getJavaIoTmp()
	 * @generated
	 */
	void setJavaIoTmp(String value);

	/**
	 * Returns the value of the '<em><b>Java Extdir</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Extdir</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Extdir</em>' attribute.
	 * @see #setJavaExtdir(String)
	 * @see org.bimserver.models.store.StorePackage#getJavaInfo_JavaExtdir()
	 * @model
	 * @generated
	 */
	String getJavaExtdir();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.JavaInfo#getJavaExtdir <em>Java Extdir</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Java Extdir</em>' attribute.
	 * @see #getJavaExtdir()
	 * @generated
	 */
	void setJavaExtdir(String value);

	/**
	 * Returns the value of the '<em><b>Java File Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java File Separator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java File Separator</em>' attribute.
	 * @see #setJavaFileSeparator(String)
	 * @see org.bimserver.models.store.StorePackage#getJavaInfo_JavaFileSeparator()
	 * @model
	 * @generated
	 */
	String getJavaFileSeparator();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.JavaInfo#getJavaFileSeparator <em>Java File Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Java File Separator</em>' attribute.
	 * @see #getJavaFileSeparator()
	 * @generated
	 */
	void setJavaFileSeparator(String value);

	/**
	 * Returns the value of the '<em><b>Java Path Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Path Separator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Path Separator</em>' attribute.
	 * @see #setJavaPathSeparator(String)
	 * @see org.bimserver.models.store.StorePackage#getJavaInfo_JavaPathSeparator()
	 * @model
	 * @generated
	 */
	String getJavaPathSeparator();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.JavaInfo#getJavaPathSeparator <em>Java Path Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Java Path Separator</em>' attribute.
	 * @see #getJavaPathSeparator()
	 * @generated
	 */
	void setJavaPathSeparator(String value);

	/**
	 * Returns the value of the '<em><b>Java Line Separator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Line Separator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Line Separator</em>' attribute.
	 * @see #setJavaLineSeparator(String)
	 * @see org.bimserver.models.store.StorePackage#getJavaInfo_JavaLineSeparator()
	 * @model
	 * @generated
	 */
	String getJavaLineSeparator();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.JavaInfo#getJavaLineSeparator <em>Java Line Separator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Java Line Separator</em>' attribute.
	 * @see #getJavaLineSeparator()
	 * @generated
	 */
	void setJavaLineSeparator(String value);

} // JavaInfo
