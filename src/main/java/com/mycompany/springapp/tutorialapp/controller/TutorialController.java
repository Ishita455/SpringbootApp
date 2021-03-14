package com.mycompany.springapp.tutorialapp.controller;

import com.mycompany.springapp.tutorialapp.model.TutorialModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class TutorialController {

    public List<TutorialModel> getAllTutorials() {
        return null;
    }
    public TutorialModel getTutorialById(long id){
        return null;
    }
    public void deleteTutorial(long id){

    }
    public void updateTutorial(TutorialModel tm){

    }
    public void createTutorial(TutorialModel tm){

    }
    @GetMapping(value = "/healthcheck")
    public String healthcheck(@RequestParam("id") Long xyzId,@RequestParam("name") String xyzName,@RequestParam("title") String xyzTitle){
        return "healty" +"id id "+xyzId+" Name "+xyzName+"   Title "+xyzTitle;
    }
    @PostMapping(value = "/healthcheck2")
    public ResponseEntity<TutorialModel> healthcheckPost(@RequestBody TutorialModel tutorialModel){
        ResponseEntity<TutorialModel> tm = new ResponseEntity<TutorialModel>(tutorialModel, HttpStatus.CREATED);
        return tm;
    }
    @PutMapping(value = "/healthcheck2/{tutorialId}")
    public ResponseEntity<TutorialModel> healthcheckPost(@RequestBody TutorialModel tutorialModel, @PathVariable Long tutorialId){
        ResponseEntity<TutorialModel> tm = new ResponseEntity<TutorialModel>(tutorialModel, HttpStatus.CREATED);
        return tm;
    }
    @GetMapping(value = "/healthcheck1")
    public String healthcheckSimple(){
        return "healty simple";
    }
    @GetMapping(value = "/healthcheck/{id}")
    public String healthcheckById(@PathVariable("id") long xyzId){
        System.out.println("id id  "+xyzId);
        return "healty + id is "+xyzId;
    }
 }
