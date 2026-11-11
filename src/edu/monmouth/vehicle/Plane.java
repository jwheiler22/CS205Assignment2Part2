package edu.monmouth.vehicle;
//Joe Wheiler s1409757 Oct 28 FA26

import java.util.Objects;

public class Plane implements Vehicle{
	
	private int wingspan;
	private PowerTypes powerSource;
	
	public Plane(PowerTypes powerSource, int wingspan) {
		super();
		this.setWingspan(wingspan);
		this.setPowerSource(powerSource);
	}

	public int getWingspan() {
		return wingspan;
	}

	public void setWingspan(int wingspan) {
		this.wingspan = wingspan;
	}

	public PowerTypes getPowerSource() {
		return powerSource;
	}

	public void setPowerSource(PowerTypes powerSource) {
		this.powerSource = powerSource;
	}
	
	@Override
	public void go() {
		System.out.println("start engine");
	}

	@Override
	public void stop() {
		System.out.println("deploy landers");
	}
	
	@Override
	public PowerTypes powerBy() {
		System.out.println("Use " +powerSource.name());
		return powerSource;
	}

	@Override
	public String toString() {
		return "Plane [wingspan=" + wingspan + ", powerSource=" + powerSource + "]";
	}
	
	/*@Override
	public int hashCode() {
		return Objects.hash(powerSource, wingspan);
	}*/

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plane other = (Plane) obj;
		return powerSource == other.powerSource && wingspan == other.wingspan;
	}
}