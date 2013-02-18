<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<!-- 
# XSL for Property Set Definition Layer1 (PSD1)

# Author: yoshinobu.adachi@vtt.fi / yo-adachi@secom.co.jp
# Version: 3.1
# Organization: International Alliance for Interoperability
# Date: 1999/06/28 0.1
        2000/03/22 0.2
	2000/03/29 0.3 delete min, max, default. change font
	2000/03/31 0.4 added TypedClass HREF
	2000/09/03 0.5 New IFC 2x. (IfcPropertySingleVlaue)
	2000/10/10 0.6
	2002/03/15 1.7 New IFC R3.0 compatible
	2002/03/29 2.0 IFC R3.0 release
	2002/07/03 2.1 IFC R2x2 extension compatibility by JF
	2003/04/01 2.2 IFC 2x2 beta extension by YA
	2003/04/03 2.3 Added: TypePropertyList by YA
	2003/04/13 2.4 Added: Printing Default value by YA
	2003/05/09 2.5 Modified: Applicable entity path by YA
	2003/05/10 2.6 Modified: XSLT name space to be  xmlns:xsl="http://www.w3.org/TR/WD-xsl"
					Modified: Schema name and html file name to be lower case by YA
	2004/06/05 2.7 Modified: copyright notice and deleted propject code printing by YA
	2005/05/12 3.0 Modified: copyright notice, classes to entities, Added multiple schema name applicable entities by YA
	2005/05/19 3.0 Named IFC2x4 by YA
	2007/03/30 3.1 Named IFC2x3 TC1 by YA
