
# CSC536, SIT@KMUTT
# By PM

# 23 Feb. 2022
# US Pollution dataset (2000-2016)

# Read in the CSV file
# Source: https://www.kaggle.com/sogun3/uspollution
# Also check for more details at: https://www.airnow.gov/aqi/aqi-basics/

pol <- read.csv("pollution_us_2000_2016.csv")

# Check dimension (rows and columns)
dim(pol)
nrow(pol)
ncol(pol)


# Show the first and last few rows of the dataset
head(pol)
tail(pol)


# Look at a structure of the dataset
str(pol)

# Check for unique states in the USA
unique(pol$State)
# sort them in an alphabetical order
sort(unique(pol$State))

# selection:
# Select only some particular rows/observations, and all columns
phx <- pol[which((pol$State == "Arizona") & (pol$City=="Phoenix")), ]

# or try another method
phx_a <- pol[pol$State == "Arizona" & pol$City == "Phoenix", ]

# now with all rows, select some particular columns, and not all
phx_col <- phx_a[ , c("State","City", "O3.AQI")]

# get some variables out for a later use
x <- phx$Date.Local
y <- phx$O3.AQI

# Check range value
range(y)

# first, plot a simple histogram
hist(y)


# Import ggplot2 library after its package installation
# ggplot2 is a data visualization package 
library(ggplot2)

# another simple plotting
qplot(y)  # just another histogram
qplot(y, binwidth = 1) # adjust a bin size, but change it as appropriate

# try a boxplot of different pollutants/gases for the cities of  Phoenix and Pittsburgh
# first, extract out some relevant data
phx_pitt_o3 <- pol[pol$City == "Phoenix" | pol$City == "Pittsburgh", 
                   c("State","City", "O3.AQI")]

# check the structure
str(phx_pitt_o3)
unique(phx_pitt_o3$City)
unique(phx_pitt_o3$State)

# draw a more interesting two-in-one boxplot, comparing the two selected cities
boxplot(O3.AQI ~ City, data=phx_pitt_o3, 
        horizontal = TRUE, col =  c("cyan",rgb(.4,.3,0,0.5)))

# You may need to further check when those outliers from the boxplot
# occurred; see any patterns of days/months/years?


# To do:
# Now try to find the top 10 cities and 10 states with the worst AQI
# of various pollutants.
# Applying a variety of plots like
# - line graph
# - histogram
# - boxplot (you may need to further process outliers)
# - stacked bar plot
# - faceted plot

# Do screen captures of the output graphs and provide your insight about them

getTop10WorstAQIByState <- function(datas, avgCol) {
  result <- matrix(ncol = 2, nrow = 0)
  for(stateName in unique(datas[,c("State")])) {
    meanValue <- mean(datas[datas$State == stateName, avgCol], na.rm = TRUE)
    result <- rbind(result, data.frame(State=stateName, avgAQI=meanValue))
  }
  avgResult <- result[order(-result$avgAQI), ]
  return (avgResult[1:10,])
}

getTop10WorstAQIByCity <- function(datas, avgCol) {
  result <- matrix(ncol = 2, nrow = 0)
  for(cityName in unique(datas[,c("City")])) {
    meanValue <- mean(datas[datas$City == cityName, avgCol], na.rm = TRUE)
    result <- rbind(result, data.frame(City=cityName, avgAQI=meanValue))
  }
  avgResult <- result[order(-result$avgAQI), ]
  return (avgResult[1:10,])
}

plotStateBarChart <- function (data, title) {
  ggplot(data, aes(reorder(State, -avgAQI, sum), avgAQI, fill=State)) +
    geom_bar(stat="identity") + scale_fill_brewer(palette = "Paired") + 
    labs(x = "States", y = "Average AQI", 
         title = title)
}

plotCityBarChart <- function (data, title) {
  ggplot(data, aes(reorder(City, -avgAQI, sum), avgAQI, fill=City)) +
    geom_bar(stat="identity") + scale_fill_brewer(palette = "Paired") + 
    labs(x = "Cities", y = "Average AQI", 
         title = title)
}

library(ggplot2)
pol <- read.csv("pollution_us_2000_2016.csv")

plotStateBarChart(getTop10WorstAQIByState(pol, "NO2.AQI"), "Top 10 worst N02 AQI states")
plotStateBarChart(getTop10WorstAQIByState(pol, "O3.AQI"), "Top 10 worst O3 AQI states")
plotStateBarChart(getTop10WorstAQIByState(pol, "SO2.AQI"), "Top 10 worst SO2 AQI states")
plotStateBarChart(getTop10WorstAQIByState(pol, "CO.AQI"), "Top 10 worst CO AQI states")

plotCityBarChart(getTop10WorstAQIByCity(pol, "NO2.AQI"), "Top 10 worst N02 AQI cities")
plotCityBarChart(getTop10WorstAQIByCity(pol, "O3.AQI"), "Top 10 worst O3 AQI cities")
plotCityBarChart(getTop10WorstAQIByCity(pol, "SO2.AQI"), "Top 10 worst SO2 AQI cities")
plotCityBarChart(getTop10WorstAQIByCity(pol, "CO.AQI"), "Top 10 worst CO AQI cities")
