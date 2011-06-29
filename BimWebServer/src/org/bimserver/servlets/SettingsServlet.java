package org.bimserver.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.bimserver.BimServer;
import org.bimserver.interfaces.objects.SSettings;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.models.store.Settings;
import org.bimserver.resources.JarResourceFetcher;
import org.bimserver.resources.WarResourceFetcher;
import org.bimserver.web.LoginManager;
import org.bimserver.webservices.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SettingsServlet extends HttpServlet {

	private static final long serialVersionUID = 2330574636289622518L;
	private static final Logger LOGGER = LoggerFactory.getLogger(SettingsServlet.class);

	@SuppressWarnings("unchecked")
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unused")
		String xsltName = null;
		BimServer bimServer = (BimServer) request.getServletContext().getAttribute("bimserver");
		try {
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			LoginManager loginManager = (LoginManager) request.getSession().getAttribute("loginManager");
			if (loginManager.getUserType() == SUserType.ADMIN) {
				if (isMultipart) {
					DiskFileItemFactory factory = new DiskFileItemFactory();
					factory.setSizeThreshold(1024 * 1024 * 300); // 300 MB
					ServletFileUpload upload = new ServletFileUpload(factory);
					try {
						List<FileItem> items = (List<FileItem>) upload.parseRequest(request);
						Iterator<FileItem> iter = items.iterator();
						while (iter.hasNext()) {
							FileItem item = iter.next();
							String fieldName = item.getFieldName();
							if (item.isFormField()) {
								if (fieldName.equals("xsltName")) {
									xsltName = item.getString();
								}
							} else {
								if (fieldName.equals("settings")) {
									JAXBContext jaxbContext = JAXBContext.newInstance(SSettings.class);
									Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
									SSettings sSettings = (SSettings) unmarshaller.unmarshal(item.getInputStream());
									bimServer.getSettingsManager().setSettings(Service.convert(sSettings, Settings.class, null));
									response.sendRedirect(getServletContext().getContextPath() + "/settings.jsp?msg=settingsfileuploadok");
									return;
								} else if (fieldName.equals("colladasettings")) {
									InputStream inputStream = item.getInputStream();
									File file = bimServer.getResourceFetcher().getFile("collada.xml");
									FileOutputStream fos = new FileOutputStream(file);
									IOUtils.copy(inputStream, fos);
									fos.close();
									response.sendRedirect(getServletContext().getContextPath()
											+ "/settings.jsp?msg=colladasettingsuploadok");
									return;
								} else if (fieldName.equals("xslt")) {
									//TODO How to add a result type to the predefined set
									
									InputStream inputStream = item.getInputStream();
									String homedir = (String) getServletContext().getAttribute("homedir");
									File xsltdir = new File(homedir + File.separator + "xslt");
									if (!xsltdir.exists()) {
										xsltdir.mkdir();
									}
									File xsltfile = new File(xsltdir.getAbsolutePath() + File.separator + item.getName());
									FileOutputStream fos = new FileOutputStream(xsltfile);
									IOUtils.copy(inputStream, fos);
									fos.close();									
									response.sendRedirect(getServletContext().getContextPath() + "/settings.jsp?msg=xsltuploadok");
									return;
								}
							}
						}
					} catch (FileUploadException e) {
						LOGGER.error("", e);
					}
				}
				if (request.getParameter("action") != null) {
					String action = request.getParameter("action");
					if (action.equals("downloadsettingsfile")) {
						response.setContentType("text/xml");
						response.setHeader("Content-Disposition", "attachment; filename=\"settings.xml\"");
						Settings settings = bimServer.getSettingsManager().getSettings();
						SSettings sSettings = Service.convert(settings, SSettings.class);
						JAXBContext jaxbContext = JAXBContext.newInstance(SSettings.class);
						Marshaller marshaller = jaxbContext.createMarshaller();
						marshaller.marshal(sSettings, response.getOutputStream());
						return;
					} else if (action.equals("downloadlog")) {
						response.setContentType("text");
						response.setHeader("Content-Disposition", "attachment; filename=\"bimserver.log\"");
						File logfile = null;
						if (bimServer.getResourceFetcher() instanceof WarResourceFetcher) {
							logfile = new File(getServletContext().getRealPath("/") + "bimserver.log");
						} else if (bimServer.getResourceFetcher() instanceof JarResourceFetcher) {
							logfile = new File("bimserver.log");
						} else {
							response.getWriter().println("No log file on local development stations");
							return;
						}
						if (logfile != null) {
							FileInputStream fileIn = new FileInputStream(logfile);
							byte[] buffer = new byte[1024];
							int read = fileIn.read(buffer);
							while (read >= 0) {
								response.getOutputStream().write(buffer, 0, read);
								read = fileIn.read(buffer);
							}
						}
						return;
					} else if (action.equals("downloadcolladasettings")) {
						response.setContentType("text/xml");
						response.setHeader("Content-Disposition", "attachment; filename=\"collada.xml\"");
						URL resource = bimServer.getResourceFetcher().getResource("collada.xml");
						InputStream openStream = resource.openStream();
						IOUtils.copy(openStream, response.getOutputStream());
						openStream.close();
						return;
					}
				}
			}
		} catch (Exception e) {
			response.getWriter().println(e.getMessage());
			LOGGER.error("", e);
		}
	}
}