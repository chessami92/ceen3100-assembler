package org.mine.ideacraft.assembly.assembler

import org.mine.ideacraft.assembly.constant.InstructionCodes
import org.mine.ideacraft.assembly.resources.Sanitizer
import org.mine.ideacraft.assembly.resources.InstructionBuilder
import org.mine.ideacraft.assembly.constant.OpCode

/**
 * Created with IntelliJ IDEA. by Joshua
 * Date: 9/12/12 Time: 9:50 PM
 */
class Assembler {
    public static void main(String[] args){
        def path = "C:\\Users\\Joshua\\Desktop\\microprocessor\\assembly\\"
        def assembled = new File(path + "testAssembled.txt")
        assembled.delete()
        def i = 0;
        new File(path + "test.txt").eachLine{
            def memoryLocation = "memory[$i] =".padRight(12, " ")
            def binaryInstruction = (InstructionBuilder.processInstruction(it) + ";").padRight(38, " ")
            def assemblyInstruction = it//Sanitizer.removeExcessiveWhitespace(it)
            assembled << "$memoryLocation 32'b$binaryInstruction //$assemblyInstruction\r\n"
            ++i
        }
    }
}
