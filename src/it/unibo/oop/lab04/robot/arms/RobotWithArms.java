package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.Robot;

public interface RobotWithArms extends Robot {

	public boolean pickUp();
	
	boolean dropDown();
	
	int getCarriedItemsCount();
}
