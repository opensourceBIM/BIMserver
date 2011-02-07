<?xml version="1.0" encoding="ISO-8859-1"?>
<?altova_samplexml ..\cobie2\Tokmo_1.xml?>
<xsl:stylesheet version="1.0" xmlns:xl="urn:schemas-microsoft-com:office:spreadsheet" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:ifc="http://www.iai-tech.org/ifcXML/IFC2x3/FINAL" xmlns="http://www.iai-tech.org/ifcXML/IFC2x3/FINAL" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:ex="urn:iso.org:standard:10303:part(28):version(2):xmlschema:common" xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet" ex:version="2.0" xsi:schemaLocation="http://www.iai-tech.org/ifcXML/IFC2x3/FINAL IFC2x3.xsd" exclude-result-prefixes="fo xs fn xsi ss xl xlink">
	<xsl:output method="xml" indent="yes" encoding="UTF-8"/>
	<xsl:param name="param1">AEC3</xsl:param>
	<xsl:param name="dat1">
		<xsl:text>2009-09-01T12:34:56</xsl:text>
	</xsl:param>
	<xsl:param name="today1">
		<xsl:text>1251819722</xsl:text>
	</xsl:param>
	<xsl:param name="all">
		<xsl:text>no</xsl:text>
	</xsl:param>
	<xsl:param name="job">
		<xsl:text>yes</xsl:text>
	</xsl:param>
	<xsl:variable name="app1">_fromCOBie2</xsl:variable>
	<xsl:variable name="cln1"> : </xsl:variable>
	<xsl:variable name="delimiter">,</xsl:variable>
	<xsl:variable name="string1">;ü*':+{}()[]~?./&amp;°()@ ,&quot;-=</xsl:variable>
	<xsl:variable name="string2">__________________________</xsl:variable>
	<xsl:variable name="na">n/a</xsl:variable>
	<xsl:variable name="prj1">
		<xsl:for-each select="//xl:Worksheet[@ss:Name='Facility']/xl:Table/xl:Row[2]">
			<xsl:call-template name="getCellData">
				<xsl:with-param name="targetIndex" select="5"/>
			</xsl:call-template>
		</xsl:for-each>
	</xsl:variable>
	<xsl:variable name="sit1">
		<xsl:for-each select="//xl:Worksheet[@ss:Name='Facility']/xl:Table/xl:Row[2]">
			<xsl:call-template name="getCellData">
				<xsl:with-param name="targetIndex" select="6"/>
			</xsl:call-template>
		</xsl:for-each>
	</xsl:variable>
	<xsl:variable name="fac1">
		<xsl:for-each select="//xl:Worksheet[@ss:Name='Facility']/xl:Table/xl:Row[2]">
			<xsl:call-template name="getCellData">
				<xsl:with-param name="targetIndex" select="1"/>
			</xsl:call-template>
		</xsl:for-each>
	</xsl:variable>
	<xsl:variable name="mom1">
		<xsl:for-each select="//xl:Worksheet[@ss:Name='Facility']/xl:Table/xl:Row[2]">
			<xsl:call-template name="getCellData">
				<xsl:with-param name="targetIndex" select="11"/>
			</xsl:call-template>
		</xsl:for-each>
	</xsl:variable>
	<!-- Linear -->
	<xsl:variable name="nam1" select="//xl:Worksheet[@ss:Name='Facility']/xl:Table/xl:Row[2]/xl:Cell[7]/xl:Data"/>
	<xsl:variable name="unt1">
		<xsl:choose>
			<xsl:when test="$nam1='feet'">304.8</xsl:when>
			<xsl:when test="$nam1='meters'">1000.0</xsl:when>
			<xsl:when test="$nam1='millimeters'">1.0</xsl:when>
			<xsl:when test="$nam1='inches'">25.4</xsl:when>
			<xsl:when test="$nam1='foot'">304.8</xsl:when>
			<xsl:when test="$nam1='meter'">1000.0</xsl:when>
			<xsl:when test="$nam1='millimeter'">1.0</xsl:when>
			<xsl:when test="$nam1='inch'">25.4</xsl:when>
			<xsl:when test="$nam1='metre'">1000.0</xsl:when>
			<xsl:when test="$nam1='millimetre'">1.0</xsl:when>
			<xsl:otherwise>1.0</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>
	<!-- Area -->
	<xsl:variable name="nam2" select="//xl:Worksheet[@ss:Name='Facility']/xl:Table/xl:Row[2]/xl:Cell[8]/xl:Data"/>
	<xsl:variable name="unt2">
		<xsl:choose>
			<xsl:when test="$nam2='squarefeet'">0.0929029</xsl:when>
			<xsl:otherwise>1.0</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>
	<!-- Volume -->
	<xsl:variable name="nam3" select="//xl:Worksheet[@ss:Name='Facility']/xl:Table/xl:Row[2]/xl:Cell[9]/xl:Data"/>
	<xsl:variable name="unt3">
		<xsl:choose>
			<xsl:when test="$nam3='cubicfeet'">0.0283168</xsl:when>
			<xsl:otherwise>1.0</xsl:otherwise>
		</xsl:choose>
	</xsl:variable>
	<xsl:variable name="app">_fromCOBie2.ifcxml.xsl</xsl:variable>
	<xsl:variable name="dat" select="substring($dat1,1,10)"/>
	<xsl:variable name="tim" select="substring($dat1,11,8)"/>
	<xsl:variable name="cln"> : </xsl:variable>
	<xsl:template match="/">
		<xsl:comment>Mapping <xsl:value-of select="$app"/> v<xsl:value-of select="$dat"/> of COBie2 <xsl:value-of select="$prj1"/> to ifcXML by <xsl:value-of select="$param1"/>
		</xsl:comment>
		<xsl:element name="ex:iso_10303_28" namespace="urn:iso.org:standard:10303:part(28):version(2):xmlschema:common">
			<xsl:attribute name="xsi:schemaLocation" namespace="http://www.w3.org/2001/XMLSchema-instance">http://www.iai-tech.org/ifcXML/IFC2x3/FINAL IFC2x3.xsd</xsl:attribute>
			<xsl:attribute name="version">2.0</xsl:attribute>
			<xsl:element name="ifc:uos">
				<xsl:attribute name="id">_0</xsl:attribute>
				<IfcApplication id="ap_0">
					<ApplicationDeveloper>
						<IfcOrganization>
							<Id>
								<xsl:value-of select="$param1"/>
							</Id>
							<Name>
								<xsl:value-of select="$param1"/>
							</Name>
							<Description>
								<xsl:value-of select="$param1"/>
							</Description>
						</IfcOrganization>
					</ApplicationDeveloper>
					<Version>v<xsl:value-of select="$dat"/>
					</Version>
					<ApplicationFullName>
						<xsl:value-of select="$app"/> v<xsl:value-of select="$dat"/>
					</ApplicationFullName>
					<ApplicationIdentifier>
						<xsl:value-of select="$app"/>
					</ApplicationIdentifier>
				</IfcApplication>
				<IfcDateAndTime id="dt">
					<DateComponent>
						<IfcCalendarDate xsi:nil="true" ref="cd"/>
					</DateComponent>
					<TimeComponent>
						<IfcLocalTime xsi:nil="true" ref="lt"/>
					</TimeComponent>
				</IfcDateAndTime>
				<IfcCalendarDate id="cd">
					<DayComponent>
						<xsl:value-of select="substring($dat1,9,2)"/>
					</DayComponent>
					<MonthComponent>
						<xsl:value-of select="substring($dat1,6,2)"/>
					</MonthComponent>
					<YearComponent>
						<xsl:value-of select="substring($dat1,1,4)"/>
					</YearComponent>
				</IfcCalendarDate>
				<IfcLocalTime id="lt">
					<HourComponent>
						<xsl:value-of select="substring($dat1,12,2)"/>
					</HourComponent>
					<MinuteComponent>
						<xsl:value-of select="substring($dat1,15,2)"/>
					</MinuteComponent>
					<SecondComponent>
						<xsl:value-of select="substring($dat1,18,2)"/>
					</SecondComponent>
				</IfcLocalTime>
				<IfcCartesianPoint id="origin">
					<Coordinates ex:cType="list">
						<IfcLengthMeasure>0.</IfcLengthMeasure>
						<IfcLengthMeasure>0.</IfcLengthMeasure>
						<IfcLengthMeasure>0.</IfcLengthMeasure>
					</Coordinates>
				</IfcCartesianPoint>
				<!--
				<IfcCartesianPoint id="origin2d">
					<Coordinates>
						<IfcLengthMeasure pos="0">0.</IfcLengthMeasure>
						<IfcLengthMeasure pos="1">0.</IfcLengthMeasure>
					</Coordinates>
				</IfcCartesianPoint>
