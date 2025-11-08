# University Coursework Management System (UCMS)

This Java console application simulates a **University Coursework Management System**  
used to manage users, courses, and modules within a university setting.

---

## Exercise 2 — Exception Handling & Artefact Management

This partial version of UCMS cover a number of learning objectives as shown below:

### Learning Objectives
- Apply **abstract classes** and **method overriding**
- Implement and use **generic interfaces**
- Demonstrate **robust exception handling** and input validation
- Manage **artefacts** (reports and data containers)
- Ensure the system **runs without errors** and gracefully handles invalid input

---

## Key Features Implemented
| Area                    | Description                                                                            |
|-------------------------|----------------------------------------------------------------------------------------|
| **Abstract Class**      | `User` made abstract with `generateReport(String[])` implemented by `Admin`            |
| **Interfaces**          | `Module` implements `Assignable<Lecturer>`; `Lecturer` implements `Assignable<Course>` |
| **Exception Handling**  | Input validation prevents crashes (e.g. invalid menu or login data)                    |
| **Artefact Management** | `Admin.generateReport()` outputs a dynamic UCMS summary report                         |
| **Sample Data**         | Optional `loadSampleData()` method populates the system for quick testing              |
| **Safe Stubs**          | Non-essential menu options display “Not implemented for Exercise 2” and never crash    |

---

## Running the Program
1. Open the project in **IntelliJ IDEA** (or any Java 21+ environment).
2. Run `Main.java`.
3. Choose a role from the main menu:
    - **Admin** → Can add/update courses and generate reports
    - **Lecturer/Student** → Stub menus (safe placeholders for Exercise 2)
4. Use the `loadSampleData()` helper in `Main` for quick test data.

---

## Exception Handling Examples
- **Invalid menu input:** entering “one” or out-of-range values re-prompts instead of crashing.
- **Empty or invalid admin details:** program re-prompts until valid information is entered.
- **All menu paths:** safely return to the previous menu or print an explanatory message.

---

## Submission Readiness
- ✅ Runs without compile/runtime errors
- ✅ All Exercise 2 requirements implemented
- ✅ Gracefully handles invalid input
- ✅ Clear separation between completed tasks and unimplemented stubs

---

## Author
**Michael McKibbin**  
_BSc (Hons) Contemporary Software Development (Software Development - Exercise 2 Submission — Exception Handling & Artefact Management)_

---
