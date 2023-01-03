package com.example.lockedDiary.services;

import com.example.lockedDiary.data.model.DiaryPages;
import com.example.lockedDiary.dto.request.DiaryServiceRequest;
import com.example.lockedDiary.dto.responce.DiaryServiceResponce;
import com.example.lockedDiary.exectionThrow.DiaryPageExeption;
import com.example.lockedDiary.exectionThrow.DiaryServicesExeption;

import java.util.HashMap;

public interface DiaryServicesInterface {
    DiaryServiceResponce createDiaryPage(DiaryServiceRequest diaryServiceRequest) throws DiaryPageExeption, DiaryServicesExeption;


    int countDiaryPages();

    HashMap<String, DiaryPages> viewAllDiaryPages();
    DiaryPages findDiaryPageByDate(String date, String month, String password) throws DiaryPageExeption;
    DiaryPages findDiaryPageByDate(DiaryServiceRequest diaryServiceRequest) throws DiaryPageExeption;
    String createDiaryPage(String date, String month, String title, String message, String password) throws DiaryPageExeption;

    String deleteByDate(String date, String month);
DiaryServiceResponce deleteByDate(DiaryServiceRequest diaryServiceRequest);
}
