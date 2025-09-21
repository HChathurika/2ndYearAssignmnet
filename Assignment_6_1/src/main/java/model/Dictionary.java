package model;

import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> words = new HashMap<>();

    public Dictionary() {
        // Hardcoded words (temporary)
        addWord("Java", "A high-level programming language.");
        addWord("Python", "A versatile programming language.");
        addWord("HTML", "Markup language for web pages.");
    }

    public void addWord(String word, String meaning) {
        words.put(word.toLowerCase(), meaning);
    }

    public String searchWord(String word) throws Exception {
        if (word.isEmpty()) {
            throw new Exception("Please enter a word.");
        }
        String meaning = words.get(word.toLowerCase());
        if (meaning == null) {
            throw new Exception("Word not found.");
        }
        return meaning;
    }
}
