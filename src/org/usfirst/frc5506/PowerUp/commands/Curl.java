// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5506.PowerUp.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5506.PowerUp.Robot;

/**
 *
 **/
public class Curl extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
   public Curl(double liftDegrees) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        this.liftDegrees = liftDegrees;
        //Encoder, make sure that 0 is when arm is parallel to floor
    	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.elbow);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	if(liftDegrees<Robot.elbow.armPos.getDistance())//TODO: I switched these at SES
    		Robot.elbow.rotateArm(0.6);
    	else
    	Robot.elbow.rotateArm(-0.6);//play with this number for speed
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    	if(liftDegrees+2/*change to 2 degrees encoder units*/>Robot.elbow.armPos.getDistance()&&liftDegrees-2/*encoder units*/<Robot.elbow.armPos.getDistance())//if distance needed to rotate
    		return true;                                 //is greater than distance rotated
    	else                                             //stop rotating
            return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	Robot.elbow.rotateArm(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
    
    private double liftDegrees;
}
