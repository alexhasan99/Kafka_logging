package com.example.demo;

import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.lookup.StrLookup;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Plugin(name = "CustomLookup", category = StrLookup.CATEGORY)
public class CustomLookup implements StrLookup {

    private static String cachedHostname = null;

    static {
        System.out.println("CustomLookup loaded");
    }
    private static synchronized String getHostname() {
        if (cachedHostname == null || cachedHostname.isEmpty() || "c.n.n.n.".equals(cachedHostname)) {
            try {
                cachedHostname = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e) {
                cachedHostname = "unknown-host";
            }
        }
        return cachedHostname;
    }

    @Override
    public String lookup(String key) {
        if ("container.name".equals(key)) {
            return getHostname();
        }
        return null; // Ingen matchning
    }

    @Override
    public String lookup(LogEvent event, String key) {
        return lookup(key); // Du kan erbjuda mer specifika lookups baserat på LogEvent om så önskas
    }
}

