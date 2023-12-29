package bankdemo.bankdemosp.controller;

import bankdemo.bankdemosp.DAO.bank;
import bankdemo.bankdemosp.exception.BankException;
import bankdemo.bankdemosp.repository.Bankrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class BankController {

    @Autowired
    Bankrepository brep;

    @PostMapping("/newaccount")
    public bank insertaccount(@RequestBody bank b)
    {

        return brep.save(b);

    }

    @GetMapping("/Listaccount")
    public List<bank> getaccounts()
    {
        return brep.findAll();
    }

    @GetMapping("/singleaccount/{id}")
    public bank singleaccount(@PathVariable Long id)
    {
        return brep.findById(id)
                .orElseThrow(()->new BankException(id));
    }
}
