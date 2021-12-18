package monopoly;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/Ferrocarril") // This means URL's start with /demo (after Application path)
public class FerrocarrilController {
	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private FerrocarrilRepository repository;
	@Autowired
	private PropiedadRepository repositoryPropiedad;

	@GetMapping(path = "/All")
	public @ResponseBody Iterable<Ferrocarril> getAllUsers() {
		// This returns a JSON or XML with the users
		return repository.findAll();
	}

	@GetMapping(path = "/FerrocarrilsVeins/{id}")
	public @ResponseBody Iterable<Ferrocarril> getFerrocarrilsVeins(@PathVariable Integer id) {
		Optional<Ferrocarril> ferrocarril = repository.findById(id);

		if (ferrocarril.isPresent()) {
			Ferrocarril f = ferrocarril.get();
			return f.getVecinos();
		}
		return null;
	}
}