if(typeof BIMSURFER.Constants != 'object') {
	BIMSURFER.Constants = {};
}


/**
 * Time in milliseconds before a connect or login action will timeout
 */
BIMSURFER.Constants.timeoutTime = 10000; // ms

/**
 * The default IFC Types to load
 */
BIMSURFER.Constants.defaultTypes = [
	"IfcColumn",
	"IfcStair",
	"IfcSlab",
	"IfcWindow",
//	"IfcOpeningElement",
	"IfcDoor",
	"IfcBuildingElementProxy",
	"IfcWallStandardCase",
	"IfcWall",
	"IfcBeam",
	"IfcRailing",
	"IfcProxy",
	"IfcRoof"
];

//writeMaterial(jsonWriter, "IfcSpace", new double[] { 0.137255f, 0.403922f, 0.870588f }, 1.0f);
//writeMaterial(jsonWriter, "IfcRoof", new double[] { 0.837255f, 0.203922f, 0.270588f }, 1.0f);
//writeMaterial(jsonWriter, "IfcSlab", new double[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f);
//writeMaterial(jsonWriter, "IfcWall", new double[] { 0.537255f, 0.337255f, 0.237255f }, 1.0f);
//writeMaterial(jsonWriter, "IfcWallStandardCase", new double[] { 1.0f, 1.0f, 1.0f }, 1.0f);
//writeMaterial(jsonWriter, "IfcDoor", new double[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f);
//writeMaterial(jsonWriter, "IfcWindow", new double[] { 0.2f, 0.2f, 0.8f }, 0.2f);
//writeMaterial(jsonWriter, "IfcRailing", new double[] { 0.137255f, 0.203922f, 0.270588f }, 1.0f);
//writeMaterial(jsonWriter, "IfcColumn", new double[] { 0.437255f, 0.603922f, 0.370588f, }, 1.0f);
//writeMaterial(jsonWriter, "IfcBeam", new double[] { 0.437255f, 0.603922f, 0.370588f, }, 1.0f);
//writeMaterial(jsonWriter, "IfcFurnishingElement", new double[] { 0.437255f, 0.603922f, 0.370588f }, 1.0f);
//writeMaterial(jsonWriter, "IfcCurtainWall", new double[] { 0.5f, 0.5f, 0.5f }, 0.5f);
//writeMaterial(jsonWriter, "IfcStair", new double[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f);
//writeMaterial(jsonWriter, "IfcBuildingElementProxy", new double[] { 0.5f, 0.5f, 0.5f }, 1.0f);
//writeMaterial(jsonWriter, "IfcFlowSegment", new double[] { 0.8470588235f, 0.427450980392f, 0f }, 1.0f);
//writeMaterial(jsonWriter, "IfcFlowFitting", new double[] { 0.8470588235f, 0.427450980392f, 0f }, 1.0f);
//writeMaterial(jsonWriter, "IfcFlowTerminal", new double[] { 0.8470588235f, 0.427450980392f, 0f }, 1.0f);
//writeMaterial(jsonWriter, "IfcProxy", new double[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f);
//writeMaterial(jsonWriter, "IfcSite", new double[] { 0.637255f, 0.603922f, 0.670588f }, 1.0f);
//writeMaterial(jsonWriter, "IfcLightFixture", new double[] {0.8470588235f, 0.8470588235f, 0f }, 1.0f);
//writeMaterial(jsonWriter, "IfcDuctSegment", new double[] {0.8470588235f, 0.427450980392f, 0f }, 1.0f);
//writeMaterial(jsonWriter, "IfcDuctFitting", new double[] {0.8470588235f, 0.427450980392f, 0f }, 1.0f);
//writeMaterial(jsonWriter, "IfcAirTerminal", new double[] {0.8470588235f, 0.427450980392f, 0f }, 1.0f);

