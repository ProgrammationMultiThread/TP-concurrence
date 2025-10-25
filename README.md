# Concurrent Multithreaded Programming – Introduction to concurrency (TP)

This repository contains the **starter code and exercises** for the first hands-on session (*Travaux Pratiques*) of the *[Programmation Concurrente en Multi-Threads](https://github.com/ProgrammationMultiThread/)* course at **Nantes Université**.

---

## Notes for students

Each file in `src/main/java/` is an **independent Java program** corresponding to a TP exercise.  
These programs illustrate key concepts from the lectures — *asynchrony, critical sections, visibility, liveness, monitors, reentrancy*, etc.

You can open, modify, and run them directly to observe typical issues
encountered in concurrent programming.

- These examples are intended for **educational use** only.  
- The programs are deliberately **simplified**: they are not production-grade and may contain data races or deadlocks by design.  
- Each exercise is documented in the corresponding **LaTeX sheet** of the course.  
- Some programs require an **integer argument** (e.g., number of iterations or tokens). If no argument is provided, a small dialog box will appear to ask for a value. This feature is implemented via the `concurrence.utils.ParseArgs` helper class.

---

## How to open and run the project

Clone the repository:

```bash
git clone git@github.com:ProgrammationMultiThread/TP-concurrence.git
```

Then import it as a **Maven project** in your IDE:
- **Eclipse** → *File → Import → Existing Maven Project*  
- **IntelliJ IDEA** → *Open → pom.xml*  
- **VS Code** → install the *Extension Pack for Java* and open the folder.

To compile and run a program manually:
```bash
mvn compile
mvn exec:java -Dexec.mainClass="concurrence.CountingSemaphore" -Dexec.args="6"
```

---

## License

All **Java source code and related project files** in this repository  
are distributed under the **MIT License**.

- The full legal text of this license is available in [`LICENSE.txt`](LICENSE.txt).  
- Detailed attributions and cross-repository licensing notes  
  are provided in the [organization-wide license file](https://github.com/ProgrammationMultiThread/.github/blob/main/LICENSE.md).

This license applies only to the **original Java code** provided as part of the  
*Concurrent Multithreaded Programming* course at Nantes Université.  
External libraries and dependencies (e.g. JSoup, JUnit) are distributed  
under their own respective licenses.

### Suggested attribution

> *"Source code from the course **Programmation Concurrente en Multi-Threads** —  
> © 2025 Matthieu Perrin, licensed under the MIT License."*
