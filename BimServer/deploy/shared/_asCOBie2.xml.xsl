<?xml version="1.0" encoding="ISO-8859-1"?>
<?altova_samplexml ../models/SixRooms.ifcxml?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" ex:version="2.0" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:ex="urn:iso.org:standard:10303:part(28):version(2):xmlschema:common" xmlns:ifc="http://www.iai-tech.org/ifcXML/IFC2x3/FINAL" xsi:schemaLocation="http://www.iai-tech.org/ifcXML/IFC2x3/FINAL http://www.iai-tech.org/ifcXML/IFC2x3/FINAL/IFC2x3.xsd ./IFC2x3.xsd" xmlns="urn:schemas-microsoft-com:office:spreadsheet" xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet" xmlns:html="http://www.w3.org/TR/REC-html40" exclude-result-prefixes="fo xs fn xlink xsi ex ifc">
	<xsl:output method="xml" encoding="UTF-8" indent="yes" version="1.0"/>
	<xsl:param name="param1">AEC3</xsl:param>
	<xsl:param name="cur">
		<xsl:text>n/a</xsl:text>
	</xsl:param>
	<xsl:param name="all">
		<xsl:text>no</xsl:text>
	</xsl:param>
	<xsl:param name="dat1">
		<xsl:text>2010-05-24T12:34:56</xsl:text>
	</xsl:param>
	<xsl:variable name="vers1">2</xsl:variable>
	<xsl:variable name="vers2">26</xsl:variable>
	<xsl:variable name="cln"> : </xsl:variable>
	<!-- keys used to accelerate parsing -->
	<xsl:key name="find_id" match="*" use="@id"/>
	<xsl:key name="find_ref" match="*" use="@ref"/>
	<!-- units -->
	<xsl:variable name="lif">
		<xsl:text>year</xsl:text>
	</xsl:variable>
	<xsl:variable name="linearFactor">
		<xsl:for-each select="//ifc:IfcUnitAssignment[not(@ref)]/ifc:Units/*">
			<xsl:for-each select="key('find_id',@ref)">
				<xsl:if test="ifc:UnitType='lengthunit'">
					<xsl:choose>
						<xsl:when test="ifc:Prefix='milli'">1000</xsl:when>
						<xsl:when test="ifc:Name='metre'">1</xsl:when>
						<xsl:when test="ifc:Name='INCH'">39.37</xsl:when>
						<xsl:when test="ifc:Name='inch'">39.37</xsl:when>
						<xsl:otherwise>1</xsl:otherwise>
					</xsl:choose>
				</xsl:if>
			</xsl:for-each>
		</xsl:for-each>
	</xsl:variable>
	<xsl:variable name="unt">
		<xsl:for-each select="//ifc:IfcUnitAssignment[not(@ref)]/ifc:Units/*">
			<xsl:for-each select="key('find_id',@ref)">
				<xsl:if test="ifc:UnitType='lengthunit'">
					<xsl:choose>
						<xsl:when test="ifc:Prefix='milli'">millimeters</xsl:when>
						<xsl:when test="ifc:Name='metre'">meters</xsl:when>
						<xsl:when test="ifc:Name='INCH'">inches</xsl:when>
						<xsl:when test="ifc:Name='inch'">inches</xsl:when>
						<xsl:otherwise>feet</xsl:otherwise>
					</xsl:choose>
				</xsl:if>
			</xsl:for-each>
		</xsl:for-each>
	</xsl:variable>
	<xsl:variable name="unt2">
		<xsl:for-each select="//ifc:IfcUnitAssignment[not(@ref)]/ifc:Units/*">
			<xsl:for-each select="key('find_id',@ref)">
				<xsl:if test="ifc:UnitType='areaunit'">
					<xsl:choose>
						<xsl:when test="ifc:Name='square_metre'">squaremeters</xsl:when>
						<xsl:otherwise>squarefeet</xsl:otherwise>
					</xsl:choose>
				</xsl:if>
			</xsl:for-each>
		</xsl:for-each>
	</xsl:variable>
	<xsl:variable name="unt3">
		<xsl:for-each select="//ifc:IfcUnitAssignment[not(@ref)]/ifc:Units/*">
			<xsl:for-each select="key('find_id',@ref)">
				<xsl:if test="ifc:UnitType='volumeunit'">
					<xsl:choose>
						<xsl:when test="ifc:Name='cubic_metre'">cubicmeters</xsl:when>
						<xsl:otherwise>cubicfeet</xsl:otherwise>
					</xsl:choose>
				</xsl:if>
			</xsl:for-each>
		</xsl:for-each>
	</xsl:variable>
	<xsl:variable name="dat" select="substring($dat1,1,10)"/>
	<xsl:variable name="tim" select="substring($dat1,11,8)"/>
	<xsl:variable name="timeunit">year</xsl:variable>
	<xsl:variable name="timeunit2">hour</xsl:variable>
	<!-- constants -->
	<xsl:variable name="na">
		<xsl:text>n/a</xsl:text>
	</xsl:variable>
	<!-- common values -->
	<xsl:variable name="doc">
		<xsl:call-template name="nav">
			<xsl:with-param name="text">
				<xsl:choose>
					<xsl:when test="//ifc:IfcProject[not(@ref)]/ifc:Name">
						<xsl:value-of select="//ifc:IfcProject[not(@ref)]/ifc:Name"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="//ifc:IfcProject[not(@ref)]/ifc:LongName"/>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:with-param>
		</xsl:call-template>
	</xsl:variable>
	<xsl:variable name="doc1">
		<xsl:call-template name="nav">
			<xsl:with-param name="text">
				<xsl:choose>
					<xsl:when test="//ifc:IfcSite[not(@ref)]/ifc:Name">
						<xsl:value-of select="//ifc:IfcSite[not(@ref)]/ifc:Name"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="//ifc:IfcSite[not(@ref)]/ifc:LongName"/>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:with-param>
		</xsl:call-template>
	</xsl:variable>
	<xsl:variable name="app">
		<xsl:call-template name="nav">
			<xsl:with-param name="text">
				<xsl:value-of select="//ifc:IfcApplication[not(@ref)][1]/ifc:ApplicationFullName"/>
			</xsl:with-param>
		</xsl:call-template>
	</xsl:variable>
	<xsl:variable name="org">
		<xsl:call-template name="nav">
			<xsl:with-param name="text">
				<xsl:value-of select="//ifc:IfcOrganization[not(@ref)][1]/ifc:Name"/>
			</xsl:with-param>
		</xsl:call-template>
	</xsl:variable>
	<xsl:variable name="gn1">
		<xsl:value-of select="//ifc:IfcPerson[not(@ref)][1]/ifc:GivenName"/>
	</xsl:variable>
	<xsl:variable name="fn1">
		<xsl:value-of select="//ifc:IfcPerson[not(@ref)][1]/ifc:FamilyName"/>
	</xsl:variable>
	<xsl:variable name="per">
		<xsl:call-template name="nav">
			<xsl:with-param name="text">
				<xsl:value-of select="$gn1"/>
				<xsl:text> </xsl:text>
				<xsl:value-of select="$fn1"/>
			</xsl:with-param>
		</xsl:call-template>
	</xsl:variable>
	<xsl:variable name="oh0" select="//ifc:OwnerHistory/*[1]/@ref"/>
	<!-- root sets up spreadsheet and then each worksheet and writes header row and then body rows -->
	<xsl:template match="/">
		<xsl:processing-instruction name="mso-application">progid="Excel.Sheet"</xsl:processing-instruction>
		<xsl:comment>Mapping v<xsl:value-of select="$dat"/> of IFC <xsl:value-of select="$doc"/>  TO COBIE<xsl:value-of select="$vers1"/>.<xsl:value-of select="$vers2"/> by <xsl:value-of select="$param1"/>
		</xsl:comment>
		<xsl:message>Mapping v<xsl:value-of select="$dat"/> of IFC <xsl:value-of select="$doc"/>  TO COBIE<xsl:value-of select="$vers1"/>.<xsl:value-of select="$vers2"/>  by <xsl:value-of select="$param1"/>
		</xsl:message>
		<Workbook xmlns="urn:schemas-microsoft-com:office:spreadsheet" xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet" xmlns:html="http://www.w3.org/TR/REC-html40">
			<DocumentProperties xmlns="urn:schemas-microsoft-com:office:office">
				<Author>
					<xsl:value-of select="$per"/>
				</Author>
				<LastAuthor>
					<xsl:value-of select="$per"/>
				</LastAuthor>
				<Created>
					<xsl:value-of select="$dat1"/>
				</Created>
				<Company>
					<xsl:value-of select="$org"/>
				</Company>
				<Version>11.8036</Version>
			</DocumentProperties>
			<Styles>
				<Style ss:ID="Mandatory">
					<Interior ss:Color="#FFFF99" ss:Pattern="Solid"/>
					<!-- yellow -->
					<xsl:call-template name="cell"/>
				</Style>
				<Style ss:ID="Optional">
					<Interior ss:Color="#CC99FF" ss:Pattern="Solid"/>
					<!-- purple -->
					<xsl:call-template name="cell"/>
				</Style>
				<Style ss:ID="Specifiable">
					<Interior ss:Color="#CCFFCC" ss:Pattern="Solid"/>
					<!-- green -->
					<xsl:call-template name="cell"/>
				</Style>
				<Style ss:ID="Reference">
					<Interior ss:Color="#FFCC99" ss:Pattern="Solid"/>
					<!-- puce -->
					<xsl:call-template name="cell"/>
				</Style>
				<Style ss:ID="Unchangable">
					<Interior ss:Color="#969696" ss:Pattern="Solid"/>
					<!-- white -->
					<xsl:call-template name="cell"/>
				</Style>
				<Style ss:ID="Header">
					<Font ss:FontName="Arial" x:Family="Swiss" ss:Bold="1"/>
					<Alignment ss:Horizontal="Center" ss:Vertical="Bottom" ss:ReadingOrder="LeftToRight" ss:Rotate="90" ss:ShrinkToFit="1"/>
					<Interior ss:Color="#C0C0C0" ss:Pattern="Solid"/>
					<!-- grey -->
					<xsl:call-template name="cell"/>
				</Style>
				<Style ss:ID="Header2">
					<Interior ss:Color="#C0C0C0" ss:Pattern="Solid"/>
					<!-- grey -->
					<xsl:call-template name="cell"/>
				</Style>
			</Styles>
			<!-- create each worksheet -->
			<xsl:message>Instruction</xsl:message>
			<xsl:element name="Worksheet">
				<xsl:attribute name="ss:Name">Instruction</xsl:attribute>
				<Table>
					<Row>
						<Cell ss:StyleID="Header2">
							<Data ss:Type="String">Title</Data>
						</Cell>
						<Cell ss:StyleID="Mandatory">
							<Data ss:Type="String">COBIE</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Header2">
							<Data ss:Type="String">Version</Data>
						</Cell>
						<Cell ss:StyleID="Mandatory">
							<Data ss:Type="Number">
								<xsl:value-of select="$vers1"/>
							</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Header2">
							<Data ss:Type="String">Release</Data>
						</Cell>
						<Cell ss:StyleID="Mandatory">
							<Data ss:Type="Number">
								<xsl:value-of select="$vers2"/>
							</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Header2">
							<Data ss:Type="String">Status</Data>
						</Cell>
						<Cell ss:StyleID="Mandatory">
							<Data ss:Type="String">draft</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Header2">
							<Data ss:Type="String">Region</Data>
						</Cell>
						<Cell ss:StyleID="Mandatory">
							<Data ss:Type="String">en-US</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Header2">
							<Data ss:Type="String">Purpose</Data>
						</Cell>
						<Cell ss:StyleID="Mandatory">
							<Data ss:Type="String">This spreadsheet supports the exchange of building information through the life of the project.</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Header2">
							<Data ss:Type="String">Outline</Data>
						</Cell>
						<Cell ss:StyleID="Mandatory">
							<Data ss:Type="String">Individual worksheets are organized by project phase as shown below</Data>
						</Cell>
					</Row>
					<Row ss:Index="9">
						<Cell ss:StyleID="Header2">
							<Data ss:Type="String">All Phases</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Header2" ss:Index="2">
							<Data ss:Type="String">Sheet</Data>
						</Cell>
						<Cell ss:StyleID="Header2">
							<Data ss:Type="String">Contents</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Mandatory" ss:Index="2">
							<Data ss:Type="String">Contact</Data>
						</Cell>
						<Cell ss:StyleID="Mandatory">
							<Data ss:Type="String">People and Companies</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:Index="2"/>
					</Row>
					<Row>
						<Cell ss:StyleID="Header2">
							<Data ss:Type="String">Early Design Worksheets</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Header2" ss:Index="2">
							<Data ss:Type="String">Sheet</Data>
						</Cell>
						<Cell ss:StyleID="Header2">
							<Data ss:Type="String">Contents</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Mandatory" ss:Index="2">
							<Data ss:Type="String">Facility</Data>
						</Cell>
						<Cell ss:StyleID="Mandatory">
							<Data ss:Type="String">Project, Site, and Facility</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Mandatory" ss:Index="2">
							<Data ss:Type="String">Floor</Data>
						</Cell>
						<Cell ss:StyleID="Mandatory">
							<Data ss:Type="String">Vertical levels and exterior areas</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Mandatory" ss:Index="2">
							<Data ss:Type="String">Space</Data>
						</Cell>
						<Cell ss:StyleID="Mandatory">
							<Data ss:Type="String">Spaces</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Specifiable" ss:Index="2">
							<Data ss:Type="String">Zone</Data>
						</Cell>
						<Cell ss:StyleID="Specifiable">
							<Data ss:Type="String">Sets of spaces sharing a specific attribute</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Mandatory" ss:Index="2">
							<Data ss:Type="String">Type</Data>
						</Cell>
						<Cell ss:StyleID="Mandatory">
							<Data ss:Type="String">Types of equipment, products, and materials</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:Index="2"/>
					</Row>
					<Row>
						<Cell ss:StyleID="Header2">
							<Data ss:Type="String">Detailed Design Worksheets</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Header2" ss:Index="2">
							<Data ss:Type="String">Sheet</Data>
						</Cell>
						<Cell ss:StyleID="Header2">
							<Data ss:Type="String">Contents</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Mandatory" ss:Index="2">
							<Data ss:Type="String">Component</Data>
						</Cell>
						<Cell ss:StyleID="Mandatory">
							<Data ss:Type="String">Individually named or schedule items</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Specifiable" ss:Index="2">
							<Data ss:Type="String">System</Data>
						</Cell>
						<Cell ss:StyleID="Specifiable">
							<Data ss:Type="String">Sets of components providing a service</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:Index="2"/>
					</Row>
					<Row>
						<Cell ss:StyleID="Header2">
							<Data ss:Type="String">Construction Worksheets</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Header2" ss:Index="2">
							<Data ss:Type="String">Sheet</Data>
						</Cell>
						<Cell ss:StyleID="Header2">
							<Data ss:Type="String">Contents</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:Index="2">
							<Data ss:Type="String">Note: all approved submittals added under Documents</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:Index="2">
							<Data ss:Type="String">Note: manufacturer, model, serial, and tag on Component</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:Index="2"/>
					</Row>
					<Row>
						<Cell ss:StyleID="Header2">
							<Data ss:Type="String">Operations and Maintenance Worksheets</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Header2" ss:Index="2">
							<Data ss:Type="String">Sheet</Data>
						</Cell>
						<Cell ss:StyleID="Header2">
							<Data ss:Type="String">Contents</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Mandatory" ss:Index="2">
							<Data ss:Type="String">Spare</Data>
						</Cell>
						<Cell ss:StyleID="Mandatory">
							<Data ss:Type="String">Onsite and replacement parts</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Mandatory" ss:Index="2">
							<Data ss:Type="String">Resource</Data>
						</Cell>
						<Cell ss:StyleID="Mandatory">
							<Data ss:Type="String">Required materails, tools, and training</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Mandatory" ss:Index="2">
							<Data ss:Type="String">Job</Data>
						</Cell>
						<Cell ss:StyleID="Mandatory">
							<Data ss:Type="String">PM, Safety, and other job plans</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:Index="2">
							<Data ss:Type="String">Note: warranty information on Type</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:Index="2"/>
					</Row>
					<Row>
						<Cell ss:StyleID="Header2">
							<Data ss:Type="String">All Phases</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Header2" ss:Index="2">
							<Data ss:Type="String">Sheet</Data>
						</Cell>
						<Cell ss:StyleID="Header2">
							<Data ss:Type="String">Contents</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Mandatory" ss:Index="2">
							<Data ss:Type="String">Document</Data>
						</Cell>
						<Cell ss:StyleID="Mandatory">
							<Data ss:Type="String">All applicable document references</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Specifiable" ss:Index="2">
							<Data ss:Type="String">Attribute</Data>
						</Cell>
						<Cell ss:StyleID="Specifiable">
							<Data ss:Type="String">Property sets of referenced item</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Specifiable" ss:Index="2">
							<Data ss:Type="String">Connection</Data>
						</Cell>
						<Cell ss:StyleID="Specifiable">
							<Data ss:Type="String">Logical connections between components</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Specifiable" ss:Index="2">
							<Data ss:Type="String">Coordinate</Data>
						</Cell>
						<Cell ss:StyleID="Specifiable">
							<Data ss:Type="String">Spatial locations in box, line, or point format</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:StyleID="Specifiable" ss:Index="2">
							<Data ss:Type="String">Issue</Data>
						</Cell>
						<Cell ss:StyleID="Specifiable">
							<Data ss:Type="String">Other required handover issues</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:Index="2"/>
					</Row>
					<Row>
						<Cell ss:StyleID="Header2">
							<Data ss:Type="String">Legend</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:Index="2"/>
						<Cell/>
					</Row>
					<Row>
						<Cell ss:StyleID="Mandatory" ss:Index="2">
							<Data ss:Type="String">text</Data>
						</Cell>
						<Cell>
							<Data ss:Type="String"> required</Data>
						</Cell>
					</Row>
					<Row ss:Index="50">
						<Cell ss:StyleID="Reference" ss:Index="2">
							<Data ss:Type="String">text</Data>
						</Cell>
						<Cell>
							<Data ss:Type="String"> foreign key</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:Index="2"/>
						<Cell/>
					</Row>
					<Row>
						<Cell ss:StyleID="Optional" ss:Index="2">
							<Data ss:Type="String">text</Data>
						</Cell>
						<Cell>
							<Data ss:Type="String"> external reference</Data>
						</Cell>
					</Row>
					<Row ss:Index="54">
						<Cell ss:StyleID="Specifiable" ss:Index="2">
							<Data ss:Type="String">text</Data>
						</Cell>
						<Cell>
							<Data ss:Type="String"> if specified as required</Data>
						</Cell>
					</Row>
					<Row ss:Index="56">
						<Cell ss:MergeAcross="2">
							<Data ss:Type="String">NOTES:</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:MergeAcross="2">
							<Data ss:Type="String">(1) Regional, owner, or product specific data may be added as new columns to the right of standard template columns.</Data>
						</Cell>
					</Row>
					<Row>
						<Cell ss:MergeAcross="2">
							<Data ss:Type="String">(2) Regional classification schema may be substituted for OmniClass pick lists, used in the United States.</Data>
						</Cell>
					</Row>
					<Row>
						<Cell/>
						<Cell/>
						<Cell/>
					</Row>
					<Row>
						<Cell>
							<Data ss:Type="String">Copyright ERDC (c) 2006-2010</Data>
						</Cell>
					</Row>
				</Table>
			</xsl:element>
			<!--Contact -->
			<xsl:message>Contact</xsl:message>
			<xsl:element name="Worksheet">
				<xsl:attribute name="ss:Name">Contact</xsl:attribute>
				<xsl:element name="Table">
					<!-- create header row  -->
					<xsl:call-template name="contact">
					</xsl:call-template>
					<!-- create data rows -->
					<xsl:for-each select="//ifc:IfcOwnerHistory[not(@ref)]">
						<xsl:message>
							<xsl:text>IfcOwnerHistory</xsl:text>
							<xsl:value-of select="$cln"/>
							<xsl:value-of select="@id"/>
						</xsl:message>
						<xsl:call-template name="contact">
							<xsl:with-param name="mode">Data</xsl:with-param>
						</xsl:call-template>
					</xsl:for-each>
				</xsl:element>
				<xsl:call-template name="freeze"/>
			</xsl:element>
			<!-- Facility -->
			<xsl:message>Facility</xsl:message>
			<xsl:element name="Worksheet">
				<xsl:attribute name="ss:Name">Facility</xsl:attribute>
				<xsl:element name="Table">
					<xsl:call-template name="facility">
					</xsl:call-template>
					<xsl:for-each select="//ifc:IfcBuilding[not(@ref)][1]">
						<xsl:message>
							<xsl:text>IfcBuilding</xsl:text>
							<xsl:value-of select="$cln"/>
							<xsl:value-of select="ifc:Name"/>
						</xsl:message>
						<xsl:call-template name="facility">
							<xsl:with-param name="mode">Data</xsl:with-param>
						</xsl:call-template>
					</xsl:for-each>
				</xsl:element>
				<xsl:call-template name="freeze"/>
			</xsl:element>
			<!-- Floor -->
			<xsl:message>Floor</xsl:message>
			<xsl:element name="Worksheet">
				<xsl:attribute name="ss:Name">Floor</xsl:attribute>
				<xsl:element name="Table">
					<xsl:call-template name="floor">
					</xsl:call-template>
					<xsl:for-each select="//ifc:IfcBuildingStorey[not(@ref)]">
						<xsl:sort order="ascending" data-type="number" select="ifc:Elevation"/>
						<xsl:sort order="ascending" data-type="number" select="ifc:Name"/>
						<xsl:message>
							<xsl:text>IfcBuildingStorey</xsl:text>
							<xsl:value-of select="$cln"/>
							<xsl:value-of select="ifc:Name"/>
						</xsl:message>
						<xsl:call-template name="floor">
							<xsl:with-param name="mode">Data</xsl:with-param>
						</xsl:call-template>
					</xsl:for-each>
				</xsl:element>
				<xsl:call-template name="freeze"/>
			</xsl:element>
			<!-- Space -->
			<xsl:message>Space</xsl:message>
			<xsl:element name="Worksheet">
				<xsl:attribute name="ss:Name">Space</xsl:attribute>
				<xsl:element name="Table">
					<xsl:call-template name="space">
					</xsl:call-template>
					<xsl:for-each select="//ifc:IfcSpace[not(@ref)]">
						<xsl:message>
							<xsl:text>IfcSpace</xsl:text>
							<xsl:value-of select="$cln"/>
							<xsl:value-of select="ifc:Name"/>
						</xsl:message>
						<xsl:call-template name="space">
							<xsl:with-param name="mode">Data</xsl:with-param>
						</xsl:call-template>
					</xsl:for-each>
				</xsl:element>
				<xsl:call-template name="freeze"/>
			</xsl:element>
			<!-- Zone -->
			<xsl:message>Zone</xsl:message>
			<xsl:element name="Worksheet">
				<xsl:attribute name="ss:Name">Zone</xsl:attribute>
				<xsl:element name="Table">
					<xsl:call-template name="zone">
					</xsl:call-template>
					<xsl:for-each select="//ifc:IfcZone[not(@ref)]">
						<xsl:message>
							<xsl:text>IfcZone</xsl:text>
							<xsl:value-of select="$cln"/>
							<xsl:value-of select="ifc:Name"/>
						</xsl:message>
						<xsl:call-template name="zone">
							<xsl:with-param name="mode">Data</xsl:with-param>
						</xsl:call-template>
					</xsl:for-each>
				</xsl:element>
				<xsl:call-template name="freeze"/>
			</xsl:element>
			<!-- Type -->
			<xsl:message>Type</xsl:message>
			<xsl:element name="Worksheet">
				<xsl:attribute name="ss:Name">Type</xsl:attribute>
				<xsl:element name="Table">
					<xsl:call-template name="type">
					</xsl:call-template>
					<xsl:for-each select="//ifc:IfcRelDefinesByType[not(@ref)]/ifc:RelatingType/*">
						<xsl:for-each select="key('find_id',@ref)">
							<xsl:variable name="isAsset">
								<xsl:call-template name="IsAsset"/>
							</xsl:variable>
							<xsl:if test="string-length($isAsset)>0">
								<xsl:variable select="ifc:Name" name="keyname"/>
								<xsl:variable select="local-name()" name="keyid"/>
								<xsl:if test="count(preceding::*[local-name()=$keyid][ifc:Name=$keyname])=0">
									<xsl:message>
										<xsl:value-of select="name()"/>
										<xsl:value-of select="$cln"/>
										<xsl:value-of select="$keyname"/>
									</xsl:message>
									<xsl:call-template name="type">
										<xsl:with-param name="mode">Data</xsl:with-param>
									</xsl:call-template>
								</xsl:if>
							</xsl:if>
						</xsl:for-each>
					</xsl:for-each>
				</xsl:element>
				<xsl:call-template name="freeze"/>
			</xsl:element>
			<!-- Component-->
			<xsl:message>Component</xsl:message>
			<xsl:element name="Worksheet">
				<xsl:attribute name="ss:Name">Component</xsl:attribute>
				<xsl:element name="Table">
					<xsl:call-template name="component">
					</xsl:call-template>
					<xsl:for-each select="//ifc:IfcRelContainedInSpatialStructure/ifc:RelatedElements/*">
						<xsl:variable name="isAsset">
							<xsl:call-template name="IsAssetComponent"/>
						</xsl:variable>
						<xsl:if test="string-length($isAsset)>0">
							<xsl:for-each select="key('find_id',@ref)">
								<xsl:message>
									<xsl:value-of select="name()"/>
									<xsl:value-of select="$cln"/>
									<xsl:value-of select="ifc:Name"/>
								</xsl:message>
								<xsl:call-template name="component">
									<xsl:with-param name="mode">Data</xsl:with-param>
								</xsl:call-template>
							</xsl:for-each>
						</xsl:if>
					</xsl:for-each>
				</xsl:element>
				<xsl:call-template name="freeze"/>
			</xsl:element>
			<!-- System-->
			<xsl:message>System</xsl:message>
			<xsl:element name="Worksheet">
				<xsl:attribute name="ss:Name">System</xsl:attribute>
				<xsl:element name="Table">
					<xsl:call-template name="system">
					</xsl:call-template>
					<xsl:for-each select="//ifc:*[local-name()='IfcSystem' or local-name()='IfcGroup' ][not(@ref)]">
						<xsl:message>
							<xsl:value-of select="name()"/>
							<xsl:value-of select="$cln"/>
							<xsl:value-of select="ifc:Name"/>
						</xsl:message>
						<xsl:call-template name="system">
							<xsl:with-param name="mode">Data</xsl:with-param>
						</xsl:call-template>
					</xsl:for-each>
				</xsl:element>
				<xsl:call-template name="freeze"/>
			</xsl:element>
			<!-- Spare-->
			<xsl:message>Spare</xsl:message>
			<xsl:element name="Worksheet">
				<xsl:attribute name="ss:Name">Spare</xsl:attribute>
				<xsl:element name="Table">
					<xsl:call-template name="spare">
					</xsl:call-template>
					<xsl:for-each select="//ifc:IfcConstructionProductResource[not(@ref)]">
						<xsl:message>
							<xsl:value-of select="name()"/>
							<xsl:value-of select="$cln"/>
							<xsl:value-of select="ifc:Name"/>
						</xsl:message>
						<xsl:call-template name="spare">
							<xsl:with-param name="mode">Data</xsl:with-param>
						</xsl:call-template>
					</xsl:for-each>
				</xsl:element>
				<xsl:call-template name="freeze"/>
			</xsl:element>
			<!-- Resource -->
			<xsl:message>Resource</xsl:message>
			<xsl:element name="Worksheet">
				<xsl:attribute name="ss:Name">Resource</xsl:attribute>
				<xsl:element name="Table">
					<xsl:call-template name="resource">
					</xsl:call-template>
					<xsl:for-each select="//ifc:IfcConstructionEquipmentResource[not(@ref)]">
						<xsl:message>
							<xsl:value-of select="name()"/>
							<xsl:value-of select="$cln"/>
							<xsl:value-of select="ifc:Name"/>
						</xsl:message>
						<xsl:call-template name="resource">
							<xsl:with-param name="mode">Data</xsl:with-param>
						</xsl:call-template>
					</xsl:for-each>
				</xsl:element>
			</xsl:element>
			<!-- Job-->
			<xsl:message>Job</xsl:message>
			<xsl:element name="Worksheet">
				<xsl:attribute name="ss:Name">Job</xsl:attribute>
				<xsl:element name="Table">
					<xsl:call-template name="job">
					</xsl:call-template>
					<xsl:for-each select="//ifc:IfcTask[not(@ref)]">
						<xsl:message>
							<xsl:value-of select="name()"/>
							<xsl:value-of select="$cln"/>
							<xsl:value-of select="ifc:Name"/>
						</xsl:message>
						<xsl:call-template name="job">
							<xsl:with-param name="mode">Data</xsl:with-param>
						</xsl:call-template>
					</xsl:for-each>
				</xsl:element>
			</xsl:element>
			<!-- Document -->
			<xsl:message>Document</xsl:message>
			<xsl:element name="Worksheet">
				<xsl:attribute name="ss:Name">Document</xsl:attribute>
				<xsl:element name="Table">
					<xsl:call-template name="document">
					</xsl:call-template>
					<xsl:for-each select="//ifc:IfcDocumentInformation[not(@ref)]">
						<xsl:message>
							<xsl:value-of select="name()"/>
							<xsl:value-of select="$cln"/>
							<xsl:value-of select="ifc:Name"/>
						</xsl:message>
						<xsl:call-template name="document">
							<xsl:with-param name="mode">Data</xsl:with-param>
						</xsl:call-template>
					</xsl:for-each>
					<!-- if none found, lets create some expected submittals -->
					<xsl:if test="count(//ifc:IfcDocumentInformation[not(@ref)])=0">
						<xsl:for-each select="//ifc:IfcRelDefinesByType[not(@ref)]/ifc:RelatingType/*">
							<xsl:for-each select="key('find_id',@ref)">
								<xsl:variable name="isAsset">
									<xsl:call-template name="IsAsset"/>
								</xsl:variable>
								<xsl:if test="string-length($isAsset)>0">
									<xsl:variable select="ifc:Name" name="keyname"/>
									<xsl:variable select="local-name()" name="keyid"/>
									<xsl:if test="count(preceding::*[local-name()=$keyid][ifc:Name=$keyname])=0">
										<xsl:message>
											<xsl:value-of select="name()"/>
											<xsl:value-of select="$cln"/>
											<xsl:value-of select="$keyname"/>
										</xsl:message>
										<xsl:call-template name="document">
											<xsl:with-param name="mode">Data</xsl:with-param>
										</xsl:call-template>
									</xsl:if>
								</xsl:if>
							</xsl:for-each>
						</xsl:for-each>
					</xsl:if>
					<xsl:call-template name="freeze"/>
				</xsl:element>
			</xsl:element>
			<!-- Attribute -->
			<xsl:message>Attribute</xsl:message>
			<xsl:element name="Worksheet">
				<xsl:attribute name="ss:Name">Attribute</xsl:attribute>
				<xsl:element name="Table">
					<xsl:call-template name="attribute"/>
					<!-- project properties -->
					<xsl:for-each select="//ifc:IfcProject[not(@ref)]">
						<xsl:call-template name="getattributes">
							<xsl:with-param name="sheet1">Facility</xsl:with-param>
							<xsl:with-param select="@id" name="obj1"/>
						</xsl:call-template>
					</xsl:for-each>
					<!-- site properties -->
					<xsl:for-each select="//ifc:IfcSite[not(@ref)]">
						<xsl:call-template name="getattributes">
							<xsl:with-param name="sheet1">Facility</xsl:with-param>
							<xsl:with-param select="@id" name="obj1"/>
						</xsl:call-template>
					</xsl:for-each>
					<!-- building properties -->
					<xsl:for-each select="//ifc:IfcBuilding[not(@ref)]">
						<xsl:call-template name="getattributes">
							<xsl:with-param name="sheet1">Facility</xsl:with-param>
							<xsl:with-param select="@id" name="obj1"/>
						</xsl:call-template>
					</xsl:for-each>
					<!-- floor properties -->
					<xsl:for-each select="//ifc:IfcBuildingStorey[not(@ref)]">
						<xsl:call-template name="getattributes">
							<xsl:with-param name="sheet1">Floor</xsl:with-param>
							<xsl:with-param select="@id" name="obj1"/>
						</xsl:call-template>
					</xsl:for-each>
					<!-- space properties -->
					<xsl:for-each select="//ifc:IfcSpace[not(@ref)]">
						<xsl:call-template name="getattributes">
							<xsl:with-param name="sheet1">Space</xsl:with-param>
							<xsl:with-param select="@id" name="obj1"/>
						</xsl:call-template>
					</xsl:for-each>
					<!-- zone properties -->
					<xsl:for-each select="//ifc:IfcZone[not(@ref)]">
						<xsl:call-template name="getattributes">
							<xsl:with-param name="sheet1">Zone</xsl:with-param>
							<xsl:with-param select="@id" name="obj1"/>
						</xsl:call-template>
					</xsl:for-each>
					<!-- system properties -->
					<xsl:for-each select="//ifc:IfcSystem[not(@ref)]">
						<xsl:call-template name="getattributes">
							<xsl:with-param name="sheet1">System</xsl:with-param>
							<xsl:with-param select="@id" name="obj1"/>
						</xsl:call-template>
					</xsl:for-each>
					<!-- type  and component properties -->
					<xsl:for-each select="//ifc:RelatingType/*">
						<xsl:variable select="@ref" name="k1"/>
						<xsl:variable name="isAsset">
							<xsl:call-template name="IsAsset"/>
						</xsl:variable>
						<xsl:if test="string-length($isAsset)>0">
							<xsl:for-each select="//*[@id=$k1]">
								<xsl:variable select="local-name()" name="keyid"/>
								<xsl:variable select="ifc:Name" name="keyname"/>
								<xsl:if test="count(preceding::*[local-name()=$keyid][ifc:Name=$keyname])=0">
									<xsl:call-template name="getattributes">
										<xsl:with-param name="sheet1">Type</xsl:with-param>
										<xsl:with-param select="@id" name="obj1"/>
									</xsl:call-template>
								</xsl:if>
							</xsl:for-each>
							<xsl:for-each select="../../ifc:RelatedObjects/*">
								<xsl:call-template name="getattributes">
									<xsl:with-param name="sheet1">Component</xsl:with-param>
									<xsl:with-param select="@ref" name="obj1"/>
								</xsl:call-template>
							</xsl:for-each>
						</xsl:if>
					</xsl:for-each>
				</xsl:element>
				<xsl:call-template name="freeze"/>
			</xsl:element>
			<!-- Coordinate -->
			<xsl:message>Coordinate</xsl:message>
			<xsl:element name="Worksheet">
				<xsl:attribute name="ss:Name">Coordinate</xsl:attribute>
				<xsl:element name="Table">
					<xsl:call-template name="coordinate">
					</xsl:call-template>
					<xsl:for-each select="//ifc:IfcBuildingStorey[not(@ref)]">
						<xsl:sort order="ascending" data-type="number" select="ifc:Elevation"/>
						<xsl:sort order="ascending" data-type="number" select="ifc:Name"/>
						<xsl:call-template name="coordinate">
							<xsl:with-param name="mode">Data</xsl:with-param>
							<xsl:with-param name="sheet1">Floor</xsl:with-param>
							<xsl:with-param name="name1" select="ifc:Name"/>
							<xsl:with-param name="corner1">point</xsl:with-param>
						</xsl:call-template>
					</xsl:for-each>
					<xsl:for-each select="//ifc:IfcSpace[not(@ref)]">
						<xsl:sort order="ascending" data-type="number" select="ifc:Name"/>
						<xsl:call-template name="coordinate">
							<xsl:with-param name="mode">Data</xsl:with-param>
							<xsl:with-param name="sheet1">Space</xsl:with-param>
							<xsl:with-param name="name1" select="ifc:Name"/>
							<xsl:with-param name="corner1">box-lowerleft</xsl:with-param>
						</xsl:call-template>
						<xsl:call-template name="coordinate">
							<xsl:with-param name="mode">Data</xsl:with-param>
							<xsl:with-param name="sheet1">Space</xsl:with-param>
							<xsl:with-param name="name1" select="ifc:Name"/>
							<xsl:with-param name="corner1">box-upperright</xsl:with-param>
						</xsl:call-template>
					</xsl:for-each>
					<xsl:for-each select="//ifc:IfcRelContainedInSpatialStructure/ifc:RelatedElements/*">
						<xsl:variable name="isAsset">
							<xsl:call-template name="IsAssetComponent"/>
						</xsl:variable>
						<xsl:if test="string-length($isAsset)>0">
							<xsl:for-each select="key('find_id',@ref)">
								<xsl:call-template name="coordinate">
									<xsl:with-param name="mode">Data</xsl:with-param>
									<xsl:with-param name="sheet1">Component</xsl:with-param>
									<xsl:with-param name="name1" select="ifc:Name"/>
									<xsl:with-param name="corner1">box-lowerleft</xsl:with-param>
								</xsl:call-template>
								<xsl:call-template name="coordinate">
									<xsl:with-param name="mode">Data</xsl:with-param>
									<xsl:with-param name="sheet1">Component</xsl:with-param>
									<xsl:with-param name="name1" select="ifc:Name"/>
									<xsl:with-param name="corner1">box-upperright</xsl:with-param>
								</xsl:call-template>
							</xsl:for-each>
						</xsl:if>
					</xsl:for-each>
				</xsl:element>
				<xsl:call-template name="freeze"/>
			</xsl:element>
			<!-- Connection -->
			<xsl:message>Connection</xsl:message>
			<xsl:element name="Worksheet">
				<xsl:attribute name="ss:Name">Connection</xsl:attribute>
				<xsl:element name="Table">
					<xsl:call-template name="connection">
					</xsl:call-template>
					<xsl:for-each select="//ifc:IfcRelConnectsElements[not(@ref)]">
						<xsl:message>
							<xsl:value-of select="name()"/>
							<xsl:value-of select="$cln"/>
							<xsl:value-of select="ifc:Name"/>
						</xsl:message>
						<xsl:call-template name="connection">
							<xsl:with-param name="mode">Data</xsl:with-param>
						</xsl:call-template>
					</xsl:for-each>
				</xsl:element>
				<xsl:call-template name="freeze"/>
			</xsl:element>
			<!-- Issue -->
			<xsl:message>Issue</xsl:message>
			<xsl:element name="Worksheet">
				<xsl:attribute name="ss:Name">Issue</xsl:attribute>
				<xsl:element name="Table">
					<xsl:call-template name="issue">
					</xsl:call-template>
					<xsl:for-each select="//ifc:IfcApproval[not(@ref)]">
						<xsl:message>
							<xsl:value-of select="name()"/>
							<xsl:value-of select="$cln"/>
							<xsl:value-of select="ifc:Name"/>
						</xsl:message>
						<xsl:call-template name="issue">
							<xsl:with-param name="mode">Data</xsl:with-param>
						</xsl:call-template>
					</xsl:for-each>
				</xsl:element>
				<xsl:call-template name="freeze"/>
			</xsl:element>
			<!-- reference tables not reproduced -->
			<xsl:message>PickLists</xsl:message>
			<xsl:element name="Worksheet">
				<xsl:attribute name="ss:Name">PickLists</xsl:attribute>
				<xsl:element name="Table">
					<xsl:element name="Row">
						<xsl:call-template name="putString">
							<xsl:with-param name="text">Asset model generated by ifcCOBIE2. See COBIE2 documentation for reference tables.</xsl:with-param>
						</xsl:call-template>
					</xsl:element>
				</xsl:element>
			</xsl:element>
			<xsl:message>(Finished)</xsl:message>
		</Workbook>
	</xsl:template>
	<!-- Contact -->
	<xsl:template name="contact">
		<xsl:param name="mode">Header</xsl:param>
		<xsl:comment>
			<xsl:value-of select="@id"/>
		</xsl:comment>
		<xsl:variable name="ou2" select="ifc:OwningUser/*/@ref"/>
		<xsl:variable name="po2" select="//*[@id=$ou2]/ifc:ThePerson/*/@ref"/>
		<xsl:variable name="gn2" select="//*[@id=$po2]/ifc:GivenName"/>
		<xsl:variable name="fn2" select="//*[@id=$po2]/ifc:FamilyName"/>
		<xsl:variable name="oo2" select="//*[@id=$ou2]/ifc:TheOrganization/*/@ref"/>
		<xsl:variable name="org2" select="//*[@id=$oo2]/ifc:Name"/>
		<xsl:variable name="oa2" select="ifc:OwningApplication/*/@ref"/>
		<xsl:variable name="app2" select="//*[@id=$oa2]/ifc:ApplicationFullName"/>
		<xsl:variable name="tel2">
			<xsl:choose>
				<xsl:when test="//*[@id=$po2]/ifc:Addresses/ifc:IfcTelecomAddress/@ref">
					<xsl:value-of select="//*[@id=$po2]/ifc:Addresses/ifc:IfcTelecomAddress/@ref"/>
				</xsl:when>
				<xsl:when test="//*[@id=$oo2]/ifc:Addresses/ifc:IfcTelecomAddress/@ref">
					<xsl:value-of select="//*[@id=$oo2]/ifc:Addresses/ifc:IfcTelecomAddress/@ref"/>
				</xsl:when>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="add2">
			<xsl:choose>
				<xsl:when test="//*[@id=$po2]/ifc:Addresses/ifc:IfcPostalAddress[1]/@ref">
					<xsl:value-of select="//*[@id=$po2]/ifc:Addresses/ifc:IfcPostalAddress[1]/@ref"/>
				</xsl:when>
				<xsl:when test="//*[@id=$oo2]/ifc:Addresses/ifc:IfcPostalAddress[1]/@ref">
					<xsl:value-of select="//*[@id=$oo2]/ifc:Addresses/ifc:IfcPostalAddress[1]/@ref"/>
				</xsl:when>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="rol2">
			<xsl:choose>
				<xsl:when test="//*[@id=$po2]/ifc:Roles/ifc:IfcActorRole/@ref">
					<xsl:value-of select="//*[@id=$po2]/ifc:Roles/ifc:IfcActorRole/@ref"/>
				</xsl:when>
				<xsl:when test="//*[@id=$oo2]/ifc:Roles/ifc:IfcActorRole/@ref">
					<xsl:value-of select="//*[@id=$oo2]/ifc:Roles/ifc:IfcActorRole/@ref"/>
				</xsl:when>
			</xsl:choose>
		</xsl:variable>
		<!-- create cell, with information about style required -->
		<xsl:variable name="per2">
			<xsl:call-template name="nav">
				<xsl:with-param name="text">
					<xsl:value-of select="$gn2"/>
					<xsl:text> </xsl:text>
					<xsl:value-of select="$fn2"/>
				</xsl:with-param>
			</xsl:call-template>
		</xsl:variable>
		<xsl:variable name="email2">
			<xsl:call-template name="makeEmail">
				<xsl:with-param select="@id" name="oh1"/>
			</xsl:call-template>
		</xsl:variable>
		<!-- create row -->
		<xsl:element name="Row">
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="typing">email</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<!-- heading wording -->
						<xsl:when test="$mode='Header'">Email</xsl:when>
						<!-- data wording -->
						<xsl:otherwise>
							<xsl:value-of select="$email2"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailEnd">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="oh1" select="$oh0"/>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<!-- map to Omniclass -->
					<xsl:choose>
						<xsl:when test="$mode='Header'">Category</xsl:when>
						<xsl:when test="string-length($rol2)>0">
							<xsl:value-of select="//*[@id=$rol2]/ifc:Role"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Company</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$org2"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Phone</xsl:when>
						<xsl:when test="string-length($tel2)>0">
							<xsl:value-of select="//*[@id=$tel2]/ifc:TelephoneNumbers[1]/*"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Optional</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">ExternalSystem</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$app2"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Optional</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">ExternalObject</xsl:when>
						<xsl:otherwise>
							<xsl:text>IfcPersonAndOrganization</xsl:text>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Optional</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">ExternalIdentifier</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$email2"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Department</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$org2"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">OrganizationCode</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$org2"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">GivenName</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$gn2"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">FamilyName</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$fn2"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Street</xsl:when>
						<xsl:when test="string-length($add2)>0">
							<xsl:value-of select="//*[@id=$add2]/ifc:AddressLines/*"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">PostalBox</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Town</xsl:when>
						<xsl:when test="string-length($add2)>0">
							<xsl:value-of select="//*[@id=$add2]/ifc:Town"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">StateRegion</xsl:when>
						<xsl:when test="string-length($add2)>0">
							<xsl:value-of select="//*[@id=$add2]/ifc:Region"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">PostalCode</xsl:when>
						<xsl:when test="string-length($add2)>0">
							<xsl:value-of select="//*[@id=$add2]/ifc:PostalCode"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Country</xsl:when>
						<xsl:when test="string-length($add2)>0">
							<xsl:value-of select="//*[@id=$add2]/ifc:Country"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
		</xsl:element>
	</xsl:template>
	<!-- Facility -->
	<xsl:template name="facility">
		<xsl:param name="mode">Header</xsl:param>
		<xsl:comment>
			<xsl:value-of select="@id"/>
		</xsl:comment>
		<xsl:element name="Row">
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Name</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Name"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailEnd">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="oh1" select="ifc:OwnerHistory/ifc:IfcOwnerHistory[1]/@ref"/>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Category</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getClassification"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
				<xsl:with-param name="alternative">
					<xsl:value-of select="ifc:ObjectType"/>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">ProjectName</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$doc"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">SiteName</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$doc1"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">LinearUnits</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$unt"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">AreaUnits</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$unt2"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">VolumeUnits</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$unt3"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">CurrencyUnits</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$cur"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">AreaMeasurement</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="//ifc:IfcElementQuantity[string-length(ifc:MethodOfMeasurement)>0]/ifc:MethodOfMeasurement"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Optional</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">ExternalSystem</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$app"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Optional</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">ExternalProjectObject</xsl:when>
						<xsl:otherwise>
							<xsl:text>IfcProject</xsl:text>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Optional</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">ExternalProjectIdentifier</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="//ifc:IfcProject/ifc:GlobalId"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<!-- site -->
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Optional</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">ExternalSiteObject</xsl:when>
						<xsl:otherwise>
							<xsl:text>IfcSite</xsl:text>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Optional</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">ExternalSiteIdentifier</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="//ifc:IfcSite/ifc:GlobalId"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<!-- facility -->
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Optional</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">ExternalFacilityObject</xsl:when>
						<xsl:otherwise>
							<xsl:text>IfcBuilding</xsl:text>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Optional</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">ExternalFacilityIdentifier</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:GlobalId"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Description</xsl:when>
						<xsl:when test="ifc:LongName">
							<xsl:value-of select="ifc:LongName"/>
						</xsl:when>
						<xsl:when test="ifc:Description">
							<xsl:value-of select="ifc:Description"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Name"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">ProjectDescription</xsl:when>
						<xsl:when test="//ifc:IfcProject[not(@ref)][1]/ifc:LongName">
							<xsl:value-of select="//ifc:IfcProject[not(@ref)][1]/ifc:LongName"/>
						</xsl:when>
						<xsl:when test="//ifc:IfcProject[not(@ref)][1]/ifc:Description">
							<xsl:value-of select="//ifc:IfcProject[not(@ref)][1]/ifc:Description"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="//ifc:IfcProject[not(@ref)][1]/ifc:Name"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">SiteDescription</xsl:when>
						<xsl:when test="//ifc:IfcSite[not(@ref)][1]/ifc:LongName">
							<xsl:value-of select="//ifc:IfcSite[not(@ref)][1]/ifc:LongName"/>
						</xsl:when>
						<xsl:when test="//ifc:IfcSite[not(@ref)][1]/ifc:Description">
							<xsl:value-of select="//ifc:IfcSite[not(@ref)][1]/ifc:Description"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="//ifc:IfcSite[not(@ref)][1]/ifc:Name"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Phase</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="//ifc:IfcProject[not(@ref)][1]/ifc:Phase"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
		</xsl:element>
	</xsl:template>
	<!-- Floor -->
	<xsl:template name="floor">
		<xsl:param name="mode">Header</xsl:param>
		<xsl:variable name="k1" select="@id"/>
		<xsl:comment>
			<xsl:value-of select="@id"/>
		</xsl:comment>
		<xsl:element name="Row">
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Name</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Name"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailEnd">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="oh1" select="ifc:OwnerHistory/*[1]/@ref"/>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Category</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getClassification"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailExternal">
				<xsl:with-param name="mode" select="$mode"/>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Description</xsl:when>
						<xsl:when test="ifc:LongName">
							<xsl:value-of select="ifc:LongName"/>
						</xsl:when>
						<xsl:when test="ifc:Description">
							<xsl:value-of select="ifc:Description"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Name"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="typing">number</xsl:with-param>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Elevation</xsl:when>
						<xsl:when test="ifc:Elevation">
							<xsl:value-of select="format-number(normalize-space(ifc:Elevation),'0.000')"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="typing">number</xsl:with-param>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Height</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getProperty">
								<xsl:with-param name="pName">NominalHeight</xsl:with-param>
								<xsl:with-param name="altpName">Height</xsl:with-param>
							</xsl:call-template>
							<!--	<xsl:value-of select="((following::ifc:IfcBuildingStorey/ifc:Elevation)-(ifc:Elevation)) "/>  -->
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<!--
			<xsl:choose>
				<xsl:when test="$mode='Header'">
					<xsl:call-template name="putString">
						<xsl:with-param name="mode" select="$mode"/>
						<xsl:with-param name="shade">Specifiable</xsl:with-param>
						<xsl:with-param name="text">Height</xsl:with-param>
					</xsl:call-template>
				</xsl:when>
				<xsl:otherwise>
					<xsl:call-template name="putFormula">
						<xsl:with-param name="shade">Specifiable</xsl:with-param>
						<xsl:with-param name="text">MAX(R[1]C[-1]-R[0]C[-1],0)</xsl:with-param>
					</xsl:call-template>
				</xsl:otherwise>
			</xsl:choose>
