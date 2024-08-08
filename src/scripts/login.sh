#!/bin/bash

USERS_FILE=src/data/users.txt
passedEmail=$1
passedPassword=$2

hash_password() {
    echo -n "$1" | sha256sum | awk '{print $1}'
}

# Read the file line by line
while IFS=' ' read -r uuid firstname lastname email password dob has_hiv diagnosis_date on_art start_drug_date iso role; do
    hashedEnteredPassword=$(hash_password "$passedPassword")

    # shellcheck disable=SC2053
    if [[ $passedEmail == $email && "$hashedEnteredPassword" == $password ]]; then
        if [[ "$role" == "admin" ]]; then
            exit 0
        elif [[ "$role" == "patient" ]]; then
            exit 2
        fi
    fi
done < "$USERS_FILE"

# If no match is found
exit 1
