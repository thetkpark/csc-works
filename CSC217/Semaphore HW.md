```pseudocode
// Sethanant Pipatpakorn 62130500230
semaphore {
	valet = 4,
	entrance = 2,
	exit = 1,
	space = 50
	giveKeyToValet = 0
	getKeyBack = 0
	keyBack = 0
	price = 0
	giveMoney = 0
	receipt = 0
	payment = 0
}

customer() {
	wait(entrance)
	driveIn()
	wait(valet)
	signal(giveKeyToValet)
	giveKeyToValet()
	signal(entrance)
	shopping()
	wait(valet)
	signal(getKeyBack)
	wait(keyBack)
	goToPayment()
	wait(valet)
	signal(payment)
	wait(price)
	giveMoney()
	signal(giveMoney)
	wait(receipt)
	getInCar()
	wait(exit)
	driveOut()
	signal(exit)
}

ParkingValet() {
	while(true) {
		wait(giveKeyToValet)
		wait(space)
		parkCar()
		signal(valet)
	}
}

RecieveValet() {
	while(true) {
		wait(getKeyBack)
		goGetCar()
		signal(space)
		signal(keyBack)
		signal(valet)
	}
}

PaymentValet() {
	while(true) {
		wait(payment)
		tellPrice()
		signal(price)
		wait(giveMoney)
		getMoney()
		giveReceipt()
		signal(receipt)
		signal(valet)
	}
}
```

5.7) 

a.) The lower bound is 2 and the upper bound is 100

b.) The lower bound is still 2 but the upper bound is depended on the number of process (2*process).

