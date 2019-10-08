/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package matrix4j.utils.collections.lists;

import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Objects;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

public final class DoubleArrayList implements Serializable {
    private static final long serialVersionUID = -8155789759545975413L;
    public static final int DEFAULT_CAPACITY = 12;

    /** array entity */
    private double[] data;
    private int used;

    public DoubleArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public DoubleArrayList(int size) {
        this.data = new double[size];
        this.used = 0;
    }

    public DoubleArrayList(@CheckForNull double[] initValues) {
        this.data = Objects.requireNonNull(initValues);
        this.used = initValues.length;
    }

    @Nonnull
    public DoubleArrayList add(double value) {
        if (used >= data.length) {
            expand(used + 1);
        }
        data[used++] = value;
        return this;
    }

    @Nonnull
    public DoubleArrayList add(@Nonnull double[] values) {
        final int needs = used + values.length;
        if (needs >= data.length) {
            expand(needs);
        }
        System.arraycopy(values, 0, data, used, values.length);
        this.used = needs;
        return this;
    }

    /**
     * dynamic expansion.
     */
    private void expand(final int minimumCapacity) {
        while (data.length < minimumCapacity) {
            int oldLen = data.length;
            int newLen = (int) Math.max(minimumCapacity, Math.min(oldLen * 2L, Integer.MAX_VALUE));
            double[] newArray = new double[newLen];
            System.arraycopy(data, 0, newArray, 0, oldLen);
            this.data = newArray;
        }
    }

    public double remove() {
        if (used == 0) {
            throw new NoSuchElementException("No elements to remove");
        }
        return data[--used];
    }

    public double remove(int index) {
        if (index >= used) {
            throw new IndexOutOfBoundsException();
        }

        final double ret;
        if (index == used) {
            ret = data[index];
            --used;
        } else { // index < used
            ret = data[index];
            System.arraycopy(data, index + 1, data, index, used - index - 1);
            --used;
        }
        return ret;
    }

    public void set(int index, double value) {
        if (index > used) {
            throw new IllegalArgumentException("Index MUST be less than \"size()\".");
        } else if (index == used) {
            ++used;
        }
        data[index] = value;
    }

    public double get(int index) {
        if (index >= used)
            throw new IndexOutOfBoundsException();
        return data[index];
    }

    public double fastGet(int index) {
        return data[index];
    }

    public int size() {
        return used;
    }

    public boolean isEmpty() {
        return used == 0;
    }

    public void clear() {
        used = 0;
    }

    @Nonnull
    public double[] toArray() {
        return toArray(false);
    }

    @Nonnull
    public double[] toArray(boolean close) {
        final double[] newArray = new double[used];
        System.arraycopy(data, 0, newArray, 0, used);
        if (close) {
            this.data = null;
        }
        return newArray;
    }

    public double[] array() {
        return data;
    }

    @Override
    public String toString() {
        final StringBuilder buf = new StringBuilder();
        buf.append('[');
        for (int i = 0; i < used; i++) {
            if (i != 0) {
                buf.append(", ");
            }
            buf.append(data[i]);
        }
        buf.append(']');
        return buf.toString();
    }

}
