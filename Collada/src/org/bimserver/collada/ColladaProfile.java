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

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

// Mostly, something to capture IfcSurfaceStyleRendering.
class ColladaProfile {
	String name = "COMMON";
	// Inherited attribute SurfaceColour on IfcSurfaceStyleRendering.
	double[] ambientColor = new double[] {0, 0, 0, 1.0, };
	// Transparency on IfcSurfaceStyleRendering; 0 = opaque; 1 = see-through; complement is tacked onto diffuse color.
	double transparency = 0;
	// Not an IFC setting. Color of perfectly refracted light. Default is pass-through for RGB_ZERO.
	double[] transparent = new double[] {1, 1, 1, 1, };
	// DiffuseColour on IfcSurfaceStyleRendering.
	double[] diffuseColor = new double[] {1.0, 1.0, 1.0, };
	// TransmissionColour on IfcSurfaceStyleRendering. Only valid when transparency > 0.
	double[] transmissionColor = new double[] {0, 0, 0, 1.0, };
	// DiffuseTransmissionColour on IfcSurfaceStyleRendering.
	double[] diffuseTransmissionColor = new double[] {1.0, };
	// ReflectionColour on IfcSurfaceStyleRendering. Color of perfect reflection.
	double[] reflectionColor = new double[] {1.0, 1.0, 1.0, };
	// SpecularColour on IfcSurfaceStyleRendering.
	double[] specularColor = new double[] {0.5, 0.5, 0.5, 1, };
	// SpecularHighlight on IfcSurfaceStyleRendering.
	double specularHighlight = 50;
	// DispersionFactor on IfcSurfaceStyleRefraction.
	double reflectivity = 0.10;
	// RefractionIndex on IfcSurfaceStyleRefraction.
	double indexOfRefraction = 0;
	// ReflectanceMethod on IfcSurfaceStyleRendering.
	// Incoming options: BLINN, FLAT, GLASS, MATT, METAL, MIRROR, PHONG, PLASTIC, STRAUSS
	// Options in Collada: constant, lambert, blinn, phong.
	// constant: color = emission + (ambient * ambient light from scene)
	// lambert: color = emission + (ambient * ambient light from scene) + diffuse * max(dot(Normal Vector, Light Vector), 0)
	// blinn: color = emission + (ambient * ambient light from scene) + diffuse * max(dot(Normal Vector, Light Vector), 0) + specular * max(dot(Half-Angle Vector, Eye Vector), 0) ^ shininess exponent
	// phong: color = emission + (ambient * ambient light from scene) + diffuse * max(dot(Normal Vector, Light Vector), 0) + specular * max(dot(Perfect Reflection Vector, Eye Vector), 0) ^ shininess exponent 
	String mode = "phong";
	//
	List<SimpleEntry<String, String>> renderStates = new ArrayList<SimpleEntry<String,String>>();

	public ColladaProfile() {
		// Common.
	}

	public ColladaProfile(String name) {
		super();
		//
		this.name = name;
	}

	public ColladaProfile(String name, double transparency, double[] diffuseColor, double[] transmissionColor, double[] diffuseTransmissionColor, double[] reflectionColor, double[] specularColor, double specularHighlight, String mode) {
		super();
		//
		this.name = name;
		this.transparency = transparency;
		this.diffuseColor = diffuseColor;
		this.transmissionColor = transmissionColor;
		this.diffuseTransmissionColor = diffuseTransmissionColor;
		this.reflectionColor = reflectionColor;
		this.specularColor = specularColor;
		this.specularHighlight = specularHighlight;
		this.mode = mode;
	}

	private String getStringFor(double[] values)
	{
		List<String> list = new ArrayList<String>();
		for (double value : values)
			list.add(String.format("%f", value));
		return StringUtils.join(list, " ");
	}

	public String getString()
	{
		StringBuilder builder = new StringBuilder();
		// Start the effect profile.
		builder.append(String.format("   <profile_%s>%n", name));
		builder.append(String.format("    <technique sid=\"%s\">%n", name.toLowerCase(Locale.ENGLISH)));
		builder.append(String.format("     <%s>%n", mode));
		// Only print the applicable components to the Collada format.
		if (mode.equalsIgnoreCase("constant"))
			addConstantComponentsString(builder);
		else if (mode.equalsIgnoreCase("lambert"))
			addLambertComponentsString(builder);
		else if (mode.equalsIgnoreCase("blinn"))
			addBlinnComponentsString(builder);
		else if (mode.equalsIgnoreCase("phong"))
			addPhongComponentsString(builder);
		//
		builder.append(String.format("     </%s>%n", mode));
		builder.append(String.format("    </technique>%n"));
		if (renderStates.size() > 0)
			addPassString(builder);
		builder.append(String.format("   </profile_%s>", name));
		// Send it back.
		return builder.toString();
	}

