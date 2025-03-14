package myfiles.GC.model;

import jakarta.persistence.*;

@Entity
@Table(name = "designs")
public class Design {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String colors;
    private int quantity;
    private String sizes;

    @Lob
    @Column(columnDefinition = "BLOB")  // For storing binary data (e.g., image file)
    private byte[] designFile;  // Store the file as a byte array

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;  // Establish a relationship to the User entity

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

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
