package com.knubisoft.base.string;

import java.util.NoSuchElementException;

public class StringTasksImpl implements StringTasks {

    @Override
    public String reverseString(String original) {
        if (original == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder s = new StringBuilder(original);
        return s.reverse().toString();
    }

    @Override
    public String insertStringInMiddle(String original, String toInsert) {
        if (original == null || original.isBlank() || toInsert == null || toInsert.isBlank()) {
            throw new IllegalArgumentException();
        }
        StringBuilder s = new StringBuilder(original);
        toInsert = toInsert.replaceAll("\\r\\n", "\n");
        return s.insert(original.length() / 2, toInsert).toString();
    }

    @Override
    public String insertSymbolInString(String original, char toInsert, int position) {
        if (original == null || original.isBlank() || position > original.length() || position < 0) {
            throw new IllegalArgumentException();
        }
        StringBuilder s = new StringBuilder(original);
        s.insert(position, toInsert);
        return s.toString();
    }

    @Override
    public String appendToString(StringBuilder original, String toAppend) {
        if (original == null || original.length() == 0 || toAppend == null) {
            throw new NoSuchElementException();
        }
        return original.append(toAppend).toString();
    }

    @Override
    public boolean isPalindrome(String palindrome) {
        if (palindrome == null) {
            throw new RuntimeException();
        }
        StringBuilder s = new StringBuilder(palindrome).reverse();
        return palindrome.equals(s.toString());
    }

    @Override
    public boolean hasLowerCase(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        if (str.equals(str.toLowerCase())) {
            return true;
        }
        return false;
    }

    @Override
    public String uniqueCharacters(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        char[] chars = str.toLowerCase().toCharArray();
        StringBuilder result = new StringBuilder();
        int count;
        for (char char1 : chars) {
            count = 0;
            for (char char2 : chars) {
                if (char1 == char2) {
                    count++;
                }
            }
            if (count == 1) {
                result.append(char1);
            }
        }
        return result.toString();
    }

    @Override
    public String removeAllCharacters(String str, char charToRemove) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        return str.replaceAll(Character.toString(charToRemove), "");
    }

    @Override
    public String toCamelCase(String str) {
        if (str == null || str.isBlank()) {
            throw new IllegalArgumentException();
        }
        String[] words = str.split("[\\W_]+");
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            if (builder.length() == 0) {
                builder.append(word.toLowerCase());
            } else
                builder.append(Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase());
        }
        return builder.toString();
    }

    @Override
    public String getCountRepeatableString(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder builder = new StringBuilder();
        int count;
        for (int i = 0; i < str.length(); i++){
            count = 1;
            for (int j = 0; j < str.length(); j++){
                if (str.charAt(i) == str.charAt(j) && i <= j){
                    if (count>9){
                        count = 1;
                    }
                    builder.append(count);
                    count++;
                }
            }
        }
        return builder.toString();
    }

    @Override
    public String sortStringCharactersAsc(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        String s;
        char[] arr = str.toCharArray();
        char temp;
        for (int i = 0; i < arr.length; i++){
            for (int j = i+1; j < arr.length; j++){
                if (arr[j] < arr[i]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        s = String.valueOf(arr);
        return s;
    }
}
