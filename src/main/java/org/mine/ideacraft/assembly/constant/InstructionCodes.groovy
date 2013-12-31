package org.mine.ideacraft.assembly.constant

/**
 * Created with IntelliJ IDEA. by Joshua
 * Date: 9/18/12 Time: 11:53 PM
 */
public enum InstructionCodes {
    ADD(OpCode.REGISTER, "000000"),
    SUB(OpCode.REGISTER, "000001"),
    AND(OpCode.REGISTER, "000010"),
    OR(OpCode.REGISTER, "000011"),
    SLT(OpCode.REGISTER, "000100"),
    LW(OpCode.LOAD),
    SW(OpCode.STORE),
    BEQ(OpCode.BRANCH_EQUAL)

    private final String opCode
    private final String functionCode

    InstructionCodes(OpCode opCode, String functionCode) {
        this.opCode = opCode.code
        this.functionCode = functionCode
    }

    InstructionCodes(OpCode opCode) {
        this.opCode = opCode.code
    }

    String getOpCode() {
        opCode
    }

    String getFunctionCode(){
        functionCode
    }
}