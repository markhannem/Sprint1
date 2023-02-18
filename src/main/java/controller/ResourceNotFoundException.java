package controller;

public class ResourceNotFoundException extends RuntimeException {
    private final String message;

    public ResourceNotFoundException(String s) {
        String message = "Item not found";
        this.message = "message";
    }
    public String getMessage() {
        return message;
    }
}
