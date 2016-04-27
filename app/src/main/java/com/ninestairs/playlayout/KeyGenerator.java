package com.ninestairs.playlayout;

import java.util.Random;

/**
 * Created by kangt2000 on 2016. 4. 20..
 */
public class KeyGenerator {
    /*
    * generate random key
    * */
    int range;

    public  KeyGenerator(int range){
        this.range = range;
    }

    public int generate(){
        return new Random().nextInt(this.range);
    }
}
