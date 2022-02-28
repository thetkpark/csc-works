
# Feb. 2022
# Data Viz. Fundamentals
# By PM

# Credit: Some code from Data Visualization: a practical introduction by Kieran Healy, 
# Princeton Univ. Press, 2019


# We'll work on more interesting graphics with various plots
# Install socviz package and load it
# Visit http://gss.norc.org/ for more details about the data


library(socviz)
library(ggplot2)

# Now, We start working on some categorical data
# know more about the data
?gss_sm

# let's take a look at the dataset first
gdat <- gss_sm

# multi-panel plot (fold/facet)
# it shows a two-way comparison (sex vs. race)
p <- ggplot(data = gss_sm,
           mapping = aes(x = age, y = childs))
p + geom_point(alpha = 0.25) +
  geom_smooth() +
  facet_grid(sex ~ race)

# add more variables, but mindful of being messy
# this one shows a multi-way comparison (sex,race and degree)
p <- ggplot(data = gss_sm,
            mapping = aes(x = age, y = childs))
p + geom_point(alpha = 0.2) +
  geom_smooth() +
  facet_grid(sex ~ race + degree)

# bar plots
# this plot show the counts as default statistic on the y-axis
p <- ggplot(data = gss_sm, mapping = aes(x = bigregion))
p + geom_bar()

# with proportions, not the total counts
# the proportion of each region from the whole one population/group)
p <- ggplot(data = gss_sm, mapping = aes(x = bigregion))
p + geom_bar(mapping = aes(y = ..prop.., group = 1))

# let's peer into the religions
# use the table() function to get a quick frequency count
table(gss_sm$religion)

# another bar plot
# this shows the counts of each religion
p <- ggplot(data = gss_sm, mapping = aes(x = religion, color = religion))
p + geom_bar()
# now apply different colors, and without using legends/notes
p <- ggplot(data = gss_sm, mapping = aes(x = religion, fill = religion))
p + geom_bar() + theme(legend.position = "none")

# another stacked bar plot
# this shows the different counts of religion in each region
# this may be somewhat difficult for readers
# of the chart to compare lengths and areas on an unaligned scale
p <- ggplot(data = gss_sm, mapping = aes(x = bigregion, fill = religion))
p + geom_bar()

# another one of the stacked bar plot
# in each bar is now shown with proportions (see better relative position),
# but without the counts
p <- ggplot(data = gss_sm, mapping = aes(x = bigregion, fill = religion))
p + geom_bar(position = "fill")

# another attempt to better visualize and compare
# This makes bars appear side by side
# Note that the bars do not sum to one within each region. 
# Instead, the bars for any particular religion sum to one across regions
# That's because they are grouped by religion

p <- ggplot(data = gss_sm, mapping = aes(x = bigregion, fill = religion))
p + geom_bar(position = "dodge", mapping = aes(y = ..prop..,
                                               group = religion))

# another way make the plots placed side by side
p <- ggplot(data = gss_sm, mapping = aes(x = religion))
p + geom_bar(position = "dodge", 
             mapping = aes(y = ..prop.., group = bigregion)) + 
    facet_wrap(~bigregion, ncol = 2)


# Now work on this very same dataset, gss_sm, use more
# visualizations to extract our more useful information
