import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.stream.Collectors.groupingBy;

public class JobApplicationService {

    public static Map<String, Long> getCitiesCount(List<JobApplication> jobApplications) {
        return jobApplications.stream().map(JobApplication::getCity).collect(groupingBy(Function.identity(), Collectors.counting()));
    }

    public static Map<String, Long> getEmailsCount(List<JobApplication> jobApplications) {
        return jobApplications.stream().map(JobApplication::getEmail).collect(groupingBy(Function.identity(), Collectors.counting()));

    }

    public static String getMostFreqSkill(List<JobApplication> jobApplications) {
        return jobApplications.stream()
                .flatMap(a -> Arrays.stream(a.getSkills()))
                .collect(groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse(null)
                .toString();
    }

    public static List<JobApplication> validate(List<JobApplication> jobApplications) {
        //    znajdz oferty błędne, błędne czyli takie ktore:
//    z jednego maila dostaliśmy dwie aploikacje z tym samym imieniem. Czyli z jednego maila moze przyjsc kilka roznych ofert,
//    ale jezeli przyjdzie wiecej niz jedna z tym samym imieniem to jest to bledna apliakcja
        return getDuplicatesMap(jobApplications).values().stream()
                .filter(duplicates -> duplicates.size() > 1)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
    private static Map<String, List<JobApplication>> getDuplicatesMap(List<JobApplication> personList) {
        return personList.stream().collect(groupingBy(JobApplication::uniqueAttributes));
    }
}


