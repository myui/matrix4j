# Matrix4j
The matrix and vector library for Java

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
