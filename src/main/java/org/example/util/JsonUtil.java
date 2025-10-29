package org.example.util;

import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonUtil
{
    private static final Gson gson = new Gson();
    private static final String RESOURCE_PATH = "src/main/resources/cart.json";

    public static void saveToFile(List<?> list)
    {
        try (Writer writer = new FileWriter(RESOURCE_PATH))
        {
            gson.toJson(list, writer);
        }
        catch (IOException e)
        {
            System.out.println("❌ Error saving data: " + e.getMessage());
        }
    }

    public static  List<?> loadFromFile(Type typeOfT)
    {
        try {
            File file = new File(RESOURCE_PATH);

            // Create file if it doesn't exist
            if (!file.exists())
            {
                Files.createDirectories(Paths.get("src/main/resources"));
                file.createNewFile();
                Files.write(Paths.get(RESOURCE_PATH), "[]".getBytes());
            }

            try (Reader reader = new FileReader(file))
            {
                List<?> data = gson.fromJson(reader, typeOfT);
                return data != null ? data : new java.util.ArrayList<>();
            }

        }
        catch (IOException e)
        {
            System.out.println("❌ Error loading data: " + e.getMessage());
        }

        return new java.util.ArrayList<>();
    }
}
