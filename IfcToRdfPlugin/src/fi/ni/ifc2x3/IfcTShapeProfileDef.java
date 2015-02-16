package fi.ni.ifc2x3;

/*
 * IFC Java class
The MIT License (MIT)

Copyright (c) 2014 Jyrki Oraskari

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

public class IfcTShapeProfileDef extends IfcParameterizedProfileDef 
{
 // The property attributes
 Double depth;
 Double flangeWidth;
 Double webThickness;
 Double flangeThickness;
 Double filletRadius;
 Double flangeEdgeRadius;
 Double webEdgeRadius;
 Double webSlope;
 Double flangeSlope;
 Double centreOfGravityInY;


 // Getters and setters of properties

 public Double getDepth() {
   return depth;
 }
 public void setDepth(String txt){
   Double value = i.toDouble(txt);
   this.depth=value;

 }

 public Double getFlangeWidth() {
   return flangeWidth;
 }
 public void setFlangeWidth(String txt){
   Double value = i.toDouble(txt);
   this.flangeWidth=value;

 }

 public Double getWebThickness() {
   return webThickness;
 }
 public void setWebThickness(String txt){
   Double value = i.toDouble(txt);
   this.webThickness=value;

 }

 public Double getFlangeThickness() {
   return flangeThickness;
 }
 public void setFlangeThickness(String txt){
   Double value = i.toDouble(txt);
   this.flangeThickness=value;

 }

 public Double getFilletRadius() {
   return filletRadius;
 }
 public void setFilletRadius(String txt){
   Double value = i.toDouble(txt);
   this.filletRadius=value;

 }

 public Double getFlangeEdgeRadius() {
   return flangeEdgeRadius;
 }
 public void setFlangeEdgeRadius(String txt){
   Double value = i.toDouble(txt);
   this.flangeEdgeRadius=value;

 }

 public Double getWebEdgeRadius() {
   return webEdgeRadius;
 }
 public void setWebEdgeRadius(String txt){
   Double value = i.toDouble(txt);
   this.webEdgeRadius=value;

 }

 public Double getWebSlope() {
   return webSlope;
 }
 public void setWebSlope(String txt){
   Double value = i.toDouble(txt);
   this.webSlope=value;

 }

 public Double getFlangeSlope() {
   return flangeSlope;
 }
 public void setFlangeSlope(String txt){
   Double value = i.toDouble(txt);
   this.flangeSlope=value;

 }

 public Double getCentreOfGravityInY() {
   return centreOfGravityInY;
 }
 public void setCentreOfGravityInY(String txt){
   Double value = i.toDouble(txt);
   this.centreOfGravityInY=value;

 }

}
