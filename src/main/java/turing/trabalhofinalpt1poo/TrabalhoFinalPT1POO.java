package turing.trabalhofinalpt1poo;


import java.util.Scanner;
import java.util.ArrayList;

public class TrabalhoFinalPT1POO 
{
    public static void main(String[] args) 
    {
        int x;
        Scanner entrada = new Scanner(System.in);
        do 
        {
            // Menu
            System.out.println("1. Cadastrar aluno(a)" +
                               "2. Listar alunos" +
                               "3. Excluir aluno(a)" +
                               "4. Cadastrar Professor(a)" +
                               "5. Listar Professores" +
                               "6. Excluir professor(a)");
            
            
            x = entrada.nextInt();
            entrada.nextLine();  // limpa o buffer
 
            switch (x)
            {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
            
            
            
        } while (x != 0);
        
    }
}
