package edu.csc413.interpreter;

import edu.csc413.statement.Statement;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.*;

/**
 * A class which tracks the state of a running program. ProgramState should maintain a call stack, with each call frame
 * tracking variable names and their corresponding values. ProgramState should also keep track of function definitions,
 * so that when function calls are made, they can be run and evaluated.
 */
public class ProgramState {

    private final Map<String,Integer> variableExpressionMap;

    private final Map<String, List<String>> functionParameters = new HashMap<>();
    private final Map<String, List<Statement>> functionStatements = new HashMap<>();

    private final Stack<Map<String, Integer>> state = new Stack<>();
    private int value = 0;
    private Boolean hasReturnValue = false;

    public Stack<Map<String, Integer>> getState() {
        return state;
    }

    public ProgramState() {
        variableExpressionMap = new TreeMap<>();
    }

    public int getVariable(String variable) {
        // TODO: Implement.
        if(!variableExpressionMap.containsKey(variable))
            throw new RuntimeException("The following Key is not located : " + variable);
        return variableExpressionMap.get(variable);

    }

    public void setVariable(String variable, int value) {
        // TODO: Implement.
        variableExpressionMap.put(variable,value);

    }

    public void addNewCallFrame() {
        // TODO: Implement.

        Map<String, Integer> map = new HashMap();
        state.push(map);
    }

    public void removeCurrentCallFrame() {
        // TODO: Implement.
        //callFrames.pop();
    }


    // TODO: Define and implement methods for setting and retrieving a function's list of parameter names given the
    //       function name, along with the corresponding instance variables.

    public void setFunctionParameter(String functionName, List<String> paramName){
        if(!functionParameters.containsKey(functionName))
         functionParameters.put(functionName, paramName);
    }
    public List<String> getFunctionParameter(String name){
        return functionParameters.get(name);
    }
    // TODO: Define and implement methods for setting and retrieving a function's list of Statements representing its
    //       body given the function name, along with the corresponding instance variables.



    public List<Statement> getFunctionStatements(String name) {
        return functionStatements.get(name);
    }

    public void setFunctionStatement(String functionName, List<Statement> functionStatements) {
    }


    public boolean hasReturnValue() {
        // TODO: Implement.
        return hasReturnValue;
    }

    public int getReturnValue() {
        // TODO: Implement.
        return value;
    }

    public void setReturnValue(int value) {
        // TODO: Implement.
        hasReturnValue = true;
        this.value = value;
    }

    public void clearReturnValue() {
        // TODO: Implement.
        hasReturnValue = false;
        this.value = 0;
    }

}
