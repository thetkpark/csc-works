# Homework 5 (GDP Plot)

> Sethanant Pipatpakorn 62130500230

## The Code

```R
library(ggplot2)
gdp <- read.csv("GDPperCap.csv")
country_code <- read.csv("Metadata_Country.csv")

mergedGDP <- matrix(ncol = 44, nrow = 0)
for (ccode in country_code$Country.Code){
  mergedGDP <- rbind(mergedGDP, gdp[gdp$Country.Code == ccode,])  # binding by row
}
mergedGDP <- cbind(mergedGDP, country_code)

avgGDPByIncomeGroup <- matrix(ncol = 3, nrow = 0)
for (incomeGroup in unique(mergedGDP$IncomeGroup)) {
  if (incomeGroup == "") {
    next
  }
  for (yearCol in 5:44) {
    avgGDPThisYear <- mean(mergedGDP[mergedGDP$IncomeGroup == incomeGroup, yearCol], na.rm = TRUE)
    avgGDPByIncomeGroup <- rbind(avgGDPByIncomeGroup, data.frame(
      IncomeGroup = c(incomeGroup), 
      Year = c(1975+yearCol),
      AvgGDP = c(avgGDPThisYear)
      ))
  }
}

# Plot lines graph of each income group
ggplot(avgGDPByIncomeGroup, aes(x = Year, y = AvgGDP, group = IncomeGroup, color = IncomeGroup)) + 
  geom_line() + geom_point() + scale_y_continuous(labels=scales::comma) +
  labs(x = "Year", y = "Average GDP Per Capita (USD)", title = "Trend of Average GDP Per Capita of Income Group By Year")

# Plot lines graph of each income group with log scale
ggplot(avgGDPByIncomeGroup, aes(x = Year, y = AvgGDP, group = IncomeGroup, color = IncomeGroup)) + 
  geom_line() + geom_point() + scale_y_log10(labels=scales::comma) +
  labs(x = "Year", y = "Average GDP Per Capita (USD)", title = "Trend of Average GDP Per Capita of Income Group By Year")

# box plot of distribution by year
ggplot(avgGDPByIncomeGroup, aes(x = reorder(IncomeGroup, -AvgGDP, sum), y = AvgGDP, color = IncomeGroup)) + 
  geom_boxplot() + scale_y_log10(labels=scales::comma) +
  labs(x = "Income Group", y = "Average GDP Per Capita (USD)", title = "Average GDP Per Capita of Income Group By Year")
```

## Results

![Line](https://rawcdn.githack.com/thetkpark/csc-works/32952ba1f15b0ad5034e9967c1fcd8033539f717/CSC536/Basic%20R/img/w7/line.png)

This visualization is a line graph of average GDP Per Cap of each income group of country. You can clearly see the difference of `High Income` group compare to the rest of income group.

![Line Log](https://rawcdn.githack.com/thetkpark/csc-works/32952ba1f15b0ad5034e9967c1fcd8033539f717/CSC536/Basic%20R/img/w7/line_log.png)

This visualization is mostly the same as above, but the it's in log scale. If we use the logarithmic scale, we can see that the trends of GDP Per Cap of each income group are very similar. 

![Box Plot](https://rawcdn.githack.com/thetkpark/csc-works/32952ba1f15b0ad5034e9967c1fcd8033539f717/CSC536/Basic%20R/img/w7/box.png)

This visualization is the box plot of average GDP Per Cap of each income group corresponds to the year.