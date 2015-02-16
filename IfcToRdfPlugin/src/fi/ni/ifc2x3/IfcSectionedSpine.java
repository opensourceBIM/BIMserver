package fi.ni.ifc2x3;
import java.util.List;

import fi.ni.IfcList;

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

public class IfcSectionedSpine extends IfcGeometricRepresentationItem 
{
 // The property attributes
 IfcCompositeCurve   spineCurve;
 List<IfcProfileDef> crossSections = new IfcList<IfcProfileDef>();
 List<IfcAxis2Placement3D> crossSectionPositions = new IfcList<IfcAxis2Placement3D>();


 // Getters and setters of properties

 public IfcCompositeCurve getSpineCurve() {
   return spineCurve;

 }
 public void setSpineCurve(IfcCompositeCurve value){
   this.spineCurve=value;

 }

 public List<IfcProfileDef> getCrossSections() {
   return crossSections;

 }
 public void setCrossSections(IfcProfileDef value){
   this.crossSections.add(value);

 }

 public List<IfcAxis2Placement3D> getCrossSectionPositions() {
   return crossSectionPositions;

 }
 public void setCrossSectionPositions(IfcAxis2Placement3D value){
   this.crossSectionPositions.add(value);

 }

}
