package com.codedifferently.quickpoll.controller;

import com.codedifferently.quickpoll.domain.Poll;
import com.codedifferently.quickpoll.repository.PollRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.inject.Inject;
import java.net.URI;

@RestController
public class PollController {

    @Inject
    private PollRepository pollRepository;


    @RequestMapping(value="/polls", method= RequestMethod.POST)
    public ResponseEntity<?> createPoll(@RequestBody Poll poll) {
        poll = pollRepository.save(poll);

      //set the location header for the newly created resource

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(poll.getPollId()).toUri();
        responseHeaders.setLocation(newPollUri);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @RequestMapping(value ="/polls",method= RequestMethod.GET)
    public ResponseEntity<Iterable<Poll>> getAllPolls(){
        Iterable<Poll> allPolls = pollRepository.findAll();
        for(Poll p : allPolls){
            updatePollResourceWithLinks(p);
        }
        return new ResponseEntity<>(allPolls, HttpStatus.OK);
    }

    private void updatePollResourceWithLinks(Poll p) {

    }

    @RequestMapping(value="/polls/{pollId}", method=RequestMethod.GET)
    public ResponseEntity<?> getPoll(@PathVariable Long pollId){
        Poll p = pollRepository.findOne(pollId);
        updatePollResourceWithLinks(p);
        return new ResponseEntity<> (p, HttpStatus.OK);
    }

    @RequestMapping(value="/polls/{pollId}", method=RequestMethod.PUT)
    public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId){
        //Save the entity
        Poll p = pollRepository.save(poll);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/polls/{pollId}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId){
        pollRepository.delete(pollId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}