-->
				<IfcDirection id="east2d">
					<DirectionRatios>
						<ex:double-wrapper>1</ex:double-wrapper>
						<ex:double-wrapper>0</ex:double-wrapper>
					</DirectionRatios>
				</IfcDirection>
				<IfcDirection id="east">
					<DirectionRatios ex:cType="list">
						<ex:double-wrapper pos="0">1.</ex:double-wrapper>
						<ex:double-wrapper pos="1">0.</ex:double-wrapper>
						<ex:double-wrapper pos="2">0.</ex:double-wrapper>
					</DirectionRatios>
				</IfcDirection>
				<IfcDirection id="north">
					<DirectionRatios ex:cType="list">
						<ex:double-wrapper pos="0">0.</ex:double-wrapper>
						<ex:double-wrapper pos="1">1.</ex:double-wrapper>
						<ex:double-wrapper pos="2">0.</ex:double-wrapper>
					</DirectionRatios>
				</IfcDirection>
				<IfcDirection id="up">
					<DirectionRatios ex:cType="list">
						<ex:double-wrapper pos="0">0.</ex:double-wrapper>
						<ex:double-wrapper pos="1">0.</ex:double-wrapper>
						<ex:double-wrapper pos="2">1.</ex:double-wrapper>
					</DirectionRatios>
				</IfcDirection>
				<IfcAxis2Placement3D id="triple">
					<Location>
						<IfcCartesianPoint xsi:nil="true" ref="origin"/>
					</Location>
					<Axis>
						<IfcDirection xsi:nil="true" ref="up"/>
					</Axis>
					<RefDirection>
						<IfcDirection xsi:nil="true" ref="east"/>
					</RefDirection>
				</IfcAxis2Placement3D>
				<xsl:call-template name="approval1">
					<xsl:with-param name="desc1">
						<xsl:value-of select="count(//xl:Worksheet[@ss:Name='Issue']/xl:Table/xl:Row[string-length(xl:Cell[1]/xl:Data)>0]) - 1"/> previously documented issues</xsl:with-param>
					<xsl:with-param name="status1">Issue</xsl:with-param>
					<xsl:with-param name="level1">buildingSMART FM-10/COBie2</xsl:with-param>
					<xsl:with-param name="qualifier1">Issue</xsl:with-param>
					<xsl:with-param name="name1">Summary</xsl:with-param>
					<xsl:with-param name="identifier1">Summary</xsl:with-param>
				</xsl:call-template>
				<xsl:for-each select="//xl:Worksheet">
					<xsl:for-each select="xl:Table/xl:Row">
						<xsl:if test="position()>1">
							<xsl:apply-templates select=".">
								<xsl:with-param name="cd" select="../../@ss:Name"/>
							</xsl:apply-templates>
						</xsl:if>
					</xsl:for-each>
				</xsl:for-each>
			</xsl:element>
		</xsl:element>
	</xsl:template>
	<xsl:template match="xl:Row">
		<xsl:param name="cd" select="Unknown"/>
		<xsl:variable name="me">
			<xsl:call-template name="getCellData">
				<xsl:with-param name="targetIndex" select="1"/>
			</xsl:call-template>
		</xsl:variable>
		<xsl:if test="string-length(normalize-space($me))>0">
			<xsl:variable name="ohfull">
				<xsl:call-template name="getCellData">
					<xsl:with-param name="targetIndex" select="2"/>
				</xsl:call-template>
			</xsl:variable>
			<xsl:variable name="ohdate">
				<xsl:call-template name="getCellData">
					<xsl:with-param name="targetIndex" select="3"/>
				</xsl:call-template>
			</xsl:variable>
			<xsl:if test="($cd='Contact') or ($cd='Facility')  or ($cd='Floor')  or ($cd='Space')  or ($cd='Type')  or ($cd='Component')   or ($cd='Spare')   or ($cd='Resource')   or ($cd='Job')   or ($cd='Connection')   or ($cd='Issue') ">
				<xsl:choose>
					<xsl:when test="count(preceding-sibling::xl:Row[normalize-space(xl:Cell[1]/xl:Data)=normalize-space($me)])>0">
						<xsl:message>IfcApproval<xsl:value-of select="$cln1"/>NON COMPLIANT<xsl:value-of select="$me"/> is  not unique</xsl:message>
						<xsl:call-template name="approval1">
							<xsl:with-param name="desc1">
								<xsl:value-of select="$me"/> is not unique</xsl:with-param>
							<xsl:with-param name="level1">buildingSMART FM-10/COBie2</xsl:with-param>
							<xsl:with-param name="qualifier1">Data integrity</xsl:with-param>
							<xsl:with-param name="name1">Unique <xsl:value-of select="$cd"/> names</xsl:with-param>
							<xsl:with-param name="identifier1">Unique<xsl:value-of select="$cd"/> names</xsl:with-param>
						</xsl:call-template>
					</xsl:when>
					<xsl:when test="$all='yes'">
						<xsl:call-template name="approval1">
							<xsl:with-param name="desc1">
								<xsl:value-of select="$me"/> is unique</xsl:with-param>
							<xsl:with-param name="level1">buildingSMART FM-10/COBie2</xsl:with-param>
							<xsl:with-param name="qualifier1">Data integrity</xsl:with-param>
							<xsl:with-param name="name1">Unique <xsl:value-of select="$cd"/> names</xsl:with-param>
							<xsl:with-param name="identifier1">Unique <xsl:value-of select="$cd"/> names</xsl:with-param>
							<xsl:with-param name="status1">COMPLIANT</xsl:with-param>
						</xsl:call-template>
					</xsl:when>
				</xsl:choose>
			</xsl:if>
			<xsl:choose>
				<xsl:when test="$cd='Contact'">
					<xsl:message>
						<xsl:text>IfcOwnerHistory</xsl:text>
						<xsl:value-of select="$cln"/>
						<xsl:value-of select="$me"/>
					</xsl:message>
					<xsl:call-template name="checkInteresting">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="field1">Telephone Numbers</xsl:with-param>
						<xsl:with-param name="value1">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="6"/>
							</xsl:call-template>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:call-template name="checkInteresting">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="field1">Contact Role</xsl:with-param>
						<xsl:with-param name="value1">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="4"/>
							</xsl:call-template>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:call-template name="checkInteresting">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="field1">Organization Identification</xsl:with-param>
						<xsl:with-param name="value1">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="5"/>
							</xsl:call-template>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:choose>
						<xsl:when test="not(contains($me,'@')) or not(contains($me,'.')) or contains($me,' ')">
							<xsl:message>IfcApproval<xsl:value-of select="$cln1"/>NON COMPLIANT<xsl:value-of select="$me"/> is not an email address</xsl:message>
							<xsl:call-template name="approval1">
								<xsl:with-param name="desc1">
									<xsl:value-of select="$me"/> is not an email address</xsl:with-param>
								<xsl:with-param name="level1">buildingSMART FM-10/COBie2</xsl:with-param>
								<xsl:with-param name="qualifier1">Data format</xsl:with-param>
								<xsl:with-param name="name1">Format <xsl:value-of select="$cd"/> email</xsl:with-param>
								<xsl:with-param name="identifier1">Format <xsl:value-of select="$cd"/> email</xsl:with-param>
							</xsl:call-template>
						</xsl:when>
						<xsl:when test="$all='yes'">
							<xsl:call-template name="approval1">
								<xsl:with-param name="desc1">
									<xsl:value-of select="$me"/> is an email address</xsl:with-param>
								<xsl:with-param name="level1">buildingSMART FM-10/COBie2</xsl:with-param>
								<xsl:with-param name="qualifier1">Data format</xsl:with-param>
								<xsl:with-param name="name1">Format <xsl:value-of select="$cd"/> email</xsl:with-param>
								<xsl:with-param name="identifier1">Format<xsl:value-of select="$cd"/> email</xsl:with-param>
								<xsl:with-param name="status1">COMPLIANT</xsl:with-param>
							</xsl:call-template>
						</xsl:when>
					</xsl:choose>
					<xsl:element name="IfcOwnerHistory">
						<xsl:call-template name="makeID">
							<xsl:with-param name="cd" select="$cd"/>
							<xsl:with-param name="idref" select="$me"/>
						</xsl:call-template>
						<OwningUser>
							<IfcPersonAndOrganization>
								<ThePerson>
									<IfcPerson>
										<xsl:element name="FamilyName">
											<xsl:call-template name="getCellData">
												<xsl:with-param name="targetIndex" select="13"/>
											</xsl:call-template>
										</xsl:element>
										<xsl:element name="GivenName">
											<xsl:call-template name="getCellData">
												<xsl:with-param name="targetIndex" select="12"/>
											</xsl:call-template>
										</xsl:element>
									</IfcPerson>
								</ThePerson>
								<TheOrganization>
									<IfcOrganization>
										<Id>
											<xsl:call-template name="getCellData">
												<xsl:with-param name="targetIndex" select="1"/>
											</xsl:call-template>
										</Id>
										<Name>
											<xsl:call-template name="getCellData">
												<xsl:with-param name="targetIndex" select="5"/>
											</xsl:call-template>
										</Name>
										<Description>
											<xsl:call-template name="getCellData">
												<xsl:with-param name="targetIndex" select="5"/>
											</xsl:call-template>
										</Description>
										<xsl:element name="Roles">
											<xsl:element name="IfcActorRole">
												<xsl:element name="Role">
													<xsl:text>userdefined</xsl:text>
												</xsl:element>
												<xsl:element name="UserDefinedRole">
													<xsl:call-template name="getCellData">
														<xsl:with-param name="targetIndex" select="4"/>
													</xsl:call-template>
												</xsl:element>
											</xsl:element>
										</xsl:element>
										<xsl:element name="Addresses">
											<xsl:element name="IfcPostalAddress">
												<xsl:element name="Purpose">office</xsl:element>
												<xsl:element name="InternalLocation">
													<xsl:call-template name="getCellData">
														<xsl:with-param name="targetIndex" select="10"/>
													</xsl:call-template>
												</xsl:element>
												<xsl:element name="AddressLines">
													<xsl:element name="IfcLabel">
														<xsl:call-template name="getCellData">
															<xsl:with-param name="targetIndex" select="14"/>
														</xsl:call-template>
													</xsl:element>
												</xsl:element>
												<xsl:element name="Town">
													<xsl:call-template name="getCellData">
														<xsl:with-param name="targetIndex" select="16"/>
													</xsl:call-template>
												</xsl:element>
												<xsl:element name="Region">
													<xsl:call-template name="getCellData">
														<xsl:with-param name="targetIndex" select="17"/>
													</xsl:call-template>
												</xsl:element>
												<xsl:element name="PostalCode">
													<xsl:call-template name="getCellData">
														<xsl:with-param name="targetIndex" select="18"/>
													</xsl:call-template>
												</xsl:element>
												<xsl:element name="Country">
													<xsl:call-template name="getCellData">
														<xsl:with-param name="targetIndex" select="19"/>
													</xsl:call-template>
												</xsl:element>
											</xsl:element>
											<xsl:element name="IfcTelecomAddress">
												<xsl:element name="Purpose">office</xsl:element>
												<xsl:element name="TelephoneNumbers">
													<xsl:element name="IfcLabel">
														<xsl:call-template name="getCellData">
															<xsl:with-param name="targetIndex" select="6"/>
														</xsl:call-template>
													</xsl:element>
												</xsl:element>
												<xsl:element name="ElectronicMailAddresses">
													<xsl:element name="IfcLabel">
														<xsl:call-template name="getCellData">
															<xsl:with-param name="targetIndex" select="1"/>
														</xsl:call-template>
													</xsl:element>
												</xsl:element>
											</xsl:element>
										</xsl:element>
									</IfcOrganization>
								</TheOrganization>
							</IfcPersonAndOrganization>
						</OwningUser>
						<OwningApplication>
							<IfcApplication xsi:nil="true" ref="ap_0"/>
						</OwningApplication>
						<State>readwrite</State>
						<ChangeAction>nochange</ChangeAction>
						<CreationDate>
							<xsl:value-of select="$today1"/>
						</CreationDate>
					</xsl:element>
				</xsl:when>
				<xsl:when test="$cd='Facility'">
					<!-- Facility -->
					<xsl:call-template name="checkInteresting">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="field1">Project Name</xsl:with-param>
						<xsl:with-param name="value1">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="5"/>
							</xsl:call-template>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:call-template name="checkInteresting">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="field1">Site Name</xsl:with-param>
						<xsl:with-param name="value1">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="6"/>
							</xsl:call-template>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:call-template name="checkInteresting">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="field1">Classification Name</xsl:with-param>
						<xsl:with-param name="value1">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="4"/>
							</xsl:call-template>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:if test="position()=1">
						<xsl:message>
							<xsl:text>IfcProject</xsl:text>
							<xsl:value-of select="$cln"/>
							<xsl:value-of select="$prj1"/>
						</xsl:message>
						<xsl:call-template name="checkReference">
							<xsl:with-param name="sheet1" select="$cd"/>
							<xsl:with-param name="sheet2">Contact</xsl:with-param>
							<xsl:with-param name="field1">IfcProject.OwnerHistory</xsl:with-param>
							<xsl:with-param name="me1" select="$me"/>
							<xsl:with-param name="value1">
								<xsl:value-of select="$ohfull"/>
							</xsl:with-param>
						</xsl:call-template>
						<xsl:element name="IfcProject">
							<xsl:call-template name="makeID">
								<xsl:with-param name="idref" select="$prj1"/>
								<xsl:with-param name="cd">Project</xsl:with-param>
							</xsl:call-template>
							<xsl:call-template name="makeGUID">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="me" select="$me"/>
								<xsl:with-param name="ty">pr</xsl:with-param>
								<xsl:with-param name="cl">14</xsl:with-param>
								<xsl:with-param name="oh" select="$ohfull"/>
							</xsl:call-template>
							<Name>
								<xsl:value-of select="$prj1"/>
							</Name>
							<Description>
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="20"/>
								</xsl:call-template>
							</Description>
							<xsl:element name="ObjectType">
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="4"/>
								</xsl:call-template>
							</xsl:element>
							<LongName>
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="20"/>
								</xsl:call-template>
							</LongName>
							<Phase>
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="22"/>
								</xsl:call-template>
							</Phase>
							<RepresentationContexts ex:cType="set">
								<IfcGeometricRepresentationContext id="grc1">
									<ContextType>Design</ContextType>
									<CoordinateSpaceDimension>3</CoordinateSpaceDimension>
									<Precision>1.000000000E-5</Precision>
									<WorldCoordinateSystem>
										<IfcAxis2Placement3D xsi:nil="true" ref="triple"/>
									</WorldCoordinateSystem>
									<TrueNorth>
										<IfcDirection xsi:nil="true" ref="north"/>
									</TrueNorth>
								</IfcGeometricRepresentationContext>
							</RepresentationContexts>
							<UnitsInContext>
								<IfcUnitAssignment>
									<Units ex:cType="set">
										<IfcSIUnit id="u_mm">
											<UnitType>lengthunit</UnitType>
											<Prefix>milli</Prefix>
											<Name>metre</Name>
										</IfcSIUnit>
										<IfcSIUnit id="u_m2">
											<UnitType>areaunit</UnitType>
											<Name>square_metre</Name>
										</IfcSIUnit>
										<IfcSIUnit id="u_m3">
											<UnitType>volumeunit</UnitType>
											<Name>cubic_metre</Name>
										</IfcSIUnit>
										<IfcConversionBasedUnit id="u_deg">
											<Dimensions>
												<IfcDimensionalExponents>
													<LengthExponent>0</LengthExponent>
													<MassExponent>0</MassExponent>
													<TimeExponent>0</TimeExponent>
													<ElectricCurrentExponent>0</ElectricCurrentExponent>
													<ThermodynamicTemperatureExponent>0</ThermodynamicTemperatureExponent>
													<AmountOfSubstanceExponent>0</AmountOfSubstanceExponent>
													<LuminousIntensityExponent>0</LuminousIntensityExponent>
												</IfcDimensionalExponents>
											</Dimensions>
											<UnitType>planeangleunit</UnitType>
											<Name>DEGREE</Name>
											<ConversionFactor>
												<IfcMeasureWithUnit>
													<ValueComponent>
														<IfcPlaneAngleMeasure>0.017453293</IfcPlaneAngleMeasure>
													</ValueComponent>
													<UnitComponent>
														<IfcSIUnit>
															<UnitType>planeangleunit</UnitType>
															<Name>radian</Name>
														</IfcSIUnit>
													</UnitComponent>
												</IfcMeasureWithUnit>
											</ConversionFactor>
										</IfcConversionBasedUnit>
										<IfcSIUnit id="u_sa">
											<UnitType>solidangleunit</UnitType>
											<Name>steradian</Name>
										</IfcSIUnit>
										<IfcSIUnit id="u_g7">
											<UnitType>massunit</UnitType>
											<Name>gram</Name>
										</IfcSIUnit>
										<IfcSIUnit id="u_s">
											<UnitType>timeunit</UnitType>
											<Name>second</Name>
										</IfcSIUnit>
										<IfcSIUnit id="u_c">
											<UnitType>thermodynamictemperatureunit</UnitType>
											<Name>degree_celsius</Name>
										</IfcSIUnit>
										<IfcSIUnit id="u_li">
											<UnitType>luminousintensityunit</UnitType>
											<Name>lumen</Name>
										</IfcSIUnit>
									</Units>
								</IfcUnitAssignment>
							</UnitsInContext>
						</xsl:element>
						<xsl:comment>Project to Sites relationship</xsl:comment>
						<IfcRelAggregates>
							<xsl:call-template name="makeGUID">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="me" select="$me"/>
								<xsl:with-param name="ty">ra1</xsl:with-param>
								<xsl:with-param name="oh" select="$ohfull"/>
							</xsl:call-template>
							<Name>Project Container</Name>
							<Description>Project Contains Sites</Description>
							<RelatingObject>
								<xsl:call-template name="makeREF">
									<xsl:with-param name="cd">Project</xsl:with-param>
									<xsl:with-param name="obj">IfcProject</xsl:with-param>
									<xsl:with-param name="idref" select="$prj1"/>
								</xsl:call-template>
							</RelatingObject>
							<RelatedObjects ex:cType="set">
								<xsl:call-template name="makeREF">
									<xsl:with-param name="cd">Site</xsl:with-param>
									<xsl:with-param name="obj">IfcSite</xsl:with-param>
									<xsl:with-param name="idref" select="$sit1"/>
								</xsl:call-template>
							</RelatedObjects>
						</IfcRelAggregates>
						<xsl:message>
							<xsl:text>IfcSite</xsl:text>
							<xsl:value-of select="$cln"/>
						</xsl:message>
						<xsl:element name="IfcSite">
							<xsl:call-template name="makeID">
								<xsl:with-param name="idref" select="$sit1"/>
								<xsl:with-param name="cd">Site</xsl:with-param>
							</xsl:call-template>
							<xsl:call-template name="makeGUID">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="me" select="$me"/>
								<xsl:with-param name="ty">si</xsl:with-param>
								<xsl:with-param name="cl">16</xsl:with-param>
								<xsl:with-param name="oh" select="$ohfull"/>
							</xsl:call-template>
							<xsl:element name="Name">
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="6"/>
								</xsl:call-template>
							</xsl:element>
							<xsl:element name="Description">
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="21"/>
								</xsl:call-template>
							</xsl:element>
							<xsl:element name="ObjectType">
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="4"/>
								</xsl:call-template>
							</xsl:element>
							<ObjectPlacement>
								<xsl:call-template name="makeREF">
									<xsl:with-param name="cd" select="$cd"/>
									<xsl:with-param name="obj">IfcLocalPlacement</xsl:with-param>
									<xsl:with-param name="idref">
										<xsl:text>lp1_</xsl:text>
										<xsl:value-of select="$cd"/>
										<xsl:text>_</xsl:text>
										<xsl:value-of select="$me"/>
									</xsl:with-param>
								</xsl:call-template>
							</ObjectPlacement>
							<LongName>
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="20"/>
								</xsl:call-template>
							</LongName>
							<xsl:element name="CompositionType">
								<xsl:text>element</xsl:text>
							</xsl:element>
						</xsl:element>
						<xsl:element name="IfcLocalPlacement">
							<xsl:call-template name="makeID">
								<xsl:with-param name="idref">
									<xsl:text>lp1_</xsl:text>
									<xsl:value-of select="$cd"/>
									<xsl:text>_</xsl:text>
									<xsl:value-of select="$me"/>
								</xsl:with-param>
								<xsl:with-param name="cd" select="$cd"/>
							</xsl:call-template>
							<RelativePlacement>
								<IfcAxis2Placement3D xsi:nil="true" ref="triple"/>
							</RelativePlacement>
						</xsl:element>
						<xsl:comment>Site to Buildings relationship</xsl:comment>
						<IfcRelAggregates>
							<xsl:call-template name="makeGUID">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="me" select="$me"/>
								<xsl:with-param name="ty">ra2</xsl:with-param>
								<xsl:with-param name="oh" select="$ohfull"/>
							</xsl:call-template>
							<Name>Site Container</Name>
							<Description>Site Contains Building</Description>
							<RelatingObject>
								<xsl:call-template name="makeREF">
									<xsl:with-param name="cd">Site</xsl:with-param>
									<xsl:with-param name="obj">IfcSite</xsl:with-param>
									<xsl:with-param name="idref" select="$sit1"/>
								</xsl:call-template>
							</RelatingObject>
							<RelatedObjects ex:cType="set">
								<xsl:call-template name="makeREF">
									<xsl:with-param name="cd" select="$cd"/>
									<xsl:with-param name="obj">IfcBuilding</xsl:with-param>
									<xsl:with-param name="idref" select="$me"/>
								</xsl:call-template>
							</RelatedObjects>
						</IfcRelAggregates>
						<xsl:message>
							<xsl:text>IfcBuilding</xsl:text>
							<xsl:value-of select="$cln"/>
						</xsl:message>
						<xsl:element name="IfcBuilding">
							<xsl:call-template name="makeID">
								<xsl:with-param name="idref" select="$me"/>
								<xsl:with-param name="cd" select="$cd"/>
							</xsl:call-template>
							<xsl:call-template name="makeGUID">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="me" select="$me"/>
								<xsl:with-param name="ty">bu</xsl:with-param>
								<xsl:with-param name="cl">18</xsl:with-param>
								<xsl:with-param name="oh" select="$ohfull"/>
							</xsl:call-template>
							<xsl:element name="Name">
								<xsl:value-of select="$me"/>
							</xsl:element>
							<xsl:element name="Description">
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="19"/>
								</xsl:call-template>
							</xsl:element>
							<xsl:element name="ObjectType">
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="4"/>
								</xsl:call-template>
							</xsl:element>
							<ObjectPlacement>
								<xsl:call-template name="makeREF">
									<xsl:with-param name="cd" select="$cd"/>
									<xsl:with-param name="obj">IfcLocalPlacement</xsl:with-param>
									<xsl:with-param name="idref">
										<xsl:text>lp2_</xsl:text>
										<xsl:value-of select="$cd"/>
										<xsl:text>_</xsl:text>
										<xsl:value-of select="$me"/>
									</xsl:with-param>
								</xsl:call-template>
							</ObjectPlacement>
							<xsl:element name="CompositionType">
								<xsl:text>element</xsl:text>
							</xsl:element>
						</xsl:element>
						<xsl:element name="IfcLocalPlacement">
							<xsl:call-template name="makeID">
								<xsl:with-param name="idref">
									<xsl:text>lp2_</xsl:text>
									<xsl:value-of select="$cd"/>
									<xsl:text>_</xsl:text>
									<xsl:value-of select="$me"/>
								</xsl:with-param>
								<xsl:with-param name="cd" select="$cd"/>
							</xsl:call-template>
							<PlacementRelTo>
								<xsl:call-template name="makeREF">
									<xsl:with-param name="cd" select="$cd"/>
									<xsl:with-param name="obj">IfcLocalPlacement</xsl:with-param>
									<xsl:with-param name="idref">
										<xsl:text>lp1_</xsl:text>
										<xsl:value-of select="$cd"/>
										<xsl:text>_</xsl:text>
										<xsl:value-of select="$me"/>
									</xsl:with-param>
								</xsl:call-template>
							</PlacementRelTo>
							<RelativePlacement>
								<IfcAxis2Placement3D xsi:nil="true" ref="triple"/>
							</RelativePlacement>
						</xsl:element>
						<xsl:element name="IfcRelAssociatesClassification">
							<xsl:call-template name="makeGUID">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="me" select="$me"/>
								<xsl:with-param name="ty">rac</xsl:with-param>
								<xsl:with-param name="oh" select="$ohfull"/>
							</xsl:call-template>
							<xsl:element name="RelatedObjects">
								<xsl:call-template name="makeREF">
									<xsl:with-param name="cd" select="$cd"/>
									<xsl:with-param name="obj">IfcBuilding</xsl:with-param>
									<xsl:with-param name="idref" select="$me"/>
								</xsl:call-template>
							</xsl:element>
							<xsl:element name="RelatingClassification">
								<xsl:call-template name="makeCategory">
									<xsl:with-param name="cd" select="$cd"/>
									<xsl:with-param name="tx">
										<xsl:call-template name="getCellData">
											<xsl:with-param name="targetIndex" select="4"/>
										</xsl:call-template>
									</xsl:with-param>
								</xsl:call-template>
							</xsl:element>
						</xsl:element>
						<xsl:if test="count(//xl:Worksheet[@ss:Name='Floor']/xl:Table/xl:Row)>1">
							<xsl:comment>Building to Floor relationship</xsl:comment>
							<IfcRelAggregates>
								<xsl:call-template name="makeGUID">
									<xsl:with-param name="cd" select="$cd"/>
									<xsl:with-param name="me" select="$me"/>
									<xsl:with-param name="ty">ra3</xsl:with-param>
									<xsl:with-param name="oh" select="$ohfull"/>
								</xsl:call-template>
								<Name>Building Container</Name>
								<Description>Building Contains Storeys</Description>
								<RelatingObject>
									<xsl:call-template name="makeREF">
										<xsl:with-param name="cd" select="$cd"/>
										<xsl:with-param name="obj">IfcBuilding</xsl:with-param>
										<xsl:with-param name="idref" select="$me"/>
									</xsl:call-template>
								</RelatingObject>
								<RelatedObjects ex:cType="set">
									<xsl:for-each select="//xl:Worksheet[@ss:Name='Floor']/xl:Table/xl:Row[position()>1]">
										<xsl:variable name="me1">
											<xsl:call-template name="getCellData">
												<xsl:with-param name="targetIndex" select="1"/>
											</xsl:call-template>
										</xsl:variable>
										<xsl:call-template name="makeREF">
											<xsl:with-param name="cd">Floor</xsl:with-param>
											<xsl:with-param name="obj">IfcBuildingStorey</xsl:with-param>
											<xsl:with-param name="idref" select="$me1"/>
										</xsl:call-template>
									</xsl:for-each>
								</RelatedObjects>
							</IfcRelAggregates>
						</xsl:if>
						<xsl:call-template name="makeAttributes">
							<xsl:with-param name="ty" select="$cd"/>
							<xsl:with-param name="me" select="$me"/>
							<xsl:with-param name="ob">IfcBuilding</xsl:with-param>
							<xsl:with-param name="oh" select="$ohfull"/>
						</xsl:call-template>
					</xsl:if>
					<!--
					<xsl:if test="count(//xl:Worksheet[@ss:Name='Component']/xl:Table/xl:Row[xl:Cell[5]/xl:Data/text()=$na])>0">
						<xsl:comment>Building to Component relationship</xsl:comment>
						<IfcRelContainedInSpatialStructure>
							<xsl:call-template name="makeGUID">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="me" select="$me"/>
								<xsl:with-param name="ty">rciss</xsl:with-param>
								<xsl:with-param name="oh" select="$ohfull"/>
							</xsl:call-template>
							<Name>Building Container</Name>
							<Description>Building Contains Components</Description>
							<RelatedElements ex:cType="set">
								<xsl:for-each select="//xl:Worksheet[@ss:Name='Component']/xl:Table/xl:Row[xl:Cell[5]/xl:Data/text()=$na]">
									<xsl:call-template name="makeREF">
										<xsl:with-param name="cd">Component</xsl:with-param>
										<xsl:with-param name="obj">IfcFurnishingElement</xsl:with-param>
										<xsl:with-param name="idref">
											<xsl:call-template name="getCellData">
												<xsl:with-param name="targetIndex" select="1"/>
											</xsl:call-template>
										</xsl:with-param>
									</xsl:call-template>
								</xsl:for-each>
							</RelatedElements>
							<RelatingStructure>
								<xsl:call-template name="makeREF">
									<xsl:with-param name="cd" select="$cd"/>
									<xsl:with-param name="obj">IfcBuilding</xsl:with-param>
									<xsl:with-param name="idref" select="$me"/>
								</xsl:call-template>
							</RelatingStructure>
						</IfcRelContainedInSpatialStructure>
					</xsl:if>
                    -->
				</xsl:when>
				<xsl:when test="$cd='Floor'">
					<xsl:call-template name="checkReference">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="sheet2">Contact</xsl:with-param>
						<xsl:with-param name="field1">IfcBuildingStorey.OwnerHistory</xsl:with-param>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="value1">
							<xsl:value-of select="$ohfull"/>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:call-template name="checkInteresting">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="field1">Classification Name</xsl:with-param>
						<xsl:with-param name="value1">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="4"/>
							</xsl:call-template>
						</xsl:with-param>
					</xsl:call-template>
					<!-- Floor -->
					<xsl:variable name="eheight">
						<xsl:call-template name="zero">
							<xsl:with-param name="avalue">
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="11"/>
								</xsl:call-template>
							</xsl:with-param>
						</xsl:call-template>
					</xsl:variable>
					<xsl:variable name="evalue2" select="$unt1 * $eheight"/>
					<xsl:message>
						<xsl:text>IfcBuildingStorey</xsl:text>
						<xsl:value-of select="$cln"/>
						<xsl:value-of select="$me"/>
						<xsl:value-of select="$cln"/>
						<xsl:value-of select="$evalue2"/>
					</xsl:message>
					<xsl:element name="IfcBuildingStorey">
						<xsl:call-template name="makeID">
							<xsl:with-param name="idref" select="$me"/>
							<xsl:with-param name="cd" select="$cd"/>
						</xsl:call-template>
						<xsl:call-template name="makeGUID">
							<xsl:with-param name="cd" select="$cd"/>
							<xsl:with-param name="me" select="$me"/>
							<xsl:with-param name="ty">bs</xsl:with-param>
							<xsl:with-param name="cl">8</xsl:with-param>
							<xsl:with-param name="oh" select="$ohfull"/>
						</xsl:call-template>
						<xsl:element name="Name">
							<xsl:value-of select="$me"/>
						</xsl:element>
						<xsl:element name="Description">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="9"/>
							</xsl:call-template>
						</xsl:element>
						<xsl:element name="ObjectType">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="4"/>
							</xsl:call-template>
						</xsl:element>
						<ObjectPlacement>
							<xsl:call-template name="makeREF">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="obj">IfcLocalPlacement</xsl:with-param>
								<xsl:with-param name="idref">
									<xsl:text>lp_</xsl:text>
									<xsl:value-of select="$cd"/>
									<xsl:text>_</xsl:text>
									<xsl:value-of select="$me"/>
								</xsl:with-param>
							</xsl:call-template>
						</ObjectPlacement>
						<xsl:element name="CompositionType">
							<xsl:text>element</xsl:text>
						</xsl:element>
						<xsl:element name="Elevation">
							<xsl:value-of select="$evalue2"/>
						</xsl:element>
					</xsl:element>
					<xsl:element name="IfcLocalPlacement">
						<xsl:call-template name="makeID">
							<xsl:with-param name="idref">
								<xsl:text>lp_</xsl:text>
								<xsl:value-of select="$cd"/>
								<xsl:text>_</xsl:text>
								<xsl:value-of select="$me"/>
							</xsl:with-param>
							<xsl:with-param name="cd" select="$cd"/>
						</xsl:call-template>
						<PlacementRelTo>
							<xsl:call-template name="makeREF">
								<xsl:with-param name="cd">Facility</xsl:with-param>
								<xsl:with-param name="obj">IfcLocalPlacement</xsl:with-param>
								<xsl:with-param name="idref">
									<xsl:text>lp2_Facility_</xsl:text>
									<xsl:value-of select="$fac1"/>
								</xsl:with-param>
							</xsl:call-template>
						</PlacementRelTo>
						<RelativePlacement>
							<IfcAxis2Placement3D>
								<Location>
									<IfcCartesianPoint>
										<Coordinates ex:cType="list">
											<IfcLengthMeasure>0.</IfcLengthMeasure>
											<IfcLengthMeasure>0.</IfcLengthMeasure>
											<IfcLengthMeasure>
												<xsl:value-of select="$evalue2"/>
											</IfcLengthMeasure>
										</Coordinates>
									</IfcCartesianPoint>
								</Location>
								<Axis>
									<IfcDirection xsi:nil="true" ref="up"/>
								</Axis>
								<RefDirection>
									<IfcDirection xsi:nil="true" ref="east"/>
								</RefDirection>
							</IfcAxis2Placement3D>
						</RelativePlacement>
					</xsl:element>
					<xsl:if test="count(//xl:Worksheet[@ss:Name='Space']/xl:Table/xl:Row[xl:Cell[5]/xl:Data/text()=$me])>0">
						<xsl:comment>Floor to Space relationship</xsl:comment>
						<IfcRelAggregates>
							<xsl:call-template name="makeGUID">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="me" select="$me"/>
								<xsl:with-param name="ty">ra4</xsl:with-param>
								<xsl:with-param name="oh" select="$ohfull"/>
							</xsl:call-template>
							<Name>Storey Container</Name>
							<Description>Storey Contains Spaces</Description>
							<RelatingObject>
								<xsl:call-template name="makeREF">
									<xsl:with-param name="cd" select="$cd"/>
									<xsl:with-param name="obj">IfcBuildingStorey</xsl:with-param>
									<xsl:with-param name="idref" select="$me"/>
								</xsl:call-template>
							</RelatingObject>
							<RelatedObjects ex:cType="set">
								<xsl:for-each select="//xl:Worksheet[@ss:Name='Space']/xl:Table/xl:Row[xl:Cell[5]/xl:Data/text()=$me]">
									<xsl:variable name="me1">
										<xsl:call-template name="getCellData">
											<xsl:with-param name="targetIndex" select="1"/>
										</xsl:call-template>
									</xsl:variable>
									<xsl:call-template name="makeREF">
										<xsl:with-param name="cd">Space</xsl:with-param>
										<xsl:with-param name="obj">IfcSpace</xsl:with-param>
										<xsl:with-param name="idref" select="$me1"/>
									</xsl:call-template>
								</xsl:for-each>
							</RelatedObjects>
						</IfcRelAggregates>
					</xsl:if>
					<xsl:call-template name="makeAttributes">
						<xsl:with-param name="ty" select="$cd"/>
						<xsl:with-param name="me" select="$me"/>
						<xsl:with-param name="ob">IfcBuildingStorey</xsl:with-param>
						<xsl:with-param name="oh" select="$ohfull"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:when test="$cd='Space'">
					<!-- Space -->
					<xsl:message>
						<xsl:text>IfcSpace</xsl:text>
						<xsl:value-of select="$cln"/>
						<xsl:value-of select="$me"/>
					</xsl:message>
					<xsl:call-template name="checkReference">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="sheet2">Contact</xsl:with-param>
						<xsl:with-param name="field1">IfcSpace.OwnerHistory</xsl:with-param>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="value1">
							<xsl:value-of select="$ohfull"/>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:call-template name="checkReference">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="sheet2">Floor</xsl:with-param>
						<xsl:with-param name="field1">IfcSpace.ReferencesElements</xsl:with-param>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="value1">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="5"/>
							</xsl:call-template>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:call-template name="checkInteresting">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="field1">Classification Name</xsl:with-param>
						<xsl:with-param name="value1">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="4"/>
							</xsl:call-template>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:call-template name="checkInteresting">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="field1">Space Description</xsl:with-param>
						<xsl:with-param name="value1">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="6"/>
							</xsl:call-template>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:element name="IfcSpace">
						<xsl:call-template name="makeID">
							<xsl:with-param name="idref" select="$me"/>
							<xsl:with-param name="cd" select="$cd"/>
						</xsl:call-template>
						<xsl:call-template name="makeGUID">
							<xsl:with-param name="cd" select="$cd"/>
							<xsl:with-param name="me" select="$me"/>
							<xsl:with-param name="ty">sp</xsl:with-param>
							<xsl:with-param name="cl">9</xsl:with-param>
							<xsl:with-param name="oh" select="$ohfull"/>
						</xsl:call-template>
						<xsl:element name="Name">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="1"/>
							</xsl:call-template>
						</xsl:element>
						<xsl:element name="Description">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="6"/>
							</xsl:call-template>
						</xsl:element>
						<xsl:element name="ObjectType">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="4"/>
							</xsl:call-template>
						</xsl:element>
						<ObjectPlacement>
							<xsl:call-template name="makeREF">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="obj">IfcLocalPlacement</xsl:with-param>
								<xsl:with-param name="idref">
									<xsl:text>lp_</xsl:text>
									<xsl:value-of select="$cd"/>
									<xsl:text>_</xsl:text>
									<xsl:value-of select="$me"/>
								</xsl:with-param>
							</xsl:call-template>
						</ObjectPlacement>
						<xsl:call-template name="makeShape">
							<xsl:with-param name="ty" select="$cd"/>
							<xsl:with-param name="key1" select="$me"/>
						</xsl:call-template>
						<LongName>
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="6"/>
							</xsl:call-template>
						</LongName>
						<xsl:element name="CompositionType">
							<xsl:text>element</xsl:text>
						</xsl:element>
						<xsl:element name="InteriorOrExteriorSpace">
							<xsl:text>internal</xsl:text>
						</xsl:element>
					</xsl:element>
					<xsl:variable name="me1">
						<xsl:call-template name="getCellIndex">
							<xsl:with-param name="targetIndex" select="5"/>
						</xsl:call-template>
					</xsl:variable>
					<xsl:element name="IfcLocalPlacement">
						<xsl:call-template name="makeID">
							<xsl:with-param name="idref">
								<xsl:text>lp_</xsl:text>
								<xsl:value-of select="$cd"/>
								<xsl:text>_</xsl:text>
								<xsl:value-of select="$me"/>
							</xsl:with-param>
							<xsl:with-param name="cd" select="$cd"/>
						</xsl:call-template>
						<xsl:if test="not($me1=$na)">
							<PlacementRelTo>
								<xsl:call-template name="makeREF">
									<xsl:with-param name="cd">Floor</xsl:with-param>
									<xsl:with-param name="obj">IfcLocalPlacement</xsl:with-param>
									<xsl:with-param name="idref">
										<xsl:text>lp_Floor_</xsl:text>
										<xsl:value-of select="$me1"/>
									</xsl:with-param>
								</xsl:call-template>
							</PlacementRelTo>
						</xsl:if>
						<RelativePlacement>
							<IfcAxis2Placement3D>
								<Location>
									<IfcCartesianPoint>
										<Coordinates ex:cType="list">
											<IfcLengthMeasure>
												<xsl:call-template name="zero">
													<xsl:with-param name="avalue">
														<xsl:call-template name="geometry">
															<xsl:with-param name="type" select="$cd"/>
															<xsl:with-param name="mode">lowerleft</xsl:with-param>
															<xsl:with-param name="axis">1</xsl:with-param>
															<xsl:with-param name="key1" select="$me"/>
														</xsl:call-template>
													</xsl:with-param>
												</xsl:call-template>
											</IfcLengthMeasure>
											<IfcLengthMeasure>
												<xsl:call-template name="zero">
													<xsl:with-param name="avalue">
														<xsl:call-template name="geometry">
															<xsl:with-param name="type" select="$cd"/>
															<xsl:with-param name="mode">lowerleft</xsl:with-param>
															<xsl:with-param name="axis">2</xsl:with-param>
															<xsl:with-param name="key1" select="$me"/>
														</xsl:call-template>
													</xsl:with-param>
												</xsl:call-template>
											</IfcLengthMeasure>
											<IfcLengthMeasure>
												<xsl:call-template name="zero">
													<xsl:with-param name="avalue">
														<xsl:call-template name="geometry">
															<xsl:with-param name="type" select="$cd"/>
															<xsl:with-param name="mode">lowerleft</xsl:with-param>
															<xsl:with-param name="axis">3</xsl:with-param>
															<xsl:with-param name="key1" select="$me"/>
														</xsl:call-template>
													</xsl:with-param>
												</xsl:call-template>
											</IfcLengthMeasure>
										</Coordinates>
									</IfcCartesianPoint>
								</Location>
								<Axis>
									<IfcDirection xsi:nil="true" ref="up"/>
								</Axis>
								<RefDirection>
									<IfcDirection xsi:nil="true" ref="east"/>
								</RefDirection>
							</IfcAxis2Placement3D>
						</RelativePlacement>
					</xsl:element>
					<!-- coloration -->
					<IfcStyledItem>
						<Item>
							<xsl:call-template name="makeREF">
								<xsl:with-param name="cd">Space</xsl:with-param>
								<xsl:with-param name="obj">IfcExtrudedAreaSolid</xsl:with-param>
								<xsl:with-param name="idref">
									<xsl:text>item_</xsl:text>
									<xsl:value-of select="$me"/>
								</xsl:with-param>
							</xsl:call-template>
						</Item>
						<Styles>
							<xsl:call-template name="makeColor">
								<xsl:with-param name="cd1">Space</xsl:with-param>
								<xsl:with-param name="me1" select="$me"/>
								<xsl:with-param name="ifc1">IfcPresentationStyleAssignment</xsl:with-param>
							</xsl:call-template>
						</Styles>
					</IfcStyledItem>
					<!-- classification -->
					<xsl:element name="IfcRelAssociatesClassification">
						<xsl:call-template name="makeGUID">
							<xsl:with-param name="cd" select="$cd"/>
							<xsl:with-param name="me" select="$me"/>
							<xsl:with-param name="ty">rac</xsl:with-param>
							<xsl:with-param name="oh" select="$ohfull"/>
						</xsl:call-template>
						<xsl:element name="RelatedObjects">
							<xsl:call-template name="makeREF">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="obj">IfcSpace</xsl:with-param>
								<xsl:with-param name="idref" select="$me"/>
							</xsl:call-template>
						</xsl:element>
						<xsl:element name="RelatingClassification">
							<xsl:call-template name="makeCategory">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="tx">
									<xsl:call-template name="getCellData">
										<xsl:with-param name="targetIndex" select="4"/>
									</xsl:call-template>
								</xsl:with-param>
							</xsl:call-template>
						</xsl:element>
					</xsl:element>
					<xsl:if test="count(//xl:Worksheet[@ss:Name='Component']/xl:Table/xl:Row[(xl:Cell[5]/xl:Data/text()=$me) or (substring-before(xl:Cell[5]/xl:Data/text(),$delimiter)=$me)])">
						<xsl:comment>Space to Component relationship</xsl:comment>
						<IfcRelContainedInSpatialStructure>
							<xsl:call-template name="makeGUID">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="me" select="$me"/>
								<xsl:with-param name="ty">rciss</xsl:with-param>
								<xsl:with-param name="oh" select="$ohfull"/>
							</xsl:call-template>
							<Name>Space Container</Name>
							<Description>Space Contains Products</Description>
							<RelatedElements ex:cType="set">
								<xsl:for-each select="//xl:Worksheet[@ss:Name='Component']/xl:Table/xl:Row[(xl:Cell[5]/xl:Data/text()=$me) or (substring-before(xl:Cell[5]/xl:Data/text(),$delimiter)=$me)]">
									<xsl:call-template name="makeREF">
										<xsl:with-param name="cd">Component</xsl:with-param>
										<xsl:with-param name="obj">IfcFurnishingElement</xsl:with-param>
										<xsl:with-param name="idref">
											<xsl:call-template name="getCellData">
												<xsl:with-param name="targetIndex" select="1"/>
											</xsl:call-template>
										</xsl:with-param>
									</xsl:call-template>
								</xsl:for-each>
							</RelatedElements>
							<RelatingStructure>
								<xsl:call-template name="makeREF">
									<xsl:with-param name="cd" select="$cd"/>
									<xsl:with-param name="obj">IfcSpace</xsl:with-param>
									<xsl:with-param name="idref" select="$me"/>
								</xsl:call-template>
							</RelatingStructure>
						</IfcRelContainedInSpatialStructure>
					</xsl:if>
					<xsl:call-template name="makeAttributes">
						<xsl:with-param name="ty" select="$cd"/>
						<xsl:with-param name="ob">IfcSpace</xsl:with-param>
						<xsl:with-param name="me" select="$me"/>
						<xsl:with-param name="oh" select="$ohfull"/>
					</xsl:call-template>
					<IfcRelDefinesByProperties>
						<xsl:call-template name="makeGUID">
							<xsl:with-param name="cd" select="$cd"/>
							<xsl:with-param name="me" select="$me"/>
							<xsl:with-param name="ty">rdp4</xsl:with-param>
							<xsl:with-param name="oh" select="$ohfull"/>
						</xsl:call-template>
						<RelatedObjects>
							<xsl:call-template name="makeREF">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="obj">IfcSpace</xsl:with-param>
								<xsl:with-param name="idref" select="$me"/>
							</xsl:call-template>
						</RelatedObjects>
						<RelatingPropertyDefinition>
							<IfcElementQuantity>
								<xsl:call-template name="makeGUID">
									<xsl:with-param name="cd" select="$cd"/>
									<xsl:with-param name="me" select="$me"/>
									<xsl:with-param name="ty">eq</xsl:with-param>
									<xsl:with-param name="oh" select="$ohfull"/>
								</xsl:call-template>
								<Name>BaseQuantities</Name>
								<Description>Base Quantities</Description>
								<MethodOfMeasurement>
									<xsl:value-of select="$mom1"/>
								</MethodOfMeasurement>
								<xsl:variable name="gfa">
									<xsl:call-template name="getCellData">
										<xsl:with-param name="targetIndex" select="12"/>
									</xsl:call-template>
								</xsl:variable>
								<xsl:variable name="nfa">
									<xsl:call-template name="getCellData">
										<xsl:with-param name="targetIndex" select="13"/>
									</xsl:call-template>
								</xsl:variable>
								<Quantities>
									<IfcQuantityArea>
										<Name>NetFloorArea</Name>
										<Description>Net Floor Area</Description>
										<AreaValue>
											<xsl:value-of select="$nfa * $unt2"/>
										</AreaValue>
									</IfcQuantityArea>
									<IfcQuantityArea>
										<Name>GrossFloorArea</Name>
										<Description>Gross Floor Area</Description>
										<AreaValue>
											<xsl:value-of select="$gfa * $unt2"/>
										</AreaValue>
									</IfcQuantityArea>
								</Quantities>
							</IfcElementQuantity>
						</RelatingPropertyDefinition>
					</IfcRelDefinesByProperties>
				</xsl:when>
				<xsl:when test="$cd='Zone'">
					<!-- Zone -->
					<xsl:if test="count(preceding-sibling::xl:Row[normalize-space(xl:Cell[1]/xl:Data)=normalize-space($me)])=0">
						<xsl:message>
							<xsl:text>IfcZone</xsl:text>
							<xsl:value-of select="$cln"/>
							<xsl:value-of select="$me"/>
						</xsl:message>
						<xsl:call-template name="checkReference">
							<xsl:with-param name="sheet1" select="$cd"/>
							<xsl:with-param name="sheet2">Contact</xsl:with-param>
							<xsl:with-param name="field1">IfcZone.OwnerHistory</xsl:with-param>
							<xsl:with-param name="me1" select="$me"/>
							<xsl:with-param name="value1">
								<xsl:value-of select="$ohfull"/>
							</xsl:with-param>
						</xsl:call-template>
						<xsl:call-template name="checkInteresting">
							<xsl:with-param name="sheet1" select="$cd"/>
							<xsl:with-param name="me1" select="$me"/>
							<xsl:with-param name="field1">Classification Name</xsl:with-param>
							<xsl:with-param name="value1">
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="4"/>
								</xsl:call-template>
							</xsl:with-param>
						</xsl:call-template>
						<xsl:element name="IfcZone">
							<xsl:call-template name="makeID">
								<xsl:with-param name="idref" select="$me"/>
								<xsl:with-param name="cd" select="$cd"/>
							</xsl:call-template>
							<xsl:call-template name="makeGUID">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="me" select="$me"/>
								<xsl:with-param name="ty">zn</xsl:with-param>
								<xsl:with-param name="cl">8</xsl:with-param>
								<xsl:with-param name="oh" select="$ohfull"/>
							</xsl:call-template>
							<xsl:element name="Name">
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="1"/>
								</xsl:call-template>
							</xsl:element>
							<xsl:element name="Description">
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="9"/>
								</xsl:call-template>
							</xsl:element>
							<xsl:element name="ObjectType">
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="4"/>
								</xsl:call-template>
							</xsl:element>
						</xsl:element>
						<xsl:if test="string-length(xl:Cell[5]/xl:Data)>0">
							<IfcRelAssignsToGroup>
								<xsl:call-template name="makeGUID">
									<xsl:with-param name="cd" select="$cd"/>
									<xsl:with-param name="me" select="$me"/>
									<xsl:with-param name="ty">ratg</xsl:with-param>
									<xsl:with-param name="oh" select="$ohfull"/>
								</xsl:call-template>
								<Name>Zone Contents</Name>
								<Description>Zone contains Spaces</Description>
								<RelatedObjects>
									<xsl:for-each select="../*[normalize-space(xl:Cell[1]/xl:Data)=normalize-space($me)]">
										<xsl:call-template name="recurseList">
											<xsl:with-param name="cd">Space</xsl:with-param>
											<xsl:with-param name="seq">
												<xsl:call-template name="getCellData">
													<xsl:with-param name="targetIndex">5</xsl:with-param>
												</xsl:call-template>
											</xsl:with-param>
											<xsl:with-param name="ty">IfcSpace</xsl:with-param>
										</xsl:call-template>
									</xsl:for-each>
								</RelatedObjects>
								<RelatingGroup>
									<xsl:call-template name="makeREF">
										<xsl:with-param name="cd">Zone</xsl:with-param>
										<xsl:with-param name="obj">IfcZone</xsl:with-param>
										<xsl:with-param name="idref" select="$me"/>
									</xsl:call-template>
								</RelatingGroup>
							</IfcRelAssignsToGroup>
						</xsl:if>
						<xsl:call-template name="makeAttributes">
							<xsl:with-param name="ty" select="$cd"/>
							<xsl:with-param name="me" select="$me"/>
							<xsl:with-param name="ob">IfcZone</xsl:with-param>
							<xsl:with-param name="oh" select="$ohfull"/>
						</xsl:call-template>
						<xsl:element name="IfcRelAssociatesClassification">
							<xsl:call-template name="makeGUID">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="me" select="$me"/>
								<xsl:with-param name="ty">rac</xsl:with-param>
								<xsl:with-param name="oh" select="$ohfull"/>
							</xsl:call-template>
							<xsl:element name="RelatedObjects">
								<xsl:call-template name="makeREF">
									<xsl:with-param name="cd" select="$cd"/>
									<xsl:with-param name="obj">IfcZone</xsl:with-param>
									<xsl:with-param name="idref" select="$me"/>
								</xsl:call-template>
							</xsl:element>
							<xsl:element name="RelatingClassification">
								<xsl:call-template name="makeCategory">
									<xsl:with-param name="cd" select="$cd"/>
									<xsl:with-param name="tx">
										<xsl:call-template name="getCellData">
											<xsl:with-param name="targetIndex" select="4"/>
										</xsl:call-template>
									</xsl:with-param>
								</xsl:call-template>
							</xsl:element>
						</xsl:element>
					</xsl:if>
				</xsl:when>
				<xsl:when test="$cd='System'">
					<!-- System -->
					<xsl:if test="count(preceding-sibling::xl:Row[normalize-space(xl:Cell[1]/xl:Data)=normalize-space($me)])=0">
						<xsl:message>
							<xsl:text>IfcSystem</xsl:text>
							<xsl:value-of select="$cln"/>
							<xsl:value-of select="$me"/>
						</xsl:message>
						<xsl:call-template name="checkReference">
							<xsl:with-param name="sheet1" select="$cd"/>
							<xsl:with-param name="sheet2">Contact</xsl:with-param>
							<xsl:with-param name="field1">IfcSystem.OwnerHistory</xsl:with-param>
							<xsl:with-param name="me1" select="$me"/>
							<xsl:with-param name="value1">
								<xsl:value-of select="$ohfull"/>
							</xsl:with-param>
						</xsl:call-template>
						<xsl:call-template name="checkInteresting">
							<xsl:with-param name="sheet1" select="$cd"/>
							<xsl:with-param name="me1" select="$me"/>
							<xsl:with-param name="field1">Classification Name</xsl:with-param>
							<xsl:with-param name="value1">
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="4"/>
								</xsl:call-template>
							</xsl:with-param>
						</xsl:call-template>
						<xsl:element name="IfcSystem">
							<xsl:call-template name="makeID">
								<xsl:with-param name="idref" select="$me"/>
								<xsl:with-param name="cd" select="$cd"/>
							</xsl:call-template>
							<xsl:call-template name="makeGUID">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="me" select="$me"/>
								<xsl:with-param name="ty">sy</xsl:with-param>
								<xsl:with-param name="cl">8</xsl:with-param>
								<xsl:with-param name="oh" select="$ohfull"/>
							</xsl:call-template>
							<xsl:element name="Name">
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="1"/>
								</xsl:call-template>
							</xsl:element>
							<xsl:element name="Description">
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="6"/>
								</xsl:call-template>
							</xsl:element>
							<xsl:element name="ObjectType">
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="4"/>
								</xsl:call-template>
							</xsl:element>
						</xsl:element>
						<IfcRelServicesBuildings>
							<xsl:call-template name="makeGUID">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="me" select="$me"/>
								<xsl:with-param name="ty">rsb</xsl:with-param>
								<xsl:with-param name="oh" select="$ohfull"/>
							</xsl:call-template>
							<Name>System Container</Name>
							<Description>System Services Spatial</Description>
							<RelatingSystem>
								<xsl:call-template name="makeREF">
									<xsl:with-param name="cd" select="$cd"/>
									<xsl:with-param name="obj">IfcSystem</xsl:with-param>
									<xsl:with-param name="idref" select="$me"/>
								</xsl:call-template>
							</RelatingSystem>
							<RelatedBuildings ex:cType="set">
								<xsl:call-template name="makeREF">
									<xsl:with-param name="cd">Facility</xsl:with-param>
									<xsl:with-param name="obj">IfcBuilding</xsl:with-param>
									<xsl:with-param name="idref" select="$fac1"/>
								</xsl:call-template>
							</RelatedBuildings>
						</IfcRelServicesBuildings>
						<xsl:if test="string-length(xl:Cell[5]/xl:Data)>0">
							<IfcRelAssignsToGroup>
								<xsl:call-template name="makeGUID">
									<xsl:with-param name="cd" select="$cd"/>
									<xsl:with-param name="me" select="$me"/>
									<xsl:with-param name="ty">ratg</xsl:with-param>
									<xsl:with-param name="oh" select="$ohfull"/>
								</xsl:call-template>
								<Name>System Contents</Name>
								<Description>System contains Components</Description>
								<RelatedObjects ex:cType="set">
									<xsl:for-each select="../*[normalize-space(xl:Cell[1]/xl:Data)=normalize-space($me)]">
										<xsl:call-template name="recurseList">
											<xsl:with-param name="cd">Component</xsl:with-param>
											<xsl:with-param name="seq">
												<xsl:call-template name="getCellData">
													<xsl:with-param name="targetIndex">5</xsl:with-param>
												</xsl:call-template>
											</xsl:with-param>
											<xsl:with-param name="ty">IfcFurnishingElement</xsl:with-param>
										</xsl:call-template>
									</xsl:for-each>
								</RelatedObjects>
								<RelatingGroup>
									<xsl:call-template name="makeREF">
										<xsl:with-param name="cd" select="$cd"/>
										<xsl:with-param name="obj">IfcSystem</xsl:with-param>
										<xsl:with-param name="idref" select="$me"/>
									</xsl:call-template>
								</RelatingGroup>
							</IfcRelAssignsToGroup>
						</xsl:if>
						<xsl:call-template name="makeAttributes">
							<xsl:with-param name="ty" select="$cd"/>
							<xsl:with-param name="me" select="$me"/>
							<xsl:with-param name="ob">IfcSystem</xsl:with-param>
							<xsl:with-param name="oh" select="$ohfull"/>
						</xsl:call-template>
						<xsl:element name="IfcRelAssociatesClassification">
							<xsl:call-template name="makeGUID">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="me" select="$me"/>
								<xsl:with-param name="ty">rac</xsl:with-param>
								<xsl:with-param name="oh" select="$ohfull"/>
							</xsl:call-template>
							<xsl:element name="RelatedObjects">
								<xsl:call-template name="makeREF">
									<xsl:with-param name="cd" select="$cd"/>
									<xsl:with-param name="obj">IfcSystem</xsl:with-param>
									<xsl:with-param name="idref" select="$me"/>
								</xsl:call-template>
							</xsl:element>
							<xsl:element name="RelatingClassification">
								<xsl:call-template name="makeCategory">
									<xsl:with-param name="cd" select="$cd"/>
									<xsl:with-param name="tx">
										<xsl:call-template name="getCellData">
											<xsl:with-param name="targetIndex" select="4"/>
										</xsl:call-template>
									</xsl:with-param>
								</xsl:call-template>
							</xsl:element>
						</xsl:element>
					</xsl:if>
				</xsl:when>
				<xsl:when test="$cd='Type'">
					<!-- Type -->
					<xsl:variable name="ifctype">
						<xsl:call-template name="getIFC">
							<xsl:with-param name="cl" select="15"/>
							<xsl:with-param name="df">IfcFurnishingElementType</xsl:with-param>
						</xsl:call-template>
					</xsl:variable>
					<xsl:message>
						<xsl:value-of select="$ifctype"/>
						<xsl:value-of select="$cln"/>
						<xsl:value-of select="$me"/>
					</xsl:message>
					<xsl:call-template name="checkReference">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="sheet2">Contact</xsl:with-param>
						<xsl:with-param name="field1">
							<xsl:value-of select="$ifctype"/>.OwnerHistory</xsl:with-param>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="value1">
							<xsl:value-of select="$ohfull"/>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:call-template name="checkInteresting">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="field1">Classification Name</xsl:with-param>
						<xsl:with-param name="value1">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="4"/>
							</xsl:call-template>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:call-template name="checkInteresting">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="field1">
							<xsl:value-of select="$ifctype"/>Description</xsl:with-param>
						<xsl:with-param name="value1">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="5"/>
							</xsl:call-template>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:element name="{$ifctype}">
						<xsl:call-template name="makeID">
							<xsl:with-param name="idref" select="$me"/>
							<xsl:with-param name="cd" select="$cd"/>
						</xsl:call-template>
						<xsl:call-template name="makeGUID">
							<xsl:with-param name="cd" select="$cd"/>
							<xsl:with-param name="me" select="$me"/>
							<xsl:with-param name="ty">bept</xsl:with-param>
							<xsl:with-param name="cl">16</xsl:with-param>
							<xsl:with-param name="oh" select="$ohfull"/>
						</xsl:call-template>
						<xsl:element name="Name">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="1"/>
							</xsl:call-template>
						</xsl:element>
						<xsl:element name="Description">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="5"/>
							</xsl:call-template>
						</xsl:element>
						<HasPropertySets>
							<IfcPropertySet>
								<xsl:call-template name="makeGUID">
									<xsl:with-param name="cd" select="$cd"/>
									<xsl:with-param name="me" select="$me"/>
									<xsl:with-param name="ty">ps1</xsl:with-param>
									<xsl:with-param name="oh" select="$ohfull"/>
								</xsl:call-template>
								<Name>Pset_ManufacturersTypeInformation</Name>
								<Description>Defines characteristics of manufactured products that may be given by the manufacturer. Note that the term may also be used to refer to products that are supplied and identified by the supplier or that are assembled off site by a third party provider.</Description>
								<HasProperties>
									<IfcPropertySingleValue>
										<Name>Manufacturer</Name>
										<Description>The organization that manufactured and/or assembled the item.</Description>
										<NominalValue>
											<IfcLabel>
												<xsl:call-template name="getCellData">
													<xsl:with-param name="targetIndex" select="7"/>
												</xsl:call-template>
												<xsl:text> </xsl:text>
											</IfcLabel>
										</NominalValue>
									</IfcPropertySingleValue>
									<IfcPropertySingleValue>
										<Name>ModelReference</Name>
										<Description>The name of the manufactured item as used by the manufacturer.</Description>
										<NominalValue>
											<IfcLabel>
												<xsl:call-template name="getCellData">
													<xsl:with-param name="targetIndex" select="8"/>
												</xsl:call-template>
												<xsl:text> </xsl:text>
											</IfcLabel>
										</NominalValue>
									</IfcPropertySingleValue>
									<IfcPropertySingleValue>
										<Name>ModelLabel</Name>
										<Description>The model number and/or unit designator assigned by the manufacturer of the manufactured item. </Description>
										<NominalValue>
											<IfcLabel>
												<xsl:call-template name="getCellData">
													<xsl:with-param name="targetIndex" select="8"/>
												</xsl:call-template>
												<xsl:text> </xsl:text>
											</IfcLabel>
										</NominalValue>
									</IfcPropertySingleValue>
								</HasProperties>
							</IfcPropertySet>
							<IfcPropertySet>
								<xsl:call-template name="makeGUID">
									<xsl:with-param name="cd" select="$cd"/>
									<xsl:with-param name="me" select="$me"/>
									<xsl:with-param name="ty">ps3</xsl:with-param>
									<xsl:with-param name="oh" select="$ohfull"/>
								</xsl:call-template>
								<Name>Pset_Asset</Name>
								<Description>An asset is a uniquely identifiable element which has a financial value and against which maintenance actions are recorded. </Description>
								<HasProperties>
									<IfcPropertySingleValue>
										<Name>AssetAccountingType</Name>
										<Description>Identifies the predefined types of asset from which the type required may be set. </Description>
										<NominalValue>
											<xsl:variable name="IsFixed">
												<xsl:call-template name="getCellData">
													<xsl:with-param name="targetIndex" select="6"/>
												</xsl:call-template>
											</xsl:variable>
											<IfcLabel>
												<xsl:choose>
													<xsl:when test="$IsFixed='Fixed'">Fixed</xsl:when>
													<xsl:otherwise>NonFixed</xsl:otherwise>
												</xsl:choose>
											</IfcLabel>
										</NominalValue>
									</IfcPropertySingleValue>
								</HasProperties>
							</IfcPropertySet>
							<IfcPropertySet>
								<xsl:call-template name="makeGUID">
									<xsl:with-param name="cd" select="$cd"/>
									<xsl:with-param name="me" select="$me"/>
									<xsl:with-param name="ty">ps2</xsl:with-param>
									<xsl:with-param name="oh" select="$ohfull"/>
								</xsl:call-template>
								<Name>Pset_Warranty</Name>
								<Description>Warranty Information</Description>
								<HasProperties>
									<IfcPropertySingleValue>
										<Name>WarrantyName</Name>
										<Description>The name of the warranty</Description>
										<NominalValue>
											<IfcLabel>
												<xsl:call-template name="getCellData">
													<xsl:with-param name="targetIndex" select="20"/>
												</xsl:call-template>
												<xsl:text> </xsl:text>
											</IfcLabel>
										</NominalValue>
									</IfcPropertySingleValue>
									<IfcPropertySingleValue>
										<Name>WarrantyDescription</Name>
										<Description>Description of the warranty</Description>
										<NominalValue>
											<IfcLabel>
												<xsl:call-template name="getCellData">
													<xsl:with-param name="targetIndex" select="20"/>
												</xsl:call-template>
												<xsl:text> </xsl:text>
											</IfcLabel>
										</NominalValue>
									</IfcPropertySingleValue>
									<!--
