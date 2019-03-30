package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.ArrayRhymersFactory;
import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.ListRhymersFactory;
import edu.kis.vh.nursery.factory.RhymersFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class RhymersDemo {
    public static void main(String[] args) {
        RhymersFactory factory = new DefaultRhymersFactory();
        List<RhymersFactory> rhymersFactories = new ArrayList<>();
        rhymersFactories.add(new DefaultRhymersFactory());
        rhymersFactories.add(new ArrayRhymersFactory());
        rhymersFactories.add(new ListRhymersFactory());

        rhymersFactories.forEach(RhymersDemo::testRhymers);
    }

    private static void testRhymers(RhymersFactory factory) {
        DefaultCountingOutRhymer[] rhymers = {factory.getStandardRhymer(), factory.getFalseRhymer(),
                factory.getFIFORhymer(), factory.getHanoiRhymer()};

        for (int i = 1; i < 15; i++)
            for (int j = 0; j < 3; j++)
                rhymers[j].countIn(i);

        Random random = new Random();
        for (int i = 1; i < 15; i++)
            rhymers[3].countIn(random.nextInt(20));

        for (int i = 0; i < rhymers.length; i++) {
            while (!rhymers[i].callCheck())
                System.out.print(rhymers[i].countOut() + "  ");
            System.out.println();
    }

        System.out.println("total rejected is " + ((HanoiRhymer) rhymers[3]).reportRejected());

	}
	
}