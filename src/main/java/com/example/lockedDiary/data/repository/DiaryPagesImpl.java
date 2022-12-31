package com.example.lockedDiary.data.repository;

import com.example.lockedDiary.data.model.DiaryPages;

import java.util.HashMap;

public class DiaryPagesImpl implements DiaryPageRepository{

    HashMap<String, DiaryPages> diaryPageList = new HashMap<>();


    @Override
    public String writeEvenInDiary(DiaryPages diaryPages) {
        return null;
    }
}
