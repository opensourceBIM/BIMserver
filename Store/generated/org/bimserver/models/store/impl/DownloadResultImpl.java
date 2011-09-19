/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.bimserver.models.store.impl;

import javax.activation.DataHandler;

import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.models.store.DownloadResult;
import org.bimserver.models.store.StorePackage;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Download Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.bimserver.models.store.impl.DownloadResultImpl#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.DownloadResultImpl#getRevisionNr <em>Revision Nr</em>}</li>
 *   <li>{@link org.bimserver.models.store.impl.DownloadResultImpl#getFile <em>File</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DownloadResultImpl extends IdEObjectImpl implements DownloadResult {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DownloadResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StorePackage.Literals.DOWNLOAD_RESULT;
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
	public String getProjectName() {
		return (String)eGet(StorePackage.Literals.DOWNLOAD_RESULT__PROJECT_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProjectName(String newProjectName) {
		eSet(StorePackage.Literals.DOWNLOAD_RESULT__PROJECT_NAME, newProjectName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRevisionNr() {
		return (Integer)eGet(StorePackage.Literals.DOWNLOAD_RESULT__REVISION_NR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRevisionNr(int newRevisionNr) {
		eSet(StorePackage.Literals.DOWNLOAD_RESULT__REVISION_NR, newRevisionNr);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataHandler getFile() {
		return (DataHandler)eGet(StorePackage.Literals.DOWNLOAD_RESULT__FILE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFile(DataHandler newFile) {
		eSet(StorePackage.Literals.DOWNLOAD_RESULT__FILE, newFile);
	}

} //DownloadResultImpl
