package com.FrankieRodriguez.dakboardtosmartthingsapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "originalAirDate", "category", "question", "answer" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class TriviaObject
{
    private String category;
    private String question;
    private String answer;
    private String originalAirDate;

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getQuestion()
    {
        return question;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public String getAnswer()
    {
        return answer;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

    public String getOriginalAirDate()
    {
        return originalAirDate;
    }

    public void setOriginalAirDate(String originalAirDate)
    {
        this.originalAirDate = originalAirDate;
    }



    public TriviaObject()
    {
        super();
    }

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}
