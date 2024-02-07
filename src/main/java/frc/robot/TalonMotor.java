package frc.robot;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TalonMotor {

    private TalonSRX motor;

    public TalonMotor(int id, boolean isInverted) {
        motor = new TalonSRX(id);

        motor.setInverted(isInverted);
    }

    public TalonMotor(int id) {
        motor = new TalonSRX(id);
        motor.setInverted(false);
    }

    public void runAtSpeed(double speed) {
        if (speed > 1.0) {
            speed = 1.0;
        } else if (speed < -1.0) {
            speed = -1.0;
        }
        motor.set(TalonSRXControlMode.PercentOutput, speed);
    }

    public void fullForward() {
        motor.set(TalonSRXControlMode.PercentOutput, 1.0);
    }

    public void fullReverse() {
        motor.set(TalonSRXControlMode.PercentOutput, -1.0);
    }

    public void stop() {
        motor.set(TalonSRXControlMode.PercentOutput, 0.0);
    }

    public void updateDashboard(String motorDescription) {
        SmartDashboard.putNumber(motorDescription.concat(" set speed"), motor.getMotorOutputPercent());
    }
}
