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

package org.feathercore.protogen.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

/**
 * @author xtrafrancyz
 */
public final class NetworkUtil {

    private NetworkUtil() { }

    public static String get(String url) throws IOException {
        HttpURLConnection conn = null;
        try {
            for (int i = 0; i < 3; i++) {
                conn = (HttpURLConnection) new URL(url).openConnection();
                conn.setConnectTimeout(10000);
                conn.setReadTimeout(10000);
                conn.setRequestProperty("User-Agent", "protogen");
                switch (conn.getResponseCode()) {
                    case HttpURLConnection.HTTP_MOVED_PERM:
                    case HttpURLConnection.HTTP_MOVED_TEMP:
                        url = new URL(new URL(url), conn.getHeaderField("Location")).toExternalForm();
                        conn.disconnect();
                        continue;
                }
                break;
            }
            if (conn.getResponseCode() / 200 == 1) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                   return br.lines().collect(Collectors.joining());
                }
            } else {
                conn.getInputStream();
                return null;
            }
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
}
