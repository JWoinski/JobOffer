import java.util.Arrays;

public class JobApplication {
    String name;
    String city;
    String email;
    String[] skills;
    int phoneNumber, salary, experience;
    boolean relocationReady;

    JobApplication(String name, String city, String email, String[] skills, int phoneNumber, int salary, int experience, boolean relocationReady) {
        this.name = name;
        this.city = city;
        this.email = email;
        this.skills = skills;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.experience = experience;
        this.relocationReady = relocationReady;
    }
    public String toString() {
        return getClass().getName() +" Name: "+name + " Email: "+email+" City: " + city + " Salary: " + salary + " Skills: " + Arrays.toString(skills) + " Experience: " + experience + "\n";
    }
}
