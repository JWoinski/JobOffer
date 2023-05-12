import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JobOfferService {

    public static JobOffer getBiggestSalary(List<JobOffer> jobOffers) {
        return jobOffers.stream().max(Comparator.comparing(JobOffer::getOfferedSalary)).orElse(null);
    }

    public static long countInCity(List<JobOffer> jobOffers, String city) {
       return jobOffers.stream().filter(jobOffer -> jobOffer.getCity().equals(city)).count();
    }

    public static Set<String> getCitiesSet(List<JobOffer> jobOffers) {
        //    znajduje wszystkie miasta z ofert (różne, czyli maja sie nie powtarzac)
        return jobOffers.stream().map(JobOffer::getCity).collect(Collectors.toSet());
    }

    public static double getAverageMinExp(List<JobOffer> jobOffers) {
        OptionalDouble average = jobOffers.stream().mapToInt(a -> a.getExperience()).average();
        return average.isPresent() ? average.getAsDouble() : 0;
    }

    public static String getMostPopularSkill(List<JobOffer> jobOffers) {
        return jobOffers.stream()
                .flatMap(a -> Arrays.stream(a.getSkills()))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse(null)
                .toString();
    }


    public static JobApplication getBestApplication(JobOffer jobOffer, List<JobApplication> jobApplications) {
        //    (znajdz z listy aplikacji o prace NAJLEPSZA dla danej oferty

        //TODO finish getBestApplication
        // odrzucamy niepasuajce aplikacje !DONE!
        // szukamy najlepszej, czyli tkaiej ktora:
        // ma wiecej pasujacych skilli, ma wiecej expa, chce mniej siana, rzut mooneta
        return null;
    }


}

