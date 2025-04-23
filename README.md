# S.A.ID-Validation
This is a simple terminal-based tool to validate **South African ID numbers** based on their structure and checksum. It does **not** fetch data or use any database — all validation is done locally.

---

## 🔍 Features

- Validates **13-digit South African ID numbers**
- Checks:
  - Correct length (13 digits)
  - All numeric characters
  - Valid **Luhn algorithm checksum**
  - Basic structure: date of birth, gender code, citizenship

## 🧰 Requirements

- Java JDK 8 or higher
- Terminal or Command Prompt
- (Optional) Git for cloning the repo
## **Step 2: Run the Application**
java -cp out org.calculator.junit.App

## Validation Logic
South African ID numbers are 13 digits and follow this format:
YYMMDD SSSS C A Z
Where:

YYMMDD: Date of birth

SSSS: Sequence number (used to determine gender)

C: Citizenship (0 = SA citizen, 1 = permanent resident)

A: Usually 8 (historical use)

Z: Checksum digit (validated using the Luhn algorithm)
