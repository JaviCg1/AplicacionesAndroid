package com.example.ejerciciofirebase1;

import java.util.ArrayList;
import java.util.List;

public class Parse {
    private static List<ListElement> l1 = new ArrayList<ListElement>();
    public static void setList(List<ListElement> l){
         l1 = l;

    }
    public static List getList(){
        return l1;
    }
}
