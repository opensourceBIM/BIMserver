package org.bimwebserver.servlets;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimwebserver.jsp.LoginManager;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonServlet extends HttpServlet {

	private static final long serialVersionUID = 186486233172374336L;
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonServlet.class);

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginManager loginManager = (LoginManager) request.getSession().getAttribute("loginManager");
		try {
			JSONObject in = new JSONObject(new JSONTokener(IOUtils.toString(request.getInputStream())));
			String action = in.getString("action");
			if (action.equals("inviteuser")) {
				try {
					SUser user = null;
					try {
						user = loginManager.getService().getUserByUserName(in.getString("username"));
					} catch (UserException e) {
					}
					long uoid = -1;
					if (user == null) {
						if (loginManager.getService().isSettingAllowSelfRegistration()) {
							uoid = loginManager.getService().addUser(in.getString("username"), in.getString("name"), SUserType.valueOf(in.getString("type")), false).getOid();
						} else {
							JSONObject result = new JSONObject();
							result.put("error", "There is no user for this e-mail address and self-registration is disabled");
							result.write(response.getWriter());
							return;
						}
					} else {
						uoid = user.getOid();
					}
					JSONObject result = new JSONObject();
					result.put("uoid", uoid);
					result.write(response.getWriter());
				} catch (ServiceException e) {
					JSONObject result = new JSONObject();
					result.put("error", e.getMessage());
					result.write(response.getWriter());
					return;
				}
			}
		} catch (JSONException e) {
			LOGGER.error("", e);
		}
	}
}