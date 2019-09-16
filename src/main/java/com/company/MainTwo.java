package com.company;

import java.io.IOException;
import java.util.List;

public class MainTwo {
    public static void main(String[] args) throws IOException {
        PrimeNumbers eratosphenPrimes = new BrutePrimes();
//        List<Integer> primeNumbers = eratosphenPrimes.getAllPrimes(10000);
        List<Integer> primeNumbers = eratosphenPrimes.getAllPrimes(10000);
        for (int i = 0; i < primeNumbers.size(); i++) {
                System.out.println(primeNumbers.get(i));
        }
    }
}
