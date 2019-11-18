package org.bimserver.shared.interfaces.async;

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
import java.util.concurrent.ExecutorService;
import org.bimserver.shared.interfaces.LowLevelInterface;

public class AsyncLowLevelInterface {

	private final ExecutorService executorService;
	private final LowLevelInterface syncService;

	public AsyncLowLevelInterface(LowLevelInterface syncService, ExecutorService executorService) {
		this.executorService = executorService;
		this.syncService = syncService;
	}

	public interface AbortTransactionCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface AddBooleanAttributeCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface AddDoubleAttributeCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface AddIntegerAttributeCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface AddReferenceCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface AddStringAttributeCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface CommitTransactionCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface CountCallback {
		void success(java.lang.Integer result);
		void error(Throwable e);
	}
	
	public interface CreateObjectCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface GetBooleanAttributeCallback {
		void success(java.lang.Boolean result);
		void error(Throwable e);
	}
	
	public interface GetBooleanAttributeAtIndexCallback {
		void success(java.lang.Boolean result);
		void error(Throwable e);
	}
	
	public interface GetBooleanAttributesCallback {
		void success(java.util.List<java.lang.Boolean> result);
		void error(Throwable e);
	}
	
	public interface GetByteArrayAttributeCallback {
		void success(byte[] result);
		void error(Throwable e);
	}
	
	public interface GetByteArrayAttributesCallback {
		void success(java.util.List<byte[]> result);
		void error(Throwable e);
	}
	
	public interface GetDataObjectByGuidCallback {
		void success(org.bimserver.interfaces.objects.SDataObject result);
		void error(Throwable e);
	}
	
	public interface GetDataObjectByOidCallback {
		void success(org.bimserver.interfaces.objects.SDataObject result);
		void error(Throwable e);
	}
	
