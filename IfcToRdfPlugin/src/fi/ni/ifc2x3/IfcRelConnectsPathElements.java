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

public class IfcRelConnectsPathElements extends IfcRelConnectsElements 
{
 // The property attributes
 List<Long> relatingPriorities = new IfcList<Long>();
 List<Long> relatedPriorities = new IfcList<Long>();
 String relatedConnectionType;
 String relatingConnectionType;


 // Getters and setters of properties

 public List<Long> getRelatingPriorities() {
   return relatingPriorities;
 }
 public void setRelatingPriorities(String txt){
   List<Long> value = i.toLongList(txt);
   this.relatingPriorities=value;

 }

 public List<Long> getRelatedPriorities() {
   return relatedPriorities;
 }
 public void setRelatedPriorities(String txt){
   List<Long> value = i.toLongList(txt);
   this.relatedPriorities=value;

 }

 public String getRelatedConnectionType() {
   return relatedConnectionType;
 }
 public void setRelatedConnectionType(String value){
   this.relatedConnectionType=value;

 }

 public String getRelatingConnectionType() {
   return relatingConnectionType;
 }
 public void setRelatingConnectionType(String value){
   this.relatingConnectionType=value;

 }

}
