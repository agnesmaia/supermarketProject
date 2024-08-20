package services;
import java.util.HashMap;
import java.util.Map;

public class AutenticaçãoService {
    private Map<String, String> administradores = new HashMap<>();
    private Map<String, String> clientes = new HashMap<>();

    public AutenticaçãoService() {
        administradores.put("admin", "senhaAdmin");  // Admin padrão
        clientes.put("cliente", "senhaCliente");  // Cliente padrão
    }

    public boolean autenticarAdministrador(String username, String senha) {
        return administradores.containsKey(username) && administradores.get(username).equals(senha);
    }

    public boolean autenticarCliente(String username, String senha) {
        return clientes.containsKey(username) && clientes.get(username).equals(senha);
    }

    public void registrarCliente(String username, String senha) {
        clientes.put(username, senha);
    }
}
