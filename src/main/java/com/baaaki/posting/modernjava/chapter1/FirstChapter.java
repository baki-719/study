package com.baaaki.posting.modernjava.chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FirstChapter {

    public void practice() {
        List<Integer> sampleList = List.of(1,2,3,4,5,6,7,8);
        sampleList.forEach(System.out::println);

        // 람다, 스트림 예시
        List<Integer> oddNumberList = sampleList.stream()
                .filter(item -> item % 2 == 1)
                .collect(Collectors.toList());

        // 예전의 방식
        List<Integer> oldWayOddNumberList = new ArrayList<>();
        for(Integer temp : sampleList) {
            if(temp % 2 == 1)
                oldWayOddNumberList.add(temp);
        }
    }

}


