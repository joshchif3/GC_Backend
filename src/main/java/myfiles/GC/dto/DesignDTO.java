package myfiles.GC.dto;

public class DesignDTO {
    private String colors;
    private int quantity;
    private String sizes;
    private String designFile; // Base64 encoded file
    private Long userId; // Change Integer to Long

    // Getters and Setters
    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public String getDesignFile() {
        return designFile;
    }

    public void setDesignFile(String designFile) {
        this.designFile = designFile;
    }

    public Long getUserId() { // Change return type to Long
        return userId;
    }

    public void setUserId(Long userId) { // Change parameter type to Long
        this.userId = userId;
    }
}
