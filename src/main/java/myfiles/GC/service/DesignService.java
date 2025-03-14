package myfiles.GC.service;

import myfiles.GC.model.Design;
import myfiles.GC.model.User;
import myfiles.GC.repository.DesignRepository;
import myfiles.GC.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Base64;
import java.util.Optional;

@Service
public class DesignService {

    @Autowired
    private DesignRepository designRepository;

    @Autowired
    private UserRepository userRepository;

    public void saveDesign(String colors, int quantity, String sizes, String designFileBase64, Integer userId) {
        // Validate Base64 data
        if (designFileBase64 == null || designFileBase64.isEmpty()) {
            throw new IllegalArgumentException("Design file is required");
        }

        // Remove the "data:image/...;base64," prefix if present
        String base64Data = designFileBase64.split(",").length > 1 ? designFileBase64.split(",")[1] : designFileBase64;

        // Decode the Base64 string to a byte array
        byte[] fileBytes;
        try {
            fileBytes = Base64.getDecoder().decode(base64Data);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid Base64 data: " + e.getMessage());
        }

        // Fetch the user from the database
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }
        User user = userOptional.get();

        // Create a new Design entity
        Design design = new Design();
        design.setColors(colors);
        design.setQuantity(quantity);
        design.setSizes(sizes);
        design.setDesignFile(fileBytes); // Save the file as a byte array
        design.setUser(user); // Associate the design with the user

        // Save the design to the database
        designRepository.save(design);
    }
}