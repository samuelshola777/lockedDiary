package com.example.lockedDiary.exectionThrow;

public class DiaryPageExeption extends Exception{
    private String message;
    public DiaryPageExeption(String message){
        super(message);
    }
}
