package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class NeoMotor {

    private CANSparkMax motor;

    public NeoMotor(int id, boolean isInverted) {
        motor = new CANSparkMax(id, MotorType.kBrushless);
        motor.setInverted(isInverted);
    }

    public NeoMotor(int id) {
        motor = new CANSparkMax(id, MotorType.kBrushless);
        motor.setInverted(false);
    }

    public void runAtSpeed(double speed) {
        if (speed > 1.0) {
            speed = 1.0;
        } else if (speed < -1.0) {
            speed = -1.0;
        }
        motor.set(speed);
    }

    public void fullForward() {
        motor.set(1.0);
    }

    public void fullReverse() {
        motor.set(-1.0);
    }

    public void stop() {
        motor.set(0.0);
    }

    public void updateDashboard(String motorDescription) {
        SmartDashboard.putNumber(motorDescription.concat(" set speed"), motor.get());
    }
}
