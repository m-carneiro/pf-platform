package apps.progfort.platform.courses;

import apps.progfort.platform.enums.Difficulties;

import java.util.List;

public record CoursesDTO (
    String name,
    String description,
    List<String> tags,
    Difficulties level,
    String category,
    Double price
) {}