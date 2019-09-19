package com.company;

import java.io.FileNotFoundException;
import java.util.List;

public class PrimeGeneratorComparator {
    private PrimeNumbers firstPrimeNumbers;
    private PrimeNumbers secondPrimeNumbers;
    public PrimeGeneratorComparator(PrimeNumbers firstPrimeNumbers, PrimeNumbers secondPrimeNumbers){
        this.firstPrimeNumbers = firstPrimeNumbers;
        this.secondPrimeNumbers = secondPrimeNumbers;
    }
    public boolean compare(int border) throws FileNotFoundException {
        List<Integer> firstAllPrimeNumbers = firstPrimeNumbers.getAllPrimes(border);
        List<Integer> secondAllPrimeNumbers = firstPrimeNumbers.getAllPrimes(border);
        for (int i = 0; i < firstAllPrimeNumbers.size(); i++) {
            if (!firstAllPrimeNumbers.get(i).equals(secondAllPrimeNumbers.get(i))){
                return false;
            }
        }
        return true;
    }
}
