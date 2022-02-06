

# 2 Feb. 2022
# by PM, SIT@KMUTT

# Learnt: Data frame, renaming, slicing, dicing

# vector/sequence
a <- c("H","e","l","l","o")
a
str(a)  # check its structure
length(a)

# Show how the indexing is used, e.g., from:to
# index starts from 1, and not 0 in R's vector/array
a[2:4]
a <- "Hello"
nchar(a)   # use nchar instead of length() 

# string of characters
a <- "Hello"
a
str(a)  # check its structure
nchar(a)  # could not use the function length()
# Find a sub string, indicating the indices
substr(a,2,4)

# data frame and slicing
age=13:21
height=c(48, 47, 70, 50, 62, 60, 62, 72, 53)
students = data.frame(age, height) # turn into table
# rename if needed
students = data.frame(s_age=age, s_height=height)
# access 
students$s_age

# check a structure
str(students)

# print all rows, all columns
students
students[,]

# slicing; cut in a row-wise manner
students[students$s_age>=18,]  # but with all columns that "s_age" > = 18

# dicing; cut in a column-wish manner
students[,c("s_age")] # but with all rows with only "s_age"

# slicing and dicing
students[students$s_age>=15, c("s_age")]
students[students$s_age>=15, c("s_age","s_height")]
students[students$s_age>=15,]  # for all columns
students[students$s_age>=15, 1] # 1th column only
students[students$s_age>=15, 2] # 2nd column

# done!
