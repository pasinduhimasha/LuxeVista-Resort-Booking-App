package com.example.luxevistaresort;

public class Reservation {
    public String date;
    public int hour;
    public int minute;

    public Reservation() {
        // Default constructor required for Firebase
    }

    public Reservation(String date, int hour, int minute) {
        this.date = date;
        this.hour = hour;
        this.minute = minute;
    }
}
