package fi.ni.ifc2x3;
import fi.ni.InverseLinksList;
import fi.ni.Thing;
import fi.ni.ifc2x3.interfaces.IfcMaterialSelect;
import fi.ni.ifc2x3.interfaces.IfcObjectReferenceSelect;

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

public class IfcMaterialLayer extends Thing implements IfcMaterialSelect, IfcObjectReferenceSelect
{
 // The property attributes
 IfcMaterial   material;
 Double layerThickness;
 String isVentilated;
 // The inverse attributes

 InverseLinksList<IfcMaterialLayerSet> toMaterialLayerSet= new InverseLinksList<IfcMaterialLayerSet>();


 // Getters and setters of properties

 public IfcMaterial getMaterial() {
   return material;

 }
 public void setMaterial(IfcMaterial value){
   this.material=value;

 }

 public Double getLayerThickness() {
   return layerThickness;
 }
 public void setLayerThickness(String txt){
   Double value = i.toDouble(txt);
   this.layerThickness=value;

 }

 public String getIsVentilated() {
   return isVentilated;
 }
 public void setIsVentilated(String value){
   this.isVentilated=value;

 }

 // Getters and setters of inverse values

 public InverseLinksList<IfcMaterialLayerSet> getToMaterialLayerSet() {
   return toMaterialLayerSet;

 }
 public void setToMaterialLayerSet(IfcMaterialLayerSet value){
   this.toMaterialLayerSet.add(value);

 }

}
