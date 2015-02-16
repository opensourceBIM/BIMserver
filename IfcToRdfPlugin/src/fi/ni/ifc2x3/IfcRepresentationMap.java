package fi.ni.ifc2x3;
import fi.ni.InverseLinksList;
import fi.ni.Thing;
import fi.ni.ifc2x3.interfaces.IfcAxis2Placement;

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

public class IfcRepresentationMap extends Thing 
{
 // The property attributes
IfcAxis2Placement mappingOrigin;
 IfcRepresentation   mappedRepresentation;
 // The inverse attributes

 InverseLinksList<IfcMappedItem> mapUsage= new InverseLinksList<IfcMappedItem>();


 // Getters and setters of properties

 public IfcAxis2Placement getMappingOrigin() {
   return mappingOrigin;
 }
 public void setMappingOrigin(IfcAxis2Placement value){
   this.mappingOrigin=value;

 }

 public IfcRepresentation getMappedRepresentation() {
   return mappedRepresentation;

 }
 public void setMappedRepresentation(IfcRepresentation value){
   this.mappedRepresentation=value;

 }

 // Getters and setters of inverse values

 public InverseLinksList<IfcMappedItem> getMapUsage() {
   return mapUsage;

 }
 public void setMapUsage(IfcMappedItem value){
   this.mapUsage.add(value);

 }

}
