package com.example.poject1.util;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Util {


    private static final Random RANDOM = new Random();
    private static final String DATE = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

    public static String generateDate(){
        return DATE;
    }

    public static int generateId() {
        return  RANDOM.nextInt(Integer.MAX_VALUE);
    }

       public static float DpToPx(Context context, float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }
}
