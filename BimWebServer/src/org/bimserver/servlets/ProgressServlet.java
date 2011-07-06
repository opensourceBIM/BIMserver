package org.bimserver.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bimserver.BimServer;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.longaction.LongCheckinAction;
import org.bimserver.longaction.LongCheckinActionKey;
import org.bimserver.shared.LongActionState;
import org.bimserver.shared.ServiceException;
import org.bimserver.shared.UserException;
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
				if (request.getParameter("poid") != null) {
					long poid = Long.parseLong(request.getParameter("poid"));
					SProject project = loginManager.getService().getProjectByPoid(poid);
					if (project != null) {
						for (long roid : project.getRevisions()) {
							try {
								SRevision revision = loginManager.getService().getRevision(roid);
								JSONObject object = new JSONObject();
								object.put("roid", roid);
								object.put("state", revision.getState());
								object.put("totalsize", revision.getSize());
								object.put("lastError", revision.getLastError());
								object.put("clashes", revision.getNrClashes());
								object.put("islast", (loginManager.getService().getProjectByPoid(revision.getProjectId()).getLastRevisionId() == revision.getOid()));
								BimServer bimServer = (BimServer) request.getServletContext().getAttribute("bimserver");
								LongCheckinAction longCheckinAction = bimServer.getLongActionManager().getLongAction(LongCheckinAction.class, new LongCheckinActionKey(revision.getLastConcreteRevisionId()));
								if (longCheckinAction != null) {
									object.put("progress", longCheckinAction.getProgress());
								}
								revisions.put(object);
							} catch (UserException e) {
								// This is probably a browser trying to load
								// stuff that is not there anymore
							}
						}
						result.put("lastRevision", project.getLastRevisionId());
					}
					result.put("revisions", revisions);
				} else if (request.getParameter("laid") != null) {
					LongActionState downloadState = loginManager.getService().getDownloadState(Integer.parseInt(request.getParameter("laid")));
					result.put("state", downloadState.getState());
					result.put("progress", downloadState.getProgress());
				}
			} else {
				revisions.put("error");
			}
			result.write(response.getWriter());
		} catch (NumberFormatException e) {
			LOGGER.error("", e);
		} catch (JSONException e) {
			LOGGER.error("", e);
		} catch (ServiceException e) {
			LOGGER.error("", e);
		}
	}
}