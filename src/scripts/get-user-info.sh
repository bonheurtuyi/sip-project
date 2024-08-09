#!/bin/bash
USERS_FILE="./data/users.txt"

# Step 1: accept (uuid)
id=$1

# Ensure the identifier is not empty
if [[ -z "$id" ]]; then
  echo "No UUID provided!"
  exit 1
fi

trim() {
    local var="$*"
    var="${var#"${var%%[![:space:]]*}"}"
    var="${var%"${var##*[![:space:]]}"}"
    printf '%s' "$var"
}

# Flag to check if the user is found
user_found=false

# Read the file line by line
# shellcheck disable=SC2034
while IFS=' ' read -r uuid firstname lastname email password dob has_hiv diagnosis_date on_art start_drug_date iso role; do
    # Trim the uuid and id
    uuid=$(trim "$uuid")
    id=$(trim "$id")

    if [ "$id" == "$email" ]; then
        echo "-----"
        echo "Your profile information:"
        echo "UUID: $uuid"
        echo "First Name: $firstname"
        echo "Last Name: $lastname"
        echo "Email: $email"
        echo "Date of Birth: $dob"
        echo "Has HIV: $has_hiv"
        echo "Diagnosis Date: $diagnosis_date"
        echo "On ART: $on_art"
        echo "Start Drug Date: $start_drug_date"
        echo "ISO: $iso"
        echo "Role: $role"
        user_found=true
        break
    fi
done < "$USERS_FILE"

# If the user was not found
if [ "$user_found" = false ]; then
  echo "User not found"
fi