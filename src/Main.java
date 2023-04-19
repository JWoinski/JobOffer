import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Implementation of Job Offers
        List<JobOffer> JobOffers = new ArrayList<>();
        JobOffer offer = new JobOffer("Bialystok", 5000, new String[]{"sql", "Java"}, 1);
        JobOffer offer1 = new JobOffer("Bialystok", 5000, new String[]{"Java", "sql"}, 1);
        JobOffer offer2 = new JobOffer("Warszawa", 8000, new String[]{"Java", "sql"}, 2);
        JobOffer offer3 = new JobOffer("Warszawa", 8500, new String[]{"Java", "sql"}, 2);
        JobOffer offer4 = new JobOffer("Warszawa", 8500, new String[]{"Java", "Python"}, 2);
        JobOffers.add(offer);
        JobOffers.add(offer1);
        JobOffers.add(offer2);
        JobOffers.add(offer3);
        JobOffers.add(offer4);

        //Implementation of Job Applications
        List<JobApplication> jobApplications = new ArrayList<>();
        JobApplication application = new JobApplication("Jakub", "Bialystok", "jakub.woinski@icloud.com", new String[]{"Java", "sql"}, 514305254, 5000, 2, true);
        JobApplication application1 = new JobApplication("Michal", "Warszawa", "michal@icloud.com", new String[]{"Java", "sql"}, 514305254, 6000, 2, true);
        JobApplication application2 = new JobApplication("Daniel", "Warszawa", "Daniel@icloud.com", new String[]{"Java", "sql"}, 514305254, 5000, 2, true);
        JobApplication application3 = new JobApplication("Marek", "Warszawa", "Marek@icloud.com", new String[]{"Java", "sql"}, 514305254, 5000, 2, true);
        jobApplications.add(application);
        jobApplications.add(application1);
        jobApplications.add(application2);
        jobApplications.add(application3);

        // Checking Methods
        System.out.println(JobOfferService.getBiggestSalary(JobOffers));
        System.out.println(JobOfferService.countInCity(JobOffers, "Warszawa"));
        System.out.println(JobOfferService.getAverageMinExp(JobOffers));
        System.out.println(JobOfferService.getMostPopularSkill(JobOffers));
        System.out.println(JobOfferService.getCitiesSet(JobOffers));
        System.out.println(JobOfferService.getBestApplication(offer,jobApplications));
    }
}
