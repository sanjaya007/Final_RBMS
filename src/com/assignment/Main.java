package com.assignment;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static final String DEV_TXT = "Sakar Regmi";
    public static final String STD_ID = "12142647";
    public static final float GUITAR_PRICE = 199.00F;
    public static final float LESSON_PRICE = 29.95F;
    public static final int MAX_Count = getHighestNumber(STD_ID);

    public static void main(String[] args) {
        byte counter = 1;

        Scanner scanner = new Scanner(System.in);

        String[] bookingArr = {"", "", "", "", ""};
        String[] booking1 = {"", "", "", "", ""};
        String[] booking2 = {"", "", "", "", ""};
        String[] booking3 = {"", "", "", "", ""};
        String[] booking4 = {"", "", "", "", ""};
        String[] booking5 = {"", "", "", "", ""};
        String[] booking6 = {"", "", "", "", ""};
        String[] booking7 = {"", "", "", "", ""};
        int[] lessonArr = {0, 0, 0, 0, 0, 0, 0};


//      heading
        System.out.println("");
        System.out.println("Welcome to the Rocky Blues Management System");
        System.out.println("");

        while (counter <= MAX_Count){
            while (true){
                System.out.print("Please enter booking name " + counter + " ==> ");
                String bookingName = scanner.nextLine().trim();
                if (isBlank(bookingName)) {
                    System.out.println("ERROR: Booking name cannot be blank.");
                }else if (isNumeric(bookingName)){
                    System.out.println("Error: Only alphabets are allowed.");
                }else {
                    bookingArr[0] = bookingName;
                    break;
                }
            }

            while (true) {
                System.out.print("Enter the number of lessons for " + bookingArr[0] + " ==> ");
                String lessonCount = scanner.nextLine().trim();

                if (isBlank(lessonCount)) {
                    System.out.println("ERROR:  You forget to add number of lessons.");
                }else if (!isNumeric(lessonCount)){
                    System.out.println("Error: Only valid numeric positive digits are allowed.");
                }else if(Integer.parseInt(lessonCount) < 1) {
                    System.out.println("Error: Number of lessons must be greater than or equal to 1.");
                }else {
                    String totalLessonPrice = "";
                    bookingArr[1] = lessonCount;
                    if (Integer.parseInt(lessonCount) > 10){
                        float result = twentyPercentDiscount(Float.parseFloat(lessonCount));
                        String finalResult = String.format("%.2f", result);
                        totalLessonPrice = finalResult;
                    } else if(Integer.parseInt(lessonCount) > 5 && Integer.parseInt(lessonCount) <= 10){
                        float result = tenPercentDiscount(Float.parseFloat(lessonCount));
                        String finalResult = String.format("%.2f", result);
                        totalLessonPrice = finalResult;
                    }else{
                        float result = noDiscount(Float.parseFloat(lessonCount));
                        String finalResult = String.format("%.2f", result);
                        totalLessonPrice = finalResult;
                    }
                    bookingArr[2] = totalLessonPrice;
                    break;
                }
            }

            while (true) {
                System.out.print(bookingArr[0] + " do you want to purchase a guitar for $199.00 (y/n) ==> ");
                String wantGuitar = scanner.nextLine().trim().toLowerCase();

                if (!isBool(wantGuitar)){
                    System.out.println("ERROR: Enter 'y' or 'n' or 'yes' or 'no'.");
                }else{
                    String guitarPrice = "";
                    if (wantGuitar.equals("y") || wantGuitar.equals("yes")){
                        String finalResult = String.format("%.2f", GUITAR_PRICE);
                        guitarPrice = finalResult;
                    }else{
                        guitarPrice = "0";
                    }
                    bookingArr[3] = guitarPrice;
                    break;
                }
            }

            //      total price
            float totalPrice = Float.parseFloat(bookingArr[2]) + Float.parseFloat(bookingArr[3]);
            String finalTotalPrice = String.format("%.2f", totalPrice);
            bookingArr[4] = finalTotalPrice;
            if (bookingArr[3].equals("0")){
                System.out.println("The charge for " + bookingArr[0] + " for " + bookingArr[1] + " lessons is $" + bookingArr[4]);
            }else{
                System.out.println("The charge for " + bookingArr[0] + " for " + bookingArr[1] + " lessons and a guitar purchase is $" + bookingArr[4]);
            }

//          cloning array
            switch(counter){
                case 1:
                    booking1 = bookingArr.clone();
                    break;
                case 2:
                    booking2 = bookingArr.clone();
                    break;
                case 3:
                    booking3 = bookingArr.clone();
                    break;
                case 4:
                    booking4 = bookingArr.clone();
                    break;
                case 5:
                    booking5 = bookingArr.clone();
                    break;
                case 6:
                    booking6 = bookingArr.clone();
                    break;
                case 7:
                    booking7 = bookingArr.clone();
                    break;
            }

//          empty array
            for (int i = 0; i < bookingArr.length; i++) {
                bookingArr[i] = "";
            }

            System.out.println("");
            counter++;
        }

//      statistical info
        System.out.println("");

        System.out.println("Statistical information for Rocky Blues");
        System.out.println("");

//      final calculation
        lessonArr[0] = Integer.parseInt(booking1[1]);
        lessonArr[1] = Integer.parseInt(booking2[1]);
        lessonArr[2] = Integer.parseInt(booking3[1]);
        lessonArr[3] = Integer.parseInt(booking4[1]);
        lessonArr[4] = Integer.parseInt(booking5[1]);
        lessonArr[5] = Integer.parseInt(booking6[1]);
        lessonArr[6] = Integer.parseInt(booking7[1]);

        Arrays.sort(lessonArr);
        int maxLesson = lessonArr[MAX_Count - 1];
        int minLesson = lessonArr[0];

        if (lessonArr[0] == lessonArr[1] && lessonArr[0] == lessonArr[2] && lessonArr[0] == lessonArr[3] && lessonArr[0] == lessonArr[4] && lessonArr[0] == lessonArr[5] && lessonArr[0] == lessonArr[6] && lessonArr[0] == lessonArr[7]){
            System.out.println("All have same number of " + lessonArr[0] + " lessons");
        }else{
            String maxLessonStr = String.valueOf(maxLesson);
            String minLessonStr = String.valueOf(minLesson);
            String maxLessonHolder = "";
            String minLessonHolder = "";
            boolean isPluralMaxHolders = false;
            boolean isPluralMinHolders = false;

//          checking max lesson holder
            if (Arrays.stream(booking1).anyMatch(maxLessonStr::equals)){
                if (maxLessonHolder.equals("")){
                    maxLessonHolder = booking1[0];
                }else{
                    maxLessonHolder += ", " + booking1[0];
                    isPluralMaxHolders = true;
                }
            }

            if (Arrays.stream(booking2).anyMatch(maxLessonStr::equals)){
                if (maxLessonHolder.equals("")){
                    maxLessonHolder = booking2[0];
                }else{
                    maxLessonHolder += ", " + booking2[0];
                    isPluralMaxHolders = true;
                }
            }

            if (Arrays.stream(booking3).anyMatch(maxLessonStr::equals)){
                if (maxLessonHolder.equals("")){
                    maxLessonHolder = booking3[0];
                }else{
                    maxLessonHolder += ", " + booking3[0];
                    isPluralMaxHolders = true;
                }
            }

            if (Arrays.stream(booking4).anyMatch(maxLessonStr::equals)){
                if (maxLessonHolder.equals("")){
                    maxLessonHolder = booking4[0];
                }else{
                    maxLessonHolder += ", " + booking4[0];
                    isPluralMaxHolders = true;
                }
            }

            if (Arrays.stream(booking5).anyMatch(maxLessonStr::equals)){
                if (maxLessonHolder.equals("")){
                    maxLessonHolder = booking5[0];
                }else{
                    maxLessonHolder += ", " + booking5[0];
                    isPluralMaxHolders = true;
                }
            }

            if (Arrays.stream(booking6).anyMatch(maxLessonStr::equals)){
                if (maxLessonHolder.equals("")){
                    maxLessonHolder = booking6[0];
                }else{
                    maxLessonHolder += ", " + booking6[0];
                    isPluralMaxHolders = true;
                }
            }

            if (Arrays.stream(booking7).anyMatch(maxLessonStr::equals)){
                if (maxLessonHolder.equals("")){
                    maxLessonHolder = booking7[0];
                }else{
                    maxLessonHolder += ", " + booking7[0];
                    isPluralMaxHolders = true;
                }
            }

//          checking min lesson holder
            if (Arrays.stream(booking1).anyMatch(minLessonStr::equals)){
                if (minLessonHolder.equals("")){
                    minLessonHolder = booking1[0];
                }else{
                    minLessonHolder += ", " + booking1[0];
                    isPluralMinHolders = true;
                }
            }

            if (Arrays.stream(booking2).anyMatch(minLessonStr::equals)){
                if (minLessonHolder.equals("")){
                    minLessonHolder = booking2[0];
                }else{
                    minLessonHolder += ", " + booking2[0];
                    isPluralMinHolders = true;
                }
            }

            if (Arrays.stream(booking3).anyMatch(minLessonStr::equals)){
                if (minLessonHolder.equals("")){
                    minLessonHolder = booking3[0];
                }else{
                    minLessonHolder += ", " + booking3[0];
                    isPluralMinHolders = true;
                }
            }

            if (Arrays.stream(booking4).anyMatch(minLessonStr::equals)){
                if (minLessonHolder.equals("")){
                    minLessonHolder = booking4[0];
                }else{
                    minLessonHolder += ", " + booking4[0];
                    isPluralMinHolders = true;
                }
            }

            if (Arrays.stream(booking5).anyMatch(minLessonStr::equals)){
                if (minLessonHolder.equals("")){
                    minLessonHolder = booking5[0];
                }else{
                    minLessonHolder += ", " + booking5[0];
                    isPluralMinHolders = true;
                }
            }

            if (Arrays.stream(booking6).anyMatch(minLessonStr::equals)){
                if (minLessonHolder.equals("")){
                    minLessonHolder = booking6[0];
                }else{
                    minLessonHolder += ", " + booking6[0];
                    isPluralMinHolders = true;
                }
            }

            if (Arrays.stream(booking7).anyMatch(minLessonStr::equals)){
                if (minLessonHolder.equals("")){
                    minLessonHolder = booking7[0];
                }else{
                    minLessonHolder += ", " + booking7[0];
                    isPluralMinHolders = true;
                }
            }

            System.out.println(minLessonHolder + grammarInit(isPluralMinHolders) + " the minimum number of " + minLessonStr + " lessons.");
            System.out.println(maxLessonHolder + grammarInit(isPluralMaxHolders) + " the maximum number of " + maxLessonStr + " lessons.");
        }

        float totalCharges = Float.parseFloat(booking1[4]) + Float.parseFloat(booking2[4]) + Float.parseFloat(booking3[4]) + Float.parseFloat(booking4[4]) + Float.parseFloat(booking5[4]) + Float.parseFloat(booking6[4]) + Float.parseFloat(booking7[4]);
        String totalChargesFormatted = String.format("%.2f", totalCharges);

        float averageValue = calculateAverage(Float.parseFloat(booking1[1]), Float.parseFloat(booking2[1]), Float.parseFloat(booking3[1]), Float.parseFloat(booking4[1]), Float.parseFloat(booking5[1]), Float.parseFloat(booking6[1]), Float.parseFloat(booking7[1]));
        String averageFormatted = String.format("%.2f", averageValue);

        System.out.println("The average number of lessons per booking is: " + averageFormatted + " lessons.");
        System.out.println("The total charges collected is $" + totalChargesFormatted);

//      thank you text
        System.out.println("");
        System.out.println("");
        System.out.println("Thank you for using the Rocky Blues Management System.");
        System.out.println("Program written by " + DEV_TXT + "(" + STD_ID + ")" );
        System.out.println("");
        System.out.println("");
    }

    public static boolean isBlank(String value){
        if (value.equals("")){
            return true;
        }
        return false;
    }

    public static boolean isAlphabet(String value) {
        String strRegex = "[a-zA-Z]+";
        if(value.matches(strRegex)){
            return true;
        }
        return false;
    }

    public static boolean isNumeric(String value) {
        String intRegex = "[0-9]+";
        if(value.matches(intRegex)){
            return true;
        }
        return false;
    }

    public static float twentyPercentDiscount(Float value){
        float totalLessonPrice = value * LESSON_PRICE;
        float discountValue = (20F / 100F) * totalLessonPrice;
        float result = totalLessonPrice - discountValue;
        return result;
    }

    public static float tenPercentDiscount(Float value){
        float totalLessonPrice = value * LESSON_PRICE;
        float discountValue = (10F / 100F) * totalLessonPrice;
        float result = totalLessonPrice - discountValue;
        return result;
    }

    public static float noDiscount(Float value){
        float totalLessonPrice = value * LESSON_PRICE;
        float discountValue = 0F;
        float result = totalLessonPrice - discountValue;
        return result;
    }

    public static boolean isBool(String value){
        if (value.equals("y") || value.equals("n") || value.equals("yes") || value.equals("no")){
            return true;
        }
        return false;
    }

    public static float calculateAverage(Float val1, Float val2, Float val3, Float val4, Float val5, Float val6, Float val7 ){
        float result = (val1 + val2 + val3 + val4 + val5 + val6 + val7) / MAX_Count;
        return  result;
    }

    public static String grammarInit(boolean value){
        if (value){
            return " have";
        }else{
            return " has";
        }
    }

    public static Integer getHighestNumber(String value){
        String[] idArr = value.split("");
        Arrays.sort(idArr);
        String highestNumber = idArr[idArr.length - 1];
        return Integer.parseInt(highestNumber);
    }
}
