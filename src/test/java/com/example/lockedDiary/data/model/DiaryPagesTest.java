package com.example.lockedDiary.data.model;

import com.example.lockedDiary.exectionThrow.DiaryPageExeption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryPagesTest {
    DiaryPages page;
    @BeforeEach
    @Test
    void setUp() {
        page = new DiaryPages();
    }
    @Test
    void testIfDiaryPageCanBeUnlock(){
        page.setPassword("gold");
        page.unlock("gold");
        assertEquals(false, page.getIsLock());
    }
    @Test
    void testThatDiaryCanBeLocked(){
        page.setPassword("gold");
        page.unlock("gold");
        assertEquals(false, page.getIsLock());
        page.lockDiary("gold");
        assertEquals(true, page.getIsLock());
    }
    @Test
    void testThatDiaryPageCanHaveTitle() throws DiaryPageExeption {
        assertEquals(true, page.getIsLock());
        page.setPassword("gold");
        page.unlock("gold");
        assertEquals(false, page.getIsLock());
        page.creationDate("09","01");
        page.setTitle("the day that never come");
        assertEquals("the day that never come", page.getTitle());
    }
    @Test
    void testDiaryCanHaveBody() throws DiaryPageExeption {
        assertEquals(true, page.getIsLock());
        page.setPassword("gold");
        page.unlock("gold");
        assertEquals(false, page.getIsLock());
        page.creationDate("09","01");
       page.setTitle("the day that never come");
        assertEquals("the day that never come", page.getTitle());
        page.setBody("i dreams i was so scared  now i will listen cause no else cares ");
        assertEquals("i dreams i was so scared  now i will listen cause no else cares ", page.getMessageBody());
    }
    @Test
    void testDiaryPageCanHaveCreateDateAndMonth(){
        page.setDate("01");
        page.setMonth("05");
        assertEquals("01", page.getDate());
        assertEquals("05", page.getMonth());
    }
    @Test
    void testThatDiaryCanHaveCreationDate() throws DiaryPageExeption {
        assertEquals("0901", page.creationDate("09","01"));

    }

    @Test
    void testThatWeCanWriteEventsOnDiaryPage() throws DiaryPageExeption {
        String title = "the glorious celebration ";
        String messageBody = "the joy of the lord is my strength i am strong the love of christ ";
        page.writeEventsOnPage("30","6" ,title, messageBody);
        assertEquals("30", page.getDate());
        assertEquals("06", page.getMonth());
        assertEquals("the glorious celebration ", page.getTitle());
        assertEquals("the joy of the lord is my strength i am strong the love of christ ", page.getMessageBody());
    }

    @Test
    void testThatWeCanUpdateMessageBody() throws DiaryPageExeption {
        String title = "the glorious celebration ";
        String messageBody = "the joy of the lord is my strength i am strong the love of christ ";
        page.writeEventsOnPage("30","6" ,title, messageBody);
        int response = 1;
        page.UpdateDiaryPage(response, "i have 2 million");
    }

}