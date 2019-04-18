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

package org.feathercore.protogen.wiki;

/**
 * @author xtrafrancyz
 */
public class WikiParticle {
    private String name;
    private String enumName;
    private int id;
    private boolean complex;

    public WikiParticle(String name, int id, boolean complex) {
        this.name = name;
        this.id = id;
        this.enumName = name.toUpperCase().substring(10); // trim "minecraft:"
        this.complex = complex;
    }

    public boolean isComplex() {
        return complex;
    }

    public String getEnumName() {
        return enumName;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
