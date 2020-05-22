import javax.swing.JFrame;

public class Client
{

    public static void main(String[] args)
    {
        JFrame window = new JFrame();
        window.setTitle("Graph");
        Graph graph = new Graph();
        GraphPanel panel = new GraphPanel(graph);
        window.add(panel);
        GraphClickListener listener = new GraphClickListener(panel, graph);
        panel.addMouseListener(listener);
        panel.addMouseMotionListener(listener);

        window.setSize(800, 600);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
