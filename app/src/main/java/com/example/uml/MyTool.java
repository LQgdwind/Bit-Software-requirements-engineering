package com.example.uml;

public class MyTool
{
    public static boolean isNumeric(String str)
    {
        for (int i = str.length();--i>=0;)
        {
            if (!Character.isDigit(str.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }
    public static int myAbs(int num)
    {
        if(num>=0) return num;
        else return -num;
    }
}
