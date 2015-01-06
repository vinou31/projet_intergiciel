package intergiciel;


public class membreExisteException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public membreExisteException(){
		System.out.println("un autre membre utilise déjà ces paramètres");
		//rappeler le formulaire
	}

}
