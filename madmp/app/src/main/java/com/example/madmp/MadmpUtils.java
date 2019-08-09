package com.example.madmp;

import java.util.ArrayList;

public class MadmpUtils {
    public static String convertArrayListToString (ArrayList<String> arrayList)
    {
        StringBuilder sb = new StringBuilder();
        for (String s : arrayList)
        {
            sb.append(s);
            sb.append("|");
        }

        System.out.println(sb.toString());
        return sb.toString();
    }
}
