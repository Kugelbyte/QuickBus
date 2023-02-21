package com.example.lnctbushelp;

public class Route {

    String busNumber,driverName,contact;

    public Route(String busNumber, String driverName, String contact) {
        this.busNumber = busNumber;
        this.driverName = driverName;
        this.contact = contact;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getContact() {
        return contact;
    }
}
