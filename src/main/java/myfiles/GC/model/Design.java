package myfiles.GC.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Design {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String colors;
    private int quantity;
    private String sizes;

    @Lob
    private byte[] designFile; // Store the file as a byte array

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date(); // Automatically set the creation timestamp

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Foreign key to the User table
    private User user; // Associate the design with a user

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getColors() { return colors; }
    public void setColors(String colors) { this.colors = colors; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public String getSizes() { return sizes; }
    public void setSizes(String sizes) { this.sizes = sizes; }
    public byte[] getDesignFile() { return designFile; }
    public void setDesignFile(byte[] designFile) { this.designFile = designFile; }
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}