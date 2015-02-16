package fi.ni.ifc2x3;
import java.util.List;

import fi.ni.IfcList;

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

public class IfcPixelTexture extends IfcSurfaceTexture 
{
 // The property attributes
 Long width;
 Long height;
 Long colourComponents;
 List<String> pixel = new IfcList<String>();


 // Getters and setters of properties

 public Long getWidth() {
   return width;
 }
 public void setWidth(String txt){
   Long value = i.toLong(txt);
   this.width=value;

 }

 public Long getHeight() {
   return height;
 }
 public void setHeight(String txt){
   Long value = i.toLong(txt);
   this.height=value;

 }

 public Long getColourComponents() {
   return colourComponents;
 }
 public void setColourComponents(String txt){
   Long value = i.toLong(txt);
   this.colourComponents=value;

 }

 public List<String> getPixel() {
   return pixel;
 }
 public void setPixel(String value){
   this.pixel.add(value);

 }

}
