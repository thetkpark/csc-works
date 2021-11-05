# Lab 2 VI

#### dd

> Delete line

#### <number> dd

> Delete <number> of lines

#### Shift + J 

> Delete end of the line character (\n)

#### x

> Delete the current character

#### <number>x

> Delele <number> of character

#### u

> undo

#### .

> redo

#### :w <filename>

> Save to the <filename> (If not provide -> Save to the same file)

- h -> move left
- j -> move up
- k -> move down
- l -> move right

#### ZZ

> save and exit

#### :q

> quit with save (add ! to not save)

#### :<number1>, <number2> m <number3>

> move from <number1> to <number2> line to under line <number3>



# Lab3

### ps

> List all the processes

### kill <process id>

> kill process according to process id

### more

> Display content of file

### less

> Display content of file in another windows (No backlog)

### cal

> Display calendar

### od <filename>

> octal display (Display binary value into base 8)

### > 

> Redirect output

### >>

> Append the output

### cat <filename> <filename>

> Concat contents of two files into STDOUT

### whoami

> display current username

s

---

### grep <pattern> <filename>

> Find in file
>
> -c -> Count number of places
>
> -n -> Show with line number

### wc <filename>

> Word count
>
> display in: <number of lines> <number of words> <number of character>

### head -n <number> <filename>

> display only first <number> lines

### tail -n <number> <filename>

> Show last <number> lines

### sort <filename>

> Display file sorted by First character of each sentense



# Pipe |

> "|" operation that send output of one program to be an input of another program

Ex: grep printf sum.c | tail -n 1 -> Send output of "grep" to "tail"







```sh
cd lab
mkdir lab6
vi hi5
chmod +x hi5
vi addition
chmod +x addition
vi calculator
chmod +x calculator
```



Content of hi5

```sh
echo "Hi, My name is Boy!"
echo Boy love come to schoo

x=5
y=12
z=$(($x+$y))
echo $z

ls -l
date

x=grep
$x "Boy" hi5
```



Addition

```sh
echo Addition Program
x=10
y=20

z=$(($x+$y))
echo $z

echo Please give me a number
read a
echo Please give me another number
read b

c=$(bc <<< $a+$b)
echo $a + $b = $c

if [ $a -le $b ]
then
    echo $a is less than $b
fi
```



Calculator

```sh
echo My Calculator

echo Please give me a number
read a
echo Please give me another number
read b


echo Please choose operation among [+ - x / ]
read choice

if [ $choice == "+" ]
then 
		add=$(($a+$b))
    echo $a + $b = $add
fi
if [ $choice == "-" ]
then 
		minus=$(($a-$b))
    echo $a - $b = $minus
fi
if [ $choice == "x" ]
then
	 multiply=$(($a*$b))
   echo $a x  $b = $multiply
fi
if [ $choice == "/" ]
then
   divide=$(bc -l <<< $a/$b)
   echo $a / $b = $divide
fi
```

