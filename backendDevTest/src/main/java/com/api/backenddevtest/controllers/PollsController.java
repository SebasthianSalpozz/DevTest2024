package com.api.backenddevtest.controllers;

import com.api.backenddevtest.dtos.PollsDto;
import com.api.backenddevtest.models.Polls;
import com.api.backenddevtest.services.PollsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/polls")
public class PollsController {
    @Autowired
    private PollsService pollsService;

    @GetMapping
    public ArrayList<Polls> getAllPolls(){
        return pollsService.getAllPolls();
    }

    @PostMapping
    public Polls createPoll(@RequestBody PollsDto pollsDto) {
        return pollsService.createPoll(pollsDto);
    }

    @PostMapping("/{id}/votes")
    public Polls vote(@PathVariable Long id, @RequestBody Map<String, Long> loadMap){
        Long optionId = loadMap.get("optionId");
        return pollsService.vote(id, optionId);
    }

}
