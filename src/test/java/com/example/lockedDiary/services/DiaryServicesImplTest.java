package com.example.lockedDiary.services;

import com.example.lockedDiary.data.model.DiaryPages;
import com.example.lockedDiary.dto.request.DiaryServiceRequest;
import com.example.lockedDiary.exectionThrow.DiaryPageExeption;
import com.example.lockedDiary.exectionThrow.DiaryServicesExeption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryServicesImplTest {
    DiaryServiceRequest diaryServiceRequest = new DiaryServiceRequest();
    DiaryServicesInterface diaryServices;

    @BeforeEach
    @Test
    void setUp() {
        diaryServices = new DiaryServicesImpl();
    }



    @Test
     void testThatPageCanBeFoundByDate() throws DiaryPageExeption {
        String title1 = " i wanna be in your presence";
        String message1 = "holy holy , God almighty it's a" +
                " hour to stand before you";

        String title2 = " you're all that matter";
        String message2 = "you are that matter to me lord jesus thank you " +
                "for fighting my battle for me. ";
        String title3 = " guide  us with your truth ";
        String message3 = "so we bow as we enter your thrown , there is non like thee " +
                "for fighting my battle for me. ";
        String title4 = " before the throne ";
        String message4 = "before your throne is where we come to offer grace and seek wisdome";

        diaryServices.createDiaryPage("21", "1",title1, message1,"boneshaker");
        diaryServices.createDiaryPage("22", "2",title2, message2,"boneshaker");
        diaryServices.createDiaryPage("23", "3",title3, message3,"boneshaker");
        diaryServices.createDiaryPage("24", "4",title4, message4,"boneshaker");




       assertEquals(4, diaryServices.countDiaryPages());
       assertEquals(title2, diaryServices.findDiaryPageByDate("22","2","boneshaker").getTitle());
    }
    @Test
    void testThatPageCanBeDeletedByDate() throws DiaryPageExeption {
        String title1 = " i wanna be in your presence";
        String message1 = "holy holy , God almighty it's a" +
                " hour to stand before you";

        String title2 = " you're all that matter";
        String message2 = "you are that matter to me lord jesus thank you " +
                "for fighting my battle for me. ";
        String title3 = " guide  us with your truth ";
        String message3 = "so we bow as we enter your thrown , there is non like thee " +
                "for fighting my battle for me. ";
        String title4 = " before the throne ";
        String message4 = "before your throne is where we come to offer grace and seek wisdome";

        diaryServices.createDiaryPage("21", "1",title1, message1,"boneshaker");
        diaryServices.createDiaryPage("22", "2",title2, message2,"boneshaker");
        diaryServices.createDiaryPage("23", "3",title3, message3,"boneshaker");
        diaryServices.createDiaryPage("24", "4",title4, message4,"boneshaker");




        assertEquals(4, diaryServices.countDiaryPages());

        diaryServices.deleteByDate("22","2");
        assertEquals(3, diaryServices.countDiaryPages());

    }
}