package ecoBikeSystem.controller;

import ecoBikeSystem.service.ITempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temp")
public class TempController {

    private final ITempService tempService;

    @Autowired
    public TempController(ITempService tempService) {
        this.tempService = tempService;
    }
}
