package myfiles.GC.controller;

import myfiles.GC.model.Design;
import myfiles.GC.service.DesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/designs")
@CrossOrigin(origins = {"http://localhost:5173", "https://gc-frontend.onrender.com"})
public class DesignController {

    @Autowired
    private DesignService designService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadDesign(
            @RequestParam("colors") String colors,
            @RequestParam("quantity") int quantity,
            @RequestParam("sizes") String sizes,
            @RequestParam("designFile") MultipartFile designFile) {

        try {
            Design savedDesign = designService.saveDesign(colors, quantity, sizes, designFile);
            return ResponseEntity.ok(savedDesign);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to upload design: " + e.getMessage());
        }
    }
}