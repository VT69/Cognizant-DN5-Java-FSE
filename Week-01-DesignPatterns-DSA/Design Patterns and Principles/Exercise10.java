public class Student {
    private String name;
    private String grade;
    private long id;

    public Student(long id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

class StudentView {
    public void displayStudentDetails(long id, String name, String grade) {
        System.out.println("Student Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
        System.out.println("-------------------------");
    }
}

class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    public String getStudentGrade() {
        return model.getGrade();
    }

    public void setStudentId(long id) {
        model.setId(id);
    }

    public long getStudentId() {
        return model.getId();
    }

    public void updateView() {
        view.displayStudentDetails(model.getId(), model.getName(), model.getGrade());
    }
}

class MVCPatternDemo {
    public static void main(String[] args) {
        
        Student model = new Student(101L, "John Doe", "A");

        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        System.out.println("--- Initial Details ---");
        controller.updateView();

        System.out.println("--- Updating Details... ---");
        
        controller.setStudentName("John Smith");
        controller.setStudentGrade("A+");

        controller.updateView();
    }
}