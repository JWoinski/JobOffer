import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JobApplicationService extends JobApplication {
    JobApplicationService(String name, String city, String email, String[] skills, int phoneNumber, int salary, int experience, boolean relocationReady) {
        super(name, city, email, skills, phoneNumber, salary, experience, relocationReady);
    }


    public static Map<String, Long> getCitiesCount(List<JobApplication> jobApplications) {
        //    zlicza ilośc wystąpnien miast, np (krakow : 5, warszawa : 10, rzeszow 2, itp)
        List<String> cities = new ArrayList<>();
        for (JobApplication item : jobApplications) {
            cities.add(item.city);
        }
        return cities.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }


    public static Map<String, Long> getEmailsCount(List<JobApplication> jobApplications) {
//        zlicza ilosc wystapien kazdego z maili, np (test@test.pl : 2, itp)
        List<String> emails = new ArrayList<>();
        for (JobApplication item : jobApplications) {
            emails.add(item.email);
        }
        return emails.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }


    public static String getMostFreqSkill(List<JobApplication> jobApplications) {
        //    znajdz najczessciej wystepujacy skill
        List<String> list = new ArrayList<>();
        for (JobApplication offer : jobApplications) {
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


    public static List<JobApplication> validate(List<JobApplication> jobApplications) {
        //    znajdz oferty błędne, błędne czyli takie ktore:
//    z jednego maila dostaliśmy dwie aploikacje z tym samym imieniem. Czyli z jednego maila moze przyjsc kilka roznych ofert,
//    ale jezeli przyjdzie wiecej niz jedna z tym samym imieniem to jest to bledna apliakcja
        List<JobApplication> incrorectApplications = new ArrayList<>();

        for (int i = 0; i < jobApplications.size(); i++) {
            for (int j = i + 1; j < jobApplications.size(); j++) {
                if (jobApplications.get(i).name.equals(jobApplications.get(j).name)) {
                    //now we got duplicated one element and checking second element
                    if (jobApplications.get(i).email.equals(jobApplications.get(j).email)) {
                        incrorectApplications.add(jobApplications.get(i));
                        incrorectApplications.add(jobApplications.get(j));
                    }
                }
            }
        }
        return incrorectApplications;

    }
}


