package com.additional;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;


import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.*;


class Csv {
    int n=0;
  public void toReadFile(String root, byte num) throws IOException, CsvValidationException, InterruptedException {

        FileReader f=new FileReader(root);


        if (num == 1) {

           CSVReader access= new CSVReader(f);
            singleCorrect(access);
        } else if (num == 2) {
            CSVReader access = new CSVReader(new FileReader(root));
            multiCorrectCpp(access);
        } else if (num == 3) {
            CSVReader access = new CSVReader(new FileReader(root));
                multiCorrectPython(access);
        }
    }
    public void singleCorrect(CSVReader obj1) throws CsvValidationException, IOException {
        questionModel Q1 = new questionModel();

        ArrayList<String[]> allQuestions = new ArrayList<>();
        ArrayList<Integer> indexes = new ArrayList<>();
        ArrayList<Integer> options = new ArrayList<>();

        String[] line1;

        for (int i = 0; i < 3; i++) {
            indexes.add(i);
        }

        while ((line1 = obj1.readNext()) != null) {
            allQuestions.add(line1);


        }

        Random Q = new Random();

        for (int i = 0; i < allQuestions.get(0).length; i++) {

            for (int j = 0; j < 4; j++) {
                options.add(j);
            }
            int index = Q.nextInt(indexes.size());

            int qNo=indexes.get(index);
            System.out.println(allQuestions.get(0)[qNo]);


            while (options.size() > 0) {

                int choices = new Random().nextInt(options.size());

                System.out.println(allQuestions.get(qNo + 1)[options.get(choices)]);
                options.remove(choices);
            }

                System.out.println("Please enter your answer: ");
                Scanner ans = new Scanner(System.in);
                try {
                    int input = ans.nextInt();
                    if (qNo == 0) {
                        if (input == 4)
                            Q1.correct();
                        else
                            Q1.wrong();
                    } else if (qNo == 1) {
                        if (input == 3) {
                            Q1.correct();
                        } else
                            Q1.wrong();
                    } else {
                        if (input == 3) {
                            Q1.correct();
                        } else {
                            Q1.wrong();
                        }
                    }
                }
                catch (Exception e){
                    System.out.println(e);
                }
            indexes.remove(index);

                }




        Q1.finalScore();
    }


