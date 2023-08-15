package com.example.streetmaster;

public class SMuser {
    String Id;
    String UserFirstName;
    String UserLastName;
    String UserMail;
    String UserPhone;
    String UserPassword;

    public SMuser(String id, String userFirstName, String userLastName, String userMail, String userPhone, String userPassword) {
        Id = id;
        UserFirstName = userFirstName;
        UserLastName = userLastName;
        UserMail = userMail;
        UserPhone = userPhone;
        UserPassword = userPassword;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUserFirstName() {
        return UserFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        UserFirstName = userFirstName;
    }

    public String getUserLastName() {
        return UserLastName;
    }

    public void setUserLastName(String userLastName) {
        UserLastName = userLastName;
    }

    public String getUserMail() {
        return UserMail;
    }

    public void setUserMail(String userMail) {
        UserMail = userMail;
    }

    public String getUserPhone() {
        return UserPhone;
    }

    public void setUserPhone(String userPhone) {
        UserPhone = userPhone;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    @Override
    public String toString() {
        return "SMuser{" +
                "Id='" + Id + '\'' +
                ", UserFirstName='" + UserFirstName + '\'' +
                ", UserLastName='" + UserLastName + '\'' +
                ", UserMail='" + UserMail + '\'' +
                ", UserPhone='" + UserPhone + '\'' +
                ", UserPassword='" + UserPassword + '\'' +
                '}';
    }
}
