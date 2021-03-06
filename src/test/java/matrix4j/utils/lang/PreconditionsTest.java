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
package matrix4j.utils.lang;

import org.junit.Assert;
import org.junit.Test;

public class PreconditionsTest {

    @Test(expected = NullPointerException.class)
    public void testCheckNotNullTClassOfE() {
        Preconditions.checkNotNull(null, NullPointerException.class);
    }

    @Test
    public void testCheckNotNullTClassOfE2() {
        final String msg = "safdfvzfd";
        try {
            Preconditions.checkNotNull(null, msg, NullPointerException.class);
        } catch (NullPointerException e) {
            if (e.getMessage().equals(msg)) {
                return;
            }
        }
        Assert.fail("should not reach");
    }

    @Test(expected = NullPointerException.class)
    public void testCheckArgumentBooleanClassOfE() {
        Preconditions.checkArgument(false, NullPointerException.class);
    }

    @Test
    public void testCheckArgumentBooleanClassOfE2() {
        final String msg = "safdfvzfd";
        try {
            Preconditions.checkArgument(false, NullPointerException.class, msg);
        } catch (NullPointerException e) {
            if (e.getMessage().equals(msg)) {
                return;
            }
        }
        Assert.fail("should not reach");
    }

}
