package edu.kis.vh.nursery;

import edu.kis.vh.nursery.list.IntLinkedList;
import edu.kis.vh.nursery.list.StackableInterface;

public class DefaultCountingOutRhymer {

    private final int STACK_EMPTY_SIZE = -1;

    private StackableInterface intLinkedList;

    public DefaultCountingOutRhymer(StackableInterface intLinkedList) {
        this.intLinkedList = intLinkedList;
    }

    public DefaultCountingOutRhymer() {
        this.intLinkedList = new IntLinkedList();
    }

    public void countIn(int in) {
        intLinkedList.push(in);
    }

    public boolean callCheck() {
        return intLinkedList.isEmpty();
    }

    public boolean isFull() {
        return false;
    }

    public int peekaboo() {
        if(intLinkedList.isEmpty())
            return STACK_EMPTY_SIZE;
        return intLinkedList.top();
    }

    public int countOut() {
        return intLinkedList.pop();
    }
}


