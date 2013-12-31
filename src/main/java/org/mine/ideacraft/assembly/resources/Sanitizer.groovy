package org.mine.ideacraft.assembly.resources

/**
 * Created with IntelliJ IDEA. by Joshua
 * Date: 9/19/12 Time: 12:04 AM
 */
class Sanitizer {
    static String[] parse(String string) {
        string = sanitize(string)
        def split = string.split(",")
        def splitAgain = split[0].split(" ")
        splitAgain += split[1..split.length - 1]
        removeWhitespace(splitAgain.flatten())
    }

    static String sanitize(String string) {
        string = string.toUpperCase()
        removeExcessiveWhitespace(string)
    }

    static String removeExcessiveWhitespace(String string) {
        boolean hasNextWhiteSpace = true
        while(hasNextWhiteSpace){
            string = string.replace("\t", "").replace("  ", " ")
            if(string.indexOf("\t") == -1 && string.indexOf("  ") == -1) hasNextWhiteSpace = false
        }
        string
    }

    static ArrayList<String> removeWhitespace(ArrayList<String> string) {
        def newList = []
        string.each {
            newList += it.replaceAll(" ", "")
        }
        newList
    }
}
