package org.bimserver.collada;

/******************************************************************************
 * Copyright (C) 2009-2014  BIMserver.org
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.ArrayList;
import java.util.List;

import org.bimserver.models.ifc2x3tc1.IfcColourOrFactor;
import org.bimserver.models.ifc2x3tc1.IfcColourRgb;
import org.bimserver.models.ifc2x3tc1.IfcExternallyDefinedSurfaceStyle;
import org.bimserver.models.ifc2x3tc1.IfcNormalisedRatioMeasure;
import org.bimserver.models.ifc2x3tc1.IfcPresentationStyleAssignment;
import org.bimserver.models.ifc2x3tc1.IfcPresentationStyleSelect;
import org.bimserver.models.ifc2x3tc1.IfcProduct;
import org.bimserver.models.ifc2x3tc1.IfcProductRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcReflectanceMethodEnum;
import org.bimserver.models.ifc2x3tc1.IfcRepresentation;
import org.bimserver.models.ifc2x3tc1.IfcRepresentationItem;
import org.bimserver.models.ifc2x3tc1.IfcSpecularExponent;
import org.bimserver.models.ifc2x3tc1.IfcSpecularHighlightSelect;
import org.bimserver.models.ifc2x3tc1.IfcSpecularRoughness;
import org.bimserver.models.ifc2x3tc1.IfcStyledItem;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceSide;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyle;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleElementSelect;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleLighting;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRefraction;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleRendering;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleShading;
import org.bimserver.models.ifc2x3tc1.IfcSurfaceStyleWithTextures;

public class ColladaMaterial {
	String name = "material";
	List<ColladaProfile> profiles = new ArrayList<ColladaProfile> ();
	
	public ColladaMaterial(String name) {
		this.name = name;
		// Add common profile.
		profiles.add(new ColladaProfile("COMMON"));
	}

	public ColladaMaterial(String name, List<ColladaProfile> profiles) {
		super();
		//
		this.name = name;
		this.profiles = profiles;
	}

	public ColladaProfile getProfile(String profileName)
	{
		for (ColladaProfile thisProfile : profiles)
			if (thisProfile.name.equalsIgnoreCase(profileName))
				return thisProfile;
		// Not found.
		return null;
	}

	public String getEffectString() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("  <effect id=\"%s-fx\">%n", name));
		// Dump the profile.
		for (ColladaProfile profile : profiles)
			builder.append(String.format("%s%n", profile.getString()));
		//
		builder.append(String.format("  </effect>"));
		return builder.toString();
	}

	public static ColladaMaterial getMaterialForIfcProduct(IfcProduct ifcProduct) {
		IfcProductRepresentation representation = ifcProduct.getRepresentation();
		// IfcProduct (ex: IfcWindow, IfcDoor, etc.) is represented by an IfcRepresentation.
		for (IfcRepresentation thisRepresentation : representation.getRepresentations())
		{
			// That IfcRepresentation is made up of individual items (an IfcRepresentationItem, which is one of: IfcTopologicalRepresentationItem, IfcGeometricRepresentationItem, IfcMappedItem, or IfcStyledItem).
			for (IfcRepresentationItem item : thisRepresentation.getItems())
			{
				// IfcTopologicalRepresentationItem is one of: IfcConnectedFaceSet, IfcEdge, IfcFace, IfcFaceBound, IfcPath, IfcVertex, IfcLoop.
				// IfcGeometricRepresentationItem is one of: IfcCompositeCurveSegment, IfcCurve, IfcDirection, IfcPlacement, IfcPoint, IfcSurface, IfcVector, IfcBooleanResult, IfcSolidModel, IfcHalfSpaceSolid, IfcBoundingBox, IfcCartesianTransformationOperator, IfcSectionedSpine, IfcGeometricSet, IfcFaceBasedSurfaceModel, IfcShellBasedSurfaceModel.
				// Each IfcRepresentationItem may have style for presentation (IfcStyledItem which is actually also an IfcRepresentationItem itself).
				for (IfcStyledItem styledItem : item.getStyledByItem())
				{
					// Each IfcStyledItem may have a set of presentation style assignments (IfcPresentationStyleAssignment).
					for(IfcPresentationStyleAssignment assignment : styledItem.getStyles())
					{
						// The presentation style assignment is a set of styles which are assigned to styled items for the purpose of presenting these styled items.
						for (IfcPresentationStyleSelect selection : assignment.getStyles())
						{
							// The presentation style select is a selection of one of many kinds of styles, a different one for each kind of geometric representation item to be styled (re: IfcNullStyle, IfcCurveStyle, IfcSymbolStyle, IfcFillAreaStyle, IfcTextStyle, IfcSurfaceStyle).
							// TODO: Find a way to compare IfcSurfaceStyle materials to save extra space in Collada files. Currently, they are per-product.
							// Only consider surface styles.
							if (selection instanceof IfcSurfaceStyle)
							{
								// An assignment of one or many surface style elements to a surface, defined by subtypes of IfcSurface, IfcFaceBasedSurfaceModel, IfcShellBasedSurfaceModel, or by subtypes of IfcSolidModel. The positive direction of the surface normal relates to the positive side. In case of solids the outside of the solid is to be taken as positive side.
								IfcSurfaceStyle surfaceStyle = (IfcSurfaceStyle) selection;
								IfcSurfaceSide side = surfaceStyle.getSide();
								// Only consider POSITIVE and BOTH, because they follow the normal (and would therefore be visible), and only geometry for the outside-pointing faces gets exported.
								if (side != IfcSurfaceSide.NEGATIVE)
								{
									// Get the renderable surface material from the IfcSurfaceStyle.
									String materialName = String.format("%d", ifcProduct.getOid());
									return getColladaMaterialFromIfcSurfaceStyle(materialName, surfaceStyle);
								}
							}
						}
					}
				}
			}
		}
		// Send back something that's probably a default material name (based on the more specific class of the IfcProduct): IfcRoof, IfcWindow, etc.
		return null;
	}

	public static ColladaMaterial getColladaMaterialFromIfcSurfaceStyle(String materialName, IfcSurfaceStyle surfaceStyle) {
		// At this point, prepare a Collada material to be filled out as information is encountered. The material should be so named: {ifc-product-oid}
		ColladaMaterial material = new ColladaMaterial(materialName);
		// Get the style selections, extracting them for their information.
		for (IfcSurfaceStyleElementSelect elementSelection : surfaceStyle.getStyles())
		{
			if (elementSelection instanceof IfcSurfaceStyleShading)
			{
				if (elementSelection instanceof IfcSurfaceStyleRendering)
				{
					// See: http://www.buildingsmart-tech.org/ifc/IFC2x3/TC1/html/ifcpresentationappearanceresource/lexical/ifcsurfacestylerendering.htm
					IfcSurfaceStyleRendering thisDirective = (IfcSurfaceStyleRendering)elementSelection;
					ColladaProfile profile = material.getProfile("Common");
					profile.ambientColor = ColladaMaterial.getDoubleArrayForIfcColourRgb(thisDirective.getSurfaceColour());
					// 1. Transparency: The degree of transparency is indicated by the percentage of light traversing the surface. 1.0 being completely transparent, and 0.0 completely opaque. If not given, the value 0.0 (opaque) is assumed.
					profile.transparency = thisDirective.getTransparency();
					// 2. DiffuseColour: The diffuse part of the reflectance equation can be given as either a colour or a scalar factor.
					profile.diffuseColor = ColladaMaterial.getDoubleArrayForIfcColourOrFactor(thisDirective.getDiffuseColour());
					// 3. TransmissionColour: The transmissive part of the reflectance equation can be given as either a colour or a scalar factor. It only applies to materials which Transparency field is greater than zero.
					profile.transmissionColor = ColladaMaterial.getDoubleArrayForIfcColourOrFactor(thisDirective.getTransmissionColour());
					// 4. DiffuseTransmissionColour: The diffuse transmission part of the reflectance equation can be given as either a colour or a scalar factor. It only applies to materials whose Transparency field is greater than zero.
					profile.diffuseTransmissionColor = ColladaMaterial.getDoubleArrayForIfcColourOrFactor(thisDirective.getDiffuseTransmissionColour());
					// 5. ReflectionColour: The reflection (or mirror) part of the reflectance equation can be given as either a colour or a scalar factor. Applies to "glass" and "mirror" reflection models.
					profile.reflectionColor = ColladaMaterial.getDoubleArrayForIfcColourOrFactor(thisDirective.getReflectionColour());
					// 6. SpecularColour: The specular part of the reflectance equation can be given as either a colour or a scalar factor.
					profile.specularColor = ColladaMaterial.getDoubleArrayForIfcColourOrFactor(thisDirective.getSpecularColour());
					// 7. SpecularHighlight: The exponent or roughness part of the specular reflectance.
					IfcSpecularHighlightSelect specularSelection = thisDirective.getSpecularHighlight();
					if (specularSelection instanceof IfcSpecularExponent)
						profile.specularHighlight = ((IfcSpecularExponent)specularSelection).getWrappedValue();
					else if (specularSelection instanceof IfcSpecularRoughness)
						profile.specularHighlight = ((IfcSpecularRoughness)specularSelection).getWrappedValue();
					// Material shading mode.
					IfcReflectanceMethodEnum reflectance = thisDirective.getReflectanceMethod();
					// BLINN: A reflectance model providing a smooth, slightly shiny appearance.
					if (reflectance == IfcReflectanceMethodEnum.BLINN)
						profile.mode = "blinn";
					// FLAT: A reflectance model providing a constant colour. This model ignores the effect of all light sources.
					else if (reflectance == IfcReflectanceMethodEnum.FLAT)
						profile.mode = "constant";
					// GLASS: A reflectance model that supports an approximation of glass-like materials that have both reflective and transmissive properties.
					else if (reflectance == IfcReflectanceMethodEnum.GLASS)
						profile.mode = "phong";
					// MATT: A reflectance model providing a dull matte appearance.
					else if (reflectance == IfcReflectanceMethodEnum.MATT)
						profile.mode = "lambert";
					// METAL: A reflectance model providing a specular metallic appearance.
					else if (reflectance == IfcReflectanceMethodEnum.METAL)
						profile.mode = "phong";
					// MIRROR: A reflectance model that supports secondary mirrored views through ray tracing.
					else if (reflectance == IfcReflectanceMethodEnum.MIRROR)
						profile.mode = "phong";
					// PHONG: A reflectance model conforming with the Phong model in which reflections are greatest in the `mirror' direction of a surface opposite the viewing direction with respect to the surface normal.
					else if (reflectance == IfcReflectanceMethodEnum.PHONG)
						profile.mode = "phong";
					// PLASTIC: A reflectance model providing a specular effect which is similar to the Phong model.
					else if (reflectance == IfcReflectanceMethodEnum.PLASTIC)
						profile.mode = "blinn";
					// STRAUSS: A reflectance model for metallic and non-metallic appearance based on a limited set of control parameter.
					else if (reflectance == IfcReflectanceMethodEnum.STRAUSS)
						profile.mode = "blinn";
					// Default to phong.
					else if (reflectance == IfcReflectanceMethodEnum.NOTDEFINED)
						profile.mode = "phong";
				}
				else {
					IfcSurfaceStyleShading thisDirective = (IfcSurfaceStyleShading)elementSelection;
					ColladaProfile profile = material.getProfile("Common");
					profile.diffuseColor = ColladaMaterial.getDoubleArrayForIfcColourRgb(thisDirective.getSurfaceColour());
					profile.mode = "blinn";
				}
			}
			else if (elementSelection instanceof IfcSurfaceStyleLighting)
			{
				IfcSurfaceStyleLighting thisDirective = (IfcSurfaceStyleLighting)elementSelection;
				//
				ColladaProfile profile = material.getProfile("Common");
				// The degree of diffusion of the transmitted light. In the case of completely transparent materials there is no diffusion. The greater the diffusing power, the smaller the direct component of the transmitted light, up to the point where only diffuse light is produced.A value of 1 means totally diffuse for that colour part of the light.
				profile.reflectionColor = ColladaMaterial.getDoubleArrayForIfcColourRgb(thisDirective.getDiffuseReflectionColour());
				// The degree of diffusion of the reflected light. In the case of specular surfaces there is no diffusion. The greater the diffusing power of the reflecting surface, the smaller the specular component of the reflected light, up to the point where only diffuse light is produced. A value of 1 means totally diffuse for that colour part of the light.
				profile.diffuseTransmissionColor = ColladaMaterial.getDoubleArrayForIfcColourRgb(thisDirective.getDiffuseTransmissionColour());
				// A coefficient that determines the extent that the light falling onto a surface is fully or partially reflected. 
				profile.reflectionColor = ColladaMaterial.getDoubleArrayForIfcColourRgb(thisDirective.getReflectanceColour());
				// Describes how the light falling on a body is totally or partially transmitted.
				profile.transmissionColor = ColladaMaterial.getDoubleArrayForIfcColourRgb(thisDirective.getTransmissionColour());
				profile.mode = "blinn";
			}
			else if (elementSelection instanceof IfcSurfaceStyleWithTextures)
			{
				// No IFC files to test this on (and other issues). Ignore it.
				// See (IfcSurfaceStyleWithTextures) - http://www.buildingsmart-tech.org/ifc/IFC2x3/TC1/html/ifcpresentationappearanceresource/lexical/ifcsurfacestylewithtextures.htm
				// See Also (IfcPixelTexture) - http://www.buildingsmart-tech.org/ifc/IFC2x3/TC1/html/ifcpresentationappearanceresource/lexical/ifcpixeltexture.htm
				// See Also (IfcImageTexture) - http://www.buildingsmart-tech.org/ifc/IFC2x3/TC1/html/ifcpresentationappearanceresource/lexical/ifcimagetexture.htm
				// See Also (IfcBlobTexture) - http://www.buildingsmart-tech.org/ifc/IFC2x3/TC1/html/ifcpresentationappearanceresource/lexical/ifcblobtexture.htm
				// Ignored: IfcSurfaceStyleWithTextures -> IfcPixelTexture, IfcSurfaceStyleWithTextures -> IfcImageTexture, IfcSurfaceStyleWithTextures -> IfcBlobTexture.
			}
			else if (elementSelection instanceof IfcExternallyDefinedSurfaceStyle)
			{
				// Ignored.
				// See (IfcExternallyDefinedSurfaceStyle) - http://www.buildingsmart-tech.org/ifc/IFC2x3/TC1/html/ifcpresentationappearanceresource/lexical/ifcexternallydefinedsurfacestyle.htm
			}
			else if (elementSelection instanceof IfcSurfaceStyleRefraction)
			{
				IfcSurfaceStyleRefraction thisDirective = (IfcSurfaceStyleRefraction)elementSelection;
				//
				ColladaProfile profile = material.getProfile("Common");
				profile.indexOfRefraction = thisDirective.getRefractionIndex();
				profile.reflectivity = thisDirective.getDispersionFactor();
				profile.mode = "phong";
			}
		}
		// Send the material back.
		return material;
	}

	private static double[] getDoubleArrayForIfcColourOrFactor(IfcColourOrFactor rgb) {
		if (rgb instanceof IfcColourRgb)
			return getDoubleArrayForIfcColourRgb((IfcColourRgb)rgb);
		else if (rgb instanceof IfcNormalisedRatioMeasure)
			return new double[] {((IfcNormalisedRatioMeasure)rgb).getWrappedValue()};
		return new double[] {};
	}

	private static double[] getDoubleArrayForIfcColourRgb(IfcColourRgb rgb) {
		return new double[] {rgb.getRed(), rgb.getBlue(), rgb.getGreen(), };
	}
}