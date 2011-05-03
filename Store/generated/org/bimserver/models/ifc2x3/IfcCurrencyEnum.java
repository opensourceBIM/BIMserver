/**
 *  (c) Copyright bimserver.org 2009
 *  Licensed under GNU GPLv3
 *  http://www.gnu.org/licenses/gpl-3.0.txt
 *  For more information mail to license@bimserver.org
 *  
 *  Bimserver.org is free software: you can redistribute it and/or modify 
 *  it under the terms of the GNU General Public License as published by 
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Bimserver.org is distributed in the hope that it will be useful, but 
 *  WITHOUT ANY WARRANTY; without even the implied warranty of 
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 *  General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License a 
 *  long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Ifc Currency Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3.Ifc2x3Package#getIfcCurrencyEnum()
 * @model
 * @generated
 */
public enum IfcCurrencyEnum implements Enumerator
{
	/**
	 * The '<em><b>NULL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NULL
	 * @generated
	 * @ordered
	 */
	NULL_LITERAL(0, "NULL", "NULL"),

	/**
	 * The '<em><b>CNY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CNY
	 * @generated
	 * @ordered
	 */
	CNY_LITERAL(1, "CNY", "CNY"),

	/**
	 * The '<em><b>JPY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JPY
	 * @generated
	 * @ordered
	 */
	JPY_LITERAL(2, "JPY", "JPY"),

	/**
	 * The '<em><b>KYD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KYD
	 * @generated
	 * @ordered
	 */
	KYD_LITERAL(3, "KYD", "KYD"),

	/**
	 * The '<em><b>TTD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TTD
	 * @generated
	 * @ordered
	 */
	TTD_LITERAL(4, "TTD", "TTD"),

	/**
	 * The '<em><b>LKR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LKR
	 * @generated
	 * @ordered
	 */
	LKR_LITERAL(5, "LKR", "LKR"),

	/**
	 * The '<em><b>MXN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MXN
	 * @generated
	 * @ordered
	 */
	MXN_LITERAL(6, "MXN", "MXN"),

	/**
	 * The '<em><b>XEU</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #XEU
	 * @generated
	 * @ordered
	 */
	XEU_LITERAL(7, "XEU", "XEU"),

	/**
	 * The '<em><b>CAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CAD
	 * @generated
	 * @ordered
	 */
	CAD_LITERAL(8, "CAD", "CAD"),

	/**
	 * The '<em><b>ZAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZAR
	 * @generated
	 * @ordered
	 */
	ZAR_LITERAL(9, "ZAR", "ZAR"),

	/**
	 * The '<em><b>AUD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUD
	 * @generated
	 * @ordered
	 */
	AUD_LITERAL(10, "AUD", "AUD"),

	/**
	 * The '<em><b>DEM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEM
	 * @generated
	 * @ordered
	 */
	DEM_LITERAL(11, "DEM", "DEM"),

	/**
	 * The '<em><b>NOK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOK
	 * @generated
	 * @ordered
	 */
	NOK_LITERAL(12, "NOK", "NOK"),

	/**
	 * The '<em><b>ILS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ILS
	 * @generated
	 * @ordered
	 */
	ILS_LITERAL(13, "ILS", "ILS"),

	/**
	 * The '<em><b>AES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AES
	 * @generated
	 * @ordered
	 */
	AES_LITERAL(14, "AES", "AES"),

	/**
	 * The '<em><b>FAK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAK
	 * @generated
	 * @ordered
	 */
	FAK_LITERAL(15, "FAK", "FAK"),

	/**
	 * The '<em><b>PKR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PKR
	 * @generated
	 * @ordered
	 */
	PKR_LITERAL(16, "PKR", "PKR"),

	/**
	 * The '<em><b>BBD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BBD
	 * @generated
	 * @ordered
	 */
	BBD_LITERAL(17, "BBD", "BBD"),

	/**
	 * The '<em><b>THB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #THB
	 * @generated
	 * @ordered
	 */
	THB_LITERAL(18, "THB", "THB"),

	/**
	 * The '<em><b>SCR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCR
	 * @generated
	 * @ordered
	 */
	SCR_LITERAL(19, "SCR", "SCR"),

