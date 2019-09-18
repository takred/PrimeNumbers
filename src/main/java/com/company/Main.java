package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        long currentTime = System.currentTimeMillis();
        String eratosphen = "EratosphenResultTimeCalculation.csv";
        String fileName = "Test.csv";
        String brute = "ResultTimeCalculation.csv";

        System.out.println("ЗАРАБОТАЛ! ЗАРАБОТАЛ! ЗАРАБОТА-А-АЛ!!!");
//        PrimeNumbers brutePrimes = new BrutePrimes();
        PrimeNumbers brutePrimes = new EratosphenPrimes();
//        List<Integer> listSimpleNumbers =  brutePrimes.getAllPrimes(2000);
//        for (int i = 0; i < listSimpleNumbers.size(); i++) {
//            System.out.println(listSimpleNumbers.get(i));
//        }
        PrimeTimings primeTimings = new PrimeTimings(fileName, brutePrimes);
//        PrimeTimings primeTimings = new PrimeTimings(brutePrimes);
//        primeTimings.getAllPrimes(2000);
//        primeTimings.fileSaveResult(listSimpleNumbers);
//        primeTimings.getAllPrimesThreeBorder(primeTimings.getList().size() - 1, primeTimings.getList().size() - 1 + 500, 10);
        primeTimings.getAllPrimes(60000, fileName);
        System.out.println(primeTimings.newCalculationResult.size());
//        primeTimings.kakoytoMethod(primeTimings.newCalculationResult.get(primeTimings.newCalculationResult.size() - 1).border, 100, 10);
//        primeTimings.getAllPrimesThreeBorder(primeTimings.getNewList().get(primeTimings.getNewList().size() - 1).border, primeTimings.getNewList().get(primeTimings.getNewList().size() - 1).border + 100, 10);
//        for (int i = 0; i < primeTimings.getList().size(); i++) {
//            System.out.println(i + 2 + " " + primeTimings.getList().get(i));
//        }
//        primeTimings.kakoytoMethod(500);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - currentTime);
    }
}
