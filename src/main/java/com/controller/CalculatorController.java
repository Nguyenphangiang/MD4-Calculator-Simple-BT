package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CalculatorController {
    @GetMapping("")
    public String home(){
        return "index";
    }
    @PostMapping("/result")
    public String calculate(@RequestParam Integer firstNumber, @RequestParam Integer secondNumber,@RequestParam String operator , Model model){
        if (secondNumber == 0 && operator.equals("division")){
            model.addAttribute("message","cant division 0");
        } else {
            int result = 0;
            switch (operator){
                case "addition":
                    result= firstNumber + secondNumber;
                    break;
                case "subtraction":
                    result=firstNumber - secondNumber;
                    break;
                case "multiplication":
                    result = firstNumber * secondNumber;
                    break;
                case "division":
                    result = firstNumber / secondNumber;
                    break;
            }
            model.addAttribute("result",result);
            model.addAttribute("message",operator);
        }
        return "index";
    }
}
