package fi.ni.ifc2x3;
import fi.ni.ifc2x3.interfaces.*;
import fi.ni.*;
import java.util.*;

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

public class IfcCraneRailAShapeProfileDef extends IfcParameterizedProfileDef 
{
 // The property attributes
 Double overallHeight;
 Double baseWidth2;
 Double radius;
 Double headWidth;
 Double headDepth2;
 Double headDepth3;
 Double webThickness;
 Double baseWidth4;
 Double baseDepth1;
 Double baseDepth2;
 Double baseDepth3;
 Double centreOfGravityInY;


 // Getters and setters of properties

 public Double getOverallHeight() {
   return overallHeight;
 }
 public void setOverallHeight(String txt){
   Double value = i.toDouble(txt);
   this.overallHeight=value;

 }

 public Double getBaseWidth2() {
   return baseWidth2;
 }
 public void setBaseWidth2(String txt){
   Double value = i.toDouble(txt);
   this.baseWidth2=value;

 }

 public Double getRadius() {
   return radius;
 }
 public void setRadius(String txt){
   Double value = i.toDouble(txt);
   this.radius=value;

 }

 public Double getHeadWidth() {
   return headWidth;
 }
 public void setHeadWidth(String txt){
   Double value = i.toDouble(txt);
   this.headWidth=value;

 }

 public Double getHeadDepth2() {
   return headDepth2;
 }
 public void setHeadDepth2(String txt){
   Double value = i.toDouble(txt);
   this.headDepth2=value;

 }

 public Double getHeadDepth3() {
   return headDepth3;
 }
 public void setHeadDepth3(String txt){
   Double value = i.toDouble(txt);
   this.headDepth3=value;

 }

 public Double getWebThickness() {
   return webThickness;
 }
 public void setWebThickness(String txt){
   Double value = i.toDouble(txt);
   this.webThickness=value;

 }

 public Double getBaseWidth4() {
   return baseWidth4;
 }
 public void setBaseWidth4(String txt){
   Double value = i.toDouble(txt);
   this.baseWidth4=value;

 }

 public Double getBaseDepth1() {
   return baseDepth1;
 }
 public void setBaseDepth1(String txt){
   Double value = i.toDouble(txt);
   this.baseDepth1=value;

 }

 public Double getBaseDepth2() {
   return baseDepth2;
 }
 public void setBaseDepth2(String txt){
   Double value = i.toDouble(txt);
   this.baseDepth2=value;

 }

 public Double getBaseDepth3() {
   return baseDepth3;
 }
 public void setBaseDepth3(String txt){
   Double value = i.toDouble(txt);
   this.baseDepth3=value;

 }

 public Double getCentreOfGravityInY() {
   return centreOfGravityInY;
 }
 public void setCentreOfGravityInY(String txt){
   Double value = i.toDouble(txt);
   this.centreOfGravityInY=value;

 }

}
