package com.FrankieRodriguez.dakboardtosmartthingsapi;

import org.apache.commons.lang3.text.WordUtils;

import java.text.SimpleDateFormat;


public class TriviaService
{
    private static TriviaProxy triviaProxy;
    private static SimpleDateFormat df = new SimpleDateFormat("EEE, MMMM dd YYYY");

    public TriviaService(){
        triviaProxy = new TriviaProxy();
    }
    public TriviaObject getRandomTriviaQuestion(){
        TriviaObject returnItem = new TriviaObject();

        TriviaProxyModel model = triviaProxy.getRandomTrivia();

        returnItem.setAnswer(model.getAnswer());
        returnItem.setQuestion(model.getQuestion());
        returnItem.setCategory(WordUtils.capitalize(model.getCategory().getTitle()) + " for " + model.getValue() + " Alex");
        returnItem.setOriginalAirDate(df.format(model.getAirdate()));


        return returnItem;

    }
}
