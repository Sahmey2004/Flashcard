import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner; 
public class FlashcardApp {
    private ArrayList < Flashcard > flashcards = new ArrayList<>();
    private JFrame frame;
    private JTextArea questionArea;
    private JTextArea answerArea;
    private JTextField questionInput;
    private JTextField answerInput;
    private int currentIndex;
    
    
    public FlashcardApp(){
        frame = new JFrame ( "Flashcard App");
        frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE);
        frame.setSize ( 500,300 );
        questionArea = new JTextArea();
        questionArea.setEditable ( false);
        answerArea = new JTextArea();
        answerArea.setEditable ( false);
        questionInput = new JTextField();
        answerInput = new JTextField ();
        JButton addButton = new JButton ( "Add Flashcard");
        JButton nextButton = new JButton ("Next");
        JButton showAnswerButton = new JButton ("Show Answer");
        
        addButton.addActionListener ( new AddFlashCardListener());
        nextButton.addActionListener ( new NextFlashcardListener());
        showAnswerButton.addActionListener ( new ShowAnswerListener());
        
        JPanel inputPanel = new JPanel ( new GridLayout (4,2));
        inputPanel.add ( new JLabel ( "Question: "));
        inputPanel.add ( questionInput);
        inputPanel.add ( new JLabel ("Answer: "));
        inputPanel.add (answerInput);
        inputPanel.add (addButton);
        inputPanel.add (nextButton);
        inputPanel.add (showAnswerButton);
        
        frame.getContentPane().add(BorderLayout.NORTH , inputPanel);
        frame.getContentPane().add(BorderLayout.CENTER, new JScrollPane ( questionArea));
        frame.getContentPane().add(BorderLayout.SOUTH, new JScrollPane(answerArea));
        
        frame.setVisible(true);
        
    }
    
    private class AddFlashCardListener implements ActionListener{
        public void actionPerformed ( ActionEvent e){
            String question = questionInput.getText();
            String answer = answerInput.getText();
            if ( !question.isEmpty() && !answer.isEmpty()){
                flashcards.add(new Flashcard ( question, answer));
                questionInput.setText("");
                answerInput.setText("");
                JOptionPane.showMessageDialog (frame, "Flashcard added!");
            }
            else {
            JOptionPane.showMessageDialog ( frame, " Please fill in both fields");
        }
            }
        }
    
    
    private class NextFlashcardListener implements ActionListener {
        public void actionPerformed ( ActionEvent e){
            if (!flashcards.isEmpty()){
                Collections.shuffle(flashcards);
                currentIndex = (currentIndex + 1) % flashcards.size();
                questionArea.setText ( flashcards.get(currentIndex).getQuestions());
                answerArea.setText("");
            }
        }
    }
    

    
    private class ShowAnswerListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if (!flashcards.isEmpty()){
                answerArea.setText ( flashcards.get(currentIndex).getAnswers());
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater ( FlashcardApp::new);
    }
}    