#!/bin/bash
echo $@
cat $@ | jq '.'
