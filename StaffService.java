package com.example.demo.service;

import com.example.demo.model.Staff;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StaffService {

    private final Map<Long, Staff> staffMap = new HashMap<>();
    private Long idCounter = 1L;

    public List<Staff> getAllStaff() {
        return new ArrayList<>(staffMap.values());
    }

    public Optional<Staff> getStaffById(Long id) {
        return Optional.ofNullable(staffMap.get(id));
    }

    public Staff createStaff(Staff staff) {
        staff.setId(idCounter++);
        staffMap.put(staff.getId(), staff);
        return staff;
    }

    public Optional<Staff> updateStaff(Long id, Staff updatedStaff) {
        if (staffMap.containsKey(id)) {
            updatedStaff.setId(id);
            staffMap.put(id, updatedStaff);
            return Optional.of(updatedStaff);
        }
        return Optional.empty();
    }

    public boolean deleteStaff(Long id) {
        return staffMap.remove(id) != null;
    }
}