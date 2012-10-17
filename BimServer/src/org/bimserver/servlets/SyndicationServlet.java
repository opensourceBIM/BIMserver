package org.bimserver.servlets;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.bimserver.BimServer;
import org.bimserver.interfaces.objects.SCheckout;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.shared.comparators.SRevisionIdComparator;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.ServiceException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedOutput;

public class SyndicationServlet extends HttpServlet {
	private static final Logger LOGGER = LoggerFactory.getLogger(SyndicationServlet.class);
	private static final long serialVersionUID = -8204995157688379164L;
	private static final String FEED_TYPE = "atom_1.0";

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BimServer bimServer = (BimServer) getServletContext().getAttribute("bimserver");
		if (!bimServer.isHostAllowed(request.getHeader("Origin"))) {
			response.setStatus(403);
			return;
		}
		if (request.getHeader("Authorization") != null) {
			String authorization = request.getHeader("Authorization");
			String usernamePasswordEncoded = authorization.substring(6);
			String decodeBase64 = new String(Base64.decodeBase64(usernamePasswordEncoded.getBytes(Charsets.UTF_8)), Charsets.UTF_8);
			if (decodeBase64.equals(":")) {
				response.getWriter().print("Not authenticated");
				return;
			}
			String[] split = decodeBase64.split(":");
			String username = split[0];
			String password = split[1];
			ServiceInterface service = (ServiceInterface) getServletContext().getAttribute("service");
			if (service == null) {
				try {
					service = bimServer.getServiceFactory().newServiceMap(AccessMethod.SYNDICATION, request.getRemoteAddr()).get(ServiceInterface.class);
				} catch (ServerException e) {
					e.printStackTrace();
				} catch (UserException e) {
					e.printStackTrace();
				}
			}
			try {
				if (service.login(username, password) != null) {
					String requestURI = request.getRequestURI();
					response.setContentType("application/atom+xml");
					try {
						if (requestURI.endsWith("/projects")) {
							writeProjectsFeed(request, response, service);
						} else if (requestURI.contains("/revisions")) {
							writeRevisionsFeed(request, response, service);
						} else if (requestURI.contains("/checkouts")) {
							writeCheckoutsFeed(request, response, service);
						}
					} catch (ServiceException e) {
						response.setContentType("text/html");
						response.getWriter().println(e.getUserMessage());
					} catch (FeedException e) {
						LOGGER.error("", e);
					}
				} else {
					response.setStatus(401);
					response.setHeader("WWW-Authenticate", "Basic realm=\"Secure Area\"");
				}
			} catch (ServiceException e) {
				LOGGER.error("", e);
			}
		} else {
			response.setStatus(401);
			response.setHeader("WWW-Authenticate", "Basic realm=\"Secure Area\"");
		}
	}

	private void writeProjectsFeed(HttpServletRequest request, HttpServletResponse response, ServiceInterface service) throws UserException, IOException, FeedException {
		SyndFeed feed = new SyndFeedImpl();
		feed.setFeedType(FEED_TYPE);

		feed.setTitle("BIMserver.org projects feed");
		feed.setLink(request.getContextPath());
		feed.setDescription("This feed represents all your available projects within this BIMserver");

		List<SyndEntry> entries = new ArrayList<SyndEntry>();
		try {
			List<SProject> allProjects = service.getAllProjects(false);
			for (SProject sProject : allProjects) {
				SyndEntry entry = new SyndEntryImpl();
				entry.setAuthor(service.getUserByUoid(sProject.getCreatedById()).getName());
				entry.setTitle(sProject.getName());
				entry.setLink(request.getContextPath() + "/project.jsp?poid=" + sProject.getOid());
				entry.setPublishedDate(sProject.getCreatedDate());
				SyndContent description = new SyndContentImpl();
				description.setType("text/plain");
				description.setValue(sProject.getDescription());
				entry.setDescription(description);
				entries.add(entry);
			}
			if (allProjects.size() == 0) {
				SyndEntry entry = new SyndEntryImpl();
				entry.setTitle("No projects found");
				entry.setLink(request.getContextPath() + "/main.jsp");
				entry.setPublishedDate(new Date());
				SyndContent description = new SyndContentImpl();
				description.setType("text/plain");
				description.setValue("No projects found");
				entry.setDescription(description);
				entries.add(entry);
			}
		} catch (ServiceException e) {
			LOGGER.error("", e);
		}
		feed.setEntries(entries);
		SyndFeedOutput output = new SyndFeedOutput();
		output.output(feed, response.getWriter());
	}

	private void writeRevisionsFeed(HttpServletRequest request, HttpServletResponse response, ServiceInterface service) throws IOException, FeedException, ServiceException {
		long poid = Long.parseLong(request.getParameter("poid"));
		SProject sProject = service.getProjectByPoid(poid);

		SyndFeed feed = new SyndFeedImpl();
		feed.setFeedType(FEED_TYPE);

		feed.setTitle("BIMserver.org revisions feed for project '" + sProject.getName() + "'");
		feed.setLink(request.getContextPath());
		feed.setDescription("This feed represents all the revisions of project '" + sProject.getName() + "'");

		List<SyndEntry> entries = new ArrayList<SyndEntry>();
		try {
			List<SRevision> allRevisionsOfProject = service.getAllRevisionsOfProject(poid);
			Collections.sort(allRevisionsOfProject, new SRevisionIdComparator(false));
			for (SRevision sVirtualRevision : allRevisionsOfProject) {
				SUser user = service.getUserByUoid(sVirtualRevision.getUserId());
				SyndEntry entry = new SyndEntryImpl();
				entry.setTitle("Revision " + sVirtualRevision.getOid());
				entry.setLink(request.getContextPath() + "/revision.jsp?poid=" + sVirtualRevision.getOid() + "&roid=" + sVirtualRevision.getOid());
				entry.setPublishedDate(sVirtualRevision.getDate());
				SyndContent description = new SyndContentImpl();
				description.setType("text/html");
				description.setValue("<table><tr><td>User</td><td>" + user.getUsername() + "</td></tr><tr><td>Comment</td><td>" + sVirtualRevision.getComment() + "</td></tr></table>");
				entry.setDescription(description);
				entries.add(entry);
			}
		} catch (ServiceException e) {
			LOGGER.error("", e);
		}
		feed.setEntries(entries);
		SyndFeedOutput output = new SyndFeedOutput();
		output.output(feed, response.getWriter());
	}

	private void writeCheckoutsFeed(HttpServletRequest request, HttpServletResponse response, ServiceInterface service) throws ServiceException, IOException, FeedException {
		long poid = Long.parseLong(request.getParameter("poid"));
		SProject sProject = service.getProjectByPoid(poid);

		SyndFeed feed = new SyndFeedImpl();
		feed.setFeedType(FEED_TYPE);

		feed.setTitle("BIMserver.org checkouts feed for project '" + sProject.getName() + "'");
		feed.setLink(request.getContextPath());
		feed.setDescription("This feed represents all the checkouts of project '" + sProject.getName() + "'");

		List<SyndEntry> entries = new ArrayList<SyndEntry>();
		try {
			List<SCheckout> allCheckoutsOfProject = service.getAllCheckoutsOfProjectAndSubProjects(poid);
			for (SCheckout sCheckout : allCheckoutsOfProject) {
				SRevision revision = service.getRevision(sCheckout.getRevisionId());
				SProject project = service.getProjectByPoid(sCheckout.getProjectId());
				SUser user = service.getUserByUoid(sCheckout.getUserId());
				SyndEntry entry = new SyndEntryImpl();
				entry.setTitle("Checkout on " + project.getName() + ", revision " + revision.getId());
				entry.setLink(request.getContextPath() + "/project.jsp?poid=" + sProject.getOid());
				entry.setPublishedDate(sCheckout.getDate());
				SyndContent description = new SyndContentImpl();
				description.setType("text/plain");
				description.setValue("<table><tr><td>User</td><td>" + user.getUsername() + "</td></tr><tr><td>Revision</td><td>" + sCheckout.getRevisionId() + "</td></tr></table>");
				entry.setDescription(description);
				entries.add(entry);
			}
		} catch (UserException e) {
			LOGGER.error("", e);
		}
		feed.setEntries(entries);
		SyndFeedOutput output = new SyndFeedOutput();
		output.output(feed, response.getWriter());
	}
}