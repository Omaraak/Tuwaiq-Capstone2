package com.example.capstone2.Service;

import com.example.capstone2.Api.ApiException;
import com.example.capstone2.Model.BloodTest;
import com.example.capstone2.Repository.BloodTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BloodTestService {
    private final BloodTestRepository bloodTestRepository;

    public List<BloodTest> getAll() {
        return bloodTestRepository.findAll();
    }

    public void add(BloodTest bloodTest) {
        bloodTestRepository.save(bloodTest);
    }

    public void update(int id, BloodTest bloodTest) throws ApiException {
        BloodTest u = bloodTestRepository.findBloodTestById(id);
        if (u == null) {
            throw new ApiException("bloodTest not found");
        }
        u.setName(bloodTest.getName());
        u.setPrice(bloodTest.getPrice());
        u.setUserID(bloodTest.getUserID());
        bloodTestRepository.save(u);
    }

    public void delete(int id) throws ApiException {
        BloodTest u = bloodTestRepository.findBloodTestById(id);
        if (u == null) {
            throw new ApiException("bloodTest not found");
        }
        bloodTestRepository.delete(u);
    }

    public BloodTest findBloodTestById(int id) throws ApiException {
        BloodTest u = bloodTestRepository.findBloodTestById(id);
        if (u == null) {
            throw new ApiException("bloodTest not found");
        }
        return u;
    }
}
