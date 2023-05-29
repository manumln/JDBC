import controlador.Controlador;
import modelo.modelo.dao.UsuarioDAO;
import modelo.modelo.dao.UsuarioDAOImp;
import vista.app1.App1;

public class App {
    public static void main(String[] args) {
        App1 vista = new App1();
        UsuarioDAO modelo = new UsuarioDAOImp();
        Controlador controlador = new Controlador( modelo, vista);
    }
}
