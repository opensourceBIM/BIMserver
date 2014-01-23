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
import org.bimserver.shared.interfaces.AuthInterface;

public class AsyncAuthInterface {

	private final ExecutorService executorService;
	private final AuthInterface syncService;

	public AsyncAuthInterface(AuthInterface syncService, ExecutorService executorService) {
		this.executorService = executorService;
		this.syncService = syncService;
	}

	public interface ChangePasswordCallback {
		void success(java.lang.Boolean result);
		void error(Throwable e);
	}
	
	public interface GetLoggedInUserCallback {
		void success(org.bimserver.interfaces.objects.SUser result);
		void error(Throwable e);
	}
	
	public interface RequestPasswordChangeCallback {
		void success();
		void error(Throwable e);
	}
	
	public interface ValidateAccountCallback {
		void success(org.bimserver.interfaces.objects.SUser result);
		void error(Throwable e);
	}
	


	public void changePassword(final java.lang.Long uoid, final java.lang.String oldPassword, final java.lang.String newPassword, final ChangePasswordCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.changePassword(uoid, oldPassword, newPassword));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void getLoggedInUser(final GetLoggedInUserCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.getLoggedInUser());
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void requestPasswordChange(final java.lang.String username, final java.lang.String resetUrl, final RequestPasswordChangeCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					syncService.requestPasswordChange(username, resetUrl);
					callback.success();
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
	public void validateAccount(final java.lang.Long uoid, final java.lang.String token, final java.lang.String password, final ValidateAccountCallback callback) {
		executorService.submit(new Runnable(){
			public void run(){
				try {
					callback.success(syncService.validateAccount(uoid, token, password));
				} catch (Throwable e) {
					callback.error(e);
				}
			}
		});
	}
	
}