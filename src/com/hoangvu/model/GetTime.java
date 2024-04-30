package com.hoangvu.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GetTime {
    public static String getCurrentTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
        String formattedTime = currentTime.format(formatter);
        return formattedTime;
    }

    public static void main(String[] args) {
        String currentTime = getCurrentTime();
        System.out.println("Current Time: " + currentTime);
    }
}