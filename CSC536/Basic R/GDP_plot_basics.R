
# Mar. 2022
# By PM

# read in a CSV file
gdp <- read.csv("GDPperCap.csv")
country_code <- read.csv("Metadata_Country.csv")

# E.g., select data of Thailand and Brazil
bra_tha_ukr <- gdp[gdp$Country.Name == "Brazil" | gdp$Country.Name == "Thailand"
               | gdp$Country.Name == "Ukraine", ]

# get region and other info of each selected country
# initial a new data frame
ccode <- as.data.frame(NULL)

# add each row with, from cross table information with same country code
for (i in bra_tha_ukr$Country.Code){
  cc <- country_code[country_code$Country.Code==i, ] 
  ccode <- rbind(ccode,cc)  # binding by row
}

# combine some columns of the two data frames
bra_tha_ukr <- cbind(bra_tha_ukr,ccode$Region)  # binding by column
bra_tha_ukr <- cbind(bra_tha_ukr,ccode$IncomeGroup)

# try to transpose the data frame
new_df <- as.data.frame(t(bra_tha_ukr))

# try to select some rows
nd <- new_df[-c(1:11,45,46),]

# try to see some simple plots
# prepare data for x, y axes
bra_gdpCap <- new_df[-c(1:11,45,46),1]  # exclude some rows, with only 1st column
tha_gdpCap <- new_df[-c(1:11,45,46),2]
ukr_gdpCap <- new_df[-c(1:11,45,46),3]

yrs <- c(1987:2019)


# simple plots
plot(yrs, bra_gdpCap)
plot(yrs, tha_gdpCap)
plot(yrs, ukr_gdpCap)

# try to combine the two
plot(yrs, bra_gdpCap, type = "b", col= "dark red",
     main = "Brazil's, Thailand's, and Ukraine's GDP per capita",
     sub = "Red -> Brazil; Green -> Thailand; Blue -> Ukraine",
     xlab = "Years", ylab = "GDP per capita ($US)",ylim= c(500,13000))

# let's try to put the three on the same chart
lines(yrs, tha_gdpCap, col = "dark green")
points(yrs, tha_gdpCap, col = "dark green")

lines(yrs, ukr_gdpCap, col = "dark blue")
points(yrs, ukr_gdpCap, col = "dark blue")

# Now try to use more analyses and more advanced plotting.
# E.g., data of different regions/continents

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

library(ggplot2)

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



# For exmaple

gdp <- read.csv("GDPperCap.csv")
country_code <- read.csv("Metadata_Country.csv")

mergedGDP <- matrix(ncol = 44, nrow = 0)
for (ccode in country_code$Country.Code){
  mergedGDP <- rbind(mergedGDP, gdp[gdp$Country.Code == ccode,])  # binding by row
}
mergedGDP <- cbind(mergedGDP, country_code)

mergedGDP <- mergedGDP[1:10,] # select top 10 by alphabet
tGDP <- matrix(ncol=4, nrow = 0) # Country.Name, Year, GDP, IncomeGroup
for (country in mergedGDP$Country.Name) {
  for (yearCol in 5:44) {
    gdp <- mergedGDP[mergedGDP$Country.Name == country, yearCol]
    tGDP = rbind(tGDP, data.frame(
      Country = country,
      Year = c(1975+yearCol),
      GDP = gdp,
      IncomeGroup = mergedGDP[mergedGDP$Country.Name == country, "IncomeGroup"]
    ))
  }
}

ggplot(tGDP, aes(x=Year, y=GDP, group=Country, color=Country)) + geom_line() + geom_point()
  