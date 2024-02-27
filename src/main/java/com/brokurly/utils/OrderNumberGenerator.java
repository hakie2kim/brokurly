package com.brokurly.utils;

import java.security.SecureRandom;
import java.time.LocalDate;

public class OrderNumberGenerator {
    private static final SecureRandom random = new SecureRandom();
    private static final int RANDOM_STRING_LENGTH = 6;
    private static final String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String generateOrderNumber() {
        StringBuilder sb = new StringBuilder();
        sb.append(LocalDate.now().toString().replaceAll("-", ""));
        for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}