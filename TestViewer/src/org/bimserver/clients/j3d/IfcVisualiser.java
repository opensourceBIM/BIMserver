package org.bimserver.clients.j3d;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.media.j3d.AmbientLight;
import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.Bounds;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.GeometryArray;
import javax.media.j3d.Link;
import javax.media.j3d.Locale;
import javax.media.j3d.Material;
import javax.media.j3d.PhysicalBody;
import javax.media.j3d.PhysicalEnvironment;
import javax.media.j3d.Shape3D;
import javax.media.j3d.SharedGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.TriangleArray;
import javax.media.j3d.View;
import javax.media.j3d.ViewPlatform;
import javax.media.j3d.VirtualUniverse;
import javax.swing.JFrame;
import javax.vecmath.Color3f;
import javax.vecmath.Matrix3f;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

import org.bimserver.LocalDevPluginLoader;
import org.bimserver.clients.j3d.behavior.OrbitBehaviorInterim;
import org.bimserver.emf.IdEObject;
import org.bimserver.emf.IdEObjectImpl;
import org.bimserver.ifc.IfcModel;
import org.bimserver.ifc.step.serializer.IfcStepSerializer;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcBeam;
import org.bimserver.models.ifc2x3tc1.IfcColumn;
import org.bimserver.models.ifc2x3tc1.IfcDistributionFlowElement;
import org.bimserver.models.ifc2x3tc1.IfcDoor;
import org.bimserver.models.ifc2x3tc1.IfcFlowTerminalType;
import org.bimserver.models.ifc2x3tc1.IfcFurnishingElement;
import org.bimserver.models.ifc2x3tc1.IfcGloballyUniqueId;
import org.bimserver.models.ifc2x3tc1.IfcOpeningElement;
import org.bimserver.models.ifc2x3tc1.IfcRailing;
import org.bimserver.models.ifc2x3tc1.IfcRoof;
import org.bimserver.models.ifc2x3tc1.IfcRoot;
import org.bimserver.models.ifc2x3tc1.IfcSite;
import org.bimserver.models.ifc2x3tc1.IfcSlab;
import org.bimserver.models.ifc2x3tc1.IfcSpace;
import org.bimserver.models.ifc2x3tc1.IfcStair;
import org.bimserver.models.ifc2x3tc1.IfcWall;
import org.bimserver.models.ifc2x3tc1.IfcWallStandardCase;
import org.bimserver.models.ifc2x3tc1.IfcWindow;
import org.bimserver.models.ifc2x3tc1.WrappedValue;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.deserializers.DeserializerPlugin;
import org.bimserver.plugins.deserializers.EmfDeserializer;
import org.bimserver.plugins.ifcengine.IfcEngine;
import org.bimserver.plugins.ifcengine.IfcEngineException;
import org.bimserver.plugins.ifcengine.IfcEngineGeometry;
import org.bimserver.plugins.ifcengine.IfcEngineInstance;
import org.bimserver.plugins.ifcengine.IfcEngineInstanceVisualisationProperties;
import org.bimserver.plugins.ifcengine.IfcEngineModel;
import org.bimserver.plugins.ifcengine.IfcEngineSurfaceProperties;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.plugins.objectidms.ObjectIDMException;
import org.bimserver.plugins.serializers.IfcModelInterface;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.xml.internal.ws.encoding.soap.DeserializationException;

public class IfcVisualiser extends JFrame {
	private static final long serialVersionUID = -4779999816911473897L;
	private static final Logger LOGGER = LoggerFactory.getLogger(IfcVisualiser.class);
	private BranchGroup sceneBranchGroup;
	private BranchGroup viewBranchGroup;
	private OrbitBehaviorInterim orbitBehaviorInterim;
	private volatile boolean showLoader;
	private BranchGroup buildingBranchGroup;
	private TransformGroup buildingTransformGroup;
	private BranchGroup loaderBranchGroup;
	private TransformGroup loaderTransformGroup;
	private Canvas3D canvas;
	private View view;
	private SharedGroup sharedGroup;
	private Appearances appearances = new Appearances();
	private IfcEngine ifcEngine;
	private PluginManager pluginManager;
	private ObjectIDM objectIDM;

