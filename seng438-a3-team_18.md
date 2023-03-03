**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report #3 – Code Coverage, Adequacy Criteria and Test Case Correlation**

| Group: 18                |
|:-------------------------|
| Braden Foley             |
| Ethan Sengsavang         |
| Momin Ali Khan           |
| Nicole Zacaruk           |

(Note that some labs require individual reports while others require one report
for each group. Please see each lab document for details.)

# 1 Introduction

Text… nz

# 2 Manual data-flow coverage calculations for X and Y methods

Text… nz

# 3 A detailed description of the testing strategy for the new unit test

Text… es

To design new unit tests for untested methods, we started with black box
testing. This process ensured that a general basis of the code, based off the
requirements within the documentation, was covered. This process primarily
focused on equivalent class testing, determining possible input value types and
passing those values as parameters for the method.

Once a basis of the test code has been defined, the test cases can be run
against the code such that the statements left uncovered can be easily
identified. With this, additional test cases can be crafted such that the
necessary conditions and situations to execute those lines can be met,
maximizing coverage.

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage

Text… momin

# 5 A detailed report of the coverage achieved of each class and method (a screen shot from the code cover results in green and red color would suffice)

Text… es

# 6 Pros and Cons of coverage tools used and Metrics you report

Text… braden

# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.

Text… es
- in this process, ensuring complete coverage is a reactionary process,
addressing the code, while the blackbox testing process more directly addressed
the documentation and the requirements of the code.
- the greatest downfall of requirements-based test generation was vague
requirements or documentation. the greatest downfall of white-box testing was
illogical code requiring unreasonable tests to achieve complete coverage.
- white-box testing is a lengthier process over black-box testing, but can be
more accurate
- some issues are easier to identify in white-box testing, however as the
testing team, our sole responsibility would be to identify these issues and
notify developers

# 8 A discussion on how the team work/effort was divided and managed

Text… nz

# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the lab

Text… braden
- one of the external jar files was missing, requiring a lot of debugging.
  - the import of `hamcrest-library-1.1.jar` and `hamcrest-core-1.1.jar` fixed
  this after comparing it to the assignment 2 codebase.

# 10 Comments/feedback on the lab itself

Text…
