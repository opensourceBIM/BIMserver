package fi.ni.ifc2x3;
import fi.ni.InverseLinksList;
import fi.ni.Thing;
import fi.ni.ifc2x3.interfaces.IfcLayeredItem;

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

public class IfcRepresentationItem extends Thing implements IfcLayeredItem
{
 // The inverse attributes

 InverseLinksList<IfcPresentationLayerAssignment> layerAssignments= new InverseLinksList<IfcPresentationLayerAssignment>();
 InverseLinksList<IfcStyledItem> styledByItem= new InverseLinksList<IfcStyledItem>();


 // Getters and setters of inverse values

 public InverseLinksList<IfcPresentationLayerAssignment> getLayerAssignments() {
   return layerAssignments;

 }
 public void setLayerAssignments(IfcPresentationLayerAssignment value){
   this.layerAssignments.add(value);

 }

 public InverseLinksList<IfcStyledItem> getStyledByItem() {
   return styledByItem;

 }
 public void setStyledByItem(IfcStyledItem value){
   this.styledByItem.add(value);

 }

}
