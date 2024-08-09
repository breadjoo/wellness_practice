package org.example.springapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SportsInfoRepository extends JpaRepository<SportsInfo,Long> {
}
