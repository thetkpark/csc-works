# Exercise Week 2

Sethanant Pipatpakorn 62130500230

## Exercise 1

**To-do Exercise for Fun**
Write a code to simulate a random rolling of two-die for 900 times. 
Record a sum of the two face values, analyze and plot them, 
using a simple histogram, box plot,with statistical values (mean, median,and mode).

```R
d1 <- sample(1:6, size = 900, replace = TRUE)
d2 <- sample(1:6, size = 900, replace = TRUE)
dicesSum <- d1+d2

getmode <- function(v) {
  uniqv <- unique(v)
  uniqv[which.max(tabulate(match(v, uniqv)))]
}

sumMean = mean(dicesSum)
sumMode = getmode(dicesSum)
sumMedian = median(dicesSum)

hist(dicesSum, breaks= c(1:12), freq = TRUE,border = "blue",xlab = "Value", 
     main = "Frequence of two dice summation")
abline(v = sumMean, col = "red", lwd = 2)
text(sumMean, 10, "mean", col="red")
abline(v = sumMode, col = "green", lwd = 2)
text(sumMode, 30 , "mode", col="green")
abline(v = sumMedian, col = "yellow", lwd = 2)
text(sumMedian, 50 , "median", col="yellow")

boxplot(dicesSum, main="Box plot of summation of two dices", ylab="Value")
```

![Rplot01](https://img.cscms.me/lSRzuXXoZOV1DBMloM4U.png)
![Rplot0](https://img.cscms.me/wLFyTYEe6FLkKkV2Ilf7.png)

## Exercise 2
In addition, find a probability of getting a sum of 4 of those 900 rolls.
```R
got4 <- 0
for (s in dicesSum) {
  if (s==4) {
    got4 <- got4+1
  }
}
prob <- got4/900
print(prob)
```


![Screen Shot 2565-01-29 at 16.44.47](https://img.cscms.me/t8e6QOBS2sK5yFVEzeYr.png)
