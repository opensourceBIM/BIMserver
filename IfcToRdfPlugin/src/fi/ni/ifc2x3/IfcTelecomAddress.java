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

public class IfcTelecomAddress extends IfcAddress 
{
 // The property attributes
 List<String> telephoneNumbers = new IfcList<String>();
 List<String> facsimileNumbers = new IfcList<String>();
 String pagerNumber;
 List<String> electronicMailAddresses = new IfcList<String>();
 String wWWHomePageURL;


 // Getters and setters of properties

 public List<String> getTelephoneNumbers() {
   return telephoneNumbers;
 }
 public void setTelephoneNumbers(String value){
   this.telephoneNumbers.add(value);

 }

 public List<String> getFacsimileNumbers() {
   return facsimileNumbers;
 }
 public void setFacsimileNumbers(String value){
   this.facsimileNumbers.add(value);

 }

 public String getPagerNumber() {
   return pagerNumber;
 }
 public void setPagerNumber(String value){
   this.pagerNumber=value;

 }

 public List<String> getElectronicMailAddresses() {
   return electronicMailAddresses;
 }
 public void setElectronicMailAddresses(String value){
   this.electronicMailAddresses.add(value);

 }

 public String getWWWHomePageURL() {
   return wWWHomePageURL;
 }
 public void setWWWHomePageURL(String value){
   this.wWWHomePageURL=value;

 }

}
