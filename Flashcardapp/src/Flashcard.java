

public class Flashcard {
    private String questions;
    private String answers;
    
    public Flashcard(String questions, String answers){
    this.questions = questions;
    this.answers = answers;
}

public String getQuestions(){
    return questions;
}

public String getAnswers(){
    return answers;
}

public void setQuestions (String diffQuestions){
    diffQuestions = questions;
}

public void setAnswers ( String diffAnswers) {
    diffAnswers = answers;
}
}


    


