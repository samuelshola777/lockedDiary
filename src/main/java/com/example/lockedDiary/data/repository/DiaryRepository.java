package com.example.lockedDiary.data.repository;

import com.example.lockedDiary.data.model.DiaryPages;
import com.example.lockedDiary.exectionThrow.DiaryPageExeption;

import java.util.HashMap;

public interface DiaryRepository {
    String writeOnDiaryPage(DiaryPages pages);

    int CountDiaryPage();

     DiaryPages findByDate(String date, String month, String password) throws DiaryPageExeption;
    HashMap<String, DiaryPages> viewAllDiaryPages();

    String deletePage(String date, String month);
}
