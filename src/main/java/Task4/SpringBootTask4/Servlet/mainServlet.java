package Task4.SpringBootTask4.Servlet;

import Task4.SpringBootTask4.BIN.applicationRepos;
import Task4.SpringBootTask4.model.applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class mainServlet {

    @Autowired
    private applicationRepos applicationRepos;

    @GetMapping(value = "/")
    public String main(Model model) {
        List<applications> sort = applicationRepos.findAllByOrderByHandledDesc();
        model.addAttribute("spisok", sort);
        return "newIncomingApplications";
    }

    @GetMapping(value = "/details/{id}")
    public String details(@PathVariable(name = "id") Long id, Model model) {
        applications app = applicationRepos.findById(id).orElse(null);
        model.addAttribute("applications", app);
        return "detailsRequest";
    }

    @PostMapping(value = "/addApplications")
    public String addApplications(@RequestParam(name = "fullName") String fullName,
                                  @RequestParam(name = "well") String well,
                                  @RequestParam(name = "number") String number,
                                  @RequestParam(name = "comment") String comment) {
        applications applications = new applications();
        applications.setFullName(fullName);
        applications.setWell(well);
        applications.setTelefonNumber(number);
        applications.setOsnovText(comment);
        applications.setHandled(true);
        applicationRepos.save(applications);
        return "redirect:/";
    }

    @GetMapping(value = "/addRequest")
    public String addRequest() {
        return "/addApplication";
    }

    @PostMapping(value = "/editRequest")
    public String editRequest(@RequestParam(name = "id") Long id) {
        applications applications = applicationRepos.findById(id).orElse(null);
        if (applications != null){
            applications.setHandled(false);
            applicationRepos.save(applications);
            return "redirect:/";
        }
        return "redirect:/";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestParam(name = "id") Long id) {
        System.out.println(" dfasdasdkl;asjdflkas " + id);
        applicationRepos.deleteById(id);
        return "redirect:/";
    }
}