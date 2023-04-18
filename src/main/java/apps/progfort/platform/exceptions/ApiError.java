package apps.progfort.platform.exceptions;

public record ApiError(int statusCode, String message) {}
