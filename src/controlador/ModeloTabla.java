package controlador;

import modelo.modelo.dao.UsuarioDAO;
import modelo.modelo.dao.UsuarioDAOImp;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ModeloTabla extends AbstractTableModel {
    private UsuarioDAO dao = new UsuarioDAOImp();
    private String[] columnNames = {"id_usuario", "nombre", "dni", "direccion", "telefono", "email", "rol", "contrasenna"};

    private List<String[]> data;

    public List<String[]> getData() {
        return data;
    }

    {
        try {
            data = dao.obtenerTodosLosUsuariosParaLaTabla();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int i, int j) {
        return data.get(i)[j];
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0)
            return false;
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        String[] usuario = data.get(rowIndex);
      /*  System.out.println(Arrays.toString(usuario));
        System.out.println(aValue);*/
        if (columnIndex == 1) {
            usuario[1] = aValue.toString();
            fireTableCellUpdated(rowIndex, columnIndex);
        }
        if (columnIndex == 2) {
            usuario[2] = aValue.toString();
            fireTableCellUpdated(rowIndex, columnIndex);
        }
    }
}
