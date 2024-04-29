package com.lgcns.test.state;

import java.util.List;

import com.lgcns.test.State;
import com.lgcns.test.VariableManager;

public class ChoiceState extends State {

	private List<Choice> choices;

	public static class Choice {
		String variable;
		String euqal;
		String next;

		public Choice(String variable, String euqal, String next) {
			super();
			this.variable = variable;
			this.euqal = euqal;
			this.next = next;
		}
	}

	public ChoiceState(String name, String next, List<Choice> choices) {
		super(name, next);
		this.choices = choices;
	}

	@Override
	public String run() throws Exception {
		for (Choice choice : choices) {
			System.out.println(
					"choice: " + choice.variable + ", " + choice.euqal + ", " + VariableManager.get(choice.variable));
			if (VariableManager.get(choice.variable).equals(choice.euqal)) {
				return choice.next;
			}
		}
		return getNext();
	}
}
