# Chart Serializers

## Overview

This project contains serializers for various types of charts, yielding Scalable Vector Graphics (SVG) images.

### Background

This project is designed to provide a server-side, feature-for-feature alternative to __RAW__ by DensityDesign Lab: http://app.raw.densitydesign.org/

__RAW__ is a frontend for the __D3.js__ visualization library (henceforth referred to as __D3__): http://d3js.org/

Because __RAW__ is a client-only AngularJS application, this counterpart re-implements parts of both __D3__ and __RAW__. Like __RAW__, this project opts to defer to third-party implementations where possible. Where such options were not available, features of __D3__ were ported to Java. The third-party libraries are: __(1)__ Prefuse, __(2)__ JTS Topology Suite, and the __(3)__ support code for the _Stacked Graphs - Geometry & Aesthetics_ paper.

__Prefuse__ is a visualization application licensed under the Berkeley Standard Distribution (BSD) license. It is used to provide the layouts required by charts based on trees (ex. _Treemap_, _Treeview_, _et al_). Parts of this software have been altered to better match the output produced by __RAW__.

__JTS Topology Suite__ is a math-focused library licensed under the GNU Lesser Public License (LGPL). It is used to provide a complex, reliable implementation for 2D triangulation in the _Delaunay_ and _Convex Hull_ charts.

The support code for the _Stacked Graphs - Geometry & Aesthetics_ paper is licensed under the Berkeley Standard Distribution (BSD) license. It was adapted to match the features provided by __D3's__ adaptation of the same code.

### Chart Plugins for Use with BIMServer

Currently, this project provides plugins mostly for tree model type charts, which offer a graphical display similar to how projects are displayed in BIMvie.ws.

#### IFC Treeview

![Treeview](./readme%20images/Treeview.png?raw=true)

IFC objects are displayed from left to right, ending in IFC objects that do not contain other IFC objects.

#### IFC Depth-Clustered Treeview

![Depth-Clustered Treeview](./readme%20images/Depth-Clustered%20Treeview.png?raw=true)

IFC objects are displayed from left to right, ending in IFC objects that do not contain other IFC objects. However, jagged data is right-aligned so that all non-container IFC objects are lined up along the right-hand side of the chart.

#### IFC Treemap by Area

![Treemap](./readme%20images/Treemap.png?raw=true)

IFC objects are grouped. Groups are compared against each other by total area. IFC objects in a group are laid out as rectangles by area against other objects in that group.

#### IFC Radial Dendrogram

![Radial Dendrogram](./readme%20images/Radial%20Dendrogram.png?raw=true)

IFC objects are displayed from the center out towards the edges of the chart in a circular fashion.

#### IFC Circle Packing Map by Area

![Circle Packing](./readme%20images/Circle%20Packing.png?raw=true)

IFC objects are grouped. Groups are compared against each other by total area. IFC objects in a group are laid out as circles by area against other objects in that group.

#### IFC Cluster Force

![Cluster Force](./readme%20images/Cluster%20Force.png?raw=true)

IFC objects are placed in an aggregate group. IFC objects are laid out as circles by area against all other objects. This chart is meant to be made interactive through the use of the __D3__ library, which requires the SVG to exist in an appropriate web context.

#### IFC Class Packing

![Class Packing](./readme%20images/Class%20Packing.png?raw=true)

IFC objects are counted by which class they belong to. Counts are compared against each other.

#### IFC Classification Packing

![Classification Packing](./readme%20images/Classification%20Packing.png?raw=true)

IFC objects which reference classifications contribute to counts of those classifications. Counts are compared against each other.

#### IFC Material Usage

![Material Usage](./readme%20images/Material%20Usage.png?raw=true)

IFC material-like objects (IfcMaterialSelect) are related to a running summation of the volume of the IFC objects they're assigned to. The volumes exist on the same scale.

#### IFC Material Usage, Own Scale

![Material Usage](./readme%20images/Material%20Usage,%20Own%20Scale.png?raw=true)

IFC material-like objects (IfcMaterialSelect) are related to a running summation of the volume of the IFC objects they're assigned to. The volumes exist on their own scale.

#### IFC Raw Material Usage

![Raw Material Usage](./readme%20images/Raw%20Material%20Usage.png?raw=true)

Individual IFC material objects are related to a running summation of the volume of the IFC objects they're assigned to. The volumes exist on the same scale.

#### IFC Level of Detail Metrics

![Level of Detail Metrics](./readme%20images/Level%20of%20Detail%20Metrics.png?raw=true)

IFC data is inspected to yield data relating to how many objects and triangles exist per cubic meter in a given project.