	/**
	 * The '<em><b>FKP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FKP
	 * @generated
	 * @ordered
	 */
	FKP_LITERAL(20, "FKP", "FKP"),

	/**
	 * The '<em><b>ATS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ATS
	 * @generated
	 * @ordered
	 */
	ATS_LITERAL(21, "ATS", "ATS"),

	/**
	 * The '<em><b>FIM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIM
	 * @generated
	 * @ordered
	 */
	FIM_LITERAL(22, "FIM", "FIM"),

	/**
	 * The '<em><b>IDR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IDR
	 * @generated
	 * @ordered
	 */
	IDR_LITERAL(23, "IDR", "IDR"),

	/**
	 * The '<em><b>AED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AED
	 * @generated
	 * @ordered
	 */
	AED_LITERAL(24, "AED", "AED"),

	/**
	 * The '<em><b>PGK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PGK
	 * @generated
	 * @ordered
	 */
	PGK_LITERAL(25, "PGK", "PGK"),

	/**
	 * The '<em><b>GIP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GIP
	 * @generated
	 * @ordered
	 */
	GIP_LITERAL(26, "GIP", "GIP"),

	/**
	 * The '<em><b>QAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QAR
	 * @generated
	 * @ordered
	 */
	QAR_LITERAL(27, "QAR", "QAR"),

	/**
	 * The '<em><b>BHD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BHD
	 * @generated
	 * @ordered
	 */
	BHD_LITERAL(28, "BHD", "BHD"),

	/**
	 * The '<em><b>BWP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BWP
	 * @generated
	 * @ordered
	 */
	BWP_LITERAL(29, "BWP", "BWP"),

	/**
	 * The '<em><b>BSD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BSD
	 * @generated
	 * @ordered
	 */
	BSD_LITERAL(30, "BSD", "BSD"),

	/**
	 * The '<em><b>IRP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IRP
	 * @generated
	 * @ordered
	 */
	IRP_LITERAL(31, "IRP", "IRP"),

	/**
	 * The '<em><b>DKK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DKK
	 * @generated
	 * @ordered
	 */
	DKK_LITERAL(32, "DKK", "DKK"),

	/**
	 * The '<em><b>SEK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEK
	 * @generated
	 * @ordered
	 */
	SEK_LITERAL(33, "SEK", "SEK"),

	/**
	 * The '<em><b>MYR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MYR
	 * @generated
	 * @ordered
	 */
	MYR_LITERAL(34, "MYR", "MYR"),

	/**
	 * The '<em><b>FJD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FJD
	 * @generated
	 * @ordered
	 */
	FJD_LITERAL(35, "FJD", "FJD"),

	/**
	 * The '<em><b>DDP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DDP
	 * @generated
	 * @ordered
	 */
	DDP_LITERAL(36, "DDP", "DDP"),

	/**
	 * The '<em><b>GRX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GRX
	 * @generated
	 * @ordered
	 */
	GRX_LITERAL(37, "GRX", "GRX"),

	/**
	 * The '<em><b>JMD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JMD
	 * @generated
	 * @ordered
	 */
	JMD_LITERAL(38, "JMD", "JMD"),

	/**
	 * The '<em><b>KRW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KRW
	 * @generated
	 * @ordered
	 */
	KRW_LITERAL(39, "KRW", "KRW"),

	/**
	 * The '<em><b>EST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EST
	 * @generated
	 * @ordered
	 */
	EST_LITERAL(40, "EST", "EST"),

	/**
	 * The '<em><b>BGL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BGL
	 * @generated
	 * @ordered
	 */
	BGL_LITERAL(41, "BGL", "BGL"),

	/**
	 * The '<em><b>ZWD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZWD
	 * @generated
	 * @ordered
	 */
	ZWD_LITERAL(42, "ZWD", "ZWD"),

	/**
	 * The '<em><b>CZK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CZK
	 * @generated
	 * @ordered
	 */
	CZK_LITERAL(43, "CZK", "CZK"),

	/**
	 * The '<em><b>FRF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRF
	 * @generated
	 * @ordered
	 */
	FRF_LITERAL(44, "FRF", "FRF"),

	/**
	 * The '<em><b>KWD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KWD
	 * @generated
	 * @ordered
	 */
	KWD_LITERAL(45, "KWD", "KWD"),

