# DevopsCw1

A small Java project used as a DevOps coursework exercise. It contains a decimal-to-hexadecimal converter, a JUnit 4 test suite, and a SonarQube configuration for static analysis and coverage in a Jenkins pipeline.

The point of the project is not the converter itself but the build, test, and quality-analysis pipeline around it: compile the code, run the unit tests, and report code quality and coverage to SonarQube.

## What's in the repo

| File | Purpose |
|------|---------|
| `Dec2Hex.java` | The application. Converts a decimal integer to its hexadecimal string. |
| `testing.java` | JUnit 4 test suite for `Dec2Hex.convertToHex` plus argument-handling tests. |
| `testrun.java` | A custom JUnit runner (`main` method) that runs the `testing` suite and exits with a non-zero status if any test fails. |
| `sonar-project.properties` | SonarQube scanner configuration (project key, sources, binaries, coverage target). |
| `junit4.10/` | Bundled JUnit 4.10 jars (`junit-4.10.jar`, `junit-dep-4.10.jar`, source jar). |
| `.gitignore` | Ignores compiled `*.class` files and the `out/` build directory. |

## The application

`Dec2Hex` takes a single integer as a command-line argument and logs its hexadecimal value.

`convertToHex(int num)` is the core method: it handles `0` as a special case, then repeatedly takes `num % 16`, maps the remainder to a hex character (`0`–`9`, `A`–`F`), and divides by 16 until the number is consumed. Input parsing and error cases (no argument, non-integer input) are handled in `main` and reported through `java.util.logging`.

## Tests

`testing.java` covers the converter with representative values:

- `1` → `1`
- `10` → `A`
- `15` → `F`
- `16` → `10`
- `47` → `2F`

It also checks the argument-handling behaviour: no argument provided, a non-integer argument, and a valid integer argument.

`testrun.java` wraps the suite in a runner that exits `0` when everything passes and `1` when any test fails, so a CI job can gate on the exit code.

## Prerequisites

- JDK 8 or later (`javac` and `java` on your `PATH`)
- The bundled JUnit jar in `junit4.10/` (JUnit 4.10 ships Hamcrest inside `junit-4.10.jar`, so no separate Hamcrest jar is needed)
- SonarQube server and `sonar-scanner`, only if you want to run the analysis step

## Build and run

Compile everything into an `out/` directory (this matches `sonar.java.binaries=out`):

```bash
javac -d out -cp junit4.10/junit-4.10.jar *.java
```

Run the converter:

```bash
java -cp out Dec2Hex 47
# logs: Hexadecimal is: 2F
```

## Run the tests

Using the custom runner (returns a non-zero exit code on failure, which is what the pipeline checks):

```bash
java -cp "out:junit4.10/junit-4.10.jar" testrun
```

On Windows, use `;` instead of `:` as the classpath separator:

```bash
java -cp "out;junit4.10/junit-4.10.jar" testrun
```

## Static analysis (SonarQube)

`sonar-project.properties` configures the scan:

```properties
sonar.projectKey=java-jenkins-sonar
sonar.sources=.
sonar.java.binaries=out
sonar.coverage=80
```

The code must be compiled to `out/` before scanning, since Sonar reads the compiled binaries. With a SonarQube server reachable and `sonar-scanner` installed, run:

```bash
sonar-scanner
```

The project key (`java-jenkins-sonar`) and the layout indicate this is driven from a Jenkins pipeline: compile, run the tests via `testrun`, then invoke the scanner so SonarQube reports quality and coverage against the 80% target.

## Notes

- Class names `testing` and `testrun` are lowercase, so keep the classpath and class-name casing exactly as shown when running.
- Compiled `.class` files and `out/` are git-ignored; only source and the JUnit jars are tracked.
