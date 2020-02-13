package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class ShiftGear extends CommandBase {
  private DriveTrain dt;
  private DriveTrain.DriveGear gear;
  
  public ShiftGear(DriveTrain dt, DriveTrain.DriveGear gear) {
    addRequirements(dt);
    this.dt = dt;
    this.gear = gear;
  }

  @Override
  public void initialize() {
    this.dt.setDriveGear(this.gear);
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