WarrantyGuarantorParts
WarrantyDurationParts
WarrantyGuarantorLabor
WarrantyDurationLabor
WarrantyDurationUnit
-->
									<IfcPropertySingleValue>
										<Name>WarrantyGuarantorParts</Name>
										<Description>Organization acting as guarantor of parts warranty</Description>
										<NominalValue>
											<IfcLabel>
												<xsl:call-template name="getCellData">
													<xsl:with-param name="targetIndex" select="9"/>
												</xsl:call-template>
												<xsl:text> </xsl:text>
											</IfcLabel>
										</NominalValue>
									</IfcPropertySingleValue>
									<IfcPropertySingleValue>
										<Name>WarrantyDurationParts</Name>
										<Description>Duration of parts warranty (years)</Description>
										<NominalValue>
											<IfcLabel>
												<xsl:call-template name="asyear">
													<xsl:with-param name="dur1">
														<xsl:call-template name="getCellData">
															<xsl:with-param name="targetIndex" select="10"/>
														</xsl:call-template>
													</xsl:with-param>
													<xsl:with-param name="uni1">
														<xsl:call-template name="getCellData">
															<xsl:with-param name="targetIndex" select="13"/>
														</xsl:call-template>
													</xsl:with-param>
												</xsl:call-template>
												<xsl:text> </xsl:text>
											</IfcLabel>
										</NominalValue>
									</IfcPropertySingleValue>
									<IfcPropertySingleValue>
										<Name>WarrantyGuarantorLabor</Name>
										<Description>Organization acting as guarantor of labor warranty</Description>
										<NominalValue>
											<IfcLabel>
												<xsl:call-template name="getCellData">
													<xsl:with-param name="targetIndex" select="11"/>
												</xsl:call-template>
												<xsl:text> </xsl:text>
											</IfcLabel>
										</NominalValue>
									</IfcPropertySingleValue>
									<IfcPropertySingleValue>
										<Name>WarrantyDurationLabor</Name>
										<Description>Duration of labor warranty (years)</Description>
										<NominalValue>
											<IfcLabel>
												<xsl:call-template name="asyear">
													<xsl:with-param name="dur1">
														<xsl:call-template name="getCellData">
															<xsl:with-param name="targetIndex" select="12"/>
														</xsl:call-template>
													</xsl:with-param>
													<xsl:with-param name="uni1">
														<xsl:call-template name="getCellData">
															<xsl:with-param name="targetIndex" select="13"/>
														</xsl:call-template>
													</xsl:with-param>
												</xsl:call-template>
												<xsl:text> </xsl:text>
											</IfcLabel>
										</NominalValue>
									</IfcPropertySingleValue>
								</HasProperties>
							</IfcPropertySet>
							<IfcPropertySet>
								<xsl:call-template name="makeGUID">
									<xsl:with-param name="cd" select="$cd"/>
									<xsl:with-param name="me" select="$me"/>
									<xsl:with-param name="ty">ps0</xsl:with-param>
									<xsl:with-param name="oh" select="$ohfull"/>
								</xsl:call-template>
								<Name>Pset_<xsl:value-of select="$cd"/>_COBie2</Name>
								<Description>Properties for <xsl:value-of select="$cd"/> found in COBie2</Description>
								<HasProperties>
									<IfcPropertySingleValue>
										<Name>ReplacementCost</Name>
										<Description>Nominal replacement cost</Description>
										<NominalValue>
											<IfcLabel>
												<xsl:call-template name="getCellData">
													<xsl:with-param name="targetIndex" select="17"/>
												</xsl:call-template>
												<xsl:text> </xsl:text>
											</IfcLabel>
										</NominalValue>
									</IfcPropertySingleValue>
									<IfcPropertySingleValue>
										<Name>ExpectedLife</Name>
										<Description>Nominal life expectancy (years)</Description>
										<NominalValue>
											<IfcLabel>
												<xsl:call-template name="asyear">
													<xsl:with-param name="dur1">
														<xsl:call-template name="getCellData">
															<xsl:with-param name="targetIndex" select="18"/>
														</xsl:call-template>
													</xsl:with-param>
													<xsl:with-param name="uni1">
														<xsl:call-template name="getCellData">
															<xsl:with-param name="targetIndex" select="19"/>
														</xsl:call-template>
													</xsl:with-param>
												</xsl:call-template>
												<xsl:text> </xsl:text>
											</IfcLabel>
										</NominalValue>
									</IfcPropertySingleValue>
									<xsl:call-template name="makeAttributeReferences">
										<xsl:with-param name="ty" select="$cd"/>
										<xsl:with-param name="me" select="$me"/>
									</xsl:call-template>
								</HasProperties>
							</IfcPropertySet>
						</HasPropertySets>
						<xsl:element name="Tag">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="5"/>
							</xsl:call-template>
							<xsl:text> </xsl:text>
						</xsl:element>
						<xsl:choose>
							<xsl:when test="($ifctype='IfcWindowStyle') ">
								<xsl:element name="ConstructionType">
									<xsl:text>notdefined</xsl:text>
								</xsl:element>
								<xsl:element name="OperationType">
									<xsl:text>notdefined</xsl:text>
								</xsl:element>
								<xsl:element name="ParameterTakesPrecedence">
									<xsl:text>false</xsl:text>
								</xsl:element>
								<xsl:element name="Sizeable">
									<xsl:text>false</xsl:text>
								</xsl:element>
							</xsl:when>
							<xsl:when test="($ifctype='IfcDoorStyle') ">
								<xsl:element name="OperationType">
									<xsl:text>notdefined</xsl:text>
								</xsl:element>
								<xsl:element name="ConstructionType">
									<xsl:text>notdefined</xsl:text>
								</xsl:element>
								<xsl:element name="ParameterTakesPrecedence">
									<xsl:text>false</xsl:text>
								</xsl:element>
								<xsl:element name="Sizeable">
									<xsl:text>false</xsl:text>
								</xsl:element>
							</xsl:when>
							<xsl:otherwise>
								<xsl:element name="ElementType">
									<xsl:call-template name="getCellData">
										<xsl:with-param name="targetIndex" select="4"/>
									</xsl:call-template>
								</xsl:element>
							</xsl:otherwise>
						</xsl:choose>
						<xsl:choose>
							<xsl:when test="($ifctype='IfcDoorStyle') or ($ifctype='IfcWindowStyle') ">
								
							</xsl:when>
							<xsl:when test="($ifctype='IfcSystemFurnitureElementType') ">
								
							</xsl:when>
							<xsl:when test="($ifctype='IfcFurnishingElementType') ">
								
							</xsl:when>
							<xsl:when test="($ifctype='IfcDistributionElementType') ">
								
							</xsl:when>
							<xsl:when test="($ifctype='IfcFurnitureType') ">
								<xsl:element name="AssemblyPlace">
									<xsl:text>notdefined</xsl:text>
								</xsl:element>
							</xsl:when>
							<xsl:otherwise>
								<xsl:element name="PredefinedType">
									<xsl:text>notdefined</xsl:text>
								</xsl:element>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:element>
					<xsl:element name="IfcRelAssociatesClassification">
						<xsl:call-template name="makeGUID">
							<xsl:with-param name="cd" select="$cd"/>
							<xsl:with-param name="me" select="$me"/>
							<xsl:with-param name="ty">rac</xsl:with-param>
							<xsl:with-param name="oh" select="$ohfull"/>
						</xsl:call-template>
						<xsl:element name="RelatedObjects">
							<xsl:call-template name="makeREF">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="obj" select="$ifctype"/>
								<xsl:with-param name="idref" select="$me"/>
							</xsl:call-template>
						</xsl:element>
						<xsl:element name="RelatingClassification">
							<xsl:call-template name="makeCategory">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="tx">
									<xsl:call-template name="getCellData">
										<xsl:with-param name="targetIndex" select="4"/>
									</xsl:call-template>
								</xsl:with-param>
							</xsl:call-template>
						</xsl:element>
					</xsl:element>
					<xsl:if test="count(//xl:Worksheet[@ss:Name='Component']/xl:Table/xl:Row[xl:Cell[4]/xl:Data/text()=$me])>0">
						<xsl:comment>Type Product to Components relationship</xsl:comment>
						<IfcRelDefinesByType>
							<xsl:call-template name="makeGUID">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="me" select="$me"/>
								<xsl:with-param name="ty">rdbt</xsl:with-param>
								<xsl:with-param name="oh" select="$ohfull"/>
							</xsl:call-template>
							<Name>Type Product definition </Name>
							<Description>Type Product  Defines Components</Description>
							<RelatedObjects ex:cType="set">
								<xsl:for-each select="//xl:Worksheet[@ss:Name='Component']/xl:Table/xl:Row[xl:Cell[4]/xl:Data/text()=$me]">
									<xsl:variable name="me1">
										<xsl:call-template name="getCellData">
											<xsl:with-param name="targetIndex" select="1"/>
										</xsl:call-template>
									</xsl:variable>
									<xsl:call-template name="makeREF">
										<xsl:with-param name="cd">Component</xsl:with-param>
										<xsl:with-param name="obj">IfcFurnishingElement</xsl:with-param>
										<xsl:with-param name="idref" select="$me1"/>
									</xsl:call-template>
								</xsl:for-each>
							</RelatedObjects>
							<RelatingType>
								<xsl:call-template name="makeREF">
									<xsl:with-param name="cd" select="$cd"/>
									<xsl:with-param name="obj">IfcFurnishingElementType</xsl:with-param>
									<xsl:with-param name="idref" select="$me"/>
								</xsl:call-template>
							</RelatingType>
						</IfcRelDefinesByType>
					</xsl:if>
				</xsl:when>
				<xsl:when test="$cd='Component'">
					<!-- Component -->
					<xsl:variable name="ifctype">
						<xsl:call-template name="getIFC">
							<xsl:with-param name="cl" select="8"/>
							<xsl:with-param name="df">IfcFurnishingElement</xsl:with-param>
						</xsl:call-template>
					</xsl:variable>
					<xsl:message>
						<xsl:value-of select="$ifctype"/>
						<xsl:value-of select="$cln"/>
						<xsl:value-of select="$me"/>
					</xsl:message>
					<xsl:call-template name="checkReference">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="sheet2">Contact</xsl:with-param>
						<xsl:with-param name="field1">
							<xsl:value-of select="$ifctype"/> Owner History</xsl:with-param>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="value1">
							<xsl:value-of select="$ohfull"/>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:call-template name="checkReference">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="sheet2">Type</xsl:with-param>
						<xsl:with-param name="field1">
							<xsl:value-of select="$ifctype"/> Is Defined By</xsl:with-param>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="value1">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="4"/>
							</xsl:call-template>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:call-template name="checkInteresting">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="field1">
							<xsl:value-of select="$ifctype"/> Description</xsl:with-param>
						<xsl:with-param name="value1">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="6"/>
							</xsl:call-template>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:element name="{$ifctype}">
						<xsl:call-template name="makeID">
							<xsl:with-param name="idref" select="$me"/>
							<xsl:with-param name="cd" select="$cd"/>
						</xsl:call-template>
						<xsl:call-template name="makeGUID">
							<xsl:with-param name="cd" select="$cd"/>
							<xsl:with-param name="me" select="$me"/>
							<xsl:with-param name="ty">bep</xsl:with-param>
							<xsl:with-param name="cl">9</xsl:with-param>
							<xsl:with-param name="oh" select="$ohfull"/>
						</xsl:call-template>
						<xsl:element name="Name">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="1"/>
							</xsl:call-template>
						</xsl:element>
						<xsl:element name="Description">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="6"/>
							</xsl:call-template>
						</xsl:element>
						<xsl:element name="ObjectType">
							<xsl:text>COMPONENT</xsl:text>
						</xsl:element>
						<ObjectPlacement>
							<xsl:call-template name="makeREF">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="obj">IfcLocalPlacement</xsl:with-param>
								<xsl:with-param name="idref">
									<xsl:text>lp_</xsl:text>
									<xsl:value-of select="$cd"/>
									<xsl:text>_</xsl:text>
									<xsl:value-of select="$me"/>
								</xsl:with-param>
							</xsl:call-template>
						</ObjectPlacement>
						<xsl:call-template name="makeShape">
							<xsl:with-param name="ty" select="$cd"/>
							<xsl:with-param name="key1" select="$me"/>
						</xsl:call-template>
						<xsl:element name="Tag">
							<xsl:text>element</xsl:text>
						</xsl:element>
						<xsl:if test="$ifctype='IfcBuildingElementProxy'">
							<xsl:element name="CompositionType">
								<xsl:text>element</xsl:text>
							</xsl:element>
						</xsl:if>
						<xsl:if test="$ifctype='IfcElectricDistributionPoint'">
							<xsl:element name="DistributionPointFunction">
								<xsl:text>notdefined</xsl:text>
							</xsl:element>
						</xsl:if>
					</xsl:element>
					<xsl:element name="IfcLocalPlacement">
						<xsl:call-template name="makeID">
							<xsl:with-param name="idref">
								<xsl:text>lp_</xsl:text>
								<xsl:value-of select="$cd"/>
								<xsl:text>_</xsl:text>
								<xsl:value-of select="$me"/>
							</xsl:with-param>
							<xsl:with-param name="cd" select="$cd"/>
						</xsl:call-template>
						<xsl:variable name="me1">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="5"/>
							</xsl:call-template>
						</xsl:variable>
						<xsl:if test="not($me1=$na)">
							<PlacementRelTo>
								<xsl:call-template name="makeREF">
									<xsl:with-param name="cd">Space</xsl:with-param>
									<xsl:with-param name="obj">IfcLocalPlacement</xsl:with-param>
									<xsl:with-param name="idref">
										<xsl:text>lp_Space_</xsl:text>
										<xsl:choose>
											<xsl:when test="contains($me1,$delimiter)">
												<xsl:value-of select="substring-before($me1,$delimiter)"/>
											</xsl:when>
											<xsl:otherwise>
												<xsl:value-of select="$me1"/>
											</xsl:otherwise>
										</xsl:choose>
									</xsl:with-param>
								</xsl:call-template>
							</PlacementRelTo>
						</xsl:if>
						<RelativePlacement>
							<IfcAxis2Placement3D>
								<Location>
									<IfcCartesianPoint>
										<Coordinates ex:cType="list">
											<IfcLengthMeasure>
												<xsl:call-template name="zero">
													<xsl:with-param name="avalue">
														<xsl:call-template name="geometry">
															<xsl:with-param name="type" select="$cd"/>
															<xsl:with-param name="mode">lowerleft</xsl:with-param>
															<xsl:with-param name="axis">1</xsl:with-param>
															<xsl:with-param name="key1" select="$me"/>
														</xsl:call-template>
													</xsl:with-param>
												</xsl:call-template>
											</IfcLengthMeasure>
											<IfcLengthMeasure>
												<xsl:call-template name="zero">
													<xsl:with-param name="avalue">
														<xsl:call-template name="geometry">
															<xsl:with-param name="type" select="$cd"/>
															<xsl:with-param name="mode">lowerleft</xsl:with-param>
															<xsl:with-param name="axis">2</xsl:with-param>
															<xsl:with-param name="key1" select="$me"/>
														</xsl:call-template>
													</xsl:with-param>
												</xsl:call-template>
											</IfcLengthMeasure>
											<IfcLengthMeasure>
												<xsl:call-template name="zero">
													<xsl:with-param name="avalue">
														<xsl:call-template name="geometry">
															<xsl:with-param name="type" select="$cd"/>
															<xsl:with-param name="mode">lowerleft</xsl:with-param>
															<xsl:with-param name="axis">3</xsl:with-param>
															<xsl:with-param name="key1" select="$me"/>
														</xsl:call-template>
													</xsl:with-param>
												</xsl:call-template>
											</IfcLengthMeasure>
										</Coordinates>
									</IfcCartesianPoint>
								</Location>
								<Axis>
									<IfcDirection xsi:nil="true" ref="up"/>
								</Axis>
								<RefDirection>
									<IfcDirection xsi:nil="true" ref="east"/>
								</RefDirection>
							</IfcAxis2Placement3D>
						</RelativePlacement>
					</xsl:element>
					<xsl:call-template name="makeAttributes">
						<xsl:with-param name="ty" select="$cd"/>
						<xsl:with-param name="me" select="$me"/>
						<xsl:with-param name="ob" select="$ifctype"/>
						<xsl:with-param name="oh" select="$ohfull"/>
					</xsl:call-template>
					<!-- coloration -->
					<IfcStyledItem>
						<Item>
							<xsl:call-template name="makeREF">
								<xsl:with-param name="cd">Component</xsl:with-param>
								<xsl:with-param name="obj">IfcExtrudedAreaSolid</xsl:with-param>
								<xsl:with-param name="idref">
									<xsl:text>item_</xsl:text>
									<xsl:value-of select="$me"/>
								</xsl:with-param>
							</xsl:call-template>
						</Item>
						<Styles>
							<xsl:call-template name="makeColor">
								<xsl:with-param name="cd1">Component</xsl:with-param>
								<xsl:with-param name="me1" select="$me"/>
								<xsl:with-param name="ifc1">IfcPresentationStyleAssignment</xsl:with-param>
							</xsl:call-template>
						</Styles>
					</IfcStyledItem>
				</xsl:when>
				<xsl:when test="$cd='Attribute'">
					<!-- Attribute -->
					<xsl:variable name="c5">
						<xsl:call-template name="getCellData">
							<xsl:with-param name="targetIndex" select="5"/>
						</xsl:call-template>
					</xsl:variable>
					<xsl:variable name="c6">
						<xsl:call-template name="getCellData">
							<xsl:with-param name="targetIndex" select="6"/>
						</xsl:call-template>
					</xsl:variable>
					<xsl:if test="0=count(preceding-sibling::xl:Row[(xl:Cell[1]/xl:Data=$me) and (xl:Cell[5]/xl:Data=$c5) and (xl:Cell[6]/xl:Data=$c6) ]) ">
						<xsl:message>
							<xsl:text>IfcPropertySingleValue</xsl:text>
							<xsl:value-of select="$cln"/>
							<xsl:value-of select="$me"/>
							<xsl:value-of select="$cln"/>
							<xsl:value-of select="$c5"/>
							<xsl:value-of select="$cln"/>
							<xsl:value-of select="$c6"/>
						</xsl:message>
						<xsl:call-template name="checkReference">
							<xsl:with-param name="sheet1" select="$cd"/>
							<xsl:with-param name="sheet2">
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="5"/>
								</xsl:call-template>
							</xsl:with-param>
							<xsl:with-param name="field1">IfcPropertySingleValue.(association)</xsl:with-param>
							<xsl:with-param name="me1" select="$me"/>
							<xsl:with-param name="value1">
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="6"/>
								</xsl:call-template>
							</xsl:with-param>
						</xsl:call-template>
						<xsl:call-template name="checkInteresting">
							<xsl:with-param name="sheet1" select="$cd"/>
							<xsl:with-param name="me1" select="$me"/>
							<xsl:with-param name="field1">Property Value</xsl:with-param>
							<xsl:with-param name="value1">
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="7"/>
								</xsl:call-template>
							</xsl:with-param>
						</xsl:call-template>
						<xsl:element name="IfcPropertySingleValue">
							<xsl:call-template name="makeID">
								<xsl:with-param name="idref">
									<xsl:value-of select="$c5"/>_<xsl:value-of select="$c6"/>_<xsl:value-of select="$me"/>
								</xsl:with-param>
								<xsl:with-param name="cd" select="$cd"/>
							</xsl:call-template>
							<Name>
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="1"/>
								</xsl:call-template>
							</Name>
							<Description>
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="12"/>
								</xsl:call-template>
							</Description>
							<NominalValue>
								<IfcDescriptiveMeasure>
									<xsl:call-template name="getCellData">
										<xsl:with-param name="targetIndex" select="7"/>
									</xsl:call-template>
								</IfcDescriptiveMeasure>
							</NominalValue>
						</xsl:element>
					</xsl:if>
				</xsl:when>
				<xsl:when test="$cd='Spare' and not($job='no')">
					<!-- Spare -->
					<xsl:message>
						<xsl:text>IfcConstructionProductResource</xsl:text>
						<xsl:value-of select="$cln"/>
						<xsl:value-of select="$me"/>
					</xsl:message>
					<xsl:call-template name="checkReference">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="sheet2">Type</xsl:with-param>
						<xsl:with-param name="field1">IfcTypeProduct</xsl:with-param>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="value1">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="5"/>
							</xsl:call-template>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:call-template name="checkReference">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="sheet2">Contact</xsl:with-param>
						<xsl:with-param name="field1">IfcConstructionProductResource.OwnerHistory</xsl:with-param>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="value1">
							<xsl:value-of select="$ohfull"/>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:call-template name="checkInteresting">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="field1">Spare Type</xsl:with-param>
						<xsl:with-param name="value1">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="4"/>
							</xsl:call-template>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:element name="IfcConstructionProductResource">
						<xsl:call-template name="makeID">
							<xsl:with-param name="idref" select="$me"/>
							<xsl:with-param name="cd" select="$cd"/>
						</xsl:call-template>
						<xsl:call-template name="makeGUID">
							<xsl:with-param name="cd" select="$cd"/>
							<xsl:with-param name="me" select="$me"/>
							<xsl:with-param name="ty">cpr</xsl:with-param>
							<xsl:with-param name="cl">9</xsl:with-param>
							<xsl:with-param name="oh" select="$ohfull"/>
						</xsl:call-template>
						<xsl:element name="Name">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="1"/>
							</xsl:call-template>
						</xsl:element>
						<xsl:element name="Description">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="9"/>
							</xsl:call-template>
						</xsl:element>
						<xsl:element name="ObjectType">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="4"/>
							</xsl:call-template>
						</xsl:element>
						<xsl:element name="ResourceIdentifier">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="11"/>
							</xsl:call-template>
						</xsl:element>
						<xsl:element name="ResourceGroup">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="10"/>
							</xsl:call-template>
						</xsl:element>
						<!--
			<ResourceConsumption></ResourceConsumption>
			<BaseQuantity>
