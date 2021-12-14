package airbnb;

import java.util.ArrayList;
import java.util.List;

public class QueueWithFixedArray {
    private int fixedSize;
    private int count;
    private int headPtr;
    private int tailPtr;
    private List<Object> headList;
    private List<Object> tailList;

    public QueueWithFixedArray(int fixedSize) {
        this.fixedSize = fixedSize;
        this.count = 0;
        this.headPtr = 0;
        this.tailPtr = 0;
        this.headList = new ArrayList<>();
        this.tailList = this.headList;
    }

    public void offer(int num) {
        if (tailPtr == fixedSize - 1) {
            List<Object> newList = new ArrayList<>();
            newList.add(num);
            tailList.add(newList);
            tailList = newList; // (List<Object>)tailList.get(tailPtr);
            tailPtr = 0;
        } else {
            tailList.add(num);
        }
        count++;
        tailPtr++;
    }

    public Integer poll() {
        if (count == 0) {
            return null;
        }

        int num = (int)headList.get(headPtr);
        headPtr++;
        count--;

        if (headPtr == fixedSize - 1) {
            List<Object> newList = (List<Object>)headList.get(headPtr);
            headList.clear();
            headList = newList;
            headPtr = 0;
        }
        return num;
    }

    public int size() {
        return count;
    }
}