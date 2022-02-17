/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import DTO.DTO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author German Bartoli
 */
public class PInicio extends javax.swing.JPanel {

    GBDInicio gBDInicio;
    ArrayList<DTO> dTOProducto;

    final String DMY_FORMAT;
    final String YMD_FORMAT;
    private final SimpleDateFormat simpleDateFormat;

    /**
     * Creates new form Inicio
     */
    public PInicio() {
        initComponents();

        DMY_FORMAT = "dd/MM/yyyy";
        YMD_FORMAT = "yyyy/MM/dd";

        simpleDateFormat = new SimpleDateFormat();

        gBDInicio = new GBDInicio();

        CargarTablaDTOProductosStockXVencer();

        CargarTablaDTOProductosStockBajo();
    }

    private void CargarTablaDTOProductosStockXVencer() {
        dTOProducto = gBDInicio.CargarTablaDTOProductosStockXVencer();

        DefaultTableModel dtm;
        dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;//This causes all cells to be not editable
            }
        };

        String[] nombreDeColumnas = {
            "Producto",
            "Marca",
            "Tipo Producto",
            "Cantidad",
            "Fecha Elaboración",
            "Fecha Vencimiento",
            "Vence en 'x' días"
        };
        dtm.setColumnIdentifiers(nombreDeColumnas);

        simpleDateFormat.applyPattern(DMY_FORMAT);

        for (DTO producto : dTOProducto) {
            Object[] row = {producto.getNombreProducto(),
                producto.getMarca(),
                producto.getTipoProducto(),
                producto.getCantidadStock(),
                simpleDateFormat.format(producto.getFechaElaboracion()),
                simpleDateFormat.format(producto.getFechaVencimiento()),
                producto.getDiasParaVencer()
            };
            dtm.addRow(row);
        }
        jTStockXVencer.setModel(dtm);
    }

    private void CargarTablaDTOProductosStockBajo() {
        dTOProducto = gBDInicio.CargarTablaDTOProductosStockBajo();

        DefaultTableModel dtm = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;//This causes all cells to be not editable
            }
        };

        String[] nombreDeColumnas = {
            "Producto",
            "Marca",
            "Tipo Producto",
            "Stock Mínimo",
            "Cantidad"
        };
        dtm.setColumnIdentifiers(nombreDeColumnas);

        simpleDateFormat.applyPattern(DMY_FORMAT);

        for (DTO producto : dTOProducto) {
            Object[] row = {producto.getNombreProducto(),
                producto.getMarca(),
                producto.getTipoProducto(),
                producto.getStockMinimo(),
                producto.getCantidadStock()
            };
            dtm.addRow(row);
        }
        jTStockBajo.setModel(dtm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTStockXVencer = new javax.swing.JTable()
        {
            @Override
            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex){
                Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);

                Object value = getModel().getValueAt(rowIndex,columnIndex);

                componenet.setBackground(Color.BLACK);
                componenet.setForeground(Color.WHITE);

                if(columnIndex == 6){
                    int dia = (Integer) value;
                    if(0 <= dia && dia <= 1)
                    {
                        componenet.setBackground(Color.RED);
                        componenet.setForeground(Color.BLACK);
                    }

                    if(2 <= dia && dia <= 3)
                    {
                        componenet.setBackground(Color.YELLOW);
                        componenet.setForeground(Color.BLACK);
                    }

                    if(4 <= dia)
                    {
                        componenet.setBackground(Color.GREEN);
                        componenet.setForeground(Color.BLACK);
                    }
                }
                return componenet;
            }
        }
        ;
        jScrollPane2 = new javax.swing.JScrollPane();
        jTStockBajo = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        setPreferredSize(new java.awt.Dimension(1280, 695));
        setLayout(null);

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        jTStockXVencer.setBackground(new java.awt.Color(0, 0, 0));
        jTStockXVencer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTStockXVencer.setForeground(new java.awt.Color(255, 255, 255));
        jTStockXVencer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Marca", "Tipo Producto", "Cantidad", "Fecha Elaboración", "Fecha Vencimiento", "Vence en"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTStockXVencer.setToolTipText("Aviso de Vencimiento con Anticipación de 5 Días");
        jTStockXVencer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTStockXVencer.setGridColor(new java.awt.Color(102, 102, 102));
        jTStockXVencer.setNextFocusableComponent(jTStockBajo);
        jTStockXVencer.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTStockXVencer.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTStockXVencer.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTStockXVencer);

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 50, 1260, 280);

        jTStockBajo.setBackground(new java.awt.Color(0, 0, 0));
        jTStockBajo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTStockBajo.setForeground(new java.awt.Color(255, 255, 255));
        jTStockBajo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Marca", "Tipo Producto", "Stock Mínimo", "Cantidad"
            }
        ));
        jTStockBajo.setToolTipText("Aviso de Stock Bajo según Stock Mínimo");
        jTStockBajo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTStockBajo.setGridColor(new java.awt.Color(102, 102, 102));
        jTStockBajo.setNextFocusableComponent(jTStockXVencer);
        jTStockBajo.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTStockBajo.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTStockBajo.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jTStockBajo);

        add(jScrollPane2);
        jScrollPane2.setBounds(10, 370, 1260, 320);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Stock Bajo");
        add(jLabel2);
        jLabel2.setBounds(550, 330, 190, 43);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Stock por Vencer");
        add(jLabel3);
        jLabel3.setBounds(520, 10, 290, 43);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTStockBajo;
    private javax.swing.JTable jTStockXVencer;
    // End of variables declaration//GEN-END:variables

}
