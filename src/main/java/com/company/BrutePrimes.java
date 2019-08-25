package com.company;

import java.io.File;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class BrutePrimes implements PrimeNumbers {
    public List<Integer> getAllPrimes(int border) {
        List<Integer> listSimpleNumber = new ArrayList<Integer>();
        for (int i = 2; i < border; i++) {
            int count = 0;
            for (int j = i; j > 0; j--) {
                if (i % j == 0){
                    count++;
                }
            }
            if (count == 2){
                listSimpleNumber.add(i);
            }
        }
        return listSimpleNumber;
    }
}
