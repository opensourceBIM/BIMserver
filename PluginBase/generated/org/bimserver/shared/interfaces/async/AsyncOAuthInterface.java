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
import org.bimserver.shared.interfaces.OAuthInterface;

public class AsyncOAuthInterface {

	private final ExecutorService executorService;
	private final OAuthInterface syncService;

	public AsyncOAuthInterface(OAuthInterface syncService, ExecutorService executorService) {
		this.executorService = executorService;
		this.syncService = syncService;
	}

	public interface AuthorizeCallback {
		void success(java.lang.String result);
		void error(Throwable e);
	}
	
	public interface GenerateForwardUrlCallback {
		void success(java.lang.String result);
		void error(Throwable e);
	}
	
	public interface GetAuthorizationByIdCallback {
		void success(org.bimserver.interfaces.objects.SAuthorization result);
		void error(Throwable e);
	}
	
	public interface GetOAuthServerByClientIdCallback {
		void success(org.bimserver.interfaces.objects.SOAuthServer result);
		void error(Throwable e);
	}
	
	public interface GetOAuthServerByIdCallback {
		void success(org.bimserver.interfaces.objects.SOAuthServer result);
		void error(Throwable e);
	}
	
	public interface GetRemoteTokenCallback {
		void success(java.lang.String result);
		void error(Throwable e);
	}
	
	public interface ListAuthorizationCodesCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SOAuthAuthorizationCode> result);
		void error(Throwable e);
	}
	
	public interface ListIssuedAuthorizationCodesCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SOAuthAuthorizationCode> result);
		void error(Throwable e);
	}
	
	public interface ListRegisteredServersCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SOAuthServer> result);
		void error(Throwable e);
	}
	
	public interface ListRegisteredServersLocalCallback {
		void success(java.util.List<org.bimserver.interfaces.objects.SOAuthServer> result);
		void error(Throwable e);
	}
	
	public interface RegisterApplicationCallback {
		void success(java.lang.Long result);
		void error(Throwable e);
	}
	
	public interface RegisterRemoteApplicationCallback {
		void success(org.bimserver.interfaces.objects.SOAuthServer result);
		void error(Throwable e);
	}
	
	public interface RevokeApplicationCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface RevokeAuthorizationCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface SetAuthorizationCodeCallback {
		void success();
		void error(Throwable e);
	}
	


	public void authorize(final java.lang.Long oAuthServerOid, final org.bimserver.interfaces.objects.SAuthorization authorization, final AuthorizeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.authorize(oAuthServerOid, authorization));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void generateForwardUrl(final java.lang.String registrationEndpoint, final java.lang.String authorizeUrl, final java.lang.String returnUrl, final GenerateForwardUrlCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.generateForwardUrl(registrationEndpoint, authorizeUrl, returnUrl));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getAuthorizationById(final java.lang.Long oid, final GetAuthorizationByIdCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAuthorizationById(oid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getOAuthServerByClientId(final java.lang.String clientId, final GetOAuthServerByClientIdCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getOAuthServerByClientId(clientId));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getOAuthServerById(final java.lang.Long oid, final GetOAuthServerByIdCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getOAuthServerById(oid));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getRemoteToken(final java.lang.Long soid, final java.lang.String code, final java.lang.Long serverId, final GetRemoteTokenCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getRemoteToken(soid, code, serverId));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void listAuthorizationCodes(final ListAuthorizationCodesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.listAuthorizationCodes());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void listIssuedAuthorizationCodes(final ListIssuedAuthorizationCodesCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.listIssuedAuthorizationCodes());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void listRegisteredServers(final ListRegisteredServersCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.listRegisteredServers());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void listRegisteredServersLocal(final ListRegisteredServersLocalCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.listRegisteredServersLocal());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void registerApplication(final java.lang.String registrationEndpoint, final java.lang.String apiUrl, final java.lang.String redirectUrl, final RegisterApplicationCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.registerApplication(registrationEndpoint, apiUrl, redirectUrl));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void registerRemoteApplication(final java.lang.String redirectUrl, final java.lang.String name, final java.lang.String description, final RegisterRemoteApplicationCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.registerRemoteApplication(redirectUrl, name, description));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void revokeApplication(final java.lang.Long oid, final RevokeApplicationCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.revokeApplication(oid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void revokeAuthorization(final java.lang.Long oid, final RevokeAuthorizationCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.revokeAuthorization(oid);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void setAuthorizationCode(final java.lang.Long applicationId, final java.lang.String code, final SetAuthorizationCodeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.setAuthorizationCode(applicationId, code);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
}