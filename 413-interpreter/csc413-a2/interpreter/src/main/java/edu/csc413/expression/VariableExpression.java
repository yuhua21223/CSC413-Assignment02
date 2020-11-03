package edu.csc413.expression;

import edu.csc413.interpreter.ProgramState;
import java.util.regex.Pattern;

public class VariableExpression extends Expression {

    public static final Pattern VARIABLE_NAME_PATTERN = Pattern.compile("^[A-Za-z][A-Za-z0-9_]*$");

    final private String variableName;
    private int value;

    public VariableExpression(String variableName){
        if(!variableName.matches(VARIABLE_NAME_PATTERN.pattern()))
        {
            throw new RuntimeException("b.Invalid Variable : " + variableName);
        }
        this.variableName = variableName;
    }

    @Override
    public int evaluate(ProgramState programState){
        return programState.getVariable(variableName);
    }

}
