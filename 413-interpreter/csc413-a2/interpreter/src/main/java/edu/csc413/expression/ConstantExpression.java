package edu.csc413.expression;

import edu.csc413.interpreter.ProgramState;

import java.util.regex.Pattern;

public class ConstantExpression extends Expression{

    //Please check this later
    public static final Pattern CONSTANT_PATTERN = Pattern.compile("^-?[0-9_]+$");

    private final int value;

    public ConstantExpression(int value){ this.value = value; }

    @Override
    public int evaluate(ProgramState programState){ return value; }
}