-->
		</xsl:element>
	</xsl:template>
	<!-- Space -->
	<xsl:template name="space">
		<xsl:param name="mode">Header</xsl:param>
		<xsl:variable name="k1" select="@id"/>
		<xsl:comment>
			<xsl:value-of select="@id"/>
		</xsl:comment>
		<xsl:element name="Row">
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Name</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Name"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailEnd">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="oh1" select="ifc:OwnerHistory/*[1]/@ref"/>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<!-- map to Omniclass -->
					<xsl:choose>
						<xsl:when test="$mode='Header'">Category</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getClassification"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
				<xsl:with-param name="alternative">
					<xsl:value-of select="ifc:ObjectType"/>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Reference</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">FloorName</xsl:when>
						<xsl:otherwise>
							<xsl:for-each select="//ifc:IfcSpace[@ref=$k1]/../../ifc:RelatingObject/ifc:IfcBuildingStorey">
								<xsl:variable name="k2" select="@ref"/>
								<xsl:for-each select="//ifc:IfcBuildingStorey[not(@ref)]">
									<xsl:if test="@id=$k2">
										<xsl:value-of select="ifc:Name"/>
									</xsl:if>
								</xsl:for-each>
							</xsl:for-each>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
				<xsl:with-param name="alternative">
					<xsl:value-of select="$na"/>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Description</xsl:when>
						<xsl:when test="ifc:LongName">
							<xsl:value-of select="ifc:LongName"/>
						</xsl:when>
						<xsl:when test="ifc:Description">
							<xsl:value-of select="ifc:Description"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Name"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailExternal">
				<xsl:with-param name="mode" select="$mode"/>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<!-- map to Omniclass -->
					<xsl:choose>
						<xsl:when test="$mode='Header'">RoomTag</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Description"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="typing">number</xsl:with-param>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">UsableHeight</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getProperty">
								<xsl:with-param name="pName">FinishCeilingHeight</xsl:with-param>
								<xsl:with-param name="altpName">Height</xsl:with-param>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
				<xsl:with-param name="alternative">
					<xsl:call-template name="getProperty">
						<xsl:with-param name="pName">SpaceUsableHeight</xsl:with-param>
						<xsl:with-param name="altpName">Ceiling Height</xsl:with-param>
					</xsl:call-template>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="typing">number</xsl:with-param>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">GrossArea</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getProperty">
								<xsl:with-param name="pName">GrossFloorArea</xsl:with-param>
								<xsl:with-param name="altpName">GSA</xsl:with-param>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="typing">number</xsl:with-param>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">NetArea</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getProperty">
								<xsl:with-param name="pName">NetFloorArea</xsl:with-param>
								<xsl:with-param name="altpName">GSA</xsl:with-param>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
		</xsl:element>
	</xsl:template>
	<!-- Zone -->
	<xsl:template name="zone">
		<xsl:param name="mode">Header</xsl:param>
		<xsl:variable name="k1" select="@id"/>
		<xsl:comment>
			<xsl:value-of select="@id"/>
		</xsl:comment>
		<xsl:element name="Row">
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Name</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Name"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailEnd">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="oh1" select="ifc:OwnerHistory/*[1]/@ref"/>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Category</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getClassification"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
				<xsl:with-param name="alternative">
					<xsl:value-of select="ifc:ObjectType"/>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Reference</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">SpaceNames</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getList"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailExternal">
				<xsl:with-param name="mode" select="$mode"/>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Description</xsl:when>
						<xsl:when test="ifc:Description">
							<xsl:value-of select="ifc:Description"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Name"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
		</xsl:element>
	</xsl:template>
	<!-- Type -->
	<xsl:template name="type">
		<xsl:param name="mode">Header</xsl:param>
		<xsl:param name="uid1">1</xsl:param>
		<xsl:variable name="k1" select="@id"/>
		<xsl:comment>
			<xsl:value-of select="@id"/>
		</xsl:comment>
		<xsl:element name="Row">
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Name</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Name"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailEnd">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="oh1" select="ifc:OwnerHistory/*[1]/@ref"/>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Category</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getClassification"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
				<xsl:with-param name="alternative">
					<xsl:value-of select="ifc:ObjectType"/>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Description</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Name"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">AssetType</xsl:when>
						<xsl:when test="local-name()='IfcFurnitureType' ">Moveable</xsl:when>
						<xsl:otherwise>Fixed</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="typing">email</xsl:with-param>
				<xsl:with-param name="shade">Reference</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Manufacturer</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getProperty">
								<xsl:with-param name="pName">Manufacturer</xsl:with-param>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">ModelNumber</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getProperty">
								<xsl:with-param name="pName">ArticleNumber</xsl:with-param>
								<xsl:with-param name="altpName">ModelLabel</xsl:with-param>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="typing">email</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">WarrantyGuarantorParts</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getProperty">
								<xsl:with-param name="pName">WarrantyGuarantorParts</xsl:with-param>
								<xsl:with-param name="altpName">PartsWarrantyGuarantor</xsl:with-param>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<!--
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">PartsWarrantyStartDate</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getProperty">
								<xsl:with-param name="pName">WarrantyStartDate</xsl:with-param>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
           -->
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="typing">number</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">WarrantyDurationParts</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getProperty">
								<xsl:with-param name="pName">WarrantyDurationParts</xsl:with-param>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="typing">email</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">WarrantyGuarantorLabor</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getProperty">
								<xsl:with-param name="pName">WarrantyGuarantorLabor</xsl:with-param>
								<xsl:with-param name="altpName">LaborWarrantyGuarantor</xsl:with-param>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="typing">number</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">WarrantyDurationLabor</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getProperty">
								<xsl:with-param name="pName">WarrantyDurationLabor</xsl:with-param>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">WarrantyDurationUnit</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$timeunit"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<!--
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">LaborWarrantyStartDate</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getProperty">
								<xsl:with-param name="pName">WarrantyStartDate</xsl:with-param>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">LaborWarrantyEndDate</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getProperty">
								<xsl:with-param name="pName">WarrantyEndDate</xsl:with-param>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
            -->
			<xsl:call-template name="tailExternal">
				<xsl:with-param name="mode" select="$mode"/>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="typing">number</xsl:with-param>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">ReplacementCost</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getProperty">
								<xsl:with-param name="pName">Replacement</xsl:with-param>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="typing">number</xsl:with-param>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">ExpectedLife</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getProperty">
								<xsl:with-param name="pName">Expected</xsl:with-param>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">DurationUnit</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$lif"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">WarrantyDescription</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="substring(name(),4)"/>
							<xsl:if test="ifc:PredefinedType">
								<xsl:text> </xsl:text>
								<xsl:value-of select="ifc:PredefinedType"/>
							</xsl:if>
							<xsl:if test="ifc:ElementType">
								<xsl:text> </xsl:text>
								<xsl:value-of select="ifc:ElementType"/>
							</xsl:if>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
		</xsl:element>
	</xsl:template>
	<!-- Component -->
	<xsl:template name="component">
		<xsl:param name="mode">Header</xsl:param>
		<xsl:param name="uid1">1</xsl:param>
		<xsl:variable name="k1" select="@id"/>
		<xsl:comment>
			<xsl:value-of select="@id"/>
		</xsl:comment>
		<xsl:element name="Row">
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Name</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Name"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailEnd">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="oh1" select="ifc:OwnerHistory/*[1]/@ref"/>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Reference</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">TypeName</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getRegister">
								<xsl:with-param name="cid" select="@id"/>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Reference</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Space</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getSpace">
								<xsl:with-param name="cid" select="@id"/>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Description</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Description"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
				<xsl:with-param name="alternative">
					<xsl:value-of select="substring(name(),4)"/>
					<xsl:if test="ifc:PredefinedType">
						<xsl:text> </xsl:text>
						<xsl:value-of select="ifc:PredefinedType"/>
					</xsl:if>
					<xsl:if test="ifc:ElementType">
						<xsl:text> </xsl:text>
						<xsl:value-of select="ifc:ElementType"/>
					</xsl:if>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailExternal">
				<xsl:with-param name="mode" select="$mode"/>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">SerialNumber</xsl:when>
						<xsl:otherwise>
							<xsl:text>n/a</xsl:text>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="typing">date</xsl:with-param>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">InstallationDate</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getProperty">
								<xsl:with-param name="pName">InstallationDate</xsl:with-param>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="typing">date</xsl:with-param>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">WarrantyStartDate</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getProperty">
								<xsl:with-param name="pName">WarrantyStartDate</xsl:with-param>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">TagNumber</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getProperty">
								<xsl:with-param name="pName">Tag</xsl:with-param>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">BarCode</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getProperty">
								<xsl:with-param name="pName">Bar</xsl:with-param>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">AssetIdentifier</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getProperty">
								<xsl:with-param name="pName">Identifier</xsl:with-param>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
		</xsl:element>
	</xsl:template>
	<!-- System -->
	<xsl:template name="system">
		<xsl:param name="mode">Header</xsl:param>
		<xsl:variable name="k1" select="@id"/>
		<xsl:comment>
			<xsl:value-of select="@id"/>
		</xsl:comment>
		<xsl:element name="Row">
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Name</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Name"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailEnd">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="oh1" select="ifc:OwnerHistory/*[1]/@ref"/>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Category</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getClassification"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
				<xsl:with-param name="alternative">
					<xsl:value-of select="ifc:ObjectType"/>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Reference</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">ComponentNames</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getList"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailExternal">
				<xsl:with-param name="mode" select="$mode"/>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Description</xsl:when>
						<xsl:when test="ifc:Description">
							<xsl:value-of select="ifc:Description"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Name"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
		</xsl:element>
	</xsl:template>
	<!-- Spare -->
	<xsl:template name="spare">
		<xsl:param name="mode">Header</xsl:param>
		<xsl:param name="uid1">1</xsl:param>
		<xsl:comment>
			<xsl:value-of select="@id"/>
		</xsl:comment>
		<xsl:variable select="@id" name="me"/>
		<xsl:element name="Row">
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Name</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Name"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailEnd">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="oh1" select="ifc:OwnerHistory/*[1]/@ref"/>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Category</xsl:when>
						<xsl:otherwise>
							<xsl:text>SpareSet</xsl:text>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Reference</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">TypeName</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="nav">
								<xsl:with-param name="text">
									<xsl:for-each select="//ifc:IfcRelAssignsToResource">
										<xsl:for-each select="ifc:RelatingResource/*[$me=@ref]">
											<xsl:variable name="tid1" select="../../ifc:RelatedObjects/*[1]/@ref"/>
											<xsl:value-of select="//*[@id=$tid1]/ifc:Name"/>
										</xsl:for-each>
									</xsl:for-each>
								</xsl:with-param>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="typing">email</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Suppliers</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailExternal">
				<xsl:with-param name="mode" select="$mode"/>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Description</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Description"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">SetNumber</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">PartNumber</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
		</xsl:element>
	</xsl:template>
	<!-- Resource  -->
	<xsl:template name="resource">
		<xsl:param name="mode">Header</xsl:param>
		<xsl:comment>
			<xsl:value-of select="@id"/>
		</xsl:comment>
		<xsl:element name="Row">
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Name</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Name"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailEnd">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="oh1" select="ifc:OwnerHistory/*[1]/@ref"/>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Category</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:ObjectType"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailExternal">
				<xsl:with-param name="mode" select="$mode"/>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Description</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Description"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
		</xsl:element>
	</xsl:template>
	<!-- Job -->
	<xsl:template name="job">
		<xsl:param name="mode">Header</xsl:param>
		<xsl:comment>
			<xsl:value-of select="@id"/>
		</xsl:comment>
		<xsl:variable select="@id" name="me"/>
		<xsl:element name="Row">
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Name</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Name"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailEnd">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="oh1" select="ifc:OwnerHistory/*[1]/@ref"/>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Category</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:ObjectType"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Status</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Status"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Reference</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">TypeName</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="nav">
								<xsl:with-param name="text">
									<xsl:for-each select="//ifc:IfcRelAssignsToProcess">
										<xsl:for-each select="ifc:RelatingProcess/*[$me=@ref]/../../ifc:RelatedObjects/*[not(local-name()='IfcConstructionEquipmentResource')]">
											<xsl:variable name="tid1" select="@ref"/>
											<xsl:value-of select="//*[@id=$tid1]/ifc:Name"/>
										</xsl:for-each>
									</xsl:for-each>
								</xsl:with-param>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Description</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Description"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="typing">number</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Duration</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getProperty">
								<xsl:with-param name="pName">TaskDuration</xsl:with-param>
								<xsl:with-param name="altpName">TaskDuration</xsl:with-param>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">DurationUnit</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$timeunit2"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="typing">date</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Start</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getProperty">
								<xsl:with-param name="pName">TaskStartDate</xsl:with-param>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">TaskStartUnit</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="typing">number</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Frequency</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="getProperty">
								<xsl:with-param name="pName">TaskInterval</xsl:with-param>
								<xsl:with-param name="altpName">TaskInterval</xsl:with-param>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">FrequencyUnit</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$timeunit"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailExternal">
				<xsl:with-param name="mode" select="$mode"/>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">TaskNumber</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:TaskId"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Priors</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">ResourceNames</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="nav">
								<xsl:with-param name="text">
									<xsl:for-each select="//ifc:IfcRelAssignsToProcess">
										<xsl:for-each select="ifc:RelatingProcess/*[$me=@ref]/../../ifc:RelatedObjects/*[local-name()='IfcConstructionEquipmentResource']">
											<xsl:variable name="tid1" select="@ref"/>
											<xsl:value-of select="//*[@id=$tid1]/ifc:Name"/>
											<xsl:text>,</xsl:text>
										</xsl:for-each>
									</xsl:for-each>
								</xsl:with-param>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
		</xsl:element>
	</xsl:template>
	<!-- Document -->
	<xsl:template name="document">
		<xsl:param name="mode">Header</xsl:param>
		<xsl:comment>
			<xsl:value-of select="@id"/>
		</xsl:comment>
		<xsl:element name="Row">
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Name</xsl:when>
						<xsl:when test="name()='IfcDocumentInformation'">
							<xsl:value-of select="ifc:Name"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Name"/>
							<xsl:text> Product Data</xsl:text>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailEnd">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="oh1" select="ifc:OwnerHistory/*[1]/@ref"/>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Category</xsl:when>
						<xsl:when test="name()='IfcDocumentInformation'">
							<xsl:value-of select="ifc:Purpose"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:text>Product Data</xsl:text>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">ApprovalBy</xsl:when>
						<xsl:otherwise>
							<xsl:text>Information Only</xsl:text>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Stage</xsl:when>
						<xsl:otherwise>
							<xsl:text>Requirement</xsl:text>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Reference</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">SheetName</xsl:when>
						<xsl:when test="name()='IfcDocumentInformation'">
							<xsl:value-of select="$na"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:text>Type</xsl:text>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Reference</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">RowName</xsl:when>
						<xsl:when test="name()='IfcDocumentInformation'">
							<xsl:value-of select="$na"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Name"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Directory</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">File</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailExternal">
				<xsl:with-param name="mode" select="$mode"/>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Description</xsl:when>
						<xsl:when test="name()='IfcDocumentInformation'">
							<xsl:value-of select="$na"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Description"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Reference</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
		</xsl:element>
	</xsl:template>
	<!-- Attribute -->
	<xsl:template name="attribute">
		<xsl:param name="mode">Header</xsl:param>
		<xsl:param name="sheet1"/>
		<xsl:param name="name1"/>
		<xsl:variable name="k1" select="@id"/>
		<xsl:if test="not(name()='Name') and  not(name()='Description') and  not(name()='LongName') and  not(name()='GlobalId') and  not(name()='CompositionType') and  not(name()='UsageName') ">
			<xsl:comment>
				<xsl:value-of select="@id"/>
			</xsl:comment>
			<xsl:if test="$mode='Data'">
				<xsl:message>
					<xsl:text>IfcAttribute</xsl:text>
					<xsl:value-of select="$cln"/>
					<xsl:value-of select="$sheet1"/>
					<xsl:value-of select="$cln"/>
					<xsl:value-of select="$name1"/>
					<xsl:value-of select="$cln"/>
					<xsl:choose>
						<xsl:when test="ifc:Name">
							<xsl:value-of select="ifc:Name"/>
							<xsl:value-of select="$cln"/>
							<xsl:value-of select="ifc:NominalValue"/>
							<xsl:value-of select="ifc:EnumerationValues/*[1]"/>
							<xsl:value-of select="ifc:AreaValue"/>
							<xsl:value-of select="ifc:VolumeValue"/>
							<xsl:value-of select="ifc:LengthValue"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="name()"/>
							<xsl:value-of select="$cln"/>
							<xsl:value-of select="."/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:message>
			</xsl:if>
			<xsl:element name="Row">
				<xsl:call-template name="putString">
					<xsl:with-param name="mode" select="$mode"/>
					<xsl:with-param name="text">
						<xsl:choose>
							<xsl:when test="$mode='Header'">Name</xsl:when>
							<xsl:when test="ifc:Name">
								<xsl:value-of select="ifc:Name"/>
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="name()"/>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:with-param>
				</xsl:call-template>
				<xsl:call-template name="tailEnd">
					<xsl:with-param name="mode" select="$mode"/>
					<xsl:with-param name="oh1" select="$oh0"/>
				</xsl:call-template>
				<xsl:call-template name="putString">
					<xsl:with-param name="mode" select="$mode"/>
					<xsl:with-param name="text">
						<xsl:choose>
							<xsl:when test="$mode='Header'">Category</xsl:when>
							<xsl:otherwise>
								<xsl:text>Requirement</xsl:text>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:with-param>
				</xsl:call-template>
				<xsl:call-template name="putString">
					<xsl:with-param name="mode" select="$mode"/>
					<xsl:with-param name="shade">Reference</xsl:with-param>
					<xsl:with-param name="text">
						<xsl:choose>
							<xsl:when test="$mode='Header'">SheetName</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="$sheet1"/>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:with-param>
				</xsl:call-template>
				<xsl:call-template name="putString">
					<xsl:with-param name="mode" select="$mode"/>
					<xsl:with-param name="shade">Reference</xsl:with-param>
					<xsl:with-param name="text">
						<xsl:choose>
							<xsl:when test="$mode='Header'">RowName</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="$name1"/>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:with-param>
				</xsl:call-template>
				<xsl:call-template name="putString">
					<xsl:with-param name="mode" select="$mode"/>
					<xsl:with-param name="typing">number</xsl:with-param>
					<xsl:with-param name="text">
						<xsl:choose>
							<xsl:when test="$mode='Header'">Value</xsl:when>
							<xsl:when test="ifc:NominalValue">
								<xsl:value-of select="ifc:NominalValue"/>
							</xsl:when>
							<xsl:when test="ifc:EnumerationValues/*[1]">
								<xsl:value-of select="ifc:EnumerationValues/*[1]"/>
							</xsl:when>
							<xsl:when test="ifc:AreaValue">
								<xsl:value-of select="format-number(normalize-space(ifc:AreaValue),'0.000')"/>
							</xsl:when>
							<xsl:when test="ifc:VolumeValue">
								<xsl:value-of select="format-number(normalize-space(ifc:VolumeValue),'0.000')"/>
							</xsl:when>
							<xsl:when test="ifc:LengthValue">
								<xsl:value-of select="format-number(normalize-space(ifc:LengthValue),'0.000')"/>
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="."/>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:with-param>
				</xsl:call-template>
				<xsl:call-template name="putString">
					<xsl:with-param name="mode" select="$mode"/>
					<xsl:with-param name="text">
						<xsl:choose>
							<xsl:when test="$mode='Header'">Unit</xsl:when>
							<xsl:when test="./ifc:LengthValue">
								<xsl:value-of select="$unt"/>
							</xsl:when>
							<xsl:when test="./ifc:AreaValue">
								<xsl:value-of select="$unt2"/>
							</xsl:when>
							<xsl:when test="./ifc:VolumeValue">
								<xsl:value-of select="$unt3"/>
							</xsl:when>
							<xsl:when test="./ifc:CostValue">
								<xsl:value-of select="$cur"/>
							</xsl:when>
							<xsl:when test="(name()='Elevation') or(name()='OverallHeight') or(name()='OverallWidth') or(name()='ElevationWithFlooring') or(name()='FrameDepth') or(name()='FrameThickness') or(name()='LiningDepth') or(name()='LiningThickness')">
								<xsl:value-of select="$unt"/>
							</xsl:when>
							<xsl:when test="./ifc:Unit">
								<xsl:value-of select="key('find_id',ifc:Unit/*[1]/@ref)/ifc:Name"/>
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="$na"/>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:with-param>
				</xsl:call-template>
				<xsl:choose>
					<xsl:when test="$mode='Header'">
						<xsl:call-template name="tailExternal">
							<xsl:with-param name="mode" select="$mode"/>
						</xsl:call-template>
					</xsl:when>
					<xsl:when test="ifc:Name">
						<xsl:call-template name="tailExternal">
							<xsl:with-param name="mode" select="$mode"/>
						</xsl:call-template>
					</xsl:when>
					<xsl:otherwise>
						<xsl:for-each select="..">
							<xsl:call-template name="tailExternal">
								<xsl:with-param name="mode" select="$mode"/>
							</xsl:call-template>
						</xsl:for-each>
					</xsl:otherwise>
				</xsl:choose>
				<xsl:call-template name="putString">
					<xsl:with-param name="mode" select="$mode"/>
					<xsl:with-param name="shade">Specifiable</xsl:with-param>
					<xsl:with-param name="text">
						<xsl:choose>
							<xsl:when test="$mode='Header'">Description</xsl:when>
							<xsl:when test="ifc:Description">
								<xsl:value-of select="ifc:Description"/>
							</xsl:when>
							<xsl:when test="ifc:Name">
								<xsl:value-of select="ifc:Name"/>
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="name()"/>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:with-param>
				</xsl:call-template>
			</xsl:element>
		</xsl:if>
	</xsl:template>
	<!-- Coordinate -->
	<xsl:template name="coordinate">
		<xsl:param name="mode">Header</xsl:param>
		<xsl:param name="sheet1">Space</xsl:param>
		<xsl:param name="name1" select="ifc:Name"/>
		<xsl:param name="corner1">point</xsl:param>
		<xsl:variable name="k1" select="@id"/>
		<xsl:comment>
			<xsl:value-of select="@id"/>
		</xsl:comment>
		<xsl:if test="not($mode='Header')">
			<xsl:message>
				<xsl:text>IfcCartesianPoint3D</xsl:text>
				<xsl:value-of select="$cln"/>
				<xsl:value-of select="name()"/>
				<xsl:value-of select="$cln"/>
				<xsl:value-of select="ifc:Name"/>
			</xsl:message>
		</xsl:if>
		<xsl:variable select="key('find_id',ifc:ObjectPlacement/*/@ref)/ifc:RelativePlacement/*/@ref" name="apd1"/>
		<xsl:variable select="key('find_id',$apd1)/ifc:Location/*/@ref" name="cp1"/>
		<xsl:variable name="x1" select="key('find_id',$cp1)/*/*[1]"/>
		<xsl:variable name="y1" select="key('find_id',$cp1)/*/*[2]"/>
		<xsl:variable name="z1" select="key('find_id',$cp1)/*/*[3]"/>
		<!-- ObjectRepresentation ifcProductDefinitionShape -->
		<!-- Representations IfcShapeRepresentation (many) -->
		<!-- Items IfcExtrudedAreaSolid or IfcBoundingBox-->
		<!-- XDim YDim ZDim -->
		<xsl:variable select="key('find_id',ifc:Representation/*/@ref)/ifc:Representations/*[1]/@ref" name="rep1"/>
		<xsl:variable select="key('find_id',$rep1)/ifc:Items/*[1]/@ref" name="cp2"/>
		<xsl:variable name="x2" select="key('find_id',$cp2)/ifc:XDim"/>
		<xsl:variable name="y2" select="key('find_id',$cp2)/ifc:YDim"/>
		<xsl:variable name="z2" select="key('find_id',$cp2)/ifc:ZDim"/>
		<xsl:variable select="key('find_id',$cp2)/ifc:SweptArea/*[1]/@ref" name="cp3"/>
		<xsl:variable name="x3" select="key('find_id',$cp3)/ifc:XDim"/>
		<xsl:variable name="y3" select="key('find_id',$cp3)/ifc:YDim"/>
		<xsl:variable name="z3" select="key('find_id',$cp2)/ifc:Depth"/>
		<xsl:variable select="key('find_id',$cp3)/ifc:Position/*[1]/@ref" name="ck"/>
		<xsl:variable select="key('find_id',$ck)/ifc:Location/*[1]/@ref" name="cp4"/>
		<xsl:variable name="x4" select="key('find_id',$cp4)/*/*[1]"/>
		<xsl:variable name="y4" select="key('find_id',$cp4)/*/*[2]"/>
		<xsl:variable name="z4" select="key('find_id',$cp4)/*/*[3]"/>
		<xsl:variable name="xx1">
			<xsl:choose>
				<xsl:when test="not($x1) or $x1='' or number($x1)='NaN'">0</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$x1"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="xx2">
			<xsl:choose>
				<xsl:when test="not($x2) or $x2='' or number($x2)='NaN'">0</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$x2"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="xx3">
			<xsl:choose>
				<xsl:when test="not($x3) or $x3='' or number($x3)='NaN'">0</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$x3"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="xx4">
			<xsl:choose>
				<xsl:when test="not($x4) or $x4='' or number($x4)='NaN'">0</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$x4"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="yy1">
			<xsl:choose>
				<xsl:when test="not($y1) or $y1='' or number($y1)='NaN'">0</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$y1"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="yy2">
			<xsl:choose>
				<xsl:when test="not($y2) or $y2='' or number($y2)='NaN'">0</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$y2"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="yy3">
			<xsl:choose>
				<xsl:when test="not($y3) or $y3='' or number($y3)='NaN'">0</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$y3"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="yy4">
			<xsl:choose>
				<xsl:when test="not($y4) or $y4='' or number($y4)='NaN'">0</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$y4"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="zz1">
			<xsl:choose>
				<xsl:when test="not($z1) or $z1='' or number($z1)='NaN'">0</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$z1"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="zz2">
			<xsl:choose>
				<xsl:when test="not($z2) or $z2='' or number($z2)='NaN'">0</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$z2"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="zz3">
			<xsl:choose>
				<xsl:when test="not($z3) or $z3='' or number($z3)='NaN'">0</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$z3"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="zz4">
			<xsl:choose>
				<xsl:when test="not($z4) or $z4='' or number($z4)='NaN'">0</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$z4"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:if test="not($mode='Header')">
			<xsl:message>
				<xsl:text>IfcCartesianPoint 1</xsl:text>
				<xsl:value-of select="$cln"/>
				<xsl:value-of select="name()"/>
				<xsl:value-of select="$cln"/>
				<xsl:value-of select="ifc:Name"/>
				<xsl:text> apd1 </xsl:text>
				<xsl:value-of select="$apd1"/>
				<xsl:text> cp1 </xsl:text>
				<xsl:value-of select="$cp1"/>
				<xsl:text> x1 </xsl:text>
				<xsl:value-of select="$xx1"/>
				<xsl:text> y1 </xsl:text>
				<xsl:value-of select="$yy1"/>
				<xsl:text> z1 </xsl:text>
				<xsl:value-of select="$zz1"/>
			</xsl:message>
		</xsl:if>
		<xsl:if test="not($mode='Header')">
			<xsl:message>
				<xsl:text>IfcCartesianPoint 2</xsl:text>
				<xsl:value-of select="$cln"/>
				<xsl:value-of select="name()"/>
				<xsl:value-of select="$cln"/>
				<xsl:value-of select="ifc:Name"/>
				<xsl:text> rep1 </xsl:text>
				<xsl:value-of select="$rep1"/>
				<xsl:text> cp2 </xsl:text>
				<xsl:value-of select="$cp2"/>
				<xsl:text> x2 </xsl:text>
				<xsl:value-of select="$xx2"/>
				<xsl:text> y2 </xsl:text>
				<xsl:value-of select="$yy2"/>
				<xsl:text> z2 </xsl:text>
				<xsl:value-of select="$zz2"/>
			</xsl:message>
			<xsl:if test="not($mode='Header')">
				<xsl:message>
					<xsl:text>IfcCartesianPoint 3</xsl:text>
					<xsl:value-of select="$cln"/>
					<xsl:value-of select="name()"/>
					<xsl:value-of select="$cln"/>
					<xsl:value-of select="ifc:Name"/>
					<xsl:text> rep1 </xsl:text>
					<xsl:value-of select="$rep1"/>
					<xsl:text> cp3 </xsl:text>
					<xsl:value-of select="$cp3"/>
					<xsl:text> x3 </xsl:text>
					<xsl:value-of select="$xx3"/>
					<xsl:text> y3 </xsl:text>
					<xsl:value-of select="$yy3"/>
					<xsl:text> z3 </xsl:text>
					<xsl:value-of select="$zz3"/>
				</xsl:message>
			</xsl:if>
			<xsl:if test="not($mode='Header')">
				<xsl:message>
					<xsl:text>IfcCartesianPoint 4</xsl:text>
					<xsl:value-of select="$cln"/>
					<xsl:value-of select="name()"/>
					<xsl:value-of select="$cln"/>
					<xsl:value-of select="ifc:Name"/>
					<xsl:text> ck   </xsl:text>
					<xsl:value-of select="$ck"/>
					<xsl:text> cp4 </xsl:text>
					<xsl:value-of select="$cp4"/>
					<xsl:text> x4 </xsl:text>
					<xsl:value-of select="$xx4"/>
					<xsl:text> y4 </xsl:text>
					<xsl:value-of select="$yy4"/>
					<xsl:text> z4 </xsl:text>
					<xsl:value-of select="$zz4"/>
				</xsl:message>
			</xsl:if>
		</xsl:if>
		<xsl:element name="Row">
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Name</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Name"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailEnd">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="oh1" select="$oh0"/>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Reference</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Category</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$corner1"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Reference</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">SheetName</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$sheet1"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Reference</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">RowName</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Name"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="typing">number</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">CoordinateXAxis</xsl:when>
						<xsl:when test="$corner1='box-upperright'">
							<xsl:value-of select="$xx1 + $xx2 + $xx3 + $xx4"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$xx1 + $xx3 + $xx4"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="typing">number</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">CoordinateYAxis</xsl:when>
						<xsl:when test="$corner1='box-upperright'">
							<xsl:value-of select="$yy1 + $yy2 + $yy3 + $yy4"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$yy1 + $yy3 + $yy4 "/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="typing">number</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">CoordinateZAxis</xsl:when>
						<xsl:when test="$corner1='box-upperright'">
							<xsl:value-of select="$zz1 + $zz2 + $zz3 + $zz4"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$zz1 + $zz4"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailExternal">
				<xsl:with-param name="mode" select="$mode"/>
			</xsl:call-template>
		</xsl:element>
	</xsl:template>
	<!-- Connection -->
	<xsl:template name="connection">
		<xsl:param name="mode">Header</xsl:param>
		<xsl:variable name="k1" select="@id"/>
		<xsl:comment>
			<xsl:value-of select="@id"/>
		</xsl:comment>
		<xsl:variable select="ifc:RelatingElement/*[1]/@ref" name="n1"/>
		<xsl:variable select="ifc:RelatedElement/*[1]/@ref" name="n2"/>
		<xsl:element name="Row">
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Name</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Name"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailEnd">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="oh1" select="ifc:OwnerHistory/*[1]/@ref"/>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Reference</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">ComponentName1</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="//*[@id=$n1]/ifc:Name"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Reference</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">ComponentName2</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="//*[@id=$n2]/ifc:Name"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Reference</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">ConnectionType</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Description"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailExternal">
				<xsl:with-param name="mode" select="$mode"/>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Specifiable</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Description</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="ifc:Description"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
				<xsl:with-param name="alternative">
					<xsl:value-of select="ifc:Name"/>
				</xsl:with-param>
			</xsl:call-template>
		</xsl:element>
	</xsl:template>
	<!-- Issue -->
	<xsl:template name="issue">
		<xsl:param name="mode">Header</xsl:param>
		<xsl:comment>
			<xsl:value-of select="@id"/>
		</xsl:comment>
		<xsl:element name="Row">
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Name</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailEnd">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="oh1" select="$oh0"/>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Reference</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Type</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Reference</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Risk</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Reference</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Chance</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Reference</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Impact</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Reference</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">SheetName1</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Reference</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">RowName1</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Reference</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">SheetName2</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Reference</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">RowName2</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Description</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="shade">Reference</xsl:with-param>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Owner</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="putString">
				<xsl:with-param name="mode" select="$mode"/>
				<xsl:with-param name="text">
					<xsl:choose>
						<xsl:when test="$mode='Header'">Mitigation</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="$na"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:with-param>
			</xsl:call-template>
			<xsl:call-template name="tailExternal">
				<xsl:with-param name="mode" select="$mode"/>
			</xsl:call-template>
		</xsl:element>
	</xsl:template>
	<!-- utilties -->
	<!-- scan object for all attributes -->
	<xsl:template name="getattributes">
		<xsl:param name="obj1"/>
		<xsl:param name="sheet1">Type</xsl:param>
		<!-- NN -->
		<xsl:for-each select="key('find_id',$obj1)">
			<xsl:variable name="name1">
				<xsl:choose>
					<xsl:when test="name()='IfcProject'">
						<xsl:value-of select="//ifc:IfcBuilding[not(@ref)][1]/ifc:Name"/>
					</xsl:when>
					<xsl:when test="name()='IfcSite'">
						<xsl:value-of select="//ifc:IfcBuilding[not(@ref)][1]/ifc:Name"/>
					</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="ifc:Name"/>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:variable>
			<xsl:call-template name="recurseattributes">
				<xsl:with-param name="obj1" select="$obj1"/>
				<xsl:with-param name="sheet1" select="$sheet1"/>
				<xsl:with-param name="name1" select="$name1"/>
			</xsl:call-template>
		</xsl:for-each>
		<!-- NN -->
	</xsl:template>
	<!-- recursively scan object for all attributes -->
	<xsl:template name="recurseattributes">
		<xsl:param name="obj1"/>
		<xsl:param name="sheet1">Type</xsl:param>
		<xsl:param name="name1">unnamed</xsl:param>
		<xsl:for-each select="key('find_id',$obj1)">
			<!-- immediate -->
			<xsl:message>
				<xsl:value-of select="name()"/>
				<xsl:value-of select="$cln"/>
				<xsl:value-of select="$sheet1"/> / <xsl:value-of select="$name1"/>
			</xsl:message>
			<xsl:for-each select="*[text()]">
				<xsl:call-template name="attribute">
					<xsl:with-param name="mode">Data</xsl:with-param>
					<xsl:with-param name="sheet1" select="$sheet1"/>
					<xsl:with-param name="name1" select="$name1"/>
				</xsl:call-template>
			</xsl:for-each>
			<!-- properties -->
			<xsl:for-each select="key('find_ref',$obj1)[local-name(..)='RelatedObjects']/../../ifc:RelatingPropertyDefinition/*">
				<xsl:call-template name="recurseattributes">
					<xsl:with-param name="obj1" select="@ref"/>
					<xsl:with-param name="sheet1" select="$sheet1"/>
					<xsl:with-param name="name1" select="$name1"/>
				</xsl:call-template>
			</xsl:for-each>
			<xsl:for-each select="ifc:HasProperties/*">
				<xsl:for-each select="key('find_id',@ref)">
					<xsl:choose>
						<xsl:when test="local-name()='IfcComplexProperty'">
							<xsl:call-template name="recurseattributes">
								<xsl:with-param name="obj1" select="@id"/>
								<xsl:with-param name="sheet1" select="$sheet1"/>
								<xsl:with-param name="name1" select="$name1"/>
							</xsl:call-template>
						</xsl:when>
						<xsl:otherwise>
							<xsl:call-template name="attribute">
								<xsl:with-param name="mode">Data</xsl:with-param>
								<xsl:with-param name="sheet1" select="$sheet1"/>
								<xsl:with-param name="name1" select="$name1"/>
							</xsl:call-template>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:for-each>
			</xsl:for-each>
			<!-- qsets -->
			<xsl:for-each select="ifc:Quantities/*">
				<xsl:for-each select="key('find_id',@ref)">
					<xsl:call-template name="attribute">
						<xsl:with-param name="mode">Data</xsl:with-param>
						<xsl:with-param name="sheet1" select="$sheet1"/>
						<xsl:with-param name="name1" select="$name1"/>
					</xsl:call-template>
				</xsl:for-each>
			</xsl:for-each>
			<!--  internal property sets -->
			<xsl:for-each select="ifc:HasPropertySets/*">
				<xsl:call-template name="recurseattributes">
					<xsl:with-param name="obj1" select="@ref"/>
					<xsl:with-param name="sheet1" select="$sheet1"/>
					<xsl:with-param name="name1" select="$name1"/>
				</xsl:call-template>
			</xsl:for-each>
			<!--
			<xsl:for-each select="key('find_ref',$obj1)/../../ifc:RelatingPropertyDefinition/*">
				<xsl:call-template name="recurseattributes">
					<xsl:with-param name="obj1" select="@ref"/>
					<xsl:with-param name="sheet1" select="$sheet1"/>
					<xsl:with-param name="name1" select="$name1"/>
				</xsl:call-template>
			</xsl:for-each>
