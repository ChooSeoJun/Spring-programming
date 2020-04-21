package kr.hs.dgsw.webclass01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    /*@GetMapping("/greeting")
    public String greeting(@RequestParam final String say, @RequestParam final String to){
         return say + " " + to;
    }
    @GetMapping("/greeting1{say}/{to}")
    public String greeting1(@PathVariable final String say, @PathVariable final String to){
         return say + " " + to;
    }
    @PostMapping("/greeting2")
    public String greeting2(@RequestParam final String say, @RequestParam final String to){
        return say + " " + to;
    }*/
    @GetMapping("/calculate")
    public String calculate(@RequestParam final int num1, @RequestParam final int num2,@RequestParam final int operator){
         return Integer.toString(calculateParam(num1,num2,operator));
    }
    @GetMapping("/calculateParse/{num1}/{num2}/{operator}")
    public String calculateParse(@PathVariable final int num1, @PathVariable final int num2,@PathVariable final int operator){
         return Integer.toString(calculateParam(num1,num2,operator));
    }
    public int calculateParam(int num1, int num2, int operator){
        int result = 0;
        if(operator == 0) result = num1 + num2;
        else if(operator == 1) result = num1 -= num2;
        else if(operator == 2) result = num1 *= num2;
        else if(operator == 3) result = num1 /= num2;

        return result;
    }
}
