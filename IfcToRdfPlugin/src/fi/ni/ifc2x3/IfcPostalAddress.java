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

public class IfcPostalAddress extends IfcAddress 
{
 // The property attributes
 String internalLocation;
 List<String> addressLines = new IfcList<String>();
 String postalBox;
 String town;
 String region;
 String postalCode;
 String country;


 // Getters and setters of properties

 public String getInternalLocation() {
   return internalLocation;
 }
 public void setInternalLocation(String value){
   this.internalLocation=value;

 }

 public List<String> getAddressLines() {
   return addressLines;
 }
 public void setAddressLines(String value){
   this.addressLines.add(value);

 }

 public String getPostalBox() {
   return postalBox;
 }
 public void setPostalBox(String value){
   this.postalBox=value;

 }

 public String getTown() {
   return town;
 }
 public void setTown(String value){
   this.town=value;

 }

 public String getRegion() {
   return region;
 }
 public void setRegion(String value){
   this.region=value;

 }

 public String getPostalCode() {
   return postalCode;
 }
 public void setPostalCode(String value){
   this.postalCode=value;

 }

 public String getCountry() {
   return country;
 }
 public void setCountry(String value){
   this.country=value;

 }

}