BIMSURFER.Constants.materials = {
	IfcSpace: {r: 0.137255, g: 0.403922, b: 0.870588, a: 1.0},
	IfcRoof: {r: 0.837255, g: 0.203922, b: 0.270588, a: 1.0},
	IfcSlab: {r: 0.637255, g: 0.603922, b: 0.670588, a: 1.0},
	IfcWall: {r: 0.537255, g: 0.337255, b: 0.237255, a: 1.0},
	IfcWallStandardCase: {r: 0.537255, g: 0.337255, b: 0.237255, a: 1.0},
	IfcDoor: {r: 0.637255, g: 0.603922, b: 0.670588, a: 1.0},
	IfcWindow: {r: 0.137255, g: 0.403922, b: 0.870588, a: 0.5},
	IfcOpeningElement: {r: 0.137255, g: 0.403922, b: 0.870588, a: 0},
	IfcRailing: {r: 0.137255, g: 0.403922, b: 0.870588, a: 1.0},
	IfcColumn: {r: 0.137255, g: 0.403922, b: 0.870588, a: 1.0},
	IfcBeam: {r: 0.137255, g: 0.403922, b: 0.870588, a: 1.0},
	IfcFurnishingElement: {r: 0.137255, g: 0.403922, b: 0.870588, a: 1.0},
	IfcCurtainWall: {r: 0.137255, g: 0.403922, b: 0.870588, a: 1.0},
	IfcStair: {r: 0.637255, g: 0.603922, b: 0.670588, a: 1.0},
	IfcStairFlight: {r: 0.637255, g: 0.603922, b: 0.670588, a: 1.0},
	IfcBuildingElementProxy: {r: 0.5, g: 0.5, b: 0.5, a: 1.0},
	IfcFlowSegment: {r: 0.137255, g: 0.403922, b: 0.870588, a: 1.0},
	IfcFlowitting: {r: 0.137255, g: 0.403922, b: 0.870588, a: 1.0},
	IfcFlowTerminal: {r: 0.137255, g: 0.403922, b: 0.870588, a: 1.0},
	IfcProxy: {r: 0.137255, g: 0.403922, b: 0.870588, a: 1.0},
	IfcSite: {r: 0.137255, g: 0.403922, b: 0.870588, a: 1.0},
	IfcLightFixture: {r: 0.8470588235, g: 0.8470588235, b: 0.870588, a: 1.0},
	IfcDuctSegment: {r: 0.8470588235, g: 0.427450980392, b: 0, a: 1.0},
	IfcDistributionFlowElement: {r: 0.8470588235, g: 0.427450980392, b: 0, a: 1.0},
	IfcDuctFitting: {r: 0.8470588235, g: 0.427450980392, b: 0, a: 1.0},
	IfcPlate: {r: 0.8470588235, g: 0.427450980392, b: 0, a: 0.5},
	IfcAirTerminal: {r: 0.8470588235, g: 0.427450980392, b: 0, a: 1.0},
	IfcMember: {r: 0.8470588235, g: 0.427450980392, b: 0, a: 1.0},
	IfcCovering: {r: 0.8470588235, g: 0.427450980392, b: 0, a: 1.0},
	IfcTransportElement: {r: 0.8470588235, g: 0.427450980392, b: 0, a: 1.0},
	IfcFlowController: {r: 0.8470588235, g: 0.427450980392, b: 0, a: 1.0},
	IfcFlowFitting: {r: 0.8470588235, g: 0.427450980392, b: 0, a: 1.0},
	IfcRamp: {r: 0.8470588235, g: 0.427450980392, b: 0, a: 1.0},
	IfcFurniture: {r: 0.8470588235, g: 0.427450980392, b: 0, a: 1.0},
	IfcFooting: {r: 0.8470588235, g: 0.427450980392, b: 0, a: 1.0},
	IfcSystemFurnitureElement: {r: 0.8470588235, g: 0.427450980392, b: 0, a: 1.0},
	DEFAULT: {r: 0.8470588235, g: 0.427450980392, b: 0, a: 1.0}
}

/*
 * Default camera settings
 */
BIMSURFER.Constants.camera = {
	maxOrbitSpeed : Math.PI * 0.1,
	orbitSpeedFactor : 0.05,
	zoomSpeedFactor : 0.1,
	panSpeedFactor : 0.6
};

/*
 * Default markup for highlighted objects
 */
BIMSURFER.Constants.highlightSelectedObject = {
	type : 'material',
	id : 'highlight',
	emit : 0.0,
	baseColor : {r: 0.0, g: 1, b: 0}
}

/*
 * Default markup for highlighted special objects
 */
BIMSURFER.Constants.highlightSelectedSpecialObject = {
	type : 'material',
	id : 'specialselectedhighlight',
	emit : 1,
	baseColor : {r: 0.16,g: 0.70,b: 0.88},
	shine : 10.0
};

/*
 * Enumeration for progressbar types
 */
BIMSURFER.Constants.ProgressBarStyle = {
	Continuous: 1,
	Marquee: 2
}



/**
 * Returns a number whose value is limited to the given range.
 *
 * Example: limit the output of this computation to between 0 and 255
 * (x * 255).clamp(0, 255)
 *
 * @param {Number} s The number to clamp
 * @param {Number} min The lower boundary of the output range
 * @param {Number} max The upper boundary of the output range
 * @returns A number in the range [min, max]
 * @type Number
 */
BIMSURFER.Constants.clamp = function(s, min, max) {
	return Math.min(Math.max(s, min), max);
};