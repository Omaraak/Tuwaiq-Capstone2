package com.example.capstone2.Repository;

import com.example.capstone2.Model.BloodTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BloodTestRepository extends JpaRepository<BloodTest, Integer> {
    BloodTest findBloodTestById(int id);
    List<BloodTest> findBloodTestByUserID(int userID);
}