-->
					</xsl:element>
					<IfcRelAssignsToResource>
						<xsl:call-template name="makeGUID">
							<xsl:with-param name="cd" select="$cd"/>
							<xsl:with-param name="me" select="$me"/>
							<xsl:with-param name="ty">ratr</xsl:with-param>
							<xsl:with-param name="oh" select="$ohfull"/>
						</xsl:call-template>
						<Name>Type(s) assigned to Spare</Name>
						<Description>Type(s) assigned to Spare</Description>
						<RelatedObjects>
							<xsl:call-template name="makeREF">
								<xsl:with-param name="cd">Type</xsl:with-param>
								<xsl:with-param name="obj">IfcTypeProduct</xsl:with-param>
								<xsl:with-param name="idref">
									<xsl:call-template name="getCellData">
										<xsl:with-param name="targetIndex" select="5"/>
									</xsl:call-template>
								</xsl:with-param>
							</xsl:call-template>
						</RelatedObjects>
						<RelatingResource>
							<xsl:call-template name="makeREF">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="obj">IfcConstructionProductResource</xsl:with-param>
								<xsl:with-param name="idref" select="$me"/>
							</xsl:call-template>
						</RelatingResource>
					</IfcRelAssignsToResource>
				</xsl:when>
				<xsl:when test="$cd='Resource' and not($job='no')">
					<!-- Resource -->
					<xsl:message>
						<xsl:text>IfcConstructionEquipmentResource</xsl:text>
						<xsl:value-of select="$cln"/>
						<xsl:value-of select="$me"/>
					</xsl:message>
					<xsl:call-template name="checkReference">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="sheet2">Contact</xsl:with-param>
						<xsl:with-param name="field1">IfcConstructionEquipmentResource.OwnerHistory</xsl:with-param>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="value1">
							<xsl:value-of select="$ohfull"/>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:call-template name="checkInteresting">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="field1">Resource Type</xsl:with-param>
						<xsl:with-param name="value1">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="4"/>
							</xsl:call-template>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:element name="IfcConstructionEquipmentResource">
						<xsl:call-template name="makeID">
							<xsl:with-param name="idref" select="$me"/>
							<xsl:with-param name="cd" select="$cd"/>
						</xsl:call-template>
						<xsl:call-template name="makeGUID">
							<xsl:with-param name="cd" select="$cd"/>
							<xsl:with-param name="me" select="$me"/>
							<xsl:with-param name="ty">cer</xsl:with-param>
							<xsl:with-param name="cl">6</xsl:with-param>
							<xsl:with-param name="oh" select="$ohfull"/>
						</xsl:call-template>
						<xsl:element name="Name">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="1"/>
							</xsl:call-template>
						</xsl:element>
						<xsl:element name="Description">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="8"/>
							</xsl:call-template>
						</xsl:element>
						<xsl:element name="ObjectType">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="4"/>
							</xsl:call-template>
						</xsl:element>
						<!--
						<xsl:element name="ResourceIdentifier">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="11"/>
							</xsl:call-template>
						</xsl:element>
					<xsl:element name="ResourceGroup">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="10"/>
							</xsl:call-template>
						</xsl:element>
