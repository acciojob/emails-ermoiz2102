package com.driver;

import java.util.Date;

public class Mail {
    private String message;
    private String sender;
    private Date date;

    public Mail() {
    }

    public Mail(String message, String sender, Date date) {
        this.message = message;
        this.sender = sender;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
