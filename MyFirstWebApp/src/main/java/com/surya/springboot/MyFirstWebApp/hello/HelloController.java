package com.surya.springboot.MyFirstWebApp.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class HelloController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello(){
        return "Hello!World.";
    }

    //bad way of serving a html page
    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHtml(){
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<title>Demo Page</title>");
        sb.append("<body>");
        sb.append("Demo page");

        sb.append("</body>");

        sb.append("</html>");
        return sb.toString();
    }

    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp(@RequestParam Map<String, String> params, ModelMap model){
        log.info("Info - Surya Venkatesh Vijjana");
        params.keySet().forEach(key-> model.put(key,params.get(key)));
        return "sayHello";
    }
}
