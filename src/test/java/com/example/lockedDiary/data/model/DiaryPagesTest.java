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
        page = new DiaryPages("boneshaker");
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
        page.setCreationDate("09","01");
        page.setTitle("the day that never come");
        assertEquals("the day that never come", page.getTitle());
    }
    @Test
    void testDiaryCanHaveBody() throws DiaryPageExeption {
        assertEquals(true, page.getIsLock());
        page.setPassword("gold");
        page.unlock("gold");
        assertEquals(false, page.getIsLock());
        page.setCreationDate("09","01");
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
        page.setCreationDate("09","1");
        assertEquals("0901", page.getCreationDate());

    }

    @Test
    void testThatWeCanWriteEventsOnDiaryPage() throws DiaryPageExeption {
        page.unlock("boneshaker");
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
        page.unlock("boneshaker");
        String title = "the glorious celebration ";
        String space = " ";
        String messageBody = "the joy of the lord is my strength i am strong the love of christ ";
        page.writeEventsOnPage("30","6" ,title, messageBody);
        String testText = "i have 2 million";
        page.updateMessageBody(testText );
        assertEquals(messageBody + space+testText, page.getMessageBody());
    }
    @Test
    void testThatTitleCanBeUpdated() throws DiaryPageExeption {
        page.unlock("boneshaker");
        String title = "the glorious celebration ";
        String updatedTitle = "my name is samuel shola";
        String space = " ";
        String messageBody = "the joy of the lord is my strength i am strong the love of christ ";
        page.writeEventsOnPage("30","6" ,title, messageBody);
page.UpdateTitle(updatedTitle);
assertEquals(title+space+updatedTitle, page.getTitle());
    }
    @Test
    void testThatTitleCanBeChanged() throws DiaryPageExeption {
        page.unlock("boneshaker");
        String changedTitle = "i have no reason to do this bt i just wanna ";
        String title = "the glorious celebration ";
        String messageBody = "the joy of the lord is my strength i am strong the love of christ ";
        page.writeEventsOnPage("30","6" ,title, messageBody);
        page.changeTitle(changedTitle);
        assertEquals(changedTitle, page.getTitle());
    }
    @Test
    void testThatWecanDeleteMessageBody() throws DiaryPageExeption {
        page.unlock("boneshaker");
        String changedTitle = "i have no reason to do this bt i just wanna ";
        String title = "the glorious celebration ";
        String messageBody = "the joy of the lord is my strength i am strong the love of christ ";
        page.writeEventsOnPage("30","6" ,title, messageBody);
        page.deleteMessageBody();
        assertEquals("",page.getMessageBody());

    }

}