/**
 * Copyright (C) 2009-2014 BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.ifc2x3tc1;

/******************************************************************************
 * Copyright (C) 2009-2019  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see {@literal<http://www.gnu.org/licenses/>}.
 *****************************************************************************/

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Ifc Currency Enum</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Package#getIfcCurrencyEnum()
 * @model
 * @generated
 */
public enum IfcCurrencyEnum implements Enumerator {
	/**
	 * The '<em><b>NULL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NULL_VALUE
	 * @generated
	 * @ordered
	 */
	NULL(0, "NULL", "NULL"),

	/**
	 * The '<em><b>ATS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ATS_VALUE
	 * @generated
	 * @ordered
	 */
	ATS(1, "ATS", "ATS"),

	/**
	 * The '<em><b>CHF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHF_VALUE
	 * @generated
	 * @ordered
	 */
	CHF(2, "CHF", "CHF"),

	/**
	 * The '<em><b>ITL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ITL_VALUE
	 * @generated
	 * @ordered
	 */
	ITL(3, "ITL", "ITL"),

	/**
	 * The '<em><b>FJD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FJD_VALUE
	 * @generated
	 * @ordered
	 */
	FJD(4, "FJD", "FJD"),

	/**
	 * The '<em><b>MXN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MXN_VALUE
	 * @generated
	 * @ordered
	 */
	MXN(5, "MXN", "MXN"),

	/**
	 * The '<em><b>SCR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SCR_VALUE
	 * @generated
	 * @ordered
	 */
	SCR(6, "SCR", "SCR"),

	/**
	 * The '<em><b>MTL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MTL_VALUE
	 * @generated
	 * @ordered
	 */
	MTL(7, "MTL", "MTL"),

	/**
	 * The '<em><b>BBD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BBD_VALUE
	 * @generated
	 * @ordered
	 */
	BBD(8, "BBD", "BBD"),

	/**
	 * The '<em><b>CLP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLP_VALUE
	 * @generated
	 * @ordered
	 */
	CLP(9, "CLP", "CLP"),

	/**
	 * The '<em><b>XEU</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #XEU_VALUE
	 * @generated
	 * @ordered
	 */
	XEU(10, "XEU", "XEU"),

	/**
	 * The '<em><b>ZAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZAR_VALUE
	 * @generated
	 * @ordered
	 */
	ZAR(11, "ZAR", "ZAR"),

	/**
	 * The '<em><b>VND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VND_VALUE
	 * @generated
	 * @ordered
	 */
	VND(12, "VND", "VND"),

	/**
	 * The '<em><b>TRL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRL_VALUE
	 * @generated
	 * @ordered
	 */
	TRL(13, "TRL", "TRL"),

	/**
	 * The '<em><b>AUD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AUD_VALUE
	 * @generated
	 * @ordered
	 */
	AUD(14, "AUD", "AUD"),

	/**
	 * The '<em><b>ILS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ILS_VALUE
	 * @generated
	 * @ordered
	 */
	ILS(15, "ILS", "ILS"),

	/**
	 * The '<em><b>BSD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BSD_VALUE
	 * @generated
	 * @ordered
	 */
	BSD(16, "BSD", "BSD"),

	/**
	 * The '<em><b>IDR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IDR_VALUE
	 * @generated
	 * @ordered
	 */
	IDR(17, "IDR", "IDR"),

	/**
	 * The '<em><b>KYD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KYD_VALUE
	 * @generated
	 * @ordered
	 */
	KYD(18, "KYD", "KYD"),

	/**
	 * The '<em><b>BWP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BWP_VALUE
	 * @generated
	 * @ordered
	 */
	BWP(19, "BWP", "BWP"),

	/**
	 * The '<em><b>CYS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CYS_VALUE
	 * @generated
	 * @ordered
	 */
	CYS(20, "CYS", "CYS"),

	/**
	 * The '<em><b>JOD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JOD_VALUE
	 * @generated
	 * @ordered
	 */
	JOD(21, "JOD", "JOD"),

