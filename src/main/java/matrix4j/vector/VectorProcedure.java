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
package matrix4j.vector;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

public abstract class VectorProcedure {

    public VectorProcedure() {}

    public void apply(@Nonnegative int i, @Nonnegative int j, float value) {
        apply(i, j, (double) value);
    }

    public void apply(@Nonnegative int i, @Nonnegative int j, double value) {}

    public void apply(@Nonnegative int i, float value) {
        apply(i, (double) value);
    }

    public void apply(@Nonnegative int i, double value) {}

    public void apply(@Nonnegative int i, int value) {}

    public void apply(@Nonnegative int i) {}

    public void apply(@Nonnegative int i, @Nonnull int[] values) {}

}
