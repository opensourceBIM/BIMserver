package fi.ni.ifc2x3;
import fi.ni.Thing;
import fi.ni.ifc2x3.interfaces.IfcDateTimeSelect;
import fi.ni.ifc2x3.interfaces.IfcObjectReferenceSelect;

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

public class IfcCalendarDate extends Thing implements IfcDateTimeSelect, IfcObjectReferenceSelect
{
 // The property attributes
 Long dayComponent;
 Long monthComponent;
 Long yearComponent;


 // Getters and setters of properties

 public Long getDayComponent() {
   return dayComponent;
 }
 public void setDayComponent(String txt){
   Long value = i.toLong(txt);
   this.dayComponent=value;

 }

 public Long getMonthComponent() {
   return monthComponent;
 }
 public void setMonthComponent(String txt){
   Long value = i.toLong(txt);
   this.monthComponent=value;

 }

 public Long getYearComponent() {
   return yearComponent;
 }
 public void setYearComponent(String txt){
   Long value = i.toLong(txt);
   this.yearComponent=value;

 }

}
