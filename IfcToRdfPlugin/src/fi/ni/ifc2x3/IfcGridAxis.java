package fi.ni.ifc2x3;
import fi.ni.InverseLinksList;
import fi.ni.Thing;

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

public class IfcGridAxis extends Thing 
{
 // The property attributes
 String axisTag;
 IfcCurve   axisCurve;
 String sameSense;
 // The inverse attributes

 InverseLinksList<IfcGrid> partOfW= new InverseLinksList<IfcGrid>();
 InverseLinksList<IfcGrid> partOfV= new InverseLinksList<IfcGrid>();
 InverseLinksList<IfcGrid> partOfU= new InverseLinksList<IfcGrid>();
 InverseLinksList<IfcVirtualGridIntersection> hasIntersections= new InverseLinksList<IfcVirtualGridIntersection>();


 // Getters and setters of properties

 public String getAxisTag() {
   return axisTag;
 }
 public void setAxisTag(String value){
   this.axisTag=value;

 }

 public IfcCurve getAxisCurve() {
   return axisCurve;

 }
 public void setAxisCurve(IfcCurve value){
   this.axisCurve=value;

 }

 public String getSameSense() {
   return sameSense;
 }
 public void setSameSense(String value){
   this.sameSense=value;

 }

 // Getters and setters of inverse values

 public InverseLinksList<IfcGrid> getPartOfW() {
   return partOfW;

 }
 public void setPartOfW(IfcGrid value){
   this.partOfW.add(value);

 }

 public InverseLinksList<IfcGrid> getPartOfV() {
   return partOfV;

 }
 public void setPartOfV(IfcGrid value){
   this.partOfV.add(value);

 }

 public InverseLinksList<IfcGrid> getPartOfU() {
   return partOfU;

 }
 public void setPartOfU(IfcGrid value){
   this.partOfU.add(value);

 }

 public InverseLinksList<IfcVirtualGridIntersection> getHasIntersections() {
   return hasIntersections;

 }
 public void setHasIntersections(IfcVirtualGridIntersection value){
   this.hasIntersections.add(value);

 }

}
