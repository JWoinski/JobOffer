import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobOfferService extends JobOffer {

    JobOfferService(String city, int offeredSalary, String[] skills, int experience) {
        super(city, offeredSalary, skills, experience);
    }

    // ZAPYTAC O STATIC !
    public static JobOffer getBiggestSalary(List<JobOffer> jobOffers) {
        int biggestSalary = Integer.MIN_VALUE;
        JobOffer biggestSalaryOffer = null;
        for (JobOffer offer : jobOffers) {
            if (offer.offeredSalary > biggestSalary) {
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
            if ((offer.city).equals(city)) {
                counter++;
            }
        }
        return counter;
    }

    public static List<String> getCitiesSet(List<JobOffer> jobOffers) {
        //    znajduje wszystkie miasta z ofert (różne, czyli maja sie nie powtarzac)
        List<String> list = new ArrayList<>();
        for (JobOffer offer : jobOffers) {
            if (!list.contains(offer.city)) {
                list.add(offer.city);
            }
        }
        return list;
    }

    public static double getAverageMinExp(List<JobOffer> jobOffers) {
        double temp = 0;
        for (JobOffer offer : jobOffers) {
            temp += offer.experience;
        }
        //    znajduje srednie minimalne doswiadczenie z ofert z listy
        return temp / jobOffers.size();
    }

    public static String getMostPopularSkill(List<JobOffer> jobOffers) {
        List<String> list = new ArrayList<>();
        for (JobOffer offer : jobOffers) {
            list.addAll(Arrays.asList(offer.skills));
        }

        int frequence = 0;
        String res = "";
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).equals(list.get(i))) {
                    count++;
                }
            }
            if (count >= frequence) {
                res = list.get(i);
                frequence = count;
            }
        }
        return res;
    }

    public static JobApplication getBestApplication(JobOffer jobOffer, List<JobApplication> jobApplications) {
        //    (znajdz z listy aplikacji o prace NAJLEPSZA dla danej oferty)
        int score;
        List<Integer> list = new ArrayList<>();
        for (JobApplication application : jobApplications) {
            score = 0;
            if ((jobOffer.city).equals(application.city)) {
                score++;
            }
            if (jobOffer.experience >= application.experience) {
                score++;
            }
            if (jobOffer.offeredSalary <= application.salary) {
                score++;
            }
            if (Arrays.asList(sortSkills(jobOffer.skills)).containsAll(Arrays.asList(sortSkills(application.skills)))) {
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

