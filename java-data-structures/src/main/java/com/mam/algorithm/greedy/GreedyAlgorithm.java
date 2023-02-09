package com.mam.algorithm.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author Anmin
 * @Date 2023/02/03
 * 贪心算法 -> 解决集合覆盖问题
 **/
public class GreedyAlgorithm {
    public static void main(String[] args) {
        //创建广播电台，放入到map中
        HashMap<String, HashSet<String>> broadcast = new HashMap<>();
        HashSet<String> set1 = new HashSet<>();
        set1.add("北京");
        set1.add("上海");
        set1.add("天津");

        HashSet<String> set2 = new HashSet<>();
        set2.add("广州");
        set2.add("北京");
        set2.add("深圳");

        HashSet<String> set3 = new HashSet<>();
        set3.add("成都");
        set3.add("上海");
        set3.add("杭州");

        HashSet<String> set4 = new HashSet<>();
        set4.add("上海");
        set4.add("天津");

        HashSet<String> set5 = new HashSet<>();
        set5.add("杭州");
        set5.add("大连");

        broadcast.put("k1",set1);
        broadcast.put("k2",set2);
        broadcast.put("k3",set3);
        broadcast.put("k4",set4);
        broadcast.put("k5",set5);

        HashSet<String> allAreas = new HashSet<>();

        Set<String> keySet = broadcast.keySet();
        for (String key : keySet) {
            HashSet<String> set = broadcast.get(key);
            for (String city : set) {
                allAreas.add(city);
            }
        }
        ArrayList<String> selector = new ArrayList<>();
        HashSet<String> tempSet = new HashSet<>();
        String maxKey = null;
        while (allAreas.size() != 0){
            maxKey = null;
            for (String key : broadcast.keySet()) {
                tempSet.clear();
                HashSet<String> areas = broadcast.get(key);
                tempSet.addAll(areas);
                tempSet.retainAll(allAreas);
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcast.get(maxKey).size())){
                    maxKey = key;
                }
            }
            if (maxKey != null){
                selector.add(maxKey);
                allAreas.removeAll(broadcast.get(maxKey));
            }
        }

        System.out.println("最优的电台： " + selector);

    }
}
