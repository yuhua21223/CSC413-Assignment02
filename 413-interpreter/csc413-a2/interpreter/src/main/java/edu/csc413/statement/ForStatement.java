package edu.csc413.statement;

import edu.csc413.expression.Condition;
import edu.csc413.interpreter.ProgramState;

import java.util.List;

public class ForStatement extends LoopStatement{

    private Statement initializedState;
    private Statement updatedState;

    public ForStatement(Condition condition, Statement updatedState, Statement initializedState, List<Statement> blockStatement) {
        super(condition, blockStatement);
        this.initializedState = initializedState;
        this.updatedState = updatedState;
    }

    @Override
    protected void runInitialization(ProgramState programState) {
        initializedState.run(programState);
    }

    @Override
    protected void runUpdate(ProgramState programState) {
        updatedState.run(programState);
    }
}
