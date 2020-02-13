package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CompressorController extends SubsystemBase {
    private Compressor compressor = new Compressor(Constants.CANIds.PCM);
    
    private AnalogInput pressureTransducer = new AnalogInput(0);

    public CompressorController() {

    }

    @Override
    public void periodic() {
    }

    public void setCompressorState(boolean state) {
    	this.compressor.setClosedLoopControl(state);
    }
    
    public boolean getCompressorClosedLoopState() {
    	return this.compressor.getClosedLoopControl();
    }

    public boolean getCompressorState() {
    	return this.compressor.enabled();
    }
}