	public static void main(String[] args) {
		try {
			new IfcVisualiser().start();
		} catch (PluginException e) {
			LOGGER.error("", e);
		}
	}

	private void start() throws PluginException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			setIconImage(ImageIO.read(getClass().getResource("haussmall.png")));
		} catch (IOException e) {
			LOGGER.error("", e);
		}
		setSize(800, 600);
		getContentPane().setBackground(Color.BLACK);
		setTitle("IFC Visualiser");
		setVisible(true);

		VirtualUniverse universe = new VirtualUniverse();
		Locale locale = new Locale(universe);
		canvas = new Canvas3D(SimpleUniverse.getPreferredConfiguration());

		sceneBranchGroup = new BranchGroup();
		sceneBranchGroup.setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND);
		sceneBranchGroup.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);
		createLoaderSceneGraph();
		locale.addBranchGraph(sceneBranchGroup);

		showLoader = true;
		new Thread() {
			public void run() {
				float x = 0;
				float y = 0;
				while (showLoader) {
					Matrix3f matrixX = new Matrix3f();
					matrixX.rotX(x);

					Matrix3f matrixY = new Matrix3f();
					matrixY.rotY(y);

					Matrix3f rot = new Matrix3f();
					rot.mul(matrixX, matrixY);

					Transform3D transform3d = new Transform3D();
					transform3d.setRotation(rot);
					transform3d.setTranslation(new Vector3d(10, 0, 0));
					loaderTransformGroup.setTransform(transform3d);
					y -= 0.05;
					x += 0.015;
					try {
						Thread.sleep(25);
					} catch (InterruptedException e) {
						LOGGER.error("", e);
					}
				}
			};
		}.start();

		viewBranchGroup = new BranchGroup();
		createViewBranch();
		viewBranchGroup.compile();
		locale.addBranchGraph(viewBranchGroup);

		add(canvas, BorderLayout.CENTER);

		canvas.setVisible(true);
		validate();

		sharedGroup = new SharedGroup();

		try {
			pluginManager = LocalDevPluginLoader.createPluginManager(new File("home"));
			objectIDM = pluginManager.requireObjectIDM();
		} catch (PluginException e) {
			LOGGER.error("", e);
		} catch (ObjectIDMException e) {
			LOGGER.error("", e);
		}
		
		createSceneGraph();
		System.out.println("Done");
	}

	protected void createViewBranch() {
		TransformGroup viewTG = new TransformGroup();
		viewTG.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

		ViewPlatform viewPlatform = new ViewPlatform();
		view = new View();
		view.setBackClipDistance(30000);
		view.addCanvas3D(canvas);
		view.setPhysicalBody(new PhysicalBody());
		view.setPhysicalEnvironment(new PhysicalEnvironment());
		view.attachViewPlatform(viewPlatform);

		float halfRadius = (float) (getBoundingSphere(sceneBranchGroup).getRadius() / 2f);
		Point3d center = new Point3d();
		getBoundingSphere(sceneBranchGroup).getCenter(center);

		BoundingSphere globalBounds = new BoundingSphere();
		globalBounds.setRadius(Double.MAX_VALUE);

		orbitBehaviorInterim = new OrbitBehaviorInterim(canvas, viewTG, OrbitBehaviorInterim.REVERSE_ROTATE | OrbitBehaviorInterim.REVERSE_TRANSLATE);

		orbitBehaviorInterim.setRotationCenter(center);
		orbitBehaviorInterim
				.setViewingTransform(new Point3d(halfRadius, getViewPlatformDistance(sceneBranchGroup, canvas, view), halfRadius), center, new Vector3d(0, -1, 0), true);
		orbitBehaviorInterim.setVpView(view);
		orbitBehaviorInterim.setTransFactors(3.0, 3.0);
		orbitBehaviorInterim.setSchedulingBounds(globalBounds);

		viewTG.addChild(viewPlatform);
		viewTG.addChild(orbitBehaviorInterim);

		viewBranchGroup.addChild(viewTG);
	}

	private void reInitView() {
		Point3d center = new Point3d();
		getBoundingSphere(sceneBranchGroup).getCenter(center);
		float halfRadius = (float) (getBoundingSphere(sceneBranchGroup).getRadius() / 2f);
		orbitBehaviorInterim.setRotationCenter(center);
		orbitBehaviorInterim
				.setViewingTransform(new Point3d(halfRadius, getViewPlatformDistance(sceneBranchGroup, canvas, view), halfRadius), center, new Vector3d(0, -1, 0), true);
	}

	private void createLoaderSceneGraph() {
		loaderBranchGroup = new BranchGroup();
		loaderBranchGroup.setCapability(BranchGroup.ALLOW_DETACH);
		loaderTransformGroup = new TransformGroup();
		loaderTransformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		addLights(loaderBranchGroup);
		Appearance loaderAppearance = new Appearance();
		Color3f loaderColor = new Color3f(0.5f, 0.5f, 0.5f);
		Material loaderMaterial = new Material(loaderColor, new Color3f(), loaderColor, loaderColor, 10);
		loaderMaterial.setLightingEnable(true);
		loaderAppearance.setMaterial(loaderMaterial);
		for (int i = 0; i < 20; i++) {
			Transform3D translate3d = new Transform3D();
			translate3d.setTranslation(new Vector3f(0f, 0f, 0.9f));
			TransformGroup translate = new TransformGroup(translate3d);

			Transform3D rotationY3d = new Transform3D();
			rotationY3d.rotY((Math.PI * 2 * i) / 20);
			TransformGroup rotateY = new TransformGroup(rotationY3d);
			rotateY.addChild(translate);

			Box box = new Box(0.1f, 0.1f, 0.1f, loaderAppearance);
			translate.addChild(box);
			loaderTransformGroup.addChild(rotateY);
		}
		loaderBranchGroup.addChild(loaderTransformGroup);
		sceneBranchGroup.addChild(loaderBranchGroup);
	}

	private void createSceneGraph() throws PluginException {
		buildingTransformGroup = new TransformGroup();
		DeserializerPlugin deserializerPlugin = pluginManager.getFirstDeserializer("ifc", true);
		EmfDeserializer deserializer = deserializerPlugin.createDeserializer();
		deserializer.init(pluginManager.requireSchemaDefinition());
		IfcModelInterface model = null;
		try {
//			deserializer.read(new File("../TestData/data/export1.ifc"));
			model = deserializer.read(new File("../TestData/data/AC11-Institute-Var-2-IFC.ifc"), true);
		} catch (DeserializationException e) {
			LOGGER.error("", e);
		} catch (Exception e) {
			LOGGER.error("", e);
		}

		model.setObjectOids();

		Set<Class<? extends IfcRoot>> classesToConvert = new HashSet<Class<? extends IfcRoot>>();
		classesToConvert.add(IfcWall.class);
		classesToConvert.add(IfcWallStandardCase.class);
		classesToConvert.add(IfcWindow.class);
		classesToConvert.add(IfcOpeningElement.class);
		classesToConvert.add(IfcSlab.class);
		classesToConvert.add(IfcRoof.class);
		classesToConvert.add(IfcColumn.class);
		classesToConvert.add(IfcSpace.class);
		classesToConvert.add(IfcDoor.class);
		classesToConvert.add(IfcRailing.class);
		classesToConvert.add(IfcFurnishingElement.class);
		classesToConvert.add(IfcStair.class);
		classesToConvert.add(IfcBeam.class);
		classesToConvert.add(IfcFlowTerminalType.class);
		classesToConvert.add(IfcDistributionFlowElement.class);
		classesToConvert.add(IfcSite.class);
//		classesToConvert.add(IfcProxy.class);

		for (IdEObject idEObject : model.getValues()) {
			if (classesToConvert.contains(idEObject.eClass().getInstanceClass())) {
				setGeometry((IfcRoot) idEObject);
			}
		}
		buildingBranchGroup = new BranchGroup();
		addLights(buildingBranchGroup);
		buildingBranchGroup.addChild(buildingTransformGroup);
		showLoader = false;
		sceneBranchGroup.removeChild(loaderBranchGroup);
		sharedGroup.addChild(buildingBranchGroup);

//		for (int x = 0; x < 5; x++) {
//			for (int y = 0; y < 5; y++) {
				Link link1 = new Link(sharedGroup);
				Transform3D t3d1 = new Transform3D();
//				t3d1.setTranslation(new Vector3f(x * 20, y * 20, 0f));
				BranchGroup x1 = new BranchGroup();
				TransformGroup t1 = new TransformGroup(t3d1);
				x1.addChild(t1);
				t1.addChild(link1);
				sceneBranchGroup.addChild(x1);
//			}
//		}

		reInitView();
	}

	private void addLights(BranchGroup transformGroup) {
		BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 100000.0);

		AmbientLight ambientLight = new AmbientLight(new Color3f(0.5f, 0.5f, 0.5f));
		ambientLight.setInfluencingBounds(bounds);
		transformGroup.addChild(ambientLight);

		Color3f lightColor = new Color3f(1.0f, 1.0f, 1.0f);
		Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);
		DirectionalLight light1 = new DirectionalLight(true, lightColor, light1Direction);
		light1.setInfluencingBounds(bounds);
		transformGroup.addChild(light1);

		light1Direction.negate();
		DirectionalLight light2 = new DirectionalLight(true, lightColor, light1Direction);
		light2.setInfluencingBounds(bounds);
		transformGroup.addChild(light2);
	}

	public void createTriangles(IfcRoot ifcRootObject, IfcModel ifcModel, TransformGroup buildingTransformGroup) {
		IfcStepSerializer ifcSerializer = new IfcStepSerializer();
		try {
			ifcSerializer.init(ifcModel, null, null, null);
			IfcEngineModel model = ifcEngine.openModel(ifcSerializer.getBytes());
			try {
				model.setPostProcessing(true);
				IfcEngineSurfaceProperties initializeModelling = model.initializeModelling();
				IfcEngineGeometry geometry = model.finalizeModelling(initializeModelling);
				if (geometry != null) {
					List<? extends IfcEngineInstance> instances = model.getInstances(ifcRootObject.eClass().getName().toUpperCase());
					for (IfcEngineInstance instance : instances) {
						IfcEngineInstanceVisualisationProperties instanceInModelling = instance.getVisualisationProperties();
						if (instanceInModelling.getPrimitiveCount() != 0) {
							Appearance appearance = appearances.getAppearance(ifcRootObject);
							if (appearance != null) {
								Point3f[] coordinates = new Point3f[instanceInModelling.getPrimitiveCount() * 3];
								Vector3f[] normals = new Vector3f[instanceInModelling.getPrimitiveCount() * 3];
								for (int i = instanceInModelling.getStartIndex(); i < instanceInModelling.getPrimitiveCount() * 3 + instanceInModelling.getStartIndex(); i += 3) {
									int offsetIndex = i - instanceInModelling.getStartIndex();
									int i1 = geometry.getIndex(i);
									int i2 = geometry.getIndex(i + 1);
									int i3 = geometry.getIndex(i + 2);

									coordinates[offsetIndex] = new Point3f(geometry.getVertex(i1 * 3), geometry.getVertex(i1 * 3 + 1), geometry.getVertex(i1 * 3 + 2));
									coordinates[offsetIndex + 1] = new Point3f(geometry.getVertex(i3 * 3), geometry.getVertex(i3 * 3 + 1), geometry.getVertex(i3 * 3 + 2));
									coordinates[offsetIndex + 2] = new Point3f(geometry.getVertex(i2 * 3), geometry.getVertex(i2 * 3 + 1), geometry.getVertex(i2 * 3 + 2));

									normals[offsetIndex] = new Vector3f(geometry.getNormal(i1 * 3), geometry.getNormal(i1 * 3 + 1), geometry.getNormal(i1 * 3 + 2));
									normals[offsetIndex + 1] = new Vector3f(geometry.getNormal(i3 * 3), geometry.getNormal(i3 * 3 + 1), geometry.getNormal(i3 * 3 + 2));
									normals[offsetIndex + 2] = new Vector3f(geometry.getNormal(i2 * 3), geometry.getNormal(i2 * 3 + 1), geometry.getNormal(i2 * 3 + 2));
								}
								TriangleArray triangleArray = new TriangleArray(coordinates.length, GeometryArray.COORDINATES | GeometryArray.NORMALS);
								triangleArray.setCoordinates(0, coordinates);
								triangleArray.setNormals(0, normals);
								Shape3D myShape = new Shape3D(triangleArray, appearance);
								buildingTransformGroup.addChild(myShape);
								myShape.setUserData(ifcRootObject);
							}
						}
					}
				}
			} finally {
				model.close();
			}
		} catch (IfcEngineException e) {
			LOGGER.error("", e);
		} catch (Exception e) {
			LOGGER.error("", e);
		}
	}
	
	public float getViewPlatformDistance(BranchGroup scene, Component canvas, View view) {
		BoundingSphere sceneSphere = getBoundingSphere(scene);
		double sceneRadius = sceneSphere.getRadius();
		double borderFactor = 1.3;
		double ratioFactor = 1.0;
		int canvasWidth = canvas.getWidth();
		int canvasHeight = canvas.getHeight();
		if (canvasWidth > canvasHeight) {
			ratioFactor = (double) canvasWidth / canvasHeight;
		}
		double distance = ratioFactor * borderFactor * sceneRadius / Math.tan(view.getFieldOfView() / 2);
		return (float) distance;
	}

	private BoundingSphere getBoundingSphere(BranchGroup scene) {
		Bounds bounds = scene.getBounds();
		BoundingSphere sceneSphere = null;
		if (bounds instanceof BoundingSphere) {
			sceneSphere = (BoundingSphere) bounds;
		} else {
			sceneSphere = new BoundingSphere(bounds);
		}
		return sceneSphere;
	}

	private void setGeometry(IfcRoot ifcRootObject) {
		IfcModel ifcModel = new IfcModel();
		convertToSubset(ifcRootObject.eClass(), ifcRootObject, ifcModel, new HashMap<EObject, EObject>());
		createTriangles(ifcRootObject, ifcModel, buildingTransformGroup);
	}

	@SuppressWarnings("unchecked")
	protected EObject convertToSubset(EClass originalClass, IdEObject ifcRootObject, IfcModel newModel, Map<EObject, EObject> converted) {
		IdEObject newObject = (IdEObject) Ifc2x3tc1Factory.eINSTANCE.create(ifcRootObject.eClass());
		((IdEObjectImpl)newObject).setOid(ifcRootObject.getOid());
		converted.put(ifcRootObject, newObject);
		if (!(newObject instanceof WrappedValue) && !(newObject instanceof IfcGloballyUniqueId)) {
			newModel.add(newObject.getOid(), newObject, true);
		}
		for (EStructuralFeature eStructuralFeature : ifcRootObject.eClass().getEAllStructuralFeatures()) {
			if (objectIDM.shouldFollowReference(ifcRootObject.eClass(), ifcRootObject.eClass(), eStructuralFeature)) {
				Object get = ifcRootObject.eGet(eStructuralFeature);
				if (eStructuralFeature instanceof EAttribute) {
					if (get instanceof Float || get instanceof Double) {
						EStructuralFeature floatStringFeature = ifcRootObject.eClass().getEStructuralFeature("wrappedValueAsString");
						if (floatStringFeature != null) {
							Object floatString = ifcRootObject.eGet(floatStringFeature);
							newObject.eSet(floatStringFeature, floatString);
						} else {
							newObject.eSet(eStructuralFeature, get);
						}
					} else {
						newObject.eSet(eStructuralFeature, get);
					}
				} else if (eStructuralFeature instanceof EReference) {
					if (get == null) {
					} else {
						if (eStructuralFeature.isMany()) {
							BasicEList<EObject> list = (BasicEList<EObject>) get;
							BasicEList<EObject> toList = (BasicEList<EObject>) newObject.eGet(eStructuralFeature);
							for (Object o : list) {
								if (converted.containsKey(o)) {
									toList.addUnique(converted.get(o));
								} else {
									toList.addUnique(convertToSubset(originalClass, (IdEObject) o, newModel, converted));
								}
							}
						} else {
							if (converted.containsKey(get)) {
								newObject.eSet(eStructuralFeature, converted.get(get));
							} else {
								newObject.eSet(eStructuralFeature, convertToSubset(originalClass, (IdEObject) get, newModel, converted));
							}
						}
					}
				}
			}
		}
		return newObject;
	}
}
