package com.example.capstone2.Repository;

import com.example.capstone2.Model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
    Staff findStaffById(int id);
}
