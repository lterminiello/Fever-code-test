package com.lterminiello.ferverstar.utils;

import com.lterminiello.ferverstar.model.Area;
import com.lterminiello.ferverstar.model.Betazoid;
import com.lterminiello.ferverstar.model.Human;
import com.lterminiello.ferverstar.model.Member;
import com.lterminiello.ferverstar.model.Vulcan;
import java.util.List;

public class GeneratorCrew {

    public static List<Member> getCrew() {
        final List<Member> crew = Lists.newArrayList();
        final int numberCrew = randomNumber(423,1000);
        for (int i = 0; i < numberCrew; i++) {
            final int race = randomNumber(1,3);
            Member member;
            switch (race) {
            case 1:
                member = new Human(randomNumber(1 , (int)System.currentTimeMillis()),Area.randomArea());
                break;
            case 2:
                member = new Vulcan(randomNumber(1 , (int)System.currentTimeMillis()),Area.randomArea());
                break;
            default:
                member = new Betazoid(randomNumber(1 , (int)System.currentTimeMillis()),Area.randomArea());
            }
            crew.add(member);
        }
        return crew;
    }

    private static int randomNumber(int min, int max) {
        return (int) (Math.random() * max) + min;
    }
}
