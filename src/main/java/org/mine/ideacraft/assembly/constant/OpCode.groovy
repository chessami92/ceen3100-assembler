package org.mine.ideacraft.assembly.constant

/**
 * Created with IntelliJ IDEA. by Joshua
 * Date: 9/18/12 Time: 11:39 PM
 */
public enum OpCode {
    REGISTER('000000'),
    LOAD('000001'),
    STORE('000010'),
    BRANCH_EQUAL('000011')

    private final String code

    OpCode(String code) {
        this.code = code
    }

    String toString() {
        code
    }
}