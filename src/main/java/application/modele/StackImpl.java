package application.modele;
/*
import java.util.Stack;

public class StackImpl {
  
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
  
  public String infixToPostfix(String s) {
    Stack<Character> st = new Stack<Character>();
    String postfix = "";
    char ch[] = s.toCharArray();
    
    for(char c: ch) {
      if(c != '+' && c != '-' && c != '*' && c != '/' && c != '(' && c != ')') {
        postfix = postfix + c;
      } else if (c == '(') {
        st.push(c);
      } else if (c == ')') {
        while(!st.isEmpty()) {
          char t = st.pop();
          if(t != '(') {
            postfix = postfix + t;
          } else {
            break;
          }
        }
      } else if(c == '+' ||c == '-' ||c == '*' ||c == '/') {
        if(st.isEmpty()) {
          st.push(c);
        } else {
          while(!st.isEmpty()) {
            char t = st.pop();
            if(t == '(') {
              st.push(t);
              break;
            } else if(t == '+' || t == '-' || t == '*' || t == '/') {
              if(getPriority(t) <  getPriority(c)) {
                st.push(t);
                break;
              } else {
                postfix = postfix + t;
              }
            }
          }
          st.push(c);
        }
      }
    }
    while(!st.isEmpty()) {
      postfix = postfix + st.pop();
    }
    return postfix;
  }
  
  public int getPriority(char c) {
    if(c == '+' || c == '-') {
      return 1;
    } else {
      return 2;
    } 
  }
  
}



*/