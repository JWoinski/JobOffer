import java.util.*;
import java.util.stream.Collectors;

public class JobOfferService {

    public static JobOffer getBiggestSalary(List<JobOffer> jobOffers) {
        JobOffer biggestSalaryOffer = null;
        for (JobOffer offer : jobOffers) {
            if (biggestSalaryOffer == null || offer.getOfferedSalary() > biggestSalaryOffer.getOfferedSalary()) {
                biggestSalaryOffer = offer;
            }
        }
        return biggestSalaryOffer;
        //        znajduje z listy oferte o najwyzsazej pensji
    }

    public static long countInCity(List<JobOffer> jobOffers, String city) {
        //    liczy ile jest ofert z danego miasta (city)
        long counter = 0;
        for (JobOffer offer : jobOffers) {
            if ((offer.getCity()).equals(city)) {
                counter++;
            }
        }
        return counter;
    }

    public static Set<String> getCitiesSet(List<JobOffer> jobOffers) {
        //    znajduje wszystkie miasta z ofert (różne, czyli maja sie nie powtarzac)
        return jobOffers.stream().map(JobOffer::getCity).collect(Collectors.toSet());
    }

    public static double getAverageMinExp(List<JobOffer> jobOffers) {
        //    znajduje srednie minimalne doswiadczenie z ofert z listy
        double temp = 0;
        for (JobOffer offer : jobOffers) {
            temp += offer.getExperience();
        }
        return temp / jobOffers.size();
    }

    public static String getMostPopularSkill(List<JobOffer> jobOffers) {
        Map<String, Integer> skillsMap = new HashMap<>();
        int i =0;
        for (JobOffer jobOffer : jobOffers) {
            for (String skill : jobOffer.getSkills()) {
                skillsMap.put(skill,i);
                i++;
            }
        }
        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : skillsMap.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
    }


    public static JobApplication getBestApplication(JobOffer jobOffer, List<JobApplication> jobApplications) {
        //    (znajdz z listy aplikacji o prace NAJLEPSZA dla danej oferty

        //TODO finish getBestApplication
        // odrzucamy niepasuajce aplikacje !DONE!
        // szukamy najlepszej, czyli tkaiej ktora:
        // ma wiecej pasujacych skilli, ma wiecej expa, chce mniej siana, rzut mooneta
        jobApplications.removeIf(jobApplication -> jobApplication.getRelocationReady() == false && (!jobApplication.getCity().equals(jobOffer.getCity())));
        int score;
        List<Integer> list = new ArrayList<>();
        for (JobApplication application : jobApplications) {
            score = 0;

            if (jobOffer.getExperience() >= application.getExperience()) {
                score++;
            }
            if (jobOffer.getOfferedSalary() <= application.getSalary()) {
                score++;
            }
            if (new HashSet<>(Arrays.asList(sortSkills(jobOffer.getSkills()))).containsAll(Arrays.asList(sortSkills(application.getSkills())))) {
                score++;
            }
            list.add(score);
        }
        Integer obj = Collections.max(list);
        int index = list.indexOf(obj);
        return jobApplications.get(index);
    }

    public static String[] sortSkills(String[] skills) {
        for (int i = 0; i < skills.length - 1; i++) {
            for (int j = i + 1; j < skills.length; j++) {
                if (skills[i].compareTo(skills[j]) > 0) {
                    String temp = skills[i];
                    skills[i] = skills[j];
                    skills[j] = temp;
                }
            }
        }
        return skills;
    }
}

