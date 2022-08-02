package com.knubisoft.base.numbers;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class NumbersTasksImpl implements NumbersTasks {

    @Override
    public void swapTwoNumbersWithoutUsingTemporaryVariable(int firstNumber, int secondNumber) {
        int first = firstNumber;
        int second = secondNumber;
        first = first + second;
        second = first - second;
        first = first - second;
    }

    @Override
    public boolean isUglyInt(int number) {
        if (number < 1) {
            return false;
        }
        int num;
        do {
            num = number;
            if (number % 2 == 0) number /= 2;
            if (number % 3 == 0) number /= 3;
            if (number % 5 == 0) number /= 5;
        } while (num != number);
        return number == 1;
    }

    @Override
    public int addDigits(int number) {
        String s = String.valueOf(number);
        char[] numbers = s.toCharArray();
        int sum = 0;
        if (numbers.length == 1) {
            return number;
        }
        while (numbers.length != 1) {
            for (char digit : numbers) {
                sum += Character.getNumericValue(digit);
            }
            if (sum >= 10) {
                s = String.valueOf(sum);
                numbers = s.toCharArray();
                sum = 0;
            } else {
                break;
            }
        }
        return sum;
    }

    @Override
    public boolean isHarshadNumber(int number) {
        if (number < 10) {
            return false;
        }
        String s = String.valueOf(number);
        char[] numbers = s.toCharArray();
        int sum = 0;
        for (char digit : numbers) {
            sum += Character.getNumericValue(digit);
        }
        return number % sum == 0;
    }

    @Override
    public boolean isPrime(int number) {
        int n = number;
        if (n % 2 == 0 || n % 3 == 0 || n % 5 == 0 || n % 7 == 0) {
            return false;
        }
        for (int i = 11; i < n / 2; i = i + 6) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;

        /*
        return number > 1
                && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(n -> (number % n == 0));
         */

        /*
        BigInteger bigInt = BigInteger.valueOf(number);
        return bigInt.isProbablePrime(100);
        */
    }

    @Override
    public boolean isArmstrongNumber(int number) {
        if (number < 10) {
            return true;
        }
        String s = String.valueOf(number);
        char[] numbers = s.toCharArray();
        int sum = 0;
        for (char digit : numbers) {
            int i = Character.getNumericValue(digit);
            sum += Math.pow(i, s.length());
        }
        return number == sum;
    }

    @Override
    public BigInteger factorial(int number) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 1; i <= number; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }

    @Override
    public boolean palindrome(int number) {
        String s = String.valueOf(number);
        StringBuilder num = new StringBuilder();
        num.append(s).reverse();
        return s.equals(num.toString());
    }

    @Override
    public boolean isAutomorphic(int number) {
        long squaredNum = (long )number * number;
        String first = String.valueOf(number);
        String second = String.valueOf(squaredNum);
        StringBuilder result = new StringBuilder();
        int index = second.length()-1;
        for (int i = first.length()-1; i >= 0; i--) {
                if (second.charAt(index) == first.charAt(i)) {
                    result.append(first.charAt(i));
                }
                index--;
            }
        return first.equals(result.reverse().toString());
    }
}
