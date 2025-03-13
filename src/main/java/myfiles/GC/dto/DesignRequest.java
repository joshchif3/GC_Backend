package myfiles.GC.dto;

public class DesignRequest {
    private String colors;
    private int quantity;
    private String sizes;
    private String designFile;
    private Integer userId; // Add userId to associate the design with a user

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