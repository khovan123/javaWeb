package model;

import java.util.Date;

public class Notify {
    private String idNotify;
    private String idUserSend;
    private String idUserReceive;
    private Date date;
    private String content;
    private boolean markRead;

    public Notify() {
    }

    public Notify(String idNotify, String idUserSend, String idUserReceive, Date date, String content, boolean markRead) {
        this.idNotify = idNotify;
        this.idUserSend = idUserSend;
        this.idUserReceive = idUserReceive;
        this.date = date;
        this.content = content;
        this.markRead = markRead;
    }

    public String getIdNotify() {
        return idNotify;
    }

    public void setIdNotify(String idNotify) {
        this.idNotify = idNotify;
    }

    public String getIdUserSend() {
        return idUserSend;
    }

    public void setIdUserSend(String idUserSend) {
        this.idUserSend = idUserSend;
    }

    public String getIdUserReceive() {
        return idUserReceive;
    }

    public void setIdUserReceive(String idUserReceive) {
        this.idUserReceive = idUserReceive;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isMarkRead() {
        return markRead;
    }

    public void setMarkRead(boolean markRead) {
        this.markRead = markRead;
    }
    
}
