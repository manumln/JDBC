import controlador.Controlador;
import modelo.modelo.dao.UsuarioDAO;
import modelo.modelo.dao.UsuarioDAOImp;

public class App {
    public static void main(String[] args) {
        vista.app5.App vista = new vista.app5.App();
        UsuarioDAO modelo = new UsuarioDAOImp();
        Controlador controlador = new Controlador( modelo, vista);
    }
}
