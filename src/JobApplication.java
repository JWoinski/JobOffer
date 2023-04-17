import java.util.List;
import java.util.Map;

public class JobApplication {
    String name, city, email, skills[];
    int phoneNumber, salary, experience;
    boolean relocationReady;

    public JobOffer getBiggestSalary(List<JobOffer> jobOffers) {
        //        znajduje z listy oferte o najwyzsazej pensji
    }

    public long countInCity(List<JobOffer> jobOffers, String city) {
        //    liczy ile jest ofert z danego miasta (city)

    }


    public List<String> getCitiesSet(List<JobOffer> jobOffers) {
        //    znajduje wszystkie miasta z ofert (różne, czyli maja sie nie powtarzac)

    }


    public double getAverageMinExp(List<JobOffer> jobOffers) {
        //    znajduje srednie minimalne doswiadczenie z ofert z listy

    }


    public String getMostPopularSkill(List<JobOffer> jobOffers) {
        //    znajdz najpopularniejszy skill z ofert z listy (czyli ten ktory wystepuje najczesniej)

    }


    public JobApplication getBestApplication(JobOffer jobOffer, List<JobApplication> jobApplications) {
        //    (znajdz z listy aplikacji o prace NAJLEPSZA dla danej oferty)

    }


}
