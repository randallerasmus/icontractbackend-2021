package icontractbackend.demo.appuser;

/*
* This class list my API endpoints
*
*/

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    // this is visible to everyone
    @GetMapping("/")
    public String home(){
        return ("<h1> Welcome</h1>");
    }

    // this is visible to every user regardless of your role
    @GetMapping("/user")
    public String user(){
        return ("<h1> Welcome User</h1>");
    }

    // this is visible to admin user only
    @GetMapping("/admin")
    public String admin(){
        return ("<h1> Welcome admin</h1>");
    }

}
