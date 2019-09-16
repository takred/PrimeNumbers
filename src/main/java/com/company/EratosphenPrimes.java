package com.company;

import java.util.ArrayList;
import java.util.List;

public class EratosphenPrimes implements PrimeNumbers {
    public List<Integer> getAllPrimes(int border) {
        List<Integer> allNumbers = new ArrayList<>();
        for (int i = 0; i < border; i++) {
            allNumbers.add(i);
        }
        Integer p = 2;
        while (true) {
            for (int i = p; i < allNumbers.size(); i++) {
                if (allNumbers.get(i) != -1) {
                    p = i;
                    break;
                }
                if (i == allNumbers.size() - 1 && allNumbers.get(i) == -1) {
                    p = -1;
                }
            }
            if (p == -1 || p >= allNumbers.size()) {
                break;
            }
            for (int j = p * p; j < border; j = j + p) {
                if (j > 0) {
                    allNumbers.set(j, -1);
                }
            }
            p++;

        }
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 0; i < allNumbers.size(); i++) {
            if (allNumbers.get(i) != -1){
                primeNumbers.add(allNumbers.get(i));
            }
        }
        return primeNumbers;
    }
}
