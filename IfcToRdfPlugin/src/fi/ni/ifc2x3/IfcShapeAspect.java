package fi.ni.ifc2x3;
import java.util.List;

import fi.ni.IfcList;
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

public class IfcShapeAspect extends Thing 
{
 // The property attributes
 List<IfcShapeModel> shapeRepresentations = new IfcList<IfcShapeModel>();
 String name;
 String description;
 String productDefinitional;
 IfcProductDefinitionShape   partOfProductDefinitionShape;


 // Getters and setters of properties

 public List<IfcShapeModel> getShapeRepresentations() {
   return shapeRepresentations;

 }
 public void setShapeRepresentations(IfcShapeModel value){
   this.shapeRepresentations.add(value);

 }

 public String getName() {
   return name;
 }
 public void setName(String value){
   this.name=value;

 }

 public String getDescription() {
   return description;
 }
 public void setDescription(String value){
   this.description=value;

 }

 public String getProductDefinitional() {
   return productDefinitional;
 }
 public void setProductDefinitional(String value){
   this.productDefinitional=value;

 }

 public IfcProductDefinitionShape getPartOfProductDefinitionShape() {
   return partOfProductDefinitionShape;

 }
 public void setPartOfProductDefinitionShape(IfcProductDefinitionShape value){
   this.partOfProductDefinitionShape=value;

 }

}
