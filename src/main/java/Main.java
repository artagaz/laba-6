import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Collections
        CollectionsTask Col = new CollectionsTask();

        //array
        System.out.println("Array: "+Arrays.toString(Col.A));
        //list
        Col.B = Col.ListFromArray(Col.A);
        System.out.println("List from array: "+Col.B);
        //sort up
        Col.SortUp(Col.B);
        System.out.println("Sorted up list: "+Col.B);
        //sort down
        Col.SortDown(Col.B);
        System.out.println("Sorted down list: "+Col.B);
        //shuffle
        Col.Shuffle(Col.B);
        System.out.println("shuffled list: "+Col.B);
        //right 1
        Col.RightOne(Col.B);
        System.out.println("Moved list: "+Col.B);
        //unique
        System.out.println("Unique list: "+Col.UnicueList(Col.B));
        //non unique
        System.out.println("Not unique list: "+Col.NonUnicueList(Col.B));
        //list to array
        System.out.println("Array from list: "+ Arrays.toString(Col.ListToArray(Col.B)));
        //Count
        System.out.println("Count numbers: "+Col.Counter(Col.ListToArray(Col.B)));

        //Primes
        PrimesGenerator P = new PrimesGenerator();
        System.out.println("First n primes: "+ P.getFirstPrimes(100));

    }
}

//Collections
class CollectionsTask{
    public Integer[] A;
    public List<Integer> B;

    //array
    CollectionsTask() {
        A = new Integer[100];
        B = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            A[i] = ((int) (Math.random()*100));
        }
    }

    //list from array
    List<Integer> ListFromArray(Integer[] A){
        List<Integer> B = new ArrayList<Integer>(Arrays.asList(A));
        return B;
    }

    //sort up
        void SortUp(List<Integer> A){
            Collections.sort(A);
        }

    //sort down
        void SortDown(List<Integer> A){
            A.sort(Collections.reverseOrder());
        }

    //shuffle
        void Shuffle(List<Integer> A){
            Collections.shuffle(A);
        }

    //right 1
        void RightOne(List<Integer> A){
            A.addFirst(A.getLast());
            A.removeLast();
        }

    //unique
    List<Integer> UnicueList(List<Integer> A){
        HashSet hashSet = new HashSet(A);
        return new ArrayList<>(hashSet);
    }


    //non-unique
    List<Integer> NonUnicueList(List<Integer> A){
        List<Integer> nonUniqueList = new ArrayList<>();
        Map<Integer, Integer> counter = new HashMap<>();
        for (Integer key : A) {
            counter.put(key, counter.getOrDefault(key, 0) + 1);
        }

        for (Integer key : A) {
            if (counter.get(key) > 1) {
                nonUniqueList.add(key);
            }
        }

        return nonUniqueList;
    }
    //List to Array
    Integer[] ListToArray(List<Integer> A){
        return A.toArray(new Integer[0]);
    }

    //counter
    Map<Integer, Integer>  Counter(Integer[] A){
        Map<Integer, Integer> counter = new HashMap<>();
        for (Integer key : A) {
            counter.put(key, counter.getOrDefault(key, 0) + 1);
        }

        return counter;
    }
}


//Primes
class PrimesGenerator {

    public List<Integer> getFirstPrimes(int count) {
        List<Integer> primes = new ArrayList<>();
        if (count > 0) {
            primes.add(2);
        }
        for (var i = 3; primes.size() < count; i += 2) {
            if (isPrime(i, primes)) {
                primes.add(i);
            }
        }
        return primes;
    }

    private boolean isPrime(int n, List<Integer> primes) {
        double sqrt = Math.sqrt(n);
        for (var i = 0; i < primes.size(); i++) {
            var prime = primes.get(i);
            if (prime > sqrt) {
                return true;
            }
            if (n % prime == 0) {
                return false;
            }
        }
        return true;
    }

}

class PrimesGeneratorTest{
    PrimesGenerator prim = new PrimesGenerator();
    List<Integer> A = prim.getFirstPrimes(100);

    void ShowPrimes(List<Integer> A){

    }
}