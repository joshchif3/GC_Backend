package myfiles.GC.controller;

import myfiles.GC.dto.DesignRequest;
import myfiles.GC.service.DesignService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/designs")
@CrossOrigin(origins = "*", allowCredentials = "true") // Modify CORS if needed
public class DesignController {

    private static final Logger logger = LoggerFactory.getLogger(DesignController.class);

    @Autowired
    private DesignService designService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadDesign(@RequestBody DesignRequest designRequest) {
        try {
            logger.info("Received design upload request: {}", designRequest);

            // Save the design to the database
            designService.saveDesign(
                    designRequest.getColors(),
                    designRequest.getQuantity(),
                    designRequest.getSizes(),
                    designRequest.getDesignFile(), // Base64-encoded file
                    designRequest.getUserId() // Pass the userId
            );

            logger.info("Design uploaded successfully");
            return ResponseEntity.ok("Design uploaded successfully");
        } catch (Exception e) {
            logger.error("Error uploading design: {}", e.getMessage(), e);
            return ResponseEntity.status(500).body("Failed to upload design: " + e.getMessage());
        }
    }
}
