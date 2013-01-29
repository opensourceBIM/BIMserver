/**
 * Copyright (C) 2009-2013 BIMserver.org
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

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.Java#getHeapTotal <em>Heap Total</em>}</li>
 *   <li>{@link org.bimserver.models.store.Java#getHeapUsed <em>Heap Used</em>}</li>
 *   <li>{@link org.bimserver.models.store.Java#getHeapFree <em>Heap Free</em>}</li>
 *   <li>{@link org.bimserver.models.store.Java#getHeapMax <em>Heap Max</em>}</li>
 *   <li>{@link org.bimserver.models.store.Java#getThreads <em>Threads</em>}</li>
 *   <li>{@link org.bimserver.models.store.Java#getJavaHome <em>Java Home</em>}</li>
 *   <li>{@link org.bimserver.models.store.Java#getJavaVersion <em>Java Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.Java#getJavaVendor <em>Java Vendor</em>}</li>
 *   <li>{@link org.bimserver.models.store.Java#getJavaVendorurl <em>Java Vendorurl</em>}</li>
 *   <li>{@link org.bimserver.models.store.Java#getJavavmVersion <em>Javavm Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.Java#getJavavmVendor <em>Javavm Vendor</em>}</li>
 *   <li>{@link org.bimserver.models.store.Java#getJavavmName <em>Javavm Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.Java#getJavaspecVersion <em>Javaspec Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.Java#getJavaspecVendor <em>Javaspec Vendor</em>}</li>
 *   <li>{@link org.bimserver.models.store.Java#getJavaspecName <em>Javaspec Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.Java#getJavaClassVersion <em>Java Class Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.Java#getJavaClasspath <em>Java Classpath</em>}</li>
 *   <li>{@link org.bimserver.models.store.Java#getJavaLibrarypath <em>Java Librarypath</em>}</li>
 *   <li>{@link org.bimserver.models.store.Java#getJavaIoTmp <em>Java Io Tmp</em>}</li>
 *   <li>{@link org.bimserver.models.store.Java#getJavaCompiler <em>Java Compiler</em>}</li>
 *   <li>{@link org.bimserver.models.store.Java#getJavaExtdir <em>Java Extdir</em>}</li>
 *   <li>{@link org.bimserver.models.store.Java#getJavaFileSeparator <em>Java File Separator</em>}</li>
 *   <li>{@link org.bimserver.models.store.Java#getJavaPathSeparator <em>Java Path Separator</em>}</li>
 *   <li>{@link org.bimserver.models.store.Java#getJavaLineSeparator <em>Java Line Separator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getJava()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface Java extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Heap Total</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Heap Total</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Heap Total</em>' attribute.
	 * @see #setHeapTotal(int)
	 * @see org.bimserver.models.store.StorePackage#getJava_HeapTotal()
	 * @model
	 * @generated
	 */
	int getHeapTotal();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Java#getHeapTotal <em>Heap Total</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heap Total</em>' attribute.
	 * @see #getHeapTotal()
	 * @generated
	 */
	void setHeapTotal(int value);

	/**
	 * Returns the value of the '<em><b>Heap Used</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Heap Used</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Heap Used</em>' attribute.
	 * @see #setHeapUsed(int)
	 * @see org.bimserver.models.store.StorePackage#getJava_HeapUsed()
	 * @model
	 * @generated
	 */
	int getHeapUsed();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Java#getHeapUsed <em>Heap Used</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heap Used</em>' attribute.
	 * @see #getHeapUsed()
	 * @generated
	 */
	void setHeapUsed(int value);

	/**
	 * Returns the value of the '<em><b>Heap Free</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Heap Free</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Heap Free</em>' attribute.
	 * @see #setHeapFree(int)
	 * @see org.bimserver.models.store.StorePackage#getJava_HeapFree()
	 * @model
	 * @generated
	 */
	int getHeapFree();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Java#getHeapFree <em>Heap Free</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heap Free</em>' attribute.
	 * @see #getHeapFree()
	 * @generated
	 */
	void setHeapFree(int value);

	/**
	 * Returns the value of the '<em><b>Heap Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Heap Max</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Heap Max</em>' attribute.
	 * @see #setHeapMax(int)
	 * @see org.bimserver.models.store.StorePackage#getJava_HeapMax()
	 * @model
	 * @generated
	 */
	int getHeapMax();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Java#getHeapMax <em>Heap Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heap Max</em>' attribute.
	 * @see #getHeapMax()
	 * @generated
	 */
	void setHeapMax(int value);

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
	 * @see org.bimserver.models.store.StorePackage#getJava_Threads()
	 * @model
	 * @generated
	 */
	int getThreads();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Java#getThreads <em>Threads</em>}' attribute.
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
	 * @see org.bimserver.models.store.StorePackage#getJava_JavaHome()
	 * @model
	 * @generated
	 */
	String getJavaHome();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Java#getJavaHome <em>Java Home</em>}' attribute.
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
	 * @see org.bimserver.models.store.StorePackage#getJava_JavaVersion()
	 * @model
	 * @generated
	 */
	String getJavaVersion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Java#getJavaVersion <em>Java Version</em>}' attribute.
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
	 * @see org.bimserver.models.store.StorePackage#getJava_JavaVendor()
	 * @model
	 * @generated
	 */
	String getJavaVendor();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Java#getJavaVendor <em>Java Vendor</em>}' attribute.
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
	 * @see org.bimserver.models.store.StorePackage#getJava_JavaVendorurl()
	 * @model
	 * @generated
	 */
	String getJavaVendorurl();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Java#getJavaVendorurl <em>Java Vendorurl</em>}' attribute.
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
	 * @see org.bimserver.models.store.StorePackage#getJava_JavavmVersion()
	 * @model
	 * @generated
	 */
	String getJavavmVersion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Java#getJavavmVersion <em>Javavm Version</em>}' attribute.
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
	 * @see org.bimserver.models.store.StorePackage#getJava_JavavmVendor()
	 * @model
	 * @generated
	 */
	String getJavavmVendor();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Java#getJavavmVendor <em>Javavm Vendor</em>}' attribute.
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
	 * @see org.bimserver.models.store.StorePackage#getJava_JavavmName()
	 * @model
	 * @generated
	 */
	String getJavavmName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Java#getJavavmName <em>Javavm Name</em>}' attribute.
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
	 * @see org.bimserver.models.store.StorePackage#getJava_JavaspecVersion()
	 * @model
	 * @generated
	 */
	String getJavaspecVersion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Java#getJavaspecVersion <em>Javaspec Version</em>}' attribute.
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
	 * @see org.bimserver.models.store.StorePackage#getJava_JavaspecVendor()
	 * @model
	 * @generated
	 */
	String getJavaspecVendor();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Java#getJavaspecVendor <em>Javaspec Vendor</em>}' attribute.
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
	 * @see org.bimserver.models.store.StorePackage#getJava_JavaspecName()
	 * @model
	 * @generated
	 */
	String getJavaspecName();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Java#getJavaspecName <em>Javaspec Name</em>}' attribute.
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
	 * @see org.bimserver.models.store.StorePackage#getJava_JavaClassVersion()
	 * @model
	 * @generated
	 */
	String getJavaClassVersion();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.Java#getJavaClassVersion <em>Java Class Version</em>}' attribute.
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
	 * @see org.bimserver.models.store.StorePackage#getJava_JavaClasspath()
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
	 * @see org.bimserver.models.store.StorePackage#getJava_JavaLibrarypath()
	 * @model
	 * @generated
	 */
	EList<String> getJavaLibrarypath();

	/**
	 * Returns the value of the '<em><b>Java Io Tmp</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Io Tmp</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Io Tmp</em>' attribute list.
	 * @see org.bimserver.models.store.StorePackage#getJava_JavaIoTmp()
	 * @model
	 * @generated
	 */
	EList<String> getJavaIoTmp();

	/**
	 * Returns the value of the '<em><b>Java Compiler</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Compiler</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Compiler</em>' attribute list.
	 * @see org.bimserver.models.store.StorePackage#getJava_JavaCompiler()
	 * @model
	 * @generated
	 */
	EList<String> getJavaCompiler();

	/**
	 * Returns the value of the '<em><b>Java Extdir</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Extdir</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Extdir</em>' attribute list.
	 * @see org.bimserver.models.store.StorePackage#getJava_JavaExtdir()
	 * @model
	 * @generated
	 */
	EList<String> getJavaExtdir();

	/**
	 * Returns the value of the '<em><b>Java File Separator</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java File Separator</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java File Separator</em>' attribute list.
	 * @see org.bimserver.models.store.StorePackage#getJava_JavaFileSeparator()
	 * @model
	 * @generated
	 */
	EList<String> getJavaFileSeparator();

	/**
	 * Returns the value of the '<em><b>Java Path Separator</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Path Separator</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Path Separator</em>' attribute list.
	 * @see org.bimserver.models.store.StorePackage#getJava_JavaPathSeparator()
	 * @model
	 * @generated
	 */
	EList<String> getJavaPathSeparator();

	/**
	 * Returns the value of the '<em><b>Java Line Separator</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Java Line Separator</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Line Separator</em>' attribute list.
	 * @see org.bimserver.models.store.StorePackage#getJava_JavaLineSeparator()
	 * @model
	 * @generated
	 */
	EList<String> getJavaLineSeparator();

} // Java
