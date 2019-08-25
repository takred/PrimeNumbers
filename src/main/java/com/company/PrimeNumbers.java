package com.company;

import java.io.FileNotFoundException;
import java.util.List;

public interface PrimeNumbers {
    public List<Integer> getAllPrimes(int border) throws FileNotFoundException;
}
