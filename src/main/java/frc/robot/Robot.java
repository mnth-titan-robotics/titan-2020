/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.cameraserver.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private DriveSystem _drivesys;
  private OperatorInterface _opFace;
  private Intake _intake;
  
  

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    this._drivesys = new DriveSystem();
    this._opFace = new OperatorInterface();
    this._intake = new Intake();
    CameraServer.getInstance().startAutomaticCapture();
  }
  double x = 0.0;
  double y = 0.0;
  double balx = 0.0;
  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    this._drivesys.reset();
    this._opFace.reset();
    this._intake.reset();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    //xEntry.setDouble(balx);
    //AutonSearch.middle(balx, x);
    //AutonSearch.interpret(x, y);
    //this._drivesys.setCommands(0.0, y);
    //if(y == 0.0)
    //{
     // this._drivesys.setCommands(0.2, 0.0);
    //}
    this._drivesys.setCommands(1.0, 0.0);
    
    this._drivesys.update();
    }
  @Override
  public void teleopInit() {
    this._drivesys.reset();
    this._opFace.reset();
    this._intake.reset();
  }
  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    this._opFace.update();
    this._drivesys.setCommands(this._opFace.getDriveCmd(), this._opFace.getTurnCmd());
    this._intake.setCommands(this._opFace.getUpCmd(), this._opFace.getDownCmd());
    this._drivesys.update();
    this._intake.update();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void disabledInit() {
    this._drivesys.reset();
    this._opFace.reset();
    this._intake.reset();
  }
  @Override
  public void disabledPeriodic() {
    this._drivesys.setCommands(0.0, 0.0);
    this._drivesys.update();
    this._intake.setCommands(0.0, 0.0);
    this._intake.update();
  }
}
