package edu.csc413.statement;

import edu.csc413.expression.Condition;
import edu.csc413.interpreter.ProgramState;

import java.util.List;

public class WhileStatement extends LoopStatement {
    public WhileStatement(Condition condition, List<Statement> blockStatements) {
        super(condition, blockStatements);
    }

    @Override
    protected void runInitialization(ProgramState programState) {

    }

    @Override
    protected void runUpdate(ProgramState programState) {

    }

}

