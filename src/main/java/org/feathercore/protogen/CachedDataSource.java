/*
 * Copyright 2019 Feather Core
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

package org.feathercore.protogen;

/**
 * @author xtrafrancyz
 */
public class CachedDataSource<T> {
    private Creator<T> creator;
    private T cache;

    public T get() throws Exception {
        if (cache == null) {
            cache = creator.create();
        }
        return cache;
    }

    public void setHandle(Creator<T> creator) {
        this.creator = creator;
    }

    public interface Creator<T> {
        T create() throws Exception;
    }
}
