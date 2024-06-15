package uk.co.sheffieldwebprogrammer.estatesearch.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.co.sheffieldwebprogrammer.estatesearch.userservice.entity.UserLike;
import uk.co.sheffieldwebprogrammer.estatesearch.userservice.entity.UserShortlist;
import uk.co.sheffieldwebprogrammer.estatesearch.userservice.model.Shortlist;
import uk.co.sheffieldwebprogrammer.estatesearch.userservice.repository.UserLikeRepository;
import uk.co.sheffieldwebprogrammer.estatesearch.userservice.repository.UserShortlistRepository;

@RestController
@RequestMapping("/usershortlistservice")
public class UserShortlistController {

    @Autowired
    private UserShortlistRepository userShortlistRepository;

    @GetMapping("/{userid}")
    public void getUser(){

    }

    @PostMapping("/{userid}")
    public void addLike(@PathVariable("userid") String userid, @RequestBody Shortlist shortlist) {
        UserShortlist userShortlist = new UserShortlist();
        userShortlist.setUserId(userid);
        userShortlist.setShortlistProperty(shortlist.getPropertyId());
        userShortlistRepository.save(userShortlist);
    }
}
