package com.example.lockedDiary;

import com.example.lockedDiary.controller.DiaryControllerImpl;
import com.example.lockedDiary.controller.DiaryControllerInterface;
import com.example.lockedDiary.data.model.DiaryPages;
import com.example.lockedDiary.exectionThrow.DiaryPageExeption;
import com.example.lockedDiary.exectionThrow.DiaryServicesExeption;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyDiaryApp {
    public static void main(String[] args) throws DiaryPageExeption {
        diplayMenu();
    }
  private static  DiaryControllerInterface diary = new DiaryControllerImpl();

    public static void diplayMenu() throws DiaryPageExeption {
        String displayMenu = """
                          
                >>>>>>   Welcome to your daily Event Secured Diary <<<<<<<<<\n\n
                 *   <<===============================================>> \n    
                 **     Press 1 to Write Today's  Gist π₯°π₯°π₯°π₯°ππ\n
                          
                 ***    Press 2 to View an Existing Diary Gistπ₯°π₯°π₯°π₯°ππ\n 
                      
                ****    Press 3  to Add to An Existing Gist π₯°π₯°π₯°π₯°ππ\n
                      
                *****   press 4  to Delete Diary Page π₯°π₯°π₯°π₯°ππ \n
                          
                ****** press 5    to count the number of available  pages  π₯°π₯°π₯°π₯°ππ
                          """;
        print(displayMenu);
     int responce = input();
      switch (responce){
      case 1 -> writeMessagePageOnDiary();
      case 2 -> findExistingDiaryPage();
      case 3 -> addToAnExistingPage();
      case 4 -> deletePage();
      case 5 -> diary.countDiaryPages();
      }

    }
public static void print(String word){
        System.out.println(word);
}
public static void print(int num){
        System.out.println(num);
}
public static void print(DiaryPages diaryPages){
    System.out.println(diaryPages);
}
public static int input (){
    Scanner scanner = new Scanner(System.in);
   int num = scanner.nextInt();
    return num;
}
public static String inputS(){
    Scanner scanner = new Scanner(System.in);
  String  word = scanner.nextLine();
    return word;
}


public static void writeMessagePageOnDiary() throws DiaryPageExeption {
        try {
            print("Diary is currently locked bt you can unlocked Diary by creating new password\n" +
                    "Enter a New Password");
            String password = inputS();
            print("please enter Event date\n");
            String date = inputS();
            print("please enter Event Month \n ");
            String month = inputS();

            print(" Enter Event Title \n");
            String title = inputS();

            print(" Enter today's  Days EVent");
            String message = inputS();
            diary.createDiaryPage(date, month, title, message, password);

            print("do you want add to the existing gist?\n\n" +
                    "press 1 to continue the gist  \n" +
                    "press 2 to go the main menu \n" +
                    "press 3 to add to an Existing gist \n");
            int respond = input();
            switch (respond) {
                case 1 -> addToMessageBody(date, month, password, message);
                case 2 -> diplayMenu();
                case 3 -> addToAnExistingPage();
            }
        }catch (DiaryPageExeption | IllegalArgumentException | InputMismatchException be){
            writeMessagePageOnDiary();
        }
}

public static void addToMessageBody(String date , String month, String password, String message) throws DiaryPageExeption {
        try {
            DiaryPages page = diary.findPageByDate(date, month, password);
            page.updateMessageBody(message);
        }catch (DiaryPageExeption | IllegalArgumentException | InputMismatchException no){
            writeMessagePageOnDiary();
        }

}
public static void findExistingDiaryPage() throws DiaryPageExeption {
    try {
    print("please enter password ");
    String password = inputS();
    print("please enter Event date\n");
    String date = inputS();
    print("please enter Event Month \n ");
    String month = inputS();



    print(diary.findPageByDate(date, month, password));
    while (true) {
        print("do you want add to the existing gist?\n\n" +
                "press 1 to go back to the main menu \n" +
                "press 2 to Edith the Existing Diary Page ");
        int respond = input();
        if (respond > 2) {
            continue;
        } else {
            switch (respond) {
                case 1 -> diplayMenu();
                case 2 -> addToAnExistingPage();
            }
        }
    }
}catch (DiaryPageExeption |IllegalArgumentException| InputMismatchException bone){
    findExistingDiaryPage();
}
}
public static void addToAnExistingPage() throws DiaryPageExeption {
try {

    print("please enter password ");
    String password = inputS();
    print("please enter Event date\n");
    String date = inputS();
    print("please enter Event Month \n ");
    String month = inputS();


    DiaryPages pages = diary.findPageByDate(date, month, password);
    print("""
            >>>>    WELCOME TO THE PAGE EDITING CHANNEL <<<<<<<<< \n\n
                        
            press 1 to  Update Title   <<<<< \n
                        
            press 2 to Change Title <<<<<<\n
                        
            press 3  to Update Message Body <<<<<\n
                        
            press 4 to delete Massage Body  
            """);
    int response = input();
    switch (response) {
        case 1:
            print("please enter new title  ");
            String updateTitle = inputS();
            pages.updateTitle(updateTitle);
            break;
        case 2:
            print("please enter the new title");
            String newTitle = inputS();
            pages.changeTitle(newTitle);
            break;
        case 3:
            print("please enter the updates message body ");
            String updateMessagebody = inputS();
            pages.updateMessageBody(updateMessagebody);
            break;
        case 4:
            print("Message deleted ");
            pages.deleteMessageBody();
            break;
        default:
    }
    while (true) {
        print("do you want add to the existing gist?\n\n" +
                "press 1 to go back to the main menu \n" +
                "press 2 to Edith the Existing Diary Page ");
        int respond = input();
        if (respond > 2) {
            continue;
        } else {
            switch (respond) {
                case 1 -> diplayMenu();
                case 2 -> addToAnExistingPage();
            }
        }

    }

}catch (DiaryPageExeption | IllegalArgumentException | InputMismatchException bo){
    addToAnExistingPage();
}
 }

public static void deletePage() throws DiaryPageExeption {
    try {
        print("please enter date of the Page you wanna delete");
        String date = inputS();
        print("please enter month of the Page you wanna delete");
        String month = inputS();
        diary.deletePageByDate(date, month);
        print("delete successful");


            while (true) {
                print("do you want add to the existing gist?\n\n" +
                        "press 1 to go back to the main menu \n" +
                        "press 2 to Edith the Existing Diary Page ");
                int respond = input();
                if (respond > 2) {
                    continue;
                } else {
                    switch (respond) {
                        case 1 -> diplayMenu();
                        case 2 -> addToAnExistingPage();
                    }
                }
            }
        }catch (DiaryPageExeption | IllegalArgumentException | InputMismatchException to){
            deletePage();
        }

   }

}
