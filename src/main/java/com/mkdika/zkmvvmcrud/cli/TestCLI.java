package com.mkdika.zkmvvmcrud.cli;

import com.mkdika.zkmvvmcrud.config.SpringConfig;
import com.mkdika.zkmvvmcrud.entity.TbExperience;
import com.mkdika.zkmvvmcrud.entity.TbPerson;
import com.mkdika.zkmvvmcrud.repository.ServiceRepository;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 *
 * For testing middle ware (Business Layer) purpose.
 */
public class TestCLI {

    private static final String[] PERSON_NAME = {"Maikel Chandika", "Budi Gunawan", "Jacky Cheung", "Albert Einstin", "Jackson Lee",
        "Sher Jo", "Steve Vai", "Joe Satriani", "Joseph Ray", "Justin Bibir", "Steve Jobs",
        "James Gosling", "Zulfian Kamal", "Darwin Wong", "Otto Motoo", "Peter Lim", "Cornelius Brutos",
        "Daniel Mars", "Fernandes Gaul"};
    private static final int TOTAL_DETAIL = 50;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        ServiceRepository svc = ctx.getBean(ServiceRepository.class);

        for (String s : PERSON_NAME) {
            TbPerson p = new TbPerson();
            p.setFirstname(s.split(" ")[0]);
            p.setLastname(s.split(" ")[1]);
            p.setGender(1);
            p.setBirthday(createDate(ranInt(1, 28), ranInt(1, 12), ranInt(50, 116)));
            p.setIdtype(0);
            p.setIdnumber("12312312312");
            p.setPhonenumber("08119892312");
            p.setEmail(s.split(" ")[0] + "@gmail.com");
            p.setAddress("Jl.Bunga Melati no.123, Jakarta Utara, Indonesia");
            p.setExperiences(new ArrayList<TbExperience>());

            for (int i = 0; i < TOTAL_DETAIL; i++) {
                TbExperience te = new TbExperience();
                te.setPerson(p);
                te.setCompanyname("Company-" + (i + 1));
                te.setCompanysector((i % 5));
                te.setPosition("Position-" + (i + 1));
                te.setDtfrom(new Date());
                te.setDtto(new Date());
                te.setLeavingreason("The Reason is out there.");
                p.getExperiences().add(te);
            }

            try {
                svc.save(p);
                System.out.println("Save Successful! " + s);
            } catch (javax.persistence.RollbackException e) {
                System.out.println("Save Failed!\n" + e.getLocalizedMessage());
            }
        }
    }

    private static Date createDate(int d, int m, int y) {
        Date dt = new Date();
        dt.setDate(d);
        dt.setMonth((m - 1));
        dt.setYear((y + 1900));
        dt.setHours(0);
        dt.setMinutes(0);
        dt.setSeconds(0);
        return dt;
    }

    public static int ranInt(int Min, int Max) {
        return (int) (Math.random() * (Max - Min)) + Min;
    }
}