	private void addConstantComponentsString(StringBuilder builder) {
		addEmissionString(builder);
		addReflectiveString(builder);
		addReflectivityString(builder);
		addTransparentString(builder);
		addTransparencyString(builder);
		addIndexOfRefractionString(builder);
	}

	private void addLambertComponentsString(StringBuilder builder) {
		addEmissionString(builder);
		addAmbientString(builder);
		addDiffuseString(builder);
		addReflectiveString(builder);
		addReflectivityString(builder);
		addTransparentString(builder);
		addTransparencyString(builder);
		addIndexOfRefractionString(builder);
	}

	private void addBlinnComponentsString(StringBuilder builder) {
		addEmissionString(builder);
		addAmbientString(builder);
		addDiffuseString(builder);
		addSpecularString(builder);
		addShininessString(builder);
		addReflectiveString(builder);
		addReflectivityString(builder);
		addTransparentString(builder);
		addTransparencyString(builder);
		addIndexOfRefractionString(builder);
	}

	private void addPhongComponentsString(StringBuilder builder) {
		addEmissionString(builder);
		addAmbientString(builder);
		addDiffuseString(builder);
		addSpecularString(builder);
		addShininessString(builder);
		addReflectiveString(builder);
		addReflectivityString(builder);
		addTransparentString(builder);
		addTransparencyString(builder);
		addIndexOfRefractionString(builder);
	}

	private void addIndexOfRefractionString(StringBuilder builder) {
		builder.append(String.format("      <index_of_refraction>%n"));
		builder.append(String.format("       <color>%f</color>%n", indexOfRefraction));
		builder.append(String.format("      </index_of_refraction>%n"));
	}

	private void addReflectivityString(StringBuilder builder) {
		builder.append(String.format("      <reflectivity>%n"));
		builder.append(String.format("       <float>%f</float>%n", reflectivity));
		builder.append(String.format("      </reflectivity>%n"));
	}

	private void addReflectiveString(StringBuilder builder) {
		builder.append(String.format("      <reflective>%n"));
		if (reflectionColor.length == 1)
			builder.append(String.format("       <float>%f</float>%n", reflectionColor[0]));
		else
			builder.append(String.format("       <color>%s</color>%n", getStringFor(reflectionColor)));
		builder.append(String.format("      </reflective>%n"));
	}

	private void addShininessString(StringBuilder builder) {
		builder.append(String.format("      <shininess>%n"));
		builder.append(String.format("       <float>%f</float>%n", specularHighlight));
		builder.append(String.format("      </shininess>%n"));
	}

	private void addSpecularString(StringBuilder builder) {
		builder.append(String.format("      <specular>%n"));
		builder.append(String.format("       <color>%s</color>%n", getStringFor(specularColor)));
		builder.append(String.format("      </specular>%n"));
	}

	private void addDiffuseString(StringBuilder builder) {
		builder.append(String.format("      <diffuse>%n"));
		builder.append(String.format("       <color>%s %f</color>%n", getStringFor(diffuseColor), (1 - transparency)));
		builder.append(String.format("      </diffuse>%n"));
	}

	private void addAmbientString(StringBuilder builder) {
		builder.append(String.format("      <ambient>%n"));
		builder.append(String.format("       <color>%s</color>%n", getStringFor(ambientColor)));
		builder.append(String.format("      </ambient>%n"));
	}

	private void addEmissionString(StringBuilder builder) {
		builder.append(String.format("      <emission>%n"));
		builder.append(String.format("       <color>%s</color>%n", getStringFor(transmissionColor)));
		builder.append(String.format("      </emission>%n"));
	}

	private void addTransparentString(StringBuilder builder) {
		// A_ONE (the default): Takes the transparency information from the color's	alpha channel, where the value 1.0 is opaque.
		// RGB_ZERO: Takes the transparency information from the color's red, green, and blue channels, where the value 0.0	is opaque, with each channel modulated independently.
		builder.append(String.format("      <transparent opaque=\"RGB_ZERO\">%n"));
		builder.append(String.format("       <color>%s</color>%n", getStringFor(transparent)));
		builder.append(String.format("      </transparent>%n"));
	}

	private void addTransparencyString(StringBuilder builder) {
		builder.append(String.format("      <transparency>%n"));
		builder.append(String.format("       <float>%f</float>%n", transparency));
		builder.append(String.format("      </transparency>%n"));
	}

	private void addPassString(StringBuilder builder) {
		builder.append(String.format("    <pass>%n"));
		for (SimpleEntry<String, String> entry : renderStates)
			builder.append(String.format("     <render_state param=\"%s\" value=\"%s\"/>%n", entry.getKey(), entry.getValue()));
		builder.append(String.format("    </pass>%n"));
	}
}