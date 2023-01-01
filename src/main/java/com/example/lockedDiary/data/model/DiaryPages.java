package com.example.lockedDiary.data.model;

import com.example.lockedDiary.exectionThrow.DiaryPageExeption;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data

public class DiaryPages {
    @Getter
    private Boolean isLock = true;
//    @Getter
    @Setter
    private String password;
    @Setter
    @Getter
    private String title;
    @Getter
    private String messageBody;
    @Setter
    @Getter
    private String date;
    @Setter
    @Getter
    private String month;


    public boolean unlock(String unlockPassword) {
        if (unlockPassword.equals(password)) {
            isLock = false;
        }
        return getIsLock();
    }
    public DiaryPages(String password){
        this.password = password;
    }


    public void lockDiary(String lockPassword) {
        if (lockPassword.equals(password)) {
            isLock = true;
        }
    }
    public void setTitle(String title) throws DiaryPageExeption {
        if (date  == null) throw new DiaryPageExeption("please set date to proceed");
        if (month  == null) throw new DiaryPageExeption("please set month to proceed");
        this.title = title;
    }
    public String setBody(String messageBody) throws DiaryPageExeption {
        if (title == null) throw new DiaryPageExeption("can't create a message body without a tittle");
        if (date  == null) throw new DiaryPageExeption("please set date to proceed");
        if (month  == null) throw new DiaryPageExeption("please set month to proceed");
        this.messageBody = messageBody;
        return "succeful";
    }
public String getCreationDate(){
        return date+month;
}

    public void setCreationDate(String date, String month) throws DiaryPageExeption {
        if (Integer.parseInt(date) > 30 || Integer.parseInt(date) < 0){
            throw new DiaryPageExeption("you have entered an invalid date");
        }if (Integer.parseInt(month) > 12 || Integer.parseInt(month) < 0){
            throw new DiaryPageExeption("you have entered an invalid month");
        }
        String zero = "0";
        if (date.length() < 2){
            date = zero + date ;
        }
        this.date = date;
        if (month.length() < 2 ){
            month = zero + month;
        }

        this.month = month;
//        return date+month;
    }

    public void writeEventsOnPage(String date, String month, String title, String messageBody) throws DiaryPageExeption {
     if (isLock == true){
         throw new DiaryPageExeption("diary page is lock " +
                 "please unlock before you proceed");
     }
      String zero = "0";
       if (date.length() < 2){
           date = zero + date ;
       }
        this.date = date;

       if (month.length() < 2 ){
           month = zero + month;
       }
       setCreationDate(date, month);
        this.month = month;
        this.title = title;
        this.messageBody = messageBody;
    }


    public void UpdateMessageBody( String updateMessageBody) throws DiaryPageExeption {
        String space = " ";
                if (messageBody == null ){
                    throw new DiaryPageExeption("these nothing to update," +
                            "you can only update a saved diary message ");
                }
                setMessageBody(messageBody +  space+updateMessageBody);
    }
    public void UpdateTitle( String updateTitle) throws DiaryPageExeption {
        String space = " ";
                if (title == null ){
                    throw new DiaryPageExeption("these nothing to update," +
                            "you can only update a saved diary message ");
                } if (messageBody == null ){
            throw new DiaryPageExeption("these nothing to update," +
                    "you can only update a saved diary message ");
        }
                setTitle(title +  space+updateTitle);
    }

    public String changeTitle(String changedTitle) throws DiaryPageExeption {
        setTitle(changedTitle);
        return "title changed succeful";
    }

    public String deleteMessageBody() throws DiaryPageExeption {
        setBody("");
        return "messageBody Deleted successful";
    }
}
