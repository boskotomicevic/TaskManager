package org.TaskManager;

import java.io.Serializable;

public class Task implements Serializable {
    private String taskName;
    private double taskLenght;
    int taskNumber;
    String optionChecked = null;

    Task(String taskName, double taskLenght, int taskNumber){
        setTaskName(taskName);
        setTaskLenght(taskLenght);
        setTaskNumber(taskNumber);
    }
    /*Task(String taskName, double taskLenght, int taskNumber,String optionChecked){
        setTaskName(taskName);
        setTaskLenght(taskLenght);
        setTaskNumber(taskNumber);
        setOptionChecked(optionChecked);
    }*/
    Task(String optionChecked) {
        setOptionChecked(optionChecked);
    }


    public void setTaskName(String taskName){this.taskName  = taskName;}
    public String getTaskName(){return taskName;}

    public void setTaskLenght(double taskLenght){this.taskLenght = taskLenght;}
    public double getTaskLenght(){return taskLenght;}

    public void setTaskNumber(int taskNumber){this.taskNumber = taskNumber;}
    public int getTaskNumber(){return taskNumber;}

    public void setOptionChecked(String optionChecked){this.optionChecked = optionChecked;}
    public String getOptionChecked(){return optionChecked;}
    @Override
    public String toString(){
        return taskNumber + " "+ "|Task name: "+taskName+"|"+" "+"|Lenght of the task: "+ taskLenght+" "+"hours|"+" "+ "|"+optionChecked+"|";
    }

}
