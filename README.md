# toyrobot
My attempt at an implementation of the Toy Robot Puzzle Challenge using **Java 11**. Used **Gradle** for an easier time in bootstrapping the project and maintaining the structure. No framework or library dependency added except for **JUnit** and **Mockito** which were used for testing.

## General Usage
No need to install gradle since a gradle wrapper is already provided in the project root ("gradlew" for linux and "gradlew.bat" for windows). Run `gradlew tasks` to find out all the tasks that gradle can do.

## Testing
To run all the test of the project run
```bash
gradlew test
```
Afterwards, you can go to `\app\build\reports\tests\test` and open the `index.html` on your browser to view the test report that gradle generated after finishing the test.

You can also test a specific test class or even a specific method.
```bash
gradlew test --tests GameTest # Run all the test case of GameTest
gradlew test --tests InputParserTest.parsingValidInputProducesGameCommand # Run only the specified method of InputParserTest
```
