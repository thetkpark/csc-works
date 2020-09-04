function solveToH(n: number) {
	const s: Array<Number> = new Array<Number>()
	const a: Array<Number> = new Array<Number>()
	const d: Array<Number> = new Array<Number>()

	for (let i = n; i >= 1; i++) {
		s.push(i)
	}

	const round = Math.pow(2, n) - 1

	for (let i = 1; i < round; i++) {
		console.info(`Round ${i}`)
		if (i % 3 == 1) {
			if (s.length == 0) s.push(d.pop())
			else if (d.length == 0) d.push(s.pop())
			else if (s[s.length - 1] < d[d.length - 1]) d.push(s.pop())
			else s.push(d.pop())
		} else if (i % 3 == 2) {
			if (s.length == 0) s.push(a.pop())
			else if (a.length == 0) a.push(s.pop())
			else if (s[s.length - 1] < a[a.length - 1]) a.push(s.pop())
			else s.push(a.pop())
		} else {
			if (d.length == 0) d.push(a.pop())
			else if (a.length == 0) a.push(d.pop())
			else if (d[d.length - 1] < a[a.length - 1]) a.push(d.pop())
			else d.push(a.pop())
		}
	}
	// Do something with the poles.
}
