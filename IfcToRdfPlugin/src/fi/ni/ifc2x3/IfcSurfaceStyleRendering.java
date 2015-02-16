package fi.ni.ifc2x3;
import fi.ni.ifc2x3.interfaces.IfcColourOrFactor;

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

public class IfcSurfaceStyleRendering extends IfcSurfaceStyleShading 
{
 // The property attributes
 Double transparency;
IfcColourOrFactor diffuseColour;
IfcColourOrFactor transmissionColour;
IfcColourOrFactor diffuseTransmissionColour;
IfcColourOrFactor reflectionColour;
IfcColourOrFactor specularColour;
 String specularHighlight;
 String reflectanceMethod;


 // Getters and setters of properties

 public Double getTransparency() {
   return transparency;
 }
 public void setTransparency(String txt){
   Double value = i.toDouble(txt);
   this.transparency=value;

 }

 public IfcColourOrFactor getDiffuseColour() {
   return diffuseColour;
 }
 public void setDiffuseColour(IfcColourOrFactor value){
   this.diffuseColour=value;

 }

 public IfcColourOrFactor getTransmissionColour() {
   return transmissionColour;
 }
 public void setTransmissionColour(IfcColourOrFactor value){
   this.transmissionColour=value;

 }

 public IfcColourOrFactor getDiffuseTransmissionColour() {
   return diffuseTransmissionColour;
 }
 public void setDiffuseTransmissionColour(IfcColourOrFactor value){
   this.diffuseTransmissionColour=value;

 }

 public IfcColourOrFactor getReflectionColour() {
   return reflectionColour;
 }
 public void setReflectionColour(IfcColourOrFactor value){
   this.reflectionColour=value;

 }

 public IfcColourOrFactor getSpecularColour() {
   return specularColour;
 }
 public void setSpecularColour(IfcColourOrFactor value){
   this.specularColour=value;

 }

 public String getSpecularHighlight() {
   return specularHighlight;
 }
 public void setSpecularHighlight(String value){
   this.specularHighlight=value;

 }

 public String getReflectanceMethod() {
   return reflectanceMethod;
 }
 public void setReflectanceMethod(String value){
   this.reflectanceMethod=value;

 }

}
