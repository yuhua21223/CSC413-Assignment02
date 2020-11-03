package edu.csc413.statement;

import edu.csc413.expression.Expression;
import edu.csc413.interpreter.ProgramState;

import edu.csc413.expression.VariableExpression;

public class AssignStatement extends Statement {

    private Expression expression;
    private String variableName;
    private int value;

    public AssignStatement(String variableName, Expression expression){
        if(!variableName.matches(VariableExpression.VARIABLE_NAME_PATTERN.pattern())){
            throw new RuntimeException("The following variable is invalid : " + variableName);
        }
        this.variableName = variableName;
        this.expression = expression;
    }

    @Override
    public void run(ProgramState programState){
        int value = expression.evaluate(programState);
        programState.setVariable(variableName, value);

    }
    }