	/**
	 * The '<em><b>VEB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VEB
	 * @generated
	 * @ordered
	 */
	VEB_LITERAL(46, "VEB", "VEB"),

	/**
	 * The '<em><b>VND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VND
	 * @generated
	 * @ordered
	 */
	VND_LITERAL(47, "VND", "VND"),

	/**
	 * The '<em><b>TRL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRL
	 * @generated
	 * @ordered
	 */
	TRL_LITERAL(48, "TRL", "TRL"),

	/**
	 * The '<em><b>JOD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JOD
	 * @generated
	 * @ordered
	 */
	JOD_LITERAL(49, "JOD", "JOD"),

	/**
	 * The '<em><b>NZD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NZD
	 * @generated
	 * @ordered
	 */
	NZD_LITERAL(50, "NZD", "NZD"),

	/**
	 * The '<em><b>CLP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLP
	 * @generated
	 * @ordered
	 */
	CLP_LITERAL(51, "CLP", "CLP"),

	/**
	 * The '<em><b>GBP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GBP
	 * @generated
	 * @ordered
	 */
	GBP_LITERAL(52, "GBP", "GBP"),

	/**
	 * The '<em><b>KES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KES
	 * @generated
	 * @ordered
	 */
	KES_LITERAL(53, "KES", "KES"),

	/**
	 * The '<em><b>CHF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHF
	 * @generated
	 * @ordered
	 */
	CHF_LITERAL(54, "CHF", "CHF"),

	/**
	 * The '<em><b>EGL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EGL
	 * @generated
	 * @ordered
	 */
	EGL_LITERAL(55, "EGL", "EGL"),

	/**
	 * The '<em><b>MUR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MUR
	 * @generated
	 * @ordered
	 */
	MUR_LITERAL(56, "MUR", "MUR"),

	/**
	 * The '<em><b>SAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SAR
	 * @generated
	 * @ordered
	 */
	SAR_LITERAL(57, "SAR", "SAR"),

	/**
	 * The '<em><b>BZD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BZD
	 * @generated
	 * @ordered
	 */
	BZD_LITERAL(58, "BZD", "BZD"),

	/**
	 * The '<em><b>INR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INR
	 * @generated
	 * @ordered
	 */
	INR_LITERAL(59, "INR", "INR"),

	/**
	 * The '<em><b>PTN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PTN
	 * @generated
	 * @ordered
	 */
	PTN_LITERAL(60, "PTN", "PTN"),

	/**
	 * The '<em><b>TWD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TWD
	 * @generated
	 * @ordered
	 */
	TWD_LITERAL(61, "TWD", "TWD"),

	/**
	 * The '<em><b>BMD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BMD
	 * @generated
	 * @ordered
	 */
	BMD_LITERAL(62, "BMD", "BMD"),

	/**
	 * The '<em><b>ITL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ITL
	 * @generated
	 * @ordered
	 */
	ITL_LITERAL(63, "ITL", "ITL"),

	/**
	 * The '<em><b>OMR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OMR
	 * @generated
	 * @ordered
	 */
	OMR_LITERAL(64, "OMR", "OMR"),

	/**
	 * The '<em><b>SGD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SGD
	 * @generated
	 * @ordered
	 */
	SGD_LITERAL(65, "SGD", "SGD"),

	/**
	 * The '<em><b>NLG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NLG
	 * @generated
	 * @ordered
	 */
	NLG_LITERAL(66, "NLG", "NLG"),

	/**
	 * The '<em><b>SKP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SKP
	 * @generated
	 * @ordered
	 */
	SKP_LITERAL(67, "SKP", "SKP"),

	/**
	 * The '<em><b>HKD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HKD
	 * @generated
	 * @ordered
	 */
	HKD_LITERAL(68, "HKD", "HKD"),

	/**
	 * The '<em><b>RUR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RUR
	 * @generated
	 * @ordered
	 */
	RUR_LITERAL(69, "RUR", "RUR"),

	/**
	 * The '<em><b>GMD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GMD
	 * @generated
	 * @ordered
	 */
	GMD_LITERAL(70, "GMD", "GMD"),

