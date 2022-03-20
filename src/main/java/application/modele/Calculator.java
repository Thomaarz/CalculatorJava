package application.modele;

import java.util.Stack;

public class Calculator {
	
	public String infixToPostfix(String s) {
	    Stack<Operator> st = new Stack<Operator>();
	    String postfix = "";
	    char ch[] = s.toCharArray();
	    
	    for(char c: ch) {
	    	if(c >= '0' && c <= '9') {
	            postfix = postfix + c;
   	
	    	}
	    	else if (c == '(') {
	            st.push(new Operator(c));
	          } else if (c == ')') {
	            while(!st.isEmpty()) {
	              Operator t = st.pop();
	              if(t.getSymbol() != '(') {
	                postfix = postfix + t.getSymbol();
	              } else {
	                break;
	              }
	            }
	          }else if(c == '+' ||c == '-' ||c == '*' ||c == '/') {
	    		if(st.isEmpty()) {
	    	          st.push(new Operator(c));
	    	    }else {
	    	          while(!st.isEmpty()) {
	    	              Operator t = st.pop();
	    	              if(t.getSymbol() == '(') {
	    	                st.push(t);
	    	                break;
	    	              } else if(t.getSymbol() == '+' || t.getSymbol() == '-' || t.getSymbol() == '*' || t.getSymbol() == '/') {
	    	                if(t.getPriority() <  new Operator(c).getPriority()) {
	    	                  st.push(t);
	    	                  break;
	    	                } else {
	    	                  postfix = postfix + t.getSymbol();
	    	                }
	    	              }
	    	            }
	    	            st.push(new Operator(c));
	    	          }
	    	}
	      
	  }
	    while(!st.isEmpty()) {
	        postfix = postfix + st.pop().getSymbol();
	      }
	    return postfix;

	  
	}  
	
	public int postfixToEvaluation(String s) {
		  System.out.println("s = "+ s);
	    Stack<Integer> st = new Stack<Integer>();
	    int x = 0, y = 0;
	    char ch[] = s.toCharArray();
	    for(char c: ch) {
	      if(c >= '0' && c <= '9') {
	        st.push((int)(c - '0'));
	      } else {
	    	  
	        y = st.pop();
	        x = st.pop();
	        System.out.println(x);
	        System.out.println(y);
	        System.out.println("--------------------------------");
	        switch(c) {
	          case '+':
	            st.push(x+y);
	            break;
	          case '-':
	            st.push(x-y);
	            break;
	          case '*':
	            st.push(x*y);
	            break;
	          case '/':
	            st.push(x/y);
	            break;
	        }
	      }
	    }
	    return st.pop();
	  }
}
