package fi.ni.ifc2x3;

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

public class IfcTask extends IfcProcess 
{
 // The property attributes
 String taskId;
 String status;
 String workMethod;
 String isMilestone;
 Long priority;


 // Getters and setters of properties

 public String getTaskId() {
   return taskId;
 }
 public void setTaskId(String value){
   this.taskId=value;

 }

 public String getStatus() {
   return status;
 }
 public void setStatus(String value){
   this.status=value;

 }

 public String getWorkMethod() {
   return workMethod;
 }
 public void setWorkMethod(String value){
   this.workMethod=value;

 }

 public String getIsMilestone() {
   return isMilestone;
 }
 public void setIsMilestone(String value){
   this.isMilestone=value;

 }

 public Long getPriority() {
   return priority;
 }
 public void setPriority(String txt){
   Long value = i.toLong(txt);
   this.priority=value;

 }

}
