package hacker.partie.controller;

import hacker.partie.model.SvcSentence;
import hacker.partie.services.SvcSentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jens on 08.07.14.
 */
@Controller
@RequestMapping(value = "/sentence")
public class SentenceController {

    @Autowired
    private SvcSentenceService svcSentenceService;

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public ModelAndView saveSentence() {
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("sentence", new SvcSentence());
        return modelAndView;
    }

}
