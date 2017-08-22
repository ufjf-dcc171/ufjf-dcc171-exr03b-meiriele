package aula03exercicio3b;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JanelaOperacoes extends JFrame {

    private final JLabel etiqueta1;
    private final JLabel etiqueta2;
    private final JLabel etiqueta3;
    private final JLabel etiqueta4;
    private final JTextField texto;
    private final JTextField texto2;
    private final JButton btnSoma = new JButton("Click para efetuar a soma");
    private final JButton btnDivisao = new JButton("Click para efetuar a divisao");
    private final JButton btnSubtracao = new JButton("Click para efetuar a subtração");
    private final JButton btnMulti = new JButton("Click para efetuar a multiplicação.");
    private final JButton btnResultado = new JButton("Click para ver o resultado");
    private double valor1;
    private double valor2;

    public JanelaOperacoes() throws HeadlessException {
        super("Calculadora");
        setLayout(new FlowLayout(FlowLayout.CENTER));

        etiqueta1 = new JLabel("Primeiro valor: ");
        texto = new JTextField(10);
        add(etiqueta1);
        add(texto);

        etiqueta2 = new JLabel("Segundo valor: ");
        texto2 = new JTextField(10);
        add(etiqueta2);
        add(texto2);

        add(btnSoma);
        add(btnSubtracao);
        add(btnDivisao);
        add(btnMulti);
        texto.addActionListener(new Numero1Enter());

        etiqueta3 = new JLabel("Escolha a operação:");

        etiqueta4 = new JLabel("Resultado.");

        btnSoma.addActionListener(new BotaoSoma());
        btnSubtracao.addActionListener(new BotaoSub());
        btnDivisao.addActionListener(new BotaoDiv());
        btnMulti.addActionListener(new BotaoMulti());
    }

    private class Numero1Enter implements ActionListener {

        public Numero1Enter() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            texto2.requestFocus();
        }
    }

    private class BotaoSoma implements ActionListener {

        public BotaoSoma() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            valor1 = Double.parseDouble(texto.getText());
            valor2 = Double.parseDouble(texto2.getText());
            JOptionPane.showMessageDialog(null, String.format("O resultado é: %.3f", (valor1 + valor2)), "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class BotaoSub implements ActionListener {

        public BotaoSub() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            valor1 = Double.parseDouble(texto.getText());
            valor2 = Double.parseDouble(texto2.getText());
            JOptionPane.showMessageDialog(null, String.format("O resultado é: %.3f", (valor1 - valor2)), "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class BotaoDiv implements ActionListener {

        public BotaoDiv() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            valor1 = Double.parseDouble(texto.getText());
            valor2 = Double.parseDouble(texto2.getText());
            if (valor2 == 0) {
                JOptionPane.showMessageDialog(null, "ERRO, não é possível fazer divisão por 0.");
            } else {
                JOptionPane.showMessageDialog(null, String.format("O resultado é: %.3f", (valor1 / valor2)), "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private class BotaoMulti implements ActionListener {

        public BotaoMulti() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            valor1 = Double.parseDouble(texto.getText());
            valor2 = Double.parseDouble(texto2.getText());
            JOptionPane.showMessageDialog(null, String.format("O resultado é: %.3f", (valor1 * valor2)), "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
