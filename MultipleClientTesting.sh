#!/bin/bash

# performing the last 5 test cases, to be run at the same time
java CalculatorClient < ./inputs/input6.txt > ./outputs/output6.txt & java CalculatorClient < ./inputs/input7.txt > ./outputs/output7.txt & java CalculatorClient < ./inputs/input8.txt > ./outputs/output8.txt & java CalculatorClient < ./inputs/input9.txt > ./outputs/output9.txt & java CalculatorClient < ./inputs/input10.txt > ./outputs/output10.txt
