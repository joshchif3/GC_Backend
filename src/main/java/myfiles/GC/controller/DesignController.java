package myfiles.GC.controller;

import myfiles.GC.dto.DesignDTO;
import myfiles.GC.model.Design;
import myfiles.GC.service.DesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/designs")
public class DesignController {

    @Autowired
    private DesignService designService;

    @PostMapping("/upload")
    public ResponseEntity<Design> uploadDesign(@RequestBody DesignDTO designDTO, @RequestHeader("Authorization") String token) {
        // Validate token (you can add token validation logic here)
        if (token == null || !token.startsWith("Bearer ")) {
            throw new RuntimeException("❌ Invalid or missing token.");
        }

        // Log the incoming payload for debugging
        System.out.println("📤 Received payload: " + designDTO);

        // Upload the design
        Design uploadedDesign = designService.uploadDesign(designDTO);

        // Return the saved design with a 200 OK response
        return ResponseEntity.ok(uploadedDesign);
    }
}