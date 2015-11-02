class Assertions {
	def static <T> T checkResult(T value, T expectation) {
		if (value != expectation) {
			throw new IllegalArgumentException('''«value» != «expectation»''')
		}
		return value
	}
	
	def static <T> T unknown() {
		throw new UnsupportedOperationException()
	}
}