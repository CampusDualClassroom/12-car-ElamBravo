package com.campusdual.classroom;

public class Exercise {

    public static void main(String[] args) {
        Car myCar = new Car();
        System.out.println(myCar.isTachometerEqualToZero());
        myCar.start();
        myCar.stop();
        myCar.start();

        for (int i = 0; i < 4; i++) {
            myCar.accelerate();
        }

        for (int i = 0; i < 6; i++) {
            myCar.accelerate();
        }

        for (int i = 0; i < 10; i++) {
            myCar.accelerate();

            for (int j = 0; j < 10; j++) { // ← variable cambiada de i a j
                myCar.brake();
            }

            myCar.turnAngleOfWheels(20);
            myCar.turnAngleOfWheels(60);

            myCar.stop();
            myCar.start();
            myCar.accelerate();
            myCar.setReverse(true);
        }
    }
}