	/**
	 * The '<em><b>GMD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GMD_VALUE
	 * @generated
	 * @ordered
	 */
	GMD(22, "GMD", "GMD"),

	/**
	 * The '<em><b>AED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AED_VALUE
	 * @generated
	 * @ordered
	 */
	AED(23, "AED", "AED"),

	/**
	 * The '<em><b>HKD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HKD_VALUE
	 * @generated
	 * @ordered
	 */
	HKD(24, "HKD", "HKD"),

	/**
	 * The '<em><b>TWD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TWD_VALUE
	 * @generated
	 * @ordered
	 */
	TWD(25, "TWD", "TWD"),

	/**
	 * The '<em><b>EUR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EUR_VALUE
	 * @generated
	 * @ordered
	 */
	EUR(26, "EUR", "EUR"),

	/**
	 * The '<em><b>DKK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DKK_VALUE
	 * @generated
	 * @ordered
	 */
	DKK(27, "DKK", "DKK"),

	/**
	 * The '<em><b>BGL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BGL_VALUE
	 * @generated
	 * @ordered
	 */
	BGL(28, "BGL", "BGL"),

	/**
	 * The '<em><b>ZWD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZWD_VALUE
	 * @generated
	 * @ordered
	 */
	ZWD(29, "ZWD", "ZWD"),

	/**
	 * The '<em><b>CAD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CAD_VALUE
	 * @generated
	 * @ordered
	 */
	CAD(30, "CAD", "CAD"),

	/**
	 * The '<em><b>MYR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MYR_VALUE
	 * @generated
	 * @ordered
	 */
	MYR(31, "MYR", "MYR"),

	/**
	 * The '<em><b>FKP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FKP_VALUE
	 * @generated
	 * @ordered
	 */
	FKP(32, "FKP", "FKP"),

	/**
	 * The '<em><b>MUR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MUR_VALUE
	 * @generated
	 * @ordered
	 */
	MUR(33, "MUR", "MUR"),

	/**
	 * The '<em><b>NOK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOK_VALUE
	 * @generated
	 * @ordered
	 */
	NOK(34, "NOK", "NOK"),

	/**
	 * The '<em><b>AES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AES_VALUE
	 * @generated
	 * @ordered
	 */
	AES(35, "AES", "AES"),

	/**
	 * The '<em><b>GIP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GIP_VALUE
	 * @generated
	 * @ordered
	 */
	GIP(36, "GIP", "GIP"),

	/**
	 * The '<em><b>LKR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LKR_VALUE
	 * @generated
	 * @ordered
	 */
	LKR(37, "LKR", "LKR"),

	/**
	 * The '<em><b>CZK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CZK_VALUE
	 * @generated
	 * @ordered
	 */
	CZK(38, "CZK", "CZK"),

	/**
	 * The '<em><b>OMR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OMR_VALUE
	 * @generated
	 * @ordered
	 */
	OMR(39, "OMR", "OMR"),

	/**
	 * The '<em><b>PGK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PGK_VALUE
	 * @generated
	 * @ordered
	 */
	PGK(40, "PGK", "PGK"),

	/**
	 * The '<em><b>PKR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PKR_VALUE
	 * @generated
	 * @ordered
	 */
	PKR(41, "PKR", "PKR"),

	/**
	 * The '<em><b>KES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KES_VALUE
	 * @generated
	 * @ordered
	 */
	KES(42, "KES", "KES"),

	/**
	 * The '<em><b>SEK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEK_VALUE
	 * @generated
	 * @ordered
	 */
	SEK(43, "SEK", "SEK"),

	/**
	 * The '<em><b>BHD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BHD_VALUE
	 * @generated
	 * @ordered
	 */
	BHD(44, "BHD", "BHD"),

	/**
	 * The '<em><b>QAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QAR_VALUE
	 * @generated
	 * @ordered
	 */
	QAR(45, "QAR", "QAR"),

