# LedgerEdge

A console‑based Java banking application showcasing atomic transactions, robust error handling, and clean OOP design.

## 🚀 Features

- **Unique Account IDs**  
  Generated with `AtomicLong` to guarantee thread‑safe, sequential identifiers.

- **Validated Transactions**  
  Deposits and withdrawals enforce positive amounts and prevent overdrafts.

- **Exception‑Driven Safety**  
  Throws meaningful exceptions for invalid inputs and insufficient funds.

- **Automated Testing**  
  Comprehensive JUnit 5 suite covering all core behaviors and edge cases.

## 📦 Build & Run

### Prerequisites

- Java 11 or later  
- Maven 3.6 or later  

### Clone & Compile

```bash
git clone https://github.com/jamely15/LedgerEdge2.git
cd LedgerEdge2
mvn clean package
Execute
bash
Copy
Edit
java -cp target/java-banking-system-1.0-SNAPSHOT.jar com.djouvens.bank.Main
Alternatively, without Maven:

bash
Copy
Edit
javac -d out \
  src/main/java/com/djouvens/bank/Account.java \
  src/main/java/com/djouvens/bank/Main.java
java -cp out com.djouvens.bank.Main
🧪 Testing
Run the full test suite with:

bash
Copy
Edit
mvn test
You should see all tests pass, confirming deposit, withdrawal, and error‑handling logic.

📚 What I Learned
Project structuring and dependency management with Maven

Defensive programming and domain‑driven exception design in Java

Unit testing fundamentals using JUnit 5

Package naming conventions and code documentation best practices

📝 License
Distributed under the MIT License. See LICENSE.md for details.

