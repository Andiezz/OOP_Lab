package hust.soict.itep.aims.screen;

import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.media.Media;
import hust.soict.itep.aims.media.Playable;
import hust.soict.itep.aims.store.Store;

import javax.lang.model.type.ArrayType;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    public class MediaStore extends JPanel {
        private Media media;

        public MediaStore(Media media) {

            this.media = media;
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            JLabel title = new JLabel(media.getTitle());
            title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
            title.setAlignmentX(CENTER_ALIGNMENT);

            JLabel cost = new JLabel("" + media.getCost() + " $");
            cost.setAlignmentX((CENTER_ALIGNMENT));

            JPanel container = new JPanel();
            container.setLayout(new FlowLayout(FlowLayout.CENTER));

            JButton btnAddToCart = new JButton("Add to cart");
            container.add(btnAddToCart);
            btnAddToCart.addActionListener(new ButtonATCListener());
            if(media instanceof Playable) {
                JButton btnPlay = new JButton("Play");
                container.add(btnPlay);
                btnPlay.addActionListener(new ButtonPlayListener());
            }

            this.add(Box.createVerticalGlue());
            this.add(title);
            this.add(cost);
            this.add(Box.createVerticalGlue());
            this.add(container);

            this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }

        private class ButtonATCListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                cart.addMedia(media);
            }
        }

        private class ButtonPlayListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(media instanceof Playable) {
                    ((Playable) media).play();

                    JDialog dialog = new JDialog();
                    JPanel mainGui = new JPanel(new BorderLayout());

                    mainGui.setBorder(new EmptyBorder(20, 20, 20, 20));
                    mainGui.add(new JLabel("Playing " + media.getTitle()), BorderLayout.CENTER);

                    JPanel buttonPanel = new JPanel(new FlowLayout());
                    mainGui.add(buttonPanel, BorderLayout.SOUTH);

                    JButton close = new JButton("Done");
                    close.addActionListener(i->dialog.setVisible(false));

                    buttonPanel.add(close);

                    dialog.setContentPane(mainGui);
                    dialog.setTitle("Playing");
                    dialog.pack();
                    dialog.setVisible(true);
                }
            }
        }
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < mediaInStore.toArray().length; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }
}
