package com.intexsoft.samokat.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestdataService {
    private static final Path TESTDATA_PATH = Path.of("src/test/resources/testdata.json");
    private static final JsonObject TESTDATA;

    static {
        try {
            TESTDATA = new Gson().fromJson(Files.readString(TESTDATA_PATH, StandardCharsets.UTF_8), JsonObject.class);
        } catch (IOException e) {
            throw new RuntimeException(String.format("Cannot find testdata.json at %s", TESTDATA_PATH));
        }
    }

}
