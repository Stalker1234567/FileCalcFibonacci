package FileInput;

import FibonacciCalculator.FibonacciCalculator;

import java.io.*;
import java.util.Scanner;

public class FileInput {

    private String nameFile;
    public int dataStart;
    public int dataEnd;
    public int repeatFibonacci;

    public String setNameFile() {
        System.out.println("Введите название файла: ");
        Scanner scannNameFile = new Scanner(System.in);
        return nameFile = scannNameFile.nextLine();
    }

    public void setFile() throws IOException {

        FibonacciCalculator fibonacciCalculator = new FibonacciCalculator();

        File fileOutput = new File("C:\\Users\\Bogdan\\IdeaProjects\\project\\src\\output\\" + setNameFile() + "Start" + ".txt");
        File fileOutputEnd = new File("C:\\Users\\Bogdan\\IdeaProjects\\project\\src\\output\\" + nameFile + "End" + ".txt");
        if (!fileOutput.exists()) {
            try {
                fileOutput.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (!fileOutputEnd.exists()) {
            try {
                fileOutputEnd.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        dataStart = fibonacciCalculator.inputBoard();
        repeatFibonacci = fibonacciCalculator.setRepeatFibonacci();
        dataEnd = fibonacciCalculator.setFibonacci();

        try(FileOutputStream fileOutputStreamStart = new FileOutputStream(fileOutput);
            BufferedOutputStream bufferedOutputStreamStart = new BufferedOutputStream(fileOutputStreamStart)) {

            String convertIntegerToStringStart = Integer.toString(dataStart);
            byte[] convertStringToByteStart = convertIntegerToStringStart.getBytes();

            System.out.println("Начальная точка: " + dataStart);
            bufferedOutputStreamStart.write(convertStringToByteStart);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try(FileOutputStream fileOutputStreamEnd = new FileOutputStream(fileOutputEnd);
            BufferedOutputStream bufferedOutputStreamEnd = new BufferedOutputStream(fileOutputStreamEnd)) {

            String convertIntegerToStringEnd = Integer.toString(dataEnd);
            byte[] convertStringToByteEnd = convertIntegerToStringEnd.getBytes();

            System.out.println("Конечная точка: " + dataEnd);
            bufferedOutputStreamEnd.write(convertStringToByteEnd);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
