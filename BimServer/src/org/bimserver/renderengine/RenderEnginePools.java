package org.bimserver.renderengine;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.bimserver.BimServer;
import org.bimserver.emf.Schema;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.renderengine.RenderEngine;
import org.bimserver.plugins.renderengine.RenderEngineException;
import org.bimserver.plugins.renderengine.RenderEnginePlugin;
import org.bimserver.shared.exceptions.PluginException;

public class RenderEnginePools {

	private BimServer bimServer;
	private final Map<Schema, Map<String, RenderEnginePool>> pools = new HashMap<>();

	public RenderEnginePools(BimServer bimServer) throws RenderEngineException {
		this.bimServer = bimServer;
		int nrRenderEngineProcesses = this.bimServer.getServerSettingsCache().getServerSettings().getRenderEngineProcesses();
		
		Collection<RenderEnginePlugin> renderEnginePlugins = bimServer.getPluginManager().getAllRenderEnginePlugins(true);
		for (Schema schema : Schema.getIfcSchemas()) {
			HashMap<String, RenderEnginePool> map = new HashMap<>();
			pools.put(schema, map);
			for (RenderEnginePlugin renderEnginePlugin : renderEnginePlugins) {
				map.put(renderEnginePlugin.getClass().getName(), new RenderEnginePool(nrRenderEngineProcesses, new RenderEngineFactory(){
					@Override
					public RenderEngine createRenderEngine() throws RenderEngineException {
						return renderEnginePlugin.createRenderEngine(new PluginConfiguration(), schema.name());
					}}));
			}
		}
	}
	
	public RenderEnginePool getRenderEnginePool(Schema schema, String className) throws PluginException {
		if (pools.containsKey(schema)) {
			Map<String, RenderEnginePool> map = pools.get(schema);
			if (map.containsKey(className)) {
				return map.get(className);
			} else {
				throw new PluginException("No render engine found for className " + className);
			}
		} else {
			throw new PluginException("No render engine found for schema " + schema);
		}
	}
}