// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5506.PowerUp.subsystems;

import org.usfirst.frc5506.PowerUp.Robot;
import org.usfirst.frc5506.PowerUp.RobotMap;
import org.usfirst.frc5506.PowerUp.commands.*;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveBase extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    //make motor controller objects for VictorSPX motor controllers that are driving robot
    WPI_VictorSPX left = new WPI_VictorSPX(4);
    WPI_VictorSPX right = new WPI_VictorSPX(2);
    
    //declare slave victor objects, same as above
    WPI_VictorSPX leftSlave = new WPI_VictorSPX(3); 
    WPI_VictorSPX rightSlave = new WPI_VictorSPX(1);
    
    DifferentialDrive drive = new DifferentialDrive(left, right);
    
    public Encoder leftRevs = RobotMap.leftRevs;
    public Encoder rightRevs = RobotMap.rightRevs;
	
    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        //Motors mounted backwards so invert the ones on one side
        //left.setInverted(true);
        //leftSlave.setInverted(true);
    	//I guess none of them need to be inverted...?
    	
        //Make slave VictorSPX follow driver ones
        leftSlave.follow(left);
        rightSlave.follow(right);
        
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
    	drive(Robot.forward, Robot.turn);
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void drive(double forward, double turn) {
        //deadband
        if(Math.abs(forward) < .10)
        forward = 0;
        
        if(Math.abs(turn)<.10)
        	turn = 0;
        
        drive.arcadeDrive(-1*forward, turn);//for some reason something's backwards? but this fixes it
        									//Trial error like nothing else.
    }
    
    public Encoder getLeftRotation() {
    	return leftRevs;
    }
    
    public Encoder getRightRotation() {
    	return rightRevs;
    }

    public void driveAuto(boolean forwards) {
    	if(forwards==true)
    		direction = 0.5;
    	else
    		direction = -0.5;
    	
    	difference = rightRevs.getDistance()-leftRevs.getDistance();//difference of distances
    																//wheels travelled
    	
    	if(Math.abs(difference)>0.5)//if one side has gone farther than another
    		correction = difference;//turn the robot the amount that it's off
    	else
    		correction = 0;
    	
    	drive(direction, (correction/10));//play with this number -- imprecise
    								//if it gets off by more than half an inch, turn at 5%
    }
    
    protected double direction;
    protected double correction;
    protected double difference;
}