## Q1

> Draw the corresponding UML class diagram for the given Java program.
>
> Remark: There does not exist the Java main class here; therefore, do NOT include it in your diagram.



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



## Q5

> Q5. Draw the corresponding UML class diagram for the refactored program of Q4.
>
> Remark: No need to include the Java main class in your class diagram.



## Q6

> Argue the following points

### Similarities between the Template and Strategy patterns



### Differences between the Template and Strategy patterns



### It is clear from this exercise that one can use Strategy to refactor the Template pattern, and vice versa. Discuss when one should be favored over the other

