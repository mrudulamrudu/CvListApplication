package com.cv.cvlistapplication.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CompanyTest {

    private static final String TENURE_1 = "Jan 2015 - Feb 2018";
    private static final String TENURE_2 = "March 2018 - July 2019";

    /*
       Test two equal companies
     */
    @Test
    public void company_testEqualCompanies_returnsTrue() throws Exception {

        ArrayList<String> responsibilities = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> achievements = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        Company company1 = new Company("Company", "Logo", "Role 1",
                TENURE_1, "location", responsibilities, achievements);
        Company company2 = new Company("Company", "Logo", "Role 1",
                TENURE_1, "location", responsibilities, achievements);

        assertEquals(company1, company2);
    }

    /*
      Test companies with different names
    */
    @Test
    public void company_testCompaniesWithDifNames_returnsFalse() throws Exception {
        ArrayList<String> responsibilities = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> achievements = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        Company company1 = new Company("Company", "Logo", "Role 1",
                TENURE_1, "location", responsibilities, achievements);
        Company company2 = new Company("Company two", "Logo", "Role 1",
                TENURE_1, "location", responsibilities, achievements);

        assertNotEquals(company1, company2);
    }

    /*
      Test companies with different logos
    */
    @Test
    public void company_testCompaniesWithDifLogos_returnsFalse() throws Exception {
        ArrayList<String> responsibilities = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> achievements = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        Company company1 = new Company("Company", "Logo", "Role 1",
                TENURE_1, "location", responsibilities, achievements);
        Company company2 = new Company("Company", "Logo two", "Role 1",
                TENURE_1, "location", responsibilities, achievements);

        assertNotEquals(company1, company2);
    }

    /*
    Test companies with different tenures
  */
    @Test
    public void company_testCompaniesWithDifRoles_returnsFalse() throws Exception {
        ArrayList<String> responsibilities = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> achievements = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        Company company1 = new Company("Company", "Logo", "Role 1",
                TENURE_1, "location", responsibilities, achievements);
        Company company2 = new Company("Company", "Logo", "Role 2",
                TENURE_1, "location", responsibilities, achievements);

        assertNotEquals(company1, company2);
    }

    /*
      Test companies with different locations
    */
    @Test
    public void company_testCompaniesWithDifTenures_returnsFalse() throws Exception {
        ArrayList<String> responsibilities = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> achievements = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        Company company1 = new Company("Company", "Logo", "Role 1",
                TENURE_1, "location", responsibilities, achievements);
        Company company2 = new Company("Company", "Logo", "Role 2",
                TENURE_2, "location", responsibilities, achievements);

        assertNotEquals(company1, company2);
    }

    /*
      Test companies with different names
    */
    @Test
    public void company_testCompaniesWithDifLocations_returnsFalse() throws Exception {
        ArrayList<String> responsibilities = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> achievements = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        Company company1 = new Company("Company", "Logo", "Role 1",
                TENURE_1, "location", responsibilities, achievements);
        Company company2 = new Company("Company two", "Logo", "Role 1",
                TENURE_1, "location 2", responsibilities, achievements);

        assertNotEquals(company1, company2);
    }

    /*
      Test companies with different names
    */
    @Test
    public void company_testCompaniesWithDifNResponsibilities_returnsFalse() throws Exception {
        ArrayList<String> responsibilities = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> responsibilities_2 = new ArrayList<>();
        responsibilities.add("Seven");
        responsibilities.add("Six");
        responsibilities.add("Fours");

        ArrayList<String> achievements = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        Company company1 = new Company("Company", "Logo", "Role 1",
                TENURE_1, "location", responsibilities, achievements);
        Company company2 = new Company("Company two", "Logo", "Role 1",
                TENURE_1, "location", responsibilities_2, achievements);

        assertNotEquals(company1, company2);
    }

    /*
      Test companies with different achievements
    */
    @Test
    public void company_testCompaniesWithDifAchievements_returnsFalse() throws Exception {
        ArrayList<String> responsibilities = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> achievements = new ArrayList<>();
        responsibilities.add("One");
        responsibilities.add("Two");
        responsibilities.add("Three");

        ArrayList<String> achievements_2 = new ArrayList<>();
        responsibilities.add("six");
        responsibilities.add("seven");
        responsibilities.add("Five");

        Company company1 = new Company("Company", "Logo", "Role 1",
                TENURE_1, "location", responsibilities, achievements);
        Company company2 = new Company("Company two", "Logo", "Role 1",
                TENURE_1, "location", responsibilities, achievements_2);

        assertNotEquals(company1, company2);
    }


}