package com.intexsoft.samokat.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResourcesService {
    private static final Path TESTDATA_PATH = Path.of("src/test/resources/testdata.json");
    private static final Path CONFIG_PATH = Path.of("src/test/resources/config.json");
    private static final JsonObject TESTDATA;
    private static final JsonObject CONFIG;


    static {
        try {
            TESTDATA = new Gson().fromJson(Files.readString(TESTDATA_PATH, StandardCharsets.UTF_8), JsonObject.class);
        } catch (IOException e) {
            throw new RuntimeException(String.format("Cannot find testdata.json at %s", TESTDATA_PATH));
        }
    }

    static {
        try {
            CONFIG = new Gson().fromJson(Files.readString(CONFIG_PATH, StandardCharsets.UTF_8), JsonObject.class);
        } catch (IOException e) {
            throw new RuntimeException(String.format("Cannot find config.json at %s", CONFIG_PATH));
        }

    }
}
