package com.example.streetmaster;

public class Student {
    private String stdFname;
    private String stdLname;
    private String stdId;
    private String stdPhone;
    private String stdAdress;
    private String stdLicenseRank;
    private String stdMedicalConfirmationDate;
    private String stdStartDate;
    private String stdTestDate;
    private String stdEyesDate;
    private String stdGlasses;

    public Student(String stdFname, String stdLname, String stdId, String stdPhone, String stdAdress, String stdLicenseRank, String stdMedicalConfirmationDate, String stdStartDate, String stdTestDate, String stdEyesDate, String stdGlasses) {
        this.stdFname = stdFname;
        this.stdLname = stdLname;
        this.stdId = stdId;
        this.stdPhone = stdPhone;
        this.stdAdress = stdAdress;
        this.stdLicenseRank = stdLicenseRank;
        this.stdMedicalConfirmationDate = stdMedicalConfirmationDate;
        this.stdStartDate = stdStartDate;
        this.stdTestDate = stdTestDate;
        this.stdEyesDate = stdEyesDate;
        this.stdGlasses = stdGlasses;
    }
    public Student(){

    }

    public String getStdFname() {
        return stdFname;
    }

    public void setStdFname(String stdFname) {
        this.stdFname = stdFname;
    }

    public String getStdLname() {
        return stdLname;
    }

    public void setStdLname(String stdLname) {
        this.stdLname = stdLname;
    }

    public String getStdId() {
        return stdId;
    }

    public void setStdId(String stdId) {
        this.stdId = stdId;
    }

    public String getStdPhone() {
        return stdPhone;
    }

    public void setStdPhone(String stdPhone) {
        this.stdPhone = stdPhone;
    }

    public String getStdAdress() {
        return stdAdress;
    }

    public void setStdAdress(String stdAdress) {
        this.stdAdress = stdAdress;
    }

    public String getStdLicenseRank() {
        return stdLicenseRank;
    }

    public void setStdLicenseRank(String stdLicenseRank) {
        this.stdLicenseRank = stdLicenseRank;
    }

    public String getStdMedicalConfirmationDate() {
        return stdMedicalConfirmationDate;
    }

    public void setStdMedicalConfirmationDate(String stdMedicalConfirmationDate) {
        this.stdMedicalConfirmationDate = stdMedicalConfirmationDate;
    }

    public String getStdStartDate() {
        return stdStartDate;
    }

    public void setStdStartDate(String stdStartDate) {
        this.stdStartDate = stdStartDate;
    }

    public String getStdTestDate() {
        return stdTestDate;
    }

    public void setStdTestDate(String stdTestDate) {
        this.stdTestDate = stdTestDate;
    }

    public String getStdEyesDate() {
        return stdEyesDate;
    }

    public void setStdEyesDate(String stdEyesDate) {
        this.stdEyesDate = stdEyesDate;
    }

    public String getStdGlasses() {
        return stdGlasses;
    }

    public void setStdGlasses(String stdGlasses) {
        this.stdGlasses = stdGlasses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stdFname='" + stdFname + '\'' +
                ", stdLname='" + stdLname + '\'' +
                ", stdId='" + stdId + '\'' +
                ", stdPhone='" + stdPhone + '\'' +
                ", stdAdress='" + stdAdress + '\'' +
                ", stdLevel='" + stdLicenseRank + '\'' +
                ", stdDoctor='" + stdMedicalConfirmationDate + '\'' +
                ", stdStart='" + stdStartDate + '\'' +
                ", stdTestDate='" + stdTestDate + '\'' +
                ", stdEyesDate='" + stdEyesDate + '\'' +
                ", stdGlasses='" + stdGlasses + '\'' +
                '}';
    }
}

