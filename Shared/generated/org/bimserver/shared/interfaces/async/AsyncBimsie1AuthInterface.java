package org.bimserver.shared.interfaces.async;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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
 *****************************************************************************/
import java.util.concurrent.ExecutorService;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1AuthInterface;

public class AsyncBimsie1AuthInterface {

	private final ExecutorService executorService;
	private final Bimsie1AuthInterface syncService;

	public AsyncBimsie1AuthInterface(Bimsie1AuthInterface syncService, ExecutorService executorService) {
		this.executorService = executorService;
		this.syncService = syncService;
	}

	public interface GetAccessMethodCallback {
		void success(org.bimserver.interfaces.objects.SAccessMethod result);
		void error(Throwable e);
	}
	
	public interface IsLoggedInCallback {
		void success(java.lang.Boolean result);
		void error(Throwable e);
	}
	
	public interface LoginCallback {
		void success(java.lang.String result);
		void error(Throwable e);
	}
	
	public interface LoginOpenIdCallback {
		void success(java.lang.String result);
		void error(Throwable e);
	}
	
	public interface LoginUserTokenCallback {
		void success(java.lang.String result);
		void error(Throwable e);
	}
	
	public interface LogoutCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface ValidateOpenIdCallback {
		void success(java.lang.String result);
		void error(Throwable e);
	}
	


	public void getAccessMethod(final GetAccessMethodCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getAccessMethod());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void isLoggedIn(final IsLoggedInCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.isLoggedIn());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void login(final java.lang.String username, final java.lang.String password, final LoginCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.login(username, password));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void loginOpenId(final java.lang.String op, final java.lang.String returnUrl, final LoginOpenIdCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.loginOpenId(op, returnUrl));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void loginUserToken(final java.lang.String token, final LoginUserTokenCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.loginUserToken(token));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void logout(final LogoutCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.logout();
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void validateOpenId(final java.lang.String queryString, final ValidateOpenIdCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.validateOpenId(queryString));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
}