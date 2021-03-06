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
package matrix4j.matrix.ints;

import matrix4j.vector.VectorProcedure;

import javax.annotation.Nonnull;

public abstract class ColumnMajorIntMatrix extends AbstractIntMatrix {

    public ColumnMajorIntMatrix() {
        super();
    }

    @Override
    public void eachInRow(int row, VectorProcedure procedure, boolean nullOutput) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void eachNonZeroInRow(int row, VectorProcedure procedure) {
        throw new UnsupportedOperationException();
    }

    public abstract void eachNonNullInColumn(final int col, final int startRow, final int endRow,
            @Nonnull final VectorProcedure procedure);

    public abstract void eachRow(@Nonnull final VectorProcedure procedure);

}