	/**
	 * The '<em><b>CYS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CYS
	 * @generated
	 * @ordered
	 */
	CYS_LITERAL(71, "CYS", "CYS"),

	/**
	 * The '<em><b>CBD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CBD
	 * @generated
	 * @ordered
	 */
	CBD_LITERAL(72, "CBD", "CBD"),

	/**
	 * The '<em><b>BRL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BRL
	 * @generated
	 * @ordered
	 */
	BRL_LITERAL(73, "BRL", "BRL"),

	/**
	 * The '<em><b>EUR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EUR
	 * @generated
	 * @ordered
	 */
	EUR_LITERAL(74, "EUR", "EUR"),

	/**
	 * The '<em><b>ICK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ICK
	 * @generated
	 * @ordered
	 */
	ICK_LITERAL(75, "ICK", "ICK"),

	/**
	 * The '<em><b>BEG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BEG
	 * @generated
	 * @ordered
	 */
	BEG_LITERAL(76, "BEG", "BEG"),

	/**
	 * The '<em><b>PHP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PHP
	 * @generated
	 * @ordered
	 */
	PHP_LITERAL(77, "PHP", "PHP"),

	/**
	 * The '<em><b>HUF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HUF
	 * @generated
	 * @ordered
	 */
	HUF_LITERAL(78, "HUF", "HUF"),

	/**
	 * The '<em><b>PLN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLN
	 * @generated
	 * @ordered
	 */
	PLN_LITERAL(79, "PLN", "PLN"),

	/**
	 * The '<em><b>USD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USD
	 * @generated
	 * @ordered
	 */
	USD_LITERAL(80, "USD", "USD"),

	/**
	 * The '<em><b>MTL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MTL
	 * @generated
	 * @ordered
	 */
	MTL_LITERAL(81, "MTL", "MTL"),

	/**
	 * The '<em><b>LUF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LUF
	 * @generated
	 * @ordered
	 */
	LUF_LITERAL(82, "LUF", "LUF"),

	/**
	 * The '<em><b>BND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BND
	 * @generated
	 * @ordered
	 */
	BND_LITERAL(83, "BND", "BND");

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " (c) Copyright bimserver.org 2009\r\n Licensed under GNU GPLv3\r\n http://www.gnu.org/licenses/gpl-3.0.txt\r\n For more information mail to license@bimserver.org\r\n \r\n Bimserver.org is free software: you can redistribute it and/or modify \r\n it under the terms of the GNU General Public License as published by \r\n the Free Software Foundation, either version 3 of the License, or\r\n (at your option) any later version.\r\n \r\n Bimserver.org is distributed in the hope that it will be useful, but \r\n WITHOUT ANY WARRANTY; without even the implied warranty of \r\n MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU \r\n General Public License for more details.\r\n \r\n You should have received a copy of the GNU General Public License a \r\n long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.";

