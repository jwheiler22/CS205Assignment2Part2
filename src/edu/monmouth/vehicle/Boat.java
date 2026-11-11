package edu.monmouth.vehicle;
// Joe Wheiler s1409757 Oct 21 FA26

import java.util.Objects;

public class Boat implements Vehicle {
	
	private int boatLength;
	private PowerTypes powerSource;

	public Boat(PowerTypes powerSource, int boatLength) throws BoatException {
		super();
		this.setPowerSource(powerSource);
		//try {
		this.setBoatLength(boatLength);
		//}
		//catch (BoatException e) {
			//e.printStackTrace();
		//}
	}

	public int getBoatLength() {
		return boatLength;
	}

	public void setBoatLength(int boatLength) throws BoatException {
		if (boatLength < VehicleConstants.MINLENGTH || boatLength > VehicleConstants.MAXLENGTH) throw new BoatException("Irregular boat length");
		this.boatLength = boatLength;
	}

	@Override
	public void go() {
		System.out.println("turn propellor");
	}

	@Override
	public void stop() {
		System.out.println("drop anchor");
	}
	
	@Override
	public PowerTypes powerBy() {
		System.out.println("Use " +powerSource.name());
		return powerSource;
	}
	
	public PowerTypes getPowerSource() {
		return powerSource;
	}

	public void setPowerSource(PowerTypes powerSource) {
		this.powerSource = powerSource;
	}
	
	@Override
	public String toString() {
		return "Boat [boatLength=" + boatLength + ", powerSource=" + powerSource + "]";
	}

	/*@Override
	public int hashCode() {
		return Objects.hash(boatLength, powerSource);
	}*/

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Boat other = (Boat) obj;
		return boatLength == other.boatLength && powerSource == other.powerSource;
	}

}
