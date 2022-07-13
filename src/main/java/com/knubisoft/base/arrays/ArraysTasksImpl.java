package com.knubisoft.base.arrays;

import java.util.Arrays;

public class ArraysTasksImpl implements ArraysTasks {
    @Override
    public int[] reverse(int[] array) {
        int arrayLength = array.length;
        int index = 0;
        int[] arrayReversed = new int[arrayLength];
        for (int i = array.length - 1; i >= 0; i--) {
            arrayReversed[index] = array[i];
            index++;
        }
        return arrayReversed;
    }

    @Override
    public int[] mergeArrays(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length + array2.length];
        int index = 0;
        for (int i = 0; i < array1.length; i++) {
            mergedArray[i] = array1[i];
        }
        for (int j = array1.length; j < mergedArray.length; j++) {
            mergedArray[j] = array2[index];
            index++;
        }
        return mergedArray;
    }

    @Override
    public int[] findMax3InArray(int[] array) {
        if (array.length <= 2) {
            return array;
        }
        int max1 = 0;
        int max2 = 0;
        int max3 = 0;
        for (int i = 0; i < array.length; i++) {
            if (max1 < array[i]) {
                max3 = max2;
                max2 = max1;
                max1 = array[i];
            } else if (max2 < array[i]) {
                max3 = max2;
                max2 = array[i];
            } else if (max3 < array[i]) {
                max3 = array[i];
            }
        }
        int[] max3InArray = {max1, max2, max3};
        return max3InArray;
    }

    @Override
    public int findLongestIncreasingContinuesSubsequence(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int longestSubsequence = 1;
        int currentSubsequence = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                currentSubsequence++;
            } else {
                if (longestSubsequence < currentSubsequence) {
                    longestSubsequence = currentSubsequence;
                }
                currentSubsequence = 1;
            }
        }
        if (longestSubsequence < currentSubsequence) {
            longestSubsequence = currentSubsequence;
        }
        return longestSubsequence;
    }

    @Override
    public int sumOfAllUniqueElements(int[] array) {
        int sum = 0;
        int uniqueElCount = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j] && i <= j) {
                    uniqueElCount++;
                }
            }
            if (uniqueElCount < 2) {
                sum += array[i];
            }
            uniqueElCount = 0;
        }
        return sum;
    }

    @Override
    public int[] moveZeroes(int[] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                continue;
            } else if (array[i] != 0 && index != i) {
                int helper = 0;
                array[index] = array[i];
                array[i] = helper;
                index++;
            } else {
                index++;
                continue;
            }
        }
        return array;
    }

    @Override
    public int findFinalValue(int[] nums, int original) {
        int finalValue = original;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == finalValue) {
                finalValue *= 2;
                i = -1;
            }
        }
        return finalValue;
    }

    @Override
    public String longestCommonPrefix(String[] words) {
        if (words.length == 0) {
            return "";
        }
        if (words.length == 1) {
            return words[0];
        }
        int wordLength = words[0].length();
        int arrayLength = words.length;
        Arrays.sort(words);
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < wordLength; i++) {
            if (words[0].charAt(i) == words[arrayLength - 1].charAt(i)) {
                prefix.append(words[0].charAt(i));
            } else {
                break;
            }
        }
        String result = prefix.toString();
        return result;
    }

    @Override
    public int missingNumber(int[] array) {
        int missingNum = 0;
        int num = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                int helper = array[i - 1];
                array[i - 1] = array[i];
                array[i] = helper;
                i = 0;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != num) {
                missingNum = num;
                return missingNum;
            }
            num++;
        }
        if (num == array.length) {
            missingNum = num;
        }
        return missingNum;
    }

    @Override
    public boolean containsDuplicate(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int currentNum = array[i];
            int count = 0;
            for (int j = 0; j < array.length; j++) {
                if (currentNum == array[j]) {
                    count++;
                }
                if (count >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
