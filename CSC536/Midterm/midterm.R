# Sethanant Pipatpakorn 62130500230
ww2 <- read.csv("csvData.csv")

# Plot top 1 total death
library(ggplot2)

ww2OrderedByDeath <- ww2[order(-ww2$totalDeaths),]
top10Death <- ww2OrderedByDeath[1:10,]

ggplot(top10Death, aes(reorder(country, -totalDeaths, sum), totalDeaths, fill=reorder(country, -totalDeaths, sum))) +
  geom_bar(stat="identity") + 
  scale_fill_brewer(palette = "BrBG") + 
  scale_y_continuous(labels=scales::comma) +
  labs(x = "Country", y = "Total Death", fill = "Country", title = "Top 10 Country with The Most Total Death in WW2")


ww2OrderbyCivDealthFamine <- ww2[order(-ww2$civDeathsFamineDisease),]
top10FamineDeath <- ww2OrderbyCivDealthFamine[1:5,]
ggplot(top10FamineDeath, aes(reorder(country, -civDeathsFamineDisease, sum), civDeathsFamineDisease, fill=reorder(country, civDeathsFamineDisease, sum))) +
  geom_bar(stat="identity") + 
  scale_fill_brewer(palette = "Blues") + 
  scale_y_continuous(labels=scales::comma) +
  labs(x = "Country", y = "Total Death", fill = "Country",
       title = "Top 5 Country with The Most Civilian Death by Famine and Disease in WW2")


chinaDeathLabel <- c("Military Deaths", "Civ. Deaths via Military", "Civ. Deaths via Famine/Disease")
chinaDeathData <- c(ww2[ww2$country == "China", "milDeaths"], ww2[ww2$country == "China", "civDeathsFromMilitary"], ww2[ww2$country == "China", "civDeathsFamineDisease"])
piepercent<- round(100 * chinaDeathData / sum(chinaDeathData), 1)
pie(chinaDeathData, labels = paste0(piepercent, "%"), main = "Total Death of China in WW2", col=c("green","black","yellow"))
legend("topright", chinaDeathLabel, cex = 0.8, fill=c("green","black","yellow"))

    