	/**
	 * The '<em><b>NULL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NULL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NULL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NULL = 0;

	/**
	 * The '<em><b>CNY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CNY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CNY_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CNY = 1;

	/**
	 * The '<em><b>JPY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>JPY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JPY_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int JPY = 2;

	/**
	 * The '<em><b>KYD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KYD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KYD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KYD = 3;

	/**
	 * The '<em><b>TTD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TTD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TTD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TTD = 4;

	/**
	 * The '<em><b>LKR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LKR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LKR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LKR = 5;

	/**
	 * The '<em><b>MXN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MXN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MXN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MXN = 6;

	/**
	 * The '<em><b>XEU</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>XEU</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #XEU_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int XEU = 7;

	/**
	 * The '<em><b>CAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CAD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CAD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CAD = 8;

	/**
	 * The '<em><b>ZAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ZAR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZAR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ZAR = 9;

	/**
	 * The '<em><b>AUD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AUD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AUD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AUD = 10;

	/**
	 * The '<em><b>DEM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DEM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DEM_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DEM = 11;

	/**
	 * The '<em><b>NOK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOK_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOK = 12;

	/**
	 * The '<em><b>ILS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ILS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ILS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ILS = 13;

	/**
	 * The '<em><b>AES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AES_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AES = 14;

	/**
	 * The '<em><b>FAK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FAK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FAK_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FAK = 15;

	/**
	 * The '<em><b>PKR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PKR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PKR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PKR = 16;

	/**
	 * The '<em><b>BBD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BBD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BBD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BBD = 17;

	/**
	 * The '<em><b>THB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>THB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #THB_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int THB = 18;

	/**
	 * The '<em><b>SCR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SCR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SCR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SCR = 19;

	/**
	 * The '<em><b>FKP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FKP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FKP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FKP = 20;

	/**
	 * The '<em><b>ATS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ATS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ATS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ATS = 21;

	/**
	 * The '<em><b>FIM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FIM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIM_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FIM = 22;

	/**
	 * The '<em><b>IDR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IDR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IDR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IDR = 23;

	/**
	 * The '<em><b>AED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AED_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AED = 24;

	/**
	 * The '<em><b>PGK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PGK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PGK_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PGK = 25;

	/**
	 * The '<em><b>GIP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GIP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GIP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GIP = 26;

	/**
	 * The '<em><b>QAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>QAR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QAR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int QAR = 27;

	/**
	 * The '<em><b>BHD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BHD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BHD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BHD = 28;

	/**
	 * The '<em><b>BWP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BWP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BWP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BWP = 29;

	/**
	 * The '<em><b>BSD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BSD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BSD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BSD = 30;

	/**
	 * The '<em><b>IRP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IRP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IRP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IRP = 31;

	/**
	 * The '<em><b>DKK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DKK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DKK_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DKK = 32;

	/**
	 * The '<em><b>SEK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SEK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SEK_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SEK = 33;

	/**
	 * The '<em><b>MYR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MYR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MYR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MYR = 34;

	/**
	 * The '<em><b>FJD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FJD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FJD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FJD = 35;

	/**
	 * The '<em><b>DDP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DDP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DDP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DDP = 36;

	/**
	 * The '<em><b>GRX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GRX</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GRX_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GRX = 37;

	/**
	 * The '<em><b>JMD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>JMD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JMD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int JMD = 38;

	/**
	 * The '<em><b>KRW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KRW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KRW_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KRW = 39;

	/**
	 * The '<em><b>EST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EST_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EST = 40;

	/**
	 * The '<em><b>BGL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BGL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BGL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BGL = 41;

	/**
	 * The '<em><b>ZWD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ZWD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZWD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ZWD = 42;

	/**
	 * The '<em><b>CZK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CZK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CZK_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CZK = 43;

	/**
	 * The '<em><b>FRF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FRF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FRF_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FRF = 44;

	/**
	 * The '<em><b>KWD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KWD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KWD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KWD = 45;

	/**
	 * The '<em><b>VEB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VEB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VEB_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VEB = 46;

	/**
	 * The '<em><b>VND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VND_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VND = 47;

	/**
	 * The '<em><b>TRL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRL = 48;

	/**
	 * The '<em><b>JOD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>JOD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JOD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int JOD = 49;

	/**
	 * The '<em><b>NZD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NZD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NZD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NZD = 50;

	/**
	 * The '<em><b>CLP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CLP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CLP = 51;

	/**
	 * The '<em><b>GBP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GBP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GBP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GBP = 52;

	/**
	 * The '<em><b>KES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KES_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KES = 53;

	/**
	 * The '<em><b>CHF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CHF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHF_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHF = 54;

	/**
	 * The '<em><b>EGL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EGL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EGL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EGL = 55;

	/**
	 * The '<em><b>MUR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MUR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MUR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MUR = 56;

	/**
	 * The '<em><b>SAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SAR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SAR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SAR = 57;

	/**
	 * The '<em><b>BZD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BZD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BZD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BZD = 58;

	/**
	 * The '<em><b>INR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INR = 59;

	/**
	 * The '<em><b>PTN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PTN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PTN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PTN = 60;

	/**
	 * The '<em><b>TWD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TWD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TWD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TWD = 61;

	/**
	 * The '<em><b>BMD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BMD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BMD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BMD = 62;

	/**
	 * The '<em><b>ITL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ITL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ITL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ITL = 63;

	/**
	 * The '<em><b>OMR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OMR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OMR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OMR = 64;

	/**
	 * The '<em><b>SGD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SGD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SGD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SGD = 65;

	/**
	 * The '<em><b>NLG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NLG</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NLG_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NLG = 66;

	/**
	 * The '<em><b>SKP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SKP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SKP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SKP = 67;

	/**
	 * The '<em><b>HKD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HKD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HKD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HKD = 68;

	/**
	 * The '<em><b>RUR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RUR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RUR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RUR = 69;

	/**
	 * The '<em><b>GMD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GMD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GMD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GMD = 70;

	/**
	 * The '<em><b>CYS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CYS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CYS_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CYS = 71;

	/**
	 * The '<em><b>CBD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CBD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CBD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CBD = 72;

	/**
	 * The '<em><b>BRL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BRL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BRL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BRL = 73;

	/**
	 * The '<em><b>EUR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EUR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EUR_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EUR = 74;

	/**
	 * The '<em><b>ICK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ICK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ICK_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ICK = 75;

	/**
	 * The '<em><b>BEG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BEG</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BEG_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BEG = 76;

	/**
	 * The '<em><b>PHP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PHP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PHP_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PHP = 77;

	/**
	 * The '<em><b>HUF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HUF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HUF_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HUF = 78;

	/**
	 * The '<em><b>PLN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PLN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLN_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PLN = 79;

	/**
	 * The '<em><b>USD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>USD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USD_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USD = 80;

	/**
	 * The '<em><b>MTL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MTL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MTL_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MTL = 81;

	/**
	 * The '<em><b>LUF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LUF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LUF_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LUF = 82;

	/**
	 * The '<em><b>BND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BND_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BND = 83;

	/**
	 * An array of all the '<em><b>Ifc Currency Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcCurrencyEnum[] VALUES_ARRAY =
		new IfcCurrencyEnum[]
		{
			NULL_LITERAL,
			CNY_LITERAL,
			JPY_LITERAL,
			KYD_LITERAL,
			TTD_LITERAL,
			LKR_LITERAL,
			MXN_LITERAL,
			XEU_LITERAL,
			CAD_LITERAL,
			ZAR_LITERAL,
			AUD_LITERAL,
			DEM_LITERAL,
			NOK_LITERAL,
			ILS_LITERAL,
			AES_LITERAL,
			FAK_LITERAL,
			PKR_LITERAL,
			BBD_LITERAL,
			THB_LITERAL,
			SCR_LITERAL,
			FKP_LITERAL,
			ATS_LITERAL,
			FIM_LITERAL,
			IDR_LITERAL,
			AED_LITERAL,
			PGK_LITERAL,
			GIP_LITERAL,
			QAR_LITERAL,
			BHD_LITERAL,
			BWP_LITERAL,
			BSD_LITERAL,
			IRP_LITERAL,
			DKK_LITERAL,
			SEK_LITERAL,
			MYR_LITERAL,
			FJD_LITERAL,
			DDP_LITERAL,
			GRX_LITERAL,
			JMD_LITERAL,
			KRW_LITERAL,
			EST_LITERAL,
			BGL_LITERAL,
			ZWD_LITERAL,
			CZK_LITERAL,
			FRF_LITERAL,
			KWD_LITERAL,
			VEB_LITERAL,
			VND_LITERAL,
			TRL_LITERAL,
			JOD_LITERAL,
			NZD_LITERAL,
			CLP_LITERAL,
			GBP_LITERAL,
			KES_LITERAL,
			CHF_LITERAL,
			EGL_LITERAL,
			MUR_LITERAL,
			SAR_LITERAL,
			BZD_LITERAL,
			INR_LITERAL,
			PTN_LITERAL,
			TWD_LITERAL,
			BMD_LITERAL,
			ITL_LITERAL,
			OMR_LITERAL,
			SGD_LITERAL,
			NLG_LITERAL,
			SKP_LITERAL,
			HKD_LITERAL,
			RUR_LITERAL,
			GMD_LITERAL,
			CYS_LITERAL,
			CBD_LITERAL,
			BRL_LITERAL,
			EUR_LITERAL,
			ICK_LITERAL,
			BEG_LITERAL,
			PHP_LITERAL,
			HUF_LITERAL,
			PLN_LITERAL,
			USD_LITERAL,
			MTL_LITERAL,
			LUF_LITERAL,
			BND_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Ifc Currency Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IfcCurrencyEnum> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ifc Currency Enum</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcCurrencyEnum get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcCurrencyEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Currency Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcCurrencyEnum getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			IfcCurrencyEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Currency Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IfcCurrencyEnum get(int value)
	{
		switch (value)
		{
			case NULL: return NULL_LITERAL;
			case CNY: return CNY_LITERAL;
			case JPY: return JPY_LITERAL;
			case KYD: return KYD_LITERAL;
			case TTD: return TTD_LITERAL;
			case LKR: return LKR_LITERAL;
			case MXN: return MXN_LITERAL;
			case XEU: return XEU_LITERAL;
			case CAD: return CAD_LITERAL;
			case ZAR: return ZAR_LITERAL;
			case AUD: return AUD_LITERAL;
			case DEM: return DEM_LITERAL;
			case NOK: return NOK_LITERAL;
			case ILS: return ILS_LITERAL;
			case AES: return AES_LITERAL;
			case FAK: return FAK_LITERAL;
			case PKR: return PKR_LITERAL;
			case BBD: return BBD_LITERAL;
			case THB: return THB_LITERAL;
			case SCR: return SCR_LITERAL;
			case FKP: return FKP_LITERAL;
			case ATS: return ATS_LITERAL;
			case FIM: return FIM_LITERAL;
			case IDR: return IDR_LITERAL;
			case AED: return AED_LITERAL;
			case PGK: return PGK_LITERAL;
			case GIP: return GIP_LITERAL;
			case QAR: return QAR_LITERAL;
			case BHD: return BHD_LITERAL;
			case BWP: return BWP_LITERAL;
			case BSD: return BSD_LITERAL;
			case IRP: return IRP_LITERAL;
			case DKK: return DKK_LITERAL;
			case SEK: return SEK_LITERAL;
			case MYR: return MYR_LITERAL;
			case FJD: return FJD_LITERAL;
			case DDP: return DDP_LITERAL;
			case GRX: return GRX_LITERAL;
			case JMD: return JMD_LITERAL;
			case KRW: return KRW_LITERAL;
			case EST: return EST_LITERAL;
			case BGL: return BGL_LITERAL;
			case ZWD: return ZWD_LITERAL;
			case CZK: return CZK_LITERAL;
			case FRF: return FRF_LITERAL;
			case KWD: return KWD_LITERAL;
			case VEB: return VEB_LITERAL;
			case VND: return VND_LITERAL;
			case TRL: return TRL_LITERAL;
			case JOD: return JOD_LITERAL;
			case NZD: return NZD_LITERAL;
			case CLP: return CLP_LITERAL;
			case GBP: return GBP_LITERAL;
			case KES: return KES_LITERAL;
			case CHF: return CHF_LITERAL;
			case EGL: return EGL_LITERAL;
			case MUR: return MUR_LITERAL;
			case SAR: return SAR_LITERAL;
			case BZD: return BZD_LITERAL;
			case INR: return INR_LITERAL;
			case PTN: return PTN_LITERAL;
			case TWD: return TWD_LITERAL;
			case BMD: return BMD_LITERAL;
			case ITL: return ITL_LITERAL;
			case OMR: return OMR_LITERAL;
			case SGD: return SGD_LITERAL;
			case NLG: return NLG_LITERAL;
			case SKP: return SKP_LITERAL;
			case HKD: return HKD_LITERAL;
			case RUR: return RUR_LITERAL;
			case GMD: return GMD_LITERAL;
			case CYS: return CYS_LITERAL;
			case CBD: return CBD_LITERAL;
			case BRL: return BRL_LITERAL;
			case EUR: return EUR_LITERAL;
			case ICK: return ICK_LITERAL;
			case BEG: return BEG_LITERAL;
			case PHP: return PHP_LITERAL;
			case HUF: return HUF_LITERAL;
			case PLN: return PLN_LITERAL;
			case USD: return USD_LITERAL;
			case MTL: return MTL_LITERAL;
			case LUF: return LUF_LITERAL;
			case BND: return BND_LITERAL;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private IfcCurrencyEnum(int value, String name, String literal)
	{
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue()
	{
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral()
	{
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		return literal;
	}
	
} //IfcCurrencyEnum
