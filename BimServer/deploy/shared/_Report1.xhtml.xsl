<?xml version="1.0"?>
<?altova_samplexml ..\models\Railyard.ifcxml?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xhtml="http://www.w3.org/1999/xhtml" xmlns="http://www.w3.org/1999/xhtml" exclude-result-prefixes="xhtml xsl fo ifc ex xlink xsi" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:ex="urn:iso.org:standard:10303:part(28):version(2):xmlschema:common" xmlns:ifc="http://www.iai-tech.org/ifcXML/IFC2x3/FINAL" xsi:schemaLocation="http://www.iai-tech.org/ifcXML/IFC2x3/FINAL">
	<!--	
	<xsl:output method="xml" version="1.0" encoding="UTF-8" doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN" doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" indent="yes"/>
    -->
	<xsl:output method="xml" version="1.0" encoding="UTF-8" doctype-public="-//W3C//DTD XHTML 1.1//EN" doctype-system="http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd" indent="yes"/>
	<!-- these two parameters control the scope of the report -->
	<xsl:param name="topic">system</xsl:param>
	<xsl:param name="item">every</xsl:param>
	<!-- these are the string constants -->
	<xsl:variable name="title"> Schedule of <xsl:value-of select="$item"/>
		<xsl:text>  </xsl:text>
		<xsl:value-of select="$topic"/>.</xsl:variable>
	<!-- find out the facility name for titling -->
	<xsl:variable select="//ifc:IfcProject/ifc:Name" name="proj"/>
	<xsl:variable name="nbsp"> .</xsl:variable>
	<xsl:variable name="unknown">every</xsl:variable>
	<xsl:variable name="delim">!</xsl:variable>
	<!-- keys used to accelerate parsing -->
	<xsl:key name="find_id" match="*" use="@id"/>
	<xsl:key name="find_ref" match="*" use="@ref"/>
	<xsl:variable name="lcletters">abcdefghijklmnopqrstuvwxyz</xsl:variable>
	<xsl:variable name="ucletters">ABCDEFGHIJKLMNOPQRSTUVWXYZ</xsl:variable>
	<xsl:template match="/">
		<html>
			<head>
				<title>
					<xsl:value-of select="$proj"/>
					<xsl:text> </xsl:text>
					<xsl:value-of select="$title"/>
				</title>
			</head>
			<body>
				<h1 style="text-align:center">
					<xsl:value-of select="$proj"/>
				</h1>
				<h2 style="text-align:center">
					<xsl:value-of select="$title"/>
				</h2>
				<!-- report on every topic -->
				<xsl:for-each select="//ifc:IfcProject[not(@ref)]">
					<xsl:if test="not($topic='space')">
						<xsl:apply-templates select="."/>
					</xsl:if>
					<xsl:if test="$topic='space'">
						<xsl:call-template name="disaggregate"/>
					</xsl:if>
				</xsl:for-each>
				<xsl:if test="$topic='type'">
					<xsl:for-each select="//ifc:IfcRelDefinesByType/ifc:RelatingType/*">
						<xsl:sort select="name()"/>
						<xsl:apply-templates select="."/>
					</xsl:for-each>
				</xsl:if>
				<xsl:if test="$topic='component'">
					<xsl:for-each select="//ifc:IfcRelDefinesByType/ifc:RelatedObjects/*">
						<xsl:sort select="name()"/>
						<xsl:apply-templates select="."/>
					</xsl:for-each>
				</xsl:if>

				<xsl:if test="$topic='system'">
					<xsl:for-each select="//ifc:IfcSystem[not(@ref)]">
						<xsl:sort select="ifc:Name"/>
						<xsl:apply-templates select="."/>
					</xsl:for-each>
				</xsl:if>
				<xsl:if test="$topic='zone'">
					<xsl:for-each select="//ifc:IfcZone[not(@ref)]">
						<xsl:sort select="ifc:Name"/>
						<xsl:apply-templates select="."/>
					</xsl:for-each>
				</xsl:if>
			</body>
		</html>
	</xsl:template>
	<xsl:template name="disaggregate">
		<xsl:variable select="@id" name="pid"/>
		<xsl:apply-templates select="."/>
		<xsl:for-each select="//ifc:IfcRelAggregates/ifc:RelatingObject/*[@ref=$pid]/../../ifc:RelatedObjects/*">
			<xsl:for-each select="key('find_id',@ref)">
				<xsl:call-template name="disaggregate"/>
			</xsl:for-each>
		</xsl:for-each>
	</xsl:template>
	<xsl:template match="*[@ref]">
		<xsl:param name="deep">0</xsl:param>
		<xsl:apply-templates select="key('find_id',@ref)">
			<xsl:with-param name="deep" select="$deep"/>
		</xsl:apply-templates>
	</xsl:template>
	<xsl:template match="ifc:*[not(@ref)]">
		<xsl:param name="deep">0</xsl:param>
		<xsl:param name="list1"/>
		<xsl:param name="list2"/>
		<xsl:variable select="@id" name="object1"/>
		<xsl:if test="($item=$unknown) or ($item=ifc:Name) or ($item='') or ($item=ifc:Description) or (local-name()='IfcProject') or ($deep>0)">
			<xsl:message>
				<xsl:value-of select="name()"/> : <xsl:value-of select="ifc:Name"/> : <xsl:value-of select="$deep"/>
			</xsl:message>
			<xsl:choose>
				<xsl:when test="$deep=0">
					<xsl:call-template name="subtable">
						<xsl:with-param name="list1">
							<xsl:value-of select="$object1"/>
							<xsl:value-of select="$delim"/>
						</xsl:with-param>
						<xsl:with-param name="mode0">main</xsl:with-param>
					</xsl:call-template>
					<!-- contents -->
					<xsl:call-template name="subtable">
						<xsl:with-param name="mode0">Contained</xsl:with-param>
						<xsl:with-param name="list1">
							<xsl:for-each select="key('find_ref',$object1)[local-name(..)='RelatingStructure']/../../ifc:RelatedElements/*[not(@ref=$object1)]">
								<xsl:sort select="name()"/>
								<xsl:sort select="ifc:Name"/>
								<xsl:value-of select="@ref"/>
								<xsl:value-of select="$delim"/>
							</xsl:for-each>
						</xsl:with-param>
					</xsl:call-template>
					<!-- grouped -->
					<xsl:call-template name="subtable">
						<xsl:with-param name="mode0">Grouped</xsl:with-param>
						<xsl:with-param name="list1">
							<xsl:for-each select="key('find_ref',$object1)[local-name(..)='RelatingGroup']/../../ifc:RelatedObjects/*[not(@ref=$object1)]">
								<xsl:sort select="name()"/>
								<xsl:sort select="ifc:Name"/>
								<xsl:value-of select="@ref"/>
								<xsl:value-of select="$delim"/>
							</xsl:for-each>
						</xsl:with-param>
					</xsl:call-template>
					<!-- boundaries -->
					<xsl:call-template name="subtable">
						<xsl:with-param name="mode0">Boundaries</xsl:with-param>
						<xsl:with-param name="list1">
							<xsl:for-each select="key('find_ref',$object1)[local-name(..)='RelatingSpace']/../../ifc:RelatedBuildingElement/*[not(@ref=$object1)]">
								<xsl:sort select="name()"/>
								<xsl:sort select="ifc:Name"/>
								<xsl:value-of select="@ref"/>
								<xsl:value-of select="$delim"/>
							</xsl:for-each>
						</xsl:with-param>
					</xsl:call-template>
					<!-- occurences -->
					<xsl:call-template name="subtable">
						<xsl:with-param name="mode0">Occurences</xsl:with-param>
						<xsl:with-param name="list1">
							<xsl:for-each select="key('find_ref',$object1)[local-name(..)='RelatingType']/../../ifc:RelatedObjects/*[not(@ref=$object1)]">
								<xsl:sort select="name()"/>
								<xsl:sort select="ifc:Name"/>
								<xsl:value-of select="@ref"/>
								<xsl:value-of select="$delim"/>
							</xsl:for-each>
						</xsl:with-param>
					</xsl:call-template>
					<!-- spares -->
					<xsl:call-template name="subtable">
						<xsl:with-param name="mode0">Spares</xsl:with-param>
						<xsl:with-param name="list1">
							<xsl:for-each select="key('find_ref',$object1)[local-name(..)='RelatedObjects']/../../ifc:RelatingResource/*[not(@ref=$object1)]">
								<xsl:sort select="name()"/>
								<xsl:sort select="ifc:Name"/>
								<xsl:value-of select="@ref"/>
								<xsl:value-of select="$delim"/>
							</xsl:for-each>
						</xsl:with-param>
					</xsl:call-template>
					<!-- jobs -->
					<xsl:call-template name="subtable">
						<xsl:with-param name="mode0">Jobs</xsl:with-param>
						<xsl:with-param name="list1">
							<xsl:for-each select="key('find_ref',$object1)[local-name(..)='RelatedObjects']/../../ifc:RelatingProcess/*[not(@ref=$object1)]">
								<xsl:sort select="name()"/>
								<xsl:sort select="ifc:Name"/>
								<xsl:value-of select="@ref"/>
								<xsl:value-of select="$delim"/>
							</xsl:for-each>
						</xsl:with-param>
					</xsl:call-template>
					<!-- documents -->
					<xsl:call-template name="subtable">
						<xsl:with-param name="mode0">Documents</xsl:with-param>
						<xsl:with-param name="list1">
							<xsl:for-each select="key('find_ref',$object1)[local-name(..)='RelatedObjects']/../../ifc:RelatingDocument/*[not(@ref=$object1)]">
								<xsl:sort select="name()"/>
								<xsl:sort select="ifc:Name"/>
								<xsl:value-of select="@ref"/>
								<xsl:value-of select="$delim"/>
							</xsl:for-each>
						</xsl:with-param>
					</xsl:call-template>
					<!-- issues -->
					<xsl:call-template name="subtable">
						<xsl:with-param name="mode0">Issues</xsl:with-param>
						<xsl:with-param name="list1">
							<xsl:for-each select="key('find_ref',$object1)[local-name(..)='RelatedObjects']/../../ifc:RelatingApproval/*[not(@ref=$object1)]">
								<xsl:sort select="name()"/>
								<xsl:sort select="ifc:Name"/>
								<xsl:value-of select="@ref"/>
								<xsl:value-of select="$delim"/>
							</xsl:for-each>
						</xsl:with-param>
					</xsl:call-template>
					<!-- more associations -->
				</xsl:when>
				<xsl:when test="$deep=1">
					<tr>
						<td>
							<xsl:value-of select="substring-after(name(),'Ifc')"/>
							<xsl:text> </xsl:text>
							<xsl:value-of select="ifc:ObjectType"/>
						</td>
						<td>
							<xsl:value-of select="ifc:Name"/>
							<xsl:value-of select="$nbsp"/>
						</td>
						<td>
							<xsl:value-of select="ifc:Description"/>
							<xsl:value-of select="$nbsp"/>
						</td>
						<td>
							<xsl:value-of select="key('find_id',key('find_ref',$object1)/../../ifc:RelatingType/*[1]/@ref)/ifc:Name"/>
							<xsl:value-of select="$nbsp"/>
						</td>
						<!-- values of attributes of  objects of this object -->
						<xsl:call-template name="eachProperty">
							<xsl:with-param name="list1" select="$object1"/>
							<xsl:with-param name="list2" select="$list2"/>
							<xsl:with-param name="mode2">propertyvalue</xsl:with-param>
						</xsl:call-template>
					</tr>
				</xsl:when>
			</xsl:choose>
		</xsl:if>
	</xsl:template>
	<!-- utilities -->
	<!-- recurse over each ref -->
	<xsl:template name="eachObject">
		<xsl:param name="list1"/>
		<xsl:param name="list2"/>
		<xsl:param name="mode1"/>
		<!-- get head object -->
		<xsl:variable select="substring-before($list1,$delim)" name="head1"/>
		<xsl:variable select="substring-after($list1,$delim)" name="tail1"/>
		<!-- action -->
		<xsl:if test="not(contains($tail1,$head1))">
			<xsl:if test="$mode1='propertynames'">
				<xsl:call-template name="getAllProp">
					<xsl:with-param name="mode" select="$mode1"/>
					<xsl:with-param name="objref" select="$head1"/>
				</xsl:call-template>
			</xsl:if>
			<xsl:if test="$mode1='objectrow'">
				<xsl:apply-templates select="key('find_id',$head1)">
					<xsl:with-param name="deep">1</xsl:with-param>
					<xsl:with-param name="list2" select="$list2"/>
					<xsl:with-param name="list1" select="$list1"/>
				</xsl:apply-templates>
			</xsl:if>
		</xsl:if>
		<!-- recurse -->
		<xsl:choose>
			<xsl:when test="string-length($head1)=0"/>
			<xsl:when test="string-length($tail1)=0"/>
			<xsl:when test="$tail1=$delim"/>
			<xsl:otherwise>
				<xsl:call-template name="eachObject">
					<xsl:with-param select="$tail1" name="list1"/>
					<xsl:with-param select="$list2" name="list2"/>
					<xsl:with-param select="$mode1" name="mode1"/>
				</xsl:call-template>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<!-- recurse over each prop -->
	<xsl:template name="eachProperty">
		<xsl:param name="list1"/>
		<xsl:param name="list2"/>
		<xsl:param name="mode2"/>
		<!-- get head name -->
		<xsl:variable select="substring-before($list2,$delim)" name="head2"/>
		<xsl:variable select="substring-after($list2,$delim)" name="tail2"/>
		<!-- action -->
		<xsl:if test="not(contains($tail2,$head2))">
			<xsl:if test="$mode2='propertyvalue'">
				<td width="10%">
					<xsl:call-template name="getAllProp">
						<xsl:with-param name="mode" select="$mode2"/>
						<xsl:with-param name="objref" select="$list1"/>
						<xsl:with-param name="prpnam" select="$head2"/>
					</xsl:call-template>
				</td>
			</xsl:if>
			<xsl:if test="not($mode2='propertyvalue')">
				<xsl:call-template name="getAllProp">
					<xsl:with-param name="mode" select="$mode2"/>
					<xsl:with-param name="objref" select="$list1"/>
					<xsl:with-param name="prpnam" select="$head2"/>
				</xsl:call-template>
			</xsl:if>
		</xsl:if>
		<!-- recurse -->
		<xsl:choose>
			<xsl:when test="string-length($head2)=0"/>
			<xsl:when test="string-length($tail2)=0"/>
			<xsl:when test="$tail2=$delim"/>
			<xsl:otherwise>
				<xsl:call-template name="eachProperty">
					<xsl:with-param select="$list1" name="list1"/>
					<xsl:with-param select="$tail2" name="list2"/>
					<xsl:with-param select="$mode2" name="mode2"/>
				</xsl:call-template>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<!-- get all prop -->
	<xsl:template name="getAllProp">
		<xsl:param name="mode">value</xsl:param>
		<xsl:param name="objref"/>
		<xsl:param name="prpnam"/>
		<xsl:choose>
			<xsl:when test="$mode='propertyheader'">
				<xsl:call-template name="getProp">
					<xsl:with-param name="mode" select="$mode"/>
					<xsl:with-param name="pName" select="$prpnam"/>
					<xsl:with-param name="tName" select="$prpnam"/>
					<xsl:with-param name="pValue"/>
				</xsl:call-template>
			</xsl:when>
			<xsl:otherwise>
				<xsl:for-each select="key('find_id',$objref)/*">
					<xsl:if test="not(*[not(*)])  and string-length(.)>0">
						<xsl:call-template name="getProp">
							<xsl:with-param name="mode" select="$mode"/>
							<xsl:with-param name="pName" select="name()"/>
							<xsl:with-param name="tName" select="$prpnam"/>
							<xsl:with-param name="pValue" select="."/>
						</xsl:call-template>
					</xsl:if>
				</xsl:for-each>
				<!-- check for document information to document-reference connection -->
				<xsl:for-each select="key('find_id',key('find_id',$objref)/ifc:DocumentReferences/*/@ref)/*">
					<xsl:if test="not(*[not(*)])  and string-length(.)>0">
						<xsl:call-template name="getProp">
							<xsl:with-param name="mode" select="$mode"/>
							<xsl:with-param name="pName" select="name()"/>
							<xsl:with-param name="tName" select="$prpnam"/>
							<xsl:with-param name="pValue" select="."/>
						</xsl:call-template>
					</xsl:if>
				</xsl:for-each>
				<!-- check most property set associations -->
				<xsl:for-each select="key('find_ref',$objref)/../../ifc:RelatingPropertyDefinition/*">
					<xsl:for-each select="key('find_id',@ref)/*">
						<xsl:if test="not(*[not(*)])  and string-length(.)>0">
							<xsl:call-template name="getProp">
								<xsl:with-param name="mode" select="$mode"/>
								<xsl:with-param name="pName" select="name()"/>
								<xsl:with-param name="tName" select="$prpnam"/>
								<xsl:with-param name="pValue" select="."/>
							</xsl:call-template>
						</xsl:if>
					</xsl:for-each>
					<xsl:for-each select="key('find_id',@ref)/ifc:Quantities/*">
						<xsl:for-each select="key('find_id',@ref)">
							<xsl:call-template name="getProp">
								<xsl:with-param name="mode" select="$mode"/>
								<xsl:with-param name="pName" select="ifc:Name"/>
								<xsl:with-param name="tName" select="$prpnam"/>
								<xsl:with-param name="pValue">
									<xsl:value-of select="./ifc:AreaValue"/>
									<xsl:value-of select="./ifc:LengthValue"/>
									<xsl:value-of select="./ifc:VolumeValue"/>
								</xsl:with-param>
							</xsl:call-template>
						</xsl:for-each>
					</xsl:for-each>
					<xsl:for-each select="key('find_id',@ref)/ifc:HasProperties/*">
						<xsl:for-each select="key('find_id',@ref)">
							<xsl:call-template name="getProp">
								<xsl:with-param name="mode" select="$mode"/>
								<xsl:with-param name="pName" select="ifc:Name"/>
								<xsl:with-param name="tName" select="$prpnam"/>
								<xsl:with-param name="pValue">
									<xsl:value-of select="./ifc:NominalValue/*"/>
									<xsl:value-of select="./ifc:EnumerationValues/*[1]"/>
								</xsl:with-param>
							</xsl:call-template>
						</xsl:for-each>
					</xsl:for-each>
				</xsl:for-each>
				<!-- check type property association -->
				<xsl:for-each select="key('find_id',$objref)/ifc:HasPropertySets/*">
					<xsl:for-each select="key('find_id',@ref)/*">
						<xsl:if test="not(*[not(*)])  and string-length(.)>0">
							<xsl:call-template name="getProp">
								<xsl:with-param name="mode" select="$mode"/>
								<xsl:with-param name="pName" select="name()"/>
								<xsl:with-param name="tName" select="$prpnam"/>
								<xsl:with-param name="pValue" select="."/>
							</xsl:call-template>
						</xsl:if>
					</xsl:for-each>
					<xsl:for-each select="key('find_id',@ref)/ifc:HasProperties/*">
						<xsl:for-each select="key('find_id',@ref)">
							<xsl:call-template name="getProp">
								<xsl:with-param name="mode" select="$mode"/>
								<xsl:with-param name="pName" select="ifc:Name"/>
								<xsl:with-param name="tName" select="$prpnam"/>
								<xsl:with-param name="pValue">
									<xsl:value-of select="./ifc:NominalValue/*"/>
									<xsl:value-of select="./ifc:EnumerationValues/*[1]"/>
								</xsl:with-param>
							</xsl:call-template>
						</xsl:for-each>
					</xsl:for-each>
				</xsl:for-each>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<!-- properties -->
	<xsl:template name="getProp">
		<xsl:param name="mode">_</xsl:param>
		<xsl:param name="pName">Name</xsl:param>
		<xsl:param name="tName">Target</xsl:param>
		<xsl:param name="pValue">Unknown</xsl:param>
		<xsl:param name="pUnit"/>
		<xsl:if test="not($pName='Name')and not($pName='Description')and not($pName='ObjectType')and not($pName='LongName') and not($pName='GlobalId')">
			<xsl:if test="$tName='' or $tName=$pName">
				<!-- check instance -->
				<xsl:if test="$mode='propertynames' and string-length($pValue)>0">
					<xsl:value-of select="$pName"/>
					<xsl:value-of select="$delim"/>
				</xsl:if>
				<xsl:if test="$mode='propertyheader'">
					<th width="10%">
						<xsl:call-template name="valueorlink">
							<xsl:with-param name="text1" select="$pName"/>
							<xsl:with-param name="unit1" select="$pUnit"/>
						</xsl:call-template>
					</th>
				</xsl:if>
				<xsl:if test="$mode='propertyvalue'">
					<xsl:call-template name="valueorlink">
						<xsl:with-param name="text1" select="$pValue"/>
						<xsl:with-param name="unit1" select="$pUnit"/>
					</xsl:call-template>
				</xsl:if>
				<xsl:if test="$mode='propertypair'">
					<tr>
						<th width="30%">
							<xsl:call-template name="valueorlink">
								<xsl:with-param name="text1" select="$pName"/>
								<xsl:with-param name="unit1" select="$pUnit"/>
							</xsl:call-template>
						</th>
						<td>
							<xsl:call-template name="valueorlink">
								<xsl:with-param name="text1" select="$pValue"/>
								<xsl:with-param name="unit1" select="$pUnit"/>
							</xsl:call-template>
						</td>
					</tr>
				</xsl:if>
			</xsl:if>
		</xsl:if>
	</xsl:template>
	<xsl:template name="subtable">
		<xsl:param name="list1"/>
		<xsl:param name="mode0">main</xsl:param>
		<xsl:if test="string-length($list1)>0">
			<xsl:variable name="list2">
				<xsl:call-template name="eachObject">
					<xsl:with-param name="list1" select="$list1"/>
					<xsl:with-param name="list2"/>
					<xsl:with-param name="mode1">propertynames</xsl:with-param>
				</xsl:call-template>
			</xsl:variable>
			<xsl:if test="$mode0='main'">
				<h2>
					<xsl:value-of select="substring-after(name(),'Ifc')"/> : <xsl:value-of select="ifc:Name"/>
				</h2>
				<table border="1" cellspacing="0" cellpadding="0" width="80%">
					<tr>
						<th width="25%">Category</th>
						<td width="75%">
							<xsl:value-of select="substring-after(name(),'Ifc')"/>
							<xsl:text> </xsl:text>
							<xsl:value-of select="ifc:ObjectType"/>
							<xsl:text> </xsl:text>
							<xsl:value-of select="ifc:ElementType"/>
							<xsl:text> </xsl:text>
							<xsl:value-of select="ifc:PredefinedType"/>
						</td>
					</tr>
					<tr>
						<th>
							<xsl:value-of select="substring-after(name(),'Ifc')"/>
						</th>
						<td>
							<xsl:value-of select="ifc:Name"/>
							<xsl:value-of select="$nbsp"/>
						</td>
					</tr>
					<tr>
						<th>Description</th>
						<td>
							<xsl:value-of select="ifc:Description"/>
							<xsl:if test="not(ifc:LongName=ifc:Description)">
								<xsl:text> </xsl:text>
								<xsl:value-of select="ifc:LongName"/>
							</xsl:if>
							<xsl:value-of select="$nbsp"/>
						</td>
					</tr>
					<tr>
						<th>Type</th>
						<td>
							<xsl:value-of select="key('find_id',key('find_ref',@id)/../../ifc:RelatingType/*[1]/@ref)/ifc:Name"/>
							<xsl:value-of select="$nbsp"/>
						</td>
					</tr>
					<!-- name and value of attributes of this object -->
					<xsl:call-template name="eachProperty">
						<xsl:with-param name="list1" select="substring-before($list1,$delim)"/>
						<xsl:with-param name="list2" select="$list2"/>
						<xsl:with-param name="mode2">propertypair</xsl:with-param>
					</xsl:call-template>
				</table>
			</xsl:if>
			<xsl:if test="not($mode0='main')">
				<h4>
					<xsl:value-of select="$mode0"/>
				</h4>
				<table border="1" cellspacing="0" cellpadding="0" width="100%">
					<tr>
						<th width="20%">Category</th>
						<th width="20%">
							<xsl:value-of select="$mode0"/>
						</th>
						<th width="20%">Description</th>
						<th width="20%">Type</th>
						<xsl:call-template name="eachProperty">
							<xsl:with-param name="list1" select="$list1"/>
							<xsl:with-param name="list2" select="$list2"/>
							<xsl:with-param name="mode2">propertyheader</xsl:with-param>
						</xsl:call-template>
					</tr>
					<xsl:call-template name="eachObject">
						<xsl:with-param name="list1" select="$list1"/>
						<xsl:with-param name="list2" select="$list2"/>
						<xsl:with-param name="mode1">objectrow</xsl:with-param>
					</xsl:call-template>
				</table>
			</xsl:if>
		</xsl:if>
	</xsl:template>
	<xsl:template name="valueorlink">
		<xsl:param name="text1"/>
		<xsl:param name="unit1"/>
		<xsl:choose>
			<xsl:when test="contains($text1, '://')">
				<a href="{$text1}" target="_blank">
					<xsl:value-of select="$text1"/>
				</a>
			</xsl:when>
			<xsl:when test="$text1">
				<xsl:call-template name="showName">
					<xsl:with-param name="text1" select="$text1"/>
				</xsl:call-template>
				<xsl:if test="not($unit1=$nbsp)">
					<xsl:text> </xsl:text>
					<xsl:value-of select="$unit1"/>
				</xsl:if>
			</xsl:when>
			<xsl:when test="$unit1">
				<xsl:value-of select="$unit1"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="$nbsp"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<xsl:template name="showName">
		<xsl:param name="text1"/>
		<xsl:variable name="f1" select="substring($text1,1,1)"/>
		<xsl:variable name="f2" select="substring($text1,2,1)"/>
		<xsl:value-of select="$f1"/>
		<xsl:if test="contains($lcletters,$f1) and contains($ucletters,$f2)">
			<xsl:text> </xsl:text>
		</xsl:if>
		<xsl:if test="string-length($f2)>0">
			<xsl:call-template name="showName">
				<xsl:with-param name="text1" select="substring($text1,2)"/>
			</xsl:call-template>
		</xsl:if>
	</xsl:template>
</xsl:stylesheet>
