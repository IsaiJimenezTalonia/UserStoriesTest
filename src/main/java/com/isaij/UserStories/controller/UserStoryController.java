package com.isaij.UserStories.controller;

import com.isaij.UserStories.model.UserStory;
import com.isaij.UserStories.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserStoryController {

    @Autowired
    UserStoryRepository userStoryRepository;

    @GetMapping("/userstories")
    public ResponseEntity<List<UserStory>> getAllStories() {
        try {
            List<UserStory> stories = new ArrayList<UserStory>();

            userStoryRepository.findAll().forEach(stories::add);


            if (stories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(stories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/userstories/getstate")
    public ResponseEntity<List<UserStory>> getUserStoryByState(@RequestParam(required = false) String state) {
        try {
            List<UserStory> stories = new ArrayList<UserStory>();

            userStoryRepository.findByStateContaining(state).forEach(stories::add);

            if (stories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(stories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/userstories")
    public ResponseEntity<UserStory> createUserStory(@RequestBody UserStory userStory) {
        try {
            UserStory _story = userStoryRepository
                    .save(new UserStory(userStory.getDescription(), userStory.getStartDate(), userStory.getEndDate(), userStory.isFinished(), userStory.getState()));
            return new ResponseEntity<>(_story, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/userstories/{id}")
    public ResponseEntity<UserStory> updateUserStory(@PathVariable("id") long id) {
        Optional<UserStory> userStoryData = userStoryRepository.findById(id);

        if (userStoryData.isPresent()) {
            UserStory _userstory = userStoryData.get();
            _userstory.setFinished(true);
            return new ResponseEntity<>(userStoryRepository.save(_userstory), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/userstories/{id}")
    public ResponseEntity<HttpStatus> deleteUserStory(@PathVariable("id") long id) {
        try {
            userStoryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
