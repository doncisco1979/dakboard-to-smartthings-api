package com.FrankieRodriguez.dakboardtosmartthingsapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TriviaProxyModel
{

    private Integer id;
    private String answer;
    private Integer value;
    private String question;
    private Timestamp airdate;
    private CategoryProxyModel category;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getAnswer()
    {
        return answer;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public Timestamp getAirdate()
    {
        return airdate;
    }

    public void setAirdate(Timestamp airdate)
    {
        this.airdate = airdate;
    }

    public CategoryProxyModel getCategory()
    {
        return category;
    }

    public void setCategory(CategoryProxyModel category)
    {
        this.category = category;
    }

    public Integer getValue()
    {
        return value;
    }

    public void setValue(Integer value)
    {
        this.value = value;
    }

    public TriviaProxyModel(){

    }
}

/*
{
        "id": 148940,
        "answer": "(George) Mitchell",
        "question": "This former Maine senator helped broker a peace deal in Northern Ireland",
        "value": 1000,
        "airdate": "2014-03-04T12:00:00.000Z",
        "created_at": "2015-01-22T02:35:53.931Z",
        "updated_at": "2015-01-22T02:35:53.931Z",
        "category_id": 17236,
        "game_id": 4439,
        "invalid_count": null,
        "category": {
        "id": 17236,
        "title": "like it's 1998",
        "created_at": "2015-01-18T18:12:19.420Z",
        "updated_at": "2015-01-18T18:12:19.420Z",
        "clues_count": 10
        }
        }*/
