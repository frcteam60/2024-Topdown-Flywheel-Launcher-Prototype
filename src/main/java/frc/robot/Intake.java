package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Intake {
    // TODO: Switchintake to using a redline with a talon srx speed controller
    private TalonMotor motor = new TalonMotor(11);

    private final SendableChooser<String> chooser = new SendableChooser<>();

    private static final String kFullStop = "Full Stop";
    private static final String kFullIntake = "Full Intake";
    private static final String kReverse = "Slow Reject";

    public Intake() {
    }

    public void fullIntake() {
        motor.fullForward();
    }

    public void stopAll() {
        motor.stop();
    }

    public void reverse() {
        motor.runAtSpeed(-0.2);
    }

    void addDashboardDisplays() {
        chooser.setDefaultOption(kFullStop, kFullStop);
        chooser.addOption(kFullIntake, kFullIntake);
        chooser.addOption(kReverse, kReverse);
        SmartDashboard.putData("Intake Options", chooser);
    }

    public void periodicUpdate() {
        motor.updateDashboard("Intake Motor");

        switch (chooser.getSelected()) {
            case kFullIntake:
                fullIntake();
                break;
            case kReverse:
                reverse();
                break;
            case kFullStop:
            default:
                stopAll();
                break;
        }
    }

}
