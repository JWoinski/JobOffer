public class JobOffer {
    String city, offeredJob, skills[];
    int experience;

    JobOffer(String city, String offeredJob, String[] skills, int experience) {
        this.city = city;
        this.offeredJob = offeredJob;
        this.skills = skills;
        this.experience = experience;
    }
}