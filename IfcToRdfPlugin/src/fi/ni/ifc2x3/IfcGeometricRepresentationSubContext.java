package fi.ni.ifc2x3;
import fi.ni.ifc2x3.interfaces.*;
import fi.ni.*;
import java.util.*;

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

public class IfcGeometricRepresentationSubContext extends IfcGeometricRepresentationContext 
{
 // The property attributes
 IfcGeometricRepresentationContext   parentContext;
 Double targetScale;
 String targetView;
 String userDefinedTargetView;


 // Getters and setters of properties

 public IfcGeometricRepresentationContext getParentContext() {
   return parentContext;

 }
 public void setParentContext(IfcGeometricRepresentationContext value){
   this.parentContext=value;

 }

 public Double getTargetScale() {
   return targetScale;
 }
 public void setTargetScale(String txt){
   Double value = i.toDouble(txt);
   this.targetScale=value;

 }

 public String getTargetView() {
   return targetView;
 }
 public void setTargetView(String value){
   this.targetView=value;

 }

 public String getUserDefinedTargetView() {
   return userDefinedTargetView;
 }
 public void setUserDefinedTargetView(String value){
   this.userDefinedTargetView=value;

 }

}
