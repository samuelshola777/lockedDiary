package com.example.lockedDiary.exectionThrow;

public class DiaryServicesExeption extends Exception{
    private String message;

    public DiaryServicesExeption(String message){
        super(message);
    }

}
