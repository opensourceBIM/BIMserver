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

Currently, this project provides two charts: __(1)__ _IFC Treemap by Area_ and __(2)__ _IFC Circle Packing Map by Area_. These are the charts mentioned in issue #133, except that the color in these charts is driven by an IfcObject's immediate parent. This is to provide coordinated blocks of color, which may not be visually appealing for low-complexity projects.