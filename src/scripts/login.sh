#!/bin/bash

USERS_FILE=C:\\Users\\STUDENT\\Desktop\\project\\src\\data\\users.txt
passedEmail=$1
passedPassword=$2

hash_password() {
    echo -n "$1" | sha256sum | awk '{print $1}' | xargs
}

trim() {
    local var="$*"
    var="${var#"${var%%[![:space:]]*}"}"
    var="${var%"${var##*[![:space:]]}"}"
    printf '%s' "$var"
}

# Read the file line by line
count=0
while IFS=' ' read -r uuid firstname lastname email password dob has_hiv diagnosis_date on_art start_drug_date iso role; do

    if [ $count != 0 ];
    then
        hashedEnteredPassword=$(hash_password "$passedPassword")

#        printf '\nentered pwd: %s hash: %s\n entered mail:%s curr:%s' $hashedEnteredPassword $password $passedEmail $email

        # shellcheck disable=SC2053
        if [ $passedEmail == $email ] && [ $hashedEnteredPassword == $password ]; then
#            printf '\nFound user: %s' $email
            if [ $(trim "$role") == "admin" ]; then
#                printf '\n%s' 'This is admin'
                exit 0
            elif [ $(trim "$role") == "patient" ]; then
#                printf '\n%s' 'This is a patient'
                exit 2
            fi
        fi
    fi

    (( count ++ ))
done < "$USERS_FILE"

# If no match is found
exit 1