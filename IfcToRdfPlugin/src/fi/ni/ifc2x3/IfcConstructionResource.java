package fi.ni.ifc2x3;

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

public class IfcConstructionResource extends IfcResource 
{
 // The property attributes
 String resourceIdentifier;
 String resourceGroup;
 String resourceConsumption;
 IfcMeasureWithUnit   baseQuantity;


 // Getters and setters of properties

 public String getResourceIdentifier() {
   return resourceIdentifier;
 }
 public void setResourceIdentifier(String value){
   this.resourceIdentifier=value;

 }

 public String getResourceGroup() {
   return resourceGroup;
 }
 public void setResourceGroup(String value){
   this.resourceGroup=value;

 }

 public String getResourceConsumption() {
   return resourceConsumption;
 }
 public void setResourceConsumption(String value){
   this.resourceConsumption=value;

 }

 public IfcMeasureWithUnit getBaseQuantity() {
   return baseQuantity;

 }
 public void setBaseQuantity(IfcMeasureWithUnit value){
   this.baseQuantity=value;

 }

}
