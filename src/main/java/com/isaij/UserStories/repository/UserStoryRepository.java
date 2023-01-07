package com.isaij.UserStories.repository;

import com.isaij.UserStories.model.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserStoryRepository extends JpaRepository<UserStory, Long> {

    List<UserStory> findByStateContaining(String state);
}
