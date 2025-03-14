package myfiles.GC.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class DesignRequest {

    @NotBlank(message = "Colors are required")
    private String colors;

    @Positive(message = "Quantity must be a positive number")
    private int quantity;

    @NotBlank(message = "Sizes are required")
    private String sizes;

    @NotBlank(message = "Design file is required")
    private String designFile;

    @NotNull(message = "User ID is required")
    private Integer userId;

    // Getters and setters
    public String getColors() { return colors; }
    public void setColors(String colors) { this.colors = colors; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public String getSizes() { return sizes; }
    public void setSizes(String sizes) { this.sizes = sizes; }
    public String getDesignFile() { return designFile; }
    public void setDesignFile(String designFile) { this.designFile = designFile; }
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
}