# Homework 4

## The Code
```R
# Helper Function
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
```

```R
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
```

## Results

### States
![State CO](https://rawcdn.githack.com/thetkpark/csc-works/768840c7c627f3020342642b0699d96580f6bcc5/CSC536/Basic%20R/img/w6/states_CO.png)

![State NO2](https://rawcdn.githack.com/thetkpark/csc-works/768840c7c627f3020342642b0699d96580f6bcc5/CSC536/Basic%20R/img/w6/states_NO2.png)

![State O3](https://rawcdn.githack.com/thetkpark/csc-works/768840c7c627f3020342642b0699d96580f6bcc5/CSC536/Basic%20R/img/w6/states_O3.png)

![State SO2](https://rawcdn.githack.com/thetkpark/csc-works/768840c7c627f3020342642b0699d96580f6bcc5/CSC536/Basic%20R/img/w6/states_SO2.png)

> From the states comparison, the average AQI of 10 worst states are silimar to each other. There is a big different of average AQI of CO in Country of Maxico state compare to other states.

### Cities
![Cities CO](https://rawcdn.githack.com/thetkpark/csc-works/768840c7c627f3020342642b0699d96580f6bcc5/CSC536/Basic%20R/img/w6/cities_CO.png)

![Cities NO2](https://rawcdn.githack.com/thetkpark/csc-works/768840c7c627f3020342642b0699d96580f6bcc5/CSC536/Basic%20R/img/w6/cities_NO2.png)

![Cities O3](https://rawcdn.githack.com/thetkpark/csc-works/768840c7c627f3020342642b0699d96580f6bcc5/CSC536/Basic%20R/img/w6/cities_O3.png)

![Cities SO2](https://rawcdn.githack.com/thetkpark/csc-works/768840c7c627f3020342642b0699d96580f6bcc5/CSC536/Basic%20R/img/w6/cities_SO2.png)

> When we look by the cities, the worst average AQI of NO2 is
>
>  significantly higher than other pollutant. 
