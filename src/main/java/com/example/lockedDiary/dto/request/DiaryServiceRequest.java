package com.example.lockedDiary.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
public class DiaryServiceRequest {

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

}
