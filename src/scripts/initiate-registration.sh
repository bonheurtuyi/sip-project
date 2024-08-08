#!/bin/bash
echo $@ #pass all arguments

#locating the users.txt
userStoreFile="./data/users.txt"

#Updateing the users.txt
echo $@ >> $userStoreFile

