package com.example.bfhl;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class BfhlController {

    @GetMapping("/bfhl")
    public Map<String, Object> getOperationCode() {
        Map<String, Object> response = new HashMap<>();
        response.put("operation_code", 1);
        return response;
    }

    @PostMapping("/bfhl")
    public Map<String, Object> processData(@RequestBody Map<String, Object> request) {
        List<String> data = (List<String>) request.get("data");

        List<String> numbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        String highestAlphabet = "";

        for (String item : data) {
            if (item.matches("\\d+")) {
                numbers.add(item);
            } else {
                alphabets.add(item);
                if (highestAlphabet.isEmpty() || item.compareToIgnoreCase(highestAlphabet) > 0) {
                    highestAlphabet = item;
                }
            }
        }

        Map<String, Object> response = new HashMap<>();
        response.put("is_success", true);
        response.put("user_id", "malik_amber_123"); // change to your format
        response.put("email", "malik.amber1428@gmail.com");
        response.put("roll_number", "21BCE0000"); // put your roll no
        response.put("numbers", numbers);
        response.put("alphabets", alphabets);
        response.put("highest_alphabet", highestAlphabet.isEmpty() ? new ArrayList<>() : Arrays.asList(highestAlphabet));

        return response;
    }
}
