
# 2 Feb. 2022
# By PM, SIT@KMUTT

# How to access a data frame.

# Sequence of integer
value <- seq(from = 5, to = 16, by = 2)
val <- 6:13 # or use this format
# Check the data first to better understand it
# Check a structure
str(val)
# Check type of each element
typeof(val)

# Make a vector
my_val <- c(2,4,6,9,10)
# Check the data first to better understand it
# Check a structure
str(my_val)
# Check type of each element
typeof(my_val)
class(my_val)

# do some simple statistics
range(my_val)
mean(my_val)
sd(my_val)  # standard deviation
summary(my_val) # some statistics

# find a quantile
quantile(my_val)
# Produce box-and-whisker plot(s)
boxplot(my_val)
boxplot(my_val, horizontal = TRUE)
boxplot(my_val, horizontal = TRUE, col = "lightblue", 
        main = "My first boxplot", xlab = "Simple values")

# try and compare to this new dataset
my_val <- c(2,4,6,9,10,30,50)
# there is a skewness to the right of the boxplot
boxplot(my_val)

my_val[4] = 10  # reassign an element value
my_val
table(my_val) # a simple contigency table, show frequencies
sort(table(my_val))

# Install tidyverse packange and load it
# Also install socviz, gapminder package and load it

# tidyverse is a package for data science and analysis
library(tidyverse)

library(socviz)
library(gapminder)

# ggplot2 is an implementation of Grammar of Graphics, which
# is a general scheme for data visualization which breaks up 
# graphs into semantic components such as scales and layers

library(ggplot2)

# datasets of GDP of various countries
gapminder
gap <- gapminder
# see structure
str(gap)
# type
typeof(gap$lifeExp)
# class
class(gap$lifeExp)

# plot and see
ggplot(data =gap,mapping = aes(x = gdpPercap, y = lifeExp)) + 
  geom_point()

# try different plots
p <- ggplot(data =gap,mapping = aes(x = gdpPercap, y = lifeExp,
                               size = pop, color = continent)) + 
  geom_point() + 
  coord_cartesian() + 
  #scale_x + 
  labs(x = "GDP", y = "Life expectancy", title = "Gap for all")
# plot it
p
# try to make a log-10 scale of x
new_p <- p + scale_x_log10(labels=scales::dollar) + labs(x = "log GDP")
new_p

# try other looks
q <- ggplot(data = gapminder, mapping = aes(x =gdpPercap, y=lifeExp))
q + geom_smooth()
q + geom_point() + geom_smooth()
q + geom_point() + geom_smooth(method = "lm")


# select just Thailand's
th_gap <- gap[gap$country == "Thailand",]
# see structure
str(th_gap)
# sort and view its life expectancy
sort(th_gap$lifeExp)
t <- th_gap[th_gap$year == 2007,]
t
