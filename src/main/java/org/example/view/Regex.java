package org.example.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Regex {
    PIZZA_ORDER("(?<type>Small|Medium|Large) Pizza(?<toppings>.+)"),
    SANDWICH_ORDER("Sandwich(?<toppings>.+)")
    ;
    private final String regex ;

    Regex(String regex) {
        this.regex = regex;
    }

    private Matcher getMather(String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        matcher.matches();
        return matcher;
    }

    public boolean isMatch(String input) {
        return getMather(input).matches();
    }

    public boolean isFind(String input) {
        return getMather(input).find();
    }

    public String getGroup(String input, String group) {
        return getMather(input).group(group);
    }
}
