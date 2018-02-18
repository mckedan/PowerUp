// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5506.PowerUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc5506.PowerUp.commands.*;
import org.usfirst.frc5506.PowerUp.subsystems.*;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {

    Command autonomousCommand;
    SendableChooser<Command> chooser = new SendableChooser<>();

    public static double elbowSpeed;
    public static double forward;
    public static double turn;
    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DriveBase driveBase;
    public static Elbow elbow;
    public static Arm arm;
    public static Hand hand;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    //int c=0; -- Testing Purposes
    Joystick joystick = new Joystick(0);
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        RobotMap.init();
        UsbCamera cam1 = CameraServer.getInstance().startAutomaticCapture();//only lines for cams; only need to
        UsbCamera cam2 = CameraServer.getInstance().startAutomaticCapture();//declare objects if there is more than one camera
        
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveBase = new DriveBase();
        elbow = new Elbow();
        arm = new Arm();
        hand = new Hand();

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // Add commands to Autonomous Sendable Chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        chooser.addDefault("Default -- #a", new AutoBoring());
        
        
        chooser.addObject("1a", new AutoOne('a', DriverStation.getInstance().getGameSpecificMessage()));
        chooser.addObject("1b", new AutoOne('b', DriverStation.getInstance().getGameSpecificMessage()));
        //chooser.addObject("1c", new AutoOne(c, /*String LRR*/));
        
        chooser.addObject("2a", new AutoTwo('a', DriverStation.getInstance().getGameSpecificMessage()));
        chooser.addObject("2b", new AutoTwo('b', DriverStation.getInstance().getGameSpecificMessage()));
        //chooser.addObject("2c", new AutoTwo(c, /*String LRR*/));
        
        chooser.addObject("3a", new AutoThree('a', DriverStation.getInstance().getGameSpecificMessage()));
        chooser.addObject("3b", new AutoThree('b', DriverStation.getInstance().getGameSpecificMessage()));
        //chooser.addObject("3c", new AutoThree(c, /*String LRR*/));
        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit(){

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        autonomousCommand = chooser.getSelected();
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
    	Scheduler.getInstance().run();
    	
        forward = -1*joystick.getY();
        turn = joystick.getX();
        elbowSpeed = joystick.getRawAxis(5);
        
        /**Testing Purposes: Find how values were working -- Remember to uncomment instantiation
         * c++;
         * if(c==50) {
         * System.out.println(elbowSpeed+" -- Robot's elbowSpeed");
         * System.out.println(forward+" -- Robot's forward");
         * c=0;}
         */
    }
}
