package org.usfirst.frc5506.PowerUp.commands;

import org.usfirst.frc5506.PowerUp.Robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class TeleopDrive extends Command {

	protected double forward;
	protected double turn;
	
	Joystick joystick;
	private double elbowSpeed;
	private double elbowDown;
	private double elbowUp;
	private boolean driveMode;
	
	public TeleopDrive() {
		requires(Robot.driveBase);
		
		joystick = Robot.oi.getjoystick();
	}
	
	@Override
	protected void initialize() {
		driveMode = Robot.driveMode;
	}
	
	@Override
	protected void execute() {
		forward = -0.8*joystick.getY();//forward is always left y axis
        
        if(driveMode) {
        	turn = 0.68*joystick.getX();
        	elbowSpeed = 0.75*joystick.getRawAxis(5);
        } else {
        	turn = -0.75*joystick.getRawAxis(5);//make sure this is scaled the same as forward (left side)
        	elbowDown = joystick.getRawAxis(2);//left trigger
        	elbowUp = joystick.getRawAxis(3);//right trigger
        	
        	elbowSpeed = Math.max(elbowDown, elbowUp);//figure out which one is being pushed, then use it as elbowSpeed
        	if(elbowUp>elbowDown)//if going down,
        		elbowSpeed *= -1;//make sure motor runs in reverse
        }
        
        Robot.driveBase.drive(forward, turn);
    	Robot.elbow.rotateArm(elbowSpeed);
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

}
