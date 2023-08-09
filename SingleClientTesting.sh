#!/bin/bash

# performing the first 5 test cases for clients, one after another
java CalculatorClient < ./inputs/input1.txt > ./outputs/output1.txt
java CalculatorClient < ./inputs/input2.txt > ./outputs/output2.txt
java CalculatorClient < ./inputs/input3.txt > ./outputs/output3.txt
java CalculatorClient < ./inputs/input4.txt > ./outputs/output4.txt
java CalculatorClient < ./inputs/input5.txt > ./outputs/output5.txt
