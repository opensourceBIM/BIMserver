package org.bimserver.renderengine;

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
	private RenderEnginePoolFactory renderEnginePoolFactory;

	public RenderEnginePools(BimServer bimServer, RenderEnginePoolFactory renderEnginePoolFactory) throws RenderEngineException {
		this.bimServer = bimServer;
		this.renderEnginePoolFactory = renderEnginePoolFactory;
		
//		Collection<RenderEnginePlugin> renderEnginePlugins = bimServer.getPluginManager().getAllRenderEnginePlugins(true).values();
		for (Schema schema : Schema.getIfcSchemas()) {
			HashMap<String, RenderEnginePool> map = new HashMap<>();
			pools.put(schema, map);
//			for (RenderEnginePlugin renderEnginePlugin : renderEnginePlugins) {
//				RenderEnginePool renderEnginePool = renderEnginePoolFactory.newRenderEnginePool(new RenderEngineFactory(){
//					@Override
//					public RenderEngine createRenderEngine() throws RenderEngineException {
//						return renderEnginePlugin.createRenderEngine(pluginConfiguration, schema.name());
//					}});
//				map.put(renderEnginePlugin.getClass().getName(), renderEnginePool);
//			}
		}
	}

	public RenderEnginePool getRenderEnginePool(Schema schema, String className, PluginConfiguration pluginConfiguration) throws PluginException {
		if (pools.containsKey(schema)) {
			Map<String, RenderEnginePool> map = pools.get(schema);
			if (map.containsKey(className)) {
				return map.get(className);
			} else {
				// Maybe this plugin has been installed after startup, let's have a look in the PluginManager
				RenderEnginePlugin renderEnginePlugin = bimServer.getPluginManager().getRenderEnginePlugin(className, true);
				if (renderEnginePlugin == null) {
					throw new PluginException("No render engine found for className " + className);
				} else {
					RenderEnginePool renderEnginePool = renderEnginePoolFactory.newRenderEnginePool(new RenderEngineFactory(){
						@Override
						public RenderEngine createRenderEngine() throws RenderEngineException {
							return renderEnginePlugin.createRenderEngine(pluginConfiguration, schema.name());
						}});
					map.put(className, renderEnginePool);
					return renderEnginePool;
				}
			}
		} else {
			throw new PluginException("No render engine found for schema " + schema);
		}
	}
}