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
package matrix4j.matrix.builders;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import matrix4j.matrix.dense.ColumnMajorDenseMatrix2d;
import matrix4j.utils.collections.Fastutil;
import matrix4j.utils.collections.arrays.SparseDoubleArray;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

public final class ColumnMajorDenseMatrixBuilder extends MatrixBuilder {

    @Nonnull
    private final Int2ObjectMap<SparseDoubleArray> col2rows;
    private int row;
    private int maxNumColumns;
    private int nnz;

    public ColumnMajorDenseMatrixBuilder(int initSize) {
        this.col2rows = new Int2ObjectOpenHashMap<SparseDoubleArray>(initSize);
        this.row = 0;
        this.maxNumColumns = 0;
        this.nnz = 0;
    }

    @Override
    public ColumnMajorDenseMatrixBuilder nextRow() {
        row++;
        return this;
    }

    @Override
    public ColumnMajorDenseMatrixBuilder nextColumn(@Nonnegative final int col,
            final double value) {
        checkColIndex(col);

        this.maxNumColumns = Math.max(col + 1, maxNumColumns);
        if (value == 0.d) {
            return this;
        }

        SparseDoubleArray rows = col2rows.get(col);
        if (rows == null) {
            rows = new SparseDoubleArray(4);
            col2rows.put(col, rows);
        }
        rows.put(row, value);
        nnz++;
        return this;
    }

    @Override
    public ColumnMajorDenseMatrix2d buildMatrix() {
        final double[][] data = new double[maxNumColumns][];

        for (Int2ObjectMap.Entry<SparseDoubleArray> e : Fastutil.fastIterable(col2rows)) {
            int col = e.getIntKey();
            SparseDoubleArray rows = e.getValue();
            data[col] = rows.toArray();
        }

        return new ColumnMajorDenseMatrix2d(data, row, nnz);
    }

}
