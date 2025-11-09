package com.campusdual.classroom;

public class Car {
    public String brand;
    public String model;
    public static final int MAX_SPEED = 120;
    public String fuel;
    public int speedometer = 0;
    public int tachometer = 0;
    public String gear = "N";
    public boolean reverse = false;
    public int wheelsAngle = 0;


    public Car(String brand, String model, String fuel) {
        this.brand = brand;
        this.model = model;
        this.fuel = fuel;
    }

    public Car() {
        this("Citroën", "Xsara", "Diesel");
    }


    public void start() {
        if (isTachometerEqualToZero() && this.gear.equals("N")) {
            this.tachometer = 1000;
            System.out.println("Vehículo encendido");
        } else {
            System.out.println("Vehículo ya está encendido");
        }
    }


    public void stop() {
        if (this.speedometer == 0 && this.gear.equals("N")) {
            this.tachometer = 0;
            System.out.println("Vehículo apagado");
        } else {
            System.out.println("No se puede apagar el vehículo. Primero tiene que estar detenido");
        }
    }


    public void accelerate() {
        if (this.tachometer >= 1000) {
            this.gear = "D";
            if (this.speedometer < MAX_SPEED) {
                this.speedometer += 5;
                System.out.println("Velocidad del vehículo: " + this.speedometer + " Km/h");
            } else {
                System.out.println("Has alcanzado la velocidad máxima: " + MAX_SPEED + " Km/h.");
            }
        } else {
            System.out.println("Debe encender su vehículo primero");
        }
    }


    public void brake() {
        if (this.speedometer > 0) {
            this.speedometer -= 5;
            System.out.println("Frenando. Velocidad actual: " + this.speedometer + " Km/h");
        } else {
            System.out.println("Vehículo detenido");
        }
    }


    public void turnAngleOfWheels(int angle) {
        int totalAngle = this.wheelsAngle + angle;
        if (totalAngle >= -45 && totalAngle <= 45) {
            this.wheelsAngle = totalAngle;
        } else {
            System.out.println("No puedes girar más las ruedas");
            this.wheelsAngle = (angle > 0) ? 45 : -45;
        }
        System.out.println("El ángulo de las ruedas es: " + this.wheelsAngle);
    }


    public String showSteeringWheelDetail() {
        return "Ángulo actual del volante: " + this.wheelsAngle;
    }

    public boolean isReverse() {
        return this.reverse;
    }


    public void setReverse(boolean reverse) {
        if (this.speedometer == 0 && isTachometerGreaterThanZero()) {
            this.gear = "R";
            this.reverse = reverse;
            System.out.println("Marcha atrás activada");
        } else {
            System.out.println("Primero detenga el vehículo");
            this.reverse = false;
        }
    }


    public void showDetails() {
        System.out.println("Marca: " + brand);
        System.out.println("Modelo: " + model);
        System.out.println("Combustible: " + fuel);
        System.out.println("Velocidad: " + speedometer);
        System.out.println("Tacómetro: " + tachometer);
        System.out.println("Marcha: " + gear);
        System.out.println("Marcha atrás: " + reverse);
        System.out.println("Ángulo de ruedas: " + wheelsAngle);
    }


    public boolean isTachometerEqualToZero() {
        return this.tachometer == 0;
    }


    public boolean isTachometerGreaterThanZero() {
        return this.tachometer > 0;
    }
}

