package br.com.ifpb.cantinaonline.model;

public class Acesso {
    private String nomeUsuario;
    private String senha;
    private String nome;
    private String funcao;

    public Acesso(String nomeUsuario, String senha, String nome, String funcao) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.nome = nome;
        this.funcao = funcao;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}

