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
package matrix4j.utils.collections.maps;

import org.junit.Assert;
import org.junit.Test;

public class Long2FloatOpenHashTableTest {

    @Test
    public void testSize() {
        Long2FloatOpenHashTable map = new Long2FloatOpenHashTable(16384);
        map.put(1L, 3);
        Assert.assertEquals(3, map.get(1L), 1E-6f);
        map.put(1L, 5);
        Assert.assertEquals(5, map.get(1L), 1E-6f);
        Assert.assertEquals(1, map.size());
    }

    @Test
    public void testDefaultReturnValue() {
        Long2FloatOpenHashTable map = new Long2FloatOpenHashTable(16384);
        map.defaultReturnValue(-1);
        Assert.assertEquals(0, map.size());
        Assert.assertEquals(-1, map.get(1L), 1E-6f);
        int ret = Integer.MAX_VALUE;
        map.defaultReturnValue(ret);
        Assert.assertEquals(ret, map.get(1L), 1E-6f);
    }

    @Test
    public void testPutAndGet() {
        Long2FloatOpenHashTable map = new Long2FloatOpenHashTable(16384);
        map.defaultReturnValue(-1);
        final int numEntries = 1000000;
        for (int i = 0; i < numEntries; i++) {
            Assert.assertEquals(-1L, map.put(i, i), 1E-6f);
        }
        Assert.assertEquals(numEntries, map.size());
        for (int i = 0; i < numEntries; i++) {
            Assert.assertEquals(i, map.get(i), 1E-6f);
        }

        map.clear();
        int i = 0;
        for (long j = 1L + Integer.MAX_VALUE; i < 10000; j += 99L, i++) {
            map.put(j, i);
        }
        Assert.assertEquals(i, map.size());
        i = 0;
        for (long j = 1L + Integer.MAX_VALUE; i < 10000; j += 99L, i++) {
            Assert.assertEquals(i, map.get(j), 1E-6f);
        }
    }

    @Test
    public void testIterator() {
        Long2FloatOpenHashTable map = new Long2FloatOpenHashTable(1000);
        map.defaultReturnValue(-1);
        Long2FloatOpenHashTable.IMapIterator itor = map.entries();
        Assert.assertFalse(itor.hasNext());

        final int numEntries = 1000000;
        for (int i = 0; i < numEntries; i++) {
            Assert.assertEquals(-1, map.put(i, i), 1E-6f);
        }
        Assert.assertEquals(numEntries, map.size());

        itor = map.entries();
        Assert.assertTrue(itor.hasNext());
        while (itor.hasNext()) {
            Assert.assertFalse(itor.next() == -1);
            long k = itor.getKey();
            float v = itor.getValue();
            Assert.assertEquals(k, v, 1E-6f);
        }
        Assert.assertEquals(-1, itor.next());
    }

    @Test
    public void testPutRemoveGet() {
        Long2FloatOpenHashTable map = new Long2FloatOpenHashTable(16384);
        map.defaultReturnValue(-1);
        map.defaultReturnValue(-2);
        final int numEntries = 1000000;
        for (int i = 0; i < numEntries; i++) {
            Assert.assertEquals(-2, map.put(i, i), 1E-6f);
        }
        Assert.assertEquals(numEntries, map.size());
        for (int i = 0; i < numEntries; i++) {
            Assert.assertEquals(i, map.remove(i), 1E-6f);
        }
        Assert.assertEquals(0, map.size());
        map.defaultReturnValue(-1);
        for (int i = 0; i < numEntries; i++) {
            Assert.assertEquals(-1, map.get(i), 1E-6f);
        }
        map.put(1, Integer.MAX_VALUE);
        Assert.assertEquals(Integer.MAX_VALUE, map.get(1), 1E-6f);
    }

    @Test
    public void testPutRemoveGet2() {
        Long2FloatOpenHashTable map = new Long2FloatOpenHashTable(16384);
        map.defaultReturnValue(-1);
        map.defaultReturnValue(-2);
        final int numEntries = 1000000;
        for (int i = 0; i < numEntries; i++) {
            Assert.assertEquals(-2, map.put(i, i), 1E-6f);
        }
        Assert.assertEquals(numEntries, map.size());
        for (int i = 0; i < numEntries; i++) {
            Assert.assertEquals(i, map.remove(i), 1E-6f);
        }
        Assert.assertEquals(0, map.size());
        map.defaultReturnValue(-1);
        for (int i = numEntries, len = numEntries + (numEntries / 2); i < len; i++) {
            Assert.assertEquals(-1, map.put(i, i), 1E-6f);
        }
        Assert.assertEquals(numEntries / 2, map.size());
        for (int i = numEntries, len = numEntries + (numEntries / 2); i < len; i++) {
            Assert.assertEquals(i, map.get(i), 1E-6f);
        }
        for (int i = numEntries + (numEntries / 2), j = 0; j < numEntries; i++, j++) {
            Assert.assertEquals(-1, map.put(i, i), 1E-6f);
        }
        for (int i = numEntries + (numEntries / 2), j = 0; j < numEntries; i++, j++) {
            Assert.assertEquals(i, map.get(i), 1E-6f);
        }
    }

    @Test
    public void testShrink() {
        Long2FloatOpenHashTable map = new Long2FloatOpenHashTable(16384);
        map.defaultReturnValue(-1);
        final int numEntries = 65536;
        for (int i = 0; i < numEntries; i++) {
            Assert.assertEquals(-1, map.put(i, i), 1E-6f);
            Assert.assertEquals(i, map.remove(i), 1E-6f);
        }
        Assert.assertEquals(0, map.size());
        map.defaultReturnValue(-2);
        for (int i = 0, len = 2 * numEntries; i < len; i++) {
            Assert.assertEquals(-2, map.put(i, i), 1E-6f);
        }
        Assert.assertEquals(numEntries * 2, map.size());
    }
}