        public void multiCorrectCpp(CSVReader obj) throws CsvValidationException, IOException {
            questionModel Q1 = new questionModel();

            ArrayList<String[]> allQuestions = new ArrayList<>();
            ArrayList<Integer> indexes = new ArrayList<>();
            ArrayList<Integer> options = new ArrayList<>();

            String[] line1;

            for (int i = 0; i < 3; i++) {
                indexes.add(i);
            }

            while ((line1 = obj.readNext()) != null) {
                allQuestions.add(line1);


            }

            Random Q = new Random();

            for (int i = 0; i < allQuestions.get(0).length; i++) {

                for (int j = 0; j < 4; j++) {
                    options.add(j);
                }
                int index = Q.nextInt(indexes.size());

                int qNo=indexes.get(index);
                System.out.println(allQuestions.get(0)[qNo]);


                while (options.size() > 0) {

                    int choices = new Random().nextInt(options.size());

                    System.out.println(allQuestions.get(qNo + 1)[options.get(choices)]);
                    options.remove(choices);
                }
                int[][] answers={{1,2,3}};
                System.out.println("Please enter your answer: ");
                Scanner ans = new Scanner(System.in);
                try {
                    int[] input=new int[3];
                    int correct=0;
                    if (qNo == 0) {
                        for (int j=0;j<input.length;j++){
                            input[j]=ans.nextInt();
                        }
                        for (int l=0;l<3;l++){
                            for(int k=0;k<3;k++) {
                                if(input[l]==answers[qNo][k]) {
                                    correct++;
                                }
                            }
                        }
                        if (correct==3){
                            Q1.correct();
                        }
                        else
                            Q1.wrong();


                    } else if (qNo == 1) {
                        int userinput;
                        userinput=ans.nextInt();
                        if (userinput==3) {
                            Q1.correct();
                        } else
                            Q1.wrong();
                    } else {
                        int userinput;
                        userinput=ans.nextInt();
                        if (userinput == 3) {
                            Q1.correct();
                        } else {
                            Q1.wrong();
                        }
                    }
                }
                catch (Exception e){
                    System.out.println(e);
                }
                indexes.remove(index);

            }




            Q1.finalScore();
        }
        public void multiCorrectPython(CSVReader obj) throws CsvValidationException, IOException {
            questionModel Q1 = new questionModel();

            ArrayList<String[]> allQuestions = new ArrayList<>();
            ArrayList<Integer> indexes = new ArrayList<>();
            ArrayList<Integer> options = new ArrayList<>();

            String[] line1;

            for (int i = 0; i < 3; i++) {
                indexes.add(i);
            }

            while ((line1 = obj.readNext()) != null) {
                allQuestions.add(line1);


            }

            Random Q = new Random();

            for (int i = 0; i < allQuestions.get(0).length; i++) {

                for (int j = 0; j < 4; j++) {
                    options.add(j);
                }
                int index = Q.nextInt(indexes.size());

                int qNo=indexes.get(index);
                System.out.println(allQuestions.get(0)[qNo]);


                while (options.size() > 0) {

                    int choices = Q.nextInt(options.size());

                    System.out.println(allQuestions.get(qNo + 1)[options.get(choices)]);
                    options.remove(choices);
                }

                int[][] answers={{1,2,3},{1,2,3},{3}};
                System.out.println("Please enter your answer: ");
                Scanner ans = new Scanner(System.in);
                try {
                    int[] input=new int[3];
                    int correct=0;
                    if (qNo == 0) {
                        for (int j=0;j<input.length;j++){
                            input[j]=ans.nextInt();
                        }
                        for (int l=0;l<3;l++){
                            for(int k=0;k<3;k++) {
                                if(input[l]==answers[qNo][k]) {
                                    correct++;
                                }
                            }
                        }
                        if (correct==3){
                            Q1.correct();
                        }
                        else
                            Q1.wrong();

                    } else if (qNo == 1) {
                        correct=0;
                        for (int j=0;j<input.length;j++){
                            input[j]=ans.nextInt();
                        }
                        for (int l=0;l<3;l++){
                            for(int k=0;k<3;k++) {
                                if(input[l]==answers[qNo][k]) {
                                    correct++;
                                }
                            }
                        }
                        if (correct==3){
                            Q1.correct();
                        }
                        else
                            Q1.wrong();

                    } else {
                     int single=ans.nextInt();
                     if (single==answers[qNo][0]){
                         Q1.correct();
                     }
                     else
                         Q1.wrong();

                    }
                }
                catch (Exception e){
                    System.out.println(e);
                }
                indexes.remove(index);

            }




            Q1.finalScore();
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
 class End{
     public void topics(int num) throws CsvValidationException, IOException, InterruptedException {

         switch (num) {
             case 1:
                 Java in = new Java();
                 in.topicName();
                 in.questions();
                 choices(num);
                 break;
             case 2:
                 cPlusPlus in1 = new cPlusPlus();
                 in1.topicName();
                 in1.questions();
                 choices(num);
                 break;
             case 3:
                 python in2=new python();
                 in2.topicName();
                 in2.questions();
                 choices(num);
                 break;
         }
     }
     public void choices(int num) throws CsvValidationException, IOException, InterruptedException {
         Scanner sc=new Scanner(System.in);
         int input;
         System.out.println("\nDo you wish to play again??\nEnter 0 to start next topic\nEnter 1 to repeat the same topic\nEnter 2 to exit");
         input=sc.nextInt();
         if (input==0){
             num++;
             if(num>3){
                 num=1;
             }

             topics(num);
         }
         else if(input==1) {
             topics(num);
         }
         else if(input==2){
             System.out.println("Thank you for participating in the quiz");
         }
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
                "\n3.each question is allotted 1 mark and no negative marking\n4.Every option has a unique id represented by the number beside. " +
                "Enter your answer by typing the unique digit id against the option\nplease select your topic: \n 1.Java \n2.C++\n3.Python");
        Scanner inputNum = new Scanner(System.in);
        byte num = inputNum.nextByte();
        End obj1=new End();
        obj1.topics(num);





    }
}










