package org.bimserver;

public class Q {

	private long oid;
	private double area;
	private double volume;
	private int nrPrimitives;
	private long size;
	private double[] mibu;
	private double[] mabu;

	public Q(long oid, double area, double volume, int nrPrimitives, long size, double[] mibu, double[] mabu) {
		this.oid = oid;
		this.area = area;
		this.volume = volume;
		this.nrPrimitives = nrPrimitives;
		this.size = size;
		this.mibu = mibu;
		this.mabu = mabu;
	}
	
	public double[] getMibu() {
		return mibu;
	}

	public double[] getMabu() {
		return mabu;
	}
	
	public long getSize() {
		return size;
	}
	
	public double getArea() {
		return area;
	}
	
	public int getNrPrimitives() {
		return nrPrimitives;
	}
	
	public long getOid() {
		return oid;
	}
	
	public double getVolume() {
		return volume;
	}
}
