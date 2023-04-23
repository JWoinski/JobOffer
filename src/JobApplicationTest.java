import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
public class JobApplicationTest {
    @Test
    public void shoulSayThatCityIsValid() {
        JobApplication application = new JobApplication("Jakub", "Bialystok", "jakub.woinski@icloud.com", new String[]{"Java", "sql"}, 514305254, 5000, 2, true);
        Assert.assertEquals("Bialystok", String.valueOf(application.city));
    }

    @Test
    public void getterWorks() {
        JobOffer offer = new JobOffer("Bialystok", 5000, new String[]{"sql", "Java"}, 1);
        Assert.assertEquals(5000, offer.getOfferedSalary());
    }

    @Test
    public void countingCities() {
        JobApplication application = new JobApplication("Jakub", "Bialystok", "jakub.woinski@icloud.com", new String[]{"Java", "sql"}, 514305254, 5000, 2, true);
        JobApplication application1 = new JobApplication("Michal", "Bialystok", "michal.woinski@icloud.com", new String[]{"Java", "sql"}, 514305254, 5000, 2, true);
        JobApplication application2 = new JobApplication("Piotr", "Warszawa", "piotr.woinski@icloud.com", new String[]{"Java", "sql"}, 514305254, 5000, 2, true);
        JobApplication application3 = new JobApplication("Tomek", "Warszawa", "tomek.woinski@icloud.com", new String[]{"Java", "sql"}, 514305254, 5000, 2, true);
        List<JobApplication> jobApplications = new ArrayList<>();
        jobApplications.add(application);
        jobApplications.add(application1);
        jobApplications.add(application2);
        jobApplications.add(application3);
        Assert.assertEquals("{Bialystok=2, Warszawa=2}",String.valueOf(JobApplicationService.getCitiesCount(jobApplications)));
    }
}