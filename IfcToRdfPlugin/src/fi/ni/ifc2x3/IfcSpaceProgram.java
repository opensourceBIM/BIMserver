package fi.ni.ifc2x3;
import fi.ni.InverseLinksList;

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

public class IfcSpaceProgram extends IfcControl 
{
 // The property attributes
 String spaceProgramIdentifier;
 Double maxRequiredArea;
 Double minRequiredArea;
 IfcSpatialStructureElement   requestedLocation;
 Double standardRequiredArea;
 // The inverse attributes

 InverseLinksList<IfcRelInteractionRequirements> hasInteractionReqsFrom= new InverseLinksList<IfcRelInteractionRequirements>();
 InverseLinksList<IfcRelInteractionRequirements> hasInteractionReqsTo= new InverseLinksList<IfcRelInteractionRequirements>();


 // Getters and setters of properties

 public String getSpaceProgramIdentifier() {
   return spaceProgramIdentifier;
 }
 public void setSpaceProgramIdentifier(String value){
   this.spaceProgramIdentifier=value;

 }

 public Double getMaxRequiredArea() {
   return maxRequiredArea;
 }
 public void setMaxRequiredArea(String txt){
   Double value = i.toDouble(txt);
   this.maxRequiredArea=value;

 }

 public Double getMinRequiredArea() {
   return minRequiredArea;
 }
 public void setMinRequiredArea(String txt){
   Double value = i.toDouble(txt);
   this.minRequiredArea=value;

 }

 public IfcSpatialStructureElement getRequestedLocation() {
   return requestedLocation;

 }
 public void setRequestedLocation(IfcSpatialStructureElement value){
   this.requestedLocation=value;

 }

 public Double getStandardRequiredArea() {
   return standardRequiredArea;
 }
 public void setStandardRequiredArea(String txt){
   Double value = i.toDouble(txt);
   this.standardRequiredArea=value;

 }

 // Getters and setters of inverse values

 public InverseLinksList<IfcRelInteractionRequirements> getHasInteractionReqsFrom() {
   return hasInteractionReqsFrom;

 }
 public void setHasInteractionReqsFrom(IfcRelInteractionRequirements value){
   this.hasInteractionReqsFrom.add(value);

 }

 public InverseLinksList<IfcRelInteractionRequirements> getHasInteractionReqsTo() {
   return hasInteractionReqsTo;

 }
 public void setHasInteractionReqsTo(IfcRelInteractionRequirements value){
   this.hasInteractionReqsTo.add(value);

 }

}
