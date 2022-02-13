Sethanant Pipatpakorn 62130500230

> Basing on the example code given in class (also attached here), your work is to choose some useful plotting to demonstrate analyses of GDP, life expectancy and population size when comparing those of Thailand with ASEAN countries, China, India, Asia, Europe, South Americas, and Africa.

```R
# function to calculate the average
calculateAvg <- function(name, datas) {
  avgData <- matrix(ncol = 6, nrow = 0)
  for (i in 1952:2007) {
    thisYearData = datas[datas$year==i,]
    if (dim(thisYearData)[1] != 0) {
      meanPop <- mean(thisYearData$pop)
      meanLifeExp <- mean(thisYearData$lifeExp)
      meanGDP <- mean(thisYearData$gdpPercap)
      newrow <- data.frame(country=as.factor(paste(name, "")),
                           continent=as.factor(name),
                           year=i,
                           lifeExp=meanLifeExp,
                           pop=meanPop,
                           gdpPercap=meanGDP)
      avgData <- rbind(avgData, newrow)
    }
  }
  return (avgData)
}

# All the data includes average data of continents
EuropeAvgData <- calculateAvg("Europe", gap[gap$continent == "Europe",])
AfricaAvgData <- calculateAvg("Africa", gap[gap$continent == "Africa",])
AsiaAvgData <- calculateAvg("Asia", gap[gap$continent == "Asia",])
ASEANAvgData <- calculateAvg("ASEAN", gap[gap$country == "Thailand" | gap$country == "Vietnam" 
                                          | gap$country == "Brunei" | gap$country == "Cambodia"
                                          | gap$country == "Indonesia" | gap$country == "Laos"
                                          | gap$country == "Malaysia" | gap$country == "Myanmar"
                                          | gap$country == "Philippines" | gap$country == "Singapore",])
SouthAmericaAvgData <- calculateAvg("South Americas", gap[gap$country == "Argentina" | gap$country == "Bolivia" 
                                          | gap$country == "Brazil" | gap$country == "Chile"
                                          | gap$country == "Colombia" | gap$country == "Ecuador"
                                          | gap$country == "Guyana" | gap$country == "Paraguay"
                                          | gap$country == "Peru" | gap$country == "Suriname"
                                          | gap$country == "Uruguay" | gap$country == "Venezuela",])

plotData <- rbind(EuropeAvgData, AfricaAvgData, AsiaAvgData, ASEANAvgData, 
                  SouthAmericaAvgData, gap[gap$country == "Thailand",], 
                  gap[gap$country == "China",], gap[gap$country == "India",])
```

```R
# Population
ggplot(data=plotData, mapping = aes(x=year, y=pop, color=country)) +
  scale_color_brewer(palette="Dark2") +
  geom_smooth() + 
  geom_point() +
  scale_y_log10() +
  labs(x = "Year",
       y = "Population",
       title = "Population trends of Thailand compare to others")
```

![Population](https://cdn.githubraw.com/thetkpark/csc-works/4a17b5bb/CSC536/Basic%20R/img/w4-population.png)

```R
# GDP per cap
ggplot(data=plotData, mapping = aes(x=year, y=gdpPercap, color=country)) +
  scale_color_brewer(palette="Dark2") +
  geom_smooth() + 
  geom_point() +
  labs(x = "Year",
       y = "GDP per capita",
       title = "GDP per capita trends of Thailand compare to others")
```

![GDP](https://cdn.githubraw.com/thetkpark/csc-works/4a17b5bb/CSC536/Basic%20R/img/w4-gdp.png)

```R
# Life expectancy
ggplot(data=plotData, mapping = aes(x=year, y=lifeExp, color=country)) +
  scale_color_brewer(palette="Dark2") +
  geom_line() + 
  geom_point() +
  labs(x = "Year",
       y = "Life expectancy",
       title = "Life expectancy trends of Thailand compare to others")
```

![Life](https://cdn.githubraw.com/thetkpark/csc-works/4a17b5bb/CSC536/Basic%20R/img/w4-life.png)