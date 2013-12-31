package org.mine.ideacraft.assembly.resources

import org.mine.ideacraft.assembly.constant.InstructionCodes
import org.mine.ideacraft.assembly.constant.OpCode

/**
 * Created with IntelliJ IDEA. by Joshua
 * Date: 9/19/12 Time: 8:35 PM
 */
class InstructionBuilder {
    static String processInstruction(String assemblyInstruction) {
        def line = Sanitizer.parse(assemblyInstruction)

        InstructionCodes instructionCodes = Enum.valueOf(InstructionCodes.class, line[0])

        if (instructionCodes.opCode.equals(OpCode.REGISTER.toString()))
            processRegisterInstruction(instructionCodes, line[1], line[2], line[3])
        else if (instructionCodes.opCode.equals(OpCode.LOAD.toString()))
            processLoadInstruction(instructionCodes, line[1], line[2], line[3])
        else if (instructionCodes.opCode.equals(OpCode.STORE.toString()))
            processStoreInstruction(instructionCodes, line[1], line[2], line[3])
        else if (instructionCodes.opCode.equals(OpCode.BRANCH_EQUAL.toString()))
            processBranchEqualInstruction(instructionCodes, line[1], line[2], line[3])
    }

    static String processRegisterInstruction(InstructionCodes instructionCodes, String rd, String rs, String rt) {
        return "${instructionCodes.opCode}_${getBinaryRegisterValue(rs)}_${getBinaryRegisterValue(rt)}_${getBinaryRegisterValue(rd)}_00000_$instructionCodes.functionCode"
    }

    static String processLoadInstruction(InstructionCodes instructionCodes, String rd, String rs, String immediate) {
        return "${instructionCodes.opCode}_${getBinaryRegisterValue(rs)}_${getBinaryRegisterValue(rd)}_${getBinaryImmediateValue(immediate)}"
    }

    static String processStoreInstruction(InstructionCodes instructionCodes, String rs, String rt, String immediate) {
        return "${instructionCodes.opCode}_${getBinaryRegisterValue(rt)}_${getBinaryRegisterValue(rs)}_${getBinaryImmediateValue(immediate)}"
    }

    static String processBranchEqualInstruction(InstructionCodes instructionCodes, String rs, String rt, String immediate) {
        return "${instructionCodes.opCode}_${getBinaryRegisterValue(rs)}_${getBinaryRegisterValue(rt)}_${getBinaryImmediateValue(immediate)}"
    }

    static String getBinaryRegisterValue(String register) {
        def index = register.replace("R","")
        Integer.toBinaryString(index as int).padLeft(5,"0")
    }

    static String getBinaryImmediateValue(String immediate){
        def binaryImmediate = Integer.toBinaryString(immediate as int)
        if(binaryImmediate.length() > 16)
            binaryImmediate = binaryImmediate[binaryImmediate.length()-16..binaryImmediate.length()-1]

        binaryImmediate.padLeft(16,"0")
    }
}

