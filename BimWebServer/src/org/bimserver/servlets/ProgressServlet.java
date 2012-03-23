package org.bimserver.servlets;

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

import org.bimserver.interfaces.objects.SCheckinResult;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.web.LoginManager;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProgressServlet extends HttpServlet {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProgressServlet.class);
	private static final long serialVersionUID = -1957923502114983147L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject result = new JSONObject();
		response.setContentType("text/json");
		try {
			LOGGER.info("Progress request");
			response.setContentType("application/json");
			LoginManager loginManager = (LoginManager) request.getSession().getAttribute("loginManager");
			if (loginManager != null) {
				if (request.getParameter("checkinid") != null) {
					int checkinId = Integer.parseInt(request.getParameter("checkinid"));
					SCheckinResult checkinState = loginManager.getService().getCheckinState(checkinId);
					result.put("progress", checkinState.getProgress());
					result.put("status", checkinState.getStatus());
					result.put("lastError", checkinState.getLastError());
				} else if (request.getParameter("laid") != null) {
					SLongActionState downloadState = loginManager.getService().getDownloadState(Integer.parseInt(request.getParameter("laid")));
					result.put("state", downloadState.getState());
					result.put("progress", downloadState.getProgress());
				}
			}
		} catch (Exception e) {
			try {
				result.put("error", e.getMessage());
			} catch (JSONException e1) {
			}
		}
		try {
			result.write(response.getWriter());
		} catch (JSONException e) {
		}
	}
}