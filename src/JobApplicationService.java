import java.util.List;

public class JobApplicationService extends JobApplication {
    JobApplicationService(String name, String city, String email, String[] skills, int phoneNumber, int salary, int experience, boolean relocationReady) {
        super(name, city, email, skills, phoneNumber, salary, experience, relocationReady);
    }


//    public Map<String, Long> getCitiesCount(List<JobApplication> jobApplications) {
//        //    zlicza ilośc wystąpnien miast, np (krakow : 5, warszawa : 10, rzeszow 2, itp)
//
//    }
//
//
//    public Map<String, Long> getEmailsCount(List<JobApplication> jobApplications) {
////        zlicza ilosc wystapien kazdego z maili, np (test@test.pl : 2, itp)
//    }
//
//
//    public String getMostFreqSkill(List<JobApplication> jobApplications) {
//        //    znajdz najczessciej wystepujacy skill
//
//    }
//
//
//    public List<JobApplication> validate(List<JobApplication> jobApplications) {
//        //    znajdz oferty błędne, błędne czyli takie ktore:
////    z jednego maila dostaliśmy dwie aploikacje z tym samym imieniem. Czyli z jednego maila moze przyjsc kilka roznych ofert,
////    ale jezeli przyjdzie wiecej niz jedna z tym samym imieniem to jest to bledna apliakcja
//    }

}
