package com.myresume.api.gateway;

import java.util.HashSet;
import java.util.Set;

public class JwtTokenBlacklist {
    private static Set<String> BLACKLIST = new HashSet<>();

    public static void add(String token) {
        BLACKLIST.add(token);
    }

    public static boolean contains(String token) {
        return BLACKLIST.contains(token);
    }
}
