package com.additional;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//class Timer  {
//
//     public Timer(long num)  throws InterruptedException   {
//
//         }
//
//     }
// }
 class Csv {
    public void timer(long num) throws InterruptedException {
        int charsWritten = 0;
        while (1 > 0) {
            Thread.sleep(1000);
            long elapsedTime = System.currentTimeMillis() - num;
            elapsedTime = elapsedTime / 1000;

            String seconds = Integer.toString((int) (elapsedTime % 60));
            String minutes = Integer.toString((int) ((elapsedTime % 3600) / 60));
            String hours = Integer.toString((int) (elapsedTime / 3600));

            if (seconds.length() < 2) {
                seconds = "0" + seconds;
            }

            if (minutes.length() < 2) {
                minutes = "0" + minutes;
            }

            if (hours.length() < 2) {
                hours = "0" + hours;
            }

            String writeThis = hours + ":" + minutes + ":" + seconds;

            for (int i = 0; i < charsWritten; i++) {
                System.out.print("\b");
            }
            System.out.print(writeThis);
            charsWritten = writeThis.length();
        }

    }

    public void toReadFile(String root, byte num) throws IOException, CsvValidationException, InterruptedException {

        FileReader reader = new FileReader(root);

        if (num == 1) {

            CSVReader access = new CSVReader(reader);
            singleCorrect(access);
        } else if (num == 2) {
            CSVReader access = new CSVReader(reader);
            multiCorrectCpp(access);
        } else if (num == 3) {
            CSVReader access = new CSVReader(reader);
                multiCorrectPython(access);
        }
    }
        public void singleCorrect(CSVReader obj) throws CsvValidationException, IOException {
            int n = 0;
            String[] data;
            questionModel Q1 = new questionModel();
            while ((data = obj.readNext()) != null) {
                for (String element3 : data
                ) {
                    System.out.println(element3 + " ");
                }
                n++;
                int[] arr = new int[3];
                System.out.println("Please enter your answer: ");
                Scanner ans = new Scanner(System.in);
                arr[n - 1] = ans.nextInt();
                if (arr[0] == 4 || arr[1] == 3 || arr[2] == 3) {
                    Q1.correct();
                } else {
                    Q1.wrong();
                }
                if (n == 3) {
                    Q1.finalScore();
                    break;
                }

            }
        }
        public void multiCorrectCpp(CSVReader obj) throws CsvValidationException, IOException {
            int n = 0;
            String[] data;
            questionModel Q1 = new questionModel();
            while ((data = obj.readNext()) != null) {
                for (String element3 : data
                ) {
                    System.out.println(element3 + " ");
                }
                n++;
                int[] arr = new int[4];
                System.out.println("Please enter your answer: ");
                Scanner ans = new Scanner(System.in);
                if (n == 1) {
                    arr[n - 1] = ans.nextInt();
                    arr[n] = ans.nextInt();
                } else {
                    arr[n] = ans.nextInt();
                }
                if (arr[0] == 1 && arr[1] == 2 || arr[2] == 3 || arr[3] == 3) {
                    Q1.correct();
                } else {
                    Q1.wrong();
                }
                if (n == 3) {
                    Q1.finalScore();
                    break;
                }

            }
        }
        public void multiCorrectPython(CSVReader obj) throws CsvValidationException, IOException {
            int n = 0;
            String[] data;
            questionModel Q1 = new questionModel();
            while ((data = obj.readNext()) != null) {
                for (String element3 : data
                ) {
                    System.out.println(element3 + " ");
                }
                n++;
                int[] arr = new int[7];
                System.out.println("Please enter your answer: ");
                Scanner ans = new Scanner(System.in);
                if (n==1){
                    arr[n - 1] = ans.nextInt();
                    arr[n]=ans.nextInt();
                    arr[n+1]=ans.nextInt();
                }

                else if(n==2){
                    arr[n+1]=ans.nextInt();
                    arr[n+2]=ans.nextInt();
                    arr[n+3]=ans.nextInt();
                }
                else {
                    arr[2*n]=ans.nextInt();
                }
                if (arr[0] == 1 && arr[1]==2 && arr[2]==3 ||arr[3] == 1 && arr[4]==2 && arr[5]==3 || arr[6] == 3) {
                    Q1.correct();
                } else {
                    Q1.wrong();
                }
                if (n == 3) {
                    Q1.finalScore();
                    break;
                }

            }
        }

}
 interface Result{
     void correct();
     void wrong();
     void finalScore();
 }
 class questionModel implements Result{
     int score=0;
     public void correct(){
         System.out.println("Your answer is correct!!\n");
        score++;
     }
     public void wrong(){
         System.out.println("Your answer is wrong");
     }

     public void finalScore(){
         System.out.println("\nyou got "+score+" questions right!\nYour final score is "+score);
     }
 }

 abstract class Topic extends Csv{
    abstract public void questions() throws CsvValidationException, IOException, InterruptedException;
    abstract public void topicName();
 }
 class Java extends Topic{
     @Override
     public void topicName() {
         System.out.println("You have chosen Java as the topic,here are your questions:\n");
     }
     @Override
     public void questions() throws CsvValidationException, IOException, InterruptedException {
         String CSV_PATH = "src/com/additional/questions.csv";
        // timer(System.currentTimeMillis());
         toReadFile(CSV_PATH, (byte) 1);
     }
 }
 class cPlusPlus extends Topic {
     @Override
     public void topicName() {
         System.out.println("You have chosen C++ as the topic,here are your questions:\n");
     }

     @Override
     public void questions() throws CsvValidationException, IOException, InterruptedException {
         String CSV_PATH = "src/com/additional/questionsCpp.csv";
         toReadFile(CSV_PATH, (byte) 2);
     }
 }class python extends Topic {
     @Override
     public void topicName() {
         System.out.println("You have chosen python as the topic,here are your questions:\n");
     }

     @Override
     public void questions() throws CsvValidationException, IOException, InterruptedException {
         String CSV_PATH = "src/com/additional/questionsPython.csv";
         toReadFile(CSV_PATH, (byte) 3);
     }
 }

public class Main {
    public static void main(String[] args) throws IOException, CsvValidationException, InterruptedException {
//        Csv c=new Csv();
//        c.timer(System.currentTimeMillis());

      //  taking input from the user
        System.out.println("Welcome to the programming language quiz," +
                "\n please read the general instructions as follows:\n  " +
                "1.The questions could be single or multi correct.It will be indicated accordingly beside question number" +
                " \n2.there are three questions per topic" +
                "\n3.each question is allotted 1 mark and no negative marking\n\nplease select your topic: \n 1.Java \n2.C++\n3.Python");
        Scanner inputNum = new Scanner(System.in);
        byte num = inputNum.nextByte();
        switch (num) {
            case 1:
                Java in = new Java();
                in.topicName();
                in.questions();
                break;
            case 2:
                cPlusPlus in1 = new cPlusPlus();
                in1.topicName();
                in1.questions();
                break;
            case 3:
                python in2=new python();
                in2.topicName();
                in2.questions();
                break;
        }
        int input;
        System.out.println("\nDo you wish to play again??\nEnter 0 for yes\nEnter 1 for no");
        input=inputNum.nextInt();
        if (input==0){
            main(args);
        }
        else {
            System.out.println("Thank you for participating in the quiz");
        }


    }
}










