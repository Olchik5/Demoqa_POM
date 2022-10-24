package com.telran.tests.forms;

import com.telran.data.StudentData;
import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.forms.PracticeFormPage;
import com.telran.tests.TestBase;
import com.telran.util.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PracticeFormTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){

        new HomePage(driver).selectForms();
        new SidePanelPage(driver).selectPracticeForm();
    }

    @Test
    public void createNewStudentTest(){
       new PracticeFormPage(driver).hideIframes().enterPersonalData(StudentData.FIRST_NAME,StudentData.LAST_NAME,StudentData.EMAIL,
               StudentData.TEL_NUM);

        new PracticeFormPage(driver).selectGender(StudentData.GENDER)
                .chooseDate("May", "2000", "10")
                //.typeOfDate(StudentData.DATE)
                .addSubject(StudentData.SUBJECTS)
                .chooseHobby(StudentData.HOBBIES)
                .uploadFile(StudentData.PHOTO_PATH)
                .addAddress(StudentData.ADDRESS)
                .enterState(StudentData.STATE)
                .enterCity(StudentData.CITY).submit();
        Assert.assertTrue(new PracticeFormPage(driver).getModalTitle().contains("Thanks for submitting the form"));
        new PracticeFormPage(driver).closeModalDialog();

    }

//    @DataProvider
//    public Iterator <Object[]> addNewStudent() {
//        List<Object[]> list = new ArrayList<>();
//        list.add(new Object[]{"Nick", "Green", "nick@gmail.com", "1234567891", "Green Street 1", "male"});
//        list.add(new Object[]{"Nick", "Green", "nick+1@gmail.com", "1234567892", "Green Street 1", "male"});
//        list.add(new Object[]{"Nick", "Green", "nick+2@gmail.com", "1234567893", "Green Street 1", "male"});
//        return list.iterator();
//
//
//    }

    @Test(dataProviderClass = DataProviders.class,dataProvider = "usingFile")
    public void createNewStudentTestWithDataProviderTest(String firstName, String lastName, String email, String phone,
                                                         String birthDate, String file, String address){
        new PracticeFormPage(driver)
                .hideIframes()
                .enterPersonalData(firstName, lastName, email, phone);
        new PracticeFormPage(driver).selectGender(StudentData.GENDER)
                .typeOfDate(birthDate)
                .addSubject(StudentData.SUBJECTS)
                .chooseHobby(StudentData.HOBBIES)
                .uploadFile(file)
                .addAddress(address)
                .enterState(StudentData.STATE)
                .enterCity(StudentData.CITY).submit();
        Assert.assertTrue(new PracticeFormPage(driver).getModalTitle().contains("Thanks for submitting the form"));
        new PracticeFormPage(driver).closeModalDialog();

    }

}
