# Matrix4j
[![Build Status](https://travis-ci.org/myui/matrix4j.svg?branch=master)](https://travis-ci.org/myui/matrix4j)
[![License](http://img.shields.io/:license-Apache_v2-blue.svg)](https://github.com/myui/matrix4j/blob/master/LICENSE)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.myui/matrix4j/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.myui/matrix4j)

The matrix and vector library for Java

# How to use

You can use Matrix4j through Maven central repository by adding the following entry to your project pom.xml file.

```
    <dependency>
      <groupId>io.github.myui</groupId>
      <artifactId>matrix4j</artifactId>
      <version>0.9.2</version>
    </dependency>
 ```

Find usage in [unit tests](https://github.com/myui/matrix4j/blob/master/src/test/java/matrix4j/matrix/MatrixBuilderTest.java).

# Requirements

Java7 or later is supported.

Matrix4j has minimum dependencies to

- jsr305 1.3.9
- fastutil [7.2.1,7.3)

# What matrix4j provides

- Matrix
    - Sparse Matrix
        - CSR Matrix
        - CSC Matrix
        - DoK Matrix
    - Dense Matrix
        - Column-major Dense Matrix
         - Row-major Dense Matrix
    - double/float/int matrix
- Dense/Sparse Vector
- Vector processing APIs

# What matrix4j does not provide

Matrix4j _does not_ provides Linear Algebra while it provides _minimum building blocks_ for Matrix computation.
