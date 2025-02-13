package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ResourceLoader {
    private Map<String, String> messages = new HashMap<>();

    public ResourceLoader(String language) {
        loadMessages(language);
    }

    private void loadMessages(String language) {
        try {
            String filePath = "src/" + language + ".txt";

            Files.lines(Paths.get(filePath))
                    .forEach(line -> {
                        String[] parts = line.split("=", 2);
                        if (parts.length == 2) {
                            messages.put(parts[0], parts[1].replace("\\n", "\n"));
                        }
                    });
        } catch (IOException e) {
            System.err.println("Error loading language file: " + e.getMessage());
        }
    }

    public String get(String key) {
        return messages.getOrDefault(key, key);  // Връщаме стойността по ключ
    }
}