	public interface GetDataObjectsCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SDataObject> result);
		void error(Throwable e);
	}
	
	public interface GetDataObjectsByTypeCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SDataObject> result);
		void error(Throwable e);
	}
	
	public interface GetDoubleAttributeCallback {
		void success(java.lang.Double result);
		void error(Throwable e);
	}
	
	public interface GetDoubleAttributeAtIndexCallback {
		void success(java.lang.Double result);
		void error(Throwable e);
	}
	
	public interface GetDoubleAttributesCallback {
		void success(java.util.List<java.lang.Double> result);
		void error(Throwable e);
	}
	
	public interface GetEnumAttributeCallback {
		void success(java.lang.String result);
		void error(Throwable e);
	}
	
	public interface GetIntegerAttributeCallback {
		void success(java.lang.Integer result);
		void error(Throwable e);
	}
	
	public interface GetIntegerAttributeAtIndexCallback {
		void success(java.lang.Integer result);
		void error(Throwable e);
	}
	
	public interface GetIntegerAttributesCallback {
		void success(java.util.List<java.lang.Integer> result);
		void error(Throwable e);
	}
	
	public interface GetLongAttributeCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface GetLongAttributeAtIndexCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface GetReferenceCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface GetReferencesCallback {
		void success(java.util.List<java.lang.Long> result);
		void error(Throwable e);
	}
	
	public interface GetStringAttributeCallback {
		void success(java.lang.String result);
		void error(Throwable e);
	}
	
	public interface GetStringAttributesCallback {
		void success(java.util.List<java.lang.String> result);
		void error(Throwable e);
	}
	
	public interface RemoveAllReferencesCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface RemoveAttributeCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface RemoveObjectCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface RemoveReferenceCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface RemoveReferenceByOidCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetBooleanAttributeCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetBooleanAttributeAtIndexCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetBooleanAttributesCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetByteArrayAttributeCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetDoubleAttributeCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetDoubleAttributeAtIndexCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetDoubleAttributesCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetEnumAttributeCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetIntegerAttributeCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetIntegerAttributeAtIndexCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetIntegerAttributesCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetLongAttributeCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetLongAttributeAtIndexCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetLongAttributesCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetReferenceCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetStringAttributeCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetStringAttributeAtIndexCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetWrappedBooleanAttributeCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetWrappedDoubleAttributeCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetWrappedIntegerAttributeCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetWrappedLongAttributeCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetWrappedStringAttributeCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface StartTransactionCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface UnsetAttributeCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface UnsetReferenceCallback {
		void success();
		void error(Throwable e);
	}
	


	public void abortTransaction(final java.lang.Long tid, final AbortTransactionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.abortTransaction(tid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void addBooleanAttribute(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.lang.Boolean value, final AddBooleanAttributeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.addBooleanAttribute(tid, oid, attributeName, value);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void addDoubleAttribute(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.lang.Double value, final AddDoubleAttributeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.addDoubleAttribute(tid, oid, attributeName, value);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void addIntegerAttribute(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.lang.Integer value, final AddIntegerAttributeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.addIntegerAttribute(tid, oid, attributeName, value);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void addReference(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String referenceName, final java.lang.Long referenceOid, final AddReferenceCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.addReference(tid, oid, referenceName, referenceOid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void addStringAttribute(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.lang.String value, final AddStringAttributeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.addStringAttribute(tid, oid, attributeName, value);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void commitTransaction(final java.lang.Long tid, final java.lang.String comment, final java.lang.Boolean regenerateAllGeometry, final CommitTransactionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.commitTransaction(tid, comment, regenerateAllGeometry));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void count(final java.lang.Long roid, final java.lang.String className, final CountCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.count(roid, className));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void createObject(final java.lang.Long tid, final java.lang.String className, final java.lang.Boolean generateGuid, final CreateObjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.createObject(tid, className, generateGuid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getBooleanAttribute(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final GetBooleanAttributeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getBooleanAttribute(tid, oid, attributeName));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getBooleanAttributeAtIndex(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.lang.Integer index, final GetBooleanAttributeAtIndexCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getBooleanAttributeAtIndex(tid, oid, attributeName, index));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getBooleanAttributes(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final GetBooleanAttributesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getBooleanAttributes(tid, oid, attributeName));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getByteArrayAttribute(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final GetByteArrayAttributeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getByteArrayAttribute(tid, oid, attributeName));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getByteArrayAttributes(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final GetByteArrayAttributesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getByteArrayAttributes(tid, oid, attributeName));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getDataObjectByGuid(final java.lang.Long roid, final java.lang.String guid, final GetDataObjectByGuidCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getDataObjectByGuid(roid, guid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getDataObjectByOid(final java.lang.Long roid, final java.lang.Long oid, final GetDataObjectByOidCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getDataObjectByOid(roid, oid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getDataObjects(final java.lang.Long roid, final GetDataObjectsCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getDataObjects(roid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getDataObjectsByType(final java.lang.Long roid, final java.lang.String packageName, final java.lang.String className, final java.lang.Boolean flat, final GetDataObjectsByTypeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getDataObjectsByType(roid, packageName, className, flat));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getDoubleAttribute(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final GetDoubleAttributeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getDoubleAttribute(tid, oid, attributeName));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getDoubleAttributeAtIndex(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.lang.Integer index, final GetDoubleAttributeAtIndexCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getDoubleAttributeAtIndex(tid, oid, attributeName, index));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getDoubleAttributes(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final GetDoubleAttributesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getDoubleAttributes(tid, oid, attributeName));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getEnumAttribute(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final GetEnumAttributeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getEnumAttribute(tid, oid, attributeName));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getIntegerAttribute(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final GetIntegerAttributeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getIntegerAttribute(tid, oid, attributeName));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getIntegerAttributeAtIndex(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.lang.Integer index, final GetIntegerAttributeAtIndexCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getIntegerAttributeAtIndex(tid, oid, attributeName, index));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getIntegerAttributes(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final GetIntegerAttributesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getIntegerAttributes(tid, oid, attributeName));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getLongAttribute(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final GetLongAttributeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getLongAttribute(tid, oid, attributeName));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getLongAttributeAtIndex(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.lang.Integer index, final GetLongAttributeAtIndexCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getLongAttributeAtIndex(tid, oid, attributeName, index));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getReference(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String referenceName, final GetReferenceCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getReference(tid, oid, referenceName));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getReferences(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String referenceName, final GetReferencesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getReferences(tid, oid, referenceName));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getStringAttribute(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final GetStringAttributeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getStringAttribute(tid, oid, attributeName));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getStringAttributes(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final GetStringAttributesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getStringAttributes(tid, oid, attributeName));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void removeAllReferences(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String referenceName, final RemoveAllReferencesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.removeAllReferences(tid, oid, referenceName);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void removeAttribute(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.lang.Integer index, final RemoveAttributeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.removeAttribute(tid, oid, attributeName, index);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void removeObject(final java.lang.Long tid, final java.lang.Long oid, final RemoveObjectCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.removeObject(tid, oid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void removeReference(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String referenceName, final java.lang.Integer index, final RemoveReferenceCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.removeReference(tid, oid, referenceName, index);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void removeReferenceByOid(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String referenceName, final java.lang.Long referencedOid, final RemoveReferenceByOidCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.removeReferenceByOid(tid, oid, referenceName, referencedOid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setBooleanAttribute(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.lang.Boolean value, final SetBooleanAttributeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setBooleanAttribute(tid, oid, attributeName, value);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setBooleanAttributeAtIndex(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.lang.Integer index, final java.lang.Boolean value, final SetBooleanAttributeAtIndexCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setBooleanAttributeAtIndex(tid, oid, attributeName, index, value);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setBooleanAttributes(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.util.List<java.lang.Boolean> values, final SetBooleanAttributesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setBooleanAttributes(tid, oid, attributeName, values);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setByteArrayAttribute(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.lang.Byte[] value, final SetByteArrayAttributeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setByteArrayAttribute(tid, oid, attributeName, value);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setDoubleAttribute(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.lang.Double value, final SetDoubleAttributeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setDoubleAttribute(tid, oid, attributeName, value);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setDoubleAttributeAtIndex(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.lang.Integer index, final java.lang.Double value, final SetDoubleAttributeAtIndexCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setDoubleAttributeAtIndex(tid, oid, attributeName, index, value);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setDoubleAttributes(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.util.List<java.lang.Double> values, final SetDoubleAttributesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setDoubleAttributes(tid, oid, attributeName, values);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setEnumAttribute(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.lang.String value, final SetEnumAttributeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setEnumAttribute(tid, oid, attributeName, value);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setIntegerAttribute(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.lang.Integer value, final SetIntegerAttributeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setIntegerAttribute(tid, oid, attributeName, value);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setIntegerAttributeAtIndex(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.lang.Integer index, final java.lang.Integer value, final SetIntegerAttributeAtIndexCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setIntegerAttributeAtIndex(tid, oid, attributeName, index, value);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setIntegerAttributes(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.util.List<java.lang.Integer> values, final SetIntegerAttributesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setIntegerAttributes(tid, oid, attributeName, values);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setLongAttribute(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.lang.Long value, final SetLongAttributeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setLongAttribute(tid, oid, attributeName, value);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setLongAttributeAtIndex(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.lang.Integer index, final java.lang.Long value, final SetLongAttributeAtIndexCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setLongAttributeAtIndex(tid, oid, attributeName, index, value);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setLongAttributes(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.util.List<java.lang.Long> values, final SetLongAttributesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setLongAttributes(tid, oid, attributeName, values);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setReference(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String referenceName, final java.lang.Long referenceOid, final SetReferenceCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setReference(tid, oid, referenceName, referenceOid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setStringAttribute(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.lang.String value, final SetStringAttributeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setStringAttribute(tid, oid, attributeName, value);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setStringAttributeAtIndex(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.lang.Integer index, final java.lang.String value, final SetStringAttributeAtIndexCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setStringAttributeAtIndex(tid, oid, attributeName, index, value);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setWrappedBooleanAttribute(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.lang.String type, final java.lang.Boolean value, final SetWrappedBooleanAttributeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setWrappedBooleanAttribute(tid, oid, attributeName, type, value);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setWrappedDoubleAttribute(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.lang.String type, final java.lang.Double value, final SetWrappedDoubleAttributeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setWrappedDoubleAttribute(tid, oid, attributeName, type, value);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setWrappedIntegerAttribute(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.lang.String type, final java.lang.Integer value, final SetWrappedIntegerAttributeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setWrappedIntegerAttribute(tid, oid, attributeName, type, value);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setWrappedLongAttribute(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.lang.String type, final java.lang.Long value, final SetWrappedLongAttributeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setWrappedLongAttribute(tid, oid, attributeName, type, value);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setWrappedStringAttribute(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final java.lang.String type, final java.lang.String value, final SetWrappedStringAttributeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setWrappedStringAttribute(tid, oid, attributeName, type, value);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void startTransaction(final java.lang.Long poid, final StartTransactionCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.startTransaction(poid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void unsetAttribute(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String attributeName, final UnsetAttributeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.unsetAttribute(tid, oid, attributeName);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void unsetReference(final java.lang.Long tid, final java.lang.Long oid, final java.lang.String referenceName, final UnsetReferenceCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.unsetReference(tid, oid, referenceName);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
}