package com.articlesproject.core.user.controller;

import com.articlesproject.core.common.base.BaseController;
import com.articlesproject.core.user.model.request.CreateAlbumRequest;
import com.articlesproject.core.user.model.request.CreateArticleAlbumRequest;
import com.articlesproject.core.user.model.request.UpdateAlbumRequest;
import com.articlesproject.core.user.service.UserAlbumService;
import com.articlesproject.core.common.base.ResponseObject;
import com.articlesproject.core.user.service.UserArticleAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/album")
public class UserAlbumResController extends BaseController {

    @Value("${app.UserId}") private String id;

    @Autowired
    private UserAlbumService albumService;

    @Autowired
    private UserArticleAlbumService articleAlbumService;



    @PostMapping("/create")
    private ResponseObject create(@RequestBody CreateAlbumRequest request){
         String userId = id;
        return new ResponseObject(albumService.create(request, userId));
    }

    @PostMapping("/add-article-album")
    private ResponseObject createArticleToAlbum(@RequestBody CreateArticleAlbumRequest request){
        return new ResponseObject(articleAlbumService.create(request));
    }

    @PutMapping("/update")
    private ResponseObject update(@RequestBody UpdateAlbumRequest request){
        return new ResponseObject(albumService.update(request));
    }

    @DeleteMapping
    private ResponseObject deleteArticleInAlbum(@RequestParam("id") String id){
        return new ResponseObject(articleAlbumService.delete(id));
    }

    @GetMapping
    private ResponseObject findAllAlbumByUserId(){
        String userId = id;
        return new ResponseObject(albumService.findAllAlbumByUserId(userId));
    }

    @GetMapping("/{userId}")
    private ResponseObject findAllAlbumPublicByUserId(@PathVariable("userId") String userId){
        return new ResponseObject(albumService.findAllAlbumPublicByUserId(userId));
    }

    @GetMapping("/detail-article-ablum/{id}")
    private ResponseObject detailAlbum(@PathVariable("id") String id){
        return new ResponseObject(albumService.findById(id));
    }

    @DeleteMapping("/delete-article-ablum/{id}")
    private ResponseObject deleteAlbum(@PathVariable("id") String id){
        return new ResponseObject(albumService.delete(id));
    }
}
