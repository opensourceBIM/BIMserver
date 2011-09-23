package org.bimserver.servlets;

/******************************************************************************
 * Copyright (C) 2011  BIMserver.org
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

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.web.LoginManager;

import com.google.common.base.Charsets;

public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = -521315408437405994L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginManager loginManager = (LoginManager) request.getSession().getAttribute("loginManager");
		if (request.getParameter("file") != null) {
			String file = request.getParameter("file");
			if (file.equals("service.proto")) {
				String protocolBuffersFile;
				try {
					protocolBuffersFile = loginManager.getService().getProtocolBuffersFile();
					response.getOutputStream().write(protocolBuffersFile.getBytes(Charsets.UTF_8));
				} catch (ServiceException e) {
					e.printStackTrace();
				}
			}
		}
	}
}