/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advantal.util;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author shivam
 */
public class RandomStringGenerator {

    private static Random random = new Random((new Date()).getTime());

    public static String getRandomString(int length) {

        char[] values = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3',
            '4', '5', '6', '7', '8', '9'};

        String out = "";

        for (int i = 0; i < length; i++) {
            int idx = random.nextInt(values.length);
            out += values[idx];
        }
        return out;
    }

     public static String getRandomNumberString(int length) {

        char[] values = {'0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9'};
        String out = "";
        for (int i = 0; i < length; i++) {
            int idx = random.nextInt(values.length);
            out += values[idx];
        }
        return out;
    }

    public static String getRandomStringComplex(int length) {

        char[] values = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z', '0',
            '!', '@', '#', '$', '%', '&', '*',
            '(', ')', '-', '_', '+', '=',
            '1', '2', '3',
            '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y',};

        String out = "";

        for (int i = 0; i < length; i++) {
            int idx = random.nextInt(values.length);
            out += values[idx];
        }

        return out;
    }
    public static void main(String[] args) {
        //   System.out.println("ss="+getRandomNumberString(4));
    }
}
