package com.intexsoft.samokat.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConfigService {
    private static final Path CONFIG_PATH = Path.of("src/test/resources/testdata.json");
    private static final JsonObject CONFIG;

    static {
        try {
            CONFIG = new Gson().fromJson(Files.readString(CONFIG_PATH, StandardCharsets.UTF_8), JsonObject.class);
        } catch (IOException e) {
            throw new RuntimeException(String.format("Cannot find config.json at %s", CONFIG_PATH));
        }
    }
}
