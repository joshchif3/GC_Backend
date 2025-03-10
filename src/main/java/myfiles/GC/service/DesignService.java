package myfiles.GC.service;

import myfiles.GC.model.Design;
import myfiles.GC.repository.DesignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Service
public class DesignService {

    @Autowired
    private DesignRepository designRepository;

    public Design saveDesign(String colors, int quantity, String sizes, MultipartFile designFile) throws IOException {
        Design design = new Design();
        design.setColors(colors);
        design.setQuantity(quantity);
        design.setSizes(sizes);
        design.setDesignFile(designFile.getBytes()); // Convert file to byte array
        design.setCreatedAt(new Date());

        return designRepository.save(design);
    }
}