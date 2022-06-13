package com.example.project;

import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        Exercise1 obj = new Exercise1();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(obj.esBalanceado(s));
        }
    }

    public boolean esBalanceado(String s) {
        MyStack<Character> stack = new LinkedListStack<Character>();

        for(int i=0; i<s.length(); i++){
            if(i==0){
                if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}'){//verifica que no comience con los caracteres de cierre
                    return false;
                }
                else{
                    stack.push(s.charAt(i));//agrega caracteres de apertura
                }
            }
            else{
                if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                    stack.push(s.charAt(i));//agrega caracteres de apertura
                }
                else{
                    if(s.charAt(i) == ')'){//verifica caracter de cierre
                        if(stack.top() == '('){//verifica si el ultimo caracter correspondiente abre
                            stack.pop();//elimina caracter
                        }
                        else{
                            return false;//si caracter es diferente de '(' retorna false
                        }
                    }
                    else if(s.charAt(i) == ']'){//verifica caracter de cierre
                        if(stack.top() == '['){//verifica si el ultimo caracter correspondiente abre
                            stack.pop();//elimina caracter
                        }
                        else{
                            return false;//si caracter es diferente de '[' retorna false
                        }
                    }
                    else if(s.charAt(i) == '}'){//verifica caracter de cierre
                        if(stack.top() == '{'){//verifica si el ultimo caracter correspondiente abre
                            stack.pop();//elimina caracter
                        }
                        else{
                            return false;//si caracter es diferente de '{' retorna false
                        }
                    }
                }
            }
        }

        if(stack.isEmpty()){//si pila esta vacia retorna true
            return true;
        }
        else{//si pila no esta vacia retorna false
            return false;
        }
    }

    
}
