package myfiles.GC.dto;

import jakarta.validation.constraints.NotNull;

public class DesignRequest {
    @NotNull(message = "Colors cannot be null")
    private String colors;

    @NotNull(message = "Quantity cannot be null")
    private int quantity;

    @NotNull(message = "Sizes cannot be null")
    private String sizes;

    @NotNull(message = "Design file is required")
    private String designFile;

    @NotNull(message = "User ID is required")
    private Integer userId; // Associate design with a user

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
