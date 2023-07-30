package com.FrankieRodriguez.dakboardtosmartthingsapi;

import com.fasterxml.jackson.annotation.JsonSetter;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class TaskProxyModel
{
    private Boolean completed;
    private String content;
    @JsonSetter("due")
    private DueProxyModel due;
    private Long id;
    private Integer indent;
    @JsonSetter("label_ids")
    private List<Long> lableIds;
    private Integer order;
    private Integer priority;
    @JsonSetter("project_id")
    private Long projectId;
    public Boolean getCompleted()
    {
        return completed;
    }

    public void setCompleted(Boolean completed)
    {
        this.completed = completed;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public DueProxyModel getDue()
    {
        return due;
    }

    public void setDue(DueProxyModel due)
    {
        this.due = due;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Integer getIndent()
    {
        return indent;
    }

    public void setIndent(Integer indent)
    {
        this.indent = indent;
    }

    public List<Long> getLableIds()
    {
        return lableIds;
    }

    public void setLableIds(List<Long> lableIds)
    {
        this.lableIds = lableIds;
    }

    public Integer getOrder()
    {
        return order;
    }

    public void setOrder(Integer order)
    {
        this.order = order;
    }

    public Integer getPriority()
    {
        return priority;
    }

    public void setPriority(Integer priority)
    {
        this.priority = priority;
    }

    public Long getProjectId()
    {
        return projectId;
    }

    public void setProjectId(Long projectId)
    {
        this.projectId = projectId;
    }
}

class DueProxyModel{
    /* ToDo: Come back and look at timezones. Somethign wonky here */
    @JsonSetter("date")
    private Date date;
    @JsonSetter("dateTime")
    private Timestamp datetime;
    @JsonSetter("string")
    private String dateString;
    private Boolean recurring;
    @JsonSetter("timezone")
    private String timeZone;

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getTimeZone()
    {
        return timeZone;
    }

    public void setTimeZone(String timeZone)
    {
        this.timeZone = timeZone;
    }
    public Timestamp getDatetime()
    {
        return datetime;
    }

    public void setDatetime(Timestamp datetime)
    {
        this.datetime = datetime;
    }

    public String getDateString()
    {
        return dateString;
    }

    public void setDateString(String dateString)
    {
        this.dateString = dateString;
    }

    public Boolean getRecurring()
    {
        return recurring;
    }

    public void setRecurring(Boolean recurring)
    {
        this.recurring = recurring;
    }

}


/*
{
        "comment_count": 10,
        "completed": true,
        "content": "My task",
        "due": {
        "date": "2016-09-01",
        "recurring": true,
        "datetime": "2016-09-01T09:00:00Z",
        "string": "tomorrow at 12",
        "timezone": "Europe/Moscow"
        },
        "id": 1234,
        "indent": 1,
        "label_ids": [
        124,
        125,
        128
        ],
        "order": 123,
        "priority": 1,
        "project_id": 2345,
        "url": "https://todoist.com/showTask?id=12345&sync_id=56789"
        }*/
