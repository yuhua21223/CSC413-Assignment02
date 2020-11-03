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

    private final Map<String, List<String>> Params = new HashMap<>();
    private final Map<String, List<Statement>> States = new HashMap<>();


    private final Map<String,Integer> variableExpressionMap;


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

        Map<String, Integer> newMap = new HashMap();
        state.push(newMap);
    }

    public void removeCurrentCallFrame() {
        // TODO: Implement.
        state.pop();

    }


    // TODO: Define and implement methods for setting and retrieving a function's list of parameter names given the
    //       function name, along with the corresponding instance variables.

    public void setFunctionParameter(String functionName, List<String> paramName){
        if(!Params.containsKey(functionName))
         Params.put(functionName, paramName);
    }
    public List<String> getFunctionParameter(String name){
        return Params.get(name);
    }
    // TODO: Define and implement methods for setting and retrieving a function's list of Statements representing its
    //       body given the function name, along with the corresponding instance variables.



    public List<Statement> getStates(String name) {
        return States.get(name);
    }

    public void setFunctionStatement(String functionName, List<Statement> States) {
    }


    public boolean hasReturnValue() {
        // TODO: Implement.
        return ValReturn;
    }

    public int getReturnValue() {
        // TODO: Implement.
        return value;
    }

    public void setReturnValue(int value) {
        // TODO: Implement.
        ValReturn = true;
        this.value = value;
    }

    public void clearReturnValue() {
        // TODO: Implement.
        ValReturn = false;
        this.value = 0;
    }

}
