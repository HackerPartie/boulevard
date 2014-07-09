package hacker.partie.hibtry.controller;

import hacker.partie.hibtry.service.SentenceService;
import hacker.partie.model.SvcSentence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    private SentenceService sentenceService;

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public ModelAndView getSaveSentenceForm() {
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("sentence", new SvcSentence());
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveSentence(@ModelAttribute SvcSentence sentence) {
        ModelAndView modelAndView = new ModelAndView("main");
        sentenceService.saveSent(sentence);
        String message = "Sentence successfully created and saved";
        modelAndView.addObject("message", message);
        modelAndView.addObject("sentence", sentence);
        return modelAndView;
    }

}
