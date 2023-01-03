package com.example.lockedDiary.services;

import com.example.lockedDiary.data.model.DiaryPages;
import com.example.lockedDiary.data.repository.DiaryRepoImpl;
import com.example.lockedDiary.data.repository.DiaryRepository;
import com.example.lockedDiary.dto.request.DiaryServiceRequest;
import com.example.lockedDiary.dto.responce.DiaryServiceResponce;
import com.example.lockedDiary.exectionThrow.DiaryPageExeption;
import com.example.lockedDiary.exectionThrow.DiaryServicesExeption;

import java.util.HashMap;

public class DiaryServicesImpl implements DiaryServicesInterface {
    DiaryRepository diaryRepo = new DiaryRepoImpl();

    @Override
    public DiaryServiceResponce createDiaryPage(DiaryServiceRequest diaryServiceRequest)
            throws DiaryPageExeption, DiaryServicesExeption {
        DiaryPages page = new DiaryPages(diaryServiceRequest.getPassword());

        if (diaryRepo.findByDate(diaryServiceRequest.getDate(), diaryServiceRequest.getMonth(), diaryServiceRequest.getPassword()
   ) != null){
       throw new DiaryServicesExeption("you cannot creat new date of an existing" +
               "date please update the existing date or enter a new date");
   }
    page.unlock(diaryServiceRequest.getPassword());
        page.writeEventsOnPage(diaryServiceRequest.getDate(), diaryServiceRequest.getMonth(),
    diaryServiceRequest.getTitle(), diaryServiceRequest.getMessageBody());
        diaryRepo.writeOnDiaryPage(page);
        return  new DiaryServiceResponce("page created successfully ");
    }

    @Override
    public int countDiaryPages() {
        return diaryRepo.CountDiaryPage() ;
    }

    @Override
    public HashMap<String, DiaryPages> viewAllDiaryPages() {
        return diaryRepo.viewAllDiaryPages();
    }

    @Override
    public DiaryPages findDiaryPageByDate(String date, String month, String password) throws DiaryPageExeption {
        return diaryRepo.findByDate(date, month, password);
    }

    @Override
    public DiaryPages findDiaryPageByDate(DiaryServiceRequest diaryServiceRequest) throws DiaryPageExeption {
      return   diaryRepo.findByDate(diaryServiceRequest.getDate(),
                diaryServiceRequest.getMonth(), diaryServiceRequest.getPassword());
    }

    public String createDiaryPage(String date, String month , String title, String message, String password)
            throws DiaryPageExeption {
        if (diaryRepo.findByDate(date, month, password) != null){
            throw new DiaryPageExeption("you cannot creat new date of an existing" +
                    "date please update the existing date or enter a new date");
        }
        DiaryPages page = new DiaryPages("bone");

        page.unlock("bone");
        page.writeEventsOnPage(date, month, title, message);
        diaryRepo.writeOnDiaryPage(page);
        return "page create successfully";
    }

    @Override
    public String deleteByDate(String date, String month) {
        return diaryRepo.deletePage(date, month);
    }

    @Override
    public DiaryServiceResponce deleteByDate(DiaryServiceRequest diaryServiceRequest) {
        diaryRepo.deletePage(diaryServiceRequest.getDate(), diaryServiceRequest.getMonth());
        return new DiaryServiceResponce("page deleted successfully");
    }


}
