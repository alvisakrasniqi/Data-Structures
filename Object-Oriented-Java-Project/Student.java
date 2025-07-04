
import java.util.ArrayList;

public class Student {

    private String name;
    private String studentID;
    private ArrayList<Integer> grades;

    //constructor to intialize student name and id
    public Student(String name, String studentID){
        this.name = name;
        this.studentID = studentID;
        this.grades = new ArrayList<>();
    }


    //method to addd a grade
    public void addGrade(int grade){
        grades.add(grade);
        System.out.println("the grade added is " + grade);
    }


    //method to get the avergae grade
    public double getAverageGrade(){
        
        if(grades.isEmpty()){
            System.out.println("no grades to compute");
            return -1;
        }
        
        int sum = 0;
        //for loop to add a grade to the sum 
        for( int i=0; i< grades.size(); i++){
            sum = sum + grades.get(i); 
        }

        return(double) sum/ grades.size(); // returns the caluclated grade average
      
    }

    public static void main(String[] args) {
        
        Student student1 = new Student("Alvisa Krasniqi", "383939");

        student1.addGrade(93);
        student1.addGrade(90);
        student1.addGrade(70);
        student1.addGrade(60);
        student1.addGrade(59);


        double average = student1.getAverageGrade();
        System.out.println("the average grade is: " + average);


    }

}