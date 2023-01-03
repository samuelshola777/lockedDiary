package com.example.lockedDiary.controller;

import com.example.lockedDiary.data.repository.DiaryRepoImpl;
import com.example.lockedDiary.data.repository.DiaryRepository;
import com.example.lockedDiary.exectionThrow.DiaryPageExeption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryControllerImplTest {
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

    DiaryRepository diaryRepo = new DiaryRepoImpl();
    DiaryControllerInterface diaryController;
    @BeforeEach
    @Test

    void setUp() {
        diaryController = new DiaryControllerImpl();
    }

    @Test
    void testThatControllerCanCreateDiaryPage() throws DiaryPageExeption {
        diaryController.createDiaryPage("9","12",title1 ,message1,"boneshaker");
       assertEquals(1, diaryController.countDiaryPages());
    }
    @Test
    void testThatPAgeCanBeFoundByDate() throws DiaryPageExeption {
        diaryController.createDiaryPage("1","11",title1 ,message1, "boneshaker");
        diaryController.createDiaryPage("2","12",title2 ,message2,"boneshaker");
        diaryController.createDiaryPage("3","12",title3 ,message3,"boneshaker");
        diaryController.createDiaryPage("4","12",title4 ,message4,"boneshaker");
        assertEquals(4, diaryController.countDiaryPages());
assertEquals(title2, diaryController.findPageByDate("2","12","boneshaker").getTitle());

    }
@Test
    void testThatWeCanDeleteDiaryPageByName() throws DiaryPageExeption {
    diaryController.createDiaryPage("1","11",title1 ,message1,"boneshaker");
    diaryController.createDiaryPage("2","12",title2 ,message2,"boneshaker");
    diaryController.createDiaryPage("3","12",title3 ,message3,"boneshaker");
    diaryController.createDiaryPage("4","12",title4 ,message4,"boneshaker");
    assertEquals(4, diaryController.countDiaryPages());
    diaryController.deletePageByDate("3","12");
    assertEquals(3, diaryController.countDiaryPages());


}
}