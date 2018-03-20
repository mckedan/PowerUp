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

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.DigitalInput;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
//import edu.wpi.first.wpilibj.AnalogGyro;
//import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DoubleSolenoid armextendor;
    public static DoubleSolenoid handgripper;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Encoder leftRevs;
    public static Encoder rightRevs;
    public static Encoder armPos;
    public static Gyro gyro;
    public static DigitalInput foreLS;
    public static DigitalInput rearLS;
    public static  WPI_VictorSPX left;
    public static WPI_VictorSPX right;
    public static WPI_VictorSPX leftSlave;
    public static WPI_VictorSPX rightSlave;
    public static DifferentialDrive drive;
	public static WPI_TalonSRX elbow;

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    	
        //make motor controller objects for VictorSPX motor controllers that are driving robot
        left = new WPI_VictorSPX(4);
        right = new WPI_VictorSPX(2);
        
        //declare slave victor objects, same as above
        leftSlave = new WPI_VictorSPX(3); 
        rightSlave = new WPI_VictorSPX(1);
        
        //Make slave VictorSPX follow driver ones
        leftSlave.follow(left);
        rightSlave.follow(right);
        
        drive = new DifferentialDrive(left, right);
        //drive.setSafetyEnabled(false);
        
        elbow = new WPI_TalonSRX(1);
        elbow.setInverted(true);
    	
    	armextendor = new DoubleSolenoid(0, 6, 7);
        LiveWindow.addActuator("Arm", "extendor", armextendor);
        
        handgripper = new DoubleSolenoid(0, 4, 5);
        LiveWindow.addActuator("Hand", "gripper", handgripper);
        //these lines were generated by Robotbuilder, had to change port numbers so I moved it out -DM
        
        //these are all made by me because I couldn't get RobotBuilder to export for some reason?
        //I got RobotBuilder to work in GlitchenAutoTesting, it's MUCH easier with it working
        armPos = new Encoder(2, 6, false, EncodingType.k4X);
        leftRevs = new Encoder(0, 7, false, EncodingType.k4X);
        rightRevs = new Encoder(1, 5, false, EncodingType.k4X);
        
        /*TODO: Encoder distancePerPulses
        //http://www.andymark.com/E4T-OEM-Miniature-Optical-Encoder-Kit-p/am-3132.htm
        //According to the link, 1440 pulses per revolution, so one encoder distance is one wheel rotation.
        leftRevs.setDistancePerPulse((6*Math.PI)/1440);
        rightRevs.setDistancePerPulse((6*Math.PI)/1440);//1440 rev per pulse ; 6pi inches per rev
        */
        
        foreLS = new DigitalInput(3);
        rearLS = new DigitalInput(4);
        
        LiveWindow.addSensor("Arm", "Position", armPos);
        armPos.setDistancePerPulse(1);
        //armPos.setDistancePerPulse((6*Math.PI)/1440);
        //armPos.setPIDSourceParameter(PIDSourceParameter.kRate);//I guess we need an import, don't know it thoug
        
        gyro = new AnalogGyro(0);
        //gyro.setSensitivity(0.0015);//TODO: I can't use gyro setSensitivity(float) method
    }
}
