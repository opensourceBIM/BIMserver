package fi.ni.ifc2x3;
import fi.ni.Thing;
import fi.ni.ifc2x3.interfaces.IfcSurfaceStyleElementSelect;

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

public class IfcSurfaceStyleLighting extends Thing implements IfcSurfaceStyleElementSelect
{
 // The property attributes
 IfcColourRgb   diffuseTransmissionColour;
 IfcColourRgb   diffuseReflectionColour;
 IfcColourRgb   transmissionColour;
 IfcColourRgb   reflectanceColour;


 // Getters and setters of properties

 public IfcColourRgb getDiffuseTransmissionColour() {
   return diffuseTransmissionColour;

 }
 public void setDiffuseTransmissionColour(IfcColourRgb value){
   this.diffuseTransmissionColour=value;

 }

 public IfcColourRgb getDiffuseReflectionColour() {
   return diffuseReflectionColour;

 }
 public void setDiffuseReflectionColour(IfcColourRgb value){
   this.diffuseReflectionColour=value;

 }

 public IfcColourRgb getTransmissionColour() {
   return transmissionColour;

 }
 public void setTransmissionColour(IfcColourRgb value){
   this.transmissionColour=value;

 }

 public IfcColourRgb getReflectanceColour() {
   return reflectanceColour;

 }
 public void setReflectanceColour(IfcColourRgb value){
   this.reflectanceColour=value;

 }

}
