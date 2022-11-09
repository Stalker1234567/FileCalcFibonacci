package FibonacciCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciCalculator {

    public int stepOneFibonacci;
    public int stepTwoFibonacci;
    public int stepThreeFibonacci;

    public int stepResult;

    public int stepSetRepeatFibonacci;


    public int setRepeatFibonacci() throws IOException {
        System.out.println("Введите число, которое укажет срок работы цикла числа Фибоначчи в повторениях рассчёта: ");
        BufferedReader bufferedReaderRepeat = new BufferedReader(new InputStreamReader(System.in));
        stepSetRepeatFibonacci = Integer.parseInt(bufferedReaderRepeat.readLine());
        return stepSetRepeatFibonacci;
    }
    public int inputBoard() throws IOException {
        System.out.println("Введите число которое будет входной точкой рассчёта чисел Фибоначчи: ");
        BufferedReader bufferedReaderFibonacci = new BufferedReader(new InputStreamReader(System.in));
        stepResult = Integer.parseInt(bufferedReaderFibonacci.readLine());
        return stepResult;
    }

    public int setFibonacci() throws IOException {
        stepOneFibonacci = this.stepOneFibonacci;
        stepTwoFibonacci = this.stepTwoFibonacci;
        stepThreeFibonacci = this.stepThreeFibonacci;

        stepOneFibonacci = stepResult;

        stepTwoFibonacci = stepOneFibonacci;

        for(int i = 0; i < stepSetRepeatFibonacci; i++) {
            stepThreeFibonacci = stepOneFibonacci + stepTwoFibonacci;
            System.out.println(stepThreeFibonacci);

            stepOneFibonacci = stepTwoFibonacci;
            stepTwoFibonacci = stepThreeFibonacci;
        }
        System.out.println();
        return stepThreeFibonacci;
    }
}
