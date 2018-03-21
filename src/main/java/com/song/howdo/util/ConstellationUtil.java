package com.song.howdo.util;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by songchao on 2018/3/21.
 */
public class ConstellationUtil {
    private static List<Map<String, Object>> LIST = null;
    private static float[][] floatXingZuo = null;



    public String getXingZuoName(Date birthday) {
        SimpleDateFormat monthFormatter = new SimpleDateFormat("MM");
        String monthDate = monthFormatter.format(birthday);
        SimpleDateFormat dayFormatter = new SimpleDateFormat("dd");
        String dayDate = dayFormatter.format(birthday);

        int month = Integer.parseInt(monthDate);
        int day = Integer.parseInt(dayDate);

        if (floatXingZuo == null)
            floatXingZuo = loadXingZuoFloatValue();

        String ds = String.format("%02d", day);
        float target = Float.valueOf(month + "." + ds);

        boolean bool1 = Float.compare(target, 12.22f) >= 0 ? true : false;
        boolean bool2 = Float.compare(target, 1.20f) <= 0 ? true : false;
        if (bool1 || bool2) {
            return "摩羯座";
        }

        int i;
        boolean b1, b2;
        for (i = 0; i < 12; i++) {

            b1 = Float.compare(target, floatXingZuo[0][i]) >= 0 ? true : false;
            b2 = Float.compare(target, floatXingZuo[1][i]) <= 0 ? true : false;

            if (b1 && b2)
                break;
        }

        Map map = (Map) (LIST.get(i));

        return map.get("XINGZUO_NAME") + "";
    }

    private static float[][] loadXingZuoFloatValue() {
        if (LIST == null)
            LIST = loadXingZuo12();

        Map map = null;
        // String xzname=null;
        int mind, maxd, minm, maxm;

        float[][] fxingzuo = new float[2][12];

        float start, end;
        for (int i = 0; i < 12; i++) {
            map = (Map) (LIST.get(i));

            mind = Integer.parseInt(map.get("MIN_DAY") + "");
            maxd = Integer.parseInt(map.get("MAX_DAY") + "");
            minm = Integer.parseInt(map.get("MIN_MONTH") + "");
            maxm = Integer.parseInt(map.get("MAX_MONTH") + "");

            start = Float.valueOf(minm + "." + mind);
            end = Float.valueOf(maxm + "." + maxd);

            fxingzuo[0][i] = start;
            fxingzuo[1][i] = end;
        }

        return fxingzuo;
    }

    private static List loadXingZuo12() {
        String XINGZUO_NAME = "XINGZUO_NAME";

        String MIN_DAY = "MIN_DAY";
        String MIN_MONTH = "MIN_MONTH";
        String MAX_DAY = "MAX_DAY";
        String MAX_MONTH = "MAX_MONTH";

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;

        map = new HashMap<String, Object>();
        map.put(XINGZUO_NAME, "白羊座");
        map.put(MIN_DAY, 21);
        map.put(MAX_DAY, 20);
        map.put(MIN_MONTH, 3);
        map.put(MAX_MONTH, 4);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put(XINGZUO_NAME, "金牛座");
        map.put(MIN_DAY, 21);
        map.put(MAX_DAY, 21);
        map.put(MIN_MONTH, 4);
        map.put(MAX_MONTH, 5);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put(XINGZUO_NAME, "双子座");
        map.put(MIN_DAY, 22);
        map.put(MAX_DAY, 21);
        map.put(MIN_MONTH, 5);
        map.put(MAX_MONTH, 6);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put(XINGZUO_NAME, "巨蟹座");
        map.put(MIN_DAY, 22);
        map.put(MAX_DAY, 22);
        map.put(MIN_MONTH, 6);
        map.put(MAX_MONTH, 7);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put(XINGZUO_NAME, "狮子座");
        map.put(MIN_DAY, 23);
        map.put(MAX_DAY, 23);
        map.put(MIN_MONTH, 7);
        map.put(MAX_MONTH, 8);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put(XINGZUO_NAME, "处女座");
        map.put(MIN_DAY, 24);
        map.put(MAX_DAY, 23);
        map.put(MIN_MONTH, 8);
        map.put(MAX_MONTH, 9);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put(XINGZUO_NAME, "天秤座");
        map.put(MIN_DAY, 24);
        map.put(MAX_DAY, 23);
        map.put(MIN_MONTH, 9);
        map.put(MAX_MONTH, 10);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put(XINGZUO_NAME, "天蝎座");
        map.put(MIN_DAY, 24);
        map.put(MAX_DAY, 22);
        map.put(MIN_MONTH, 10);
        map.put(MAX_MONTH, 11);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put(XINGZUO_NAME, "射手座");
        map.put(MIN_DAY, 23);
        map.put(MAX_DAY, 21);
        map.put(MIN_MONTH, 11);
        map.put(MAX_MONTH, 12);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put(XINGZUO_NAME, "摩羯座");
        map.put(MIN_DAY, 22);
        map.put(MAX_DAY, 20);
        map.put(MIN_MONTH, 12);
        map.put(MAX_MONTH, 1);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put(XINGZUO_NAME, "水瓶座");
        map.put(MIN_DAY, 21);
        map.put(MAX_DAY, 19);
        map.put(MIN_MONTH, 1);
        map.put(MAX_MONTH, 2);
        list.add(map);

        map = new HashMap<String, Object>();
        map.put(XINGZUO_NAME, "双鱼座");
        map.put(MIN_DAY, 20);
        map.put(MAX_DAY, 20);
        map.put(MIN_MONTH, 2);
        map.put(MAX_MONTH, 3);
        list.add(map);

        return list;
    }
}