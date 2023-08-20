package org.TaskManager;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class TaskMain {
    public static void main(String args[])throws Exception{
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);


        ArrayList<Task> alt = new ArrayList<Task>();

        ListIterator list = null;

        int choice = -1;
        int n;
        String yn;
        File file = new File("C:\\Users\\zver\\Desktop\\TaskManager\\TaskMan.txt");

        ObjectOutputStream out = null;
        ObjectInputStream oin = null;

        if(file.isFile()){
            oin = new ObjectInputStream(new FileInputStream(file));
            alt = (ArrayList<Task>) oin.readObject();
            oin.close();
        }

        while(choice != 0 ){
            System.out.println("1. INSERT");
            System.out.println("2. DISPLAY");
            System.out.println("3. DELETE");
            System.out.println("4.  CHECK");
            System.out.println("5.  EXIT");
            System.out.println("Enter your option: ");
            choice = s.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter the number of tasks: ");
                    n = s1.nextInt();

                    for(int i = 0; i < n;i++){

                        System.out.println("Enter Task: ");
                        String taskName = s1.next();


                        System.out.println("Enter Task Lenght in HOURS: ");
                        double taskLenght = s.nextDouble();

                        System.out.println("Enter the task's ordinal number");
                        int taskNumber = s.nextInt();

                        alt.add(new Task(taskName,taskLenght,taskNumber));
                    }
                    out = new ObjectOutputStream(new FileOutputStream(file));
                    out.writeObject(alt);
                    out.close();

                    break;
                case 2:
                    System.out.println("----------------------");
                    list = alt.listIterator();
                    while(list.hasNext())
                        System.out.println(list.next());

                    System.out.println("----------------------");
                    break;
                case 3:
                    if(file.isFile()){
                        oin = new ObjectInputStream(new FileInputStream(file));
                        alt = (ArrayList<Task>) oin.readObject();
                        oin.close();

                        boolean found = false;
                        System.out.println("Enter number of task that you want to Delete: ");
                        int taskNumber = s.nextInt();
                        list = alt.listIterator();
                        while(list.hasNext()){
                            Task t = (Task)list.next();
                            if(t.taskNumber == taskNumber){
                                list.remove();
                                found = true;
                            }

                        }
                        //azuriranje fajla o tome da smo neke stavke izbrisali iz liste
                        if(found){
                            out = new ObjectOutputStream(new FileOutputStream(file));
                            out.writeObject(alt);
                            out.close();

                            System.out.println("Record Deleted Successfully! ");
                        }
                    }else System.out.println("Record Not Found");
                    break;

                case 4:
                    if(file.isFile()){
                        oin = new ObjectInputStream(new FileInputStream(file));
                        alt = (ArrayList<Task>) oin.readObject();
                        oin.close();

                        boolean found = false;

                        System.out.println("Enter the ordinal number of task: ");
                        int taskNumber = s.nextInt();

                        System.out.println("CHECK OR UNCHECK: ");
                        String optionCheck = s1.next();

                        list = alt.listIterator();
                        while(list.hasNext()){
                            Task t = (Task)list.next();
                            if(t.taskNumber == taskNumber){
                                t.optionChecked = optionCheck;
                                found = true;
                            }

                        }
                        //azuriranje fajla o tome da smo neke stavke izbrisali iz liste
                        if(found){
                            out = new ObjectOutputStream(new FileOutputStream(file));
                            out.writeObject(alt);
                            out.close();

                            System.out.println("Task is Checked Successfully! ");
                        }
                    }else System.out.println("Record Not Found");
                    break;

                    }

            }
        }
    }
    