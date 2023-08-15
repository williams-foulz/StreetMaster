package com.example.streetmaster;

import java.util.Date;

public class CarStatus {
    private String model;
    private String number;
    private String year;
    private String km;
    private String exLicense;
    private String exInsurance;
    private String transmission;
    private String school;

    public CarStatus(String model, String number, String year, String km, String exLicense, String exInsurance, String transmission, String school) {
        this.model = model;
        this.number = number;
        this.year = year;
        this.km = km;
        this.exLicense = exLicense;
        this.exInsurance = exInsurance;
        this.transmission = transmission;
        this.school = school;
    }

    public CarStatus() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getExLicense() {
        return exLicense;
    }

    public void setExLicense(String exLicense) {
        this.exLicense = exLicense;
    }

    public String getExInsurance() {
        return exInsurance;
    }

    public void setExInsurance(String exInsurance) {
        this.exInsurance = exInsurance;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "CarStatus{" +
                "model='" + model + '\'' +
                ", number='" + number + '\'' +
                ", year='" + year + '\'' +
                ", km='" + km + '\'' +
                ", exLicense='" + exLicense + '\'' +
                ", exInsurance='" + exInsurance + '\'' +
                ", transmission='" + transmission + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
