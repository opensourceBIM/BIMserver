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
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.web.LoginManager;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProgressServlet extends HttpServlet {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProgressServlet.class);
	private static final long serialVersionUID = -1957923502114983147L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			LOGGER.info("Progress request");
			response.setContentType("application/json");
			LoginManager loginManager = (LoginManager) request.getSession().getAttribute("loginManager");
			JSONObject result = new JSONObject();
			JSONArray revisions = new JSONArray();
			if (loginManager != null) {
				if (request.getParameter("checkinId") != null) {
					int checkinId = Integer.parseInt(request.getParameter("checkinId"));
					SCheckinResult checkinState = loginManager.getService().getCheckinState(checkinId);
					try {
						SRevision revision = loginManager.getService().getRevision(checkinState.getRevisionId());
						JSONObject object = new JSONObject();
						object.put("roid", checkinState.getRevisionId());
						object.put("state", revision.getState());
						object.put("totalsize", revision.getSize());
						object.put("lastError", revision.getLastError());
						object.put("clashes", revision.getNrClashes());
						object.put("islast", (loginManager.getService().getProjectByPoid(revision.getProjectId()).getLastRevisionId() == revision.getOid()));
						object.put("progress", checkinState.getProgress());
						revisions.put(object);
					} catch (UserException e) {
						// This is probably a browser trying to load
						// stuff that is not there anymore
					}
				} else if (request.getParameter("laid") != null) {
					SLongActionState downloadState = loginManager.getService().getDownloadState(Integer.parseInt(request.getParameter("laid")));
					result.put("state", downloadState.getState());
					result.put("progress", downloadState.getProgress());
				}
			}
			result.put("revisions", revisions);
			result.write(response.getWriter());
		} catch (NumberFormatException e) {
			LOGGER.error("", e);
		} catch (JSONException e) {
			LOGGER.error("", e);
		} catch (UserException e) {
			JSONObject result = new JSONObject();
			try {
				result.put("error", e.getMessage());
				result.write(response.getWriter());
			} catch (JSONException e1) {
				LOGGER.error("", e);
			}
		} catch (ServerException e) {
			LOGGER.error("", e);
		}
	}
}