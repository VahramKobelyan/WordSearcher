package com.koko.utils;


public class Constants {

    public static final String WRONG_ARGUEMNTS_COUNT_ERROR = "Please  provide two required arguments on the command line specifying:\n *  1) The keyword to search on\n *  2) The file name to search in\n Example: \njava -jar WordSearcher.jar he Text.txt";

    public static final String INCORRECT_KEYWORD = "Keyword's characters should be letters or digits";
    public static final String FILE_NOT_EXISTS = "A file with the specified pathname does not exist";
    public static final String IS_DIRECTORY = "Is not file";

    public static final String ALPHA_NEMERIC = "^[a-zA-Z0-9]+$";

}
