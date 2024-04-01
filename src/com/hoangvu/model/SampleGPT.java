/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hoangvu.model;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class SampleGPT {

    public static void main(String[] args) {
        String apiUrl = "https://api-inference.huggingface.co/models/mistralai/Mistral-7B-Instruct-v0.2";
        String authToken = "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";

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("prompt: ");
            String txt = scanner.nextLine();
            try {
                String response = query(apiUrl, authToken, txt);
                String generatedText = extractGeneratedText(response);
                System.out.println(generatedText);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String query(String apiUrl, String authToken, String text) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "Bearer " + authToken);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);

        String payload = "{\"inputs\": \"" + text + "\", \"parameters\": {\"max_new_tokens\": 500}}";
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = payload.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int statusCode = conn.getResponseCode();
        if (statusCode != 200) {
            throw new IOException("Failed to fetch data from API: " + statusCode);
        }

        StringBuilder response = new StringBuilder();
        try (Scanner scanner = new Scanner(conn.getInputStream(), "utf-8")) {
            while (scanner.hasNextLine()) {
                response.append(scanner.nextLine());
            }
        }

        return response.toString();
    }

    public static String extractGeneratedText(String response) {
        int startIndex = response.indexOf("\"generated_text\":") + "\"generated_text\":".length();
        int endIndex = response.indexOf("}", startIndex);
        String generatedText = response.substring(startIndex + 1, endIndex - 1);
        generatedText = generatedText.replace("\\n", "\n");
        return generatedText;
    }
}