-->
		</xsl:for-each>
	</xsl:template>
	<!-- guess an email -->
	<xsl:template name="makeEmail">
		<xsl:param name="oh1">0</xsl:param>
		<xsl:variable name="ou2" select="key('find_id',$oh1)/ifc:OwningUser/*/@ref"/>
		<xsl:variable name="po2" select="key('find_id',$ou2)/ifc:ThePerson/*/@ref"/>
		<xsl:variable name="gn2" select="key('find_id',$po2)/ifc:GivenName"/>
		<xsl:variable name="fn2" select="key('find_id',$po2)/ifc:FamilyName"/>
		<xsl:variable name="oo2" select="key('find_id',$ou2)/ifc:TheOrganization/*/@ref"/>
		<xsl:variable name="org2" select="key('find_id',$oo2)/ifc:Name"/>
		<xsl:variable name="oa2" select="key('find_id',$oh1)/ifc:OwningApplication/*/@ref"/>
		<xsl:variable name="app2" select="key('find_id',$oa2)/ifc:ApplicationFullName"/>
		<xsl:variable name="tel2">
			<xsl:choose>
				<xsl:when test="key('find_id',$po2)/ifc:Addresses/ifc:IfcTelecomAddress/@ref">
					<xsl:value-of select="key('find_id',$po2)/ifc:Addresses/ifc:IfcTelecomAddress/@ref"/>
				</xsl:when>
				<xsl:when test="key('find_id',$oo2)/ifc:Addresses/ifc:IfcTelecomAddress/@ref">
					<xsl:value-of select="key('find_id',$oo2)/ifc:Addresses/ifc:IfcTelecomAddress/@ref"/>
				</xsl:when>
			</xsl:choose>
		</xsl:variable>
		<xsl:choose>
			<xsl:when test="string-length(key('find_id',$tel2)/ifc:ElectronicMailAddresses/*[1])>0">
				<xsl:value-of select="key('find_id',$tel2)/ifc:ElectronicMailAddresses/*[1]"/>
			</xsl:when>
			<xsl:when test="key('find_id',$po2)/ifc:Id">
				<xsl:value-of select="key('find_id',$po2)/ifc:Id"/>
			</xsl:when>
			<xsl:when test="key('find_id',$oo2)/ifc:Id">
				<xsl:value-of select="key('find_id',$oo2)/ifc:Id"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="$gn2"/>
				<xsl:text>.</xsl:text>
				<xsl:value-of select="$fn2"/>
				<xsl:text>@</xsl:text>
				<xsl:value-of select="$org2"/>
				<xsl:text>.com</xsl:text>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<!-- common history fields -->
	<xsl:template name="tailEnd">
		<xsl:param name="mode">Header</xsl:param>
		<xsl:param name="oh1">0</xsl:param>
		<xsl:call-template name="putString">
			<xsl:with-param name="mode" select="$mode"/>
			<xsl:with-param name="typing">email</xsl:with-param>
			<xsl:with-param name="shade">Reference</xsl:with-param>
			<xsl:with-param name="text">
				<xsl:choose>
					<xsl:when test="$mode='Header'">CreatedBy</xsl:when>
					<xsl:otherwise>
						<xsl:call-template name="makeEmail">
							<xsl:with-param select="$oh1" name="oh1"/>
						</xsl:call-template>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="putString">
			<xsl:with-param name="mode" select="$mode"/>
			<xsl:with-param name="typing">date</xsl:with-param>
			<xsl:with-param name="text">
				<xsl:choose>
					<xsl:when test="$mode='Header'">CreatedOn</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="$dat1"/>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:with-param>
		</xsl:call-template>
	</xsl:template>
	<xsl:template name="tailExternal">
		<xsl:param name="mode">Header</xsl:param>
		<xsl:call-template name="putString">
			<xsl:with-param name="mode" select="$mode"/>
			<xsl:with-param name="shade">Optional</xsl:with-param>
			<xsl:with-param name="text">
				<xsl:choose>
					<xsl:when test="$mode='Header'">ExtSystem</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="$app"/>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="putString">
			<xsl:with-param name="mode" select="$mode"/>
			<xsl:with-param name="shade">Optional</xsl:with-param>
			<xsl:with-param name="text">
				<xsl:choose>
					<xsl:when test="$mode='Header'">ExtObject</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="local-name()"/>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:with-param>
		</xsl:call-template>
		<xsl:call-template name="putString">
			<xsl:with-param name="mode" select="$mode"/>
			<xsl:with-param name="shade">Optional</xsl:with-param>
			<xsl:with-param name="text">
				<xsl:choose>
					<xsl:when test="$mode='Header'">ExtIdentifier</xsl:when>
					<xsl:otherwise>
						<xsl:value-of select="ifc:GlobalId"/>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:with-param>
		</xsl:call-template>
	</xsl:template>
	<!-- search for property or synonym -->
	<xsl:template name="getProperty">
		<xsl:param name="pName">Name</xsl:param>
		<xsl:param name="altpName">AlternativeName</xsl:param>
		<xsl:call-template name="nav">
			<xsl:with-param name="text">
				<xsl:call-template name="getProp">
					<xsl:with-param name="pName" select="$pName"/>
				</xsl:call-template>
			</xsl:with-param>
			<xsl:with-param name="alternative">
				<xsl:call-template name="getProp">
					<xsl:with-param name="pName" select="$altpName"/>
				</xsl:call-template>
			</xsl:with-param>
		</xsl:call-template>
	</xsl:template>
	<!-- groups -->
	<xsl:template name="getList">
		<xsl:for-each select="key('find_ref',@id)[name(..)='RelatingGroup']/../../ifc:RelatedObjects/*">
			<xsl:variable name="ref1" select="@ref"/>
			<xsl:variable name="check1">
				<xsl:call-template name="IsAssetComponent"/>
			</xsl:variable>
		<xsl:if test="string-length($check1)>0 or name()='IfcSpace'">
				<xsl:value-of select="//*[@id=$ref1]/ifc:Name"/>
				<xsl:text>, </xsl:text>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>
	<!-- classification -->
	<xsl:template name="getClassification">
		<xsl:variable select="@id" name="k1"/>
		<!--
		<xsl:variable name="instCat">
			<xsl:variable name="inst1" select="//ifc:RelatingType/*[@ref=$k1]/../../ifc:RelatedObjects/*[1]/@ref"/>
			<xsl:for-each select="//*[@id=$inst1]">
				<xsl:call-template name="getClassification"/>
			</xsl:for-each>
		</xsl:variable>
		<xsl:variable name="spaceCat">
			<xsl:variable name="inst1" select="//ifc:RelatingGroup/*[@ref=$k1]/../../ifc:RelatedObjects/*[1]/@ref"/>
			<xsl:for-each select="//*[@id=$inst1]">
				<xsl:call-template name="getClassification"/>
			</xsl:for-each>
		</xsl:variable>
          -->
		<xsl:choose>
			<xsl:when test="key('find_ref',@id)/../../ifc:RelatingClassification/*">
				<xsl:for-each select="key('find_ref',@id)/../../ifc:RelatingClassification/*">
					<xsl:if test="position()>1">
						<xsl:text>, </xsl:text>
					</xsl:if>
					<xsl:value-of select="key('find_id',@ref)/ifc:ItemReference"/>
					<xsl:text>: </xsl:text>
					<xsl:value-of select="key('find_id',@ref)/ifc:Name"/>
				</xsl:for-each>
			</xsl:when>
			<!--
			<xsl:when test="$instCat">
				<xsl:value-of select="$instCat"/>
			</xsl:when>
            -->
			<xsl:when test="ifc:ObjectType">
				<xsl:value-of select="ifc:ObjectType"/>
			</xsl:when>
			<!--
			<xsl:when test="$spaceCat">
				<xsl:value-of select="$spaceCat"/>
			</xsl:when>
           -->
			<xsl:when test="ifc:ElementType">
				<xsl:value-of select="ifc:ElementType"/>
			</xsl:when>
			<xsl:when test="ifc:PredefinedType">
				<xsl:value-of select="ifc:PredefinedType"/>
			</xsl:when>
			<xsl:when test="ifc:OperationType">
				<xsl:value-of select="ifc:OperationType"/>
			</xsl:when>
			<xsl:when test="ifc:ConstructionType">
				<xsl:value-of select="ifc:ConstructionType"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="$na"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<!-- property / quantity / type search -->
	<xsl:template name="getProp">
		<xsl:param name="pName">Name</xsl:param>
		<xsl:value-of select="*[name()=$pName]"/>
		<!-- check instance -->
		<xsl:for-each select="key('find_ref',@id)/../../ifc:RelatingPropertyDefinition/*">
			<xsl:value-of select="key('find_id',@ref)/*[name()=$pName]"/>
			<!-- check instance quantities -->
			<xsl:for-each select="key('find_id',@ref)/ifc:Quantities/*">
				<xsl:for-each select="key('find_id',@ref)">
					<xsl:if test="./ifc:Name = $pName">
						<xsl:value-of select="./ifc:AreaValue"/>
						<xsl:value-of select="./ifc:LengthValue"/>
						<xsl:value-of select="./ifc:VolumeValue"/>
					</xsl:if>
				</xsl:for-each>
			</xsl:for-each>
			<!-- check  instance properties -->
			<xsl:for-each select="key('find_id',@ref)/ifc:HasProperties/*">
				<xsl:for-each select="key('find_id',@ref)">
					<xsl:if test="./ifc:Name = $pName">
						<xsl:value-of select="./ifc:NominalValue"/>
						<xsl:value-of select="./ifc:EnumerationValues/*[1]"/>
					</xsl:if>
				</xsl:for-each>
			</xsl:for-each>
		</xsl:for-each>
		<!-- check properties if it is a type -->
		<xsl:for-each select="ifc:HasProperties/*">
			<xsl:for-each select="key('find_id',@ref)">
				<xsl:if test="./ifc:Name = $pName">
					<xsl:value-of select="./ifc:NominalValue"/>
					<xsl:value-of select="./ifc:EnumerationValues/*[1]"/>
				</xsl:if>
			</xsl:for-each>
		</xsl:for-each>
		<!-- check instance applied values -->
		<xsl:for-each select="key('find_ref',@id)/../../ifc:RelatingAppliedValue/*">
			<xsl:for-each select="key('find_id',@ref)">
				<xsl:if test="./ifc:Name = $pName">
					<xsl:value-of select="./ifc:AppliedValue"/>
				</xsl:if>
			</xsl:for-each>
		</xsl:for-each>
		<!-- check type definition -->
		<xsl:for-each select="key('find_ref',@id)/../../ifc:RelatingType/*">
			<xsl:value-of select="key('find_id',@ref)/*[name()=$pName]"/>
			<!-- check type properties -->
			<xsl:for-each select="key('find_id',@ref)//ifc:HasPropertySets/*">
				<xsl:for-each select="key('find_id',@ref)/ifc:HasProperties/*">
					<xsl:for-each select="key('find_id',@ref)">
						<xsl:if test="./ifc:Name = $pName">
							<xsl:value-of select="./ifc:NominalValue"/>
							<xsl:value-of select="./ifc:EnumerationValues/*[1]"/>
						</xsl:if>
					</xsl:for-each>
				</xsl:for-each>
			</xsl:for-each>
			<!-- check type applied values -->
			<xsl:for-each select="key('find_ref',@id)/../../ifc:RelatingAppliedValue/*">
				<xsl:for-each select="key('find_id',@ref)">
					<xsl:if test="./ifc:Name = $pName">
						<xsl:value-of select="./ifc:AppliedValue"/>
					</xsl:if>
				</xsl:for-each>
			</xsl:for-each>
		</xsl:for-each>
		<!-- check classification -->
		<xsl:for-each select="key('find_ref',@id)/../../ifc:RelatingClassification/*">
			<xsl:for-each select="key('find_id',@ref)">
				<xsl:if test="./ifc:Name = $pName">
					<xsl:value-of select="./ifc:ItemReference"/>
				</xsl:if>
			</xsl:for-each>
		</xsl:for-each>
		<!-- check only the first instance of a type -->
		<xsl:variable select="key('find_ref',@id)/../../ifc:RelatedObjects/*[1]/@ref" name="comp1"/>
		<xsl:for-each select="key('find_ref',$comp1)/../../ifc:RelatingPropertyDefinition/*">
			<xsl:value-of select="key('find_id',@ref)/*[name()=$pName]"/>
			<!-- check  instance properties -->
			<xsl:for-each select="key('find_id',@ref)/ifc:HasProperties/*">
				<xsl:for-each select="key('find_id',@ref)">
					<xsl:if test="./ifc:Name = $pName">
						<xsl:value-of select="./ifc:NominalValue"/>
						<xsl:value-of select="./ifc:EnumerationValues/*[1]"/>
					</xsl:if>
				</xsl:for-each>
			</xsl:for-each>
		</xsl:for-each>
	</xsl:template>
	<!-- search register for component -->
	<xsl:template name="getRegister">
		<xsl:param name="cid"/>
		<xsl:call-template name="nav">
			<xsl:with-param name="text">
				<xsl:for-each select="//ifc:IfcRelDefinesByType">
					<xsl:for-each select="ifc:RelatedObjects/*[$cid=@ref]">
						<xsl:variable name="tid1" select="../../ifc:RelatingType/*/@ref"/>
						<xsl:value-of select="//*[@id=$tid1]/ifc:Name"/>
					</xsl:for-each>
				</xsl:for-each>
			</xsl:with-param>
		</xsl:call-template>
	</xsl:template>
	<!-- search spaces or boundaries for component  -->
	<xsl:template name="getSpace">
		<xsl:param name="cid"/>
		<xsl:call-template name="nav">
			<xsl:with-param name="text">
				<xsl:for-each select="//ifc:IfcRelContainedInSpatialStructure/ifc:RelatedElements/*[@ref=$cid]/../../ifc:RelatingStructure/*">
					<xsl:variable name="sid1" select="@ref"/>
					<xsl:for-each select="//ifc:IfcSpace[not(@ref)]">
						<xsl:if test="@id=$sid1">
							<xsl:value-of select="ifc:Name"/>
						</xsl:if>
					</xsl:for-each>
				</xsl:for-each>
			</xsl:with-param>
			<xsl:with-param name="alternative">
				<xsl:for-each select="//ifc:IfcRelSpaceBoundary/ifc:RelatedBuildingElement/*[@ref=$cid]/../../ifc:RelatingSpace/*">
					<xsl:variable name="sid1" select="@ref"/>
					<xsl:for-each select="//ifc:IfcSpace[not(@ref)]">
						<xsl:if test="@id=$sid1">
							<xsl:value-of select="ifc:Name"/>
							<xsl:text>, </xsl:text>
						</xsl:if>
					</xsl:for-each>
				</xsl:for-each>
			</xsl:with-param>
		</xsl:call-template>
	</xsl:template>
	<!-- writing text into worksheet with style -->
	<xsl:template name="putString">
		<xsl:param name="mode">0</xsl:param>
		<xsl:param name="shade">Mandatory</xsl:param>
		<xsl:param name="typing">text</xsl:param>
		<xsl:param name="text">n/a</xsl:param>
		<xsl:param name="alternative"/>
		<xsl:element name="Cell" namespace="urn:schemas-microsoft-com:office:spreadsheet">
			<xsl:choose>
				<xsl:when test="$mode='Header'">
					<xsl:attribute name="ss:StyleID">Header</xsl:attribute>
				</xsl:when>
				<xsl:otherwise>
					<xsl:attribute name="ss:StyleID"><xsl:value-of select="$shade"/></xsl:attribute>
				</xsl:otherwise>
			</xsl:choose>
			<xsl:element name="Data" namespace="urn:schemas-microsoft-com:office:spreadsheet">
				<xsl:choose>
					<xsl:when test="($typing='number') and not(format-number(normalize-space($text),'0.000') = 'NaN')">
						<xsl:attribute name="ss:Type">Number</xsl:attribute>
					</xsl:when>
					<!-- 2009-11-04T11:08:38.490 -->
					<!--
					<xsl:when test="($typing='date') and not($mode='Header')">
						<xsl:attribute name="ss:Type">DateTime</xsl:attribute>
					</xsl:when>
				-->
					<!--
				<xsl:when test="($typing='email') and not($mode='Header')">
						<xsl:attribute name="ss:Type">xxxx</xsl:attribute>
					</xsl:when>
