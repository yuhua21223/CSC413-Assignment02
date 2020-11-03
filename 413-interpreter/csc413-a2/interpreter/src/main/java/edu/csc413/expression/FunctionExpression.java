package edu.csc413.expression;

import edu.csc413.interpreter.ProgramState;
import edu.csc413.statement.Statement;


import java.util.ArrayList;
import java.util.List;

public class FunctionExpression extends Expression{

    private String functionName;
    private List<Expression> parameterValues;
    public FunctionExpression(String functionName, List<Expression> parameterValues){
        this.functionName = functionName;
        this.parameterValues = parameterValues;
    }

    @Override
    public int evaluate(ProgramState programState) {
        List<String> getParamName = programState.getFunctionParameter(functionName);
        List<Statement> StateList = programState.getFunctionStatements(functionName);

        List<Integer> paramVal = new ArrayList<>();

        for (Expression funcParameter : parameterValues) {
            paramVal.add(funcParameter.evaluate(programState));
        }

        programState.addNewCallFrame();
        for (int i = 0; i < parameterValues.size(); i++) {
            programState.setVariable(getParamName.get(i), paramVal.get(i));
        }
        // By iterating through the program , we cna check if there is a return statement
        for (Statement s : StateList) {
            if(!programState.hasReturnValue()) {
                s.run(programState);
            }
        }

        int val = programState.getReturnValue();
        boolean tempReturnValue = programState.hasReturnValue();

        programState.removeCurrentCallFrame();
        programState.clearReturnValue();
            if(tempReturnValue)return val;

        return 0;
    }

}
