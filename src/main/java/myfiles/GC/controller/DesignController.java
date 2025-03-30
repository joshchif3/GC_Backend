package myfiles.GC.controller;

import myfiles.GC.dto.DesignDTO;
import myfiles.GC.model.Design;
import myfiles.GC.service.DesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequestMapping("/api/designs")
public class DesignController {

    @Autowired
    private DesignService designService;

    @PostMapping("/upload")
    public ResponseEntity<Design> uploadDesign(
            @RequestParam("colors") String colors,
            @RequestParam("quantity") int quantity,
            @RequestParam("sizes") String sizes,
            @RequestParam("designFile") MultipartFile designFile,
            @RequestParam("userId") Long userId, // userId is already Long
            @RequestHeader("Authorization") String token) {

        if (token == null || !token.startsWith("Bearer ")) {
            throw new RuntimeException("❌ Invalid or missing token.");
        }

        // Convert the file to Base64
        String encodedFile = designService.saveDesignFile(designFile);

        // Create DTO and pass it to the service
        DesignDTO designDTO = new DesignDTO();
        designDTO.setColors(colors);
        designDTO.setQuantity(quantity);
        designDTO.setSizes(sizes);
        designDTO.setDesignFile(encodedFile);
        designDTO.setUserId(userId); // No need for conversion

        Design uploadedDesign = designService.uploadDesign(designDTO);

        return ResponseEntity.ok(uploadedDesign);
    }
}

