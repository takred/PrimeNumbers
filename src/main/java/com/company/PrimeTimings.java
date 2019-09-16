package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeTimings /*implements PrimeNumbers*/ {

    private PrimeNumbers primeNumbers;
    public List<Integer> allTimeCalculation = new ArrayList<>();
    public int lastNumbers;
    public List<CalculationResult> newCalculationResult = new ArrayList<>();

    public PrimeTimings(PrimeNumbers primeNumbers){
        this.primeNumbers = primeNumbers;
    }
//    public PrimeTimings(String fileName, PrimeNumbers primeNumbers) throws IOException {
//        this.primeNumbers = primeNumbers;
//        File file = new File(fileName);
//        if (!file.exists()){
//            System.out.println("no");
//        } else {
//            InputStream inputStream = new FileInputStream(file);
//            Reader reader = new InputStreamReader(inputStream);
//            BufferedReader bufferedReader = new BufferedReader(reader);
//            List<String> strings = bufferedReader.lines().collect(Collectors.toList());
//            inputStream.close();
//
//            lastNumbers = Integer.parseInt(strings.get(strings.size() - 1).substring(0, strings.get(strings.size() - 1).indexOf(";")));
//            for (int i = 0; i < strings.size(); i++) {
//                allTimeCalculation.add(Integer.parseInt(strings.get(i).substring(strings.get(i).indexOf(";") + 2)));
//            }
//        }
//
//    }
    public PrimeTimings(String fileName, PrimeNumbers primeNumbers) throws IOException {
        this.primeNumbers = primeNumbers;
        File file = new File(fileName);
        if (!file.exists()){
            System.out.println("no");
        } else {
            InputStream inputStream = new FileInputStream(file);
            Reader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            List<String> strings = bufferedReader.lines().collect(Collectors.toList());
            inputStream.close();

            lastNumbers = Integer.parseInt(strings.get(strings.size() - 1).substring(0, strings.get(strings.size() - 1).indexOf(";")));
            for (int i = 0; i < strings.size(); i++) {
                CalculationResult calculationResult = new CalculationResult(Integer.parseInt(strings.get(i).substring(0, strings.get(i).indexOf(";"))), Integer.parseInt(strings.get(i).substring(strings.get(i).indexOf(";") + 2)));
                newCalculationResult.add(calculationResult);
            }
        }

    }

    public List<Integer> getAllPrimes(int border) throws FileNotFoundException {
//        List<Integer> timeCalculation = new ArrayList<>();
//        for (int i = 2; i < border + 1; i++) {
//            long currentTime = System.currentTimeMillis();
//            primeNumbers.getAllPrimes(i);
//            long endTime = System.currentTimeMillis();
//            timeCalculation.add((int) (endTime - currentTime));
//            System.out.println(i);
//        }
//        fileSaveResult(timeCalculation);
        return getAllPrimesThreeBorder(2, border, 1);
    }
    public List<Integer> getAllPrimesTwoBorder(int minBorder, int maxBorder) throws FileNotFoundException {
//        List<Integer> timeCalculation = new ArrayList<>();
//        for (; minBorder < maxBorder + 2; minBorder++) {
//            long currentTime = System.currentTimeMillis();
//            primeNumbers.getAllPrimes(minBorder);
//            long endTime = System.currentTimeMillis();
//            allTimeCalculation.add((int) (endTime - currentTime));
//            System.out.println(minBorder + 1);
//        }
//        fileSaveResult(allTimeCalculation);
        return getAllPrimesThreeBorder(minBorder, maxBorder, 1);
    }

    public List<Integer> getAllPrimesThreeBorder(Integer minBorder, Integer maxBorder, Integer borderIteration) throws FileNotFoundException {
        minBorder = minBorder + borderIteration;
        for (; minBorder < maxBorder + borderIteration; minBorder = minBorder + borderIteration) {
            long currentTime = System.currentTimeMillis();
            primeNumbers.getAllPrimes(minBorder);
            long endTime = System.currentTimeMillis();
            CalculationResult calculationResult = new CalculationResult(minBorder, (int) (endTime - currentTime));
            newCalculationResult.add(calculationResult);
            System.out.println(minBorder);
            System.out.println(maxBorder);
        }
        newFileSaveResult(borderIteration);
        return allTimeCalculation;
    }

    public void fileSaveResult(List<Integer> timeCalculation) throws FileNotFoundException {
        OutputStream outputStream = new FileOutputStream("ResultTimeCalculation.csv", true);
            PrintWriter writer = new PrintWriter(outputStream);
        System.out.println(timeCalculation.size());
        System.out.println("lastNumbers = " + lastNumbers);
        writer.println("");
        for (int i = 0; i < timeCalculation.size() - 1; i++) {
//            writer.println((i + 2) + "; " + timeCalculation.get(i));
            if(i == timeCalculation.size() - 2){
                writer.print(i + 1 +"; " + timeCalculation.get(1 + i));
            } else {
                writer.println(i + 1 + "; " + timeCalculation.get(1 + i));
            }
        }
        writer.close();
    }
    public void newFileSaveResult(Integer borderIteration) throws FileNotFoundException {
        OutputStream outputStream = new FileOutputStream("ResultTimeCalculation.csv", true);
        PrintWriter writer = new PrintWriter(outputStream);
        System.out.println(newCalculationResult.size());
//        System.out.println("lastNumbers = " + lastNumbers);
        writer.println("");
        for (int i = lastNumbers - 1; i < newCalculationResult.size(); i++) {
//            writer.println((i + 2) + "; " + timeCalculation.get(i));
            if(i == newCalculationResult.size() - 1){
                writer.print(newCalculationResult.get(i).border  + "; " + newCalculationResult.get(i).timeCalculation);
            } else {
                writer.println(newCalculationResult.get(i).border + "; " + newCalculationResult.get(i).timeCalculation);
            }
        }
        writer.close();
    }
    public void kakoytoMethod(int minBorder, int borderMsec, int borderIteration) throws FileNotFoundException {
//        List<Integer> timeCalculation = new ArrayList<>();
        for (int i = minBorder;; i = i + borderIteration) {
            long currentTime = System.currentTimeMillis();
            primeNumbers.getAllPrimes(i);
            long endTime = System.currentTimeMillis();
            CalculationResult calculationResult = new CalculationResult(i, (int) (endTime - currentTime));
//            timeCalculation.add((int) (endTime - currentTime));
            newCalculationResult.add(calculationResult);
            System.out.println(i);

//            if (newCalculationResult.size() > 2 && (newCalculationResult.get(i - (10 * (i / 10))).timeCalculation >= borderMsec &&
//                    newCalculationResult.get(i - (10 * (i / 10) + 1)).timeCalculation >= borderMsec && newCalculationResult.get(i - (10 * (i / 10) + 2)).timeCalculation >= borderMsec)) {
            if (newCalculationResult.size() > 2 && (newCalculationResult.get(newCalculationResult.size() - 1).timeCalculation >= borderMsec &&
                    newCalculationResult.get(newCalculationResult.size() - 2).timeCalculation >= borderMsec && newCalculationResult.get(newCalculationResult.size() - 3).timeCalculation >= borderMsec)){
                break;
            }
        }
        newFileSaveResult(borderIteration);
//        fileSaveResult(timeCalculation);
    }
    public void eschoMethod(int minBorder, int maxBorder){
        List<Integer> timeCalculation = new ArrayList<>();
        for (;minBorder < maxBorder + 1; minBorder++){

        }
    }
    public List<Integer> getList(){
        return allTimeCalculation;
    }
    public List<CalculationResult> getNewList(){
        return newCalculationResult;
    }
}
