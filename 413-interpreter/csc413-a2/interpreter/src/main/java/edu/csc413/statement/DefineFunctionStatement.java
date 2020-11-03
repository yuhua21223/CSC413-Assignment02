package edu.csc413.statement;

import edu.csc413.interpreter.ProgramState;

import java.util.List;

public class DefineFunctionStatement extends Statement{
    private String functionName;
    private List<String> paramNames;
    private List<Statement> functionStatements;

    public DefineFunctionStatement(String functionName, List<String> paramNames, List<Statement> functionStatements ){
        this.functionName = functionName;
        this.paramNames = paramNames;
        this.functionStatements = functionStatements;
    }

    @Override
    public void run(ProgramState programState) {
        programState.setFunctionParameter(functionName, paramNames);
        programState.setFunctionStatement(functionName, functionStatements);
    }
}
