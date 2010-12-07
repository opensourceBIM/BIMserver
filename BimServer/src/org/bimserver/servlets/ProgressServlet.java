package org.bimserver.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bimserver.interfaces.objects.SRevision;
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
			response.setContentType("application/json");
			LoginManager loginManager = (LoginManager) request.getSession().getAttribute("loginManager");
			JSONArray result = new JSONArray();
			if (loginManager != null) {
				String roidsString = request.getParameter("roids");
				String[] split = roidsString.split(";");
				for (String roidString : split) {
					long roid = Long.parseLong(roidString);
					SRevision revision = loginManager.getService().getRevision(roid);
					JSONObject object = new JSONObject();
					object.put("roid", roid);
					object.put("state", revision.getState());
					object.put("totalsize", revision.getSize());
					object.put("lastError", revision.getLastError());
					object.put("clashes", revision.getLastClashes().size());
					object.put("islast", (loginManager.getService().getProjectByPoid(revision.getProjectId()).getLastRevisionId() == revision.getOid()));
					result.put(object);
				}
			} else {
				result.put("error");
			}
			result.write(response.getWriter());
		} catch (NumberFormatException e) {
			LOGGER.error("", e);
		} catch (UserException e) {
			LOGGER.error("", e);
		} catch (JSONException e) {
			LOGGER.error("", e);
		}
	}
}