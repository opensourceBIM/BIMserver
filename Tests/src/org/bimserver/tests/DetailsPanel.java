package org.bimserver.tests;

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

//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//import javax.swing.SpringLayout;
//
//import org.bimserver.database.FieldIgnoreMap;
//import org.bimserver.database.FileFieldIgnoreMap;
//import org.bimserver.database.IndexObjectWrapper;
//import org.bimserver.utils.BinUtils;
//import org.bimserver.utils.SpringUtilities;
//import org.eclipse.emf.ecore.EClass;
//import org.eclipse.emf.ecore.EDataType;
//import org.eclipse.emf.ecore.EEnum;
//import org.eclipse.emf.ecore.EEnumLiteral;
//import org.eclipse.emf.ecore.EStructuralFeature;
//import org.eclipse.emf.ecore.impl.EEnumImpl;
//
//public class DetailsPanel extends JPanel {
//
//	private static final long serialVersionUID = -8468276395770698154L;
//	private final FieldIgnoreMap fieldIgnoreMap;
//
//	public DetailsPanel(FileFieldIgnoreMap fieldIgnoreMap) {
//		this.fieldIgnoreMap = fieldIgnoreMap;
//		setLayout(new SpringLayout());
//	}
//
//	public void init(EClass eClass, byte[] value) {
//		removeAll();
//		if (value.length == 1 && value[0] == -1) {
//			JLabel label = new JLabel("Deleted");
//			add(label);
//		} else {
//			int index = 0;
//			int addedFields = 0;
//			for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
//				if (fieldIgnoreMap.shouldIgnoreField(feature)) {
//					// we have to do some reading to maintain a correct index
//					index = fakeRead(value, index, feature);
//				} else {
//					JLabel label = new JLabel(feature.getName());
//					add(label);
//					JTextField field = new JTextField(40);
//					add(field);
//					addedFields++;
//					if (feature.getUpperBound() == 1) {
//						if (feature.getEType() instanceof EEnum) {
//							byte[] integerBuffer = new byte[4];
//							System.arraycopy(value, index, integerBuffer, 0, integerBuffer.length);
//							int enumOrdinal = BinUtils.byteArrayToInt(integerBuffer);
//							EEnumLiteral enumLiteral = (((EEnumImpl) feature.getEType()).getEEnumLiteral(enumOrdinal));
//							field.setText(enumLiteral.getInstance().toString());
//							index += integerBuffer.length;
//						} else if (feature.getEType() instanceof EClass) {
//							field.setText("Reference");
//							IndexObjectWrapper iow = readReference(value, index);
//							if (iow.getObject() == null) {
//								field.setText("null");
//							} else {
//								field.setText(iow.getObject().toString());
//							}
//							index = iow.getIndex();
//						} else if (feature.getEType() instanceof EDataType) {
//							IndexObjectWrapper iow = readPrimitiveValue(feature, value, index);
//							field.setText(iow.getObject().toString());
//							index = iow.getIndex();
//						}
//					} else {
//						if (feature.getEType() instanceof EEnum) {
//						} else if (feature.getEType() instanceof EClass) {
//							if (value.length == 1 && value[0] == -1) {
//							} else {
//								byte[] shortBuffer = new byte[2];
//								System.arraycopy(value, index, shortBuffer, 0, shortBuffer.length);
//								short listSize = BinUtils.byteArrayToShort(shortBuffer);
//								field.setText("List(" + listSize + ")");
//								index += 2;
//								for (int i = 0; i < listSize; i++) {
//									IndexObjectWrapper iow = readReference(value, index);
//									index = iow.getIndex();
//								}
//							}
//						} else if (feature.getEType() instanceof EDataType) {
//							byte[] shortBuffer = new byte[2];
//							System.arraycopy(value, index, shortBuffer, 0, shortBuffer.length);
//							short listSize = BinUtils.byteArrayToShort(shortBuffer);
//							index += 2;
//							for (int i = 0; i < listSize; i++) {
//								IndexObjectWrapper iow = readPrimitiveValue(feature, value, index);
//								index = iow.getIndex();
//							}
//						}
//					}
//				}
//			}
//			SpringUtilities.makeCompactGrid(this, addedFields, 2, // rows,
//					// cols
//					6, 6, // initX, initY
//					6, 6); // xPad, yPad
//
//		}
//	}
//
//	private IndexObjectWrapper readReference(byte[] value, int index) {
//		IndexObjectWrapper indexObjectWrapper = new IndexObjectWrapper();
//		if (value.length == 1 && value[0] == -1) {
//			indexObjectWrapper.setIndex(index++);
//			return indexObjectWrapper;
//		}
//		byte[] shortBuffer = new byte[2];
//		System.arraycopy(value, index, shortBuffer, 0, shortBuffer.length);
//		short cid = BinUtils.byteArrayToShort(shortBuffer);
//		index += shortBuffer.length;
//		if (cid != -1) {
//			byte[] oidBuffer = new byte[8];
//			System.arraycopy(value, index, oidBuffer, 0, oidBuffer.length);
//			index += oidBuffer.length;
//			long oid = BinUtils.byteArrayToLong(oidBuffer);
//			indexObjectWrapper.setObject(oid);
//		}
//		indexObjectWrapper.setIndex(index);
//		return indexObjectWrapper;
//	}
//
//	private IndexObjectWrapper readPrimitiveValue(EStructuralFeature feature, byte[] value, int index) {
//		IndexObjectWrapper indexObjectWrapper = new IndexObjectWrapper();
//		if (feature.getEType().getName().equals("EString")) {
//			byte[] shortBuffer = new byte[2];
//			System.arraycopy(value, index, shortBuffer, 0, shortBuffer.length);
//			short stringLength = BinUtils.byteArrayToShort(shortBuffer);
//			index += 2;
//			byte[] stringBytes = new byte[stringLength];
//			System.arraycopy(value, index, stringBytes, 0, stringBytes.length);
//			index += stringBytes.length;
//			indexObjectWrapper.setObject(BinUtils.byteArrayToString(stringBytes));
//		} else if (feature.getEType().getName().equals("EInt")) {
//			byte[] intBuffer = new byte[4];
//			System.arraycopy(value, index, intBuffer, 0, intBuffer.length);
//			index += intBuffer.length;
//			indexObjectWrapper.setObject(BinUtils.byteArrayToInt(intBuffer));
//		} else if (feature.getEType().getName().equals("ELong")) {
//			byte[] longBuffer = new byte[8];
//			System.arraycopy(value, index, longBuffer, 0, longBuffer.length);
//			index += longBuffer.length;
//			indexObjectWrapper.setObject(BinUtils.byteArrayToLong(longBuffer));
//		} else if (feature.getEType().getName().equals("EFloat")) {
//			byte[] floatBuffer = new byte[4];
//			System.arraycopy(value, index, floatBuffer, 0, floatBuffer.length);
//			index += floatBuffer.length;
//			indexObjectWrapper.setObject(BinUtils.byteArrayToFloat(floatBuffer));
//		} else if (feature.getEType().getName().equals("EDouble")) {
//			byte[] doubleBuffer = new byte[8];
//			System.arraycopy(value, index, doubleBuffer, 0, doubleBuffer.length);
//			index += doubleBuffer.length;
//			indexObjectWrapper.setObject(BinUtils.byteArrayToDouble(doubleBuffer));
//		} else if (feature.getEType().getName().equals("EBoolean")) {
//			byte[] booleanBuffer = new byte[1];
//			System.arraycopy(value, index, booleanBuffer, 0, booleanBuffer.length);
//			index += booleanBuffer.length;
//			indexObjectWrapper.setObject(BinUtils.byteArrayToBoolean(booleanBuffer));
//		} else if (feature.getEType().getName().equals("EDate")) {
//			byte[] dateBuffer = new byte[8];
//			System.arraycopy(value, index, dateBuffer, 0, dateBuffer.length);
//			index += dateBuffer.length;
//			indexObjectWrapper.setObject(BinUtils.byteArrayToDate(dateBuffer));
//		}
//		indexObjectWrapper.setIndex(index);
//		return indexObjectWrapper;
//	}
//
//	private int fakeRead(byte[] value, int index, EStructuralFeature feature) {
//		if (feature.getUpperBound() > 1 || feature.getUpperBound() == -1) {
//			if (feature.getEType() instanceof EEnum) {
//			} else if (feature.getEType() instanceof EClass) {
//				if (value.length == 1 && value[0] == -1) {
//				} else {
//					byte[] shortBuffer = new byte[2];
//					System.arraycopy(value, index, shortBuffer, 0, shortBuffer.length);
//					short listSize = BinUtils.byteArrayToShort(shortBuffer);
//					index += 2;
//					for (int i = 0; i < listSize; i++) {
//						byte[] shortBuffer2 = new byte[2];
//						System.arraycopy(value, index, shortBuffer2, 0, shortBuffer2.length);
//						short cid = BinUtils.byteArrayToShort(shortBuffer2);
//						index += shortBuffer2.length;
//						if (cid != -1) {
//							index += 8;
//						}
//					}
//				}
//			} else if (feature.getEType() instanceof EDataType) {
//				byte[] shortBuffer = new byte[2];
//				System.arraycopy(value, index, shortBuffer, 0, shortBuffer.length);
//				short listSize = BinUtils.byteArrayToShort(shortBuffer);
//				index += 2;
//				for (int i = 0; i < listSize; i++) {
//					index += getPrimitiveTypeSize(feature, value, index);
//				}
//			}
//		} else {
//			if (feature.getEType() instanceof EEnum) {
//				index += 4;
//			} else if (feature.getEType() instanceof EClass) {
//				if (value.length == 1 && value[0] == -1) {
//					index++;
//				} else {
//					byte[] shortBuffer = new byte[2];
//					System.arraycopy(value, index, shortBuffer, 0, shortBuffer.length);
//					short cid = BinUtils.byteArrayToShort(shortBuffer);
//					index += shortBuffer.length;
//					if (cid != -1) {
//						index += 8;
//					}
//				}
//			} else if (feature.getEType() instanceof EDataType) {
//				index += getPrimitiveTypeSize(feature, value, index);
//			}
//		}
//		return index;
//	}
//
//	private int getPrimitiveTypeSize(EStructuralFeature feature, byte[] value, int index) {
//		if (feature.getEType().getName().equals("EString")) {
//			byte[] shortBuffer = new byte[2];
//			System.arraycopy(value, index, shortBuffer, 0, shortBuffer.length);
//			short stringLength = BinUtils.byteArrayToShort(shortBuffer);
//			return stringLength + 2;
//		} else if (feature.getEType().getName().equals("EInt")) {
//			return 4;
//		} else if (feature.getEType().getName().equals("ELong")) {
//			return 8;
//		} else if (feature.getEType().getName().equals("EFloat")) {
//			return 4;
//		} else if (feature.getEType().getName().equals("EDouble")) {
//			return 8;
//		} else if (feature.getEType().getName().equals("EBoolean")) {
//			return 1;
//		} else if (feature.getEType().getName().equals("EDate")) {
//			return 8;
//		}
//		return -0;
//	}
//
//	public void clear() {
//		removeAll();
//	}
//}