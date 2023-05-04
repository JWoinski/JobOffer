import java.util.Arrays;

public class JobApplication {
    private String name;
    private String city;
    private String email;
    private String[] skills;
    private int phoneNumber, salary, experience;
    private boolean relocationReady;

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

    String getName() {
        return this.name;
    }

    String getCity() {
        return this.city;
    }

    String getEmail() {
        return this.email;
    }

    String[] getSkills() {
        return this.skills;
    }

    int getPhoneNumber() {
        return this.phoneNumber;
    }

    int getSalary() {
        return this.salary;
    }

    int getExperience() {
        return this.experience;
    }

    boolean getRelocationReady() {
        return this.relocationReady;
    }

    public String toString() {
        return getClass().getName() + " Name: " + name + " Email: " + email + " City: " + city + " Salary: " + salary + " Skills: " + Arrays.toString(skills) + " Experience: " + experience + "\n";
    }
}
