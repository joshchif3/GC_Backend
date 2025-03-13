package myfiles.GC.controller;

import myfiles.GC.dto.DesignRequest;
import myfiles.GC.service.DesignService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/designs")
@CrossOrigin(origins = "https://fgc-wnzg.onrender.com/", allowCredentials = "true") // Allow CORS for this controller
public class DesignController {

    @Autowired
    private DesignService designService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadDesign(@RequestBody DesignRequest designRequest) {
        try {
            // Save the design to the database
            designService.saveDesign(
                    designRequest.getColors(),
                    designRequest.getQuantity(),
                    designRequest.getSizes(),
                    designRequest.getDesignFile(), // Base64-encoded file
                    designRequest.getUserId() // Pass the userId
            );
            return ResponseEntity.ok("Design uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to upload design: " + e.getMessage());
        }
    }
}