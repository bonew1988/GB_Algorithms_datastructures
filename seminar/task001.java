package seminar;

import java.sql.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class task001 {
public static void main(String[] args) {
/* System.out.println("Hello world!");
int sum = (number + 1) * number / 2;

    long start = System.nanoTime();
    int number = 1004;
    int sum = 0;
    for (int i = 1; i <= number; i++, sum += i);
    long end = System.nanoTime();
    System.out.println(sum + " " + (end - start));

    int number = 60, cnt = 0;
    ArrayList<Integer> simpleList = new ArrayList<>();
    for (int i = 1; i <= number; i++) {
        boolean simple = true;
        for (int j = 2; j < i; j++) {
            cnt++;
            if (i % j == 0) {
                simple = false;
                break;
            }
        }
        if (simple) simpleList.add(i);
    }
    System.out.println(simpleList);
    System.out.println(cnt);
    */
    /*
    int numberCube = 4, numberSides = 6, cnt = 0;
    ArrayList<String> simpleList = new ArrayList<>();
    for (int i1 = 1; i1 <= numberSides; i1++) {
        for (int i2 = 1; i2 <= numberSides; i2++) {
            for (int i3 = 1; i3 <= numberSides; i3++) {
                for (int i4 = 1; i4 <= numberSides; i4++) {
                    simpleList.add(" " + i1 + i2 + i3 + i4);
                    cnt++;
                }
            }
        }
    }
    System.out.println(simpleList);
    System.out.println(cnt);

     */
    AtomicLong cnt = new AtomicLong(0);
    long start = System.currentTimeMillis();
    System.out.println(fib(44, cnt));
    System.out.println(System.currentTimeMillis()-start);
    System.out.println(cnt);
    cnt = new AtomicLong(0);
    start = System.currentTimeMillis();
    System.out.println(fibFor(44, cnt));
    System.out.println(System.currentTimeMillis()-start);
    System.out.println(cnt);
}

public static int fib(int number, AtomicLong cnt) {
    cnt.incrementAndGet();
    if (number <= 2) return 1;
    return fib(number - 1, cnt) + fib(number - 2, cnt);
}

public static int fibFor(int number, AtomicLong cnt) {
    if (number <= 2) return 1;
    int f1 = 1, f2 = 1;
    int f3 = f1 + f2;
    while (number-- > 3) {
        f1 = f2;
        f2 = f3;
        f3 = f1 + f2;
        cnt.incrementAndGet();
    }
    return f3;
}
}