	/**
	 * The '<em><b>CBD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CBD_VALUE
	 * @generated
	 * @ordered
	 */
	CBD(46, "CBD", "CBD"),

	/**
	 * The '<em><b>SAR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SAR_VALUE
	 * @generated
	 * @ordered
	 */
	SAR(47, "SAR", "SAR"),

	/**
	 * The '<em><b>TTD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TTD_VALUE
	 * @generated
	 * @ordered
	 */
	TTD(48, "TTD", "TTD"),

	/**
	 * The '<em><b>IRP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IRP_VALUE
	 * @generated
	 * @ordered
	 */
	IRP(49, "IRP", "IRP"),

	/**
	 * The '<em><b>NLG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NLG_VALUE
	 * @generated
	 * @ordered
	 */
	NLG(50, "NLG", "NLG"),

	/**
	 * The '<em><b>PTN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PTN_VALUE
	 * @generated
	 * @ordered
	 */
	PTN(51, "PTN", "PTN"),

	/**
	 * The '<em><b>GRX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GRX_VALUE
	 * @generated
	 * @ordered
	 */
	GRX(52, "GRX", "GRX"),

	/**
	 * The '<em><b>INR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INR_VALUE
	 * @generated
	 * @ordered
	 */
	INR(53, "INR", "INR"),

	/**
	 * The '<em><b>CNY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CNY_VALUE
	 * @generated
	 * @ordered
	 */
	CNY(54, "CNY", "CNY"),

	/**
	 * The '<em><b>THB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #THB_VALUE
	 * @generated
	 * @ordered
	 */
	THB(55, "THB", "THB"),

	/**
	 * The '<em><b>DDP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DDP_VALUE
	 * @generated
	 * @ordered
	 */
	DDP(56, "DDP", "DDP"),

	/**
	 * The '<em><b>KRW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KRW_VALUE
	 * @generated
	 * @ordered
	 */
	KRW(57, "KRW", "KRW"),

	/**
	 * The '<em><b>JPY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JPY_VALUE
	 * @generated
	 * @ordered
	 */
	JPY(58, "JPY", "JPY"),

	/**
	 * The '<em><b>PLN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLN_VALUE
	 * @generated
	 * @ordered
	 */
	PLN(59, "PLN", "PLN"),

	/**
	 * The '<em><b>GBP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GBP_VALUE
	 * @generated
	 * @ordered
	 */
	GBP(60, "GBP", "GBP"),

	/**
	 * The '<em><b>BMD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BMD_VALUE
	 * @generated
	 * @ordered
	 */
	BMD(61, "BMD", "BMD"),

	/**
	 * The '<em><b>HUF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HUF_VALUE
	 * @generated
	 * @ordered
	 */
	HUF(62, "HUF", "HUF"),

	/**
	 * The '<em><b>KWD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KWD_VALUE
	 * @generated
	 * @ordered
	 */
	KWD(63, "KWD", "KWD"),

	/**
	 * The '<em><b>PHP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PHP_VALUE
	 * @generated
	 * @ordered
	 */
	PHP(64, "PHP", "PHP"),

	/**
	 * The '<em><b>LUF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LUF_VALUE
	 * @generated
	 * @ordered
	 */
	LUF(65, "LUF", "LUF"),

	/**
	 * The '<em><b>JMD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JMD_VALUE
	 * @generated
	 * @ordered
	 */
	JMD(66, "JMD", "JMD"),

	/**
	 * The '<em><b>BEG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BEG_VALUE
	 * @generated
	 * @ordered
	 */
	BEG(67, "BEG", "BEG"),

	/**
	 * The '<em><b>EST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EST_VALUE
	 * @generated
	 * @ordered
	 */
	EST(68, "EST", "EST"),

	/**
	 * The '<em><b>USD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USD_VALUE
	 * @generated
	 * @ordered
	 */
	USD(69, "USD", "USD"),

