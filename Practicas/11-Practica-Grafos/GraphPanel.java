import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GraphPanel extends JPanel implements ActionListener
{

    private Graph graph;
    private JButton btnPrint;
    private JButton btnClear;
    private JLabel label;

    public GraphPanel(Graph graph)
    {
        this.graph = graph;

        btnPrint = new JButton("Print Adjacency List");
        btnClear = new JButton("Remove Graph");
        this.add(btnClear);
        this.add(btnPrint);
        btnClear.setBackground(Color.decode("#C0C0C0"));
        btnPrint.setBackground(Color.decode("#C0C0C0"));
        btnPrint.addActionListener(this);
        btnClear.addActionListener(this);
        this.setBackground(Color.decode("#214756"));
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        graph.getEdges().forEach(edge -> edge.draw(g));
        graph.getNodes().forEach(node -> node.draw(g));
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(btnPrint)) {
            Methods.printAdjList(graph.getNodes());
        }

        if (e.getSource().equals(btnClear)) {
            graph.getEdges().clear();
            graph.getNodes().clear();
            repaint();
        }
    }
}
