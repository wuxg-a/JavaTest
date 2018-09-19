package com.wxg.generic.test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/**
 * Created by wuxg-a on 2018/9/17.
 */
public class Copy {

    public static void main(String[] args) {
        List<? extends Fruit> list1 = new ArrayList<>(1);



//        list1.add(new Apple(100));
//        list1.add(new Orange(50));

        //copy(list2, list1);

        Object object = list1.get(0);
        if(object instanceof Apple){
            Apple apple = (Apple)object;
        }else if(object instanceof Orange){
            Orange orange = (Orange)object;

        }
    }


//    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
//        int srcSize = src.size();
////        if (srcSize > dest.size())
////            throw new IndexOutOfBoundsException("Source does not fit in dest");
//
//        if (srcSize < 100 ||
//                (src instanceof RandomAccess && dest instanceof RandomAccess)) {
//            for (int i=0; i<srcSize; i++)
//                dest.set(i, src.get(i));
//        } else {
//            ListIterator<? super T> di=dest.listIterator();
//            ListIterator<? extends T> si=src.listIterator();
//            for (int i=0; i<srcSize; i++) {
//                di.next();
//                di.set(si.next());
//            }
//        }
//    }
}
