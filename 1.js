const greeting = async () => {
	console.log('Hello World')
	return await name.input()
}

greeting().then(name => {
	this.sitename = name
})
