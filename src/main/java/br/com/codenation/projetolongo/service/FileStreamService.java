package br.com.codenation.projetolongo.service;

import br.com.codenation.projetolongo.anottantion.MyAnnotation;
import br.com.codenation.projetolongo.entity.Empresa;
import br.com.codenation.projetolongo.entity.Usuario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FileStreamService {

    private List<Usuario> usuarios = new ArrayList<>();
    private List<Empresa> empresas = new ArrayList<>();
    private final static String arquivoUsuario = "/home/gustavo/Documentos/arquivos/usuarios.txt";
    private final static String arquivoEmpresa = "/home/gustavo/Documentos/arquivos/empresa.txt";

    @MyAnnotation(texto = "Method que faaz a leitura do arquivo Usuário")
    public List<Usuario> lerArquivoUsuario() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivoUsuario));
            long numeroLinha = 0;
            String linha;
            while ((linha = br.readLine()) != null) {
                //String linha = br.readLine();

                if (!linha.contains("nome;documento")) {
                    String[] nomeDivido = linha.split(";");

                    String nome = nomeDivido[0];
                    String documento = nomeDivido[1];
                    int idade = Integer.parseInt(nomeDivido[2]);
                    String login = nomeDivido[3];
                    String senha = nomeDivido[4];
                    Long empresa = Long.parseLong(nomeDivido[5]);
                    BigDecimal salario = new BigDecimal(nomeDivido[6]);

                    Empresa empresaObj = empresas.stream().filter(e -> e.getId().equals(empresa)).findFirst().orElse(null);

                    Usuario usuario = new Usuario();
                    usuario.setId(numeroLinha);
                    usuario.setName(nome);
                    usuario.setDocumento(documento);
                    usuario.setIdade(idade);
                    usuario.setLogin(login);
                    usuario.setSenha(getSenhaCriptografada(senha)); //senha criptografada
                    usuario.setIdEmpresa(empresa);
                    usuario.setEmpresa(empresaObj); //em teste
                    usuario.setSalario(salario);

                    usuarios.add(usuario);
                }

                numeroLinha += 1;
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    public List<Empresa> lerArquivoEmpresa() {

        try {
            long numeroLinha = 0;
            BufferedReader br = new BufferedReader(new FileReader(arquivoEmpresa));
            String linha;
            while ((linha = br.readLine()) != null) {

                if (!linha.contains("nome;documento")) {

                    String[] nomeDivido = linha.split(";");

                    String nome = nomeDivido[0];
                    String documento = nomeDivido[1];
                    int vagas = Integer.parseInt(nomeDivido[2]);
                    String site = nomeDivido[3];

                    Empresa empresa = new Empresa();
                    empresa.setId(numeroLinha);
                    empresa.setVagas(vagas);
                    empresa.setName(nome);
                    empresa.setDocumento(documento);
                    empresa.setSite(site);

                    empresas.add(empresa);
                }
                numeroLinha++;
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();

        }

        return empresas;
    }


    public String getSenhaCriptografada(String senha) {
        StringBuilder novaSenha = new StringBuilder();
        char[] caracteres = senha.toCharArray();
        for (char c : caracteres) {
            switch (c) {
                case 'u':
                    novaSenha.append("#0P");
                    break;
                case 's':
                    novaSenha.append("[%0");
                    break;
                case 'e':
                    novaSenha.append("lD7");
                    break;
                case 'r':
                    novaSenha.append("çA=");
                    break;
                default:
                    novaSenha.append(c);
            }
        }
        return novaSenha.toString();
    }
}
