readme_content = """
# Voting System

## 📌 Overview
The **Voting System** is an online platform designed to facilitate secure and reliable digital voting. This project provides a structured database and a user-friendly interface to manage voter registrations, candidate details, and voting processes. 

## 🎯 Key Features
- **Secure Login System**: Ensures only registered voters can participate.
- **Admin Dashboard**: Manage voters, candidates, and view election results.
- **One-Vote Policy**: Prevents multiple votes from a single account.
- **Automated Vote Counting**: Dynamically updates results in real-time.
- **Candidate Management**: Admins can add, edit, and delete candidate records.
- **Voter Authentication**: Secure username-password verification.

## 🔧 Tech Stack
- **Frontend**: Java (Swing, JFrame Forms)
- **Backend**: Java, SQL Server
- **Database**: SQL Server with ERD-based schema
- **Libraries Used**:
  - `mssql-jdbc-8.2.2.jre8.jar` (JDBC driver for SQL Server)
  - Java Development Kit (JDK 19)

## 🏗 System Architecture
The project is divided into different modules:
- **Admin Module**: Handles candidate and voter management.
- **Voter Module**: Allows authenticated users to cast votes.
- **Database Connection**: Facilitates secure data storage and retrieval.
- **Voting Mechanism**: Prevents duplicate voting and maintains accurate vote counts.

## 📊 Database Schema
Entities in the database:
- **Admin**: (`A_ID`, `Phone`, `Email`, `Fullname`, `Username`, `Password`)
- **Account**: (`ACC_ID`, `Username`, `Password`, `V_ID`)
- **Voter**: (`V_ID`, `Job`, `Phone`, `Name`, `DOB`, `Gender`, `A_ID`)
- **Candidate**: (`C_ID`, `First Name`, `Last Name`, `Phone`, `Position`, `A_ID`)
- **Votes**: (`Votes_ID`, `Date`, `V_ID`, `C_ID`)

## 🚀 How to Run the Project
1. Clone the repository:
   ```sh
   git clone https://github.com/your-username/voting-system.git
   ```
2. Open the project in **NetBeans IDE**.
3. Configure database credentials in `ConnectToDb.java`.
4. Run the SQL scripts to create the database and tables.
5. Start the application and log in as Admin or Voter.

## ✅ Sample SQL Queries
Find the top 10 candidates with the highest votes:
```sql
SELECT TOP 10 Candidate.First_name, Candidate.Last_name, COUNT(Votes.V_ID) AS VoteCount
FROM Candidate
JOIN Votes ON Candidate.C_ID = Votes.C_ID
GROUP BY Candidate.C_ID, Candidate.First_name, Candidate.Last_name
ORDER BY VoteCount DESC;
```

Find the most recent voter:
```sql
SELECT TOP 1 Voter.* FROM Voter
JOIN Votes ON Voter.V_ID = Votes.V_ID
ORDER BY Votes.date DESC;
```

## 📄 Project Documentation
- [Source Code](https://drive.google.com/drive/folders/1LDLDizHy9qtnUsxD4TRLR8vxgaIWUgwj?usp=sharing)
- [Slides](https://www.canva.com/design/DAFh3AlX0Ys/94_U_U1F-XZRpzNA56JZKg/edit?utm_content=DAFh3AlX0Ys&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton)

📢 **Vote Smart, Vote Securely!** 🗳️"""

with open("README.md", "w", encoding="utf-8") as file:
    file.write(readme_content)

print("README.md file has been generated successfully!")
