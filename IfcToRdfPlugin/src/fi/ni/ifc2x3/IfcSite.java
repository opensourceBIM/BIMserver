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

public class IfcSite extends IfcSpatialStructureElement 
{
 // The property attributes
 String refLatitude;
 String refLongitude;
 Double refElevation;
 String landTitleNumber;
 IfcPostalAddress   siteAddress;


 // Getters and setters of properties

 public String getRefLatitude() {
   return refLatitude;
 }
 public void setRefLatitude(String value){
   this.refLatitude=value;

 }

 public String getRefLongitude() {
   return refLongitude;
 }
 public void setRefLongitude(String value){
   this.refLongitude=value;

 }

 public Double getRefElevation() {
   return refElevation;
 }
 public void setRefElevation(String txt){
   Double value = i.toDouble(txt);
   this.refElevation=value;

 }

 public String getLandTitleNumber() {
   return landTitleNumber;
 }
 public void setLandTitleNumber(String value){
   this.landTitleNumber=value;

 }

 public IfcPostalAddress getSiteAddress() {
   return siteAddress;

 }
 public void setSiteAddress(IfcPostalAddress value){
   this.siteAddress=value;

 }

}
