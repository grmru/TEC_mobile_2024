package com.tec.tecmobileapp;

import java.util.Date;

public class ToDoItem {
    private String sName;
    private String sComment;
    private boolean bIsDone;
    private Date dDeadLine;

    public ToDoItem(String name, String comment, boolean isDone)
    {
        this.sName = name;
        this.sComment = comment;
        this.bIsDone = isDone;
    }

    public String getName() {
        return sName;
    }
    public String getComment() {
        return sComment;
    }
    public boolean getIsDone() {
        return bIsDone;
    }
    public Date getDeadLine() {
        return dDeadLine;
    }
}
