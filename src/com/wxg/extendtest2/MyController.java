package com.wxg.extendtest2;

import com.wxg.extendtest1.BaseController;
import org.codehaus.jackson.map.Serializers;

/**
 * Created by wuxg-a on 2019/3/29.
 */
public class MyController extends BaseController {

    public int num = 2;

    public int Test(){
        System.out.println("My:" + this.num);
        return getNum();
    }

}