	/**
	 * The '<em><b>EGL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EGL_VALUE
	 * @generated
	 * @ordered
	 */
	EGL(70, "EGL", "EGL"),

	/**
	 * The '<em><b>FIM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FIM_VALUE
	 * @generated
	 * @ordered
	 */
	FIM(71, "FIM", "FIM"),

	/**
	 * The '<em><b>BZD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BZD_VALUE
	 * @generated
	 * @ordered
	 */
	BZD(72, "BZD", "BZD"),

	/**
	 * The '<em><b>DEM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEM_VALUE
	 * @generated
	 * @ordered
	 */
	DEM(73, "DEM", "DEM"),

	/**
	 * The '<em><b>RUR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RUR_VALUE
	 * @generated
	 * @ordered
	 */
	RUR(74, "RUR", "RUR"),

	/**
	 * The '<em><b>ICK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ICK_VALUE
	 * @generated
	 * @ordered
	 */
	ICK(75, "ICK", "ICK"),

	/**
	 * The '<em><b>FAK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAK_VALUE
	 * @generated
	 * @ordered
	 */
	FAK(76, "FAK", "FAK"),

	/**
	 * The '<em><b>SGD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SGD_VALUE
	 * @generated
	 * @ordered
	 */
	SGD(77, "SGD", "SGD"),

	/**
	 * The '<em><b>VEB</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VEB_VALUE
	 * @generated
	 * @ordered
	 */
	VEB(78, "VEB", "VEB"),

	/**
	 * The '<em><b>BND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BND_VALUE
	 * @generated
	 * @ordered
	 */
	BND(79, "BND", "BND"),

	/**
	 * The '<em><b>NZD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NZD_VALUE
	 * @generated
	 * @ordered
	 */
	NZD(80, "NZD", "NZD"),

	/**
	 * The '<em><b>SKP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SKP_VALUE
	 * @generated
	 * @ordered
	 */
	SKP(81, "SKP", "SKP"),

	/**
	 * The '<em><b>FRF</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FRF_VALUE
	 * @generated
	 * @ordered
	 */
	FRF(82, "FRF", "FRF"),

	/**
	 * The '<em><b>BRL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BRL_VALUE
	 * @generated
	 * @ordered
	 */
	BRL(83, "BRL", "BRL");

