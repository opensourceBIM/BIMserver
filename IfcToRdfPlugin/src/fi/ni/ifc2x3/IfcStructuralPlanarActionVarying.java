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

public class IfcStructuralPlanarActionVarying extends IfcStructuralPlanarAction 
{
 // The property attributes
 IfcShapeAspect   varyingAppliedLoadLocation;
 List<IfcStructuralLoad> subsequentAppliedLoads = new IfcList<IfcStructuralLoad>();


 // Getters and setters of properties

 public IfcShapeAspect getVaryingAppliedLoadLocation() {
   return varyingAppliedLoadLocation;

 }
 public void setVaryingAppliedLoadLocation(IfcShapeAspect value){
   this.varyingAppliedLoadLocation=value;

 }

 public List<IfcStructuralLoad> getSubsequentAppliedLoads() {
   return subsequentAppliedLoads;

 }
 public void setSubsequentAppliedLoads(IfcStructuralLoad value){
   this.subsequentAppliedLoads.add(value);

 }

}
