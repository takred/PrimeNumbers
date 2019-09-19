package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeTimings /*implements PrimeNumbers*/ {

    private PrimeNumbers primeNumbers;
    public List<Integer> allTimeCalculation = new ArrayList<>();
    public int lastNumbers;
    public int saveTime;
    public List<CalculationResult> newCalculationResult = new ArrayList<>();

    public PrimeTimings(PrimeNumbers primeNumbers) {
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
    public PrimeTimings(String fileName, PrimeNumbers primeNumbers, int saveTime) throws IOException {
        this.saveTime = saveTime;
        this.primeNumbers = primeNumbers;
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("no");
        } else {
            InputStream inputStream = new FileInputStream(file);
            Reader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            List<String> strings = bufferedReader.lines().collect(Collectors.toList());
            inputStream.close();
            if (strings.size() > 0) {
                lastNumbers = Integer.parseInt(strings.get(strings.size() - 1).substring(0, strings.get(strings.size() - 1).indexOf(";")));
                for (int i = 0; i < strings.size(); i++) {
                    System.out.println(strings.get(i));
                    System.out.println(strings.get(i));
                    CalculationResult calculationResult = new CalculationResult(Integer.parseInt(strings.get(i).substring(0,
                            strings.get(i).indexOf(";"))),
                            Integer.parseInt(strings.get(i).substring(strings.get(i).indexOf(";") + 2)));
                    newCalculationResult.add(calculationResult);
                }
            } else {
                lastNumbers = 1;
            }
        }

    }

    public List<Integer> getAllPrimes(int border, String fileSave) throws IOException {
        return getAllPrimesThreeBorder(2, border, 1, fileSave);
    }

    public List<Integer> getAllPrimesTwoBorder(int minBorder, int maxBorder, String fileSave) throws IOException {
        return getAllPrimesThreeBorder(minBorder, maxBorder, 1, fileSave);
    }

    public List<Integer> getAllPrimesThreeBorder(Integer minBorder, Integer maxBorder, Integer borderIteration, String fileSave) throws IOException {
        minBorder = minBorder + borderIteration;

        long lastSaveTime = 0;
        for (; minBorder < maxBorder + borderIteration; minBorder = minBorder + borderIteration) {
            long currentTime = System.currentTimeMillis();
            primeNumbers.getAllPrimes(minBorder);
            long endTime = System.currentTimeMillis();
            CalculationResult calculationResult = new CalculationResult(minBorder, (int) (endTime - currentTime));
            newCalculationResult.add(calculationResult);
            if (lastSaveTime != 0 && endTime - lastSaveTime >= saveTime * 1000){
                newFileSaveResult(borderIteration, fileSave);
                lastSaveTime = System.currentTimeMillis();
            } else if (lastSaveTime == 0){
                newFileSaveResult(borderIteration, fileSave);
                lastSaveTime = System.currentTimeMillis();
            }
            System.out.println(minBorder);
            System.out.println(maxBorder);
        }
//        newFileSaveResult(borderIteration, fileSave);
        fileSaveResult(fileSave);
        return allTimeCalculation;
    }

    public void fileSaveResult(String fileName) throws FileNotFoundException {
        OutputStream outputStream = new FileOutputStream(fileName, true);
        PrintWriter writer = new PrintWriter(outputStream);
        writer.println("");
        for (int i = 0; i < newCalculationResult.size() - 1; i++) {
            if (i == newCalculationResult.size() - 2) {
                writer.print(i + 1 + "; " + newCalculationResult.get(1 + i).timeCalculation);
            } else {
                writer.println(i + 1 + "; " + newCalculationResult.get(1 + i).timeCalculation);
            }
        }
        writer.close();
    }

    public void newFileSaveResult(Integer borderIteration, String fileSave) throws IOException {

        OutputStream outputStream = new FileOutputStream(fileSave, true);
        PrintWriter writer = new PrintWriter(outputStream);
        System.out.println(newCalculationResult.size());
        System.out.println("lastNumbers = " + lastNumbers);

        File file = new File(fileSave);
        if (!file.exists()) {
            System.out.println("no");
        } else {
            InputStream inputStream = new FileInputStream(file);
            Reader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            List<String> strings = bufferedReader.lines().collect(Collectors.toList());
            if (strings.size() == 0){
                writer.println("1; 0");
                writer.println("2; 0");
            } else {
                writer.println("");
            }
            inputStream.close();
        }
        for (int i = lastNumbers - 1; i < newCalculationResult.size(); i++) {
            if (i == newCalculationResult.size() - 1) {
                writer.print(newCalculationResult.get(i).border + "; " + newCalculationResult.get(i).timeCalculation);
            } else {
                writer.println(newCalculationResult.get(i).border + "; " + newCalculationResult.get(i).timeCalculation);
            }
        }
        lastNumbers = newCalculationResult.size() + 1;
        writer.close();
    }

    public void kakoytoMethod(int minBorder, int borderMsec, int borderIteration, String fileName) throws IOException { for (int i = minBorder; ; i = i + borderIteration) {
            long currentTime = System.currentTimeMillis();
            primeNumbers.getAllPrimes(i);
            long endTime = System.currentTimeMillis();
            CalculationResult calculationResult = new CalculationResult(i, (int) (endTime - currentTime));
            newCalculationResult.add(calculationResult);
            System.out.println(i);

//            if (newCalculationResult.size() > 2 && (newCalculationResult.get(i - (10 * (i / 10))).timeCalculation >= borderMsec &&
//                    newCalculationResult.get(i - (10 * (i / 10) + 1)).timeCalculation >= borderMsec && newCalculationResult.get(i - (10 * (i / 10) + 2)).timeCalculation >= borderMsec)) {
            if (newCalculationResult.size() > 2 && (newCalculationResult.get(newCalculationResult.size() - 1).timeCalculation >= borderMsec &&
                    newCalculationResult.get(newCalculationResult.size() - 2).timeCalculation >= borderMsec && newCalculationResult.get(newCalculationResult.size() - 3).timeCalculation >= borderMsec)) {
                break;
            }
        }
        newFileSaveResult(borderIteration, fileName);
    }

    public void eschoMethod(int minBorder, int maxBorder) {
        List<Integer> timeCalculation = new ArrayList<>();
        for (; minBorder < maxBorder + 1; minBorder++) {

        }
    }

    public List<Integer> getList() {
        return allTimeCalculation;
    }

    public List<CalculationResult> getNewList() {
        return newCalculationResult;
    }
}
