package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Launcher {
    // Controls the top roller
    private CimMotor leftMotor = new CimMotor(15, false);
    // Controls the bottom roller
    private CimMotor rightMotor = new CimMotor(16);

    private final SendableChooser<String> chooser = new SendableChooser<>();

    private static final String kFullStop = "Full Stop";
    private static final String kFullLaunch = "Full Launch";
    private static final String kIntake = "Intake";

    public Launcher() {
    }

    public void fullLaunch() {
        leftMotor.fullForward();
        rightMotor.fullForward();
    }

    public void stopAll() {
        leftMotor.stop();
        rightMotor.stop();
    }

    public void intake() {
        leftMotor.runAtSpeed(-0.2);
        rightMotor.runAtSpeed(-0.2);
    }

    void addDashboardDisplays() {
        chooser.setDefaultOption(kFullStop, kFullStop);
        chooser.addOption(kFullLaunch, kFullLaunch);
        chooser.addOption(kIntake, kIntake);
        SmartDashboard.putData("Launcher Options", chooser);
    }

    public void periodicUpdate() {
        leftMotor.updateDashboard("Left Launcher Motor");
        rightMotor.updateDashboard("Right Launcher Motor");

        switch (chooser.getSelected()) {
            case kFullLaunch:
                fullLaunch();
                break;
            case kIntake:
                intake();
                break;
            case kFullStop:
            default:
                stopAll();
                break;
        }
    }
}
