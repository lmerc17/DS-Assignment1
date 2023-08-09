all: clean compile

compile: Calculator.java CalculatorClient.java CalculatorServer.java CalculatorImplementation.java
	javac *.java

clean:
	rm -f *.class