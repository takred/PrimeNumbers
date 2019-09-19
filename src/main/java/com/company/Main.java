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
        int saveTime = 2;

        System.out.println("ЗАРАБОТАЛ! ЗАРАБОТАЛ! ЗАРАБОТА-А-АЛ!!!");
//        PrimeNumbers brutePrimes = new BrutePrimes();
        PrimeNumbers eratosphenPrimes = new EratosphenPrimes();
//        List<Integer> listSimpleNumbers =  brutePrimes.getAllPrimes(2000);
//        for (int i = 0; i < listSimpleNumbers.size(); i++) {
//            System.out.println(listSimpleNumbers.get(i));
//        }
        PrimeTimings primeTimings = new PrimeTimings(fileName, eratosphenPrimes);
//        PrimeTimings primeTimings2 = new PrimeTimings(brutePrimes);
//        PrimeGeneratorComporator primeGeneratorComporator = new PrimeGeneratorComporator(brutePrimes, eratosphenPrimes);
//        System.out.println(primeGeneratorComporator.Compare(3000));
//        primeTimings.getAllPrimes(2000);
//        primeTimings.fileSaveResult(listSimpleNumbers);
//        primeTimings.getAllPrimesThreeBorder(primeTimings.getList().size() - 1, primeTimings.getList().size() - 1 + 500, 10);
        primeTimings.getAllPrimes(60000, fileName, saveTime);
//        primeTimings.kakoytoMethod(primeTimings.newCalculationResult.get(primeTimings.newCalculationResult.size() - 1).border, 100, 10);
//        primeTimings.getAllPrimesThreeBorder(primeTimings.getNewList().get(primeTimings.getNewList().size() - 1).border, primeTimings.getNewList().get(primeTimings.getNewList().size() - 1).border + 100, 10);
//        primeTimings.kakoytoMethod(500);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - currentTime);
    }
}
