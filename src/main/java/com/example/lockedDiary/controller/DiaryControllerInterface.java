package com.example.lockedDiary.controller;

import com.example.lockedDiary.data.model.DiaryPages;
import com.example.lockedDiary.dto.request.DiaryServiceRequest;
import com.example.lockedDiary.exectionThrow.DiaryPageExeption;

import java.util.HashMap;

public interface DiaryControllerInterface {
    String createDiaryPage(String date, String month, String title1, String message1, String password) throws DiaryPageExeption;
    String createDiaryPage(DiaryServiceRequest diaryServiceRequest) throws DiaryPageExeption;

    int countDiaryPages();

    DiaryPages findPageByDate(String date, String month, String password) throws DiaryPageExeption;
    DiaryPages findPageByDate(DiaryServiceRequest diaryServiceRequest) throws DiaryPageExeption;

    String deletePageByDate(String date, String month);
    String deletePageByDate(DiaryServiceRequest diaryServiceRequest);
    HashMap<String, DiaryPages> viewAllDiaryPages();
}
