/*
 * Copyright 2019 and onwards Makoto Yui
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package matrix4j.matrix;

import matrix4j.vector.SparseVector;
import matrix4j.vector.Vector;
import matrix4j.vector.VectorProcedure;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

public abstract class AbstractMatrix implements Matrix {

    public AbstractMatrix() {}

    @Override
    public double[] row() {
        int cols = numColumns();
        return new double[cols];
    }

    @Override
    public Vector rowVector() {
        return new SparseVector();
    }

    @Override
    public final double get(@Nonnegative final int row, @Nonnegative final int col) {
        return get(row, col, 0.d);
    }

    protected static final void checkRowIndex(final int row, final int numRows) {
        if (row < 0 || row >= numRows) {
            throw new IndexOutOfBoundsException("Row index " + row + " out of bounds " + numRows);
        }
    }

    protected static final void checkColIndex(final int col, final int numColumns) {
        if (col < 0 || col >= numColumns) {
            throw new IndexOutOfBoundsException(
                "Col index " + col + " out of bounds " + numColumns);
        }
    }

    protected static final void checkIndex(final int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }
    }

    protected static final void checkIndex(final int row, final int col) {
        if (row < 0) {
            throw new IndexOutOfBoundsException("Invalid row index " + row);
        }
        if (col < 0) {
            throw new IndexOutOfBoundsException("Invalid col index " + col);
        }
    }

    protected static final void checkIndex(final int row, final int col, final int numRows,
            final int numColumns) {
        if (row < 0 || row >= numRows) {
            throw new IndexOutOfBoundsException("Row index " + row + " out of bounds " + numRows);
        }
        if (col < 0 || col >= numColumns) {
            throw new IndexOutOfBoundsException(
                "Col index " + col + " out of bounds " + numColumns);
        }
    }

    @Override
    public void eachInRow(final int row, @Nonnull final VectorProcedure procedure) {
        eachInRow(row, procedure, true);
    }

    @Override
    public void eachInColumn(final int col, @Nonnull final VectorProcedure procedure) {
        eachInColumn(col, procedure, true);
    }

    @Override
    public void eachNonNullInRow(final int row, @Nonnull final VectorProcedure procedure) {
        eachInRow(row, procedure, false);
    }

    @Override
    public void eachNonNullInColumn(final int col, @Nonnull final VectorProcedure procedure) {
        eachInColumn(col, procedure, false);
    }

    @Override
    public void eachNonZeroCell(VectorProcedure procedure) {
        throw new UnsupportedOperationException("Not yet supported");
    }

    @Override
    public String toString() {
        final int printSize = 7;
        final StringBuilder buf = new StringBuilder();

        final int rows = numRows();
        final int cols = numColumns();

        final String newline = cols > printSize ? "...\n" : "\n";

        for (int i = 0, maxRows = Math.min(printSize, rows); i < maxRows; i++) {
            for (int j = 0, maxCols = Math.min(printSize, cols); j < maxCols; j++) {
                buf.append(String.format("%8.4f  ", get(i, j)));
            }
            buf.append(newline);
        }

        if (rows > printSize) {
            buf.append("  ...\n");
        }

        return buf.toString();
    }

}
