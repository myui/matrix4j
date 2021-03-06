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
package matrix4j.utils.lang.mutable;

import java.io.Serializable;

public final class MutableInt extends Number implements Comparable<MutableInt>, Serializable {
    private static final long serialVersionUID = -3289272606407100628L;

    private int value;

    public MutableInt() {
        super();
    }

    public MutableInt(int value) {
        super();
        this.value = value;
    }

    public MutableInt(Number value) {
        super();
        this.value = value.intValue();
    }

    public int getAndIncrement() {
        int ret = value;
        this.value += 1;
        return ret;
    }

    public void incr() {
        this.value += 1;
    }

    public void decr() {
        this.value -= 1;
    }

    public void addValue(int o) {
        this.value += o;
    }

    public int get() {
        return value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setValue(Number value) {
        this.value = value.intValue();
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return value;
    }

    @Override
    public float floatValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

    @Override
    public int compareTo(MutableInt other) {
        return compare(value, other.value);
    }

    private static int compare(final int x, final int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MutableInt) {
            return value == ((MutableInt) obj).intValue();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
