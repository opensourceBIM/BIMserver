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
package org.bimserver.models.store.impl;

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

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.store.JavaInfo;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.JavaInfoImpl#getHeapTotal <em>Heap Total</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.JavaInfoImpl#getHeapUsed <em>Heap Used</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.JavaInfoImpl#getHeapFree <em>Heap Free</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.JavaInfoImpl#getHeapMax <em>Heap Max</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.JavaInfoImpl#getThreads <em>Threads</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.JavaInfoImpl#getJavaHome <em>Java Home</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.JavaInfoImpl#getJavaVersion <em>Java Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.JavaInfoImpl#getJavaVendor <em>Java Vendor</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.JavaInfoImpl#getJavaVendorurl <em>Java Vendorurl</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.JavaInfoImpl#getJavavmVersion <em>Javavm Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.JavaInfoImpl#getJavavmVendor <em>Javavm Vendor</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.JavaInfoImpl#getJavavmName <em>Javavm Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.JavaInfoImpl#getJavaspecVersion <em>Javaspec Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.JavaInfoImpl#getJavaspecVendor <em>Javaspec Vendor</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.JavaInfoImpl#getJavaspecName <em>Javaspec Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.JavaInfoImpl#getJavaClassVersion <em>Java Class Version</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.JavaInfoImpl#getJavaClasspath <em>Java Classpath</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.JavaInfoImpl#getJavaLibrarypath <em>Java Librarypath</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.JavaInfoImpl#getJavaIoTmp <em>Java Io Tmp</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.JavaInfoImpl#getJavaExtdir <em>Java Extdir</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.JavaInfoImpl#getJavaFileSeparator <em>Java File Separator</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.JavaInfoImpl#getJavaPathSeparator <em>Java Path Separator</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.JavaInfoImpl#getJavaLineSeparator <em>Java Line Separator</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JavaInfoImpl extends IdEObjectImpl implements JavaInfo {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JavaInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.JAVA_INFO;
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
	@Override
	public long getHeapTotal() {
		return (Long) eGet(StorePackage.Literals.JAVA_INFO__HEAP_TOTAL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHeapTotal(long newHeapTotal) {
		eSet(StorePackage.Literals.JAVA_INFO__HEAP_TOTAL, newHeapTotal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getHeapUsed() {
		return (Long) eGet(StorePackage.Literals.JAVA_INFO__HEAP_USED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHeapUsed(long newHeapUsed) {
		eSet(StorePackage.Literals.JAVA_INFO__HEAP_USED, newHeapUsed);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getHeapFree() {
		return (Long) eGet(StorePackage.Literals.JAVA_INFO__HEAP_FREE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHeapFree(long newHeapFree) {
		eSet(StorePackage.Literals.JAVA_INFO__HEAP_FREE, newHeapFree);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getHeapMax() {
		return (Long) eGet(StorePackage.Literals.JAVA_INFO__HEAP_MAX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHeapMax(long newHeapMax) {
		eSet(StorePackage.Literals.JAVA_INFO__HEAP_MAX, newHeapMax);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getThreads() {
		return (Integer) eGet(StorePackage.Literals.JAVA_INFO__THREADS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setThreads(int newThreads) {
		eSet(StorePackage.Literals.JAVA_INFO__THREADS, newThreads);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getJavaHome() {
		return (String) eGet(StorePackage.Literals.JAVA_INFO__JAVA_HOME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJavaHome(String newJavaHome) {
		eSet(StorePackage.Literals.JAVA_INFO__JAVA_HOME, newJavaHome);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getJavaVersion() {
		return (String) eGet(StorePackage.Literals.JAVA_INFO__JAVA_VERSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJavaVersion(String newJavaVersion) {
		eSet(StorePackage.Literals.JAVA_INFO__JAVA_VERSION, newJavaVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getJavaVendor() {
		return (String) eGet(StorePackage.Literals.JAVA_INFO__JAVA_VENDOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJavaVendor(String newJavaVendor) {
		eSet(StorePackage.Literals.JAVA_INFO__JAVA_VENDOR, newJavaVendor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getJavaVendorurl() {
		return (String) eGet(StorePackage.Literals.JAVA_INFO__JAVA_VENDORURL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJavaVendorurl(String newJavaVendorurl) {
		eSet(StorePackage.Literals.JAVA_INFO__JAVA_VENDORURL, newJavaVendorurl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getJavavmVersion() {
		return (String) eGet(StorePackage.Literals.JAVA_INFO__JAVAVM_VERSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJavavmVersion(String newJavavmVersion) {
		eSet(StorePackage.Literals.JAVA_INFO__JAVAVM_VERSION, newJavavmVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getJavavmVendor() {
		return (String) eGet(StorePackage.Literals.JAVA_INFO__JAVAVM_VENDOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJavavmVendor(String newJavavmVendor) {
		eSet(StorePackage.Literals.JAVA_INFO__JAVAVM_VENDOR, newJavavmVendor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getJavavmName() {
		return (String) eGet(StorePackage.Literals.JAVA_INFO__JAVAVM_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJavavmName(String newJavavmName) {
		eSet(StorePackage.Literals.JAVA_INFO__JAVAVM_NAME, newJavavmName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getJavaspecVersion() {
		return (String) eGet(StorePackage.Literals.JAVA_INFO__JAVASPEC_VERSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJavaspecVersion(String newJavaspecVersion) {
		eSet(StorePackage.Literals.JAVA_INFO__JAVASPEC_VERSION, newJavaspecVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getJavaspecVendor() {
		return (String) eGet(StorePackage.Literals.JAVA_INFO__JAVASPEC_VENDOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJavaspecVendor(String newJavaspecVendor) {
		eSet(StorePackage.Literals.JAVA_INFO__JAVASPEC_VENDOR, newJavaspecVendor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getJavaspecName() {
		return (String) eGet(StorePackage.Literals.JAVA_INFO__JAVASPEC_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJavaspecName(String newJavaspecName) {
		eSet(StorePackage.Literals.JAVA_INFO__JAVASPEC_NAME, newJavaspecName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getJavaClassVersion() {
		return (String) eGet(StorePackage.Literals.JAVA_INFO__JAVA_CLASS_VERSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJavaClassVersion(String newJavaClassVersion) {
		eSet(StorePackage.Literals.JAVA_INFO__JAVA_CLASS_VERSION, newJavaClassVersion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getJavaClasspath() {
		return (EList<String>) eGet(StorePackage.Literals.JAVA_INFO__JAVA_CLASSPATH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<String> getJavaLibrarypath() {
		return (EList<String>) eGet(StorePackage.Literals.JAVA_INFO__JAVA_LIBRARYPATH, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getJavaIoTmp() {
		return (String) eGet(StorePackage.Literals.JAVA_INFO__JAVA_IO_TMP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJavaIoTmp(String newJavaIoTmp) {
		eSet(StorePackage.Literals.JAVA_INFO__JAVA_IO_TMP, newJavaIoTmp);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getJavaExtdir() {
		return (String) eGet(StorePackage.Literals.JAVA_INFO__JAVA_EXTDIR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJavaExtdir(String newJavaExtdir) {
		eSet(StorePackage.Literals.JAVA_INFO__JAVA_EXTDIR, newJavaExtdir);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getJavaFileSeparator() {
		return (String) eGet(StorePackage.Literals.JAVA_INFO__JAVA_FILE_SEPARATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJavaFileSeparator(String newJavaFileSeparator) {
		eSet(StorePackage.Literals.JAVA_INFO__JAVA_FILE_SEPARATOR, newJavaFileSeparator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getJavaPathSeparator() {
		return (String) eGet(StorePackage.Literals.JAVA_INFO__JAVA_PATH_SEPARATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJavaPathSeparator(String newJavaPathSeparator) {
		eSet(StorePackage.Literals.JAVA_INFO__JAVA_PATH_SEPARATOR, newJavaPathSeparator);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getJavaLineSeparator() {
		return (String) eGet(StorePackage.Literals.JAVA_INFO__JAVA_LINE_SEPARATOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJavaLineSeparator(String newJavaLineSeparator) {
		eSet(StorePackage.Literals.JAVA_INFO__JAVA_LINE_SEPARATOR, newJavaLineSeparator);
	}

} //JavaInfoImpl
