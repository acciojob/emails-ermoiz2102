package com.driver;

import java.util.*;
import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {

    private List<Mail> mailList= new ArrayList<>();
    private List<Mail>trashList= new ArrayList<>();
    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity=inboxCapacity;

    }

    public void receiveMail(Date date, String sender, String message){
        if(mailList.size()>=inboxCapacity){
            trashList.add(mailList.remove(0));
        }
        mailList.add(new Mail(message,sender,date));
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

    }

    public void deleteMail(String message){
        int i=-1;
        int j=0;
        for(Mail mail:mailList){
            if(mail.getMessage().equals(message)){
                i=j;
            }
            j++;
        }
        if(i>=0)
            mailList.remove(i);
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing

    }

    public String findLatestMessage(){
        if(mailList.isEmpty())
            return null;
        return mailList.get(mailList.size()-1).getMessage();
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox

    }

    public String findOldestMessage(){
        if(mailList.isEmpty())
            return  null;
        return mailList.get(0).getMessage();
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox

    }

    public int findMailsBetweenDates(Date start, Date end){
        int ct=0;
        for(Mail mail:mailList){
            Date date=mail.getDate();
            if((date.compareTo(start)>=0)&&(date.compareTo(end)<=0))
                ct++;
        }
        return ct;
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date

    }

    public int getInboxSize(){
        return mailList.size();
        // Return number of mails in inbox

    }

    public int getTrashSize(){
        return trashList.size();
        // Return number of mails in Trash

    }

    public void emptyTrash(){
        trashList.clear();
        // clear all mails in the trash

    }

    public int getInboxCapacity() {
        return inboxCapacity;
        // Return the maximum number of mails that can be stored in the inbox
    }
}
