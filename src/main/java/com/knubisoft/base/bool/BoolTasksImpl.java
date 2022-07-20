package com.knubisoft.base.bool;

import java.util.Arrays;

public class BoolTasksImpl implements BoolTasks {

    @Override
    public Boolean isTrueAutobox(boolean value) {
        Boolean val = value;
        if (value == true) {
            return val;
        } else
            return false;
    }

    @Override
    public Boolean isFalseAutobox(boolean value) {
        Boolean val = value;
        if (value == false) {
            return val;
        } else
            return true;
    }

    @Override
    public boolean isTrueUnbox(Boolean value) {
        boolean val = value;
        if (val == true) {
            return val;
        } else
            return false;
    }

    @Override
    public Boolean isFalseUnbox(boolean value) {
        Boolean val = value;
        if (value == false) {
            return val;
        } else
            return true;
    }

    @Override
    public boolean andFunction(int digit, String string) {
        int num = 0;
        try {
            num = Integer.parseInt(string);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            return false;
        }
        if (num == digit) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean orFunction(int digit, String string) {

        if (string == "") {
            return false;
        }

        int num = 0;
        try {
            num = Integer.parseInt(string);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            return false;
        }
        if (num == digit || num == 0) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean andComplexFunction(int generatedFirstDigit, double generatedSecondDigit, int range) {
        long convertToLong = Math.round(generatedSecondDigit);
        int secondDigit = (int) convertToLong;
        if (secondDigit == generatedFirstDigit) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean orComplexFunction(int generatedFirstDigit, double generatedSecondDigit, double generatedThirdDigit, int range) {
        long convertSecondDigit = Math.round(generatedSecondDigit);
        long convertThirdDigit = Math.round(generatedThirdDigit);
        int secondDigit = (int) convertSecondDigit;
        int thirdDigit = (int) convertThirdDigit;
        if (secondDigit == generatedFirstDigit || thirdDigit == generatedFirstDigit) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean isSameSizeArray(Object[] firstArray, Object... secondArray) {
        if (firstArray == null && secondArray == null) {
            return false;
        }
        String first = Arrays.toString(firstArray);
        String second = Arrays.toString(secondArray);
        if (first.length() == second.length()) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean isSameCharactersCount(String username, String name, int maxLength) {
        try{
        if (username.isEmpty() || name.isEmpty() || maxLength == 0) {
            return false;
        }
        }catch (NullPointerException e){
            return false;
        }
        if (username.length() < maxLength && name.length() < maxLength) {
            return true;
        } else
            return false;
    }
}
