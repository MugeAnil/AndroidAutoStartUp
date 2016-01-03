package com.example.androidautostartup;

import java.io.Serializable;

public class AnswerQuestion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String question;
	private String answer;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
