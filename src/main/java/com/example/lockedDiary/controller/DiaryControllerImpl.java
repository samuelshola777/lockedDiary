package com.example.lockedDiary.controller;

import com.example.lockedDiary.data.model.DiaryPages;
import com.example.lockedDiary.dto.request.DiaryServiceRequest;
import com.example.lockedDiary.exectionThrow.DiaryPageExeption;
import com.example.lockedDiary.services.DiaryServicesImpl;
import com.example.lockedDiary.services.DiaryServicesInterface;

import java.util.HashMap;

public class DiaryControllerImpl implements DiaryControllerInterface{
DiaryServicesInterface diaryservice = new DiaryServicesImpl();
    @Override
    public String createDiaryPage(String date, String month, String title1, String message1, String password) throws DiaryPageExeption {
        return diaryservice.createDiaryPage(date, month, title1, message1, password);
    }

    @Override
    public String createDiaryPage(DiaryServiceRequest diaryServiceRequest) throws DiaryPageExeption {
     return    diaryservice.createDiaryPage(diaryServiceRequest.getDate(),
                diaryServiceRequest.getMonth(),
                diaryServiceRequest.getTitle(),
                diaryServiceRequest.getMessageBody(),
                diaryServiceRequest.getPassword());

    }

    @Override
    public int countDiaryPages() {
        return diaryservice.countDiaryPages();
    }

    @Override
    public DiaryPages findPageByDate(String date, String month, String password) throws DiaryPageExeption {
     return diaryservice.findDiaryPageByDate(date,month, password);
    }

    @Override
    public DiaryPages findPageByDate(DiaryServiceRequest diaryServiceRequest) throws DiaryPageExeption {
        return diaryservice.findDiaryPageByDate(diaryServiceRequest.getDate(),
                diaryServiceRequest.getMonth(),diaryServiceRequest.getPassword());
    }

    @Override
    public String deletePageByDate(String date, String month) {
        return diaryservice.deleteByDate(date,month);
    }

    @Override
    public String deletePageByDate(DiaryServiceRequest diaryServiceRequest) {
       diaryservice.deleteByDate(diaryServiceRequest);
       return "delete successfully";
    }

    @Override
    public HashMap<String, DiaryPages> viewAllDiaryPages() {
        return diaryservice.viewAllDiaryPages();
    }
}
