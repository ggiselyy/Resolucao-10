package Function;

import java.util.*;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.*;
import lombok.Data;


public class Function {
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();

    @FunctionName ("criarfuncionario")
    public Funcionario create (
        @HttpTrigger (
            name = "criarfuncionariorest",
            methods = {HttpMethod.POST},
            route = "funcionario",
            authLevel = AuthorizationLevel.ANONYMOUS)
        
        Funcionario f) {
                    
        f.setId(1);
        f.setNome("Gisely");
        f.setIdade(23);
        f.setSalario(8000);

        funcionarios.add(f);

        return f;
    }
    
    @FunctionName ("listarfuncionario")
    public ArrayList<Funcionario> list(
        @HttpTrigger (
            name = "listarfuncionariorest",
            methods = {HttpMethod.GET},
            route = "funcionario", 
            authLevel = AuthorizationLevel.ANONYMOUS
           
         )
        Funcionario f){

        return funcionarios;
        }
    

    @FunctionName ("atualizarfuncionario")
    public Funcionario update (
        @HttpTrigger (
            name = "atualizarfuncionariorest",
            methods = {HttpMethod.PUT},
            route = "funcionario", 
            authLevel = AuthorizationLevel.ANONYMOUS
          
        ) 
        Funcionario f) {
        
        f.setNome(f.getNome() + " - atualizado!");

        return f;
    }

    @FunctionName ("deletarfuncionario")
    public Funcionario delete (
        @HttpTrigger (
            name = "deletarfuncionariorest",
            methods = {HttpMethod.DELETE},
            route = "funcionario", 
            authLevel = AuthorizationLevel.ANONYMOUS
           
        )
        Funcionario f) {
            f.remove(f);    
            
            return f;
        }    
}

@Data
class Funcionario{
    private long id;
    private String nome;
    private int idade;
    private double salario;

    public Funcionario(){}

    public Funcionario(long id, String name, int age, double salario){
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int Idade) {
        this.idade = idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}