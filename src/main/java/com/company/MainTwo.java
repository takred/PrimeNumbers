package com.company;

import java.io.IOException;
import java.util.List;

public class MainTwo {
    public static void main(String[] args) throws IOException {
        EratosphenPrimes eratosphenPrimes = new EratosphenPrimes();
        List<Integer> primeNumbers = eratosphenPrimes.getAllPrimes(100);
        for (int i = 0; i < primeNumbers.size(); i++) {
            if (primeNumbers.get(i) != -1){
                System.out.println(primeNumbers.get(i));
            }
        }
    }
}
