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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.bimserver.BimServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = -521315408437405994L;
	private static final Logger LOGGER = LoggerFactory.getLogger(FileServlet.class);

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("file") != null) {
			String file = request.getParameter("file");
			if (file.equals("service.proto")) {
				BimServer bimServer = (BimServer) request.getServletContext().getAttribute("bimserver");
				sendFile(bimServer.getResourceFetcher().getFile("service.proto"), response);
			}
		}
	}

	private void sendFile(File file, HttpServletResponse response) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			IOUtils.copy(fis, response.getOutputStream());
		} catch (FileNotFoundException e) {
			LOGGER.error("", e);
		} catch (IOException e) {
			LOGGER.error("", e);
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					LOGGER.error("", e);
				}
			}
		}
	}
}
