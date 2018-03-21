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
public class AutoTwo extends CommandGroup {
	
	//private double waitTime;//TODO: 1
	
	public AutoTwo(char letter, String gameData) {
		//this.waitTime = Robot.waitTime;
		//setTimeout(waitTime);//TODO: 1
		
		switch(letter) {
		case 'a'://L==R for a
			//addSequential(new DriveLinear(4));
			addSequential(new Turn(90));
			//addSequential(new DriveLinear(72));
			addSequential(new Turn(-45));
			//addSequential(new DriveLinear(47.376154));
			addSequential(new Turn(-45));
			//addSequential(new DriveLinear(84.75));
			break;
			
		case 'b':
			addSequential(new AutoTwo('a', "Hi"));
			
			if(gameData.charAt(0)=='R') {
				addSequential(new AutoThree('b', "R"));
			} else {
				addSequential(new AutoThree('b', "L"));
			}
		}
	}
}
