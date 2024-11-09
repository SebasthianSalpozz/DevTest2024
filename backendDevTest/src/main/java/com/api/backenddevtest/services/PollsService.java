package com.api.backenddevtest.services;

import com.api.backenddevtest.dtos.OptionDto;
import com.api.backenddevtest.dtos.PollsDto;
import com.api.backenddevtest.models.Options;
import com.api.backenddevtest.models.Polls;
import com.api.backenddevtest.repositories.IRepositoryOptions;
import com.api.backenddevtest.repositories.IRepositoryPolls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PollsService {

    @Autowired
    private IRepositoryOptions repositoryOptions;
    @Autowired
    private IRepositoryPolls repositoryPolls;

    public ArrayList<Polls> getAllPolls() {
        return (ArrayList<Polls>) repositoryPolls.findAll();
    }

    public Polls createPoll(PollsDto pollsDto) {
        System.out.println("entrando1");
        Polls polls = new Polls();
        polls.setName(pollsDto.getName());
        List<Options> options = new ArrayList<>();
        //System.out.println("value = "+ pollsDto.getOptionDtos().get(1).getName());
        for (OptionDto optionDto: pollsDto.getOptionDtos()){
            System.out.println("agg");
            Options option = new Options();
            option.setName(optionDto.getName());
            option.setPolls(polls);
            options.add(option);
        }
        polls.setOptions(options);
        return repositoryPolls.save(polls);
    }

    public Polls vote(Long pollId, Long OptionId){
        Optional<Polls> pollsOptional = repositoryPolls.findById(pollId);
        if(!pollsOptional.isPresent()) {
            return null;
        }
        Optional<Options> optionsOptional = repositoryOptions.findById(OptionId);
        if (!optionsOptional.isPresent()) {
            return null;
        }
        Options options = optionsOptional.get();
        options.setVotes(options.getVotes() + 1);
        repositoryOptions.save(options);
        return pollsOptional.get();
    }
}
