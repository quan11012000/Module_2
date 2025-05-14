package ss5_accsess_modifier.bai_tap.studentAccess;

public class Student {
    private String name;
    private String classes;
    public Student(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
    public void displayStudent(){
        System.out.printf("is Name %s | is class %s  ",name,classes);
    }
}
