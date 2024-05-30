package com.ksh.soundstory.regexes;

public class Regex {
    public final String expression;

    public Regex(String expression) {
        this.expression = expression;
    }

    public boolean tests(String input, boolean allowNullOrEmpty) {
        if (input == null || input.isEmpty()) {
            return allowNullOrEmpty;
        }
        return input.matches(this.expression);
    }
}