-->
						<!--
			<ResourceConsumption></ResourceConsumption>
			<BaseQuantity>

-->
					</xsl:element>
				</xsl:when>
				<xsl:when test="($cd='Job') and not($job='no')">
					<!-- Job -->
					<xsl:message>
						<xsl:text>IfcTask</xsl:text>
						<xsl:value-of select="$cln"/>
						<xsl:value-of select="$me"/>
					</xsl:message>
					<xsl:call-template name="checkReference">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="sheet2">Type</xsl:with-param>
						<xsl:with-param name="field1">IfcTypeProduct</xsl:with-param>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="value1">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="6"/>
							</xsl:call-template>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:call-template name="checkReference">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="sheet2">Contact</xsl:with-param>
						<xsl:with-param name="field1">IfcTask.OwnerHistory</xsl:with-param>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="value1">
							<xsl:value-of select="$ohfull"/>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:call-template name="checkInteresting">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="field1">Task Type</xsl:with-param>
						<xsl:with-param name="value1">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="4"/>
							</xsl:call-template>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:element name="IfcTask">
						<xsl:call-template name="makeID">
							<xsl:with-param name="idref" select="$me"/>
							<xsl:with-param name="cd" select="$cd"/>
						</xsl:call-template>
						<xsl:call-template name="makeGUID">
							<xsl:with-param name="cd" select="$cd"/>
							<xsl:with-param name="me" select="$me"/>
							<xsl:with-param name="ty">t</xsl:with-param>
							<xsl:with-param name="cl">16</xsl:with-param>
							<xsl:with-param name="oh" select="$ohfull"/>
						</xsl:call-template>
						<xsl:element name="Name">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="1"/>
							</xsl:call-template>
						</xsl:element>
						<xsl:element name="Description">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="7"/>
							</xsl:call-template>
						</xsl:element>
						<xsl:element name="ObjectType">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="4"/>
							</xsl:call-template>
						</xsl:element>
						<xsl:element name="TaskId">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="17"/>
							</xsl:call-template>
						</xsl:element>
						<xsl:element name="Status">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="5"/>
							</xsl:call-template>
						</xsl:element>
						<!--
						<xsl:element name="WorkMethod">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="?"/>
							</xsl:call-template>
						</xsl:element>
-->
						<IsMilestone>false</IsMilestone>
						<!--
						<xsl:element name="Priority">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="?"/>
							</xsl:call-template>
						</xsl:element>
-->
					</xsl:element>
					<xsl:variable name="ResourceList">
						<xsl:call-template name="getCellData">
							<xsl:with-param name="targetIndex" select="19"/>
						</xsl:call-template>
					</xsl:variable>
					<IfcRelAssignsToProcess>
						<xsl:call-template name="makeGUID">
							<xsl:with-param name="cd" select="$cd"/>
							<xsl:with-param name="me" select="$me"/>
							<xsl:with-param name="ty">ratp</xsl:with-param>
							<xsl:with-param name="oh" select="$ohfull"/>
						</xsl:call-template>
						<Name>type(s) assigned  to task</Name>
						<Description>type(s) assigned  to task</Description>
						<RelatedObjects>
							<xsl:call-template name="makeREF">
								<xsl:with-param name="cd">Type</xsl:with-param>
								<xsl:with-param name="obj">IfcTypeProduct</xsl:with-param>
								<xsl:with-param name="idref">
									<xsl:call-template name="getCellData">
										<xsl:with-param name="targetIndex" select="6"/>
									</xsl:call-template>
								</xsl:with-param>
							</xsl:call-template>
							<xsl:call-template name="recurseList">
								<xsl:with-param name="cd">Resource</xsl:with-param>
								<xsl:with-param name="seq" select="$ResourceList"/>
								<xsl:with-param name="ty">IfcConstructionEquipmentResource</xsl:with-param>
							</xsl:call-template>
						</RelatedObjects>
						<!--
						<RelatedObjectType>product</RelatedObjectType>
