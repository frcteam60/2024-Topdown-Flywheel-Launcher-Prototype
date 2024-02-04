package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Launcher {
    private CimMotor topLeftMotor = new CimMotor(11, true);
    private CimMotor bottomLeftMotor = new CimMotor(12, true);
    private CimMotor topRightMotor = new CimMotor(13);
    private CimMotor bottomRightMotor = new CimMotor(14);

    private final SendableChooser<String> chooser = new SendableChooser<>();

    private static final String kFullStop = "Full Stop";
    private static final String kRotate = "Rotate";
    private static final String kFullLaunch = "Full Launch";
    private static final String kRollingLaunch = "Rolling Launch";
    private static final String kIntake = "Intake";

    private static final double rotationSpeed = 0.9;

    public Launcher() {
    }

    public void rotateNote() {
        // topLeftMotor.fullReverse();
        // bottomLeftMotor.fullReverse();
        // topRightMotor.fullForward();
        // bottomRightMotor.fullForward();
        topLeftMotor.runAtSpeed(-1*rotationSpeed);
        bottomLeftMotor.runAtSpeed(-1*rotationSpeed);
        topRightMotor.runAtSpeed(rotationSpeed);
        bottomRightMotor.runAtSpeed(rotationSpeed);
    }

    public void fullLaunch() {
        topLeftMotor.fullForward();
        bottomLeftMotor.fullForward();
        topRightMotor.fullForward();
        bottomRightMotor.fullForward();
    }

    public void rollingLaunch() {
        topLeftMotor.stop();
        bottomLeftMotor.stop();
        topRightMotor.fullForward();
        bottomRightMotor.fullForward();
    }

    public void stopAll() {
        topLeftMotor.stop();
        bottomLeftMotor.stop();
        topRightMotor.stop();
        bottomRightMotor.stop();
    }

    public void intake() {
        // topLeftMotor.fullReverse();
        topLeftMotor.runAtSpeed(-1*rotationSpeed);
        bottomLeftMotor.stop();
        topRightMotor.stop();
        // bottomRightMotor.fullForward();
        bottomRightMotor.runAtSpeed(rotationSpeed);
    }

    void addDashboardDisplays() {
        chooser.setDefaultOption(kFullStop, kFullStop);
        chooser.addOption(kRotate, kRotate);
        chooser.addOption(kFullLaunch, kFullLaunch);
        chooser.addOption(kRollingLaunch, kRollingLaunch);
        chooser.addOption(kIntake, kIntake);
        SmartDashboard.putData("Launcher Options", chooser);
    }

    public void periodicUpdate() {
        topLeftMotor.updateDashboard("topLeftMotor");
        bottomLeftMotor.updateDashboard("bottomLeftMotor");
        topRightMotor.updateDashboard("topRightMotor");
        bottomRightMotor.updateDashboard("bottomRightMotor");

        switch (chooser.getSelected()) {
            case kRotate:
                rotateNote();
                break;
            case kFullLaunch:
                fullLaunch();
                break;
            case kRollingLaunch:
                rollingLaunch();
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
