package de.neuefische.neuefischespringsecuritycgnjava231;

public record MongoUser(
        String id,
        String username,
        String password,
        String role
) {
}
