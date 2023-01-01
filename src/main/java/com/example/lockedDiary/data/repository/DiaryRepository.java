package com.example.lockedDiary.data.repository;

import com.example.lockedDiary.data.model.DiaryPages;
import com.example.lockedDiary.exectionThrow.DiaryPageExeption;

public interface DiaryRepository {
    String writeOnDiaryPage(DiaryPages pages);

    int CountDiaryPage();

     DiaryPages findByDate(String date, String month) throws DiaryPageExeption;

    String deletePage(String date, String month);
}
