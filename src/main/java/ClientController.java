import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ClientController {

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String showCategoryPage() {


        return "category";
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String showCategoryPage2(){
        return "category";
    }
}