-->
						<RelatingProcess>
							<xsl:call-template name="makeREF">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="obj">IfcTask</xsl:with-param>
								<xsl:with-param name="idref" select="$me"/>
							</xsl:call-template>
						</RelatingProcess>
					</IfcRelAssignsToProcess>
					<xsl:call-template name="makeAttributes">
						<xsl:with-param name="ty" select="$cd"/>
						<xsl:with-param name="me" select="$me"/>
						<xsl:with-param name="ob">IfcTask</xsl:with-param>
						<xsl:with-param name="oh" select="$ohfull"/>
					</xsl:call-template>
				</xsl:when>
				<!-- document -->
				<xsl:when test="$cd='Document'">
					<xsl:if test="count(preceding-sibling::xl:Row[normalize-space(xl:Cell[1]/xl:Data)=normalize-space($me)])=0">
						<xsl:message>
							<xsl:text>IfcDocumentInformation</xsl:text>
							<xsl:value-of select="$cln"/>
							<xsl:value-of select="$me"/>
						</xsl:message>
						<xsl:call-template name="checkReference">
							<xsl:with-param name="sheet1" select="$cd"/>
							<xsl:with-param name="sheet2">Contact</xsl:with-param>
							<xsl:with-param name="field1">IfcRelAssociatesDocument.OwnerHistory</xsl:with-param>
							<xsl:with-param name="me1" select="$me"/>
							<xsl:with-param name="value1">
								<xsl:value-of select="$ohfull"/>
							</xsl:with-param>
						</xsl:call-template>
						<!--
					<xsl:call-template name="checkReference">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="sheet2">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="7"/>
							</xsl:call-template>
						</xsl:with-param>
						<xsl:with-param name="field1">IfcDocumentInformation.(association)</xsl:with-param>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="value1">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="8"/>
							</xsl:call-template>
						</xsl:with-param>
					</xsl:call-template>
                    -->
						<xsl:call-template name="checkInteresting">
							<xsl:with-param name="sheet1" select="$cd"/>
							<xsl:with-param name="me1" select="$me"/>
							<xsl:with-param name="field1">Document Purpose</xsl:with-param>
							<xsl:with-param name="value1">
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="4"/>
								</xsl:call-template>
							</xsl:with-param>
						</xsl:call-template>
						<xsl:element name="IfcRelAssociatesDocument">
							<xsl:call-template name="makeGUID">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="me" select="$me"/>
								<xsl:with-param name="ty">rad</xsl:with-param>
								<xsl:with-param name="oh" select="$ohfull"/>
							</xsl:call-template>
							<xsl:element name="Name">
								<xsl:value-of select="$me"/>
							</xsl:element>
							<xsl:element name="Description">
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="14"/>
								</xsl:call-template>
							</xsl:element>
							<RelatedObjects>
								<xsl:for-each select="../*[normalize-space(xl:Cell[1]/xl:Data)=normalize-space($me)]">
									<xsl:variable name="ty1">
										<xsl:call-template name="getCellData">
											<xsl:with-param name="targetIndex" select="7"/>
										</xsl:call-template>
									</xsl:variable>
									<xsl:call-template name="recurseList">
										<xsl:with-param name="cd" select="$ty1"/>
										<xsl:with-param name="seq">
											<xsl:call-template name="getCellData">
												<xsl:with-param name="targetIndex">8</xsl:with-param>
											</xsl:call-template>
										</xsl:with-param>
										<xsl:with-param name="ty">
											<xsl:choose>
												<xsl:when test="$ty1='Facility'">IfcBuilding</xsl:when>
												<xsl:when test="$ty1='Floor'">IfcBuildingStorey</xsl:when>
												<xsl:when test="$ty1='Zone'">IfcZone</xsl:when>
												<xsl:when test="$ty1='System'">IfcSystem</xsl:when>
												<xsl:when test="$ty1='Space'">IfcSpace</xsl:when>
												<xsl:when test="$ty1='Component'">IfcFurnishingElement</xsl:when>
												<xsl:otherwise>IfcFurnishingElementType</xsl:otherwise>
											</xsl:choose>
										</xsl:with-param>
									</xsl:call-template>
								</xsl:for-each>
							</RelatedObjects>
							<RelatingDocument>
								<xsl:element name="IfcDocumentInformation">
									<xsl:call-template name="makeID">
										<xsl:with-param name="idref" select="$me"/>
										<xsl:with-param name="cd" select="$cd"/>
									</xsl:call-template>
									<DocumentId>
										<xsl:call-template name="getCellData">
											<xsl:with-param name="targetIndex" select="1"/>
										</xsl:call-template>
									</DocumentId>
									<Name>
										<xsl:value-of select="$me"/>
									</Name>
									<Description>
										<xsl:call-template name="getCellData">
											<xsl:with-param name="targetIndex" select="14"/>
										</xsl:call-template>
									</Description>
									<DocumentReferences>
										<IfcDocumentReference>
											<Location>
												<xsl:call-template name="getCellData">
													<xsl:with-param name="targetIndex" select="9"/>
												</xsl:call-template>
												<!--
											<xsl:call-template name="getCellData">
												<xsl:with-param name="targetIndex" select="10"/>
											</xsl:call-template>
                                           -->
											</Location>
											<ItemReference>
												<xsl:call-template name="getCellData">
													<xsl:with-param name="targetIndex" select="10"/>
												</xsl:call-template>
											</ItemReference>
											<Name>
												<xsl:call-template name="getCellData">
													<xsl:with-param name="targetIndex" select="1"/>
												</xsl:call-template>
											</Name>
										</IfcDocumentReference>
									</DocumentReferences>
									<Purpose>
										<xsl:call-template name="getCellData">
											<xsl:with-param name="targetIndex" select="4"/>
										</xsl:call-template>
									</Purpose>
									<IntendedUse>
										<xsl:call-template name="getCellData">
											<xsl:with-param name="targetIndex" select="5"/>
										</xsl:call-template>
									</IntendedUse>
									<Scope>
										<xsl:call-template name="getCellData">
											<xsl:with-param name="targetIndex" select="6"/>
										</xsl:call-template>
									</Scope>
									<!--
			<Revision/>
			<DocumentOwner/>	
			<Editors />		
			<CreationTime/>
			<LastRevisionTime/>
			<ElectronicFormat/>	
			<ValidFrom/>	
			<ValidUntil/>
			<Confidentiality/>
				-->
									<Status>notdefined</Status>
								</xsl:element>
							</RelatingDocument>
						</xsl:element>
					</xsl:if>
				</xsl:when>
				<xsl:when test="$cd='Coordinate'">
					<xsl:call-template name="checkReference">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="sheet2">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="5"/>
							</xsl:call-template>
						</xsl:with-param>
						<xsl:with-param name="field1">IfcCartesianCoordinate.(association)</xsl:with-param>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="value1">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="6"/>
							</xsl:call-template>
						</xsl:with-param>
					</xsl:call-template>
				</xsl:when>
				<xsl:when test="$cd='Connection'">
					<xsl:message>
						<xsl:text>IfcRelConnectsElements</xsl:text>
						<xsl:value-of select="$cln"/>
						<xsl:value-of select="$me"/>
					</xsl:message>
					<xsl:call-template name="checkReference">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="sheet2">Contact</xsl:with-param>
						<xsl:with-param name="field1">IfcRelConnectsElements.OwnerHistory</xsl:with-param>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="value1">
							<xsl:value-of select="$ohfull"/>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:call-template name="checkReference">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="sheet2">Component</xsl:with-param>
						<xsl:with-param name="field1">IfcRelConnectsElement.RelatingElement</xsl:with-param>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="value1">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="4"/>
							</xsl:call-template>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:call-template name="checkReference">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="sheet2">Component</xsl:with-param>
						<xsl:with-param name="field1">IfcRelConnectsElement.RelatedElement</xsl:with-param>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="value1">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="5"/>
							</xsl:call-template>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:element name="IfcRelConnectsElements">
						<xsl:call-template name="makeGUID">
							<xsl:with-param name="cd" select="$cd"/>
							<xsl:with-param name="me" select="$me"/>
							<xsl:with-param name="ty">rad</xsl:with-param>
							<xsl:with-param name="oh" select="$ohfull"/>
						</xsl:call-template>
						<Name>
							<xsl:value-of select="$me"/>
						</Name>
						<Description>
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="6"/>
							</xsl:call-template>
							<xsl:value-of select="$cln"/>
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="10"/>
							</xsl:call-template>
						</Description>
						<RelatingElement>
							<xsl:call-template name="makeREF">
								<xsl:with-param name="cd">Component</xsl:with-param>
								<xsl:with-param name="obj">IfcFurnishingElement</xsl:with-param>
								<xsl:with-param name="idref">
									<xsl:call-template name="getCellData">
										<xsl:with-param name="targetIndex" select="4"/>
									</xsl:call-template>
								</xsl:with-param>
							</xsl:call-template>
						</RelatingElement>
						<RelatedElement>
							<xsl:call-template name="makeREF">
								<xsl:with-param name="cd">Component</xsl:with-param>
								<xsl:with-param name="obj">IfcFurnishingElement</xsl:with-param>
								<xsl:with-param name="idref">
									<xsl:call-template name="getCellData">
										<xsl:with-param name="targetIndex" select="5"/>
									</xsl:call-template>
								</xsl:with-param>
							</xsl:call-template>
						</RelatedElement>
					</xsl:element>
				</xsl:when>
				<!-- Issue -->
				<xsl:when test="$cd='Issue'">
					<xsl:message>
						<xsl:text>IfcApproval</xsl:text>
						<xsl:value-of select="$cln"/>
						<xsl:value-of select="$me"/>
					</xsl:message>
					<xsl:call-template name="checkReference">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="sheet2">Contact</xsl:with-param>
						<xsl:with-param name="field1">IfcRelAssociatesApproval.OwnerHistory</xsl:with-param>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="value1">
							<xsl:value-of select="$ohfull"/>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:variable name="ty1">
						<xsl:call-template name="getCellData">
							<xsl:with-param name="targetIndex" select="8"/>
						</xsl:call-template>
					</xsl:variable>
					<xsl:variable name="ty2">
						<xsl:call-template name="getCellData">
							<xsl:with-param name="targetIndex" select="10"/>
						</xsl:call-template>
					</xsl:variable>
					<xsl:call-template name="checkReference">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="sheet2">
							<xsl:value-of select="$ty1"/>
						</xsl:with-param>
						<xsl:with-param name="field1">IfcRelAssociatesApproval.RelatedObjects</xsl:with-param>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="value1">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="9"/>
							</xsl:call-template>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:call-template name="checkReference">
						<xsl:with-param name="sheet1" select="$cd"/>
						<xsl:with-param name="sheet2">
							<xsl:value-of select="$ty2"/>
						</xsl:with-param>
						<xsl:with-param name="field1">IfcRelAssociatesApproval.RelatedObjects</xsl:with-param>
						<xsl:with-param name="me1" select="$me"/>
						<xsl:with-param name="value1">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="11"/>
							</xsl:call-template>
						</xsl:with-param>
					</xsl:call-template>
					<xsl:if test="not($ty1='Document') or not($ty2='Document')">
						<IfcRelAssociatesApproval>
							<xsl:call-template name="makeGUID">
								<xsl:with-param name="cd" select="$cd"/>
								<xsl:with-param name="me" select="$me"/>
								<xsl:with-param name="ty">rap</xsl:with-param>
								<xsl:with-param name="oh" select="$ohfull"/>
							</xsl:call-template>
							<Name>
								<xsl:value-of select="$me"/>
							</Name>
							<Description>
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="12"/>
								</xsl:call-template>
								<xsl:value-of select="$cln"/>
								<xsl:call-template name="getCellData">
									<xsl:with-param name="targetIndex" select="14"/>
								</xsl:call-template>
							</Description>
							<RelatedObjects>
								<xsl:if test="not($ty1='Document') ">
									<xsl:call-template name="makeREF">
										<xsl:with-param name="cd" select="$ty1"/>
										<xsl:with-param name="obj">
											<xsl:choose>
												<xsl:when test="$ty1='Facility'">IfcBuilding</xsl:when>
												<xsl:when test="$ty1='Floor'">IfcBuildingStorey</xsl:when>
												<xsl:when test="$ty1='Zone'">IfcZone</xsl:when>
												<xsl:when test="$ty1='System'">IfcSystem</xsl:when>
												<xsl:when test="$ty1='Space'">IfcSpace</xsl:when>
												<xsl:when test="$ty1='Component'">IfcFurnishingElement</xsl:when>
												<xsl:otherwise>IfcFurnishingElementType</xsl:otherwise>
											</xsl:choose>
										</xsl:with-param>
										<xsl:with-param name="idref">
											<xsl:call-template name="getCellData">
												<xsl:with-param name="targetIndex" select="9"/>
											</xsl:call-template>
										</xsl:with-param>
									</xsl:call-template>
								</xsl:if>
								<xsl:if test="not($ty2='Document') ">
									<xsl:call-template name="makeREF">
										<xsl:with-param name="cd" select="$ty2"/>
										<xsl:with-param name="obj">
											<xsl:choose>
												<xsl:when test="$ty2='Facility'">IfcBuilding</xsl:when>
												<xsl:when test="$ty2='Floor'">IfcBuildingStorey</xsl:when>
												<xsl:when test="$ty2='Zone'">IfcZone</xsl:when>
												<xsl:when test="$ty2='System'">IfcSystem</xsl:when>
												<xsl:when test="$ty2='Space'">IfcSpace</xsl:when>
												<xsl:when test="$ty2='Component'">IfcFurnishingElement</xsl:when>
												<xsl:otherwise>IfcFurnishingElementType</xsl:otherwise>
											</xsl:choose>
										</xsl:with-param>
										<xsl:with-param name="idref">
											<xsl:call-template name="getCellData">
												<xsl:with-param name="targetIndex" select="11"/>
											</xsl:call-template>
										</xsl:with-param>
									</xsl:call-template>
								</xsl:if>
							</RelatedObjects>
							<RelatingApproval>
								<xsl:variable name="dt1">
									<xsl:call-template name="getCellData">
										<xsl:with-param name="targetIndex" select="3"/>
									</xsl:call-template>
								</xsl:variable>
								<xsl:call-template name="approval1">
									<xsl:with-param name="desc1">
										<xsl:call-template name="getCellData">
											<xsl:with-param name="targetIndex" select="12"/>
										</xsl:call-template>
									</xsl:with-param>
									<xsl:with-param name="status1">Issue</xsl:with-param>
									<xsl:with-param name="level1">buildingSMART FM-10/COBie2</xsl:with-param>
									<xsl:with-param name="qualifier1">
										<xsl:call-template name="getCellData">
											<xsl:with-param name="targetIndex" select="14"/>
										</xsl:call-template>
									</xsl:with-param>
									<xsl:with-param name="name1">
										<xsl:call-template name="getCellData">
											<xsl:with-param name="targetIndex" select="12"/>
										</xsl:call-template>
									</xsl:with-param>
									<xsl:with-param name="identifier1">
										<xsl:value-of select="$me"/>
									</xsl:with-param>
								</xsl:call-template>
							</RelatingApproval>
						</IfcRelAssociatesApproval>
					</xsl:if>
				</xsl:when>
				<xsl:when test="$cd='PickLists'">
				</xsl:when>
				<xsl:when test="$cd='Instruction'">
				</xsl:when>
				<xsl:otherwise>
					<xsl:message>COBie2 <xsl:value-of select="$cd"/> UNEXPECTED worksheet </xsl:message>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:if>
	</xsl:template>
	<!-- utilities -->
	<xsl:template name="recurseList">
		<xsl:param name="seq"/>
		<xsl:param name="ty">IfcRoot</xsl:param>
		<xsl:param name="cd">UnknownSheet</xsl:param>
		<xsl:variable name="before1" select="normalize-space(substring-before($seq,$delimiter))"/>
		<xsl:variable name="after1" select="normalize-space(substring-after($seq,$delimiter))"/>
		<xsl:variable name="newRef">
			<xsl:choose>
				<xsl:when test="not(contains($seq,$delimiter)) and string-length(normalize-space($seq))>0">
					<xsl:value-of select="$seq"/>
				</xsl:when>
				<xsl:when test="string-length($before1)>0">
					<xsl:value-of select="$before1"/>
				</xsl:when>
			</xsl:choose>
		</xsl:variable>
		<xsl:if test="string-length(normalize-space($newRef))>0">
			<xsl:choose>
				<xsl:when test="($cd='Component')  and (1=count(//xl:Worksheet[normalize-space(@ss:Name)='System']/xl:Table/xl:Row[normalize-space(xl:Cell[1]/xl:Data)=normalize-space($newRef)])) ">
					<xsl:call-template name="makeREF">
						<xsl:with-param name="cd">System</xsl:with-param>
						<xsl:with-param name="obj">IfcSystem</xsl:with-param>
						<xsl:with-param name="idref" select="$newRef"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:when test="($cd='Space')  and (1=count(//xl:Worksheet[normalize-space(@ss:Name)='Zone']/xl:Table/xl:Row[normalize-space(xl:Cell[1]/xl:Data)=normalize-space($newRef)])) ">
					<xsl:call-template name="makeREF">
						<xsl:with-param name="cd">Zone</xsl:with-param>
						<xsl:with-param name="obj">IfcZone</xsl:with-param>
						<xsl:with-param name="idref" select="$newRef"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:otherwise>
					<xsl:call-template name="makeREF">
						<xsl:with-param name="cd" select="$cd"/>
						<xsl:with-param name="obj" select="$ty"/>
						<xsl:with-param name="idref" select="$newRef"/>
					</xsl:call-template>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:if>
		<xsl:if test="string-length($after1)>0">
			<xsl:call-template name="recurseList">
				<xsl:with-param name="cd" select="$cd"/>
				<xsl:with-param name="seq" select="$after1"/>
				<xsl:with-param name="ty" select="$ty"/>
			</xsl:call-template>
		</xsl:if>
	</xsl:template>
	<xsl:template name="makeAttributeReferences">
		<xsl:param name="cd">Type</xsl:param>
		<xsl:param name="me">0</xsl:param>
		<xsl:variable name="last">
			<xsl:choose>
				<xsl:when test="$cd='Facility'">22</xsl:when>
				<xsl:when test="$cd='Floor'">10</xsl:when>
				<xsl:when test="$cd='Space'">13</xsl:when>
				<xsl:when test="$cd='Zone'">9</xsl:when>
				<xsl:when test="$cd='System'">9</xsl:when>
				<xsl:when test="$cd='Type'">20</xsl:when>
				<xsl:when test="$cd='Component'">15</xsl:when>
				<xsl:when test="$cd='Job'">19</xsl:when>
				<xsl:otherwise>22</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<!-- spare columns -->
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="1 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="2 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="3 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="4 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="5 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="6 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="7 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="8 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="9 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="10 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="11 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="12 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="13 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="14 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="15 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="16 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="17 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="18 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="19 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="20 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="21 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="22 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="23 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="24 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="25 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="26 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="27 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="28 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="29 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="30 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="31 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="32 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="33 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="34 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="35 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="36 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="37 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="38 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="39 + $last"/>
		</xsl:call-template>
		<xsl:call-template name="attBonus">
			<xsl:with-param name="offset1" select="40 + $last"/>
		</xsl:call-template>
		<xsl:for-each select="//xl:Worksheet[@ss:Name='Attribute']/xl:Table/xl:Row">
			<xsl:variable name="cell1">
				<xsl:call-template name="getCellData">
					<xsl:with-param name="targetIndex" select="1"/>
				</xsl:call-template>
			</xsl:variable>
			<xsl:variable name="cell5">
				<xsl:call-template name="getCellData">
					<xsl:with-param name="targetIndex" select="5"/>
				</xsl:call-template>
			</xsl:variable>
			<xsl:variable name="cell6">
				<xsl:call-template name="getCellData">
					<xsl:with-param name="targetIndex" select="6"/>
				</xsl:call-template>
			</xsl:variable>
			<xsl:if test="($cell5 = $cd) and ($cell6 = $me)">
				<xsl:call-template name="makeREF">
					<xsl:with-param name="cd">Attribute</xsl:with-param>
					<xsl:with-param name="obj">IfcPropertySingleValue</xsl:with-param>
					<xsl:with-param name="idref">
						<xsl:value-of select="$cell5"/>_<xsl:value-of select="$cell6"/>_<xsl:value-of select="$cell1"/>
					</xsl:with-param>
				</xsl:call-template>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>
	<xsl:template name="makeAttributes">
		<xsl:param name="ty">Type</xsl:param>
		<xsl:param name="ob">IfcRoot</xsl:param>
		<xsl:param name="me">0</xsl:param>
		<xsl:param name="oh">0</xsl:param>
		<xsl:comment>Attribute relationship</xsl:comment>
		<IfcRelDefinesByProperties>
			<xsl:call-template name="makeGUID">
				<xsl:with-param name="cd" select="$ty"/>
				<xsl:with-param name="ob" select="$ob"/>
				<xsl:with-param name="me" select="$me"/>
				<xsl:with-param name="ty">rdbp</xsl:with-param>
				<xsl:with-param name="oh" select="$oh"/>
			</xsl:call-template>
			<Name>Associated COBie2 Attributes</Name>
			<Description>Associated COBie2 Attributes</Description>
			<RelatedObjects ex:cType="set">
				<xsl:call-template name="makeREF">
					<xsl:with-param name="cd" select="$ty"/>
					<xsl:with-param name="obj" select="$ob"/>
					<xsl:with-param name="idref" select="$me"/>
				</xsl:call-template>
			</RelatedObjects>
			<RelatingPropertyDefinition>
				<IfcPropertySet>
					<xsl:call-template name="makeGUID">
						<xsl:with-param name="cd" select="$ty"/>
						<xsl:with-param name="me" select="$me"/>
						<xsl:with-param name="ty">ps0</xsl:with-param>
						<xsl:with-param name="oh" select="$oh"/>
					</xsl:call-template>
					<Name>Pset_<xsl:value-of select="$ty"/>_COBie2</Name>
					<Description>Properties for <xsl:value-of select="$ty"/> found in COBie2</Description>
					<HasProperties>
						<xsl:choose>
							<xsl:when test="$ty='Space'">
								<IfcPropertySingleValue>
									<Name>RoomTag</Name>
									<Description>Occupiers room identification</Description>
									<NominalValue>
										<IfcLabel>
											<xsl:call-template name="getCellData">
												<xsl:with-param name="targetIndex" select="10"/>
											</xsl:call-template>
											<xsl:text> </xsl:text>
										</IfcLabel>
									</NominalValue>
								</IfcPropertySingleValue>
								<IfcPropertySingleValue>
									<Name>UseableHeight</Name>
									<Description>indicative usable height</Description>
									<NominalValue>
										<IfcLabel>
											<xsl:call-template name="getCellData">
												<xsl:with-param name="targetIndex" select="11"/>
											</xsl:call-template>
											<xsl:text> </xsl:text>
										</IfcLabel>
									</NominalValue>
								</IfcPropertySingleValue>
							</xsl:when>
							<xsl:when test="$ty='Component'">
								<IfcPropertySingleValue>
									<Name>SerialNumber</Name>
									<Description>The manufacturers unique component identifer</Description>
									<NominalValue>
										<IfcLabel>
											<xsl:call-template name="getCellData">
												<xsl:with-param name="targetIndex" select="10"/>
											</xsl:call-template>
											<xsl:text> </xsl:text>
										</IfcLabel>
									</NominalValue>
								</IfcPropertySingleValue>
								<IfcPropertySingleValue>
									<Name>InstallationDate</Name>
									<Description>Date of installation</Description>
									<NominalValue>
										<IfcLabel>
											<xsl:call-template name="getCellData">
												<xsl:with-param name="targetIndex" select="11"/>
											</xsl:call-template>
										</IfcLabel>
										<xsl:text> </xsl:text>
									</NominalValue>
								</IfcPropertySingleValue>
								<IfcPropertySingleValue>
									<Name>WarrantyStartDate</Name>
									<Description>Date of warranty start</Description>
									<NominalValue>
										<IfcLabel>
											<xsl:call-template name="getCellData">
												<xsl:with-param name="targetIndex" select="12"/>
											</xsl:call-template>
											<xsl:text> </xsl:text>
										</IfcLabel>
									</NominalValue>
								</IfcPropertySingleValue>
								<IfcPropertySingleValue>
									<Name>TagNumber</Name>
									<Description>Occupiers unique tag</Description>
									<NominalValue>
										<IfcLabel>
											<xsl:call-template name="getCellData">
												<xsl:with-param name="targetIndex" select="13"/>
											</xsl:call-template>
											<xsl:text> </xsl:text>
										</IfcLabel>
									</NominalValue>
								</IfcPropertySingleValue>
								<IfcPropertySingleValue>
									<Name>BarCode</Name>
									<Description>Identifying barcode or rfid</Description>
									<NominalValue>
										<IfcLabel>
											<xsl:call-template name="getCellData">
												<xsl:with-param name="targetIndex" select="14"/>
											</xsl:call-template>
											<xsl:text> </xsl:text>
										</IfcLabel>
									</NominalValue>
								</IfcPropertySingleValue>
								<IfcPropertySingleValue>
									<Name>AssetIdentifer</Name>
									<Description>Asset identifcation label</Description>
									<NominalValue>
										<IfcLabel>
											<xsl:call-template name="getCellData">
												<xsl:with-param name="targetIndex" select="15"/>
											</xsl:call-template>
										</IfcLabel>
										<xsl:text> </xsl:text>
									</NominalValue>
								</IfcPropertySingleValue>
							</xsl:when>
							<xsl:when test="$ty='Job'">
								<IfcPropertySingleValue>
									<Name>TaskDuration</Name>
									<Description>Estimated duration of task (hours)</Description>
									<NominalValue>
										<IfcLabel>
											<xsl:call-template name="ashour">
												<xsl:with-param name="dur1">
													<xsl:call-template name="getCellData">
														<xsl:with-param name="targetIndex" select="8"/>
													</xsl:call-template>
												</xsl:with-param>
												<xsl:with-param name="uni1">
													<xsl:call-template name="getCellData">
														<xsl:with-param name="targetIndex" select="9"/>
													</xsl:call-template>
												</xsl:with-param>
											</xsl:call-template>
											<xsl:text> </xsl:text>
										</IfcLabel>
									</NominalValue>
								</IfcPropertySingleValue>
								<IfcPropertySingleValue>
									<Name>TaskInterval</Name>
									<Description>Estimated interval between tasks (years)</Description>
									<NominalValue>
										<IfcLabel>
											<xsl:call-template name="asyear">
												<xsl:with-param name="dur1">
													<xsl:call-template name="getCellData">
														<xsl:with-param name="targetIndex" select="12"/>
													</xsl:call-template>
												</xsl:with-param>
												<xsl:with-param name="uni1">
													<xsl:call-template name="getCellData">
														<xsl:with-param name="targetIndex" select="13"/>
													</xsl:call-template>
												</xsl:with-param>
											</xsl:call-template>
										</IfcLabel>
										<xsl:text> </xsl:text>
									</NominalValue>
								</IfcPropertySingleValue>
								<IfcPropertySingleValue>
									<Name>TaskStartDate</Name>
									<Description>Start date for task (or task cycle)</Description>
									<NominalValue>
										<IfcLabel>
											<xsl:call-template name="getCellData">
												<xsl:with-param name="targetIndex" select="10"/>
											</xsl:call-template>
										</IfcLabel>
										<xsl:text> </xsl:text>
									</NominalValue>
								</IfcPropertySingleValue>
							</xsl:when>
							<xsl:otherwise>
								<IfcPropertySingleValue>
									<Name>Update</Name>
									<Description>The date of the revision</Description>
									<NominalValue>
										<IfcLabel>
											<xsl:value-of select="$dat"/>
										</IfcLabel>
									</NominalValue>
								</IfcPropertySingleValue>
							</xsl:otherwise>
						</xsl:choose>
						<xsl:call-template name="makeAttributeReferences">
							<xsl:with-param name="cd" select="$ty"/>
							<xsl:with-param name="me" select="$me"/>
						</xsl:call-template>
					</HasProperties>
				</IfcPropertySet>
			</RelatingPropertyDefinition>
		</IfcRelDefinesByProperties>
		<!-- old color -->
		<xsl:if test="($ty='Component') or ($ty='Space')">
			<IfcRelDefinesByProperties>
				<xsl:call-template name="makeGUID">
					<xsl:with-param name="cd" select="$ty"/>
					<xsl:with-param name="ob" select="$ob"/>
					<xsl:with-param name="me" select="$me"/>
					<xsl:with-param name="ty">rdbg</xsl:with-param>
					<xsl:with-param name="oh" select="$oh"/>
				</xsl:call-template>
				<Name>Associated COBie2 Attributes</Name>
				<Description>Associated COBie2 Attributes</Description>
				<RelatedObjects ex:cType="set">
					<xsl:call-template name="makeREF">
						<xsl:with-param name="cd" select="$ty"/>
						<xsl:with-param name="obj" select="$ob"/>
						<xsl:with-param name="idref" select="$me"/>
					</xsl:call-template>
				</RelatedObjects>
				<RelatingPropertyDefinition>
					<IfcPropertySet>
						<xsl:call-template name="makeGUID">
							<xsl:with-param name="cd" select="$ty"/>
							<xsl:with-param name="me" select="$me"/>
							<xsl:with-param name="ty">psg</xsl:with-param>
							<xsl:with-param name="oh" select="$oh"/>
						</xsl:call-template>
						<Name>PSet_Draughting</Name>
						<Description>Properties for Draughting</Description>
						<HasProperties>
							<IfcPropertySingleValue>
								<Name>Layername</Name>
								<NominalValue>
									<IfcLabel>
										<xsl:call-template name="getCellData">
											<xsl:with-param name="targetIndex" select="4"/>
										</xsl:call-template>
									</IfcLabel>
								</NominalValue>
							</IfcPropertySingleValue>
							<xsl:call-template name="makeColor">
								<xsl:with-param name="cd1" select="$ty"/>
								<xsl:with-param name="me1" select="$me"/>
								<xsl:with-param name="ifc1">Pset</xsl:with-param>
							</xsl:call-template>
						</HasProperties>
					</IfcPropertySet>
				</RelatingPropertyDefinition>
			</IfcRelDefinesByProperties>
		</xsl:if>
	</xsl:template>
	<xsl:template name="attBonus">
		<xsl:param name="offset1">1</xsl:param>
		<xsl:variable name="bonus1">
			<xsl:call-template name="getCellData">
				<xsl:with-param name="targetIndex" select="$offset1"/>
			</xsl:call-template>
		</xsl:variable>
		<xsl:if test="string-length($bonus1)>0">
			<xsl:variable name="title1">
				<xsl:for-each select="../xl:Row[1]">
					<xsl:call-template name="getCellData">
						<xsl:with-param name="targetIndex" select="$offset1"/>
					</xsl:call-template>
				</xsl:for-each>
			</xsl:variable>
			<xsl:if test="$title1">
				<IfcPropertySingleValue>
					<Name>
						<xsl:value-of select="$title1"/>
					</Name>
					<Description>Value for <xsl:value-of select="$title1"/>
					</Description>
					<NominalValue>
						<IfcLabel>
							<xsl:value-of select="$bonus1"/>
						</IfcLabel>
					</NominalValue>
				</IfcPropertySingleValue>
			</xsl:if>
		</xsl:if>
	</xsl:template>
	<xsl:template name="makeCategory">
		<xsl:param name="cd">Type</xsl:param>
		<xsl:param name="tx">x: unknown</xsl:param>
		<xsl:element name="IfcClassificationReference">
			<xsl:element name="Location">
				<xsl:value-of select="$tx"/>
			</xsl:element>
			<xsl:variable name="cat1">:</xsl:variable>
			<xsl:choose>
				<xsl:when test="contains($tx,$cat1)">
					<xsl:element name="ItemReference">
						<xsl:value-of select="normalize-space(substring-before($tx,$cat1))"/>
					</xsl:element>
					<xsl:element name="Name">
						<xsl:value-of select="normalize-space(substring-after($tx,$cat1))"/>
					</xsl:element>
				</xsl:when>
				<xsl:otherwise>
					<xsl:element name="ItemReference">
						<xsl:value-of select="$tx"/>
					</xsl:element>
					<xsl:element name="Name">
						<xsl:value-of select="$tx"/>
					</xsl:element>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:element>
	</xsl:template>
	<xsl:template name="makeShape">
		<xsl:param name="ty">Component</xsl:param>
		<xsl:param name="key1">aName</xsl:param>
		<xsl:variable name="x1">
			<xsl:call-template name="geometry">
				<xsl:with-param name="type" select="$ty"/>
				<xsl:with-param name="mode">lowerleft</xsl:with-param>
				<xsl:with-param name="axis">1</xsl:with-param>
				<xsl:with-param name="key1" select="$key1"/>
			</xsl:call-template>
		</xsl:variable>
		<xsl:variable name="x2">
			<xsl:call-template name="geometry">
				<xsl:with-param name="type" select="$ty"/>
				<xsl:with-param name="mode">upperright</xsl:with-param>
				<xsl:with-param name="axis">1</xsl:with-param>
				<xsl:with-param name="key1" select="$key1"/>
			</xsl:call-template>
		</xsl:variable>
		<xsl:variable name="dx">
			<xsl:value-of select="number($x2)-number($x1)"/>
		</xsl:variable>
		<xsl:variable name="a">
			<xsl:choose>
				<xsl:when test="$dx>0">
					<xsl:value-of select="$dx"/>
				</xsl:when>
				<xsl:when test="$ty='Space'">1000.0</xsl:when>
				<xsl:otherwise>100.0</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="y1">
			<xsl:call-template name="geometry">
				<xsl:with-param name="type" select="$ty"/>
				<xsl:with-param name="mode">lowerleft</xsl:with-param>
				<xsl:with-param name="axis">2</xsl:with-param>
				<xsl:with-param name="key1" select="$key1"/>
			</xsl:call-template>
		</xsl:variable>
		<xsl:variable name="y2">
			<xsl:call-template name="geometry">
				<xsl:with-param name="type" select="$ty"/>
				<xsl:with-param name="mode">upperright</xsl:with-param>
				<xsl:with-param name="axis">2</xsl:with-param>
				<xsl:with-param name="key1" select="$key1"/>
			</xsl:call-template>
		</xsl:variable>
		<xsl:variable name="dy">
			<xsl:value-of select="number($y2)-number($y1)"/>
		</xsl:variable>
		<xsl:variable name="b">
			<xsl:choose>
				<xsl:when test="$dy>0">
					<xsl:value-of select="$dy"/>
				</xsl:when>
				<xsl:when test="$ty='Space'">2000.0</xsl:when>
				<xsl:otherwise>200.0</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="z1">
			<xsl:call-template name="geometry">
				<xsl:with-param name="type" select="$ty"/>
				<xsl:with-param name="mode">lowerleft</xsl:with-param>
				<xsl:with-param name="axis">3</xsl:with-param>
				<xsl:with-param name="key1" select="$key1"/>
			</xsl:call-template>
		</xsl:variable>
		<xsl:variable name="z2">
			<xsl:call-template name="geometry">
				<xsl:with-param name="type" select="$ty"/>
				<xsl:with-param name="mode">upperright</xsl:with-param>
				<xsl:with-param name="axis">3</xsl:with-param>
				<xsl:with-param name="key1" select="$key1"/>
			</xsl:call-template>
		</xsl:variable>
		<xsl:variable name="dz">
			<xsl:value-of select="number($z2)-number($z1)"/>
		</xsl:variable>
		<xsl:variable name="c">
			<xsl:choose>
				<xsl:when test="$dz>0">
					<xsl:value-of select="$dz"/>
				</xsl:when>
				<xsl:when test="$ty='Space'">3000.0</xsl:when>
				<xsl:otherwise>300.0</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<Representation>
			<IfcProductDefinitionShape>
				<Representations ex:cType="list">
					<IfcShapeRepresentation>
						<ContextOfItems>
							<IfcGeometricRepresentationContext xsi:nil="true" ref="grc1"/>
						</ContextOfItems>
						<RepresentationIdentifier>Body</RepresentationIdentifier>
						<RepresentationType>SweptSolid</RepresentationType>
						<Items ex:cType="set">
							<xsl:element name="IfcExtrudedAreaSolid">
								<xsl:call-template name="makeID">
									<xsl:with-param name="idref">
										<xsl:text>item_</xsl:text>
										<xsl:value-of select="$key1"/>
									</xsl:with-param>
									<xsl:with-param name="cd" select="$ty"/>
								</xsl:call-template>
								<SweptArea>
									<IfcRectangleProfileDef>
										<ProfileType>area</ProfileType>
										<Position>
											<IfcAxis2Placement2D>
												<Location>
													<IfcCartesianPoint>
														<Coordinates ex:cType="list">
															<IfcLengthMeasure pos="0">
																<xsl:value-of select="$a div 2"/>
															</IfcLengthMeasure>
															<IfcLengthMeasure pos="1">
																<xsl:value-of select="$b div 2"/>
															</IfcLengthMeasure>
														</Coordinates>
													</IfcCartesianPoint>
												</Location>
												<RefDirection>
													<IfcDirection xsi:nil="true" ref="east2d"/>
												</RefDirection>
											</IfcAxis2Placement2D>
										</Position>
										<XDim>
											<xsl:value-of select="$a"/>
										</XDim>
										<YDim>
											<xsl:value-of select="$b"/>
										</YDim>
									</IfcRectangleProfileDef>
								</SweptArea>
								<Position>
									<IfcAxis2Placement3D xsi:nil="true" ref="triple"/>
								</Position>
								<ExtrudedDirection>
									<IfcDirection xsi:nil="true" ref="up"/>
								</ExtrudedDirection>
								<Depth>
									<xsl:value-of select="$c"/>
								</Depth>
							</xsl:element>
						</Items>
					</IfcShapeRepresentation>
					<!--
					<IfcShapeRepresentation>
						<ContextOfItems>
							<IfcGeometricRepresentationContext xsi:nil="true" ref="grc1"/>
						</ContextOfItems>
						<RepresentationIdentifier>Body</RepresentationIdentifier>
						<RepresentationType>SweptSolid</RepresentationType>
						<Items>
							<IfcExtrudedAreaSolid>
								<SweptArea>
									<IfcArbitraryClosedProfileDef>
										<ProfileType>area</ProfileType>
										<OuterCurve>
											<IfcPolyline>
												<Points>
													<IfcCartesianPoint xsi:nil="true" ref="origin2d"/>
													<IfcCartesianPoint>
														<Coordinates>
															<IfcLengthMeasure >
																<xsl:value-of select="$a"/>
															</IfcLengthMeasure>
															<IfcLengthMeasure pos="1">0.</IfcLengthMeasure>
														</Coordinates>
													</IfcCartesianPoint>
													<IfcCartesianPoint>
														<Coordinates>
															<IfcLengthMeasure >
																<xsl:value-of select="$a"/>
															</IfcLengthMeasure>
															<IfcLengthMeasure pos="1">
																<xsl:value-of select="$b"/>
															</IfcLengthMeasure>
														</Coordinates>
													</IfcCartesianPoint>
													<IfcCartesianPoint>
														<Coordinates>
															<IfcLengthMeasure >0.</IfcLengthMeasure>
															<IfcLengthMeasure >
																<xsl:value-of select="$b"/>
															</IfcLengthMeasure>
														</Coordinates>
													</IfcCartesianPoint>
													<IfcCartesianPoint xsi:nil="true" ref="origin2d"/>
												</Points>
											</IfcPolyline>
										</OuterCurve>
									</IfcArbitraryClosedProfileDef>
								</SweptArea>
								<Position>
									<IfcAxis2Placement3D>
										<Location>
											<IfcCartesianPoint xsi:nil="true" ref="origin"/>
										</Location>
										<Axis>
											<IfcDirection xsi:nil="true" ref="up"/>
										</Axis>
										<RefDirection>
											<IfcDirection xsi:nil="true" ref="east"/>
										</RefDirection>
									</IfcAxis2Placement3D>
								</Position>
								<ExtrudedDirection>
									<IfcDirection xsi:nil="true" ref="up"/>
								</ExtrudedDirection>
								<Depth>
									<xsl:value-of select="$c"/>
								</Depth>
							</IfcExtrudedAreaSolid>
						</Items>
					</IfcShapeRepresentation>
