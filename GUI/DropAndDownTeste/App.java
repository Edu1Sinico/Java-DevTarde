package DropAndDownTeste;

// import javax.swing.*;
// import java.awt.*;
// import java.awt.dnd.*;
// import java.awt.datatransfer.*;

// public class App {
//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             createAndShowGUI();
//         });
//     }

//     private static void createAndShowGUI() {
//         // Cria a janela principal
//         JFrame frame = new JFrame("Exemplo de Drag'n'Drop");
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setLayout(new FlowLayout());

//         // Cria um painel de origem (Drag Source)
//         JPanel dragSourcePanel = new JPanel();
//         dragSourcePanel.setPreferredSize(new Dimension(100, 100));
//         dragSourcePanel.setBackground(Color.BLUE);
//         frame.add(dragSourcePanel);

//         // Cria um painel de destino (Drop Target)
//         JPanel dropTargetPanel = new JPanel();
//         dropTargetPanel.setPreferredSize(new Dimension(100, 100));
//         dropTargetPanel.setBackground(Color.RED);
//         frame.add(dropTargetPanel);

//         // Define a fonte de arrastar
//         DragSource dragSource = DragSource.getDefaultDragSource();
//         DragGestureRecognizer dgr = dragSource.createDefaultDragGestureRecognizer(
//                 dragSourcePanel,
//                 DnDConstants.ACTION_COPY,
//                 new DragGestureListener() {
//                     public void dragGestureRecognized(DragGestureEvent dge) {
//                         Transferable transferable = new StringSelection("Texto para arrastar");
//                         dge.startDrag(DragSource.DefaultCopyDrop, transferable, new DragSourceAdapter() {});
//                     }
//                 }
//         );

//         // Define o alvo de soltar
//         DropTarget dropTarget = new DropTarget(
//                 dropTargetPanel,
//                 DnDConstants.ACTION_COPY,
//                 new DropTargetAdapter() {
//                     public void drop(DropTargetDropEvent dtde) {
//                         try {
//                             Transferable tr = dtde.getTransferable();
//                             if (tr.isDataFlavorSupported(DataFlavor.stringFlavor)) {
//                                 String data = (String) tr.getTransferData(DataFlavor.stringFlavor);
//                                 JOptionPane.showMessageDialog(frame, "Texto arrastado: " + data);
//                                 dtde.dropComplete(true);
//                             } else {
//                                 dtde.rejectDrop();
//                             }
//                         } catch (Exception e) {
//                             e.printStackTrace();
//                             dtde.rejectDrop();
//                         }
//                     }
//                 }
//         );

//         frame.pack();
//         frame.setVisible(true);
//     }
// }

// import javax.swing.*;
// import java.awt.*;
// import java.awt.dnd.*;
// import java.awt.datatransfer.*;
// import java.util.List;

// public class App {
//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             createAndShowGUI();
//         });
//     }

//     private static void createAndShowGUI() {
//         // Cria a janela principal
//         JFrame frame = new JFrame("Exemplo de Drag'n'Drop");
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setLayout(new FlowLayout());

//         // Cria a lista com elementos de texto
//         DefaultListModel<String> listModel = new DefaultListModel<>();
//         listModel.addElement("Item 1");
//         listModel.addElement("Item 2");
//         listModel.addElement("Item 3");
//         JList<String> list = new JList<>(listModel);
//         list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//         list.setPreferredSize(new Dimension(150, 100));
//         frame.add(list);

//         // Define a fonte de arrastar
//         DragSource dragSource = DragSource.getDefaultDragSource();
//         DragGestureRecognizer dgr = dragSource.createDefaultDragGestureRecognizer(
//                 list,
//                 DnDConstants.ACTION_COPY,
//                 new DragGestureListener() {
//                     public void dragGestureRecognized(DragGestureEvent dge) {
//                         // Obtém o índice do item selecionado na lista
//                         int selectedIndex = list.getSelectedIndex();
//                         if (selectedIndex >= 0) {
//                             String selectedItem = listModel.getElementAt(selectedIndex);
//                             Transferable transferable = new StringSelection(selectedItem);
//                             dge.startDrag(DragSource.DefaultCopyDrop, transferable, new DragSourceAdapter() {});
//                         }
//                     }
//                 }
//         );

//         frame.pack();
//         frame.setVisible(true);
//     }
// }

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.*;
import java.awt.datatransfer.*;
import java.util.List;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        // Cria a janela principal
        JFrame frame = new JFrame("Exemplo de Drag'n'Drop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Cria a primeira lista com elementos de texto
        DefaultListModel<String> listModel1 = new DefaultListModel<>();
        listModel1.addElement("Item 1");
        listModel1.addElement("Item 2");
        JList<String> list1 = new JList<>(listModel1);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list1.setPreferredSize(new Dimension(150, 100));
        frame.add(list1);

        // Cria a segunda lista
        DefaultListModel<String> listModel2 = new DefaultListModel<>();
        JList<String> list2 = new JList<>(listModel2);
        list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list2.setPreferredSize(new Dimension(150, 100));
        frame.add(list2);

        // Define a fonte de arrastar para a primeira lista
        DragSource dragSource1 = DragSource.getDefaultDragSource();
        DragGestureRecognizer dgr1 = dragSource1.createDefaultDragGestureRecognizer(
                list1,
                DnDConstants.ACTION_COPY,
                new DragGestureListener() {
                    public void dragGestureRecognized(DragGestureEvent dge) {
                        int selectedIndex = list1.getSelectedIndex();
                        if (selectedIndex >= 0) {
                            String selectedItem = listModel1.getElementAt(selectedIndex);
                            Transferable transferable = new StringSelection(selectedItem);
                            dge.startDrag(DragSource.DefaultCopyDrop, transferable, new DragSourceAdapter() {});
                        }
                    }
                }
        );

        // Define o alvo de soltar para a segunda lista
        DropTarget dropTarget2 = new DropTarget(
                list2,
                DnDConstants.ACTION_COPY,
                new DropTargetAdapter() {
                    public void drop(DropTargetDropEvent dtde) {
                        try {
                            Transferable tr = dtde.getTransferable();
                            if (tr.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                                String data = (String) tr.getTransferData(DataFlavor.stringFlavor);
                                listModel2.addElement(data); // Adiciona o item à segunda lista
                                dtde.dropComplete(true);
                            } else {
                                dtde.rejectDrop();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            dtde.rejectDrop();
                        }
                    }
                }
        );

        frame.pack();
        frame.setVisible(true);
    }
}
