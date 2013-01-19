package org.bimserver;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.tools.shell.Global;
import org.mozilla.javascript.tools.shell.Main;

public class TestScript {
	public static void main(String[] args) {
		Context cx = ContextFactory.getGlobal().enterContext();
		cx.setOptimizationLevel(-1);
		cx.setLanguageVersion(Context.VERSION_1_7);
		Global global = Main.getGlobal();
		global.init(cx);
		Main.processSource(cx, "www/js/env.rhino.1.2.js");
		Main.processSource(cx, "www/js/sha256.js");
		Main.processSource(cx, "www/js/bimserverapi.js");
		Main.processSource(cx, "www/js/jquery-1.8.2.min.js");
		Main.processSource(cx, "www/js/jquery.cookie.js");
		Main.processSource(cx, "www/js/String.js");
		Main.processSource(cx, "www/js/Formatters.js");
		Main.processSource(cx, "www/js/array.js");
		Main.processSource(cx, "test.js");
	}
}
