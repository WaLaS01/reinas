import java.awt.BorderLayout;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;



public class Reinas extends JFrame {

   
    private static final long serialVersionUID = 1L;
    private int NUM_REINAS;
    private int[] solution;
    private final static  int SIZE = 600;
    public Reinas(int NUM_REINAS) {
        this.NUM_REINAS = NUM_REINAS;
        this.solution = new int[NUM_REINAS];
     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(SIZE,SIZE);
        
        BorderLayout gestorLayout = new BorderLayout();

        setLayout(gestorLayout);

        JButton btn1 = new JButton("B1");
        JButton btn2 = new JButton("B1");
        JButton btn3 = new JButton("B1");
        JButton btn4 = new JButton("B1");


        add(BorderLayout.NORTH,btn1);
        add(BorderLayout.SOUTH,btn2);

        add(BorderLayout.EAST,btn3);
        add(BorderLayout.WEST,btn4);

        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);

        setLocationRelativeTo(this);
        setVisible(true);
        
        
        
    }



    public void getOptions(){

    }

    public void getResult(){

    }

    public void init() {
        for (int i = 0; i < solution.length; i++) {
            solution[i] = -1;
        }
    }

    public void searchSolution() {
        init();
        backtracking(solution, 0);
    }

    public boolean backtracking(int[] solucion, int reina) {
   
        boolean success = false;
        if (reina < NUM_REINAS) { 
            do {
                solucion[reina]++;
      
                boolean valid = isValid(solution, reina);
                String strSol = Arrays.toString(solution);
                System.out.println(strSol + " " + (valid ? "sol parcial" : "")
                        + (valid && (reina == NUM_REINAS - 1) ? "solucion" : ""));
                if (valid) {
              
                    success = backtracking(solucion, reina + 1);
                }
            } while (solution[reina] < (NUM_REINAS - 1) && (!success));
            solucion[reina] = -1;
        } 
        return success;
    }


    public boolean isValid(int[] solution, int reina) {
        boolean ok = true;
        for (int i = 0; i < reina; i++) {
            if (solution[i] == solution[reina] || Math.abs(solution[i] - solution[reina]) == Math.abs(i - reina)) {
                ok = false;
                break;
            }
        }
        return ok;
    }

    public static void main(String[] args) {
        Reinas reina = new Reinas(3);
        reina.searchSolution();
    }

}
