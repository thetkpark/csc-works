
# R basics I
# By PM, SIT@KMUTT
# 19 Jan. 2022

# Learnt: for, if, function definition, random sampling, histogram

# Simple vector/sequence
3:27
length(3:27)

# Assignment
a <- 3:27
a
# access the vector (Started from index of 1)
a[1]

# get help on a control flow, type in ?control
# for loop with print
for (i in a){
  print(i)
}
# try another way to print, using the cat function
a <- 6:13
for(i in a){
  cat(i, sep="", ", ")
}

# if-else
if (55 %in% a){
  print("yes, there is a 5.")
} else {
  print("No, it's not.")
}


# Naming variables
a.hello <- "Hello, world!"
a_hello <- "Hi, earth"

# Normal division
3/7

# Integral division
3 %/% 7

# Modulo
3 %% 7

# Power
3^4
3**4

# element-wise operations
a <- 2:9
a < 5
a*2
3+a

# structure of ...
str(a)
# type of element
typeof(a)

# Boolean: true/false
a <- TRUE
b <- FALSE
a & b  # a bit-wise AND
a && b  #a short-circuit AND
# combining fuction
a <- c(TRUE, TRUE, FALSE)
b <- c(FALSE, TRUE, TRUE)
a & b
a && b # short-circuit, not the same as & 

# some predefined functions
a <- c(1:10) # combine values into list
a
mean(a)
sd(a)
# get sample elements
sample(a) 
sample(a)
sample(a,size = 3)
# set a sample seed 
set.seed(43)
sample(a,size = 3)
set.seed(43)
sample(a,size = 3)
# repeat the sampling for a given number of times
replicate(4,sample(a, size = 3))

# Write or define our own function
my.sum <- function(){
  val <- sample(1:6, size = 2)
  return(sum(val))
}

my.sum()

# Write another function
my.sum <- function(my.list = list()){
  if(length(my.list) == 0){
    return(NULL)
  }
  val <- sample(my.list, size = 2)
  return(sum(val))
}

my.sum()
my.sum(-5:0)

# Do a random sampling
set.seed(110)
a <- sample(1:20, size = 150, replace = TRUE)
a

# Show a simple plot
plot(a, col = "dark red")
# Plot a simple histogram
hist(a, col = "cyan", xlab = "Sample values", main = "My sample")


# More advanced histogram plot
set.seed(110)
a <- sample(1:6, size = 10000, replace = TRUE)
a
hist(a, breaks= c(0,1,2,3,4,5,6), freq = TRUE,border = "red",
     xlab = "Sample values", main = "My sample")

# Using xaxt="n" to avoid showing the x-axis
hist(a, breaks= seq(0,6,1), freq = TRUE,border = "blue",
     ylim = c(0,2000), xaxt="n", 
     xlab = "Sample values", main = "My sample", labels = TRUE)
axis(1, at=seq(0.5,6,by=1), labels=seq(1,6,by=1), tick = FALSE)



# Try a box plot
set.seed(24)
b <- sample(100:999, size = 5500, replace = TRUE)
summary(b)
table(b)
sort(table(b))
plot(b)
hist(b)
boxplot(b)

# Try a random normal distribution
set.seed(44)
c <- rnorm(900, mean = 350, sd= 20)
summary(c)
plot(c)
hist(c)
boxplot(c)



# To-do Exercise for Fun
# Write a code to simulate a random rolling of two-die for 900 times. 
# Record a sum of the two face values, analyze and plot them, 
# using a simple histogram, box plot,with statistical values (mean, median, 
# and mode).
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

# In addition, find a probability of getting a sum of 4 of those 900 rolls.
got4 <- 0
for (s in dicesSum) {
  if (s==4) {
    got4 <- got4+1
  }
  cat(i, sep="", ", ")
}
prob <- got4/900
print(prob)
