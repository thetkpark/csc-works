## Q1

> Draw the corresponding UML class diagram for the given Java program.
>
> Remark: There does not exist the Java main class here; therefore, do NOT include it in your diagram.

<img src="https://rawcdn.githack.com/thetkpark/csc-works/0b0144f2ffbea213980cf0ef6b63f181a75d133e/CSC319/j2-review/img/template-plattern.png" alt="Template Pattern" style="zoom: 40%;" />

## Q2

> Argue that the given program realizes the Template pattern.
>
> Hint: You can use the class diagram in Q1 for your advantage.

​	Template pattern defined the general function called template method to a abstract class. From the given code, the template method is `warpAt()` method. The execution of this method depends on another method, `warp()`. This method is defined as a abstract method in `CustomWarp` class. It delegate the action of `warp()` method to the subclass which needed to implement their own `warp()` method. Because of the implementation of `warp()` in each subclass is unique. It allow `warpAt()` method to have many characteristic. According to the code, `CustomWarp` has 2 subclass, `Decremeter` and `Incremeter`. They implements the different implementation of `warp()` method. `Decremeter` implements `warp()` by returning the decreased number. While `Incremeter` returns the increased number. Therefore, the given code is written with Template design pattern.

## Q3

> Write the Java main class to test both “warp” operations of the given program. Test the program.

```java
package Template;

public class Main {
    public static void main(String[] args) {
        CustomWarp incrementer = new Incrementer();
        CustomWarp decrementer = new Decrementer();

        System.out.println("-----Incrementer-----");
        incrementer.warpAt(2);
        incrementer.warpAt(5);
        incrementer.warpAt(10);

        System.out.println("-----Decrementer-----");
        decrementer.warpAt(1);
        decrementer.warpAt(6);
        decrementer.warpAt(0);
    }
}
```

### Result

```
-----Incrementer-----
2 is warped to 3
5 is warped to 6
10 is warped to 11
-----Decrementer-----
1 is warped to 0
6 is warped to 5
0 is warped to -1
```

## Q4

> Refactor the given program such that it realizes the Strategy pattern instead. Your answer for this question must be another Java program resulted from refactoring.
>
> Remark: Be sure to include the Java main class to TEST your refactored program.

```java
// WarpBehavior
public interface WarpBehavior {
    public int warp(int n);
}

public class Decrement implements WarpBehavior {
    @Override
    public int warp(int n) {
        return --n;
    }
}

public class Increment implements WarpBehavior {
    @Override
    public int warp(int n) {
        return ++n;
    }
}

// CustomWarp
public class CustomWarp {
    protected WarpBehavior warpBehavior;

    public void warpAt(int n) {
        int warpedN = warpBehavior.warp(n);
        System.out.println(n + " is warped to " + warpedN);
    }

    public void setWarpBehavior(WarpBehavior warpBehavior) {
        this.warpBehavior = warpBehavior;
    }
}

public class Decrementer extends CustomWarp {
    public Decrementer() {
        this.warpBehavior = new Decrement();
    }
}

public class Incrementer extends CustomWarp{
    public Incrementer() {
        this.warpBehavior = new Increment();
    }
}

public class Main {
    public static void main(String[] args) {
        CustomWarp decrementer = new Decrementer();
        CustomWarp incrementer = new Incrementer();

        System.out.println("-----Decrementer Warp Behavior-----");
        decrementer.warpAt(1);
        decrementer.warpAt(10);

        System.out.println("-----Incrementer Warp Behavior-----");
        incrementer.warpAt(1);
        incrementer.warpAt(10);
    }
}
```

### Result

```
-----Decrementer Warp Behavior-----
1 is warped to 0
10 is warped to 9
-----Incrementer Warp Behavior-----
1 is warped to 2
10 is warped to 11
```

## Q5

> Q5. Draw the corresponding UML class diagram for the refactored program of Q4.
>
> Remark: No need to include the Java main class in your class diagram.

<img src="https://rawcdn.githack.com/thetkpark/csc-works/0b0144f2ffbea213980cf0ef6b63f181a75d133e/CSC319/j2-review/img/strategy-pattern.png" alt="Strategy Pattern UML" style="zoom:50%;" />

## Q6

> Argue the following points

### Similarities between the Template and Strategy patterns



### Differences between the Template and Strategy patterns



### It is clear from this exercise that one can use Strategy to refactor the Template pattern, and vice versa. Discuss when one should be favored over the other

