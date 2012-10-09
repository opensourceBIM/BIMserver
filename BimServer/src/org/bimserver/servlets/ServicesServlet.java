package org.bimserver.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.database.query.conditions.AttributeCondition;
import org.bimserver.database.query.conditions.Condition;
import org.bimserver.database.query.literals.StringLiteral;
import org.bimserver.models.store.InternalServicePluginConfiguration;
import org.bimserver.models.store.StorePackage;
import org.bimserver.models.store.User;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class ServicesServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BimServer bimServer = (BimServer) getServletContext().getAttribute("bimserver");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		try {
			if (request.getParameter("doc") != null) {
				writeDoc(request, response);
			} else if (request.getParameter("profiles") != null) {
				if (request.getParameter("token") != null) {
					writeProfiles(request, response, request.getParameter("token"), bimServer);
				} else {
					writePublicProfiles(request, response);
				}
			}
		} catch (JSONException e) {
		} catch (IOException e) {
		}
	}

	private void writeProfiles(HttpServletRequest request, HttpServletResponse response, String token, BimServer bimServer) throws JSONException, IOException {
		DatabaseSession session = bimServer.getDatabase().createSession();
		JSONObject result = new JSONObject();
		JSONArray profiles = new JSONArray();
		try {
			Condition condition = new AttributeCondition(StorePackage.eINSTANCE.getUser_Token(), new StringLiteral(token));
			User user = session.querySingle(condition, User.class, false, null);
			if (user != null) {
				for (InternalServicePluginConfiguration internalServicePluginConfiguration : user.getUserSettings().getServices()) {
					JSONObject profile = new JSONObject();
					profiles.put(profile);
					profile.put("identifier", internalServicePluginConfiguration.getOid());
					profile.put("name", internalServicePluginConfiguration.getName());
					profile.put("description", internalServicePluginConfiguration.getDescription());
					profile.put("publicProfile", false);
				}
			}
		} catch (BimserverDatabaseException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		result.put("profiles", profiles);
		result.write(response.getWriter());
	}

	private void writePublicProfiles(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {
		JSONObject result = new JSONObject();
		JSONArray profiles = new JSONArray();
		result.put("profiles", profiles);
		result.write(response.getWriter());
	}

	private void writeDoc(HttpServletRequest request, HttpServletResponse response) {
	}
}
