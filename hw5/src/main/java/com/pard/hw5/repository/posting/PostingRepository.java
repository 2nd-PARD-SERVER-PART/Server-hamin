package com.pard.hw5.repository.posting;

import com.pard.hw5.entity.posting.PostingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostingRepository extends JpaRepository<PostingEntity, Long> {
}
