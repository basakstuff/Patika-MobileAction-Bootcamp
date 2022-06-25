package com.basaker.homeworki.controller;


import com.basaker.homeworki.dao.CommentsDao;
import com.basaker.homeworki.entities.Comments;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentsController {

    @Autowired
    private CommentsDao commentsDao;

    public CommentsController(CommentsDao commentsDao) {
        this.commentsDao = commentsDao;
    }

    @PostMapping("/save")
    public ResponseEntity saveComment(@RequestBody Comments comment) {

        comment = commentsDao.save(comment);

        return ResponseEntity.ok(comment);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Comments>> findAllComments() {

        List<Comments> commentsList = commentsDao.findAll();
        return ResponseEntity.ok(commentsList);
    }

    @DeleteMapping("/delete")
    public void deleteComment(@RequestParam Long id) {

        commentsDao.deleteById(id);
    }


    @PatchMapping("/update/{id}")
    public ResponseEntity updateComment(@RequestParam Long id, @RequestBody String text) {

        Comments comment = commentsDao.findById(id).orElseThrow();
        comment.setComment(text);
        comment = commentsDao.save(comment);
        return ResponseEntity.ok(comment);
    }


}