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

import org.bimserver.interfaces.objects.SCompileResult;
import org.bimserver.interfaces.objects.SRunResult;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.web.LoginManager;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompileServlet extends HttpServlet {

	private static final Logger LOGGER = LoggerFactory.getLogger(CompileServlet.class);
	private static final long serialVersionUID = 2409894233105690606L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String code = request.getParameter("code");
		LoginManager loginManager = (LoginManager) request.getSession().getAttribute("loginManager");
		JSONObject root = new JSONObject();
		JSONArray warnings = new JSONArray();
		JSONArray errors = new JSONArray();
		try {
			root.put("output", "");
			root.put("compileErrors", errors);
			root.put("compileWarnings", warnings);
		} catch (JSONException e) {
			LOGGER.error("", e);
		}
		try {
			if (action.equals("compile")) {
				try {
					SCompileResult compileResult = loginManager.getService().compile(code);
					if (compileResult.getCompileOke() == true) {
						root.put("output", "Compilation successfull");
					} else {
						for (String warning : compileResult.getWarnings()) {
							warnings.put(warning);
						}
						for (String error : compileResult.getErrors()) {
							errors.put(error);
						}
					}
				} catch (ServiceException e) {
					root.put("output", e.getMessage());
				}
			} else if (action.equals("compileandrun")) {
				long roid = Long.parseLong(request.getParameter("roid"));
				try {
					SRunResult compileAndRun = loginManager.getService().compileAndRun(roid, code);
					if (compileAndRun.getRunOke()) {
						root.put("output", compileAndRun.getOutput());
					} else {
						for (String warning : compileAndRun.getWarnings()) {
							warnings.put(warning);
						}
						for (String error : compileAndRun.getErrors()) {
							errors.put(error);
						}
					}
				} catch (ServiceException e) {
					root.put("output", e.getMessage());
				}
			}
		} catch (JSONException e) {
			LOGGER.error("", e);
		}
		try {
			root.write(response.getWriter());
		} catch (JSONException e) {
			LOGGER.error("", e);
		}
	}
}