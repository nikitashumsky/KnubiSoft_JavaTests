package com.knubisoft.base.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTasksImpl implements PatternTasks {

    @Override
    public boolean haveSetOfCharacters(String text) {
        if (text == null || text.contains("")) {
            throw new IllegalArgumentException();
        }
        Pattern pat = Pattern.compile("[a-zA-Z0-9]+");
        Matcher mat = pat.matcher(text);
        return mat.matches();

    }

    @Override
    public String matchByCharacters(String text) {
        if (text == null) {
            throw new IllegalArgumentException();
        }
        Pattern pat = Pattern.compile("pq*");
        Matcher mat = pat.matcher(text);
        return mat.matches() ? "Found a match!" : "Not matched!";
    }

    @Override
    public String matchStartAndEnd(String text) {
        if (text == null) {
            throw new IllegalArgumentException();
        }
        Pattern pat = Pattern.compile("\\Bg\\B");
        Matcher mat = pat.matcher(text);
        return mat.find() ? "Found a match!" : "Not matched!";
    }

    @Override
    public String matchIpAddress(String text) {
        if (text == null || text.isEmpty() || text.contains(" ")) {
            throw new IllegalArgumentException();
        }
        return text.replaceAll("\\b0+", "");
    }

    @Override
    public String matchVowels(String text) {
        if (text == null || text.isEmpty() || text.contains(" ")) {
            throw new IllegalArgumentException();
        }
        return text.replaceAll("[aeiouAEIOU]", "");
    }

    @Override
    public boolean validatePIN(String text) {
        if (text == null || text.isEmpty() || text.contains(" ")) {
            throw new IllegalArgumentException();
        }
        Pattern pat = Pattern.compile("\\d{4}|\\d{6}|\\d{8}");
        Matcher mat = pat.matcher(text);
        return mat.matches();
    }

    @Override
    public String divideDigit(int digit) {
        return String.valueOf(digit).replaceAll("000\\b", "#000");
    }

    @Override
    public String removeAllNonAlphanumericCharacters(String text) {
        if (text == null) {
            throw new RuntimeException();
        }
        return text.replaceAll("\\W", "");
    }

    @Override
    public boolean validatePhoneNumber(String text) {
        if (text == null || text.isEmpty() || text == " ") {
            throw new IllegalArgumentException();
        }
        Pattern pat = Pattern.compile("[(]\\d{3}[)]\\d{7}|" +
                                            "\\d{10}|" +
                                            "\\d{3}-\\d{3}-\\d{4}|" +
                                            "[(]\\d{3}[)]\\d{3}-\\d{4}");
        Matcher mat = pat.matcher(text);
        return mat.matches();
    }

    @Override
    public String getLastVowelsByConstraint(String text, int n) {
        if (text == null || text.isEmpty() || text == " " || n < 1) {
            throw new RuntimeException();
        }
        Pattern pat = Pattern.compile("[aeiou]");
        Matcher mat = pat.matcher(text);
        String temp = "";
        String result = "";
        while(mat.find()){
            temp += mat.group();
        }
        for (int i = temp.length()-n; i < temp.length(); i++){
            result += temp.charAt(i);
        }
        return result;
    }

    @Override
    public boolean isMathematicalExpression(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException();
        }
        Pattern pat = Pattern.compile("\\d+|\\d+\\s[+=*/-]\\s\\d+");
        Matcher mat = pat.matcher(text);
        return mat.matches();
    }

    @Override
    public String insertDash(String text) {
        if (text == null) {
            throw new RuntimeException();
        }
        return text.replaceAll("([A-Z])", "$1-");
    }
}
