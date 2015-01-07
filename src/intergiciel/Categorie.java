package intergiciel;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Categorie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;

	@ManyToMany
	private Set<Article> articles;
	
}
