import java.util.Arrays;

public class JobOffer {
    private final String city;
    private final String[] skills;
    private final int experience;
    private final int offeredSalary;

    JobOffer(String city, int offeredSalary, String[] skills, int experience) {
        this.city = city;
        this.offeredSalary = offeredSalary;
        this.skills = skills;
        this.experience = experience;
    }

    String[] getSkills() {
        return this.skills;
    }

    int getOfferedSalary() {
        return this.offeredSalary;
    }

    String getCity() {
        return this.city;
    }

    int getExperience() {
        return this.experience;
    }

    public String toString() {
        return getClass().getName() + " City: " + city + " Offered Salary: " + offeredSalary + " Skills: " + Arrays.toString(skills) + " Experience: " + experience;
    }
}