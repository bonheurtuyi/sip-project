#!/bin/bash
USERS_FILE=./data/users.txt

# Step 1: accept parameters (uuid)
uuid=$1
firstname=$2
lastname=$3
password=$4
dob=$5
has_hiv=$6
diagnosis_date=$7
on_art=$8
start_drug_date=$9
iso=${10}  # Correct handling of positional parameters beyond $9

# Function to hash the password
hash_password() {
    echo -n "$1" | sha256sum | awk '{print $1}' | xargs
}

# Check if the user exists
line_info=$(grep -n "$uuid" "$USERS_FILE")

if [[ -z $line_info ]]; then
  echo "User is not yet initiated!"
else
  line_number=$(echo "$line_info" | cut -d: -f1)
  user_record=$(echo "$line_info" | cut -d: -f2-)

  # Split the user_record into its specific values using a space as delimiter
  IFS=' ' read -r _uuid _firstname _lastname _email _password _dob _has_hiv _diagnosis_date _on_art _start_drug_date _iso _role <<< "$user_record"

  # Hash the new password
  hashed_password=$(hash_password "$password")
  echo "$hashed_password"

  # Prepare the new line to replace the current line
  new_value="${_uuid} ${firstname} ${lastname} ${_email} ${hashed_password} ${dob} ${has_hiv} ${diagnosis_date} ${on_art} ${start_drug_date} ${iso} ${_role}"

  # Use sed to replace the line in the file
  sed -i "${line_number}s/.*/$new_value/" "$USERS_FILE"

  echo "Successfully completed registration. Please login using your email (${_email}) by choosing 2.Patient and the password you provided."
fi
