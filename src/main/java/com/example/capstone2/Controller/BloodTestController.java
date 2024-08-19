package com.example.capstone2.Controller;

import com.example.capstone2.Api.ApiException;
import com.example.capstone2.Model.BloodTest;
import com.example.capstone2.Service.BloodTestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hms/bloodTest")
@RequiredArgsConstructor
public class BloodTestController {
    private final BloodTestService bloodTestService;

    @GetMapping("/getAll")
    public ResponseEntity<List<BloodTest>> getAll() {
        return ResponseEntity.status(200).body(bloodTestService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity add(@Valid @RequestBody BloodTest bloodTest, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        bloodTestService.add(bloodTest);
        return ResponseEntity.status(201).body("BloodTest added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@Valid @RequestBody BloodTest bloodTest, @PathVariable int id, Errors errors) throws ApiException {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        bloodTestService.update(id, bloodTest);
        return ResponseEntity.status(200).body("BloodTest updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id) throws ApiException {
        bloodTestService.delete(id);
        return ResponseEntity.status(200).body("BloodTest deleted");
    }

    @GetMapping("/getBloodTestById/{id}")
    public ResponseEntity<BloodTest> getBloodTestById(@PathVariable int id) throws ApiException {
        return ResponseEntity.status(200).body(bloodTestService.findBloodTestById(id));
    }
}