-->
					<!-- </xsl:if> -->
				</Representations>
			</IfcProductDefinitionShape>
		</Representation>
	</xsl:template>
	<xsl:template name="makeGUID">
		<xsl:param name="cd" select="xx"/>
		<xsl:param name="me" select="xx"/>
		<xsl:param name="ty" select="xx"/>
		<xsl:param name="cl" select="0"/>
		<xsl:param name="oh" select="0"/>
		<xsl:variable name="t">0<xsl:value-of select="$ty"/>
		</xsl:variable>
		<xsl:variable name="c" select="substring($cd,1,2)"/>
		<xsl:variable name="mx" select="normalize-space(translate($me,$string1,$string2))"/>
		<xsl:variable name="m" select="generate-id()"/>
		<xsl:variable name="alt1">
			<xsl:call-template name="getCellIndex">
				<xsl:with-param name="targetIndex" select="$cl"/>
			</xsl:call-template>
		</xsl:variable>
		<xsl:variable name="alt2">
			<xsl:call-template name="replace-string">
				<xsl:with-param name="text">
					<xsl:value-of select="substring(concat($t,$c,$m,'0000000000000000000000'),1,22)"/>
				</xsl:with-param>
				<xsl:with-param name="from" select="' '"/>
				<xsl:with-param name="to" select="'_'"/>
			</xsl:call-template>
		</xsl:variable>
		<xsl:element name="GlobalId">
			<xsl:choose>
				<xsl:when test="string-length($alt1)=22">
					<xsl:value-of select="$alt1"/>
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$alt2"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:element>
		<xsl:element name="OwnerHistory">
			<xsl:call-template name="makeREF">
				<xsl:with-param name="cd">Contact</xsl:with-param>
				<xsl:with-param name="obj">IfcOwnerHistory</xsl:with-param>
				<xsl:with-param name="idref" select="$oh"/>
			</xsl:call-template>
		</xsl:element>
	</xsl:template>
	<xsl:template name="getIFC">
		<xsl:param name="cl" select="0"/>
		<xsl:param name="df" select="IfcRoot"/>
		<xsl:variable name="userType">
			<xsl:call-template name="getCellData">
				<xsl:with-param name="targetIndex" select="$cl"/>
			</xsl:call-template>
		</xsl:variable>
		<xsl:choose>
			<xsl:when test="string-length(substring-after($userType,'Ifc'))>0">
				<xsl:value-of select="normalize-space($userType)"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="$df"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<xsl:template name="makeID">
		<xsl:param name="idref">0</xsl:param>
		<xsl:param name="cd">UnknownSheet</xsl:param>
		<xsl:attribute name="id"><xsl:call-template name="makeIDREF"><xsl:with-param name="idref" select="$idref"/><xsl:with-param name="cd" select="$cd"/></xsl:call-template></xsl:attribute>
	</xsl:template>
	<xsl:template name="makeREF">
		<xsl:param name="obj">IfcRoot</xsl:param>
		<xsl:param name="idref">_0</xsl:param>
		<xsl:param name="cd">UnknownSheet</xsl:param>
		<xsl:element name="{$obj}">
			<xsl:attribute name="xsi:nil" namespace="http://www.w3.org/2001/XMLSchema-instance">true</xsl:attribute>
			<xsl:attribute name="ref"><xsl:call-template name="makeIDREF"><xsl:with-param name="idref" select="$idref"/><xsl:with-param name="cd" select="$cd"/></xsl:call-template></xsl:attribute>
		</xsl:element>
	</xsl:template>
	<xsl:template name="makeIDREF">
		<xsl:param name="idref" select="_0"/>
		<xsl:param name="cd">UnknownSheet</xsl:param>
		<xsl:value-of select="$cd"/>
		<xsl:text>_</xsl:text>
		<xsl:value-of select="normalize-space( translate($idref,$string1,$string2))"/>
	</xsl:template>
	<!-- reusable replace-string function -->
	<xsl:template name="replace-string">
		<xsl:param name="text"/>
		<xsl:param name="from"/>
		<xsl:param name="to"/>
		<xsl:choose>
			<xsl:when test="contains($text, $from)">
				<xsl:variable name="before" select="substring-before($text, $from)"/>
				<xsl:variable name="after" select="substring-after($text, $from)"/>
				<xsl:variable name="prefix" select="concat($before, $to)"/>
				<xsl:value-of select="$before"/>
				<xsl:value-of select="$to"/>
				<xsl:call-template name="replace-string">
					<xsl:with-param name="text" select="$after"/>
					<xsl:with-param name="from" select="$from"/>
					<xsl:with-param name="to" select="$to"/>
				</xsl:call-template>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="$text"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<xsl:template name="geometry">
		<xsl:param name="mode">point</xsl:param>
		<xsl:param name="axis">3</xsl:param>
		<xsl:param name="type">Component</xsl:param>
		<xsl:param name="key1">aname</xsl:param>
		<xsl:for-each select="//xl:Worksheet[@ss:Name='Coordinate']/xl:Table/xl:Row[contains(xl:Cell[4]/xl:Data,$mode)][xl:Cell[5]/xl:Data=$type][xl:Cell[6]/xl:Data=$key1]">
			<xsl:variable name="lvalue">
				<xsl:call-template name="getCellData">
					<xsl:with-param name="targetIndex" select="6+$axis"/>
				</xsl:call-template>
			</xsl:variable>
			<xsl:choose>
				<xsl:when test="$lvalue='n/a'">
					<xsl:text>0.0</xsl:text>
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$lvalue * $unt1"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:for-each>
	</xsl:template>
	<xsl:template name="getCellIndex">
		<xsl:param name="targetIndex">1</xsl:param>
		<xsl:param name="otherIndex">0</xsl:param>
		<xsl:variable name="fullstring">
			<xsl:call-template name="getCellData">
				<xsl:with-param name="targetIndex" select="$targetIndex"/>
			</xsl:call-template>
		</xsl:variable>
		<xsl:value-of select="substring-before(concat($fullstring,$delimiter),$delimiter)"/>
	</xsl:template>
	<xsl:template name="getCellData">
		<xsl:param name="targetIndex">1</xsl:param>
		<xsl:param name="otherIndex">0</xsl:param>
		<xsl:choose>
			<xsl:when test="name()='Row'">
				<xsl:for-each select="xl:Cell[1]">
					<xsl:call-template name="getCellData">
						<xsl:with-param name="targetIndex" select="$targetIndex"/>
						<xsl:with-param name="otherIndex" select="$otherIndex"/>
					</xsl:call-template>
				</xsl:for-each>
			</xsl:when>
			<xsl:otherwise>
				<xsl:variable name="newIndex">
					<xsl:choose>
						<xsl:when test="@ss:Index">
							<xsl:value-of select="number(@ss:Index)"/>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="number($otherIndex)+1"/>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:variable>
				<xsl:choose>
					<xsl:when test="$newIndex=$targetIndex">
						<xsl:value-of select="xl:Data"/>
					</xsl:when>
					<xsl:when test="$newIndex>$targetIndex"/>
					<xsl:when test="not(following-sibling::xl:Cell[1])"/>
					<xsl:otherwise>
						<xsl:for-each select="(following-sibling::xl:Cell)[1]">
							<xsl:call-template name="getCellData">
								<xsl:with-param name="targetIndex" select="$targetIndex"/>
								<xsl:with-param name="otherIndex" select="$newIndex"/>
							</xsl:call-template>
						</xsl:for-each>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<xsl:template name="zero">
		<xsl:param name="avalue">0</xsl:param>
		<xsl:choose>
			<xsl:when test="$avalue>0">
				<xsl:value-of select="$avalue"/>
			</xsl:when>
			<xsl:when test="0>$avalue">
				<xsl:value-of select="$avalue"/>
			</xsl:when>
			<xsl:otherwise>0</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<xsl:template name="approval1">
		<xsl:param name="desc1">unknown</xsl:param>
		<xsl:param name="status1">NON COMPLIANT</xsl:param>
		<xsl:param name="level1">buildingSMART FM-10/COBie2</xsl:param>
		<xsl:param name="qualifier1">n/a</xsl:param>
		<xsl:param name="name1">n/a</xsl:param>
		<xsl:param name="identifier1">n/a</xsl:param>
		<IfcApproval>
			<Description>
				<xsl:value-of select="$desc1"/>
			</Description>
			<ApprovalDateTime>
				<IfcDateAndTime xsi:nil="true" ref="dt"/>
			</ApprovalDateTime>
			<ApprovalStatus>
				<xsl:value-of select="$status1"/>
			</ApprovalStatus>
			<ApprovalLevel>
				<xsl:value-of select="$level1"/>
			</ApprovalLevel>
			<ApprovalQualifier>
				<xsl:value-of select="$qualifier1"/>
			</ApprovalQualifier>
			<Name>
				<xsl:text>Application </xsl:text>
				<xsl:value-of select="$app1"/>
				<xsl:value-of select="$cln1"/>
				<xsl:text>Project </xsl:text>
				<xsl:value-of select="$prj1"/>
				<xsl:value-of select="$cln1"/>
				<xsl:text>Name </xsl:text>
				<xsl:value-of select="$name1"/>
			</Name>
			<Identifier>
				<xsl:value-of select="$identifier1"/>
			</Identifier>
		</IfcApproval>
	</xsl:template>
	<xsl:template name="checkInteresting">
		<xsl:param name="sheet1">Unknown</xsl:param>
		<xsl:param name="field1">Unknown</xsl:param>
		<xsl:param name="value1">Unknown</xsl:param>
		<xsl:param name="me1">Unknown</xsl:param>
		<xsl:choose>
			<xsl:when test="($value1='n/a') or ($value1='N/A') or (0=string-length($value1))">
				<xsl:message>
					<xsl:value-of select="$field1"/>
					<xsl:value-of select="$cln1"/>
					<xsl:value-of select="$value1"/> is insufficient for <xsl:value-of select="$sheet1"/>
					<xsl:text> </xsl:text>
					<xsl:value-of select="$me1"/>
				</xsl:message>
				<xsl:call-template name="approval1">
					<xsl:with-param name="desc1">
						<xsl:value-of select="$field1"/> is mandatory but <xsl:value-of select="$value1"/> is insufficient  for <xsl:value-of select="$sheet1"/>
						<xsl:text> </xsl:text>
						<xsl:value-of select="$me1"/>
					</xsl:with-param>
					<xsl:with-param name="level1">buildingSMART FM-10/COBie2</xsl:with-param>
					<xsl:with-param name="qualifier1">Data requirements</xsl:with-param>
					<xsl:with-param name="name1">
						<xsl:value-of select="$sheet1"/> mandatory <xsl:value-of select="$field1"/>
					</xsl:with-param>
					<xsl:with-param name="identifier1">
						<xsl:value-of select="$sheet1"/> mandatory data</xsl:with-param>
					<xsl:with-param name="status1">
						<xsl:if test="($value1='n/a') or ($value1='N/A') ">ADEQUATE COMPLIANCE</xsl:if>
						<xsl:if test="not($value1='n/a')  and not($value1='N/A') ">NON COMPLIANT</xsl:if>
					</xsl:with-param>
				</xsl:call-template>
			</xsl:when>
			<xsl:when test="$all='yes'">
				<xsl:call-template name="approval1">
					<xsl:with-param name="desc1">
						<xsl:value-of select="$field1"/> is mandatory and <xsl:value-of select="$value1"/> is sufficient  for <xsl:value-of select="$sheet1"/>
						<xsl:value-of select="$me1"/>
					</xsl:with-param>
					<xsl:with-param name="level1">buildingSMART FM-10/COBie2</xsl:with-param>
					<xsl:with-param name="qualifier1">Data requirements</xsl:with-param>
					<xsl:with-param name="name1">
						<xsl:value-of select="$sheet1"/> mandatory <xsl:value-of select="$field1"/>
					</xsl:with-param>
					<xsl:with-param name="identifier1">
						<xsl:value-of select="$sheet1"/> mandatory data</xsl:with-param>
					<xsl:with-param name="status1">COMPLIANT</xsl:with-param>
				</xsl:call-template>
			</xsl:when>
		</xsl:choose>
	</xsl:template>
	<xsl:template name="checkReference">
		<xsl:param name="sheet1">Unknown</xsl:param>
		<xsl:param name="sheet2">Unknown</xsl:param>
		<xsl:param name="field1">Unknown</xsl:param>
		<xsl:param name="value1">Unknown</xsl:param>
		<xsl:param name="me1">Unknown</xsl:param>
		<xsl:choose>
			<xsl:when test="0=count(//xl:Worksheet[normalize-space(@ss:Name)=normalize-space($sheet2)]/xl:Table/xl:Row[normalize-space(xl:Cell[1]/xl:Data)=normalize-space($value1)])">
				<xsl:message>
					<xsl:value-of select="$field1"/>
					<xsl:value-of select="$cln1"/>
					<xsl:value-of select="$value1"/> of <xsl:value-of select="$me1"/> not found as a  <xsl:value-of select="$sheet2"/>
				</xsl:message>
				<xsl:call-template name="approval1">
					<xsl:with-param name="desc1">
						<xsl:value-of select="$field1"/> makes reference to an unknown <xsl:value-of select="$sheet2"/> named <xsl:value-of select="$value1"/>
					</xsl:with-param>
					<xsl:with-param name="level1">buildingSMART FM-10/COBie2</xsl:with-param>
					<xsl:with-param name="qualifier1">Relational integrity</xsl:with-param>
					<xsl:with-param name="name1">
						<xsl:value-of select="$sheet1"/> relationship <xsl:value-of select="$field1"/>
					</xsl:with-param>
					<xsl:with-param name="identifier1">
						<xsl:value-of select="$sheet1"/> relationship</xsl:with-param>
				</xsl:call-template>
			</xsl:when>
			<xsl:when test="$all='yes'">
				<xsl:call-template name="approval1">
					<xsl:with-param name="desc1">
						<xsl:value-of select="$field1"/> makes good reference to <xsl:value-of select="$sheet2"/> named <xsl:value-of select="$value1"/>
					</xsl:with-param>
					<xsl:with-param name="level1">buildingSMART FM-10/COBie2</xsl:with-param>
					<xsl:with-param name="qualifier1">Relational integrity</xsl:with-param>
					<xsl:with-param name="name1">
						<xsl:value-of select="$sheet1"/> relationship <xsl:value-of select="$field1"/>
					</xsl:with-param>
					<xsl:with-param name="identifier1">
						<xsl:value-of select="$sheet1"/> relationship</xsl:with-param>
					<xsl:with-param name="status1">COMPLIANT</xsl:with-param>
				</xsl:call-template>
			</xsl:when>
		</xsl:choose>
	</xsl:template>
	<xsl:template name="asyear">
		<xsl:param name="dur1">as required</xsl:param>
		<xsl:param name="uni1">n/a</xsl:param>
		<xsl:choose>
			<xsl:when test="$uni1='month'">
				<xsl:value-of select="$dur1 div 12"/>
			</xsl:when>
			<xsl:when test="$uni1='quarter'">
				<xsl:value-of select="$dur1 div 4"/>
			</xsl:when>
			<xsl:when test="$uni1='week'">
				<xsl:value-of select="$dur1 div 52"/>
			</xsl:when>
			<xsl:when test="$uni1='day'">
				<xsl:value-of select="$dur1 div 365"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="$dur1"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<xsl:template name="ashour">
		<xsl:param name="dur1">as required</xsl:param>
		<xsl:param name="uni1">n/a</xsl:param>
		<xsl:choose>
			<xsl:when test="$uni1='minute'">
				<xsl:value-of select="$dur1 div 60"/>
			</xsl:when>
			<xsl:when test="$uni1='day'">
				<xsl:value-of select="$dur1 * 8"/>
			</xsl:when>
			<xsl:when test="$uni1='week'">
				<xsl:value-of select="$dur1 * 40"/>
			</xsl:when>
			<xsl:when test="$uni1='month'">
				<xsl:value-of select="$dur1 * 240"/>
			</xsl:when>
			<xsl:when test="$uni1='year'">
				<xsl:value-of select="$dur1 * 2880"/>
			</xsl:when>
			<xsl:otherwise>
				<xsl:value-of select="$dur1"/>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<xsl:template name="makeColor">
		<xsl:param name="cd1">Space</xsl:param>
		<xsl:param name="me1">item name</xsl:param>
		<xsl:param name="ifc1">Pset</xsl:param>
		<xsl:variable name="red0">
			<xsl:choose>
				<xsl:when test="($cd1='Component') ">
					<xsl:call-template name="getCellData">
						<xsl:with-param name="targetIndex" select="16"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:otherwise>
					<xsl:call-template name="getCellData">
						<xsl:with-param name="targetIndex" select="14"/>
					</xsl:call-template>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="green0">
			<xsl:choose>
				<xsl:when test="($cd1='Component') ">
					<xsl:call-template name="getCellData">
						<xsl:with-param name="targetIndex" select="17"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:otherwise>
					<xsl:call-template name="getCellData">
						<xsl:with-param name="targetIndex" select="15"/>
					</xsl:call-template>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="blue0">
			<xsl:choose>
				<xsl:when test="($cd1='Component') ">
					<xsl:call-template name="getCellData">
						<xsl:with-param name="targetIndex" select="18"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:otherwise>
					<xsl:call-template name="getCellData">
						<xsl:with-param name="targetIndex" select="16"/>
					</xsl:call-template>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="red1">
			<xsl:choose>
				<xsl:when test="($red0 >1)">
					<xsl:value-of select="$red0 div 255"/>
				</xsl:when>
				<xsl:when test="($red0 >= 0)">
					<xsl:value-of select="$red0"/>
				</xsl:when>
				<xsl:when test="($cd1='Component') ">0.9</xsl:when>
				<xsl:otherwise>0.1</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="green1">
			<xsl:choose>
				<xsl:when test="($green0 >1)">
					<xsl:value-of select="$green0 div 255"/>
				</xsl:when>
				<xsl:when test="($green0 >= 0)">
					<xsl:value-of select="$green0"/>
				</xsl:when>
				<xsl:when test="($cd1='Component') ">0.1</xsl:when>
				<xsl:otherwise>0.1</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="blue1">
			<xsl:choose>
				<xsl:when test="($blue0 >1)">
					<xsl:value-of select="$blue0 div 255"/>
				</xsl:when>
				<xsl:when test="($blue0 >= 0)">
					<xsl:value-of select="$blue0"/>
				</xsl:when>
				<xsl:when test="($cd1='Component') ">0.1</xsl:when>
				<xsl:otherwise>0.9</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:choose>
			<xsl:when test="$ifc1='Pset'">
				<IfcComplexProperty>
					<Name>Color</Name>
					<UsageName>Color</UsageName>
					<HasProperties>
						<IfcPropertySingleValue>
							<Name>Red</Name>
							<NominalValue>
								<IfcInteger>
									<xsl:value-of select="format-number(255*$red1,'0')"/>
								</IfcInteger>
							</NominalValue>
						</IfcPropertySingleValue>
						<IfcPropertySingleValue>
							<Name>Green</Name>
							<NominalValue>
								<IfcInteger>
									<xsl:value-of select="format-number(255*$green1,'0')"/>
								</IfcInteger>
							</NominalValue>
						</IfcPropertySingleValue>
						<IfcPropertySingleValue>
							<Name>Blue</Name>
							<NominalValue>
								<IfcInteger>
									<xsl:value-of select="format-number(255*$blue1,'0')"/>
								</IfcInteger>
							</NominalValue>
						</IfcPropertySingleValue>
					</HasProperties>
				</IfcComplexProperty>
			</xsl:when>
			<xsl:otherwise>
				<IfcPresentationStyleAssignment>
					<Styles>
						<IfcSurfaceStyle>
							<Side>both</Side>
							<Styles>
								<IfcSurfaceStyleShading>
									<SurfaceColour>
										<IfcColourRgb>
											<Red>
												<xsl:value-of select="$red1"/>
											</Red>
											<Green>
												<xsl:value-of select="$green1"/>
											</Green>
											<Blue>
												<xsl:value-of select="$blue1"/>
											</Blue>
										</IfcColourRgb>
									</SurfaceColour>
								</IfcSurfaceStyleShading>
							</Styles>
						</IfcSurfaceStyle>
					</Styles>
				</IfcPresentationStyleAssignment>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
</xsl:stylesheet>
