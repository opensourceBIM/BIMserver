package fi.ni.ifc2x3;
import fi.ni.Thing;
import fi.ni.ifc2x3.interfaces.IfcTextStyleSelect;

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

public class IfcTextStyleTextModel extends Thing implements IfcTextStyleSelect
{
 // The property attributes
 String textIndent;
 String textAlign;
 String textDecoration;
 String letterSpacing;
 String wordSpacing;
 String textTransform;
 String lineHeight;


 // Getters and setters of properties

 public String getTextIndent() {
   return textIndent;
 }
 public void setTextIndent(String value){
   this.textIndent=value;

 }

 public String getTextAlign() {
   return textAlign;
 }
 public void setTextAlign(String value){
   this.textAlign=value;

 }

 public String getTextDecoration() {
   return textDecoration;
 }
 public void setTextDecoration(String value){
   this.textDecoration=value;

 }

 public String getLetterSpacing() {
   return letterSpacing;
 }
 public void setLetterSpacing(String value){
   this.letterSpacing=value;

 }

 public String getWordSpacing() {
   return wordSpacing;
 }
 public void setWordSpacing(String value){
   this.wordSpacing=value;

 }

 public String getTextTransform() {
   return textTransform;
 }
 public void setTextTransform(String value){
   this.textTransform=value;

 }

 public String getLineHeight() {
   return lineHeight;
 }
 public void setLineHeight(String value){
   this.lineHeight=value;

 }

}
