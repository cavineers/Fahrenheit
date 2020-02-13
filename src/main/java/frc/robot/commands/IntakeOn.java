package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeOn extends CommandBase {
  private Intake intake;

  public IntakeOn(Intake intake) {
    addRequirements(intake);
    this.intake = intake;
  }

  @Override
  public void initialize() {
    this.intake.setIntakeSpeed(1);
    
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
