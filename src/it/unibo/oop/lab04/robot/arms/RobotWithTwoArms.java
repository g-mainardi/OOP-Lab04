package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.BaseRobot;

public class RobotWithTwoArms extends BaseRobot implements RobotWithArms {

	public static final double TRANSPORT_CONSMPTION = 0.5;
	
	private final BasicArm arm1;
	private final BasicArm arm2;
	
	public RobotWithTwoArms(String robotName) {
		super(robotName);
		this.arm1 = new BasicArm("Arm 1");
		this.arm2 = new BasicArm("Arm 2");
	}

	private boolean tryToPickUp(final BasicArm arm) {
		if (!arm.isGrabbing() && isBatteryEnough(arm.getConsumptionForPickUp())) {
			log(arm + "is picking an object");
			arm.pickUp();
			super.consumeBattery(arm.getConsumptionForPickUp());
			return true;
		}
		log("Pick up not possible : " + arm + " the battery is :" + super.getBatteryLevel());
		return false;
	}
	
	private boolean tryToDropDown(final BasicArm arm) {
		if (arm.isGrabbing() && isBatteryEnough(arm.getConsumptionForDropDown())) {
			log(arm + "is releasing an object");
			arm.dropDown();
			super.consumeBattery(arm.getConsumptionForDropDown());
			return true;
		}
		log("Drop down not possible : " + arm + " the battery is :" + super.getBatteryLevel());
		return false;
	}
	
	public boolean pickUp() {
		return this.tryToPickUp(this.arm1) || this.tryToPickUp(this.arm2);
	}

	public boolean dropDown() {
		return this.tryToDropDown(this.arm1) || this.tryToDropDown(this.arm2);
	}

	public int getCarriedItemsCount() {
		return (this.arm1.isGrabbing()? 1 : 0) + (this.arm2.isGrabbing()? 1 : 0);
	}


	protected double getBatteryRequirementForMovement() {
		return super.getBatteryRequirementForMovement() + TRANSPORT_CONSMPTION * getCarriedItemsCount();
	}

	
}
