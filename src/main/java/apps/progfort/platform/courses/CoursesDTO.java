package apps.progfort.platform.courses;

import apps.progfort.platform.enums.Dificulties;
import java.util.List;

public class CoursesDTO {
  private String name;
  private String description;
  private List<String> tags;
  private Dificulties level;

  private String category;
  private Double price;

  public CoursesDTO() {}

  public CoursesDTO(String name, String description, List<String> tags,
                    Dificulties level, String category, Double price) {
    this.name = name;
    this.description = description;
    this.tags = tags;
    this.level = level;
    this.category = category;
    this.price = price;
  }

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }

  public String getDescription() { return description; }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<String> getTags() { return tags; }

  public void setTags(List<String> tags) { this.tags = tags; }

  public Dificulties getLevel() { return level; }

  public void setLevel(Dificulties level) { this.level = level; }

  public Double getPrice() { return price; }

  public void setPrice(Double price) { this.price = price; }

  public String getCategory() { return category; }

  public void setCategory(String category) { this.category = category; }
}
