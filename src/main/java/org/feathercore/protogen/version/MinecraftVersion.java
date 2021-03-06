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

package org.feathercore.protogen.version;

public enum MinecraftVersion {
    _1_8_8(47, createOldIdLink("7368"), "1.8.8", null, -1, -1),
    _1_8_9(47, createOldIdLink("7368"), "1.8.9", null, -1, -1),
    _1_9_4(110, createOldIdLink("7959"), "1.9.4", null, -1, -1),
    _1_10_2(210, createOldIdLink("8235"), "1.10.2", null, -1, -1),
    _1_11_2(316, createOldIdLink("8543"), "1.11.2", null, -1, -1),
    _1_12_2(340, createOldIdLink("14204"), "1.12.2", null, -1, 2),
    _1_13_2(404, "http://wiki.vg/Protocol", "1.13.2", "bza", 11, 3);

    private static final String FORMAT = "http://wiki.vg/index.php?title=Protocol&oldid=%s";
    private final int protocolVersion;
    private final String link;
    private final String name;
    private String blockClass;
    private final String materialClass;
    private final int materialSlot;
    private final int registrySlot;

    MinecraftVersion(int protocolVersion, String link, String name, String materialClass,
                     int materialSlot, final int registrySlot) {
        this.protocolVersion = protocolVersion;
        this.link = link;
        this.name = name;
        this.materialClass = materialClass;
        this.materialSlot = materialSlot;
        this.registrySlot = registrySlot;
    }

    public int getProtocolVersion() {
        return protocolVersion;
    }

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }

    private static String createOldIdLink(String id) {
        return String.format(FORMAT, id);
    }

    public int getMaterialSlot() {
        return materialSlot;
    }

    public String getBlockClass() {
        return blockClass;
    }

    public String getMaterialClass() {
        return materialClass;
    }

    public int getRegistrySlot() {
        return registrySlot;
    }

    public void setBlockClass(String blockClass) {
        this.blockClass = blockClass;
    }

    @Override
    public String toString() {
        return name + "/" + protocolVersion;
    }
}
