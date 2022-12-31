package com.example.lockedDiary.data.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryPagesImplTest {
DiaryPageRepository diary;
    @BeforeEach
    @Test
    void setUp() {
        diary = new DiaryPagesImpl();
    }
    @Test
    void testThatWeCanLockAndOpenOurDiary(){

    }
}