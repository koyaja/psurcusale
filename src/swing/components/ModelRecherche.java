/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing.components;

import art.creativity.entities.ABSearch;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Geraud
 */
public class ModelRecherche extends AbstractTableModel{
    
    private List<ABSearch> aBFinds = new ArrayList<>();
    private String[] colonne = {"Numéro Ab", "Nom Prénom Ab"};
    private Class[] c  = {String.class, String.class};

    public ModelRecherche() {
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return c[columnIndex]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int column) {
        return colonne[column]; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int getRowCount() {
        return aBFinds.size();
    }

    @Override
    public int getColumnCount() {
        return colonne.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return aBFinds.get(rowIndex).getNumeroAB()+"";
            case 1:
                return aBFinds.get(rowIndex).getNom()+" "+aBFinds.get(rowIndex).getPrenom();
        }
        return "";
    }

    public void setaBFinds(List<ABSearch> aBFinds) {
        this.aBFinds = aBFinds;
        fireTableDataChanged();
    }
    
    public ABSearch getABSearch(int row){
        return aBFinds.get(row);
    }
    
}
