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

import matrix4j.matrix.sparse.CSRMatrix;
import matrix4j.utils.lang.ArrayUtils;

import javax.annotation.Nonnull;

import org.junit.Assert;
import org.junit.Test;

public class CSRMatrixBuilderTest {

    @Test
    public void testUnordered() {
        CSRMatrix mat1 = csrMatrixFromLibSVM_ordered();
        CSRMatrix mat2 = csrMatrixFromLibSVM_unordered();
        Assert.assertEquals(mat1.toString(), mat2.toString());
    }

    @Nonnull
    private static CSRMatrix csrMatrixFromLibSVM_ordered() {
        /*
        11  12  13  14  0   0
        0   22  23  0   0   0
        0   0   33  34  35  36
        0   0   0   44  45  0
        0   0   0   0   0   56
        0   0   0   0   0   66
        */
        CSRMatrixBuilder builder = new CSRMatrixBuilder(1024);
        builder.nextRow(new String[] {"0:11", "1:12", "2:13", "3:14"});
        builder.nextRow(new String[] {"1:22", "2:23"});
        builder.nextRow(new String[] {"2:33", "3:34", "4:35", "5:36"});
        builder.nextRow(new String[] {"3:44", "4:45"});
        builder.nextRow(new String[] {"5:56"});
        builder.nextRow(new String[] {"5:66"});
        return builder.buildMatrix();
    }

    @Nonnull
    private static CSRMatrix csrMatrixFromLibSVM_unordered() {
        /*
        11  12  13  14  0   0
        0   22  23  0   0   0
        0   0   33  34  35  36
        0   0   0   44  45  0
        0   0   0   0   0   56
        0   0   0   0   0   66
        */
        CSRMatrixBuilder builder = new CSRMatrixBuilder(1024);
        builder.nextRow(ArrayUtils.shuffle(new String[] {"0:11", "1:12", "2:13", "3:14"}));
        builder.nextRow(ArrayUtils.shuffle(new String[] {"1:22", "2:23"}));
        builder.nextRow(ArrayUtils.shuffle(new String[] {"2:33", "3:34", "4:35", "5:36"}));
        builder.nextRow(ArrayUtils.shuffle(new String[] {"3:44", "4:45"}));
        builder.nextRow(ArrayUtils.shuffle(new String[] {"5:56"}));
        builder.nextRow(ArrayUtils.shuffle(new String[] {"5:66"}));
        return builder.buildMatrix();
    }

}
