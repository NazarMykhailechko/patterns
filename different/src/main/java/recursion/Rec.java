package recursion;

import java.util.Arrays;

public class Rec implements Diff {

    private int[] arr;

    public Rec(int[] arr) {
        this.arr = arr;
    }

    @Override
    public int delta(int index, int diff) {

        if(index == arr.length){
            return arr[arr.length-1];
        }

        int dif = (arr[index]) + (diff);

        if (index != 0 && (diff > 0 && dif < 0 || diff < 0 && dif > 0 ||
                           diff == 0 && arr[index] < 0 && arr[index-1] < 0 ||
                           diff == 0 && arr[index] > 0 && arr[index-1] > 0)){
            int day = index;
            System.out.println("day is : " + ++day);
        }

        return delta(++index, dif);
    }
}
