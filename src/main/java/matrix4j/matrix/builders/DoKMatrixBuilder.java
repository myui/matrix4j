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

import matrix4j.matrix.sparse.DoKMatrix;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

public final class DoKMatrixBuilder extends MatrixBuilder {

    @Nonnull
    private final DoKMatrix matrix;

    private int row;

    public DoKMatrixBuilder(@Nonnegative int initSize) {
        super();
        this.row = 0;
        this.matrix = new DoKMatrix(initSize);
    }

    @Override
    public DoKMatrixBuilder nextRow() {
        row++;
        return this;
    }

    @Override
    public DoKMatrixBuilder nextColumn(@Nonnegative final int col, final double value) {
        checkColIndex(col);

        matrix.set(row, col, value);
        return this;
    }

    @Override
    public DoKMatrix buildMatrix() {
        return matrix;
    }

}
