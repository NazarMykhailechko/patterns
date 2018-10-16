package patterns.iterator;

public class TestIterator {

    public static void main(String[] args) {
        int[] arr = {0,22,11,54,32,11,78,99,25,88};

        Repository repository = new Repository(arr);
        Iterator myIterator = repository.getIterator();

        while(myIterator.hasNext()){
            System.out.println(myIterator.next());
        }
    }
}

interface Iterator{
    boolean hasNext();
    int next();
}


class Repository{

    private int[] num;

    public Repository(int[] num) {
        this.num = num;
    }

    public Iterator getIterator(){
        return new MyIterator();
    }

    private class MyIterator implements Iterator{

        private int index;

        @Override
        public boolean hasNext() {
            return index<num.length;
        }

        @Override
        public int next() {
            return num[index++];
        }
    }
}