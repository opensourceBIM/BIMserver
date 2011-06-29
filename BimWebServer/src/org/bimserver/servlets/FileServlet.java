package org.bimserver.servlets;

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
