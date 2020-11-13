package it.unibo.oop.lab04.robot.arms;

public class BasicArm {

	private static final double POWER_TO_PICK_UP = 1.6;
	private static final double POWER_TO_DROP_DOWN = 1.4;
	
	final String name;
	private boolean grabbing;
	
	public BasicArm(final String name) {
		this.name = name;
		this.grabbing = false;
	}

	public boolean isGrabbing() {
		return this.grabbing;
	}
	
	public void pickUp() {
		this.grabbing = true;
	}
	
	public void dropDown() {
		this.grabbing= false;
	}
	
	public double getConsumptionForPickUp() {
		return POWER_TO_PICK_UP;
	}
	
	public double getConsumptionForDropDown() {
		return POWER_TO_DROP_DOWN;
	}

	public String toString() {
		return this.name + "[grab=" + this.isGrabbing() + "]";
	}
	
	
	
}
