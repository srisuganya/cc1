package com.example.gardening;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GardenService {

    @Autowired
    private GardenRepo gardenRepo;

    public Garden createGarden(@NonNull Garden garden) {
        return gardenRepo.save(garden);
    }

    public List<Garden> getAllGardens() {
        return gardenRepo.findAll();
    }

    public Garden getGardenById(@NonNull Integer id) {
        return gardenRepo.findById(id).orElse(null);
    }

    public boolean updateGarden(int id, Garden garden) {
        if (getGardenById(id) == null) {
            return false;
        }
        try {
            gardenRepo.save(garden);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean deleteGarden(int id) {
        if (getGardenById(id) == null) {
            return false;
        }
        gardenRepo.deleteById(id);
        return true;
    }
}
