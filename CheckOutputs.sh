#!/bin/bash

# output1="./outputs/output1.txt"
# e_output1="./outputs_e/e_output1.txt"

outputDirectory="./outputs/"
e_ouputDirectory="./outputs_e/"

for i in {1..10}
do

    out=$outputDirectory"output${i}.txt"
    expected_out=$e_ouputDirectory"e_output${i}.txt"

    if cmp -s "$out" "$expected_out"; then
        printf 'The file "%s" is the same as "%s"\n' "output${i}" "expected_output${i}"
    else
        printf 'The file "%s" is different from "%s"\n' "output${i}" "expected_output${i}"
    fi
done