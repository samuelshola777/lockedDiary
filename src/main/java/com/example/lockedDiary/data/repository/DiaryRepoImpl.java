package com.example.lockedDiary.data.repository;

import com.example.lockedDiary.data.model.DiaryPages;
import com.example.lockedDiary.exectionThrow.DiaryPageExeption;

import java.util.HashMap;

public class DiaryRepoImpl implements DiaryRepository{
    DiaryPages pages;
    private HashMap<String, DiaryPages> diaryPageList = new HashMap<>();
    @Override
    public String writeOnDiaryPage(DiaryPages pages) {
        diaryPageList.put(pages.getCreationDate(), pages);
        return "Diary page writing is saved ";
    }

    @Override
    public int CountDiaryPage() {
        return diaryPageList.size();
    }

    @Override
    public DiaryPages findByDate(String date, String month, String unlockpassword) throws DiaryPageExeption {
//        if (!unlockpassword.equals(pages.getPassword())){
//            throw new DiaryPageExeption("incorrect password ");
//        }
    String zero = "0";
    if (date.length() < 2){
      date =  zero+date;
    } if (month.length() < 2){
      month =  zero+month;
    }
    String creationDate = date + month;
        return diaryPageList.get(creationDate);
    }


    @Override
    public HashMap<String, DiaryPages> viewAllDiaryPages() {
        for (int i = 0; i < diaryPageList.size(); i++) {
            if (diaryPageList.size() > 0){
                return diaryPageList;
            }

        }
        return null;
    }


    @Override
    public String deletePage(String date, String month) {
        String zero = "0";
        if (date.length() < 2){
            date =  zero+date;
        } if (month.length() < 2){
            month =  zero+month;
        }
        String creationDate = date + month;
diaryPageList.remove(creationDate);
        return "page deleted successful";
    }
}
