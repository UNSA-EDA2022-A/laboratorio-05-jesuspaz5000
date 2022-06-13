package com.example.project;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Exercise2 obj = new Exercise2();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(obj.existenDuplicados(s));
        }
    }
    

    public boolean existenDuplicados(String str) {
        MyStack<Character> stack = new LinkedListStack<>();
        for(int i=0; i<str.length(); i++){
            if(i == 0){
                stack.push(str.charAt(i));
            }
            else{
                if(str.charAt(i) == '('){//condicion para agregar el primer caracter
                    stack.push(str.charAt(i));
                }
                else if(str.charAt(i) == ')' && stack.top() == '('){//condicion para verificar si existe un duplicado
                    return true;
                }
                else{
                    if(str.charAt(i) != ')'){//condicion que verifica si se puede agregar caracteres diferentes de ')'
                        stack.push(str.charAt(i));
                    }
                    else{//en caso exista el caracter ')' se empieza a eliminar los caracteres diferentes de '('
                        while(stack.top() != '('){
                            stack.pop();
                        }
                        stack.pop();//para completar de eliminar una expresion se elimina tambien el '('
                    }
                }
            }
        }

        return false;
    }
}
