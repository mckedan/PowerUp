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
import edu.wpi.first.wpilibj.command.CommandGroup;
//import org.usfirst.frc5506.PowerUp.*;

/**
 *    There's actually no special methods or robotbuilder stuff for CommandGroup,
 *    You just add in a bunch of addSequential()s and addParallel()s for your routine
 *    until the routine is finished. Nice, right? -DM
 **/
public class AutoThree extends CommandGroup {
	
	//protected double waitTime;//TODO: 1
	
	public AutoThree(char letter, String gameData) {
		//this.waitTime = Robot.waitTime;
		//setTimeout(waitTime);//TODO: 1
		
		switch(letter) {
		case 'a'://L == R for a
			//addSequential(new DriveLinear(4));
			addSequential(new Turn(45));
			//addSequential(new DriveLinear(47.376154));
			addSequential(new Turn(-45));
			//addSequential(new DriveLinear(84.75));
			break;
			
		case 'b':
			addSequential(new AutoThree('a', "R"));
			
			if(gameData.charAt(0)=='R') {
				//addSequential(new DriveLinear(85));
				addSequential(new Turn(-90));
				//addSequential(new DriveLinear(45));
				//At same time as above command is running, lower arm
				addParallel(new Curl(30));//TODO: Find the right angle for this
				addSequential(new moveHand(false));
			} else {
				//addSequential(new DriveLinear(153.75));
				addSequential(new Turn(-90));
				//addSequential(new DriveLinear(284));
				addSequential(new Turn(-90));
				//addSequential(new DriveLinear(68.75));
				addSequential(new Turn(-90));
				//addSequential(new DriveLinear(45));
				//Same time as above command, run the command below
				addParallel(new Curl(30));//TODO: Find the right angle for this
				addSequential(new moveHand(false));
				break;
			}
		}
	}
}
