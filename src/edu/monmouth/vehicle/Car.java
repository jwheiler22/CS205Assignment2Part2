package edu.monmouth.vehicle;
// Joe Wheiler s1409757 Oct 21 FA26

import java.util.Objects;

public class Car implements Vehicle {

	private int engineSize;
	private PowerTypes powerSource;
	
	public Car(PowerTypes powerSource, int engineSize) throws CarException {
		super();
		this.setPowerSource(powerSource);
		//try {
		this.setEngineSize(engineSize);
		//}
		//catch (CarException e) {
			//e.printStackTrace();
		//}
	}
	
	public int getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(int engineSize) throws CarException {
		if (engineSize < VehicleConstants.MINSIZE || engineSize > VehicleConstants.MAXSIZE) throw new CarException("Irregular engine size");
		this.engineSize = engineSize;
	}

	@Override
	public void go() {
		System.out.println("turn wheels");
	}

	@Override
	public void stop() {
		System.out.println("brakes");
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
	
	/*@Override
	public int hashCode() {
		return Objects.hash(engineSize, powerSource);
	}*/

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return engineSize == other.engineSize && powerSource == other.powerSource;
	}

	@Override
	public String toString() {
		return "Car [engineSize=" + engineSize + ", powerSource=" + powerSource + "]";
	}
	
}