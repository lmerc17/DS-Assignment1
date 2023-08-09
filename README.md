Instructions for running a singular client and server:
    1. If not done already, compile all .java files using the provided makefile
    2. From there, inside of a terminal window, go to the folder where the .class files are and run the command 'rmiregistry &' to run a rmi registry within that terminal
    3. Then, open another terminal in the same directory (this will be the server terminal), run the command 'java CalculatorServer' and way for the server ready message.
    4. Then, open one more terminal in the same directory (this will be the client terminal), and run the command 'java CalculatorClient'. From here commands can be entered as explained below.


Commands that can be entered into the CalculatorClient:

    push num: where num is an integer. This command will call pushValue(num). It will push the integer num onto the stack stored on the server. This function will not work for an invalid number or when just push is entered without a number.

    min: this command will call pushOperation('min'). This will find the minimum value within the stack, pop all numbers and push the minimum back onto the stack.

    max: this command will call pushOpertion('max'). This will perform the same operation as min except the maximum value on the stack is found.

    lcm: this command will call pushOperation('lcm'). This will perform the same operation as min except the lcm of the values currently on the stack is found.

    gcd: this command will call pushOperation ('gcd'). This will perform the same operation as min except the gcd of the values currently on the stack is found.\

    pop: this command will call pop(). It will remove the value at the top of the stack and print it for the client.

    isEmpty: this command will call isEmpty(). It will check if the stack is empty or not, it will return true if the stack is empty or false otherwise.

    delayPop millis: where millis is an integer. This command will call delayPop(millis). It will wait the specified amount of milliseconds as determined by the integer millis and will perform the pop() function as described above.

    exit: this can be called when finished with the client and allows the client to close.


How the test cases work:

    For each input text file, the commands given to a client are written on each line. The last line needs to have the exit command otherwise the client will crash.

    When running the client, the standard input is found by the redirection of the input text file and is outputted into the corresponding output file.

    The ouput of the test is then compared to the corresponding expected output file and it is then checked if the two files match.

    The first five test cases are for a single client and the next five are for five clients at once.


To run the test cases present:

    All of the following commands should be run in a terminal within the same directory as the bash files, java files and class files.

    Before running the test cases for a single client, please be sure to close the registry and server and restart them as described above.

    To run the test cases that are for a single client, please enter the following command into the terminal './SingleClientTest.sh'. If this doesn't work, perhaps try 'bash ./SingleClientTest.sh'
    This should create output files numbered 1 to 5 in the outputs folder

    To run the test cases for multiple clients at once, please enter the following command './MultipleClientTesting.sh'. If this doesn't work, perhaps try 'bash ./MultipleClientTest.sh'
    This should create output files numbered 6 to 10 in the outputs folder

    To compare the files please enter the following command into the terminal './CheckOutputs.sh'. Once again, if that does not work, try 'bash ./CheckOutputs.sh'.
    This should check the text files and output whether they match or not.

    Disclaimer: It is possible that test cases 6 to 10 will not match up due to the unknown nature of the order in which the commands are executed. However, no crashes should occur.