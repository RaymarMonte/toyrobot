# toyrobot
My attempt at an implementation of the Toy Robot Puzzle Challenge using **Java 11**. Used **Gradle** for an easier time in bootstrapping the project and maintaining the structure. No framework or library dependency added except for **JUnit** and **Mockito** which were used for testing. 

The method that I used for capturing input commands is through files. Files are feeded to the app by setting its path as parameter when running the app.

## General Usage
No need to install gradle since a gradle wrapper is already provided in the project root ("gradlew" for linux and "gradlew.bat" for windows). Run `gradlew tasks` to find out all the tasks that gradle can do.

## Testing
To run all the test of the project run
```bash
gradlew test
```
Afterwards, you can go to `\app\build\reports\tests\test` and open the `index.html` on your browser to view the HTML test report that gradle generated after finishing the test.

You can also test a specific test class or even a specific method.
```bash
gradlew test --tests PlaceGameCommandTest # Run all the test case of GameTest
gradlew test --tests InputParserTest.parsingValidInputProducesGameCommand # Run only the specified method of InputParserTest
```
## Running
To run the app, use
```bash
gradlew run --args='<text-file-containing-commands>'
```
For example
```bash
gradlew run --args='testinputs\a.txt'
```
to input the commands from the `\app\testinputs\a.txt` (app folder is the working directory when running `gradlew run`). Absolute path can also be used to reference files.
