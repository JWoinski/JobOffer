import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JobApplicationService {

    public static Map<String, Long> getCitiesCount(List<JobApplication> jobApplications) {
        //    zlicza ilośc wystąpnien miast, np (krakow : 5, warszawa : 10, rzeszow 2, itp)
        List<String> cities = new ArrayList<>();
        for (JobApplication item : jobApplications) {
            cities.add(item.getCity());
        }
        return cities.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static Map<String, Long> getEmailsCount(List<JobApplication> jobApplications) {
//        zlicza ilosc wystapien kazdego z maili, np (test@test.pl : 2, itp)
        List<String> emails = new ArrayList<>();
        for (JobApplication item : jobApplications) {
            emails.add(item.getEmail());
        }
        return emails.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static String getMostFreqSkill(List<JobApplication> jobApplications) {
        //    znajdz najczessciej wystepujacy skill
        Map<String, Integer> skillsMap = new HashMap<>();
        int i =0;
        for (JobApplication jobApplication : jobApplications) {
            for (String skill : jobApplication.getSkills()) {
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
        assert maxEntry != null;
        return maxEntry.getKey();
    }

    public static List<JobApplication> validate(List<JobApplication> jobApplications) {
        //    znajdz oferty błędne, błędne czyli takie ktore:
//    z jednego maila dostaliśmy dwie aploikacje z tym samym imieniem. Czyli z jednego maila moze przyjsc kilka roznych ofert,
//    ale jezeli przyjdzie wiecej niz jedna z tym samym imieniem to jest to bledna apliakcja
        List<JobApplication> incrorectApplications = new ArrayList<>();
        for (int i = 0; i < jobApplications.size(); i++) {
            for (int j = i + 1; j < jobApplications.size(); j++) {
                if ((jobApplications.get(i).getName()).equals(jobApplications.get(j).getName()) || (jobApplications.get(i).getEmail().equals(jobApplications.get(j).getEmail()))) {
                    incrorectApplications.add(jobApplications.get(i));
                    incrorectApplications.add(jobApplications.get(j));
                }
            }
        }
        return incrorectApplications;
    }
}


