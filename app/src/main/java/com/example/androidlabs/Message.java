package com.example.androidlabs;

public class Message {

    private String message;
    private boolean check;
    private long messageId;




    public Message()
    {

        this("unknown",false);
    }

    public Message(String message,boolean check)
    {
        this.message=message;
        this.check=check;
    }

    public boolean isCheck() {
        return check;
    }

    public String getMessage() {
        return message;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public long getMessageId() {
        return messageId;
    }
}
