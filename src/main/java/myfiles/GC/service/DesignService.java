package myfiles.GC.service;

import myfiles.GC.dto.DesignDTO;
import myfiles.GC.model.Design;
import myfiles.GC.model.User;
import myfiles.GC.repository.DesignRepository;
import myfiles.GC.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DesignService {

    @Autowired
    private DesignRepository designRepository;

    @Autowired
    private UserRepository userRepository;

    public Design uploadDesign(DesignDTO designDTO) {
        // Fetch the user from the database
        Optional<User> userOptional = userRepository.findById(designDTO.getUserId());
        if (userOptional.isEmpty()) {
            throw new RuntimeException("❌ User not found with ID: " + designDTO.getUserId());
        }

        User user = userOptional.get();

        // Create and save the design
        Design design = new Design();
        design.setColors(designDTO.getColors());
        design.setQuantity(designDTO.getQuantity());
        design.setSizes(designDTO.getSizes());
        design.setDesignFile(designDTO.getDesignFile());
        design.setUser(user); // Associate the user with the design

        return designRepository.save(design);
    }
}