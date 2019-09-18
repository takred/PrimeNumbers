package com.company;

import java.io.FileNotFoundException;
import java.util.List;

public class PrimeGeneratorComporator {
    private PrimeNumbers firstPrimeNumbers;
    private PrimeNumbers secondPrimeNumbers;
    public PrimeGeneratorComporator(PrimeNumbers firstPrimeNumbers, PrimeNumbers secondPrimeNumbers){
        this.firstPrimeNumbers = firstPrimeNumbers;
        this.secondPrimeNumbers = secondPrimeNumbers;
    }
    public boolean Compare(int border) throws FileNotFoundException {
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
