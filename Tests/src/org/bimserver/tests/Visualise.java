package org.bimserver.tests;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
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
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.emf.IfcModelInterfaceException;
import org.bimserver.ifc.IfcModel;
import org.bimserver.merging.RevisionMerger;
import org.bimserver.models.ifc2x3tc1.IfcProject;
import org.bimserver.plugins.PluginConfiguration;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializeException;
import org.bimserver.plugins.deserializers.Deserializer;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.serializers.Serializer;
import org.bimserver.plugins.serializers.SerializerException;
import org.bimserver.plugins.serializers.SerializerPlugin;
import org.bimserver.shared.IncrementingOidProvider;
import org.bimserver.shared.exceptions.PluginException;
import org.bimserver.utils.DeserializerUtils;
import org.bimserver.utils.SerializerUtils;
import org.bimserver.utils.SwingUtil;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class Visualise extends JFrame {
	private static final long serialVersionUID = 9066505986920442200L;

	public static void main(String[] args) {
		PluginManager pluginManager;
		try {
			pluginManager = LocalDevPluginLoader.createPluginManager(Paths.get("home"));
			DeserializerPlugin deserializerPlugin = pluginManager.requireDeserializer("application/ifc");
			Deserializer deserializer = deserializerPlugin.createDeserializer(new PluginConfiguration());
			deserializer.init(pluginManager.getMetaDataManager().getPackageMetaData("ifc2x3tc1"));
			IfcModelInterface model1 = DeserializerUtils.readFromFile(deserializer, TestFile.EXPORT3.getFile());
			IfcModelInterface model1b = DeserializerUtils.readFromFile(deserializer, TestFile.EXPORT3.getFile());
			IfcModelInterface model2 = DeserializerUtils.readFromFile(deserializer, TestFile.EXPORT3.getFile());
			IfcModelInterface model2b = DeserializerUtils.readFromFile(deserializer, TestFile.EXPORT3.getFile());
			model1.setObjectOids();
			model1b.setObjectOids();
			model2.setObjectOids();
			model2b.setObjectOids();
			model1.indexGuids();
			model2.indexGuids();
			model2.fixOids(new IncrementingOidProvider(model1.getHighestOid() + 1));
			IfcModel merged = new RevisionMerger(model1, model2).merge();
			SerializerPlugin serializerPlugin = pluginManager.getSerializerPlugin("org.bimserver.ifc.step.serializer.IfcStepSerializerPlugin", true);
			Serializer serializer = serializerPlugin.createSerializer(new PluginConfiguration());
			serializer.init(merged, null, false);
			SerializerUtils.writeToFile(serializer, Paths.get("merged.ifc"));
			new Visualise().start(model1b, "Model 1");
			new Visualise().start(model2b, "Model 2");
			new Visualise().start(merged, "Merged");
		} catch (PluginException e1) {
			e1.printStackTrace();
		} catch (SerializerException e) {
			e.printStackTrace();
		} catch (DeserializeException e) {
			e.printStackTrace();
		} catch (IfcModelInterfaceException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static class Model extends DefaultTreeModel {
		private static final long serialVersionUID = 8662534344492596229L;

		public Model(TreeNode root) {
			super(root);
		}
	}

	public static class LeafNode extends DefaultMutableTreeNode {
		private static final long serialVersionUID = -4778018897806257565L;

		public LeafNode(Object val) {
			super(val == null ? "" : val);
		}
	}

	public static class StructuralFeatureNode extends DefaultMutableTreeNode {
		private static final long serialVersionUID = -5928011017640377791L;
		private List<TreeNode> nodes;
		private final EStructuralFeature eStructuralFeature;
		private final IdEObject idEObject;

		public StructuralFeatureNode(IdEObject idEObject, EStructuralFeature eStructuralFeature) {
			super(eStructuralFeature.getName());
			this.idEObject = idEObject;
			this.eStructuralFeature = eStructuralFeature;
		}

		@Override
		public int getChildCount() {
			if (nodes == null) {
				init();
			}
			return nodes.size();
		}

		@SuppressWarnings("rawtypes")
		private void init() {
			nodes = new ArrayList<TreeNode>();
			if (eStructuralFeature instanceof EReference) {
				if (eStructuralFeature.isMany()) {
					List list = (List) idEObject.eGet(eStructuralFeature);
					for (Object o : list) {
						nodes.add(new ObjectNode((IdEObject) o));
					}
				} else {
					if (idEObject.eGet(eStructuralFeature) != null) {
						nodes.add(new ObjectNode((IdEObject) idEObject.eGet(eStructuralFeature)));
					}
				}
			} else if (eStructuralFeature instanceof EAttribute) {
				if (eStructuralFeature.isMany()) {
					List list = (List) idEObject.eGet(eStructuralFeature);
					for (Object o : list) {
						nodes.add(new LeafNode(o));
					}
				} else {
					if (idEObject.eGet(eStructuralFeature) != null) {
						nodes.add(new LeafNode(idEObject.eGet(eStructuralFeature)));
					}
				}
			}
		}

		@Override
		public TreeNode getChildAt(int index) {
			if (nodes == null) {
				init();
			}
			return nodes.get(index);
		}
	}

	public static class ObjectNode extends DefaultMutableTreeNode {
		private static final long serialVersionUID = 3005180498837681862L;
		private final IdEObject idEObject;
		private Map<EStructuralFeature, TreeNode> children;

		public ObjectNode(IdEObject idEObject) {
			super(idEObject.eClass().getName() + " (" + idEObject.getOid() + ")");
			this.idEObject = idEObject;
		}

		@Override
		public int getChildCount() {
			if (children == null) {
				init();
			}
			return children.size();
		}

		private void init() {
			children = new HashMap<EStructuralFeature, TreeNode>();
			for (EStructuralFeature eStructuralFeature : idEObject.eClass().getEAllStructuralFeatures()) {
				if (!children.containsKey(eStructuralFeature)) {
					children.put(eStructuralFeature, new StructuralFeatureNode(idEObject, eStructuralFeature));
				}
			}
		}

		@Override
		public TreeNode getChildAt(int index) {
			if (children == null) {
				init();
			}
			return children.get(idEObject.eClass().getEAllStructuralFeatures().get(index));
		}
	}

	private void start(IfcModelInterface model, String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SwingUtil.setLookAndFeelToNice();
		setSize(800, 600);
		setTitle("Visualiser - " + name);
		getContentPane().setLayout(new BorderLayout());

		ObjectNode root = new ObjectNode(model.getAll(IfcProject.class).iterator().next());
		Model newModel = new Model(root);
		JTree tree = new JTree(newModel);
		JScrollPane scrollPane = new JScrollPane(tree);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		setVisible(true);
	}
}