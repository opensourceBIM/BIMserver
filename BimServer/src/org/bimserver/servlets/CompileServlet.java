package org.bimserver.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bimserver.LoginManager;
import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimDatabaseException;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.actions.DownloadDatabaseAction;
import org.bimserver.database.store.log.AccessMethod;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.database.IfcDatabase;
import org.bimserver.querycompiler.QueryCompiler;
import org.bimserver.querycompiler.QueryInterface;
import org.bimserver.shared.UserException;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class CompileServlet extends HttpServlet {

	private static final long serialVersionUID = 2409894233105690606L;
	public static BimDatabase database;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String code = request.getParameter("code");
		JSONObject root = new JSONObject();
		if (action.equals("compile")) {
			QueryInterface compile = compile(root, code);
			if (compile != null) {
				try {
					root.put("output", "Compilation succesfull");
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		} else if (action.equals("compileandrun")) {
			long roid = Long.parseLong(request.getParameter("roid"));
			QueryInterface compile = compile(root, code);
			if (compile != null) {
				try {
					root.put("output", "Compilation succesfull");
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			LoginManager loginManager = (LoginManager) request.getSession().getAttribute("loginManager");
			if (compile != null) {
				run(compile, loginManager, roid, root);
			}
		}
		try {
			root.write(response.getWriter());
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	private void run(QueryInterface queryInterface, LoginManager loginManager, long roid, JSONObject root) {
		if (loginManager == null) {
			loginManager = new LoginManager();
		}
		if (!loginManager.isLoggedIn()) {
			loginManager.loginAnonymous();
		}
		BimDatabaseSession session = database.createSession();
		try {
			BimDatabaseAction<IfcModel> action = new DownloadDatabaseAction(AccessMethod.INTERNAL, roid, loginManager.getUoid());
			IfcModel IfcModel = session.executeAndCommitAction(action, 10);
			StringWriter out = new StringWriter();
			queryInterface.query(new IfcDatabase(IfcModel, null), new PrintWriter(out));
			try {
				root.put("output", root.getString("output") + "\n" + "Executing...\n\n" + out + "\n" + "Execution complete");
			} catch (JSONException e) {
				e.printStackTrace();
			}
		} catch (BimDatabaseException e) {
		} catch (UserException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	private QueryInterface compile(JSONObject root, String code) {
		QueryCompiler queryCompiler = new QueryCompiler();
		QueryInterface compile = queryCompiler.compile(code, root);
		return compile;
	}
}