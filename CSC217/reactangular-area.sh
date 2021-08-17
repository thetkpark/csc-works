# Sethanant Pipatpakorn 62130500230
if [ $# -ne 2 ]
then 
    echo "We need two arguments to calculate the area of reactangle"
    exit 1
fi

area=$(($1 * $2))
echo The area of reactangle is $area