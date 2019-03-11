package adt.stack.parenthesis;

import java.util.Stack;

/**
 * @author Cláudio Campelo
 * Ver comentários na interface LongestValidParenthesisSubstring.
 *
 */
public class LongestValidParenthesisSubstringImpl implements LongestValidParenthesisSubstring {

    /* (non-Javadoc)
     * @see adt.stack.parenthesis.LongestValidParenthesisSubstring#findLongest(java.lang.String)
     */
    public String findLongest(String parenthesis) {
		Stack<String> stack = new Stack<String>();
		int longa = 0;
		String longest = "";
		int contAberto = 0, contFechado = 0;
		String parenthesisInvert = parenthesisMirror(parenthesis);
		
		if (parenthesis == "" || parenthesis == null) {
			return null;
		}
		
		for (int k = 0; k < parenthesis.length() -1; k++) {
			if (parenthesisInvert.charAt(k) == '(') {
				stack.push("(");
			} else if (parenthesisInvert.charAt(k) == ')'){
				stack.push(")");
			} else return null;
		}
		
		for (String string : stack) {
			if (string == ")" && contAberto != 0) {
				contFechado++;
			} else if(string == "(") {
				contAberto++;
			} else if(contAberto == contFechado && (contAberto % contFechado == 0)) {
				if ((contAberto + contFechado) > longa) {
					longa = contAberto + contFechado;
				}
			}
		}
				
		if (longa != 0) {
			for (int j = (parenthesisInvert.length() - longa); j < longa; j++) {
				longest.concat(stack.get(j));
			}
		} else return null;
		
		return longest;
    }
    
    /*
     * Este é um método utilitário que calcula o "espelho" de uma String.
     * Ou seja, é uma espécie de flip horizontal. Veja os exemplos abaixo
     * para entender como o método deve ser comportar.
     * 
     * A implementação deste método não é obrigatória, porém, é fortemente
     * recomendada, visto que pode ser muito útil para a implementação
     * do findLongest.
     * 
     * Neste método, implemente uma solução baseada em PILHA. 
     * 
     * Exemplo 1:
     * input		   = ((()
     * expected_output = ()))
     * 
     * Exemplo 2:
     * input		   = ()()
     * expected_output = ()()
     * 
     * Exemplo 2:
     * input		   = (((((
     * expected_output = )))))
     */
    private String parenthesisMirror(String str){
        
    	Stack<String> stack = new Stack<String>();
    	String mirrorStr = ""; 
    	if (str == "" || str == null) {
			return null;
		}
    	
    	for (int i = 0; i < str.length() -1; i++) {
			if (str.charAt(i) == '(') {
				stack.push(")");
			} else {
				stack.push("(");
			}
		}
    	
    	for (int j = 0; j < str.length() -1; j++) {
			mirrorStr.concat(stack.pop());
		}
    	
		return mirrorStr;

    }

}
