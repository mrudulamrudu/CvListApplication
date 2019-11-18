package com.cv.cvlistapplication.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CvTest {

    private static final String TENURE_1 = "Jan 2015 - Feb 2018";
    private static final String TENURE_2 = "March 2018 - July 2019";

    /*
      Test two equal cvs
    */
    @Test
    public void cv_testEqualCompanies_returnsTrue() throws Exception {

        ArrayList<String> responsibilities = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> achievements = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> profSummary = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> techSkills = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        Company company1 = new Company("Company", "Logo", "Role 1",
                TENURE_1, "location", responsibilities, achievements);
        Company company2 = new Company("Company", "Logo", "Role 1",
                TENURE_1, "location", responsibilities, achievements);


        ArrayList<Company> companies = new ArrayList<>();
        companies.add(company1);
        companies.add(company2);

        Cv cv1 = new Cv("Mrudula", "mrudula@gmail.com", "+1 4328787w6767", "linked in",
                profSummary, techSkills, companies);
        Cv cv2 = new Cv("Mrudula", "mrudula@gmail.com", "+1 4328787w6767", "linked in",
                profSummary, techSkills, companies);

        assertEquals(cv1, cv2);
    }

    /*
     Test two  cvs  - diff names
   */
    @Test
    public void cv_testDiffCompaniesWithDiffNames_returnsFalse() throws Exception {

        ArrayList<String> responsibilities = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> achievements = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> profSummary = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> techSkills = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        Company company1 = new Company("Company", "Logo", "Role 1",
                TENURE_1, "location", responsibilities, achievements);
        Company company2 = new Company("Company", "Logo", "Role 1",
                TENURE_1, "location", responsibilities, achievements);


        ArrayList<Company> companies = new ArrayList<>();
        companies.add(company1);
        companies.add(company2);

        Cv cv1 = new Cv("Mrudula", "mrudula@gmail.com", "+1 4328787w6767", "linked in",
                profSummary, techSkills, companies);
        Cv cv2 = new Cv("Hello", "mrudula@gmail.com", "+1 4328787w6767", "linked in",
                profSummary, techSkills, companies);

        assertNotEquals(cv1, cv2);
    }


    /*
    Test two  cvs  - diff emails
  */
    @Test
    public void cv_testDiffCompaniesWithDiffEmails_returnsFalse() throws Exception {

        ArrayList<String> responsibilities = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> achievements = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> profSummary = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> techSkills = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        Company company1 = new Company("Company", "Logo", "Role 1",
                TENURE_1, "location", responsibilities, achievements);
        Company company2 = new Company("Company", "Logo", "Role 1",
                TENURE_1, "location", responsibilities, achievements);


        ArrayList<Company> companies = new ArrayList<>();
        companies.add(company1);
        companies.add(company2);

        Cv cv1 = new Cv("Mrudula", "mrudula@gmail.com", "+1 4328787w6767", "linked in",
                profSummary, techSkills, companies);
        Cv cv2 = new Cv("Hello", "xxx@gmail.com", "+1 4328787w6767", "linked in",
                profSummary, techSkills, companies);

        assertNotEquals(cv1, cv2);
    }

    /*
    Test two  cvs  - diff phones
  */
    @Test
    public void cv_testDiffCompaniesWithDiffPhones_returnsFalse() throws Exception {

        ArrayList<String> responsibilities = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> achievements = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> profSummary = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> techSkills = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        Company company1 = new Company("Company", "Logo", "Role 1",
                TENURE_1, "location", responsibilities, achievements);
        Company company2 = new Company("Company", "Logo", "Role 1",
                TENURE_1, "location", responsibilities, achievements);


        ArrayList<Company> companies = new ArrayList<>();
        companies.add(company1);
        companies.add(company2);

        Cv cv1 = new Cv("Mrudula", "mrudula@gmail.com", "+1 4328787w6767", "linked in",
                profSummary, techSkills, companies);
        Cv cv2 = new Cv("Hello", "mrudula@gmail.com", "+1 77665454345", "linked in",
                profSummary, techSkills, companies);

        assertNotEquals(cv1, cv2);
    }

    /*
    Test two  cvs  - diff linked in
  */
    @Test
    public void cv_testDiffCompaniesWithDiffTenures_returnsFalse() throws Exception {

        ArrayList<String> responsibilities = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> achievements = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> profSummary = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> techSkills = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        Company company1 = new Company("Company", "Logo", "Role 1",
                TENURE_1, "location", responsibilities, achievements);
        Company company2 = new Company("Company", "Logo", "Role 1",
                TENURE_1, "location", responsibilities, achievements);


        ArrayList<Company> companies = new ArrayList<>();
        companies.add(company1);
        companies.add(company2);

        Cv cv1 = new Cv("Mrudula", "mrudula@gmail.com", "+1 4328787w6767", "linked in",
                profSummary, techSkills, companies);
        Cv cv2 = new Cv("Hello", "mrudula@gmail.com", "+1 4328787w6767", "asdjhdhghsgd in",
                profSummary, techSkills, companies);

        assertNotEquals(cv1, cv2);
    }

    /*
    Test two  cvs  - diff profsummary
  */
    @Test
    public void cv_testDiffCompaniesWithDiffProfSummary_returnsFalse() throws Exception {

        ArrayList<String> responsibilities = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> achievements = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> profSummary = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> profSummary2 = new ArrayList<>();
        responsibilities.add("four");
        responsibilities.add("five");
        responsibilities.add("six");

        ArrayList<String> techSkills = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        Company company1 = new Company("Company", "Logo", "Role 1",
                TENURE_1, "location", responsibilities, achievements);
        Company company2 = new Company("Company", "Logo", "Role 1",
                TENURE_1, "location", responsibilities, achievements);


        ArrayList<Company> companies = new ArrayList<>();
        companies.add(company1);
        companies.add(company2);

        Cv cv1 = new Cv("Mrudula", "mrudula@gmail.com", "+1 4328787w6767", "linked in",
                profSummary, techSkills, companies);
        Cv cv2 = new Cv("Hello", "mrudula@gmail.com", "+1 4328787w6767", "linked in",
                profSummary2, techSkills, companies);

        assertNotEquals(cv1, cv2);
    }

    /*
 Test two  cvs  - diff profsummary
*/
    @Test
    public void cv_testDiffCompaniesWithDiffTechSkills_returnsFalse() throws Exception {

        ArrayList<String> responsibilities = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> achievements = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> profSummary = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> techSkills = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> techSkills2 = new ArrayList<>();
        responsibilities.add("four");
        responsibilities.add("five");
        responsibilities.add("six");

        Company company1 = new Company("Company", "Logo", "Role 1",
                TENURE_1, "location", responsibilities, achievements);
        Company company2 = new Company("Company", "Logo", "Role 1",
                TENURE_1, "location", responsibilities, achievements);


        ArrayList<Company> companies = new ArrayList<>();
        companies.add(company1);
        companies.add(company2);

        Cv cv1 = new Cv("Mrudula", "mrudula@gmail.com", "+1 4328787w6767", "linked in",
                profSummary, techSkills, companies);
        Cv cv2 = new Cv("Hello", "mrudula@gmail.com", "+1 4328787w6767", "linked in",
                profSummary, techSkills2, companies);

        assertNotEquals(cv1, cv2);
    }


}

