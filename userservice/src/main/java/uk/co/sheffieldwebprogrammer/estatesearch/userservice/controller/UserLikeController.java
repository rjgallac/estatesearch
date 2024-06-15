package uk.co.sheffieldwebprogrammer.estatesearch.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.co.sheffieldwebprogrammer.estatesearch.userservice.entity.UserLike;
import uk.co.sheffieldwebprogrammer.estatesearch.userservice.model.Like;
import uk.co.sheffieldwebprogrammer.estatesearch.userservice.repository.UserLikeRepository;
import uk.co.sheffieldwebprogrammer.estatesearch.userservice.repository.UserShortlistRepository;

@RestController
@RequestMapping("/userservice/userlikeservice")
public class UserLikeController {

    @Autowired
    private UserLikeRepository userLikeRepository;

    @GetMapping
    public void getUser(){

    }

    @PostMapping("/{userid}")
    public void addLike(@PathVariable String userid, @RequestBody Like like) {
        UserLike userLike = new UserLike();
        userLike.setUserId(userid);
        userLike.setLikedProperty(like.getPropertyId());
        userLikeRepository.save(userLike);
    }
}
