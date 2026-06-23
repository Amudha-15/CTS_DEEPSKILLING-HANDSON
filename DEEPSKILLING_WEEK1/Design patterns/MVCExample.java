class Student {
    private String name; private int id; private double grade;
    public Student(int id, String name, double grade){ this.id=id; this.name=name; this.grade=grade; }
    public String getName(){return name;} public int getId(){return id;} public double getGrade(){return grade;}
    public void setGrade(double g){ this.grade = g; }
}

class StudentView {
    public void displayStudentDetails(Student s){
        System.out.println("Student: " + s.getId() + " " + s.getName() + " grade=" + s.getGrade());
    }
}

class StudentController {
    private final Student model; private final StudentView view;
    public StudentController(Student m, StudentView v){ model=m; view=v; }
    public void setGrade(double g){ model.setGrade(g); }
    public void updateView(){ view.displayStudentDetails(model); }
}

public class MVCExample {
    public static void main(String[] args){
        Student s = new Student(1, "Alice", 90.0);
        StudentView v = new StudentView();
        StudentController c = new StudentController(s, v);
        c.updateView();
        c.setGrade(95.0);
        c.updateView();
    }
}
