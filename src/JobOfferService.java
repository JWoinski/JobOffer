import java.util.List;
import java.util.Map;

public class JobOfferService {


    public Map<String, Long> getCitiesCount(List<JobApplication> jobApplications) {
        //    zlicza ilośc wystąpnien miast, np (krakow : 5, warszawa : 10, rzeszow 2, itp)

    }


    public Map<String, Long> getEmailsCount(List<JobApplication> jobApplications) {
//        zlicza ilosc wystapien kazdego z maili, np (test@test.pl : 2, itp)
    }


    public String getMostFreqSkill(List<JobApplication> jobApplications) {
        //    znajdz najczessciej wystepujacy skill

    }


    public List<JobApplication> validate(List<JobApplication> jobApplications) {
        //    znajdz oferty błędne, błędne czyli takie ktore:
//    z jednego maila dostaliśmy dwie aploikacje z tym samym imieniem. Czyli z jednego maila moze przyjsc kilka roznych ofert,
//    ale jezeli przyjdzie wiecej niz jedna z tym samym imieniem to jest to bledna apliakcja
    }

}
