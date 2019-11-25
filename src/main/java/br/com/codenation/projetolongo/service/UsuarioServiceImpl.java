package br.com.codenation.projetolongo.service;

import br.com.codenation.projetolongo.domain.DAO.UsuarioDAO;
import br.com.codenation.projetolongo.domain.entity.Usuario;
import br.com.codenation.projetolongo.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public Usuario salvar(Usuario usuario) {
        return usuarioDAO.save(usuario);
    }

    @Override
    public void updateUser(Usuario usuario) {
        usuarioDAO.updateNameFromId(usuario.getId(), usuario.getName());
    }

    @Override
    public void deletar(Usuario usuario) {
        usuarioDAO.delete(usuario);
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        usuarioDAO.deleteById(id);
    }

    @Override
    public void updateSalario(Long id, BigDecimal salario) {
        usuarioDAO.updateSalarioFromId(id, salario);
    }

    @Override
    public Usuario findByUserName(String username) {
        return null;
    }





















    /*public Usuario insertUsuario(Usuario usuario) throws MyExceptions {


        validarUsuario(usuario); //gera //exception
        usuarios.add(usuario);
        LOG.info("#### USUÁRIO {} CADASTRADO COM SUCESSO", usuario.getName());
        //inserirUsuarioEmpresa(usuario);

        return usuario;
    }


    public List<Usuario> findUsuariosFromEmpresa(Long idEmpresa) {
        LOG.info("#### USUARIOS FROM EMPRESA");
        Empresa empresa = findEmpresaById(idEmpresa);
        List<Usuario> usuariosEmpresa = null;
        usuariosEmpresa = empresa.getUsuarios();
        usuariosEmpresa.stream().map(Usuario::getName).forEach(System.out::println);

        return usuariosEmpresa;
    }

    public List<Usuario> findUsuariosEmpresas(Usuario usuario) {
        List<Usuario> users = usuarios.stream().filter(user -> user.getEmpresa() == usuario.getEmpresa()
                && user.getName().equals(usuario.getName())
                && user.getDocumento().equals(usuario.getDocumento())
                && user.getIdade() == usuario.getIdade()).collect(Collectors.toList());

        return users;
    }

    public void inserirUsuarioEmpresa(Usuario usuario) throws MyExceptions {
        Empresa empresa = usuario.getEmpresa();

        validarEmpresa(empresa); //gera Exception
        validarVagas(empresa);//gera Exception

        empresa.getUsuarios().add(usuario);
        int index = empresas.indexOf(empresa); //mesma posição na memória que o objeto acima
        empresas.set(index, empresa);


        LOG.info("#### USUÁRIO {} ENTROU NA EMPRESA {}", usuario.getName(), empresa.getName());
    }*/


    /*private void validarUsuario(Usuario usuario) {
        if (isNullOrEmpty(usuario.getName())) {
            throw new MyExceptions("### NOME DEVE SER PREENCHIDO");
        } else if (isNullOrEmpty(usuario.getDocumento())) {
            throw new MyExceptions("### DOCUMENTO DEVE SER PREENCHIDO");
        } else if (isNullOrEmpty(usuario.getLogin())) {
            throw new MyExceptions("### LOGIN DEVE SER PREENCHIDO");
        } else if (isNullOrEmpty(usuario.getSenha())) {
            throw new MyExceptions("### SENHA DEVE SER PREENCHIDA");
        } else if (usuario.getIdade() <= 0) {
            throw new MyExceptions("### IDADE DEVE SER PREENCHIDA");
        }

        boolean existeUsuarioNome = existeNomeUsuario(usuario.getName());
        boolean existeUsuarioLogin = existeLoginUsuario(usuario.getLogin());
        boolean existeUsuarioDocumento = existeDocumentoUsuario(usuario.getDocumento());

        if (existeUsuarioNome) {
            throw new MyExceptions("#### NOME DO USUARIO JÁ CADASTRADO : " + usuario.getName());
        } else if (existeUsuarioLogin) {
            //LOG.error("#### LOGIN DO USUARIO JÁ CADASTRADO : " + usuario.getName());
            throw new MyExceptions("#### LOGIN DO USUARIO JÁ CADASTRADO : " + usuario.getName());

        } else if (existeUsuarioDocumento) {
            //LOG.error("#### DOCUMENTO DO USUARIO JÁ CADASTRADO : " + usuario.getName());
            throw new MyExceptions("#### DOCUMENTO DO USUARIO JÁ CADASTRADO : " + usuario.getName());
        }
    }/*

    /*UTIL E VALIDAÇÕES*/
    /*private boolean existeNomeUsuario(String nome) {
        return usuarios.stream().anyMatch(user -> user.getName().equals(nome));
    }

    private boolean existeLoginUsuario(String login) {
        return usuarios.stream().anyMatch(user -> user.getLogin().equals(login));
    }

    private boolean existeDocumentoUsuario(String documento) {
        return usuarios.stream().anyMatch(user -> user.getDocumento().equals(documento));
    }

    private boolean isNullOrEmpty(String texto) {
        return texto == null || texto.isEmpty();
    }

    */
}
