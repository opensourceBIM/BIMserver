package org.bimserver.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bimserver.BimServer;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.actions.DownloadDatabaseAction;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.bimserver.querycompiler.CompileException;
import org.bimserver.querycompiler.QueryCompiler;
import org.bimserver.querycompiler.QueryInterface;
import org.bimserver.shared.ServiceException;
import org.bimserver.web.LoginManager;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CompileServlet extends HttpServlet {

	private static final Logger LOGGER = LoggerFactory.getLogger(CompileServlet.class);
	private static final long serialVersionUID = 2409894233105690606L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String code = request.getParameter("code");
		JSONObject root = new JSONObject();
		try {
			if (action.equals("compile")) {
				compile(root, code);
			} else if (action.equals("compileandrun")) {
				long roid = Long.parseLong(request.getParameter("roid"));
				QueryInterface compile = compile(root, code);
				LoginManager loginManager = (LoginManager) request.getSession().getAttribute("loginManager");
				if (compile != null) {
					run(compile, loginManager, roid, root, (BimServer)request.getServletContext().getAttribute("bimserver"));
				}
			}
		} catch (CompileException e) {
			LOGGER.info("", e);
		} catch (JSONException e) {
			LOGGER.error("", e);
		}
		try {
			root.write(response.getWriter());
		} catch (JSONException e) {
			LOGGER.error("", e);
		}
	}

	private void run(QueryInterface queryInterface, LoginManager loginManager, long roid, JSONObject root, BimServer bimServer) {
		if (loginManager == null) {
			loginManager = new LoginManager();
		}
		try {
			if (!loginManager.getService().isLoggedIn()) {
				loginManager.getService().loginAnonymous();
			}
		} catch (ServiceException e) {
			LOGGER.error("", e);
		}
		BimDatabaseSession session = bimServer.getDatabase().createSession(true);
		try {
			BimDatabaseAction<IfcModelInterface> action = new DownloadDatabaseAction(bimServer, session, AccessMethod.INTERNAL, roid, loginManager.getUoid());
			IfcModelInterface IfcModel = session.executeAndCommitAction(action, 10);
			StringWriter out = new StringWriter();
			queryInterface.query(IfcModel, new PrintWriter(out));
			try {
				root.put("output", root.getString("output") + "\n" + "Executing...\n\n" + out + "\n" + "Execution complete");
			} catch (JSONException e) {
				LOGGER.error("", e);
			}
		} catch (BimDatabaseException e) {
		} catch (ServiceException e) {
			LOGGER.error("", e);
		} finally {
			session.close();
		}
	}

	private QueryInterface compile(JSONObject root, String code) throws CompileException, JSONException {
		QueryCompiler queryCompiler = new QueryCompiler();
		QueryInterface compile = queryCompiler.compile(code, root);
		if (compile != null) {
			root.put("output", "Compilation successfull");
		}
		return compile;
	}
}