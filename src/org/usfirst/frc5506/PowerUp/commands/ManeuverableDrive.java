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
/*
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5506.PowerUp.Robot;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.analysis.integration.*;*/

/**
 *
 *//*//TODO: Uncomment ManeuverableDrive
public class ManeuverableDrive extends Command {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public ManeuverableDrive(double xPos, double yPos) {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    	f = xPos;//end point is (f, g)
    	g = yPos;
    	
    	r = Math.sqrt(Math.pow(f, 2)+Math.pow(g, 2));//r = v|f^2 + g^2
		a = -g/r;
		b = Math.pow(r, 2)/Math.pow(f, 2);//b = r^2/f^2
    	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveBase);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	//Robot.driveBase.resetEncoders();//need to make this method and fix some access stuff
    	maxTurn = derivValue(f);//the most we'll be turning is how much we're turning at the endpoint
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	x = distanceTravelled/pathDistance * f;//x value of where we are on path is percentage of how far we've gone on curve with f as largest amount possible
    	rawTurn = derivValue(x);//y value of derivative from equation
    	turn = rawTurn/maxTurn;//scaled from 0 - 1
    	
    	Robot.driveBase.getMotors().arcadeDrive(0.7, turn);//go go powerUP Robot
    	distanceTravelled = (Robot.driveBase.getLeftRotation().getDistance()+Robot.driveBase.getRightRotation().getDistance())/2;//how far we've gone
    }


    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    	return (distanceTravelled >= pathDistance);//if we've gone as far as the path, we're done
    	//return (distanceTravelled<=pathDistance+2&&distanceTravelled>=pathDistance-2);//4" tolerance
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	//don't stop the motors because you want the robot to flow smoothly into next M.D. Command
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
    
    protected double value(double x) {//equation y value at certain x
		return a*Math.sqrt(r*r-b*x*x)-a*r;
	}
    
    protected double derivValue(double x) {//derivative y value at certain x
    	return -(a*b*x/Math.sqrt(r*r-b*x*x));
    }

    private double f, g, r, a, b, x, pathDistance, distanceTravelled, turn, rawTurn, maxTurn;
}*/