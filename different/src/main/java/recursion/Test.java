package recursion;

public class Test {

    public static void main(String[] args) {

        //int arr[] = new int[]{20,-10,-30,20,30,-50,20,-30,20,20};
        //int arr[] = new int[]{-20,-10,30,-20,-10,50,-20,-30,20,-20};
        int arr[] = new int[]{-50,-10,80,-110,200,-80,-20,-60,-30,-20};
        //Diff diff = new Rec(arr);
        //diff.delta(0,0);
        getDays(arr);

    }

    private static void getDays(int arr[]){

        int index = 0;
        int diff = 0;

        for (int i : arr) {

            int dif = (i) + (diff);

            if (index != 0 && (diff > 0 && dif < 0 || diff < 0 && dif > 0 ||
                               diff == 0 && arr[index] < 0 && arr[index-1] < 0 ||
                               diff == 0 && arr[index] > 0 && arr[index-1] > 0)){
                int day = index;
                System.out.println("day is : " + ++day);
            }

            diff = dif;
            index++;

        }
    }
}
