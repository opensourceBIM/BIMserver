package fi.ni.ifc2x3;
import java.util.List;

import fi.ni.IfcSet;
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

public class IfcRepresentation extends Thing implements IfcLayeredItem
{
 // The property attributes
 IfcRepresentationContext   contextOfItems;
 String representationIdentifier;
 String representationType;
 List<IfcRepresentationItem> items = new IfcSet<IfcRepresentationItem>();
 // The inverse attributes

 InverseLinksList<IfcRepresentationMap> representationMap= new InverseLinksList<IfcRepresentationMap>();
 InverseLinksList<IfcPresentationLayerAssignment> layerAssignments= new InverseLinksList<IfcPresentationLayerAssignment>();
 InverseLinksList<IfcProductRepresentation> ofProductRepresentation= new InverseLinksList<IfcProductRepresentation>();


 // Getters and setters of properties

 public IfcRepresentationContext getContextOfItems() {
   return contextOfItems;

 }
 public void setContextOfItems(IfcRepresentationContext value){
   this.contextOfItems=value;

 }

 public String getRepresentationIdentifier() {
   return representationIdentifier;
 }
 public void setRepresentationIdentifier(String value){
   this.representationIdentifier=value;

 }

 public String getRepresentationType() {
   return representationType;
 }
 public void setRepresentationType(String value){
   this.representationType=value;

 }

 public List<IfcRepresentationItem> getItems() {
   return items;

 }
 public void setItems(IfcRepresentationItem value){
   this.items.add(value);

 }

 // Getters and setters of inverse values

 public InverseLinksList<IfcRepresentationMap> getRepresentationMap() {
   return representationMap;

 }
 public void setRepresentationMap(IfcRepresentationMap value){
   this.representationMap.add(value);

 }

 public InverseLinksList<IfcPresentationLayerAssignment> getLayerAssignments() {
   return layerAssignments;

 }
 public void setLayerAssignments(IfcPresentationLayerAssignment value){
   this.layerAssignments.add(value);

 }

 public InverseLinksList<IfcProductRepresentation> getOfProductRepresentation() {
   return ofProductRepresentation;

 }
 public void setOfProductRepresentation(IfcProductRepresentation value){
   this.ofProductRepresentation.add(value);

 }

}