	/**
	 * The '<em><b>NULL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NULL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NULL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NULL_VALUE = 0;

	/**
	 * The '<em><b>ATS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ATS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ATS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ATS_VALUE = 1;

	/**
	 * The '<em><b>CHF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CHF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CHF_VALUE = 2;

	/**
	 * The '<em><b>ITL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ITL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ITL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ITL_VALUE = 3;

	/**
	 * The '<em><b>FJD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FJD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FJD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FJD_VALUE = 4;

	/**
	 * The '<em><b>MXN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MXN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MXN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MXN_VALUE = 5;

	/**
	 * The '<em><b>SCR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SCR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SCR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SCR_VALUE = 6;

	/**
	 * The '<em><b>MTL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MTL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MTL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MTL_VALUE = 7;

	/**
	 * The '<em><b>BBD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BBD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BBD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BBD_VALUE = 8;

	/**
	 * The '<em><b>CLP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CLP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CLP_VALUE = 9;

	/**
	 * The '<em><b>XEU</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>XEU</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #XEU
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int XEU_VALUE = 10;

	/**
	 * The '<em><b>ZAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ZAR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZAR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ZAR_VALUE = 11;

	/**
	 * The '<em><b>VND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VND_VALUE = 12;

	/**
	 * The '<em><b>TRL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TRL_VALUE = 13;

	/**
	 * The '<em><b>AUD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AUD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AUD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AUD_VALUE = 14;

	/**
	 * The '<em><b>ILS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ILS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ILS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ILS_VALUE = 15;

	/**
	 * The '<em><b>BSD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BSD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BSD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BSD_VALUE = 16;

	/**
	 * The '<em><b>IDR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IDR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IDR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IDR_VALUE = 17;

	/**
	 * The '<em><b>KYD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KYD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KYD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KYD_VALUE = 18;

	/**
	 * The '<em><b>BWP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BWP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BWP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BWP_VALUE = 19;

	/**
	 * The '<em><b>CYS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CYS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CYS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CYS_VALUE = 20;

	/**
	 * The '<em><b>JOD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>JOD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JOD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int JOD_VALUE = 21;

	/**
	 * The '<em><b>GMD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GMD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GMD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GMD_VALUE = 22;

	/**
	 * The '<em><b>AED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AED
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AED_VALUE = 23;

	/**
	 * The '<em><b>HKD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HKD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HKD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HKD_VALUE = 24;

	/**
	 * The '<em><b>TWD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TWD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TWD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TWD_VALUE = 25;

	/**
	 * The '<em><b>EUR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EUR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EUR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EUR_VALUE = 26;

	/**
	 * The '<em><b>DKK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DKK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DKK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DKK_VALUE = 27;

	/**
	 * The '<em><b>BGL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BGL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BGL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BGL_VALUE = 28;

	/**
	 * The '<em><b>ZWD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ZWD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZWD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ZWD_VALUE = 29;

	/**
	 * The '<em><b>CAD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CAD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CAD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CAD_VALUE = 30;

	/**
	 * The '<em><b>MYR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MYR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MYR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MYR_VALUE = 31;

	/**
	 * The '<em><b>FKP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FKP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FKP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FKP_VALUE = 32;

	/**
	 * The '<em><b>MUR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MUR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MUR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MUR_VALUE = 33;

	/**
	 * The '<em><b>NOK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NOK_VALUE = 34;

	/**
	 * The '<em><b>AES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AES
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AES_VALUE = 35;

	/**
	 * The '<em><b>GIP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GIP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GIP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GIP_VALUE = 36;

	/**
	 * The '<em><b>LKR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LKR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LKR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LKR_VALUE = 37;

	/**
	 * The '<em><b>CZK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CZK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CZK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CZK_VALUE = 38;

	/**
	 * The '<em><b>OMR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>OMR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OMR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int OMR_VALUE = 39;

	/**
	 * The '<em><b>PGK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PGK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PGK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PGK_VALUE = 40;

	/**
	 * The '<em><b>PKR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PKR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PKR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PKR_VALUE = 41;

	/**
	 * The '<em><b>KES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KES</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KES
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KES_VALUE = 42;

	/**
	 * The '<em><b>SEK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SEK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SEK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SEK_VALUE = 43;

	/**
	 * The '<em><b>BHD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BHD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BHD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BHD_VALUE = 44;

	/**
	 * The '<em><b>QAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>QAR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QAR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int QAR_VALUE = 45;

	/**
	 * The '<em><b>CBD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CBD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CBD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CBD_VALUE = 46;

	/**
	 * The '<em><b>SAR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SAR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SAR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SAR_VALUE = 47;

	/**
	 * The '<em><b>TTD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TTD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TTD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TTD_VALUE = 48;

	/**
	 * The '<em><b>IRP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IRP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IRP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IRP_VALUE = 49;

	/**
	 * The '<em><b>NLG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NLG</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NLG
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NLG_VALUE = 50;

	/**
	 * The '<em><b>PTN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PTN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PTN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PTN_VALUE = 51;

	/**
	 * The '<em><b>GRX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GRX</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GRX
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GRX_VALUE = 52;

	/**
	 * The '<em><b>INR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INR_VALUE = 53;

	/**
	 * The '<em><b>CNY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CNY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CNY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CNY_VALUE = 54;

	/**
	 * The '<em><b>THB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>THB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #THB
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int THB_VALUE = 55;

	/**
	 * The '<em><b>DDP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DDP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DDP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DDP_VALUE = 56;

	/**
	 * The '<em><b>KRW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KRW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KRW
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KRW_VALUE = 57;

	/**
	 * The '<em><b>JPY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>JPY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JPY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int JPY_VALUE = 58;

	/**
	 * The '<em><b>PLN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PLN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PLN_VALUE = 59;

	/**
	 * The '<em><b>GBP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GBP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GBP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int GBP_VALUE = 60;

	/**
	 * The '<em><b>BMD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BMD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BMD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BMD_VALUE = 61;

	/**
	 * The '<em><b>HUF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HUF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HUF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HUF_VALUE = 62;

	/**
	 * The '<em><b>KWD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>KWD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KWD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int KWD_VALUE = 63;

	/**
	 * The '<em><b>PHP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PHP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PHP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PHP_VALUE = 64;

	/**
	 * The '<em><b>LUF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LUF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LUF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LUF_VALUE = 65;

	/**
	 * The '<em><b>JMD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>JMD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JMD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int JMD_VALUE = 66;

	/**
	 * The '<em><b>BEG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BEG</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BEG
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BEG_VALUE = 67;

	/**
	 * The '<em><b>EST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EST_VALUE = 68;

	/**
	 * The '<em><b>USD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>USD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int USD_VALUE = 69;

	/**
	 * The '<em><b>EGL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EGL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EGL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EGL_VALUE = 70;

	/**
	 * The '<em><b>FIM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FIM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FIM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FIM_VALUE = 71;

	/**
	 * The '<em><b>BZD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BZD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BZD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BZD_VALUE = 72;

	/**
	 * The '<em><b>DEM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DEM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DEM
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DEM_VALUE = 73;

	/**
	 * The '<em><b>RUR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RUR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RUR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int RUR_VALUE = 74;

	/**
	 * The '<em><b>ICK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ICK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ICK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ICK_VALUE = 75;

	/**
	 * The '<em><b>FAK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FAK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FAK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FAK_VALUE = 76;

	/**
	 * The '<em><b>SGD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SGD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SGD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SGD_VALUE = 77;

	/**
	 * The '<em><b>VEB</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VEB</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VEB
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int VEB_VALUE = 78;

	/**
	 * The '<em><b>BND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BND
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BND_VALUE = 79;

	/**
	 * The '<em><b>NZD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NZD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NZD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NZD_VALUE = 80;

	/**
	 * The '<em><b>SKP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SKP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SKP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SKP_VALUE = 81;

	/**
	 * The '<em><b>FRF</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FRF</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FRF
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int FRF_VALUE = 82;

	/**
	 * The '<em><b>BRL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BRL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BRL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BRL_VALUE = 83;

	/**
	 * An array of all the '<em><b>Ifc Currency Enum</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IfcCurrencyEnum[] VALUES_ARRAY = new IfcCurrencyEnum[] { NULL, ATS, CHF, ITL, FJD, MXN, SCR,
			MTL, BBD, CLP, XEU, ZAR, VND, TRL, AUD, ILS, BSD, IDR, KYD, BWP, CYS, JOD, GMD, AED, HKD, TWD, EUR, DKK,
			BGL, ZWD, CAD, MYR, FKP, MUR, NOK, AES, GIP, LKR, CZK, OMR, PGK, PKR, KES, SEK, BHD, QAR, CBD, SAR, TTD,
			IRP, NLG, PTN, GRX, INR, CNY, THB, DDP, KRW, JPY, PLN, GBP, BMD, HUF, KWD, PHP, LUF, JMD, BEG, EST, USD,
			EGL, FIM, BZD, DEM, RUR, ICK, FAK, SGD, VEB, BND, NZD, SKP, FRF, BRL, };

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
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcCurrencyEnum get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcCurrencyEnum result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Currency Enum</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcCurrencyEnum getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IfcCurrencyEnum result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ifc Currency Enum</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static IfcCurrencyEnum get(int value) {
		switch (value) {
		case NULL_VALUE:
			return NULL;
		case ATS_VALUE:
			return ATS;
		case CHF_VALUE:
			return CHF;
		case ITL_VALUE:
			return ITL;
		case FJD_VALUE:
			return FJD;
		case MXN_VALUE:
			return MXN;
		case SCR_VALUE:
			return SCR;
		case MTL_VALUE:
			return MTL;
		case BBD_VALUE:
			return BBD;
		case CLP_VALUE:
			return CLP;
		case XEU_VALUE:
			return XEU;
		case ZAR_VALUE:
			return ZAR;
		case VND_VALUE:
			return VND;
		case TRL_VALUE:
			return TRL;
		case AUD_VALUE:
			return AUD;
		case ILS_VALUE:
			return ILS;
		case BSD_VALUE:
			return BSD;
		case IDR_VALUE:
			return IDR;
		case KYD_VALUE:
			return KYD;
		case BWP_VALUE:
			return BWP;
		case CYS_VALUE:
			return CYS;
		case JOD_VALUE:
			return JOD;
		case GMD_VALUE:
			return GMD;
		case AED_VALUE:
			return AED;
		case HKD_VALUE:
			return HKD;
		case TWD_VALUE:
			return TWD;
		case EUR_VALUE:
			return EUR;
		case DKK_VALUE:
			return DKK;
		case BGL_VALUE:
			return BGL;
		case ZWD_VALUE:
			return ZWD;
		case CAD_VALUE:
			return CAD;
		case MYR_VALUE:
			return MYR;
		case FKP_VALUE:
			return FKP;
		case MUR_VALUE:
			return MUR;
		case NOK_VALUE:
			return NOK;
		case AES_VALUE:
			return AES;
		case GIP_VALUE:
			return GIP;
		case LKR_VALUE:
			return LKR;
		case CZK_VALUE:
			return CZK;
		case OMR_VALUE:
			return OMR;
		case PGK_VALUE:
			return PGK;
		case PKR_VALUE:
			return PKR;
		case KES_VALUE:
			return KES;
		case SEK_VALUE:
			return SEK;
		case BHD_VALUE:
			return BHD;
		case QAR_VALUE:
			return QAR;
		case CBD_VALUE:
			return CBD;
		case SAR_VALUE:
			return SAR;
		case TTD_VALUE:
			return TTD;
		case IRP_VALUE:
			return IRP;
		case NLG_VALUE:
			return NLG;
		case PTN_VALUE:
			return PTN;
		case GRX_VALUE:
			return GRX;
		case INR_VALUE:
			return INR;
		case CNY_VALUE:
			return CNY;
		case THB_VALUE:
			return THB;
		case DDP_VALUE:
			return DDP;
		case KRW_VALUE:
			return KRW;
		case JPY_VALUE:
			return JPY;
		case PLN_VALUE:
			return PLN;
		case GBP_VALUE:
			return GBP;
		case BMD_VALUE:
			return BMD;
		case HUF_VALUE:
			return HUF;
		case KWD_VALUE:
			return KWD;
		case PHP_VALUE:
			return PHP;
		case LUF_VALUE:
			return LUF;
		case JMD_VALUE:
			return JMD;
		case BEG_VALUE:
			return BEG;
		case EST_VALUE:
			return EST;
		case USD_VALUE:
			return USD;
		case EGL_VALUE:
			return EGL;
		case FIM_VALUE:
			return FIM;
		case BZD_VALUE:
			return BZD;
		case DEM_VALUE:
			return DEM;
		case RUR_VALUE:
			return RUR;
		case ICK_VALUE:
			return ICK;
		case FAK_VALUE:
			return FAK;
		case SGD_VALUE:
			return SGD;
		case VEB_VALUE:
			return VEB;
		case BND_VALUE:
			return BND;
		case NZD_VALUE:
			return NZD;
		case SKP_VALUE:
			return SKP;
		case FRF_VALUE:
			return FRF;
		case BRL_VALUE:
			return BRL;
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
	private IfcCurrencyEnum(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} //IfcCurrencyEnum
