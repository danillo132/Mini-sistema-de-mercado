package cursojava.interfaces;


//Essa interface ser� o contrato de autentica��o

public interface PermitirAcesso {

	  // apenas declara��o do m�todo
	public boolean autenticar(String login, String senha);
	public boolean autenticar();
	
	
}
