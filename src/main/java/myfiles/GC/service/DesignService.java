package myfiles.GC.service;

import myfiles.GC.dto.DesignDTO;
import myfiles.GC.model.Design;
import myfiles.GC.model.User;
import myfiles.GC.repository.DesignRepository;
import myfiles.GC.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@Service
public class DesignService {

    @Autowired
    private DesignRepository designRepository;

    @Autowired
    private UserRepository userRepository;

    public String saveDesignFile(MultipartFile file) {
        try {
            return Base64.getEncoder().encodeToString(file.getBytes()); // Convert file to Base64
        } catch (IOException e) {
            throw new RuntimeException("❌ Failed to process file", e);
        }
    }

    public Design uploadDesign(DesignDTO designDTO) {
        // Convert Integer userId to Long explicitly
        Optional<User> userOptional = userRepository.findById(designDTO.getUserId());

        if (userOptional.isEmpty()) {
            throw new RuntimeException("❌ User not found with ID: " + designDTO.getUserId());
        }

        User user = userOptional.get();

        Design design = new Design();
        design.setColors(designDTO.getColors());
        design.setQuantity(designDTO.getQuantity());
        design.setSizes(designDTO.getSizes());
        design.setDesignFile(designDTO.getDesignFile());
        design.setUser(user);

        return designRepository.save(design);
    }
}
