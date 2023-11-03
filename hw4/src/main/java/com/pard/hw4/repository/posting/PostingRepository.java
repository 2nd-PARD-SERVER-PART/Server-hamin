package com.pard.hw4.repository.posting;

import com.pard.hw4.entity.posting.PostingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostingRepository extends JpaRepository<PostingEntity, Long> {
}
