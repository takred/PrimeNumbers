package com.company;

import java.util.ArrayList;
import java.util.List;

public class EratosphenPrimes implements PrimeNumbers {
    public List<Integer> getAllPrimes(int border) {
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 0; i < border; i++) {
            primeNumbers.add(i);
        }
        Integer p = 2;
        while (true){
            for (int i = p; i < primeNumbers.size(); i++) {
                if (primeNumbers.get(i) != -1){
                    p = i;
                    break;
                }
                System.out.println(p);
                if (i == primeNumbers.size() - 1 && primeNumbers.get(i) == -1){
                    p = -1;
                }
            }
            if (p == -1){
                break;
            }
                for (int j = p * p; j < border; j = j + p) {
                    primeNumbers.set(j, -1);
                }
            p++;

        }
       return primeNumbers;
    }
}
