package controller;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ValidateAPI {
    private static final String VALID_API_KEY = "123456789";
    public boolean isValidApiKey(String apiKey) {
        return VALID_API_KEY.equals(apiKey);
    }

}
