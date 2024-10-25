import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter 1 to task 1;\n enter 2 to task 2;\n enter 3 to task 3;\n enter 4 to task4\n enter 5 to task 5\nenter any to exit;");
        int Select = 0;
        try {
            Select = scanner.nextInt();
        } catch (Exception ignored) {
        }
        switch (Select) {
            case 1:
                //Collections
                CollectionsTask Col = new CollectionsTask();

                //array
                System.out.println("Array: " + Arrays.toString(Col.A));
                //list
                Col.B = Col.ListFromArray(Col.A);
                System.out.println("List from array: " + Col.B);
                //sort up
                Col.SortUp(Col.B);
                System.out.println("Sorted up list: " + Col.B);
                //sort down
                Col.SortDown(Col.B);
                System.out.println("Sorted down list: " + Col.B);
                //shuffle
                Col.Shuffle(Col.B);
                System.out.println("shuffled list: " + Col.B);
                //right 1
                Col.RightOne(Col.B);
                System.out.println("Moved list: " + Col.B);
                //unique
                System.out.println("Unique list: " + Col.UnicueList(Col.B));
                //non unique
                System.out.println("Not unique list: " + Col.NonUnicueList(Col.B));
                //list to array
                System.out.println("Array from list: " + Arrays.toString(Col.ListToArray(Col.B)));
                //Count
                System.out.println("Count numbers: " + Col.Counter(Col.ListToArray(Col.B)));

                break;

            case 2:
                //Primes
                System.out.print("Enter number of primes: ");
                int primes = scanner.nextInt();

                PrimesGenerator P = new PrimesGenerator();
                System.out.println("First n primes: " + P.getFirstPrimes(primes));

                PrimesGeneratorTest Test = new PrimesGeneratorTest();
                System.out.println("Test for PrimesGenerator");
                Test.ShowPrimes(P.getFirstPrimes(primes));
                break;

            case 3:
                //Humans
                List<Human> H = new ArrayList<>();
                H.add(new Human("John", "Willson", 100));
                H.add(new Human("Jose", "Brown", 26));
                H.add(new Human("Thomas", "Scott", 45));
                H.add(new Human("Mario", "Roberts", 11));

                HashSet<Human> HHS = new HashSet<>(H);
                System.out.println("HashSet: ");
                for (Human i : HHS) {
                    System.out.println(i.HOut() + "\t");
                }

                System.out.println("\n\nLinkedHashSet: ");
                LinkedHashSet<Human> HLHS = new LinkedHashSet<>(H);
                for (Human i : HLHS) {
                    System.out.println(i.HOut() + "\t");
                }

                System.out.println("\n\nTreeSet w Comp : ");
                Comparator<Human> hcomp = new HumanSurameComparator();
                TreeSet<Human> HTS = new TreeSet<>(hcomp);
                HTS.addAll(H);
                for (Human i : HTS) {
                    System.out.println(i.HOut() + "\t");
                }//по фамилии

                System.out.println("\n\nTreeSet: ");

                TreeSet<Human> HTSA = new TreeSet<>(new Comparator<Human>() {
                    @Override
                    public int compare(Human A, Human B) {
                        int a = A.getAge();
                        int b = B.getAge();
                        return Integer.compare(b, a);
                    }
                });
                HTSA.addAll(H);
                for (Human i : HTSA) {
                    System.out.println(i.HOut() + "\t");
                }//по возрасту
                break;
            case 4:
                String str = "My family is quite big. It consists of my mother, father, my three siblings and our cat Bob. Well, most people would say that a pet is not a family member but no one in our family would agree with that. We all love Bob and consider him a family member.";
                str = str.toLowerCase();
                str = str.replaceAll("\\W", " ");

                Map<String, Integer> Wmap = new HashMap<>();
                for (String s : str.split(" ")) {
                    if (Wmap.containsKey(s)) {
                        Wmap.put(s, Wmap.get(s) + 1);
                    } else {
                        Wmap.put(s, 1);
                    }
                }
                Wmap.remove("");
                System.out.println(Wmap);
                break;
            case 5:
                HashMap<Integer, String> Map = new HashMap<>();

                Map.put(1, "one");
                Map.put(2, "two");
                Map.put(3, "three");
                Map.put(4, "four");

                HashMap<String, Integer> newMap = new HashMap<>();

                for (Map.Entry<Integer, String> i : Map.entrySet()) {
                    newMap.put(i.getValue(), i.getKey());
                }
                System.out.println(Map);
                System.out.println(newMap);
                break;
            default:
                System.out.println("Exit.");
                break;
        }

    }
}

//Collections
class CollectionsTask {
    public Integer[] A;
    public List<Integer> B;

    //array
    CollectionsTask() {
        A = new Integer[100];
        B = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            A[i] = ((int) (Math.random() * 100));
        }
    }

    //list from array
    List<Integer> ListFromArray(Integer[] A) {
        List<Integer> B = new ArrayList<Integer>(Arrays.asList(A));
        return B;
    }

    //sort up
    void SortUp(List<Integer> A) {
        Collections.sort(A);
    }

    //sort down
    void SortDown(List<Integer> A) {
        A.sort(Collections.reverseOrder());
    }

    //shuffle
    void Shuffle(List<Integer> A) {
        Collections.shuffle(A);
    }

    //right 1
    void RightOne(List<Integer> A) {
        A.addFirst(A.getLast());
        A.removeLast();
    }

    //unique
    List<Integer> UnicueList(List<Integer> A) {
        HashSet hashSet = new HashSet(A);
        return new ArrayList<>(hashSet);
    }


    //non-unique
    List<Integer> NonUnicueList(List<Integer> A) {
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
    Integer[] ListToArray(List<Integer> A) {
        return A.toArray(new Integer[0]);
    }

    //counter
    Map<Integer, Integer> Counter(Integer[] A) {
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

class PrimesGeneratorTest {

    void ShowPrimes(List<Integer> A) {
        Iterator iterator = A.iterator();
        System.out.println("Normal: ");
        while (iterator.hasNext()) {
            System.out.print(" " + iterator.next());
        }

        iterator = A.reversed().iterator();
        System.out.println("\nReversed: ");
        while (iterator.hasNext()) {
            System.out.print(" " + iterator.next());
        }
    }
}


//Human
class Human {
    String Name;
    String Surname;
    int Age;

    Human(String N, String S, int A) {
        Name = N;
        Surname = S;
        Age = A;
    }

    String getName() {
        return Name;
    }

    String getSurname() {
        return Surname;
    }

    int getAge() {
        return Age;
    }

    String HOut() {
        return ("Name: " + Name + " Surname: " + Surname + " Age: " + Age);
    }

}

class HumanSurameComparator implements Comparator<Human> {

    public int compare(Human a, Human b) {

        return a.getSurname().compareTo(b.getSurname());
    }
}