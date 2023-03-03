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

This lab we used several tools, including manual calculations, to calculate the coverage of methods in DataUtilities class and Range class. First the coverage was calculated using only tests written in assignment 2 using black box methods, then, using white box testing, more tests were developed to improve coverage for all coverage types.

# 2 Manual data-flow coverage calculations for X and Y methods

See images SENG438_Lab3_DataUtilCFG and SENG438_Lab3_RangeCFG in folder "submission/images/diagrams" to view the data-flow coverage for methods DataUtilitise.CalculateColumnTotal and Range.Equal respectively.

# 3 A detailed description of the testing strategy for the new unit test

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

After trying several coverage tools, we couldn’t find one/make a tool work that could show us the condition coverage. Therefor, we opted to show the coverage for Statement / line coverage, branch coverage and method coverage. The screenshots displaying the coverage reached for each of these metrics can be found in "submission/images/coverageResults" folder.

The methods getUpperBound, getLowerBound, and getLength in the class Range could not achieve a statement coverage of 90% because of infeasible paths in the method implementation. There is a condition in all three methods which checks if “lower > upper” which can never be true due to that condition already appearing in the constructor. When that condition is met in the constructor, an illegal argument exception is thrown, preventing any instance of Range from being created satisfying that condition. Because of that, getUpperBound, getLowerBound, and getLength can never get to 100% statement coverage.

There is another infeasible path in DataUtilities in the method calculateColumnTotal. This infeasible path did not prevent us from achieving the needed coverage percentages however it does contain statements of unreachable code. A variable is defined to be 0 and then is immediately checked if it is greater than 0. The code within that if statement is impossible to reach without some bit corruption occurring.


# 6 Pros and Cons of coverage tools used and Metrics you report

To perform our coverage testing we attempted to use two different tools. EclEmma was the easy choice as it came preinstalled with eclipse and was fairly simple to figure out how to perform the coverage testing. However, a drawback was that the results were not very intuitive. The website's documentation of the coverage metrics were incomplete or missing, and therefore required us to infer some of their meaning. It also was not evidently clear that it did perform all the coverage tests as the results would omit them if the test cases did not contain for example branchs or conditions. We also attempted to use CodeCover, although something went wrong with the installation and the documentation and user support was insufficient to resolve the issue, hence we scrapped attempting to use that coverage tool. A drawback of these coverage metrics is that even when we attain 100% coverage, that does not account for the edge case failures. However, we can presume that with multiple metrics meeting a high percentage of coverage that the foundations of a program are solid. But does not mean it is flawless as without additional targeted testing, more obscure edge cases can cause critical errors in the system.

# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.

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

One group member created CFG for methods calculateColumnTotal from DataUtilitise and equal from Range class. Using the diagrams to do manual calculations as specified in section 3.2.
2 group members worked on created additional tests for all methods to improve coverage.
Another group member focused on testing varyious coverage tools to find the coverage metrics from using tests only from assignment two and and then the new metrics after aditional test creations.

# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the lab

There were a few ambiguities we found when working through this lab, as to how many new unit tests we were to develop was unclear. For example, whether we should have full coverage for all of Ranges methods or just the ones that we had initially created in assignment 2. Another issue was with the lab document itself, as a number of the photos to help with importing our suite were not functioning so it took us a significant amount of time to troubleshoot issues with the import. Additionally, the coverage testing tools were not very intuitive and had very outdated documentation in regards to setting them up and physically running them to check coverage metrics.

additionally:

- one of the external jar files was missing, requiring a lot of debugging.
  - the import of `hamcrest-library-1.1.jar` and `hamcrest-core-1.1.jar` fixed
  this after comparing it to the assignment 2 codebase.

# 10 Comments/feedback on the lab itself

Instructions in section 3.3 could be updated to explicitly state that we need to write tests to cover ALL methods in class Range not just the 5 methods used in assignment 2.
Several images in the lab instruction document could not be viewed and made troubleshooting difficult as there was nothing to visually refrence.
ext…
