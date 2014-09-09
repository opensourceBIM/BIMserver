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

public class IfcTextStyleFontModel extends IfcPreDefinedTextFont 
{
 // The property attributes
 List<String> fontFamily = new IfcList<String>();
 String fontStyle;
 String fontVariant;
 String fontWeight;
 String fontSize;


 // Getters and setters of properties

 public List<String> getFontFamily() {
   return fontFamily;
 }
 public void setFontFamily(String value){
   this.fontFamily.add(value);

 }

 public String getFontStyle() {
   return fontStyle;
 }
 public void setFontStyle(String value){
   this.fontStyle=value;

 }

 public String getFontVariant() {
   return fontVariant;
 }
 public void setFontVariant(String value){
   this.fontVariant=value;

 }

 public String getFontWeight() {
   return fontWeight;
 }
 public void setFontWeight(String value){
   this.fontWeight=value;

 }

 public String getFontSize() {
   return fontSize;
 }
 public void setFontSize(String value){
   this.fontSize=value;

 }

}