-->
	<xsl:template match="/">
		<HTML>
			<HEAD>
				<TITLE>IFC 2x3 Property Set Definition Reference</TITLE>
			</HEAD>
			<BODY>
				<font face="arial"/>
				<H2>IFC<b>
						<i>2x3</i>
					</b>
					Property Set Definition Reference</H2>
				<HR size="5"/>
				<xsl:apply-templates select="PropertySetDef"/>
				<H3>
					<FONT color="green">Property Definitions:</FONT>
				</H3>
				<TABLE BORDER="1" WIDTH="90%">
					<TR bgcolor="#D0D0D0" VALIGN="bottom">
						<TD WIDTH="23%" ALIGN="center">
							<font size="2"/>
							<b>Name</b>
						</TD>
						<TD WIDTH="23%" ALIGN="center">
							<font size="2"/>
							<b>Property Type</b>
						</TD>
						<TD WIDTH="23%" ALIGN="center">
							<font size="2"/>
							<b>Data Type</b>
						</TD>
						<TD WIDTH="31%" ALIGN="center">
							<font size="2"/>
							<b>Definition</b>
						</TD>
					</TR>
					<xsl:apply-templates select="PropertySetDef/PropertyDefs"/>
				</TABLE>
				<HR size="5"/>
				<font size="2">Copyright (c) 2000 - 2007 International Alliance for Interoperability</font>
			</BODY>
		</HTML>
	</xsl:template>
	<xsl:template match="PropertySetDef">
		<H3>
			<FONT color="green">PropertySet Definition:</FONT>
		</H3>
		<TABLE BORDER="2" WIDTH="90%">
			<TR VALIGN="top">
				<TD bgcolor="#C0C0F0" WIDTH="18%">
					<font size="2"/>
					<b>PropertySet Name</b>
				</TD>
				<TD bgcolor="#FFFFFF">
					<font size="2"/>
					<xsl:value-of select="Name"/>
					<BR/>
				</TD>
			</TR>
			<!--
			<TR VALIGN="top">
				<TD bgcolor="#C0C0F0" WIDTH="18%">
					<font size="2"/>
					<b>Applicability</b>
				</TD>
				<TD bgcolor="#FFFFFF">
					<font size="2"/>
					<xsl:value-of select="Applicability"/>
					<BR/>
				</TD>
			</TR>
			-->
			<TR VALIGN="top">
				<TD bgcolor="#C0C0F0" WIDTH="18%">
					<font size="2"/>
					<b>Applicable Entities</b>
				</TD>
				<TD bgcolor="#FFFFFF">
					<xsl:apply-templates select="ApplicableClasses"/>
				</TD>
			</TR>
			<TR VALIGN="top">
				<TD bgcolor="#C0C0F0" WIDTH="18%">
					<font size="2"/>
					<b>Applicable Type Value</b>
				</TD>
				<TD bgcolor="#FFFFFF">
					<font size="2"/>
					<xsl:value-of select="ApplicableTypeValue"/>
					<BR/>
				</TD>
			</TR>
			<TR VALIGN="top">
				<TD bgcolor="#C0C0F0">
					<font size="2"/>
					<b>Definition</b>
				</TD>
				<TD bgcolor="#FFFFFF">
					<font size="2"/>
					<xsl:value-of select="Definition"/>
					<BR/>
				</TD>
			</TR>
		</TABLE>
	</xsl:template>
	<xsl:template match="PropertyDefs">
		<xsl:for-each select="PropertyDef">
			<xsl:choose>
				<xsl:when test="PropertyType/TypeComplexProperty">
					<tr>
						<td VALIGN="top">
							<font size="2" color="blue">
								<b><xsl:value-of select="Name"/></b>
							</font>
						</td>
						<td VALIGN="top">
							<font size="2" color="blue">
								<b>IfcComplexProperty</b>
							</font>
							<br/>
						</td>
						<td VALIGN="top">
							<font size="2" color="blue">
								<b>Usage Name:</b>
								<br/>
								<xsl:value-of select="PropertyType/TypeComplexProperty/@name"/>
							</font>
							<br/>
						</td>
						<td VALIGN="top">
							<font size="2"  color="blue">
								<xsl:apply-templates select="Definition"/>
							</font>
						</td>
					</tr>
					<xsl:apply-templates select="PropertyType/TypeComplexProperty" mode="internal"/>
				</xsl:when>
				<xsl:otherwise>
					<tr>
						<td VALIGN="top">
							<font size="2">
								<xsl:value-of select="Name"/>
							</font>
						</td>
						<xsl:apply-templates select="PropertyType"/>
						<td ALIGN="left" VALIGN="top">
							<font size="2">
								<xsl:apply-templates select="Definition"/>
							</font>
						</td>
					</tr>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:for-each>
	</xsl:template>
	<xsl:template match="TypeComplexProperty" mode="internal">
		<xsl:for-each select="PropertyDef">
			<TR>
				<TD VALIGN="top">
					<font size="2" color="blue">\__<xsl:value-of select="Name"/>
					</font>
				</TD>
				<xsl:choose>
					<xsl:when test="PropertyType/TypeComplexProperty">
						<td VALIGN="top">
							<font size="2">IfcComplexProperty</font>
							<br/>
						</td>
						<td VALIGN="top">
							<font size="2">
								<b>Usage Name: </b>
								<xsl:value-of select="PropertyType/TypeComplexProperty/@name"/>
							</font>
							<br/>
						</td>
						<td VALIGN="top">
							<font size="2">
								<xsl:apply-templates select="Definition"/>
							</font>
						</td>
						<xsl:apply-templates select="PropertyType/TypeComplexProperty" mode="internal"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:apply-templates select="PropertyType"/>
					</xsl:otherwise>
				</xsl:choose>
				<TD ALIGN="left" VALIGN="top">
					<font size="2">
						<xsl:apply-templates select="Definition"/>
					</font>
				</TD>
			</TR>
		</xsl:for-each>
	</xsl:template>
	<xsl:template match="PropertyType">
		<xsl:if test="TypePropertySingleValue">
			<xsl:apply-templates select="TypePropertySingleValue"/>
		</xsl:if>
		<xsl:if test="TypePropertyBoundedValue">
			<xsl:apply-templates select="TypePropertyBoundedValue"/>
		</xsl:if>
		<xsl:if test="TypePropertyReferenceValue">
			<xsl:apply-templates select="TypePropertyReferenceValue"/>
		</xsl:if>
		<xsl:if test="TypePropertyEnumeratedValue">
			<xsl:apply-templates select="TypePropertyEnumeratedValue"/>
		</xsl:if>
		<xsl:if test="TypePropertyTableValue">
			<xsl:apply-templates select="TypePropertyTableValue"/>
		</xsl:if>
		<xsl:if test="TypePropertyListValue">
			<xsl:apply-templates select="TypePropertyListValue"/>
		</xsl:if>
		<xsl:if test="TypeComplexProperty">
			<xsl:apply-templates select="TypeComplexProperty" mode="internal"/>
		</xsl:if>
		<xsl:if test="TypeLibraryReference">
	IfcLibraryReference
	<TD ALIGN="left" VALIGN="top">
				<BR/>
			</TD>
		</xsl:if>
		<xsl:if test="TypeSimpleProperty">
			<xsl:apply-templates select="TypeSimpleProperty"/>
		</xsl:if>
	</xsl:template>
	<xsl:template match="TypeSimpleProperty">
		<TD ALIGN="left" VALIGN="top">
			<font size="2" color="red">IfcSimpleProperty</font>
		</TD>
		<TD ALIGN="left" VALIGN="top">
			<font size="2">
				<xsl:apply-templates select="DataType"/>
				<xsl:apply-templates select="UnitType"/>
			</font>
		</TD>
	</xsl:template>
	<xsl:template match="TypePropertySingleValue">
		<TD ALIGN="left" VALIGN="top">
			<font size="2">
      IfcPropertySingleValue
        </font>
		</TD>
		<TD ALIGN="left" VALIGN="top">
			<font size="2">
				<xsl:apply-templates select="DataType"/>
				<xsl:apply-templates select="UnitType"/>
				<xsl:apply-templates select="../../ValueDef/DefaultValue"/>
			</font>
		</TD>
	</xsl:template>
	<xsl:template match="TypePropertyBoundedValue">
		<TD ALIGN="left" VALIGN="top">
			<font size="2">
      IfcPropertyBoundedValue
        </font>
		</TD>
		<TD ALIGN="left" VALIGN="top">
			<font size="2">
				<xsl:apply-templates select="DataType"/>
				<xsl:apply-templates select="UnitType"/>
				<xsl:apply-templates select="ValueRangeDef"/>
				<xsl:apply-templates select="../ValueDef/DefaultValue"/>
			</font>
		</TD>
	</xsl:template>
	<xsl:template match="TypePropertyReferenceValue">
		<TD ALIGN="left" VALIGN="top">
			<font size="2">
      IfcPropertyReferenceValue
        </font>
		</TD>
		<TD ALIGN="left" VALIGN="top">
			<font size="2">
				<xsl:value-of select="@reftype"/>
			</font>
		</TD>
	</xsl:template>
	<xsl:template match="TypePropertyEnumeratedValue">
		<TD ALIGN="left" VALIGN="top">
			<font size="2">
      IfcPropertyEnumeratedValue
        </font>
		</TD>
		<TD ALIGN="left" VALIGN="top">
			<font size="2">
				<xsl:apply-templates select="EnumList"/>
				<xsl:apply-templates select="../ValueDef/DefaultValue"/>
			</font>
		</TD>
	</xsl:template>
	<xsl:template match="TypePropertyTableValue">
		<TD ALIGN="left" VALIGN="top">
			<font size="2">
      IfcPropertyTableValue
        </font>
		</TD>
		<td>
			<xsl:apply-templates select="Expression"/>
			<xsl:apply-templates select="DefiningValue"/>
			<xsl:apply-templates select="DefinedValue"/>
		</td>
	</xsl:template>
	<xsl:template match="TypePropertyListValue">
		<TD ALIGN="left" VALIGN="top">
			<font size="2">
      IfcPropertyListValue
        </font>
		</TD>
		<td VALIGN="top">
			<xsl:apply-templates select="ListValue"/>
		</td>
	</xsl:template>
	<xsl:template match="Expression">
		<font size="2">
			<b>Expression: </b>
			<p>
				<xsl:value-of select="."/>
			</p>
		</font>
	</xsl:template>
	<xsl:template match="DefiningValue">
		<font size="2">
			<b>Defining Value:</b>
			<br/>
			<xsl:value-of select="DataType/@type"/> / <xsl:value-of select="UnitType/@type"/>
			<ol>
				<xsl:apply-templates select="Values/ValueItem"/>
			</ol>
		</font>
	</xsl:template>
	<xsl:template match="DefinedValue">
		<font size="2">
			<b>Defined Value:</b>
			<br/>
			<xsl:value-of select="DataType/@type"/> / <xsl:value-of select="UnitType/@type"/>
			<ol>
				<xsl:apply-templates select="Values/ValueItem"/>
			</ol>
		</font>
	</xsl:template>
	<xsl:template match="ListValue">
		<font size="2">
			<b>List Value:</b>
			<br/>
			<xsl:value-of select="DataType/@type"/> / <xsl:value-of select="UnitType/@type"/>
			<ol>
				<xsl:apply-templates select="Values/ValueItem"/>
			</ol>
		</font>
	</xsl:template>
	<xsl:template match="ValueItem">
		<li>
			<xsl:value-of select="text()"/>
		</li>
	</xsl:template>
	<xsl:template match="TypeComplexProperty/PropertyType/TypePropertySingleValue">
		<TD ALIGN="left" VALIGN="top">
			<font size="2">
      IfcPropertySingleValue
	<hr/>
				<xsl:apply-templates select="DataType"/>
				<xsl:apply-templates select="UnitType"/>
			</font>
		</TD>
	</xsl:template>
	<xsl:template match="TypeComplexProperty/PropertyType/TypePropertyBoundedValue">
		<TD ALIGN="left" VALIGN="top">
			<font size="2">
      IfcPropertyBoundedValue
	<hr/>
				<xsl:apply-templates select="DataType"/>
				<xsl:apply-templates select="UnitType"/>
				<xsl:apply-templates select="ValueRangeDef"/>
			</font>
		</TD>
	</xsl:template>
	<xsl:template match="TypeComplexProperty/PropertyType/TypePropertyEnumeratedValue">
		<TD ALIGN="left" VALIGN="top">
			<font size="2">
      IfcPropertyEnumeratedValue
	<hr/>
				<xsl:apply-templates select="EnumList"/>
			</font>
		</TD>
	</xsl:template>
	<xsl:template match="TypeComplexProperty/PropertyType/TypePropertyReferenceValue">
		<TD ALIGN="left" VALIGN="top">
			<font size="2">
      IfcPropertyReferenceValue
    	<hr/>
				<xsl:value-of select="@reftype"/>
			</font>
		</TD>
	</xsl:template>
	<xsl:template match="TypeComplexProperty/PropertyType/TypePropertyTableValue">
		<TD ALIGN="left" VALIGN="top">
			<font size="2">
	IfcPropertyTableValue
	</font>
			<hr/>
			<xsl:apply-templates select="Expression"/>
			<xsl:apply-templates select="DefiningValue"/>
			<xsl:apply-templates select="DefinedValue"/>
		</TD>
	</xsl:template>
	<xsl:template match="EnumList">
		<xsl:value-of select="@name"/>
		<ul>
			<xsl:for-each select="EnumItem">
				<li>
					<xsl:value-of select="."/>
				</li>
			</xsl:for-each>
		</ul>
	</xsl:template>
	<xsl:template match="ApplicableClasses">
		<xsl:variable name="schema_name" select="../IfcVersion/@schema"/>
		<xsl:for-each select="ClassName">
			<a>
				<xsl:choose>
					<xsl:when test="string-length($schema_name)=0 ">
						<xsl:attribute name="HREF">../../
							<xsl:call-template name="get_lower_string">
								<xsl:with-param name="str_input">
									<xsl:call-template name="get_schema_string"><xsl:with-param name="str_input" select="."/></xsl:call-template>
								</xsl:with-param>
							</xsl:call-template>/lexical/
							<xsl:call-template name="get_lower_string">
								<xsl:with-param name="str_input">
									<xsl:call-template name="get_entity_string"><xsl:with-param name="str_input" select="."/></xsl:call-template>
								</xsl:with-param>
							</xsl:call-template>.htm
						</xsl:attribute>
						<font size="2"/>
						<xsl:call-template name="get_entity_string"><xsl:with-param name="str_input" select="."/></xsl:call-template>
					</xsl:when>
					<xsl:otherwise>
						<xsl:attribute name="HREF">../../
							<xsl:call-template name="get_lower_string"><xsl:with-param name="str_input" select="$schema_name"/></xsl:call-template>/lexical/
							<xsl:call-template name="get_lower_string"><xsl:with-param name="str_input" select="."/></xsl:call-template>.htm
						</xsl:attribute>
						<font size="2"/>
						<xsl:value-of select="."/>
					</xsl:otherwise>
				</xsl:choose>
			</a>
			<xsl:value-of select="string(' ')"/>
		</xsl:for-each>
	</xsl:template>
	<xsl:template match="DataType">
		<xsl:value-of select="@type"/>
	</xsl:template>
	<xsl:template match="UnitType">
      /
      <xsl:value-of select="@type"/>
	</xsl:template>
	<xsl:template match="ValueRangeDef">
		<br/>
		<ul>
			<li>LowerBound: <xsl:value-of select="LowerBoundValue/@value"/>
			</li>
			<li>UpperBound: <xsl:value-of select="UpperBoundValue/@value"/>
			</li>
		</ul>
	</xsl:template>
	<xsl:template match="Definition">
		<xsl:value-of select="."/>
	</xsl:template>
	<xsl:template match="ValueDef/DefaultValue ">
		<br/>
		<ul>
			<li>Default Value: <xsl:value-of select="@value"/>
			</li>
		</ul>
	</xsl:template>
	<!-- Lowercase function -->
	<xsl:template name="get_lower_string">
		<xsl:param name="str_input"/>
		<xsl:value-of select="translate($str_input, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')"/>
	</xsl:template>
	<!-- Extract SchameName from SchemaName/EntityName -->
	<xsl:template name="get_schema_string">
		<xsl:param name="str_input"/>
		<xsl:value-of select="substring-before($str_input, '/')"/>
	</xsl:template>
	<!-- Extract EntityName from SchemaName/EntityName -->
	<xsl:template name="get_entity_string">
		<xsl:param name="str_input"/>
		<xsl:value-of select="substring-after($str_input, '/')"/>
	</xsl:template>
</xsl:stylesheet>
<!-- EOF -->
