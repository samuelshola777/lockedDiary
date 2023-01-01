package com.example.lockedDiary.data.repository;

import com.example.lockedDiary.data.model.Diary;
import com.example.lockedDiary.data.model.DiaryPages;
import com.example.lockedDiary.exectionThrow.DiaryPageExeption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryRepoImplTest {
DiaryRepository diary;
DiaryPages diaryPages = new DiaryPages("boneshaker");
//DiaryPages diaryPage;

    @BeforeEach
    @Test
    void setUp() {
        diary = new DiaryRepoImpl();
    }
    @Test
    void testThatDiaryCanHavePages() throws DiaryPageExeption {
        String title = "my creative life" ;
        String message = "i'm presently chatting with immaculate and bukola at the " +
                "same time ";
        diaryPages.unlock("boneshaker");
      diaryPages.writeEventsOnPage("7","5", title, message);
        diary.writeOnDiaryPage(diaryPages);
        assertEquals(1, diary.CountDiaryPage());
    }
    @Test
    void testThatDiaryPageCanBeFindByDate() throws DiaryPageExeption {
        String title = "my creative life" ;
        String message = "i'm presently chatting with immaculate and bukola at the " +
                "same time ";
        diaryPages.unlock("boneshaker");
        diaryPages.writeEventsOnPage("7","5", title, message);
        diary.writeOnDiaryPage(diaryPages);
        String title2 = "you will always be my heart";
        String message2 = "stand near don't leave don't look the rain, all in " +
                "the black and blue ";
        DiaryPages pages2 = new DiaryPages("alexpacker");
        pages2.unlock("alexpacker");
        pages2.writeEventsOnPage("23", "4", title2, message2);
        diary.writeOnDiaryPage(pages2);
         String title3 = " my life is a testimony ";
         String message3 = " wen i think of the goodness of jesus and all he has done" +
                 "for me, my very soul will shout halleluyah. praise God for saving me";
         DiaryPages pages3 = new DiaryPages("blackMamber");
         pages3.unlock("blackMamber");
         pages3.writeEventsOnPage("14", "6",title3, message3);
         diary.writeOnDiaryPage(pages3);
         assertEquals(3,diary.CountDiaryPage());

         assertEquals(title,diary.findByDate("7","5").getTitle() );

    }
   @Test
    void testThatPageCanBeDeleted() throws DiaryPageExeption {
       String title = "my creative life" ;
       String message = "i'm presently chatting with immaculate and bukola at the " +
               "same time ";
       diaryPages.unlock("boneshaker");
       diaryPages.writeEventsOnPage("7","5", title, message);
       diary.writeOnDiaryPage(diaryPages);
       String title2 = "you will always be my heart";
       String message2 = "stand near don't leave don't look the rain, all in " +
               "the black and blue ";
       DiaryPages pages2 = new DiaryPages("alexpacker");
       pages2.unlock("alexpacker");
       pages2.writeEventsOnPage("23", "4", title2, message2);
       diary.writeOnDiaryPage(pages2);
       String title3 = " my life is a testimony ";
       String message3 = " wen i think of the goodness of jesus and all he has done" +
               "for me, my very soul will shout halleluyah. praise God for saving me";
       DiaryPages pages3 = new DiaryPages("blackMamber");
       pages3.unlock("blackMamber");
       pages3.writeEventsOnPage("14", "6",title3, message3);
       diary.writeOnDiaryPage(pages3);
       assertEquals(3,diary.CountDiaryPage());
       diary.deletePage("7","5");
       assertEquals(2,diary.CountDiaryPage());


   }
}