-->
					<xsl:otherwise>
						<xsl:attribute name="ss:Type">String</xsl:attribute>
					</xsl:otherwise>
				</xsl:choose>
				<!--

				<xsl:attribute name="ss:Type">String</xsl:attribute>
-->
				<xsl:call-template name="nav">
					<xsl:with-param name="text" select="$text"/>
					<xsl:with-param name="alternative" select="$alternative"/>
				</xsl:call-template>
			</xsl:element>
		</xsl:element>
	</xsl:template>
	<!-- writing formula into worksheet -->
	<xsl:template name="putFormula">
		<xsl:param name="shade">Mandatory</xsl:param>
		<xsl:param name="text"/>
		<xsl:element name="Cell" namespace="urn:schemas-microsoft-com:office:spreadsheet">
			<xsl:attribute name="ss:StyleID"><xsl:value-of select="$shade"/></xsl:attribute>
			<xsl:attribute name="ss:Formula"><xsl:text>=</xsl:text><xsl:value-of select="$text"/></xsl:attribute>
		</xsl:element>
	</xsl:template>
	<!-- mark a worksheet as having first column and first row frozen -->
	<xsl:template name="freeze">
		<WorksheetOptions xmlns="urn:schemas-microsoft-com:office:excel">
			<FreezePanes/>
			<FrozenNoSplit/>
			<SplitHorizontal>1</SplitHorizontal>
			<TopRowBottomPane>1</TopRowBottomPane>
			<SplitVertical>1</SplitVertical>
			<LeftColumnRightPane>1</LeftColumnRightPane>
		</WorksheetOptions>
	</xsl:template>
	<!-- writing n/a into worksheet if no other value found-->
	<xsl:template name="nav">
		<xsl:param name="text">n/a</xsl:param>
		<xsl:param name="alternative"/>
		<xsl:value-of select="normalize-space($text)"/>
		<xsl:if test="string-length($text)=0">
			<xsl:value-of select="normalize-space($alternative)"/>
			<xsl:if test="string-length($alternative)=0">
				<xsl:value-of select="$na"/>
			</xsl:if>
		</xsl:if>
	</xsl:template>
	<!-- common cell formatting -->
	<xsl:template name="cell">
		<Borders>
			<Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"/>
			<Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"/>
			<Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"/>
			<Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"/>
		</Borders>
	</xsl:template>
	<!-- IsAsset -->
	<xsl:template name="IsAsset">
		<xsl:variable select="local-name()" name="typename"/>
		<xsl:choose>
			<xsl:when test="$all='yes'">
				<xsl:value-of select="$typename"/>
			</xsl:when>
			<xsl:when test="$typename='IfcBeamType'"/>
			<xsl:when test="$typename='IfcCableCarrierSegmentType'"/>
			<xsl:when test="$typename='IfcCableSegmentType'"/>
			<xsl:when test="$typename='IfcColumnType'"/>
			<xsl:when test="$typename='IfcCurtainWallType'"/>
			<xsl:when test="$typename='IfcDuctFittingType'"/>
			<xsl:when test="$typename='IfcDuctSegmentType'"/>
			<xsl:when test="$typename='IfcFastenerType'"/>
			<xsl:when test="$typename='IfcJunctionBoxType'"/>
			<xsl:when test="$typename='IfcMemberType'"/>
			<xsl:when test="$typename='IfcPipeFittingType'"/>
			<xsl:when test="$typename='IfcPipeSegmentType'"/>
			<xsl:when test="$typename='IfcPlateType'"/>
			<xsl:when test="$typename='IfcRailingType'"/>
			<xsl:when test="$typename='IfcRampFlightType'"/>
			<xsl:when test="$typename='IfcRampType'"/>
			<xsl:when test="$typename='IfcSlabType'"/>
			<xsl:when test="$typename='IfcSpaceType'"/>
			<xsl:when test="$typename='IfcStairFlightType'"/>
			<xsl:when test="$typename='IfcStairType'"/>
			<xsl:when test="$typename='IfcWallType'"/>
			<xsl:when test="$typename='IfcTypeObject'"/>
			<xsl:when test="$typename='IfcTypeProduct'"/>
			<xsl:when test="$typename='IfcElementType'"/>
			<xsl:otherwise>
				<xsl:value-of select="$typename"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<!-- IsAsset -->
	<xsl:template name="IsAssetComponent">
		<xsl:variable select="local-name()" name="typename"/>
		<xsl:choose>
			<xsl:when test="$typename='IfcAnnotation'"/>
			<xsl:when test="$typename='IfcDistributionPort'"/>
			<xsl:when test="$typename='IfcSpace'"/>
			<xsl:when test="$typename='IfcBuildingStorey'"/>
			<xsl:when test="$typename='IfcBuilding'"/>
			<xsl:when test="$typename='IfcSite'"/>
			<xsl:when test="$typename='IfcVirtualElement'"/>
			<xsl:when test="$all='yes'">
				<xsl:value-of select="$typename"/>
			</xsl:when>
			<xsl:when test="$typename='IfcBeam'"/>
			<xsl:when test="$typename='IfcBuildingElementPart'"/>
			<xsl:when test="$typename='IfcColumn'"/>
			<xsl:when test="$typename='IfcCurtainWall'"/>
			<xsl:when test="$typename='IfcElementAssembly'"/>
			<xsl:when test="$typename='IfcFastener'"/>
			<xsl:when test="$typename='IfcFeatureElement'"/>
			<xsl:when test="$typename='IfcFlowFitting'"/>
			<xsl:when test="$typename='IfcFlowSegment'"/>
			<xsl:when test="$typename='IfcFooting'"/>
			<xsl:when test="$typename='IfcMechanicalFastener'"/>
			<xsl:when test="$typename='IfcMember'"/>
			<xsl:when test="$typename='IfcPile'"/>
			<xsl:when test="$typename='IfcPlate'"/>
			<xsl:when test="$typename='IfcRailing'"/>
			<xsl:when test="$typename='IfcRamp'"/>
			<xsl:when test="$typename='IfcRampFlight'"/>
			<xsl:when test="$typename='IfcReinforcingBar'"/>
			<xsl:when test="$typename='IfcReinforcingMesh'"/>
			<xsl:when test="$typename='IfcRoof'"/>
			<xsl:when test="$typename='IfcSlab'"/>
			<xsl:when test="$typename='IfcStair'"/>
			<xsl:when test="$typename='IfcStairFlight'"/>
			<xsl:when test="$typename='IfcTendon'"/>
			<xsl:when test="$typename='IfcTendonAnchor'"/>
			<xsl:when test="$typename='IfcWall'"/>
			<xsl:when test="$typename='IfcWallStandardCase'"/>
			<xsl:otherwise>
				<xsl:value-of select="$typename"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
</xsl:stylesheet>
