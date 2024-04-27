package com.example.gardening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GardenController {

    @Autowired
    private GardenService gardenService;

    @PostMapping("/garden")
    public ResponseEntity<Garden> add(@RequestBody Garden garden) {
        Garden newGarden = gardenService.createGarden(garden);
        if (newGarden != null) {
            return new ResponseEntity<>(newGarden, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/gardens")
    public ResponseEntity<List<Garden>> getAllGardens() {
        List<Garden> gardens = gardenService.getAllGardens();
        if (!gardens.isEmpty()) {
            return new ResponseEntity<>(gardens, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/garden/{gardenId}")
    public ResponseEntity<Garden> updateGarden(@PathVariable int gardenId, @RequestBody Garden garden) {
        boolean updated = gardenService.updateGarden(gardenId, garden);
        if (updated) {
            return new ResponseEntity<>(garden, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/garden/{gardenId}")
    public ResponseEntity<Boolean> deleteGarden(@PathVariable int gardenId) {
        boolean deleted = gardenService.deleteGarden(gardenId);
        if (deleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
}
