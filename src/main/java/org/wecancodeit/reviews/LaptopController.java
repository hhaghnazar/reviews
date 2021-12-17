package org.wecancodeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;

@Controller
public class LaptopController {

    @Resource
    private ReviewRepository laptopRepo;

    @RequestMapping("/")
    public String homePage(){
        return "home.html";
    }

    @RequestMapping("/laptops")
    public String findAllLaptops(Model model) {
        model.addAttribute("laptopsModel", laptopRepo.findAll());
        return "laptopsTemplate";
    }

    @RequestMapping("/laptop/{id}")
    public String findOneLaptop(@PathVariable Long id, Model model) throws LaptopNotFoundException {
        if(laptopRepo.findOne(id) == null){
            throw new LaptopNotFoundException();
            }
        model.addAttribute("laptopModel", laptopRepo.findOne(id));
        return "laptopTemplate";
    }

}
