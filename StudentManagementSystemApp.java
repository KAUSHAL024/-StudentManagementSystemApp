import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
class Student{
    private String name;
    private int rollNumber;
    private String grade;
    public Student(String name,int rollNumber,String grade) {
        this.name=name;
        this.rollNumber=rollNumber;
        this.grade=grade;
    }
    public String getName(){
        return name;
    }
    public int getRollNumber(){
        return rollNumber;
    }
    public String getGrade(){
        return grade;
    }
    @Override
    public String toString(){
        return "name: "+ name +", RollNumber : "+ rollNumber +", Grade: "+grade;
        
    }
}
    class StudentManagementSystem{
        private List<Student> students =new ArrayList();
        public void addStudent(Student student){
            students.add(student);
        }
        public void removeStudent(Student student){
            students.remove(student);
        }
        public List<Student> searchStudent(String keyword){
            List<Student> result= new ArrayList<>();
            for(Student student:students){
                if(student.getName().contains(keyword) || Integer.toString(student.getRollNumber()).contains(keyword)||student.getGrade().contains(keyword)){
                result.add(student);
                }
                
        }
        return result;
        
    }
    public void displayAllStudent(){
        for(Student student: students){
            System.out.println(student);
            
        }
    }
    }
    public class StudentManagementSystemApp{
        public static void main(String[]args){
            StudentManagementSystem sms= new StudentManagementSystem();
            Scanner kb=new Scanner(System.in);
            while(true){
                System.out.println("Student Management System Menu:");
                System.out.println("1. Add a new Student");
                System.out.println("2. Remove a Student");
                System.out.println("1. Add a new Student");
                System.out.println("3. Search for a Student");
                System.out.println("4. Display all  Student");;
                System.out.println("5. Exit");
                System.out.println("Enter your choice: ");
                int choice=kb.nextInt();
                kb.nextLine();
                switch(choice){
                    case 1:
                        System.out.println("Enter name: ");
                        String name=kb.nextLine();
                        System.out.println("Enter  roll number");
                        int rollNumber=kb.nextInt();
                        kb.nextLine();
                        System.out.println("Enter a grade");
                        String grade=kb.nextLine();
                        Student newStudent= new Student(name,rollNumber,grade);
                        sms.addStudent(newStudent);
                        break;
                     case 2:
                          System.out.println("Enter the Roll number OR Name of the student to remove");
                          String removeKeyword=kb.nextLine();
                           List<Student> studentToRemove =sms.searchStudent(removeKeyword);
                             if(!studentToRemove.isEmpty()){
                                 for(Student student : studentToRemove){
                                     sms.removeStudent(student);
                                     System.out.println("Remove: "+ student);
                                     
                                 }
                             }
                             else{
                                 System.out.println("Student not found.");
                             }
                             break;
                        case 3:
                                 System.out.println("enter the Seach keyword: ");
                                 String searchKeyword=kb.nextLine();
                                 List<Student> searchResult=sms.searchStudent(searchKeyword);
                                 if(!searchResult.isEmpty()){
                                     System.out.println("Search Result: ");
                                     for(Student student: searchResult){
                                         System.out.println(student);
                                     }
                                 }
                                 else{
                                     System.out.println("no matching student found.");
                                 }
                                 break;
                        case 4:
                                     System.out.println("All Student: ");
                                     sms.displayAllStudent();
                                     break;
                        case 5:
                                  System.out.println(" THANK YOU! Exiting Student Management System.");
                                  kb.close();
                                System.exit(0);
                                default:
                                 System.out.println("Invalid choice . please enter a valid option. ");
                                break;
                                 
                }
            
            }
        }
    }